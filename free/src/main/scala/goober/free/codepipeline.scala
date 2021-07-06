package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.codepipeline.CodePipelineClient
import software.amazon.awssdk.services.codepipeline.model._


object codepipeline { module =>

  // Free monad over CodePipelineOp
  type CodePipelineIO[A] = FF[CodePipelineOp, A]

  sealed trait CodePipelineOp[A] {
    def visit[F[_]](visitor: CodePipelineOp.Visitor[F]): F[A]
  }

  object CodePipelineOp {
    // Given a CodePipelineClient we can embed a CodePipelineIO program in any algebra that understands embedding.
    implicit val CodePipelineOpEmbeddable: Embeddable[CodePipelineOp, CodePipelineClient] = new Embeddable[CodePipelineOp, CodePipelineClient] {
      def embed[A](client: CodePipelineClient, io: CodePipelineIO[A]): Embedded[A] = Embedded.CodePipeline(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CodePipelineOp.Visitor[Kleisli[M, CodePipelineClient, *]] {
        def acknowledgeJob(
          request: AcknowledgeJobRequest
        ): Kleisli[M, CodePipelineClient, AcknowledgeJobResponse] =
          primitive(_.acknowledgeJob(request))

        def acknowledgeThirdPartyJob(
          request: AcknowledgeThirdPartyJobRequest
        ): Kleisli[M, CodePipelineClient, AcknowledgeThirdPartyJobResponse] =
          primitive(_.acknowledgeThirdPartyJob(request))

        def createCustomActionType(
          request: CreateCustomActionTypeRequest
        ): Kleisli[M, CodePipelineClient, CreateCustomActionTypeResponse] =
          primitive(_.createCustomActionType(request))

        def createPipeline(
          request: CreatePipelineRequest
        ): Kleisli[M, CodePipelineClient, CreatePipelineResponse] =
          primitive(_.createPipeline(request))

        def deleteCustomActionType(
          request: DeleteCustomActionTypeRequest
        ): Kleisli[M, CodePipelineClient, DeleteCustomActionTypeResponse] =
          primitive(_.deleteCustomActionType(request))

        def deletePipeline(
          request: DeletePipelineRequest
        ): Kleisli[M, CodePipelineClient, DeletePipelineResponse] =
          primitive(_.deletePipeline(request))

        def deleteWebhook(
          request: DeleteWebhookRequest
        ): Kleisli[M, CodePipelineClient, DeleteWebhookResponse] =
          primitive(_.deleteWebhook(request))

        def deregisterWebhookWithThirdParty(
          request: DeregisterWebhookWithThirdPartyRequest
        ): Kleisli[M, CodePipelineClient, DeregisterWebhookWithThirdPartyResponse] =
          primitive(_.deregisterWebhookWithThirdParty(request))

        def disableStageTransition(
          request: DisableStageTransitionRequest
        ): Kleisli[M, CodePipelineClient, DisableStageTransitionResponse] =
          primitive(_.disableStageTransition(request))

        def enableStageTransition(
          request: EnableStageTransitionRequest
        ): Kleisli[M, CodePipelineClient, EnableStageTransitionResponse] =
          primitive(_.enableStageTransition(request))

        def getActionType(
          request: GetActionTypeRequest
        ): Kleisli[M, CodePipelineClient, GetActionTypeResponse] =
          primitive(_.getActionType(request))

        def getJobDetails(
          request: GetJobDetailsRequest
        ): Kleisli[M, CodePipelineClient, GetJobDetailsResponse] =
          primitive(_.getJobDetails(request))

        def getPipeline(
          request: GetPipelineRequest
        ): Kleisli[M, CodePipelineClient, GetPipelineResponse] =
          primitive(_.getPipeline(request))

        def getPipelineExecution(
          request: GetPipelineExecutionRequest
        ): Kleisli[M, CodePipelineClient, GetPipelineExecutionResponse] =
          primitive(_.getPipelineExecution(request))

        def getPipelineState(
          request: GetPipelineStateRequest
        ): Kleisli[M, CodePipelineClient, GetPipelineStateResponse] =
          primitive(_.getPipelineState(request))

        def getThirdPartyJobDetails(
          request: GetThirdPartyJobDetailsRequest
        ): Kleisli[M, CodePipelineClient, GetThirdPartyJobDetailsResponse] =
          primitive(_.getThirdPartyJobDetails(request))

        def listActionExecutions(
          request: ListActionExecutionsRequest
        ): Kleisli[M, CodePipelineClient, ListActionExecutionsResponse] =
          primitive(_.listActionExecutions(request))

        def listActionTypes(
          request: ListActionTypesRequest
        ): Kleisli[M, CodePipelineClient, ListActionTypesResponse] =
          primitive(_.listActionTypes(request))

        def listPipelineExecutions(
          request: ListPipelineExecutionsRequest
        ): Kleisli[M, CodePipelineClient, ListPipelineExecutionsResponse] =
          primitive(_.listPipelineExecutions(request))

        def listPipelines(
          request: ListPipelinesRequest
        ): Kleisli[M, CodePipelineClient, ListPipelinesResponse] =
          primitive(_.listPipelines(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, CodePipelineClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listWebhooks(
          request: ListWebhooksRequest
        ): Kleisli[M, CodePipelineClient, ListWebhooksResponse] =
          primitive(_.listWebhooks(request))

        def pollForJobs(
          request: PollForJobsRequest
        ): Kleisli[M, CodePipelineClient, PollForJobsResponse] =
          primitive(_.pollForJobs(request))

        def pollForThirdPartyJobs(
          request: PollForThirdPartyJobsRequest
        ): Kleisli[M, CodePipelineClient, PollForThirdPartyJobsResponse] =
          primitive(_.pollForThirdPartyJobs(request))

        def putActionRevision(
          request: PutActionRevisionRequest
        ): Kleisli[M, CodePipelineClient, PutActionRevisionResponse] =
          primitive(_.putActionRevision(request))

        def putApprovalResult(
          request: PutApprovalResultRequest
        ): Kleisli[M, CodePipelineClient, PutApprovalResultResponse] =
          primitive(_.putApprovalResult(request))

        def putJobFailureResult(
          request: PutJobFailureResultRequest
        ): Kleisli[M, CodePipelineClient, PutJobFailureResultResponse] =
          primitive(_.putJobFailureResult(request))

        def putJobSuccessResult(
          request: PutJobSuccessResultRequest
        ): Kleisli[M, CodePipelineClient, PutJobSuccessResultResponse] =
          primitive(_.putJobSuccessResult(request))

        def putThirdPartyJobFailureResult(
          request: PutThirdPartyJobFailureResultRequest
        ): Kleisli[M, CodePipelineClient, PutThirdPartyJobFailureResultResponse] =
          primitive(_.putThirdPartyJobFailureResult(request))

        def putThirdPartyJobSuccessResult(
          request: PutThirdPartyJobSuccessResultRequest
        ): Kleisli[M, CodePipelineClient, PutThirdPartyJobSuccessResultResponse] =
          primitive(_.putThirdPartyJobSuccessResult(request))

        def putWebhook(
          request: PutWebhookRequest
        ): Kleisli[M, CodePipelineClient, PutWebhookResponse] =
          primitive(_.putWebhook(request))

        def registerWebhookWithThirdParty(
          request: RegisterWebhookWithThirdPartyRequest
        ): Kleisli[M, CodePipelineClient, RegisterWebhookWithThirdPartyResponse] =
          primitive(_.registerWebhookWithThirdParty(request))

        def retryStageExecution(
          request: RetryStageExecutionRequest
        ): Kleisli[M, CodePipelineClient, RetryStageExecutionResponse] =
          primitive(_.retryStageExecution(request))

        def startPipelineExecution(
          request: StartPipelineExecutionRequest
        ): Kleisli[M, CodePipelineClient, StartPipelineExecutionResponse] =
          primitive(_.startPipelineExecution(request))

        def stopPipelineExecution(
          request: StopPipelineExecutionRequest
        ): Kleisli[M, CodePipelineClient, StopPipelineExecutionResponse] =
          primitive(_.stopPipelineExecution(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, CodePipelineClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, CodePipelineClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateActionType(
          request: UpdateActionTypeRequest
        ): Kleisli[M, CodePipelineClient, UpdateActionTypeResponse] =
          primitive(_.updateActionType(request))

        def updatePipeline(
          request: UpdatePipelineRequest
        ): Kleisli[M, CodePipelineClient, UpdatePipelineResponse] =
          primitive(_.updatePipeline(request))

        def primitive[A](
          f: CodePipelineClient => A
        ): Kleisli[M, CodePipelineClient, A]
      }
    }

    trait Visitor[F[_]] extends (CodePipelineOp ~> F) {
      final def apply[A](op: CodePipelineOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acknowledgeJob(
        request: AcknowledgeJobRequest
      ): F[AcknowledgeJobResponse]

      def acknowledgeThirdPartyJob(
        request: AcknowledgeThirdPartyJobRequest
      ): F[AcknowledgeThirdPartyJobResponse]

      def createCustomActionType(
        request: CreateCustomActionTypeRequest
      ): F[CreateCustomActionTypeResponse]

      def createPipeline(
        request: CreatePipelineRequest
      ): F[CreatePipelineResponse]

      def deleteCustomActionType(
        request: DeleteCustomActionTypeRequest
      ): F[DeleteCustomActionTypeResponse]

      def deletePipeline(
        request: DeletePipelineRequest
      ): F[DeletePipelineResponse]

      def deleteWebhook(
        request: DeleteWebhookRequest
      ): F[DeleteWebhookResponse]

      def deregisterWebhookWithThirdParty(
        request: DeregisterWebhookWithThirdPartyRequest
      ): F[DeregisterWebhookWithThirdPartyResponse]

      def disableStageTransition(
        request: DisableStageTransitionRequest
      ): F[DisableStageTransitionResponse]

      def enableStageTransition(
        request: EnableStageTransitionRequest
      ): F[EnableStageTransitionResponse]

      def getActionType(
        request: GetActionTypeRequest
      ): F[GetActionTypeResponse]

      def getJobDetails(
        request: GetJobDetailsRequest
      ): F[GetJobDetailsResponse]

      def getPipeline(
        request: GetPipelineRequest
      ): F[GetPipelineResponse]

      def getPipelineExecution(
        request: GetPipelineExecutionRequest
      ): F[GetPipelineExecutionResponse]

      def getPipelineState(
        request: GetPipelineStateRequest
      ): F[GetPipelineStateResponse]

      def getThirdPartyJobDetails(
        request: GetThirdPartyJobDetailsRequest
      ): F[GetThirdPartyJobDetailsResponse]

      def listActionExecutions(
        request: ListActionExecutionsRequest
      ): F[ListActionExecutionsResponse]

      def listActionTypes(
        request: ListActionTypesRequest
      ): F[ListActionTypesResponse]

      def listPipelineExecutions(
        request: ListPipelineExecutionsRequest
      ): F[ListPipelineExecutionsResponse]

      def listPipelines(
        request: ListPipelinesRequest
      ): F[ListPipelinesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listWebhooks(
        request: ListWebhooksRequest
      ): F[ListWebhooksResponse]

      def pollForJobs(
        request: PollForJobsRequest
      ): F[PollForJobsResponse]

      def pollForThirdPartyJobs(
        request: PollForThirdPartyJobsRequest
      ): F[PollForThirdPartyJobsResponse]

      def putActionRevision(
        request: PutActionRevisionRequest
      ): F[PutActionRevisionResponse]

      def putApprovalResult(
        request: PutApprovalResultRequest
      ): F[PutApprovalResultResponse]

      def putJobFailureResult(
        request: PutJobFailureResultRequest
      ): F[PutJobFailureResultResponse]

      def putJobSuccessResult(
        request: PutJobSuccessResultRequest
      ): F[PutJobSuccessResultResponse]

      def putThirdPartyJobFailureResult(
        request: PutThirdPartyJobFailureResultRequest
      ): F[PutThirdPartyJobFailureResultResponse]

      def putThirdPartyJobSuccessResult(
        request: PutThirdPartyJobSuccessResultRequest
      ): F[PutThirdPartyJobSuccessResultResponse]

      def putWebhook(
        request: PutWebhookRequest
      ): F[PutWebhookResponse]

      def registerWebhookWithThirdParty(
        request: RegisterWebhookWithThirdPartyRequest
      ): F[RegisterWebhookWithThirdPartyResponse]

      def retryStageExecution(
        request: RetryStageExecutionRequest
      ): F[RetryStageExecutionResponse]

      def startPipelineExecution(
        request: StartPipelineExecutionRequest
      ): F[StartPipelineExecutionResponse]

      def stopPipelineExecution(
        request: StopPipelineExecutionRequest
      ): F[StopPipelineExecutionResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateActionType(
        request: UpdateActionTypeRequest
      ): F[UpdateActionTypeResponse]

      def updatePipeline(
        request: UpdatePipelineRequest
      ): F[UpdatePipelineResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CodePipelineOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcknowledgeJobOp(
      request: AcknowledgeJobRequest
    ) extends CodePipelineOp[AcknowledgeJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcknowledgeJobResponse] =
        visitor.acknowledgeJob(request)
    }

    final case class AcknowledgeThirdPartyJobOp(
      request: AcknowledgeThirdPartyJobRequest
    ) extends CodePipelineOp[AcknowledgeThirdPartyJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcknowledgeThirdPartyJobResponse] =
        visitor.acknowledgeThirdPartyJob(request)
    }

    final case class CreateCustomActionTypeOp(
      request: CreateCustomActionTypeRequest
    ) extends CodePipelineOp[CreateCustomActionTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCustomActionTypeResponse] =
        visitor.createCustomActionType(request)
    }

    final case class CreatePipelineOp(
      request: CreatePipelineRequest
    ) extends CodePipelineOp[CreatePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePipelineResponse] =
        visitor.createPipeline(request)
    }

    final case class DeleteCustomActionTypeOp(
      request: DeleteCustomActionTypeRequest
    ) extends CodePipelineOp[DeleteCustomActionTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCustomActionTypeResponse] =
        visitor.deleteCustomActionType(request)
    }

    final case class DeletePipelineOp(
      request: DeletePipelineRequest
    ) extends CodePipelineOp[DeletePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePipelineResponse] =
        visitor.deletePipeline(request)
    }

    final case class DeleteWebhookOp(
      request: DeleteWebhookRequest
    ) extends CodePipelineOp[DeleteWebhookResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWebhookResponse] =
        visitor.deleteWebhook(request)
    }

    final case class DeregisterWebhookWithThirdPartyOp(
      request: DeregisterWebhookWithThirdPartyRequest
    ) extends CodePipelineOp[DeregisterWebhookWithThirdPartyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterWebhookWithThirdPartyResponse] =
        visitor.deregisterWebhookWithThirdParty(request)
    }

    final case class DisableStageTransitionOp(
      request: DisableStageTransitionRequest
    ) extends CodePipelineOp[DisableStageTransitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableStageTransitionResponse] =
        visitor.disableStageTransition(request)
    }

    final case class EnableStageTransitionOp(
      request: EnableStageTransitionRequest
    ) extends CodePipelineOp[EnableStageTransitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableStageTransitionResponse] =
        visitor.enableStageTransition(request)
    }

    final case class GetActionTypeOp(
      request: GetActionTypeRequest
    ) extends CodePipelineOp[GetActionTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetActionTypeResponse] =
        visitor.getActionType(request)
    }

    final case class GetJobDetailsOp(
      request: GetJobDetailsRequest
    ) extends CodePipelineOp[GetJobDetailsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJobDetailsResponse] =
        visitor.getJobDetails(request)
    }

    final case class GetPipelineOp(
      request: GetPipelineRequest
    ) extends CodePipelineOp[GetPipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPipelineResponse] =
        visitor.getPipeline(request)
    }

    final case class GetPipelineExecutionOp(
      request: GetPipelineExecutionRequest
    ) extends CodePipelineOp[GetPipelineExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPipelineExecutionResponse] =
        visitor.getPipelineExecution(request)
    }

    final case class GetPipelineStateOp(
      request: GetPipelineStateRequest
    ) extends CodePipelineOp[GetPipelineStateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPipelineStateResponse] =
        visitor.getPipelineState(request)
    }

    final case class GetThirdPartyJobDetailsOp(
      request: GetThirdPartyJobDetailsRequest
    ) extends CodePipelineOp[GetThirdPartyJobDetailsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetThirdPartyJobDetailsResponse] =
        visitor.getThirdPartyJobDetails(request)
    }

    final case class ListActionExecutionsOp(
      request: ListActionExecutionsRequest
    ) extends CodePipelineOp[ListActionExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListActionExecutionsResponse] =
        visitor.listActionExecutions(request)
    }

    final case class ListActionTypesOp(
      request: ListActionTypesRequest
    ) extends CodePipelineOp[ListActionTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListActionTypesResponse] =
        visitor.listActionTypes(request)
    }

    final case class ListPipelineExecutionsOp(
      request: ListPipelineExecutionsRequest
    ) extends CodePipelineOp[ListPipelineExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPipelineExecutionsResponse] =
        visitor.listPipelineExecutions(request)
    }

    final case class ListPipelinesOp(
      request: ListPipelinesRequest
    ) extends CodePipelineOp[ListPipelinesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPipelinesResponse] =
        visitor.listPipelines(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends CodePipelineOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListWebhooksOp(
      request: ListWebhooksRequest
    ) extends CodePipelineOp[ListWebhooksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWebhooksResponse] =
        visitor.listWebhooks(request)
    }

    final case class PollForJobsOp(
      request: PollForJobsRequest
    ) extends CodePipelineOp[PollForJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PollForJobsResponse] =
        visitor.pollForJobs(request)
    }

    final case class PollForThirdPartyJobsOp(
      request: PollForThirdPartyJobsRequest
    ) extends CodePipelineOp[PollForThirdPartyJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PollForThirdPartyJobsResponse] =
        visitor.pollForThirdPartyJobs(request)
    }

    final case class PutActionRevisionOp(
      request: PutActionRevisionRequest
    ) extends CodePipelineOp[PutActionRevisionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutActionRevisionResponse] =
        visitor.putActionRevision(request)
    }

    final case class PutApprovalResultOp(
      request: PutApprovalResultRequest
    ) extends CodePipelineOp[PutApprovalResultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutApprovalResultResponse] =
        visitor.putApprovalResult(request)
    }

    final case class PutJobFailureResultOp(
      request: PutJobFailureResultRequest
    ) extends CodePipelineOp[PutJobFailureResultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutJobFailureResultResponse] =
        visitor.putJobFailureResult(request)
    }

    final case class PutJobSuccessResultOp(
      request: PutJobSuccessResultRequest
    ) extends CodePipelineOp[PutJobSuccessResultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutJobSuccessResultResponse] =
        visitor.putJobSuccessResult(request)
    }

    final case class PutThirdPartyJobFailureResultOp(
      request: PutThirdPartyJobFailureResultRequest
    ) extends CodePipelineOp[PutThirdPartyJobFailureResultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutThirdPartyJobFailureResultResponse] =
        visitor.putThirdPartyJobFailureResult(request)
    }

    final case class PutThirdPartyJobSuccessResultOp(
      request: PutThirdPartyJobSuccessResultRequest
    ) extends CodePipelineOp[PutThirdPartyJobSuccessResultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutThirdPartyJobSuccessResultResponse] =
        visitor.putThirdPartyJobSuccessResult(request)
    }

    final case class PutWebhookOp(
      request: PutWebhookRequest
    ) extends CodePipelineOp[PutWebhookResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutWebhookResponse] =
        visitor.putWebhook(request)
    }

    final case class RegisterWebhookWithThirdPartyOp(
      request: RegisterWebhookWithThirdPartyRequest
    ) extends CodePipelineOp[RegisterWebhookWithThirdPartyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterWebhookWithThirdPartyResponse] =
        visitor.registerWebhookWithThirdParty(request)
    }

    final case class RetryStageExecutionOp(
      request: RetryStageExecutionRequest
    ) extends CodePipelineOp[RetryStageExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RetryStageExecutionResponse] =
        visitor.retryStageExecution(request)
    }

    final case class StartPipelineExecutionOp(
      request: StartPipelineExecutionRequest
    ) extends CodePipelineOp[StartPipelineExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartPipelineExecutionResponse] =
        visitor.startPipelineExecution(request)
    }

    final case class StopPipelineExecutionOp(
      request: StopPipelineExecutionRequest
    ) extends CodePipelineOp[StopPipelineExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopPipelineExecutionResponse] =
        visitor.stopPipelineExecution(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends CodePipelineOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends CodePipelineOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateActionTypeOp(
      request: UpdateActionTypeRequest
    ) extends CodePipelineOp[UpdateActionTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateActionTypeResponse] =
        visitor.updateActionType(request)
    }

    final case class UpdatePipelineOp(
      request: UpdatePipelineRequest
    ) extends CodePipelineOp[UpdatePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePipelineResponse] =
        visitor.updatePipeline(request)
    }
  }

  import CodePipelineOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CodePipelineOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acknowledgeJob(
    request: AcknowledgeJobRequest
  ): CodePipelineIO[AcknowledgeJobResponse] =
    FF.liftF(AcknowledgeJobOp(request))

  def acknowledgeThirdPartyJob(
    request: AcknowledgeThirdPartyJobRequest
  ): CodePipelineIO[AcknowledgeThirdPartyJobResponse] =
    FF.liftF(AcknowledgeThirdPartyJobOp(request))

  def createCustomActionType(
    request: CreateCustomActionTypeRequest
  ): CodePipelineIO[CreateCustomActionTypeResponse] =
    FF.liftF(CreateCustomActionTypeOp(request))

  def createPipeline(
    request: CreatePipelineRequest
  ): CodePipelineIO[CreatePipelineResponse] =
    FF.liftF(CreatePipelineOp(request))

  def deleteCustomActionType(
    request: DeleteCustomActionTypeRequest
  ): CodePipelineIO[DeleteCustomActionTypeResponse] =
    FF.liftF(DeleteCustomActionTypeOp(request))

  def deletePipeline(
    request: DeletePipelineRequest
  ): CodePipelineIO[DeletePipelineResponse] =
    FF.liftF(DeletePipelineOp(request))

  def deleteWebhook(
    request: DeleteWebhookRequest
  ): CodePipelineIO[DeleteWebhookResponse] =
    FF.liftF(DeleteWebhookOp(request))

  def deregisterWebhookWithThirdParty(
    request: DeregisterWebhookWithThirdPartyRequest
  ): CodePipelineIO[DeregisterWebhookWithThirdPartyResponse] =
    FF.liftF(DeregisterWebhookWithThirdPartyOp(request))

  def disableStageTransition(
    request: DisableStageTransitionRequest
  ): CodePipelineIO[DisableStageTransitionResponse] =
    FF.liftF(DisableStageTransitionOp(request))

  def enableStageTransition(
    request: EnableStageTransitionRequest
  ): CodePipelineIO[EnableStageTransitionResponse] =
    FF.liftF(EnableStageTransitionOp(request))

  def getActionType(
    request: GetActionTypeRequest
  ): CodePipelineIO[GetActionTypeResponse] =
    FF.liftF(GetActionTypeOp(request))

  def getJobDetails(
    request: GetJobDetailsRequest
  ): CodePipelineIO[GetJobDetailsResponse] =
    FF.liftF(GetJobDetailsOp(request))

  def getPipeline(
    request: GetPipelineRequest
  ): CodePipelineIO[GetPipelineResponse] =
    FF.liftF(GetPipelineOp(request))

  def getPipelineExecution(
    request: GetPipelineExecutionRequest
  ): CodePipelineIO[GetPipelineExecutionResponse] =
    FF.liftF(GetPipelineExecutionOp(request))

  def getPipelineState(
    request: GetPipelineStateRequest
  ): CodePipelineIO[GetPipelineStateResponse] =
    FF.liftF(GetPipelineStateOp(request))

  def getThirdPartyJobDetails(
    request: GetThirdPartyJobDetailsRequest
  ): CodePipelineIO[GetThirdPartyJobDetailsResponse] =
    FF.liftF(GetThirdPartyJobDetailsOp(request))

  def listActionExecutions(
    request: ListActionExecutionsRequest
  ): CodePipelineIO[ListActionExecutionsResponse] =
    FF.liftF(ListActionExecutionsOp(request))

  def listActionTypes(
    request: ListActionTypesRequest
  ): CodePipelineIO[ListActionTypesResponse] =
    FF.liftF(ListActionTypesOp(request))

  def listPipelineExecutions(
    request: ListPipelineExecutionsRequest
  ): CodePipelineIO[ListPipelineExecutionsResponse] =
    FF.liftF(ListPipelineExecutionsOp(request))

  def listPipelines(
    request: ListPipelinesRequest
  ): CodePipelineIO[ListPipelinesResponse] =
    FF.liftF(ListPipelinesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): CodePipelineIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listWebhooks(
    request: ListWebhooksRequest
  ): CodePipelineIO[ListWebhooksResponse] =
    FF.liftF(ListWebhooksOp(request))

  def pollForJobs(
    request: PollForJobsRequest
  ): CodePipelineIO[PollForJobsResponse] =
    FF.liftF(PollForJobsOp(request))

  def pollForThirdPartyJobs(
    request: PollForThirdPartyJobsRequest
  ): CodePipelineIO[PollForThirdPartyJobsResponse] =
    FF.liftF(PollForThirdPartyJobsOp(request))

  def putActionRevision(
    request: PutActionRevisionRequest
  ): CodePipelineIO[PutActionRevisionResponse] =
    FF.liftF(PutActionRevisionOp(request))

  def putApprovalResult(
    request: PutApprovalResultRequest
  ): CodePipelineIO[PutApprovalResultResponse] =
    FF.liftF(PutApprovalResultOp(request))

  def putJobFailureResult(
    request: PutJobFailureResultRequest
  ): CodePipelineIO[PutJobFailureResultResponse] =
    FF.liftF(PutJobFailureResultOp(request))

  def putJobSuccessResult(
    request: PutJobSuccessResultRequest
  ): CodePipelineIO[PutJobSuccessResultResponse] =
    FF.liftF(PutJobSuccessResultOp(request))

  def putThirdPartyJobFailureResult(
    request: PutThirdPartyJobFailureResultRequest
  ): CodePipelineIO[PutThirdPartyJobFailureResultResponse] =
    FF.liftF(PutThirdPartyJobFailureResultOp(request))

  def putThirdPartyJobSuccessResult(
    request: PutThirdPartyJobSuccessResultRequest
  ): CodePipelineIO[PutThirdPartyJobSuccessResultResponse] =
    FF.liftF(PutThirdPartyJobSuccessResultOp(request))

  def putWebhook(
    request: PutWebhookRequest
  ): CodePipelineIO[PutWebhookResponse] =
    FF.liftF(PutWebhookOp(request))

  def registerWebhookWithThirdParty(
    request: RegisterWebhookWithThirdPartyRequest
  ): CodePipelineIO[RegisterWebhookWithThirdPartyResponse] =
    FF.liftF(RegisterWebhookWithThirdPartyOp(request))

  def retryStageExecution(
    request: RetryStageExecutionRequest
  ): CodePipelineIO[RetryStageExecutionResponse] =
    FF.liftF(RetryStageExecutionOp(request))

  def startPipelineExecution(
    request: StartPipelineExecutionRequest
  ): CodePipelineIO[StartPipelineExecutionResponse] =
    FF.liftF(StartPipelineExecutionOp(request))

  def stopPipelineExecution(
    request: StopPipelineExecutionRequest
  ): CodePipelineIO[StopPipelineExecutionResponse] =
    FF.liftF(StopPipelineExecutionOp(request))

  def tagResource(
    request: TagResourceRequest
  ): CodePipelineIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): CodePipelineIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateActionType(
    request: UpdateActionTypeRequest
  ): CodePipelineIO[UpdateActionTypeResponse] =
    FF.liftF(UpdateActionTypeOp(request))

  def updatePipeline(
    request: UpdatePipelineRequest
  ): CodePipelineIO[UpdatePipelineResponse] =
    FF.liftF(UpdatePipelineOp(request))
}
