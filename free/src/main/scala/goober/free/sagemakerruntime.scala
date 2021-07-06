package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.sagemakerruntime.SageMakerRuntimeClient
import software.amazon.awssdk.services.sagemakerruntime.model._


object sagemakerruntime { module =>

  // Free monad over SageMakerRuntimeOp
  type SageMakerRuntimeIO[A] = FF[SageMakerRuntimeOp, A]

  sealed trait SageMakerRuntimeOp[A] {
    def visit[F[_]](visitor: SageMakerRuntimeOp.Visitor[F]): F[A]
  }

  object SageMakerRuntimeOp {
    // Given a SageMakerRuntimeClient we can embed a SageMakerRuntimeIO program in any algebra that understands embedding.
    implicit val SageMakerRuntimeOpEmbeddable: Embeddable[SageMakerRuntimeOp, SageMakerRuntimeClient] = new Embeddable[SageMakerRuntimeOp, SageMakerRuntimeClient] {
      def embed[A](client: SageMakerRuntimeClient, io: SageMakerRuntimeIO[A]): Embedded[A] = Embedded.SageMakerRuntime(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SageMakerRuntimeOp.Visitor[Kleisli[M, SageMakerRuntimeClient, *]] {
        def invokeEndpoint(
          request: InvokeEndpointRequest
        ): Kleisli[M, SageMakerRuntimeClient, InvokeEndpointResponse] =
          primitive(_.invokeEndpoint(request))

        def primitive[A](
          f: SageMakerRuntimeClient => A
        ): Kleisli[M, SageMakerRuntimeClient, A]
      }
    }

    trait Visitor[F[_]] extends (SageMakerRuntimeOp ~> F) {
      final def apply[A](op: SageMakerRuntimeOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def invokeEndpoint(
        request: InvokeEndpointRequest
      ): F[InvokeEndpointResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SageMakerRuntimeOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class InvokeEndpointOp(
      request: InvokeEndpointRequest
    ) extends SageMakerRuntimeOp[InvokeEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InvokeEndpointResponse] =
        visitor.invokeEndpoint(request)
    }
  }

  import SageMakerRuntimeOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SageMakerRuntimeOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def invokeEndpoint(
    request: InvokeEndpointRequest
  ): SageMakerRuntimeIO[InvokeEndpointResponse] =
    FF.liftF(InvokeEndpointOp(request))
}
