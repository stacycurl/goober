package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.lightsail.LightsailClient
import software.amazon.awssdk.services.lightsail.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object lightsail { module =>

  // Free monad over LightsailOp
  type LightsailIO[A] = FF[LightsailOp, A]

  sealed trait LightsailOp[A] {
    def visit[F[_]](visitor: LightsailOp.Visitor[F]): F[A]
  }

  object LightsailOp {
    // Given a LightsailClient we can embed a LightsailIO program in any algebra that understands embedding.
    implicit val LightsailOpEmbeddable: Embeddable[LightsailOp, LightsailClient] = new Embeddable[LightsailOp, LightsailClient] {
      def embed[A](client: LightsailClient, io: LightsailIO[A]): Embedded[A] = Embedded.Lightsail(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends LightsailOp.Visitor[Kleisli[M, LightsailClient, *]] {
        def allocateStaticIp(
          request: AllocateStaticIpRequest
        ): Kleisli[M, LightsailClient, AllocateStaticIpResponse] =
          primitive(_.allocateStaticIp(request))

        def attachCertificateToDistribution(
          request: AttachCertificateToDistributionRequest
        ): Kleisli[M, LightsailClient, AttachCertificateToDistributionResponse] =
          primitive(_.attachCertificateToDistribution(request))

        def attachDisk(
          request: AttachDiskRequest
        ): Kleisli[M, LightsailClient, AttachDiskResponse] =
          primitive(_.attachDisk(request))

        def attachInstancesToLoadBalancer(
          request: AttachInstancesToLoadBalancerRequest
        ): Kleisli[M, LightsailClient, AttachInstancesToLoadBalancerResponse] =
          primitive(_.attachInstancesToLoadBalancer(request))

        def attachLoadBalancerTlsCertificate(
          request: AttachLoadBalancerTlsCertificateRequest
        ): Kleisli[M, LightsailClient, AttachLoadBalancerTlsCertificateResponse] =
          primitive(_.attachLoadBalancerTlsCertificate(request))

        def attachStaticIp(
          request: AttachStaticIpRequest
        ): Kleisli[M, LightsailClient, AttachStaticIpResponse] =
          primitive(_.attachStaticIp(request))

        def closeInstancePublicPorts(
          request: CloseInstancePublicPortsRequest
        ): Kleisli[M, LightsailClient, CloseInstancePublicPortsResponse] =
          primitive(_.closeInstancePublicPorts(request))

        def copySnapshot(
          request: CopySnapshotRequest
        ): Kleisli[M, LightsailClient, CopySnapshotResponse] =
          primitive(_.copySnapshot(request))

        def createCertificate(
          request: CreateCertificateRequest
        ): Kleisli[M, LightsailClient, CreateCertificateResponse] =
          primitive(_.createCertificate(request))

        def createCloudFormationStack(
          request: CreateCloudFormationStackRequest
        ): Kleisli[M, LightsailClient, CreateCloudFormationStackResponse] =
          primitive(_.createCloudFormationStack(request))

        def createContactMethod(
          request: CreateContactMethodRequest
        ): Kleisli[M, LightsailClient, CreateContactMethodResponse] =
          primitive(_.createContactMethod(request))

        def createContainerService(
          request: CreateContainerServiceRequest
        ): Kleisli[M, LightsailClient, CreateContainerServiceResponse] =
          primitive(_.createContainerService(request))

        def createContainerServiceDeployment(
          request: CreateContainerServiceDeploymentRequest
        ): Kleisli[M, LightsailClient, CreateContainerServiceDeploymentResponse] =
          primitive(_.createContainerServiceDeployment(request))

        def createContainerServiceRegistryLogin(
          request: CreateContainerServiceRegistryLoginRequest
        ): Kleisli[M, LightsailClient, CreateContainerServiceRegistryLoginResponse] =
          primitive(_.createContainerServiceRegistryLogin(request))

        def createDisk(
          request: CreateDiskRequest
        ): Kleisli[M, LightsailClient, CreateDiskResponse] =
          primitive(_.createDisk(request))

        def createDiskFromSnapshot(
          request: CreateDiskFromSnapshotRequest
        ): Kleisli[M, LightsailClient, CreateDiskFromSnapshotResponse] =
          primitive(_.createDiskFromSnapshot(request))

        def createDiskSnapshot(
          request: CreateDiskSnapshotRequest
        ): Kleisli[M, LightsailClient, CreateDiskSnapshotResponse] =
          primitive(_.createDiskSnapshot(request))

        def createDistribution(
          request: CreateDistributionRequest
        ): Kleisli[M, LightsailClient, CreateDistributionResponse] =
          primitive(_.createDistribution(request))

        def createDomain(
          request: CreateDomainRequest
        ): Kleisli[M, LightsailClient, CreateDomainResponse] =
          primitive(_.createDomain(request))

        def createDomainEntry(
          request: CreateDomainEntryRequest
        ): Kleisli[M, LightsailClient, CreateDomainEntryResponse] =
          primitive(_.createDomainEntry(request))

        def createInstanceSnapshot(
          request: CreateInstanceSnapshotRequest
        ): Kleisli[M, LightsailClient, CreateInstanceSnapshotResponse] =
          primitive(_.createInstanceSnapshot(request))

        def createInstances(
          request: CreateInstancesRequest
        ): Kleisli[M, LightsailClient, CreateInstancesResponse] =
          primitive(_.createInstances(request))

        def createInstancesFromSnapshot(
          request: CreateInstancesFromSnapshotRequest
        ): Kleisli[M, LightsailClient, CreateInstancesFromSnapshotResponse] =
          primitive(_.createInstancesFromSnapshot(request))

        def createKeyPair(
          request: CreateKeyPairRequest
        ): Kleisli[M, LightsailClient, CreateKeyPairResponse] =
          primitive(_.createKeyPair(request))

        def createLoadBalancer(
          request: CreateLoadBalancerRequest
        ): Kleisli[M, LightsailClient, CreateLoadBalancerResponse] =
          primitive(_.createLoadBalancer(request))

        def createLoadBalancerTlsCertificate(
          request: CreateLoadBalancerTlsCertificateRequest
        ): Kleisli[M, LightsailClient, CreateLoadBalancerTlsCertificateResponse] =
          primitive(_.createLoadBalancerTlsCertificate(request))

        def createRelationalDatabase(
          request: CreateRelationalDatabaseRequest
        ): Kleisli[M, LightsailClient, CreateRelationalDatabaseResponse] =
          primitive(_.createRelationalDatabase(request))

        def createRelationalDatabaseFromSnapshot(
          request: CreateRelationalDatabaseFromSnapshotRequest
        ): Kleisli[M, LightsailClient, CreateRelationalDatabaseFromSnapshotResponse] =
          primitive(_.createRelationalDatabaseFromSnapshot(request))

        def createRelationalDatabaseSnapshot(
          request: CreateRelationalDatabaseSnapshotRequest
        ): Kleisli[M, LightsailClient, CreateRelationalDatabaseSnapshotResponse] =
          primitive(_.createRelationalDatabaseSnapshot(request))

        def deleteAlarm(
          request: DeleteAlarmRequest
        ): Kleisli[M, LightsailClient, DeleteAlarmResponse] =
          primitive(_.deleteAlarm(request))

        def deleteAutoSnapshot(
          request: DeleteAutoSnapshotRequest
        ): Kleisli[M, LightsailClient, DeleteAutoSnapshotResponse] =
          primitive(_.deleteAutoSnapshot(request))

        def deleteCertificate(
          request: DeleteCertificateRequest
        ): Kleisli[M, LightsailClient, DeleteCertificateResponse] =
          primitive(_.deleteCertificate(request))

        def deleteContactMethod(
          request: DeleteContactMethodRequest
        ): Kleisli[M, LightsailClient, DeleteContactMethodResponse] =
          primitive(_.deleteContactMethod(request))

        def deleteContainerImage(
          request: DeleteContainerImageRequest
        ): Kleisli[M, LightsailClient, DeleteContainerImageResponse] =
          primitive(_.deleteContainerImage(request))

        def deleteContainerService(
          request: DeleteContainerServiceRequest
        ): Kleisli[M, LightsailClient, DeleteContainerServiceResponse] =
          primitive(_.deleteContainerService(request))

        def deleteDisk(
          request: DeleteDiskRequest
        ): Kleisli[M, LightsailClient, DeleteDiskResponse] =
          primitive(_.deleteDisk(request))

        def deleteDiskSnapshot(
          request: DeleteDiskSnapshotRequest
        ): Kleisli[M, LightsailClient, DeleteDiskSnapshotResponse] =
          primitive(_.deleteDiskSnapshot(request))

        def deleteDistribution(
          request: DeleteDistributionRequest
        ): Kleisli[M, LightsailClient, DeleteDistributionResponse] =
          primitive(_.deleteDistribution(request))

        def deleteDomain(
          request: DeleteDomainRequest
        ): Kleisli[M, LightsailClient, DeleteDomainResponse] =
          primitive(_.deleteDomain(request))

        def deleteDomainEntry(
          request: DeleteDomainEntryRequest
        ): Kleisli[M, LightsailClient, DeleteDomainEntryResponse] =
          primitive(_.deleteDomainEntry(request))

        def deleteInstance(
          request: DeleteInstanceRequest
        ): Kleisli[M, LightsailClient, DeleteInstanceResponse] =
          primitive(_.deleteInstance(request))

        def deleteInstanceSnapshot(
          request: DeleteInstanceSnapshotRequest
        ): Kleisli[M, LightsailClient, DeleteInstanceSnapshotResponse] =
          primitive(_.deleteInstanceSnapshot(request))

        def deleteKeyPair(
          request: DeleteKeyPairRequest
        ): Kleisli[M, LightsailClient, DeleteKeyPairResponse] =
          primitive(_.deleteKeyPair(request))

        def deleteKnownHostKeys(
          request: DeleteKnownHostKeysRequest
        ): Kleisli[M, LightsailClient, DeleteKnownHostKeysResponse] =
          primitive(_.deleteKnownHostKeys(request))

        def deleteLoadBalancer(
          request: DeleteLoadBalancerRequest
        ): Kleisli[M, LightsailClient, DeleteLoadBalancerResponse] =
          primitive(_.deleteLoadBalancer(request))

        def deleteLoadBalancerTlsCertificate(
          request: DeleteLoadBalancerTlsCertificateRequest
        ): Kleisli[M, LightsailClient, DeleteLoadBalancerTlsCertificateResponse] =
          primitive(_.deleteLoadBalancerTlsCertificate(request))

        def deleteRelationalDatabase(
          request: DeleteRelationalDatabaseRequest
        ): Kleisli[M, LightsailClient, DeleteRelationalDatabaseResponse] =
          primitive(_.deleteRelationalDatabase(request))

        def deleteRelationalDatabaseSnapshot(
          request: DeleteRelationalDatabaseSnapshotRequest
        ): Kleisli[M, LightsailClient, DeleteRelationalDatabaseSnapshotResponse] =
          primitive(_.deleteRelationalDatabaseSnapshot(request))

        def detachCertificateFromDistribution(
          request: DetachCertificateFromDistributionRequest
        ): Kleisli[M, LightsailClient, DetachCertificateFromDistributionResponse] =
          primitive(_.detachCertificateFromDistribution(request))

        def detachDisk(
          request: DetachDiskRequest
        ): Kleisli[M, LightsailClient, DetachDiskResponse] =
          primitive(_.detachDisk(request))

        def detachInstancesFromLoadBalancer(
          request: DetachInstancesFromLoadBalancerRequest
        ): Kleisli[M, LightsailClient, DetachInstancesFromLoadBalancerResponse] =
          primitive(_.detachInstancesFromLoadBalancer(request))

        def detachStaticIp(
          request: DetachStaticIpRequest
        ): Kleisli[M, LightsailClient, DetachStaticIpResponse] =
          primitive(_.detachStaticIp(request))

        def disableAddOn(
          request: DisableAddOnRequest
        ): Kleisli[M, LightsailClient, DisableAddOnResponse] =
          primitive(_.disableAddOn(request))

        def downloadDefaultKeyPair(
          request: DownloadDefaultKeyPairRequest
        ): Kleisli[M, LightsailClient, DownloadDefaultKeyPairResponse] =
          primitive(_.downloadDefaultKeyPair(request))

        def enableAddOn(
          request: EnableAddOnRequest
        ): Kleisli[M, LightsailClient, EnableAddOnResponse] =
          primitive(_.enableAddOn(request))

        def exportSnapshot(
          request: ExportSnapshotRequest
        ): Kleisli[M, LightsailClient, ExportSnapshotResponse] =
          primitive(_.exportSnapshot(request))

        def getActiveNames(
          request: GetActiveNamesRequest
        ): Kleisli[M, LightsailClient, GetActiveNamesResponse] =
          primitive(_.getActiveNames(request))

        def getAlarms(
          request: GetAlarmsRequest
        ): Kleisli[M, LightsailClient, GetAlarmsResponse] =
          primitive(_.getAlarms(request))

        def getAutoSnapshots(
          request: GetAutoSnapshotsRequest
        ): Kleisli[M, LightsailClient, GetAutoSnapshotsResponse] =
          primitive(_.getAutoSnapshots(request))

        def getBlueprints(
          request: GetBlueprintsRequest
        ): Kleisli[M, LightsailClient, GetBlueprintsResponse] =
          primitive(_.getBlueprints(request))

        def getBundles(
          request: GetBundlesRequest
        ): Kleisli[M, LightsailClient, GetBundlesResponse] =
          primitive(_.getBundles(request))

        def getCertificates(
          request: GetCertificatesRequest
        ): Kleisli[M, LightsailClient, GetCertificatesResponse] =
          primitive(_.getCertificates(request))

        def getCloudFormationStackRecords(
          request: GetCloudFormationStackRecordsRequest
        ): Kleisli[M, LightsailClient, GetCloudFormationStackRecordsResponse] =
          primitive(_.getCloudFormationStackRecords(request))

        def getContactMethods(
          request: GetContactMethodsRequest
        ): Kleisli[M, LightsailClient, GetContactMethodsResponse] =
          primitive(_.getContactMethods(request))

        def getContainerAPIMetadata(
          request: GetContainerApiMetadataRequest
        ): Kleisli[M, LightsailClient, GetContainerApiMetadataResponse] =
          primitive(_.getContainerAPIMetadata(request))

        def getContainerImages(
          request: GetContainerImagesRequest
        ): Kleisli[M, LightsailClient, GetContainerImagesResponse] =
          primitive(_.getContainerImages(request))

        def getContainerLog(
          request: GetContainerLogRequest
        ): Kleisli[M, LightsailClient, GetContainerLogResponse] =
          primitive(_.getContainerLog(request))

        def getContainerServiceDeployments(
          request: GetContainerServiceDeploymentsRequest
        ): Kleisli[M, LightsailClient, GetContainerServiceDeploymentsResponse] =
          primitive(_.getContainerServiceDeployments(request))

        def getContainerServiceMetricData(
          request: GetContainerServiceMetricDataRequest
        ): Kleisli[M, LightsailClient, GetContainerServiceMetricDataResponse] =
          primitive(_.getContainerServiceMetricData(request))

        def getContainerServicePowers(
          request: GetContainerServicePowersRequest
        ): Kleisli[M, LightsailClient, GetContainerServicePowersResponse] =
          primitive(_.getContainerServicePowers(request))

        def getContainerServices(
          request: GetContainerServicesRequest
        ): Kleisli[M, LightsailClient, GetContainerServicesResponse] =
          primitive(_.getContainerServices(request))

        def getDisk(
          request: GetDiskRequest
        ): Kleisli[M, LightsailClient, GetDiskResponse] =
          primitive(_.getDisk(request))

        def getDiskSnapshot(
          request: GetDiskSnapshotRequest
        ): Kleisli[M, LightsailClient, GetDiskSnapshotResponse] =
          primitive(_.getDiskSnapshot(request))

        def getDiskSnapshots(
          request: GetDiskSnapshotsRequest
        ): Kleisli[M, LightsailClient, GetDiskSnapshotsResponse] =
          primitive(_.getDiskSnapshots(request))

        def getDisks(
          request: GetDisksRequest
        ): Kleisli[M, LightsailClient, GetDisksResponse] =
          primitive(_.getDisks(request))

        def getDistributionBundles(
          request: GetDistributionBundlesRequest
        ): Kleisli[M, LightsailClient, GetDistributionBundlesResponse] =
          primitive(_.getDistributionBundles(request))

        def getDistributionLatestCacheReset(
          request: GetDistributionLatestCacheResetRequest
        ): Kleisli[M, LightsailClient, GetDistributionLatestCacheResetResponse] =
          primitive(_.getDistributionLatestCacheReset(request))

        def getDistributionMetricData(
          request: GetDistributionMetricDataRequest
        ): Kleisli[M, LightsailClient, GetDistributionMetricDataResponse] =
          primitive(_.getDistributionMetricData(request))

        def getDistributions(
          request: GetDistributionsRequest
        ): Kleisli[M, LightsailClient, GetDistributionsResponse] =
          primitive(_.getDistributions(request))

        def getDomain(
          request: GetDomainRequest
        ): Kleisli[M, LightsailClient, GetDomainResponse] =
          primitive(_.getDomain(request))

        def getDomains(
          request: GetDomainsRequest
        ): Kleisli[M, LightsailClient, GetDomainsResponse] =
          primitive(_.getDomains(request))

        def getExportSnapshotRecords(
          request: GetExportSnapshotRecordsRequest
        ): Kleisli[M, LightsailClient, GetExportSnapshotRecordsResponse] =
          primitive(_.getExportSnapshotRecords(request))

        def getInstance(
          request: GetInstanceRequest
        ): Kleisli[M, LightsailClient, GetInstanceResponse] =
          primitive(_.getInstance(request))

        def getInstanceAccessDetails(
          request: GetInstanceAccessDetailsRequest
        ): Kleisli[M, LightsailClient, GetInstanceAccessDetailsResponse] =
          primitive(_.getInstanceAccessDetails(request))

        def getInstanceMetricData(
          request: GetInstanceMetricDataRequest
        ): Kleisli[M, LightsailClient, GetInstanceMetricDataResponse] =
          primitive(_.getInstanceMetricData(request))

        def getInstancePortStates(
          request: GetInstancePortStatesRequest
        ): Kleisli[M, LightsailClient, GetInstancePortStatesResponse] =
          primitive(_.getInstancePortStates(request))

        def getInstanceSnapshot(
          request: GetInstanceSnapshotRequest
        ): Kleisli[M, LightsailClient, GetInstanceSnapshotResponse] =
          primitive(_.getInstanceSnapshot(request))

        def getInstanceSnapshots(
          request: GetInstanceSnapshotsRequest
        ): Kleisli[M, LightsailClient, GetInstanceSnapshotsResponse] =
          primitive(_.getInstanceSnapshots(request))

        def getInstanceState(
          request: GetInstanceStateRequest
        ): Kleisli[M, LightsailClient, GetInstanceStateResponse] =
          primitive(_.getInstanceState(request))

        def getInstances(
          request: GetInstancesRequest
        ): Kleisli[M, LightsailClient, GetInstancesResponse] =
          primitive(_.getInstances(request))

        def getKeyPair(
          request: GetKeyPairRequest
        ): Kleisli[M, LightsailClient, GetKeyPairResponse] =
          primitive(_.getKeyPair(request))

        def getKeyPairs(
          request: GetKeyPairsRequest
        ): Kleisli[M, LightsailClient, GetKeyPairsResponse] =
          primitive(_.getKeyPairs(request))

        def getLoadBalancer(
          request: GetLoadBalancerRequest
        ): Kleisli[M, LightsailClient, GetLoadBalancerResponse] =
          primitive(_.getLoadBalancer(request))

        def getLoadBalancerMetricData(
          request: GetLoadBalancerMetricDataRequest
        ): Kleisli[M, LightsailClient, GetLoadBalancerMetricDataResponse] =
          primitive(_.getLoadBalancerMetricData(request))

        def getLoadBalancerTlsCertificates(
          request: GetLoadBalancerTlsCertificatesRequest
        ): Kleisli[M, LightsailClient, GetLoadBalancerTlsCertificatesResponse] =
          primitive(_.getLoadBalancerTlsCertificates(request))

        def getLoadBalancers(
          request: GetLoadBalancersRequest
        ): Kleisli[M, LightsailClient, GetLoadBalancersResponse] =
          primitive(_.getLoadBalancers(request))

        def getOperation(
          request: GetOperationRequest
        ): Kleisli[M, LightsailClient, GetOperationResponse] =
          primitive(_.getOperation(request))

        def getOperations(
          request: GetOperationsRequest
        ): Kleisli[M, LightsailClient, GetOperationsResponse] =
          primitive(_.getOperations(request))

        def getOperationsForResource(
          request: GetOperationsForResourceRequest
        ): Kleisli[M, LightsailClient, GetOperationsForResourceResponse] =
          primitive(_.getOperationsForResource(request))

        def getRegions(
          request: GetRegionsRequest
        ): Kleisli[M, LightsailClient, GetRegionsResponse] =
          primitive(_.getRegions(request))

        def getRelationalDatabase(
          request: GetRelationalDatabaseRequest
        ): Kleisli[M, LightsailClient, GetRelationalDatabaseResponse] =
          primitive(_.getRelationalDatabase(request))

        def getRelationalDatabaseBlueprints(
          request: GetRelationalDatabaseBlueprintsRequest
        ): Kleisli[M, LightsailClient, GetRelationalDatabaseBlueprintsResponse] =
          primitive(_.getRelationalDatabaseBlueprints(request))

        def getRelationalDatabaseBundles(
          request: GetRelationalDatabaseBundlesRequest
        ): Kleisli[M, LightsailClient, GetRelationalDatabaseBundlesResponse] =
          primitive(_.getRelationalDatabaseBundles(request))

        def getRelationalDatabaseEvents(
          request: GetRelationalDatabaseEventsRequest
        ): Kleisli[M, LightsailClient, GetRelationalDatabaseEventsResponse] =
          primitive(_.getRelationalDatabaseEvents(request))

        def getRelationalDatabaseLogEvents(
          request: GetRelationalDatabaseLogEventsRequest
        ): Kleisli[M, LightsailClient, GetRelationalDatabaseLogEventsResponse] =
          primitive(_.getRelationalDatabaseLogEvents(request))

        def getRelationalDatabaseLogStreams(
          request: GetRelationalDatabaseLogStreamsRequest
        ): Kleisli[M, LightsailClient, GetRelationalDatabaseLogStreamsResponse] =
          primitive(_.getRelationalDatabaseLogStreams(request))

        def getRelationalDatabaseMasterUserPassword(
          request: GetRelationalDatabaseMasterUserPasswordRequest
        ): Kleisli[M, LightsailClient, GetRelationalDatabaseMasterUserPasswordResponse] =
          primitive(_.getRelationalDatabaseMasterUserPassword(request))

        def getRelationalDatabaseMetricData(
          request: GetRelationalDatabaseMetricDataRequest
        ): Kleisli[M, LightsailClient, GetRelationalDatabaseMetricDataResponse] =
          primitive(_.getRelationalDatabaseMetricData(request))

        def getRelationalDatabaseParameters(
          request: GetRelationalDatabaseParametersRequest
        ): Kleisli[M, LightsailClient, GetRelationalDatabaseParametersResponse] =
          primitive(_.getRelationalDatabaseParameters(request))

        def getRelationalDatabaseSnapshot(
          request: GetRelationalDatabaseSnapshotRequest
        ): Kleisli[M, LightsailClient, GetRelationalDatabaseSnapshotResponse] =
          primitive(_.getRelationalDatabaseSnapshot(request))

        def getRelationalDatabaseSnapshots(
          request: GetRelationalDatabaseSnapshotsRequest
        ): Kleisli[M, LightsailClient, GetRelationalDatabaseSnapshotsResponse] =
          primitive(_.getRelationalDatabaseSnapshots(request))

        def getRelationalDatabases(
          request: GetRelationalDatabasesRequest
        ): Kleisli[M, LightsailClient, GetRelationalDatabasesResponse] =
          primitive(_.getRelationalDatabases(request))

        def getStaticIp(
          request: GetStaticIpRequest
        ): Kleisli[M, LightsailClient, GetStaticIpResponse] =
          primitive(_.getStaticIp(request))

        def getStaticIps(
          request: GetStaticIpsRequest
        ): Kleisli[M, LightsailClient, GetStaticIpsResponse] =
          primitive(_.getStaticIps(request))

        def importKeyPair(
          request: ImportKeyPairRequest
        ): Kleisli[M, LightsailClient, ImportKeyPairResponse] =
          primitive(_.importKeyPair(request))

        def isVpcPeered(
          request: IsVpcPeeredRequest
        ): Kleisli[M, LightsailClient, IsVpcPeeredResponse] =
          primitive(_.isVpcPeered(request))

        def openInstancePublicPorts(
          request: OpenInstancePublicPortsRequest
        ): Kleisli[M, LightsailClient, OpenInstancePublicPortsResponse] =
          primitive(_.openInstancePublicPorts(request))

        def peerVpc(
          request: PeerVpcRequest
        ): Kleisli[M, LightsailClient, PeerVpcResponse] =
          primitive(_.peerVpc(request))

        def putAlarm(
          request: PutAlarmRequest
        ): Kleisli[M, LightsailClient, PutAlarmResponse] =
          primitive(_.putAlarm(request))

        def putInstancePublicPorts(
          request: PutInstancePublicPortsRequest
        ): Kleisli[M, LightsailClient, PutInstancePublicPortsResponse] =
          primitive(_.putInstancePublicPorts(request))

        def rebootInstance(
          request: RebootInstanceRequest
        ): Kleisli[M, LightsailClient, RebootInstanceResponse] =
          primitive(_.rebootInstance(request))

        def rebootRelationalDatabase(
          request: RebootRelationalDatabaseRequest
        ): Kleisli[M, LightsailClient, RebootRelationalDatabaseResponse] =
          primitive(_.rebootRelationalDatabase(request))

        def registerContainerImage(
          request: RegisterContainerImageRequest
        ): Kleisli[M, LightsailClient, RegisterContainerImageResponse] =
          primitive(_.registerContainerImage(request))

        def releaseStaticIp(
          request: ReleaseStaticIpRequest
        ): Kleisli[M, LightsailClient, ReleaseStaticIpResponse] =
          primitive(_.releaseStaticIp(request))

        def resetDistributionCache(
          request: ResetDistributionCacheRequest
        ): Kleisli[M, LightsailClient, ResetDistributionCacheResponse] =
          primitive(_.resetDistributionCache(request))

        def sendContactMethodVerification(
          request: SendContactMethodVerificationRequest
        ): Kleisli[M, LightsailClient, SendContactMethodVerificationResponse] =
          primitive(_.sendContactMethodVerification(request))

        def setIpAddressType(
          request: SetIpAddressTypeRequest
        ): Kleisli[M, LightsailClient, SetIpAddressTypeResponse] =
          primitive(_.setIpAddressType(request))

        def startInstance(
          request: StartInstanceRequest
        ): Kleisli[M, LightsailClient, StartInstanceResponse] =
          primitive(_.startInstance(request))

        def startRelationalDatabase(
          request: StartRelationalDatabaseRequest
        ): Kleisli[M, LightsailClient, StartRelationalDatabaseResponse] =
          primitive(_.startRelationalDatabase(request))

        def stopInstance(
          request: StopInstanceRequest
        ): Kleisli[M, LightsailClient, StopInstanceResponse] =
          primitive(_.stopInstance(request))

        def stopRelationalDatabase(
          request: StopRelationalDatabaseRequest
        ): Kleisli[M, LightsailClient, StopRelationalDatabaseResponse] =
          primitive(_.stopRelationalDatabase(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, LightsailClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def testAlarm(
          request: TestAlarmRequest
        ): Kleisli[M, LightsailClient, TestAlarmResponse] =
          primitive(_.testAlarm(request))

        def unpeerVpc(
          request: UnpeerVpcRequest
        ): Kleisli[M, LightsailClient, UnpeerVpcResponse] =
          primitive(_.unpeerVpc(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, LightsailClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateContainerService(
          request: UpdateContainerServiceRequest
        ): Kleisli[M, LightsailClient, UpdateContainerServiceResponse] =
          primitive(_.updateContainerService(request))

        def updateDistribution(
          request: UpdateDistributionRequest
        ): Kleisli[M, LightsailClient, UpdateDistributionResponse] =
          primitive(_.updateDistribution(request))

        def updateDistributionBundle(
          request: UpdateDistributionBundleRequest
        ): Kleisli[M, LightsailClient, UpdateDistributionBundleResponse] =
          primitive(_.updateDistributionBundle(request))

        def updateDomainEntry(
          request: UpdateDomainEntryRequest
        ): Kleisli[M, LightsailClient, UpdateDomainEntryResponse] =
          primitive(_.updateDomainEntry(request))

        def updateLoadBalancerAttribute(
          request: UpdateLoadBalancerAttributeRequest
        ): Kleisli[M, LightsailClient, UpdateLoadBalancerAttributeResponse] =
          primitive(_.updateLoadBalancerAttribute(request))

        def updateRelationalDatabase(
          request: UpdateRelationalDatabaseRequest
        ): Kleisli[M, LightsailClient, UpdateRelationalDatabaseResponse] =
          primitive(_.updateRelationalDatabase(request))

        def updateRelationalDatabaseParameters(
          request: UpdateRelationalDatabaseParametersRequest
        ): Kleisli[M, LightsailClient, UpdateRelationalDatabaseParametersResponse] =
          primitive(_.updateRelationalDatabaseParameters(request))

        def primitive[A](
          f: LightsailClient => A
        ): Kleisli[M, LightsailClient, A]
      }
    }

    trait Visitor[F[_]] extends (LightsailOp ~> F) {
      final def apply[A](op: LightsailOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def allocateStaticIp(
        request: AllocateStaticIpRequest
      ): F[AllocateStaticIpResponse]

      def attachCertificateToDistribution(
        request: AttachCertificateToDistributionRequest
      ): F[AttachCertificateToDistributionResponse]

      def attachDisk(
        request: AttachDiskRequest
      ): F[AttachDiskResponse]

      def attachInstancesToLoadBalancer(
        request: AttachInstancesToLoadBalancerRequest
      ): F[AttachInstancesToLoadBalancerResponse]

      def attachLoadBalancerTlsCertificate(
        request: AttachLoadBalancerTlsCertificateRequest
      ): F[AttachLoadBalancerTlsCertificateResponse]

      def attachStaticIp(
        request: AttachStaticIpRequest
      ): F[AttachStaticIpResponse]

      def closeInstancePublicPorts(
        request: CloseInstancePublicPortsRequest
      ): F[CloseInstancePublicPortsResponse]

      def copySnapshot(
        request: CopySnapshotRequest
      ): F[CopySnapshotResponse]

      def createCertificate(
        request: CreateCertificateRequest
      ): F[CreateCertificateResponse]

      def createCloudFormationStack(
        request: CreateCloudFormationStackRequest
      ): F[CreateCloudFormationStackResponse]

      def createContactMethod(
        request: CreateContactMethodRequest
      ): F[CreateContactMethodResponse]

      def createContainerService(
        request: CreateContainerServiceRequest
      ): F[CreateContainerServiceResponse]

      def createContainerServiceDeployment(
        request: CreateContainerServiceDeploymentRequest
      ): F[CreateContainerServiceDeploymentResponse]

      def createContainerServiceRegistryLogin(
        request: CreateContainerServiceRegistryLoginRequest
      ): F[CreateContainerServiceRegistryLoginResponse]

      def createDisk(
        request: CreateDiskRequest
      ): F[CreateDiskResponse]

      def createDiskFromSnapshot(
        request: CreateDiskFromSnapshotRequest
      ): F[CreateDiskFromSnapshotResponse]

      def createDiskSnapshot(
        request: CreateDiskSnapshotRequest
      ): F[CreateDiskSnapshotResponse]

      def createDistribution(
        request: CreateDistributionRequest
      ): F[CreateDistributionResponse]

      def createDomain(
        request: CreateDomainRequest
      ): F[CreateDomainResponse]

      def createDomainEntry(
        request: CreateDomainEntryRequest
      ): F[CreateDomainEntryResponse]

      def createInstanceSnapshot(
        request: CreateInstanceSnapshotRequest
      ): F[CreateInstanceSnapshotResponse]

      def createInstances(
        request: CreateInstancesRequest
      ): F[CreateInstancesResponse]

      def createInstancesFromSnapshot(
        request: CreateInstancesFromSnapshotRequest
      ): F[CreateInstancesFromSnapshotResponse]

      def createKeyPair(
        request: CreateKeyPairRequest
      ): F[CreateKeyPairResponse]

      def createLoadBalancer(
        request: CreateLoadBalancerRequest
      ): F[CreateLoadBalancerResponse]

      def createLoadBalancerTlsCertificate(
        request: CreateLoadBalancerTlsCertificateRequest
      ): F[CreateLoadBalancerTlsCertificateResponse]

      def createRelationalDatabase(
        request: CreateRelationalDatabaseRequest
      ): F[CreateRelationalDatabaseResponse]

      def createRelationalDatabaseFromSnapshot(
        request: CreateRelationalDatabaseFromSnapshotRequest
      ): F[CreateRelationalDatabaseFromSnapshotResponse]

      def createRelationalDatabaseSnapshot(
        request: CreateRelationalDatabaseSnapshotRequest
      ): F[CreateRelationalDatabaseSnapshotResponse]

      def deleteAlarm(
        request: DeleteAlarmRequest
      ): F[DeleteAlarmResponse]

      def deleteAutoSnapshot(
        request: DeleteAutoSnapshotRequest
      ): F[DeleteAutoSnapshotResponse]

      def deleteCertificate(
        request: DeleteCertificateRequest
      ): F[DeleteCertificateResponse]

      def deleteContactMethod(
        request: DeleteContactMethodRequest
      ): F[DeleteContactMethodResponse]

      def deleteContainerImage(
        request: DeleteContainerImageRequest
      ): F[DeleteContainerImageResponse]

      def deleteContainerService(
        request: DeleteContainerServiceRequest
      ): F[DeleteContainerServiceResponse]

      def deleteDisk(
        request: DeleteDiskRequest
      ): F[DeleteDiskResponse]

      def deleteDiskSnapshot(
        request: DeleteDiskSnapshotRequest
      ): F[DeleteDiskSnapshotResponse]

      def deleteDistribution(
        request: DeleteDistributionRequest
      ): F[DeleteDistributionResponse]

      def deleteDomain(
        request: DeleteDomainRequest
      ): F[DeleteDomainResponse]

      def deleteDomainEntry(
        request: DeleteDomainEntryRequest
      ): F[DeleteDomainEntryResponse]

      def deleteInstance(
        request: DeleteInstanceRequest
      ): F[DeleteInstanceResponse]

      def deleteInstanceSnapshot(
        request: DeleteInstanceSnapshotRequest
      ): F[DeleteInstanceSnapshotResponse]

      def deleteKeyPair(
        request: DeleteKeyPairRequest
      ): F[DeleteKeyPairResponse]

      def deleteKnownHostKeys(
        request: DeleteKnownHostKeysRequest
      ): F[DeleteKnownHostKeysResponse]

      def deleteLoadBalancer(
        request: DeleteLoadBalancerRequest
      ): F[DeleteLoadBalancerResponse]

      def deleteLoadBalancerTlsCertificate(
        request: DeleteLoadBalancerTlsCertificateRequest
      ): F[DeleteLoadBalancerTlsCertificateResponse]

      def deleteRelationalDatabase(
        request: DeleteRelationalDatabaseRequest
      ): F[DeleteRelationalDatabaseResponse]

      def deleteRelationalDatabaseSnapshot(
        request: DeleteRelationalDatabaseSnapshotRequest
      ): F[DeleteRelationalDatabaseSnapshotResponse]

      def detachCertificateFromDistribution(
        request: DetachCertificateFromDistributionRequest
      ): F[DetachCertificateFromDistributionResponse]

      def detachDisk(
        request: DetachDiskRequest
      ): F[DetachDiskResponse]

      def detachInstancesFromLoadBalancer(
        request: DetachInstancesFromLoadBalancerRequest
      ): F[DetachInstancesFromLoadBalancerResponse]

      def detachStaticIp(
        request: DetachStaticIpRequest
      ): F[DetachStaticIpResponse]

      def disableAddOn(
        request: DisableAddOnRequest
      ): F[DisableAddOnResponse]

      def downloadDefaultKeyPair(
        request: DownloadDefaultKeyPairRequest
      ): F[DownloadDefaultKeyPairResponse]

      def enableAddOn(
        request: EnableAddOnRequest
      ): F[EnableAddOnResponse]

      def exportSnapshot(
        request: ExportSnapshotRequest
      ): F[ExportSnapshotResponse]

      def getActiveNames(
        request: GetActiveNamesRequest
      ): F[GetActiveNamesResponse]

      def getAlarms(
        request: GetAlarmsRequest
      ): F[GetAlarmsResponse]

      def getAutoSnapshots(
        request: GetAutoSnapshotsRequest
      ): F[GetAutoSnapshotsResponse]

      def getBlueprints(
        request: GetBlueprintsRequest
      ): F[GetBlueprintsResponse]

      def getBundles(
        request: GetBundlesRequest
      ): F[GetBundlesResponse]

      def getCertificates(
        request: GetCertificatesRequest
      ): F[GetCertificatesResponse]

      def getCloudFormationStackRecords(
        request: GetCloudFormationStackRecordsRequest
      ): F[GetCloudFormationStackRecordsResponse]

      def getContactMethods(
        request: GetContactMethodsRequest
      ): F[GetContactMethodsResponse]

      def getContainerAPIMetadata(
        request: GetContainerApiMetadataRequest
      ): F[GetContainerApiMetadataResponse]

      def getContainerImages(
        request: GetContainerImagesRequest
      ): F[GetContainerImagesResponse]

      def getContainerLog(
        request: GetContainerLogRequest
      ): F[GetContainerLogResponse]

      def getContainerServiceDeployments(
        request: GetContainerServiceDeploymentsRequest
      ): F[GetContainerServiceDeploymentsResponse]

      def getContainerServiceMetricData(
        request: GetContainerServiceMetricDataRequest
      ): F[GetContainerServiceMetricDataResponse]

      def getContainerServicePowers(
        request: GetContainerServicePowersRequest
      ): F[GetContainerServicePowersResponse]

      def getContainerServices(
        request: GetContainerServicesRequest
      ): F[GetContainerServicesResponse]

      def getDisk(
        request: GetDiskRequest
      ): F[GetDiskResponse]

      def getDiskSnapshot(
        request: GetDiskSnapshotRequest
      ): F[GetDiskSnapshotResponse]

      def getDiskSnapshots(
        request: GetDiskSnapshotsRequest
      ): F[GetDiskSnapshotsResponse]

      def getDisks(
        request: GetDisksRequest
      ): F[GetDisksResponse]

      def getDistributionBundles(
        request: GetDistributionBundlesRequest
      ): F[GetDistributionBundlesResponse]

      def getDistributionLatestCacheReset(
        request: GetDistributionLatestCacheResetRequest
      ): F[GetDistributionLatestCacheResetResponse]

      def getDistributionMetricData(
        request: GetDistributionMetricDataRequest
      ): F[GetDistributionMetricDataResponse]

      def getDistributions(
        request: GetDistributionsRequest
      ): F[GetDistributionsResponse]

      def getDomain(
        request: GetDomainRequest
      ): F[GetDomainResponse]

      def getDomains(
        request: GetDomainsRequest
      ): F[GetDomainsResponse]

      def getExportSnapshotRecords(
        request: GetExportSnapshotRecordsRequest
      ): F[GetExportSnapshotRecordsResponse]

      def getInstance(
        request: GetInstanceRequest
      ): F[GetInstanceResponse]

      def getInstanceAccessDetails(
        request: GetInstanceAccessDetailsRequest
      ): F[GetInstanceAccessDetailsResponse]

      def getInstanceMetricData(
        request: GetInstanceMetricDataRequest
      ): F[GetInstanceMetricDataResponse]

      def getInstancePortStates(
        request: GetInstancePortStatesRequest
      ): F[GetInstancePortStatesResponse]

      def getInstanceSnapshot(
        request: GetInstanceSnapshotRequest
      ): F[GetInstanceSnapshotResponse]

      def getInstanceSnapshots(
        request: GetInstanceSnapshotsRequest
      ): F[GetInstanceSnapshotsResponse]

      def getInstanceState(
        request: GetInstanceStateRequest
      ): F[GetInstanceStateResponse]

      def getInstances(
        request: GetInstancesRequest
      ): F[GetInstancesResponse]

      def getKeyPair(
        request: GetKeyPairRequest
      ): F[GetKeyPairResponse]

      def getKeyPairs(
        request: GetKeyPairsRequest
      ): F[GetKeyPairsResponse]

      def getLoadBalancer(
        request: GetLoadBalancerRequest
      ): F[GetLoadBalancerResponse]

      def getLoadBalancerMetricData(
        request: GetLoadBalancerMetricDataRequest
      ): F[GetLoadBalancerMetricDataResponse]

      def getLoadBalancerTlsCertificates(
        request: GetLoadBalancerTlsCertificatesRequest
      ): F[GetLoadBalancerTlsCertificatesResponse]

      def getLoadBalancers(
        request: GetLoadBalancersRequest
      ): F[GetLoadBalancersResponse]

      def getOperation(
        request: GetOperationRequest
      ): F[GetOperationResponse]

      def getOperations(
        request: GetOperationsRequest
      ): F[GetOperationsResponse]

      def getOperationsForResource(
        request: GetOperationsForResourceRequest
      ): F[GetOperationsForResourceResponse]

      def getRegions(
        request: GetRegionsRequest
      ): F[GetRegionsResponse]

      def getRelationalDatabase(
        request: GetRelationalDatabaseRequest
      ): F[GetRelationalDatabaseResponse]

      def getRelationalDatabaseBlueprints(
        request: GetRelationalDatabaseBlueprintsRequest
      ): F[GetRelationalDatabaseBlueprintsResponse]

      def getRelationalDatabaseBundles(
        request: GetRelationalDatabaseBundlesRequest
      ): F[GetRelationalDatabaseBundlesResponse]

      def getRelationalDatabaseEvents(
        request: GetRelationalDatabaseEventsRequest
      ): F[GetRelationalDatabaseEventsResponse]

      def getRelationalDatabaseLogEvents(
        request: GetRelationalDatabaseLogEventsRequest
      ): F[GetRelationalDatabaseLogEventsResponse]

      def getRelationalDatabaseLogStreams(
        request: GetRelationalDatabaseLogStreamsRequest
      ): F[GetRelationalDatabaseLogStreamsResponse]

      def getRelationalDatabaseMasterUserPassword(
        request: GetRelationalDatabaseMasterUserPasswordRequest
      ): F[GetRelationalDatabaseMasterUserPasswordResponse]

      def getRelationalDatabaseMetricData(
        request: GetRelationalDatabaseMetricDataRequest
      ): F[GetRelationalDatabaseMetricDataResponse]

      def getRelationalDatabaseParameters(
        request: GetRelationalDatabaseParametersRequest
      ): F[GetRelationalDatabaseParametersResponse]

      def getRelationalDatabaseSnapshot(
        request: GetRelationalDatabaseSnapshotRequest
      ): F[GetRelationalDatabaseSnapshotResponse]

      def getRelationalDatabaseSnapshots(
        request: GetRelationalDatabaseSnapshotsRequest
      ): F[GetRelationalDatabaseSnapshotsResponse]

      def getRelationalDatabases(
        request: GetRelationalDatabasesRequest
      ): F[GetRelationalDatabasesResponse]

      def getStaticIp(
        request: GetStaticIpRequest
      ): F[GetStaticIpResponse]

      def getStaticIps(
        request: GetStaticIpsRequest
      ): F[GetStaticIpsResponse]

      def importKeyPair(
        request: ImportKeyPairRequest
      ): F[ImportKeyPairResponse]

      def isVpcPeered(
        request: IsVpcPeeredRequest
      ): F[IsVpcPeeredResponse]

      def openInstancePublicPorts(
        request: OpenInstancePublicPortsRequest
      ): F[OpenInstancePublicPortsResponse]

      def peerVpc(
        request: PeerVpcRequest
      ): F[PeerVpcResponse]

      def putAlarm(
        request: PutAlarmRequest
      ): F[PutAlarmResponse]

      def putInstancePublicPorts(
        request: PutInstancePublicPortsRequest
      ): F[PutInstancePublicPortsResponse]

      def rebootInstance(
        request: RebootInstanceRequest
      ): F[RebootInstanceResponse]

      def rebootRelationalDatabase(
        request: RebootRelationalDatabaseRequest
      ): F[RebootRelationalDatabaseResponse]

      def registerContainerImage(
        request: RegisterContainerImageRequest
      ): F[RegisterContainerImageResponse]

      def releaseStaticIp(
        request: ReleaseStaticIpRequest
      ): F[ReleaseStaticIpResponse]

      def resetDistributionCache(
        request: ResetDistributionCacheRequest
      ): F[ResetDistributionCacheResponse]

      def sendContactMethodVerification(
        request: SendContactMethodVerificationRequest
      ): F[SendContactMethodVerificationResponse]

      def setIpAddressType(
        request: SetIpAddressTypeRequest
      ): F[SetIpAddressTypeResponse]

      def startInstance(
        request: StartInstanceRequest
      ): F[StartInstanceResponse]

      def startRelationalDatabase(
        request: StartRelationalDatabaseRequest
      ): F[StartRelationalDatabaseResponse]

      def stopInstance(
        request: StopInstanceRequest
      ): F[StopInstanceResponse]

      def stopRelationalDatabase(
        request: StopRelationalDatabaseRequest
      ): F[StopRelationalDatabaseResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def testAlarm(
        request: TestAlarmRequest
      ): F[TestAlarmResponse]

      def unpeerVpc(
        request: UnpeerVpcRequest
      ): F[UnpeerVpcResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateContainerService(
        request: UpdateContainerServiceRequest
      ): F[UpdateContainerServiceResponse]

      def updateDistribution(
        request: UpdateDistributionRequest
      ): F[UpdateDistributionResponse]

      def updateDistributionBundle(
        request: UpdateDistributionBundleRequest
      ): F[UpdateDistributionBundleResponse]

      def updateDomainEntry(
        request: UpdateDomainEntryRequest
      ): F[UpdateDomainEntryResponse]

      def updateLoadBalancerAttribute(
        request: UpdateLoadBalancerAttributeRequest
      ): F[UpdateLoadBalancerAttributeResponse]

      def updateRelationalDatabase(
        request: UpdateRelationalDatabaseRequest
      ): F[UpdateRelationalDatabaseResponse]

      def updateRelationalDatabaseParameters(
        request: UpdateRelationalDatabaseParametersRequest
      ): F[UpdateRelationalDatabaseParametersResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends LightsailOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AllocateStaticIpOp(
      request: AllocateStaticIpRequest
    ) extends LightsailOp[AllocateStaticIpResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AllocateStaticIpResponse] =
        visitor.allocateStaticIp(request)
    }

    final case class AttachCertificateToDistributionOp(
      request: AttachCertificateToDistributionRequest
    ) extends LightsailOp[AttachCertificateToDistributionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachCertificateToDistributionResponse] =
        visitor.attachCertificateToDistribution(request)
    }

    final case class AttachDiskOp(
      request: AttachDiskRequest
    ) extends LightsailOp[AttachDiskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachDiskResponse] =
        visitor.attachDisk(request)
    }

    final case class AttachInstancesToLoadBalancerOp(
      request: AttachInstancesToLoadBalancerRequest
    ) extends LightsailOp[AttachInstancesToLoadBalancerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachInstancesToLoadBalancerResponse] =
        visitor.attachInstancesToLoadBalancer(request)
    }

    final case class AttachLoadBalancerTlsCertificateOp(
      request: AttachLoadBalancerTlsCertificateRequest
    ) extends LightsailOp[AttachLoadBalancerTlsCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachLoadBalancerTlsCertificateResponse] =
        visitor.attachLoadBalancerTlsCertificate(request)
    }

    final case class AttachStaticIpOp(
      request: AttachStaticIpRequest
    ) extends LightsailOp[AttachStaticIpResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachStaticIpResponse] =
        visitor.attachStaticIp(request)
    }

    final case class CloseInstancePublicPortsOp(
      request: CloseInstancePublicPortsRequest
    ) extends LightsailOp[CloseInstancePublicPortsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CloseInstancePublicPortsResponse] =
        visitor.closeInstancePublicPorts(request)
    }

    final case class CopySnapshotOp(
      request: CopySnapshotRequest
    ) extends LightsailOp[CopySnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopySnapshotResponse] =
        visitor.copySnapshot(request)
    }

    final case class CreateCertificateOp(
      request: CreateCertificateRequest
    ) extends LightsailOp[CreateCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCertificateResponse] =
        visitor.createCertificate(request)
    }

    final case class CreateCloudFormationStackOp(
      request: CreateCloudFormationStackRequest
    ) extends LightsailOp[CreateCloudFormationStackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCloudFormationStackResponse] =
        visitor.createCloudFormationStack(request)
    }

    final case class CreateContactMethodOp(
      request: CreateContactMethodRequest
    ) extends LightsailOp[CreateContactMethodResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateContactMethodResponse] =
        visitor.createContactMethod(request)
    }

    final case class CreateContainerServiceOp(
      request: CreateContainerServiceRequest
    ) extends LightsailOp[CreateContainerServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateContainerServiceResponse] =
        visitor.createContainerService(request)
    }

    final case class CreateContainerServiceDeploymentOp(
      request: CreateContainerServiceDeploymentRequest
    ) extends LightsailOp[CreateContainerServiceDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateContainerServiceDeploymentResponse] =
        visitor.createContainerServiceDeployment(request)
    }

    final case class CreateContainerServiceRegistryLoginOp(
      request: CreateContainerServiceRegistryLoginRequest
    ) extends LightsailOp[CreateContainerServiceRegistryLoginResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateContainerServiceRegistryLoginResponse] =
        visitor.createContainerServiceRegistryLogin(request)
    }

    final case class CreateDiskOp(
      request: CreateDiskRequest
    ) extends LightsailOp[CreateDiskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDiskResponse] =
        visitor.createDisk(request)
    }

    final case class CreateDiskFromSnapshotOp(
      request: CreateDiskFromSnapshotRequest
    ) extends LightsailOp[CreateDiskFromSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDiskFromSnapshotResponse] =
        visitor.createDiskFromSnapshot(request)
    }

    final case class CreateDiskSnapshotOp(
      request: CreateDiskSnapshotRequest
    ) extends LightsailOp[CreateDiskSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDiskSnapshotResponse] =
        visitor.createDiskSnapshot(request)
    }

    final case class CreateDistributionOp(
      request: CreateDistributionRequest
    ) extends LightsailOp[CreateDistributionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDistributionResponse] =
        visitor.createDistribution(request)
    }

    final case class CreateDomainOp(
      request: CreateDomainRequest
    ) extends LightsailOp[CreateDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDomainResponse] =
        visitor.createDomain(request)
    }

    final case class CreateDomainEntryOp(
      request: CreateDomainEntryRequest
    ) extends LightsailOp[CreateDomainEntryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDomainEntryResponse] =
        visitor.createDomainEntry(request)
    }

    final case class CreateInstanceSnapshotOp(
      request: CreateInstanceSnapshotRequest
    ) extends LightsailOp[CreateInstanceSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateInstanceSnapshotResponse] =
        visitor.createInstanceSnapshot(request)
    }

    final case class CreateInstancesOp(
      request: CreateInstancesRequest
    ) extends LightsailOp[CreateInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateInstancesResponse] =
        visitor.createInstances(request)
    }

    final case class CreateInstancesFromSnapshotOp(
      request: CreateInstancesFromSnapshotRequest
    ) extends LightsailOp[CreateInstancesFromSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateInstancesFromSnapshotResponse] =
        visitor.createInstancesFromSnapshot(request)
    }

    final case class CreateKeyPairOp(
      request: CreateKeyPairRequest
    ) extends LightsailOp[CreateKeyPairResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateKeyPairResponse] =
        visitor.createKeyPair(request)
    }

    final case class CreateLoadBalancerOp(
      request: CreateLoadBalancerRequest
    ) extends LightsailOp[CreateLoadBalancerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLoadBalancerResponse] =
        visitor.createLoadBalancer(request)
    }

    final case class CreateLoadBalancerTlsCertificateOp(
      request: CreateLoadBalancerTlsCertificateRequest
    ) extends LightsailOp[CreateLoadBalancerTlsCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLoadBalancerTlsCertificateResponse] =
        visitor.createLoadBalancerTlsCertificate(request)
    }

    final case class CreateRelationalDatabaseOp(
      request: CreateRelationalDatabaseRequest
    ) extends LightsailOp[CreateRelationalDatabaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRelationalDatabaseResponse] =
        visitor.createRelationalDatabase(request)
    }

    final case class CreateRelationalDatabaseFromSnapshotOp(
      request: CreateRelationalDatabaseFromSnapshotRequest
    ) extends LightsailOp[CreateRelationalDatabaseFromSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRelationalDatabaseFromSnapshotResponse] =
        visitor.createRelationalDatabaseFromSnapshot(request)
    }

    final case class CreateRelationalDatabaseSnapshotOp(
      request: CreateRelationalDatabaseSnapshotRequest
    ) extends LightsailOp[CreateRelationalDatabaseSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRelationalDatabaseSnapshotResponse] =
        visitor.createRelationalDatabaseSnapshot(request)
    }

    final case class DeleteAlarmOp(
      request: DeleteAlarmRequest
    ) extends LightsailOp[DeleteAlarmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAlarmResponse] =
        visitor.deleteAlarm(request)
    }

    final case class DeleteAutoSnapshotOp(
      request: DeleteAutoSnapshotRequest
    ) extends LightsailOp[DeleteAutoSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAutoSnapshotResponse] =
        visitor.deleteAutoSnapshot(request)
    }

    final case class DeleteCertificateOp(
      request: DeleteCertificateRequest
    ) extends LightsailOp[DeleteCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCertificateResponse] =
        visitor.deleteCertificate(request)
    }

    final case class DeleteContactMethodOp(
      request: DeleteContactMethodRequest
    ) extends LightsailOp[DeleteContactMethodResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteContactMethodResponse] =
        visitor.deleteContactMethod(request)
    }

    final case class DeleteContainerImageOp(
      request: DeleteContainerImageRequest
    ) extends LightsailOp[DeleteContainerImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteContainerImageResponse] =
        visitor.deleteContainerImage(request)
    }

    final case class DeleteContainerServiceOp(
      request: DeleteContainerServiceRequest
    ) extends LightsailOp[DeleteContainerServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteContainerServiceResponse] =
        visitor.deleteContainerService(request)
    }

    final case class DeleteDiskOp(
      request: DeleteDiskRequest
    ) extends LightsailOp[DeleteDiskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDiskResponse] =
        visitor.deleteDisk(request)
    }

    final case class DeleteDiskSnapshotOp(
      request: DeleteDiskSnapshotRequest
    ) extends LightsailOp[DeleteDiskSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDiskSnapshotResponse] =
        visitor.deleteDiskSnapshot(request)
    }

    final case class DeleteDistributionOp(
      request: DeleteDistributionRequest
    ) extends LightsailOp[DeleteDistributionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDistributionResponse] =
        visitor.deleteDistribution(request)
    }

    final case class DeleteDomainOp(
      request: DeleteDomainRequest
    ) extends LightsailOp[DeleteDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDomainResponse] =
        visitor.deleteDomain(request)
    }

    final case class DeleteDomainEntryOp(
      request: DeleteDomainEntryRequest
    ) extends LightsailOp[DeleteDomainEntryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDomainEntryResponse] =
        visitor.deleteDomainEntry(request)
    }

    final case class DeleteInstanceOp(
      request: DeleteInstanceRequest
    ) extends LightsailOp[DeleteInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInstanceResponse] =
        visitor.deleteInstance(request)
    }

    final case class DeleteInstanceSnapshotOp(
      request: DeleteInstanceSnapshotRequest
    ) extends LightsailOp[DeleteInstanceSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInstanceSnapshotResponse] =
        visitor.deleteInstanceSnapshot(request)
    }

    final case class DeleteKeyPairOp(
      request: DeleteKeyPairRequest
    ) extends LightsailOp[DeleteKeyPairResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteKeyPairResponse] =
        visitor.deleteKeyPair(request)
    }

    final case class DeleteKnownHostKeysOp(
      request: DeleteKnownHostKeysRequest
    ) extends LightsailOp[DeleteKnownHostKeysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteKnownHostKeysResponse] =
        visitor.deleteKnownHostKeys(request)
    }

    final case class DeleteLoadBalancerOp(
      request: DeleteLoadBalancerRequest
    ) extends LightsailOp[DeleteLoadBalancerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLoadBalancerResponse] =
        visitor.deleteLoadBalancer(request)
    }

    final case class DeleteLoadBalancerTlsCertificateOp(
      request: DeleteLoadBalancerTlsCertificateRequest
    ) extends LightsailOp[DeleteLoadBalancerTlsCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLoadBalancerTlsCertificateResponse] =
        visitor.deleteLoadBalancerTlsCertificate(request)
    }

    final case class DeleteRelationalDatabaseOp(
      request: DeleteRelationalDatabaseRequest
    ) extends LightsailOp[DeleteRelationalDatabaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRelationalDatabaseResponse] =
        visitor.deleteRelationalDatabase(request)
    }

    final case class DeleteRelationalDatabaseSnapshotOp(
      request: DeleteRelationalDatabaseSnapshotRequest
    ) extends LightsailOp[DeleteRelationalDatabaseSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRelationalDatabaseSnapshotResponse] =
        visitor.deleteRelationalDatabaseSnapshot(request)
    }

    final case class DetachCertificateFromDistributionOp(
      request: DetachCertificateFromDistributionRequest
    ) extends LightsailOp[DetachCertificateFromDistributionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachCertificateFromDistributionResponse] =
        visitor.detachCertificateFromDistribution(request)
    }

    final case class DetachDiskOp(
      request: DetachDiskRequest
    ) extends LightsailOp[DetachDiskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachDiskResponse] =
        visitor.detachDisk(request)
    }

    final case class DetachInstancesFromLoadBalancerOp(
      request: DetachInstancesFromLoadBalancerRequest
    ) extends LightsailOp[DetachInstancesFromLoadBalancerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachInstancesFromLoadBalancerResponse] =
        visitor.detachInstancesFromLoadBalancer(request)
    }

    final case class DetachStaticIpOp(
      request: DetachStaticIpRequest
    ) extends LightsailOp[DetachStaticIpResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachStaticIpResponse] =
        visitor.detachStaticIp(request)
    }

    final case class DisableAddOnOp(
      request: DisableAddOnRequest
    ) extends LightsailOp[DisableAddOnResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableAddOnResponse] =
        visitor.disableAddOn(request)
    }

    final case class DownloadDefaultKeyPairOp(
      request: DownloadDefaultKeyPairRequest
    ) extends LightsailOp[DownloadDefaultKeyPairResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DownloadDefaultKeyPairResponse] =
        visitor.downloadDefaultKeyPair(request)
    }

    final case class EnableAddOnOp(
      request: EnableAddOnRequest
    ) extends LightsailOp[EnableAddOnResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableAddOnResponse] =
        visitor.enableAddOn(request)
    }

    final case class ExportSnapshotOp(
      request: ExportSnapshotRequest
    ) extends LightsailOp[ExportSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExportSnapshotResponse] =
        visitor.exportSnapshot(request)
    }

    final case class GetActiveNamesOp(
      request: GetActiveNamesRequest
    ) extends LightsailOp[GetActiveNamesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetActiveNamesResponse] =
        visitor.getActiveNames(request)
    }

    final case class GetAlarmsOp(
      request: GetAlarmsRequest
    ) extends LightsailOp[GetAlarmsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAlarmsResponse] =
        visitor.getAlarms(request)
    }

    final case class GetAutoSnapshotsOp(
      request: GetAutoSnapshotsRequest
    ) extends LightsailOp[GetAutoSnapshotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAutoSnapshotsResponse] =
        visitor.getAutoSnapshots(request)
    }

    final case class GetBlueprintsOp(
      request: GetBlueprintsRequest
    ) extends LightsailOp[GetBlueprintsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBlueprintsResponse] =
        visitor.getBlueprints(request)
    }

    final case class GetBundlesOp(
      request: GetBundlesRequest
    ) extends LightsailOp[GetBundlesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBundlesResponse] =
        visitor.getBundles(request)
    }

    final case class GetCertificatesOp(
      request: GetCertificatesRequest
    ) extends LightsailOp[GetCertificatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCertificatesResponse] =
        visitor.getCertificates(request)
    }

    final case class GetCloudFormationStackRecordsOp(
      request: GetCloudFormationStackRecordsRequest
    ) extends LightsailOp[GetCloudFormationStackRecordsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCloudFormationStackRecordsResponse] =
        visitor.getCloudFormationStackRecords(request)
    }

    final case class GetContactMethodsOp(
      request: GetContactMethodsRequest
    ) extends LightsailOp[GetContactMethodsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContactMethodsResponse] =
        visitor.getContactMethods(request)
    }

    final case class GetContainerAPIMetadataOp(
      request: GetContainerApiMetadataRequest
    ) extends LightsailOp[GetContainerApiMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContainerApiMetadataResponse] =
        visitor.getContainerAPIMetadata(request)
    }

    final case class GetContainerImagesOp(
      request: GetContainerImagesRequest
    ) extends LightsailOp[GetContainerImagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContainerImagesResponse] =
        visitor.getContainerImages(request)
    }

    final case class GetContainerLogOp(
      request: GetContainerLogRequest
    ) extends LightsailOp[GetContainerLogResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContainerLogResponse] =
        visitor.getContainerLog(request)
    }

    final case class GetContainerServiceDeploymentsOp(
      request: GetContainerServiceDeploymentsRequest
    ) extends LightsailOp[GetContainerServiceDeploymentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContainerServiceDeploymentsResponse] =
        visitor.getContainerServiceDeployments(request)
    }

    final case class GetContainerServiceMetricDataOp(
      request: GetContainerServiceMetricDataRequest
    ) extends LightsailOp[GetContainerServiceMetricDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContainerServiceMetricDataResponse] =
        visitor.getContainerServiceMetricData(request)
    }

    final case class GetContainerServicePowersOp(
      request: GetContainerServicePowersRequest
    ) extends LightsailOp[GetContainerServicePowersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContainerServicePowersResponse] =
        visitor.getContainerServicePowers(request)
    }

    final case class GetContainerServicesOp(
      request: GetContainerServicesRequest
    ) extends LightsailOp[GetContainerServicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContainerServicesResponse] =
        visitor.getContainerServices(request)
    }

    final case class GetDiskOp(
      request: GetDiskRequest
    ) extends LightsailOp[GetDiskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDiskResponse] =
        visitor.getDisk(request)
    }

    final case class GetDiskSnapshotOp(
      request: GetDiskSnapshotRequest
    ) extends LightsailOp[GetDiskSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDiskSnapshotResponse] =
        visitor.getDiskSnapshot(request)
    }

    final case class GetDiskSnapshotsOp(
      request: GetDiskSnapshotsRequest
    ) extends LightsailOp[GetDiskSnapshotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDiskSnapshotsResponse] =
        visitor.getDiskSnapshots(request)
    }

    final case class GetDisksOp(
      request: GetDisksRequest
    ) extends LightsailOp[GetDisksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDisksResponse] =
        visitor.getDisks(request)
    }

    final case class GetDistributionBundlesOp(
      request: GetDistributionBundlesRequest
    ) extends LightsailOp[GetDistributionBundlesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDistributionBundlesResponse] =
        visitor.getDistributionBundles(request)
    }

    final case class GetDistributionLatestCacheResetOp(
      request: GetDistributionLatestCacheResetRequest
    ) extends LightsailOp[GetDistributionLatestCacheResetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDistributionLatestCacheResetResponse] =
        visitor.getDistributionLatestCacheReset(request)
    }

    final case class GetDistributionMetricDataOp(
      request: GetDistributionMetricDataRequest
    ) extends LightsailOp[GetDistributionMetricDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDistributionMetricDataResponse] =
        visitor.getDistributionMetricData(request)
    }

    final case class GetDistributionsOp(
      request: GetDistributionsRequest
    ) extends LightsailOp[GetDistributionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDistributionsResponse] =
        visitor.getDistributions(request)
    }

    final case class GetDomainOp(
      request: GetDomainRequest
    ) extends LightsailOp[GetDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDomainResponse] =
        visitor.getDomain(request)
    }

    final case class GetDomainsOp(
      request: GetDomainsRequest
    ) extends LightsailOp[GetDomainsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDomainsResponse] =
        visitor.getDomains(request)
    }

    final case class GetExportSnapshotRecordsOp(
      request: GetExportSnapshotRecordsRequest
    ) extends LightsailOp[GetExportSnapshotRecordsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetExportSnapshotRecordsResponse] =
        visitor.getExportSnapshotRecords(request)
    }

    final case class GetInstanceOp(
      request: GetInstanceRequest
    ) extends LightsailOp[GetInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInstanceResponse] =
        visitor.getInstance(request)
    }

    final case class GetInstanceAccessDetailsOp(
      request: GetInstanceAccessDetailsRequest
    ) extends LightsailOp[GetInstanceAccessDetailsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInstanceAccessDetailsResponse] =
        visitor.getInstanceAccessDetails(request)
    }

    final case class GetInstanceMetricDataOp(
      request: GetInstanceMetricDataRequest
    ) extends LightsailOp[GetInstanceMetricDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInstanceMetricDataResponse] =
        visitor.getInstanceMetricData(request)
    }

    final case class GetInstancePortStatesOp(
      request: GetInstancePortStatesRequest
    ) extends LightsailOp[GetInstancePortStatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInstancePortStatesResponse] =
        visitor.getInstancePortStates(request)
    }

    final case class GetInstanceSnapshotOp(
      request: GetInstanceSnapshotRequest
    ) extends LightsailOp[GetInstanceSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInstanceSnapshotResponse] =
        visitor.getInstanceSnapshot(request)
    }

    final case class GetInstanceSnapshotsOp(
      request: GetInstanceSnapshotsRequest
    ) extends LightsailOp[GetInstanceSnapshotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInstanceSnapshotsResponse] =
        visitor.getInstanceSnapshots(request)
    }

    final case class GetInstanceStateOp(
      request: GetInstanceStateRequest
    ) extends LightsailOp[GetInstanceStateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInstanceStateResponse] =
        visitor.getInstanceState(request)
    }

    final case class GetInstancesOp(
      request: GetInstancesRequest
    ) extends LightsailOp[GetInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInstancesResponse] =
        visitor.getInstances(request)
    }

    final case class GetKeyPairOp(
      request: GetKeyPairRequest
    ) extends LightsailOp[GetKeyPairResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetKeyPairResponse] =
        visitor.getKeyPair(request)
    }

    final case class GetKeyPairsOp(
      request: GetKeyPairsRequest
    ) extends LightsailOp[GetKeyPairsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetKeyPairsResponse] =
        visitor.getKeyPairs(request)
    }

    final case class GetLoadBalancerOp(
      request: GetLoadBalancerRequest
    ) extends LightsailOp[GetLoadBalancerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLoadBalancerResponse] =
        visitor.getLoadBalancer(request)
    }

    final case class GetLoadBalancerMetricDataOp(
      request: GetLoadBalancerMetricDataRequest
    ) extends LightsailOp[GetLoadBalancerMetricDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLoadBalancerMetricDataResponse] =
        visitor.getLoadBalancerMetricData(request)
    }

    final case class GetLoadBalancerTlsCertificatesOp(
      request: GetLoadBalancerTlsCertificatesRequest
    ) extends LightsailOp[GetLoadBalancerTlsCertificatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLoadBalancerTlsCertificatesResponse] =
        visitor.getLoadBalancerTlsCertificates(request)
    }

    final case class GetLoadBalancersOp(
      request: GetLoadBalancersRequest
    ) extends LightsailOp[GetLoadBalancersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLoadBalancersResponse] =
        visitor.getLoadBalancers(request)
    }

    final case class GetOperationOp(
      request: GetOperationRequest
    ) extends LightsailOp[GetOperationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOperationResponse] =
        visitor.getOperation(request)
    }

    final case class GetOperationsOp(
      request: GetOperationsRequest
    ) extends LightsailOp[GetOperationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOperationsResponse] =
        visitor.getOperations(request)
    }

    final case class GetOperationsForResourceOp(
      request: GetOperationsForResourceRequest
    ) extends LightsailOp[GetOperationsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOperationsForResourceResponse] =
        visitor.getOperationsForResource(request)
    }

    final case class GetRegionsOp(
      request: GetRegionsRequest
    ) extends LightsailOp[GetRegionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRegionsResponse] =
        visitor.getRegions(request)
    }

    final case class GetRelationalDatabaseOp(
      request: GetRelationalDatabaseRequest
    ) extends LightsailOp[GetRelationalDatabaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRelationalDatabaseResponse] =
        visitor.getRelationalDatabase(request)
    }

    final case class GetRelationalDatabaseBlueprintsOp(
      request: GetRelationalDatabaseBlueprintsRequest
    ) extends LightsailOp[GetRelationalDatabaseBlueprintsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRelationalDatabaseBlueprintsResponse] =
        visitor.getRelationalDatabaseBlueprints(request)
    }

    final case class GetRelationalDatabaseBundlesOp(
      request: GetRelationalDatabaseBundlesRequest
    ) extends LightsailOp[GetRelationalDatabaseBundlesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRelationalDatabaseBundlesResponse] =
        visitor.getRelationalDatabaseBundles(request)
    }

    final case class GetRelationalDatabaseEventsOp(
      request: GetRelationalDatabaseEventsRequest
    ) extends LightsailOp[GetRelationalDatabaseEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRelationalDatabaseEventsResponse] =
        visitor.getRelationalDatabaseEvents(request)
    }

    final case class GetRelationalDatabaseLogEventsOp(
      request: GetRelationalDatabaseLogEventsRequest
    ) extends LightsailOp[GetRelationalDatabaseLogEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRelationalDatabaseLogEventsResponse] =
        visitor.getRelationalDatabaseLogEvents(request)
    }

    final case class GetRelationalDatabaseLogStreamsOp(
      request: GetRelationalDatabaseLogStreamsRequest
    ) extends LightsailOp[GetRelationalDatabaseLogStreamsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRelationalDatabaseLogStreamsResponse] =
        visitor.getRelationalDatabaseLogStreams(request)
    }

    final case class GetRelationalDatabaseMasterUserPasswordOp(
      request: GetRelationalDatabaseMasterUserPasswordRequest
    ) extends LightsailOp[GetRelationalDatabaseMasterUserPasswordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRelationalDatabaseMasterUserPasswordResponse] =
        visitor.getRelationalDatabaseMasterUserPassword(request)
    }

    final case class GetRelationalDatabaseMetricDataOp(
      request: GetRelationalDatabaseMetricDataRequest
    ) extends LightsailOp[GetRelationalDatabaseMetricDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRelationalDatabaseMetricDataResponse] =
        visitor.getRelationalDatabaseMetricData(request)
    }

    final case class GetRelationalDatabaseParametersOp(
      request: GetRelationalDatabaseParametersRequest
    ) extends LightsailOp[GetRelationalDatabaseParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRelationalDatabaseParametersResponse] =
        visitor.getRelationalDatabaseParameters(request)
    }

    final case class GetRelationalDatabaseSnapshotOp(
      request: GetRelationalDatabaseSnapshotRequest
    ) extends LightsailOp[GetRelationalDatabaseSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRelationalDatabaseSnapshotResponse] =
        visitor.getRelationalDatabaseSnapshot(request)
    }

    final case class GetRelationalDatabaseSnapshotsOp(
      request: GetRelationalDatabaseSnapshotsRequest
    ) extends LightsailOp[GetRelationalDatabaseSnapshotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRelationalDatabaseSnapshotsResponse] =
        visitor.getRelationalDatabaseSnapshots(request)
    }

    final case class GetRelationalDatabasesOp(
      request: GetRelationalDatabasesRequest
    ) extends LightsailOp[GetRelationalDatabasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRelationalDatabasesResponse] =
        visitor.getRelationalDatabases(request)
    }

    final case class GetStaticIpOp(
      request: GetStaticIpRequest
    ) extends LightsailOp[GetStaticIpResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStaticIpResponse] =
        visitor.getStaticIp(request)
    }

    final case class GetStaticIpsOp(
      request: GetStaticIpsRequest
    ) extends LightsailOp[GetStaticIpsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStaticIpsResponse] =
        visitor.getStaticIps(request)
    }

    final case class ImportKeyPairOp(
      request: ImportKeyPairRequest
    ) extends LightsailOp[ImportKeyPairResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportKeyPairResponse] =
        visitor.importKeyPair(request)
    }

    final case class IsVpcPeeredOp(
      request: IsVpcPeeredRequest
    ) extends LightsailOp[IsVpcPeeredResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[IsVpcPeeredResponse] =
        visitor.isVpcPeered(request)
    }

    final case class OpenInstancePublicPortsOp(
      request: OpenInstancePublicPortsRequest
    ) extends LightsailOp[OpenInstancePublicPortsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[OpenInstancePublicPortsResponse] =
        visitor.openInstancePublicPorts(request)
    }

    final case class PeerVpcOp(
      request: PeerVpcRequest
    ) extends LightsailOp[PeerVpcResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PeerVpcResponse] =
        visitor.peerVpc(request)
    }

    final case class PutAlarmOp(
      request: PutAlarmRequest
    ) extends LightsailOp[PutAlarmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAlarmResponse] =
        visitor.putAlarm(request)
    }

    final case class PutInstancePublicPortsOp(
      request: PutInstancePublicPortsRequest
    ) extends LightsailOp[PutInstancePublicPortsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutInstancePublicPortsResponse] =
        visitor.putInstancePublicPorts(request)
    }

    final case class RebootInstanceOp(
      request: RebootInstanceRequest
    ) extends LightsailOp[RebootInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RebootInstanceResponse] =
        visitor.rebootInstance(request)
    }

    final case class RebootRelationalDatabaseOp(
      request: RebootRelationalDatabaseRequest
    ) extends LightsailOp[RebootRelationalDatabaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RebootRelationalDatabaseResponse] =
        visitor.rebootRelationalDatabase(request)
    }

    final case class RegisterContainerImageOp(
      request: RegisterContainerImageRequest
    ) extends LightsailOp[RegisterContainerImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterContainerImageResponse] =
        visitor.registerContainerImage(request)
    }

    final case class ReleaseStaticIpOp(
      request: ReleaseStaticIpRequest
    ) extends LightsailOp[ReleaseStaticIpResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReleaseStaticIpResponse] =
        visitor.releaseStaticIp(request)
    }

    final case class ResetDistributionCacheOp(
      request: ResetDistributionCacheRequest
    ) extends LightsailOp[ResetDistributionCacheResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetDistributionCacheResponse] =
        visitor.resetDistributionCache(request)
    }

    final case class SendContactMethodVerificationOp(
      request: SendContactMethodVerificationRequest
    ) extends LightsailOp[SendContactMethodVerificationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendContactMethodVerificationResponse] =
        visitor.sendContactMethodVerification(request)
    }

    final case class SetIpAddressTypeOp(
      request: SetIpAddressTypeRequest
    ) extends LightsailOp[SetIpAddressTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetIpAddressTypeResponse] =
        visitor.setIpAddressType(request)
    }

    final case class StartInstanceOp(
      request: StartInstanceRequest
    ) extends LightsailOp[StartInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartInstanceResponse] =
        visitor.startInstance(request)
    }

    final case class StartRelationalDatabaseOp(
      request: StartRelationalDatabaseRequest
    ) extends LightsailOp[StartRelationalDatabaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartRelationalDatabaseResponse] =
        visitor.startRelationalDatabase(request)
    }

    final case class StopInstanceOp(
      request: StopInstanceRequest
    ) extends LightsailOp[StopInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopInstanceResponse] =
        visitor.stopInstance(request)
    }

    final case class StopRelationalDatabaseOp(
      request: StopRelationalDatabaseRequest
    ) extends LightsailOp[StopRelationalDatabaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopRelationalDatabaseResponse] =
        visitor.stopRelationalDatabase(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends LightsailOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class TestAlarmOp(
      request: TestAlarmRequest
    ) extends LightsailOp[TestAlarmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TestAlarmResponse] =
        visitor.testAlarm(request)
    }

    final case class UnpeerVpcOp(
      request: UnpeerVpcRequest
    ) extends LightsailOp[UnpeerVpcResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UnpeerVpcResponse] =
        visitor.unpeerVpc(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends LightsailOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateContainerServiceOp(
      request: UpdateContainerServiceRequest
    ) extends LightsailOp[UpdateContainerServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateContainerServiceResponse] =
        visitor.updateContainerService(request)
    }

    final case class UpdateDistributionOp(
      request: UpdateDistributionRequest
    ) extends LightsailOp[UpdateDistributionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDistributionResponse] =
        visitor.updateDistribution(request)
    }

    final case class UpdateDistributionBundleOp(
      request: UpdateDistributionBundleRequest
    ) extends LightsailOp[UpdateDistributionBundleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDistributionBundleResponse] =
        visitor.updateDistributionBundle(request)
    }

    final case class UpdateDomainEntryOp(
      request: UpdateDomainEntryRequest
    ) extends LightsailOp[UpdateDomainEntryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDomainEntryResponse] =
        visitor.updateDomainEntry(request)
    }

    final case class UpdateLoadBalancerAttributeOp(
      request: UpdateLoadBalancerAttributeRequest
    ) extends LightsailOp[UpdateLoadBalancerAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLoadBalancerAttributeResponse] =
        visitor.updateLoadBalancerAttribute(request)
    }

    final case class UpdateRelationalDatabaseOp(
      request: UpdateRelationalDatabaseRequest
    ) extends LightsailOp[UpdateRelationalDatabaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRelationalDatabaseResponse] =
        visitor.updateRelationalDatabase(request)
    }

    final case class UpdateRelationalDatabaseParametersOp(
      request: UpdateRelationalDatabaseParametersRequest
    ) extends LightsailOp[UpdateRelationalDatabaseParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRelationalDatabaseParametersResponse] =
        visitor.updateRelationalDatabaseParameters(request)
    }
  }

  import LightsailOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[LightsailOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def allocateStaticIp(
    request: AllocateStaticIpRequest
  ): LightsailIO[AllocateStaticIpResponse] =
    FF.liftF(AllocateStaticIpOp(request))

  def attachCertificateToDistribution(
    request: AttachCertificateToDistributionRequest
  ): LightsailIO[AttachCertificateToDistributionResponse] =
    FF.liftF(AttachCertificateToDistributionOp(request))

  def attachDisk(
    request: AttachDiskRequest
  ): LightsailIO[AttachDiskResponse] =
    FF.liftF(AttachDiskOp(request))

  def attachInstancesToLoadBalancer(
    request: AttachInstancesToLoadBalancerRequest
  ): LightsailIO[AttachInstancesToLoadBalancerResponse] =
    FF.liftF(AttachInstancesToLoadBalancerOp(request))

  def attachLoadBalancerTlsCertificate(
    request: AttachLoadBalancerTlsCertificateRequest
  ): LightsailIO[AttachLoadBalancerTlsCertificateResponse] =
    FF.liftF(AttachLoadBalancerTlsCertificateOp(request))

  def attachStaticIp(
    request: AttachStaticIpRequest
  ): LightsailIO[AttachStaticIpResponse] =
    FF.liftF(AttachStaticIpOp(request))

  def closeInstancePublicPorts(
    request: CloseInstancePublicPortsRequest
  ): LightsailIO[CloseInstancePublicPortsResponse] =
    FF.liftF(CloseInstancePublicPortsOp(request))

  def copySnapshot(
    request: CopySnapshotRequest
  ): LightsailIO[CopySnapshotResponse] =
    FF.liftF(CopySnapshotOp(request))

  def createCertificate(
    request: CreateCertificateRequest
  ): LightsailIO[CreateCertificateResponse] =
    FF.liftF(CreateCertificateOp(request))

  def createCloudFormationStack(
    request: CreateCloudFormationStackRequest
  ): LightsailIO[CreateCloudFormationStackResponse] =
    FF.liftF(CreateCloudFormationStackOp(request))

  def createContactMethod(
    request: CreateContactMethodRequest
  ): LightsailIO[CreateContactMethodResponse] =
    FF.liftF(CreateContactMethodOp(request))

  def createContainerService(
    request: CreateContainerServiceRequest
  ): LightsailIO[CreateContainerServiceResponse] =
    FF.liftF(CreateContainerServiceOp(request))

  def createContainerServiceDeployment(
    request: CreateContainerServiceDeploymentRequest
  ): LightsailIO[CreateContainerServiceDeploymentResponse] =
    FF.liftF(CreateContainerServiceDeploymentOp(request))

  def createContainerServiceRegistryLogin(
    request: CreateContainerServiceRegistryLoginRequest
  ): LightsailIO[CreateContainerServiceRegistryLoginResponse] =
    FF.liftF(CreateContainerServiceRegistryLoginOp(request))

  def createDisk(
    request: CreateDiskRequest
  ): LightsailIO[CreateDiskResponse] =
    FF.liftF(CreateDiskOp(request))

  def createDiskFromSnapshot(
    request: CreateDiskFromSnapshotRequest
  ): LightsailIO[CreateDiskFromSnapshotResponse] =
    FF.liftF(CreateDiskFromSnapshotOp(request))

  def createDiskSnapshot(
    request: CreateDiskSnapshotRequest
  ): LightsailIO[CreateDiskSnapshotResponse] =
    FF.liftF(CreateDiskSnapshotOp(request))

  def createDistribution(
    request: CreateDistributionRequest
  ): LightsailIO[CreateDistributionResponse] =
    FF.liftF(CreateDistributionOp(request))

  def createDomain(
    request: CreateDomainRequest
  ): LightsailIO[CreateDomainResponse] =
    FF.liftF(CreateDomainOp(request))

  def createDomainEntry(
    request: CreateDomainEntryRequest
  ): LightsailIO[CreateDomainEntryResponse] =
    FF.liftF(CreateDomainEntryOp(request))

  def createInstanceSnapshot(
    request: CreateInstanceSnapshotRequest
  ): LightsailIO[CreateInstanceSnapshotResponse] =
    FF.liftF(CreateInstanceSnapshotOp(request))

  def createInstances(
    request: CreateInstancesRequest
  ): LightsailIO[CreateInstancesResponse] =
    FF.liftF(CreateInstancesOp(request))

  def createInstancesFromSnapshot(
    request: CreateInstancesFromSnapshotRequest
  ): LightsailIO[CreateInstancesFromSnapshotResponse] =
    FF.liftF(CreateInstancesFromSnapshotOp(request))

  def createKeyPair(
    request: CreateKeyPairRequest
  ): LightsailIO[CreateKeyPairResponse] =
    FF.liftF(CreateKeyPairOp(request))

  def createLoadBalancer(
    request: CreateLoadBalancerRequest
  ): LightsailIO[CreateLoadBalancerResponse] =
    FF.liftF(CreateLoadBalancerOp(request))

  def createLoadBalancerTlsCertificate(
    request: CreateLoadBalancerTlsCertificateRequest
  ): LightsailIO[CreateLoadBalancerTlsCertificateResponse] =
    FF.liftF(CreateLoadBalancerTlsCertificateOp(request))

  def createRelationalDatabase(
    request: CreateRelationalDatabaseRequest
  ): LightsailIO[CreateRelationalDatabaseResponse] =
    FF.liftF(CreateRelationalDatabaseOp(request))

  def createRelationalDatabaseFromSnapshot(
    request: CreateRelationalDatabaseFromSnapshotRequest
  ): LightsailIO[CreateRelationalDatabaseFromSnapshotResponse] =
    FF.liftF(CreateRelationalDatabaseFromSnapshotOp(request))

  def createRelationalDatabaseSnapshot(
    request: CreateRelationalDatabaseSnapshotRequest
  ): LightsailIO[CreateRelationalDatabaseSnapshotResponse] =
    FF.liftF(CreateRelationalDatabaseSnapshotOp(request))

  def deleteAlarm(
    request: DeleteAlarmRequest
  ): LightsailIO[DeleteAlarmResponse] =
    FF.liftF(DeleteAlarmOp(request))

  def deleteAutoSnapshot(
    request: DeleteAutoSnapshotRequest
  ): LightsailIO[DeleteAutoSnapshotResponse] =
    FF.liftF(DeleteAutoSnapshotOp(request))

  def deleteCertificate(
    request: DeleteCertificateRequest
  ): LightsailIO[DeleteCertificateResponse] =
    FF.liftF(DeleteCertificateOp(request))

  def deleteContactMethod(
    request: DeleteContactMethodRequest
  ): LightsailIO[DeleteContactMethodResponse] =
    FF.liftF(DeleteContactMethodOp(request))

  def deleteContainerImage(
    request: DeleteContainerImageRequest
  ): LightsailIO[DeleteContainerImageResponse] =
    FF.liftF(DeleteContainerImageOp(request))

  def deleteContainerService(
    request: DeleteContainerServiceRequest
  ): LightsailIO[DeleteContainerServiceResponse] =
    FF.liftF(DeleteContainerServiceOp(request))

  def deleteDisk(
    request: DeleteDiskRequest
  ): LightsailIO[DeleteDiskResponse] =
    FF.liftF(DeleteDiskOp(request))

  def deleteDiskSnapshot(
    request: DeleteDiskSnapshotRequest
  ): LightsailIO[DeleteDiskSnapshotResponse] =
    FF.liftF(DeleteDiskSnapshotOp(request))

  def deleteDistribution(
    request: DeleteDistributionRequest
  ): LightsailIO[DeleteDistributionResponse] =
    FF.liftF(DeleteDistributionOp(request))

  def deleteDomain(
    request: DeleteDomainRequest
  ): LightsailIO[DeleteDomainResponse] =
    FF.liftF(DeleteDomainOp(request))

  def deleteDomainEntry(
    request: DeleteDomainEntryRequest
  ): LightsailIO[DeleteDomainEntryResponse] =
    FF.liftF(DeleteDomainEntryOp(request))

  def deleteInstance(
    request: DeleteInstanceRequest
  ): LightsailIO[DeleteInstanceResponse] =
    FF.liftF(DeleteInstanceOp(request))

  def deleteInstanceSnapshot(
    request: DeleteInstanceSnapshotRequest
  ): LightsailIO[DeleteInstanceSnapshotResponse] =
    FF.liftF(DeleteInstanceSnapshotOp(request))

  def deleteKeyPair(
    request: DeleteKeyPairRequest
  ): LightsailIO[DeleteKeyPairResponse] =
    FF.liftF(DeleteKeyPairOp(request))

  def deleteKnownHostKeys(
    request: DeleteKnownHostKeysRequest
  ): LightsailIO[DeleteKnownHostKeysResponse] =
    FF.liftF(DeleteKnownHostKeysOp(request))

  def deleteLoadBalancer(
    request: DeleteLoadBalancerRequest
  ): LightsailIO[DeleteLoadBalancerResponse] =
    FF.liftF(DeleteLoadBalancerOp(request))

  def deleteLoadBalancerTlsCertificate(
    request: DeleteLoadBalancerTlsCertificateRequest
  ): LightsailIO[DeleteLoadBalancerTlsCertificateResponse] =
    FF.liftF(DeleteLoadBalancerTlsCertificateOp(request))

  def deleteRelationalDatabase(
    request: DeleteRelationalDatabaseRequest
  ): LightsailIO[DeleteRelationalDatabaseResponse] =
    FF.liftF(DeleteRelationalDatabaseOp(request))

  def deleteRelationalDatabaseSnapshot(
    request: DeleteRelationalDatabaseSnapshotRequest
  ): LightsailIO[DeleteRelationalDatabaseSnapshotResponse] =
    FF.liftF(DeleteRelationalDatabaseSnapshotOp(request))

  def detachCertificateFromDistribution(
    request: DetachCertificateFromDistributionRequest
  ): LightsailIO[DetachCertificateFromDistributionResponse] =
    FF.liftF(DetachCertificateFromDistributionOp(request))

  def detachDisk(
    request: DetachDiskRequest
  ): LightsailIO[DetachDiskResponse] =
    FF.liftF(DetachDiskOp(request))

  def detachInstancesFromLoadBalancer(
    request: DetachInstancesFromLoadBalancerRequest
  ): LightsailIO[DetachInstancesFromLoadBalancerResponse] =
    FF.liftF(DetachInstancesFromLoadBalancerOp(request))

  def detachStaticIp(
    request: DetachStaticIpRequest
  ): LightsailIO[DetachStaticIpResponse] =
    FF.liftF(DetachStaticIpOp(request))

  def disableAddOn(
    request: DisableAddOnRequest
  ): LightsailIO[DisableAddOnResponse] =
    FF.liftF(DisableAddOnOp(request))

  def downloadDefaultKeyPair(
    request: DownloadDefaultKeyPairRequest
  ): LightsailIO[DownloadDefaultKeyPairResponse] =
    FF.liftF(DownloadDefaultKeyPairOp(request))

  def enableAddOn(
    request: EnableAddOnRequest
  ): LightsailIO[EnableAddOnResponse] =
    FF.liftF(EnableAddOnOp(request))

  def exportSnapshot(
    request: ExportSnapshotRequest
  ): LightsailIO[ExportSnapshotResponse] =
    FF.liftF(ExportSnapshotOp(request))

  def getActiveNames(
    request: GetActiveNamesRequest
  ): LightsailIO[GetActiveNamesResponse] =
    FF.liftF(GetActiveNamesOp(request))

  def getAlarms(
    request: GetAlarmsRequest
  ): LightsailIO[GetAlarmsResponse] =
    FF.liftF(GetAlarmsOp(request))

  def getAutoSnapshots(
    request: GetAutoSnapshotsRequest
  ): LightsailIO[GetAutoSnapshotsResponse] =
    FF.liftF(GetAutoSnapshotsOp(request))

  def getBlueprints(
    request: GetBlueprintsRequest
  ): LightsailIO[GetBlueprintsResponse] =
    FF.liftF(GetBlueprintsOp(request))

  def getBundles(
    request: GetBundlesRequest
  ): LightsailIO[GetBundlesResponse] =
    FF.liftF(GetBundlesOp(request))

  def getCertificates(
    request: GetCertificatesRequest
  ): LightsailIO[GetCertificatesResponse] =
    FF.liftF(GetCertificatesOp(request))

  def getCloudFormationStackRecords(
    request: GetCloudFormationStackRecordsRequest
  ): LightsailIO[GetCloudFormationStackRecordsResponse] =
    FF.liftF(GetCloudFormationStackRecordsOp(request))

  def getContactMethods(
    request: GetContactMethodsRequest
  ): LightsailIO[GetContactMethodsResponse] =
    FF.liftF(GetContactMethodsOp(request))

  def getContainerAPIMetadata(
    request: GetContainerApiMetadataRequest
  ): LightsailIO[GetContainerApiMetadataResponse] =
    FF.liftF(GetContainerAPIMetadataOp(request))

  def getContainerImages(
    request: GetContainerImagesRequest
  ): LightsailIO[GetContainerImagesResponse] =
    FF.liftF(GetContainerImagesOp(request))

  def getContainerLog(
    request: GetContainerLogRequest
  ): LightsailIO[GetContainerLogResponse] =
    FF.liftF(GetContainerLogOp(request))

  def getContainerServiceDeployments(
    request: GetContainerServiceDeploymentsRequest
  ): LightsailIO[GetContainerServiceDeploymentsResponse] =
    FF.liftF(GetContainerServiceDeploymentsOp(request))

  def getContainerServiceMetricData(
    request: GetContainerServiceMetricDataRequest
  ): LightsailIO[GetContainerServiceMetricDataResponse] =
    FF.liftF(GetContainerServiceMetricDataOp(request))

  def getContainerServicePowers(
    request: GetContainerServicePowersRequest
  ): LightsailIO[GetContainerServicePowersResponse] =
    FF.liftF(GetContainerServicePowersOp(request))

  def getContainerServices(
    request: GetContainerServicesRequest
  ): LightsailIO[GetContainerServicesResponse] =
    FF.liftF(GetContainerServicesOp(request))

  def getDisk(
    request: GetDiskRequest
  ): LightsailIO[GetDiskResponse] =
    FF.liftF(GetDiskOp(request))

  def getDiskSnapshot(
    request: GetDiskSnapshotRequest
  ): LightsailIO[GetDiskSnapshotResponse] =
    FF.liftF(GetDiskSnapshotOp(request))

  def getDiskSnapshots(
    request: GetDiskSnapshotsRequest
  ): LightsailIO[GetDiskSnapshotsResponse] =
    FF.liftF(GetDiskSnapshotsOp(request))

  def getDisks(
    request: GetDisksRequest
  ): LightsailIO[GetDisksResponse] =
    FF.liftF(GetDisksOp(request))

  def getDistributionBundles(
    request: GetDistributionBundlesRequest
  ): LightsailIO[GetDistributionBundlesResponse] =
    FF.liftF(GetDistributionBundlesOp(request))

  def getDistributionLatestCacheReset(
    request: GetDistributionLatestCacheResetRequest
  ): LightsailIO[GetDistributionLatestCacheResetResponse] =
    FF.liftF(GetDistributionLatestCacheResetOp(request))

  def getDistributionMetricData(
    request: GetDistributionMetricDataRequest
  ): LightsailIO[GetDistributionMetricDataResponse] =
    FF.liftF(GetDistributionMetricDataOp(request))

  def getDistributions(
    request: GetDistributionsRequest
  ): LightsailIO[GetDistributionsResponse] =
    FF.liftF(GetDistributionsOp(request))

  def getDomain(
    request: GetDomainRequest
  ): LightsailIO[GetDomainResponse] =
    FF.liftF(GetDomainOp(request))

  def getDomains(
    request: GetDomainsRequest
  ): LightsailIO[GetDomainsResponse] =
    FF.liftF(GetDomainsOp(request))

  def getExportSnapshotRecords(
    request: GetExportSnapshotRecordsRequest
  ): LightsailIO[GetExportSnapshotRecordsResponse] =
    FF.liftF(GetExportSnapshotRecordsOp(request))

  def getInstance(
    request: GetInstanceRequest
  ): LightsailIO[GetInstanceResponse] =
    FF.liftF(GetInstanceOp(request))

  def getInstanceAccessDetails(
    request: GetInstanceAccessDetailsRequest
  ): LightsailIO[GetInstanceAccessDetailsResponse] =
    FF.liftF(GetInstanceAccessDetailsOp(request))

  def getInstanceMetricData(
    request: GetInstanceMetricDataRequest
  ): LightsailIO[GetInstanceMetricDataResponse] =
    FF.liftF(GetInstanceMetricDataOp(request))

  def getInstancePortStates(
    request: GetInstancePortStatesRequest
  ): LightsailIO[GetInstancePortStatesResponse] =
    FF.liftF(GetInstancePortStatesOp(request))

  def getInstanceSnapshot(
    request: GetInstanceSnapshotRequest
  ): LightsailIO[GetInstanceSnapshotResponse] =
    FF.liftF(GetInstanceSnapshotOp(request))

  def getInstanceSnapshots(
    request: GetInstanceSnapshotsRequest
  ): LightsailIO[GetInstanceSnapshotsResponse] =
    FF.liftF(GetInstanceSnapshotsOp(request))

  def getInstanceState(
    request: GetInstanceStateRequest
  ): LightsailIO[GetInstanceStateResponse] =
    FF.liftF(GetInstanceStateOp(request))

  def getInstances(
    request: GetInstancesRequest
  ): LightsailIO[GetInstancesResponse] =
    FF.liftF(GetInstancesOp(request))

  def getKeyPair(
    request: GetKeyPairRequest
  ): LightsailIO[GetKeyPairResponse] =
    FF.liftF(GetKeyPairOp(request))

  def getKeyPairs(
    request: GetKeyPairsRequest
  ): LightsailIO[GetKeyPairsResponse] =
    FF.liftF(GetKeyPairsOp(request))

  def getLoadBalancer(
    request: GetLoadBalancerRequest
  ): LightsailIO[GetLoadBalancerResponse] =
    FF.liftF(GetLoadBalancerOp(request))

  def getLoadBalancerMetricData(
    request: GetLoadBalancerMetricDataRequest
  ): LightsailIO[GetLoadBalancerMetricDataResponse] =
    FF.liftF(GetLoadBalancerMetricDataOp(request))

  def getLoadBalancerTlsCertificates(
    request: GetLoadBalancerTlsCertificatesRequest
  ): LightsailIO[GetLoadBalancerTlsCertificatesResponse] =
    FF.liftF(GetLoadBalancerTlsCertificatesOp(request))

  def getLoadBalancers(
    request: GetLoadBalancersRequest
  ): LightsailIO[GetLoadBalancersResponse] =
    FF.liftF(GetLoadBalancersOp(request))

  def getOperation(
    request: GetOperationRequest
  ): LightsailIO[GetOperationResponse] =
    FF.liftF(GetOperationOp(request))

  def getOperations(
    request: GetOperationsRequest
  ): LightsailIO[GetOperationsResponse] =
    FF.liftF(GetOperationsOp(request))

  def getOperationsForResource(
    request: GetOperationsForResourceRequest
  ): LightsailIO[GetOperationsForResourceResponse] =
    FF.liftF(GetOperationsForResourceOp(request))

  def getRegions(
    request: GetRegionsRequest
  ): LightsailIO[GetRegionsResponse] =
    FF.liftF(GetRegionsOp(request))

  def getRelationalDatabase(
    request: GetRelationalDatabaseRequest
  ): LightsailIO[GetRelationalDatabaseResponse] =
    FF.liftF(GetRelationalDatabaseOp(request))

  def getRelationalDatabaseBlueprints(
    request: GetRelationalDatabaseBlueprintsRequest
  ): LightsailIO[GetRelationalDatabaseBlueprintsResponse] =
    FF.liftF(GetRelationalDatabaseBlueprintsOp(request))

  def getRelationalDatabaseBundles(
    request: GetRelationalDatabaseBundlesRequest
  ): LightsailIO[GetRelationalDatabaseBundlesResponse] =
    FF.liftF(GetRelationalDatabaseBundlesOp(request))

  def getRelationalDatabaseEvents(
    request: GetRelationalDatabaseEventsRequest
  ): LightsailIO[GetRelationalDatabaseEventsResponse] =
    FF.liftF(GetRelationalDatabaseEventsOp(request))

  def getRelationalDatabaseLogEvents(
    request: GetRelationalDatabaseLogEventsRequest
  ): LightsailIO[GetRelationalDatabaseLogEventsResponse] =
    FF.liftF(GetRelationalDatabaseLogEventsOp(request))

  def getRelationalDatabaseLogStreams(
    request: GetRelationalDatabaseLogStreamsRequest
  ): LightsailIO[GetRelationalDatabaseLogStreamsResponse] =
    FF.liftF(GetRelationalDatabaseLogStreamsOp(request))

  def getRelationalDatabaseMasterUserPassword(
    request: GetRelationalDatabaseMasterUserPasswordRequest
  ): LightsailIO[GetRelationalDatabaseMasterUserPasswordResponse] =
    FF.liftF(GetRelationalDatabaseMasterUserPasswordOp(request))

  def getRelationalDatabaseMetricData(
    request: GetRelationalDatabaseMetricDataRequest
  ): LightsailIO[GetRelationalDatabaseMetricDataResponse] =
    FF.liftF(GetRelationalDatabaseMetricDataOp(request))

  def getRelationalDatabaseParameters(
    request: GetRelationalDatabaseParametersRequest
  ): LightsailIO[GetRelationalDatabaseParametersResponse] =
    FF.liftF(GetRelationalDatabaseParametersOp(request))

  def getRelationalDatabaseSnapshot(
    request: GetRelationalDatabaseSnapshotRequest
  ): LightsailIO[GetRelationalDatabaseSnapshotResponse] =
    FF.liftF(GetRelationalDatabaseSnapshotOp(request))

  def getRelationalDatabaseSnapshots(
    request: GetRelationalDatabaseSnapshotsRequest
  ): LightsailIO[GetRelationalDatabaseSnapshotsResponse] =
    FF.liftF(GetRelationalDatabaseSnapshotsOp(request))

  def getRelationalDatabases(
    request: GetRelationalDatabasesRequest
  ): LightsailIO[GetRelationalDatabasesResponse] =
    FF.liftF(GetRelationalDatabasesOp(request))

  def getStaticIp(
    request: GetStaticIpRequest
  ): LightsailIO[GetStaticIpResponse] =
    FF.liftF(GetStaticIpOp(request))

  def getStaticIps(
    request: GetStaticIpsRequest
  ): LightsailIO[GetStaticIpsResponse] =
    FF.liftF(GetStaticIpsOp(request))

  def importKeyPair(
    request: ImportKeyPairRequest
  ): LightsailIO[ImportKeyPairResponse] =
    FF.liftF(ImportKeyPairOp(request))

  def isVpcPeered(
    request: IsVpcPeeredRequest
  ): LightsailIO[IsVpcPeeredResponse] =
    FF.liftF(IsVpcPeeredOp(request))

  def openInstancePublicPorts(
    request: OpenInstancePublicPortsRequest
  ): LightsailIO[OpenInstancePublicPortsResponse] =
    FF.liftF(OpenInstancePublicPortsOp(request))

  def peerVpc(
    request: PeerVpcRequest
  ): LightsailIO[PeerVpcResponse] =
    FF.liftF(PeerVpcOp(request))

  def putAlarm(
    request: PutAlarmRequest
  ): LightsailIO[PutAlarmResponse] =
    FF.liftF(PutAlarmOp(request))

  def putInstancePublicPorts(
    request: PutInstancePublicPortsRequest
  ): LightsailIO[PutInstancePublicPortsResponse] =
    FF.liftF(PutInstancePublicPortsOp(request))

  def rebootInstance(
    request: RebootInstanceRequest
  ): LightsailIO[RebootInstanceResponse] =
    FF.liftF(RebootInstanceOp(request))

  def rebootRelationalDatabase(
    request: RebootRelationalDatabaseRequest
  ): LightsailIO[RebootRelationalDatabaseResponse] =
    FF.liftF(RebootRelationalDatabaseOp(request))

  def registerContainerImage(
    request: RegisterContainerImageRequest
  ): LightsailIO[RegisterContainerImageResponse] =
    FF.liftF(RegisterContainerImageOp(request))

  def releaseStaticIp(
    request: ReleaseStaticIpRequest
  ): LightsailIO[ReleaseStaticIpResponse] =
    FF.liftF(ReleaseStaticIpOp(request))

  def resetDistributionCache(
    request: ResetDistributionCacheRequest
  ): LightsailIO[ResetDistributionCacheResponse] =
    FF.liftF(ResetDistributionCacheOp(request))

  def sendContactMethodVerification(
    request: SendContactMethodVerificationRequest
  ): LightsailIO[SendContactMethodVerificationResponse] =
    FF.liftF(SendContactMethodVerificationOp(request))

  def setIpAddressType(
    request: SetIpAddressTypeRequest
  ): LightsailIO[SetIpAddressTypeResponse] =
    FF.liftF(SetIpAddressTypeOp(request))

  def startInstance(
    request: StartInstanceRequest
  ): LightsailIO[StartInstanceResponse] =
    FF.liftF(StartInstanceOp(request))

  def startRelationalDatabase(
    request: StartRelationalDatabaseRequest
  ): LightsailIO[StartRelationalDatabaseResponse] =
    FF.liftF(StartRelationalDatabaseOp(request))

  def stopInstance(
    request: StopInstanceRequest
  ): LightsailIO[StopInstanceResponse] =
    FF.liftF(StopInstanceOp(request))

  def stopRelationalDatabase(
    request: StopRelationalDatabaseRequest
  ): LightsailIO[StopRelationalDatabaseResponse] =
    FF.liftF(StopRelationalDatabaseOp(request))

  def tagResource(
    request: TagResourceRequest
  ): LightsailIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def testAlarm(
    request: TestAlarmRequest
  ): LightsailIO[TestAlarmResponse] =
    FF.liftF(TestAlarmOp(request))

  def unpeerVpc(
    request: UnpeerVpcRequest
  ): LightsailIO[UnpeerVpcResponse] =
    FF.liftF(UnpeerVpcOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): LightsailIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateContainerService(
    request: UpdateContainerServiceRequest
  ): LightsailIO[UpdateContainerServiceResponse] =
    FF.liftF(UpdateContainerServiceOp(request))

  def updateDistribution(
    request: UpdateDistributionRequest
  ): LightsailIO[UpdateDistributionResponse] =
    FF.liftF(UpdateDistributionOp(request))

  def updateDistributionBundle(
    request: UpdateDistributionBundleRequest
  ): LightsailIO[UpdateDistributionBundleResponse] =
    FF.liftF(UpdateDistributionBundleOp(request))

  def updateDomainEntry(
    request: UpdateDomainEntryRequest
  ): LightsailIO[UpdateDomainEntryResponse] =
    FF.liftF(UpdateDomainEntryOp(request))

  def updateLoadBalancerAttribute(
    request: UpdateLoadBalancerAttributeRequest
  ): LightsailIO[UpdateLoadBalancerAttributeResponse] =
    FF.liftF(UpdateLoadBalancerAttributeOp(request))

  def updateRelationalDatabase(
    request: UpdateRelationalDatabaseRequest
  ): LightsailIO[UpdateRelationalDatabaseResponse] =
    FF.liftF(UpdateRelationalDatabaseOp(request))

  def updateRelationalDatabaseParameters(
    request: UpdateRelationalDatabaseParametersRequest
  ): LightsailIO[UpdateRelationalDatabaseParametersResponse] =
    FF.liftF(UpdateRelationalDatabaseParametersOp(request))
}
