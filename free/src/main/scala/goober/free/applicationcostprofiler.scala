package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.applicationcostprofiler.ApplicationCostProfilerClient
import software.amazon.awssdk.services.applicationcostprofiler.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object applicationcostprofiler { module =>

  // Free monad over ApplicationCostProfilerOp
  type ApplicationCostProfilerIO[A] = FF[ApplicationCostProfilerOp, A]

  sealed trait ApplicationCostProfilerOp[A] {
    def visit[F[_]](visitor: ApplicationCostProfilerOp.Visitor[F]): F[A]
  }

  object ApplicationCostProfilerOp {
    // Given a ApplicationCostProfilerClient we can embed a ApplicationCostProfilerIO program in any algebra that understands embedding.
    implicit val ApplicationCostProfilerOpEmbeddable: Embeddable[ApplicationCostProfilerOp, ApplicationCostProfilerClient] = new Embeddable[ApplicationCostProfilerOp, ApplicationCostProfilerClient] {
      def embed[A](client: ApplicationCostProfilerClient, io: ApplicationCostProfilerIO[A]): Embedded[A] = Embedded.ApplicationCostProfiler(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ApplicationCostProfilerOp.Visitor[Kleisli[M, ApplicationCostProfilerClient, *]] {
        def deleteReportDefinition(
          request: DeleteReportDefinitionRequest
        ): Kleisli[M, ApplicationCostProfilerClient, DeleteReportDefinitionResponse] =
          primitive(_.deleteReportDefinition(request))

        def getReportDefinition(
          request: GetReportDefinitionRequest
        ): Kleisli[M, ApplicationCostProfilerClient, GetReportDefinitionResponse] =
          primitive(_.getReportDefinition(request))

        def importApplicationUsage(
          request: ImportApplicationUsageRequest
        ): Kleisli[M, ApplicationCostProfilerClient, ImportApplicationUsageResponse] =
          primitive(_.importApplicationUsage(request))

        def listReportDefinitions(
          request: ListReportDefinitionsRequest
        ): Kleisli[M, ApplicationCostProfilerClient, ListReportDefinitionsResponse] =
          primitive(_.listReportDefinitions(request))

        def putReportDefinition(
          request: PutReportDefinitionRequest
        ): Kleisli[M, ApplicationCostProfilerClient, PutReportDefinitionResponse] =
          primitive(_.putReportDefinition(request))

        def updateReportDefinition(
          request: UpdateReportDefinitionRequest
        ): Kleisli[M, ApplicationCostProfilerClient, UpdateReportDefinitionResponse] =
          primitive(_.updateReportDefinition(request))

        def primitive[A](
          f: ApplicationCostProfilerClient => A
        ): Kleisli[M, ApplicationCostProfilerClient, A]
      }
    }

    trait Visitor[F[_]] extends (ApplicationCostProfilerOp ~> F) {
      final def apply[A](op: ApplicationCostProfilerOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def deleteReportDefinition(
        request: DeleteReportDefinitionRequest
      ): F[DeleteReportDefinitionResponse]

      def getReportDefinition(
        request: GetReportDefinitionRequest
      ): F[GetReportDefinitionResponse]

      def importApplicationUsage(
        request: ImportApplicationUsageRequest
      ): F[ImportApplicationUsageResponse]

      def listReportDefinitions(
        request: ListReportDefinitionsRequest
      ): F[ListReportDefinitionsResponse]

      def putReportDefinition(
        request: PutReportDefinitionRequest
      ): F[PutReportDefinitionResponse]

      def updateReportDefinition(
        request: UpdateReportDefinitionRequest
      ): F[UpdateReportDefinitionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ApplicationCostProfilerOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DeleteReportDefinitionOp(
      request: DeleteReportDefinitionRequest
    ) extends ApplicationCostProfilerOp[DeleteReportDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteReportDefinitionResponse] =
        visitor.deleteReportDefinition(request)
    }

    final case class GetReportDefinitionOp(
      request: GetReportDefinitionRequest
    ) extends ApplicationCostProfilerOp[GetReportDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetReportDefinitionResponse] =
        visitor.getReportDefinition(request)
    }

    final case class ImportApplicationUsageOp(
      request: ImportApplicationUsageRequest
    ) extends ApplicationCostProfilerOp[ImportApplicationUsageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportApplicationUsageResponse] =
        visitor.importApplicationUsage(request)
    }

    final case class ListReportDefinitionsOp(
      request: ListReportDefinitionsRequest
    ) extends ApplicationCostProfilerOp[ListReportDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListReportDefinitionsResponse] =
        visitor.listReportDefinitions(request)
    }

    final case class PutReportDefinitionOp(
      request: PutReportDefinitionRequest
    ) extends ApplicationCostProfilerOp[PutReportDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutReportDefinitionResponse] =
        visitor.putReportDefinition(request)
    }

    final case class UpdateReportDefinitionOp(
      request: UpdateReportDefinitionRequest
    ) extends ApplicationCostProfilerOp[UpdateReportDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateReportDefinitionResponse] =
        visitor.updateReportDefinition(request)
    }
  }

  import ApplicationCostProfilerOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ApplicationCostProfilerOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def deleteReportDefinition(
    request: DeleteReportDefinitionRequest
  ): ApplicationCostProfilerIO[DeleteReportDefinitionResponse] =
    FF.liftF(DeleteReportDefinitionOp(request))

  def getReportDefinition(
    request: GetReportDefinitionRequest
  ): ApplicationCostProfilerIO[GetReportDefinitionResponse] =
    FF.liftF(GetReportDefinitionOp(request))

  def importApplicationUsage(
    request: ImportApplicationUsageRequest
  ): ApplicationCostProfilerIO[ImportApplicationUsageResponse] =
    FF.liftF(ImportApplicationUsageOp(request))

  def listReportDefinitions(
    request: ListReportDefinitionsRequest
  ): ApplicationCostProfilerIO[ListReportDefinitionsResponse] =
    FF.liftF(ListReportDefinitionsOp(request))

  def putReportDefinition(
    request: PutReportDefinitionRequest
  ): ApplicationCostProfilerIO[PutReportDefinitionResponse] =
    FF.liftF(PutReportDefinitionOp(request))

  def updateReportDefinition(
    request: UpdateReportDefinitionRequest
  ): ApplicationCostProfilerIO[UpdateReportDefinitionResponse] =
    FF.liftF(UpdateReportDefinitionOp(request))
}
