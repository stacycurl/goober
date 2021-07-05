package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.mobile.MobileClient
import software.amazon.awssdk.services.mobile.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object mobile { module =>

  // Free monad over MobileOp
  type MobileIO[A] = FF[MobileOp, A]

  sealed trait MobileOp[A] {
    def visit[F[_]](visitor: MobileOp.Visitor[F]): F[A]
  }

  object MobileOp {
    // Given a MobileClient we can embed a MobileIO program in any algebra that understands embedding.
    implicit val MobileOpEmbeddable: Embeddable[MobileOp, MobileClient] = new Embeddable[MobileOp, MobileClient] {
      def embed[A](client: MobileClient, io: MobileIO[A]): Embedded[A] = Embedded.Mobile(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MobileOp.Visitor[Kleisli[M, MobileClient, *]] {
        def createProject(
          request: CreateProjectRequest
        ): Kleisli[M, MobileClient, CreateProjectResponse] =
          primitive(_.createProject(request))

        def deleteProject(
          request: DeleteProjectRequest
        ): Kleisli[M, MobileClient, DeleteProjectResponse] =
          primitive(_.deleteProject(request))

        def describeBundle(
          request: DescribeBundleRequest
        ): Kleisli[M, MobileClient, DescribeBundleResponse] =
          primitive(_.describeBundle(request))

        def describeProject(
          request: DescribeProjectRequest
        ): Kleisli[M, MobileClient, DescribeProjectResponse] =
          primitive(_.describeProject(request))

        def exportBundle(
          request: ExportBundleRequest
        ): Kleisli[M, MobileClient, ExportBundleResponse] =
          primitive(_.exportBundle(request))

        def exportProject(
          request: ExportProjectRequest
        ): Kleisli[M, MobileClient, ExportProjectResponse] =
          primitive(_.exportProject(request))

        def listBundles(
          request: ListBundlesRequest
        ): Kleisli[M, MobileClient, ListBundlesResponse] =
          primitive(_.listBundles(request))

        def listProjects(
          request: ListProjectsRequest
        ): Kleisli[M, MobileClient, ListProjectsResponse] =
          primitive(_.listProjects(request))

        def updateProject(
          request: UpdateProjectRequest
        ): Kleisli[M, MobileClient, UpdateProjectResponse] =
          primitive(_.updateProject(request))

        def primitive[A](
          f: MobileClient => A
        ): Kleisli[M, MobileClient, A]
      }
    }

    trait Visitor[F[_]] extends (MobileOp ~> F) {
      final def apply[A](op: MobileOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createProject(
        request: CreateProjectRequest
      ): F[CreateProjectResponse]

      def deleteProject(
        request: DeleteProjectRequest
      ): F[DeleteProjectResponse]

      def describeBundle(
        request: DescribeBundleRequest
      ): F[DescribeBundleResponse]

      def describeProject(
        request: DescribeProjectRequest
      ): F[DescribeProjectResponse]

      def exportBundle(
        request: ExportBundleRequest
      ): F[ExportBundleResponse]

      def exportProject(
        request: ExportProjectRequest
      ): F[ExportProjectResponse]

      def listBundles(
        request: ListBundlesRequest
      ): F[ListBundlesResponse]

      def listProjects(
        request: ListProjectsRequest
      ): F[ListProjectsResponse]

      def updateProject(
        request: UpdateProjectRequest
      ): F[UpdateProjectResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MobileOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateProjectOp(
      request: CreateProjectRequest
    ) extends MobileOp[CreateProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProjectResponse] =
        visitor.createProject(request)
    }

    final case class DeleteProjectOp(
      request: DeleteProjectRequest
    ) extends MobileOp[DeleteProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProjectResponse] =
        visitor.deleteProject(request)
    }

    final case class DescribeBundleOp(
      request: DescribeBundleRequest
    ) extends MobileOp[DescribeBundleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBundleResponse] =
        visitor.describeBundle(request)
    }

    final case class DescribeProjectOp(
      request: DescribeProjectRequest
    ) extends MobileOp[DescribeProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProjectResponse] =
        visitor.describeProject(request)
    }

    final case class ExportBundleOp(
      request: ExportBundleRequest
    ) extends MobileOp[ExportBundleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExportBundleResponse] =
        visitor.exportBundle(request)
    }

    final case class ExportProjectOp(
      request: ExportProjectRequest
    ) extends MobileOp[ExportProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExportProjectResponse] =
        visitor.exportProject(request)
    }

    final case class ListBundlesOp(
      request: ListBundlesRequest
    ) extends MobileOp[ListBundlesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBundlesResponse] =
        visitor.listBundles(request)
    }

    final case class ListProjectsOp(
      request: ListProjectsRequest
    ) extends MobileOp[ListProjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProjectsResponse] =
        visitor.listProjects(request)
    }

    final case class UpdateProjectOp(
      request: UpdateProjectRequest
    ) extends MobileOp[UpdateProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateProjectResponse] =
        visitor.updateProject(request)
    }
  }

  import MobileOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MobileOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createProject(
    request: CreateProjectRequest
  ): MobileIO[CreateProjectResponse] =
    FF.liftF(CreateProjectOp(request))

  def deleteProject(
    request: DeleteProjectRequest
  ): MobileIO[DeleteProjectResponse] =
    FF.liftF(DeleteProjectOp(request))

  def describeBundle(
    request: DescribeBundleRequest
  ): MobileIO[DescribeBundleResponse] =
    FF.liftF(DescribeBundleOp(request))

  def describeProject(
    request: DescribeProjectRequest
  ): MobileIO[DescribeProjectResponse] =
    FF.liftF(DescribeProjectOp(request))

  def exportBundle(
    request: ExportBundleRequest
  ): MobileIO[ExportBundleResponse] =
    FF.liftF(ExportBundleOp(request))

  def exportProject(
    request: ExportProjectRequest
  ): MobileIO[ExportProjectResponse] =
    FF.liftF(ExportProjectOp(request))

  def listBundles(
    request: ListBundlesRequest
  ): MobileIO[ListBundlesResponse] =
    FF.liftF(ListBundlesOp(request))

  def listProjects(
    request: ListProjectsRequest
  ): MobileIO[ListProjectsResponse] =
    FF.liftF(ListProjectsOp(request))

  def updateProject(
    request: UpdateProjectRequest
  ): MobileIO[UpdateProjectResponse] =
    FF.liftF(UpdateProjectOp(request))
}
