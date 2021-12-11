package goober.hi

import goober.free.glacier.GlacierIO
import software.amazon.awssdk.services.glacier.model._


object glacier {
  import goober.free.{glacier ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def abortMultipartUploadInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None,
      uploadId: Option[String] = None
    ): AbortMultipartUploadInput =
      AbortMultipartUploadInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .ifSome(uploadId)(_.uploadId(_))
        .build

    def abortVaultLockInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None
    ): AbortVaultLockInput =
      AbortVaultLockInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .build

    def addTagsToVaultInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None,
      tags: Option[TagMap] = None
    ): AddTagsToVaultInput =
      AddTagsToVaultInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def archiveCreationOutput(
      location: Option[String] = None,
      checksum: Option[String] = None,
      archiveId: Option[String] = None
    ): ArchiveCreationOutput =
      ArchiveCreationOutput
        .builder
        .ifSome(location)(_.location(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(archiveId)(_.archiveId(_))
        .build

    def cSVInput(
      fileHeaderInfo: Option[String] = None,
      comments: Option[String] = None,
      quoteEscapeCharacter: Option[String] = None,
      recordDelimiter: Option[String] = None,
      fieldDelimiter: Option[String] = None,
      quoteCharacter: Option[String] = None
    ): CSVInput =
      CSVInput
        .builder
        .ifSome(fileHeaderInfo)(_.fileHeaderInfo(_))
        .ifSome(comments)(_.comments(_))
        .ifSome(quoteEscapeCharacter)(_.quoteEscapeCharacter(_))
        .ifSome(recordDelimiter)(_.recordDelimiter(_))
        .ifSome(fieldDelimiter)(_.fieldDelimiter(_))
        .ifSome(quoteCharacter)(_.quoteCharacter(_))
        .build

    def cSVOutput(
      quoteFields: Option[String] = None,
      quoteEscapeCharacter: Option[String] = None,
      recordDelimiter: Option[String] = None,
      fieldDelimiter: Option[String] = None,
      quoteCharacter: Option[String] = None
    ): CSVOutput =
      CSVOutput
        .builder
        .ifSome(quoteFields)(_.quoteFields(_))
        .ifSome(quoteEscapeCharacter)(_.quoteEscapeCharacter(_))
        .ifSome(recordDelimiter)(_.recordDelimiter(_))
        .ifSome(fieldDelimiter)(_.fieldDelimiter(_))
        .ifSome(quoteCharacter)(_.quoteCharacter(_))
        .build

    def completeMultipartUploadInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None,
      uploadId: Option[String] = None,
      archiveSize: Option[String] = None,
      checksum: Option[String] = None
    ): CompleteMultipartUploadInput =
      CompleteMultipartUploadInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .ifSome(uploadId)(_.uploadId(_))
        .ifSome(archiveSize)(_.archiveSize(_))
        .ifSome(checksum)(_.checksum(_))
        .build

    def completeVaultLockInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None,
      lockId: Option[String] = None
    ): CompleteVaultLockInput =
      CompleteVaultLockInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .ifSome(lockId)(_.lockId(_))
        .build

    def createVaultInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None
    ): CreateVaultInput =
      CreateVaultInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .build

    def createVaultOutput(
      location: Option[String] = None
    ): CreateVaultOutput =
      CreateVaultOutput
        .builder
        .ifSome(location)(_.location(_))
        .build

    def dataRetrievalPolicy(
      rules: Option[List[DataRetrievalRule]] = None
    ): DataRetrievalPolicy =
      DataRetrievalPolicy
        .builder
        .ifSome(rules)(_.rules(_))
        .build

    def dataRetrievalRule(
      strategy: Option[String] = None,
      bytesPerHour: Option[NullableLong] = None
    ): DataRetrievalRule =
      DataRetrievalRule
        .builder
        .ifSome(strategy)(_.strategy(_))
        .ifSome(bytesPerHour)(_.bytesPerHour(_))
        .build

    def deleteArchiveInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None,
      archiveId: Option[String] = None
    ): DeleteArchiveInput =
      DeleteArchiveInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .ifSome(archiveId)(_.archiveId(_))
        .build

    def deleteVaultAccessPolicyInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None
    ): DeleteVaultAccessPolicyInput =
      DeleteVaultAccessPolicyInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .build

    def deleteVaultInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None
    ): DeleteVaultInput =
      DeleteVaultInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .build

    def deleteVaultNotificationsInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None
    ): DeleteVaultNotificationsInput =
      DeleteVaultNotificationsInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .build

    def describeJobInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None,
      jobId: Option[String] = None
    ): DescribeJobInput =
      DescribeJobInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeVaultInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None
    ): DescribeVaultInput =
      DescribeVaultInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .build

    def describeVaultOutput(
      vaultARN: Option[String] = None,
      vaultName: Option[String] = None,
      creationDate: Option[String] = None,
      lastInventoryDate: Option[String] = None,
      numberOfArchives: Option[long] = None,
      sizeInBytes: Option[long] = None
    ): DescribeVaultOutput =
      DescribeVaultOutput
        .builder
        .ifSome(vaultARN)(_.vaultARN(_))
        .ifSome(vaultName)(_.vaultName(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastInventoryDate)(_.lastInventoryDate(_))
        .ifSome(numberOfArchives)(_.numberOfArchives(_))
        .ifSome(sizeInBytes)(_.sizeInBytes(_))
        .build

    def encryption(
      encryptionType: Option[String] = None,
      kMSKeyId: Option[String] = None,
      kMSContext: Option[String] = None
    ): Encryption =
      Encryption
        .builder
        .ifSome(encryptionType)(_.encryptionType(_))
        .ifSome(kMSKeyId)(_.kMSKeyId(_))
        .ifSome(kMSContext)(_.kMSContext(_))
        .build

    def getDataRetrievalPolicyInput(
      accountId: Option[String] = None
    ): GetDataRetrievalPolicyInput =
      GetDataRetrievalPolicyInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .build

    def getDataRetrievalPolicyOutput(
      policy: Option[DataRetrievalPolicy] = None
    ): GetDataRetrievalPolicyOutput =
      GetDataRetrievalPolicyOutput
        .builder
        .ifSome(policy)(_.policy(_))
        .build

    def getJobOutputInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None,
      jobId: Option[String] = None,
      range: Option[String] = None
    ): GetJobOutputInput =
      GetJobOutputInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(range)(_.range(_))
        .build

    def getJobOutputOutput(
      body: Option[Stream] = None,
      checksum: Option[String] = None,
      status: Option[Int] = None,
      contentRange: Option[String] = None,
      acceptRanges: Option[String] = None,
      contentType: Option[String] = None,
      archiveDescription: Option[String] = None
    ): GetJobOutputOutput =
      GetJobOutputOutput
        .builder
        .ifSome(body)(_.body(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(status)(_.status(_))
        .ifSome(contentRange)(_.contentRange(_))
        .ifSome(acceptRanges)(_.acceptRanges(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(archiveDescription)(_.archiveDescription(_))
        .build

    def getVaultAccessPolicyInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None
    ): GetVaultAccessPolicyInput =
      GetVaultAccessPolicyInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .build

    def getVaultAccessPolicyOutput(
      policy: Option[VaultAccessPolicy] = None
    ): GetVaultAccessPolicyOutput =
      GetVaultAccessPolicyOutput
        .builder
        .ifSome(policy)(_.policy(_))
        .build

    def getVaultLockInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None
    ): GetVaultLockInput =
      GetVaultLockInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .build

    def getVaultLockOutput(
      policy: Option[String] = None,
      state: Option[String] = None,
      expirationDate: Option[String] = None,
      creationDate: Option[String] = None
    ): GetVaultLockOutput =
      GetVaultLockOutput
        .builder
        .ifSome(policy)(_.policy(_))
        .ifSome(state)(_.state(_))
        .ifSome(expirationDate)(_.expirationDate(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def getVaultNotificationsInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None
    ): GetVaultNotificationsInput =
      GetVaultNotificationsInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .build

    def getVaultNotificationsOutput(
      vaultNotificationConfig: Option[VaultNotificationConfig] = None
    ): GetVaultNotificationsOutput =
      GetVaultNotificationsOutput
        .builder
        .ifSome(vaultNotificationConfig)(_.vaultNotificationConfig(_))
        .build

    def glacierJobDescription(
      jobId: Option[String] = None,
      jobDescription: Option[String] = None,
      action: Option[String] = None,
      archiveId: Option[String] = None,
      vaultARN: Option[String] = None,
      creationDate: Option[String] = None,
      completed: Option[Boolean] = None,
      statusCode: Option[String] = None,
      statusMessage: Option[String] = None,
      archiveSizeInBytes: Option[Size] = None,
      inventorySizeInBytes: Option[Size] = None,
      sNSTopic: Option[String] = None,
      completionDate: Option[String] = None,
      sHA256TreeHash: Option[String] = None,
      archiveSHA256TreeHash: Option[String] = None,
      retrievalByteRange: Option[String] = None,
      tier: Option[String] = None,
      inventoryRetrievalParameters: Option[InventoryRetrievalJobDescription] = None,
      jobOutputPath: Option[String] = None,
      selectParameters: Option[SelectParameters] = None,
      outputLocation: Option[OutputLocation] = None
    ): GlacierJobDescription =
      GlacierJobDescription
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobDescription)(_.jobDescription(_))
        .ifSome(action)(_.action(_))
        .ifSome(archiveId)(_.archiveId(_))
        .ifSome(vaultARN)(_.vaultARN(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(completed)(_.completed(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(archiveSizeInBytes)(_.archiveSizeInBytes(_))
        .ifSome(inventorySizeInBytes)(_.inventorySizeInBytes(_))
        .ifSome(sNSTopic)(_.sNSTopic(_))
        .ifSome(completionDate)(_.completionDate(_))
        .ifSome(sHA256TreeHash)(_.sHA256TreeHash(_))
        .ifSome(archiveSHA256TreeHash)(_.archiveSHA256TreeHash(_))
        .ifSome(retrievalByteRange)(_.retrievalByteRange(_))
        .ifSome(tier)(_.tier(_))
        .ifSome(inventoryRetrievalParameters)(_.inventoryRetrievalParameters(_))
        .ifSome(jobOutputPath)(_.jobOutputPath(_))
        .ifSome(selectParameters)(_.selectParameters(_))
        .ifSome(outputLocation)(_.outputLocation(_))
        .build

    def grant(
      grantee: Option[Grantee] = None,
      permission: Option[String] = None
    ): Grant =
      Grant
        .builder
        .ifSome(grantee)(_.grantee(_))
        .ifSome(permission)(_.permission(_))
        .build

    def grantee(
      `type`: Option[String] = None,
      displayName: Option[String] = None,
      uRI: Option[String] = None,
      iD: Option[String] = None,
      emailAddress: Option[String] = None
    ): Grantee =
      Grantee
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(uRI)(_.uRI(_))
        .ifSome(iD)(_.iD(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .build

    def initiateJobInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None,
      jobParameters: Option[JobParameters] = None
    ): InitiateJobInput =
      InitiateJobInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .ifSome(jobParameters)(_.jobParameters(_))
        .build

    def initiateJobOutput(
      location: Option[String] = None,
      jobId: Option[String] = None,
      jobOutputPath: Option[String] = None
    ): InitiateJobOutput =
      InitiateJobOutput
        .builder
        .ifSome(location)(_.location(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobOutputPath)(_.jobOutputPath(_))
        .build

    def initiateMultipartUploadInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None,
      archiveDescription: Option[String] = None,
      partSize: Option[String] = None
    ): InitiateMultipartUploadInput =
      InitiateMultipartUploadInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .ifSome(archiveDescription)(_.archiveDescription(_))
        .ifSome(partSize)(_.partSize(_))
        .build

    def initiateMultipartUploadOutput(
      location: Option[String] = None,
      uploadId: Option[String] = None
    ): InitiateMultipartUploadOutput =
      InitiateMultipartUploadOutput
        .builder
        .ifSome(location)(_.location(_))
        .ifSome(uploadId)(_.uploadId(_))
        .build

    def initiateVaultLockInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None,
      policy: Option[VaultLockPolicy] = None
    ): InitiateVaultLockInput =
      InitiateVaultLockInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .ifSome(policy)(_.policy(_))
        .build

    def initiateVaultLockOutput(
      lockId: Option[String] = None
    ): InitiateVaultLockOutput =
      InitiateVaultLockOutput
        .builder
        .ifSome(lockId)(_.lockId(_))
        .build

    def inputSerialization(
      csv: Option[CSVInput] = None
    ): InputSerialization =
      InputSerialization
        .builder
        .ifSome(csv)(_.csv(_))
        .build

    def insufficientCapacityException(
      `type`: Option[String] = None,
      code: Option[String] = None,
      message: Option[String] = None
    ): InsufficientCapacityException =
      InsufficientCapacityException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def invalidParameterValueException(
      `type`: Option[String] = None,
      code: Option[String] = None,
      message: Option[String] = None
    ): InvalidParameterValueException =
      InvalidParameterValueException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def inventoryRetrievalJobDescription(
      format: Option[String] = None,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      limit: Option[String] = None,
      marker: Option[String] = None
    ): InventoryRetrievalJobDescription =
      InventoryRetrievalJobDescription
        .builder
        .ifSome(format)(_.format(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(endDate)(_.endDate(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(marker)(_.marker(_))
        .build

    def inventoryRetrievalJobInput(
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      limit: Option[String] = None,
      marker: Option[String] = None
    ): InventoryRetrievalJobInput =
      InventoryRetrievalJobInput
        .builder
        .ifSome(startDate)(_.startDate(_))
        .ifSome(endDate)(_.endDate(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(marker)(_.marker(_))
        .build

    def jobParameters(
      format: Option[String] = None,
      `type`: Option[String] = None,
      archiveId: Option[String] = None,
      description: Option[String] = None,
      sNSTopic: Option[String] = None,
      retrievalByteRange: Option[String] = None,
      tier: Option[String] = None,
      inventoryRetrievalParameters: Option[InventoryRetrievalJobInput] = None,
      selectParameters: Option[SelectParameters] = None,
      outputLocation: Option[OutputLocation] = None
    ): JobParameters =
      JobParameters
        .builder
        .ifSome(format)(_.format(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(archiveId)(_.archiveId(_))
        .ifSome(description)(_.description(_))
        .ifSome(sNSTopic)(_.sNSTopic(_))
        .ifSome(retrievalByteRange)(_.retrievalByteRange(_))
        .ifSome(tier)(_.tier(_))
        .ifSome(inventoryRetrievalParameters)(_.inventoryRetrievalParameters(_))
        .ifSome(selectParameters)(_.selectParameters(_))
        .ifSome(outputLocation)(_.outputLocation(_))
        .build

    def limitExceededException(
      `type`: Option[String] = None,
      code: Option[String] = None,
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def listJobsInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None,
      limit: Option[String] = None,
      marker: Option[String] = None,
      statuscode: Option[String] = None,
      completed: Option[String] = None
    ): ListJobsInput =
      ListJobsInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(statuscode)(_.statuscode(_))
        .ifSome(completed)(_.completed(_))
        .build

    def listJobsOutput(
      jobList: Option[List[GlacierJobDescription]] = None,
      marker: Option[String] = None
    ): ListJobsOutput =
      ListJobsOutput
        .builder
        .ifSome(jobList)(_.jobList(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listMultipartUploadsInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None,
      marker: Option[String] = None,
      limit: Option[String] = None
    ): ListMultipartUploadsInput =
      ListMultipartUploadsInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listMultipartUploadsOutput(
      uploadsList: Option[List[UploadListElement]] = None,
      marker: Option[String] = None
    ): ListMultipartUploadsOutput =
      ListMultipartUploadsOutput
        .builder
        .ifSome(uploadsList)(_.uploadsList(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listPartsInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None,
      uploadId: Option[String] = None,
      marker: Option[String] = None,
      limit: Option[String] = None
    ): ListPartsInput =
      ListPartsInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .ifSome(uploadId)(_.uploadId(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listPartsOutput(
      multipartUploadId: Option[String] = None,
      vaultARN: Option[String] = None,
      archiveDescription: Option[String] = None,
      partSizeInBytes: Option[long] = None,
      creationDate: Option[String] = None,
      parts: Option[List[PartListElement]] = None,
      marker: Option[String] = None
    ): ListPartsOutput =
      ListPartsOutput
        .builder
        .ifSome(multipartUploadId)(_.multipartUploadId(_))
        .ifSome(vaultARN)(_.vaultARN(_))
        .ifSome(archiveDescription)(_.archiveDescription(_))
        .ifSome(partSizeInBytes)(_.partSizeInBytes(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(parts)(_.parts(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listProvisionedCapacityInput(
      accountId: Option[String] = None
    ): ListProvisionedCapacityInput =
      ListProvisionedCapacityInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .build

    def listProvisionedCapacityOutput(
      provisionedCapacityList: Option[List[ProvisionedCapacityDescription]] = None
    ): ListProvisionedCapacityOutput =
      ListProvisionedCapacityOutput
        .builder
        .ifSome(provisionedCapacityList)(_.provisionedCapacityList(_))
        .build

    def listTagsForVaultInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None
    ): ListTagsForVaultInput =
      ListTagsForVaultInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .build

    def listTagsForVaultOutput(
      tags: Option[TagMap] = None
    ): ListTagsForVaultOutput =
      ListTagsForVaultOutput
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listVaultsInput(
      accountId: Option[String] = None,
      marker: Option[String] = None,
      limit: Option[String] = None
    ): ListVaultsInput =
      ListVaultsInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listVaultsOutput(
      vaultList: Option[List[DescribeVaultOutput]] = None,
      marker: Option[String] = None
    ): ListVaultsOutput =
      ListVaultsOutput
        .builder
        .ifSome(vaultList)(_.vaultList(_))
        .ifSome(marker)(_.marker(_))
        .build

    def missingParameterValueException(
      `type`: Option[String] = None,
      code: Option[String] = None,
      message: Option[String] = None
    ): MissingParameterValueException =
      MissingParameterValueException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def outputLocation(
      s3: Option[S3Location] = None
    ): OutputLocation =
      OutputLocation
        .builder
        .ifSome(s3)(_.s3(_))
        .build

    def outputSerialization(
      csv: Option[CSVOutput] = None
    ): OutputSerialization =
      OutputSerialization
        .builder
        .ifSome(csv)(_.csv(_))
        .build

    def partListElement(
      rangeInBytes: Option[String] = None,
      sHA256TreeHash: Option[String] = None
    ): PartListElement =
      PartListElement
        .builder
        .ifSome(rangeInBytes)(_.rangeInBytes(_))
        .ifSome(sHA256TreeHash)(_.sHA256TreeHash(_))
        .build

    def policyEnforcedException(
      `type`: Option[String] = None,
      code: Option[String] = None,
      message: Option[String] = None
    ): PolicyEnforcedException =
      PolicyEnforcedException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def provisionedCapacityDescription(
      capacityId: Option[String] = None,
      startDate: Option[String] = None,
      expirationDate: Option[String] = None
    ): ProvisionedCapacityDescription =
      ProvisionedCapacityDescription
        .builder
        .ifSome(capacityId)(_.capacityId(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(expirationDate)(_.expirationDate(_))
        .build

    def purchaseProvisionedCapacityInput(
      accountId: Option[String] = None
    ): PurchaseProvisionedCapacityInput =
      PurchaseProvisionedCapacityInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .build

    def purchaseProvisionedCapacityOutput(
      capacityId: Option[String] = None
    ): PurchaseProvisionedCapacityOutput =
      PurchaseProvisionedCapacityOutput
        .builder
        .ifSome(capacityId)(_.capacityId(_))
        .build

    def removeTagsFromVaultInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None,
      tagKeys: Option[List[string]] = None
    ): RemoveTagsFromVaultInput =
      RemoveTagsFromVaultInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def requestTimeoutException(
      `type`: Option[String] = None,
      code: Option[String] = None,
      message: Option[String] = None
    ): RequestTimeoutException =
      RequestTimeoutException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFoundException(
      `type`: Option[String] = None,
      code: Option[String] = None,
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def s3Location(
      bucketName: Option[String] = None,
      prefix: Option[String] = None,
      encryption: Option[Encryption] = None,
      cannedACL: Option[String] = None,
      accessControlList: Option[List[Grant]] = None,
      tagging: Option[hashmap] = None,
      userMetadata: Option[hashmap] = None,
      storageClass: Option[String] = None
    ): S3Location =
      S3Location
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(cannedACL)(_.cannedACL(_))
        .ifSome(accessControlList)(_.accessControlList(_))
        .ifSome(tagging)(_.tagging(_))
        .ifSome(userMetadata)(_.userMetadata(_))
        .ifSome(storageClass)(_.storageClass(_))
        .build

    def selectParameters(
      inputSerialization: Option[InputSerialization] = None,
      expressionType: Option[String] = None,
      expression: Option[String] = None,
      outputSerialization: Option[OutputSerialization] = None
    ): SelectParameters =
      SelectParameters
        .builder
        .ifSome(inputSerialization)(_.inputSerialization(_))
        .ifSome(expressionType)(_.expressionType(_))
        .ifSome(expression)(_.expression(_))
        .ifSome(outputSerialization)(_.outputSerialization(_))
        .build

    def serviceUnavailableException(
      `type`: Option[String] = None,
      code: Option[String] = None,
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def setDataRetrievalPolicyInput(
      accountId: Option[String] = None,
      policy: Option[DataRetrievalPolicy] = None
    ): SetDataRetrievalPolicyInput =
      SetDataRetrievalPolicyInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(policy)(_.policy(_))
        .build

    def setVaultAccessPolicyInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None,
      policy: Option[VaultAccessPolicy] = None
    ): SetVaultAccessPolicyInput =
      SetVaultAccessPolicyInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .ifSome(policy)(_.policy(_))
        .build

    def setVaultNotificationsInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None,
      vaultNotificationConfig: Option[VaultNotificationConfig] = None
    ): SetVaultNotificationsInput =
      SetVaultNotificationsInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .ifSome(vaultNotificationConfig)(_.vaultNotificationConfig(_))
        .build

    def uploadArchiveInput(
      vaultName: Option[String] = None,
      accountId: Option[String] = None,
      archiveDescription: Option[String] = None,
      checksum: Option[String] = None,
      body: Option[Stream] = None
    ): UploadArchiveInput =
      UploadArchiveInput
        .builder
        .ifSome(vaultName)(_.vaultName(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(archiveDescription)(_.archiveDescription(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(body)(_.body(_))
        .build

    def uploadListElement(
      multipartUploadId: Option[String] = None,
      vaultARN: Option[String] = None,
      archiveDescription: Option[String] = None,
      partSizeInBytes: Option[long] = None,
      creationDate: Option[String] = None
    ): UploadListElement =
      UploadListElement
        .builder
        .ifSome(multipartUploadId)(_.multipartUploadId(_))
        .ifSome(vaultARN)(_.vaultARN(_))
        .ifSome(archiveDescription)(_.archiveDescription(_))
        .ifSome(partSizeInBytes)(_.partSizeInBytes(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def uploadMultipartPartInput(
      accountId: Option[String] = None,
      vaultName: Option[String] = None,
      uploadId: Option[String] = None,
      checksum: Option[String] = None,
      range: Option[String] = None,
      body: Option[Stream] = None
    ): UploadMultipartPartInput =
      UploadMultipartPartInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(vaultName)(_.vaultName(_))
        .ifSome(uploadId)(_.uploadId(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(range)(_.range(_))
        .ifSome(body)(_.body(_))
        .build

    def uploadMultipartPartOutput(
      checksum: Option[String] = None
    ): UploadMultipartPartOutput =
      UploadMultipartPartOutput
        .builder
        .ifSome(checksum)(_.checksum(_))
        .build

    def vaultAccessPolicy(
      policy: Option[String] = None
    ): VaultAccessPolicy =
      VaultAccessPolicy
        .builder
        .ifSome(policy)(_.policy(_))
        .build

    def vaultLockPolicy(
      policy: Option[String] = None
    ): VaultLockPolicy =
      VaultLockPolicy
        .builder
        .ifSome(policy)(_.policy(_))
        .build

    def vaultNotificationConfig(
      sNSTopic: Option[String] = None,
      events: Option[List[string]] = None
    ): VaultNotificationConfig =
      VaultNotificationConfig
        .builder
        .ifSome(sNSTopic)(_.sNSTopic(_))
        .ifSome(events)(_.events(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
