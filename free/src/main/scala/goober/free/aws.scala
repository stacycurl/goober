package goober

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import goober.free.{Embeddable, Embedded}


object aws { module =>
  sealed trait AWSOp[A] {
    def visit[F[_]](visitor: AWSOp.Visitor[F]): F[A]
  }
  
  object AWSOp {
    trait Visitor[F[_]] extends (AWSOp ~> F) {
      final def apply[A](op: AWSOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]
    }
    
    final case class Embed[A](e: Embedded[A]) extends AWSOp[A] {
      def visit[F[_]](v: Visitor[F]) = v.embed(e)
    }
  }
  
  import AWSOp._
  
  def embed[F[_], J, A](j: J, fa: FF[F, A])(implicit ev: Embeddable[F, J]): FF[AWSOp, A] = FF.liftF(Embed(ev.embed(j, fa)))
}
