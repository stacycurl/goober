package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.shield.ShieldClient
import software.amazon.awssdk.services.shield.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object shield { module =>

  // Free monad over ShieldOp
  type ShieldIO[A] = FF[ShieldOp, A]

  sealed trait ShieldOp[A] {
    def visit[F[_]](visitor: ShieldOp.Visitor[F]): F[A]
  }

  object ShieldOp {
    // Given a ShieldClient we can embed a ShieldIO program in any algebra that understands embedding.
    implicit val ShieldOpEmbeddable: Embeddable[ShieldOp, ShieldClient] = new Embeddable[ShieldOp, ShieldClient] {
      def embed[A](client: ShieldClient, io: ShieldIO[A]): Embedded[A] = Embedded.Shield(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ShieldOp.Visitor[Kleisli[M, ShieldClient, *]] {
        def associateDRTLogBucket(
          request: AssociateDrtLogBucketRequest
        ): Kleisli[M, ShieldClient, AssociateDrtLogBucketResponse] =
          primitive(_.associateDRTLogBucket(request))

        def associateDRTRole(
          request: AssociateDrtRoleRequest
        ): Kleisli[M, ShieldClient, AssociateDrtRoleResponse] =
          primitive(_.associateDRTRole(request))

        def associateHealthCheck(
          request: AssociateHealthCheckRequest
        ): Kleisli[M, ShieldClient, AssociateHealthCheckResponse] =
          primitive(_.associateHealthCheck(request))

        def associateProactiveEngagementDetails(
          request: AssociateProactiveEngagementDetailsRequest
        ): Kleisli[M, ShieldClient, AssociateProactiveEngagementDetailsResponse] =
          primitive(_.associateProactiveEngagementDetails(request))

        def createProtection(
          request: CreateProtectionRequest
        ): Kleisli[M, ShieldClient, CreateProtectionResponse] =
          primitive(_.createProtection(request))

        def createProtectionGroup(
          request: CreateProtectionGroupRequest
        ): Kleisli[M, ShieldClient, CreateProtectionGroupResponse] =
          primitive(_.createProtectionGroup(request))

        def createSubscription(
          request: CreateSubscriptionRequest
        ): Kleisli[M, ShieldClient, CreateSubscriptionResponse] =
          primitive(_.createSubscription(request))

        def deleteProtection(
          request: DeleteProtectionRequest
        ): Kleisli[M, ShieldClient, DeleteProtectionResponse] =
          primitive(_.deleteProtection(request))

        def deleteProtectionGroup(
          request: DeleteProtectionGroupRequest
        ): Kleisli[M, ShieldClient, DeleteProtectionGroupResponse] =
          primitive(_.deleteProtectionGroup(request))

        def describeAttack(
          request: DescribeAttackRequest
        ): Kleisli[M, ShieldClient, DescribeAttackResponse] =
          primitive(_.describeAttack(request))

        def describeAttackStatistics(
          request: DescribeAttackStatisticsRequest
        ): Kleisli[M, ShieldClient, DescribeAttackStatisticsResponse] =
          primitive(_.describeAttackStatistics(request))

        def describeDRTAccess(
          request: DescribeDrtAccessRequest
        ): Kleisli[M, ShieldClient, DescribeDrtAccessResponse] =
          primitive(_.describeDRTAccess(request))

        def describeEmergencyContactSettings(
          request: DescribeEmergencyContactSettingsRequest
        ): Kleisli[M, ShieldClient, DescribeEmergencyContactSettingsResponse] =
          primitive(_.describeEmergencyContactSettings(request))

        def describeProtection(
          request: DescribeProtectionRequest
        ): Kleisli[M, ShieldClient, DescribeProtectionResponse] =
          primitive(_.describeProtection(request))

        def describeProtectionGroup(
          request: DescribeProtectionGroupRequest
        ): Kleisli[M, ShieldClient, DescribeProtectionGroupResponse] =
          primitive(_.describeProtectionGroup(request))

        def describeSubscription(
          request: DescribeSubscriptionRequest
        ): Kleisli[M, ShieldClient, DescribeSubscriptionResponse] =
          primitive(_.describeSubscription(request))

        def disableProactiveEngagement(
          request: DisableProactiveEngagementRequest
        ): Kleisli[M, ShieldClient, DisableProactiveEngagementResponse] =
          primitive(_.disableProactiveEngagement(request))

        def disassociateDRTLogBucket(
          request: DisassociateDrtLogBucketRequest
        ): Kleisli[M, ShieldClient, DisassociateDrtLogBucketResponse] =
          primitive(_.disassociateDRTLogBucket(request))

        def disassociateDRTRole(
          request: DisassociateDrtRoleRequest
        ): Kleisli[M, ShieldClient, DisassociateDrtRoleResponse] =
          primitive(_.disassociateDRTRole(request))

        def disassociateHealthCheck(
          request: DisassociateHealthCheckRequest
        ): Kleisli[M, ShieldClient, DisassociateHealthCheckResponse] =
          primitive(_.disassociateHealthCheck(request))

        def enableProactiveEngagement(
          request: EnableProactiveEngagementRequest
        ): Kleisli[M, ShieldClient, EnableProactiveEngagementResponse] =
          primitive(_.enableProactiveEngagement(request))

        def getSubscriptionState(
          request: GetSubscriptionStateRequest
        ): Kleisli[M, ShieldClient, GetSubscriptionStateResponse] =
          primitive(_.getSubscriptionState(request))

        def listAttacks(
          request: ListAttacksRequest
        ): Kleisli[M, ShieldClient, ListAttacksResponse] =
          primitive(_.listAttacks(request))

        def listProtectionGroups(
          request: ListProtectionGroupsRequest
        ): Kleisli[M, ShieldClient, ListProtectionGroupsResponse] =
          primitive(_.listProtectionGroups(request))

        def listProtections(
          request: ListProtectionsRequest
        ): Kleisli[M, ShieldClient, ListProtectionsResponse] =
          primitive(_.listProtections(request))

        def listResourcesInProtectionGroup(
          request: ListResourcesInProtectionGroupRequest
        ): Kleisli[M, ShieldClient, ListResourcesInProtectionGroupResponse] =
          primitive(_.listResourcesInProtectionGroup(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, ShieldClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, ShieldClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, ShieldClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateEmergencyContactSettings(
          request: UpdateEmergencyContactSettingsRequest
        ): Kleisli[M, ShieldClient, UpdateEmergencyContactSettingsResponse] =
          primitive(_.updateEmergencyContactSettings(request))

        def updateProtectionGroup(
          request: UpdateProtectionGroupRequest
        ): Kleisli[M, ShieldClient, UpdateProtectionGroupResponse] =
          primitive(_.updateProtectionGroup(request))

        def updateSubscription(
          request: UpdateSubscriptionRequest
        ): Kleisli[M, ShieldClient, UpdateSubscriptionResponse] =
          primitive(_.updateSubscription(request))

        def primitive[A](
          f: ShieldClient => A
        ): Kleisli[M, ShieldClient, A]
      }
    }

    trait Visitor[F[_]] extends (ShieldOp ~> F) {
      final def apply[A](op: ShieldOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateDRTLogBucket(
        request: AssociateDrtLogBucketRequest
      ): F[AssociateDrtLogBucketResponse]

      def associateDRTRole(
        request: AssociateDrtRoleRequest
      ): F[AssociateDrtRoleResponse]

      def associateHealthCheck(
        request: AssociateHealthCheckRequest
      ): F[AssociateHealthCheckResponse]

      def associateProactiveEngagementDetails(
        request: AssociateProactiveEngagementDetailsRequest
      ): F[AssociateProactiveEngagementDetailsResponse]

      def createProtection(
        request: CreateProtectionRequest
      ): F[CreateProtectionResponse]

      def createProtectionGroup(
        request: CreateProtectionGroupRequest
      ): F[CreateProtectionGroupResponse]

      def createSubscription(
        request: CreateSubscriptionRequest
      ): F[CreateSubscriptionResponse]

      def deleteProtection(
        request: DeleteProtectionRequest
      ): F[DeleteProtectionResponse]

      def deleteProtectionGroup(
        request: DeleteProtectionGroupRequest
      ): F[DeleteProtectionGroupResponse]

      def describeAttack(
        request: DescribeAttackRequest
      ): F[DescribeAttackResponse]

      def describeAttackStatistics(
        request: DescribeAttackStatisticsRequest
      ): F[DescribeAttackStatisticsResponse]

      def describeDRTAccess(
        request: DescribeDrtAccessRequest
      ): F[DescribeDrtAccessResponse]

      def describeEmergencyContactSettings(
        request: DescribeEmergencyContactSettingsRequest
      ): F[DescribeEmergencyContactSettingsResponse]

      def describeProtection(
        request: DescribeProtectionRequest
      ): F[DescribeProtectionResponse]

      def describeProtectionGroup(
        request: DescribeProtectionGroupRequest
      ): F[DescribeProtectionGroupResponse]

      def describeSubscription(
        request: DescribeSubscriptionRequest
      ): F[DescribeSubscriptionResponse]

      def disableProactiveEngagement(
        request: DisableProactiveEngagementRequest
      ): F[DisableProactiveEngagementResponse]

      def disassociateDRTLogBucket(
        request: DisassociateDrtLogBucketRequest
      ): F[DisassociateDrtLogBucketResponse]

      def disassociateDRTRole(
        request: DisassociateDrtRoleRequest
      ): F[DisassociateDrtRoleResponse]

      def disassociateHealthCheck(
        request: DisassociateHealthCheckRequest
      ): F[DisassociateHealthCheckResponse]

      def enableProactiveEngagement(
        request: EnableProactiveEngagementRequest
      ): F[EnableProactiveEngagementResponse]

      def getSubscriptionState(
        request: GetSubscriptionStateRequest
      ): F[GetSubscriptionStateResponse]

      def listAttacks(
        request: ListAttacksRequest
      ): F[ListAttacksResponse]

      def listProtectionGroups(
        request: ListProtectionGroupsRequest
      ): F[ListProtectionGroupsResponse]

      def listProtections(
        request: ListProtectionsRequest
      ): F[ListProtectionsResponse]

      def listResourcesInProtectionGroup(
        request: ListResourcesInProtectionGroupRequest
      ): F[ListResourcesInProtectionGroupResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateEmergencyContactSettings(
        request: UpdateEmergencyContactSettingsRequest
      ): F[UpdateEmergencyContactSettingsResponse]

      def updateProtectionGroup(
        request: UpdateProtectionGroupRequest
      ): F[UpdateProtectionGroupResponse]

      def updateSubscription(
        request: UpdateSubscriptionRequest
      ): F[UpdateSubscriptionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ShieldOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateDRTLogBucketOp(
      request: AssociateDrtLogBucketRequest
    ) extends ShieldOp[AssociateDrtLogBucketResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateDrtLogBucketResponse] =
        visitor.associateDRTLogBucket(request)
    }

    final case class AssociateDRTRoleOp(
      request: AssociateDrtRoleRequest
    ) extends ShieldOp[AssociateDrtRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateDrtRoleResponse] =
        visitor.associateDRTRole(request)
    }

    final case class AssociateHealthCheckOp(
      request: AssociateHealthCheckRequest
    ) extends ShieldOp[AssociateHealthCheckResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateHealthCheckResponse] =
        visitor.associateHealthCheck(request)
    }

    final case class AssociateProactiveEngagementDetailsOp(
      request: AssociateProactiveEngagementDetailsRequest
    ) extends ShieldOp[AssociateProactiveEngagementDetailsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateProactiveEngagementDetailsResponse] =
        visitor.associateProactiveEngagementDetails(request)
    }

    final case class CreateProtectionOp(
      request: CreateProtectionRequest
    ) extends ShieldOp[CreateProtectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProtectionResponse] =
        visitor.createProtection(request)
    }

    final case class CreateProtectionGroupOp(
      request: CreateProtectionGroupRequest
    ) extends ShieldOp[CreateProtectionGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProtectionGroupResponse] =
        visitor.createProtectionGroup(request)
    }

    final case class CreateSubscriptionOp(
      request: CreateSubscriptionRequest
    ) extends ShieldOp[CreateSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSubscriptionResponse] =
        visitor.createSubscription(request)
    }

    final case class DeleteProtectionOp(
      request: DeleteProtectionRequest
    ) extends ShieldOp[DeleteProtectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProtectionResponse] =
        visitor.deleteProtection(request)
    }

    final case class DeleteProtectionGroupOp(
      request: DeleteProtectionGroupRequest
    ) extends ShieldOp[DeleteProtectionGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProtectionGroupResponse] =
        visitor.deleteProtectionGroup(request)
    }

    final case class DescribeAttackOp(
      request: DescribeAttackRequest
    ) extends ShieldOp[DescribeAttackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAttackResponse] =
        visitor.describeAttack(request)
    }

    final case class DescribeAttackStatisticsOp(
      request: DescribeAttackStatisticsRequest
    ) extends ShieldOp[DescribeAttackStatisticsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAttackStatisticsResponse] =
        visitor.describeAttackStatistics(request)
    }

    final case class DescribeDRTAccessOp(
      request: DescribeDrtAccessRequest
    ) extends ShieldOp[DescribeDrtAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDrtAccessResponse] =
        visitor.describeDRTAccess(request)
    }

    final case class DescribeEmergencyContactSettingsOp(
      request: DescribeEmergencyContactSettingsRequest
    ) extends ShieldOp[DescribeEmergencyContactSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEmergencyContactSettingsResponse] =
        visitor.describeEmergencyContactSettings(request)
    }

    final case class DescribeProtectionOp(
      request: DescribeProtectionRequest
    ) extends ShieldOp[DescribeProtectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProtectionResponse] =
        visitor.describeProtection(request)
    }

    final case class DescribeProtectionGroupOp(
      request: DescribeProtectionGroupRequest
    ) extends ShieldOp[DescribeProtectionGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProtectionGroupResponse] =
        visitor.describeProtectionGroup(request)
    }

    final case class DescribeSubscriptionOp(
      request: DescribeSubscriptionRequest
    ) extends ShieldOp[DescribeSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSubscriptionResponse] =
        visitor.describeSubscription(request)
    }

    final case class DisableProactiveEngagementOp(
      request: DisableProactiveEngagementRequest
    ) extends ShieldOp[DisableProactiveEngagementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableProactiveEngagementResponse] =
        visitor.disableProactiveEngagement(request)
    }

    final case class DisassociateDRTLogBucketOp(
      request: DisassociateDrtLogBucketRequest
    ) extends ShieldOp[DisassociateDrtLogBucketResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateDrtLogBucketResponse] =
        visitor.disassociateDRTLogBucket(request)
    }

    final case class DisassociateDRTRoleOp(
      request: DisassociateDrtRoleRequest
    ) extends ShieldOp[DisassociateDrtRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateDrtRoleResponse] =
        visitor.disassociateDRTRole(request)
    }

    final case class DisassociateHealthCheckOp(
      request: DisassociateHealthCheckRequest
    ) extends ShieldOp[DisassociateHealthCheckResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateHealthCheckResponse] =
        visitor.disassociateHealthCheck(request)
    }

    final case class EnableProactiveEngagementOp(
      request: EnableProactiveEngagementRequest
    ) extends ShieldOp[EnableProactiveEngagementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableProactiveEngagementResponse] =
        visitor.enableProactiveEngagement(request)
    }

    final case class GetSubscriptionStateOp(
      request: GetSubscriptionStateRequest
    ) extends ShieldOp[GetSubscriptionStateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSubscriptionStateResponse] =
        visitor.getSubscriptionState(request)
    }

    final case class ListAttacksOp(
      request: ListAttacksRequest
    ) extends ShieldOp[ListAttacksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAttacksResponse] =
        visitor.listAttacks(request)
    }

    final case class ListProtectionGroupsOp(
      request: ListProtectionGroupsRequest
    ) extends ShieldOp[ListProtectionGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProtectionGroupsResponse] =
        visitor.listProtectionGroups(request)
    }

    final case class ListProtectionsOp(
      request: ListProtectionsRequest
    ) extends ShieldOp[ListProtectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProtectionsResponse] =
        visitor.listProtections(request)
    }

    final case class ListResourcesInProtectionGroupOp(
      request: ListResourcesInProtectionGroupRequest
    ) extends ShieldOp[ListResourcesInProtectionGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResourcesInProtectionGroupResponse] =
        visitor.listResourcesInProtectionGroup(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends ShieldOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends ShieldOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends ShieldOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateEmergencyContactSettingsOp(
      request: UpdateEmergencyContactSettingsRequest
    ) extends ShieldOp[UpdateEmergencyContactSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEmergencyContactSettingsResponse] =
        visitor.updateEmergencyContactSettings(request)
    }

    final case class UpdateProtectionGroupOp(
      request: UpdateProtectionGroupRequest
    ) extends ShieldOp[UpdateProtectionGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateProtectionGroupResponse] =
        visitor.updateProtectionGroup(request)
    }

    final case class UpdateSubscriptionOp(
      request: UpdateSubscriptionRequest
    ) extends ShieldOp[UpdateSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSubscriptionResponse] =
        visitor.updateSubscription(request)
    }
  }

  import ShieldOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ShieldOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateDRTLogBucket(
    request: AssociateDrtLogBucketRequest
  ): ShieldIO[AssociateDrtLogBucketResponse] =
    FF.liftF(AssociateDRTLogBucketOp(request))

  def associateDRTRole(
    request: AssociateDrtRoleRequest
  ): ShieldIO[AssociateDrtRoleResponse] =
    FF.liftF(AssociateDRTRoleOp(request))

  def associateHealthCheck(
    request: AssociateHealthCheckRequest
  ): ShieldIO[AssociateHealthCheckResponse] =
    FF.liftF(AssociateHealthCheckOp(request))

  def associateProactiveEngagementDetails(
    request: AssociateProactiveEngagementDetailsRequest
  ): ShieldIO[AssociateProactiveEngagementDetailsResponse] =
    FF.liftF(AssociateProactiveEngagementDetailsOp(request))

  def createProtection(
    request: CreateProtectionRequest
  ): ShieldIO[CreateProtectionResponse] =
    FF.liftF(CreateProtectionOp(request))

  def createProtectionGroup(
    request: CreateProtectionGroupRequest
  ): ShieldIO[CreateProtectionGroupResponse] =
    FF.liftF(CreateProtectionGroupOp(request))

  def createSubscription(
    request: CreateSubscriptionRequest
  ): ShieldIO[CreateSubscriptionResponse] =
    FF.liftF(CreateSubscriptionOp(request))

  def deleteProtection(
    request: DeleteProtectionRequest
  ): ShieldIO[DeleteProtectionResponse] =
    FF.liftF(DeleteProtectionOp(request))

  def deleteProtectionGroup(
    request: DeleteProtectionGroupRequest
  ): ShieldIO[DeleteProtectionGroupResponse] =
    FF.liftF(DeleteProtectionGroupOp(request))

  def describeAttack(
    request: DescribeAttackRequest
  ): ShieldIO[DescribeAttackResponse] =
    FF.liftF(DescribeAttackOp(request))

  def describeAttackStatistics(
    request: DescribeAttackStatisticsRequest
  ): ShieldIO[DescribeAttackStatisticsResponse] =
    FF.liftF(DescribeAttackStatisticsOp(request))

  def describeDRTAccess(
    request: DescribeDrtAccessRequest
  ): ShieldIO[DescribeDrtAccessResponse] =
    FF.liftF(DescribeDRTAccessOp(request))

  def describeEmergencyContactSettings(
    request: DescribeEmergencyContactSettingsRequest
  ): ShieldIO[DescribeEmergencyContactSettingsResponse] =
    FF.liftF(DescribeEmergencyContactSettingsOp(request))

  def describeProtection(
    request: DescribeProtectionRequest
  ): ShieldIO[DescribeProtectionResponse] =
    FF.liftF(DescribeProtectionOp(request))

  def describeProtectionGroup(
    request: DescribeProtectionGroupRequest
  ): ShieldIO[DescribeProtectionGroupResponse] =
    FF.liftF(DescribeProtectionGroupOp(request))

  def describeSubscription(
    request: DescribeSubscriptionRequest
  ): ShieldIO[DescribeSubscriptionResponse] =
    FF.liftF(DescribeSubscriptionOp(request))

  def disableProactiveEngagement(
    request: DisableProactiveEngagementRequest
  ): ShieldIO[DisableProactiveEngagementResponse] =
    FF.liftF(DisableProactiveEngagementOp(request))

  def disassociateDRTLogBucket(
    request: DisassociateDrtLogBucketRequest
  ): ShieldIO[DisassociateDrtLogBucketResponse] =
    FF.liftF(DisassociateDRTLogBucketOp(request))

  def disassociateDRTRole(
    request: DisassociateDrtRoleRequest
  ): ShieldIO[DisassociateDrtRoleResponse] =
    FF.liftF(DisassociateDRTRoleOp(request))

  def disassociateHealthCheck(
    request: DisassociateHealthCheckRequest
  ): ShieldIO[DisassociateHealthCheckResponse] =
    FF.liftF(DisassociateHealthCheckOp(request))

  def enableProactiveEngagement(
    request: EnableProactiveEngagementRequest
  ): ShieldIO[EnableProactiveEngagementResponse] =
    FF.liftF(EnableProactiveEngagementOp(request))

  def getSubscriptionState(
    request: GetSubscriptionStateRequest
  ): ShieldIO[GetSubscriptionStateResponse] =
    FF.liftF(GetSubscriptionStateOp(request))

  def listAttacks(
    request: ListAttacksRequest
  ): ShieldIO[ListAttacksResponse] =
    FF.liftF(ListAttacksOp(request))

  def listProtectionGroups(
    request: ListProtectionGroupsRequest
  ): ShieldIO[ListProtectionGroupsResponse] =
    FF.liftF(ListProtectionGroupsOp(request))

  def listProtections(
    request: ListProtectionsRequest
  ): ShieldIO[ListProtectionsResponse] =
    FF.liftF(ListProtectionsOp(request))

  def listResourcesInProtectionGroup(
    request: ListResourcesInProtectionGroupRequest
  ): ShieldIO[ListResourcesInProtectionGroupResponse] =
    FF.liftF(ListResourcesInProtectionGroupOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): ShieldIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): ShieldIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): ShieldIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateEmergencyContactSettings(
    request: UpdateEmergencyContactSettingsRequest
  ): ShieldIO[UpdateEmergencyContactSettingsResponse] =
    FF.liftF(UpdateEmergencyContactSettingsOp(request))

  def updateProtectionGroup(
    request: UpdateProtectionGroupRequest
  ): ShieldIO[UpdateProtectionGroupResponse] =
    FF.liftF(UpdateProtectionGroupOp(request))

  def updateSubscription(
    request: UpdateSubscriptionRequest
  ): ShieldIO[UpdateSubscriptionResponse] =
    FF.liftF(UpdateSubscriptionOp(request))
}
