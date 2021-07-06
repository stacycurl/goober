package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.devicefarm.DeviceFarmClient
import software.amazon.awssdk.services.devicefarm.model._


object devicefarm { module =>

  // Free monad over DeviceFarmOp
  type DeviceFarmIO[A] = FF[DeviceFarmOp, A]

  sealed trait DeviceFarmOp[A] {
    def visit[F[_]](visitor: DeviceFarmOp.Visitor[F]): F[A]
  }

  object DeviceFarmOp {
    // Given a DeviceFarmClient we can embed a DeviceFarmIO program in any algebra that understands embedding.
    implicit val DeviceFarmOpEmbeddable: Embeddable[DeviceFarmOp, DeviceFarmClient] = new Embeddable[DeviceFarmOp, DeviceFarmClient] {
      def embed[A](client: DeviceFarmClient, io: DeviceFarmIO[A]): Embedded[A] = Embedded.DeviceFarm(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends DeviceFarmOp.Visitor[Kleisli[M, DeviceFarmClient, *]] {
        def createDevicePool(
          request: CreateDevicePoolRequest
        ): Kleisli[M, DeviceFarmClient, CreateDevicePoolResponse] =
          primitive(_.createDevicePool(request))

        def createInstanceProfile(
          request: CreateInstanceProfileRequest
        ): Kleisli[M, DeviceFarmClient, CreateInstanceProfileResponse] =
          primitive(_.createInstanceProfile(request))

        def createNetworkProfile(
          request: CreateNetworkProfileRequest
        ): Kleisli[M, DeviceFarmClient, CreateNetworkProfileResponse] =
          primitive(_.createNetworkProfile(request))

        def createProject(
          request: CreateProjectRequest
        ): Kleisli[M, DeviceFarmClient, CreateProjectResponse] =
          primitive(_.createProject(request))

        def createRemoteAccessSession(
          request: CreateRemoteAccessSessionRequest
        ): Kleisli[M, DeviceFarmClient, CreateRemoteAccessSessionResponse] =
          primitive(_.createRemoteAccessSession(request))

        def createTestGridProject(
          request: CreateTestGridProjectRequest
        ): Kleisli[M, DeviceFarmClient, CreateTestGridProjectResponse] =
          primitive(_.createTestGridProject(request))

        def createTestGridUrl(
          request: CreateTestGridUrlRequest
        ): Kleisli[M, DeviceFarmClient, CreateTestGridUrlResponse] =
          primitive(_.createTestGridUrl(request))

        def createUpload(
          request: CreateUploadRequest
        ): Kleisli[M, DeviceFarmClient, CreateUploadResponse] =
          primitive(_.createUpload(request))

        def createVPCEConfiguration(
          request: CreateVpceConfigurationRequest
        ): Kleisli[M, DeviceFarmClient, CreateVpceConfigurationResponse] =
          primitive(_.createVPCEConfiguration(request))

        def deleteDevicePool(
          request: DeleteDevicePoolRequest
        ): Kleisli[M, DeviceFarmClient, DeleteDevicePoolResponse] =
          primitive(_.deleteDevicePool(request))

        def deleteInstanceProfile(
          request: DeleteInstanceProfileRequest
        ): Kleisli[M, DeviceFarmClient, DeleteInstanceProfileResponse] =
          primitive(_.deleteInstanceProfile(request))

        def deleteNetworkProfile(
          request: DeleteNetworkProfileRequest
        ): Kleisli[M, DeviceFarmClient, DeleteNetworkProfileResponse] =
          primitive(_.deleteNetworkProfile(request))

        def deleteProject(
          request: DeleteProjectRequest
        ): Kleisli[M, DeviceFarmClient, DeleteProjectResponse] =
          primitive(_.deleteProject(request))

        def deleteRemoteAccessSession(
          request: DeleteRemoteAccessSessionRequest
        ): Kleisli[M, DeviceFarmClient, DeleteRemoteAccessSessionResponse] =
          primitive(_.deleteRemoteAccessSession(request))

        def deleteRun(
          request: DeleteRunRequest
        ): Kleisli[M, DeviceFarmClient, DeleteRunResponse] =
          primitive(_.deleteRun(request))

        def deleteTestGridProject(
          request: DeleteTestGridProjectRequest
        ): Kleisli[M, DeviceFarmClient, DeleteTestGridProjectResponse] =
          primitive(_.deleteTestGridProject(request))

        def deleteUpload(
          request: DeleteUploadRequest
        ): Kleisli[M, DeviceFarmClient, DeleteUploadResponse] =
          primitive(_.deleteUpload(request))

        def deleteVPCEConfiguration(
          request: DeleteVpceConfigurationRequest
        ): Kleisli[M, DeviceFarmClient, DeleteVpceConfigurationResponse] =
          primitive(_.deleteVPCEConfiguration(request))

        def getAccountSettings(
          request: GetAccountSettingsRequest
        ): Kleisli[M, DeviceFarmClient, GetAccountSettingsResponse] =
          primitive(_.getAccountSettings(request))

        def getDevice(
          request: GetDeviceRequest
        ): Kleisli[M, DeviceFarmClient, GetDeviceResponse] =
          primitive(_.getDevice(request))

        def getDeviceInstance(
          request: GetDeviceInstanceRequest
        ): Kleisli[M, DeviceFarmClient, GetDeviceInstanceResponse] =
          primitive(_.getDeviceInstance(request))

        def getDevicePool(
          request: GetDevicePoolRequest
        ): Kleisli[M, DeviceFarmClient, GetDevicePoolResponse] =
          primitive(_.getDevicePool(request))

        def getDevicePoolCompatibility(
          request: GetDevicePoolCompatibilityRequest
        ): Kleisli[M, DeviceFarmClient, GetDevicePoolCompatibilityResponse] =
          primitive(_.getDevicePoolCompatibility(request))

        def getInstanceProfile(
          request: GetInstanceProfileRequest
        ): Kleisli[M, DeviceFarmClient, GetInstanceProfileResponse] =
          primitive(_.getInstanceProfile(request))

        def getJob(
          request: GetJobRequest
        ): Kleisli[M, DeviceFarmClient, GetJobResponse] =
          primitive(_.getJob(request))

        def getNetworkProfile(
          request: GetNetworkProfileRequest
        ): Kleisli[M, DeviceFarmClient, GetNetworkProfileResponse] =
          primitive(_.getNetworkProfile(request))

        def getOfferingStatus(
          request: GetOfferingStatusRequest
        ): Kleisli[M, DeviceFarmClient, GetOfferingStatusResponse] =
          primitive(_.getOfferingStatus(request))

        def getProject(
          request: GetProjectRequest
        ): Kleisli[M, DeviceFarmClient, GetProjectResponse] =
          primitive(_.getProject(request))

        def getRemoteAccessSession(
          request: GetRemoteAccessSessionRequest
        ): Kleisli[M, DeviceFarmClient, GetRemoteAccessSessionResponse] =
          primitive(_.getRemoteAccessSession(request))

        def getRun(
          request: GetRunRequest
        ): Kleisli[M, DeviceFarmClient, GetRunResponse] =
          primitive(_.getRun(request))

        def getSuite(
          request: GetSuiteRequest
        ): Kleisli[M, DeviceFarmClient, GetSuiteResponse] =
          primitive(_.getSuite(request))

        def getTest(
          request: GetTestRequest
        ): Kleisli[M, DeviceFarmClient, GetTestResponse] =
          primitive(_.getTest(request))

        def getTestGridProject(
          request: GetTestGridProjectRequest
        ): Kleisli[M, DeviceFarmClient, GetTestGridProjectResponse] =
          primitive(_.getTestGridProject(request))

        def getTestGridSession(
          request: GetTestGridSessionRequest
        ): Kleisli[M, DeviceFarmClient, GetTestGridSessionResponse] =
          primitive(_.getTestGridSession(request))

        def getUpload(
          request: GetUploadRequest
        ): Kleisli[M, DeviceFarmClient, GetUploadResponse] =
          primitive(_.getUpload(request))

        def getVPCEConfiguration(
          request: GetVpceConfigurationRequest
        ): Kleisli[M, DeviceFarmClient, GetVpceConfigurationResponse] =
          primitive(_.getVPCEConfiguration(request))

        def installToRemoteAccessSession(
          request: InstallToRemoteAccessSessionRequest
        ): Kleisli[M, DeviceFarmClient, InstallToRemoteAccessSessionResponse] =
          primitive(_.installToRemoteAccessSession(request))

        def listArtifacts(
          request: ListArtifactsRequest
        ): Kleisli[M, DeviceFarmClient, ListArtifactsResponse] =
          primitive(_.listArtifacts(request))

        def listDeviceInstances(
          request: ListDeviceInstancesRequest
        ): Kleisli[M, DeviceFarmClient, ListDeviceInstancesResponse] =
          primitive(_.listDeviceInstances(request))

        def listDevicePools(
          request: ListDevicePoolsRequest
        ): Kleisli[M, DeviceFarmClient, ListDevicePoolsResponse] =
          primitive(_.listDevicePools(request))

        def listDevices(
          request: ListDevicesRequest
        ): Kleisli[M, DeviceFarmClient, ListDevicesResponse] =
          primitive(_.listDevices(request))

        def listInstanceProfiles(
          request: ListInstanceProfilesRequest
        ): Kleisli[M, DeviceFarmClient, ListInstanceProfilesResponse] =
          primitive(_.listInstanceProfiles(request))

        def listJobs(
          request: ListJobsRequest
        ): Kleisli[M, DeviceFarmClient, ListJobsResponse] =
          primitive(_.listJobs(request))

        def listNetworkProfiles(
          request: ListNetworkProfilesRequest
        ): Kleisli[M, DeviceFarmClient, ListNetworkProfilesResponse] =
          primitive(_.listNetworkProfiles(request))

        def listOfferingPromotions(
          request: ListOfferingPromotionsRequest
        ): Kleisli[M, DeviceFarmClient, ListOfferingPromotionsResponse] =
          primitive(_.listOfferingPromotions(request))

        def listOfferingTransactions(
          request: ListOfferingTransactionsRequest
        ): Kleisli[M, DeviceFarmClient, ListOfferingTransactionsResponse] =
          primitive(_.listOfferingTransactions(request))

        def listOfferings(
          request: ListOfferingsRequest
        ): Kleisli[M, DeviceFarmClient, ListOfferingsResponse] =
          primitive(_.listOfferings(request))

        def listProjects(
          request: ListProjectsRequest
        ): Kleisli[M, DeviceFarmClient, ListProjectsResponse] =
          primitive(_.listProjects(request))

        def listRemoteAccessSessions(
          request: ListRemoteAccessSessionsRequest
        ): Kleisli[M, DeviceFarmClient, ListRemoteAccessSessionsResponse] =
          primitive(_.listRemoteAccessSessions(request))

        def listRuns(
          request: ListRunsRequest
        ): Kleisli[M, DeviceFarmClient, ListRunsResponse] =
          primitive(_.listRuns(request))

        def listSamples(
          request: ListSamplesRequest
        ): Kleisli[M, DeviceFarmClient, ListSamplesResponse] =
          primitive(_.listSamples(request))

        def listSuites(
          request: ListSuitesRequest
        ): Kleisli[M, DeviceFarmClient, ListSuitesResponse] =
          primitive(_.listSuites(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, DeviceFarmClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTestGridProjects(
          request: ListTestGridProjectsRequest
        ): Kleisli[M, DeviceFarmClient, ListTestGridProjectsResponse] =
          primitive(_.listTestGridProjects(request))

        def listTestGridSessionActions(
          request: ListTestGridSessionActionsRequest
        ): Kleisli[M, DeviceFarmClient, ListTestGridSessionActionsResponse] =
          primitive(_.listTestGridSessionActions(request))

        def listTestGridSessionArtifacts(
          request: ListTestGridSessionArtifactsRequest
        ): Kleisli[M, DeviceFarmClient, ListTestGridSessionArtifactsResponse] =
          primitive(_.listTestGridSessionArtifacts(request))

        def listTestGridSessions(
          request: ListTestGridSessionsRequest
        ): Kleisli[M, DeviceFarmClient, ListTestGridSessionsResponse] =
          primitive(_.listTestGridSessions(request))

        def listTests(
          request: ListTestsRequest
        ): Kleisli[M, DeviceFarmClient, ListTestsResponse] =
          primitive(_.listTests(request))

        def listUniqueProblems(
          request: ListUniqueProblemsRequest
        ): Kleisli[M, DeviceFarmClient, ListUniqueProblemsResponse] =
          primitive(_.listUniqueProblems(request))

        def listUploads(
          request: ListUploadsRequest
        ): Kleisli[M, DeviceFarmClient, ListUploadsResponse] =
          primitive(_.listUploads(request))

        def listVPCEConfigurations(
          request: ListVpceConfigurationsRequest
        ): Kleisli[M, DeviceFarmClient, ListVpceConfigurationsResponse] =
          primitive(_.listVPCEConfigurations(request))

        def purchaseOffering(
          request: PurchaseOfferingRequest
        ): Kleisli[M, DeviceFarmClient, PurchaseOfferingResponse] =
          primitive(_.purchaseOffering(request))

        def renewOffering(
          request: RenewOfferingRequest
        ): Kleisli[M, DeviceFarmClient, RenewOfferingResponse] =
          primitive(_.renewOffering(request))

        def scheduleRun(
          request: ScheduleRunRequest
        ): Kleisli[M, DeviceFarmClient, ScheduleRunResponse] =
          primitive(_.scheduleRun(request))

        def stopJob(
          request: StopJobRequest
        ): Kleisli[M, DeviceFarmClient, StopJobResponse] =
          primitive(_.stopJob(request))

        def stopRemoteAccessSession(
          request: StopRemoteAccessSessionRequest
        ): Kleisli[M, DeviceFarmClient, StopRemoteAccessSessionResponse] =
          primitive(_.stopRemoteAccessSession(request))

        def stopRun(
          request: StopRunRequest
        ): Kleisli[M, DeviceFarmClient, StopRunResponse] =
          primitive(_.stopRun(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, DeviceFarmClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, DeviceFarmClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateDeviceInstance(
          request: UpdateDeviceInstanceRequest
        ): Kleisli[M, DeviceFarmClient, UpdateDeviceInstanceResponse] =
          primitive(_.updateDeviceInstance(request))

        def updateDevicePool(
          request: UpdateDevicePoolRequest
        ): Kleisli[M, DeviceFarmClient, UpdateDevicePoolResponse] =
          primitive(_.updateDevicePool(request))

        def updateInstanceProfile(
          request: UpdateInstanceProfileRequest
        ): Kleisli[M, DeviceFarmClient, UpdateInstanceProfileResponse] =
          primitive(_.updateInstanceProfile(request))

        def updateNetworkProfile(
          request: UpdateNetworkProfileRequest
        ): Kleisli[M, DeviceFarmClient, UpdateNetworkProfileResponse] =
          primitive(_.updateNetworkProfile(request))

        def updateProject(
          request: UpdateProjectRequest
        ): Kleisli[M, DeviceFarmClient, UpdateProjectResponse] =
          primitive(_.updateProject(request))

        def updateTestGridProject(
          request: UpdateTestGridProjectRequest
        ): Kleisli[M, DeviceFarmClient, UpdateTestGridProjectResponse] =
          primitive(_.updateTestGridProject(request))

        def updateUpload(
          request: UpdateUploadRequest
        ): Kleisli[M, DeviceFarmClient, UpdateUploadResponse] =
          primitive(_.updateUpload(request))

        def updateVPCEConfiguration(
          request: UpdateVpceConfigurationRequest
        ): Kleisli[M, DeviceFarmClient, UpdateVpceConfigurationResponse] =
          primitive(_.updateVPCEConfiguration(request))

        def primitive[A](
          f: DeviceFarmClient => A
        ): Kleisli[M, DeviceFarmClient, A]
      }
    }

    trait Visitor[F[_]] extends (DeviceFarmOp ~> F) {
      final def apply[A](op: DeviceFarmOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createDevicePool(
        request: CreateDevicePoolRequest
      ): F[CreateDevicePoolResponse]

      def createInstanceProfile(
        request: CreateInstanceProfileRequest
      ): F[CreateInstanceProfileResponse]

      def createNetworkProfile(
        request: CreateNetworkProfileRequest
      ): F[CreateNetworkProfileResponse]

      def createProject(
        request: CreateProjectRequest
      ): F[CreateProjectResponse]

      def createRemoteAccessSession(
        request: CreateRemoteAccessSessionRequest
      ): F[CreateRemoteAccessSessionResponse]

      def createTestGridProject(
        request: CreateTestGridProjectRequest
      ): F[CreateTestGridProjectResponse]

      def createTestGridUrl(
        request: CreateTestGridUrlRequest
      ): F[CreateTestGridUrlResponse]

      def createUpload(
        request: CreateUploadRequest
      ): F[CreateUploadResponse]

      def createVPCEConfiguration(
        request: CreateVpceConfigurationRequest
      ): F[CreateVpceConfigurationResponse]

      def deleteDevicePool(
        request: DeleteDevicePoolRequest
      ): F[DeleteDevicePoolResponse]

      def deleteInstanceProfile(
        request: DeleteInstanceProfileRequest
      ): F[DeleteInstanceProfileResponse]

      def deleteNetworkProfile(
        request: DeleteNetworkProfileRequest
      ): F[DeleteNetworkProfileResponse]

      def deleteProject(
        request: DeleteProjectRequest
      ): F[DeleteProjectResponse]

      def deleteRemoteAccessSession(
        request: DeleteRemoteAccessSessionRequest
      ): F[DeleteRemoteAccessSessionResponse]

      def deleteRun(
        request: DeleteRunRequest
      ): F[DeleteRunResponse]

      def deleteTestGridProject(
        request: DeleteTestGridProjectRequest
      ): F[DeleteTestGridProjectResponse]

      def deleteUpload(
        request: DeleteUploadRequest
      ): F[DeleteUploadResponse]

      def deleteVPCEConfiguration(
        request: DeleteVpceConfigurationRequest
      ): F[DeleteVpceConfigurationResponse]

      def getAccountSettings(
        request: GetAccountSettingsRequest
      ): F[GetAccountSettingsResponse]

      def getDevice(
        request: GetDeviceRequest
      ): F[GetDeviceResponse]

      def getDeviceInstance(
        request: GetDeviceInstanceRequest
      ): F[GetDeviceInstanceResponse]

      def getDevicePool(
        request: GetDevicePoolRequest
      ): F[GetDevicePoolResponse]

      def getDevicePoolCompatibility(
        request: GetDevicePoolCompatibilityRequest
      ): F[GetDevicePoolCompatibilityResponse]

      def getInstanceProfile(
        request: GetInstanceProfileRequest
      ): F[GetInstanceProfileResponse]

      def getJob(
        request: GetJobRequest
      ): F[GetJobResponse]

      def getNetworkProfile(
        request: GetNetworkProfileRequest
      ): F[GetNetworkProfileResponse]

      def getOfferingStatus(
        request: GetOfferingStatusRequest
      ): F[GetOfferingStatusResponse]

      def getProject(
        request: GetProjectRequest
      ): F[GetProjectResponse]

      def getRemoteAccessSession(
        request: GetRemoteAccessSessionRequest
      ): F[GetRemoteAccessSessionResponse]

      def getRun(
        request: GetRunRequest
      ): F[GetRunResponse]

      def getSuite(
        request: GetSuiteRequest
      ): F[GetSuiteResponse]

      def getTest(
        request: GetTestRequest
      ): F[GetTestResponse]

      def getTestGridProject(
        request: GetTestGridProjectRequest
      ): F[GetTestGridProjectResponse]

      def getTestGridSession(
        request: GetTestGridSessionRequest
      ): F[GetTestGridSessionResponse]

      def getUpload(
        request: GetUploadRequest
      ): F[GetUploadResponse]

      def getVPCEConfiguration(
        request: GetVpceConfigurationRequest
      ): F[GetVpceConfigurationResponse]

      def installToRemoteAccessSession(
        request: InstallToRemoteAccessSessionRequest
      ): F[InstallToRemoteAccessSessionResponse]

      def listArtifacts(
        request: ListArtifactsRequest
      ): F[ListArtifactsResponse]

      def listDeviceInstances(
        request: ListDeviceInstancesRequest
      ): F[ListDeviceInstancesResponse]

      def listDevicePools(
        request: ListDevicePoolsRequest
      ): F[ListDevicePoolsResponse]

      def listDevices(
        request: ListDevicesRequest
      ): F[ListDevicesResponse]

      def listInstanceProfiles(
        request: ListInstanceProfilesRequest
      ): F[ListInstanceProfilesResponse]

      def listJobs(
        request: ListJobsRequest
      ): F[ListJobsResponse]

      def listNetworkProfiles(
        request: ListNetworkProfilesRequest
      ): F[ListNetworkProfilesResponse]

      def listOfferingPromotions(
        request: ListOfferingPromotionsRequest
      ): F[ListOfferingPromotionsResponse]

      def listOfferingTransactions(
        request: ListOfferingTransactionsRequest
      ): F[ListOfferingTransactionsResponse]

      def listOfferings(
        request: ListOfferingsRequest
      ): F[ListOfferingsResponse]

      def listProjects(
        request: ListProjectsRequest
      ): F[ListProjectsResponse]

      def listRemoteAccessSessions(
        request: ListRemoteAccessSessionsRequest
      ): F[ListRemoteAccessSessionsResponse]

      def listRuns(
        request: ListRunsRequest
      ): F[ListRunsResponse]

      def listSamples(
        request: ListSamplesRequest
      ): F[ListSamplesResponse]

      def listSuites(
        request: ListSuitesRequest
      ): F[ListSuitesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTestGridProjects(
        request: ListTestGridProjectsRequest
      ): F[ListTestGridProjectsResponse]

      def listTestGridSessionActions(
        request: ListTestGridSessionActionsRequest
      ): F[ListTestGridSessionActionsResponse]

      def listTestGridSessionArtifacts(
        request: ListTestGridSessionArtifactsRequest
      ): F[ListTestGridSessionArtifactsResponse]

      def listTestGridSessions(
        request: ListTestGridSessionsRequest
      ): F[ListTestGridSessionsResponse]

      def listTests(
        request: ListTestsRequest
      ): F[ListTestsResponse]

      def listUniqueProblems(
        request: ListUniqueProblemsRequest
      ): F[ListUniqueProblemsResponse]

      def listUploads(
        request: ListUploadsRequest
      ): F[ListUploadsResponse]

      def listVPCEConfigurations(
        request: ListVpceConfigurationsRequest
      ): F[ListVpceConfigurationsResponse]

      def purchaseOffering(
        request: PurchaseOfferingRequest
      ): F[PurchaseOfferingResponse]

      def renewOffering(
        request: RenewOfferingRequest
      ): F[RenewOfferingResponse]

      def scheduleRun(
        request: ScheduleRunRequest
      ): F[ScheduleRunResponse]

      def stopJob(
        request: StopJobRequest
      ): F[StopJobResponse]

      def stopRemoteAccessSession(
        request: StopRemoteAccessSessionRequest
      ): F[StopRemoteAccessSessionResponse]

      def stopRun(
        request: StopRunRequest
      ): F[StopRunResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateDeviceInstance(
        request: UpdateDeviceInstanceRequest
      ): F[UpdateDeviceInstanceResponse]

      def updateDevicePool(
        request: UpdateDevicePoolRequest
      ): F[UpdateDevicePoolResponse]

      def updateInstanceProfile(
        request: UpdateInstanceProfileRequest
      ): F[UpdateInstanceProfileResponse]

      def updateNetworkProfile(
        request: UpdateNetworkProfileRequest
      ): F[UpdateNetworkProfileResponse]

      def updateProject(
        request: UpdateProjectRequest
      ): F[UpdateProjectResponse]

      def updateTestGridProject(
        request: UpdateTestGridProjectRequest
      ): F[UpdateTestGridProjectResponse]

      def updateUpload(
        request: UpdateUploadRequest
      ): F[UpdateUploadResponse]

      def updateVPCEConfiguration(
        request: UpdateVpceConfigurationRequest
      ): F[UpdateVpceConfigurationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends DeviceFarmOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateDevicePoolOp(
      request: CreateDevicePoolRequest
    ) extends DeviceFarmOp[CreateDevicePoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDevicePoolResponse] =
        visitor.createDevicePool(request)
    }

    final case class CreateInstanceProfileOp(
      request: CreateInstanceProfileRequest
    ) extends DeviceFarmOp[CreateInstanceProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateInstanceProfileResponse] =
        visitor.createInstanceProfile(request)
    }

    final case class CreateNetworkProfileOp(
      request: CreateNetworkProfileRequest
    ) extends DeviceFarmOp[CreateNetworkProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateNetworkProfileResponse] =
        visitor.createNetworkProfile(request)
    }

    final case class CreateProjectOp(
      request: CreateProjectRequest
    ) extends DeviceFarmOp[CreateProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProjectResponse] =
        visitor.createProject(request)
    }

    final case class CreateRemoteAccessSessionOp(
      request: CreateRemoteAccessSessionRequest
    ) extends DeviceFarmOp[CreateRemoteAccessSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRemoteAccessSessionResponse] =
        visitor.createRemoteAccessSession(request)
    }

    final case class CreateTestGridProjectOp(
      request: CreateTestGridProjectRequest
    ) extends DeviceFarmOp[CreateTestGridProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTestGridProjectResponse] =
        visitor.createTestGridProject(request)
    }

    final case class CreateTestGridUrlOp(
      request: CreateTestGridUrlRequest
    ) extends DeviceFarmOp[CreateTestGridUrlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTestGridUrlResponse] =
        visitor.createTestGridUrl(request)
    }

    final case class CreateUploadOp(
      request: CreateUploadRequest
    ) extends DeviceFarmOp[CreateUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUploadResponse] =
        visitor.createUpload(request)
    }

    final case class CreateVPCEConfigurationOp(
      request: CreateVpceConfigurationRequest
    ) extends DeviceFarmOp[CreateVpceConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVpceConfigurationResponse] =
        visitor.createVPCEConfiguration(request)
    }

    final case class DeleteDevicePoolOp(
      request: DeleteDevicePoolRequest
    ) extends DeviceFarmOp[DeleteDevicePoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDevicePoolResponse] =
        visitor.deleteDevicePool(request)
    }

    final case class DeleteInstanceProfileOp(
      request: DeleteInstanceProfileRequest
    ) extends DeviceFarmOp[DeleteInstanceProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInstanceProfileResponse] =
        visitor.deleteInstanceProfile(request)
    }

    final case class DeleteNetworkProfileOp(
      request: DeleteNetworkProfileRequest
    ) extends DeviceFarmOp[DeleteNetworkProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNetworkProfileResponse] =
        visitor.deleteNetworkProfile(request)
    }

    final case class DeleteProjectOp(
      request: DeleteProjectRequest
    ) extends DeviceFarmOp[DeleteProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProjectResponse] =
        visitor.deleteProject(request)
    }

    final case class DeleteRemoteAccessSessionOp(
      request: DeleteRemoteAccessSessionRequest
    ) extends DeviceFarmOp[DeleteRemoteAccessSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRemoteAccessSessionResponse] =
        visitor.deleteRemoteAccessSession(request)
    }

    final case class DeleteRunOp(
      request: DeleteRunRequest
    ) extends DeviceFarmOp[DeleteRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRunResponse] =
        visitor.deleteRun(request)
    }

    final case class DeleteTestGridProjectOp(
      request: DeleteTestGridProjectRequest
    ) extends DeviceFarmOp[DeleteTestGridProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTestGridProjectResponse] =
        visitor.deleteTestGridProject(request)
    }

    final case class DeleteUploadOp(
      request: DeleteUploadRequest
    ) extends DeviceFarmOp[DeleteUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUploadResponse] =
        visitor.deleteUpload(request)
    }

    final case class DeleteVPCEConfigurationOp(
      request: DeleteVpceConfigurationRequest
    ) extends DeviceFarmOp[DeleteVpceConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVpceConfigurationResponse] =
        visitor.deleteVPCEConfiguration(request)
    }

    final case class GetAccountSettingsOp(
      request: GetAccountSettingsRequest
    ) extends DeviceFarmOp[GetAccountSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccountSettingsResponse] =
        visitor.getAccountSettings(request)
    }

    final case class GetDeviceOp(
      request: GetDeviceRequest
    ) extends DeviceFarmOp[GetDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeviceResponse] =
        visitor.getDevice(request)
    }

    final case class GetDeviceInstanceOp(
      request: GetDeviceInstanceRequest
    ) extends DeviceFarmOp[GetDeviceInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeviceInstanceResponse] =
        visitor.getDeviceInstance(request)
    }

    final case class GetDevicePoolOp(
      request: GetDevicePoolRequest
    ) extends DeviceFarmOp[GetDevicePoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDevicePoolResponse] =
        visitor.getDevicePool(request)
    }

    final case class GetDevicePoolCompatibilityOp(
      request: GetDevicePoolCompatibilityRequest
    ) extends DeviceFarmOp[GetDevicePoolCompatibilityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDevicePoolCompatibilityResponse] =
        visitor.getDevicePoolCompatibility(request)
    }

    final case class GetInstanceProfileOp(
      request: GetInstanceProfileRequest
    ) extends DeviceFarmOp[GetInstanceProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInstanceProfileResponse] =
        visitor.getInstanceProfile(request)
    }

    final case class GetJobOp(
      request: GetJobRequest
    ) extends DeviceFarmOp[GetJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJobResponse] =
        visitor.getJob(request)
    }

    final case class GetNetworkProfileOp(
      request: GetNetworkProfileRequest
    ) extends DeviceFarmOp[GetNetworkProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetNetworkProfileResponse] =
        visitor.getNetworkProfile(request)
    }

    final case class GetOfferingStatusOp(
      request: GetOfferingStatusRequest
    ) extends DeviceFarmOp[GetOfferingStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOfferingStatusResponse] =
        visitor.getOfferingStatus(request)
    }

    final case class GetProjectOp(
      request: GetProjectRequest
    ) extends DeviceFarmOp[GetProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetProjectResponse] =
        visitor.getProject(request)
    }

    final case class GetRemoteAccessSessionOp(
      request: GetRemoteAccessSessionRequest
    ) extends DeviceFarmOp[GetRemoteAccessSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRemoteAccessSessionResponse] =
        visitor.getRemoteAccessSession(request)
    }

    final case class GetRunOp(
      request: GetRunRequest
    ) extends DeviceFarmOp[GetRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRunResponse] =
        visitor.getRun(request)
    }

    final case class GetSuiteOp(
      request: GetSuiteRequest
    ) extends DeviceFarmOp[GetSuiteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSuiteResponse] =
        visitor.getSuite(request)
    }

    final case class GetTestOp(
      request: GetTestRequest
    ) extends DeviceFarmOp[GetTestResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTestResponse] =
        visitor.getTest(request)
    }

    final case class GetTestGridProjectOp(
      request: GetTestGridProjectRequest
    ) extends DeviceFarmOp[GetTestGridProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTestGridProjectResponse] =
        visitor.getTestGridProject(request)
    }

    final case class GetTestGridSessionOp(
      request: GetTestGridSessionRequest
    ) extends DeviceFarmOp[GetTestGridSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTestGridSessionResponse] =
        visitor.getTestGridSession(request)
    }

    final case class GetUploadOp(
      request: GetUploadRequest
    ) extends DeviceFarmOp[GetUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUploadResponse] =
        visitor.getUpload(request)
    }

    final case class GetVPCEConfigurationOp(
      request: GetVpceConfigurationRequest
    ) extends DeviceFarmOp[GetVpceConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVpceConfigurationResponse] =
        visitor.getVPCEConfiguration(request)
    }

    final case class InstallToRemoteAccessSessionOp(
      request: InstallToRemoteAccessSessionRequest
    ) extends DeviceFarmOp[InstallToRemoteAccessSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InstallToRemoteAccessSessionResponse] =
        visitor.installToRemoteAccessSession(request)
    }

    final case class ListArtifactsOp(
      request: ListArtifactsRequest
    ) extends DeviceFarmOp[ListArtifactsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListArtifactsResponse] =
        visitor.listArtifacts(request)
    }

    final case class ListDeviceInstancesOp(
      request: ListDeviceInstancesRequest
    ) extends DeviceFarmOp[ListDeviceInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeviceInstancesResponse] =
        visitor.listDeviceInstances(request)
    }

    final case class ListDevicePoolsOp(
      request: ListDevicePoolsRequest
    ) extends DeviceFarmOp[ListDevicePoolsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDevicePoolsResponse] =
        visitor.listDevicePools(request)
    }

    final case class ListDevicesOp(
      request: ListDevicesRequest
    ) extends DeviceFarmOp[ListDevicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDevicesResponse] =
        visitor.listDevices(request)
    }

    final case class ListInstanceProfilesOp(
      request: ListInstanceProfilesRequest
    ) extends DeviceFarmOp[ListInstanceProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInstanceProfilesResponse] =
        visitor.listInstanceProfiles(request)
    }

    final case class ListJobsOp(
      request: ListJobsRequest
    ) extends DeviceFarmOp[ListJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJobsResponse] =
        visitor.listJobs(request)
    }

    final case class ListNetworkProfilesOp(
      request: ListNetworkProfilesRequest
    ) extends DeviceFarmOp[ListNetworkProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListNetworkProfilesResponse] =
        visitor.listNetworkProfiles(request)
    }

    final case class ListOfferingPromotionsOp(
      request: ListOfferingPromotionsRequest
    ) extends DeviceFarmOp[ListOfferingPromotionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOfferingPromotionsResponse] =
        visitor.listOfferingPromotions(request)
    }

    final case class ListOfferingTransactionsOp(
      request: ListOfferingTransactionsRequest
    ) extends DeviceFarmOp[ListOfferingTransactionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOfferingTransactionsResponse] =
        visitor.listOfferingTransactions(request)
    }

    final case class ListOfferingsOp(
      request: ListOfferingsRequest
    ) extends DeviceFarmOp[ListOfferingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOfferingsResponse] =
        visitor.listOfferings(request)
    }

    final case class ListProjectsOp(
      request: ListProjectsRequest
    ) extends DeviceFarmOp[ListProjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProjectsResponse] =
        visitor.listProjects(request)
    }

    final case class ListRemoteAccessSessionsOp(
      request: ListRemoteAccessSessionsRequest
    ) extends DeviceFarmOp[ListRemoteAccessSessionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRemoteAccessSessionsResponse] =
        visitor.listRemoteAccessSessions(request)
    }

    final case class ListRunsOp(
      request: ListRunsRequest
    ) extends DeviceFarmOp[ListRunsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRunsResponse] =
        visitor.listRuns(request)
    }

    final case class ListSamplesOp(
      request: ListSamplesRequest
    ) extends DeviceFarmOp[ListSamplesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSamplesResponse] =
        visitor.listSamples(request)
    }

    final case class ListSuitesOp(
      request: ListSuitesRequest
    ) extends DeviceFarmOp[ListSuitesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSuitesResponse] =
        visitor.listSuites(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends DeviceFarmOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTestGridProjectsOp(
      request: ListTestGridProjectsRequest
    ) extends DeviceFarmOp[ListTestGridProjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTestGridProjectsResponse] =
        visitor.listTestGridProjects(request)
    }

    final case class ListTestGridSessionActionsOp(
      request: ListTestGridSessionActionsRequest
    ) extends DeviceFarmOp[ListTestGridSessionActionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTestGridSessionActionsResponse] =
        visitor.listTestGridSessionActions(request)
    }

    final case class ListTestGridSessionArtifactsOp(
      request: ListTestGridSessionArtifactsRequest
    ) extends DeviceFarmOp[ListTestGridSessionArtifactsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTestGridSessionArtifactsResponse] =
        visitor.listTestGridSessionArtifacts(request)
    }

    final case class ListTestGridSessionsOp(
      request: ListTestGridSessionsRequest
    ) extends DeviceFarmOp[ListTestGridSessionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTestGridSessionsResponse] =
        visitor.listTestGridSessions(request)
    }

    final case class ListTestsOp(
      request: ListTestsRequest
    ) extends DeviceFarmOp[ListTestsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTestsResponse] =
        visitor.listTests(request)
    }

    final case class ListUniqueProblemsOp(
      request: ListUniqueProblemsRequest
    ) extends DeviceFarmOp[ListUniqueProblemsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUniqueProblemsResponse] =
        visitor.listUniqueProblems(request)
    }

    final case class ListUploadsOp(
      request: ListUploadsRequest
    ) extends DeviceFarmOp[ListUploadsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUploadsResponse] =
        visitor.listUploads(request)
    }

    final case class ListVPCEConfigurationsOp(
      request: ListVpceConfigurationsRequest
    ) extends DeviceFarmOp[ListVpceConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVpceConfigurationsResponse] =
        visitor.listVPCEConfigurations(request)
    }

    final case class PurchaseOfferingOp(
      request: PurchaseOfferingRequest
    ) extends DeviceFarmOp[PurchaseOfferingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PurchaseOfferingResponse] =
        visitor.purchaseOffering(request)
    }

    final case class RenewOfferingOp(
      request: RenewOfferingRequest
    ) extends DeviceFarmOp[RenewOfferingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RenewOfferingResponse] =
        visitor.renewOffering(request)
    }

    final case class ScheduleRunOp(
      request: ScheduleRunRequest
    ) extends DeviceFarmOp[ScheduleRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ScheduleRunResponse] =
        visitor.scheduleRun(request)
    }

    final case class StopJobOp(
      request: StopJobRequest
    ) extends DeviceFarmOp[StopJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopJobResponse] =
        visitor.stopJob(request)
    }

    final case class StopRemoteAccessSessionOp(
      request: StopRemoteAccessSessionRequest
    ) extends DeviceFarmOp[StopRemoteAccessSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopRemoteAccessSessionResponse] =
        visitor.stopRemoteAccessSession(request)
    }

    final case class StopRunOp(
      request: StopRunRequest
    ) extends DeviceFarmOp[StopRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopRunResponse] =
        visitor.stopRun(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends DeviceFarmOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends DeviceFarmOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateDeviceInstanceOp(
      request: UpdateDeviceInstanceRequest
    ) extends DeviceFarmOp[UpdateDeviceInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDeviceInstanceResponse] =
        visitor.updateDeviceInstance(request)
    }

    final case class UpdateDevicePoolOp(
      request: UpdateDevicePoolRequest
    ) extends DeviceFarmOp[UpdateDevicePoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDevicePoolResponse] =
        visitor.updateDevicePool(request)
    }

    final case class UpdateInstanceProfileOp(
      request: UpdateInstanceProfileRequest
    ) extends DeviceFarmOp[UpdateInstanceProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateInstanceProfileResponse] =
        visitor.updateInstanceProfile(request)
    }

    final case class UpdateNetworkProfileOp(
      request: UpdateNetworkProfileRequest
    ) extends DeviceFarmOp[UpdateNetworkProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateNetworkProfileResponse] =
        visitor.updateNetworkProfile(request)
    }

    final case class UpdateProjectOp(
      request: UpdateProjectRequest
    ) extends DeviceFarmOp[UpdateProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateProjectResponse] =
        visitor.updateProject(request)
    }

    final case class UpdateTestGridProjectOp(
      request: UpdateTestGridProjectRequest
    ) extends DeviceFarmOp[UpdateTestGridProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTestGridProjectResponse] =
        visitor.updateTestGridProject(request)
    }

    final case class UpdateUploadOp(
      request: UpdateUploadRequest
    ) extends DeviceFarmOp[UpdateUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUploadResponse] =
        visitor.updateUpload(request)
    }

    final case class UpdateVPCEConfigurationOp(
      request: UpdateVpceConfigurationRequest
    ) extends DeviceFarmOp[UpdateVpceConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateVpceConfigurationResponse] =
        visitor.updateVPCEConfiguration(request)
    }
  }

  import DeviceFarmOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[DeviceFarmOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createDevicePool(
    request: CreateDevicePoolRequest
  ): DeviceFarmIO[CreateDevicePoolResponse] =
    FF.liftF(CreateDevicePoolOp(request))

  def createInstanceProfile(
    request: CreateInstanceProfileRequest
  ): DeviceFarmIO[CreateInstanceProfileResponse] =
    FF.liftF(CreateInstanceProfileOp(request))

  def createNetworkProfile(
    request: CreateNetworkProfileRequest
  ): DeviceFarmIO[CreateNetworkProfileResponse] =
    FF.liftF(CreateNetworkProfileOp(request))

  def createProject(
    request: CreateProjectRequest
  ): DeviceFarmIO[CreateProjectResponse] =
    FF.liftF(CreateProjectOp(request))

  def createRemoteAccessSession(
    request: CreateRemoteAccessSessionRequest
  ): DeviceFarmIO[CreateRemoteAccessSessionResponse] =
    FF.liftF(CreateRemoteAccessSessionOp(request))

  def createTestGridProject(
    request: CreateTestGridProjectRequest
  ): DeviceFarmIO[CreateTestGridProjectResponse] =
    FF.liftF(CreateTestGridProjectOp(request))

  def createTestGridUrl(
    request: CreateTestGridUrlRequest
  ): DeviceFarmIO[CreateTestGridUrlResponse] =
    FF.liftF(CreateTestGridUrlOp(request))

  def createUpload(
    request: CreateUploadRequest
  ): DeviceFarmIO[CreateUploadResponse] =
    FF.liftF(CreateUploadOp(request))

  def createVPCEConfiguration(
    request: CreateVpceConfigurationRequest
  ): DeviceFarmIO[CreateVpceConfigurationResponse] =
    FF.liftF(CreateVPCEConfigurationOp(request))

  def deleteDevicePool(
    request: DeleteDevicePoolRequest
  ): DeviceFarmIO[DeleteDevicePoolResponse] =
    FF.liftF(DeleteDevicePoolOp(request))

  def deleteInstanceProfile(
    request: DeleteInstanceProfileRequest
  ): DeviceFarmIO[DeleteInstanceProfileResponse] =
    FF.liftF(DeleteInstanceProfileOp(request))

  def deleteNetworkProfile(
    request: DeleteNetworkProfileRequest
  ): DeviceFarmIO[DeleteNetworkProfileResponse] =
    FF.liftF(DeleteNetworkProfileOp(request))

  def deleteProject(
    request: DeleteProjectRequest
  ): DeviceFarmIO[DeleteProjectResponse] =
    FF.liftF(DeleteProjectOp(request))

  def deleteRemoteAccessSession(
    request: DeleteRemoteAccessSessionRequest
  ): DeviceFarmIO[DeleteRemoteAccessSessionResponse] =
    FF.liftF(DeleteRemoteAccessSessionOp(request))

  def deleteRun(
    request: DeleteRunRequest
  ): DeviceFarmIO[DeleteRunResponse] =
    FF.liftF(DeleteRunOp(request))

  def deleteTestGridProject(
    request: DeleteTestGridProjectRequest
  ): DeviceFarmIO[DeleteTestGridProjectResponse] =
    FF.liftF(DeleteTestGridProjectOp(request))

  def deleteUpload(
    request: DeleteUploadRequest
  ): DeviceFarmIO[DeleteUploadResponse] =
    FF.liftF(DeleteUploadOp(request))

  def deleteVPCEConfiguration(
    request: DeleteVpceConfigurationRequest
  ): DeviceFarmIO[DeleteVpceConfigurationResponse] =
    FF.liftF(DeleteVPCEConfigurationOp(request))

  def getAccountSettings(
    request: GetAccountSettingsRequest
  ): DeviceFarmIO[GetAccountSettingsResponse] =
    FF.liftF(GetAccountSettingsOp(request))

  def getDevice(
    request: GetDeviceRequest
  ): DeviceFarmIO[GetDeviceResponse] =
    FF.liftF(GetDeviceOp(request))

  def getDeviceInstance(
    request: GetDeviceInstanceRequest
  ): DeviceFarmIO[GetDeviceInstanceResponse] =
    FF.liftF(GetDeviceInstanceOp(request))

  def getDevicePool(
    request: GetDevicePoolRequest
  ): DeviceFarmIO[GetDevicePoolResponse] =
    FF.liftF(GetDevicePoolOp(request))

  def getDevicePoolCompatibility(
    request: GetDevicePoolCompatibilityRequest
  ): DeviceFarmIO[GetDevicePoolCompatibilityResponse] =
    FF.liftF(GetDevicePoolCompatibilityOp(request))

  def getInstanceProfile(
    request: GetInstanceProfileRequest
  ): DeviceFarmIO[GetInstanceProfileResponse] =
    FF.liftF(GetInstanceProfileOp(request))

  def getJob(
    request: GetJobRequest
  ): DeviceFarmIO[GetJobResponse] =
    FF.liftF(GetJobOp(request))

  def getNetworkProfile(
    request: GetNetworkProfileRequest
  ): DeviceFarmIO[GetNetworkProfileResponse] =
    FF.liftF(GetNetworkProfileOp(request))

  def getOfferingStatus(
    request: GetOfferingStatusRequest
  ): DeviceFarmIO[GetOfferingStatusResponse] =
    FF.liftF(GetOfferingStatusOp(request))

  def getProject(
    request: GetProjectRequest
  ): DeviceFarmIO[GetProjectResponse] =
    FF.liftF(GetProjectOp(request))

  def getRemoteAccessSession(
    request: GetRemoteAccessSessionRequest
  ): DeviceFarmIO[GetRemoteAccessSessionResponse] =
    FF.liftF(GetRemoteAccessSessionOp(request))

  def getRun(
    request: GetRunRequest
  ): DeviceFarmIO[GetRunResponse] =
    FF.liftF(GetRunOp(request))

  def getSuite(
    request: GetSuiteRequest
  ): DeviceFarmIO[GetSuiteResponse] =
    FF.liftF(GetSuiteOp(request))

  def getTest(
    request: GetTestRequest
  ): DeviceFarmIO[GetTestResponse] =
    FF.liftF(GetTestOp(request))

  def getTestGridProject(
    request: GetTestGridProjectRequest
  ): DeviceFarmIO[GetTestGridProjectResponse] =
    FF.liftF(GetTestGridProjectOp(request))

  def getTestGridSession(
    request: GetTestGridSessionRequest
  ): DeviceFarmIO[GetTestGridSessionResponse] =
    FF.liftF(GetTestGridSessionOp(request))

  def getUpload(
    request: GetUploadRequest
  ): DeviceFarmIO[GetUploadResponse] =
    FF.liftF(GetUploadOp(request))

  def getVPCEConfiguration(
    request: GetVpceConfigurationRequest
  ): DeviceFarmIO[GetVpceConfigurationResponse] =
    FF.liftF(GetVPCEConfigurationOp(request))

  def installToRemoteAccessSession(
    request: InstallToRemoteAccessSessionRequest
  ): DeviceFarmIO[InstallToRemoteAccessSessionResponse] =
    FF.liftF(InstallToRemoteAccessSessionOp(request))

  def listArtifacts(
    request: ListArtifactsRequest
  ): DeviceFarmIO[ListArtifactsResponse] =
    FF.liftF(ListArtifactsOp(request))

  def listDeviceInstances(
    request: ListDeviceInstancesRequest
  ): DeviceFarmIO[ListDeviceInstancesResponse] =
    FF.liftF(ListDeviceInstancesOp(request))

  def listDevicePools(
    request: ListDevicePoolsRequest
  ): DeviceFarmIO[ListDevicePoolsResponse] =
    FF.liftF(ListDevicePoolsOp(request))

  def listDevices(
    request: ListDevicesRequest
  ): DeviceFarmIO[ListDevicesResponse] =
    FF.liftF(ListDevicesOp(request))

  def listInstanceProfiles(
    request: ListInstanceProfilesRequest
  ): DeviceFarmIO[ListInstanceProfilesResponse] =
    FF.liftF(ListInstanceProfilesOp(request))

  def listJobs(
    request: ListJobsRequest
  ): DeviceFarmIO[ListJobsResponse] =
    FF.liftF(ListJobsOp(request))

  def listNetworkProfiles(
    request: ListNetworkProfilesRequest
  ): DeviceFarmIO[ListNetworkProfilesResponse] =
    FF.liftF(ListNetworkProfilesOp(request))

  def listOfferingPromotions(
    request: ListOfferingPromotionsRequest
  ): DeviceFarmIO[ListOfferingPromotionsResponse] =
    FF.liftF(ListOfferingPromotionsOp(request))

  def listOfferingTransactions(
    request: ListOfferingTransactionsRequest
  ): DeviceFarmIO[ListOfferingTransactionsResponse] =
    FF.liftF(ListOfferingTransactionsOp(request))

  def listOfferings(
    request: ListOfferingsRequest
  ): DeviceFarmIO[ListOfferingsResponse] =
    FF.liftF(ListOfferingsOp(request))

  def listProjects(
    request: ListProjectsRequest
  ): DeviceFarmIO[ListProjectsResponse] =
    FF.liftF(ListProjectsOp(request))

  def listRemoteAccessSessions(
    request: ListRemoteAccessSessionsRequest
  ): DeviceFarmIO[ListRemoteAccessSessionsResponse] =
    FF.liftF(ListRemoteAccessSessionsOp(request))

  def listRuns(
    request: ListRunsRequest
  ): DeviceFarmIO[ListRunsResponse] =
    FF.liftF(ListRunsOp(request))

  def listSamples(
    request: ListSamplesRequest
  ): DeviceFarmIO[ListSamplesResponse] =
    FF.liftF(ListSamplesOp(request))

  def listSuites(
    request: ListSuitesRequest
  ): DeviceFarmIO[ListSuitesResponse] =
    FF.liftF(ListSuitesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): DeviceFarmIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTestGridProjects(
    request: ListTestGridProjectsRequest
  ): DeviceFarmIO[ListTestGridProjectsResponse] =
    FF.liftF(ListTestGridProjectsOp(request))

  def listTestGridSessionActions(
    request: ListTestGridSessionActionsRequest
  ): DeviceFarmIO[ListTestGridSessionActionsResponse] =
    FF.liftF(ListTestGridSessionActionsOp(request))

  def listTestGridSessionArtifacts(
    request: ListTestGridSessionArtifactsRequest
  ): DeviceFarmIO[ListTestGridSessionArtifactsResponse] =
    FF.liftF(ListTestGridSessionArtifactsOp(request))

  def listTestGridSessions(
    request: ListTestGridSessionsRequest
  ): DeviceFarmIO[ListTestGridSessionsResponse] =
    FF.liftF(ListTestGridSessionsOp(request))

  def listTests(
    request: ListTestsRequest
  ): DeviceFarmIO[ListTestsResponse] =
    FF.liftF(ListTestsOp(request))

  def listUniqueProblems(
    request: ListUniqueProblemsRequest
  ): DeviceFarmIO[ListUniqueProblemsResponse] =
    FF.liftF(ListUniqueProblemsOp(request))

  def listUploads(
    request: ListUploadsRequest
  ): DeviceFarmIO[ListUploadsResponse] =
    FF.liftF(ListUploadsOp(request))

  def listVPCEConfigurations(
    request: ListVpceConfigurationsRequest
  ): DeviceFarmIO[ListVpceConfigurationsResponse] =
    FF.liftF(ListVPCEConfigurationsOp(request))

  def purchaseOffering(
    request: PurchaseOfferingRequest
  ): DeviceFarmIO[PurchaseOfferingResponse] =
    FF.liftF(PurchaseOfferingOp(request))

  def renewOffering(
    request: RenewOfferingRequest
  ): DeviceFarmIO[RenewOfferingResponse] =
    FF.liftF(RenewOfferingOp(request))

  def scheduleRun(
    request: ScheduleRunRequest
  ): DeviceFarmIO[ScheduleRunResponse] =
    FF.liftF(ScheduleRunOp(request))

  def stopJob(
    request: StopJobRequest
  ): DeviceFarmIO[StopJobResponse] =
    FF.liftF(StopJobOp(request))

  def stopRemoteAccessSession(
    request: StopRemoteAccessSessionRequest
  ): DeviceFarmIO[StopRemoteAccessSessionResponse] =
    FF.liftF(StopRemoteAccessSessionOp(request))

  def stopRun(
    request: StopRunRequest
  ): DeviceFarmIO[StopRunResponse] =
    FF.liftF(StopRunOp(request))

  def tagResource(
    request: TagResourceRequest
  ): DeviceFarmIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): DeviceFarmIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateDeviceInstance(
    request: UpdateDeviceInstanceRequest
  ): DeviceFarmIO[UpdateDeviceInstanceResponse] =
    FF.liftF(UpdateDeviceInstanceOp(request))

  def updateDevicePool(
    request: UpdateDevicePoolRequest
  ): DeviceFarmIO[UpdateDevicePoolResponse] =
    FF.liftF(UpdateDevicePoolOp(request))

  def updateInstanceProfile(
    request: UpdateInstanceProfileRequest
  ): DeviceFarmIO[UpdateInstanceProfileResponse] =
    FF.liftF(UpdateInstanceProfileOp(request))

  def updateNetworkProfile(
    request: UpdateNetworkProfileRequest
  ): DeviceFarmIO[UpdateNetworkProfileResponse] =
    FF.liftF(UpdateNetworkProfileOp(request))

  def updateProject(
    request: UpdateProjectRequest
  ): DeviceFarmIO[UpdateProjectResponse] =
    FF.liftF(UpdateProjectOp(request))

  def updateTestGridProject(
    request: UpdateTestGridProjectRequest
  ): DeviceFarmIO[UpdateTestGridProjectResponse] =
    FF.liftF(UpdateTestGridProjectOp(request))

  def updateUpload(
    request: UpdateUploadRequest
  ): DeviceFarmIO[UpdateUploadResponse] =
    FF.liftF(UpdateUploadOp(request))

  def updateVPCEConfiguration(
    request: UpdateVpceConfigurationRequest
  ): DeviceFarmIO[UpdateVpceConfigurationResponse] =
    FF.liftF(UpdateVPCEConfigurationOp(request))
}
