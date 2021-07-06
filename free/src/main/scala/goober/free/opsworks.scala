package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.opsworks.OpsWorksClient
import software.amazon.awssdk.services.opsworks.model._


object opsworks { module =>

  // Free monad over OpsWorksOp
  type OpsWorksIO[A] = FF[OpsWorksOp, A]

  sealed trait OpsWorksOp[A] {
    def visit[F[_]](visitor: OpsWorksOp.Visitor[F]): F[A]
  }

  object OpsWorksOp {
    // Given a OpsWorksClient we can embed a OpsWorksIO program in any algebra that understands embedding.
    implicit val OpsWorksOpEmbeddable: Embeddable[OpsWorksOp, OpsWorksClient] = new Embeddable[OpsWorksOp, OpsWorksClient] {
      def embed[A](client: OpsWorksClient, io: OpsWorksIO[A]): Embedded[A] = Embedded.OpsWorks(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends OpsWorksOp.Visitor[Kleisli[M, OpsWorksClient, *]] {
        def assignInstance(
          request: AssignInstanceRequest
        ): Kleisli[M, OpsWorksClient, AssignInstanceResponse] =
          primitive(_.assignInstance(request))

        def assignVolume(
          request: AssignVolumeRequest
        ): Kleisli[M, OpsWorksClient, AssignVolumeResponse] =
          primitive(_.assignVolume(request))

        def associateElasticIp(
          request: AssociateElasticIpRequest
        ): Kleisli[M, OpsWorksClient, AssociateElasticIpResponse] =
          primitive(_.associateElasticIp(request))

        def attachElasticLoadBalancer(
          request: AttachElasticLoadBalancerRequest
        ): Kleisli[M, OpsWorksClient, AttachElasticLoadBalancerResponse] =
          primitive(_.attachElasticLoadBalancer(request))

        def cloneStack(
          request: CloneStackRequest
        ): Kleisli[M, OpsWorksClient, CloneStackResponse] =
          primitive(_.cloneStack(request))

        def createApp(
          request: CreateAppRequest
        ): Kleisli[M, OpsWorksClient, CreateAppResponse] =
          primitive(_.createApp(request))

        def createDeployment(
          request: CreateDeploymentRequest
        ): Kleisli[M, OpsWorksClient, CreateDeploymentResponse] =
          primitive(_.createDeployment(request))

        def createInstance(
          request: CreateInstanceRequest
        ): Kleisli[M, OpsWorksClient, CreateInstanceResponse] =
          primitive(_.createInstance(request))

        def createLayer(
          request: CreateLayerRequest
        ): Kleisli[M, OpsWorksClient, CreateLayerResponse] =
          primitive(_.createLayer(request))

        def createStack(
          request: CreateStackRequest
        ): Kleisli[M, OpsWorksClient, CreateStackResponse] =
          primitive(_.createStack(request))

        def createUserProfile(
          request: CreateUserProfileRequest
        ): Kleisli[M, OpsWorksClient, CreateUserProfileResponse] =
          primitive(_.createUserProfile(request))

        def deleteApp(
          request: DeleteAppRequest
        ): Kleisli[M, OpsWorksClient, DeleteAppResponse] =
          primitive(_.deleteApp(request))

        def deleteInstance(
          request: DeleteInstanceRequest
        ): Kleisli[M, OpsWorksClient, DeleteInstanceResponse] =
          primitive(_.deleteInstance(request))

        def deleteLayer(
          request: DeleteLayerRequest
        ): Kleisli[M, OpsWorksClient, DeleteLayerResponse] =
          primitive(_.deleteLayer(request))

        def deleteStack(
          request: DeleteStackRequest
        ): Kleisli[M, OpsWorksClient, DeleteStackResponse] =
          primitive(_.deleteStack(request))

        def deleteUserProfile(
          request: DeleteUserProfileRequest
        ): Kleisli[M, OpsWorksClient, DeleteUserProfileResponse] =
          primitive(_.deleteUserProfile(request))

        def deregisterEcsCluster(
          request: DeregisterEcsClusterRequest
        ): Kleisli[M, OpsWorksClient, DeregisterEcsClusterResponse] =
          primitive(_.deregisterEcsCluster(request))

        def deregisterElasticIp(
          request: DeregisterElasticIpRequest
        ): Kleisli[M, OpsWorksClient, DeregisterElasticIpResponse] =
          primitive(_.deregisterElasticIp(request))

        def deregisterInstance(
          request: DeregisterInstanceRequest
        ): Kleisli[M, OpsWorksClient, DeregisterInstanceResponse] =
          primitive(_.deregisterInstance(request))

        def deregisterRdsDbInstance(
          request: DeregisterRdsDbInstanceRequest
        ): Kleisli[M, OpsWorksClient, DeregisterRdsDbInstanceResponse] =
          primitive(_.deregisterRdsDbInstance(request))

        def deregisterVolume(
          request: DeregisterVolumeRequest
        ): Kleisli[M, OpsWorksClient, DeregisterVolumeResponse] =
          primitive(_.deregisterVolume(request))

        def describeAgentVersions(
          request: DescribeAgentVersionsRequest
        ): Kleisli[M, OpsWorksClient, DescribeAgentVersionsResponse] =
          primitive(_.describeAgentVersions(request))

        def describeApps(
          request: DescribeAppsRequest
        ): Kleisli[M, OpsWorksClient, DescribeAppsResponse] =
          primitive(_.describeApps(request))

        def describeCommands(
          request: DescribeCommandsRequest
        ): Kleisli[M, OpsWorksClient, DescribeCommandsResponse] =
          primitive(_.describeCommands(request))

        def describeDeployments(
          request: DescribeDeploymentsRequest
        ): Kleisli[M, OpsWorksClient, DescribeDeploymentsResponse] =
          primitive(_.describeDeployments(request))

        def describeEcsClusters(
          request: DescribeEcsClustersRequest
        ): Kleisli[M, OpsWorksClient, DescribeEcsClustersResponse] =
          primitive(_.describeEcsClusters(request))

        def describeElasticIps(
          request: DescribeElasticIpsRequest
        ): Kleisli[M, OpsWorksClient, DescribeElasticIpsResponse] =
          primitive(_.describeElasticIps(request))

        def describeElasticLoadBalancers(
          request: DescribeElasticLoadBalancersRequest
        ): Kleisli[M, OpsWorksClient, DescribeElasticLoadBalancersResponse] =
          primitive(_.describeElasticLoadBalancers(request))

        def describeInstances(
          request: DescribeInstancesRequest
        ): Kleisli[M, OpsWorksClient, DescribeInstancesResponse] =
          primitive(_.describeInstances(request))

        def describeLayers(
          request: DescribeLayersRequest
        ): Kleisli[M, OpsWorksClient, DescribeLayersResponse] =
          primitive(_.describeLayers(request))

        def describeLoadBasedAutoScaling(
          request: DescribeLoadBasedAutoScalingRequest
        ): Kleisli[M, OpsWorksClient, DescribeLoadBasedAutoScalingResponse] =
          primitive(_.describeLoadBasedAutoScaling(request))

        def describeMyUserProfile(
          request: DescribeMyUserProfileRequest
        ): Kleisli[M, OpsWorksClient, DescribeMyUserProfileResponse] =
          primitive(_.describeMyUserProfile(request))

        def describeOperatingSystems(
          request: DescribeOperatingSystemsRequest
        ): Kleisli[M, OpsWorksClient, DescribeOperatingSystemsResponse] =
          primitive(_.describeOperatingSystems(request))

        def describePermissions(
          request: DescribePermissionsRequest
        ): Kleisli[M, OpsWorksClient, DescribePermissionsResponse] =
          primitive(_.describePermissions(request))

        def describeRaidArrays(
          request: DescribeRaidArraysRequest
        ): Kleisli[M, OpsWorksClient, DescribeRaidArraysResponse] =
          primitive(_.describeRaidArrays(request))

        def describeRdsDbInstances(
          request: DescribeRdsDbInstancesRequest
        ): Kleisli[M, OpsWorksClient, DescribeRdsDbInstancesResponse] =
          primitive(_.describeRdsDbInstances(request))

        def describeServiceErrors(
          request: DescribeServiceErrorsRequest
        ): Kleisli[M, OpsWorksClient, DescribeServiceErrorsResponse] =
          primitive(_.describeServiceErrors(request))

        def describeStackProvisioningParameters(
          request: DescribeStackProvisioningParametersRequest
        ): Kleisli[M, OpsWorksClient, DescribeStackProvisioningParametersResponse] =
          primitive(_.describeStackProvisioningParameters(request))

        def describeStackSummary(
          request: DescribeStackSummaryRequest
        ): Kleisli[M, OpsWorksClient, DescribeStackSummaryResponse] =
          primitive(_.describeStackSummary(request))

        def describeStacks(
          request: DescribeStacksRequest
        ): Kleisli[M, OpsWorksClient, DescribeStacksResponse] =
          primitive(_.describeStacks(request))

        def describeTimeBasedAutoScaling(
          request: DescribeTimeBasedAutoScalingRequest
        ): Kleisli[M, OpsWorksClient, DescribeTimeBasedAutoScalingResponse] =
          primitive(_.describeTimeBasedAutoScaling(request))

        def describeUserProfiles(
          request: DescribeUserProfilesRequest
        ): Kleisli[M, OpsWorksClient, DescribeUserProfilesResponse] =
          primitive(_.describeUserProfiles(request))

        def describeVolumes(
          request: DescribeVolumesRequest
        ): Kleisli[M, OpsWorksClient, DescribeVolumesResponse] =
          primitive(_.describeVolumes(request))

        def detachElasticLoadBalancer(
          request: DetachElasticLoadBalancerRequest
        ): Kleisli[M, OpsWorksClient, DetachElasticLoadBalancerResponse] =
          primitive(_.detachElasticLoadBalancer(request))

        def disassociateElasticIp(
          request: DisassociateElasticIpRequest
        ): Kleisli[M, OpsWorksClient, DisassociateElasticIpResponse] =
          primitive(_.disassociateElasticIp(request))

        def getHostnameSuggestion(
          request: GetHostnameSuggestionRequest
        ): Kleisli[M, OpsWorksClient, GetHostnameSuggestionResponse] =
          primitive(_.getHostnameSuggestion(request))

        def grantAccess(
          request: GrantAccessRequest
        ): Kleisli[M, OpsWorksClient, GrantAccessResponse] =
          primitive(_.grantAccess(request))

        def listTags(
          request: ListTagsRequest
        ): Kleisli[M, OpsWorksClient, ListTagsResponse] =
          primitive(_.listTags(request))

        def rebootInstance(
          request: RebootInstanceRequest
        ): Kleisli[M, OpsWorksClient, RebootInstanceResponse] =
          primitive(_.rebootInstance(request))

        def registerEcsCluster(
          request: RegisterEcsClusterRequest
        ): Kleisli[M, OpsWorksClient, RegisterEcsClusterResponse] =
          primitive(_.registerEcsCluster(request))

        def registerElasticIp(
          request: RegisterElasticIpRequest
        ): Kleisli[M, OpsWorksClient, RegisterElasticIpResponse] =
          primitive(_.registerElasticIp(request))

        def registerInstance(
          request: RegisterInstanceRequest
        ): Kleisli[M, OpsWorksClient, RegisterInstanceResponse] =
          primitive(_.registerInstance(request))

        def registerRdsDbInstance(
          request: RegisterRdsDbInstanceRequest
        ): Kleisli[M, OpsWorksClient, RegisterRdsDbInstanceResponse] =
          primitive(_.registerRdsDbInstance(request))

        def registerVolume(
          request: RegisterVolumeRequest
        ): Kleisli[M, OpsWorksClient, RegisterVolumeResponse] =
          primitive(_.registerVolume(request))

        def setLoadBasedAutoScaling(
          request: SetLoadBasedAutoScalingRequest
        ): Kleisli[M, OpsWorksClient, SetLoadBasedAutoScalingResponse] =
          primitive(_.setLoadBasedAutoScaling(request))

        def setPermission(
          request: SetPermissionRequest
        ): Kleisli[M, OpsWorksClient, SetPermissionResponse] =
          primitive(_.setPermission(request))

        def setTimeBasedAutoScaling(
          request: SetTimeBasedAutoScalingRequest
        ): Kleisli[M, OpsWorksClient, SetTimeBasedAutoScalingResponse] =
          primitive(_.setTimeBasedAutoScaling(request))

        def startInstance(
          request: StartInstanceRequest
        ): Kleisli[M, OpsWorksClient, StartInstanceResponse] =
          primitive(_.startInstance(request))

        def startStack(
          request: StartStackRequest
        ): Kleisli[M, OpsWorksClient, StartStackResponse] =
          primitive(_.startStack(request))

        def stopInstance(
          request: StopInstanceRequest
        ): Kleisli[M, OpsWorksClient, StopInstanceResponse] =
          primitive(_.stopInstance(request))

        def stopStack(
          request: StopStackRequest
        ): Kleisli[M, OpsWorksClient, StopStackResponse] =
          primitive(_.stopStack(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, OpsWorksClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def unassignInstance(
          request: UnassignInstanceRequest
        ): Kleisli[M, OpsWorksClient, UnassignInstanceResponse] =
          primitive(_.unassignInstance(request))

        def unassignVolume(
          request: UnassignVolumeRequest
        ): Kleisli[M, OpsWorksClient, UnassignVolumeResponse] =
          primitive(_.unassignVolume(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, OpsWorksClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateApp(
          request: UpdateAppRequest
        ): Kleisli[M, OpsWorksClient, UpdateAppResponse] =
          primitive(_.updateApp(request))

        def updateElasticIp(
          request: UpdateElasticIpRequest
        ): Kleisli[M, OpsWorksClient, UpdateElasticIpResponse] =
          primitive(_.updateElasticIp(request))

        def updateInstance(
          request: UpdateInstanceRequest
        ): Kleisli[M, OpsWorksClient, UpdateInstanceResponse] =
          primitive(_.updateInstance(request))

        def updateLayer(
          request: UpdateLayerRequest
        ): Kleisli[M, OpsWorksClient, UpdateLayerResponse] =
          primitive(_.updateLayer(request))

        def updateMyUserProfile(
          request: UpdateMyUserProfileRequest
        ): Kleisli[M, OpsWorksClient, UpdateMyUserProfileResponse] =
          primitive(_.updateMyUserProfile(request))

        def updateRdsDbInstance(
          request: UpdateRdsDbInstanceRequest
        ): Kleisli[M, OpsWorksClient, UpdateRdsDbInstanceResponse] =
          primitive(_.updateRdsDbInstance(request))

        def updateStack(
          request: UpdateStackRequest
        ): Kleisli[M, OpsWorksClient, UpdateStackResponse] =
          primitive(_.updateStack(request))

        def updateUserProfile(
          request: UpdateUserProfileRequest
        ): Kleisli[M, OpsWorksClient, UpdateUserProfileResponse] =
          primitive(_.updateUserProfile(request))

        def updateVolume(
          request: UpdateVolumeRequest
        ): Kleisli[M, OpsWorksClient, UpdateVolumeResponse] =
          primitive(_.updateVolume(request))

        def primitive[A](
          f: OpsWorksClient => A
        ): Kleisli[M, OpsWorksClient, A]
      }
    }

    trait Visitor[F[_]] extends (OpsWorksOp ~> F) {
      final def apply[A](op: OpsWorksOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def assignInstance(
        request: AssignInstanceRequest
      ): F[AssignInstanceResponse]

      def assignVolume(
        request: AssignVolumeRequest
      ): F[AssignVolumeResponse]

      def associateElasticIp(
        request: AssociateElasticIpRequest
      ): F[AssociateElasticIpResponse]

      def attachElasticLoadBalancer(
        request: AttachElasticLoadBalancerRequest
      ): F[AttachElasticLoadBalancerResponse]

      def cloneStack(
        request: CloneStackRequest
      ): F[CloneStackResponse]

      def createApp(
        request: CreateAppRequest
      ): F[CreateAppResponse]

      def createDeployment(
        request: CreateDeploymentRequest
      ): F[CreateDeploymentResponse]

      def createInstance(
        request: CreateInstanceRequest
      ): F[CreateInstanceResponse]

      def createLayer(
        request: CreateLayerRequest
      ): F[CreateLayerResponse]

      def createStack(
        request: CreateStackRequest
      ): F[CreateStackResponse]

      def createUserProfile(
        request: CreateUserProfileRequest
      ): F[CreateUserProfileResponse]

      def deleteApp(
        request: DeleteAppRequest
      ): F[DeleteAppResponse]

      def deleteInstance(
        request: DeleteInstanceRequest
      ): F[DeleteInstanceResponse]

      def deleteLayer(
        request: DeleteLayerRequest
      ): F[DeleteLayerResponse]

      def deleteStack(
        request: DeleteStackRequest
      ): F[DeleteStackResponse]

      def deleteUserProfile(
        request: DeleteUserProfileRequest
      ): F[DeleteUserProfileResponse]

      def deregisterEcsCluster(
        request: DeregisterEcsClusterRequest
      ): F[DeregisterEcsClusterResponse]

      def deregisterElasticIp(
        request: DeregisterElasticIpRequest
      ): F[DeregisterElasticIpResponse]

      def deregisterInstance(
        request: DeregisterInstanceRequest
      ): F[DeregisterInstanceResponse]

      def deregisterRdsDbInstance(
        request: DeregisterRdsDbInstanceRequest
      ): F[DeregisterRdsDbInstanceResponse]

      def deregisterVolume(
        request: DeregisterVolumeRequest
      ): F[DeregisterVolumeResponse]

      def describeAgentVersions(
        request: DescribeAgentVersionsRequest
      ): F[DescribeAgentVersionsResponse]

      def describeApps(
        request: DescribeAppsRequest
      ): F[DescribeAppsResponse]

      def describeCommands(
        request: DescribeCommandsRequest
      ): F[DescribeCommandsResponse]

      def describeDeployments(
        request: DescribeDeploymentsRequest
      ): F[DescribeDeploymentsResponse]

      def describeEcsClusters(
        request: DescribeEcsClustersRequest
      ): F[DescribeEcsClustersResponse]

      def describeElasticIps(
        request: DescribeElasticIpsRequest
      ): F[DescribeElasticIpsResponse]

      def describeElasticLoadBalancers(
        request: DescribeElasticLoadBalancersRequest
      ): F[DescribeElasticLoadBalancersResponse]

      def describeInstances(
        request: DescribeInstancesRequest
      ): F[DescribeInstancesResponse]

      def describeLayers(
        request: DescribeLayersRequest
      ): F[DescribeLayersResponse]

      def describeLoadBasedAutoScaling(
        request: DescribeLoadBasedAutoScalingRequest
      ): F[DescribeLoadBasedAutoScalingResponse]

      def describeMyUserProfile(
        request: DescribeMyUserProfileRequest
      ): F[DescribeMyUserProfileResponse]

      def describeOperatingSystems(
        request: DescribeOperatingSystemsRequest
      ): F[DescribeOperatingSystemsResponse]

      def describePermissions(
        request: DescribePermissionsRequest
      ): F[DescribePermissionsResponse]

      def describeRaidArrays(
        request: DescribeRaidArraysRequest
      ): F[DescribeRaidArraysResponse]

      def describeRdsDbInstances(
        request: DescribeRdsDbInstancesRequest
      ): F[DescribeRdsDbInstancesResponse]

      def describeServiceErrors(
        request: DescribeServiceErrorsRequest
      ): F[DescribeServiceErrorsResponse]

      def describeStackProvisioningParameters(
        request: DescribeStackProvisioningParametersRequest
      ): F[DescribeStackProvisioningParametersResponse]

      def describeStackSummary(
        request: DescribeStackSummaryRequest
      ): F[DescribeStackSummaryResponse]

      def describeStacks(
        request: DescribeStacksRequest
      ): F[DescribeStacksResponse]

      def describeTimeBasedAutoScaling(
        request: DescribeTimeBasedAutoScalingRequest
      ): F[DescribeTimeBasedAutoScalingResponse]

      def describeUserProfiles(
        request: DescribeUserProfilesRequest
      ): F[DescribeUserProfilesResponse]

      def describeVolumes(
        request: DescribeVolumesRequest
      ): F[DescribeVolumesResponse]

      def detachElasticLoadBalancer(
        request: DetachElasticLoadBalancerRequest
      ): F[DetachElasticLoadBalancerResponse]

      def disassociateElasticIp(
        request: DisassociateElasticIpRequest
      ): F[DisassociateElasticIpResponse]

      def getHostnameSuggestion(
        request: GetHostnameSuggestionRequest
      ): F[GetHostnameSuggestionResponse]

      def grantAccess(
        request: GrantAccessRequest
      ): F[GrantAccessResponse]

      def listTags(
        request: ListTagsRequest
      ): F[ListTagsResponse]

      def rebootInstance(
        request: RebootInstanceRequest
      ): F[RebootInstanceResponse]

      def registerEcsCluster(
        request: RegisterEcsClusterRequest
      ): F[RegisterEcsClusterResponse]

      def registerElasticIp(
        request: RegisterElasticIpRequest
      ): F[RegisterElasticIpResponse]

      def registerInstance(
        request: RegisterInstanceRequest
      ): F[RegisterInstanceResponse]

      def registerRdsDbInstance(
        request: RegisterRdsDbInstanceRequest
      ): F[RegisterRdsDbInstanceResponse]

      def registerVolume(
        request: RegisterVolumeRequest
      ): F[RegisterVolumeResponse]

      def setLoadBasedAutoScaling(
        request: SetLoadBasedAutoScalingRequest
      ): F[SetLoadBasedAutoScalingResponse]

      def setPermission(
        request: SetPermissionRequest
      ): F[SetPermissionResponse]

      def setTimeBasedAutoScaling(
        request: SetTimeBasedAutoScalingRequest
      ): F[SetTimeBasedAutoScalingResponse]

      def startInstance(
        request: StartInstanceRequest
      ): F[StartInstanceResponse]

      def startStack(
        request: StartStackRequest
      ): F[StartStackResponse]

      def stopInstance(
        request: StopInstanceRequest
      ): F[StopInstanceResponse]

      def stopStack(
        request: StopStackRequest
      ): F[StopStackResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def unassignInstance(
        request: UnassignInstanceRequest
      ): F[UnassignInstanceResponse]

      def unassignVolume(
        request: UnassignVolumeRequest
      ): F[UnassignVolumeResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateApp(
        request: UpdateAppRequest
      ): F[UpdateAppResponse]

      def updateElasticIp(
        request: UpdateElasticIpRequest
      ): F[UpdateElasticIpResponse]

      def updateInstance(
        request: UpdateInstanceRequest
      ): F[UpdateInstanceResponse]

      def updateLayer(
        request: UpdateLayerRequest
      ): F[UpdateLayerResponse]

      def updateMyUserProfile(
        request: UpdateMyUserProfileRequest
      ): F[UpdateMyUserProfileResponse]

      def updateRdsDbInstance(
        request: UpdateRdsDbInstanceRequest
      ): F[UpdateRdsDbInstanceResponse]

      def updateStack(
        request: UpdateStackRequest
      ): F[UpdateStackResponse]

      def updateUserProfile(
        request: UpdateUserProfileRequest
      ): F[UpdateUserProfileResponse]

      def updateVolume(
        request: UpdateVolumeRequest
      ): F[UpdateVolumeResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends OpsWorksOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssignInstanceOp(
      request: AssignInstanceRequest
    ) extends OpsWorksOp[AssignInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssignInstanceResponse] =
        visitor.assignInstance(request)
    }

    final case class AssignVolumeOp(
      request: AssignVolumeRequest
    ) extends OpsWorksOp[AssignVolumeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssignVolumeResponse] =
        visitor.assignVolume(request)
    }

    final case class AssociateElasticIpOp(
      request: AssociateElasticIpRequest
    ) extends OpsWorksOp[AssociateElasticIpResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateElasticIpResponse] =
        visitor.associateElasticIp(request)
    }

    final case class AttachElasticLoadBalancerOp(
      request: AttachElasticLoadBalancerRequest
    ) extends OpsWorksOp[AttachElasticLoadBalancerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachElasticLoadBalancerResponse] =
        visitor.attachElasticLoadBalancer(request)
    }

    final case class CloneStackOp(
      request: CloneStackRequest
    ) extends OpsWorksOp[CloneStackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CloneStackResponse] =
        visitor.cloneStack(request)
    }

    final case class CreateAppOp(
      request: CreateAppRequest
    ) extends OpsWorksOp[CreateAppResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAppResponse] =
        visitor.createApp(request)
    }

    final case class CreateDeploymentOp(
      request: CreateDeploymentRequest
    ) extends OpsWorksOp[CreateDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDeploymentResponse] =
        visitor.createDeployment(request)
    }

    final case class CreateInstanceOp(
      request: CreateInstanceRequest
    ) extends OpsWorksOp[CreateInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateInstanceResponse] =
        visitor.createInstance(request)
    }

    final case class CreateLayerOp(
      request: CreateLayerRequest
    ) extends OpsWorksOp[CreateLayerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLayerResponse] =
        visitor.createLayer(request)
    }

    final case class CreateStackOp(
      request: CreateStackRequest
    ) extends OpsWorksOp[CreateStackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStackResponse] =
        visitor.createStack(request)
    }

    final case class CreateUserProfileOp(
      request: CreateUserProfileRequest
    ) extends OpsWorksOp[CreateUserProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserProfileResponse] =
        visitor.createUserProfile(request)
    }

    final case class DeleteAppOp(
      request: DeleteAppRequest
    ) extends OpsWorksOp[DeleteAppResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAppResponse] =
        visitor.deleteApp(request)
    }

    final case class DeleteInstanceOp(
      request: DeleteInstanceRequest
    ) extends OpsWorksOp[DeleteInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInstanceResponse] =
        visitor.deleteInstance(request)
    }

    final case class DeleteLayerOp(
      request: DeleteLayerRequest
    ) extends OpsWorksOp[DeleteLayerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLayerResponse] =
        visitor.deleteLayer(request)
    }

    final case class DeleteStackOp(
      request: DeleteStackRequest
    ) extends OpsWorksOp[DeleteStackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStackResponse] =
        visitor.deleteStack(request)
    }

    final case class DeleteUserProfileOp(
      request: DeleteUserProfileRequest
    ) extends OpsWorksOp[DeleteUserProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserProfileResponse] =
        visitor.deleteUserProfile(request)
    }

    final case class DeregisterEcsClusterOp(
      request: DeregisterEcsClusterRequest
    ) extends OpsWorksOp[DeregisterEcsClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterEcsClusterResponse] =
        visitor.deregisterEcsCluster(request)
    }

    final case class DeregisterElasticIpOp(
      request: DeregisterElasticIpRequest
    ) extends OpsWorksOp[DeregisterElasticIpResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterElasticIpResponse] =
        visitor.deregisterElasticIp(request)
    }

    final case class DeregisterInstanceOp(
      request: DeregisterInstanceRequest
    ) extends OpsWorksOp[DeregisterInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterInstanceResponse] =
        visitor.deregisterInstance(request)
    }

    final case class DeregisterRdsDbInstanceOp(
      request: DeregisterRdsDbInstanceRequest
    ) extends OpsWorksOp[DeregisterRdsDbInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterRdsDbInstanceResponse] =
        visitor.deregisterRdsDbInstance(request)
    }

    final case class DeregisterVolumeOp(
      request: DeregisterVolumeRequest
    ) extends OpsWorksOp[DeregisterVolumeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterVolumeResponse] =
        visitor.deregisterVolume(request)
    }

    final case class DescribeAgentVersionsOp(
      request: DescribeAgentVersionsRequest
    ) extends OpsWorksOp[DescribeAgentVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAgentVersionsResponse] =
        visitor.describeAgentVersions(request)
    }

    final case class DescribeAppsOp(
      request: DescribeAppsRequest
    ) extends OpsWorksOp[DescribeAppsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAppsResponse] =
        visitor.describeApps(request)
    }

    final case class DescribeCommandsOp(
      request: DescribeCommandsRequest
    ) extends OpsWorksOp[DescribeCommandsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCommandsResponse] =
        visitor.describeCommands(request)
    }

    final case class DescribeDeploymentsOp(
      request: DescribeDeploymentsRequest
    ) extends OpsWorksOp[DescribeDeploymentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDeploymentsResponse] =
        visitor.describeDeployments(request)
    }

    final case class DescribeEcsClustersOp(
      request: DescribeEcsClustersRequest
    ) extends OpsWorksOp[DescribeEcsClustersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEcsClustersResponse] =
        visitor.describeEcsClusters(request)
    }

    final case class DescribeElasticIpsOp(
      request: DescribeElasticIpsRequest
    ) extends OpsWorksOp[DescribeElasticIpsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeElasticIpsResponse] =
        visitor.describeElasticIps(request)
    }

    final case class DescribeElasticLoadBalancersOp(
      request: DescribeElasticLoadBalancersRequest
    ) extends OpsWorksOp[DescribeElasticLoadBalancersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeElasticLoadBalancersResponse] =
        visitor.describeElasticLoadBalancers(request)
    }

    final case class DescribeInstancesOp(
      request: DescribeInstancesRequest
    ) extends OpsWorksOp[DescribeInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstancesResponse] =
        visitor.describeInstances(request)
    }

    final case class DescribeLayersOp(
      request: DescribeLayersRequest
    ) extends OpsWorksOp[DescribeLayersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLayersResponse] =
        visitor.describeLayers(request)
    }

    final case class DescribeLoadBasedAutoScalingOp(
      request: DescribeLoadBasedAutoScalingRequest
    ) extends OpsWorksOp[DescribeLoadBasedAutoScalingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLoadBasedAutoScalingResponse] =
        visitor.describeLoadBasedAutoScaling(request)
    }

    final case class DescribeMyUserProfileOp(
      request: DescribeMyUserProfileRequest
    ) extends OpsWorksOp[DescribeMyUserProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMyUserProfileResponse] =
        visitor.describeMyUserProfile(request)
    }

    final case class DescribeOperatingSystemsOp(
      request: DescribeOperatingSystemsRequest
    ) extends OpsWorksOp[DescribeOperatingSystemsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOperatingSystemsResponse] =
        visitor.describeOperatingSystems(request)
    }

    final case class DescribePermissionsOp(
      request: DescribePermissionsRequest
    ) extends OpsWorksOp[DescribePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePermissionsResponse] =
        visitor.describePermissions(request)
    }

    final case class DescribeRaidArraysOp(
      request: DescribeRaidArraysRequest
    ) extends OpsWorksOp[DescribeRaidArraysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRaidArraysResponse] =
        visitor.describeRaidArrays(request)
    }

    final case class DescribeRdsDbInstancesOp(
      request: DescribeRdsDbInstancesRequest
    ) extends OpsWorksOp[DescribeRdsDbInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRdsDbInstancesResponse] =
        visitor.describeRdsDbInstances(request)
    }

    final case class DescribeServiceErrorsOp(
      request: DescribeServiceErrorsRequest
    ) extends OpsWorksOp[DescribeServiceErrorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeServiceErrorsResponse] =
        visitor.describeServiceErrors(request)
    }

    final case class DescribeStackProvisioningParametersOp(
      request: DescribeStackProvisioningParametersRequest
    ) extends OpsWorksOp[DescribeStackProvisioningParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStackProvisioningParametersResponse] =
        visitor.describeStackProvisioningParameters(request)
    }

    final case class DescribeStackSummaryOp(
      request: DescribeStackSummaryRequest
    ) extends OpsWorksOp[DescribeStackSummaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStackSummaryResponse] =
        visitor.describeStackSummary(request)
    }

    final case class DescribeStacksOp(
      request: DescribeStacksRequest
    ) extends OpsWorksOp[DescribeStacksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStacksResponse] =
        visitor.describeStacks(request)
    }

    final case class DescribeTimeBasedAutoScalingOp(
      request: DescribeTimeBasedAutoScalingRequest
    ) extends OpsWorksOp[DescribeTimeBasedAutoScalingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTimeBasedAutoScalingResponse] =
        visitor.describeTimeBasedAutoScaling(request)
    }

    final case class DescribeUserProfilesOp(
      request: DescribeUserProfilesRequest
    ) extends OpsWorksOp[DescribeUserProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUserProfilesResponse] =
        visitor.describeUserProfiles(request)
    }

    final case class DescribeVolumesOp(
      request: DescribeVolumesRequest
    ) extends OpsWorksOp[DescribeVolumesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVolumesResponse] =
        visitor.describeVolumes(request)
    }

    final case class DetachElasticLoadBalancerOp(
      request: DetachElasticLoadBalancerRequest
    ) extends OpsWorksOp[DetachElasticLoadBalancerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachElasticLoadBalancerResponse] =
        visitor.detachElasticLoadBalancer(request)
    }

    final case class DisassociateElasticIpOp(
      request: DisassociateElasticIpRequest
    ) extends OpsWorksOp[DisassociateElasticIpResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateElasticIpResponse] =
        visitor.disassociateElasticIp(request)
    }

    final case class GetHostnameSuggestionOp(
      request: GetHostnameSuggestionRequest
    ) extends OpsWorksOp[GetHostnameSuggestionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetHostnameSuggestionResponse] =
        visitor.getHostnameSuggestion(request)
    }

    final case class GrantAccessOp(
      request: GrantAccessRequest
    ) extends OpsWorksOp[GrantAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GrantAccessResponse] =
        visitor.grantAccess(request)
    }

    final case class ListTagsOp(
      request: ListTagsRequest
    ) extends OpsWorksOp[ListTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsResponse] =
        visitor.listTags(request)
    }

    final case class RebootInstanceOp(
      request: RebootInstanceRequest
    ) extends OpsWorksOp[RebootInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RebootInstanceResponse] =
        visitor.rebootInstance(request)
    }

    final case class RegisterEcsClusterOp(
      request: RegisterEcsClusterRequest
    ) extends OpsWorksOp[RegisterEcsClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterEcsClusterResponse] =
        visitor.registerEcsCluster(request)
    }

    final case class RegisterElasticIpOp(
      request: RegisterElasticIpRequest
    ) extends OpsWorksOp[RegisterElasticIpResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterElasticIpResponse] =
        visitor.registerElasticIp(request)
    }

    final case class RegisterInstanceOp(
      request: RegisterInstanceRequest
    ) extends OpsWorksOp[RegisterInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterInstanceResponse] =
        visitor.registerInstance(request)
    }

    final case class RegisterRdsDbInstanceOp(
      request: RegisterRdsDbInstanceRequest
    ) extends OpsWorksOp[RegisterRdsDbInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterRdsDbInstanceResponse] =
        visitor.registerRdsDbInstance(request)
    }

    final case class RegisterVolumeOp(
      request: RegisterVolumeRequest
    ) extends OpsWorksOp[RegisterVolumeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterVolumeResponse] =
        visitor.registerVolume(request)
    }

    final case class SetLoadBasedAutoScalingOp(
      request: SetLoadBasedAutoScalingRequest
    ) extends OpsWorksOp[SetLoadBasedAutoScalingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetLoadBasedAutoScalingResponse] =
        visitor.setLoadBasedAutoScaling(request)
    }

    final case class SetPermissionOp(
      request: SetPermissionRequest
    ) extends OpsWorksOp[SetPermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetPermissionResponse] =
        visitor.setPermission(request)
    }

    final case class SetTimeBasedAutoScalingOp(
      request: SetTimeBasedAutoScalingRequest
    ) extends OpsWorksOp[SetTimeBasedAutoScalingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetTimeBasedAutoScalingResponse] =
        visitor.setTimeBasedAutoScaling(request)
    }

    final case class StartInstanceOp(
      request: StartInstanceRequest
    ) extends OpsWorksOp[StartInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartInstanceResponse] =
        visitor.startInstance(request)
    }

    final case class StartStackOp(
      request: StartStackRequest
    ) extends OpsWorksOp[StartStackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartStackResponse] =
        visitor.startStack(request)
    }

    final case class StopInstanceOp(
      request: StopInstanceRequest
    ) extends OpsWorksOp[StopInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopInstanceResponse] =
        visitor.stopInstance(request)
    }

    final case class StopStackOp(
      request: StopStackRequest
    ) extends OpsWorksOp[StopStackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopStackResponse] =
        visitor.stopStack(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends OpsWorksOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UnassignInstanceOp(
      request: UnassignInstanceRequest
    ) extends OpsWorksOp[UnassignInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UnassignInstanceResponse] =
        visitor.unassignInstance(request)
    }

    final case class UnassignVolumeOp(
      request: UnassignVolumeRequest
    ) extends OpsWorksOp[UnassignVolumeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UnassignVolumeResponse] =
        visitor.unassignVolume(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends OpsWorksOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAppOp(
      request: UpdateAppRequest
    ) extends OpsWorksOp[UpdateAppResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAppResponse] =
        visitor.updateApp(request)
    }

    final case class UpdateElasticIpOp(
      request: UpdateElasticIpRequest
    ) extends OpsWorksOp[UpdateElasticIpResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateElasticIpResponse] =
        visitor.updateElasticIp(request)
    }

    final case class UpdateInstanceOp(
      request: UpdateInstanceRequest
    ) extends OpsWorksOp[UpdateInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateInstanceResponse] =
        visitor.updateInstance(request)
    }

    final case class UpdateLayerOp(
      request: UpdateLayerRequest
    ) extends OpsWorksOp[UpdateLayerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLayerResponse] =
        visitor.updateLayer(request)
    }

    final case class UpdateMyUserProfileOp(
      request: UpdateMyUserProfileRequest
    ) extends OpsWorksOp[UpdateMyUserProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMyUserProfileResponse] =
        visitor.updateMyUserProfile(request)
    }

    final case class UpdateRdsDbInstanceOp(
      request: UpdateRdsDbInstanceRequest
    ) extends OpsWorksOp[UpdateRdsDbInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRdsDbInstanceResponse] =
        visitor.updateRdsDbInstance(request)
    }

    final case class UpdateStackOp(
      request: UpdateStackRequest
    ) extends OpsWorksOp[UpdateStackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateStackResponse] =
        visitor.updateStack(request)
    }

    final case class UpdateUserProfileOp(
      request: UpdateUserProfileRequest
    ) extends OpsWorksOp[UpdateUserProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserProfileResponse] =
        visitor.updateUserProfile(request)
    }

    final case class UpdateVolumeOp(
      request: UpdateVolumeRequest
    ) extends OpsWorksOp[UpdateVolumeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateVolumeResponse] =
        visitor.updateVolume(request)
    }
  }

  import OpsWorksOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[OpsWorksOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def assignInstance(
    request: AssignInstanceRequest
  ): OpsWorksIO[AssignInstanceResponse] =
    FF.liftF(AssignInstanceOp(request))

  def assignVolume(
    request: AssignVolumeRequest
  ): OpsWorksIO[AssignVolumeResponse] =
    FF.liftF(AssignVolumeOp(request))

  def associateElasticIp(
    request: AssociateElasticIpRequest
  ): OpsWorksIO[AssociateElasticIpResponse] =
    FF.liftF(AssociateElasticIpOp(request))

  def attachElasticLoadBalancer(
    request: AttachElasticLoadBalancerRequest
  ): OpsWorksIO[AttachElasticLoadBalancerResponse] =
    FF.liftF(AttachElasticLoadBalancerOp(request))

  def cloneStack(
    request: CloneStackRequest
  ): OpsWorksIO[CloneStackResponse] =
    FF.liftF(CloneStackOp(request))

  def createApp(
    request: CreateAppRequest
  ): OpsWorksIO[CreateAppResponse] =
    FF.liftF(CreateAppOp(request))

  def createDeployment(
    request: CreateDeploymentRequest
  ): OpsWorksIO[CreateDeploymentResponse] =
    FF.liftF(CreateDeploymentOp(request))

  def createInstance(
    request: CreateInstanceRequest
  ): OpsWorksIO[CreateInstanceResponse] =
    FF.liftF(CreateInstanceOp(request))

  def createLayer(
    request: CreateLayerRequest
  ): OpsWorksIO[CreateLayerResponse] =
    FF.liftF(CreateLayerOp(request))

  def createStack(
    request: CreateStackRequest
  ): OpsWorksIO[CreateStackResponse] =
    FF.liftF(CreateStackOp(request))

  def createUserProfile(
    request: CreateUserProfileRequest
  ): OpsWorksIO[CreateUserProfileResponse] =
    FF.liftF(CreateUserProfileOp(request))

  def deleteApp(
    request: DeleteAppRequest
  ): OpsWorksIO[DeleteAppResponse] =
    FF.liftF(DeleteAppOp(request))

  def deleteInstance(
    request: DeleteInstanceRequest
  ): OpsWorksIO[DeleteInstanceResponse] =
    FF.liftF(DeleteInstanceOp(request))

  def deleteLayer(
    request: DeleteLayerRequest
  ): OpsWorksIO[DeleteLayerResponse] =
    FF.liftF(DeleteLayerOp(request))

  def deleteStack(
    request: DeleteStackRequest
  ): OpsWorksIO[DeleteStackResponse] =
    FF.liftF(DeleteStackOp(request))

  def deleteUserProfile(
    request: DeleteUserProfileRequest
  ): OpsWorksIO[DeleteUserProfileResponse] =
    FF.liftF(DeleteUserProfileOp(request))

  def deregisterEcsCluster(
    request: DeregisterEcsClusterRequest
  ): OpsWorksIO[DeregisterEcsClusterResponse] =
    FF.liftF(DeregisterEcsClusterOp(request))

  def deregisterElasticIp(
    request: DeregisterElasticIpRequest
  ): OpsWorksIO[DeregisterElasticIpResponse] =
    FF.liftF(DeregisterElasticIpOp(request))

  def deregisterInstance(
    request: DeregisterInstanceRequest
  ): OpsWorksIO[DeregisterInstanceResponse] =
    FF.liftF(DeregisterInstanceOp(request))

  def deregisterRdsDbInstance(
    request: DeregisterRdsDbInstanceRequest
  ): OpsWorksIO[DeregisterRdsDbInstanceResponse] =
    FF.liftF(DeregisterRdsDbInstanceOp(request))

  def deregisterVolume(
    request: DeregisterVolumeRequest
  ): OpsWorksIO[DeregisterVolumeResponse] =
    FF.liftF(DeregisterVolumeOp(request))

  def describeAgentVersions(
    request: DescribeAgentVersionsRequest
  ): OpsWorksIO[DescribeAgentVersionsResponse] =
    FF.liftF(DescribeAgentVersionsOp(request))

  def describeApps(
    request: DescribeAppsRequest
  ): OpsWorksIO[DescribeAppsResponse] =
    FF.liftF(DescribeAppsOp(request))

  def describeCommands(
    request: DescribeCommandsRequest
  ): OpsWorksIO[DescribeCommandsResponse] =
    FF.liftF(DescribeCommandsOp(request))

  def describeDeployments(
    request: DescribeDeploymentsRequest
  ): OpsWorksIO[DescribeDeploymentsResponse] =
    FF.liftF(DescribeDeploymentsOp(request))

  def describeEcsClusters(
    request: DescribeEcsClustersRequest
  ): OpsWorksIO[DescribeEcsClustersResponse] =
    FF.liftF(DescribeEcsClustersOp(request))

  def describeElasticIps(
    request: DescribeElasticIpsRequest
  ): OpsWorksIO[DescribeElasticIpsResponse] =
    FF.liftF(DescribeElasticIpsOp(request))

  def describeElasticLoadBalancers(
    request: DescribeElasticLoadBalancersRequest
  ): OpsWorksIO[DescribeElasticLoadBalancersResponse] =
    FF.liftF(DescribeElasticLoadBalancersOp(request))

  def describeInstances(
    request: DescribeInstancesRequest
  ): OpsWorksIO[DescribeInstancesResponse] =
    FF.liftF(DescribeInstancesOp(request))

  def describeLayers(
    request: DescribeLayersRequest
  ): OpsWorksIO[DescribeLayersResponse] =
    FF.liftF(DescribeLayersOp(request))

  def describeLoadBasedAutoScaling(
    request: DescribeLoadBasedAutoScalingRequest
  ): OpsWorksIO[DescribeLoadBasedAutoScalingResponse] =
    FF.liftF(DescribeLoadBasedAutoScalingOp(request))

  def describeMyUserProfile(
    request: DescribeMyUserProfileRequest
  ): OpsWorksIO[DescribeMyUserProfileResponse] =
    FF.liftF(DescribeMyUserProfileOp(request))

  def describeOperatingSystems(
    request: DescribeOperatingSystemsRequest
  ): OpsWorksIO[DescribeOperatingSystemsResponse] =
    FF.liftF(DescribeOperatingSystemsOp(request))

  def describePermissions(
    request: DescribePermissionsRequest
  ): OpsWorksIO[DescribePermissionsResponse] =
    FF.liftF(DescribePermissionsOp(request))

  def describeRaidArrays(
    request: DescribeRaidArraysRequest
  ): OpsWorksIO[DescribeRaidArraysResponse] =
    FF.liftF(DescribeRaidArraysOp(request))

  def describeRdsDbInstances(
    request: DescribeRdsDbInstancesRequest
  ): OpsWorksIO[DescribeRdsDbInstancesResponse] =
    FF.liftF(DescribeRdsDbInstancesOp(request))

  def describeServiceErrors(
    request: DescribeServiceErrorsRequest
  ): OpsWorksIO[DescribeServiceErrorsResponse] =
    FF.liftF(DescribeServiceErrorsOp(request))

  def describeStackProvisioningParameters(
    request: DescribeStackProvisioningParametersRequest
  ): OpsWorksIO[DescribeStackProvisioningParametersResponse] =
    FF.liftF(DescribeStackProvisioningParametersOp(request))

  def describeStackSummary(
    request: DescribeStackSummaryRequest
  ): OpsWorksIO[DescribeStackSummaryResponse] =
    FF.liftF(DescribeStackSummaryOp(request))

  def describeStacks(
    request: DescribeStacksRequest
  ): OpsWorksIO[DescribeStacksResponse] =
    FF.liftF(DescribeStacksOp(request))

  def describeTimeBasedAutoScaling(
    request: DescribeTimeBasedAutoScalingRequest
  ): OpsWorksIO[DescribeTimeBasedAutoScalingResponse] =
    FF.liftF(DescribeTimeBasedAutoScalingOp(request))

  def describeUserProfiles(
    request: DescribeUserProfilesRequest
  ): OpsWorksIO[DescribeUserProfilesResponse] =
    FF.liftF(DescribeUserProfilesOp(request))

  def describeVolumes(
    request: DescribeVolumesRequest
  ): OpsWorksIO[DescribeVolumesResponse] =
    FF.liftF(DescribeVolumesOp(request))

  def detachElasticLoadBalancer(
    request: DetachElasticLoadBalancerRequest
  ): OpsWorksIO[DetachElasticLoadBalancerResponse] =
    FF.liftF(DetachElasticLoadBalancerOp(request))

  def disassociateElasticIp(
    request: DisassociateElasticIpRequest
  ): OpsWorksIO[DisassociateElasticIpResponse] =
    FF.liftF(DisassociateElasticIpOp(request))

  def getHostnameSuggestion(
    request: GetHostnameSuggestionRequest
  ): OpsWorksIO[GetHostnameSuggestionResponse] =
    FF.liftF(GetHostnameSuggestionOp(request))

  def grantAccess(
    request: GrantAccessRequest
  ): OpsWorksIO[GrantAccessResponse] =
    FF.liftF(GrantAccessOp(request))

  def listTags(
    request: ListTagsRequest
  ): OpsWorksIO[ListTagsResponse] =
    FF.liftF(ListTagsOp(request))

  def rebootInstance(
    request: RebootInstanceRequest
  ): OpsWorksIO[RebootInstanceResponse] =
    FF.liftF(RebootInstanceOp(request))

  def registerEcsCluster(
    request: RegisterEcsClusterRequest
  ): OpsWorksIO[RegisterEcsClusterResponse] =
    FF.liftF(RegisterEcsClusterOp(request))

  def registerElasticIp(
    request: RegisterElasticIpRequest
  ): OpsWorksIO[RegisterElasticIpResponse] =
    FF.liftF(RegisterElasticIpOp(request))

  def registerInstance(
    request: RegisterInstanceRequest
  ): OpsWorksIO[RegisterInstanceResponse] =
    FF.liftF(RegisterInstanceOp(request))

  def registerRdsDbInstance(
    request: RegisterRdsDbInstanceRequest
  ): OpsWorksIO[RegisterRdsDbInstanceResponse] =
    FF.liftF(RegisterRdsDbInstanceOp(request))

  def registerVolume(
    request: RegisterVolumeRequest
  ): OpsWorksIO[RegisterVolumeResponse] =
    FF.liftF(RegisterVolumeOp(request))

  def setLoadBasedAutoScaling(
    request: SetLoadBasedAutoScalingRequest
  ): OpsWorksIO[SetLoadBasedAutoScalingResponse] =
    FF.liftF(SetLoadBasedAutoScalingOp(request))

  def setPermission(
    request: SetPermissionRequest
  ): OpsWorksIO[SetPermissionResponse] =
    FF.liftF(SetPermissionOp(request))

  def setTimeBasedAutoScaling(
    request: SetTimeBasedAutoScalingRequest
  ): OpsWorksIO[SetTimeBasedAutoScalingResponse] =
    FF.liftF(SetTimeBasedAutoScalingOp(request))

  def startInstance(
    request: StartInstanceRequest
  ): OpsWorksIO[StartInstanceResponse] =
    FF.liftF(StartInstanceOp(request))

  def startStack(
    request: StartStackRequest
  ): OpsWorksIO[StartStackResponse] =
    FF.liftF(StartStackOp(request))

  def stopInstance(
    request: StopInstanceRequest
  ): OpsWorksIO[StopInstanceResponse] =
    FF.liftF(StopInstanceOp(request))

  def stopStack(
    request: StopStackRequest
  ): OpsWorksIO[StopStackResponse] =
    FF.liftF(StopStackOp(request))

  def tagResource(
    request: TagResourceRequest
  ): OpsWorksIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def unassignInstance(
    request: UnassignInstanceRequest
  ): OpsWorksIO[UnassignInstanceResponse] =
    FF.liftF(UnassignInstanceOp(request))

  def unassignVolume(
    request: UnassignVolumeRequest
  ): OpsWorksIO[UnassignVolumeResponse] =
    FF.liftF(UnassignVolumeOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): OpsWorksIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateApp(
    request: UpdateAppRequest
  ): OpsWorksIO[UpdateAppResponse] =
    FF.liftF(UpdateAppOp(request))

  def updateElasticIp(
    request: UpdateElasticIpRequest
  ): OpsWorksIO[UpdateElasticIpResponse] =
    FF.liftF(UpdateElasticIpOp(request))

  def updateInstance(
    request: UpdateInstanceRequest
  ): OpsWorksIO[UpdateInstanceResponse] =
    FF.liftF(UpdateInstanceOp(request))

  def updateLayer(
    request: UpdateLayerRequest
  ): OpsWorksIO[UpdateLayerResponse] =
    FF.liftF(UpdateLayerOp(request))

  def updateMyUserProfile(
    request: UpdateMyUserProfileRequest
  ): OpsWorksIO[UpdateMyUserProfileResponse] =
    FF.liftF(UpdateMyUserProfileOp(request))

  def updateRdsDbInstance(
    request: UpdateRdsDbInstanceRequest
  ): OpsWorksIO[UpdateRdsDbInstanceResponse] =
    FF.liftF(UpdateRdsDbInstanceOp(request))

  def updateStack(
    request: UpdateStackRequest
  ): OpsWorksIO[UpdateStackResponse] =
    FF.liftF(UpdateStackOp(request))

  def updateUserProfile(
    request: UpdateUserProfileRequest
  ): OpsWorksIO[UpdateUserProfileResponse] =
    FF.liftF(UpdateUserProfileOp(request))

  def updateVolume(
    request: UpdateVolumeRequest
  ): OpsWorksIO[UpdateVolumeResponse] =
    FF.liftF(UpdateVolumeOp(request))
}
