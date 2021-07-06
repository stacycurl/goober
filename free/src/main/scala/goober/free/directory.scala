package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.directory.DirectoryClient
import software.amazon.awssdk.services.directory.model._


object directory { module =>

  // Free monad over DirectoryOp
  type DirectoryIO[A] = FF[DirectoryOp, A]

  sealed trait DirectoryOp[A] {
    def visit[F[_]](visitor: DirectoryOp.Visitor[F]): F[A]
  }

  object DirectoryOp {
    // Given a DirectoryClient we can embed a DirectoryIO program in any algebra that understands embedding.
    implicit val DirectoryOpEmbeddable: Embeddable[DirectoryOp, DirectoryClient] = new Embeddable[DirectoryOp, DirectoryClient] {
      def embed[A](client: DirectoryClient, io: DirectoryIO[A]): Embedded[A] = Embedded.Directory(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends DirectoryOp.Visitor[Kleisli[M, DirectoryClient, *]] {
        def acceptSharedDirectory(
          request: AcceptSharedDirectoryRequest
        ): Kleisli[M, DirectoryClient, AcceptSharedDirectoryResponse] =
          primitive(_.acceptSharedDirectory(request))

        def addIpRoutes(
          request: AddIpRoutesRequest
        ): Kleisli[M, DirectoryClient, AddIpRoutesResponse] =
          primitive(_.addIpRoutes(request))

        def addRegion(
          request: AddRegionRequest
        ): Kleisli[M, DirectoryClient, AddRegionResponse] =
          primitive(_.addRegion(request))

        def addTagsToResource(
          request: AddTagsToResourceRequest
        ): Kleisli[M, DirectoryClient, AddTagsToResourceResponse] =
          primitive(_.addTagsToResource(request))

        def cancelSchemaExtension(
          request: CancelSchemaExtensionRequest
        ): Kleisli[M, DirectoryClient, CancelSchemaExtensionResponse] =
          primitive(_.cancelSchemaExtension(request))

        def connectDirectory(
          request: ConnectDirectoryRequest
        ): Kleisli[M, DirectoryClient, ConnectDirectoryResponse] =
          primitive(_.connectDirectory(request))

        def createAlias(
          request: CreateAliasRequest
        ): Kleisli[M, DirectoryClient, CreateAliasResponse] =
          primitive(_.createAlias(request))

        def createComputer(
          request: CreateComputerRequest
        ): Kleisli[M, DirectoryClient, CreateComputerResponse] =
          primitive(_.createComputer(request))

        def createConditionalForwarder(
          request: CreateConditionalForwarderRequest
        ): Kleisli[M, DirectoryClient, CreateConditionalForwarderResponse] =
          primitive(_.createConditionalForwarder(request))

        def createDirectory(
          request: CreateDirectoryRequest
        ): Kleisli[M, DirectoryClient, CreateDirectoryResponse] =
          primitive(_.createDirectory(request))

        def createLogSubscription(
          request: CreateLogSubscriptionRequest
        ): Kleisli[M, DirectoryClient, CreateLogSubscriptionResponse] =
          primitive(_.createLogSubscription(request))

        def createMicrosoftAD(
          request: CreateMicrosoftAdRequest
        ): Kleisli[M, DirectoryClient, CreateMicrosoftAdResponse] =
          primitive(_.createMicrosoftAD(request))

        def createSnapshot(
          request: CreateSnapshotRequest
        ): Kleisli[M, DirectoryClient, CreateSnapshotResponse] =
          primitive(_.createSnapshot(request))

        def createTrust(
          request: CreateTrustRequest
        ): Kleisli[M, DirectoryClient, CreateTrustResponse] =
          primitive(_.createTrust(request))

        def deleteConditionalForwarder(
          request: DeleteConditionalForwarderRequest
        ): Kleisli[M, DirectoryClient, DeleteConditionalForwarderResponse] =
          primitive(_.deleteConditionalForwarder(request))

        def deleteDirectory(
          request: DeleteDirectoryRequest
        ): Kleisli[M, DirectoryClient, DeleteDirectoryResponse] =
          primitive(_.deleteDirectory(request))

        def deleteLogSubscription(
          request: DeleteLogSubscriptionRequest
        ): Kleisli[M, DirectoryClient, DeleteLogSubscriptionResponse] =
          primitive(_.deleteLogSubscription(request))

        def deleteSnapshot(
          request: DeleteSnapshotRequest
        ): Kleisli[M, DirectoryClient, DeleteSnapshotResponse] =
          primitive(_.deleteSnapshot(request))

        def deleteTrust(
          request: DeleteTrustRequest
        ): Kleisli[M, DirectoryClient, DeleteTrustResponse] =
          primitive(_.deleteTrust(request))

        def deregisterCertificate(
          request: DeregisterCertificateRequest
        ): Kleisli[M, DirectoryClient, DeregisterCertificateResponse] =
          primitive(_.deregisterCertificate(request))

        def deregisterEventTopic(
          request: DeregisterEventTopicRequest
        ): Kleisli[M, DirectoryClient, DeregisterEventTopicResponse] =
          primitive(_.deregisterEventTopic(request))

        def describeCertificate(
          request: DescribeCertificateRequest
        ): Kleisli[M, DirectoryClient, DescribeCertificateResponse] =
          primitive(_.describeCertificate(request))

        def describeConditionalForwarders(
          request: DescribeConditionalForwardersRequest
        ): Kleisli[M, DirectoryClient, DescribeConditionalForwardersResponse] =
          primitive(_.describeConditionalForwarders(request))

        def describeDirectories(
          request: DescribeDirectoriesRequest
        ): Kleisli[M, DirectoryClient, DescribeDirectoriesResponse] =
          primitive(_.describeDirectories(request))

        def describeDomainControllers(
          request: DescribeDomainControllersRequest
        ): Kleisli[M, DirectoryClient, DescribeDomainControllersResponse] =
          primitive(_.describeDomainControllers(request))

        def describeEventTopics(
          request: DescribeEventTopicsRequest
        ): Kleisli[M, DirectoryClient, DescribeEventTopicsResponse] =
          primitive(_.describeEventTopics(request))

        def describeLDAPSSettings(
          request: DescribeLdapsSettingsRequest
        ): Kleisli[M, DirectoryClient, DescribeLdapsSettingsResponse] =
          primitive(_.describeLDAPSSettings(request))

        def describeRegions(
          request: DescribeRegionsRequest
        ): Kleisli[M, DirectoryClient, DescribeRegionsResponse] =
          primitive(_.describeRegions(request))

        def describeSharedDirectories(
          request: DescribeSharedDirectoriesRequest
        ): Kleisli[M, DirectoryClient, DescribeSharedDirectoriesResponse] =
          primitive(_.describeSharedDirectories(request))

        def describeSnapshots(
          request: DescribeSnapshotsRequest
        ): Kleisli[M, DirectoryClient, DescribeSnapshotsResponse] =
          primitive(_.describeSnapshots(request))

        def describeTrusts(
          request: DescribeTrustsRequest
        ): Kleisli[M, DirectoryClient, DescribeTrustsResponse] =
          primitive(_.describeTrusts(request))

        def disableClientAuthentication(
          request: DisableClientAuthenticationRequest
        ): Kleisli[M, DirectoryClient, DisableClientAuthenticationResponse] =
          primitive(_.disableClientAuthentication(request))

        def disableLDAPS(
          request: DisableLdapsRequest
        ): Kleisli[M, DirectoryClient, DisableLdapsResponse] =
          primitive(_.disableLDAPS(request))

        def disableRadius(
          request: DisableRadiusRequest
        ): Kleisli[M, DirectoryClient, DisableRadiusResponse] =
          primitive(_.disableRadius(request))

        def disableSso(
          request: DisableSsoRequest
        ): Kleisli[M, DirectoryClient, DisableSsoResponse] =
          primitive(_.disableSso(request))

        def enableClientAuthentication(
          request: EnableClientAuthenticationRequest
        ): Kleisli[M, DirectoryClient, EnableClientAuthenticationResponse] =
          primitive(_.enableClientAuthentication(request))

        def enableLDAPS(
          request: EnableLdapsRequest
        ): Kleisli[M, DirectoryClient, EnableLdapsResponse] =
          primitive(_.enableLDAPS(request))

        def enableRadius(
          request: EnableRadiusRequest
        ): Kleisli[M, DirectoryClient, EnableRadiusResponse] =
          primitive(_.enableRadius(request))

        def enableSso(
          request: EnableSsoRequest
        ): Kleisli[M, DirectoryClient, EnableSsoResponse] =
          primitive(_.enableSso(request))

        def getDirectoryLimits(
          request: GetDirectoryLimitsRequest
        ): Kleisli[M, DirectoryClient, GetDirectoryLimitsResponse] =
          primitive(_.getDirectoryLimits(request))

        def getSnapshotLimits(
          request: GetSnapshotLimitsRequest
        ): Kleisli[M, DirectoryClient, GetSnapshotLimitsResponse] =
          primitive(_.getSnapshotLimits(request))

        def listCertificates(
          request: ListCertificatesRequest
        ): Kleisli[M, DirectoryClient, ListCertificatesResponse] =
          primitive(_.listCertificates(request))

        def listIpRoutes(
          request: ListIpRoutesRequest
        ): Kleisli[M, DirectoryClient, ListIpRoutesResponse] =
          primitive(_.listIpRoutes(request))

        def listLogSubscriptions(
          request: ListLogSubscriptionsRequest
        ): Kleisli[M, DirectoryClient, ListLogSubscriptionsResponse] =
          primitive(_.listLogSubscriptions(request))

        def listSchemaExtensions(
          request: ListSchemaExtensionsRequest
        ): Kleisli[M, DirectoryClient, ListSchemaExtensionsResponse] =
          primitive(_.listSchemaExtensions(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, DirectoryClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def registerCertificate(
          request: RegisterCertificateRequest
        ): Kleisli[M, DirectoryClient, RegisterCertificateResponse] =
          primitive(_.registerCertificate(request))

        def registerEventTopic(
          request: RegisterEventTopicRequest
        ): Kleisli[M, DirectoryClient, RegisterEventTopicResponse] =
          primitive(_.registerEventTopic(request))

        def rejectSharedDirectory(
          request: RejectSharedDirectoryRequest
        ): Kleisli[M, DirectoryClient, RejectSharedDirectoryResponse] =
          primitive(_.rejectSharedDirectory(request))

        def removeIpRoutes(
          request: RemoveIpRoutesRequest
        ): Kleisli[M, DirectoryClient, RemoveIpRoutesResponse] =
          primitive(_.removeIpRoutes(request))

        def removeRegion(
          request: RemoveRegionRequest
        ): Kleisli[M, DirectoryClient, RemoveRegionResponse] =
          primitive(_.removeRegion(request))

        def removeTagsFromResource(
          request: RemoveTagsFromResourceRequest
        ): Kleisli[M, DirectoryClient, RemoveTagsFromResourceResponse] =
          primitive(_.removeTagsFromResource(request))

        def resetUserPassword(
          request: ResetUserPasswordRequest
        ): Kleisli[M, DirectoryClient, ResetUserPasswordResponse] =
          primitive(_.resetUserPassword(request))

        def restoreFromSnapshot(
          request: RestoreFromSnapshotRequest
        ): Kleisli[M, DirectoryClient, RestoreFromSnapshotResponse] =
          primitive(_.restoreFromSnapshot(request))

        def shareDirectory(
          request: ShareDirectoryRequest
        ): Kleisli[M, DirectoryClient, ShareDirectoryResponse] =
          primitive(_.shareDirectory(request))

        def startSchemaExtension(
          request: StartSchemaExtensionRequest
        ): Kleisli[M, DirectoryClient, StartSchemaExtensionResponse] =
          primitive(_.startSchemaExtension(request))

        def unshareDirectory(
          request: UnshareDirectoryRequest
        ): Kleisli[M, DirectoryClient, UnshareDirectoryResponse] =
          primitive(_.unshareDirectory(request))

        def updateConditionalForwarder(
          request: UpdateConditionalForwarderRequest
        ): Kleisli[M, DirectoryClient, UpdateConditionalForwarderResponse] =
          primitive(_.updateConditionalForwarder(request))

        def updateNumberOfDomainControllers(
          request: UpdateNumberOfDomainControllersRequest
        ): Kleisli[M, DirectoryClient, UpdateNumberOfDomainControllersResponse] =
          primitive(_.updateNumberOfDomainControllers(request))

        def updateRadius(
          request: UpdateRadiusRequest
        ): Kleisli[M, DirectoryClient, UpdateRadiusResponse] =
          primitive(_.updateRadius(request))

        def updateTrust(
          request: UpdateTrustRequest
        ): Kleisli[M, DirectoryClient, UpdateTrustResponse] =
          primitive(_.updateTrust(request))

        def verifyTrust(
          request: VerifyTrustRequest
        ): Kleisli[M, DirectoryClient, VerifyTrustResponse] =
          primitive(_.verifyTrust(request))

        def primitive[A](
          f: DirectoryClient => A
        ): Kleisli[M, DirectoryClient, A]
      }
    }

    trait Visitor[F[_]] extends (DirectoryOp ~> F) {
      final def apply[A](op: DirectoryOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptSharedDirectory(
        request: AcceptSharedDirectoryRequest
      ): F[AcceptSharedDirectoryResponse]

      def addIpRoutes(
        request: AddIpRoutesRequest
      ): F[AddIpRoutesResponse]

      def addRegion(
        request: AddRegionRequest
      ): F[AddRegionResponse]

      def addTagsToResource(
        request: AddTagsToResourceRequest
      ): F[AddTagsToResourceResponse]

      def cancelSchemaExtension(
        request: CancelSchemaExtensionRequest
      ): F[CancelSchemaExtensionResponse]

      def connectDirectory(
        request: ConnectDirectoryRequest
      ): F[ConnectDirectoryResponse]

      def createAlias(
        request: CreateAliasRequest
      ): F[CreateAliasResponse]

      def createComputer(
        request: CreateComputerRequest
      ): F[CreateComputerResponse]

      def createConditionalForwarder(
        request: CreateConditionalForwarderRequest
      ): F[CreateConditionalForwarderResponse]

      def createDirectory(
        request: CreateDirectoryRequest
      ): F[CreateDirectoryResponse]

      def createLogSubscription(
        request: CreateLogSubscriptionRequest
      ): F[CreateLogSubscriptionResponse]

      def createMicrosoftAD(
        request: CreateMicrosoftAdRequest
      ): F[CreateMicrosoftAdResponse]

      def createSnapshot(
        request: CreateSnapshotRequest
      ): F[CreateSnapshotResponse]

      def createTrust(
        request: CreateTrustRequest
      ): F[CreateTrustResponse]

      def deleteConditionalForwarder(
        request: DeleteConditionalForwarderRequest
      ): F[DeleteConditionalForwarderResponse]

      def deleteDirectory(
        request: DeleteDirectoryRequest
      ): F[DeleteDirectoryResponse]

      def deleteLogSubscription(
        request: DeleteLogSubscriptionRequest
      ): F[DeleteLogSubscriptionResponse]

      def deleteSnapshot(
        request: DeleteSnapshotRequest
      ): F[DeleteSnapshotResponse]

      def deleteTrust(
        request: DeleteTrustRequest
      ): F[DeleteTrustResponse]

      def deregisterCertificate(
        request: DeregisterCertificateRequest
      ): F[DeregisterCertificateResponse]

      def deregisterEventTopic(
        request: DeregisterEventTopicRequest
      ): F[DeregisterEventTopicResponse]

      def describeCertificate(
        request: DescribeCertificateRequest
      ): F[DescribeCertificateResponse]

      def describeConditionalForwarders(
        request: DescribeConditionalForwardersRequest
      ): F[DescribeConditionalForwardersResponse]

      def describeDirectories(
        request: DescribeDirectoriesRequest
      ): F[DescribeDirectoriesResponse]

      def describeDomainControllers(
        request: DescribeDomainControllersRequest
      ): F[DescribeDomainControllersResponse]

      def describeEventTopics(
        request: DescribeEventTopicsRequest
      ): F[DescribeEventTopicsResponse]

      def describeLDAPSSettings(
        request: DescribeLdapsSettingsRequest
      ): F[DescribeLdapsSettingsResponse]

      def describeRegions(
        request: DescribeRegionsRequest
      ): F[DescribeRegionsResponse]

      def describeSharedDirectories(
        request: DescribeSharedDirectoriesRequest
      ): F[DescribeSharedDirectoriesResponse]

      def describeSnapshots(
        request: DescribeSnapshotsRequest
      ): F[DescribeSnapshotsResponse]

      def describeTrusts(
        request: DescribeTrustsRequest
      ): F[DescribeTrustsResponse]

      def disableClientAuthentication(
        request: DisableClientAuthenticationRequest
      ): F[DisableClientAuthenticationResponse]

      def disableLDAPS(
        request: DisableLdapsRequest
      ): F[DisableLdapsResponse]

      def disableRadius(
        request: DisableRadiusRequest
      ): F[DisableRadiusResponse]

      def disableSso(
        request: DisableSsoRequest
      ): F[DisableSsoResponse]

      def enableClientAuthentication(
        request: EnableClientAuthenticationRequest
      ): F[EnableClientAuthenticationResponse]

      def enableLDAPS(
        request: EnableLdapsRequest
      ): F[EnableLdapsResponse]

      def enableRadius(
        request: EnableRadiusRequest
      ): F[EnableRadiusResponse]

      def enableSso(
        request: EnableSsoRequest
      ): F[EnableSsoResponse]

      def getDirectoryLimits(
        request: GetDirectoryLimitsRequest
      ): F[GetDirectoryLimitsResponse]

      def getSnapshotLimits(
        request: GetSnapshotLimitsRequest
      ): F[GetSnapshotLimitsResponse]

      def listCertificates(
        request: ListCertificatesRequest
      ): F[ListCertificatesResponse]

      def listIpRoutes(
        request: ListIpRoutesRequest
      ): F[ListIpRoutesResponse]

      def listLogSubscriptions(
        request: ListLogSubscriptionsRequest
      ): F[ListLogSubscriptionsResponse]

      def listSchemaExtensions(
        request: ListSchemaExtensionsRequest
      ): F[ListSchemaExtensionsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def registerCertificate(
        request: RegisterCertificateRequest
      ): F[RegisterCertificateResponse]

      def registerEventTopic(
        request: RegisterEventTopicRequest
      ): F[RegisterEventTopicResponse]

      def rejectSharedDirectory(
        request: RejectSharedDirectoryRequest
      ): F[RejectSharedDirectoryResponse]

      def removeIpRoutes(
        request: RemoveIpRoutesRequest
      ): F[RemoveIpRoutesResponse]

      def removeRegion(
        request: RemoveRegionRequest
      ): F[RemoveRegionResponse]

      def removeTagsFromResource(
        request: RemoveTagsFromResourceRequest
      ): F[RemoveTagsFromResourceResponse]

      def resetUserPassword(
        request: ResetUserPasswordRequest
      ): F[ResetUserPasswordResponse]

      def restoreFromSnapshot(
        request: RestoreFromSnapshotRequest
      ): F[RestoreFromSnapshotResponse]

      def shareDirectory(
        request: ShareDirectoryRequest
      ): F[ShareDirectoryResponse]

      def startSchemaExtension(
        request: StartSchemaExtensionRequest
      ): F[StartSchemaExtensionResponse]

      def unshareDirectory(
        request: UnshareDirectoryRequest
      ): F[UnshareDirectoryResponse]

      def updateConditionalForwarder(
        request: UpdateConditionalForwarderRequest
      ): F[UpdateConditionalForwarderResponse]

      def updateNumberOfDomainControllers(
        request: UpdateNumberOfDomainControllersRequest
      ): F[UpdateNumberOfDomainControllersResponse]

      def updateRadius(
        request: UpdateRadiusRequest
      ): F[UpdateRadiusResponse]

      def updateTrust(
        request: UpdateTrustRequest
      ): F[UpdateTrustResponse]

      def verifyTrust(
        request: VerifyTrustRequest
      ): F[VerifyTrustResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends DirectoryOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptSharedDirectoryOp(
      request: AcceptSharedDirectoryRequest
    ) extends DirectoryOp[AcceptSharedDirectoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptSharedDirectoryResponse] =
        visitor.acceptSharedDirectory(request)
    }

    final case class AddIpRoutesOp(
      request: AddIpRoutesRequest
    ) extends DirectoryOp[AddIpRoutesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddIpRoutesResponse] =
        visitor.addIpRoutes(request)
    }

    final case class AddRegionOp(
      request: AddRegionRequest
    ) extends DirectoryOp[AddRegionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddRegionResponse] =
        visitor.addRegion(request)
    }

    final case class AddTagsToResourceOp(
      request: AddTagsToResourceRequest
    ) extends DirectoryOp[AddTagsToResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsToResourceResponse] =
        visitor.addTagsToResource(request)
    }

    final case class CancelSchemaExtensionOp(
      request: CancelSchemaExtensionRequest
    ) extends DirectoryOp[CancelSchemaExtensionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelSchemaExtensionResponse] =
        visitor.cancelSchemaExtension(request)
    }

    final case class ConnectDirectoryOp(
      request: ConnectDirectoryRequest
    ) extends DirectoryOp[ConnectDirectoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ConnectDirectoryResponse] =
        visitor.connectDirectory(request)
    }

    final case class CreateAliasOp(
      request: CreateAliasRequest
    ) extends DirectoryOp[CreateAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAliasResponse] =
        visitor.createAlias(request)
    }

    final case class CreateComputerOp(
      request: CreateComputerRequest
    ) extends DirectoryOp[CreateComputerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateComputerResponse] =
        visitor.createComputer(request)
    }

    final case class CreateConditionalForwarderOp(
      request: CreateConditionalForwarderRequest
    ) extends DirectoryOp[CreateConditionalForwarderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConditionalForwarderResponse] =
        visitor.createConditionalForwarder(request)
    }

    final case class CreateDirectoryOp(
      request: CreateDirectoryRequest
    ) extends DirectoryOp[CreateDirectoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDirectoryResponse] =
        visitor.createDirectory(request)
    }

    final case class CreateLogSubscriptionOp(
      request: CreateLogSubscriptionRequest
    ) extends DirectoryOp[CreateLogSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLogSubscriptionResponse] =
        visitor.createLogSubscription(request)
    }

    final case class CreateMicrosoftADOp(
      request: CreateMicrosoftAdRequest
    ) extends DirectoryOp[CreateMicrosoftAdResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMicrosoftAdResponse] =
        visitor.createMicrosoftAD(request)
    }

    final case class CreateSnapshotOp(
      request: CreateSnapshotRequest
    ) extends DirectoryOp[CreateSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSnapshotResponse] =
        visitor.createSnapshot(request)
    }

    final case class CreateTrustOp(
      request: CreateTrustRequest
    ) extends DirectoryOp[CreateTrustResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTrustResponse] =
        visitor.createTrust(request)
    }

    final case class DeleteConditionalForwarderOp(
      request: DeleteConditionalForwarderRequest
    ) extends DirectoryOp[DeleteConditionalForwarderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConditionalForwarderResponse] =
        visitor.deleteConditionalForwarder(request)
    }

    final case class DeleteDirectoryOp(
      request: DeleteDirectoryRequest
    ) extends DirectoryOp[DeleteDirectoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDirectoryResponse] =
        visitor.deleteDirectory(request)
    }

    final case class DeleteLogSubscriptionOp(
      request: DeleteLogSubscriptionRequest
    ) extends DirectoryOp[DeleteLogSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLogSubscriptionResponse] =
        visitor.deleteLogSubscription(request)
    }

    final case class DeleteSnapshotOp(
      request: DeleteSnapshotRequest
    ) extends DirectoryOp[DeleteSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSnapshotResponse] =
        visitor.deleteSnapshot(request)
    }

    final case class DeleteTrustOp(
      request: DeleteTrustRequest
    ) extends DirectoryOp[DeleteTrustResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTrustResponse] =
        visitor.deleteTrust(request)
    }

    final case class DeregisterCertificateOp(
      request: DeregisterCertificateRequest
    ) extends DirectoryOp[DeregisterCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterCertificateResponse] =
        visitor.deregisterCertificate(request)
    }

    final case class DeregisterEventTopicOp(
      request: DeregisterEventTopicRequest
    ) extends DirectoryOp[DeregisterEventTopicResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterEventTopicResponse] =
        visitor.deregisterEventTopic(request)
    }

    final case class DescribeCertificateOp(
      request: DescribeCertificateRequest
    ) extends DirectoryOp[DescribeCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCertificateResponse] =
        visitor.describeCertificate(request)
    }

    final case class DescribeConditionalForwardersOp(
      request: DescribeConditionalForwardersRequest
    ) extends DirectoryOp[DescribeConditionalForwardersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConditionalForwardersResponse] =
        visitor.describeConditionalForwarders(request)
    }

    final case class DescribeDirectoriesOp(
      request: DescribeDirectoriesRequest
    ) extends DirectoryOp[DescribeDirectoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDirectoriesResponse] =
        visitor.describeDirectories(request)
    }

    final case class DescribeDomainControllersOp(
      request: DescribeDomainControllersRequest
    ) extends DirectoryOp[DescribeDomainControllersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDomainControllersResponse] =
        visitor.describeDomainControllers(request)
    }

    final case class DescribeEventTopicsOp(
      request: DescribeEventTopicsRequest
    ) extends DirectoryOp[DescribeEventTopicsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventTopicsResponse] =
        visitor.describeEventTopics(request)
    }

    final case class DescribeLDAPSSettingsOp(
      request: DescribeLdapsSettingsRequest
    ) extends DirectoryOp[DescribeLdapsSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLdapsSettingsResponse] =
        visitor.describeLDAPSSettings(request)
    }

    final case class DescribeRegionsOp(
      request: DescribeRegionsRequest
    ) extends DirectoryOp[DescribeRegionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRegionsResponse] =
        visitor.describeRegions(request)
    }

    final case class DescribeSharedDirectoriesOp(
      request: DescribeSharedDirectoriesRequest
    ) extends DirectoryOp[DescribeSharedDirectoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSharedDirectoriesResponse] =
        visitor.describeSharedDirectories(request)
    }

    final case class DescribeSnapshotsOp(
      request: DescribeSnapshotsRequest
    ) extends DirectoryOp[DescribeSnapshotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSnapshotsResponse] =
        visitor.describeSnapshots(request)
    }

    final case class DescribeTrustsOp(
      request: DescribeTrustsRequest
    ) extends DirectoryOp[DescribeTrustsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTrustsResponse] =
        visitor.describeTrusts(request)
    }

    final case class DisableClientAuthenticationOp(
      request: DisableClientAuthenticationRequest
    ) extends DirectoryOp[DisableClientAuthenticationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableClientAuthenticationResponse] =
        visitor.disableClientAuthentication(request)
    }

    final case class DisableLDAPSOp(
      request: DisableLdapsRequest
    ) extends DirectoryOp[DisableLdapsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableLdapsResponse] =
        visitor.disableLDAPS(request)
    }

    final case class DisableRadiusOp(
      request: DisableRadiusRequest
    ) extends DirectoryOp[DisableRadiusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableRadiusResponse] =
        visitor.disableRadius(request)
    }

    final case class DisableSsoOp(
      request: DisableSsoRequest
    ) extends DirectoryOp[DisableSsoResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableSsoResponse] =
        visitor.disableSso(request)
    }

    final case class EnableClientAuthenticationOp(
      request: EnableClientAuthenticationRequest
    ) extends DirectoryOp[EnableClientAuthenticationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableClientAuthenticationResponse] =
        visitor.enableClientAuthentication(request)
    }

    final case class EnableLDAPSOp(
      request: EnableLdapsRequest
    ) extends DirectoryOp[EnableLdapsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableLdapsResponse] =
        visitor.enableLDAPS(request)
    }

    final case class EnableRadiusOp(
      request: EnableRadiusRequest
    ) extends DirectoryOp[EnableRadiusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableRadiusResponse] =
        visitor.enableRadius(request)
    }

    final case class EnableSsoOp(
      request: EnableSsoRequest
    ) extends DirectoryOp[EnableSsoResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableSsoResponse] =
        visitor.enableSso(request)
    }

    final case class GetDirectoryLimitsOp(
      request: GetDirectoryLimitsRequest
    ) extends DirectoryOp[GetDirectoryLimitsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDirectoryLimitsResponse] =
        visitor.getDirectoryLimits(request)
    }

    final case class GetSnapshotLimitsOp(
      request: GetSnapshotLimitsRequest
    ) extends DirectoryOp[GetSnapshotLimitsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSnapshotLimitsResponse] =
        visitor.getSnapshotLimits(request)
    }

    final case class ListCertificatesOp(
      request: ListCertificatesRequest
    ) extends DirectoryOp[ListCertificatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCertificatesResponse] =
        visitor.listCertificates(request)
    }

    final case class ListIpRoutesOp(
      request: ListIpRoutesRequest
    ) extends DirectoryOp[ListIpRoutesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIpRoutesResponse] =
        visitor.listIpRoutes(request)
    }

    final case class ListLogSubscriptionsOp(
      request: ListLogSubscriptionsRequest
    ) extends DirectoryOp[ListLogSubscriptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLogSubscriptionsResponse] =
        visitor.listLogSubscriptions(request)
    }

    final case class ListSchemaExtensionsOp(
      request: ListSchemaExtensionsRequest
    ) extends DirectoryOp[ListSchemaExtensionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSchemaExtensionsResponse] =
        visitor.listSchemaExtensions(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends DirectoryOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class RegisterCertificateOp(
      request: RegisterCertificateRequest
    ) extends DirectoryOp[RegisterCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterCertificateResponse] =
        visitor.registerCertificate(request)
    }

    final case class RegisterEventTopicOp(
      request: RegisterEventTopicRequest
    ) extends DirectoryOp[RegisterEventTopicResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterEventTopicResponse] =
        visitor.registerEventTopic(request)
    }

    final case class RejectSharedDirectoryOp(
      request: RejectSharedDirectoryRequest
    ) extends DirectoryOp[RejectSharedDirectoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RejectSharedDirectoryResponse] =
        visitor.rejectSharedDirectory(request)
    }

    final case class RemoveIpRoutesOp(
      request: RemoveIpRoutesRequest
    ) extends DirectoryOp[RemoveIpRoutesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveIpRoutesResponse] =
        visitor.removeIpRoutes(request)
    }

    final case class RemoveRegionOp(
      request: RemoveRegionRequest
    ) extends DirectoryOp[RemoveRegionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveRegionResponse] =
        visitor.removeRegion(request)
    }

    final case class RemoveTagsFromResourceOp(
      request: RemoveTagsFromResourceRequest
    ) extends DirectoryOp[RemoveTagsFromResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTagsFromResourceResponse] =
        visitor.removeTagsFromResource(request)
    }

    final case class ResetUserPasswordOp(
      request: ResetUserPasswordRequest
    ) extends DirectoryOp[ResetUserPasswordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetUserPasswordResponse] =
        visitor.resetUserPassword(request)
    }

    final case class RestoreFromSnapshotOp(
      request: RestoreFromSnapshotRequest
    ) extends DirectoryOp[RestoreFromSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreFromSnapshotResponse] =
        visitor.restoreFromSnapshot(request)
    }

    final case class ShareDirectoryOp(
      request: ShareDirectoryRequest
    ) extends DirectoryOp[ShareDirectoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ShareDirectoryResponse] =
        visitor.shareDirectory(request)
    }

    final case class StartSchemaExtensionOp(
      request: StartSchemaExtensionRequest
    ) extends DirectoryOp[StartSchemaExtensionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartSchemaExtensionResponse] =
        visitor.startSchemaExtension(request)
    }

    final case class UnshareDirectoryOp(
      request: UnshareDirectoryRequest
    ) extends DirectoryOp[UnshareDirectoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UnshareDirectoryResponse] =
        visitor.unshareDirectory(request)
    }

    final case class UpdateConditionalForwarderOp(
      request: UpdateConditionalForwarderRequest
    ) extends DirectoryOp[UpdateConditionalForwarderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConditionalForwarderResponse] =
        visitor.updateConditionalForwarder(request)
    }

    final case class UpdateNumberOfDomainControllersOp(
      request: UpdateNumberOfDomainControllersRequest
    ) extends DirectoryOp[UpdateNumberOfDomainControllersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateNumberOfDomainControllersResponse] =
        visitor.updateNumberOfDomainControllers(request)
    }

    final case class UpdateRadiusOp(
      request: UpdateRadiusRequest
    ) extends DirectoryOp[UpdateRadiusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRadiusResponse] =
        visitor.updateRadius(request)
    }

    final case class UpdateTrustOp(
      request: UpdateTrustRequest
    ) extends DirectoryOp[UpdateTrustResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTrustResponse] =
        visitor.updateTrust(request)
    }

    final case class VerifyTrustOp(
      request: VerifyTrustRequest
    ) extends DirectoryOp[VerifyTrustResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[VerifyTrustResponse] =
        visitor.verifyTrust(request)
    }
  }

  import DirectoryOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[DirectoryOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptSharedDirectory(
    request: AcceptSharedDirectoryRequest
  ): DirectoryIO[AcceptSharedDirectoryResponse] =
    FF.liftF(AcceptSharedDirectoryOp(request))

  def addIpRoutes(
    request: AddIpRoutesRequest
  ): DirectoryIO[AddIpRoutesResponse] =
    FF.liftF(AddIpRoutesOp(request))

  def addRegion(
    request: AddRegionRequest
  ): DirectoryIO[AddRegionResponse] =
    FF.liftF(AddRegionOp(request))

  def addTagsToResource(
    request: AddTagsToResourceRequest
  ): DirectoryIO[AddTagsToResourceResponse] =
    FF.liftF(AddTagsToResourceOp(request))

  def cancelSchemaExtension(
    request: CancelSchemaExtensionRequest
  ): DirectoryIO[CancelSchemaExtensionResponse] =
    FF.liftF(CancelSchemaExtensionOp(request))

  def connectDirectory(
    request: ConnectDirectoryRequest
  ): DirectoryIO[ConnectDirectoryResponse] =
    FF.liftF(ConnectDirectoryOp(request))

  def createAlias(
    request: CreateAliasRequest
  ): DirectoryIO[CreateAliasResponse] =
    FF.liftF(CreateAliasOp(request))

  def createComputer(
    request: CreateComputerRequest
  ): DirectoryIO[CreateComputerResponse] =
    FF.liftF(CreateComputerOp(request))

  def createConditionalForwarder(
    request: CreateConditionalForwarderRequest
  ): DirectoryIO[CreateConditionalForwarderResponse] =
    FF.liftF(CreateConditionalForwarderOp(request))

  def createDirectory(
    request: CreateDirectoryRequest
  ): DirectoryIO[CreateDirectoryResponse] =
    FF.liftF(CreateDirectoryOp(request))

  def createLogSubscription(
    request: CreateLogSubscriptionRequest
  ): DirectoryIO[CreateLogSubscriptionResponse] =
    FF.liftF(CreateLogSubscriptionOp(request))

  def createMicrosoftAD(
    request: CreateMicrosoftAdRequest
  ): DirectoryIO[CreateMicrosoftAdResponse] =
    FF.liftF(CreateMicrosoftADOp(request))

  def createSnapshot(
    request: CreateSnapshotRequest
  ): DirectoryIO[CreateSnapshotResponse] =
    FF.liftF(CreateSnapshotOp(request))

  def createTrust(
    request: CreateTrustRequest
  ): DirectoryIO[CreateTrustResponse] =
    FF.liftF(CreateTrustOp(request))

  def deleteConditionalForwarder(
    request: DeleteConditionalForwarderRequest
  ): DirectoryIO[DeleteConditionalForwarderResponse] =
    FF.liftF(DeleteConditionalForwarderOp(request))

  def deleteDirectory(
    request: DeleteDirectoryRequest
  ): DirectoryIO[DeleteDirectoryResponse] =
    FF.liftF(DeleteDirectoryOp(request))

  def deleteLogSubscription(
    request: DeleteLogSubscriptionRequest
  ): DirectoryIO[DeleteLogSubscriptionResponse] =
    FF.liftF(DeleteLogSubscriptionOp(request))

  def deleteSnapshot(
    request: DeleteSnapshotRequest
  ): DirectoryIO[DeleteSnapshotResponse] =
    FF.liftF(DeleteSnapshotOp(request))

  def deleteTrust(
    request: DeleteTrustRequest
  ): DirectoryIO[DeleteTrustResponse] =
    FF.liftF(DeleteTrustOp(request))

  def deregisterCertificate(
    request: DeregisterCertificateRequest
  ): DirectoryIO[DeregisterCertificateResponse] =
    FF.liftF(DeregisterCertificateOp(request))

  def deregisterEventTopic(
    request: DeregisterEventTopicRequest
  ): DirectoryIO[DeregisterEventTopicResponse] =
    FF.liftF(DeregisterEventTopicOp(request))

  def describeCertificate(
    request: DescribeCertificateRequest
  ): DirectoryIO[DescribeCertificateResponse] =
    FF.liftF(DescribeCertificateOp(request))

  def describeConditionalForwarders(
    request: DescribeConditionalForwardersRequest
  ): DirectoryIO[DescribeConditionalForwardersResponse] =
    FF.liftF(DescribeConditionalForwardersOp(request))

  def describeDirectories(
    request: DescribeDirectoriesRequest
  ): DirectoryIO[DescribeDirectoriesResponse] =
    FF.liftF(DescribeDirectoriesOp(request))

  def describeDomainControllers(
    request: DescribeDomainControllersRequest
  ): DirectoryIO[DescribeDomainControllersResponse] =
    FF.liftF(DescribeDomainControllersOp(request))

  def describeEventTopics(
    request: DescribeEventTopicsRequest
  ): DirectoryIO[DescribeEventTopicsResponse] =
    FF.liftF(DescribeEventTopicsOp(request))

  def describeLDAPSSettings(
    request: DescribeLdapsSettingsRequest
  ): DirectoryIO[DescribeLdapsSettingsResponse] =
    FF.liftF(DescribeLDAPSSettingsOp(request))

  def describeRegions(
    request: DescribeRegionsRequest
  ): DirectoryIO[DescribeRegionsResponse] =
    FF.liftF(DescribeRegionsOp(request))

  def describeSharedDirectories(
    request: DescribeSharedDirectoriesRequest
  ): DirectoryIO[DescribeSharedDirectoriesResponse] =
    FF.liftF(DescribeSharedDirectoriesOp(request))

  def describeSnapshots(
    request: DescribeSnapshotsRequest
  ): DirectoryIO[DescribeSnapshotsResponse] =
    FF.liftF(DescribeSnapshotsOp(request))

  def describeTrusts(
    request: DescribeTrustsRequest
  ): DirectoryIO[DescribeTrustsResponse] =
    FF.liftF(DescribeTrustsOp(request))

  def disableClientAuthentication(
    request: DisableClientAuthenticationRequest
  ): DirectoryIO[DisableClientAuthenticationResponse] =
    FF.liftF(DisableClientAuthenticationOp(request))

  def disableLDAPS(
    request: DisableLdapsRequest
  ): DirectoryIO[DisableLdapsResponse] =
    FF.liftF(DisableLDAPSOp(request))

  def disableRadius(
    request: DisableRadiusRequest
  ): DirectoryIO[DisableRadiusResponse] =
    FF.liftF(DisableRadiusOp(request))

  def disableSso(
    request: DisableSsoRequest
  ): DirectoryIO[DisableSsoResponse] =
    FF.liftF(DisableSsoOp(request))

  def enableClientAuthentication(
    request: EnableClientAuthenticationRequest
  ): DirectoryIO[EnableClientAuthenticationResponse] =
    FF.liftF(EnableClientAuthenticationOp(request))

  def enableLDAPS(
    request: EnableLdapsRequest
  ): DirectoryIO[EnableLdapsResponse] =
    FF.liftF(EnableLDAPSOp(request))

  def enableRadius(
    request: EnableRadiusRequest
  ): DirectoryIO[EnableRadiusResponse] =
    FF.liftF(EnableRadiusOp(request))

  def enableSso(
    request: EnableSsoRequest
  ): DirectoryIO[EnableSsoResponse] =
    FF.liftF(EnableSsoOp(request))

  def getDirectoryLimits(
    request: GetDirectoryLimitsRequest
  ): DirectoryIO[GetDirectoryLimitsResponse] =
    FF.liftF(GetDirectoryLimitsOp(request))

  def getSnapshotLimits(
    request: GetSnapshotLimitsRequest
  ): DirectoryIO[GetSnapshotLimitsResponse] =
    FF.liftF(GetSnapshotLimitsOp(request))

  def listCertificates(
    request: ListCertificatesRequest
  ): DirectoryIO[ListCertificatesResponse] =
    FF.liftF(ListCertificatesOp(request))

  def listIpRoutes(
    request: ListIpRoutesRequest
  ): DirectoryIO[ListIpRoutesResponse] =
    FF.liftF(ListIpRoutesOp(request))

  def listLogSubscriptions(
    request: ListLogSubscriptionsRequest
  ): DirectoryIO[ListLogSubscriptionsResponse] =
    FF.liftF(ListLogSubscriptionsOp(request))

  def listSchemaExtensions(
    request: ListSchemaExtensionsRequest
  ): DirectoryIO[ListSchemaExtensionsResponse] =
    FF.liftF(ListSchemaExtensionsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): DirectoryIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def registerCertificate(
    request: RegisterCertificateRequest
  ): DirectoryIO[RegisterCertificateResponse] =
    FF.liftF(RegisterCertificateOp(request))

  def registerEventTopic(
    request: RegisterEventTopicRequest
  ): DirectoryIO[RegisterEventTopicResponse] =
    FF.liftF(RegisterEventTopicOp(request))

  def rejectSharedDirectory(
    request: RejectSharedDirectoryRequest
  ): DirectoryIO[RejectSharedDirectoryResponse] =
    FF.liftF(RejectSharedDirectoryOp(request))

  def removeIpRoutes(
    request: RemoveIpRoutesRequest
  ): DirectoryIO[RemoveIpRoutesResponse] =
    FF.liftF(RemoveIpRoutesOp(request))

  def removeRegion(
    request: RemoveRegionRequest
  ): DirectoryIO[RemoveRegionResponse] =
    FF.liftF(RemoveRegionOp(request))

  def removeTagsFromResource(
    request: RemoveTagsFromResourceRequest
  ): DirectoryIO[RemoveTagsFromResourceResponse] =
    FF.liftF(RemoveTagsFromResourceOp(request))

  def resetUserPassword(
    request: ResetUserPasswordRequest
  ): DirectoryIO[ResetUserPasswordResponse] =
    FF.liftF(ResetUserPasswordOp(request))

  def restoreFromSnapshot(
    request: RestoreFromSnapshotRequest
  ): DirectoryIO[RestoreFromSnapshotResponse] =
    FF.liftF(RestoreFromSnapshotOp(request))

  def shareDirectory(
    request: ShareDirectoryRequest
  ): DirectoryIO[ShareDirectoryResponse] =
    FF.liftF(ShareDirectoryOp(request))

  def startSchemaExtension(
    request: StartSchemaExtensionRequest
  ): DirectoryIO[StartSchemaExtensionResponse] =
    FF.liftF(StartSchemaExtensionOp(request))

  def unshareDirectory(
    request: UnshareDirectoryRequest
  ): DirectoryIO[UnshareDirectoryResponse] =
    FF.liftF(UnshareDirectoryOp(request))

  def updateConditionalForwarder(
    request: UpdateConditionalForwarderRequest
  ): DirectoryIO[UpdateConditionalForwarderResponse] =
    FF.liftF(UpdateConditionalForwarderOp(request))

  def updateNumberOfDomainControllers(
    request: UpdateNumberOfDomainControllersRequest
  ): DirectoryIO[UpdateNumberOfDomainControllersResponse] =
    FF.liftF(UpdateNumberOfDomainControllersOp(request))

  def updateRadius(
    request: UpdateRadiusRequest
  ): DirectoryIO[UpdateRadiusResponse] =
    FF.liftF(UpdateRadiusOp(request))

  def updateTrust(
    request: UpdateTrustRequest
  ): DirectoryIO[UpdateTrustResponse] =
    FF.liftF(UpdateTrustOp(request))

  def verifyTrust(
    request: VerifyTrustRequest
  ): DirectoryIO[VerifyTrustResponse] =
    FF.liftF(VerifyTrustOp(request))
}
