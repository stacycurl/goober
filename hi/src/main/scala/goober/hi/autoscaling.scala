package goober.hi

import goober.free.autoscaling.AutoScalingIO
import software.amazon.awssdk.services.autoscaling.model._


object autoscaling {
  import goober.free.{autoscaling ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // AttachInstancesRequest
    // AttachLoadBalancerTargetGroupsRequest
    // AttachLoadBalancersRequest
    // BatchDeleteScheduledActionRequest
    // BatchPutScheduledUpdateGroupActionRequest
    // CancelInstanceRefreshRequest
    // CompleteLifecycleActionRequest
    // CreateAutoScalingGroupRequest
    // CreateLaunchConfigurationRequest
    // CreateOrUpdateTagsRequest
    // DeleteAutoScalingGroupRequest
    // DeleteLaunchConfigurationRequest
    // DeleteLifecycleHookRequest
    // DeleteNotificationConfigurationRequest
    // DeletePolicyRequest
    // DeleteScheduledActionRequest
    // DeleteTagsRequest
    // DeleteWarmPoolRequest
    // DescribeAccountLimitsRequest
    // DescribeAdjustmentTypesRequest
    // DescribeAutoScalingGroupsRequest
    // DescribeAutoScalingInstancesRequest
    // DescribeAutoScalingNotificationTypesRequest
    // DescribeInstanceRefreshesRequest
    // DescribeLaunchConfigurationsRequest
    // DescribeLifecycleHookTypesRequest
    // DescribeLifecycleHooksRequest
    // DescribeLoadBalancerTargetGroupsRequest
    // DescribeLoadBalancersRequest
    // DescribeMetricCollectionTypesRequest
    // DescribeNotificationConfigurationsRequest
    // DescribePoliciesRequest
    // DescribeScalingActivitiesRequest
    // DescribeScalingProcessTypesRequest
    // DescribeScheduledActionsRequest
    // DescribeTagsRequest
    // DescribeTerminationPolicyTypesRequest
    // DescribeWarmPoolRequest
    // DetachInstancesRequest
    // DetachLoadBalancerTargetGroupsRequest
    // DetachLoadBalancersRequest
    // DisableMetricsCollectionRequest
    // EnableMetricsCollectionRequest
    // EnterStandbyRequest
    // ExecutePolicyRequest
    // ExitStandbyRequest
    // GetPredictiveScalingForecastRequest
    // PutLifecycleHookRequest
    // PutNotificationConfigurationRequest
    // PutScalingPolicyRequest
    // PutScheduledUpdateGroupActionRequest
    // PutWarmPoolRequest
    // RecordLifecycleActionHeartbeatRequest
    // ResumeProcessesRequest
    // SetDesiredCapacityRequest
    // SetInstanceHealthRequest
    // SetInstanceProtectionRequest
    // StartInstanceRefreshRequest
    // SuspendProcessesRequest
    // TerminateInstanceInAutoScalingGroupRequest
    // UpdateAutoScalingGroupRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
