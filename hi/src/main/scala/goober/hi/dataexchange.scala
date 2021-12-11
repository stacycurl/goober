package goober.hi

import goober.free.dataexchange.DataExchangeIO
import software.amazon.awssdk.services.dataexchange.model._


object dataexchange {
  import goober.free.{dataexchange ⇒ free}

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

    def assetDestinationEntry(
      assetId: Option[String] = None,
      bucket: Option[String] = None,
      key: Option[String] = None
    ): AssetDestinationEntry =
      AssetDestinationEntry
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .build

    def assetDetails(
      s3SnapshotAsset: Option[S3SnapshotAsset] = None
    ): AssetDetails =
      AssetDetails
        .builder
        .ifSome(s3SnapshotAsset)(_.s3SnapshotAsset(_))
        .build

    def assetEntry(
      arn: Option[String] = None,
      assetDetails: Option[AssetDetails] = None,
      assetType: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      dataSetId: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      revisionId: Option[String] = None,
      sourceId: Option[String] = None,
      updatedAt: Option[Timestamp] = None
    ): AssetEntry =
      AssetEntry
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(assetDetails)(_.assetDetails(_))
        .ifSome(assetType)(_.assetType(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(sourceId)(_.sourceId(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def assetSourceEntry(
      bucket: Option[String] = None,
      key: Option[String] = None
    ): AssetSourceEntry =
      AssetSourceEntry
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .build

    def cancelJobRequest(
      jobId: Option[String] = None
    ): CancelJobRequest =
      CancelJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
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

    def createDataSetRequest(
      assetType: Option[String] = None,
      description: Option[String] = None,
      name: Option[String] = None,
      tags: Option[MapOf__string] = None
    ): CreateDataSetRequest =
      CreateDataSetRequest
        .builder
        .ifSome(assetType)(_.assetType(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDataSetResponse(
      arn: Option[String] = None,
      assetType: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      description: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      origin: Option[String] = None,
      originDetails: Option[OriginDetails] = None,
      sourceId: Option[String] = None,
      tags: Option[MapOf__string] = None,
      updatedAt: Option[Timestamp] = None
    ): CreateDataSetResponse =
      CreateDataSetResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(assetType)(_.assetType(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(origin)(_.origin(_))
        .ifSome(originDetails)(_.originDetails(_))
        .ifSome(sourceId)(_.sourceId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def createJobRequest(
      details: Option[RequestDetails] = None,
      `type`: Option[String] = None
    ): CreateJobRequest =
      CreateJobRequest
        .builder
        .ifSome(details)(_.details(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def createJobResponse(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      details: Option[ResponseDetails] = None,
      errors: Option[List[JobError]] = None,
      id: Option[String] = None,
      state: Option[String] = None,
      `type`: Option[String] = None,
      updatedAt: Option[Timestamp] = None
    ): CreateJobResponse =
      CreateJobResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(details)(_.details(_))
        .ifSome(errors)(_.errors(_))
        .ifSome(id)(_.id(_))
        .ifSome(state)(_.state(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def createRevisionRequest(
      comment: Option[String] = None,
      dataSetId: Option[String] = None,
      tags: Option[MapOf__string] = None
    ): CreateRevisionRequest =
      CreateRevisionRequest
        .builder
        .ifSome(comment)(_.comment(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRevisionResponse(
      arn: Option[String] = None,
      comment: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      dataSetId: Option[String] = None,
      finalized: Option[Boolean] = None,
      id: Option[String] = None,
      sourceId: Option[String] = None,
      tags: Option[MapOf__string] = None,
      updatedAt: Option[Timestamp] = None
    ): CreateRevisionResponse =
      CreateRevisionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(finalized)(_.finalized(_))
        .ifSome(id)(_.id(_))
        .ifSome(sourceId)(_.sourceId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def dataSetEntry(
      arn: Option[String] = None,
      assetType: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      description: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      origin: Option[String] = None,
      originDetails: Option[OriginDetails] = None,
      sourceId: Option[String] = None,
      updatedAt: Option[Timestamp] = None
    ): DataSetEntry =
      DataSetEntry
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(assetType)(_.assetType(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(origin)(_.origin(_))
        .ifSome(originDetails)(_.originDetails(_))
        .ifSome(sourceId)(_.sourceId(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def deleteAssetRequest(
      assetId: Option[String] = None,
      dataSetId: Option[String] = None,
      revisionId: Option[String] = None
    ): DeleteAssetRequest =
      DeleteAssetRequest
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def deleteDataSetRequest(
      dataSetId: Option[String] = None
    ): DeleteDataSetRequest =
      DeleteDataSetRequest
        .builder
        .ifSome(dataSetId)(_.dataSetId(_))
        .build

    def deleteRevisionRequest(
      dataSetId: Option[String] = None,
      revisionId: Option[String] = None
    ): DeleteRevisionRequest =
      DeleteRevisionRequest
        .builder
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def details(
      importAssetFromSignedUrlJobErrorDetails: Option[ImportAssetFromSignedUrlJobErrorDetails] = None,
      importAssetsFromS3JobErrorDetails: Option[List[AssetSourceEntry]] = None
    ): Details =
      Details
        .builder
        .ifSome(importAssetFromSignedUrlJobErrorDetails)(_.importAssetFromSignedUrlJobErrorDetails(_))
        .ifSome(importAssetsFromS3JobErrorDetails)(_.importAssetsFromS3JobErrorDetails(_))
        .build

    def exportAssetToSignedUrlRequestDetails(
      assetId: Option[String] = None,
      dataSetId: Option[String] = None,
      revisionId: Option[String] = None
    ): ExportAssetToSignedUrlRequestDetails =
      ExportAssetToSignedUrlRequestDetails
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def exportAssetToSignedUrlResponseDetails(
      assetId: Option[String] = None,
      dataSetId: Option[String] = None,
      revisionId: Option[String] = None,
      signedUrl: Option[String] = None,
      signedUrlExpiresAt: Option[Timestamp] = None
    ): ExportAssetToSignedUrlResponseDetails =
      ExportAssetToSignedUrlResponseDetails
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(signedUrl)(_.signedUrl(_))
        .ifSome(signedUrlExpiresAt)(_.signedUrlExpiresAt(_))
        .build

    def exportAssetsToS3RequestDetails(
      assetDestinations: Option[List[AssetDestinationEntry]] = None,
      dataSetId: Option[String] = None,
      encryption: Option[ExportServerSideEncryption] = None,
      revisionId: Option[String] = None
    ): ExportAssetsToS3RequestDetails =
      ExportAssetsToS3RequestDetails
        .builder
        .ifSome(assetDestinations)(_.assetDestinations(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def exportAssetsToS3ResponseDetails(
      assetDestinations: Option[List[AssetDestinationEntry]] = None,
      dataSetId: Option[String] = None,
      encryption: Option[ExportServerSideEncryption] = None,
      revisionId: Option[String] = None
    ): ExportAssetsToS3ResponseDetails =
      ExportAssetsToS3ResponseDetails
        .builder
        .ifSome(assetDestinations)(_.assetDestinations(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def exportRevisionsToS3RequestDetails(
      dataSetId: Option[String] = None,
      encryption: Option[ExportServerSideEncryption] = None,
      revisionDestinations: Option[List[RevisionDestinationEntry]] = None
    ): ExportRevisionsToS3RequestDetails =
      ExportRevisionsToS3RequestDetails
        .builder
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(revisionDestinations)(_.revisionDestinations(_))
        .build

    def exportRevisionsToS3ResponseDetails(
      dataSetId: Option[String] = None,
      encryption: Option[ExportServerSideEncryption] = None,
      revisionDestinations: Option[List[RevisionDestinationEntry]] = None
    ): ExportRevisionsToS3ResponseDetails =
      ExportRevisionsToS3ResponseDetails
        .builder
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(revisionDestinations)(_.revisionDestinations(_))
        .build

    def exportServerSideEncryption(
      kmsKeyArn: Option[String] = None,
      `type`: Option[String] = None
    ): ExportServerSideEncryption =
      ExportServerSideEncryption
        .builder
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def getAssetRequest(
      assetId: Option[String] = None,
      dataSetId: Option[String] = None,
      revisionId: Option[String] = None
    ): GetAssetRequest =
      GetAssetRequest
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def getAssetResponse(
      arn: Option[String] = None,
      assetDetails: Option[AssetDetails] = None,
      assetType: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      dataSetId: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      revisionId: Option[String] = None,
      sourceId: Option[String] = None,
      updatedAt: Option[Timestamp] = None
    ): GetAssetResponse =
      GetAssetResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(assetDetails)(_.assetDetails(_))
        .ifSome(assetType)(_.assetType(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(sourceId)(_.sourceId(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def getDataSetRequest(
      dataSetId: Option[String] = None
    ): GetDataSetRequest =
      GetDataSetRequest
        .builder
        .ifSome(dataSetId)(_.dataSetId(_))
        .build

    def getDataSetResponse(
      arn: Option[String] = None,
      assetType: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      description: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      origin: Option[String] = None,
      originDetails: Option[OriginDetails] = None,
      sourceId: Option[String] = None,
      tags: Option[MapOf__string] = None,
      updatedAt: Option[Timestamp] = None
    ): GetDataSetResponse =
      GetDataSetResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(assetType)(_.assetType(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(origin)(_.origin(_))
        .ifSome(originDetails)(_.originDetails(_))
        .ifSome(sourceId)(_.sourceId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def getJobRequest(
      jobId: Option[String] = None
    ): GetJobRequest =
      GetJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def getJobResponse(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      details: Option[ResponseDetails] = None,
      errors: Option[List[JobError]] = None,
      id: Option[String] = None,
      state: Option[String] = None,
      `type`: Option[String] = None,
      updatedAt: Option[Timestamp] = None
    ): GetJobResponse =
      GetJobResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(details)(_.details(_))
        .ifSome(errors)(_.errors(_))
        .ifSome(id)(_.id(_))
        .ifSome(state)(_.state(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def getRevisionRequest(
      dataSetId: Option[String] = None,
      revisionId: Option[String] = None
    ): GetRevisionRequest =
      GetRevisionRequest
        .builder
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def getRevisionResponse(
      arn: Option[String] = None,
      comment: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      dataSetId: Option[String] = None,
      finalized: Option[Boolean] = None,
      id: Option[String] = None,
      sourceId: Option[String] = None,
      tags: Option[MapOf__string] = None,
      updatedAt: Option[Timestamp] = None
    ): GetRevisionResponse =
      GetRevisionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(finalized)(_.finalized(_))
        .ifSome(id)(_.id(_))
        .ifSome(sourceId)(_.sourceId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def importAssetFromSignedUrlJobErrorDetails(
      assetName: Option[String] = None
    ): ImportAssetFromSignedUrlJobErrorDetails =
      ImportAssetFromSignedUrlJobErrorDetails
        .builder
        .ifSome(assetName)(_.assetName(_))
        .build

    def importAssetFromSignedUrlRequestDetails(
      assetName: Option[String] = None,
      dataSetId: Option[String] = None,
      md5Hash: Option[String] = None,
      revisionId: Option[String] = None
    ): ImportAssetFromSignedUrlRequestDetails =
      ImportAssetFromSignedUrlRequestDetails
        .builder
        .ifSome(assetName)(_.assetName(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(md5Hash)(_.md5Hash(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def importAssetFromSignedUrlResponseDetails(
      assetName: Option[String] = None,
      dataSetId: Option[String] = None,
      md5Hash: Option[String] = None,
      revisionId: Option[String] = None,
      signedUrl: Option[String] = None,
      signedUrlExpiresAt: Option[Timestamp] = None
    ): ImportAssetFromSignedUrlResponseDetails =
      ImportAssetFromSignedUrlResponseDetails
        .builder
        .ifSome(assetName)(_.assetName(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(md5Hash)(_.md5Hash(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(signedUrl)(_.signedUrl(_))
        .ifSome(signedUrlExpiresAt)(_.signedUrlExpiresAt(_))
        .build

    def importAssetsFromS3RequestDetails(
      assetSources: Option[List[AssetSourceEntry]] = None,
      dataSetId: Option[String] = None,
      revisionId: Option[String] = None
    ): ImportAssetsFromS3RequestDetails =
      ImportAssetsFromS3RequestDetails
        .builder
        .ifSome(assetSources)(_.assetSources(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def importAssetsFromS3ResponseDetails(
      assetSources: Option[List[AssetSourceEntry]] = None,
      dataSetId: Option[String] = None,
      revisionId: Option[String] = None
    ): ImportAssetsFromS3ResponseDetails =
      ImportAssetsFromS3ResponseDetails
        .builder
        .ifSome(assetSources)(_.assetSources(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def jobEntry(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      details: Option[ResponseDetails] = None,
      errors: Option[List[JobError]] = None,
      id: Option[String] = None,
      state: Option[String] = None,
      `type`: Option[String] = None,
      updatedAt: Option[Timestamp] = None
    ): JobEntry =
      JobEntry
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(details)(_.details(_))
        .ifSome(errors)(_.errors(_))
        .ifSome(id)(_.id(_))
        .ifSome(state)(_.state(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def jobError(
      code: Option[String] = None,
      details: Option[Details] = None,
      limitName: Option[String] = None,
      limitValue: Option[__double] = None,
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): JobError =
      JobError
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(details)(_.details(_))
        .ifSome(limitName)(_.limitName(_))
        .ifSome(limitValue)(_.limitValue(_))
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def listDataSetRevisionsRequest(
      dataSetId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListDataSetRevisionsRequest =
      ListDataSetRevisionsRequest
        .builder
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDataSetRevisionsResponse(
      nextToken: Option[String] = None,
      revisions: Option[List[RevisionEntry]] = None
    ): ListDataSetRevisionsResponse =
      ListDataSetRevisionsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(revisions)(_.revisions(_))
        .build

    def listDataSetsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      origin: Option[String] = None
    ): ListDataSetsRequest =
      ListDataSetsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(origin)(_.origin(_))
        .build

    def listDataSetsResponse(
      dataSets: Option[List[DataSetEntry]] = None,
      nextToken: Option[String] = None
    ): ListDataSetsResponse =
      ListDataSetsResponse
        .builder
        .ifSome(dataSets)(_.dataSets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJobsRequest(
      dataSetId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      revisionId: Option[String] = None
    ): ListJobsRequest =
      ListJobsRequest
        .builder
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def listJobsResponse(
      jobs: Option[List[JobEntry]] = None,
      nextToken: Option[String] = None
    ): ListJobsResponse =
      ListJobsResponse
        .builder
        .ifSome(jobs)(_.jobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRevisionAssetsRequest(
      dataSetId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      revisionId: Option[String] = None
    ): ListRevisionAssetsRequest =
      ListRevisionAssetsRequest
        .builder
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def listRevisionAssetsResponse(
      assets: Option[List[AssetEntry]] = None,
      nextToken: Option[String] = None
    ): ListRevisionAssetsResponse =
      ListRevisionAssetsResponse
        .builder
        .ifSome(assets)(_.assets(_))
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
      tags: Option[MapOf__string] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def originDetails(
      productId: Option[String] = None
    ): OriginDetails =
      OriginDetails
        .builder
        .ifSome(productId)(_.productId(_))
        .build

    def requestDetails(
      exportAssetToSignedUrl: Option[ExportAssetToSignedUrlRequestDetails] = None,
      exportAssetsToS3: Option[ExportAssetsToS3RequestDetails] = None,
      exportRevisionsToS3: Option[ExportRevisionsToS3RequestDetails] = None,
      importAssetFromSignedUrl: Option[ImportAssetFromSignedUrlRequestDetails] = None,
      importAssetsFromS3: Option[ImportAssetsFromS3RequestDetails] = None
    ): RequestDetails =
      RequestDetails
        .builder
        .ifSome(exportAssetToSignedUrl)(_.exportAssetToSignedUrl(_))
        .ifSome(exportAssetsToS3)(_.exportAssetsToS3(_))
        .ifSome(exportRevisionsToS3)(_.exportRevisionsToS3(_))
        .ifSome(importAssetFromSignedUrl)(_.importAssetFromSignedUrl(_))
        .ifSome(importAssetsFromS3)(_.importAssetsFromS3(_))
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

    def responseDetails(
      exportAssetToSignedUrl: Option[ExportAssetToSignedUrlResponseDetails] = None,
      exportAssetsToS3: Option[ExportAssetsToS3ResponseDetails] = None,
      exportRevisionsToS3: Option[ExportRevisionsToS3ResponseDetails] = None,
      importAssetFromSignedUrl: Option[ImportAssetFromSignedUrlResponseDetails] = None,
      importAssetsFromS3: Option[ImportAssetsFromS3ResponseDetails] = None
    ): ResponseDetails =
      ResponseDetails
        .builder
        .ifSome(exportAssetToSignedUrl)(_.exportAssetToSignedUrl(_))
        .ifSome(exportAssetsToS3)(_.exportAssetsToS3(_))
        .ifSome(exportRevisionsToS3)(_.exportRevisionsToS3(_))
        .ifSome(importAssetFromSignedUrl)(_.importAssetFromSignedUrl(_))
        .ifSome(importAssetsFromS3)(_.importAssetsFromS3(_))
        .build

    def revisionDestinationEntry(
      bucket: Option[String] = None,
      keyPattern: Option[String] = None,
      revisionId: Option[String] = None
    ): RevisionDestinationEntry =
      RevisionDestinationEntry
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(keyPattern)(_.keyPattern(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def revisionEntry(
      arn: Option[String] = None,
      comment: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      dataSetId: Option[String] = None,
      finalized: Option[Boolean] = None,
      id: Option[String] = None,
      sourceId: Option[String] = None,
      updatedAt: Option[Timestamp] = None
    ): RevisionEntry =
      RevisionEntry
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(finalized)(_.finalized(_))
        .ifSome(id)(_.id(_))
        .ifSome(sourceId)(_.sourceId(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def s3SnapshotAsset(
      size: Option[__doubleMin0] = None
    ): S3SnapshotAsset =
      S3SnapshotAsset
        .builder
        .ifSome(size)(_.size(_))
        .build

    def serviceLimitExceededException(
      limitName: Option[String] = None,
      limitValue: Option[__double] = None,
      message: Option[String] = None
    ): ServiceLimitExceededException =
      ServiceLimitExceededException
        .builder
        .ifSome(limitName)(_.limitName(_))
        .ifSome(limitValue)(_.limitValue(_))
        .ifSome(message)(_.message(_))
        .build

    def startJobRequest(
      jobId: Option[String] = None
    ): StartJobRequest =
      StartJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def startJobResponse(

    ): StartJobResponse =
      StartJobResponse
        .builder

        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[MapOf__string] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[__string]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateAssetRequest(
      assetId: Option[String] = None,
      dataSetId: Option[String] = None,
      name: Option[String] = None,
      revisionId: Option[String] = None
    ): UpdateAssetRequest =
      UpdateAssetRequest
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(name)(_.name(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def updateAssetResponse(
      arn: Option[String] = None,
      assetDetails: Option[AssetDetails] = None,
      assetType: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      dataSetId: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      revisionId: Option[String] = None,
      sourceId: Option[String] = None,
      updatedAt: Option[Timestamp] = None
    ): UpdateAssetResponse =
      UpdateAssetResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(assetDetails)(_.assetDetails(_))
        .ifSome(assetType)(_.assetType(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(sourceId)(_.sourceId(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def updateDataSetRequest(
      dataSetId: Option[String] = None,
      description: Option[String] = None,
      name: Option[String] = None
    ): UpdateDataSetRequest =
      UpdateDataSetRequest
        .builder
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .build

    def updateDataSetResponse(
      arn: Option[String] = None,
      assetType: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      description: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      origin: Option[String] = None,
      originDetails: Option[OriginDetails] = None,
      sourceId: Option[String] = None,
      updatedAt: Option[Timestamp] = None
    ): UpdateDataSetResponse =
      UpdateDataSetResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(assetType)(_.assetType(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(origin)(_.origin(_))
        .ifSome(originDetails)(_.originDetails(_))
        .ifSome(sourceId)(_.sourceId(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def updateRevisionRequest(
      comment: Option[String] = None,
      dataSetId: Option[String] = None,
      finalized: Option[Boolean] = None,
      revisionId: Option[String] = None
    ): UpdateRevisionRequest =
      UpdateRevisionRequest
        .builder
        .ifSome(comment)(_.comment(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(finalized)(_.finalized(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def updateRevisionResponse(
      arn: Option[String] = None,
      comment: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      dataSetId: Option[String] = None,
      finalized: Option[Boolean] = None,
      id: Option[String] = None,
      sourceId: Option[String] = None,
      updatedAt: Option[Timestamp] = None
    ): UpdateRevisionResponse =
      UpdateRevisionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(finalized)(_.finalized(_))
        .ifSome(id)(_.id(_))
        .ifSome(sourceId)(_.sourceId(_))
        .ifSome(updatedAt)(_.updatedAt(_))
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
