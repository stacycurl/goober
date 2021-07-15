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
    // DeleteReportRequest
    // DeleteReportGroupRequest
    // DeleteResourcePolicyRequest
    // DeleteSourceCredentialsRequest
    // DeleteWebhookRequest
    // DescribeCodeCoveragesRequest
    // DescribeTestCasesRequest
    // GetReportGroupTrendRequest
    // GetResourcePolicyRequest
    // ImportSourceCredentialsRequest
    // InvalidateProjectCacheRequest
    // ListBuildBatchesRequest
    // ListBuildBatchesForProjectRequest
    // ListBuildsRequest
    // ListBuildsForProjectRequest
    // ListCuratedEnvironmentImagesRequest
    // ListProjectsRequest
    // ListReportGroupsRequest
    // ListReportsRequest
    // ListReportsForReportGroupRequest
    // ListSharedProjectsRequest
    // ListSharedReportGroupsRequest
    // ListSourceCredentialsRequest
    // PutResourcePolicyRequest
    // RetryBuildRequest
    // RetryBuildBatchRequest
    // StartBuildRequest
    // StartBuildBatchRequest
    // StopBuildRequest
    // StopBuildBatchRequest
    // UpdateProjectRequest
    // UpdateReportGroupRequest
    // UpdateWebhookRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
