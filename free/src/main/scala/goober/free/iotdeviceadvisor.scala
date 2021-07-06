package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.iotdeviceadvisor.IotDeviceAdvisorClient
import software.amazon.awssdk.services.iotdeviceadvisor.model._


object iotdeviceadvisor { module =>

  // Free monad over IotDeviceAdvisorOp
  type IotDeviceAdvisorIO[A] = FF[IotDeviceAdvisorOp, A]

  sealed trait IotDeviceAdvisorOp[A] {
    def visit[F[_]](visitor: IotDeviceAdvisorOp.Visitor[F]): F[A]
  }

  object IotDeviceAdvisorOp {
    // Given a IotDeviceAdvisorClient we can embed a IotDeviceAdvisorIO program in any algebra that understands embedding.
    implicit val IotDeviceAdvisorOpEmbeddable: Embeddable[IotDeviceAdvisorOp, IotDeviceAdvisorClient] = new Embeddable[IotDeviceAdvisorOp, IotDeviceAdvisorClient] {
      def embed[A](client: IotDeviceAdvisorClient, io: IotDeviceAdvisorIO[A]): Embedded[A] = Embedded.IotDeviceAdvisor(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends IotDeviceAdvisorOp.Visitor[Kleisli[M, IotDeviceAdvisorClient, *]] {
        def createSuiteDefinition(
          request: CreateSuiteDefinitionRequest
        ): Kleisli[M, IotDeviceAdvisorClient, CreateSuiteDefinitionResponse] =
          primitive(_.createSuiteDefinition(request))

        def deleteSuiteDefinition(
          request: DeleteSuiteDefinitionRequest
        ): Kleisli[M, IotDeviceAdvisorClient, DeleteSuiteDefinitionResponse] =
          primitive(_.deleteSuiteDefinition(request))

        def getSuiteDefinition(
          request: GetSuiteDefinitionRequest
        ): Kleisli[M, IotDeviceAdvisorClient, GetSuiteDefinitionResponse] =
          primitive(_.getSuiteDefinition(request))

        def getSuiteRun(
          request: GetSuiteRunRequest
        ): Kleisli[M, IotDeviceAdvisorClient, GetSuiteRunResponse] =
          primitive(_.getSuiteRun(request))

        def getSuiteRunReport(
          request: GetSuiteRunReportRequest
        ): Kleisli[M, IotDeviceAdvisorClient, GetSuiteRunReportResponse] =
          primitive(_.getSuiteRunReport(request))

        def listSuiteDefinitions(
          request: ListSuiteDefinitionsRequest
        ): Kleisli[M, IotDeviceAdvisorClient, ListSuiteDefinitionsResponse] =
          primitive(_.listSuiteDefinitions(request))

        def listSuiteRuns(
          request: ListSuiteRunsRequest
        ): Kleisli[M, IotDeviceAdvisorClient, ListSuiteRunsResponse] =
          primitive(_.listSuiteRuns(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, IotDeviceAdvisorClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def startSuiteRun(
          request: StartSuiteRunRequest
        ): Kleisli[M, IotDeviceAdvisorClient, StartSuiteRunResponse] =
          primitive(_.startSuiteRun(request))

        def stopSuiteRun(
          request: StopSuiteRunRequest
        ): Kleisli[M, IotDeviceAdvisorClient, StopSuiteRunResponse] =
          primitive(_.stopSuiteRun(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, IotDeviceAdvisorClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, IotDeviceAdvisorClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateSuiteDefinition(
          request: UpdateSuiteDefinitionRequest
        ): Kleisli[M, IotDeviceAdvisorClient, UpdateSuiteDefinitionResponse] =
          primitive(_.updateSuiteDefinition(request))

        def primitive[A](
          f: IotDeviceAdvisorClient => A
        ): Kleisli[M, IotDeviceAdvisorClient, A]
      }
    }

    trait Visitor[F[_]] extends (IotDeviceAdvisorOp ~> F) {
      final def apply[A](op: IotDeviceAdvisorOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createSuiteDefinition(
        request: CreateSuiteDefinitionRequest
      ): F[CreateSuiteDefinitionResponse]

      def deleteSuiteDefinition(
        request: DeleteSuiteDefinitionRequest
      ): F[DeleteSuiteDefinitionResponse]

      def getSuiteDefinition(
        request: GetSuiteDefinitionRequest
      ): F[GetSuiteDefinitionResponse]

      def getSuiteRun(
        request: GetSuiteRunRequest
      ): F[GetSuiteRunResponse]

      def getSuiteRunReport(
        request: GetSuiteRunReportRequest
      ): F[GetSuiteRunReportResponse]

      def listSuiteDefinitions(
        request: ListSuiteDefinitionsRequest
      ): F[ListSuiteDefinitionsResponse]

      def listSuiteRuns(
        request: ListSuiteRunsRequest
      ): F[ListSuiteRunsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def startSuiteRun(
        request: StartSuiteRunRequest
      ): F[StartSuiteRunResponse]

      def stopSuiteRun(
        request: StopSuiteRunRequest
      ): F[StopSuiteRunResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateSuiteDefinition(
        request: UpdateSuiteDefinitionRequest
      ): F[UpdateSuiteDefinitionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends IotDeviceAdvisorOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateSuiteDefinitionOp(
      request: CreateSuiteDefinitionRequest
    ) extends IotDeviceAdvisorOp[CreateSuiteDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSuiteDefinitionResponse] =
        visitor.createSuiteDefinition(request)
    }

    final case class DeleteSuiteDefinitionOp(
      request: DeleteSuiteDefinitionRequest
    ) extends IotDeviceAdvisorOp[DeleteSuiteDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSuiteDefinitionResponse] =
        visitor.deleteSuiteDefinition(request)
    }

    final case class GetSuiteDefinitionOp(
      request: GetSuiteDefinitionRequest
    ) extends IotDeviceAdvisorOp[GetSuiteDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSuiteDefinitionResponse] =
        visitor.getSuiteDefinition(request)
    }

    final case class GetSuiteRunOp(
      request: GetSuiteRunRequest
    ) extends IotDeviceAdvisorOp[GetSuiteRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSuiteRunResponse] =
        visitor.getSuiteRun(request)
    }

    final case class GetSuiteRunReportOp(
      request: GetSuiteRunReportRequest
    ) extends IotDeviceAdvisorOp[GetSuiteRunReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSuiteRunReportResponse] =
        visitor.getSuiteRunReport(request)
    }

    final case class ListSuiteDefinitionsOp(
      request: ListSuiteDefinitionsRequest
    ) extends IotDeviceAdvisorOp[ListSuiteDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSuiteDefinitionsResponse] =
        visitor.listSuiteDefinitions(request)
    }

    final case class ListSuiteRunsOp(
      request: ListSuiteRunsRequest
    ) extends IotDeviceAdvisorOp[ListSuiteRunsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSuiteRunsResponse] =
        visitor.listSuiteRuns(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends IotDeviceAdvisorOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class StartSuiteRunOp(
      request: StartSuiteRunRequest
    ) extends IotDeviceAdvisorOp[StartSuiteRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartSuiteRunResponse] =
        visitor.startSuiteRun(request)
    }

    final case class StopSuiteRunOp(
      request: StopSuiteRunRequest
    ) extends IotDeviceAdvisorOp[StopSuiteRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopSuiteRunResponse] =
        visitor.stopSuiteRun(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends IotDeviceAdvisorOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends IotDeviceAdvisorOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateSuiteDefinitionOp(
      request: UpdateSuiteDefinitionRequest
    ) extends IotDeviceAdvisorOp[UpdateSuiteDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSuiteDefinitionResponse] =
        visitor.updateSuiteDefinition(request)
    }
  }

  import IotDeviceAdvisorOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[IotDeviceAdvisorOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createSuiteDefinition(
    request: CreateSuiteDefinitionRequest
  ): IotDeviceAdvisorIO[CreateSuiteDefinitionResponse] =
    FF.liftF(CreateSuiteDefinitionOp(request))

  def deleteSuiteDefinition(
    request: DeleteSuiteDefinitionRequest
  ): IotDeviceAdvisorIO[DeleteSuiteDefinitionResponse] =
    FF.liftF(DeleteSuiteDefinitionOp(request))

  def getSuiteDefinition(
    request: GetSuiteDefinitionRequest
  ): IotDeviceAdvisorIO[GetSuiteDefinitionResponse] =
    FF.liftF(GetSuiteDefinitionOp(request))

  def getSuiteRun(
    request: GetSuiteRunRequest
  ): IotDeviceAdvisorIO[GetSuiteRunResponse] =
    FF.liftF(GetSuiteRunOp(request))

  def getSuiteRunReport(
    request: GetSuiteRunReportRequest
  ): IotDeviceAdvisorIO[GetSuiteRunReportResponse] =
    FF.liftF(GetSuiteRunReportOp(request))

  def listSuiteDefinitions(
    request: ListSuiteDefinitionsRequest
  ): IotDeviceAdvisorIO[ListSuiteDefinitionsResponse] =
    FF.liftF(ListSuiteDefinitionsOp(request))

  def listSuiteRuns(
    request: ListSuiteRunsRequest
  ): IotDeviceAdvisorIO[ListSuiteRunsResponse] =
    FF.liftF(ListSuiteRunsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): IotDeviceAdvisorIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def startSuiteRun(
    request: StartSuiteRunRequest
  ): IotDeviceAdvisorIO[StartSuiteRunResponse] =
    FF.liftF(StartSuiteRunOp(request))

  def stopSuiteRun(
    request: StopSuiteRunRequest
  ): IotDeviceAdvisorIO[StopSuiteRunResponse] =
    FF.liftF(StopSuiteRunOp(request))

  def tagResource(
    request: TagResourceRequest
  ): IotDeviceAdvisorIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): IotDeviceAdvisorIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateSuiteDefinition(
    request: UpdateSuiteDefinitionRequest
  ): IotDeviceAdvisorIO[UpdateSuiteDefinitionResponse] =
    FF.liftF(UpdateSuiteDefinitionOp(request))
}
