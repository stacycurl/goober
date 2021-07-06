package goober.hi

import goober.free.swf.SwfIO
import software.amazon.awssdk.services.swf.model._


object swf {
  import goober.free.{swf ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // CountClosedWorkflowExecutionsRequest
    // CountOpenWorkflowExecutionsRequest
    // CountPendingActivityTasksRequest
    // CountPendingDecisionTasksRequest
    // DeprecateActivityTypeRequest
    // DeprecateDomainRequest
    // DeprecateWorkflowTypeRequest
    // DescribeActivityTypeRequest
    // DescribeDomainRequest
    // DescribeWorkflowExecutionRequest
    // DescribeWorkflowTypeRequest
    // GetWorkflowExecutionHistoryRequest
    // ListActivityTypesRequest
    // ListClosedWorkflowExecutionsRequest
    // ListDomainsRequest
    // ListOpenWorkflowExecutionsRequest
    // ListTagsForResourceRequest
    // ListWorkflowTypesRequest
    // PollForActivityTaskRequest
    // PollForDecisionTaskRequest
    // RecordActivityTaskHeartbeatRequest
    // RegisterActivityTypeRequest
    // RegisterDomainRequest
    // RegisterWorkflowTypeRequest
    // RequestCancelWorkflowExecutionRequest
    // RespondActivityTaskCanceledRequest
    // RespondActivityTaskCompletedRequest
    // RespondActivityTaskFailedRequest
    // RespondDecisionTaskCompletedRequest
    // SignalWorkflowExecutionRequest
    // StartWorkflowExecutionRequest
    // TagResourceRequest
    // TerminateWorkflowExecutionRequest
    // UndeprecateActivityTypeRequest
    // UndeprecateDomainRequest
    // UndeprecateWorkflowTypeRequest
    // UntagResourceRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
