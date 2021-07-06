package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.ssmincidents.SsmIncidentsClient
import software.amazon.awssdk.services.ssmincidents.model._


object ssmincidents { module =>

  // Free monad over SsmIncidentsOp
  type SsmIncidentsIO[A] = FF[SsmIncidentsOp, A]

  sealed trait SsmIncidentsOp[A] {
    def visit[F[_]](visitor: SsmIncidentsOp.Visitor[F]): F[A]
  }

  object SsmIncidentsOp {
    // Given a SsmIncidentsClient we can embed a SsmIncidentsIO program in any algebra that understands embedding.
    implicit val SsmIncidentsOpEmbeddable: Embeddable[SsmIncidentsOp, SsmIncidentsClient] = new Embeddable[SsmIncidentsOp, SsmIncidentsClient] {
      def embed[A](client: SsmIncidentsClient, io: SsmIncidentsIO[A]): Embedded[A] = Embedded.SsmIncidents(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SsmIncidentsOp.Visitor[Kleisli[M, SsmIncidentsClient, *]] {
        def createReplicationSet(
          request: CreateReplicationSetRequest
        ): Kleisli[M, SsmIncidentsClient, CreateReplicationSetResponse] =
          primitive(_.createReplicationSet(request))

        def createResponsePlan(
          request: CreateResponsePlanRequest
        ): Kleisli[M, SsmIncidentsClient, CreateResponsePlanResponse] =
          primitive(_.createResponsePlan(request))

        def createTimelineEvent(
          request: CreateTimelineEventRequest
        ): Kleisli[M, SsmIncidentsClient, CreateTimelineEventResponse] =
          primitive(_.createTimelineEvent(request))

        def deleteIncidentRecord(
          request: DeleteIncidentRecordRequest
        ): Kleisli[M, SsmIncidentsClient, DeleteIncidentRecordResponse] =
          primitive(_.deleteIncidentRecord(request))

        def deleteReplicationSet(
          request: DeleteReplicationSetRequest
        ): Kleisli[M, SsmIncidentsClient, DeleteReplicationSetResponse] =
          primitive(_.deleteReplicationSet(request))

        def deleteResourcePolicy(
          request: DeleteResourcePolicyRequest
        ): Kleisli[M, SsmIncidentsClient, DeleteResourcePolicyResponse] =
          primitive(_.deleteResourcePolicy(request))

        def deleteResponsePlan(
          request: DeleteResponsePlanRequest
        ): Kleisli[M, SsmIncidentsClient, DeleteResponsePlanResponse] =
          primitive(_.deleteResponsePlan(request))

        def deleteTimelineEvent(
          request: DeleteTimelineEventRequest
        ): Kleisli[M, SsmIncidentsClient, DeleteTimelineEventResponse] =
          primitive(_.deleteTimelineEvent(request))

        def getIncidentRecord(
          request: GetIncidentRecordRequest
        ): Kleisli[M, SsmIncidentsClient, GetIncidentRecordResponse] =
          primitive(_.getIncidentRecord(request))

        def getReplicationSet(
          request: GetReplicationSetRequest
        ): Kleisli[M, SsmIncidentsClient, GetReplicationSetResponse] =
          primitive(_.getReplicationSet(request))

        def getResourcePolicies(
          request: GetResourcePoliciesRequest
        ): Kleisli[M, SsmIncidentsClient, GetResourcePoliciesResponse] =
          primitive(_.getResourcePolicies(request))

        def getResponsePlan(
          request: GetResponsePlanRequest
        ): Kleisli[M, SsmIncidentsClient, GetResponsePlanResponse] =
          primitive(_.getResponsePlan(request))

        def getTimelineEvent(
          request: GetTimelineEventRequest
        ): Kleisli[M, SsmIncidentsClient, GetTimelineEventResponse] =
          primitive(_.getTimelineEvent(request))

        def listIncidentRecords(
          request: ListIncidentRecordsRequest
        ): Kleisli[M, SsmIncidentsClient, ListIncidentRecordsResponse] =
          primitive(_.listIncidentRecords(request))

        def listRelatedItems(
          request: ListRelatedItemsRequest
        ): Kleisli[M, SsmIncidentsClient, ListRelatedItemsResponse] =
          primitive(_.listRelatedItems(request))

        def listReplicationSets(
          request: ListReplicationSetsRequest
        ): Kleisli[M, SsmIncidentsClient, ListReplicationSetsResponse] =
          primitive(_.listReplicationSets(request))

        def listResponsePlans(
          request: ListResponsePlansRequest
        ): Kleisli[M, SsmIncidentsClient, ListResponsePlansResponse] =
          primitive(_.listResponsePlans(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, SsmIncidentsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTimelineEvents(
          request: ListTimelineEventsRequest
        ): Kleisli[M, SsmIncidentsClient, ListTimelineEventsResponse] =
          primitive(_.listTimelineEvents(request))

        def putResourcePolicy(
          request: PutResourcePolicyRequest
        ): Kleisli[M, SsmIncidentsClient, PutResourcePolicyResponse] =
          primitive(_.putResourcePolicy(request))

        def startIncident(
          request: StartIncidentRequest
        ): Kleisli[M, SsmIncidentsClient, StartIncidentResponse] =
          primitive(_.startIncident(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, SsmIncidentsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, SsmIncidentsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateDeletionProtection(
          request: UpdateDeletionProtectionRequest
        ): Kleisli[M, SsmIncidentsClient, UpdateDeletionProtectionResponse] =
          primitive(_.updateDeletionProtection(request))

        def updateIncidentRecord(
          request: UpdateIncidentRecordRequest
        ): Kleisli[M, SsmIncidentsClient, UpdateIncidentRecordResponse] =
          primitive(_.updateIncidentRecord(request))

        def updateRelatedItems(
          request: UpdateRelatedItemsRequest
        ): Kleisli[M, SsmIncidentsClient, UpdateRelatedItemsResponse] =
          primitive(_.updateRelatedItems(request))

        def updateReplicationSet(
          request: UpdateReplicationSetRequest
        ): Kleisli[M, SsmIncidentsClient, UpdateReplicationSetResponse] =
          primitive(_.updateReplicationSet(request))

        def updateResponsePlan(
          request: UpdateResponsePlanRequest
        ): Kleisli[M, SsmIncidentsClient, UpdateResponsePlanResponse] =
          primitive(_.updateResponsePlan(request))

        def updateTimelineEvent(
          request: UpdateTimelineEventRequest
        ): Kleisli[M, SsmIncidentsClient, UpdateTimelineEventResponse] =
          primitive(_.updateTimelineEvent(request))

        def primitive[A](
          f: SsmIncidentsClient => A
        ): Kleisli[M, SsmIncidentsClient, A]
      }
    }

    trait Visitor[F[_]] extends (SsmIncidentsOp ~> F) {
      final def apply[A](op: SsmIncidentsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createReplicationSet(
        request: CreateReplicationSetRequest
      ): F[CreateReplicationSetResponse]

      def createResponsePlan(
        request: CreateResponsePlanRequest
      ): F[CreateResponsePlanResponse]

      def createTimelineEvent(
        request: CreateTimelineEventRequest
      ): F[CreateTimelineEventResponse]

      def deleteIncidentRecord(
        request: DeleteIncidentRecordRequest
      ): F[DeleteIncidentRecordResponse]

      def deleteReplicationSet(
        request: DeleteReplicationSetRequest
      ): F[DeleteReplicationSetResponse]

      def deleteResourcePolicy(
        request: DeleteResourcePolicyRequest
      ): F[DeleteResourcePolicyResponse]

      def deleteResponsePlan(
        request: DeleteResponsePlanRequest
      ): F[DeleteResponsePlanResponse]

      def deleteTimelineEvent(
        request: DeleteTimelineEventRequest
      ): F[DeleteTimelineEventResponse]

      def getIncidentRecord(
        request: GetIncidentRecordRequest
      ): F[GetIncidentRecordResponse]

      def getReplicationSet(
        request: GetReplicationSetRequest
      ): F[GetReplicationSetResponse]

      def getResourcePolicies(
        request: GetResourcePoliciesRequest
      ): F[GetResourcePoliciesResponse]

      def getResponsePlan(
        request: GetResponsePlanRequest
      ): F[GetResponsePlanResponse]

      def getTimelineEvent(
        request: GetTimelineEventRequest
      ): F[GetTimelineEventResponse]

      def listIncidentRecords(
        request: ListIncidentRecordsRequest
      ): F[ListIncidentRecordsResponse]

      def listRelatedItems(
        request: ListRelatedItemsRequest
      ): F[ListRelatedItemsResponse]

      def listReplicationSets(
        request: ListReplicationSetsRequest
      ): F[ListReplicationSetsResponse]

      def listResponsePlans(
        request: ListResponsePlansRequest
      ): F[ListResponsePlansResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTimelineEvents(
        request: ListTimelineEventsRequest
      ): F[ListTimelineEventsResponse]

      def putResourcePolicy(
        request: PutResourcePolicyRequest
      ): F[PutResourcePolicyResponse]

      def startIncident(
        request: StartIncidentRequest
      ): F[StartIncidentResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateDeletionProtection(
        request: UpdateDeletionProtectionRequest
      ): F[UpdateDeletionProtectionResponse]

      def updateIncidentRecord(
        request: UpdateIncidentRecordRequest
      ): F[UpdateIncidentRecordResponse]

      def updateRelatedItems(
        request: UpdateRelatedItemsRequest
      ): F[UpdateRelatedItemsResponse]

      def updateReplicationSet(
        request: UpdateReplicationSetRequest
      ): F[UpdateReplicationSetResponse]

      def updateResponsePlan(
        request: UpdateResponsePlanRequest
      ): F[UpdateResponsePlanResponse]

      def updateTimelineEvent(
        request: UpdateTimelineEventRequest
      ): F[UpdateTimelineEventResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SsmIncidentsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateReplicationSetOp(
      request: CreateReplicationSetRequest
    ) extends SsmIncidentsOp[CreateReplicationSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateReplicationSetResponse] =
        visitor.createReplicationSet(request)
    }

    final case class CreateResponsePlanOp(
      request: CreateResponsePlanRequest
    ) extends SsmIncidentsOp[CreateResponsePlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateResponsePlanResponse] =
        visitor.createResponsePlan(request)
    }

    final case class CreateTimelineEventOp(
      request: CreateTimelineEventRequest
    ) extends SsmIncidentsOp[CreateTimelineEventResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTimelineEventResponse] =
        visitor.createTimelineEvent(request)
    }

    final case class DeleteIncidentRecordOp(
      request: DeleteIncidentRecordRequest
    ) extends SsmIncidentsOp[DeleteIncidentRecordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIncidentRecordResponse] =
        visitor.deleteIncidentRecord(request)
    }

    final case class DeleteReplicationSetOp(
      request: DeleteReplicationSetRequest
    ) extends SsmIncidentsOp[DeleteReplicationSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteReplicationSetResponse] =
        visitor.deleteReplicationSet(request)
    }

    final case class DeleteResourcePolicyOp(
      request: DeleteResourcePolicyRequest
    ) extends SsmIncidentsOp[DeleteResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResourcePolicyResponse] =
        visitor.deleteResourcePolicy(request)
    }

    final case class DeleteResponsePlanOp(
      request: DeleteResponsePlanRequest
    ) extends SsmIncidentsOp[DeleteResponsePlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResponsePlanResponse] =
        visitor.deleteResponsePlan(request)
    }

    final case class DeleteTimelineEventOp(
      request: DeleteTimelineEventRequest
    ) extends SsmIncidentsOp[DeleteTimelineEventResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTimelineEventResponse] =
        visitor.deleteTimelineEvent(request)
    }

    final case class GetIncidentRecordOp(
      request: GetIncidentRecordRequest
    ) extends SsmIncidentsOp[GetIncidentRecordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIncidentRecordResponse] =
        visitor.getIncidentRecord(request)
    }

    final case class GetReplicationSetOp(
      request: GetReplicationSetRequest
    ) extends SsmIncidentsOp[GetReplicationSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetReplicationSetResponse] =
        visitor.getReplicationSet(request)
    }

    final case class GetResourcePoliciesOp(
      request: GetResourcePoliciesRequest
    ) extends SsmIncidentsOp[GetResourcePoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourcePoliciesResponse] =
        visitor.getResourcePolicies(request)
    }

    final case class GetResponsePlanOp(
      request: GetResponsePlanRequest
    ) extends SsmIncidentsOp[GetResponsePlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResponsePlanResponse] =
        visitor.getResponsePlan(request)
    }

    final case class GetTimelineEventOp(
      request: GetTimelineEventRequest
    ) extends SsmIncidentsOp[GetTimelineEventResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTimelineEventResponse] =
        visitor.getTimelineEvent(request)
    }

    final case class ListIncidentRecordsOp(
      request: ListIncidentRecordsRequest
    ) extends SsmIncidentsOp[ListIncidentRecordsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIncidentRecordsResponse] =
        visitor.listIncidentRecords(request)
    }

    final case class ListRelatedItemsOp(
      request: ListRelatedItemsRequest
    ) extends SsmIncidentsOp[ListRelatedItemsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRelatedItemsResponse] =
        visitor.listRelatedItems(request)
    }

    final case class ListReplicationSetsOp(
      request: ListReplicationSetsRequest
    ) extends SsmIncidentsOp[ListReplicationSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListReplicationSetsResponse] =
        visitor.listReplicationSets(request)
    }

    final case class ListResponsePlansOp(
      request: ListResponsePlansRequest
    ) extends SsmIncidentsOp[ListResponsePlansResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResponsePlansResponse] =
        visitor.listResponsePlans(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends SsmIncidentsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTimelineEventsOp(
      request: ListTimelineEventsRequest
    ) extends SsmIncidentsOp[ListTimelineEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTimelineEventsResponse] =
        visitor.listTimelineEvents(request)
    }

    final case class PutResourcePolicyOp(
      request: PutResourcePolicyRequest
    ) extends SsmIncidentsOp[PutResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutResourcePolicyResponse] =
        visitor.putResourcePolicy(request)
    }

    final case class StartIncidentOp(
      request: StartIncidentRequest
    ) extends SsmIncidentsOp[StartIncidentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartIncidentResponse] =
        visitor.startIncident(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends SsmIncidentsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends SsmIncidentsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateDeletionProtectionOp(
      request: UpdateDeletionProtectionRequest
    ) extends SsmIncidentsOp[UpdateDeletionProtectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDeletionProtectionResponse] =
        visitor.updateDeletionProtection(request)
    }

    final case class UpdateIncidentRecordOp(
      request: UpdateIncidentRecordRequest
    ) extends SsmIncidentsOp[UpdateIncidentRecordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateIncidentRecordResponse] =
        visitor.updateIncidentRecord(request)
    }

    final case class UpdateRelatedItemsOp(
      request: UpdateRelatedItemsRequest
    ) extends SsmIncidentsOp[UpdateRelatedItemsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRelatedItemsResponse] =
        visitor.updateRelatedItems(request)
    }

    final case class UpdateReplicationSetOp(
      request: UpdateReplicationSetRequest
    ) extends SsmIncidentsOp[UpdateReplicationSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateReplicationSetResponse] =
        visitor.updateReplicationSet(request)
    }

    final case class UpdateResponsePlanOp(
      request: UpdateResponsePlanRequest
    ) extends SsmIncidentsOp[UpdateResponsePlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateResponsePlanResponse] =
        visitor.updateResponsePlan(request)
    }

    final case class UpdateTimelineEventOp(
      request: UpdateTimelineEventRequest
    ) extends SsmIncidentsOp[UpdateTimelineEventResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTimelineEventResponse] =
        visitor.updateTimelineEvent(request)
    }
  }

  import SsmIncidentsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SsmIncidentsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createReplicationSet(
    request: CreateReplicationSetRequest
  ): SsmIncidentsIO[CreateReplicationSetResponse] =
    FF.liftF(CreateReplicationSetOp(request))

  def createResponsePlan(
    request: CreateResponsePlanRequest
  ): SsmIncidentsIO[CreateResponsePlanResponse] =
    FF.liftF(CreateResponsePlanOp(request))

  def createTimelineEvent(
    request: CreateTimelineEventRequest
  ): SsmIncidentsIO[CreateTimelineEventResponse] =
    FF.liftF(CreateTimelineEventOp(request))

  def deleteIncidentRecord(
    request: DeleteIncidentRecordRequest
  ): SsmIncidentsIO[DeleteIncidentRecordResponse] =
    FF.liftF(DeleteIncidentRecordOp(request))

  def deleteReplicationSet(
    request: DeleteReplicationSetRequest
  ): SsmIncidentsIO[DeleteReplicationSetResponse] =
    FF.liftF(DeleteReplicationSetOp(request))

  def deleteResourcePolicy(
    request: DeleteResourcePolicyRequest
  ): SsmIncidentsIO[DeleteResourcePolicyResponse] =
    FF.liftF(DeleteResourcePolicyOp(request))

  def deleteResponsePlan(
    request: DeleteResponsePlanRequest
  ): SsmIncidentsIO[DeleteResponsePlanResponse] =
    FF.liftF(DeleteResponsePlanOp(request))

  def deleteTimelineEvent(
    request: DeleteTimelineEventRequest
  ): SsmIncidentsIO[DeleteTimelineEventResponse] =
    FF.liftF(DeleteTimelineEventOp(request))

  def getIncidentRecord(
    request: GetIncidentRecordRequest
  ): SsmIncidentsIO[GetIncidentRecordResponse] =
    FF.liftF(GetIncidentRecordOp(request))

  def getReplicationSet(
    request: GetReplicationSetRequest
  ): SsmIncidentsIO[GetReplicationSetResponse] =
    FF.liftF(GetReplicationSetOp(request))

  def getResourcePolicies(
    request: GetResourcePoliciesRequest
  ): SsmIncidentsIO[GetResourcePoliciesResponse] =
    FF.liftF(GetResourcePoliciesOp(request))

  def getResponsePlan(
    request: GetResponsePlanRequest
  ): SsmIncidentsIO[GetResponsePlanResponse] =
    FF.liftF(GetResponsePlanOp(request))

  def getTimelineEvent(
    request: GetTimelineEventRequest
  ): SsmIncidentsIO[GetTimelineEventResponse] =
    FF.liftF(GetTimelineEventOp(request))

  def listIncidentRecords(
    request: ListIncidentRecordsRequest
  ): SsmIncidentsIO[ListIncidentRecordsResponse] =
    FF.liftF(ListIncidentRecordsOp(request))

  def listRelatedItems(
    request: ListRelatedItemsRequest
  ): SsmIncidentsIO[ListRelatedItemsResponse] =
    FF.liftF(ListRelatedItemsOp(request))

  def listReplicationSets(
    request: ListReplicationSetsRequest
  ): SsmIncidentsIO[ListReplicationSetsResponse] =
    FF.liftF(ListReplicationSetsOp(request))

  def listResponsePlans(
    request: ListResponsePlansRequest
  ): SsmIncidentsIO[ListResponsePlansResponse] =
    FF.liftF(ListResponsePlansOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): SsmIncidentsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTimelineEvents(
    request: ListTimelineEventsRequest
  ): SsmIncidentsIO[ListTimelineEventsResponse] =
    FF.liftF(ListTimelineEventsOp(request))

  def putResourcePolicy(
    request: PutResourcePolicyRequest
  ): SsmIncidentsIO[PutResourcePolicyResponse] =
    FF.liftF(PutResourcePolicyOp(request))

  def startIncident(
    request: StartIncidentRequest
  ): SsmIncidentsIO[StartIncidentResponse] =
    FF.liftF(StartIncidentOp(request))

  def tagResource(
    request: TagResourceRequest
  ): SsmIncidentsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): SsmIncidentsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateDeletionProtection(
    request: UpdateDeletionProtectionRequest
  ): SsmIncidentsIO[UpdateDeletionProtectionResponse] =
    FF.liftF(UpdateDeletionProtectionOp(request))

  def updateIncidentRecord(
    request: UpdateIncidentRecordRequest
  ): SsmIncidentsIO[UpdateIncidentRecordResponse] =
    FF.liftF(UpdateIncidentRecordOp(request))

  def updateRelatedItems(
    request: UpdateRelatedItemsRequest
  ): SsmIncidentsIO[UpdateRelatedItemsResponse] =
    FF.liftF(UpdateRelatedItemsOp(request))

  def updateReplicationSet(
    request: UpdateReplicationSetRequest
  ): SsmIncidentsIO[UpdateReplicationSetResponse] =
    FF.liftF(UpdateReplicationSetOp(request))

  def updateResponsePlan(
    request: UpdateResponsePlanRequest
  ): SsmIncidentsIO[UpdateResponsePlanResponse] =
    FF.liftF(UpdateResponsePlanOp(request))

  def updateTimelineEvent(
    request: UpdateTimelineEventRequest
  ): SsmIncidentsIO[UpdateTimelineEventResponse] =
    FF.liftF(UpdateTimelineEventOp(request))
}
