package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.s3outposts.S3OutpostsClient
import software.amazon.awssdk.services.s3outposts.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object s3outposts { module =>

  // Free monad over S3OutpostsOp
  type S3OutpostsIO[A] = FF[S3OutpostsOp, A]

  sealed trait S3OutpostsOp[A] {
    def visit[F[_]](visitor: S3OutpostsOp.Visitor[F]): F[A]
  }

  object S3OutpostsOp {
    // Given a S3OutpostsClient we can embed a S3OutpostsIO program in any algebra that understands embedding.
    implicit val S3OutpostsOpEmbeddable: Embeddable[S3OutpostsOp, S3OutpostsClient] = new Embeddable[S3OutpostsOp, S3OutpostsClient] {
      def embed[A](client: S3OutpostsClient, io: S3OutpostsIO[A]): Embedded[A] = Embedded.S3Outposts(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends S3OutpostsOp.Visitor[Kleisli[M, S3OutpostsClient, *]] {
        def createEndpoint(
          request: CreateEndpointRequest
        ): Kleisli[M, S3OutpostsClient, CreateEndpointResponse] =
          primitive(_.createEndpoint(request))

        def deleteEndpoint(
          request: DeleteEndpointRequest
        ): Kleisli[M, S3OutpostsClient, DeleteEndpointResponse] =
          primitive(_.deleteEndpoint(request))

        def listEndpoints(
          request: ListEndpointsRequest
        ): Kleisli[M, S3OutpostsClient, ListEndpointsResponse] =
          primitive(_.listEndpoints(request))

        def primitive[A](
          f: S3OutpostsClient => A
        ): Kleisli[M, S3OutpostsClient, A]
      }
    }

    trait Visitor[F[_]] extends (S3OutpostsOp ~> F) {
      final def apply[A](op: S3OutpostsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createEndpoint(
        request: CreateEndpointRequest
      ): F[CreateEndpointResponse]

      def deleteEndpoint(
        request: DeleteEndpointRequest
      ): F[DeleteEndpointResponse]

      def listEndpoints(
        request: ListEndpointsRequest
      ): F[ListEndpointsResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends S3OutpostsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateEndpointOp(
      request: CreateEndpointRequest
    ) extends S3OutpostsOp[CreateEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEndpointResponse] =
        visitor.createEndpoint(request)
    }

    final case class DeleteEndpointOp(
      request: DeleteEndpointRequest
    ) extends S3OutpostsOp[DeleteEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEndpointResponse] =
        visitor.deleteEndpoint(request)
    }

    final case class ListEndpointsOp(
      request: ListEndpointsRequest
    ) extends S3OutpostsOp[ListEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEndpointsResponse] =
        visitor.listEndpoints(request)
    }
  }

  import S3OutpostsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[S3OutpostsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createEndpoint(
    request: CreateEndpointRequest
  ): S3OutpostsIO[CreateEndpointResponse] =
    FF.liftF(CreateEndpointOp(request))

  def deleteEndpoint(
    request: DeleteEndpointRequest
  ): S3OutpostsIO[DeleteEndpointResponse] =
    FF.liftF(DeleteEndpointOp(request))

  def listEndpoints(
    request: ListEndpointsRequest
  ): S3OutpostsIO[ListEndpointsResponse] =
    FF.liftF(ListEndpointsOp(request))
}
