package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.autoscaling.AutoScalingClient
import software.amazon.awssdk.services.autoscaling.model._


object autoscaling { module =>

  // Free monad over AutoScalingOp
  type AutoScalingIO[A] = FF[AutoScalingOp, A]

  sealed trait AutoScalingOp[A] {
    def visit[F[_]](visitor: AutoScalingOp.Visitor[F]): F[A]
  }

  object AutoScalingOp {
    // Given a AutoScalingClient we can embed a AutoScalingIO program in any algebra that understands embedding.
    implicit val AutoScalingOpEmbeddable: Embeddable[AutoScalingOp, AutoScalingClient] = new Embeddable[AutoScalingOp, AutoScalingClient] {
      def embed[A](client: AutoScalingClient, io: AutoScalingIO[A]): Embedded[A] = Embedded.AutoScaling(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends AutoScalingOp.Visitor[Kleisli[M, AutoScalingClient, *]] {
        def attachInstances(
          request: AttachInstancesRequest
        ): Kleisli[M, AutoScalingClient, AttachInstancesResponse] =
          primitive(_.attachInstances(request))

        def attachLoadBalancerTargetGroups(
          request: AttachLoadBalancerTargetGroupsRequest
        ): Kleisli[M, AutoScalingClient, AttachLoadBalancerTargetGroupsResponse] =
          primitive(_.attachLoadBalancerTargetGroups(request))

        def attachLoadBalancers(
          request: AttachLoadBalancersRequest
        ): Kleisli[M, AutoScalingClient, AttachLoadBalancersResponse] =
          primitive(_.attachLoadBalancers(request))

        def batchDeleteScheduledAction(
          request: BatchDeleteScheduledActionRequest
        ): Kleisli[M, AutoScalingClient, BatchDeleteScheduledActionResponse] =
          primitive(_.batchDeleteScheduledAction(request))

        def batchPutScheduledUpdateGroupAction(
          request: BatchPutScheduledUpdateGroupActionRequest
        ): Kleisli[M, AutoScalingClient, BatchPutScheduledUpdateGroupActionResponse] =
          primitive(_.batchPutScheduledUpdateGroupAction(request))

        def cancelInstanceRefresh(
          request: CancelInstanceRefreshRequest
        ): Kleisli[M, AutoScalingClient, CancelInstanceRefreshResponse] =
          primitive(_.cancelInstanceRefresh(request))

        def completeLifecycleAction(
          request: CompleteLifecycleActionRequest
        ): Kleisli[M, AutoScalingClient, CompleteLifecycleActionResponse] =
          primitive(_.completeLifecycleAction(request))

        def createAutoScalingGroup(
          request: CreateAutoScalingGroupRequest
        ): Kleisli[M, AutoScalingClient, CreateAutoScalingGroupResponse] =
          primitive(_.createAutoScalingGroup(request))

        def createLaunchConfiguration(
          request: CreateLaunchConfigurationRequest
        ): Kleisli[M, AutoScalingClient, CreateLaunchConfigurationResponse] =
          primitive(_.createLaunchConfiguration(request))

        def createOrUpdateTags(
          request: CreateOrUpdateTagsRequest
        ): Kleisli[M, AutoScalingClient, CreateOrUpdateTagsResponse] =
          primitive(_.createOrUpdateTags(request))

        def deleteAutoScalingGroup(
          request: DeleteAutoScalingGroupRequest
        ): Kleisli[M, AutoScalingClient, DeleteAutoScalingGroupResponse] =
          primitive(_.deleteAutoScalingGroup(request))

        def deleteLaunchConfiguration(
          request: DeleteLaunchConfigurationRequest
        ): Kleisli[M, AutoScalingClient, DeleteLaunchConfigurationResponse] =
          primitive(_.deleteLaunchConfiguration(request))

        def deleteLifecycleHook(
          request: DeleteLifecycleHookRequest
        ): Kleisli[M, AutoScalingClient, DeleteLifecycleHookResponse] =
          primitive(_.deleteLifecycleHook(request))

        def deleteNotificationConfiguration(
          request: DeleteNotificationConfigurationRequest
        ): Kleisli[M, AutoScalingClient, DeleteNotificationConfigurationResponse] =
          primitive(_.deleteNotificationConfiguration(request))

        def deletePolicy(
          request: DeletePolicyRequest
        ): Kleisli[M, AutoScalingClient, DeletePolicyResponse] =
          primitive(_.deletePolicy(request))

        def deleteScheduledAction(
          request: DeleteScheduledActionRequest
        ): Kleisli[M, AutoScalingClient, DeleteScheduledActionResponse] =
          primitive(_.deleteScheduledAction(request))

        def deleteTags(
          request: DeleteTagsRequest
        ): Kleisli[M, AutoScalingClient, DeleteTagsResponse] =
          primitive(_.deleteTags(request))

        def deleteWarmPool(
          request: DeleteWarmPoolRequest
        ): Kleisli[M, AutoScalingClient, DeleteWarmPoolResponse] =
          primitive(_.deleteWarmPool(request))

        def describeAccountLimits(
          request: DescribeAccountLimitsRequest
        ): Kleisli[M, AutoScalingClient, DescribeAccountLimitsResponse] =
          primitive(_.describeAccountLimits(request))

        def describeAdjustmentTypes(
          request: DescribeAdjustmentTypesRequest
        ): Kleisli[M, AutoScalingClient, DescribeAdjustmentTypesResponse] =
          primitive(_.describeAdjustmentTypes(request))

        def describeAutoScalingGroups(
          request: DescribeAutoScalingGroupsRequest
        ): Kleisli[M, AutoScalingClient, DescribeAutoScalingGroupsResponse] =
          primitive(_.describeAutoScalingGroups(request))

        def describeAutoScalingInstances(
          request: DescribeAutoScalingInstancesRequest
        ): Kleisli[M, AutoScalingClient, DescribeAutoScalingInstancesResponse] =
          primitive(_.describeAutoScalingInstances(request))

        def describeAutoScalingNotificationTypes(
          request: DescribeAutoScalingNotificationTypesRequest
        ): Kleisli[M, AutoScalingClient, DescribeAutoScalingNotificationTypesResponse] =
          primitive(_.describeAutoScalingNotificationTypes(request))

        def describeInstanceRefreshes(
          request: DescribeInstanceRefreshesRequest
        ): Kleisli[M, AutoScalingClient, DescribeInstanceRefreshesResponse] =
          primitive(_.describeInstanceRefreshes(request))

        def describeLaunchConfigurations(
          request: DescribeLaunchConfigurationsRequest
        ): Kleisli[M, AutoScalingClient, DescribeLaunchConfigurationsResponse] =
          primitive(_.describeLaunchConfigurations(request))

        def describeLifecycleHookTypes(
          request: DescribeLifecycleHookTypesRequest
        ): Kleisli[M, AutoScalingClient, DescribeLifecycleHookTypesResponse] =
          primitive(_.describeLifecycleHookTypes(request))

        def describeLifecycleHooks(
          request: DescribeLifecycleHooksRequest
        ): Kleisli[M, AutoScalingClient, DescribeLifecycleHooksResponse] =
          primitive(_.describeLifecycleHooks(request))

        def describeLoadBalancerTargetGroups(
          request: DescribeLoadBalancerTargetGroupsRequest
        ): Kleisli[M, AutoScalingClient, DescribeLoadBalancerTargetGroupsResponse] =
          primitive(_.describeLoadBalancerTargetGroups(request))

        def describeLoadBalancers(
          request: DescribeLoadBalancersRequest
        ): Kleisli[M, AutoScalingClient, DescribeLoadBalancersResponse] =
          primitive(_.describeLoadBalancers(request))

        def describeMetricCollectionTypes(
          request: DescribeMetricCollectionTypesRequest
        ): Kleisli[M, AutoScalingClient, DescribeMetricCollectionTypesResponse] =
          primitive(_.describeMetricCollectionTypes(request))

        def describeNotificationConfigurations(
          request: DescribeNotificationConfigurationsRequest
        ): Kleisli[M, AutoScalingClient, DescribeNotificationConfigurationsResponse] =
          primitive(_.describeNotificationConfigurations(request))

        def describePolicies(
          request: DescribePoliciesRequest
        ): Kleisli[M, AutoScalingClient, DescribePoliciesResponse] =
          primitive(_.describePolicies(request))

        def describeScalingActivities(
          request: DescribeScalingActivitiesRequest
        ): Kleisli[M, AutoScalingClient, DescribeScalingActivitiesResponse] =
          primitive(_.describeScalingActivities(request))

        def describeScalingProcessTypes(
          request: DescribeScalingProcessTypesRequest
        ): Kleisli[M, AutoScalingClient, DescribeScalingProcessTypesResponse] =
          primitive(_.describeScalingProcessTypes(request))

        def describeScheduledActions(
          request: DescribeScheduledActionsRequest
        ): Kleisli[M, AutoScalingClient, DescribeScheduledActionsResponse] =
          primitive(_.describeScheduledActions(request))

        def describeTags(
          request: DescribeTagsRequest
        ): Kleisli[M, AutoScalingClient, DescribeTagsResponse] =
          primitive(_.describeTags(request))

        def describeTerminationPolicyTypes(
          request: DescribeTerminationPolicyTypesRequest
        ): Kleisli[M, AutoScalingClient, DescribeTerminationPolicyTypesResponse] =
          primitive(_.describeTerminationPolicyTypes(request))

        def describeWarmPool(
          request: DescribeWarmPoolRequest
        ): Kleisli[M, AutoScalingClient, DescribeWarmPoolResponse] =
          primitive(_.describeWarmPool(request))

        def detachInstances(
          request: DetachInstancesRequest
        ): Kleisli[M, AutoScalingClient, DetachInstancesResponse] =
          primitive(_.detachInstances(request))

        def detachLoadBalancerTargetGroups(
          request: DetachLoadBalancerTargetGroupsRequest
        ): Kleisli[M, AutoScalingClient, DetachLoadBalancerTargetGroupsResponse] =
          primitive(_.detachLoadBalancerTargetGroups(request))

        def detachLoadBalancers(
          request: DetachLoadBalancersRequest
        ): Kleisli[M, AutoScalingClient, DetachLoadBalancersResponse] =
          primitive(_.detachLoadBalancers(request))

        def disableMetricsCollection(
          request: DisableMetricsCollectionRequest
        ): Kleisli[M, AutoScalingClient, DisableMetricsCollectionResponse] =
          primitive(_.disableMetricsCollection(request))

        def enableMetricsCollection(
          request: EnableMetricsCollectionRequest
        ): Kleisli[M, AutoScalingClient, EnableMetricsCollectionResponse] =
          primitive(_.enableMetricsCollection(request))

        def enterStandby(
          request: EnterStandbyRequest
        ): Kleisli[M, AutoScalingClient, EnterStandbyResponse] =
          primitive(_.enterStandby(request))

        def executePolicy(
          request: ExecutePolicyRequest
        ): Kleisli[M, AutoScalingClient, ExecutePolicyResponse] =
          primitive(_.executePolicy(request))

        def exitStandby(
          request: ExitStandbyRequest
        ): Kleisli[M, AutoScalingClient, ExitStandbyResponse] =
          primitive(_.exitStandby(request))

        def getPredictiveScalingForecast(
          request: GetPredictiveScalingForecastRequest
        ): Kleisli[M, AutoScalingClient, GetPredictiveScalingForecastResponse] =
          primitive(_.getPredictiveScalingForecast(request))

        def putLifecycleHook(
          request: PutLifecycleHookRequest
        ): Kleisli[M, AutoScalingClient, PutLifecycleHookResponse] =
          primitive(_.putLifecycleHook(request))

        def putNotificationConfiguration(
          request: PutNotificationConfigurationRequest
        ): Kleisli[M, AutoScalingClient, PutNotificationConfigurationResponse] =
          primitive(_.putNotificationConfiguration(request))

        def putScalingPolicy(
          request: PutScalingPolicyRequest
        ): Kleisli[M, AutoScalingClient, PutScalingPolicyResponse] =
          primitive(_.putScalingPolicy(request))

        def putScheduledUpdateGroupAction(
          request: PutScheduledUpdateGroupActionRequest
        ): Kleisli[M, AutoScalingClient, PutScheduledUpdateGroupActionResponse] =
          primitive(_.putScheduledUpdateGroupAction(request))

        def putWarmPool(
          request: PutWarmPoolRequest
        ): Kleisli[M, AutoScalingClient, PutWarmPoolResponse] =
          primitive(_.putWarmPool(request))

        def recordLifecycleActionHeartbeat(
          request: RecordLifecycleActionHeartbeatRequest
        ): Kleisli[M, AutoScalingClient, RecordLifecycleActionHeartbeatResponse] =
          primitive(_.recordLifecycleActionHeartbeat(request))

        def resumeProcesses(
          request: ResumeProcessesRequest
        ): Kleisli[M, AutoScalingClient, ResumeProcessesResponse] =
          primitive(_.resumeProcesses(request))

        def setDesiredCapacity(
          request: SetDesiredCapacityRequest
        ): Kleisli[M, AutoScalingClient, SetDesiredCapacityResponse] =
          primitive(_.setDesiredCapacity(request))

        def setInstanceHealth(
          request: SetInstanceHealthRequest
        ): Kleisli[M, AutoScalingClient, SetInstanceHealthResponse] =
          primitive(_.setInstanceHealth(request))

        def setInstanceProtection(
          request: SetInstanceProtectionRequest
        ): Kleisli[M, AutoScalingClient, SetInstanceProtectionResponse] =
          primitive(_.setInstanceProtection(request))

        def startInstanceRefresh(
          request: StartInstanceRefreshRequest
        ): Kleisli[M, AutoScalingClient, StartInstanceRefreshResponse] =
          primitive(_.startInstanceRefresh(request))

        def suspendProcesses(
          request: SuspendProcessesRequest
        ): Kleisli[M, AutoScalingClient, SuspendProcessesResponse] =
          primitive(_.suspendProcesses(request))

        def terminateInstanceInAutoScalingGroup(
          request: TerminateInstanceInAutoScalingGroupRequest
        ): Kleisli[M, AutoScalingClient, TerminateInstanceInAutoScalingGroupResponse] =
          primitive(_.terminateInstanceInAutoScalingGroup(request))

        def updateAutoScalingGroup(
          request: UpdateAutoScalingGroupRequest
        ): Kleisli[M, AutoScalingClient, UpdateAutoScalingGroupResponse] =
          primitive(_.updateAutoScalingGroup(request))

        def primitive[A](
          f: AutoScalingClient => A
        ): Kleisli[M, AutoScalingClient, A]
      }
    }

    trait Visitor[F[_]] extends (AutoScalingOp ~> F) {
      final def apply[A](op: AutoScalingOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def attachInstances(
        request: AttachInstancesRequest
      ): F[AttachInstancesResponse]

      def attachLoadBalancerTargetGroups(
        request: AttachLoadBalancerTargetGroupsRequest
      ): F[AttachLoadBalancerTargetGroupsResponse]

      def attachLoadBalancers(
        request: AttachLoadBalancersRequest
      ): F[AttachLoadBalancersResponse]

      def batchDeleteScheduledAction(
        request: BatchDeleteScheduledActionRequest
      ): F[BatchDeleteScheduledActionResponse]

      def batchPutScheduledUpdateGroupAction(
        request: BatchPutScheduledUpdateGroupActionRequest
      ): F[BatchPutScheduledUpdateGroupActionResponse]

      def cancelInstanceRefresh(
        request: CancelInstanceRefreshRequest
      ): F[CancelInstanceRefreshResponse]

      def completeLifecycleAction(
        request: CompleteLifecycleActionRequest
      ): F[CompleteLifecycleActionResponse]

      def createAutoScalingGroup(
        request: CreateAutoScalingGroupRequest
      ): F[CreateAutoScalingGroupResponse]

      def createLaunchConfiguration(
        request: CreateLaunchConfigurationRequest
      ): F[CreateLaunchConfigurationResponse]

      def createOrUpdateTags(
        request: CreateOrUpdateTagsRequest
      ): F[CreateOrUpdateTagsResponse]

      def deleteAutoScalingGroup(
        request: DeleteAutoScalingGroupRequest
      ): F[DeleteAutoScalingGroupResponse]

      def deleteLaunchConfiguration(
        request: DeleteLaunchConfigurationRequest
      ): F[DeleteLaunchConfigurationResponse]

      def deleteLifecycleHook(
        request: DeleteLifecycleHookRequest
      ): F[DeleteLifecycleHookResponse]

      def deleteNotificationConfiguration(
        request: DeleteNotificationConfigurationRequest
      ): F[DeleteNotificationConfigurationResponse]

      def deletePolicy(
        request: DeletePolicyRequest
      ): F[DeletePolicyResponse]

      def deleteScheduledAction(
        request: DeleteScheduledActionRequest
      ): F[DeleteScheduledActionResponse]

      def deleteTags(
        request: DeleteTagsRequest
      ): F[DeleteTagsResponse]

      def deleteWarmPool(
        request: DeleteWarmPoolRequest
      ): F[DeleteWarmPoolResponse]

      def describeAccountLimits(
        request: DescribeAccountLimitsRequest
      ): F[DescribeAccountLimitsResponse]

      def describeAdjustmentTypes(
        request: DescribeAdjustmentTypesRequest
      ): F[DescribeAdjustmentTypesResponse]

      def describeAutoScalingGroups(
        request: DescribeAutoScalingGroupsRequest
      ): F[DescribeAutoScalingGroupsResponse]

      def describeAutoScalingInstances(
        request: DescribeAutoScalingInstancesRequest
      ): F[DescribeAutoScalingInstancesResponse]

      def describeAutoScalingNotificationTypes(
        request: DescribeAutoScalingNotificationTypesRequest
      ): F[DescribeAutoScalingNotificationTypesResponse]

      def describeInstanceRefreshes(
        request: DescribeInstanceRefreshesRequest
      ): F[DescribeInstanceRefreshesResponse]

      def describeLaunchConfigurations(
        request: DescribeLaunchConfigurationsRequest
      ): F[DescribeLaunchConfigurationsResponse]

      def describeLifecycleHookTypes(
        request: DescribeLifecycleHookTypesRequest
      ): F[DescribeLifecycleHookTypesResponse]

      def describeLifecycleHooks(
        request: DescribeLifecycleHooksRequest
      ): F[DescribeLifecycleHooksResponse]

      def describeLoadBalancerTargetGroups(
        request: DescribeLoadBalancerTargetGroupsRequest
      ): F[DescribeLoadBalancerTargetGroupsResponse]

      def describeLoadBalancers(
        request: DescribeLoadBalancersRequest
      ): F[DescribeLoadBalancersResponse]

      def describeMetricCollectionTypes(
        request: DescribeMetricCollectionTypesRequest
      ): F[DescribeMetricCollectionTypesResponse]

      def describeNotificationConfigurations(
        request: DescribeNotificationConfigurationsRequest
      ): F[DescribeNotificationConfigurationsResponse]

      def describePolicies(
        request: DescribePoliciesRequest
      ): F[DescribePoliciesResponse]

      def describeScalingActivities(
        request: DescribeScalingActivitiesRequest
      ): F[DescribeScalingActivitiesResponse]

      def describeScalingProcessTypes(
        request: DescribeScalingProcessTypesRequest
      ): F[DescribeScalingProcessTypesResponse]

      def describeScheduledActions(
        request: DescribeScheduledActionsRequest
      ): F[DescribeScheduledActionsResponse]

      def describeTags(
        request: DescribeTagsRequest
      ): F[DescribeTagsResponse]

      def describeTerminationPolicyTypes(
        request: DescribeTerminationPolicyTypesRequest
      ): F[DescribeTerminationPolicyTypesResponse]

      def describeWarmPool(
        request: DescribeWarmPoolRequest
      ): F[DescribeWarmPoolResponse]

      def detachInstances(
        request: DetachInstancesRequest
      ): F[DetachInstancesResponse]

      def detachLoadBalancerTargetGroups(
        request: DetachLoadBalancerTargetGroupsRequest
      ): F[DetachLoadBalancerTargetGroupsResponse]

      def detachLoadBalancers(
        request: DetachLoadBalancersRequest
      ): F[DetachLoadBalancersResponse]

      def disableMetricsCollection(
        request: DisableMetricsCollectionRequest
      ): F[DisableMetricsCollectionResponse]

      def enableMetricsCollection(
        request: EnableMetricsCollectionRequest
      ): F[EnableMetricsCollectionResponse]

      def enterStandby(
        request: EnterStandbyRequest
      ): F[EnterStandbyResponse]

      def executePolicy(
        request: ExecutePolicyRequest
      ): F[ExecutePolicyResponse]

      def exitStandby(
        request: ExitStandbyRequest
      ): F[ExitStandbyResponse]

      def getPredictiveScalingForecast(
        request: GetPredictiveScalingForecastRequest
      ): F[GetPredictiveScalingForecastResponse]

      def putLifecycleHook(
        request: PutLifecycleHookRequest
      ): F[PutLifecycleHookResponse]

      def putNotificationConfiguration(
        request: PutNotificationConfigurationRequest
      ): F[PutNotificationConfigurationResponse]

      def putScalingPolicy(
        request: PutScalingPolicyRequest
      ): F[PutScalingPolicyResponse]

      def putScheduledUpdateGroupAction(
        request: PutScheduledUpdateGroupActionRequest
      ): F[PutScheduledUpdateGroupActionResponse]

      def putWarmPool(
        request: PutWarmPoolRequest
      ): F[PutWarmPoolResponse]

      def recordLifecycleActionHeartbeat(
        request: RecordLifecycleActionHeartbeatRequest
      ): F[RecordLifecycleActionHeartbeatResponse]

      def resumeProcesses(
        request: ResumeProcessesRequest
      ): F[ResumeProcessesResponse]

      def setDesiredCapacity(
        request: SetDesiredCapacityRequest
      ): F[SetDesiredCapacityResponse]

      def setInstanceHealth(
        request: SetInstanceHealthRequest
      ): F[SetInstanceHealthResponse]

      def setInstanceProtection(
        request: SetInstanceProtectionRequest
      ): F[SetInstanceProtectionResponse]

      def startInstanceRefresh(
        request: StartInstanceRefreshRequest
      ): F[StartInstanceRefreshResponse]

      def suspendProcesses(
        request: SuspendProcessesRequest
      ): F[SuspendProcessesResponse]

      def terminateInstanceInAutoScalingGroup(
        request: TerminateInstanceInAutoScalingGroupRequest
      ): F[TerminateInstanceInAutoScalingGroupResponse]

      def updateAutoScalingGroup(
        request: UpdateAutoScalingGroupRequest
      ): F[UpdateAutoScalingGroupResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends AutoScalingOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AttachInstancesOp(
      request: AttachInstancesRequest
    ) extends AutoScalingOp[AttachInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachInstancesResponse] =
        visitor.attachInstances(request)
    }

    final case class AttachLoadBalancerTargetGroupsOp(
      request: AttachLoadBalancerTargetGroupsRequest
    ) extends AutoScalingOp[AttachLoadBalancerTargetGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachLoadBalancerTargetGroupsResponse] =
        visitor.attachLoadBalancerTargetGroups(request)
    }

    final case class AttachLoadBalancersOp(
      request: AttachLoadBalancersRequest
    ) extends AutoScalingOp[AttachLoadBalancersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachLoadBalancersResponse] =
        visitor.attachLoadBalancers(request)
    }

    final case class BatchDeleteScheduledActionOp(
      request: BatchDeleteScheduledActionRequest
    ) extends AutoScalingOp[BatchDeleteScheduledActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDeleteScheduledActionResponse] =
        visitor.batchDeleteScheduledAction(request)
    }

    final case class BatchPutScheduledUpdateGroupActionOp(
      request: BatchPutScheduledUpdateGroupActionRequest
    ) extends AutoScalingOp[BatchPutScheduledUpdateGroupActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchPutScheduledUpdateGroupActionResponse] =
        visitor.batchPutScheduledUpdateGroupAction(request)
    }

    final case class CancelInstanceRefreshOp(
      request: CancelInstanceRefreshRequest
    ) extends AutoScalingOp[CancelInstanceRefreshResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelInstanceRefreshResponse] =
        visitor.cancelInstanceRefresh(request)
    }

    final case class CompleteLifecycleActionOp(
      request: CompleteLifecycleActionRequest
    ) extends AutoScalingOp[CompleteLifecycleActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CompleteLifecycleActionResponse] =
        visitor.completeLifecycleAction(request)
    }

    final case class CreateAutoScalingGroupOp(
      request: CreateAutoScalingGroupRequest
    ) extends AutoScalingOp[CreateAutoScalingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAutoScalingGroupResponse] =
        visitor.createAutoScalingGroup(request)
    }

    final case class CreateLaunchConfigurationOp(
      request: CreateLaunchConfigurationRequest
    ) extends AutoScalingOp[CreateLaunchConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLaunchConfigurationResponse] =
        visitor.createLaunchConfiguration(request)
    }

    final case class CreateOrUpdateTagsOp(
      request: CreateOrUpdateTagsRequest
    ) extends AutoScalingOp[CreateOrUpdateTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateOrUpdateTagsResponse] =
        visitor.createOrUpdateTags(request)
    }

    final case class DeleteAutoScalingGroupOp(
      request: DeleteAutoScalingGroupRequest
    ) extends AutoScalingOp[DeleteAutoScalingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAutoScalingGroupResponse] =
        visitor.deleteAutoScalingGroup(request)
    }

    final case class DeleteLaunchConfigurationOp(
      request: DeleteLaunchConfigurationRequest
    ) extends AutoScalingOp[DeleteLaunchConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLaunchConfigurationResponse] =
        visitor.deleteLaunchConfiguration(request)
    }

    final case class DeleteLifecycleHookOp(
      request: DeleteLifecycleHookRequest
    ) extends AutoScalingOp[DeleteLifecycleHookResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLifecycleHookResponse] =
        visitor.deleteLifecycleHook(request)
    }

    final case class DeleteNotificationConfigurationOp(
      request: DeleteNotificationConfigurationRequest
    ) extends AutoScalingOp[DeleteNotificationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNotificationConfigurationResponse] =
        visitor.deleteNotificationConfiguration(request)
    }

    final case class DeletePolicyOp(
      request: DeletePolicyRequest
    ) extends AutoScalingOp[DeletePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePolicyResponse] =
        visitor.deletePolicy(request)
    }

    final case class DeleteScheduledActionOp(
      request: DeleteScheduledActionRequest
    ) extends AutoScalingOp[DeleteScheduledActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteScheduledActionResponse] =
        visitor.deleteScheduledAction(request)
    }

    final case class DeleteTagsOp(
      request: DeleteTagsRequest
    ) extends AutoScalingOp[DeleteTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTagsResponse] =
        visitor.deleteTags(request)
    }

    final case class DeleteWarmPoolOp(
      request: DeleteWarmPoolRequest
    ) extends AutoScalingOp[DeleteWarmPoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWarmPoolResponse] =
        visitor.deleteWarmPool(request)
    }

    final case class DescribeAccountLimitsOp(
      request: DescribeAccountLimitsRequest
    ) extends AutoScalingOp[DescribeAccountLimitsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountLimitsResponse] =
        visitor.describeAccountLimits(request)
    }

    final case class DescribeAdjustmentTypesOp(
      request: DescribeAdjustmentTypesRequest
    ) extends AutoScalingOp[DescribeAdjustmentTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAdjustmentTypesResponse] =
        visitor.describeAdjustmentTypes(request)
    }

    final case class DescribeAutoScalingGroupsOp(
      request: DescribeAutoScalingGroupsRequest
    ) extends AutoScalingOp[DescribeAutoScalingGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAutoScalingGroupsResponse] =
        visitor.describeAutoScalingGroups(request)
    }

    final case class DescribeAutoScalingInstancesOp(
      request: DescribeAutoScalingInstancesRequest
    ) extends AutoScalingOp[DescribeAutoScalingInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAutoScalingInstancesResponse] =
        visitor.describeAutoScalingInstances(request)
    }

    final case class DescribeAutoScalingNotificationTypesOp(
      request: DescribeAutoScalingNotificationTypesRequest
    ) extends AutoScalingOp[DescribeAutoScalingNotificationTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAutoScalingNotificationTypesResponse] =
        visitor.describeAutoScalingNotificationTypes(request)
    }

    final case class DescribeInstanceRefreshesOp(
      request: DescribeInstanceRefreshesRequest
    ) extends AutoScalingOp[DescribeInstanceRefreshesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstanceRefreshesResponse] =
        visitor.describeInstanceRefreshes(request)
    }

    final case class DescribeLaunchConfigurationsOp(
      request: DescribeLaunchConfigurationsRequest
    ) extends AutoScalingOp[DescribeLaunchConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLaunchConfigurationsResponse] =
        visitor.describeLaunchConfigurations(request)
    }

    final case class DescribeLifecycleHookTypesOp(
      request: DescribeLifecycleHookTypesRequest
    ) extends AutoScalingOp[DescribeLifecycleHookTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLifecycleHookTypesResponse] =
        visitor.describeLifecycleHookTypes(request)
    }

    final case class DescribeLifecycleHooksOp(
      request: DescribeLifecycleHooksRequest
    ) extends AutoScalingOp[DescribeLifecycleHooksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLifecycleHooksResponse] =
        visitor.describeLifecycleHooks(request)
    }

    final case class DescribeLoadBalancerTargetGroupsOp(
      request: DescribeLoadBalancerTargetGroupsRequest
    ) extends AutoScalingOp[DescribeLoadBalancerTargetGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLoadBalancerTargetGroupsResponse] =
        visitor.describeLoadBalancerTargetGroups(request)
    }

    final case class DescribeLoadBalancersOp(
      request: DescribeLoadBalancersRequest
    ) extends AutoScalingOp[DescribeLoadBalancersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLoadBalancersResponse] =
        visitor.describeLoadBalancers(request)
    }

    final case class DescribeMetricCollectionTypesOp(
      request: DescribeMetricCollectionTypesRequest
    ) extends AutoScalingOp[DescribeMetricCollectionTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMetricCollectionTypesResponse] =
        visitor.describeMetricCollectionTypes(request)
    }

    final case class DescribeNotificationConfigurationsOp(
      request: DescribeNotificationConfigurationsRequest
    ) extends AutoScalingOp[DescribeNotificationConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNotificationConfigurationsResponse] =
        visitor.describeNotificationConfigurations(request)
    }

    final case class DescribePoliciesOp(
      request: DescribePoliciesRequest
    ) extends AutoScalingOp[DescribePoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePoliciesResponse] =
        visitor.describePolicies(request)
    }

    final case class DescribeScalingActivitiesOp(
      request: DescribeScalingActivitiesRequest
    ) extends AutoScalingOp[DescribeScalingActivitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeScalingActivitiesResponse] =
        visitor.describeScalingActivities(request)
    }

    final case class DescribeScalingProcessTypesOp(
      request: DescribeScalingProcessTypesRequest
    ) extends AutoScalingOp[DescribeScalingProcessTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeScalingProcessTypesResponse] =
        visitor.describeScalingProcessTypes(request)
    }

    final case class DescribeScheduledActionsOp(
      request: DescribeScheduledActionsRequest
    ) extends AutoScalingOp[DescribeScheduledActionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeScheduledActionsResponse] =
        visitor.describeScheduledActions(request)
    }

    final case class DescribeTagsOp(
      request: DescribeTagsRequest
    ) extends AutoScalingOp[DescribeTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTagsResponse] =
        visitor.describeTags(request)
    }

    final case class DescribeTerminationPolicyTypesOp(
      request: DescribeTerminationPolicyTypesRequest
    ) extends AutoScalingOp[DescribeTerminationPolicyTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTerminationPolicyTypesResponse] =
        visitor.describeTerminationPolicyTypes(request)
    }

    final case class DescribeWarmPoolOp(
      request: DescribeWarmPoolRequest
    ) extends AutoScalingOp[DescribeWarmPoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeWarmPoolResponse] =
        visitor.describeWarmPool(request)
    }

    final case class DetachInstancesOp(
      request: DetachInstancesRequest
    ) extends AutoScalingOp[DetachInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachInstancesResponse] =
        visitor.detachInstances(request)
    }

    final case class DetachLoadBalancerTargetGroupsOp(
      request: DetachLoadBalancerTargetGroupsRequest
    ) extends AutoScalingOp[DetachLoadBalancerTargetGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachLoadBalancerTargetGroupsResponse] =
        visitor.detachLoadBalancerTargetGroups(request)
    }

    final case class DetachLoadBalancersOp(
      request: DetachLoadBalancersRequest
    ) extends AutoScalingOp[DetachLoadBalancersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachLoadBalancersResponse] =
        visitor.detachLoadBalancers(request)
    }

    final case class DisableMetricsCollectionOp(
      request: DisableMetricsCollectionRequest
    ) extends AutoScalingOp[DisableMetricsCollectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableMetricsCollectionResponse] =
        visitor.disableMetricsCollection(request)
    }

    final case class EnableMetricsCollectionOp(
      request: EnableMetricsCollectionRequest
    ) extends AutoScalingOp[EnableMetricsCollectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableMetricsCollectionResponse] =
        visitor.enableMetricsCollection(request)
    }

    final case class EnterStandbyOp(
      request: EnterStandbyRequest
    ) extends AutoScalingOp[EnterStandbyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnterStandbyResponse] =
        visitor.enterStandby(request)
    }

    final case class ExecutePolicyOp(
      request: ExecutePolicyRequest
    ) extends AutoScalingOp[ExecutePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExecutePolicyResponse] =
        visitor.executePolicy(request)
    }

    final case class ExitStandbyOp(
      request: ExitStandbyRequest
    ) extends AutoScalingOp[ExitStandbyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExitStandbyResponse] =
        visitor.exitStandby(request)
    }

    final case class GetPredictiveScalingForecastOp(
      request: GetPredictiveScalingForecastRequest
    ) extends AutoScalingOp[GetPredictiveScalingForecastResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPredictiveScalingForecastResponse] =
        visitor.getPredictiveScalingForecast(request)
    }

    final case class PutLifecycleHookOp(
      request: PutLifecycleHookRequest
    ) extends AutoScalingOp[PutLifecycleHookResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutLifecycleHookResponse] =
        visitor.putLifecycleHook(request)
    }

    final case class PutNotificationConfigurationOp(
      request: PutNotificationConfigurationRequest
    ) extends AutoScalingOp[PutNotificationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutNotificationConfigurationResponse] =
        visitor.putNotificationConfiguration(request)
    }

    final case class PutScalingPolicyOp(
      request: PutScalingPolicyRequest
    ) extends AutoScalingOp[PutScalingPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutScalingPolicyResponse] =
        visitor.putScalingPolicy(request)
    }

    final case class PutScheduledUpdateGroupActionOp(
      request: PutScheduledUpdateGroupActionRequest
    ) extends AutoScalingOp[PutScheduledUpdateGroupActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutScheduledUpdateGroupActionResponse] =
        visitor.putScheduledUpdateGroupAction(request)
    }

    final case class PutWarmPoolOp(
      request: PutWarmPoolRequest
    ) extends AutoScalingOp[PutWarmPoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutWarmPoolResponse] =
        visitor.putWarmPool(request)
    }

    final case class RecordLifecycleActionHeartbeatOp(
      request: RecordLifecycleActionHeartbeatRequest
    ) extends AutoScalingOp[RecordLifecycleActionHeartbeatResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RecordLifecycleActionHeartbeatResponse] =
        visitor.recordLifecycleActionHeartbeat(request)
    }

    final case class ResumeProcessesOp(
      request: ResumeProcessesRequest
    ) extends AutoScalingOp[ResumeProcessesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResumeProcessesResponse] =
        visitor.resumeProcesses(request)
    }

    final case class SetDesiredCapacityOp(
      request: SetDesiredCapacityRequest
    ) extends AutoScalingOp[SetDesiredCapacityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetDesiredCapacityResponse] =
        visitor.setDesiredCapacity(request)
    }

    final case class SetInstanceHealthOp(
      request: SetInstanceHealthRequest
    ) extends AutoScalingOp[SetInstanceHealthResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetInstanceHealthResponse] =
        visitor.setInstanceHealth(request)
    }

    final case class SetInstanceProtectionOp(
      request: SetInstanceProtectionRequest
    ) extends AutoScalingOp[SetInstanceProtectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetInstanceProtectionResponse] =
        visitor.setInstanceProtection(request)
    }

    final case class StartInstanceRefreshOp(
      request: StartInstanceRefreshRequest
    ) extends AutoScalingOp[StartInstanceRefreshResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartInstanceRefreshResponse] =
        visitor.startInstanceRefresh(request)
    }

    final case class SuspendProcessesOp(
      request: SuspendProcessesRequest
    ) extends AutoScalingOp[SuspendProcessesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SuspendProcessesResponse] =
        visitor.suspendProcesses(request)
    }

    final case class TerminateInstanceInAutoScalingGroupOp(
      request: TerminateInstanceInAutoScalingGroupRequest
    ) extends AutoScalingOp[TerminateInstanceInAutoScalingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TerminateInstanceInAutoScalingGroupResponse] =
        visitor.terminateInstanceInAutoScalingGroup(request)
    }

    final case class UpdateAutoScalingGroupOp(
      request: UpdateAutoScalingGroupRequest
    ) extends AutoScalingOp[UpdateAutoScalingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAutoScalingGroupResponse] =
        visitor.updateAutoScalingGroup(request)
    }
  }

  import AutoScalingOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[AutoScalingOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def attachInstances(
    request: AttachInstancesRequest
  ): AutoScalingIO[AttachInstancesResponse] =
    FF.liftF(AttachInstancesOp(request))

  def attachLoadBalancerTargetGroups(
    request: AttachLoadBalancerTargetGroupsRequest
  ): AutoScalingIO[AttachLoadBalancerTargetGroupsResponse] =
    FF.liftF(AttachLoadBalancerTargetGroupsOp(request))

  def attachLoadBalancers(
    request: AttachLoadBalancersRequest
  ): AutoScalingIO[AttachLoadBalancersResponse] =
    FF.liftF(AttachLoadBalancersOp(request))

  def batchDeleteScheduledAction(
    request: BatchDeleteScheduledActionRequest
  ): AutoScalingIO[BatchDeleteScheduledActionResponse] =
    FF.liftF(BatchDeleteScheduledActionOp(request))

  def batchPutScheduledUpdateGroupAction(
    request: BatchPutScheduledUpdateGroupActionRequest
  ): AutoScalingIO[BatchPutScheduledUpdateGroupActionResponse] =
    FF.liftF(BatchPutScheduledUpdateGroupActionOp(request))

  def cancelInstanceRefresh(
    request: CancelInstanceRefreshRequest
  ): AutoScalingIO[CancelInstanceRefreshResponse] =
    FF.liftF(CancelInstanceRefreshOp(request))

  def completeLifecycleAction(
    request: CompleteLifecycleActionRequest
  ): AutoScalingIO[CompleteLifecycleActionResponse] =
    FF.liftF(CompleteLifecycleActionOp(request))

  def createAutoScalingGroup(
    request: CreateAutoScalingGroupRequest
  ): AutoScalingIO[CreateAutoScalingGroupResponse] =
    FF.liftF(CreateAutoScalingGroupOp(request))

  def createLaunchConfiguration(
    request: CreateLaunchConfigurationRequest
  ): AutoScalingIO[CreateLaunchConfigurationResponse] =
    FF.liftF(CreateLaunchConfigurationOp(request))

  def createOrUpdateTags(
    request: CreateOrUpdateTagsRequest
  ): AutoScalingIO[CreateOrUpdateTagsResponse] =
    FF.liftF(CreateOrUpdateTagsOp(request))

  def deleteAutoScalingGroup(
    request: DeleteAutoScalingGroupRequest
  ): AutoScalingIO[DeleteAutoScalingGroupResponse] =
    FF.liftF(DeleteAutoScalingGroupOp(request))

  def deleteLaunchConfiguration(
    request: DeleteLaunchConfigurationRequest
  ): AutoScalingIO[DeleteLaunchConfigurationResponse] =
    FF.liftF(DeleteLaunchConfigurationOp(request))

  def deleteLifecycleHook(
    request: DeleteLifecycleHookRequest
  ): AutoScalingIO[DeleteLifecycleHookResponse] =
    FF.liftF(DeleteLifecycleHookOp(request))

  def deleteNotificationConfiguration(
    request: DeleteNotificationConfigurationRequest
  ): AutoScalingIO[DeleteNotificationConfigurationResponse] =
    FF.liftF(DeleteNotificationConfigurationOp(request))

  def deletePolicy(
    request: DeletePolicyRequest
  ): AutoScalingIO[DeletePolicyResponse] =
    FF.liftF(DeletePolicyOp(request))

  def deleteScheduledAction(
    request: DeleteScheduledActionRequest
  ): AutoScalingIO[DeleteScheduledActionResponse] =
    FF.liftF(DeleteScheduledActionOp(request))

  def deleteTags(
    request: DeleteTagsRequest
  ): AutoScalingIO[DeleteTagsResponse] =
    FF.liftF(DeleteTagsOp(request))

  def deleteWarmPool(
    request: DeleteWarmPoolRequest
  ): AutoScalingIO[DeleteWarmPoolResponse] =
    FF.liftF(DeleteWarmPoolOp(request))

  def describeAccountLimits(
    request: DescribeAccountLimitsRequest
  ): AutoScalingIO[DescribeAccountLimitsResponse] =
    FF.liftF(DescribeAccountLimitsOp(request))

  def describeAdjustmentTypes(
    request: DescribeAdjustmentTypesRequest
  ): AutoScalingIO[DescribeAdjustmentTypesResponse] =
    FF.liftF(DescribeAdjustmentTypesOp(request))

  def describeAutoScalingGroups(
    request: DescribeAutoScalingGroupsRequest
  ): AutoScalingIO[DescribeAutoScalingGroupsResponse] =
    FF.liftF(DescribeAutoScalingGroupsOp(request))

  def describeAutoScalingInstances(
    request: DescribeAutoScalingInstancesRequest
  ): AutoScalingIO[DescribeAutoScalingInstancesResponse] =
    FF.liftF(DescribeAutoScalingInstancesOp(request))

  def describeAutoScalingNotificationTypes(
    request: DescribeAutoScalingNotificationTypesRequest
  ): AutoScalingIO[DescribeAutoScalingNotificationTypesResponse] =
    FF.liftF(DescribeAutoScalingNotificationTypesOp(request))

  def describeInstanceRefreshes(
    request: DescribeInstanceRefreshesRequest
  ): AutoScalingIO[DescribeInstanceRefreshesResponse] =
    FF.liftF(DescribeInstanceRefreshesOp(request))

  def describeLaunchConfigurations(
    request: DescribeLaunchConfigurationsRequest
  ): AutoScalingIO[DescribeLaunchConfigurationsResponse] =
    FF.liftF(DescribeLaunchConfigurationsOp(request))

  def describeLifecycleHookTypes(
    request: DescribeLifecycleHookTypesRequest
  ): AutoScalingIO[DescribeLifecycleHookTypesResponse] =
    FF.liftF(DescribeLifecycleHookTypesOp(request))

  def describeLifecycleHooks(
    request: DescribeLifecycleHooksRequest
  ): AutoScalingIO[DescribeLifecycleHooksResponse] =
    FF.liftF(DescribeLifecycleHooksOp(request))

  def describeLoadBalancerTargetGroups(
    request: DescribeLoadBalancerTargetGroupsRequest
  ): AutoScalingIO[DescribeLoadBalancerTargetGroupsResponse] =
    FF.liftF(DescribeLoadBalancerTargetGroupsOp(request))

  def describeLoadBalancers(
    request: DescribeLoadBalancersRequest
  ): AutoScalingIO[DescribeLoadBalancersResponse] =
    FF.liftF(DescribeLoadBalancersOp(request))

  def describeMetricCollectionTypes(
    request: DescribeMetricCollectionTypesRequest
  ): AutoScalingIO[DescribeMetricCollectionTypesResponse] =
    FF.liftF(DescribeMetricCollectionTypesOp(request))

  def describeNotificationConfigurations(
    request: DescribeNotificationConfigurationsRequest
  ): AutoScalingIO[DescribeNotificationConfigurationsResponse] =
    FF.liftF(DescribeNotificationConfigurationsOp(request))

  def describePolicies(
    request: DescribePoliciesRequest
  ): AutoScalingIO[DescribePoliciesResponse] =
    FF.liftF(DescribePoliciesOp(request))

  def describeScalingActivities(
    request: DescribeScalingActivitiesRequest
  ): AutoScalingIO[DescribeScalingActivitiesResponse] =
    FF.liftF(DescribeScalingActivitiesOp(request))

  def describeScalingProcessTypes(
    request: DescribeScalingProcessTypesRequest
  ): AutoScalingIO[DescribeScalingProcessTypesResponse] =
    FF.liftF(DescribeScalingProcessTypesOp(request))

  def describeScheduledActions(
    request: DescribeScheduledActionsRequest
  ): AutoScalingIO[DescribeScheduledActionsResponse] =
    FF.liftF(DescribeScheduledActionsOp(request))

  def describeTags(
    request: DescribeTagsRequest
  ): AutoScalingIO[DescribeTagsResponse] =
    FF.liftF(DescribeTagsOp(request))

  def describeTerminationPolicyTypes(
    request: DescribeTerminationPolicyTypesRequest
  ): AutoScalingIO[DescribeTerminationPolicyTypesResponse] =
    FF.liftF(DescribeTerminationPolicyTypesOp(request))

  def describeWarmPool(
    request: DescribeWarmPoolRequest
  ): AutoScalingIO[DescribeWarmPoolResponse] =
    FF.liftF(DescribeWarmPoolOp(request))

  def detachInstances(
    request: DetachInstancesRequest
  ): AutoScalingIO[DetachInstancesResponse] =
    FF.liftF(DetachInstancesOp(request))

  def detachLoadBalancerTargetGroups(
    request: DetachLoadBalancerTargetGroupsRequest
  ): AutoScalingIO[DetachLoadBalancerTargetGroupsResponse] =
    FF.liftF(DetachLoadBalancerTargetGroupsOp(request))

  def detachLoadBalancers(
    request: DetachLoadBalancersRequest
  ): AutoScalingIO[DetachLoadBalancersResponse] =
    FF.liftF(DetachLoadBalancersOp(request))

  def disableMetricsCollection(
    request: DisableMetricsCollectionRequest
  ): AutoScalingIO[DisableMetricsCollectionResponse] =
    FF.liftF(DisableMetricsCollectionOp(request))

  def enableMetricsCollection(
    request: EnableMetricsCollectionRequest
  ): AutoScalingIO[EnableMetricsCollectionResponse] =
    FF.liftF(EnableMetricsCollectionOp(request))

  def enterStandby(
    request: EnterStandbyRequest
  ): AutoScalingIO[EnterStandbyResponse] =
    FF.liftF(EnterStandbyOp(request))

  def executePolicy(
    request: ExecutePolicyRequest
  ): AutoScalingIO[ExecutePolicyResponse] =
    FF.liftF(ExecutePolicyOp(request))

  def exitStandby(
    request: ExitStandbyRequest
  ): AutoScalingIO[ExitStandbyResponse] =
    FF.liftF(ExitStandbyOp(request))

  def getPredictiveScalingForecast(
    request: GetPredictiveScalingForecastRequest
  ): AutoScalingIO[GetPredictiveScalingForecastResponse] =
    FF.liftF(GetPredictiveScalingForecastOp(request))

  def putLifecycleHook(
    request: PutLifecycleHookRequest
  ): AutoScalingIO[PutLifecycleHookResponse] =
    FF.liftF(PutLifecycleHookOp(request))

  def putNotificationConfiguration(
    request: PutNotificationConfigurationRequest
  ): AutoScalingIO[PutNotificationConfigurationResponse] =
    FF.liftF(PutNotificationConfigurationOp(request))

  def putScalingPolicy(
    request: PutScalingPolicyRequest
  ): AutoScalingIO[PutScalingPolicyResponse] =
    FF.liftF(PutScalingPolicyOp(request))

  def putScheduledUpdateGroupAction(
    request: PutScheduledUpdateGroupActionRequest
  ): AutoScalingIO[PutScheduledUpdateGroupActionResponse] =
    FF.liftF(PutScheduledUpdateGroupActionOp(request))

  def putWarmPool(
    request: PutWarmPoolRequest
  ): AutoScalingIO[PutWarmPoolResponse] =
    FF.liftF(PutWarmPoolOp(request))

  def recordLifecycleActionHeartbeat(
    request: RecordLifecycleActionHeartbeatRequest
  ): AutoScalingIO[RecordLifecycleActionHeartbeatResponse] =
    FF.liftF(RecordLifecycleActionHeartbeatOp(request))

  def resumeProcesses(
    request: ResumeProcessesRequest
  ): AutoScalingIO[ResumeProcessesResponse] =
    FF.liftF(ResumeProcessesOp(request))

  def setDesiredCapacity(
    request: SetDesiredCapacityRequest
  ): AutoScalingIO[SetDesiredCapacityResponse] =
    FF.liftF(SetDesiredCapacityOp(request))

  def setInstanceHealth(
    request: SetInstanceHealthRequest
  ): AutoScalingIO[SetInstanceHealthResponse] =
    FF.liftF(SetInstanceHealthOp(request))

  def setInstanceProtection(
    request: SetInstanceProtectionRequest
  ): AutoScalingIO[SetInstanceProtectionResponse] =
    FF.liftF(SetInstanceProtectionOp(request))

  def startInstanceRefresh(
    request: StartInstanceRefreshRequest
  ): AutoScalingIO[StartInstanceRefreshResponse] =
    FF.liftF(StartInstanceRefreshOp(request))

  def suspendProcesses(
    request: SuspendProcessesRequest
  ): AutoScalingIO[SuspendProcessesResponse] =
    FF.liftF(SuspendProcessesOp(request))

  def terminateInstanceInAutoScalingGroup(
    request: TerminateInstanceInAutoScalingGroupRequest
  ): AutoScalingIO[TerminateInstanceInAutoScalingGroupResponse] =
    FF.liftF(TerminateInstanceInAutoScalingGroupOp(request))

  def updateAutoScalingGroup(
    request: UpdateAutoScalingGroupRequest
  ): AutoScalingIO[UpdateAutoScalingGroupResponse] =
    FF.liftF(UpdateAutoScalingGroupOp(request))
}
