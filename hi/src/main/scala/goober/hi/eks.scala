package goober.hi

import goober.free.eks.EksIO
import software.amazon.awssdk.services.eks.model._


object eks {
  import goober.free.{eks ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def addon(
      addonName: Option[String] = None,
      clusterName: Option[String] = None,
      status: Option[String] = None,
      addonVersion: Option[String] = None,
      health: Option[AddonHealth] = None,
      addonArn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      modifiedAt: Option[Timestamp] = None,
      serviceAccountRoleArn: Option[String] = None,
      tags: Option[TagMap] = None
    ): Addon =
      Addon
        .builder
        .ifSome(addonName)(_.addonName(_))
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(status)(_.status(_))
        .ifSome(addonVersion)(_.addonVersion(_))
        .ifSome(health)(_.health(_))
        .ifSome(addonArn)(_.addonArn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(modifiedAt)(_.modifiedAt(_))
        .ifSome(serviceAccountRoleArn)(_.serviceAccountRoleArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def addonHealth(
      issues: Option[List[AddonIssue]] = None
    ): AddonHealth =
      AddonHealth
        .builder
        .ifSome(issues)(_.issues(_))
        .build

    def addonInfo(
      addonName: Option[String] = None,
      `type`: Option[String] = None,
      addonVersions: Option[List[AddonVersionInfo]] = None
    ): AddonInfo =
      AddonInfo
        .builder
        .ifSome(addonName)(_.addonName(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(addonVersions)(_.addonVersions(_))
        .build

    def addonIssue(
      code: Option[String] = None,
      message: Option[String] = None,
      resourceIds: Option[List[String]] = None
    ): AddonIssue =
      AddonIssue
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .ifSome(resourceIds)(_.resourceIds(_))
        .build

    def addonVersionInfo(
      addonVersion: Option[String] = None,
      architecture: Option[List[String]] = None,
      compatibilities: Option[List[Compatibility]] = None
    ): AddonVersionInfo =
      AddonVersionInfo
        .builder
        .ifSome(addonVersion)(_.addonVersion(_))
        .ifSome(architecture)(_.architecture(_))
        .ifSome(compatibilities)(_.compatibilities(_))
        .build

    def associateEncryptionConfigRequest(
      clusterName: Option[String] = None,
      encryptionConfig: Option[List[EncryptionConfig]] = None,
      clientRequestToken: Option[String] = None
    ): AssociateEncryptionConfigRequest =
      AssociateEncryptionConfigRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(encryptionConfig)(_.encryptionConfig(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def associateEncryptionConfigResponse(
      update: Option[Update] = None
    ): AssociateEncryptionConfigResponse =
      AssociateEncryptionConfigResponse
        .builder
        .ifSome(update)(_.update(_))
        .build

    def associateIdentityProviderConfigRequest(
      clusterName: Option[String] = None,
      oidc: Option[OidcIdentityProviderConfigRequest] = None,
      tags: Option[TagMap] = None,
      clientRequestToken: Option[String] = None
    ): AssociateIdentityProviderConfigRequest =
      AssociateIdentityProviderConfigRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(oidc)(_.oidc(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def associateIdentityProviderConfigResponse(
      update: Option[Update] = None,
      tags: Option[TagMap] = None
    ): AssociateIdentityProviderConfigResponse =
      AssociateIdentityProviderConfigResponse
        .builder
        .ifSome(update)(_.update(_))
        .ifSome(tags)(_.tags(_))
        .build

    def autoScalingGroup(
      name: Option[String] = None
    ): AutoScalingGroup =
      AutoScalingGroup
        .builder
        .ifSome(name)(_.name(_))
        .build

    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def certificate(
      data: Option[String] = None
    ): Certificate =
      Certificate
        .builder
        .ifSome(data)(_.data(_))
        .build

    def clientException(
      clusterName: Option[String] = None,
      nodegroupName: Option[String] = None,
      addonName: Option[String] = None,
      message: Option[String] = None
    ): ClientException =
      ClientException
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(nodegroupName)(_.nodegroupName(_))
        .ifSome(addonName)(_.addonName(_))
        .ifSome(message)(_.message(_))
        .build

    def cluster(
      name: Option[String] = None,
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      version: Option[String] = None,
      endpoint: Option[String] = None,
      roleArn: Option[String] = None,
      resourcesVpcConfig: Option[VpcConfigResponse] = None,
      kubernetesNetworkConfig: Option[KubernetesNetworkConfigResponse] = None,
      logging: Option[Logging] = None,
      identity: Option[Identity] = None,
      status: Option[String] = None,
      certificateAuthority: Option[Certificate] = None,
      clientRequestToken: Option[String] = None,
      platformVersion: Option[String] = None,
      tags: Option[TagMap] = None,
      encryptionConfig: Option[List[EncryptionConfig]] = None
    ): Cluster =
      Cluster
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(version)(_.version(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(resourcesVpcConfig)(_.resourcesVpcConfig(_))
        .ifSome(kubernetesNetworkConfig)(_.kubernetesNetworkConfig(_))
        .ifSome(logging)(_.logging(_))
        .ifSome(identity)(_.identity(_))
        .ifSome(status)(_.status(_))
        .ifSome(certificateAuthority)(_.certificateAuthority(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(platformVersion)(_.platformVersion(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(encryptionConfig)(_.encryptionConfig(_))
        .build

    def compatibility(
      clusterVersion: Option[String] = None,
      platformVersions: Option[List[String]] = None,
      defaultVersion: Option[Boolean] = None
    ): Compatibility =
      Compatibility
        .builder
        .ifSome(clusterVersion)(_.clusterVersion(_))
        .ifSome(platformVersions)(_.platformVersions(_))
        .ifSome(defaultVersion)(_.defaultVersion(_))
        .build

    def createAddonRequest(
      clusterName: Option[String] = None,
      addonName: Option[String] = None,
      addonVersion: Option[String] = None,
      serviceAccountRoleArn: Option[String] = None,
      resolveConflicts: Option[String] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateAddonRequest =
      CreateAddonRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(addonName)(_.addonName(_))
        .ifSome(addonVersion)(_.addonVersion(_))
        .ifSome(serviceAccountRoleArn)(_.serviceAccountRoleArn(_))
        .ifSome(resolveConflicts)(_.resolveConflicts(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAddonResponse(
      addon: Option[Addon] = None
    ): CreateAddonResponse =
      CreateAddonResponse
        .builder
        .ifSome(addon)(_.addon(_))
        .build

    def createClusterRequest(
      name: Option[String] = None,
      version: Option[String] = None,
      roleArn: Option[String] = None,
      resourcesVpcConfig: Option[VpcConfigRequest] = None,
      kubernetesNetworkConfig: Option[KubernetesNetworkConfigRequest] = None,
      logging: Option[Logging] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[TagMap] = None,
      encryptionConfig: Option[List[EncryptionConfig]] = None
    ): CreateClusterRequest =
      CreateClusterRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(resourcesVpcConfig)(_.resourcesVpcConfig(_))
        .ifSome(kubernetesNetworkConfig)(_.kubernetesNetworkConfig(_))
        .ifSome(logging)(_.logging(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(encryptionConfig)(_.encryptionConfig(_))
        .build

    def createClusterResponse(
      cluster: Option[Cluster] = None
    ): CreateClusterResponse =
      CreateClusterResponse
        .builder
        .ifSome(cluster)(_.cluster(_))
        .build

    def createFargateProfileRequest(
      fargateProfileName: Option[String] = None,
      clusterName: Option[String] = None,
      podExecutionRoleArn: Option[String] = None,
      subnets: Option[List[String]] = None,
      selectors: Option[List[FargateProfileSelector]] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateFargateProfileRequest =
      CreateFargateProfileRequest
        .builder
        .ifSome(fargateProfileName)(_.fargateProfileName(_))
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(podExecutionRoleArn)(_.podExecutionRoleArn(_))
        .ifSome(subnets)(_.subnets(_))
        .ifSome(selectors)(_.selectors(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createFargateProfileResponse(
      fargateProfile: Option[FargateProfile] = None
    ): CreateFargateProfileResponse =
      CreateFargateProfileResponse
        .builder
        .ifSome(fargateProfile)(_.fargateProfile(_))
        .build

    def createNodegroupRequest(
      clusterName: Option[String] = None,
      nodegroupName: Option[String] = None,
      scalingConfig: Option[NodegroupScalingConfig] = None,
      diskSize: Option[Int] = None,
      subnets: Option[List[String]] = None,
      instanceTypes: Option[List[String]] = None,
      amiType: Option[String] = None,
      remoteAccess: Option[RemoteAccessConfig] = None,
      nodeRole: Option[String] = None,
      labels: Option[labelsMap] = None,
      taints: Option[List[Taint]] = None,
      tags: Option[TagMap] = None,
      clientRequestToken: Option[String] = None,
      launchTemplate: Option[LaunchTemplateSpecification] = None,
      updateConfig: Option[NodegroupUpdateConfig] = None,
      capacityType: Option[String] = None,
      version: Option[String] = None,
      releaseVersion: Option[String] = None
    ): CreateNodegroupRequest =
      CreateNodegroupRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(nodegroupName)(_.nodegroupName(_))
        .ifSome(scalingConfig)(_.scalingConfig(_))
        .ifSome(diskSize)(_.diskSize(_))
        .ifSome(subnets)(_.subnets(_))
        .ifSome(instanceTypes)(_.instanceTypes(_))
        .ifSome(amiType)(_.amiType(_))
        .ifSome(remoteAccess)(_.remoteAccess(_))
        .ifSome(nodeRole)(_.nodeRole(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(taints)(_.taints(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(launchTemplate)(_.launchTemplate(_))
        .ifSome(updateConfig)(_.updateConfig(_))
        .ifSome(capacityType)(_.capacityType(_))
        .ifSome(version)(_.version(_))
        .ifSome(releaseVersion)(_.releaseVersion(_))
        .build

    def createNodegroupResponse(
      nodegroup: Option[Nodegroup] = None
    ): CreateNodegroupResponse =
      CreateNodegroupResponse
        .builder
        .ifSome(nodegroup)(_.nodegroup(_))
        .build

    def deleteAddonRequest(
      clusterName: Option[String] = None,
      addonName: Option[String] = None
    ): DeleteAddonRequest =
      DeleteAddonRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(addonName)(_.addonName(_))
        .build

    def deleteAddonResponse(
      addon: Option[Addon] = None
    ): DeleteAddonResponse =
      DeleteAddonResponse
        .builder
        .ifSome(addon)(_.addon(_))
        .build

    def deleteClusterRequest(
      name: Option[String] = None
    ): DeleteClusterRequest =
      DeleteClusterRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteClusterResponse(
      cluster: Option[Cluster] = None
    ): DeleteClusterResponse =
      DeleteClusterResponse
        .builder
        .ifSome(cluster)(_.cluster(_))
        .build

    def deleteFargateProfileRequest(
      clusterName: Option[String] = None,
      fargateProfileName: Option[String] = None
    ): DeleteFargateProfileRequest =
      DeleteFargateProfileRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(fargateProfileName)(_.fargateProfileName(_))
        .build

    def deleteFargateProfileResponse(
      fargateProfile: Option[FargateProfile] = None
    ): DeleteFargateProfileResponse =
      DeleteFargateProfileResponse
        .builder
        .ifSome(fargateProfile)(_.fargateProfile(_))
        .build

    def deleteNodegroupRequest(
      clusterName: Option[String] = None,
      nodegroupName: Option[String] = None
    ): DeleteNodegroupRequest =
      DeleteNodegroupRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(nodegroupName)(_.nodegroupName(_))
        .build

    def deleteNodegroupResponse(
      nodegroup: Option[Nodegroup] = None
    ): DeleteNodegroupResponse =
      DeleteNodegroupResponse
        .builder
        .ifSome(nodegroup)(_.nodegroup(_))
        .build

    def describeAddonRequest(
      clusterName: Option[String] = None,
      addonName: Option[String] = None
    ): DescribeAddonRequest =
      DescribeAddonRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(addonName)(_.addonName(_))
        .build

    def describeAddonResponse(
      addon: Option[Addon] = None
    ): DescribeAddonResponse =
      DescribeAddonResponse
        .builder
        .ifSome(addon)(_.addon(_))
        .build

    def describeAddonVersionsRequest(
      kubernetesVersion: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      addonName: Option[String] = None
    ): DescribeAddonVersionsRequest =
      DescribeAddonVersionsRequest
        .builder
        .ifSome(kubernetesVersion)(_.kubernetesVersion(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(addonName)(_.addonName(_))
        .build

    def describeAddonVersionsResponse(
      addons: Option[List[AddonInfo]] = None,
      nextToken: Option[String] = None
    ): DescribeAddonVersionsResponse =
      DescribeAddonVersionsResponse
        .builder
        .ifSome(addons)(_.addons(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeClusterRequest(
      name: Option[String] = None
    ): DescribeClusterRequest =
      DescribeClusterRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def describeClusterResponse(
      cluster: Option[Cluster] = None
    ): DescribeClusterResponse =
      DescribeClusterResponse
        .builder
        .ifSome(cluster)(_.cluster(_))
        .build

    def describeFargateProfileRequest(
      clusterName: Option[String] = None,
      fargateProfileName: Option[String] = None
    ): DescribeFargateProfileRequest =
      DescribeFargateProfileRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(fargateProfileName)(_.fargateProfileName(_))
        .build

    def describeFargateProfileResponse(
      fargateProfile: Option[FargateProfile] = None
    ): DescribeFargateProfileResponse =
      DescribeFargateProfileResponse
        .builder
        .ifSome(fargateProfile)(_.fargateProfile(_))
        .build

    def describeIdentityProviderConfigRequest(
      clusterName: Option[String] = None,
      identityProviderConfig: Option[IdentityProviderConfig] = None
    ): DescribeIdentityProviderConfigRequest =
      DescribeIdentityProviderConfigRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(identityProviderConfig)(_.identityProviderConfig(_))
        .build

    def describeIdentityProviderConfigResponse(
      identityProviderConfig: Option[IdentityProviderConfigResponse] = None
    ): DescribeIdentityProviderConfigResponse =
      DescribeIdentityProviderConfigResponse
        .builder
        .ifSome(identityProviderConfig)(_.identityProviderConfig(_))
        .build

    def describeNodegroupRequest(
      clusterName: Option[String] = None,
      nodegroupName: Option[String] = None
    ): DescribeNodegroupRequest =
      DescribeNodegroupRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(nodegroupName)(_.nodegroupName(_))
        .build

    def describeNodegroupResponse(
      nodegroup: Option[Nodegroup] = None
    ): DescribeNodegroupResponse =
      DescribeNodegroupResponse
        .builder
        .ifSome(nodegroup)(_.nodegroup(_))
        .build

    def describeUpdateRequest(
      name: Option[String] = None,
      updateId: Option[String] = None,
      nodegroupName: Option[String] = None,
      addonName: Option[String] = None
    ): DescribeUpdateRequest =
      DescribeUpdateRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(updateId)(_.updateId(_))
        .ifSome(nodegroupName)(_.nodegroupName(_))
        .ifSome(addonName)(_.addonName(_))
        .build

    def describeUpdateResponse(
      update: Option[Update] = None
    ): DescribeUpdateResponse =
      DescribeUpdateResponse
        .builder
        .ifSome(update)(_.update(_))
        .build

    def disassociateIdentityProviderConfigRequest(
      clusterName: Option[String] = None,
      identityProviderConfig: Option[IdentityProviderConfig] = None,
      clientRequestToken: Option[String] = None
    ): DisassociateIdentityProviderConfigRequest =
      DisassociateIdentityProviderConfigRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(identityProviderConfig)(_.identityProviderConfig(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def disassociateIdentityProviderConfigResponse(
      update: Option[Update] = None
    ): DisassociateIdentityProviderConfigResponse =
      DisassociateIdentityProviderConfigResponse
        .builder
        .ifSome(update)(_.update(_))
        .build

    def encryptionConfig(
      resources: Option[List[String]] = None,
      provider: Option[Provider] = None
    ): EncryptionConfig =
      EncryptionConfig
        .builder
        .ifSome(resources)(_.resources(_))
        .ifSome(provider)(_.provider(_))
        .build

    def errorDetail(
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None,
      resourceIds: Option[List[String]] = None
    ): ErrorDetail =
      ErrorDetail
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(resourceIds)(_.resourceIds(_))
        .build

    def fargateProfile(
      fargateProfileName: Option[String] = None,
      fargateProfileArn: Option[String] = None,
      clusterName: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      podExecutionRoleArn: Option[String] = None,
      subnets: Option[List[String]] = None,
      selectors: Option[List[FargateProfileSelector]] = None,
      status: Option[String] = None,
      tags: Option[TagMap] = None
    ): FargateProfile =
      FargateProfile
        .builder
        .ifSome(fargateProfileName)(_.fargateProfileName(_))
        .ifSome(fargateProfileArn)(_.fargateProfileArn(_))
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(podExecutionRoleArn)(_.podExecutionRoleArn(_))
        .ifSome(subnets)(_.subnets(_))
        .ifSome(selectors)(_.selectors(_))
        .ifSome(status)(_.status(_))
        .ifSome(tags)(_.tags(_))
        .build

    def fargateProfileSelector(
      namespace: Option[String] = None,
      labels: Option[FargateProfileLabel] = None
    ): FargateProfileSelector =
      FargateProfileSelector
        .builder
        .ifSome(namespace)(_.namespace(_))
        .ifSome(labels)(_.labels(_))
        .build

    def identity(
      oidc: Option[OIDC] = None
    ): Identity =
      Identity
        .builder
        .ifSome(oidc)(_.oidc(_))
        .build

    def identityProviderConfig(
      `type`: Option[String] = None,
      name: Option[String] = None
    ): IdentityProviderConfig =
      IdentityProviderConfig
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(name)(_.name(_))
        .build

    def identityProviderConfigResponse(
      oidc: Option[OidcIdentityProviderConfig] = None
    ): IdentityProviderConfigResponse =
      IdentityProviderConfigResponse
        .builder
        .ifSome(oidc)(_.oidc(_))
        .build

    def invalidParameterException(
      clusterName: Option[String] = None,
      nodegroupName: Option[String] = None,
      fargateProfileName: Option[String] = None,
      addonName: Option[String] = None,
      message: Option[String] = None
    ): InvalidParameterException =
      InvalidParameterException
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(nodegroupName)(_.nodegroupName(_))
        .ifSome(fargateProfileName)(_.fargateProfileName(_))
        .ifSome(addonName)(_.addonName(_))
        .ifSome(message)(_.message(_))
        .build

    def invalidRequestException(
      clusterName: Option[String] = None,
      nodegroupName: Option[String] = None,
      addonName: Option[String] = None,
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(nodegroupName)(_.nodegroupName(_))
        .ifSome(addonName)(_.addonName(_))
        .ifSome(message)(_.message(_))
        .build

    def issue(
      code: Option[String] = None,
      message: Option[String] = None,
      resourceIds: Option[List[String]] = None
    ): Issue =
      Issue
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .ifSome(resourceIds)(_.resourceIds(_))
        .build

    def kubernetesNetworkConfigRequest(
      serviceIpv4Cidr: Option[String] = None
    ): KubernetesNetworkConfigRequest =
      KubernetesNetworkConfigRequest
        .builder
        .ifSome(serviceIpv4Cidr)(_.serviceIpv4Cidr(_))
        .build

    def kubernetesNetworkConfigResponse(
      serviceIpv4Cidr: Option[String] = None
    ): KubernetesNetworkConfigResponse =
      KubernetesNetworkConfigResponse
        .builder
        .ifSome(serviceIpv4Cidr)(_.serviceIpv4Cidr(_))
        .build

    def launchTemplateSpecification(
      name: Option[String] = None,
      version: Option[String] = None,
      id: Option[String] = None
    ): LaunchTemplateSpecification =
      LaunchTemplateSpecification
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(id)(_.id(_))
        .build

    def listAddonsRequest(
      clusterName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAddonsRequest =
      ListAddonsRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAddonsResponse(
      addons: Option[List[String]] = None,
      nextToken: Option[String] = None
    ): ListAddonsResponse =
      ListAddonsResponse
        .builder
        .ifSome(addons)(_.addons(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listClustersRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListClustersRequest =
      ListClustersRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listClustersResponse(
      clusters: Option[List[String]] = None,
      nextToken: Option[String] = None
    ): ListClustersResponse =
      ListClustersResponse
        .builder
        .ifSome(clusters)(_.clusters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFargateProfilesRequest(
      clusterName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListFargateProfilesRequest =
      ListFargateProfilesRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFargateProfilesResponse(
      fargateProfileNames: Option[List[String]] = None,
      nextToken: Option[String] = None
    ): ListFargateProfilesResponse =
      ListFargateProfilesResponse
        .builder
        .ifSome(fargateProfileNames)(_.fargateProfileNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listIdentityProviderConfigsRequest(
      clusterName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListIdentityProviderConfigsRequest =
      ListIdentityProviderConfigsRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listIdentityProviderConfigsResponse(
      identityProviderConfigs: Option[List[IdentityProviderConfig]] = None,
      nextToken: Option[String] = None
    ): ListIdentityProviderConfigsResponse =
      ListIdentityProviderConfigsResponse
        .builder
        .ifSome(identityProviderConfigs)(_.identityProviderConfigs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listNodegroupsRequest(
      clusterName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListNodegroupsRequest =
      ListNodegroupsRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listNodegroupsResponse(
      nodegroups: Option[List[String]] = None,
      nextToken: Option[String] = None
    ): ListNodegroupsResponse =
      ListNodegroupsResponse
        .builder
        .ifSome(nodegroups)(_.nodegroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[TagMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listUpdatesRequest(
      name: Option[String] = None,
      nodegroupName: Option[String] = None,
      addonName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListUpdatesRequest =
      ListUpdatesRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(nodegroupName)(_.nodegroupName(_))
        .ifSome(addonName)(_.addonName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listUpdatesResponse(
      updateIds: Option[List[String]] = None,
      nextToken: Option[String] = None
    ): ListUpdatesResponse =
      ListUpdatesResponse
        .builder
        .ifSome(updateIds)(_.updateIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def logSetup(
      types: Option[List[LogType]] = None,
      enabled: Option[Boolean] = None
    ): LogSetup =
      LogSetup
        .builder
        .ifSome(types)(_.types(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def logging(
      clusterLogging: Option[List[LogSetup]] = None
    ): Logging =
      Logging
        .builder
        .ifSome(clusterLogging)(_.clusterLogging(_))
        .build

    def nodegroup(
      nodegroupName: Option[String] = None,
      nodegroupArn: Option[String] = None,
      clusterName: Option[String] = None,
      version: Option[String] = None,
      releaseVersion: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      modifiedAt: Option[Timestamp] = None,
      status: Option[String] = None,
      capacityType: Option[String] = None,
      scalingConfig: Option[NodegroupScalingConfig] = None,
      instanceTypes: Option[List[String]] = None,
      subnets: Option[List[String]] = None,
      remoteAccess: Option[RemoteAccessConfig] = None,
      amiType: Option[String] = None,
      nodeRole: Option[String] = None,
      labels: Option[labelsMap] = None,
      taints: Option[List[Taint]] = None,
      resources: Option[NodegroupResources] = None,
      diskSize: Option[Int] = None,
      health: Option[NodegroupHealth] = None,
      updateConfig: Option[NodegroupUpdateConfig] = None,
      launchTemplate: Option[LaunchTemplateSpecification] = None,
      tags: Option[TagMap] = None
    ): Nodegroup =
      Nodegroup
        .builder
        .ifSome(nodegroupName)(_.nodegroupName(_))
        .ifSome(nodegroupArn)(_.nodegroupArn(_))
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(version)(_.version(_))
        .ifSome(releaseVersion)(_.releaseVersion(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(modifiedAt)(_.modifiedAt(_))
        .ifSome(status)(_.status(_))
        .ifSome(capacityType)(_.capacityType(_))
        .ifSome(scalingConfig)(_.scalingConfig(_))
        .ifSome(instanceTypes)(_.instanceTypes(_))
        .ifSome(subnets)(_.subnets(_))
        .ifSome(remoteAccess)(_.remoteAccess(_))
        .ifSome(amiType)(_.amiType(_))
        .ifSome(nodeRole)(_.nodeRole(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(taints)(_.taints(_))
        .ifSome(resources)(_.resources(_))
        .ifSome(diskSize)(_.diskSize(_))
        .ifSome(health)(_.health(_))
        .ifSome(updateConfig)(_.updateConfig(_))
        .ifSome(launchTemplate)(_.launchTemplate(_))
        .ifSome(tags)(_.tags(_))
        .build

    def nodegroupHealth(
      issues: Option[List[Issue]] = None
    ): NodegroupHealth =
      NodegroupHealth
        .builder
        .ifSome(issues)(_.issues(_))
        .build

    def nodegroupResources(
      autoScalingGroups: Option[List[AutoScalingGroup]] = None,
      remoteAccessSecurityGroup: Option[String] = None
    ): NodegroupResources =
      NodegroupResources
        .builder
        .ifSome(autoScalingGroups)(_.autoScalingGroups(_))
        .ifSome(remoteAccessSecurityGroup)(_.remoteAccessSecurityGroup(_))
        .build

    def nodegroupScalingConfig(
      minSize: Option[Int] = None,
      maxSize: Option[Int] = None,
      desiredSize: Option[Int] = None
    ): NodegroupScalingConfig =
      NodegroupScalingConfig
        .builder
        .ifSome(minSize)(_.minSize(_))
        .ifSome(maxSize)(_.maxSize(_))
        .ifSome(desiredSize)(_.desiredSize(_))
        .build

    def nodegroupUpdateConfig(
      maxUnavailable: Option[Int] = None,
      maxUnavailablePercentage: Option[Int] = None
    ): NodegroupUpdateConfig =
      NodegroupUpdateConfig
        .builder
        .ifSome(maxUnavailable)(_.maxUnavailable(_))
        .ifSome(maxUnavailablePercentage)(_.maxUnavailablePercentage(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def oIDC(
      issuer: Option[String] = None
    ): OIDC =
      OIDC
        .builder
        .ifSome(issuer)(_.issuer(_))
        .build

    def oidcIdentityProviderConfig(
      identityProviderConfigName: Option[String] = None,
      identityProviderConfigArn: Option[String] = None,
      clusterName: Option[String] = None,
      issuerUrl: Option[String] = None,
      clientId: Option[String] = None,
      usernameClaim: Option[String] = None,
      usernamePrefix: Option[String] = None,
      groupsClaim: Option[String] = None,
      groupsPrefix: Option[String] = None,
      requiredClaims: Option[requiredClaimsMap] = None,
      tags: Option[TagMap] = None,
      status: Option[String] = None
    ): OidcIdentityProviderConfig =
      OidcIdentityProviderConfig
        .builder
        .ifSome(identityProviderConfigName)(_.identityProviderConfigName(_))
        .ifSome(identityProviderConfigArn)(_.identityProviderConfigArn(_))
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(issuerUrl)(_.issuerUrl(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(usernameClaim)(_.usernameClaim(_))
        .ifSome(usernamePrefix)(_.usernamePrefix(_))
        .ifSome(groupsClaim)(_.groupsClaim(_))
        .ifSome(groupsPrefix)(_.groupsPrefix(_))
        .ifSome(requiredClaims)(_.requiredClaims(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(status)(_.status(_))
        .build

    def oidcIdentityProviderConfigRequest(
      identityProviderConfigName: Option[String] = None,
      issuerUrl: Option[String] = None,
      clientId: Option[String] = None,
      usernameClaim: Option[String] = None,
      usernamePrefix: Option[String] = None,
      groupsClaim: Option[String] = None,
      groupsPrefix: Option[String] = None,
      requiredClaims: Option[requiredClaimsMap] = None
    ): OidcIdentityProviderConfigRequest =
      OidcIdentityProviderConfigRequest
        .builder
        .ifSome(identityProviderConfigName)(_.identityProviderConfigName(_))
        .ifSome(issuerUrl)(_.issuerUrl(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(usernameClaim)(_.usernameClaim(_))
        .ifSome(usernamePrefix)(_.usernamePrefix(_))
        .ifSome(groupsClaim)(_.groupsClaim(_))
        .ifSome(groupsPrefix)(_.groupsPrefix(_))
        .ifSome(requiredClaims)(_.requiredClaims(_))
        .build

    def provider(
      keyArn: Option[String] = None
    ): Provider =
      Provider
        .builder
        .ifSome(keyArn)(_.keyArn(_))
        .build

    def remoteAccessConfig(
      ec2SshKey: Option[String] = None,
      sourceSecurityGroups: Option[List[String]] = None
    ): RemoteAccessConfig =
      RemoteAccessConfig
        .builder
        .ifSome(ec2SshKey)(_.ec2SshKey(_))
        .ifSome(sourceSecurityGroups)(_.sourceSecurityGroups(_))
        .build

    def resourceInUseException(
      clusterName: Option[String] = None,
      nodegroupName: Option[String] = None,
      addonName: Option[String] = None,
      message: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(nodegroupName)(_.nodegroupName(_))
        .ifSome(addonName)(_.addonName(_))
        .ifSome(message)(_.message(_))
        .build

    def resourceLimitExceededException(
      clusterName: Option[String] = None,
      nodegroupName: Option[String] = None,
      message: Option[String] = None
    ): ResourceLimitExceededException =
      ResourceLimitExceededException
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(nodegroupName)(_.nodegroupName(_))
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFoundException(
      clusterName: Option[String] = None,
      nodegroupName: Option[String] = None,
      fargateProfileName: Option[String] = None,
      addonName: Option[String] = None,
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(nodegroupName)(_.nodegroupName(_))
        .ifSome(fargateProfileName)(_.fargateProfileName(_))
        .ifSome(addonName)(_.addonName(_))
        .ifSome(message)(_.message(_))
        .build

    def serverException(
      clusterName: Option[String] = None,
      nodegroupName: Option[String] = None,
      addonName: Option[String] = None,
      message: Option[String] = None
    ): ServerException =
      ServerException
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(nodegroupName)(_.nodegroupName(_))
        .ifSome(addonName)(_.addonName(_))
        .ifSome(message)(_.message(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[TagMap] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def taint(
      key: Option[String] = None,
      value: Option[String] = None,
      effect: Option[String] = None
    ): Taint =
      Taint
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(effect)(_.effect(_))
        .build

    def unsupportedAvailabilityZoneException(
      message: Option[String] = None,
      clusterName: Option[String] = None,
      nodegroupName: Option[String] = None,
      validZones: Option[List[String]] = None
    ): UnsupportedAvailabilityZoneException =
      UnsupportedAvailabilityZoneException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(nodegroupName)(_.nodegroupName(_))
        .ifSome(validZones)(_.validZones(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def update(
      id: Option[String] = None,
      status: Option[String] = None,
      `type`: Option[String] = None,
      params: Option[List[UpdateParam]] = None,
      createdAt: Option[Timestamp] = None,
      errors: Option[List[ErrorDetail]] = None
    ): Update =
      Update
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(status)(_.status(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(params)(_.params(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(errors)(_.errors(_))
        .build

    def updateAddonRequest(
      clusterName: Option[String] = None,
      addonName: Option[String] = None,
      addonVersion: Option[String] = None,
      serviceAccountRoleArn: Option[String] = None,
      resolveConflicts: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): UpdateAddonRequest =
      UpdateAddonRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(addonName)(_.addonName(_))
        .ifSome(addonVersion)(_.addonVersion(_))
        .ifSome(serviceAccountRoleArn)(_.serviceAccountRoleArn(_))
        .ifSome(resolveConflicts)(_.resolveConflicts(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def updateAddonResponse(
      update: Option[Update] = None
    ): UpdateAddonResponse =
      UpdateAddonResponse
        .builder
        .ifSome(update)(_.update(_))
        .build

    def updateClusterConfigRequest(
      name: Option[String] = None,
      resourcesVpcConfig: Option[VpcConfigRequest] = None,
      logging: Option[Logging] = None,
      clientRequestToken: Option[String] = None
    ): UpdateClusterConfigRequest =
      UpdateClusterConfigRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(resourcesVpcConfig)(_.resourcesVpcConfig(_))
        .ifSome(logging)(_.logging(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def updateClusterConfigResponse(
      update: Option[Update] = None
    ): UpdateClusterConfigResponse =
      UpdateClusterConfigResponse
        .builder
        .ifSome(update)(_.update(_))
        .build

    def updateClusterVersionRequest(
      name: Option[String] = None,
      version: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): UpdateClusterVersionRequest =
      UpdateClusterVersionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def updateClusterVersionResponse(
      update: Option[Update] = None
    ): UpdateClusterVersionResponse =
      UpdateClusterVersionResponse
        .builder
        .ifSome(update)(_.update(_))
        .build

    def updateLabelsPayload(
      addOrUpdateLabels: Option[labelsMap] = None,
      removeLabels: Option[List[String]] = None
    ): UpdateLabelsPayload =
      UpdateLabelsPayload
        .builder
        .ifSome(addOrUpdateLabels)(_.addOrUpdateLabels(_))
        .ifSome(removeLabels)(_.removeLabels(_))
        .build

    def updateNodegroupConfigRequest(
      clusterName: Option[String] = None,
      nodegroupName: Option[String] = None,
      labels: Option[UpdateLabelsPayload] = None,
      taints: Option[UpdateTaintsPayload] = None,
      scalingConfig: Option[NodegroupScalingConfig] = None,
      updateConfig: Option[NodegroupUpdateConfig] = None,
      clientRequestToken: Option[String] = None
    ): UpdateNodegroupConfigRequest =
      UpdateNodegroupConfigRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(nodegroupName)(_.nodegroupName(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(taints)(_.taints(_))
        .ifSome(scalingConfig)(_.scalingConfig(_))
        .ifSome(updateConfig)(_.updateConfig(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def updateNodegroupConfigResponse(
      update: Option[Update] = None
    ): UpdateNodegroupConfigResponse =
      UpdateNodegroupConfigResponse
        .builder
        .ifSome(update)(_.update(_))
        .build

    def updateNodegroupVersionRequest(
      clusterName: Option[String] = None,
      nodegroupName: Option[String] = None,
      version: Option[String] = None,
      releaseVersion: Option[String] = None,
      launchTemplate: Option[LaunchTemplateSpecification] = None,
      force: Option[Boolean] = None,
      clientRequestToken: Option[String] = None
    ): UpdateNodegroupVersionRequest =
      UpdateNodegroupVersionRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(nodegroupName)(_.nodegroupName(_))
        .ifSome(version)(_.version(_))
        .ifSome(releaseVersion)(_.releaseVersion(_))
        .ifSome(launchTemplate)(_.launchTemplate(_))
        .ifSome(force)(_.force(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def updateNodegroupVersionResponse(
      update: Option[Update] = None
    ): UpdateNodegroupVersionResponse =
      UpdateNodegroupVersionResponse
        .builder
        .ifSome(update)(_.update(_))
        .build

    def updateParam(
      `type`: Option[String] = None,
      value: Option[String] = None
    ): UpdateParam =
      UpdateParam
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .build

    def updateTaintsPayload(
      addOrUpdateTaints: Option[List[Taint]] = None,
      removeTaints: Option[List[Taint]] = None
    ): UpdateTaintsPayload =
      UpdateTaintsPayload
        .builder
        .ifSome(addOrUpdateTaints)(_.addOrUpdateTaints(_))
        .ifSome(removeTaints)(_.removeTaints(_))
        .build

    def vpcConfigRequest(
      subnetIds: Option[List[String]] = None,
      securityGroupIds: Option[List[String]] = None,
      endpointPublicAccess: Option[Boolean] = None,
      endpointPrivateAccess: Option[Boolean] = None,
      publicAccessCidrs: Option[List[String]] = None
    ): VpcConfigRequest =
      VpcConfigRequest
        .builder
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(endpointPublicAccess)(_.endpointPublicAccess(_))
        .ifSome(endpointPrivateAccess)(_.endpointPrivateAccess(_))
        .ifSome(publicAccessCidrs)(_.publicAccessCidrs(_))
        .build

    def vpcConfigResponse(
      subnetIds: Option[List[String]] = None,
      securityGroupIds: Option[List[String]] = None,
      clusterSecurityGroupId: Option[String] = None,
      vpcId: Option[String] = None,
      endpointPublicAccess: Option[Boolean] = None,
      endpointPrivateAccess: Option[Boolean] = None,
      publicAccessCidrs: Option[List[String]] = None
    ): VpcConfigResponse =
      VpcConfigResponse
        .builder
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(clusterSecurityGroupId)(_.clusterSecurityGroupId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(endpointPublicAccess)(_.endpointPublicAccess(_))
        .ifSome(endpointPrivateAccess)(_.endpointPrivateAccess(_))
        .ifSome(publicAccessCidrs)(_.publicAccessCidrs(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
