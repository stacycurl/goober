package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.iotthingsgraph.IoTThingsGraphClient
import software.amazon.awssdk.services.iotthingsgraph.model._


object iotthingsgraph { module =>

  // Free monad over IoTThingsGraphOp
  type IoTThingsGraphIO[A] = FF[IoTThingsGraphOp, A]

  sealed trait IoTThingsGraphOp[A] {
    def visit[F[_]](visitor: IoTThingsGraphOp.Visitor[F]): F[A]
  }

  object IoTThingsGraphOp {
    // Given a IoTThingsGraphClient we can embed a IoTThingsGraphIO program in any algebra that understands embedding.
    implicit val IoTThingsGraphOpEmbeddable: Embeddable[IoTThingsGraphOp, IoTThingsGraphClient] = new Embeddable[IoTThingsGraphOp, IoTThingsGraphClient] {
      def embed[A](client: IoTThingsGraphClient, io: IoTThingsGraphIO[A]): Embedded[A] = Embedded.IoTThingsGraph(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends IoTThingsGraphOp.Visitor[Kleisli[M, IoTThingsGraphClient, *]] {
        def associateEntityToThing(
          request: AssociateEntityToThingRequest
        ): Kleisli[M, IoTThingsGraphClient, AssociateEntityToThingResponse] =
          primitive(_.associateEntityToThing(request))

        def createFlowTemplate(
          request: CreateFlowTemplateRequest
        ): Kleisli[M, IoTThingsGraphClient, CreateFlowTemplateResponse] =
          primitive(_.createFlowTemplate(request))

        def createSystemInstance(
          request: CreateSystemInstanceRequest
        ): Kleisli[M, IoTThingsGraphClient, CreateSystemInstanceResponse] =
          primitive(_.createSystemInstance(request))

        def createSystemTemplate(
          request: CreateSystemTemplateRequest
        ): Kleisli[M, IoTThingsGraphClient, CreateSystemTemplateResponse] =
          primitive(_.createSystemTemplate(request))

        def deleteFlowTemplate(
          request: DeleteFlowTemplateRequest
        ): Kleisli[M, IoTThingsGraphClient, DeleteFlowTemplateResponse] =
          primitive(_.deleteFlowTemplate(request))

        def deleteNamespace(
          request: DeleteNamespaceRequest
        ): Kleisli[M, IoTThingsGraphClient, DeleteNamespaceResponse] =
          primitive(_.deleteNamespace(request))

        def deleteSystemInstance(
          request: DeleteSystemInstanceRequest
        ): Kleisli[M, IoTThingsGraphClient, DeleteSystemInstanceResponse] =
          primitive(_.deleteSystemInstance(request))

        def deleteSystemTemplate(
          request: DeleteSystemTemplateRequest
        ): Kleisli[M, IoTThingsGraphClient, DeleteSystemTemplateResponse] =
          primitive(_.deleteSystemTemplate(request))

        def deploySystemInstance(
          request: DeploySystemInstanceRequest
        ): Kleisli[M, IoTThingsGraphClient, DeploySystemInstanceResponse] =
          primitive(_.deploySystemInstance(request))

        def deprecateFlowTemplate(
          request: DeprecateFlowTemplateRequest
        ): Kleisli[M, IoTThingsGraphClient, DeprecateFlowTemplateResponse] =
          primitive(_.deprecateFlowTemplate(request))

        def deprecateSystemTemplate(
          request: DeprecateSystemTemplateRequest
        ): Kleisli[M, IoTThingsGraphClient, DeprecateSystemTemplateResponse] =
          primitive(_.deprecateSystemTemplate(request))

        def describeNamespace(
          request: DescribeNamespaceRequest
        ): Kleisli[M, IoTThingsGraphClient, DescribeNamespaceResponse] =
          primitive(_.describeNamespace(request))

        def dissociateEntityFromThing(
          request: DissociateEntityFromThingRequest
        ): Kleisli[M, IoTThingsGraphClient, DissociateEntityFromThingResponse] =
          primitive(_.dissociateEntityFromThing(request))

        def getEntities(
          request: GetEntitiesRequest
        ): Kleisli[M, IoTThingsGraphClient, GetEntitiesResponse] =
          primitive(_.getEntities(request))

        def getFlowTemplate(
          request: GetFlowTemplateRequest
        ): Kleisli[M, IoTThingsGraphClient, GetFlowTemplateResponse] =
          primitive(_.getFlowTemplate(request))

        def getFlowTemplateRevisions(
          request: GetFlowTemplateRevisionsRequest
        ): Kleisli[M, IoTThingsGraphClient, GetFlowTemplateRevisionsResponse] =
          primitive(_.getFlowTemplateRevisions(request))

        def getNamespaceDeletionStatus(
          request: GetNamespaceDeletionStatusRequest
        ): Kleisli[M, IoTThingsGraphClient, GetNamespaceDeletionStatusResponse] =
          primitive(_.getNamespaceDeletionStatus(request))

        def getSystemInstance(
          request: GetSystemInstanceRequest
        ): Kleisli[M, IoTThingsGraphClient, GetSystemInstanceResponse] =
          primitive(_.getSystemInstance(request))

        def getSystemTemplate(
          request: GetSystemTemplateRequest
        ): Kleisli[M, IoTThingsGraphClient, GetSystemTemplateResponse] =
          primitive(_.getSystemTemplate(request))

        def getSystemTemplateRevisions(
          request: GetSystemTemplateRevisionsRequest
        ): Kleisli[M, IoTThingsGraphClient, GetSystemTemplateRevisionsResponse] =
          primitive(_.getSystemTemplateRevisions(request))

        def getUploadStatus(
          request: GetUploadStatusRequest
        ): Kleisli[M, IoTThingsGraphClient, GetUploadStatusResponse] =
          primitive(_.getUploadStatus(request))

        def listFlowExecutionMessages(
          request: ListFlowExecutionMessagesRequest
        ): Kleisli[M, IoTThingsGraphClient, ListFlowExecutionMessagesResponse] =
          primitive(_.listFlowExecutionMessages(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, IoTThingsGraphClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def searchEntities(
          request: SearchEntitiesRequest
        ): Kleisli[M, IoTThingsGraphClient, SearchEntitiesResponse] =
          primitive(_.searchEntities(request))

        def searchFlowExecutions(
          request: SearchFlowExecutionsRequest
        ): Kleisli[M, IoTThingsGraphClient, SearchFlowExecutionsResponse] =
          primitive(_.searchFlowExecutions(request))

        def searchFlowTemplates(
          request: SearchFlowTemplatesRequest
        ): Kleisli[M, IoTThingsGraphClient, SearchFlowTemplatesResponse] =
          primitive(_.searchFlowTemplates(request))

        def searchSystemInstances(
          request: SearchSystemInstancesRequest
        ): Kleisli[M, IoTThingsGraphClient, SearchSystemInstancesResponse] =
          primitive(_.searchSystemInstances(request))

        def searchSystemTemplates(
          request: SearchSystemTemplatesRequest
        ): Kleisli[M, IoTThingsGraphClient, SearchSystemTemplatesResponse] =
          primitive(_.searchSystemTemplates(request))

        def searchThings(
          request: SearchThingsRequest
        ): Kleisli[M, IoTThingsGraphClient, SearchThingsResponse] =
          primitive(_.searchThings(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, IoTThingsGraphClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def undeploySystemInstance(
          request: UndeploySystemInstanceRequest
        ): Kleisli[M, IoTThingsGraphClient, UndeploySystemInstanceResponse] =
          primitive(_.undeploySystemInstance(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, IoTThingsGraphClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateFlowTemplate(
          request: UpdateFlowTemplateRequest
        ): Kleisli[M, IoTThingsGraphClient, UpdateFlowTemplateResponse] =
          primitive(_.updateFlowTemplate(request))

        def updateSystemTemplate(
          request: UpdateSystemTemplateRequest
        ): Kleisli[M, IoTThingsGraphClient, UpdateSystemTemplateResponse] =
          primitive(_.updateSystemTemplate(request))

        def uploadEntityDefinitions(
          request: UploadEntityDefinitionsRequest
        ): Kleisli[M, IoTThingsGraphClient, UploadEntityDefinitionsResponse] =
          primitive(_.uploadEntityDefinitions(request))

        def primitive[A](
          f: IoTThingsGraphClient => A
        ): Kleisli[M, IoTThingsGraphClient, A]
      }
    }

    trait Visitor[F[_]] extends (IoTThingsGraphOp ~> F) {
      final def apply[A](op: IoTThingsGraphOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateEntityToThing(
        request: AssociateEntityToThingRequest
      ): F[AssociateEntityToThingResponse]

      def createFlowTemplate(
        request: CreateFlowTemplateRequest
      ): F[CreateFlowTemplateResponse]

      def createSystemInstance(
        request: CreateSystemInstanceRequest
      ): F[CreateSystemInstanceResponse]

      def createSystemTemplate(
        request: CreateSystemTemplateRequest
      ): F[CreateSystemTemplateResponse]

      def deleteFlowTemplate(
        request: DeleteFlowTemplateRequest
      ): F[DeleteFlowTemplateResponse]

      def deleteNamespace(
        request: DeleteNamespaceRequest
      ): F[DeleteNamespaceResponse]

      def deleteSystemInstance(
        request: DeleteSystemInstanceRequest
      ): F[DeleteSystemInstanceResponse]

      def deleteSystemTemplate(
        request: DeleteSystemTemplateRequest
      ): F[DeleteSystemTemplateResponse]

      def deploySystemInstance(
        request: DeploySystemInstanceRequest
      ): F[DeploySystemInstanceResponse]

      def deprecateFlowTemplate(
        request: DeprecateFlowTemplateRequest
      ): F[DeprecateFlowTemplateResponse]

      def deprecateSystemTemplate(
        request: DeprecateSystemTemplateRequest
      ): F[DeprecateSystemTemplateResponse]

      def describeNamespace(
        request: DescribeNamespaceRequest
      ): F[DescribeNamespaceResponse]

      def dissociateEntityFromThing(
        request: DissociateEntityFromThingRequest
      ): F[DissociateEntityFromThingResponse]

      def getEntities(
        request: GetEntitiesRequest
      ): F[GetEntitiesResponse]

      def getFlowTemplate(
        request: GetFlowTemplateRequest
      ): F[GetFlowTemplateResponse]

      def getFlowTemplateRevisions(
        request: GetFlowTemplateRevisionsRequest
      ): F[GetFlowTemplateRevisionsResponse]

      def getNamespaceDeletionStatus(
        request: GetNamespaceDeletionStatusRequest
      ): F[GetNamespaceDeletionStatusResponse]

      def getSystemInstance(
        request: GetSystemInstanceRequest
      ): F[GetSystemInstanceResponse]

      def getSystemTemplate(
        request: GetSystemTemplateRequest
      ): F[GetSystemTemplateResponse]

      def getSystemTemplateRevisions(
        request: GetSystemTemplateRevisionsRequest
      ): F[GetSystemTemplateRevisionsResponse]

      def getUploadStatus(
        request: GetUploadStatusRequest
      ): F[GetUploadStatusResponse]

      def listFlowExecutionMessages(
        request: ListFlowExecutionMessagesRequest
      ): F[ListFlowExecutionMessagesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def searchEntities(
        request: SearchEntitiesRequest
      ): F[SearchEntitiesResponse]

      def searchFlowExecutions(
        request: SearchFlowExecutionsRequest
      ): F[SearchFlowExecutionsResponse]

      def searchFlowTemplates(
        request: SearchFlowTemplatesRequest
      ): F[SearchFlowTemplatesResponse]

      def searchSystemInstances(
        request: SearchSystemInstancesRequest
      ): F[SearchSystemInstancesResponse]

      def searchSystemTemplates(
        request: SearchSystemTemplatesRequest
      ): F[SearchSystemTemplatesResponse]

      def searchThings(
        request: SearchThingsRequest
      ): F[SearchThingsResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def undeploySystemInstance(
        request: UndeploySystemInstanceRequest
      ): F[UndeploySystemInstanceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateFlowTemplate(
        request: UpdateFlowTemplateRequest
      ): F[UpdateFlowTemplateResponse]

      def updateSystemTemplate(
        request: UpdateSystemTemplateRequest
      ): F[UpdateSystemTemplateResponse]

      def uploadEntityDefinitions(
        request: UploadEntityDefinitionsRequest
      ): F[UploadEntityDefinitionsResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends IoTThingsGraphOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateEntityToThingOp(
      request: AssociateEntityToThingRequest
    ) extends IoTThingsGraphOp[AssociateEntityToThingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateEntityToThingResponse] =
        visitor.associateEntityToThing(request)
    }

    final case class CreateFlowTemplateOp(
      request: CreateFlowTemplateRequest
    ) extends IoTThingsGraphOp[CreateFlowTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFlowTemplateResponse] =
        visitor.createFlowTemplate(request)
    }

    final case class CreateSystemInstanceOp(
      request: CreateSystemInstanceRequest
    ) extends IoTThingsGraphOp[CreateSystemInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSystemInstanceResponse] =
        visitor.createSystemInstance(request)
    }

    final case class CreateSystemTemplateOp(
      request: CreateSystemTemplateRequest
    ) extends IoTThingsGraphOp[CreateSystemTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSystemTemplateResponse] =
        visitor.createSystemTemplate(request)
    }

    final case class DeleteFlowTemplateOp(
      request: DeleteFlowTemplateRequest
    ) extends IoTThingsGraphOp[DeleteFlowTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFlowTemplateResponse] =
        visitor.deleteFlowTemplate(request)
    }

    final case class DeleteNamespaceOp(
      request: DeleteNamespaceRequest
    ) extends IoTThingsGraphOp[DeleteNamespaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNamespaceResponse] =
        visitor.deleteNamespace(request)
    }

    final case class DeleteSystemInstanceOp(
      request: DeleteSystemInstanceRequest
    ) extends IoTThingsGraphOp[DeleteSystemInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSystemInstanceResponse] =
        visitor.deleteSystemInstance(request)
    }

    final case class DeleteSystemTemplateOp(
      request: DeleteSystemTemplateRequest
    ) extends IoTThingsGraphOp[DeleteSystemTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSystemTemplateResponse] =
        visitor.deleteSystemTemplate(request)
    }

    final case class DeploySystemInstanceOp(
      request: DeploySystemInstanceRequest
    ) extends IoTThingsGraphOp[DeploySystemInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeploySystemInstanceResponse] =
        visitor.deploySystemInstance(request)
    }

    final case class DeprecateFlowTemplateOp(
      request: DeprecateFlowTemplateRequest
    ) extends IoTThingsGraphOp[DeprecateFlowTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeprecateFlowTemplateResponse] =
        visitor.deprecateFlowTemplate(request)
    }

    final case class DeprecateSystemTemplateOp(
      request: DeprecateSystemTemplateRequest
    ) extends IoTThingsGraphOp[DeprecateSystemTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeprecateSystemTemplateResponse] =
        visitor.deprecateSystemTemplate(request)
    }

    final case class DescribeNamespaceOp(
      request: DescribeNamespaceRequest
    ) extends IoTThingsGraphOp[DescribeNamespaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNamespaceResponse] =
        visitor.describeNamespace(request)
    }

    final case class DissociateEntityFromThingOp(
      request: DissociateEntityFromThingRequest
    ) extends IoTThingsGraphOp[DissociateEntityFromThingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DissociateEntityFromThingResponse] =
        visitor.dissociateEntityFromThing(request)
    }

    final case class GetEntitiesOp(
      request: GetEntitiesRequest
    ) extends IoTThingsGraphOp[GetEntitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEntitiesResponse] =
        visitor.getEntities(request)
    }

    final case class GetFlowTemplateOp(
      request: GetFlowTemplateRequest
    ) extends IoTThingsGraphOp[GetFlowTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFlowTemplateResponse] =
        visitor.getFlowTemplate(request)
    }

    final case class GetFlowTemplateRevisionsOp(
      request: GetFlowTemplateRevisionsRequest
    ) extends IoTThingsGraphOp[GetFlowTemplateRevisionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFlowTemplateRevisionsResponse] =
        visitor.getFlowTemplateRevisions(request)
    }

    final case class GetNamespaceDeletionStatusOp(
      request: GetNamespaceDeletionStatusRequest
    ) extends IoTThingsGraphOp[GetNamespaceDeletionStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetNamespaceDeletionStatusResponse] =
        visitor.getNamespaceDeletionStatus(request)
    }

    final case class GetSystemInstanceOp(
      request: GetSystemInstanceRequest
    ) extends IoTThingsGraphOp[GetSystemInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSystemInstanceResponse] =
        visitor.getSystemInstance(request)
    }

    final case class GetSystemTemplateOp(
      request: GetSystemTemplateRequest
    ) extends IoTThingsGraphOp[GetSystemTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSystemTemplateResponse] =
        visitor.getSystemTemplate(request)
    }

    final case class GetSystemTemplateRevisionsOp(
      request: GetSystemTemplateRevisionsRequest
    ) extends IoTThingsGraphOp[GetSystemTemplateRevisionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSystemTemplateRevisionsResponse] =
        visitor.getSystemTemplateRevisions(request)
    }

    final case class GetUploadStatusOp(
      request: GetUploadStatusRequest
    ) extends IoTThingsGraphOp[GetUploadStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUploadStatusResponse] =
        visitor.getUploadStatus(request)
    }

    final case class ListFlowExecutionMessagesOp(
      request: ListFlowExecutionMessagesRequest
    ) extends IoTThingsGraphOp[ListFlowExecutionMessagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFlowExecutionMessagesResponse] =
        visitor.listFlowExecutionMessages(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends IoTThingsGraphOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class SearchEntitiesOp(
      request: SearchEntitiesRequest
    ) extends IoTThingsGraphOp[SearchEntitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchEntitiesResponse] =
        visitor.searchEntities(request)
    }

    final case class SearchFlowExecutionsOp(
      request: SearchFlowExecutionsRequest
    ) extends IoTThingsGraphOp[SearchFlowExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchFlowExecutionsResponse] =
        visitor.searchFlowExecutions(request)
    }

    final case class SearchFlowTemplatesOp(
      request: SearchFlowTemplatesRequest
    ) extends IoTThingsGraphOp[SearchFlowTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchFlowTemplatesResponse] =
        visitor.searchFlowTemplates(request)
    }

    final case class SearchSystemInstancesOp(
      request: SearchSystemInstancesRequest
    ) extends IoTThingsGraphOp[SearchSystemInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchSystemInstancesResponse] =
        visitor.searchSystemInstances(request)
    }

    final case class SearchSystemTemplatesOp(
      request: SearchSystemTemplatesRequest
    ) extends IoTThingsGraphOp[SearchSystemTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchSystemTemplatesResponse] =
        visitor.searchSystemTemplates(request)
    }

    final case class SearchThingsOp(
      request: SearchThingsRequest
    ) extends IoTThingsGraphOp[SearchThingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchThingsResponse] =
        visitor.searchThings(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends IoTThingsGraphOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UndeploySystemInstanceOp(
      request: UndeploySystemInstanceRequest
    ) extends IoTThingsGraphOp[UndeploySystemInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UndeploySystemInstanceResponse] =
        visitor.undeploySystemInstance(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends IoTThingsGraphOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateFlowTemplateOp(
      request: UpdateFlowTemplateRequest
    ) extends IoTThingsGraphOp[UpdateFlowTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFlowTemplateResponse] =
        visitor.updateFlowTemplate(request)
    }

    final case class UpdateSystemTemplateOp(
      request: UpdateSystemTemplateRequest
    ) extends IoTThingsGraphOp[UpdateSystemTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSystemTemplateResponse] =
        visitor.updateSystemTemplate(request)
    }

    final case class UploadEntityDefinitionsOp(
      request: UploadEntityDefinitionsRequest
    ) extends IoTThingsGraphOp[UploadEntityDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UploadEntityDefinitionsResponse] =
        visitor.uploadEntityDefinitions(request)
    }
  }

  import IoTThingsGraphOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[IoTThingsGraphOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateEntityToThing(
    request: AssociateEntityToThingRequest
  ): IoTThingsGraphIO[AssociateEntityToThingResponse] =
    FF.liftF(AssociateEntityToThingOp(request))

  def createFlowTemplate(
    request: CreateFlowTemplateRequest
  ): IoTThingsGraphIO[CreateFlowTemplateResponse] =
    FF.liftF(CreateFlowTemplateOp(request))

  def createSystemInstance(
    request: CreateSystemInstanceRequest
  ): IoTThingsGraphIO[CreateSystemInstanceResponse] =
    FF.liftF(CreateSystemInstanceOp(request))

  def createSystemTemplate(
    request: CreateSystemTemplateRequest
  ): IoTThingsGraphIO[CreateSystemTemplateResponse] =
    FF.liftF(CreateSystemTemplateOp(request))

  def deleteFlowTemplate(
    request: DeleteFlowTemplateRequest
  ): IoTThingsGraphIO[DeleteFlowTemplateResponse] =
    FF.liftF(DeleteFlowTemplateOp(request))

  def deleteNamespace(
    request: DeleteNamespaceRequest
  ): IoTThingsGraphIO[DeleteNamespaceResponse] =
    FF.liftF(DeleteNamespaceOp(request))

  def deleteSystemInstance(
    request: DeleteSystemInstanceRequest
  ): IoTThingsGraphIO[DeleteSystemInstanceResponse] =
    FF.liftF(DeleteSystemInstanceOp(request))

  def deleteSystemTemplate(
    request: DeleteSystemTemplateRequest
  ): IoTThingsGraphIO[DeleteSystemTemplateResponse] =
    FF.liftF(DeleteSystemTemplateOp(request))

  def deploySystemInstance(
    request: DeploySystemInstanceRequest
  ): IoTThingsGraphIO[DeploySystemInstanceResponse] =
    FF.liftF(DeploySystemInstanceOp(request))

  def deprecateFlowTemplate(
    request: DeprecateFlowTemplateRequest
  ): IoTThingsGraphIO[DeprecateFlowTemplateResponse] =
    FF.liftF(DeprecateFlowTemplateOp(request))

  def deprecateSystemTemplate(
    request: DeprecateSystemTemplateRequest
  ): IoTThingsGraphIO[DeprecateSystemTemplateResponse] =
    FF.liftF(DeprecateSystemTemplateOp(request))

  def describeNamespace(
    request: DescribeNamespaceRequest
  ): IoTThingsGraphIO[DescribeNamespaceResponse] =
    FF.liftF(DescribeNamespaceOp(request))

  def dissociateEntityFromThing(
    request: DissociateEntityFromThingRequest
  ): IoTThingsGraphIO[DissociateEntityFromThingResponse] =
    FF.liftF(DissociateEntityFromThingOp(request))

  def getEntities(
    request: GetEntitiesRequest
  ): IoTThingsGraphIO[GetEntitiesResponse] =
    FF.liftF(GetEntitiesOp(request))

  def getFlowTemplate(
    request: GetFlowTemplateRequest
  ): IoTThingsGraphIO[GetFlowTemplateResponse] =
    FF.liftF(GetFlowTemplateOp(request))

  def getFlowTemplateRevisions(
    request: GetFlowTemplateRevisionsRequest
  ): IoTThingsGraphIO[GetFlowTemplateRevisionsResponse] =
    FF.liftF(GetFlowTemplateRevisionsOp(request))

  def getNamespaceDeletionStatus(
    request: GetNamespaceDeletionStatusRequest
  ): IoTThingsGraphIO[GetNamespaceDeletionStatusResponse] =
    FF.liftF(GetNamespaceDeletionStatusOp(request))

  def getSystemInstance(
    request: GetSystemInstanceRequest
  ): IoTThingsGraphIO[GetSystemInstanceResponse] =
    FF.liftF(GetSystemInstanceOp(request))

  def getSystemTemplate(
    request: GetSystemTemplateRequest
  ): IoTThingsGraphIO[GetSystemTemplateResponse] =
    FF.liftF(GetSystemTemplateOp(request))

  def getSystemTemplateRevisions(
    request: GetSystemTemplateRevisionsRequest
  ): IoTThingsGraphIO[GetSystemTemplateRevisionsResponse] =
    FF.liftF(GetSystemTemplateRevisionsOp(request))

  def getUploadStatus(
    request: GetUploadStatusRequest
  ): IoTThingsGraphIO[GetUploadStatusResponse] =
    FF.liftF(GetUploadStatusOp(request))

  def listFlowExecutionMessages(
    request: ListFlowExecutionMessagesRequest
  ): IoTThingsGraphIO[ListFlowExecutionMessagesResponse] =
    FF.liftF(ListFlowExecutionMessagesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): IoTThingsGraphIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def searchEntities(
    request: SearchEntitiesRequest
  ): IoTThingsGraphIO[SearchEntitiesResponse] =
    FF.liftF(SearchEntitiesOp(request))

  def searchFlowExecutions(
    request: SearchFlowExecutionsRequest
  ): IoTThingsGraphIO[SearchFlowExecutionsResponse] =
    FF.liftF(SearchFlowExecutionsOp(request))

  def searchFlowTemplates(
    request: SearchFlowTemplatesRequest
  ): IoTThingsGraphIO[SearchFlowTemplatesResponse] =
    FF.liftF(SearchFlowTemplatesOp(request))

  def searchSystemInstances(
    request: SearchSystemInstancesRequest
  ): IoTThingsGraphIO[SearchSystemInstancesResponse] =
    FF.liftF(SearchSystemInstancesOp(request))

  def searchSystemTemplates(
    request: SearchSystemTemplatesRequest
  ): IoTThingsGraphIO[SearchSystemTemplatesResponse] =
    FF.liftF(SearchSystemTemplatesOp(request))

  def searchThings(
    request: SearchThingsRequest
  ): IoTThingsGraphIO[SearchThingsResponse] =
    FF.liftF(SearchThingsOp(request))

  def tagResource(
    request: TagResourceRequest
  ): IoTThingsGraphIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def undeploySystemInstance(
    request: UndeploySystemInstanceRequest
  ): IoTThingsGraphIO[UndeploySystemInstanceResponse] =
    FF.liftF(UndeploySystemInstanceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): IoTThingsGraphIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateFlowTemplate(
    request: UpdateFlowTemplateRequest
  ): IoTThingsGraphIO[UpdateFlowTemplateResponse] =
    FF.liftF(UpdateFlowTemplateOp(request))

  def updateSystemTemplate(
    request: UpdateSystemTemplateRequest
  ): IoTThingsGraphIO[UpdateSystemTemplateResponse] =
    FF.liftF(UpdateSystemTemplateOp(request))

  def uploadEntityDefinitions(
    request: UploadEntityDefinitionsRequest
  ): IoTThingsGraphIO[UploadEntityDefinitionsResponse] =
    FF.liftF(UploadEntityDefinitionsOp(request))
}
