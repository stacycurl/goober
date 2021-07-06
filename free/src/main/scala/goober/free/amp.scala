package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.amp.AmpClient
import software.amazon.awssdk.services.amp.model._


object amp { module =>

  // Free monad over AmpOp
  type AmpIO[A] = FF[AmpOp, A]

  sealed trait AmpOp[A] {
    def visit[F[_]](visitor: AmpOp.Visitor[F]): F[A]
  }

  object AmpOp {
    // Given a AmpClient we can embed a AmpIO program in any algebra that understands embedding.
    implicit val AmpOpEmbeddable: Embeddable[AmpOp, AmpClient] = new Embeddable[AmpOp, AmpClient] {
      def embed[A](client: AmpClient, io: AmpIO[A]): Embedded[A] = Embedded.Amp(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends AmpOp.Visitor[Kleisli[M, AmpClient, *]] {
        def createWorkspace(
          request: CreateWorkspaceRequest
        ): Kleisli[M, AmpClient, CreateWorkspaceResponse] =
          primitive(_.createWorkspace(request))

        def deleteWorkspace(
          request: DeleteWorkspaceRequest
        ): Kleisli[M, AmpClient, DeleteWorkspaceResponse] =
          primitive(_.deleteWorkspace(request))

        def describeWorkspace(
          request: DescribeWorkspaceRequest
        ): Kleisli[M, AmpClient, DescribeWorkspaceResponse] =
          primitive(_.describeWorkspace(request))

        def listWorkspaces(
          request: ListWorkspacesRequest
        ): Kleisli[M, AmpClient, ListWorkspacesResponse] =
          primitive(_.listWorkspaces(request))

        def updateWorkspaceAlias(
          request: UpdateWorkspaceAliasRequest
        ): Kleisli[M, AmpClient, UpdateWorkspaceAliasResponse] =
          primitive(_.updateWorkspaceAlias(request))

        def primitive[A](
          f: AmpClient => A
        ): Kleisli[M, AmpClient, A]
      }
    }

    trait Visitor[F[_]] extends (AmpOp ~> F) {
      final def apply[A](op: AmpOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createWorkspace(
        request: CreateWorkspaceRequest
      ): F[CreateWorkspaceResponse]

      def deleteWorkspace(
        request: DeleteWorkspaceRequest
      ): F[DeleteWorkspaceResponse]

      def describeWorkspace(
        request: DescribeWorkspaceRequest
      ): F[DescribeWorkspaceResponse]

      def listWorkspaces(
        request: ListWorkspacesRequest
      ): F[ListWorkspacesResponse]

      def updateWorkspaceAlias(
        request: UpdateWorkspaceAliasRequest
      ): F[UpdateWorkspaceAliasResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends AmpOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateWorkspaceOp(
      request: CreateWorkspaceRequest
    ) extends AmpOp[CreateWorkspaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWorkspaceResponse] =
        visitor.createWorkspace(request)
    }

    final case class DeleteWorkspaceOp(
      request: DeleteWorkspaceRequest
    ) extends AmpOp[DeleteWorkspaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWorkspaceResponse] =
        visitor.deleteWorkspace(request)
    }

    final case class DescribeWorkspaceOp(
      request: DescribeWorkspaceRequest
    ) extends AmpOp[DescribeWorkspaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeWorkspaceResponse] =
        visitor.describeWorkspace(request)
    }

    final case class ListWorkspacesOp(
      request: ListWorkspacesRequest
    ) extends AmpOp[ListWorkspacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWorkspacesResponse] =
        visitor.listWorkspaces(request)
    }

    final case class UpdateWorkspaceAliasOp(
      request: UpdateWorkspaceAliasRequest
    ) extends AmpOp[UpdateWorkspaceAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateWorkspaceAliasResponse] =
        visitor.updateWorkspaceAlias(request)
    }
  }

  import AmpOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[AmpOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createWorkspace(
    request: CreateWorkspaceRequest
  ): AmpIO[CreateWorkspaceResponse] =
    FF.liftF(CreateWorkspaceOp(request))

  def deleteWorkspace(
    request: DeleteWorkspaceRequest
  ): AmpIO[DeleteWorkspaceResponse] =
    FF.liftF(DeleteWorkspaceOp(request))

  def describeWorkspace(
    request: DescribeWorkspaceRequest
  ): AmpIO[DescribeWorkspaceResponse] =
    FF.liftF(DescribeWorkspaceOp(request))

  def listWorkspaces(
    request: ListWorkspacesRequest
  ): AmpIO[ListWorkspacesResponse] =
    FF.liftF(ListWorkspacesOp(request))

  def updateWorkspaceAlias(
    request: UpdateWorkspaceAliasRequest
  ): AmpIO[UpdateWorkspaceAliasResponse] =
    FF.liftF(UpdateWorkspaceAliasOp(request))
}
