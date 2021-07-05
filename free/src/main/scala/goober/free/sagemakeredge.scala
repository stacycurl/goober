package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.sagemakeredge.SagemakerEdgeClient
import software.amazon.awssdk.services.sagemakeredge.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object sagemakeredge { module =>

  // Free monad over SagemakerEdgeOp
  type SagemakerEdgeIO[A] = FF[SagemakerEdgeOp, A]

  sealed trait SagemakerEdgeOp[A] {
    def visit[F[_]](visitor: SagemakerEdgeOp.Visitor[F]): F[A]
  }

  object SagemakerEdgeOp {
    // Given a SagemakerEdgeClient we can embed a SagemakerEdgeIO program in any algebra that understands embedding.
    implicit val SagemakerEdgeOpEmbeddable: Embeddable[SagemakerEdgeOp, SagemakerEdgeClient] = new Embeddable[SagemakerEdgeOp, SagemakerEdgeClient] {
      def embed[A](client: SagemakerEdgeClient, io: SagemakerEdgeIO[A]): Embedded[A] = Embedded.SagemakerEdge(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SagemakerEdgeOp.Visitor[Kleisli[M, SagemakerEdgeClient, *]] {
        def getDeviceRegistration(
          request: GetDeviceRegistrationRequest
        ): Kleisli[M, SagemakerEdgeClient, GetDeviceRegistrationResponse] =
          primitive(_.getDeviceRegistration(request))

        def sendHeartbeat(
          request: SendHeartbeatRequest
        ): Kleisli[M, SagemakerEdgeClient, SendHeartbeatResponse] =
          primitive(_.sendHeartbeat(request))

        def primitive[A](
          f: SagemakerEdgeClient => A
        ): Kleisli[M, SagemakerEdgeClient, A]
      }
    }

    trait Visitor[F[_]] extends (SagemakerEdgeOp ~> F) {
      final def apply[A](op: SagemakerEdgeOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def getDeviceRegistration(
        request: GetDeviceRegistrationRequest
      ): F[GetDeviceRegistrationResponse]

      def sendHeartbeat(
        request: SendHeartbeatRequest
      ): F[SendHeartbeatResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SagemakerEdgeOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class GetDeviceRegistrationOp(
      request: GetDeviceRegistrationRequest
    ) extends SagemakerEdgeOp[GetDeviceRegistrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeviceRegistrationResponse] =
        visitor.getDeviceRegistration(request)
    }

    final case class SendHeartbeatOp(
      request: SendHeartbeatRequest
    ) extends SagemakerEdgeOp[SendHeartbeatResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendHeartbeatResponse] =
        visitor.sendHeartbeat(request)
    }
  }

  import SagemakerEdgeOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SagemakerEdgeOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def getDeviceRegistration(
    request: GetDeviceRegistrationRequest
  ): SagemakerEdgeIO[GetDeviceRegistrationResponse] =
    FF.liftF(GetDeviceRegistrationOp(request))

  def sendHeartbeat(
    request: SendHeartbeatRequest
  ): SagemakerEdgeIO[SendHeartbeatResponse] =
    FF.liftF(SendHeartbeatOp(request))
}
