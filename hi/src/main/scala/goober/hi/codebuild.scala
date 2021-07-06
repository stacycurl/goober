package goober.hi

import goober.free.codebuild.CodeBuildIO
import software.amazon.awssdk.services.codebuild.model._


object codebuild {
  import goober.free.{codebuild ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // BatchDeleteBuildsRequest
    // BatchGetBuildBatchesRequest
    // BatchGetBuildsRequest
    // BatchGetProjectsRequest
    // BatchGetReportGroupsRequest
    // BatchGetReportsRequest
    // CreateProjectRequest
    // CreateReportGroupRequest
    // CreateWebhookRequest
    // DeleteBuildBatchRequest
    // DeleteProjectRequest
    // DeleteReportGroupRequest
    // DeleteReportRequest
    // DeleteResourcePolicyRequest
    // DeleteSourceCredentialsRequest
    // DeleteWebhookRequest
    // DescribeCodeCoveragesRequest
    // DescribeTestCasesRequest
    // GetReportGroupTrendRequest
    // GetResourcePolicyRequest
    // ImportSourceCredentialsRequest
    // InvalidateProjectCacheRequest
    // ListBuildBatchesForProjectRequest
    // ListBuildBatchesRequest
    // ListBuildsForProjectRequest
    // ListBuildsRequest
    // ListCuratedEnvironmentImagesRequest
    // ListProjectsRequest
    // ListReportGroupsRequest
    // ListReportsForReportGroupRequest
    // ListReportsRequest
    // ListSharedProjectsRequest
    // ListSharedReportGroupsRequest
    // ListSourceCredentialsRequest
    // PutResourcePolicyRequest
    // RetryBuildBatchRequest
    // RetryBuildRequest
    // StartBuildBatchRequest
    // StartBuildRequest
    // StopBuildBatchRequest
    // StopBuildRequest
    // UpdateProjectRequest
    // UpdateReportGroupRequest
    // UpdateWebhookRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
