import io.circe.{Codec, Decoder, DecodingFailure, Encoder, HCursor, Json, JsonObject}

import scala.annotation.tailrec
import scala.collection.immutable.{::, List, Nil}
import scala.reflect.ClassTag


object syntax {
  def getSome[X, A](f: X => Option[A]): X => A =
    f andThen (_.get)

  implicit class AnySyntax[A](private val self: A) extends AnyVal {
    def indentBy(by: String): String =
      self.toString.getLines.mkString(s"\n$by")
  }

  implicit class StringSyntax(private val self: String) extends AnyVal {
    def getLines: List[String] =
      self.split("\n", -1).toList

    def trimTrailing: String =
      self.replaceAll("\\s+$", "")
  }

  def quote(arg: Any): String = arg match {
    case s: String ⇒ "\"" + s + "\""
    case l: List[_] ⇒ {
      s"""List(
         |    ${l.map(it ⇒ quote(it).indentBy("  ")).mkString(",\n  ")}
         |  )"""
    }
    case None ⇒"None"
    case Some(a) ⇒ {
      s"""Some(
         |    ${quote(a).indentBy("  ")}
         |  )"""
    }
    case m: Map[_, _] ⇒ {
      val sorted =
        m.toList.map(kv ⇒ quote(kv._1) → kv._2).sortBy(_._1)

      s"""Map(
         |  ${sorted.map(kv ⇒ s"${kv._1} -> ${quote(kv._2).indentBy("  ")}").mkString(",\n  ")}
         |)""".stripMargin
    }
    case other ⇒ other.toString
  }

  implicit class QuotingStringContext(private val self: StringContext) extends AnyVal {
    def q(args: Any*): String = {
      def format(arg: Any): String =
        quote(arg).indentBy("  ")

      val interleaved: List[String] = interleave(
        self.parts.toList,
        args.toList.map(format)
      )

      interleaved.mkString("")
    }

    private def interleave[A](lhs: List[A], rhs: List[A]): List[A] = {
      @tailrec
      def recurse(acc: List[A], next: List[A], after: List[A]): List[A] = next match {
        case Nil ⇒ acc.reverse ::: after
        case head :: tail ⇒ recurse(head :: acc, after, tail)
      }

      recurse(Nil, lhs, rhs)
    }
  }

  implicit class CodecSyntax[A](private val self: Codec[A]) extends AnyVal {
    def lossless(implicit A: ClassTag[A]): Codec[A] = {
      Codec.from[A](
        decodeA = Decoder.instance[A](cursor ⇒ {
          for {
            a ← self.tryDecode(cursor).left.map(failure ⇒ failure.copy(message =
              s"""${failure.message}
                 |
                 |  ${cursor.focus.fold("None")(_.spaces2.take(100).indentBy("  "))}""".stripMargin
            ))
            _ ← {
              (cursor.focus, self.apply(a).deepDropNullValues) match {
                case (None, _)             ⇒ Left(DecodingFailure.apply("Nothing at focus", Nil))
                case (Some(before), after) ⇒ diff(A.toString, cursor, before, after)
              }
            }
          } yield a
        }),
        encodeA = Encoder.instance[A](a ⇒ {
          val json = self.apply(a)

          json
        })
      )
    }
  }

  private object obj {
    def unapply(json: Json): Option[JsonObject] = json.asObject
  }

  private def diff(name: String, cursor: HCursor, lhs: Json, rhs: Json): Decoder.Result[Unit] = {
    (lhs, rhs) match {
      case (obj(lhsObj), obj(rhsObj)) ⇒ {
        val missingKeys = lhsObj.keys.toSet -- rhsObj.keys.toSet
        val additionalKeys = rhsObj.keys.toSet -- lhsObj.keys.toSet

        if (missingKeys.isEmpty && additionalKeys.isEmpty) Right(()) else {
          Left(DecodingFailure.apply(
            s"""$name Not lossless
               |
               |  before: ${lhs.spaces2.indentBy("  ")}
               |
               |  after: ${rhs.spaces2.indentBy("  ")}
               |
               |
               |  missingKeys: ${missingKeys.mkString(", ")}
               |
               |  additionalKeys: ${additionalKeys.mkString(", ")}
               |
               |""".stripMargin,
            cursor.history
          ))
        }
      }
      case _ ⇒if (lhs == rhs) Right(()) else Left(DecodingFailure.apply(
        s"""$name Not lossless
           |
           |  before: ${lhs.spaces2.indentBy("  ")}
           |
           |  after: ${rhs.spaces2.indentBy("  ")}
           |
           |""".stripMargin,
        cursor.history
      ))
    }
  }
}
