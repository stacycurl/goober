package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.finspace.FinspaceClient
import software.amazon.awssdk.services.finspace.model._


object finspace { module =>

  // Free monad over FinspaceOp
  type FinspaceIO[A] = FF[FinspaceOp, A]

  sealed trait FinspaceOp[A] {
    def visit[F[_]](visitor: FinspaceOp.Visitor[F]): F[A]
  }

  object FinspaceOp {
    // Given a FinspaceClient we can embed a FinspaceIO program in any algebra that understands embedding.
    implicit val FinspaceOpEmbeddable: Embeddable[FinspaceOp, FinspaceClient] = new Embeddable[FinspaceOp, FinspaceClient] {
      def embed[A](client: FinspaceClient, io: FinspaceIO[A]): Embedded[A] = Embedded.Finspace(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends FinspaceOp.Visitor[Kleisli[M, FinspaceClient, *]] {
        def createEnvironment(
          request: CreateEnvironmentRequest
        ): Kleisli[M, FinspaceClient, CreateEnvironmentResponse] =
          primitive(_.createEnvironment(request))

        def deleteEnvironment(
          request: DeleteEnvironmentRequest
        ): Kleisli[M, FinspaceClient, DeleteEnvironmentResponse] =
          primitive(_.deleteEnvironment(request))

        def getEnvironment(
          request: GetEnvironmentRequest
        ): Kleisli[M, FinspaceClient, GetEnvironmentResponse] =
          primitive(_.getEnvironment(request))

        def listEnvironments(
          request: ListEnvironmentsRequest
        ): Kleisli[M, FinspaceClient, ListEnvironmentsResponse] =
          primitive(_.listEnvironments(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, FinspaceClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, FinspaceClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, FinspaceClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateEnvironment(
          request: UpdateEnvironmentRequest
        ): Kleisli[M, FinspaceClient, UpdateEnvironmentResponse] =
          primitive(_.updateEnvironment(request))

        def primitive[A](
          f: FinspaceClient => A
        ): Kleisli[M, FinspaceClient, A]
      }
    }

    trait Visitor[F[_]] extends (FinspaceOp ~> F) {
      final def apply[A](op: FinspaceOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createEnvironment(
        request: CreateEnvironmentRequest
      ): F[CreateEnvironmentResponse]

      def deleteEnvironment(
        request: DeleteEnvironmentRequest
      ): F[DeleteEnvironmentResponse]

      def getEnvironment(
        request: GetEnvironmentRequest
      ): F[GetEnvironmentResponse]

      def listEnvironments(
        request: ListEnvironmentsRequest
      ): F[ListEnvironmentsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateEnvironment(
        request: UpdateEnvironmentRequest
      ): F[UpdateEnvironmentResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends FinspaceOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateEnvironmentOp(
      request: CreateEnvironmentRequest
    ) extends FinspaceOp[CreateEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEnvironmentResponse] =
        visitor.createEnvironment(request)
    }

    final case class DeleteEnvironmentOp(
      request: DeleteEnvironmentRequest
    ) extends FinspaceOp[DeleteEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEnvironmentResponse] =
        visitor.deleteEnvironment(request)
    }

    final case class GetEnvironmentOp(
      request: GetEnvironmentRequest
    ) extends FinspaceOp[GetEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEnvironmentResponse] =
        visitor.getEnvironment(request)
    }

    final case class ListEnvironmentsOp(
      request: ListEnvironmentsRequest
    ) extends FinspaceOp[ListEnvironmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEnvironmentsResponse] =
        visitor.listEnvironments(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends FinspaceOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends FinspaceOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends FinspaceOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateEnvironmentOp(
      request: UpdateEnvironmentRequest
    ) extends FinspaceOp[UpdateEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEnvironmentResponse] =
        visitor.updateEnvironment(request)
    }
  }

  import FinspaceOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[FinspaceOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createEnvironment(
    request: CreateEnvironmentRequest
  ): FinspaceIO[CreateEnvironmentResponse] =
    FF.liftF(CreateEnvironmentOp(request))

  def deleteEnvironment(
    request: DeleteEnvironmentRequest
  ): FinspaceIO[DeleteEnvironmentResponse] =
    FF.liftF(DeleteEnvironmentOp(request))

  def getEnvironment(
    request: GetEnvironmentRequest
  ): FinspaceIO[GetEnvironmentResponse] =
    FF.liftF(GetEnvironmentOp(request))

  def listEnvironments(
    request: ListEnvironmentsRequest
  ): FinspaceIO[ListEnvironmentsResponse] =
    FF.liftF(ListEnvironmentsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): FinspaceIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): FinspaceIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): FinspaceIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateEnvironment(
    request: UpdateEnvironmentRequest
  ): FinspaceIO[UpdateEnvironmentResponse] =
    FF.liftF(UpdateEnvironmentOp(request))
}
