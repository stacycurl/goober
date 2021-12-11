package goober.hi

import goober.free.connectparticipant.ConnectParticipantIO
import software.amazon.awssdk.services.connectparticipant.model._


object connectparticipant {
  import goober.free.{connectparticipant ⇒ free}

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

    def attachmentItem(
      contentType: Option[String] = None,
      attachmentId: Option[String] = None,
      attachmentName: Option[String] = None,
      status: Option[String] = None
    ): AttachmentItem =
      AttachmentItem
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(attachmentId)(_.attachmentId(_))
        .ifSome(attachmentName)(_.attachmentName(_))
        .ifSome(status)(_.status(_))
        .build

    def completeAttachmentUploadRequest(
      attachmentIds: Option[List[ArtifactId]] = None,
      clientToken: Option[String] = None,
      connectionToken: Option[String] = None
    ): CompleteAttachmentUploadRequest =
      CompleteAttachmentUploadRequest
        .builder
        .ifSome(attachmentIds)(_.attachmentIds(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(connectionToken)(_.connectionToken(_))
        .build

    def completeAttachmentUploadResponse(

    ): CompleteAttachmentUploadResponse =
      CompleteAttachmentUploadResponse
        .builder

        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def connectionCredentials(
      connectionToken: Option[String] = None,
      expiry: Option[String] = None
    ): ConnectionCredentials =
      ConnectionCredentials
        .builder
        .ifSome(connectionToken)(_.connectionToken(_))
        .ifSome(expiry)(_.expiry(_))
        .build

    def createParticipantConnectionRequest(
      `type`: Option[List[ConnectionType]] = None,
      participantToken: Option[String] = None
    ): CreateParticipantConnectionRequest =
      CreateParticipantConnectionRequest
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(participantToken)(_.participantToken(_))
        .build

    def createParticipantConnectionResponse(
      websocket: Option[Websocket] = None,
      connectionCredentials: Option[ConnectionCredentials] = None
    ): CreateParticipantConnectionResponse =
      CreateParticipantConnectionResponse
        .builder
        .ifSome(websocket)(_.websocket(_))
        .ifSome(connectionCredentials)(_.connectionCredentials(_))
        .build

    def disconnectParticipantRequest(
      clientToken: Option[String] = None,
      connectionToken: Option[String] = None
    ): DisconnectParticipantRequest =
      DisconnectParticipantRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(connectionToken)(_.connectionToken(_))
        .build

    def disconnectParticipantResponse(

    ): DisconnectParticipantResponse =
      DisconnectParticipantResponse
        .builder

        .build

    def getAttachmentRequest(
      attachmentId: Option[String] = None,
      connectionToken: Option[String] = None
    ): GetAttachmentRequest =
      GetAttachmentRequest
        .builder
        .ifSome(attachmentId)(_.attachmentId(_))
        .ifSome(connectionToken)(_.connectionToken(_))
        .build

    def getAttachmentResponse(
      url: Option[String] = None,
      urlExpiry: Option[String] = None
    ): GetAttachmentResponse =
      GetAttachmentResponse
        .builder
        .ifSome(url)(_.url(_))
        .ifSome(urlExpiry)(_.urlExpiry(_))
        .build

    def getTranscriptRequest(
      contactId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      scanDirection: Option[String] = None,
      sortOrder: Option[String] = None,
      startPosition: Option[StartPosition] = None,
      connectionToken: Option[String] = None
    ): GetTranscriptRequest =
      GetTranscriptRequest
        .builder
        .ifSome(contactId)(_.contactId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(scanDirection)(_.scanDirection(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(startPosition)(_.startPosition(_))
        .ifSome(connectionToken)(_.connectionToken(_))
        .build

    def getTranscriptResponse(
      initialContactId: Option[String] = None,
      transcript: Option[List[Item]] = None,
      nextToken: Option[String] = None
    ): GetTranscriptResponse =
      GetTranscriptResponse
        .builder
        .ifSome(initialContactId)(_.initialContactId(_))
        .ifSome(transcript)(_.transcript(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def item(
      absoluteTime: Option[String] = None,
      content: Option[String] = None,
      contentType: Option[String] = None,
      id: Option[String] = None,
      `type`: Option[String] = None,
      participantId: Option[String] = None,
      displayName: Option[String] = None,
      participantRole: Option[String] = None,
      attachments: Option[List[AttachmentItem]] = None
    ): Item =
      Item
        .builder
        .ifSome(absoluteTime)(_.absoluteTime(_))
        .ifSome(content)(_.content(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(participantId)(_.participantId(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(participantRole)(_.participantRole(_))
        .ifSome(attachments)(_.attachments(_))
        .build

    def sendEventRequest(
      contentType: Option[String] = None,
      content: Option[String] = None,
      clientToken: Option[String] = None,
      connectionToken: Option[String] = None
    ): SendEventRequest =
      SendEventRequest
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(content)(_.content(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(connectionToken)(_.connectionToken(_))
        .build

    def sendEventResponse(
      id: Option[String] = None,
      absoluteTime: Option[String] = None
    ): SendEventResponse =
      SendEventResponse
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(absoluteTime)(_.absoluteTime(_))
        .build

    def sendMessageRequest(
      contentType: Option[String] = None,
      content: Option[String] = None,
      clientToken: Option[String] = None,
      connectionToken: Option[String] = None
    ): SendMessageRequest =
      SendMessageRequest
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(content)(_.content(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(connectionToken)(_.connectionToken(_))
        .build

    def sendMessageResponse(
      id: Option[String] = None,
      absoluteTime: Option[String] = None
    ): SendMessageResponse =
      SendMessageResponse
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(absoluteTime)(_.absoluteTime(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def startAttachmentUploadRequest(
      contentType: Option[String] = None,
      attachmentSizeInBytes: Option[AttachmentSizeInBytes] = None,
      attachmentName: Option[String] = None,
      clientToken: Option[String] = None,
      connectionToken: Option[String] = None
    ): StartAttachmentUploadRequest =
      StartAttachmentUploadRequest
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(attachmentSizeInBytes)(_.attachmentSizeInBytes(_))
        .ifSome(attachmentName)(_.attachmentName(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(connectionToken)(_.connectionToken(_))
        .build

    def startAttachmentUploadResponse(
      attachmentId: Option[String] = None,
      uploadMetadata: Option[UploadMetadata] = None
    ): StartAttachmentUploadResponse =
      StartAttachmentUploadResponse
        .builder
        .ifSome(attachmentId)(_.attachmentId(_))
        .ifSome(uploadMetadata)(_.uploadMetadata(_))
        .build

    def startPosition(
      id: Option[String] = None,
      absoluteTime: Option[String] = None,
      mostRecent: Option[Int] = None
    ): StartPosition =
      StartPosition
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(absoluteTime)(_.absoluteTime(_))
        .ifSome(mostRecent)(_.mostRecent(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def uploadMetadata(
      url: Option[String] = None,
      urlExpiry: Option[String] = None,
      headersToInclude: Option[UploadMetadataSignedHeaders] = None
    ): UploadMetadata =
      UploadMetadata
        .builder
        .ifSome(url)(_.url(_))
        .ifSome(urlExpiry)(_.urlExpiry(_))
        .ifSome(headersToInclude)(_.headersToInclude(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def websocket(
      url: Option[String] = None,
      connectionExpiry: Option[String] = None
    ): Websocket =
      Websocket
        .builder
        .ifSome(url)(_.url(_))
        .ifSome(connectionExpiry)(_.connectionExpiry(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
