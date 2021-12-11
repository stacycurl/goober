package goober.hi

import goober.free.macie.MacieIO
import software.amazon.awssdk.services.macie.model._


object macie {
  import goober.free.{macie ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      message: Option[String] = None,
      resourceType: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def associateMemberAccountRequest(
      memberAccountId: Option[String] = None
    ): AssociateMemberAccountRequest =
      AssociateMemberAccountRequest
        .builder
        .ifSome(memberAccountId)(_.memberAccountId(_))
        .build

    def associateS3ResourcesRequest(
      memberAccountId: Option[String] = None,
      s3Resources: Option[List[S3ResourceClassification]] = None
    ): AssociateS3ResourcesRequest =
      AssociateS3ResourcesRequest
        .builder
        .ifSome(memberAccountId)(_.memberAccountId(_))
        .ifSome(s3Resources)(_.s3Resources(_))
        .build

    def classificationType(
      oneTime: Option[String] = None,
      continuous: Option[String] = None
    ): ClassificationType =
      ClassificationType
        .builder
        .ifSome(oneTime)(_.oneTime(_))
        .ifSome(continuous)(_.continuous(_))
        .build

    def classificationTypeUpdate(
      oneTime: Option[String] = None,
      continuous: Option[String] = None
    ): ClassificationTypeUpdate =
      ClassificationTypeUpdate
        .builder
        .ifSome(oneTime)(_.oneTime(_))
        .ifSome(continuous)(_.continuous(_))
        .build

    def disassociateMemberAccountRequest(
      memberAccountId: Option[String] = None
    ): DisassociateMemberAccountRequest =
      DisassociateMemberAccountRequest
        .builder
        .ifSome(memberAccountId)(_.memberAccountId(_))
        .build

    def disassociateS3ResourcesRequest(
      memberAccountId: Option[String] = None,
      associatedS3Resources: Option[List[S3Resource]] = None
    ): DisassociateS3ResourcesRequest =
      DisassociateS3ResourcesRequest
        .builder
        .ifSome(memberAccountId)(_.memberAccountId(_))
        .ifSome(associatedS3Resources)(_.associatedS3Resources(_))
        .build

    def failedS3Resource(
      failedItem: Option[S3Resource] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): FailedS3Resource =
      FailedS3Resource
        .builder
        .ifSome(failedItem)(_.failedItem(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def internalException(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): InternalException =
      InternalException
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def invalidInputException(
      errorCode: Option[String] = None,
      message: Option[String] = None,
      fieldName: Option[String] = None
    ): InvalidInputException =
      InvalidInputException
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .ifSome(fieldName)(_.fieldName(_))
        .build

    def limitExceededException(
      errorCode: Option[String] = None,
      message: Option[String] = None,
      resourceType: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def listMemberAccountsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListMemberAccountsRequest =
      ListMemberAccountsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listS3ResourcesRequest(
      memberAccountId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListS3ResourcesRequest =
      ListS3ResourcesRequest
        .builder
        .ifSome(memberAccountId)(_.memberAccountId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def memberAccount(
      accountId: Option[String] = None
    ): MemberAccount =
      MemberAccount
        .builder
        .ifSome(accountId)(_.accountId(_))
        .build

    def s3Resource(
      bucketName: Option[String] = None,
      prefix: Option[String] = None
    ): S3Resource =
      S3Resource
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(prefix)(_.prefix(_))
        .build

    def s3ResourceClassification(
      bucketName: Option[String] = None,
      prefix: Option[String] = None,
      classificationType: Option[ClassificationType] = None
    ): S3ResourceClassification =
      S3ResourceClassification
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(classificationType)(_.classificationType(_))
        .build

    def s3ResourceClassificationUpdate(
      bucketName: Option[String] = None,
      prefix: Option[String] = None,
      classificationTypeUpdate: Option[ClassificationTypeUpdate] = None
    ): S3ResourceClassificationUpdate =
      S3ResourceClassificationUpdate
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(classificationTypeUpdate)(_.classificationTypeUpdate(_))
        .build

    def updateS3ResourcesRequest(
      memberAccountId: Option[String] = None,
      s3ResourcesUpdate: Option[List[S3ResourceClassificationUpdate]] = None
    ): UpdateS3ResourcesRequest =
      UpdateS3ResourcesRequest
        .builder
        .ifSome(memberAccountId)(_.memberAccountId(_))
        .ifSome(s3ResourcesUpdate)(_.s3ResourcesUpdate(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
