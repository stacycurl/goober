package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.swf.SwfClient
import software.amazon.awssdk.services.swf.model._


object swf { module =>

  // Free monad over SwfOp
  type SwfIO[A] = FF[SwfOp, A]

  sealed trait SwfOp[A] {
    def visit[F[_]](visitor: SwfOp.Visitor[F]): F[A]
  }

  object SwfOp {
    // Given a SwfClient we can embed a SwfIO program in any algebra that understands embedding.
    implicit val SwfOpEmbeddable: Embeddable[SwfOp, SwfClient] = new Embeddable[SwfOp, SwfClient] {
      def embed[A](client: SwfClient, io: SwfIO[A]): Embedded[A] = Embedded.Swf(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SwfOp.Visitor[Kleisli[M, SwfClient, *]] {
        def countClosedWorkflowExecutions(
          request: CountClosedWorkflowExecutionsRequest
        ): Kleisli[M, SwfClient, CountClosedWorkflowExecutionsResponse] =
          primitive(_.countClosedWorkflowExecutions(request))

        def countOpenWorkflowExecutions(
          request: CountOpenWorkflowExecutionsRequest
        ): Kleisli[M, SwfClient, CountOpenWorkflowExecutionsResponse] =
          primitive(_.countOpenWorkflowExecutions(request))

        def countPendingActivityTasks(
          request: CountPendingActivityTasksRequest
        ): Kleisli[M, SwfClient, CountPendingActivityTasksResponse] =
          primitive(_.countPendingActivityTasks(request))

        def countPendingDecisionTasks(
          request: CountPendingDecisionTasksRequest
        ): Kleisli[M, SwfClient, CountPendingDecisionTasksResponse] =
          primitive(_.countPendingDecisionTasks(request))

        def deprecateActivityType(
          request: DeprecateActivityTypeRequest
        ): Kleisli[M, SwfClient, DeprecateActivityTypeResponse] =
          primitive(_.deprecateActivityType(request))

        def deprecateDomain(
          request: DeprecateDomainRequest
        ): Kleisli[M, SwfClient, DeprecateDomainResponse] =
          primitive(_.deprecateDomain(request))

        def deprecateWorkflowType(
          request: DeprecateWorkflowTypeRequest
        ): Kleisli[M, SwfClient, DeprecateWorkflowTypeResponse] =
          primitive(_.deprecateWorkflowType(request))

        def describeActivityType(
          request: DescribeActivityTypeRequest
        ): Kleisli[M, SwfClient, DescribeActivityTypeResponse] =
          primitive(_.describeActivityType(request))

        def describeDomain(
          request: DescribeDomainRequest
        ): Kleisli[M, SwfClient, DescribeDomainResponse] =
          primitive(_.describeDomain(request))

        def describeWorkflowExecution(
          request: DescribeWorkflowExecutionRequest
        ): Kleisli[M, SwfClient, DescribeWorkflowExecutionResponse] =
          primitive(_.describeWorkflowExecution(request))

        def describeWorkflowType(
          request: DescribeWorkflowTypeRequest
        ): Kleisli[M, SwfClient, DescribeWorkflowTypeResponse] =
          primitive(_.describeWorkflowType(request))

        def getWorkflowExecutionHistory(
          request: GetWorkflowExecutionHistoryRequest
        ): Kleisli[M, SwfClient, GetWorkflowExecutionHistoryResponse] =
          primitive(_.getWorkflowExecutionHistory(request))

        def listActivityTypes(
          request: ListActivityTypesRequest
        ): Kleisli[M, SwfClient, ListActivityTypesResponse] =
          primitive(_.listActivityTypes(request))

        def listClosedWorkflowExecutions(
          request: ListClosedWorkflowExecutionsRequest
        ): Kleisli[M, SwfClient, ListClosedWorkflowExecutionsResponse] =
          primitive(_.listClosedWorkflowExecutions(request))

        def listDomains(
          request: ListDomainsRequest
        ): Kleisli[M, SwfClient, ListDomainsResponse] =
          primitive(_.listDomains(request))

        def listOpenWorkflowExecutions(
          request: ListOpenWorkflowExecutionsRequest
        ): Kleisli[M, SwfClient, ListOpenWorkflowExecutionsResponse] =
          primitive(_.listOpenWorkflowExecutions(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, SwfClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listWorkflowTypes(
          request: ListWorkflowTypesRequest
        ): Kleisli[M, SwfClient, ListWorkflowTypesResponse] =
          primitive(_.listWorkflowTypes(request))

        def pollForActivityTask(
          request: PollForActivityTaskRequest
        ): Kleisli[M, SwfClient, PollForActivityTaskResponse] =
          primitive(_.pollForActivityTask(request))

        def pollForDecisionTask(
          request: PollForDecisionTaskRequest
        ): Kleisli[M, SwfClient, PollForDecisionTaskResponse] =
          primitive(_.pollForDecisionTask(request))

        def recordActivityTaskHeartbeat(
          request: RecordActivityTaskHeartbeatRequest
        ): Kleisli[M, SwfClient, RecordActivityTaskHeartbeatResponse] =
          primitive(_.recordActivityTaskHeartbeat(request))

        def registerActivityType(
          request: RegisterActivityTypeRequest
        ): Kleisli[M, SwfClient, RegisterActivityTypeResponse] =
          primitive(_.registerActivityType(request))

        def registerDomain(
          request: RegisterDomainRequest
        ): Kleisli[M, SwfClient, RegisterDomainResponse] =
          primitive(_.registerDomain(request))

        def registerWorkflowType(
          request: RegisterWorkflowTypeRequest
        ): Kleisli[M, SwfClient, RegisterWorkflowTypeResponse] =
          primitive(_.registerWorkflowType(request))

        def requestCancelWorkflowExecution(
          request: RequestCancelWorkflowExecutionRequest
        ): Kleisli[M, SwfClient, RequestCancelWorkflowExecutionResponse] =
          primitive(_.requestCancelWorkflowExecution(request))

        def respondActivityTaskCanceled(
          request: RespondActivityTaskCanceledRequest
        ): Kleisli[M, SwfClient, RespondActivityTaskCanceledResponse] =
          primitive(_.respondActivityTaskCanceled(request))

        def respondActivityTaskCompleted(
          request: RespondActivityTaskCompletedRequest
        ): Kleisli[M, SwfClient, RespondActivityTaskCompletedResponse] =
          primitive(_.respondActivityTaskCompleted(request))

        def respondActivityTaskFailed(
          request: RespondActivityTaskFailedRequest
        ): Kleisli[M, SwfClient, RespondActivityTaskFailedResponse] =
          primitive(_.respondActivityTaskFailed(request))

        def respondDecisionTaskCompleted(
          request: RespondDecisionTaskCompletedRequest
        ): Kleisli[M, SwfClient, RespondDecisionTaskCompletedResponse] =
          primitive(_.respondDecisionTaskCompleted(request))

        def signalWorkflowExecution(
          request: SignalWorkflowExecutionRequest
        ): Kleisli[M, SwfClient, SignalWorkflowExecutionResponse] =
          primitive(_.signalWorkflowExecution(request))

        def startWorkflowExecution(
          request: StartWorkflowExecutionRequest
        ): Kleisli[M, SwfClient, StartWorkflowExecutionResponse] =
          primitive(_.startWorkflowExecution(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, SwfClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def terminateWorkflowExecution(
          request: TerminateWorkflowExecutionRequest
        ): Kleisli[M, SwfClient, TerminateWorkflowExecutionResponse] =
          primitive(_.terminateWorkflowExecution(request))

        def undeprecateActivityType(
          request: UndeprecateActivityTypeRequest
        ): Kleisli[M, SwfClient, UndeprecateActivityTypeResponse] =
          primitive(_.undeprecateActivityType(request))

        def undeprecateDomain(
          request: UndeprecateDomainRequest
        ): Kleisli[M, SwfClient, UndeprecateDomainResponse] =
          primitive(_.undeprecateDomain(request))

        def undeprecateWorkflowType(
          request: UndeprecateWorkflowTypeRequest
        ): Kleisli[M, SwfClient, UndeprecateWorkflowTypeResponse] =
          primitive(_.undeprecateWorkflowType(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, SwfClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: SwfClient => A
        ): Kleisli[M, SwfClient, A]
      }
    }

    trait Visitor[F[_]] extends (SwfOp ~> F) {
      final def apply[A](op: SwfOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def countClosedWorkflowExecutions(
        request: CountClosedWorkflowExecutionsRequest
      ): F[CountClosedWorkflowExecutionsResponse]

      def countOpenWorkflowExecutions(
        request: CountOpenWorkflowExecutionsRequest
      ): F[CountOpenWorkflowExecutionsResponse]

      def countPendingActivityTasks(
        request: CountPendingActivityTasksRequest
      ): F[CountPendingActivityTasksResponse]

      def countPendingDecisionTasks(
        request: CountPendingDecisionTasksRequest
      ): F[CountPendingDecisionTasksResponse]

      def deprecateActivityType(
        request: DeprecateActivityTypeRequest
      ): F[DeprecateActivityTypeResponse]

      def deprecateDomain(
        request: DeprecateDomainRequest
      ): F[DeprecateDomainResponse]

      def deprecateWorkflowType(
        request: DeprecateWorkflowTypeRequest
      ): F[DeprecateWorkflowTypeResponse]

      def describeActivityType(
        request: DescribeActivityTypeRequest
      ): F[DescribeActivityTypeResponse]

      def describeDomain(
        request: DescribeDomainRequest
      ): F[DescribeDomainResponse]

      def describeWorkflowExecution(
        request: DescribeWorkflowExecutionRequest
      ): F[DescribeWorkflowExecutionResponse]

      def describeWorkflowType(
        request: DescribeWorkflowTypeRequest
      ): F[DescribeWorkflowTypeResponse]

      def getWorkflowExecutionHistory(
        request: GetWorkflowExecutionHistoryRequest
      ): F[GetWorkflowExecutionHistoryResponse]

      def listActivityTypes(
        request: ListActivityTypesRequest
      ): F[ListActivityTypesResponse]

      def listClosedWorkflowExecutions(
        request: ListClosedWorkflowExecutionsRequest
      ): F[ListClosedWorkflowExecutionsResponse]

      def listDomains(
        request: ListDomainsRequest
      ): F[ListDomainsResponse]

      def listOpenWorkflowExecutions(
        request: ListOpenWorkflowExecutionsRequest
      ): F[ListOpenWorkflowExecutionsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listWorkflowTypes(
        request: ListWorkflowTypesRequest
      ): F[ListWorkflowTypesResponse]

      def pollForActivityTask(
        request: PollForActivityTaskRequest
      ): F[PollForActivityTaskResponse]

      def pollForDecisionTask(
        request: PollForDecisionTaskRequest
      ): F[PollForDecisionTaskResponse]

      def recordActivityTaskHeartbeat(
        request: RecordActivityTaskHeartbeatRequest
      ): F[RecordActivityTaskHeartbeatResponse]

      def registerActivityType(
        request: RegisterActivityTypeRequest
      ): F[RegisterActivityTypeResponse]

      def registerDomain(
        request: RegisterDomainRequest
      ): F[RegisterDomainResponse]

      def registerWorkflowType(
        request: RegisterWorkflowTypeRequest
      ): F[RegisterWorkflowTypeResponse]

      def requestCancelWorkflowExecution(
        request: RequestCancelWorkflowExecutionRequest
      ): F[RequestCancelWorkflowExecutionResponse]

      def respondActivityTaskCanceled(
        request: RespondActivityTaskCanceledRequest
      ): F[RespondActivityTaskCanceledResponse]

      def respondActivityTaskCompleted(
        request: RespondActivityTaskCompletedRequest
      ): F[RespondActivityTaskCompletedResponse]

      def respondActivityTaskFailed(
        request: RespondActivityTaskFailedRequest
      ): F[RespondActivityTaskFailedResponse]

      def respondDecisionTaskCompleted(
        request: RespondDecisionTaskCompletedRequest
      ): F[RespondDecisionTaskCompletedResponse]

      def signalWorkflowExecution(
        request: SignalWorkflowExecutionRequest
      ): F[SignalWorkflowExecutionResponse]

      def startWorkflowExecution(
        request: StartWorkflowExecutionRequest
      ): F[StartWorkflowExecutionResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def terminateWorkflowExecution(
        request: TerminateWorkflowExecutionRequest
      ): F[TerminateWorkflowExecutionResponse]

      def undeprecateActivityType(
        request: UndeprecateActivityTypeRequest
      ): F[UndeprecateActivityTypeResponse]

      def undeprecateDomain(
        request: UndeprecateDomainRequest
      ): F[UndeprecateDomainResponse]

      def undeprecateWorkflowType(
        request: UndeprecateWorkflowTypeRequest
      ): F[UndeprecateWorkflowTypeResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SwfOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CountClosedWorkflowExecutionsOp(
      request: CountClosedWorkflowExecutionsRequest
    ) extends SwfOp[CountClosedWorkflowExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CountClosedWorkflowExecutionsResponse] =
        visitor.countClosedWorkflowExecutions(request)
    }

    final case class CountOpenWorkflowExecutionsOp(
      request: CountOpenWorkflowExecutionsRequest
    ) extends SwfOp[CountOpenWorkflowExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CountOpenWorkflowExecutionsResponse] =
        visitor.countOpenWorkflowExecutions(request)
    }

    final case class CountPendingActivityTasksOp(
      request: CountPendingActivityTasksRequest
    ) extends SwfOp[CountPendingActivityTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CountPendingActivityTasksResponse] =
        visitor.countPendingActivityTasks(request)
    }

    final case class CountPendingDecisionTasksOp(
      request: CountPendingDecisionTasksRequest
    ) extends SwfOp[CountPendingDecisionTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CountPendingDecisionTasksResponse] =
        visitor.countPendingDecisionTasks(request)
    }

    final case class DeprecateActivityTypeOp(
      request: DeprecateActivityTypeRequest
    ) extends SwfOp[DeprecateActivityTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeprecateActivityTypeResponse] =
        visitor.deprecateActivityType(request)
    }

    final case class DeprecateDomainOp(
      request: DeprecateDomainRequest
    ) extends SwfOp[DeprecateDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeprecateDomainResponse] =
        visitor.deprecateDomain(request)
    }

    final case class DeprecateWorkflowTypeOp(
      request: DeprecateWorkflowTypeRequest
    ) extends SwfOp[DeprecateWorkflowTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeprecateWorkflowTypeResponse] =
        visitor.deprecateWorkflowType(request)
    }

    final case class DescribeActivityTypeOp(
      request: DescribeActivityTypeRequest
    ) extends SwfOp[DescribeActivityTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeActivityTypeResponse] =
        visitor.describeActivityType(request)
    }

    final case class DescribeDomainOp(
      request: DescribeDomainRequest
    ) extends SwfOp[DescribeDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDomainResponse] =
        visitor.describeDomain(request)
    }

    final case class DescribeWorkflowExecutionOp(
      request: DescribeWorkflowExecutionRequest
    ) extends SwfOp[DescribeWorkflowExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeWorkflowExecutionResponse] =
        visitor.describeWorkflowExecution(request)
    }

    final case class DescribeWorkflowTypeOp(
      request: DescribeWorkflowTypeRequest
    ) extends SwfOp[DescribeWorkflowTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeWorkflowTypeResponse] =
        visitor.describeWorkflowType(request)
    }

    final case class GetWorkflowExecutionHistoryOp(
      request: GetWorkflowExecutionHistoryRequest
    ) extends SwfOp[GetWorkflowExecutionHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWorkflowExecutionHistoryResponse] =
        visitor.getWorkflowExecutionHistory(request)
    }

    final case class ListActivityTypesOp(
      request: ListActivityTypesRequest
    ) extends SwfOp[ListActivityTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListActivityTypesResponse] =
        visitor.listActivityTypes(request)
    }

    final case class ListClosedWorkflowExecutionsOp(
      request: ListClosedWorkflowExecutionsRequest
    ) extends SwfOp[ListClosedWorkflowExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListClosedWorkflowExecutionsResponse] =
        visitor.listClosedWorkflowExecutions(request)
    }

    final case class ListDomainsOp(
      request: ListDomainsRequest
    ) extends SwfOp[ListDomainsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDomainsResponse] =
        visitor.listDomains(request)
    }

    final case class ListOpenWorkflowExecutionsOp(
      request: ListOpenWorkflowExecutionsRequest
    ) extends SwfOp[ListOpenWorkflowExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOpenWorkflowExecutionsResponse] =
        visitor.listOpenWorkflowExecutions(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends SwfOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListWorkflowTypesOp(
      request: ListWorkflowTypesRequest
    ) extends SwfOp[ListWorkflowTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWorkflowTypesResponse] =
        visitor.listWorkflowTypes(request)
    }

    final case class PollForActivityTaskOp(
      request: PollForActivityTaskRequest
    ) extends SwfOp[PollForActivityTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PollForActivityTaskResponse] =
        visitor.pollForActivityTask(request)
    }

    final case class PollForDecisionTaskOp(
      request: PollForDecisionTaskRequest
    ) extends SwfOp[PollForDecisionTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PollForDecisionTaskResponse] =
        visitor.pollForDecisionTask(request)
    }

    final case class RecordActivityTaskHeartbeatOp(
      request: RecordActivityTaskHeartbeatRequest
    ) extends SwfOp[RecordActivityTaskHeartbeatResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RecordActivityTaskHeartbeatResponse] =
        visitor.recordActivityTaskHeartbeat(request)
    }

    final case class RegisterActivityTypeOp(
      request: RegisterActivityTypeRequest
    ) extends SwfOp[RegisterActivityTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterActivityTypeResponse] =
        visitor.registerActivityType(request)
    }

    final case class RegisterDomainOp(
      request: RegisterDomainRequest
    ) extends SwfOp[RegisterDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterDomainResponse] =
        visitor.registerDomain(request)
    }

    final case class RegisterWorkflowTypeOp(
      request: RegisterWorkflowTypeRequest
    ) extends SwfOp[RegisterWorkflowTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterWorkflowTypeResponse] =
        visitor.registerWorkflowType(request)
    }

    final case class RequestCancelWorkflowExecutionOp(
      request: RequestCancelWorkflowExecutionRequest
    ) extends SwfOp[RequestCancelWorkflowExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RequestCancelWorkflowExecutionResponse] =
        visitor.requestCancelWorkflowExecution(request)
    }

    final case class RespondActivityTaskCanceledOp(
      request: RespondActivityTaskCanceledRequest
    ) extends SwfOp[RespondActivityTaskCanceledResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RespondActivityTaskCanceledResponse] =
        visitor.respondActivityTaskCanceled(request)
    }

    final case class RespondActivityTaskCompletedOp(
      request: RespondActivityTaskCompletedRequest
    ) extends SwfOp[RespondActivityTaskCompletedResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RespondActivityTaskCompletedResponse] =
        visitor.respondActivityTaskCompleted(request)
    }

    final case class RespondActivityTaskFailedOp(
      request: RespondActivityTaskFailedRequest
    ) extends SwfOp[RespondActivityTaskFailedResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RespondActivityTaskFailedResponse] =
        visitor.respondActivityTaskFailed(request)
    }

    final case class RespondDecisionTaskCompletedOp(
      request: RespondDecisionTaskCompletedRequest
    ) extends SwfOp[RespondDecisionTaskCompletedResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RespondDecisionTaskCompletedResponse] =
        visitor.respondDecisionTaskCompleted(request)
    }

    final case class SignalWorkflowExecutionOp(
      request: SignalWorkflowExecutionRequest
    ) extends SwfOp[SignalWorkflowExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SignalWorkflowExecutionResponse] =
        visitor.signalWorkflowExecution(request)
    }

    final case class StartWorkflowExecutionOp(
      request: StartWorkflowExecutionRequest
    ) extends SwfOp[StartWorkflowExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartWorkflowExecutionResponse] =
        visitor.startWorkflowExecution(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends SwfOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class TerminateWorkflowExecutionOp(
      request: TerminateWorkflowExecutionRequest
    ) extends SwfOp[TerminateWorkflowExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TerminateWorkflowExecutionResponse] =
        visitor.terminateWorkflowExecution(request)
    }

    final case class UndeprecateActivityTypeOp(
      request: UndeprecateActivityTypeRequest
    ) extends SwfOp[UndeprecateActivityTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UndeprecateActivityTypeResponse] =
        visitor.undeprecateActivityType(request)
    }

    final case class UndeprecateDomainOp(
      request: UndeprecateDomainRequest
    ) extends SwfOp[UndeprecateDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UndeprecateDomainResponse] =
        visitor.undeprecateDomain(request)
    }

    final case class UndeprecateWorkflowTypeOp(
      request: UndeprecateWorkflowTypeRequest
    ) extends SwfOp[UndeprecateWorkflowTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UndeprecateWorkflowTypeResponse] =
        visitor.undeprecateWorkflowType(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends SwfOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import SwfOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SwfOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def countClosedWorkflowExecutions(
    request: CountClosedWorkflowExecutionsRequest
  ): SwfIO[CountClosedWorkflowExecutionsResponse] =
    FF.liftF(CountClosedWorkflowExecutionsOp(request))

  def countOpenWorkflowExecutions(
    request: CountOpenWorkflowExecutionsRequest
  ): SwfIO[CountOpenWorkflowExecutionsResponse] =
    FF.liftF(CountOpenWorkflowExecutionsOp(request))

  def countPendingActivityTasks(
    request: CountPendingActivityTasksRequest
  ): SwfIO[CountPendingActivityTasksResponse] =
    FF.liftF(CountPendingActivityTasksOp(request))

  def countPendingDecisionTasks(
    request: CountPendingDecisionTasksRequest
  ): SwfIO[CountPendingDecisionTasksResponse] =
    FF.liftF(CountPendingDecisionTasksOp(request))

  def deprecateActivityType(
    request: DeprecateActivityTypeRequest
  ): SwfIO[DeprecateActivityTypeResponse] =
    FF.liftF(DeprecateActivityTypeOp(request))

  def deprecateDomain(
    request: DeprecateDomainRequest
  ): SwfIO[DeprecateDomainResponse] =
    FF.liftF(DeprecateDomainOp(request))

  def deprecateWorkflowType(
    request: DeprecateWorkflowTypeRequest
  ): SwfIO[DeprecateWorkflowTypeResponse] =
    FF.liftF(DeprecateWorkflowTypeOp(request))

  def describeActivityType(
    request: DescribeActivityTypeRequest
  ): SwfIO[DescribeActivityTypeResponse] =
    FF.liftF(DescribeActivityTypeOp(request))

  def describeDomain(
    request: DescribeDomainRequest
  ): SwfIO[DescribeDomainResponse] =
    FF.liftF(DescribeDomainOp(request))

  def describeWorkflowExecution(
    request: DescribeWorkflowExecutionRequest
  ): SwfIO[DescribeWorkflowExecutionResponse] =
    FF.liftF(DescribeWorkflowExecutionOp(request))

  def describeWorkflowType(
    request: DescribeWorkflowTypeRequest
  ): SwfIO[DescribeWorkflowTypeResponse] =
    FF.liftF(DescribeWorkflowTypeOp(request))

  def getWorkflowExecutionHistory(
    request: GetWorkflowExecutionHistoryRequest
  ): SwfIO[GetWorkflowExecutionHistoryResponse] =
    FF.liftF(GetWorkflowExecutionHistoryOp(request))

  def listActivityTypes(
    request: ListActivityTypesRequest
  ): SwfIO[ListActivityTypesResponse] =
    FF.liftF(ListActivityTypesOp(request))

  def listClosedWorkflowExecutions(
    request: ListClosedWorkflowExecutionsRequest
  ): SwfIO[ListClosedWorkflowExecutionsResponse] =
    FF.liftF(ListClosedWorkflowExecutionsOp(request))

  def listDomains(
    request: ListDomainsRequest
  ): SwfIO[ListDomainsResponse] =
    FF.liftF(ListDomainsOp(request))

  def listOpenWorkflowExecutions(
    request: ListOpenWorkflowExecutionsRequest
  ): SwfIO[ListOpenWorkflowExecutionsResponse] =
    FF.liftF(ListOpenWorkflowExecutionsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): SwfIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listWorkflowTypes(
    request: ListWorkflowTypesRequest
  ): SwfIO[ListWorkflowTypesResponse] =
    FF.liftF(ListWorkflowTypesOp(request))

  def pollForActivityTask(
    request: PollForActivityTaskRequest
  ): SwfIO[PollForActivityTaskResponse] =
    FF.liftF(PollForActivityTaskOp(request))

  def pollForDecisionTask(
    request: PollForDecisionTaskRequest
  ): SwfIO[PollForDecisionTaskResponse] =
    FF.liftF(PollForDecisionTaskOp(request))

  def recordActivityTaskHeartbeat(
    request: RecordActivityTaskHeartbeatRequest
  ): SwfIO[RecordActivityTaskHeartbeatResponse] =
    FF.liftF(RecordActivityTaskHeartbeatOp(request))

  def registerActivityType(
    request: RegisterActivityTypeRequest
  ): SwfIO[RegisterActivityTypeResponse] =
    FF.liftF(RegisterActivityTypeOp(request))

  def registerDomain(
    request: RegisterDomainRequest
  ): SwfIO[RegisterDomainResponse] =
    FF.liftF(RegisterDomainOp(request))

  def registerWorkflowType(
    request: RegisterWorkflowTypeRequest
  ): SwfIO[RegisterWorkflowTypeResponse] =
    FF.liftF(RegisterWorkflowTypeOp(request))

  def requestCancelWorkflowExecution(
    request: RequestCancelWorkflowExecutionRequest
  ): SwfIO[RequestCancelWorkflowExecutionResponse] =
    FF.liftF(RequestCancelWorkflowExecutionOp(request))

  def respondActivityTaskCanceled(
    request: RespondActivityTaskCanceledRequest
  ): SwfIO[RespondActivityTaskCanceledResponse] =
    FF.liftF(RespondActivityTaskCanceledOp(request))

  def respondActivityTaskCompleted(
    request: RespondActivityTaskCompletedRequest
  ): SwfIO[RespondActivityTaskCompletedResponse] =
    FF.liftF(RespondActivityTaskCompletedOp(request))

  def respondActivityTaskFailed(
    request: RespondActivityTaskFailedRequest
  ): SwfIO[RespondActivityTaskFailedResponse] =
    FF.liftF(RespondActivityTaskFailedOp(request))

  def respondDecisionTaskCompleted(
    request: RespondDecisionTaskCompletedRequest
  ): SwfIO[RespondDecisionTaskCompletedResponse] =
    FF.liftF(RespondDecisionTaskCompletedOp(request))

  def signalWorkflowExecution(
    request: SignalWorkflowExecutionRequest
  ): SwfIO[SignalWorkflowExecutionResponse] =
    FF.liftF(SignalWorkflowExecutionOp(request))

  def startWorkflowExecution(
    request: StartWorkflowExecutionRequest
  ): SwfIO[StartWorkflowExecutionResponse] =
    FF.liftF(StartWorkflowExecutionOp(request))

  def tagResource(
    request: TagResourceRequest
  ): SwfIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def terminateWorkflowExecution(
    request: TerminateWorkflowExecutionRequest
  ): SwfIO[TerminateWorkflowExecutionResponse] =
    FF.liftF(TerminateWorkflowExecutionOp(request))

  def undeprecateActivityType(
    request: UndeprecateActivityTypeRequest
  ): SwfIO[UndeprecateActivityTypeResponse] =
    FF.liftF(UndeprecateActivityTypeOp(request))

  def undeprecateDomain(
    request: UndeprecateDomainRequest
  ): SwfIO[UndeprecateDomainResponse] =
    FF.liftF(UndeprecateDomainOp(request))

  def undeprecateWorkflowType(
    request: UndeprecateWorkflowTypeRequest
  ): SwfIO[UndeprecateWorkflowTypeResponse] =
    FF.liftF(UndeprecateWorkflowTypeOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): SwfIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
