package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.codestarconnections.CodeStarConnectionsClient
import software.amazon.awssdk.services.codestarconnections.model._


object codestarconnections { module =>

  // Free monad over CodeStarConnectionsOp
  type CodeStarConnectionsIO[A] = FF[CodeStarConnectionsOp, A]

  sealed trait CodeStarConnectionsOp[A] {
    def visit[F[_]](visitor: CodeStarConnectionsOp.Visitor[F]): F[A]
  }

  object CodeStarConnectionsOp {
    // Given a CodeStarConnectionsClient we can embed a CodeStarConnectionsIO program in any algebra that understands embedding.
    implicit val CodeStarConnectionsOpEmbeddable: Embeddable[CodeStarConnectionsOp, CodeStarConnectionsClient] = new Embeddable[CodeStarConnectionsOp, CodeStarConnectionsClient] {
      def embed[A](client: CodeStarConnectionsClient, io: CodeStarConnectionsIO[A]): Embedded[A] = Embedded.CodeStarConnections(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CodeStarConnectionsOp.Visitor[Kleisli[M, CodeStarConnectionsClient, *]] {
        def createConnection(
          request: CreateConnectionRequest
        ): Kleisli[M, CodeStarConnectionsClient, CreateConnectionResponse] =
          primitive(_.createConnection(request))

        def createHost(
          request: CreateHostRequest
        ): Kleisli[M, CodeStarConnectionsClient, CreateHostResponse] =
          primitive(_.createHost(request))

        def deleteConnection(
          request: DeleteConnectionRequest
        ): Kleisli[M, CodeStarConnectionsClient, DeleteConnectionResponse] =
          primitive(_.deleteConnection(request))

        def deleteHost(
          request: DeleteHostRequest
        ): Kleisli[M, CodeStarConnectionsClient, DeleteHostResponse] =
          primitive(_.deleteHost(request))

        def getConnection(
          request: GetConnectionRequest
        ): Kleisli[M, CodeStarConnectionsClient, GetConnectionResponse] =
          primitive(_.getConnection(request))

        def getHost(
          request: GetHostRequest
        ): Kleisli[M, CodeStarConnectionsClient, GetHostResponse] =
          primitive(_.getHost(request))

        def listConnections(
          request: ListConnectionsRequest
        ): Kleisli[M, CodeStarConnectionsClient, ListConnectionsResponse] =
          primitive(_.listConnections(request))

        def listHosts(
          request: ListHostsRequest
        ): Kleisli[M, CodeStarConnectionsClient, ListHostsResponse] =
          primitive(_.listHosts(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, CodeStarConnectionsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, CodeStarConnectionsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, CodeStarConnectionsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateHost(
          request: UpdateHostRequest
        ): Kleisli[M, CodeStarConnectionsClient, UpdateHostResponse] =
          primitive(_.updateHost(request))

        def primitive[A](
          f: CodeStarConnectionsClient => A
        ): Kleisli[M, CodeStarConnectionsClient, A]
      }
    }

    trait Visitor[F[_]] extends (CodeStarConnectionsOp ~> F) {
      final def apply[A](op: CodeStarConnectionsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createConnection(
        request: CreateConnectionRequest
      ): F[CreateConnectionResponse]

      def createHost(
        request: CreateHostRequest
      ): F[CreateHostResponse]

      def deleteConnection(
        request: DeleteConnectionRequest
      ): F[DeleteConnectionResponse]

      def deleteHost(
        request: DeleteHostRequest
      ): F[DeleteHostResponse]

      def getConnection(
        request: GetConnectionRequest
      ): F[GetConnectionResponse]

      def getHost(
        request: GetHostRequest
      ): F[GetHostResponse]

      def listConnections(
        request: ListConnectionsRequest
      ): F[ListConnectionsResponse]

      def listHosts(
        request: ListHostsRequest
      ): F[ListHostsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateHost(
        request: UpdateHostRequest
      ): F[UpdateHostResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CodeStarConnectionsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateConnectionOp(
      request: CreateConnectionRequest
    ) extends CodeStarConnectionsOp[CreateConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConnectionResponse] =
        visitor.createConnection(request)
    }

    final case class CreateHostOp(
      request: CreateHostRequest
    ) extends CodeStarConnectionsOp[CreateHostResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateHostResponse] =
        visitor.createHost(request)
    }

    final case class DeleteConnectionOp(
      request: DeleteConnectionRequest
    ) extends CodeStarConnectionsOp[DeleteConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConnectionResponse] =
        visitor.deleteConnection(request)
    }

    final case class DeleteHostOp(
      request: DeleteHostRequest
    ) extends CodeStarConnectionsOp[DeleteHostResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteHostResponse] =
        visitor.deleteHost(request)
    }

    final case class GetConnectionOp(
      request: GetConnectionRequest
    ) extends CodeStarConnectionsOp[GetConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConnectionResponse] =
        visitor.getConnection(request)
    }

    final case class GetHostOp(
      request: GetHostRequest
    ) extends CodeStarConnectionsOp[GetHostResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetHostResponse] =
        visitor.getHost(request)
    }

    final case class ListConnectionsOp(
      request: ListConnectionsRequest
    ) extends CodeStarConnectionsOp[ListConnectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConnectionsResponse] =
        visitor.listConnections(request)
    }

    final case class ListHostsOp(
      request: ListHostsRequest
    ) extends CodeStarConnectionsOp[ListHostsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListHostsResponse] =
        visitor.listHosts(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends CodeStarConnectionsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends CodeStarConnectionsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends CodeStarConnectionsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateHostOp(
      request: UpdateHostRequest
    ) extends CodeStarConnectionsOp[UpdateHostResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateHostResponse] =
        visitor.updateHost(request)
    }
  }

  import CodeStarConnectionsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CodeStarConnectionsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createConnection(
    request: CreateConnectionRequest
  ): CodeStarConnectionsIO[CreateConnectionResponse] =
    FF.liftF(CreateConnectionOp(request))

  def createHost(
    request: CreateHostRequest
  ): CodeStarConnectionsIO[CreateHostResponse] =
    FF.liftF(CreateHostOp(request))

  def deleteConnection(
    request: DeleteConnectionRequest
  ): CodeStarConnectionsIO[DeleteConnectionResponse] =
    FF.liftF(DeleteConnectionOp(request))

  def deleteHost(
    request: DeleteHostRequest
  ): CodeStarConnectionsIO[DeleteHostResponse] =
    FF.liftF(DeleteHostOp(request))

  def getConnection(
    request: GetConnectionRequest
  ): CodeStarConnectionsIO[GetConnectionResponse] =
    FF.liftF(GetConnectionOp(request))

  def getHost(
    request: GetHostRequest
  ): CodeStarConnectionsIO[GetHostResponse] =
    FF.liftF(GetHostOp(request))

  def listConnections(
    request: ListConnectionsRequest
  ): CodeStarConnectionsIO[ListConnectionsResponse] =
    FF.liftF(ListConnectionsOp(request))

  def listHosts(
    request: ListHostsRequest
  ): CodeStarConnectionsIO[ListHostsResponse] =
    FF.liftF(ListHostsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): CodeStarConnectionsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): CodeStarConnectionsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): CodeStarConnectionsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateHost(
    request: UpdateHostRequest
  ): CodeStarConnectionsIO[UpdateHostResponse] =
    FF.liftF(UpdateHostOp(request))
}
