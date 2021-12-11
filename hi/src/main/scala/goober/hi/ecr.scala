package goober.hi

import goober.free.ecr.EcrIO
import software.amazon.awssdk.services.ecr.model._


object ecr {
  import goober.free.{ecr ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def attribute(
      key: Option[String] = None,
      value: Option[String] = None
    ): Attribute =
      Attribute
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def authorizationData(
      authorizationToken: Option[String] = None,
      expiresAt: Option[ExpirationTimestamp] = None,
      proxyEndpoint: Option[String] = None
    ): AuthorizationData =
      AuthorizationData
        .builder
        .ifSome(authorizationToken)(_.authorizationToken(_))
        .ifSome(expiresAt)(_.expiresAt(_))
        .ifSome(proxyEndpoint)(_.proxyEndpoint(_))
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

    def batchGetImageRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      imageIds: Option[List[ImageIdentifier]] = None,
      acceptedMediaTypes: Option[List[MediaType]] = None
    ): BatchGetImageRequest =
      BatchGetImageRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(imageIds)(_.imageIds(_))
        .ifSome(acceptedMediaTypes)(_.acceptedMediaTypes(_))
        .build

    def batchGetImageResponse(
      images: Option[List[Image]] = None,
      failures: Option[List[ImageFailure]] = None
    ): BatchGetImageResponse =
      BatchGetImageResponse
        .builder
        .ifSome(images)(_.images(_))
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
      tags: Option[List[Tag]] = None,
      imageTagMutability: Option[String] = None,
      imageScanningConfiguration: Option[ImageScanningConfiguration] = None,
      encryptionConfiguration: Option[EncryptionConfiguration] = None
    ): CreateRepositoryRequest =
      CreateRepositoryRequest
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(imageTagMutability)(_.imageTagMutability(_))
        .ifSome(imageScanningConfiguration)(_.imageScanningConfiguration(_))
        .ifSome(encryptionConfiguration)(_.encryptionConfiguration(_))
        .build

    def createRepositoryResponse(
      repository: Option[Repository] = None
    ): CreateRepositoryResponse =
      CreateRepositoryResponse
        .builder
        .ifSome(repository)(_.repository(_))
        .build

    def deleteLifecyclePolicyRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None
    ): DeleteLifecyclePolicyRequest =
      DeleteLifecyclePolicyRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .build

    def deleteLifecyclePolicyResponse(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      lifecyclePolicyText: Option[String] = None,
      lastEvaluatedAt: Option[EvaluationTimestamp] = None
    ): DeleteLifecyclePolicyResponse =
      DeleteLifecyclePolicyResponse
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(lifecyclePolicyText)(_.lifecyclePolicyText(_))
        .ifSome(lastEvaluatedAt)(_.lastEvaluatedAt(_))
        .build

    def deleteRegistryPolicyRequest(

    ): DeleteRegistryPolicyRequest =
      DeleteRegistryPolicyRequest
        .builder

        .build

    def deleteRegistryPolicyResponse(
      registryId: Option[String] = None,
      policyText: Option[String] = None
    ): DeleteRegistryPolicyResponse =
      DeleteRegistryPolicyResponse
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(policyText)(_.policyText(_))
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

    def describeImageScanFindingsRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      imageId: Option[ImageIdentifier] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeImageScanFindingsRequest =
      DescribeImageScanFindingsRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeImageScanFindingsResponse(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      imageId: Option[ImageIdentifier] = None,
      imageScanStatus: Option[ImageScanStatus] = None,
      imageScanFindings: Option[ImageScanFindings] = None,
      nextToken: Option[String] = None
    ): DescribeImageScanFindingsResponse =
      DescribeImageScanFindingsResponse
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(imageScanStatus)(_.imageScanStatus(_))
        .ifSome(imageScanFindings)(_.imageScanFindings(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeImagesFilter(
      tagStatus: Option[String] = None
    ): DescribeImagesFilter =
      DescribeImagesFilter
        .builder
        .ifSome(tagStatus)(_.tagStatus(_))
        .build

    def describeImagesRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      imageIds: Option[List[ImageIdentifier]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filter: Option[DescribeImagesFilter] = None
    ): DescribeImagesRequest =
      DescribeImagesRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(imageIds)(_.imageIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filter)(_.filter(_))
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

    def describeRegistryRequest(

    ): DescribeRegistryRequest =
      DescribeRegistryRequest
        .builder

        .build

    def describeRegistryResponse(
      registryId: Option[String] = None,
      replicationConfiguration: Option[ReplicationConfiguration] = None
    ): DescribeRegistryResponse =
      DescribeRegistryResponse
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(replicationConfiguration)(_.replicationConfiguration(_))
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

    def encryptionConfiguration(
      encryptionType: Option[String] = None,
      kmsKey: Option[String] = None
    ): EncryptionConfiguration =
      EncryptionConfiguration
        .builder
        .ifSome(encryptionType)(_.encryptionType(_))
        .ifSome(kmsKey)(_.kmsKey(_))
        .build

    def getAuthorizationTokenRequest(
      registryIds: Option[List[RegistryId]] = None
    ): GetAuthorizationTokenRequest =
      GetAuthorizationTokenRequest
        .builder
        .ifSome(registryIds)(_.registryIds(_))
        .build

    def getAuthorizationTokenResponse(
      authorizationData: Option[List[AuthorizationData]] = None
    ): GetAuthorizationTokenResponse =
      GetAuthorizationTokenResponse
        .builder
        .ifSome(authorizationData)(_.authorizationData(_))
        .build

    def getDownloadUrlForLayerRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      layerDigest: Option[String] = None
    ): GetDownloadUrlForLayerRequest =
      GetDownloadUrlForLayerRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(layerDigest)(_.layerDigest(_))
        .build

    def getDownloadUrlForLayerResponse(
      downloadUrl: Option[String] = None,
      layerDigest: Option[String] = None
    ): GetDownloadUrlForLayerResponse =
      GetDownloadUrlForLayerResponse
        .builder
        .ifSome(downloadUrl)(_.downloadUrl(_))
        .ifSome(layerDigest)(_.layerDigest(_))
        .build

    def getLifecyclePolicyPreviewRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      imageIds: Option[List[ImageIdentifier]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filter: Option[LifecyclePolicyPreviewFilter] = None
    ): GetLifecyclePolicyPreviewRequest =
      GetLifecyclePolicyPreviewRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(imageIds)(_.imageIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filter)(_.filter(_))
        .build

    def getLifecyclePolicyPreviewResponse(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      lifecyclePolicyText: Option[String] = None,
      status: Option[String] = None,
      nextToken: Option[String] = None,
      previewResults: Option[List[LifecyclePolicyPreviewResult]] = None,
      summary: Option[LifecyclePolicyPreviewSummary] = None
    ): GetLifecyclePolicyPreviewResponse =
      GetLifecyclePolicyPreviewResponse
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(lifecyclePolicyText)(_.lifecyclePolicyText(_))
        .ifSome(status)(_.status(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(previewResults)(_.previewResults(_))
        .ifSome(summary)(_.summary(_))
        .build

    def getLifecyclePolicyRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None
    ): GetLifecyclePolicyRequest =
      GetLifecyclePolicyRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .build

    def getLifecyclePolicyResponse(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      lifecyclePolicyText: Option[String] = None,
      lastEvaluatedAt: Option[EvaluationTimestamp] = None
    ): GetLifecyclePolicyResponse =
      GetLifecyclePolicyResponse
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(lifecyclePolicyText)(_.lifecyclePolicyText(_))
        .ifSome(lastEvaluatedAt)(_.lastEvaluatedAt(_))
        .build

    def getRegistryPolicyRequest(

    ): GetRegistryPolicyRequest =
      GetRegistryPolicyRequest
        .builder

        .build

    def getRegistryPolicyResponse(
      registryId: Option[String] = None,
      policyText: Option[String] = None
    ): GetRegistryPolicyResponse =
      GetRegistryPolicyResponse
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(policyText)(_.policyText(_))
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
      imageScanStatus: Option[ImageScanStatus] = None,
      imageScanFindingsSummary: Option[ImageScanFindingsSummary] = None,
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
        .ifSome(imageScanStatus)(_.imageScanStatus(_))
        .ifSome(imageScanFindingsSummary)(_.imageScanFindingsSummary(_))
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

    def imageScanFinding(
      name: Option[String] = None,
      description: Option[String] = None,
      uri: Option[String] = None,
      severity: Option[String] = None,
      attributes: Option[List[Attribute]] = None
    ): ImageScanFinding =
      ImageScanFinding
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(uri)(_.uri(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def imageScanFindings(
      imageScanCompletedAt: Option[ScanTimestamp] = None,
      vulnerabilitySourceUpdatedAt: Option[VulnerabilitySourceUpdateTimestamp] = None,
      findings: Option[List[ImageScanFinding]] = None,
      findingSeverityCounts: Option[FindingSeverityCounts] = None
    ): ImageScanFindings =
      ImageScanFindings
        .builder
        .ifSome(imageScanCompletedAt)(_.imageScanCompletedAt(_))
        .ifSome(vulnerabilitySourceUpdatedAt)(_.vulnerabilitySourceUpdatedAt(_))
        .ifSome(findings)(_.findings(_))
        .ifSome(findingSeverityCounts)(_.findingSeverityCounts(_))
        .build

    def imageScanFindingsSummary(
      imageScanCompletedAt: Option[ScanTimestamp] = None,
      vulnerabilitySourceUpdatedAt: Option[VulnerabilitySourceUpdateTimestamp] = None,
      findingSeverityCounts: Option[FindingSeverityCounts] = None
    ): ImageScanFindingsSummary =
      ImageScanFindingsSummary
        .builder
        .ifSome(imageScanCompletedAt)(_.imageScanCompletedAt(_))
        .ifSome(vulnerabilitySourceUpdatedAt)(_.vulnerabilitySourceUpdatedAt(_))
        .ifSome(findingSeverityCounts)(_.findingSeverityCounts(_))
        .build

    def imageScanStatus(
      status: Option[String] = None,
      description: Option[String] = None
    ): ImageScanStatus =
      ImageScanStatus
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(description)(_.description(_))
        .build

    def imageScanningConfiguration(
      scanOnPush: Option[Boolean] = None
    ): ImageScanningConfiguration =
      ImageScanningConfiguration
        .builder
        .ifSome(scanOnPush)(_.scanOnPush(_))
        .build

    def imageTagAlreadyExistsException(
      message: Option[String] = None
    ): ImageTagAlreadyExistsException =
      ImageTagAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
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

    def kmsException(
      message: Option[String] = None,
      kmsError: Option[String] = None
    ): KmsException =
      KmsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(kmsError)(_.kmsError(_))
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

    def layerInaccessibleException(
      message: Option[String] = None
    ): LayerInaccessibleException =
      LayerInaccessibleException
        .builder
        .ifSome(message)(_.message(_))
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

    def lifecyclePolicyNotFoundException(
      message: Option[String] = None
    ): LifecyclePolicyNotFoundException =
      LifecyclePolicyNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def lifecyclePolicyPreviewFilter(
      tagStatus: Option[String] = None
    ): LifecyclePolicyPreviewFilter =
      LifecyclePolicyPreviewFilter
        .builder
        .ifSome(tagStatus)(_.tagStatus(_))
        .build

    def lifecyclePolicyPreviewInProgressException(
      message: Option[String] = None
    ): LifecyclePolicyPreviewInProgressException =
      LifecyclePolicyPreviewInProgressException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def lifecyclePolicyPreviewNotFoundException(
      message: Option[String] = None
    ): LifecyclePolicyPreviewNotFoundException =
      LifecyclePolicyPreviewNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def lifecyclePolicyPreviewSummary(
      expiringImageTotalCount: Option[Int] = None
    ): LifecyclePolicyPreviewSummary =
      LifecyclePolicyPreviewSummary
        .builder
        .ifSome(expiringImageTotalCount)(_.expiringImageTotalCount(_))
        .build

    def lifecyclePolicyRuleAction(
      `type`: Option[String] = None
    ): LifecyclePolicyRuleAction =
      LifecyclePolicyRuleAction
        .builder
        .ifSome(`type`)(_.`type`(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listImagesFilter(
      tagStatus: Option[String] = None
    ): ListImagesFilter =
      ListImagesFilter
        .builder
        .ifSome(tagStatus)(_.tagStatus(_))
        .build

    def listImagesRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filter: Option[ListImagesFilter] = None
    ): ListImagesRequest =
      ListImagesRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filter)(_.filter(_))
        .build

    def listImagesResponse(
      imageIds: Option[List[ImageIdentifier]] = None,
      nextToken: Option[String] = None
    ): ListImagesResponse =
      ListImagesResponse
        .builder
        .ifSome(imageIds)(_.imageIds(_))
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

    def putImageScanningConfigurationRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      imageScanningConfiguration: Option[ImageScanningConfiguration] = None
    ): PutImageScanningConfigurationRequest =
      PutImageScanningConfigurationRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(imageScanningConfiguration)(_.imageScanningConfiguration(_))
        .build

    def putImageScanningConfigurationResponse(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      imageScanningConfiguration: Option[ImageScanningConfiguration] = None
    ): PutImageScanningConfigurationResponse =
      PutImageScanningConfigurationResponse
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(imageScanningConfiguration)(_.imageScanningConfiguration(_))
        .build

    def putImageTagMutabilityRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      imageTagMutability: Option[String] = None
    ): PutImageTagMutabilityRequest =
      PutImageTagMutabilityRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(imageTagMutability)(_.imageTagMutability(_))
        .build

    def putImageTagMutabilityResponse(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      imageTagMutability: Option[String] = None
    ): PutImageTagMutabilityResponse =
      PutImageTagMutabilityResponse
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(imageTagMutability)(_.imageTagMutability(_))
        .build

    def putLifecyclePolicyRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      lifecyclePolicyText: Option[String] = None
    ): PutLifecyclePolicyRequest =
      PutLifecyclePolicyRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(lifecyclePolicyText)(_.lifecyclePolicyText(_))
        .build

    def putLifecyclePolicyResponse(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      lifecyclePolicyText: Option[String] = None
    ): PutLifecyclePolicyResponse =
      PutLifecyclePolicyResponse
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(lifecyclePolicyText)(_.lifecyclePolicyText(_))
        .build

    def putRegistryPolicyRequest(
      policyText: Option[String] = None
    ): PutRegistryPolicyRequest =
      PutRegistryPolicyRequest
        .builder
        .ifSome(policyText)(_.policyText(_))
        .build

    def putRegistryPolicyResponse(
      registryId: Option[String] = None,
      policyText: Option[String] = None
    ): PutRegistryPolicyResponse =
      PutRegistryPolicyResponse
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(policyText)(_.policyText(_))
        .build

    def putReplicationConfigurationRequest(
      replicationConfiguration: Option[ReplicationConfiguration] = None
    ): PutReplicationConfigurationRequest =
      PutReplicationConfigurationRequest
        .builder
        .ifSome(replicationConfiguration)(_.replicationConfiguration(_))
        .build

    def putReplicationConfigurationResponse(
      replicationConfiguration: Option[ReplicationConfiguration] = None
    ): PutReplicationConfigurationResponse =
      PutReplicationConfigurationResponse
        .builder
        .ifSome(replicationConfiguration)(_.replicationConfiguration(_))
        .build

    def referencedImagesNotFoundException(
      message: Option[String] = None
    ): ReferencedImagesNotFoundException =
      ReferencedImagesNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def registryPolicyNotFoundException(
      message: Option[String] = None
    ): RegistryPolicyNotFoundException =
      RegistryPolicyNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def replicationConfiguration(
      rules: Option[List[ReplicationRule]] = None
    ): ReplicationConfiguration =
      ReplicationConfiguration
        .builder
        .ifSome(rules)(_.rules(_))
        .build

    def replicationDestination(
      region: Option[String] = None,
      registryId: Option[String] = None
    ): ReplicationDestination =
      ReplicationDestination
        .builder
        .ifSome(region)(_.region(_))
        .ifSome(registryId)(_.registryId(_))
        .build

    def replicationRule(
      destinations: Option[List[ReplicationDestination]] = None
    ): ReplicationRule =
      ReplicationRule
        .builder
        .ifSome(destinations)(_.destinations(_))
        .build

    def repository(
      repositoryArn: Option[String] = None,
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      repositoryUri: Option[String] = None,
      createdAt: Option[CreationTimestamp] = None,
      imageTagMutability: Option[String] = None,
      imageScanningConfiguration: Option[ImageScanningConfiguration] = None,
      encryptionConfiguration: Option[EncryptionConfiguration] = None
    ): Repository =
      Repository
        .builder
        .ifSome(repositoryArn)(_.repositoryArn(_))
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(repositoryUri)(_.repositoryUri(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(imageTagMutability)(_.imageTagMutability(_))
        .ifSome(imageScanningConfiguration)(_.imageScanningConfiguration(_))
        .ifSome(encryptionConfiguration)(_.encryptionConfiguration(_))
        .build

    def repositoryAlreadyExistsException(
      message: Option[String] = None
    ): RepositoryAlreadyExistsException =
      RepositoryAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
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

    def scanNotFoundException(
      message: Option[String] = None
    ): ScanNotFoundException =
      ScanNotFoundException
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

    def startImageScanRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      imageId: Option[ImageIdentifier] = None
    ): StartImageScanRequest =
      StartImageScanRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(imageId)(_.imageId(_))
        .build

    def startImageScanResponse(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      imageId: Option[ImageIdentifier] = None,
      imageScanStatus: Option[ImageScanStatus] = None
    ): StartImageScanResponse =
      StartImageScanResponse
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(imageScanStatus)(_.imageScanStatus(_))
        .build

    def startLifecyclePolicyPreviewRequest(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      lifecyclePolicyText: Option[String] = None
    ): StartLifecyclePolicyPreviewRequest =
      StartLifecyclePolicyPreviewRequest
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(lifecyclePolicyText)(_.lifecyclePolicyText(_))
        .build

    def startLifecyclePolicyPreviewResponse(
      registryId: Option[String] = None,
      repositoryName: Option[String] = None,
      lifecyclePolicyText: Option[String] = None,
      status: Option[String] = None
    ): StartLifecyclePolicyPreviewResponse =
      StartLifecyclePolicyPreviewResponse
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(lifecyclePolicyText)(_.lifecyclePolicyText(_))
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

    def unsupportedImageTypeException(
      message: Option[String] = None
    ): UnsupportedImageTypeException =
      UnsupportedImageTypeException
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

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
