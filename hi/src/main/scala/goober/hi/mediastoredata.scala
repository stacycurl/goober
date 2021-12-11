package goober.hi

import goober.free.mediastoredata.MediaStoreDataIO
import software.amazon.awssdk.services.mediastoredata.model._


object mediastoredata {
  import goober.free.{mediastoredata ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def containerNotFoundException(
      message: Option[String] = None
    ): ContainerNotFoundException =
      ContainerNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deleteObjectRequest(
      path: Option[String] = None
    ): DeleteObjectRequest =
      DeleteObjectRequest
        .builder
        .ifSome(path)(_.path(_))
        .build

    def deleteObjectResponse(

    ): DeleteObjectResponse =
      DeleteObjectResponse
        .builder

        .build

    def describeObjectRequest(
      path: Option[String] = None
    ): DescribeObjectRequest =
      DescribeObjectRequest
        .builder
        .ifSome(path)(_.path(_))
        .build

    def describeObjectResponse(
      eTag: Option[String] = None,
      contentType: Option[String] = None,
      contentLength: Option[NonNegativeLong] = None,
      cacheControl: Option[String] = None,
      lastModified: Option[TimeStamp] = None
    ): DescribeObjectResponse =
      DescribeObjectResponse
        .builder
        .ifSome(eTag)(_.eTag(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(contentLength)(_.contentLength(_))
        .ifSome(cacheControl)(_.cacheControl(_))
        .ifSome(lastModified)(_.lastModified(_))
        .build

    def getObjectRequest(
      path: Option[String] = None,
      range: Option[String] = None
    ): GetObjectRequest =
      GetObjectRequest
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(range)(_.range(_))
        .build

    def getObjectResponse(
      body: Option[PayloadBlob] = None,
      cacheControl: Option[String] = None,
      contentRange: Option[String] = None,
      contentLength: Option[NonNegativeLong] = None,
      contentType: Option[String] = None,
      eTag: Option[String] = None,
      lastModified: Option[TimeStamp] = None,
      statusCode: Option[Int] = None
    ): GetObjectResponse =
      GetObjectResponse
        .builder
        .ifSome(body)(_.body(_))
        .ifSome(cacheControl)(_.cacheControl(_))
        .ifSome(contentRange)(_.contentRange(_))
        .ifSome(contentLength)(_.contentLength(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(eTag)(_.eTag(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(statusCode)(_.statusCode(_))
        .build

    def internalServerError(
      message: Option[String] = None
    ): InternalServerError =
      InternalServerError
        .builder
        .ifSome(message)(_.message(_))
        .build

    def item(
      name: Option[String] = None,
      `type`: Option[String] = None,
      eTag: Option[String] = None,
      lastModified: Option[TimeStamp] = None,
      contentType: Option[String] = None,
      contentLength: Option[NonNegativeLong] = None
    ): Item =
      Item
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(eTag)(_.eTag(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(contentLength)(_.contentLength(_))
        .build

    def listItemsRequest(
      path: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListItemsRequest =
      ListItemsRequest
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listItemsResponse(
      items: Option[List[Item]] = None,
      nextToken: Option[String] = None
    ): ListItemsResponse =
      ListItemsResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def objectNotFoundException(
      message: Option[String] = None
    ): ObjectNotFoundException =
      ObjectNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def putObjectRequest(
      body: Option[PayloadBlob] = None,
      path: Option[String] = None,
      contentType: Option[String] = None,
      cacheControl: Option[String] = None,
      storageClass: Option[String] = None,
      uploadAvailability: Option[String] = None
    ): PutObjectRequest =
      PutObjectRequest
        .builder
        .ifSome(body)(_.body(_))
        .ifSome(path)(_.path(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(cacheControl)(_.cacheControl(_))
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(uploadAvailability)(_.uploadAvailability(_))
        .build

    def putObjectResponse(
      contentSHA256: Option[String] = None,
      eTag: Option[String] = None,
      storageClass: Option[String] = None
    ): PutObjectResponse =
      PutObjectResponse
        .builder
        .ifSome(contentSHA256)(_.contentSHA256(_))
        .ifSome(eTag)(_.eTag(_))
        .ifSome(storageClass)(_.storageClass(_))
        .build

    def requestedRangeNotSatisfiableException(
      message: Option[String] = None
    ): RequestedRangeNotSatisfiableException =
      RequestedRangeNotSatisfiableException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
