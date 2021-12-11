package goober.hi

import goober.free.ecrpublic.EcrPublicIO
import software.amazon.awssdk.services.ecrpublic.model._


object ecrpublic {
  import goober.free.{ecrpublic ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def authorizationData(
      authorizationToken: Option[String] = None,
      expiresAt: Option[ExpirationTimestamp] = None
    ): AuthorizationData =
      AuthorizationData
        .builder
        .ifSome(authorizationToken)(_.authorizationToken(_))
        .ifSome(expiresAt)(_.expiresAt(_))
        .build

    def batchCheckLayerAvailabilityRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      layerDigests: Option[List[BatchedOperationLayerDigest]] = None
    ): BatchCheckLayerAvailabilityRequest =
      BatchCheckLayerAvailabilityRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(layerDigests)(_.layerDigests(_))
        .build

    def batchCheckLayerAvailabilityResponse(
      layers: Option[List[Layer]] = None,
      failures: Option[List[LayerFailure]] = None
    ): BatchCheckLayerAvailabilityResponse =
      BatchCheckLayerAvailabilityResponse
        .builder
        .ifSome(layers)(_.layers(_))
        .ifSome(failures)(_.failures(_))
        .build

    def batchDeleteImageRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      imageIds: Option[List[ImageIdentifier]] = None
    ): BatchDeleteImageRequest =
      BatchDeleteImageRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(imageIds)(_.imageIds(_))
        .build

    def batchDeleteImageResponse(
      imageIds: Option[List[ImageIdentifier]] = None,
      failures: Option[List[ImageFailure]] = None
    ): BatchDeleteImageResponse =
      BatchDeleteImageResponse
        .builder
        .ifSome(imageIds)(_.imageIds(_))
        .ifSome(failures)(_.failures(_))
        .build

    def completeLayerUploadRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      uploadId: Option[String] = None,
      layerDigests: Option[List[LayerDigest]] = None
    ): CompleteLayerUploadRequest =
      CompleteLayerUploadRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(uploadId)(_.uploadId(_))
        .ifSome(layerDigests)(_.layerDigests(_))
        .build

    def completeLayerUploadResponse(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      uploadId: Option[String] = None,
      layerDigest: Option[String] = None
    ): CompleteLayerUploadResponse =
      CompleteLayerUploadResponse
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(uploadId)(_.uploadId(_))
        .ifSome(layerDigest)(_.layerDigest(_))
        .build

    def createRepositoryRequest(
      repositoryName: Option[String] = None,
      catalogData: Option[RepositoryCatalogDataInput] = None,
      tags: Option[List[Tag]] = None
    ): CreateRepositoryRequest =
      CreateRepositoryRequest
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(catalogData)(_.catalogData(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRepositoryResponse(
      repository: Option[Repository] = None,
      catalogData: Option[RepositoryCatalogData] = None
    ): CreateRepositoryResponse =
      CreateRepositoryResponse
        .builder
        .ifSome(repository)(_.repository(_))
        .ifSome(catalogData)(_.catalogData(_))
        .build

    def deleteRepositoryPolicyRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None
    ): DeleteRepositoryPolicyRequest =
      DeleteRepositoryPolicyRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .build

    def deleteRepositoryPolicyResponse(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      policyText: Option[String] = None
    ): DeleteRepositoryPolicyResponse =
      DeleteRepositoryPolicyResponse
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(policyText)(_.policyText(_))
        .build

    def deleteRepositoryRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      force: Option[Boolean] = None
    ): DeleteRepositoryRequest =
      DeleteRepositoryRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(force)(_.force(_))
        .build

    def deleteRepositoryResponse(
      repository: Option[Repository] = None
    ): DeleteRepositoryResponse =
      DeleteRepositoryResponse
        .builder
        .ifSome(repository)(_.repository(_))
        .build

    def describeImageTagsRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeImageTagsRequest =
      DescribeImageTagsRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeImageTagsResponse(
      imageTagDetails: Option[List[ImageTagDetail]] = None,
      nextToken: Option[String] = None
    ): DescribeImageTagsResponse =
      DescribeImageTagsResponse
        .builder
        .ifSome(imageTagDetails)(_.imageTagDetails(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeImagesRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      imageIds: Option[List[ImageIdentifier]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeImagesRequest =
      DescribeImagesRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(imageIds)(_.imageIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeImagesResponse(
      imageDetails: Option[List[ImageDetail]] = None,
      nextToken: Option[String] = None
    ): DescribeImagesResponse =
      DescribeImagesResponse
        .builder
        .ifSome(imageDetails)(_.imageDetails(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeRegistriesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeRegistriesRequest =
      DescribeRegistriesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeRegistriesResponse(
      registries: Option[List[Registry]] = None,
      nextToken: Option[String] = None
    ): DescribeRegistriesResponse =
      DescribeRegistriesResponse
        .builder
        .ifSome(registries)(_.registries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeRepositoriesRequest(
      registryId: Option[String] = None,
      repositoryNames: Option[List[RepositoryName]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeRepositoriesRequest =
      DescribeRepositoriesRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryNames)(_.repositoryNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeRepositoriesResponse(
      repositories: Option[List[Repository]] = None,
      nextToken: Option[String] = None
    ): DescribeRepositoriesResponse =
      DescribeRepositoriesResponse
        .builder
        .ifSome(repositories)(_.repositories(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def emptyUploadException(
      message: Option[String] = None
    ): EmptyUploadException =
      EmptyUploadException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def getAuthorizationTokenRequest(

    ): GetAuthorizationTokenRequest =
      GetAuthorizationTokenRequest
        .builder

        .build

    def getAuthorizationTokenResponse(
      authorizationData: Option[AuthorizationData] = None
    ): GetAuthorizationTokenResponse =
      GetAuthorizationTokenResponse
        .builder
        .ifSome(authorizationData)(_.authorizationData(_))
        .build

    def getRegistryCatalogDataRequest(

    ): GetRegistryCatalogDataRequest =
      GetRegistryCatalogDataRequest
        .builder

        .build

    def getRegistryCatalogDataResponse(
      registryCatalogData: Option[RegistryCatalogData] = None
    ): GetRegistryCatalogDataResponse =
      GetRegistryCatalogDataResponse
        .builder
        .ifSome(registryCatalogData)(_.registryCatalogData(_))
        .build

    def getRepositoryCatalogDataRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None
    ): GetRepositoryCatalogDataRequest =
      GetRepositoryCatalogDataRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .build

    def getRepositoryCatalogDataResponse(
      catalogData: Option[RepositoryCatalogData] = None
    ): GetRepositoryCatalogDataResponse =
      GetRepositoryCatalogDataResponse
        .builder
        .ifSome(catalogData)(_.catalogData(_))
        .build

    def getRepositoryPolicyRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None
    ): GetRepositoryPolicyRequest =
      GetRepositoryPolicyRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .build

    def getRepositoryPolicyResponse(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      policyText: Option[String] = None
    ): GetRepositoryPolicyResponse =
      GetRepositoryPolicyResponse
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(policyText)(_.policyText(_))
        .build

    def image(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      imageId: Option[ImageIdentifier] = None,
      imageManifest: Option[String] = None,
      imageManifestMediaType: Option[String] = None
    ): Image =
      Image
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(imageManifest)(_.imageManifest(_))
        .ifSome(imageManifestMediaType)(_.imageManifestMediaType(_))
        .build

    def imageAlreadyExistsException(
      message: Option[String] = None
    ): ImageAlreadyExistsException =
      ImageAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def imageDetail(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      imageDigest: Option[String] = None,
      imageTags: Option[List[ImageTag]] = None,
      imageSizeInBytes: Option[ImageSizeInBytes] = None,
      imagePushedAt: Option[PushTimestamp] = None,
      imageManifestMediaType: Option[String] = None,
      artifactMediaType: Option[String] = None
    ): ImageDetail =
      ImageDetail
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(imageDigest)(_.imageDigest(_))
        .ifSome(imageTags)(_.imageTags(_))
        .ifSome(imageSizeInBytes)(_.imageSizeInBytes(_))
        .ifSome(imagePushedAt)(_.imagePushedAt(_))
        .ifSome(imageManifestMediaType)(_.imageManifestMediaType(_))
        .ifSome(artifactMediaType)(_.artifactMediaType(_))
        .build

    def imageDigestDoesNotMatchException(
      message: Option[String] = None
    ): ImageDigestDoesNotMatchException =
      ImageDigestDoesNotMatchException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def imageFailure(
      imageId: Option[ImageIdentifier] = None,
      failureCode: Option[String] = None,
      failureReason: Option[String] = None
    ): ImageFailure =
      ImageFailure
        .builder
        .ifSome(imageId)(_.imageId(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def imageIdentifier(
      imageDigest: Option[String] = None,
      imageTag: Option[String] = None
    ): ImageIdentifier =
      ImageIdentifier
        .builder
        .ifSome(imageDigest)(_.imageDigest(_))
        .ifSome(imageTag)(_.imageTag(_))
        .build

    def imageNotFoundException(
      message: Option[String] = None
    ): ImageNotFoundException =
      ImageNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def imageTagAlreadyExistsException(
      message: Option[String] = None
    ): ImageTagAlreadyExistsException =
      ImageTagAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def imageTagDetail(
      imageTag: Option[String] = None,
      createdAt: Option[CreationTimestamp] = None,
      imageDetail: Option[ReferencedImageDetail] = None
    ): ImageTagDetail =
      ImageTagDetail
        .builder
        .ifSome(imageTag)(_.imageTag(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(imageDetail)(_.imageDetail(_))
        .build

    def initiateLayerUploadRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None
    ): InitiateLayerUploadRequest =
      InitiateLayerUploadRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .build

    def initiateLayerUploadResponse(
      uploadId: Option[String] = None,
      partSize: Option[PartSize] = None
    ): InitiateLayerUploadResponse =
      InitiateLayerUploadResponse
        .builder
        .ifSome(uploadId)(_.uploadId(_))
        .ifSome(partSize)(_.partSize(_))
        .build

    def invalidLayerException(
      message: Option[String] = None
    ): InvalidLayerException =
      InvalidLayerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidLayerPartException(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      uploadId: Option[String] = None,
      lastValidByteReceived: Option[PartSize] = None,
      message: Option[String] = None
    ): InvalidLayerPartException =
      InvalidLayerPartException
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(uploadId)(_.uploadId(_))
        .ifSome(lastValidByteReceived)(_.lastValidByteReceived(_))
        .ifSome(message)(_.message(_))
        .build

    def invalidParameterException(
      message: Option[String] = None
    ): InvalidParameterException =
      InvalidParameterException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidTagParameterException(
      message: Option[String] = None
    ): InvalidTagParameterException =
      InvalidTagParameterException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def layer(
      layerDigest: Option[String] = None,
      layerAvailability: Option[String] = None,
      layerSize: Option[LayerSizeInBytes] = None,
      mediaType: Option[String] = None
    ): Layer =
      Layer
        .builder
        .ifSome(layerDigest)(_.layerDigest(_))
        .ifSome(layerAvailability)(_.layerAvailability(_))
        .ifSome(layerSize)(_.layerSize(_))
        .ifSome(mediaType)(_.mediaType(_))
        .build

    def layerAlreadyExistsException(
      message: Option[String] = None
    ): LayerAlreadyExistsException =
      LayerAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def layerFailure(
      layerDigest: Option[String] = None,
      failureCode: Option[String] = None,
      failureReason: Option[String] = None
    ): LayerFailure =
      LayerFailure
        .builder
        .ifSome(layerDigest)(_.layerDigest(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def layerPartTooSmallException(
      message: Option[String] = None
    ): LayerPartTooSmallException =
      LayerPartTooSmallException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def layersNotFoundException(
      message: Option[String] = None
    ): LayersNotFoundException =
      LayersNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def putImageRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      imageManifest: Option[String] = None,
      imageManifestMediaType: Option[String] = None,
      imageTag: Option[String] = None,
      imageDigest: Option[String] = None
    ): PutImageRequest =
      PutImageRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(imageManifest)(_.imageManifest(_))
        .ifSome(imageManifestMediaType)(_.imageManifestMediaType(_))
        .ifSome(imageTag)(_.imageTag(_))
        .ifSome(imageDigest)(_.imageDigest(_))
        .build

    def putImageResponse(
      image: Option[Image] = None
    ): PutImageResponse =
      PutImageResponse
        .builder
        .ifSome(image)(_.image(_))
        .build

    def putRegistryCatalogDataRequest(
      displayName: Option[String] = None
    ): PutRegistryCatalogDataRequest =
      PutRegistryCatalogDataRequest
        .builder
        .ifSome(displayName)(_.displayName(_))
        .build

    def putRegistryCatalogDataResponse(
      registryCatalogData: Option[RegistryCatalogData] = None
    ): PutRegistryCatalogDataResponse =
      PutRegistryCatalogDataResponse
        .builder
        .ifSome(registryCatalogData)(_.registryCatalogData(_))
        .build

    def putRepositoryCatalogDataRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      catalogData: Option[RepositoryCatalogDataInput] = None
    ): PutRepositoryCatalogDataRequest =
      PutRepositoryCatalogDataRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(catalogData)(_.catalogData(_))
        .build

    def putRepositoryCatalogDataResponse(
      catalogData: Option[RepositoryCatalogData] = None
    ): PutRepositoryCatalogDataResponse =
      PutRepositoryCatalogDataResponse
        .builder
        .ifSome(catalogData)(_.catalogData(_))
        .build

    def referencedImageDetail(
      imageDigest: Option[String] = None,
      imageSizeInBytes: Option[ImageSizeInBytes] = None,
      imagePushedAt: Option[PushTimestamp] = None,
      imageManifestMediaType: Option[String] = None,
      artifactMediaType: Option[String] = None
    ): ReferencedImageDetail =
      ReferencedImageDetail
        .builder
        .ifSome(imageDigest)(_.imageDigest(_))
        .ifSome(imageSizeInBytes)(_.imageSizeInBytes(_))
        .ifSome(imagePushedAt)(_.imagePushedAt(_))
        .ifSome(imageManifestMediaType)(_.imageManifestMediaType(_))
        .ifSome(artifactMediaType)(_.artifactMediaType(_))
        .build

    def referencedImagesNotFoundException(
      message: Option[String] = None
    ): ReferencedImagesNotFoundException =
      ReferencedImagesNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def registry(
      registryId: Option[String] = None,
      registryArn: Option[String] = None,
      registryUri: Option[String] = None,
      verified: Option[Boolean] = None,
      aliases: Option[List[RegistryAlias]] = None
    ): Registry =
      Registry
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(registryArn)(_.registryArn(_))
        .ifSome(registryUri)(_.registryUri(_))
        .ifSome(verified)(_.verified(_))
        .ifSome(aliases)(_.aliases(_))
        .build

    def registryAlias(
      name: Option[String] = None,
      status: Option[String] = None,
      primaryRegistryAlias: Option[Boolean] = None,
      defaultRegistryAlias: Option[Boolean] = None
    ): RegistryAlias =
      RegistryAlias
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(primaryRegistryAlias)(_.primaryRegistryAlias(_))
        .ifSome(defaultRegistryAlias)(_.defaultRegistryAlias(_))
        .build

    def registryCatalogData(
      displayName: Option[String] = None
    ): RegistryCatalogData =
      RegistryCatalogData
        .builder
        .ifSome(displayName)(_.displayName(_))
        .build

    def registryNotFoundException(
      message: Option[String] = None
    ): RegistryNotFoundException =
      RegistryNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def repository(
      repositoryArn: Option[String] = None,
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      repositoryUri: Option[String] = None,
      createdAt: Option[CreationTimestamp] = None
    ): Repository =
      Repository
        .builder
        .ifSome(repositoryArn)(_.repositoryArn(_))
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(repositoryUri)(_.repositoryUri(_))
        .ifSome(createdAt)(_.createdAt(_))
        .build

    def repositoryAlreadyExistsException(
      message: Option[String] = None
    ): RepositoryAlreadyExistsException =
      RepositoryAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def repositoryCatalogData(
      description: Option[String] = None,
      architectures: Option[List[Architecture]] = None,
      operatingSystems: Option[List[OperatingSystem]] = None,
      logoUrl: Option[String] = None,
      aboutText: Option[String] = None,
      usageText: Option[String] = None,
      marketplaceCertified: Option[Boolean] = None
    ): RepositoryCatalogData =
      RepositoryCatalogData
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(architectures)(_.architectures(_))
        .ifSome(operatingSystems)(_.operatingSystems(_))
        .ifSome(logoUrl)(_.logoUrl(_))
        .ifSome(aboutText)(_.aboutText(_))
        .ifSome(usageText)(_.usageText(_))
        .ifSome(marketplaceCertified)(_.marketplaceCertified(_))
        .build

    def repositoryCatalogDataInput(
      description: Option[String] = None,
      architectures: Option[List[Architecture]] = None,
      operatingSystems: Option[List[OperatingSystem]] = None,
      logoImageBlob: Option[LogoImageBlob] = None,
      aboutText: Option[String] = None,
      usageText: Option[String] = None
    ): RepositoryCatalogDataInput =
      RepositoryCatalogDataInput
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(architectures)(_.architectures(_))
        .ifSome(operatingSystems)(_.operatingSystems(_))
        .ifSome(logoImageBlob)(_.logoImageBlob(_))
        .ifSome(aboutText)(_.aboutText(_))
        .ifSome(usageText)(_.usageText(_))
        .build

    def repositoryNotEmptyException(
      message: Option[String] = None
    ): RepositoryNotEmptyException =
      RepositoryNotEmptyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def repositoryNotFoundException(
      message: Option[String] = None
    ): RepositoryNotFoundException =
      RepositoryNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def repositoryPolicyNotFoundException(
      message: Option[String] = None
    ): RepositoryPolicyNotFoundException =
      RepositoryPolicyNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serverException(
      message: Option[String] = None
    ): ServerException =
      ServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def setRepositoryPolicyRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      policyText: Option[String] = None,
      force: Option[Boolean] = None
    ): SetRepositoryPolicyRequest =
      SetRepositoryPolicyRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(policyText)(_.policyText(_))
        .ifSome(force)(_.force(_))
        .build

    def setRepositoryPolicyResponse(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      policyText: Option[String] = None
    ): SetRepositoryPolicyResponse =
      SetRepositoryPolicyResponse
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(policyText)(_.policyText(_))
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

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def tooManyTagsException(
      message: Option[String] = None
    ): TooManyTagsException =
      TooManyTagsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unsupportedCommandException(
      message: Option[String] = None
    ): UnsupportedCommandException =
      UnsupportedCommandException
        .builder
        .ifSome(message)(_.message(_))
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

    def uploadLayerPartRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      uploadId: Option[String] = None,
      partFirstByte: Option[PartSize] = None,
      partLastByte: Option[PartSize] = None,
      layerPartBlob: Option[LayerPartBlob] = None
    ): UploadLayerPartRequest =
      UploadLayerPartRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(uploadId)(_.uploadId(_))
        .ifSome(partFirstByte)(_.partFirstByte(_))
        .ifSome(partLastByte)(_.partLastByte(_))
        .ifSome(layerPartBlob)(_.layerPartBlob(_))
        .build

    def uploadLayerPartResponse(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      uploadId: Option[String] = None,
      lastByteReceived: Option[PartSize] = None
    ): UploadLayerPartResponse =
      UploadLayerPartResponse
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(uploadId)(_.uploadId(_))
        .ifSome(lastByteReceived)(_.lastByteReceived(_))
        .build

    def uploadNotFoundException(
      message: Option[String] = None
    ): UploadNotFoundException =
      UploadNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
