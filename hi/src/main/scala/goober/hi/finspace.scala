package goober.hi

import goober.free.finspace.FinspaceIO
import software.amazon.awssdk.services.finspace.model._


object finspace {
  import goober.free.{finspace ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(

    ): AccessDeniedException =
      AccessDeniedException
        .builder

        .build

    def createEnvironmentRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      kmsKeyId: Option[String] = None,
      tags: Option[TagMap] = None,
      federationMode: Option[String] = None,
      federationParameters: Option[FederationParameters] = None
    ): CreateEnvironmentRequest =
      CreateEnvironmentRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(federationMode)(_.federationMode(_))
        .ifSome(federationParameters)(_.federationParameters(_))
        .build

    def createEnvironmentResponse(
      environmentId: Option[String] = None,
      environmentArn: Option[String] = None,
      environmentUrl: Option[String] = None
    ): CreateEnvironmentResponse =
      CreateEnvironmentResponse
        .builder
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(environmentArn)(_.environmentArn(_))
        .ifSome(environmentUrl)(_.environmentUrl(_))
        .build

    def deleteEnvironmentRequest(
      environmentId: Option[String] = None
    ): DeleteEnvironmentRequest =
      DeleteEnvironmentRequest
        .builder
        .ifSome(environmentId)(_.environmentId(_))
        .build

    def deleteEnvironmentResponse(

    ): DeleteEnvironmentResponse =
      DeleteEnvironmentResponse
        .builder

        .build

    def environment(
      name: Option[String] = None,
      environmentId: Option[String] = None,
      awsAccountId: Option[String] = None,
      status: Option[String] = None,
      environmentUrl: Option[String] = None,
      description: Option[String] = None,
      environmentArn: Option[String] = None,
      sageMakerStudioDomainUrl: Option[String] = None,
      kmsKeyId: Option[String] = None,
      dedicatedServiceAccountId: Option[String] = None,
      federationMode: Option[String] = None,
      federationParameters: Option[FederationParameters] = None
    ): Environment =
      Environment
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(status)(_.status(_))
        .ifSome(environmentUrl)(_.environmentUrl(_))
        .ifSome(description)(_.description(_))
        .ifSome(environmentArn)(_.environmentArn(_))
        .ifSome(sageMakerStudioDomainUrl)(_.sageMakerStudioDomainUrl(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(dedicatedServiceAccountId)(_.dedicatedServiceAccountId(_))
        .ifSome(federationMode)(_.federationMode(_))
        .ifSome(federationParameters)(_.federationParameters(_))
        .build

    def federationParameters(
      samlMetadataDocument: Option[String] = None,
      samlMetadataURL: Option[String] = None,
      applicationCallBackURL: Option[String] = None,
      federationURN: Option[String] = None,
      federationProviderName: Option[String] = None,
      attributeMap: Option[AttributeMap] = None
    ): FederationParameters =
      FederationParameters
        .builder
        .ifSome(samlMetadataDocument)(_.samlMetadataDocument(_))
        .ifSome(samlMetadataURL)(_.samlMetadataURL(_))
        .ifSome(applicationCallBackURL)(_.applicationCallBackURL(_))
        .ifSome(federationURN)(_.federationURN(_))
        .ifSome(federationProviderName)(_.federationProviderName(_))
        .ifSome(attributeMap)(_.attributeMap(_))
        .build

    def getEnvironmentRequest(
      environmentId: Option[String] = None
    ): GetEnvironmentRequest =
      GetEnvironmentRequest
        .builder
        .ifSome(environmentId)(_.environmentId(_))
        .build

    def getEnvironmentResponse(
      environment: Option[Environment] = None
    ): GetEnvironmentResponse =
      GetEnvironmentResponse
        .builder
        .ifSome(environment)(_.environment(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRequestException(
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
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

    def listEnvironmentsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListEnvironmentsRequest =
      ListEnvironmentsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listEnvironmentsResponse(
      environments: Option[List[Environment]] = None,
      nextToken: Option[String] = None
    ): ListEnvironmentsResponse =
      ListEnvironmentsResponse
        .builder
        .ifSome(environments)(_.environments(_))
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

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
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

    def throttlingException(

    ): ThrottlingException =
      ThrottlingException
        .builder

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

    def updateEnvironmentRequest(
      environmentId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      federationMode: Option[String] = None,
      federationParameters: Option[FederationParameters] = None
    ): UpdateEnvironmentRequest =
      UpdateEnvironmentRequest
        .builder
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(federationMode)(_.federationMode(_))
        .ifSome(federationParameters)(_.federationParameters(_))
        .build

    def updateEnvironmentResponse(
      environment: Option[Environment] = None
    ): UpdateEnvironmentResponse =
      UpdateEnvironmentResponse
        .builder
        .ifSome(environment)(_.environment(_))
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
