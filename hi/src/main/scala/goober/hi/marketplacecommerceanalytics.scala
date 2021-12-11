package goober.hi

import goober.free.marketplacecommerceanalytics.MarketplaceCommerceAnalyticsIO
import software.amazon.awssdk.services.marketplacecommerceanalytics.model._


object marketplacecommerceanalytics {
  import goober.free.{marketplacecommerceanalytics ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def generateDataSetRequest(
      dataSetType: Option[String] = None,
      dataSetPublicationDate: Option[DataSetPublicationDate] = None,
      roleNameArn: Option[String] = None,
      destinationS3BucketName: Option[String] = None,
      destinationS3Prefix: Option[String] = None,
      snsTopicArn: Option[String] = None,
      customerDefinedValues: Option[CustomerDefinedValues] = None
    ): GenerateDataSetRequest =
      GenerateDataSetRequest
        .builder
        .ifSome(dataSetType)(_.dataSetType(_))
        .ifSome(dataSetPublicationDate)(_.dataSetPublicationDate(_))
        .ifSome(roleNameArn)(_.roleNameArn(_))
        .ifSome(destinationS3BucketName)(_.destinationS3BucketName(_))
        .ifSome(destinationS3Prefix)(_.destinationS3Prefix(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(customerDefinedValues)(_.customerDefinedValues(_))
        .build

    def marketplaceCommerceAnalyticsException(
      message: Option[String] = None
    ): MarketplaceCommerceAnalyticsException =
      MarketplaceCommerceAnalyticsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def startSupportDataExportRequest(
      dataSetType: Option[String] = None,
      fromDate: Option[FromDate] = None,
      roleNameArn: Option[String] = None,
      destinationS3BucketName: Option[String] = None,
      destinationS3Prefix: Option[String] = None,
      snsTopicArn: Option[String] = None,
      customerDefinedValues: Option[CustomerDefinedValues] = None
    ): StartSupportDataExportRequest =
      StartSupportDataExportRequest
        .builder
        .ifSome(dataSetType)(_.dataSetType(_))
        .ifSome(fromDate)(_.fromDate(_))
        .ifSome(roleNameArn)(_.roleNameArn(_))
        .ifSome(destinationS3BucketName)(_.destinationS3BucketName(_))
        .ifSome(destinationS3Prefix)(_.destinationS3Prefix(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(customerDefinedValues)(_.customerDefinedValues(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
