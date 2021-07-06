package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.eventbridge.EventBridgeClient
import software.amazon.awssdk.services.eventbridge.model._


object eventbridge { module =>

  // Free monad over EventBridgeOp
  type EventBridgeIO[A] = FF[EventBridgeOp, A]

  sealed trait EventBridgeOp[A] {
    def visit[F[_]](visitor: EventBridgeOp.Visitor[F]): F[A]
  }

  object EventBridgeOp {
    // Given a EventBridgeClient we can embed a EventBridgeIO program in any algebra that understands embedding.
    implicit val EventBridgeOpEmbeddable: Embeddable[EventBridgeOp, EventBridgeClient] = new Embeddable[EventBridgeOp, EventBridgeClient] {
      def embed[A](client: EventBridgeClient, io: EventBridgeIO[A]): Embedded[A] = Embedded.EventBridge(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends EventBridgeOp.Visitor[Kleisli[M, EventBridgeClient, *]] {
        def activateEventSource(
          request: ActivateEventSourceRequest
        ): Kleisli[M, EventBridgeClient, ActivateEventSourceResponse] =
          primitive(_.activateEventSource(request))

        def cancelReplay(
          request: CancelReplayRequest
        ): Kleisli[M, EventBridgeClient, CancelReplayResponse] =
          primitive(_.cancelReplay(request))

        def createApiDestination(
          request: CreateApiDestinationRequest
        ): Kleisli[M, EventBridgeClient, CreateApiDestinationResponse] =
          primitive(_.createApiDestination(request))

        def createArchive(
          request: CreateArchiveRequest
        ): Kleisli[M, EventBridgeClient, CreateArchiveResponse] =
          primitive(_.createArchive(request))

        def createConnection(
          request: CreateConnectionRequest
        ): Kleisli[M, EventBridgeClient, CreateConnectionResponse] =
          primitive(_.createConnection(request))

        def createEventBus(
          request: CreateEventBusRequest
        ): Kleisli[M, EventBridgeClient, CreateEventBusResponse] =
          primitive(_.createEventBus(request))

        def createPartnerEventSource(
          request: CreatePartnerEventSourceRequest
        ): Kleisli[M, EventBridgeClient, CreatePartnerEventSourceResponse] =
          primitive(_.createPartnerEventSource(request))

        def deactivateEventSource(
          request: DeactivateEventSourceRequest
        ): Kleisli[M, EventBridgeClient, DeactivateEventSourceResponse] =
          primitive(_.deactivateEventSource(request))

        def deauthorizeConnection(
          request: DeauthorizeConnectionRequest
        ): Kleisli[M, EventBridgeClient, DeauthorizeConnectionResponse] =
          primitive(_.deauthorizeConnection(request))

        def deleteApiDestination(
          request: DeleteApiDestinationRequest
        ): Kleisli[M, EventBridgeClient, DeleteApiDestinationResponse] =
          primitive(_.deleteApiDestination(request))

        def deleteArchive(
          request: DeleteArchiveRequest
        ): Kleisli[M, EventBridgeClient, DeleteArchiveResponse] =
          primitive(_.deleteArchive(request))

        def deleteConnection(
          request: DeleteConnectionRequest
        ): Kleisli[M, EventBridgeClient, DeleteConnectionResponse] =
          primitive(_.deleteConnection(request))

        def deleteEventBus(
          request: DeleteEventBusRequest
        ): Kleisli[M, EventBridgeClient, DeleteEventBusResponse] =
          primitive(_.deleteEventBus(request))

        def deletePartnerEventSource(
          request: DeletePartnerEventSourceRequest
        ): Kleisli[M, EventBridgeClient, DeletePartnerEventSourceResponse] =
          primitive(_.deletePartnerEventSource(request))

        def deleteRule(
          request: DeleteRuleRequest
        ): Kleisli[M, EventBridgeClient, DeleteRuleResponse] =
          primitive(_.deleteRule(request))

        def describeApiDestination(
          request: DescribeApiDestinationRequest
        ): Kleisli[M, EventBridgeClient, DescribeApiDestinationResponse] =
          primitive(_.describeApiDestination(request))

        def describeArchive(
          request: DescribeArchiveRequest
        ): Kleisli[M, EventBridgeClient, DescribeArchiveResponse] =
          primitive(_.describeArchive(request))

        def describeConnection(
          request: DescribeConnectionRequest
        ): Kleisli[M, EventBridgeClient, DescribeConnectionResponse] =
          primitive(_.describeConnection(request))

        def describeEventBus(
          request: DescribeEventBusRequest
        ): Kleisli[M, EventBridgeClient, DescribeEventBusResponse] =
          primitive(_.describeEventBus(request))

        def describeEventSource(
          request: DescribeEventSourceRequest
        ): Kleisli[M, EventBridgeClient, DescribeEventSourceResponse] =
          primitive(_.describeEventSource(request))

        def describePartnerEventSource(
          request: DescribePartnerEventSourceRequest
        ): Kleisli[M, EventBridgeClient, DescribePartnerEventSourceResponse] =
          primitive(_.describePartnerEventSource(request))

        def describeReplay(
          request: DescribeReplayRequest
        ): Kleisli[M, EventBridgeClient, DescribeReplayResponse] =
          primitive(_.describeReplay(request))

        def describeRule(
          request: DescribeRuleRequest
        ): Kleisli[M, EventBridgeClient, DescribeRuleResponse] =
          primitive(_.describeRule(request))

        def disableRule(
          request: DisableRuleRequest
        ): Kleisli[M, EventBridgeClient, DisableRuleResponse] =
          primitive(_.disableRule(request))

        def enableRule(
          request: EnableRuleRequest
        ): Kleisli[M, EventBridgeClient, EnableRuleResponse] =
          primitive(_.enableRule(request))

        def listApiDestinations(
          request: ListApiDestinationsRequest
        ): Kleisli[M, EventBridgeClient, ListApiDestinationsResponse] =
          primitive(_.listApiDestinations(request))

        def listArchives(
          request: ListArchivesRequest
        ): Kleisli[M, EventBridgeClient, ListArchivesResponse] =
          primitive(_.listArchives(request))

        def listConnections(
          request: ListConnectionsRequest
        ): Kleisli[M, EventBridgeClient, ListConnectionsResponse] =
          primitive(_.listConnections(request))

        def listEventBuses(
          request: ListEventBusesRequest
        ): Kleisli[M, EventBridgeClient, ListEventBusesResponse] =
          primitive(_.listEventBuses(request))

        def listEventSources(
          request: ListEventSourcesRequest
        ): Kleisli[M, EventBridgeClient, ListEventSourcesResponse] =
          primitive(_.listEventSources(request))

        def listPartnerEventSourceAccounts(
          request: ListPartnerEventSourceAccountsRequest
        ): Kleisli[M, EventBridgeClient, ListPartnerEventSourceAccountsResponse] =
          primitive(_.listPartnerEventSourceAccounts(request))

        def listPartnerEventSources(
          request: ListPartnerEventSourcesRequest
        ): Kleisli[M, EventBridgeClient, ListPartnerEventSourcesResponse] =
          primitive(_.listPartnerEventSources(request))

        def listReplays(
          request: ListReplaysRequest
        ): Kleisli[M, EventBridgeClient, ListReplaysResponse] =
          primitive(_.listReplays(request))

        def listRuleNamesByTarget(
          request: ListRuleNamesByTargetRequest
        ): Kleisli[M, EventBridgeClient, ListRuleNamesByTargetResponse] =
          primitive(_.listRuleNamesByTarget(request))

        def listRules(
          request: ListRulesRequest
        ): Kleisli[M, EventBridgeClient, ListRulesResponse] =
          primitive(_.listRules(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, EventBridgeClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTargetsByRule(
          request: ListTargetsByRuleRequest
        ): Kleisli[M, EventBridgeClient, ListTargetsByRuleResponse] =
          primitive(_.listTargetsByRule(request))

        def putEvents(
          request: PutEventsRequest
        ): Kleisli[M, EventBridgeClient, PutEventsResponse] =
          primitive(_.putEvents(request))

        def putPartnerEvents(
          request: PutPartnerEventsRequest
        ): Kleisli[M, EventBridgeClient, PutPartnerEventsResponse] =
          primitive(_.putPartnerEvents(request))

        def putPermission(
          request: PutPermissionRequest
        ): Kleisli[M, EventBridgeClient, PutPermissionResponse] =
          primitive(_.putPermission(request))

        def putRule(
          request: PutRuleRequest
        ): Kleisli[M, EventBridgeClient, PutRuleResponse] =
          primitive(_.putRule(request))

        def putTargets(
          request: PutTargetsRequest
        ): Kleisli[M, EventBridgeClient, PutTargetsResponse] =
          primitive(_.putTargets(request))

        def removePermission(
          request: RemovePermissionRequest
        ): Kleisli[M, EventBridgeClient, RemovePermissionResponse] =
          primitive(_.removePermission(request))

        def removeTargets(
          request: RemoveTargetsRequest
        ): Kleisli[M, EventBridgeClient, RemoveTargetsResponse] =
          primitive(_.removeTargets(request))

        def startReplay(
          request: StartReplayRequest
        ): Kleisli[M, EventBridgeClient, StartReplayResponse] =
          primitive(_.startReplay(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, EventBridgeClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def testEventPattern(
          request: TestEventPatternRequest
        ): Kleisli[M, EventBridgeClient, TestEventPatternResponse] =
          primitive(_.testEventPattern(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, EventBridgeClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateApiDestination(
          request: UpdateApiDestinationRequest
        ): Kleisli[M, EventBridgeClient, UpdateApiDestinationResponse] =
          primitive(_.updateApiDestination(request))

        def updateArchive(
          request: UpdateArchiveRequest
        ): Kleisli[M, EventBridgeClient, UpdateArchiveResponse] =
          primitive(_.updateArchive(request))

        def updateConnection(
          request: UpdateConnectionRequest
        ): Kleisli[M, EventBridgeClient, UpdateConnectionResponse] =
          primitive(_.updateConnection(request))

        def primitive[A](
          f: EventBridgeClient => A
        ): Kleisli[M, EventBridgeClient, A]
      }
    }

    trait Visitor[F[_]] extends (EventBridgeOp ~> F) {
      final def apply[A](op: EventBridgeOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def activateEventSource(
        request: ActivateEventSourceRequest
      ): F[ActivateEventSourceResponse]

      def cancelReplay(
        request: CancelReplayRequest
      ): F[CancelReplayResponse]

      def createApiDestination(
        request: CreateApiDestinationRequest
      ): F[CreateApiDestinationResponse]

      def createArchive(
        request: CreateArchiveRequest
      ): F[CreateArchiveResponse]

      def createConnection(
        request: CreateConnectionRequest
      ): F[CreateConnectionResponse]

      def createEventBus(
        request: CreateEventBusRequest
      ): F[CreateEventBusResponse]

      def createPartnerEventSource(
        request: CreatePartnerEventSourceRequest
      ): F[CreatePartnerEventSourceResponse]

      def deactivateEventSource(
        request: DeactivateEventSourceRequest
      ): F[DeactivateEventSourceResponse]

      def deauthorizeConnection(
        request: DeauthorizeConnectionRequest
      ): F[DeauthorizeConnectionResponse]

      def deleteApiDestination(
        request: DeleteApiDestinationRequest
      ): F[DeleteApiDestinationResponse]

      def deleteArchive(
        request: DeleteArchiveRequest
      ): F[DeleteArchiveResponse]

      def deleteConnection(
        request: DeleteConnectionRequest
      ): F[DeleteConnectionResponse]

      def deleteEventBus(
        request: DeleteEventBusRequest
      ): F[DeleteEventBusResponse]

      def deletePartnerEventSource(
        request: DeletePartnerEventSourceRequest
      ): F[DeletePartnerEventSourceResponse]

      def deleteRule(
        request: DeleteRuleRequest
      ): F[DeleteRuleResponse]

      def describeApiDestination(
        request: DescribeApiDestinationRequest
      ): F[DescribeApiDestinationResponse]

      def describeArchive(
        request: DescribeArchiveRequest
      ): F[DescribeArchiveResponse]

      def describeConnection(
        request: DescribeConnectionRequest
      ): F[DescribeConnectionResponse]

      def describeEventBus(
        request: DescribeEventBusRequest
      ): F[DescribeEventBusResponse]

      def describeEventSource(
        request: DescribeEventSourceRequest
      ): F[DescribeEventSourceResponse]

      def describePartnerEventSource(
        request: DescribePartnerEventSourceRequest
      ): F[DescribePartnerEventSourceResponse]

      def describeReplay(
        request: DescribeReplayRequest
      ): F[DescribeReplayResponse]

      def describeRule(
        request: DescribeRuleRequest
      ): F[DescribeRuleResponse]

      def disableRule(
        request: DisableRuleRequest
      ): F[DisableRuleResponse]

      def enableRule(
        request: EnableRuleRequest
      ): F[EnableRuleResponse]

      def listApiDestinations(
        request: ListApiDestinationsRequest
      ): F[ListApiDestinationsResponse]

      def listArchives(
        request: ListArchivesRequest
      ): F[ListArchivesResponse]

      def listConnections(
        request: ListConnectionsRequest
      ): F[ListConnectionsResponse]

      def listEventBuses(
        request: ListEventBusesRequest
      ): F[ListEventBusesResponse]

      def listEventSources(
        request: ListEventSourcesRequest
      ): F[ListEventSourcesResponse]

      def listPartnerEventSourceAccounts(
        request: ListPartnerEventSourceAccountsRequest
      ): F[ListPartnerEventSourceAccountsResponse]

      def listPartnerEventSources(
        request: ListPartnerEventSourcesRequest
      ): F[ListPartnerEventSourcesResponse]

      def listReplays(
        request: ListReplaysRequest
      ): F[ListReplaysResponse]

      def listRuleNamesByTarget(
        request: ListRuleNamesByTargetRequest
      ): F[ListRuleNamesByTargetResponse]

      def listRules(
        request: ListRulesRequest
      ): F[ListRulesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTargetsByRule(
        request: ListTargetsByRuleRequest
      ): F[ListTargetsByRuleResponse]

      def putEvents(
        request: PutEventsRequest
      ): F[PutEventsResponse]

      def putPartnerEvents(
        request: PutPartnerEventsRequest
      ): F[PutPartnerEventsResponse]

      def putPermission(
        request: PutPermissionRequest
      ): F[PutPermissionResponse]

      def putRule(
        request: PutRuleRequest
      ): F[PutRuleResponse]

      def putTargets(
        request: PutTargetsRequest
      ): F[PutTargetsResponse]

      def removePermission(
        request: RemovePermissionRequest
      ): F[RemovePermissionResponse]

      def removeTargets(
        request: RemoveTargetsRequest
      ): F[RemoveTargetsResponse]

      def startReplay(
        request: StartReplayRequest
      ): F[StartReplayResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def testEventPattern(
        request: TestEventPatternRequest
      ): F[TestEventPatternResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateApiDestination(
        request: UpdateApiDestinationRequest
      ): F[UpdateApiDestinationResponse]

      def updateArchive(
        request: UpdateArchiveRequest
      ): F[UpdateArchiveResponse]

      def updateConnection(
        request: UpdateConnectionRequest
      ): F[UpdateConnectionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends EventBridgeOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class ActivateEventSourceOp(
      request: ActivateEventSourceRequest
    ) extends EventBridgeOp[ActivateEventSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ActivateEventSourceResponse] =
        visitor.activateEventSource(request)
    }

    final case class CancelReplayOp(
      request: CancelReplayRequest
    ) extends EventBridgeOp[CancelReplayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelReplayResponse] =
        visitor.cancelReplay(request)
    }

    final case class CreateApiDestinationOp(
      request: CreateApiDestinationRequest
    ) extends EventBridgeOp[CreateApiDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApiDestinationResponse] =
        visitor.createApiDestination(request)
    }

    final case class CreateArchiveOp(
      request: CreateArchiveRequest
    ) extends EventBridgeOp[CreateArchiveResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateArchiveResponse] =
        visitor.createArchive(request)
    }

    final case class CreateConnectionOp(
      request: CreateConnectionRequest
    ) extends EventBridgeOp[CreateConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConnectionResponse] =
        visitor.createConnection(request)
    }

    final case class CreateEventBusOp(
      request: CreateEventBusRequest
    ) extends EventBridgeOp[CreateEventBusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEventBusResponse] =
        visitor.createEventBus(request)
    }

    final case class CreatePartnerEventSourceOp(
      request: CreatePartnerEventSourceRequest
    ) extends EventBridgeOp[CreatePartnerEventSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePartnerEventSourceResponse] =
        visitor.createPartnerEventSource(request)
    }

    final case class DeactivateEventSourceOp(
      request: DeactivateEventSourceRequest
    ) extends EventBridgeOp[DeactivateEventSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeactivateEventSourceResponse] =
        visitor.deactivateEventSource(request)
    }

    final case class DeauthorizeConnectionOp(
      request: DeauthorizeConnectionRequest
    ) extends EventBridgeOp[DeauthorizeConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeauthorizeConnectionResponse] =
        visitor.deauthorizeConnection(request)
    }

    final case class DeleteApiDestinationOp(
      request: DeleteApiDestinationRequest
    ) extends EventBridgeOp[DeleteApiDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApiDestinationResponse] =
        visitor.deleteApiDestination(request)
    }

    final case class DeleteArchiveOp(
      request: DeleteArchiveRequest
    ) extends EventBridgeOp[DeleteArchiveResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteArchiveResponse] =
        visitor.deleteArchive(request)
    }

    final case class DeleteConnectionOp(
      request: DeleteConnectionRequest
    ) extends EventBridgeOp[DeleteConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConnectionResponse] =
        visitor.deleteConnection(request)
    }

    final case class DeleteEventBusOp(
      request: DeleteEventBusRequest
    ) extends EventBridgeOp[DeleteEventBusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEventBusResponse] =
        visitor.deleteEventBus(request)
    }

    final case class DeletePartnerEventSourceOp(
      request: DeletePartnerEventSourceRequest
    ) extends EventBridgeOp[DeletePartnerEventSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePartnerEventSourceResponse] =
        visitor.deletePartnerEventSource(request)
    }

    final case class DeleteRuleOp(
      request: DeleteRuleRequest
    ) extends EventBridgeOp[DeleteRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRuleResponse] =
        visitor.deleteRule(request)
    }

    final case class DescribeApiDestinationOp(
      request: DescribeApiDestinationRequest
    ) extends EventBridgeOp[DescribeApiDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeApiDestinationResponse] =
        visitor.describeApiDestination(request)
    }

    final case class DescribeArchiveOp(
      request: DescribeArchiveRequest
    ) extends EventBridgeOp[DescribeArchiveResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeArchiveResponse] =
        visitor.describeArchive(request)
    }

    final case class DescribeConnectionOp(
      request: DescribeConnectionRequest
    ) extends EventBridgeOp[DescribeConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConnectionResponse] =
        visitor.describeConnection(request)
    }

    final case class DescribeEventBusOp(
      request: DescribeEventBusRequest
    ) extends EventBridgeOp[DescribeEventBusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventBusResponse] =
        visitor.describeEventBus(request)
    }

    final case class DescribeEventSourceOp(
      request: DescribeEventSourceRequest
    ) extends EventBridgeOp[DescribeEventSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventSourceResponse] =
        visitor.describeEventSource(request)
    }

    final case class DescribePartnerEventSourceOp(
      request: DescribePartnerEventSourceRequest
    ) extends EventBridgeOp[DescribePartnerEventSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePartnerEventSourceResponse] =
        visitor.describePartnerEventSource(request)
    }

    final case class DescribeReplayOp(
      request: DescribeReplayRequest
    ) extends EventBridgeOp[DescribeReplayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReplayResponse] =
        visitor.describeReplay(request)
    }

    final case class DescribeRuleOp(
      request: DescribeRuleRequest
    ) extends EventBridgeOp[DescribeRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRuleResponse] =
        visitor.describeRule(request)
    }

    final case class DisableRuleOp(
      request: DisableRuleRequest
    ) extends EventBridgeOp[DisableRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableRuleResponse] =
        visitor.disableRule(request)
    }

    final case class EnableRuleOp(
      request: EnableRuleRequest
    ) extends EventBridgeOp[EnableRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableRuleResponse] =
        visitor.enableRule(request)
    }

    final case class ListApiDestinationsOp(
      request: ListApiDestinationsRequest
    ) extends EventBridgeOp[ListApiDestinationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListApiDestinationsResponse] =
        visitor.listApiDestinations(request)
    }

    final case class ListArchivesOp(
      request: ListArchivesRequest
    ) extends EventBridgeOp[ListArchivesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListArchivesResponse] =
        visitor.listArchives(request)
    }

    final case class ListConnectionsOp(
      request: ListConnectionsRequest
    ) extends EventBridgeOp[ListConnectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConnectionsResponse] =
        visitor.listConnections(request)
    }

    final case class ListEventBusesOp(
      request: ListEventBusesRequest
    ) extends EventBridgeOp[ListEventBusesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEventBusesResponse] =
        visitor.listEventBuses(request)
    }

    final case class ListEventSourcesOp(
      request: ListEventSourcesRequest
    ) extends EventBridgeOp[ListEventSourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEventSourcesResponse] =
        visitor.listEventSources(request)
    }

    final case class ListPartnerEventSourceAccountsOp(
      request: ListPartnerEventSourceAccountsRequest
    ) extends EventBridgeOp[ListPartnerEventSourceAccountsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPartnerEventSourceAccountsResponse] =
        visitor.listPartnerEventSourceAccounts(request)
    }

    final case class ListPartnerEventSourcesOp(
      request: ListPartnerEventSourcesRequest
    ) extends EventBridgeOp[ListPartnerEventSourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPartnerEventSourcesResponse] =
        visitor.listPartnerEventSources(request)
    }

    final case class ListReplaysOp(
      request: ListReplaysRequest
    ) extends EventBridgeOp[ListReplaysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListReplaysResponse] =
        visitor.listReplays(request)
    }

    final case class ListRuleNamesByTargetOp(
      request: ListRuleNamesByTargetRequest
    ) extends EventBridgeOp[ListRuleNamesByTargetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRuleNamesByTargetResponse] =
        visitor.listRuleNamesByTarget(request)
    }

    final case class ListRulesOp(
      request: ListRulesRequest
    ) extends EventBridgeOp[ListRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRulesResponse] =
        visitor.listRules(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends EventBridgeOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTargetsByRuleOp(
      request: ListTargetsByRuleRequest
    ) extends EventBridgeOp[ListTargetsByRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTargetsByRuleResponse] =
        visitor.listTargetsByRule(request)
    }

    final case class PutEventsOp(
      request: PutEventsRequest
    ) extends EventBridgeOp[PutEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutEventsResponse] =
        visitor.putEvents(request)
    }

    final case class PutPartnerEventsOp(
      request: PutPartnerEventsRequest
    ) extends EventBridgeOp[PutPartnerEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutPartnerEventsResponse] =
        visitor.putPartnerEvents(request)
    }

    final case class PutPermissionOp(
      request: PutPermissionRequest
    ) extends EventBridgeOp[PutPermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutPermissionResponse] =
        visitor.putPermission(request)
    }

    final case class PutRuleOp(
      request: PutRuleRequest
    ) extends EventBridgeOp[PutRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRuleResponse] =
        visitor.putRule(request)
    }

    final case class PutTargetsOp(
      request: PutTargetsRequest
    ) extends EventBridgeOp[PutTargetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutTargetsResponse] =
        visitor.putTargets(request)
    }

    final case class RemovePermissionOp(
      request: RemovePermissionRequest
    ) extends EventBridgeOp[RemovePermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemovePermissionResponse] =
        visitor.removePermission(request)
    }

    final case class RemoveTargetsOp(
      request: RemoveTargetsRequest
    ) extends EventBridgeOp[RemoveTargetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTargetsResponse] =
        visitor.removeTargets(request)
    }

    final case class StartReplayOp(
      request: StartReplayRequest
    ) extends EventBridgeOp[StartReplayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartReplayResponse] =
        visitor.startReplay(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends EventBridgeOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class TestEventPatternOp(
      request: TestEventPatternRequest
    ) extends EventBridgeOp[TestEventPatternResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TestEventPatternResponse] =
        visitor.testEventPattern(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends EventBridgeOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateApiDestinationOp(
      request: UpdateApiDestinationRequest
    ) extends EventBridgeOp[UpdateApiDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApiDestinationResponse] =
        visitor.updateApiDestination(request)
    }

    final case class UpdateArchiveOp(
      request: UpdateArchiveRequest
    ) extends EventBridgeOp[UpdateArchiveResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateArchiveResponse] =
        visitor.updateArchive(request)
    }

    final case class UpdateConnectionOp(
      request: UpdateConnectionRequest
    ) extends EventBridgeOp[UpdateConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConnectionResponse] =
        visitor.updateConnection(request)
    }
  }

  import EventBridgeOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[EventBridgeOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def activateEventSource(
    request: ActivateEventSourceRequest
  ): EventBridgeIO[ActivateEventSourceResponse] =
    FF.liftF(ActivateEventSourceOp(request))

  def cancelReplay(
    request: CancelReplayRequest
  ): EventBridgeIO[CancelReplayResponse] =
    FF.liftF(CancelReplayOp(request))

  def createApiDestination(
    request: CreateApiDestinationRequest
  ): EventBridgeIO[CreateApiDestinationResponse] =
    FF.liftF(CreateApiDestinationOp(request))

  def createArchive(
    request: CreateArchiveRequest
  ): EventBridgeIO[CreateArchiveResponse] =
    FF.liftF(CreateArchiveOp(request))

  def createConnection(
    request: CreateConnectionRequest
  ): EventBridgeIO[CreateConnectionResponse] =
    FF.liftF(CreateConnectionOp(request))

  def createEventBus(
    request: CreateEventBusRequest
  ): EventBridgeIO[CreateEventBusResponse] =
    FF.liftF(CreateEventBusOp(request))

  def createPartnerEventSource(
    request: CreatePartnerEventSourceRequest
  ): EventBridgeIO[CreatePartnerEventSourceResponse] =
    FF.liftF(CreatePartnerEventSourceOp(request))

  def deactivateEventSource(
    request: DeactivateEventSourceRequest
  ): EventBridgeIO[DeactivateEventSourceResponse] =
    FF.liftF(DeactivateEventSourceOp(request))

  def deauthorizeConnection(
    request: DeauthorizeConnectionRequest
  ): EventBridgeIO[DeauthorizeConnectionResponse] =
    FF.liftF(DeauthorizeConnectionOp(request))

  def deleteApiDestination(
    request: DeleteApiDestinationRequest
  ): EventBridgeIO[DeleteApiDestinationResponse] =
    FF.liftF(DeleteApiDestinationOp(request))

  def deleteArchive(
    request: DeleteArchiveRequest
  ): EventBridgeIO[DeleteArchiveResponse] =
    FF.liftF(DeleteArchiveOp(request))

  def deleteConnection(
    request: DeleteConnectionRequest
  ): EventBridgeIO[DeleteConnectionResponse] =
    FF.liftF(DeleteConnectionOp(request))

  def deleteEventBus(
    request: DeleteEventBusRequest
  ): EventBridgeIO[DeleteEventBusResponse] =
    FF.liftF(DeleteEventBusOp(request))

  def deletePartnerEventSource(
    request: DeletePartnerEventSourceRequest
  ): EventBridgeIO[DeletePartnerEventSourceResponse] =
    FF.liftF(DeletePartnerEventSourceOp(request))

  def deleteRule(
    request: DeleteRuleRequest
  ): EventBridgeIO[DeleteRuleResponse] =
    FF.liftF(DeleteRuleOp(request))

  def describeApiDestination(
    request: DescribeApiDestinationRequest
  ): EventBridgeIO[DescribeApiDestinationResponse] =
    FF.liftF(DescribeApiDestinationOp(request))

  def describeArchive(
    request: DescribeArchiveRequest
  ): EventBridgeIO[DescribeArchiveResponse] =
    FF.liftF(DescribeArchiveOp(request))

  def describeConnection(
    request: DescribeConnectionRequest
  ): EventBridgeIO[DescribeConnectionResponse] =
    FF.liftF(DescribeConnectionOp(request))

  def describeEventBus(
    request: DescribeEventBusRequest
  ): EventBridgeIO[DescribeEventBusResponse] =
    FF.liftF(DescribeEventBusOp(request))

  def describeEventSource(
    request: DescribeEventSourceRequest
  ): EventBridgeIO[DescribeEventSourceResponse] =
    FF.liftF(DescribeEventSourceOp(request))

  def describePartnerEventSource(
    request: DescribePartnerEventSourceRequest
  ): EventBridgeIO[DescribePartnerEventSourceResponse] =
    FF.liftF(DescribePartnerEventSourceOp(request))

  def describeReplay(
    request: DescribeReplayRequest
  ): EventBridgeIO[DescribeReplayResponse] =
    FF.liftF(DescribeReplayOp(request))

  def describeRule(
    request: DescribeRuleRequest
  ): EventBridgeIO[DescribeRuleResponse] =
    FF.liftF(DescribeRuleOp(request))

  def disableRule(
    request: DisableRuleRequest
  ): EventBridgeIO[DisableRuleResponse] =
    FF.liftF(DisableRuleOp(request))

  def enableRule(
    request: EnableRuleRequest
  ): EventBridgeIO[EnableRuleResponse] =
    FF.liftF(EnableRuleOp(request))

  def listApiDestinations(
    request: ListApiDestinationsRequest
  ): EventBridgeIO[ListApiDestinationsResponse] =
    FF.liftF(ListApiDestinationsOp(request))

  def listArchives(
    request: ListArchivesRequest
  ): EventBridgeIO[ListArchivesResponse] =
    FF.liftF(ListArchivesOp(request))

  def listConnections(
    request: ListConnectionsRequest
  ): EventBridgeIO[ListConnectionsResponse] =
    FF.liftF(ListConnectionsOp(request))

  def listEventBuses(
    request: ListEventBusesRequest
  ): EventBridgeIO[ListEventBusesResponse] =
    FF.liftF(ListEventBusesOp(request))

  def listEventSources(
    request: ListEventSourcesRequest
  ): EventBridgeIO[ListEventSourcesResponse] =
    FF.liftF(ListEventSourcesOp(request))

  def listPartnerEventSourceAccounts(
    request: ListPartnerEventSourceAccountsRequest
  ): EventBridgeIO[ListPartnerEventSourceAccountsResponse] =
    FF.liftF(ListPartnerEventSourceAccountsOp(request))

  def listPartnerEventSources(
    request: ListPartnerEventSourcesRequest
  ): EventBridgeIO[ListPartnerEventSourcesResponse] =
    FF.liftF(ListPartnerEventSourcesOp(request))

  def listReplays(
    request: ListReplaysRequest
  ): EventBridgeIO[ListReplaysResponse] =
    FF.liftF(ListReplaysOp(request))

  def listRuleNamesByTarget(
    request: ListRuleNamesByTargetRequest
  ): EventBridgeIO[ListRuleNamesByTargetResponse] =
    FF.liftF(ListRuleNamesByTargetOp(request))

  def listRules(
    request: ListRulesRequest
  ): EventBridgeIO[ListRulesResponse] =
    FF.liftF(ListRulesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): EventBridgeIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTargetsByRule(
    request: ListTargetsByRuleRequest
  ): EventBridgeIO[ListTargetsByRuleResponse] =
    FF.liftF(ListTargetsByRuleOp(request))

  def putEvents(
    request: PutEventsRequest
  ): EventBridgeIO[PutEventsResponse] =
    FF.liftF(PutEventsOp(request))

  def putPartnerEvents(
    request: PutPartnerEventsRequest
  ): EventBridgeIO[PutPartnerEventsResponse] =
    FF.liftF(PutPartnerEventsOp(request))

  def putPermission(
    request: PutPermissionRequest
  ): EventBridgeIO[PutPermissionResponse] =
    FF.liftF(PutPermissionOp(request))

  def putRule(
    request: PutRuleRequest
  ): EventBridgeIO[PutRuleResponse] =
    FF.liftF(PutRuleOp(request))

  def putTargets(
    request: PutTargetsRequest
  ): EventBridgeIO[PutTargetsResponse] =
    FF.liftF(PutTargetsOp(request))

  def removePermission(
    request: RemovePermissionRequest
  ): EventBridgeIO[RemovePermissionResponse] =
    FF.liftF(RemovePermissionOp(request))

  def removeTargets(
    request: RemoveTargetsRequest
  ): EventBridgeIO[RemoveTargetsResponse] =
    FF.liftF(RemoveTargetsOp(request))

  def startReplay(
    request: StartReplayRequest
  ): EventBridgeIO[StartReplayResponse] =
    FF.liftF(StartReplayOp(request))

  def tagResource(
    request: TagResourceRequest
  ): EventBridgeIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def testEventPattern(
    request: TestEventPatternRequest
  ): EventBridgeIO[TestEventPatternResponse] =
    FF.liftF(TestEventPatternOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): EventBridgeIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateApiDestination(
    request: UpdateApiDestinationRequest
  ): EventBridgeIO[UpdateApiDestinationResponse] =
    FF.liftF(UpdateApiDestinationOp(request))

  def updateArchive(
    request: UpdateArchiveRequest
  ): EventBridgeIO[UpdateArchiveResponse] =
    FF.liftF(UpdateArchiveOp(request))

  def updateConnection(
    request: UpdateConnectionRequest
  ): EventBridgeIO[UpdateConnectionResponse] =
    FF.liftF(UpdateConnectionOp(request))
}
