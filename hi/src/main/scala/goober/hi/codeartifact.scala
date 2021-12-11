package goober.hi

import goober.free.codeartifact.CodeartifactIO
import software.amazon.awssdk.services.codeartifact.model._


object codeartifact {
  import goober.free.{codeartifact ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def assetSummary(
      name: Option[String] = None,
      size: Option[LongOptional] = None,
      hashes: Option[AssetHashes] = None
    ): AssetSummary =
      AssetSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(size)(_.size(_))
        .ifSome(hashes)(_.hashes(_))
        .build

    def associateExternalConnectionRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None,
      externalConnection: Option[String] = None
    ): AssociateExternalConnectionRequest =
      AssociateExternalConnectionRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(externalConnection)(_.externalConnection(_))
        .build

    def conflictException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def copyPackageVersionsRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      sourceRepository: Option[String] = None,
      destinationRepository: Option[String] = None,
      format: Option[String] = None,
      namespace: Option[String] = None,
      package: Option[String] = None,
      versions: Option[List[PackageVersion]] = None,
      versionRevisions: Option[PackageVersionRevisionMap] = None,
      allowOverwrite: Option[Boolean] = None,
      includeFromUpstream: Option[Boolean] = None
    ): CopyPackageVersionsRequest =
      CopyPackageVersionsRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(sourceRepository)(_.sourceRepository(_))
        .ifSome(destinationRepository)(_.destinationRepository(_))
        .ifSome(format)(_.format(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(package)(_.package(_))
        .ifSome(versions)(_.versions(_))
        .ifSome(versionRevisions)(_.versionRevisions(_))
        .ifSome(allowOverwrite)(_.allowOverwrite(_))
        .ifSome(includeFromUpstream)(_.includeFromUpstream(_))
        .build

    def createDomainRequest(
      domain: Option[String] = None,
      encryptionKey: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDomainRequest =
      CreateDomainRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRepositoryRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None,
      description: Option[String] = None,
      upstreams: Option[List[UpstreamRepository]] = None,
      tags: Option[List[Tag]] = None
    ): CreateRepositoryRequest =
      CreateRepositoryRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(description)(_.description(_))
        .ifSome(upstreams)(_.upstreams(_))
        .ifSome(tags)(_.tags(_))
        .build

    def deleteDomainPermissionsPolicyRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      policyRevision: Option[String] = None
    ): DeleteDomainPermissionsPolicyRequest =
      DeleteDomainPermissionsPolicyRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(policyRevision)(_.policyRevision(_))
        .build

    def deleteDomainRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None
    ): DeleteDomainRequest =
      DeleteDomainRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .build

    def deletePackageVersionsRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None,
      format: Option[String] = None,
      namespace: Option[String] = None,
      package: Option[String] = None,
      versions: Option[List[PackageVersion]] = None,
      expectedStatus: Option[String] = None
    ): DeletePackageVersionsRequest =
      DeletePackageVersionsRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(format)(_.format(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(package)(_.package(_))
        .ifSome(versions)(_.versions(_))
        .ifSome(expectedStatus)(_.expectedStatus(_))
        .build

    def deleteRepositoryPermissionsPolicyRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None,
      policyRevision: Option[String] = None
    ): DeleteRepositoryPermissionsPolicyRequest =
      DeleteRepositoryPermissionsPolicyRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(policyRevision)(_.policyRevision(_))
        .build

    def deleteRepositoryRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None
    ): DeleteRepositoryRequest =
      DeleteRepositoryRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .build

    def describeDomainRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None
    ): DescribeDomainRequest =
      DescribeDomainRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .build

    def describePackageVersionRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None,
      format: Option[String] = None,
      namespace: Option[String] = None,
      package: Option[String] = None,
      packageVersion: Option[String] = None
    ): DescribePackageVersionRequest =
      DescribePackageVersionRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(format)(_.format(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(package)(_.package(_))
        .ifSome(packageVersion)(_.packageVersion(_))
        .build

    def describeRepositoryRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None
    ): DescribeRepositoryRequest =
      DescribeRepositoryRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .build

    def disassociateExternalConnectionRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None,
      externalConnection: Option[String] = None
    ): DisassociateExternalConnectionRequest =
      DisassociateExternalConnectionRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(externalConnection)(_.externalConnection(_))
        .build

    def disposePackageVersionsRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None,
      format: Option[String] = None,
      namespace: Option[String] = None,
      package: Option[String] = None,
      versions: Option[List[PackageVersion]] = None,
      versionRevisions: Option[PackageVersionRevisionMap] = None,
      expectedStatus: Option[String] = None
    ): DisposePackageVersionsRequest =
      DisposePackageVersionsRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(format)(_.format(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(package)(_.package(_))
        .ifSome(versions)(_.versions(_))
        .ifSome(versionRevisions)(_.versionRevisions(_))
        .ifSome(expectedStatus)(_.expectedStatus(_))
        .build

    def domainDescription(
      name: Option[String] = None,
      owner: Option[String] = None,
      arn: Option[String] = None,
      status: Option[String] = None,
      createdTime: Option[Timestamp] = None,
      encryptionKey: Option[String] = None,
      repositoryCount: Option[Int] = None,
      assetSizeBytes: Option[Long] = None,
      s3BucketArn: Option[String] = None
    ): DomainDescription =
      DomainDescription
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .ifSome(repositoryCount)(_.repositoryCount(_))
        .ifSome(assetSizeBytes)(_.assetSizeBytes(_))
        .ifSome(s3BucketArn)(_.s3BucketArn(_))
        .build

    def domainSummary(
      name: Option[String] = None,
      owner: Option[String] = None,
      arn: Option[String] = None,
      status: Option[String] = None,
      createdTime: Option[Timestamp] = None,
      encryptionKey: Option[String] = None
    ): DomainSummary =
      DomainSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .build

    def getAuthorizationTokenRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      durationSeconds: Option[AuthorizationTokenDurationSeconds] = None
    ): GetAuthorizationTokenRequest =
      GetAuthorizationTokenRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(durationSeconds)(_.durationSeconds(_))
        .build

    def getDomainPermissionsPolicyRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None
    ): GetDomainPermissionsPolicyRequest =
      GetDomainPermissionsPolicyRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .build

    def getPackageVersionAssetRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None,
      format: Option[String] = None,
      namespace: Option[String] = None,
      package: Option[String] = None,
      packageVersion: Option[String] = None,
      asset: Option[String] = None,
      packageVersionRevision: Option[String] = None
    ): GetPackageVersionAssetRequest =
      GetPackageVersionAssetRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(format)(_.format(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(package)(_.package(_))
        .ifSome(packageVersion)(_.packageVersion(_))
        .ifSome(asset)(_.asset(_))
        .ifSome(packageVersionRevision)(_.packageVersionRevision(_))
        .build

    def getPackageVersionReadmeRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None,
      format: Option[String] = None,
      namespace: Option[String] = None,
      package: Option[String] = None,
      packageVersion: Option[String] = None
    ): GetPackageVersionReadmeRequest =
      GetPackageVersionReadmeRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(format)(_.format(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(package)(_.package(_))
        .ifSome(packageVersion)(_.packageVersion(_))
        .build

    def getRepositoryEndpointRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None,
      format: Option[String] = None
    ): GetRepositoryEndpointRequest =
      GetRepositoryEndpointRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(format)(_.format(_))
        .build

    def getRepositoryPermissionsPolicyRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None
    ): GetRepositoryPermissionsPolicyRequest =
      GetRepositoryPermissionsPolicyRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def licenseInfo(
      name: Option[String] = None,
      url: Option[String] = None
    ): LicenseInfo =
      LicenseInfo
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(url)(_.url(_))
        .build

    def listDomainsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListDomainsRequest =
      ListDomainsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPackageVersionAssetsRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None,
      format: Option[String] = None,
      namespace: Option[String] = None,
      package: Option[String] = None,
      packageVersion: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListPackageVersionAssetsRequest =
      ListPackageVersionAssetsRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(format)(_.format(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(package)(_.package(_))
        .ifSome(packageVersion)(_.packageVersion(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPackageVersionDependenciesRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None,
      format: Option[String] = None,
      namespace: Option[String] = None,
      package: Option[String] = None,
      packageVersion: Option[String] = None,
      nextToken: Option[String] = None
    ): ListPackageVersionDependenciesRequest =
      ListPackageVersionDependenciesRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(format)(_.format(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(package)(_.package(_))
        .ifSome(packageVersion)(_.packageVersion(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPackageVersionsRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None,
      format: Option[String] = None,
      namespace: Option[String] = None,
      package: Option[String] = None,
      status: Option[String] = None,
      sortBy: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListPackageVersionsRequest =
      ListPackageVersionsRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(format)(_.format(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(package)(_.package(_))
        .ifSome(status)(_.status(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPackagesRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None,
      format: Option[String] = None,
      namespace: Option[String] = None,
      packagePrefix: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListPackagesRequest =
      ListPackagesRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(format)(_.format(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(packagePrefix)(_.packagePrefix(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRepositoriesInDomainRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      administratorAccount: Option[String] = None,
      repositoryPrefix: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListRepositoriesInDomainRequest =
      ListRepositoriesInDomainRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(administratorAccount)(_.administratorAccount(_))
        .ifSome(repositoryPrefix)(_.repositoryPrefix(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRepositoriesRequest(
      repositoryPrefix: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListRepositoriesRequest =
      ListRepositoriesRequest
        .builder
        .ifSome(repositoryPrefix)(_.repositoryPrefix(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def packageDependency(
      namespace: Option[String] = None,
      package: Option[String] = None,
      dependencyType: Option[String] = None,
      versionRequirement: Option[String] = None
    ): PackageDependency =
      PackageDependency
        .builder
        .ifSome(namespace)(_.namespace(_))
        .ifSome(package)(_.package(_))
        .ifSome(dependencyType)(_.dependencyType(_))
        .ifSome(versionRequirement)(_.versionRequirement(_))
        .build

    def packageSummary(
      format: Option[String] = None,
      namespace: Option[String] = None,
      package: Option[String] = None
    ): PackageSummary =
      PackageSummary
        .builder
        .ifSome(format)(_.format(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(package)(_.package(_))
        .build

    def packageVersionDescription(
      format: Option[String] = None,
      namespace: Option[String] = None,
      packageName: Option[String] = None,
      displayName: Option[String] = None,
      version: Option[String] = None,
      summary: Option[String] = None,
      homePage: Option[String] = None,
      sourceCodeRepository: Option[String] = None,
      publishedTime: Option[Timestamp] = None,
      licenses: Option[List[LicenseInfo]] = None,
      revision: Option[String] = None,
      status: Option[String] = None
    ): PackageVersionDescription =
      PackageVersionDescription
        .builder
        .ifSome(format)(_.format(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(packageName)(_.packageName(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(version)(_.version(_))
        .ifSome(summary)(_.summary(_))
        .ifSome(homePage)(_.homePage(_))
        .ifSome(sourceCodeRepository)(_.sourceCodeRepository(_))
        .ifSome(publishedTime)(_.publishedTime(_))
        .ifSome(licenses)(_.licenses(_))
        .ifSome(revision)(_.revision(_))
        .ifSome(status)(_.status(_))
        .build

    def packageVersionError(
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): PackageVersionError =
      PackageVersionError
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def packageVersionSummary(
      version: Option[String] = None,
      revision: Option[String] = None,
      status: Option[String] = None
    ): PackageVersionSummary =
      PackageVersionSummary
        .builder
        .ifSome(version)(_.version(_))
        .ifSome(revision)(_.revision(_))
        .ifSome(status)(_.status(_))
        .build

    def putDomainPermissionsPolicyRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      policyRevision: Option[String] = None,
      policyDocument: Option[String] = None
    ): PutDomainPermissionsPolicyRequest =
      PutDomainPermissionsPolicyRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(policyRevision)(_.policyRevision(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .build

    def putRepositoryPermissionsPolicyRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None,
      policyRevision: Option[String] = None,
      policyDocument: Option[String] = None
    ): PutRepositoryPermissionsPolicyRequest =
      PutRepositoryPermissionsPolicyRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(policyRevision)(_.policyRevision(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .build

    def repositoryDescription(
      name: Option[String] = None,
      administratorAccount: Option[String] = None,
      domainName: Option[String] = None,
      domainOwner: Option[String] = None,
      arn: Option[String] = None,
      description: Option[String] = None,
      upstreams: Option[List[UpstreamRepositoryInfo]] = None,
      externalConnections: Option[List[RepositoryExternalConnectionInfo]] = None
    ): RepositoryDescription =
      RepositoryDescription
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(administratorAccount)(_.administratorAccount(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(description)(_.description(_))
        .ifSome(upstreams)(_.upstreams(_))
        .ifSome(externalConnections)(_.externalConnections(_))
        .build

    def repositoryExternalConnectionInfo(
      externalConnectionName: Option[String] = None,
      packageFormat: Option[String] = None,
      status: Option[String] = None
    ): RepositoryExternalConnectionInfo =
      RepositoryExternalConnectionInfo
        .builder
        .ifSome(externalConnectionName)(_.externalConnectionName(_))
        .ifSome(packageFormat)(_.packageFormat(_))
        .ifSome(status)(_.status(_))
        .build

    def repositorySummary(
      name: Option[String] = None,
      administratorAccount: Option[String] = None,
      domainName: Option[String] = None,
      domainOwner: Option[String] = None,
      arn: Option[String] = None,
      description: Option[String] = None
    ): RepositorySummary =
      RepositorySummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(administratorAccount)(_.administratorAccount(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(description)(_.description(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def resourcePolicy(
      resourceArn: Option[String] = None,
      revision: Option[String] = None,
      document: Option[String] = None
    ): ResourcePolicy =
      ResourcePolicy
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(revision)(_.revision(_))
        .ifSome(document)(_.document(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def successfulPackageVersionInfo(
      revision: Option[String] = None,
      status: Option[String] = None
    ): SuccessfulPackageVersionInfo =
      SuccessfulPackageVersionInfo
        .builder
        .ifSome(revision)(_.revision(_))
        .ifSome(status)(_.status(_))
        .build

    def tag(
      key: Option[String] = None,
      value: Option[String] = None
    ): Tag =
      Tag
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def throttlingException(
      message: Option[String] = None,
      retryAfterSeconds: Option[Int] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
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

    def updatePackageVersionsStatusRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None,
      format: Option[String] = None,
      namespace: Option[String] = None,
      package: Option[String] = None,
      versions: Option[List[PackageVersion]] = None,
      versionRevisions: Option[PackageVersionRevisionMap] = None,
      expectedStatus: Option[String] = None,
      targetStatus: Option[String] = None
    ): UpdatePackageVersionsStatusRequest =
      UpdatePackageVersionsStatusRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(format)(_.format(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(package)(_.package(_))
        .ifSome(versions)(_.versions(_))
        .ifSome(versionRevisions)(_.versionRevisions(_))
        .ifSome(expectedStatus)(_.expectedStatus(_))
        .ifSome(targetStatus)(_.targetStatus(_))
        .build

    def updateRepositoryRequest(
      domain: Option[String] = None,
      domainOwner: Option[String] = None,
      repository: Option[String] = None,
      description: Option[String] = None,
      upstreams: Option[List[UpstreamRepository]] = None
    ): UpdateRepositoryRequest =
      UpdateRepositoryRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(domainOwner)(_.domainOwner(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(description)(_.description(_))
        .ifSome(upstreams)(_.upstreams(_))
        .build

    def upstreamRepository(
      repositoryName: Option[String] = None
    ): UpstreamRepository =
      UpstreamRepository
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .build

    def upstreamRepositoryInfo(
      repositoryName: Option[String] = None
    ): UpstreamRepositoryInfo =
      UpstreamRepositoryInfo
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .build

    def validationException(
      message: Option[String] = None,
      reason: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
