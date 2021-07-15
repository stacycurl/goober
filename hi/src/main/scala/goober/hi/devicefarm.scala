package goober.hi

import goober.free.devicefarm.DeviceFarmIO
import software.amazon.awssdk.services.devicefarm.model._


object devicefarm {
  import goober.free.{devicefarm ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // CreateDevicePoolRequest
    // CreateInstanceProfileRequest
    // CreateNetworkProfileRequest
    // CreateProjectRequest
    // CreateRemoteAccessSessionRequest
    // CreateTestGridProjectRequest
    // CreateTestGridUrlRequest
    // CreateUploadRequest
    // CreateVpceConfigurationRequest
    // DeleteDevicePoolRequest
    // DeleteInstanceProfileRequest
    // DeleteNetworkProfileRequest
    // DeleteProjectRequest
    // DeleteRemoteAccessSessionRequest
    // DeleteRunRequest
    // DeleteTestGridProjectRequest
    // DeleteUploadRequest
    // DeleteVpceConfigurationRequest
    // GetAccountSettingsRequest
    // GetDeviceRequest
    // GetDeviceInstanceRequest
    // GetDevicePoolRequest
    // GetDevicePoolCompatibilityRequest
    // GetInstanceProfileRequest
    // GetJobRequest
    // GetNetworkProfileRequest
    // GetOfferingStatusRequest
    // GetProjectRequest
    // GetRemoteAccessSessionRequest
    // GetRunRequest
    // GetSuiteRequest
    // GetTestRequest
    // GetTestGridProjectRequest
    // GetTestGridSessionRequest
    // GetUploadRequest
    // GetVpceConfigurationRequest
    // InstallToRemoteAccessSessionRequest
    // ListArtifactsRequest
    // ListDeviceInstancesRequest
    // ListDevicePoolsRequest
    // ListDevicesRequest
    // ListInstanceProfilesRequest
    // ListJobsRequest
    // ListNetworkProfilesRequest
    // ListOfferingPromotionsRequest
    // ListOfferingTransactionsRequest
    // ListOfferingsRequest
    // ListProjectsRequest
    // ListRemoteAccessSessionsRequest
    // ListRunsRequest
    // ListSamplesRequest
    // ListSuitesRequest
    // ListTagsForResourceRequest
    // ListTestGridProjectsRequest
    // ListTestGridSessionActionsRequest
    // ListTestGridSessionArtifactsRequest
    // ListTestGridSessionsRequest
    // ListTestsRequest
    // ListUniqueProblemsRequest
    // ListUploadsRequest
    // ListVpceConfigurationsRequest
    // PurchaseOfferingRequest
    // RenewOfferingRequest
    // ScheduleRunRequest
    // StopJobRequest
    // StopRemoteAccessSessionRequest
    // StopRunRequest
    // TagResourceRequest
    // UntagResourceRequest
    // UpdateDeviceInstanceRequest
    // UpdateDevicePoolRequest
    // UpdateInstanceProfileRequest
    // UpdateNetworkProfileRequest
    // UpdateProjectRequest
    // UpdateTestGridProjectRequest
    // UpdateUploadRequest
    // UpdateVpceConfigurationRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
