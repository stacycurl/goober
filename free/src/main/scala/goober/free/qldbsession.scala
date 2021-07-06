package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.qldbsession.QldbSessionClient
import software.amazon.awssdk.services.qldbsession.model._


object qldbsession { module =>

  // Free monad over QldbSessionOp
  type QldbSessionIO[A] = FF[QldbSessionOp, A]

  sealed trait QldbSessionOp[A] {
    def visit[F[_]](visitor: QldbSessionOp.Visitor[F]): F[A]
  }

  object QldbSessionOp {
    // Given a QldbSessionClient we can embed a QldbSessionIO program in any algebra that understands embedding.
    implicit val QldbSessionOpEmbeddable: Embeddable[QldbSessionOp, QldbSessionClient] = new Embeddable[QldbSessionOp, QldbSessionClient] {
      def embed[A](client: QldbSessionClient, io: QldbSessionIO[A]): Embedded[A] = Embedded.QldbSession(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends QldbSessionOp.Visitor[Kleisli[M, QldbSessionClient, *]] {
        def sendCommand(
          request: SendCommandRequest
        ): Kleisli[M, QldbSessionClient, SendCommandResponse] =
          primitive(_.sendCommand(request))

        def primitive[A](
          f: QldbSessionClient => A
        ): Kleisli[M, QldbSessionClient, A]
      }
    }

    trait Visitor[F[_]] extends (QldbSessionOp ~> F) {
      final def apply[A](op: QldbSessionOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def sendCommand(
        request: SendCommandRequest
      ): F[SendCommandResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends QldbSessionOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class SendCommandOp(
      request: SendCommandRequest
    ) extends QldbSessionOp[SendCommandResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendCommandResponse] =
        visitor.sendCommand(request)
    }
  }

  import QldbSessionOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[QldbSessionOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def sendCommand(
    request: SendCommandRequest
  ): QldbSessionIO[SendCommandResponse] =
    FF.liftF(SendCommandOp(request))
}
