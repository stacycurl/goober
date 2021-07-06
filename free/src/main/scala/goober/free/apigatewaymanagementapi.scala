package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.apigatewaymanagementapi.ApiGatewayManagementApiClient
import software.amazon.awssdk.services.apigatewaymanagementapi.model._


object apigatewaymanagementapi { module =>

  // Free monad over ApiGatewayManagementApiOp
  type ApiGatewayManagementApiIO[A] = FF[ApiGatewayManagementApiOp, A]

  sealed trait ApiGatewayManagementApiOp[A] {
    def visit[F[_]](visitor: ApiGatewayManagementApiOp.Visitor[F]): F[A]
  }

  object ApiGatewayManagementApiOp {
    // Given a ApiGatewayManagementApiClient we can embed a ApiGatewayManagementApiIO program in any algebra that understands embedding.
    implicit val ApiGatewayManagementApiOpEmbeddable: Embeddable[ApiGatewayManagementApiOp, ApiGatewayManagementApiClient] = new Embeddable[ApiGatewayManagementApiOp, ApiGatewayManagementApiClient] {
      def embed[A](client: ApiGatewayManagementApiClient, io: ApiGatewayManagementApiIO[A]): Embedded[A] = Embedded.ApiGatewayManagementApi(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ApiGatewayManagementApiOp.Visitor[Kleisli[M, ApiGatewayManagementApiClient, *]] {
        def deleteConnection(
          request: DeleteConnectionRequest
        ): Kleisli[M, ApiGatewayManagementApiClient, DeleteConnectionResponse] =
          primitive(_.deleteConnection(request))

        def getConnection(
          request: GetConnectionRequest
        ): Kleisli[M, ApiGatewayManagementApiClient, GetConnectionResponse] =
          primitive(_.getConnection(request))

        def postToConnection(
          request: PostToConnectionRequest
        ): Kleisli[M, ApiGatewayManagementApiClient, PostToConnectionResponse] =
          primitive(_.postToConnection(request))

        def primitive[A](
          f: ApiGatewayManagementApiClient => A
        ): Kleisli[M, ApiGatewayManagementApiClient, A]
      }
    }

    trait Visitor[F[_]] extends (ApiGatewayManagementApiOp ~> F) {
      final def apply[A](op: ApiGatewayManagementApiOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def deleteConnection(
        request: DeleteConnectionRequest
      ): F[DeleteConnectionResponse]

      def getConnection(
        request: GetConnectionRequest
      ): F[GetConnectionResponse]

      def postToConnection(
        request: PostToConnectionRequest
      ): F[PostToConnectionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ApiGatewayManagementApiOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DeleteConnectionOp(
      request: DeleteConnectionRequest
    ) extends ApiGatewayManagementApiOp[DeleteConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConnectionResponse] =
        visitor.deleteConnection(request)
    }

    final case class GetConnectionOp(
      request: GetConnectionRequest
    ) extends ApiGatewayManagementApiOp[GetConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConnectionResponse] =
        visitor.getConnection(request)
    }

    final case class PostToConnectionOp(
      request: PostToConnectionRequest
    ) extends ApiGatewayManagementApiOp[PostToConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PostToConnectionResponse] =
        visitor.postToConnection(request)
    }
  }

  import ApiGatewayManagementApiOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ApiGatewayManagementApiOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def deleteConnection(
    request: DeleteConnectionRequest
  ): ApiGatewayManagementApiIO[DeleteConnectionResponse] =
    FF.liftF(DeleteConnectionOp(request))

  def getConnection(
    request: GetConnectionRequest
  ): ApiGatewayManagementApiIO[GetConnectionResponse] =
    FF.liftF(GetConnectionOp(request))

  def postToConnection(
    request: PostToConnectionRequest
  ): ApiGatewayManagementApiIO[PostToConnectionResponse] =
    FF.liftF(PostToConnectionOp(request))
}
