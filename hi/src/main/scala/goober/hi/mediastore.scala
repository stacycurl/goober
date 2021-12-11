package goober.hi

import goober.free.mediastore.MediaStoreIO
import software.amazon.awssdk.services.mediastore.model._


object mediastore {
  import goober.free.{mediastore ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def container(
      endpoint: Option[String] = None,
      creationTime: Option[TimeStamp] = None,
      aRN: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      accessLoggingEnabled: Option[Boolean] = None
    ): Container =
      Container
        .builder
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(aRN)(_.aRN(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(accessLoggingEnabled)(_.accessLoggingEnabled(_))
        .build

    def containerInUseException(
      message: Option[String] = None
    ): ContainerInUseException =
      ContainerInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def containerNotFoundException(
      message: Option[String] = None
    ): ContainerNotFoundException =
      ContainerNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def corsPolicyNotFoundException(
      message: Option[String] = None
    ): CorsPolicyNotFoundException =
      CorsPolicyNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def corsRule(
      allowedOrigins: Option[List[Origin]] = None,
      allowedMethods: Option[List[MethodName]] = None,
      allowedHeaders: Option[List[Header]] = None,
      maxAgeSeconds: Option[Int] = None,
      exposeHeaders: Option[List[Header]] = None
    ): CorsRule =
      CorsRule
        .builder
        .ifSome(allowedOrigins)(_.allowedOrigins(_))
        .ifSome(allowedMethods)(_.allowedMethods(_))
        .ifSome(allowedHeaders)(_.allowedHeaders(_))
        .ifSome(maxAgeSeconds)(_.maxAgeSeconds(_))
        .ifSome(exposeHeaders)(_.exposeHeaders(_))
        .build

    def createContainerInput(
      containerName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateContainerInput =
      CreateContainerInput
        .builder
        .ifSome(containerName)(_.containerName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createContainerOutput(
      container: Option[Container] = None
    ): CreateContainerOutput =
      CreateContainerOutput
        .builder
        .ifSome(container)(_.container(_))
        .build

    def deleteContainerInput(
      containerName: Option[String] = None
    ): DeleteContainerInput =
      DeleteContainerInput
        .builder
        .ifSome(containerName)(_.containerName(_))
        .build

    def deleteContainerOutput(

    ): DeleteContainerOutput =
      DeleteContainerOutput
        .builder

        .build

    def deleteContainerPolicyInput(
      containerName: Option[String] = None
    ): DeleteContainerPolicyInput =
      DeleteContainerPolicyInput
        .builder
        .ifSome(containerName)(_.containerName(_))
        .build

    def deleteContainerPolicyOutput(

    ): DeleteContainerPolicyOutput =
      DeleteContainerPolicyOutput
        .builder

        .build

    def deleteCorsPolicyInput(
      containerName: Option[String] = None
    ): DeleteCorsPolicyInput =
      DeleteCorsPolicyInput
        .builder
        .ifSome(containerName)(_.containerName(_))
        .build

    def deleteCorsPolicyOutput(

    ): DeleteCorsPolicyOutput =
      DeleteCorsPolicyOutput
        .builder

        .build

    def deleteLifecyclePolicyInput(
      containerName: Option[String] = None
    ): DeleteLifecyclePolicyInput =
      DeleteLifecyclePolicyInput
        .builder
        .ifSome(containerName)(_.containerName(_))
        .build

    def deleteLifecyclePolicyOutput(

    ): DeleteLifecyclePolicyOutput =
      DeleteLifecyclePolicyOutput
        .builder

        .build

    def deleteMetricPolicyInput(
      containerName: Option[String] = None
    ): DeleteMetricPolicyInput =
      DeleteMetricPolicyInput
        .builder
        .ifSome(containerName)(_.containerName(_))
        .build

    def deleteMetricPolicyOutput(

    ): DeleteMetricPolicyOutput =
      DeleteMetricPolicyOutput
        .builder

        .build

    def describeContainerInput(
      containerName: Option[String] = None
    ): DescribeContainerInput =
      DescribeContainerInput
        .builder
        .ifSome(containerName)(_.containerName(_))
        .build

    def describeContainerOutput(
      container: Option[Container] = None
    ): DescribeContainerOutput =
      DescribeContainerOutput
        .builder
        .ifSome(container)(_.container(_))
        .build

    def getContainerPolicyInput(
      containerName: Option[String] = None
    ): GetContainerPolicyInput =
      GetContainerPolicyInput
        .builder
        .ifSome(containerName)(_.containerName(_))
        .build

    def getContainerPolicyOutput(
      policy: Option[String] = None
    ): GetContainerPolicyOutput =
      GetContainerPolicyOutput
        .builder
        .ifSome(policy)(_.policy(_))
        .build

    def getCorsPolicyInput(
      containerName: Option[String] = None
    ): GetCorsPolicyInput =
      GetCorsPolicyInput
        .builder
        .ifSome(containerName)(_.containerName(_))
        .build

    def getCorsPolicyOutput(
      corsPolicy: Option[List[CorsRule]] = None
    ): GetCorsPolicyOutput =
      GetCorsPolicyOutput
        .builder
        .ifSome(corsPolicy)(_.corsPolicy(_))
        .build

    def getLifecyclePolicyInput(
      containerName: Option[String] = None
    ): GetLifecyclePolicyInput =
      GetLifecyclePolicyInput
        .builder
        .ifSome(containerName)(_.containerName(_))
        .build

    def getLifecyclePolicyOutput(
      lifecyclePolicy: Option[String] = None
    ): GetLifecyclePolicyOutput =
      GetLifecyclePolicyOutput
        .builder
        .ifSome(lifecyclePolicy)(_.lifecyclePolicy(_))
        .build

    def getMetricPolicyInput(
      containerName: Option[String] = None
    ): GetMetricPolicyInput =
      GetMetricPolicyInput
        .builder
        .ifSome(containerName)(_.containerName(_))
        .build

    def getMetricPolicyOutput(
      metricPolicy: Option[MetricPolicy] = None
    ): GetMetricPolicyOutput =
      GetMetricPolicyOutput
        .builder
        .ifSome(metricPolicy)(_.metricPolicy(_))
        .build

    def internalServerError(
      message: Option[String] = None
    ): InternalServerError =
      InternalServerError
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

    def listContainersInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListContainersInput =
      ListContainersInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listContainersOutput(
      containers: Option[List[Container]] = None,
      nextToken: Option[String] = None
    ): ListContainersOutput =
      ListContainersOutput
        .builder
        .ifSome(containers)(_.containers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceInput(
      resource: Option[String] = None
    ): ListTagsForResourceInput =
      ListTagsForResourceInput
        .builder
        .ifSome(resource)(_.resource(_))
        .build

    def listTagsForResourceOutput(
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceOutput =
      ListTagsForResourceOutput
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def metricPolicy(
      containerLevelMetrics: Option[String] = None,
      metricPolicyRules: Option[List[MetricPolicyRule]] = None
    ): MetricPolicy =
      MetricPolicy
        .builder
        .ifSome(containerLevelMetrics)(_.containerLevelMetrics(_))
        .ifSome(metricPolicyRules)(_.metricPolicyRules(_))
        .build

    def metricPolicyRule(
      objectGroup: Option[String] = None,
      objectGroupName: Option[String] = None
    ): MetricPolicyRule =
      MetricPolicyRule
        .builder
        .ifSome(objectGroup)(_.objectGroup(_))
        .ifSome(objectGroupName)(_.objectGroupName(_))
        .build

    def policyNotFoundException(
      message: Option[String] = None
    ): PolicyNotFoundException =
      PolicyNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def putContainerPolicyInput(
      containerName: Option[String] = None,
      policy: Option[String] = None
    ): PutContainerPolicyInput =
      PutContainerPolicyInput
        .builder
        .ifSome(containerName)(_.containerName(_))
        .ifSome(policy)(_.policy(_))
        .build

    def putContainerPolicyOutput(

    ): PutContainerPolicyOutput =
      PutContainerPolicyOutput
        .builder

        .build

    def putCorsPolicyInput(
      containerName: Option[String] = None,
      corsPolicy: Option[List[CorsRule]] = None
    ): PutCorsPolicyInput =
      PutCorsPolicyInput
        .builder
        .ifSome(containerName)(_.containerName(_))
        .ifSome(corsPolicy)(_.corsPolicy(_))
        .build

    def putCorsPolicyOutput(

    ): PutCorsPolicyOutput =
      PutCorsPolicyOutput
        .builder

        .build

    def putLifecyclePolicyInput(
      containerName: Option[String] = None,
      lifecyclePolicy: Option[String] = None
    ): PutLifecyclePolicyInput =
      PutLifecyclePolicyInput
        .builder
        .ifSome(containerName)(_.containerName(_))
        .ifSome(lifecyclePolicy)(_.lifecyclePolicy(_))
        .build

    def putLifecyclePolicyOutput(

    ): PutLifecyclePolicyOutput =
      PutLifecyclePolicyOutput
        .builder

        .build

    def putMetricPolicyInput(
      containerName: Option[String] = None,
      metricPolicy: Option[MetricPolicy] = None
    ): PutMetricPolicyInput =
      PutMetricPolicyInput
        .builder
        .ifSome(containerName)(_.containerName(_))
        .ifSome(metricPolicy)(_.metricPolicy(_))
        .build

    def putMetricPolicyOutput(

    ): PutMetricPolicyOutput =
      PutMetricPolicyOutput
        .builder

        .build

    def startAccessLoggingInput(
      containerName: Option[String] = None
    ): StartAccessLoggingInput =
      StartAccessLoggingInput
        .builder
        .ifSome(containerName)(_.containerName(_))
        .build

    def startAccessLoggingOutput(

    ): StartAccessLoggingOutput =
      StartAccessLoggingOutput
        .builder

        .build

    def stopAccessLoggingInput(
      containerName: Option[String] = None
    ): StopAccessLoggingInput =
      StopAccessLoggingInput
        .builder
        .ifSome(containerName)(_.containerName(_))
        .build

    def stopAccessLoggingOutput(

    ): StopAccessLoggingOutput =
      StopAccessLoggingOutput
        .builder

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

    def tagResourceInput(
      resource: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceInput =
      TagResourceInput
        .builder
        .ifSome(resource)(_.resource(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceOutput(

    ): TagResourceOutput =
      TagResourceOutput
        .builder

        .build

    def untagResourceInput(
      resource: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceInput =
      UntagResourceInput
        .builder
        .ifSome(resource)(_.resource(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceOutput(

    ): UntagResourceOutput =
      UntagResourceOutput
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
