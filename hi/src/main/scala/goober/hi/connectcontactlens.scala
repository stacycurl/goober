package goober.hi

import goober.free.connectcontactlens.ConnectContactLensIO
import software.amazon.awssdk.services.connectcontactlens.model._


object connectcontactlens {
  import goober.free.{connectcontactlens ⇒ free}

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

    def categories(
      matchedCategories: Option[List[CategoryName]] = None,
      matchedDetails: Option[MatchedDetails] = None
    ): Categories =
      Categories
        .builder
        .ifSome(matchedCategories)(_.matchedCategories(_))
        .ifSome(matchedDetails)(_.matchedDetails(_))
        .build

    def categoryDetails(
      pointsOfInterest: Option[List[PointOfInterest]] = None
    ): CategoryDetails =
      CategoryDetails
        .builder
        .ifSome(pointsOfInterest)(_.pointsOfInterest(_))
        .build

    def characterOffsets(
      beginOffsetChar: Option[Int] = None,
      endOffsetChar: Option[Int] = None
    ): CharacterOffsets =
      CharacterOffsets
        .builder
        .ifSome(beginOffsetChar)(_.beginOffsetChar(_))
        .ifSome(endOffsetChar)(_.endOffsetChar(_))
        .build

    def internalServiceException(
      message: Option[String] = None
    ): InternalServiceException =
      InternalServiceException
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

    def issueDetected(
      characterOffsets: Option[CharacterOffsets] = None
    ): IssueDetected =
      IssueDetected
        .builder
        .ifSome(characterOffsets)(_.characterOffsets(_))
        .build

    def listRealtimeContactAnalysisSegmentsRequest(
      instanceId: Option[String] = None,
      contactId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListRealtimeContactAnalysisSegmentsRequest =
      ListRealtimeContactAnalysisSegmentsRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(contactId)(_.contactId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRealtimeContactAnalysisSegmentsResponse(
      segments: Option[List[RealtimeContactAnalysisSegment]] = None,
      nextToken: Option[String] = None
    ): ListRealtimeContactAnalysisSegmentsResponse =
      ListRealtimeContactAnalysisSegmentsResponse
        .builder
        .ifSome(segments)(_.segments(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def pointOfInterest(
      beginOffsetMillis: Option[Int] = None,
      endOffsetMillis: Option[Int] = None
    ): PointOfInterest =
      PointOfInterest
        .builder
        .ifSome(beginOffsetMillis)(_.beginOffsetMillis(_))
        .ifSome(endOffsetMillis)(_.endOffsetMillis(_))
        .build

    def realtimeContactAnalysisSegment(
      transcript: Option[Transcript] = None,
      categories: Option[Categories] = None
    ): RealtimeContactAnalysisSegment =
      RealtimeContactAnalysisSegment
        .builder
        .ifSome(transcript)(_.transcript(_))
        .ifSome(categories)(_.categories(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def transcript(
      id: Option[String] = None,
      participantId: Option[String] = None,
      participantRole: Option[String] = None,
      content: Option[String] = None,
      beginOffsetMillis: Option[Int] = None,
      endOffsetMillis: Option[Int] = None,
      sentiment: Option[String] = None,
      issuesDetected: Option[List[IssueDetected]] = None
    ): Transcript =
      Transcript
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(participantId)(_.participantId(_))
        .ifSome(participantRole)(_.participantRole(_))
        .ifSome(content)(_.content(_))
        .ifSome(beginOffsetMillis)(_.beginOffsetMillis(_))
        .ifSome(endOffsetMillis)(_.endOffsetMillis(_))
        .ifSome(sentiment)(_.sentiment(_))
        .ifSome(issuesDetected)(_.issuesDetected(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
