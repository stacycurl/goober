package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.frauddetector.FraudDetectorClient
import software.amazon.awssdk.services.frauddetector.model._


object frauddetector { module =>

  // Free monad over FraudDetectorOp
  type FraudDetectorIO[A] = FF[FraudDetectorOp, A]

  sealed trait FraudDetectorOp[A] {
    def visit[F[_]](visitor: FraudDetectorOp.Visitor[F]): F[A]
  }

  object FraudDetectorOp {
    // Given a FraudDetectorClient we can embed a FraudDetectorIO program in any algebra that understands embedding.
    implicit val FraudDetectorOpEmbeddable: Embeddable[FraudDetectorOp, FraudDetectorClient] = new Embeddable[FraudDetectorOp, FraudDetectorClient] {
      def embed[A](client: FraudDetectorClient, io: FraudDetectorIO[A]): Embedded[A] = Embedded.FraudDetector(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends FraudDetectorOp.Visitor[Kleisli[M, FraudDetectorClient, *]] {
        def batchCreateVariable(
          request: BatchCreateVariableRequest
        ): Kleisli[M, FraudDetectorClient, BatchCreateVariableResponse] =
          primitive(_.batchCreateVariable(request))

        def batchGetVariable(
          request: BatchGetVariableRequest
        ): Kleisli[M, FraudDetectorClient, BatchGetVariableResponse] =
          primitive(_.batchGetVariable(request))

        def cancelBatchPredictionJob(
          request: CancelBatchPredictionJobRequest
        ): Kleisli[M, FraudDetectorClient, CancelBatchPredictionJobResponse] =
          primitive(_.cancelBatchPredictionJob(request))

        def createBatchPredictionJob(
          request: CreateBatchPredictionJobRequest
        ): Kleisli[M, FraudDetectorClient, CreateBatchPredictionJobResponse] =
          primitive(_.createBatchPredictionJob(request))

        def createDetectorVersion(
          request: CreateDetectorVersionRequest
        ): Kleisli[M, FraudDetectorClient, CreateDetectorVersionResponse] =
          primitive(_.createDetectorVersion(request))

        def createModel(
          request: CreateModelRequest
        ): Kleisli[M, FraudDetectorClient, CreateModelResponse] =
          primitive(_.createModel(request))

        def createModelVersion(
          request: CreateModelVersionRequest
        ): Kleisli[M, FraudDetectorClient, CreateModelVersionResponse] =
          primitive(_.createModelVersion(request))

        def createRule(
          request: CreateRuleRequest
        ): Kleisli[M, FraudDetectorClient, CreateRuleResponse] =
          primitive(_.createRule(request))

        def createVariable(
          request: CreateVariableRequest
        ): Kleisli[M, FraudDetectorClient, CreateVariableResponse] =
          primitive(_.createVariable(request))

        def deleteBatchPredictionJob(
          request: DeleteBatchPredictionJobRequest
        ): Kleisli[M, FraudDetectorClient, DeleteBatchPredictionJobResponse] =
          primitive(_.deleteBatchPredictionJob(request))

        def deleteDetector(
          request: DeleteDetectorRequest
        ): Kleisli[M, FraudDetectorClient, DeleteDetectorResponse] =
          primitive(_.deleteDetector(request))

        def deleteDetectorVersion(
          request: DeleteDetectorVersionRequest
        ): Kleisli[M, FraudDetectorClient, DeleteDetectorVersionResponse] =
          primitive(_.deleteDetectorVersion(request))

        def deleteEntityType(
          request: DeleteEntityTypeRequest
        ): Kleisli[M, FraudDetectorClient, DeleteEntityTypeResponse] =
          primitive(_.deleteEntityType(request))

        def deleteEvent(
          request: DeleteEventRequest
        ): Kleisli[M, FraudDetectorClient, DeleteEventResponse] =
          primitive(_.deleteEvent(request))

        def deleteEventType(
          request: DeleteEventTypeRequest
        ): Kleisli[M, FraudDetectorClient, DeleteEventTypeResponse] =
          primitive(_.deleteEventType(request))

        def deleteExternalModel(
          request: DeleteExternalModelRequest
        ): Kleisli[M, FraudDetectorClient, DeleteExternalModelResponse] =
          primitive(_.deleteExternalModel(request))

        def deleteLabel(
          request: DeleteLabelRequest
        ): Kleisli[M, FraudDetectorClient, DeleteLabelResponse] =
          primitive(_.deleteLabel(request))

        def deleteModel(
          request: DeleteModelRequest
        ): Kleisli[M, FraudDetectorClient, DeleteModelResponse] =
          primitive(_.deleteModel(request))

        def deleteModelVersion(
          request: DeleteModelVersionRequest
        ): Kleisli[M, FraudDetectorClient, DeleteModelVersionResponse] =
          primitive(_.deleteModelVersion(request))

        def deleteOutcome(
          request: DeleteOutcomeRequest
        ): Kleisli[M, FraudDetectorClient, DeleteOutcomeResponse] =
          primitive(_.deleteOutcome(request))

        def deleteRule(
          request: DeleteRuleRequest
        ): Kleisli[M, FraudDetectorClient, DeleteRuleResponse] =
          primitive(_.deleteRule(request))

        def deleteVariable(
          request: DeleteVariableRequest
        ): Kleisli[M, FraudDetectorClient, DeleteVariableResponse] =
          primitive(_.deleteVariable(request))

        def describeDetector(
          request: DescribeDetectorRequest
        ): Kleisli[M, FraudDetectorClient, DescribeDetectorResponse] =
          primitive(_.describeDetector(request))

        def describeModelVersions(
          request: DescribeModelVersionsRequest
        ): Kleisli[M, FraudDetectorClient, DescribeModelVersionsResponse] =
          primitive(_.describeModelVersions(request))

        def getBatchPredictionJobs(
          request: GetBatchPredictionJobsRequest
        ): Kleisli[M, FraudDetectorClient, GetBatchPredictionJobsResponse] =
          primitive(_.getBatchPredictionJobs(request))

        def getDetectorVersion(
          request: GetDetectorVersionRequest
        ): Kleisli[M, FraudDetectorClient, GetDetectorVersionResponse] =
          primitive(_.getDetectorVersion(request))

        def getDetectors(
          request: GetDetectorsRequest
        ): Kleisli[M, FraudDetectorClient, GetDetectorsResponse] =
          primitive(_.getDetectors(request))

        def getEntityTypes(
          request: GetEntityTypesRequest
        ): Kleisli[M, FraudDetectorClient, GetEntityTypesResponse] =
          primitive(_.getEntityTypes(request))

        def getEventPrediction(
          request: GetEventPredictionRequest
        ): Kleisli[M, FraudDetectorClient, GetEventPredictionResponse] =
          primitive(_.getEventPrediction(request))

        def getEventTypes(
          request: GetEventTypesRequest
        ): Kleisli[M, FraudDetectorClient, GetEventTypesResponse] =
          primitive(_.getEventTypes(request))

        def getExternalModels(
          request: GetExternalModelsRequest
        ): Kleisli[M, FraudDetectorClient, GetExternalModelsResponse] =
          primitive(_.getExternalModels(request))

        def getKMSEncryptionKey(
          request: GetKmsEncryptionKeyRequest
        ): Kleisli[M, FraudDetectorClient, GetKmsEncryptionKeyResponse] =
          primitive(_.getKMSEncryptionKey(request))

        def getLabels(
          request: GetLabelsRequest
        ): Kleisli[M, FraudDetectorClient, GetLabelsResponse] =
          primitive(_.getLabels(request))

        def getModelVersion(
          request: GetModelVersionRequest
        ): Kleisli[M, FraudDetectorClient, GetModelVersionResponse] =
          primitive(_.getModelVersion(request))

        def getModels(
          request: GetModelsRequest
        ): Kleisli[M, FraudDetectorClient, GetModelsResponse] =
          primitive(_.getModels(request))

        def getOutcomes(
          request: GetOutcomesRequest
        ): Kleisli[M, FraudDetectorClient, GetOutcomesResponse] =
          primitive(_.getOutcomes(request))

        def getRules(
          request: GetRulesRequest
        ): Kleisli[M, FraudDetectorClient, GetRulesResponse] =
          primitive(_.getRules(request))

        def getVariables(
          request: GetVariablesRequest
        ): Kleisli[M, FraudDetectorClient, GetVariablesResponse] =
          primitive(_.getVariables(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, FraudDetectorClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putDetector(
          request: PutDetectorRequest
        ): Kleisli[M, FraudDetectorClient, PutDetectorResponse] =
          primitive(_.putDetector(request))

        def putEntityType(
          request: PutEntityTypeRequest
        ): Kleisli[M, FraudDetectorClient, PutEntityTypeResponse] =
          primitive(_.putEntityType(request))

        def putEventType(
          request: PutEventTypeRequest
        ): Kleisli[M, FraudDetectorClient, PutEventTypeResponse] =
          primitive(_.putEventType(request))

        def putExternalModel(
          request: PutExternalModelRequest
        ): Kleisli[M, FraudDetectorClient, PutExternalModelResponse] =
          primitive(_.putExternalModel(request))

        def putKMSEncryptionKey(
          request: PutKmsEncryptionKeyRequest
        ): Kleisli[M, FraudDetectorClient, PutKmsEncryptionKeyResponse] =
          primitive(_.putKMSEncryptionKey(request))

        def putLabel(
          request: PutLabelRequest
        ): Kleisli[M, FraudDetectorClient, PutLabelResponse] =
          primitive(_.putLabel(request))

        def putOutcome(
          request: PutOutcomeRequest
        ): Kleisli[M, FraudDetectorClient, PutOutcomeResponse] =
          primitive(_.putOutcome(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, FraudDetectorClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, FraudDetectorClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateDetectorVersion(
          request: UpdateDetectorVersionRequest
        ): Kleisli[M, FraudDetectorClient, UpdateDetectorVersionResponse] =
          primitive(_.updateDetectorVersion(request))

        def updateDetectorVersionMetadata(
          request: UpdateDetectorVersionMetadataRequest
        ): Kleisli[M, FraudDetectorClient, UpdateDetectorVersionMetadataResponse] =
          primitive(_.updateDetectorVersionMetadata(request))

        def updateDetectorVersionStatus(
          request: UpdateDetectorVersionStatusRequest
        ): Kleisli[M, FraudDetectorClient, UpdateDetectorVersionStatusResponse] =
          primitive(_.updateDetectorVersionStatus(request))

        def updateModel(
          request: UpdateModelRequest
        ): Kleisli[M, FraudDetectorClient, UpdateModelResponse] =
          primitive(_.updateModel(request))

        def updateModelVersion(
          request: UpdateModelVersionRequest
        ): Kleisli[M, FraudDetectorClient, UpdateModelVersionResponse] =
          primitive(_.updateModelVersion(request))

        def updateModelVersionStatus(
          request: UpdateModelVersionStatusRequest
        ): Kleisli[M, FraudDetectorClient, UpdateModelVersionStatusResponse] =
          primitive(_.updateModelVersionStatus(request))

        def updateRuleMetadata(
          request: UpdateRuleMetadataRequest
        ): Kleisli[M, FraudDetectorClient, UpdateRuleMetadataResponse] =
          primitive(_.updateRuleMetadata(request))

        def updateRuleVersion(
          request: UpdateRuleVersionRequest
        ): Kleisli[M, FraudDetectorClient, UpdateRuleVersionResponse] =
          primitive(_.updateRuleVersion(request))

        def updateVariable(
          request: UpdateVariableRequest
        ): Kleisli[M, FraudDetectorClient, UpdateVariableResponse] =
          primitive(_.updateVariable(request))

        def primitive[A](
          f: FraudDetectorClient => A
        ): Kleisli[M, FraudDetectorClient, A]
      }
    }

    trait Visitor[F[_]] extends (FraudDetectorOp ~> F) {
      final def apply[A](op: FraudDetectorOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchCreateVariable(
        request: BatchCreateVariableRequest
      ): F[BatchCreateVariableResponse]

      def batchGetVariable(
        request: BatchGetVariableRequest
      ): F[BatchGetVariableResponse]

      def cancelBatchPredictionJob(
        request: CancelBatchPredictionJobRequest
      ): F[CancelBatchPredictionJobResponse]

      def createBatchPredictionJob(
        request: CreateBatchPredictionJobRequest
      ): F[CreateBatchPredictionJobResponse]

      def createDetectorVersion(
        request: CreateDetectorVersionRequest
      ): F[CreateDetectorVersionResponse]

      def createModel(
        request: CreateModelRequest
      ): F[CreateModelResponse]

      def createModelVersion(
        request: CreateModelVersionRequest
      ): F[CreateModelVersionResponse]

      def createRule(
        request: CreateRuleRequest
      ): F[CreateRuleResponse]

      def createVariable(
        request: CreateVariableRequest
      ): F[CreateVariableResponse]

      def deleteBatchPredictionJob(
        request: DeleteBatchPredictionJobRequest
      ): F[DeleteBatchPredictionJobResponse]

      def deleteDetector(
        request: DeleteDetectorRequest
      ): F[DeleteDetectorResponse]

      def deleteDetectorVersion(
        request: DeleteDetectorVersionRequest
      ): F[DeleteDetectorVersionResponse]

      def deleteEntityType(
        request: DeleteEntityTypeRequest
      ): F[DeleteEntityTypeResponse]

      def deleteEvent(
        request: DeleteEventRequest
      ): F[DeleteEventResponse]

      def deleteEventType(
        request: DeleteEventTypeRequest
      ): F[DeleteEventTypeResponse]

      def deleteExternalModel(
        request: DeleteExternalModelRequest
      ): F[DeleteExternalModelResponse]

      def deleteLabel(
        request: DeleteLabelRequest
      ): F[DeleteLabelResponse]

      def deleteModel(
        request: DeleteModelRequest
      ): F[DeleteModelResponse]

      def deleteModelVersion(
        request: DeleteModelVersionRequest
      ): F[DeleteModelVersionResponse]

      def deleteOutcome(
        request: DeleteOutcomeRequest
      ): F[DeleteOutcomeResponse]

      def deleteRule(
        request: DeleteRuleRequest
      ): F[DeleteRuleResponse]

      def deleteVariable(
        request: DeleteVariableRequest
      ): F[DeleteVariableResponse]

      def describeDetector(
        request: DescribeDetectorRequest
      ): F[DescribeDetectorResponse]

      def describeModelVersions(
        request: DescribeModelVersionsRequest
      ): F[DescribeModelVersionsResponse]

      def getBatchPredictionJobs(
        request: GetBatchPredictionJobsRequest
      ): F[GetBatchPredictionJobsResponse]

      def getDetectorVersion(
        request: GetDetectorVersionRequest
      ): F[GetDetectorVersionResponse]

      def getDetectors(
        request: GetDetectorsRequest
      ): F[GetDetectorsResponse]

      def getEntityTypes(
        request: GetEntityTypesRequest
      ): F[GetEntityTypesResponse]

      def getEventPrediction(
        request: GetEventPredictionRequest
      ): F[GetEventPredictionResponse]

      def getEventTypes(
        request: GetEventTypesRequest
      ): F[GetEventTypesResponse]

      def getExternalModels(
        request: GetExternalModelsRequest
      ): F[GetExternalModelsResponse]

      def getKMSEncryptionKey(
        request: GetKmsEncryptionKeyRequest
      ): F[GetKmsEncryptionKeyResponse]

      def getLabels(
        request: GetLabelsRequest
      ): F[GetLabelsResponse]

      def getModelVersion(
        request: GetModelVersionRequest
      ): F[GetModelVersionResponse]

      def getModels(
        request: GetModelsRequest
      ): F[GetModelsResponse]

      def getOutcomes(
        request: GetOutcomesRequest
      ): F[GetOutcomesResponse]

      def getRules(
        request: GetRulesRequest
      ): F[GetRulesResponse]

      def getVariables(
        request: GetVariablesRequest
      ): F[GetVariablesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putDetector(
        request: PutDetectorRequest
      ): F[PutDetectorResponse]

      def putEntityType(
        request: PutEntityTypeRequest
      ): F[PutEntityTypeResponse]

      def putEventType(
        request: PutEventTypeRequest
      ): F[PutEventTypeResponse]

      def putExternalModel(
        request: PutExternalModelRequest
      ): F[PutExternalModelResponse]

      def putKMSEncryptionKey(
        request: PutKmsEncryptionKeyRequest
      ): F[PutKmsEncryptionKeyResponse]

      def putLabel(
        request: PutLabelRequest
      ): F[PutLabelResponse]

      def putOutcome(
        request: PutOutcomeRequest
      ): F[PutOutcomeResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateDetectorVersion(
        request: UpdateDetectorVersionRequest
      ): F[UpdateDetectorVersionResponse]

      def updateDetectorVersionMetadata(
        request: UpdateDetectorVersionMetadataRequest
      ): F[UpdateDetectorVersionMetadataResponse]

      def updateDetectorVersionStatus(
        request: UpdateDetectorVersionStatusRequest
      ): F[UpdateDetectorVersionStatusResponse]

      def updateModel(
        request: UpdateModelRequest
      ): F[UpdateModelResponse]

      def updateModelVersion(
        request: UpdateModelVersionRequest
      ): F[UpdateModelVersionResponse]

      def updateModelVersionStatus(
        request: UpdateModelVersionStatusRequest
      ): F[UpdateModelVersionStatusResponse]

      def updateRuleMetadata(
        request: UpdateRuleMetadataRequest
      ): F[UpdateRuleMetadataResponse]

      def updateRuleVersion(
        request: UpdateRuleVersionRequest
      ): F[UpdateRuleVersionResponse]

      def updateVariable(
        request: UpdateVariableRequest
      ): F[UpdateVariableResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends FraudDetectorOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchCreateVariableOp(
      request: BatchCreateVariableRequest
    ) extends FraudDetectorOp[BatchCreateVariableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchCreateVariableResponse] =
        visitor.batchCreateVariable(request)
    }

    final case class BatchGetVariableOp(
      request: BatchGetVariableRequest
    ) extends FraudDetectorOp[BatchGetVariableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetVariableResponse] =
        visitor.batchGetVariable(request)
    }

    final case class CancelBatchPredictionJobOp(
      request: CancelBatchPredictionJobRequest
    ) extends FraudDetectorOp[CancelBatchPredictionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelBatchPredictionJobResponse] =
        visitor.cancelBatchPredictionJob(request)
    }

    final case class CreateBatchPredictionJobOp(
      request: CreateBatchPredictionJobRequest
    ) extends FraudDetectorOp[CreateBatchPredictionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBatchPredictionJobResponse] =
        visitor.createBatchPredictionJob(request)
    }

    final case class CreateDetectorVersionOp(
      request: CreateDetectorVersionRequest
    ) extends FraudDetectorOp[CreateDetectorVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDetectorVersionResponse] =
        visitor.createDetectorVersion(request)
    }

    final case class CreateModelOp(
      request: CreateModelRequest
    ) extends FraudDetectorOp[CreateModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateModelResponse] =
        visitor.createModel(request)
    }

    final case class CreateModelVersionOp(
      request: CreateModelVersionRequest
    ) extends FraudDetectorOp[CreateModelVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateModelVersionResponse] =
        visitor.createModelVersion(request)
    }

    final case class CreateRuleOp(
      request: CreateRuleRequest
    ) extends FraudDetectorOp[CreateRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRuleResponse] =
        visitor.createRule(request)
    }

    final case class CreateVariableOp(
      request: CreateVariableRequest
    ) extends FraudDetectorOp[CreateVariableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVariableResponse] =
        visitor.createVariable(request)
    }

    final case class DeleteBatchPredictionJobOp(
      request: DeleteBatchPredictionJobRequest
    ) extends FraudDetectorOp[DeleteBatchPredictionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBatchPredictionJobResponse] =
        visitor.deleteBatchPredictionJob(request)
    }

    final case class DeleteDetectorOp(
      request: DeleteDetectorRequest
    ) extends FraudDetectorOp[DeleteDetectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDetectorResponse] =
        visitor.deleteDetector(request)
    }

    final case class DeleteDetectorVersionOp(
      request: DeleteDetectorVersionRequest
    ) extends FraudDetectorOp[DeleteDetectorVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDetectorVersionResponse] =
        visitor.deleteDetectorVersion(request)
    }

    final case class DeleteEntityTypeOp(
      request: DeleteEntityTypeRequest
    ) extends FraudDetectorOp[DeleteEntityTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEntityTypeResponse] =
        visitor.deleteEntityType(request)
    }

    final case class DeleteEventOp(
      request: DeleteEventRequest
    ) extends FraudDetectorOp[DeleteEventResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEventResponse] =
        visitor.deleteEvent(request)
    }

    final case class DeleteEventTypeOp(
      request: DeleteEventTypeRequest
    ) extends FraudDetectorOp[DeleteEventTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEventTypeResponse] =
        visitor.deleteEventType(request)
    }

    final case class DeleteExternalModelOp(
      request: DeleteExternalModelRequest
    ) extends FraudDetectorOp[DeleteExternalModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteExternalModelResponse] =
        visitor.deleteExternalModel(request)
    }

    final case class DeleteLabelOp(
      request: DeleteLabelRequest
    ) extends FraudDetectorOp[DeleteLabelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLabelResponse] =
        visitor.deleteLabel(request)
    }

    final case class DeleteModelOp(
      request: DeleteModelRequest
    ) extends FraudDetectorOp[DeleteModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteModelResponse] =
        visitor.deleteModel(request)
    }

    final case class DeleteModelVersionOp(
      request: DeleteModelVersionRequest
    ) extends FraudDetectorOp[DeleteModelVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteModelVersionResponse] =
        visitor.deleteModelVersion(request)
    }

    final case class DeleteOutcomeOp(
      request: DeleteOutcomeRequest
    ) extends FraudDetectorOp[DeleteOutcomeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteOutcomeResponse] =
        visitor.deleteOutcome(request)
    }

    final case class DeleteRuleOp(
      request: DeleteRuleRequest
    ) extends FraudDetectorOp[DeleteRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRuleResponse] =
        visitor.deleteRule(request)
    }

    final case class DeleteVariableOp(
      request: DeleteVariableRequest
    ) extends FraudDetectorOp[DeleteVariableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVariableResponse] =
        visitor.deleteVariable(request)
    }

    final case class DescribeDetectorOp(
      request: DescribeDetectorRequest
    ) extends FraudDetectorOp[DescribeDetectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDetectorResponse] =
        visitor.describeDetector(request)
    }

    final case class DescribeModelVersionsOp(
      request: DescribeModelVersionsRequest
    ) extends FraudDetectorOp[DescribeModelVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeModelVersionsResponse] =
        visitor.describeModelVersions(request)
    }

    final case class GetBatchPredictionJobsOp(
      request: GetBatchPredictionJobsRequest
    ) extends FraudDetectorOp[GetBatchPredictionJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBatchPredictionJobsResponse] =
        visitor.getBatchPredictionJobs(request)
    }

    final case class GetDetectorVersionOp(
      request: GetDetectorVersionRequest
    ) extends FraudDetectorOp[GetDetectorVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDetectorVersionResponse] =
        visitor.getDetectorVersion(request)
    }

    final case class GetDetectorsOp(
      request: GetDetectorsRequest
    ) extends FraudDetectorOp[GetDetectorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDetectorsResponse] =
        visitor.getDetectors(request)
    }

    final case class GetEntityTypesOp(
      request: GetEntityTypesRequest
    ) extends FraudDetectorOp[GetEntityTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEntityTypesResponse] =
        visitor.getEntityTypes(request)
    }

    final case class GetEventPredictionOp(
      request: GetEventPredictionRequest
    ) extends FraudDetectorOp[GetEventPredictionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEventPredictionResponse] =
        visitor.getEventPrediction(request)
    }

    final case class GetEventTypesOp(
      request: GetEventTypesRequest
    ) extends FraudDetectorOp[GetEventTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEventTypesResponse] =
        visitor.getEventTypes(request)
    }

    final case class GetExternalModelsOp(
      request: GetExternalModelsRequest
    ) extends FraudDetectorOp[GetExternalModelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetExternalModelsResponse] =
        visitor.getExternalModels(request)
    }

    final case class GetKMSEncryptionKeyOp(
      request: GetKmsEncryptionKeyRequest
    ) extends FraudDetectorOp[GetKmsEncryptionKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetKmsEncryptionKeyResponse] =
        visitor.getKMSEncryptionKey(request)
    }

    final case class GetLabelsOp(
      request: GetLabelsRequest
    ) extends FraudDetectorOp[GetLabelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLabelsResponse] =
        visitor.getLabels(request)
    }

    final case class GetModelVersionOp(
      request: GetModelVersionRequest
    ) extends FraudDetectorOp[GetModelVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetModelVersionResponse] =
        visitor.getModelVersion(request)
    }

    final case class GetModelsOp(
      request: GetModelsRequest
    ) extends FraudDetectorOp[GetModelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetModelsResponse] =
        visitor.getModels(request)
    }

    final case class GetOutcomesOp(
      request: GetOutcomesRequest
    ) extends FraudDetectorOp[GetOutcomesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOutcomesResponse] =
        visitor.getOutcomes(request)
    }

    final case class GetRulesOp(
      request: GetRulesRequest
    ) extends FraudDetectorOp[GetRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRulesResponse] =
        visitor.getRules(request)
    }

    final case class GetVariablesOp(
      request: GetVariablesRequest
    ) extends FraudDetectorOp[GetVariablesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVariablesResponse] =
        visitor.getVariables(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends FraudDetectorOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutDetectorOp(
      request: PutDetectorRequest
    ) extends FraudDetectorOp[PutDetectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutDetectorResponse] =
        visitor.putDetector(request)
    }

    final case class PutEntityTypeOp(
      request: PutEntityTypeRequest
    ) extends FraudDetectorOp[PutEntityTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutEntityTypeResponse] =
        visitor.putEntityType(request)
    }

    final case class PutEventTypeOp(
      request: PutEventTypeRequest
    ) extends FraudDetectorOp[PutEventTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutEventTypeResponse] =
        visitor.putEventType(request)
    }

    final case class PutExternalModelOp(
      request: PutExternalModelRequest
    ) extends FraudDetectorOp[PutExternalModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutExternalModelResponse] =
        visitor.putExternalModel(request)
    }

    final case class PutKMSEncryptionKeyOp(
      request: PutKmsEncryptionKeyRequest
    ) extends FraudDetectorOp[PutKmsEncryptionKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutKmsEncryptionKeyResponse] =
        visitor.putKMSEncryptionKey(request)
    }

    final case class PutLabelOp(
      request: PutLabelRequest
    ) extends FraudDetectorOp[PutLabelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutLabelResponse] =
        visitor.putLabel(request)
    }

    final case class PutOutcomeOp(
      request: PutOutcomeRequest
    ) extends FraudDetectorOp[PutOutcomeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutOutcomeResponse] =
        visitor.putOutcome(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends FraudDetectorOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends FraudDetectorOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateDetectorVersionOp(
      request: UpdateDetectorVersionRequest
    ) extends FraudDetectorOp[UpdateDetectorVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDetectorVersionResponse] =
        visitor.updateDetectorVersion(request)
    }

    final case class UpdateDetectorVersionMetadataOp(
      request: UpdateDetectorVersionMetadataRequest
    ) extends FraudDetectorOp[UpdateDetectorVersionMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDetectorVersionMetadataResponse] =
        visitor.updateDetectorVersionMetadata(request)
    }

    final case class UpdateDetectorVersionStatusOp(
      request: UpdateDetectorVersionStatusRequest
    ) extends FraudDetectorOp[UpdateDetectorVersionStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDetectorVersionStatusResponse] =
        visitor.updateDetectorVersionStatus(request)
    }

    final case class UpdateModelOp(
      request: UpdateModelRequest
    ) extends FraudDetectorOp[UpdateModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateModelResponse] =
        visitor.updateModel(request)
    }

    final case class UpdateModelVersionOp(
      request: UpdateModelVersionRequest
    ) extends FraudDetectorOp[UpdateModelVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateModelVersionResponse] =
        visitor.updateModelVersion(request)
    }

    final case class UpdateModelVersionStatusOp(
      request: UpdateModelVersionStatusRequest
    ) extends FraudDetectorOp[UpdateModelVersionStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateModelVersionStatusResponse] =
        visitor.updateModelVersionStatus(request)
    }

    final case class UpdateRuleMetadataOp(
      request: UpdateRuleMetadataRequest
    ) extends FraudDetectorOp[UpdateRuleMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRuleMetadataResponse] =
        visitor.updateRuleMetadata(request)
    }

    final case class UpdateRuleVersionOp(
      request: UpdateRuleVersionRequest
    ) extends FraudDetectorOp[UpdateRuleVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRuleVersionResponse] =
        visitor.updateRuleVersion(request)
    }

    final case class UpdateVariableOp(
      request: UpdateVariableRequest
    ) extends FraudDetectorOp[UpdateVariableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateVariableResponse] =
        visitor.updateVariable(request)
    }
  }

  import FraudDetectorOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[FraudDetectorOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchCreateVariable(
    request: BatchCreateVariableRequest
  ): FraudDetectorIO[BatchCreateVariableResponse] =
    FF.liftF(BatchCreateVariableOp(request))

  def batchGetVariable(
    request: BatchGetVariableRequest
  ): FraudDetectorIO[BatchGetVariableResponse] =
    FF.liftF(BatchGetVariableOp(request))

  def cancelBatchPredictionJob(
    request: CancelBatchPredictionJobRequest
  ): FraudDetectorIO[CancelBatchPredictionJobResponse] =
    FF.liftF(CancelBatchPredictionJobOp(request))

  def createBatchPredictionJob(
    request: CreateBatchPredictionJobRequest
  ): FraudDetectorIO[CreateBatchPredictionJobResponse] =
    FF.liftF(CreateBatchPredictionJobOp(request))

  def createDetectorVersion(
    request: CreateDetectorVersionRequest
  ): FraudDetectorIO[CreateDetectorVersionResponse] =
    FF.liftF(CreateDetectorVersionOp(request))

  def createModel(
    request: CreateModelRequest
  ): FraudDetectorIO[CreateModelResponse] =
    FF.liftF(CreateModelOp(request))

  def createModelVersion(
    request: CreateModelVersionRequest
  ): FraudDetectorIO[CreateModelVersionResponse] =
    FF.liftF(CreateModelVersionOp(request))

  def createRule(
    request: CreateRuleRequest
  ): FraudDetectorIO[CreateRuleResponse] =
    FF.liftF(CreateRuleOp(request))

  def createVariable(
    request: CreateVariableRequest
  ): FraudDetectorIO[CreateVariableResponse] =
    FF.liftF(CreateVariableOp(request))

  def deleteBatchPredictionJob(
    request: DeleteBatchPredictionJobRequest
  ): FraudDetectorIO[DeleteBatchPredictionJobResponse] =
    FF.liftF(DeleteBatchPredictionJobOp(request))

  def deleteDetector(
    request: DeleteDetectorRequest
  ): FraudDetectorIO[DeleteDetectorResponse] =
    FF.liftF(DeleteDetectorOp(request))

  def deleteDetectorVersion(
    request: DeleteDetectorVersionRequest
  ): FraudDetectorIO[DeleteDetectorVersionResponse] =
    FF.liftF(DeleteDetectorVersionOp(request))

  def deleteEntityType(
    request: DeleteEntityTypeRequest
  ): FraudDetectorIO[DeleteEntityTypeResponse] =
    FF.liftF(DeleteEntityTypeOp(request))

  def deleteEvent(
    request: DeleteEventRequest
  ): FraudDetectorIO[DeleteEventResponse] =
    FF.liftF(DeleteEventOp(request))

  def deleteEventType(
    request: DeleteEventTypeRequest
  ): FraudDetectorIO[DeleteEventTypeResponse] =
    FF.liftF(DeleteEventTypeOp(request))

  def deleteExternalModel(
    request: DeleteExternalModelRequest
  ): FraudDetectorIO[DeleteExternalModelResponse] =
    FF.liftF(DeleteExternalModelOp(request))

  def deleteLabel(
    request: DeleteLabelRequest
  ): FraudDetectorIO[DeleteLabelResponse] =
    FF.liftF(DeleteLabelOp(request))

  def deleteModel(
    request: DeleteModelRequest
  ): FraudDetectorIO[DeleteModelResponse] =
    FF.liftF(DeleteModelOp(request))

  def deleteModelVersion(
    request: DeleteModelVersionRequest
  ): FraudDetectorIO[DeleteModelVersionResponse] =
    FF.liftF(DeleteModelVersionOp(request))

  def deleteOutcome(
    request: DeleteOutcomeRequest
  ): FraudDetectorIO[DeleteOutcomeResponse] =
    FF.liftF(DeleteOutcomeOp(request))

  def deleteRule(
    request: DeleteRuleRequest
  ): FraudDetectorIO[DeleteRuleResponse] =
    FF.liftF(DeleteRuleOp(request))

  def deleteVariable(
    request: DeleteVariableRequest
  ): FraudDetectorIO[DeleteVariableResponse] =
    FF.liftF(DeleteVariableOp(request))

  def describeDetector(
    request: DescribeDetectorRequest
  ): FraudDetectorIO[DescribeDetectorResponse] =
    FF.liftF(DescribeDetectorOp(request))

  def describeModelVersions(
    request: DescribeModelVersionsRequest
  ): FraudDetectorIO[DescribeModelVersionsResponse] =
    FF.liftF(DescribeModelVersionsOp(request))

  def getBatchPredictionJobs(
    request: GetBatchPredictionJobsRequest
  ): FraudDetectorIO[GetBatchPredictionJobsResponse] =
    FF.liftF(GetBatchPredictionJobsOp(request))

  def getDetectorVersion(
    request: GetDetectorVersionRequest
  ): FraudDetectorIO[GetDetectorVersionResponse] =
    FF.liftF(GetDetectorVersionOp(request))

  def getDetectors(
    request: GetDetectorsRequest
  ): FraudDetectorIO[GetDetectorsResponse] =
    FF.liftF(GetDetectorsOp(request))

  def getEntityTypes(
    request: GetEntityTypesRequest
  ): FraudDetectorIO[GetEntityTypesResponse] =
    FF.liftF(GetEntityTypesOp(request))

  def getEventPrediction(
    request: GetEventPredictionRequest
  ): FraudDetectorIO[GetEventPredictionResponse] =
    FF.liftF(GetEventPredictionOp(request))

  def getEventTypes(
    request: GetEventTypesRequest
  ): FraudDetectorIO[GetEventTypesResponse] =
    FF.liftF(GetEventTypesOp(request))

  def getExternalModels(
    request: GetExternalModelsRequest
  ): FraudDetectorIO[GetExternalModelsResponse] =
    FF.liftF(GetExternalModelsOp(request))

  def getKMSEncryptionKey(
    request: GetKmsEncryptionKeyRequest
  ): FraudDetectorIO[GetKmsEncryptionKeyResponse] =
    FF.liftF(GetKMSEncryptionKeyOp(request))

  def getLabels(
    request: GetLabelsRequest
  ): FraudDetectorIO[GetLabelsResponse] =
    FF.liftF(GetLabelsOp(request))

  def getModelVersion(
    request: GetModelVersionRequest
  ): FraudDetectorIO[GetModelVersionResponse] =
    FF.liftF(GetModelVersionOp(request))

  def getModels(
    request: GetModelsRequest
  ): FraudDetectorIO[GetModelsResponse] =
    FF.liftF(GetModelsOp(request))

  def getOutcomes(
    request: GetOutcomesRequest
  ): FraudDetectorIO[GetOutcomesResponse] =
    FF.liftF(GetOutcomesOp(request))

  def getRules(
    request: GetRulesRequest
  ): FraudDetectorIO[GetRulesResponse] =
    FF.liftF(GetRulesOp(request))

  def getVariables(
    request: GetVariablesRequest
  ): FraudDetectorIO[GetVariablesResponse] =
    FF.liftF(GetVariablesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): FraudDetectorIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putDetector(
    request: PutDetectorRequest
  ): FraudDetectorIO[PutDetectorResponse] =
    FF.liftF(PutDetectorOp(request))

  def putEntityType(
    request: PutEntityTypeRequest
  ): FraudDetectorIO[PutEntityTypeResponse] =
    FF.liftF(PutEntityTypeOp(request))

  def putEventType(
    request: PutEventTypeRequest
  ): FraudDetectorIO[PutEventTypeResponse] =
    FF.liftF(PutEventTypeOp(request))

  def putExternalModel(
    request: PutExternalModelRequest
  ): FraudDetectorIO[PutExternalModelResponse] =
    FF.liftF(PutExternalModelOp(request))

  def putKMSEncryptionKey(
    request: PutKmsEncryptionKeyRequest
  ): FraudDetectorIO[PutKmsEncryptionKeyResponse] =
    FF.liftF(PutKMSEncryptionKeyOp(request))

  def putLabel(
    request: PutLabelRequest
  ): FraudDetectorIO[PutLabelResponse] =
    FF.liftF(PutLabelOp(request))

  def putOutcome(
    request: PutOutcomeRequest
  ): FraudDetectorIO[PutOutcomeResponse] =
    FF.liftF(PutOutcomeOp(request))

  def tagResource(
    request: TagResourceRequest
  ): FraudDetectorIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): FraudDetectorIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateDetectorVersion(
    request: UpdateDetectorVersionRequest
  ): FraudDetectorIO[UpdateDetectorVersionResponse] =
    FF.liftF(UpdateDetectorVersionOp(request))

  def updateDetectorVersionMetadata(
    request: UpdateDetectorVersionMetadataRequest
  ): FraudDetectorIO[UpdateDetectorVersionMetadataResponse] =
    FF.liftF(UpdateDetectorVersionMetadataOp(request))

  def updateDetectorVersionStatus(
    request: UpdateDetectorVersionStatusRequest
  ): FraudDetectorIO[UpdateDetectorVersionStatusResponse] =
    FF.liftF(UpdateDetectorVersionStatusOp(request))

  def updateModel(
    request: UpdateModelRequest
  ): FraudDetectorIO[UpdateModelResponse] =
    FF.liftF(UpdateModelOp(request))

  def updateModelVersion(
    request: UpdateModelVersionRequest
  ): FraudDetectorIO[UpdateModelVersionResponse] =
    FF.liftF(UpdateModelVersionOp(request))

  def updateModelVersionStatus(
    request: UpdateModelVersionStatusRequest
  ): FraudDetectorIO[UpdateModelVersionStatusResponse] =
    FF.liftF(UpdateModelVersionStatusOp(request))

  def updateRuleMetadata(
    request: UpdateRuleMetadataRequest
  ): FraudDetectorIO[UpdateRuleMetadataResponse] =
    FF.liftF(UpdateRuleMetadataOp(request))

  def updateRuleVersion(
    request: UpdateRuleVersionRequest
  ): FraudDetectorIO[UpdateRuleVersionResponse] =
    FF.liftF(UpdateRuleVersionOp(request))

  def updateVariable(
    request: UpdateVariableRequest
  ): FraudDetectorIO[UpdateVariableResponse] =
    FF.liftF(UpdateVariableOp(request))
}
