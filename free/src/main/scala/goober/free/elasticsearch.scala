package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.elasticsearch.ElasticsearchClient
import software.amazon.awssdk.services.elasticsearch.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object elasticsearch { module =>

  // Free monad over ElasticsearchOp
  type ElasticsearchIO[A] = FF[ElasticsearchOp, A]

  sealed trait ElasticsearchOp[A] {
    def visit[F[_]](visitor: ElasticsearchOp.Visitor[F]): F[A]
  }

  object ElasticsearchOp {
    // Given a ElasticsearchClient we can embed a ElasticsearchIO program in any algebra that understands embedding.
    implicit val ElasticsearchOpEmbeddable: Embeddable[ElasticsearchOp, ElasticsearchClient] = new Embeddable[ElasticsearchOp, ElasticsearchClient] {
      def embed[A](client: ElasticsearchClient, io: ElasticsearchIO[A]): Embedded[A] = Embedded.Elasticsearch(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ElasticsearchOp.Visitor[Kleisli[M, ElasticsearchClient, *]] {
        def acceptInboundCrossClusterSearchConnection(
          request: AcceptInboundCrossClusterSearchConnectionRequest
        ): Kleisli[M, ElasticsearchClient, AcceptInboundCrossClusterSearchConnectionResponse] =
          primitive(_.acceptInboundCrossClusterSearchConnection(request))

        def addTags(
          request: AddTagsRequest
        ): Kleisli[M, ElasticsearchClient, AddTagsResponse] =
          primitive(_.addTags(request))

        def associatePackage(
          request: AssociatePackageRequest
        ): Kleisli[M, ElasticsearchClient, AssociatePackageResponse] =
          primitive(_.associatePackage(request))

        def cancelElasticsearchServiceSoftwareUpdate(
          request: CancelElasticsearchServiceSoftwareUpdateRequest
        ): Kleisli[M, ElasticsearchClient, CancelElasticsearchServiceSoftwareUpdateResponse] =
          primitive(_.cancelElasticsearchServiceSoftwareUpdate(request))

        def createElasticsearchDomain(
          request: CreateElasticsearchDomainRequest
        ): Kleisli[M, ElasticsearchClient, CreateElasticsearchDomainResponse] =
          primitive(_.createElasticsearchDomain(request))

        def createOutboundCrossClusterSearchConnection(
          request: CreateOutboundCrossClusterSearchConnectionRequest
        ): Kleisli[M, ElasticsearchClient, CreateOutboundCrossClusterSearchConnectionResponse] =
          primitive(_.createOutboundCrossClusterSearchConnection(request))

        def createPackage(
          request: CreatePackageRequest
        ): Kleisli[M, ElasticsearchClient, CreatePackageResponse] =
          primitive(_.createPackage(request))

        def deleteElasticsearchDomain(
          request: DeleteElasticsearchDomainRequest
        ): Kleisli[M, ElasticsearchClient, DeleteElasticsearchDomainResponse] =
          primitive(_.deleteElasticsearchDomain(request))

        def deleteElasticsearchServiceRole(
          request: DeleteElasticsearchServiceRoleRequest
        ): Kleisli[M, ElasticsearchClient, DeleteElasticsearchServiceRoleResponse] =
          primitive(_.deleteElasticsearchServiceRole(request))

        def deleteInboundCrossClusterSearchConnection(
          request: DeleteInboundCrossClusterSearchConnectionRequest
        ): Kleisli[M, ElasticsearchClient, DeleteInboundCrossClusterSearchConnectionResponse] =
          primitive(_.deleteInboundCrossClusterSearchConnection(request))

        def deleteOutboundCrossClusterSearchConnection(
          request: DeleteOutboundCrossClusterSearchConnectionRequest
        ): Kleisli[M, ElasticsearchClient, DeleteOutboundCrossClusterSearchConnectionResponse] =
          primitive(_.deleteOutboundCrossClusterSearchConnection(request))

        def deletePackage(
          request: DeletePackageRequest
        ): Kleisli[M, ElasticsearchClient, DeletePackageResponse] =
          primitive(_.deletePackage(request))

        def describeDomainAutoTunes(
          request: DescribeDomainAutoTunesRequest
        ): Kleisli[M, ElasticsearchClient, DescribeDomainAutoTunesResponse] =
          primitive(_.describeDomainAutoTunes(request))

        def describeElasticsearchDomain(
          request: DescribeElasticsearchDomainRequest
        ): Kleisli[M, ElasticsearchClient, DescribeElasticsearchDomainResponse] =
          primitive(_.describeElasticsearchDomain(request))

        def describeElasticsearchDomainConfig(
          request: DescribeElasticsearchDomainConfigRequest
        ): Kleisli[M, ElasticsearchClient, DescribeElasticsearchDomainConfigResponse] =
          primitive(_.describeElasticsearchDomainConfig(request))

        def describeElasticsearchDomains(
          request: DescribeElasticsearchDomainsRequest
        ): Kleisli[M, ElasticsearchClient, DescribeElasticsearchDomainsResponse] =
          primitive(_.describeElasticsearchDomains(request))

        def describeElasticsearchInstanceTypeLimits(
          request: DescribeElasticsearchInstanceTypeLimitsRequest
        ): Kleisli[M, ElasticsearchClient, DescribeElasticsearchInstanceTypeLimitsResponse] =
          primitive(_.describeElasticsearchInstanceTypeLimits(request))

        def describeInboundCrossClusterSearchConnections(
          request: DescribeInboundCrossClusterSearchConnectionsRequest
        ): Kleisli[M, ElasticsearchClient, DescribeInboundCrossClusterSearchConnectionsResponse] =
          primitive(_.describeInboundCrossClusterSearchConnections(request))

        def describeOutboundCrossClusterSearchConnections(
          request: DescribeOutboundCrossClusterSearchConnectionsRequest
        ): Kleisli[M, ElasticsearchClient, DescribeOutboundCrossClusterSearchConnectionsResponse] =
          primitive(_.describeOutboundCrossClusterSearchConnections(request))

        def describePackages(
          request: DescribePackagesRequest
        ): Kleisli[M, ElasticsearchClient, DescribePackagesResponse] =
          primitive(_.describePackages(request))

        def describeReservedElasticsearchInstanceOfferings(
          request: DescribeReservedElasticsearchInstanceOfferingsRequest
        ): Kleisli[M, ElasticsearchClient, DescribeReservedElasticsearchInstanceOfferingsResponse] =
          primitive(_.describeReservedElasticsearchInstanceOfferings(request))

        def describeReservedElasticsearchInstances(
          request: DescribeReservedElasticsearchInstancesRequest
        ): Kleisli[M, ElasticsearchClient, DescribeReservedElasticsearchInstancesResponse] =
          primitive(_.describeReservedElasticsearchInstances(request))

        def dissociatePackage(
          request: DissociatePackageRequest
        ): Kleisli[M, ElasticsearchClient, DissociatePackageResponse] =
          primitive(_.dissociatePackage(request))

        def getCompatibleElasticsearchVersions(
          request: GetCompatibleElasticsearchVersionsRequest
        ): Kleisli[M, ElasticsearchClient, GetCompatibleElasticsearchVersionsResponse] =
          primitive(_.getCompatibleElasticsearchVersions(request))

        def getPackageVersionHistory(
          request: GetPackageVersionHistoryRequest
        ): Kleisli[M, ElasticsearchClient, GetPackageVersionHistoryResponse] =
          primitive(_.getPackageVersionHistory(request))

        def getUpgradeHistory(
          request: GetUpgradeHistoryRequest
        ): Kleisli[M, ElasticsearchClient, GetUpgradeHistoryResponse] =
          primitive(_.getUpgradeHistory(request))

        def getUpgradeStatus(
          request: GetUpgradeStatusRequest
        ): Kleisli[M, ElasticsearchClient, GetUpgradeStatusResponse] =
          primitive(_.getUpgradeStatus(request))

        def listDomainNames(
          request: ListDomainNamesRequest
        ): Kleisli[M, ElasticsearchClient, ListDomainNamesResponse] =
          primitive(_.listDomainNames(request))

        def listDomainsForPackage(
          request: ListDomainsForPackageRequest
        ): Kleisli[M, ElasticsearchClient, ListDomainsForPackageResponse] =
          primitive(_.listDomainsForPackage(request))

        def listElasticsearchInstanceTypes(
          request: ListElasticsearchInstanceTypesRequest
        ): Kleisli[M, ElasticsearchClient, ListElasticsearchInstanceTypesResponse] =
          primitive(_.listElasticsearchInstanceTypes(request))

        def listElasticsearchVersions(
          request: ListElasticsearchVersionsRequest
        ): Kleisli[M, ElasticsearchClient, ListElasticsearchVersionsResponse] =
          primitive(_.listElasticsearchVersions(request))

        def listPackagesForDomain(
          request: ListPackagesForDomainRequest
        ): Kleisli[M, ElasticsearchClient, ListPackagesForDomainResponse] =
          primitive(_.listPackagesForDomain(request))

        def listTags(
          request: ListTagsRequest
        ): Kleisli[M, ElasticsearchClient, ListTagsResponse] =
          primitive(_.listTags(request))

        def purchaseReservedElasticsearchInstanceOffering(
          request: PurchaseReservedElasticsearchInstanceOfferingRequest
        ): Kleisli[M, ElasticsearchClient, PurchaseReservedElasticsearchInstanceOfferingResponse] =
          primitive(_.purchaseReservedElasticsearchInstanceOffering(request))

        def rejectInboundCrossClusterSearchConnection(
          request: RejectInboundCrossClusterSearchConnectionRequest
        ): Kleisli[M, ElasticsearchClient, RejectInboundCrossClusterSearchConnectionResponse] =
          primitive(_.rejectInboundCrossClusterSearchConnection(request))

        def removeTags(
          request: RemoveTagsRequest
        ): Kleisli[M, ElasticsearchClient, RemoveTagsResponse] =
          primitive(_.removeTags(request))

        def startElasticsearchServiceSoftwareUpdate(
          request: StartElasticsearchServiceSoftwareUpdateRequest
        ): Kleisli[M, ElasticsearchClient, StartElasticsearchServiceSoftwareUpdateResponse] =
          primitive(_.startElasticsearchServiceSoftwareUpdate(request))

        def updateElasticsearchDomainConfig(
          request: UpdateElasticsearchDomainConfigRequest
        ): Kleisli[M, ElasticsearchClient, UpdateElasticsearchDomainConfigResponse] =
          primitive(_.updateElasticsearchDomainConfig(request))

        def updatePackage(
          request: UpdatePackageRequest
        ): Kleisli[M, ElasticsearchClient, UpdatePackageResponse] =
          primitive(_.updatePackage(request))

        def upgradeElasticsearchDomain(
          request: UpgradeElasticsearchDomainRequest
        ): Kleisli[M, ElasticsearchClient, UpgradeElasticsearchDomainResponse] =
          primitive(_.upgradeElasticsearchDomain(request))

        def primitive[A](
          f: ElasticsearchClient => A
        ): Kleisli[M, ElasticsearchClient, A]
      }
    }

    trait Visitor[F[_]] extends (ElasticsearchOp ~> F) {
      final def apply[A](op: ElasticsearchOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptInboundCrossClusterSearchConnection(
        request: AcceptInboundCrossClusterSearchConnectionRequest
      ): F[AcceptInboundCrossClusterSearchConnectionResponse]

      def addTags(
        request: AddTagsRequest
      ): F[AddTagsResponse]

      def associatePackage(
        request: AssociatePackageRequest
      ): F[AssociatePackageResponse]

      def cancelElasticsearchServiceSoftwareUpdate(
        request: CancelElasticsearchServiceSoftwareUpdateRequest
      ): F[CancelElasticsearchServiceSoftwareUpdateResponse]

      def createElasticsearchDomain(
        request: CreateElasticsearchDomainRequest
      ): F[CreateElasticsearchDomainResponse]

      def createOutboundCrossClusterSearchConnection(
        request: CreateOutboundCrossClusterSearchConnectionRequest
      ): F[CreateOutboundCrossClusterSearchConnectionResponse]

      def createPackage(
        request: CreatePackageRequest
      ): F[CreatePackageResponse]

      def deleteElasticsearchDomain(
        request: DeleteElasticsearchDomainRequest
      ): F[DeleteElasticsearchDomainResponse]

      def deleteElasticsearchServiceRole(
        request: DeleteElasticsearchServiceRoleRequest
      ): F[DeleteElasticsearchServiceRoleResponse]

      def deleteInboundCrossClusterSearchConnection(
        request: DeleteInboundCrossClusterSearchConnectionRequest
      ): F[DeleteInboundCrossClusterSearchConnectionResponse]

      def deleteOutboundCrossClusterSearchConnection(
        request: DeleteOutboundCrossClusterSearchConnectionRequest
      ): F[DeleteOutboundCrossClusterSearchConnectionResponse]

      def deletePackage(
        request: DeletePackageRequest
      ): F[DeletePackageResponse]

      def describeDomainAutoTunes(
        request: DescribeDomainAutoTunesRequest
      ): F[DescribeDomainAutoTunesResponse]

      def describeElasticsearchDomain(
        request: DescribeElasticsearchDomainRequest
      ): F[DescribeElasticsearchDomainResponse]

      def describeElasticsearchDomainConfig(
        request: DescribeElasticsearchDomainConfigRequest
      ): F[DescribeElasticsearchDomainConfigResponse]

      def describeElasticsearchDomains(
        request: DescribeElasticsearchDomainsRequest
      ): F[DescribeElasticsearchDomainsResponse]

      def describeElasticsearchInstanceTypeLimits(
        request: DescribeElasticsearchInstanceTypeLimitsRequest
      ): F[DescribeElasticsearchInstanceTypeLimitsResponse]

      def describeInboundCrossClusterSearchConnections(
        request: DescribeInboundCrossClusterSearchConnectionsRequest
      ): F[DescribeInboundCrossClusterSearchConnectionsResponse]

      def describeOutboundCrossClusterSearchConnections(
        request: DescribeOutboundCrossClusterSearchConnectionsRequest
      ): F[DescribeOutboundCrossClusterSearchConnectionsResponse]

      def describePackages(
        request: DescribePackagesRequest
      ): F[DescribePackagesResponse]

      def describeReservedElasticsearchInstanceOfferings(
        request: DescribeReservedElasticsearchInstanceOfferingsRequest
      ): F[DescribeReservedElasticsearchInstanceOfferingsResponse]

      def describeReservedElasticsearchInstances(
        request: DescribeReservedElasticsearchInstancesRequest
      ): F[DescribeReservedElasticsearchInstancesResponse]

      def dissociatePackage(
        request: DissociatePackageRequest
      ): F[DissociatePackageResponse]

      def getCompatibleElasticsearchVersions(
        request: GetCompatibleElasticsearchVersionsRequest
      ): F[GetCompatibleElasticsearchVersionsResponse]

      def getPackageVersionHistory(
        request: GetPackageVersionHistoryRequest
      ): F[GetPackageVersionHistoryResponse]

      def getUpgradeHistory(
        request: GetUpgradeHistoryRequest
      ): F[GetUpgradeHistoryResponse]

      def getUpgradeStatus(
        request: GetUpgradeStatusRequest
      ): F[GetUpgradeStatusResponse]

      def listDomainNames(
        request: ListDomainNamesRequest
      ): F[ListDomainNamesResponse]

      def listDomainsForPackage(
        request: ListDomainsForPackageRequest
      ): F[ListDomainsForPackageResponse]

      def listElasticsearchInstanceTypes(
        request: ListElasticsearchInstanceTypesRequest
      ): F[ListElasticsearchInstanceTypesResponse]

      def listElasticsearchVersions(
        request: ListElasticsearchVersionsRequest
      ): F[ListElasticsearchVersionsResponse]

      def listPackagesForDomain(
        request: ListPackagesForDomainRequest
      ): F[ListPackagesForDomainResponse]

      def listTags(
        request: ListTagsRequest
      ): F[ListTagsResponse]

      def purchaseReservedElasticsearchInstanceOffering(
        request: PurchaseReservedElasticsearchInstanceOfferingRequest
      ): F[PurchaseReservedElasticsearchInstanceOfferingResponse]

      def rejectInboundCrossClusterSearchConnection(
        request: RejectInboundCrossClusterSearchConnectionRequest
      ): F[RejectInboundCrossClusterSearchConnectionResponse]

      def removeTags(
        request: RemoveTagsRequest
      ): F[RemoveTagsResponse]

      def startElasticsearchServiceSoftwareUpdate(
        request: StartElasticsearchServiceSoftwareUpdateRequest
      ): F[StartElasticsearchServiceSoftwareUpdateResponse]

      def updateElasticsearchDomainConfig(
        request: UpdateElasticsearchDomainConfigRequest
      ): F[UpdateElasticsearchDomainConfigResponse]

      def updatePackage(
        request: UpdatePackageRequest
      ): F[UpdatePackageResponse]

      def upgradeElasticsearchDomain(
        request: UpgradeElasticsearchDomainRequest
      ): F[UpgradeElasticsearchDomainResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ElasticsearchOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptInboundCrossClusterSearchConnectionOp(
      request: AcceptInboundCrossClusterSearchConnectionRequest
    ) extends ElasticsearchOp[AcceptInboundCrossClusterSearchConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptInboundCrossClusterSearchConnectionResponse] =
        visitor.acceptInboundCrossClusterSearchConnection(request)
    }

    final case class AddTagsOp(
      request: AddTagsRequest
    ) extends ElasticsearchOp[AddTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsResponse] =
        visitor.addTags(request)
    }

    final case class AssociatePackageOp(
      request: AssociatePackageRequest
    ) extends ElasticsearchOp[AssociatePackageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociatePackageResponse] =
        visitor.associatePackage(request)
    }

    final case class CancelElasticsearchServiceSoftwareUpdateOp(
      request: CancelElasticsearchServiceSoftwareUpdateRequest
    ) extends ElasticsearchOp[CancelElasticsearchServiceSoftwareUpdateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelElasticsearchServiceSoftwareUpdateResponse] =
        visitor.cancelElasticsearchServiceSoftwareUpdate(request)
    }

    final case class CreateElasticsearchDomainOp(
      request: CreateElasticsearchDomainRequest
    ) extends ElasticsearchOp[CreateElasticsearchDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateElasticsearchDomainResponse] =
        visitor.createElasticsearchDomain(request)
    }

    final case class CreateOutboundCrossClusterSearchConnectionOp(
      request: CreateOutboundCrossClusterSearchConnectionRequest
    ) extends ElasticsearchOp[CreateOutboundCrossClusterSearchConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateOutboundCrossClusterSearchConnectionResponse] =
        visitor.createOutboundCrossClusterSearchConnection(request)
    }

    final case class CreatePackageOp(
      request: CreatePackageRequest
    ) extends ElasticsearchOp[CreatePackageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePackageResponse] =
        visitor.createPackage(request)
    }

    final case class DeleteElasticsearchDomainOp(
      request: DeleteElasticsearchDomainRequest
    ) extends ElasticsearchOp[DeleteElasticsearchDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteElasticsearchDomainResponse] =
        visitor.deleteElasticsearchDomain(request)
    }

    final case class DeleteElasticsearchServiceRoleOp(
      request: DeleteElasticsearchServiceRoleRequest
    ) extends ElasticsearchOp[DeleteElasticsearchServiceRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteElasticsearchServiceRoleResponse] =
        visitor.deleteElasticsearchServiceRole(request)
    }

    final case class DeleteInboundCrossClusterSearchConnectionOp(
      request: DeleteInboundCrossClusterSearchConnectionRequest
    ) extends ElasticsearchOp[DeleteInboundCrossClusterSearchConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInboundCrossClusterSearchConnectionResponse] =
        visitor.deleteInboundCrossClusterSearchConnection(request)
    }

    final case class DeleteOutboundCrossClusterSearchConnectionOp(
      request: DeleteOutboundCrossClusterSearchConnectionRequest
    ) extends ElasticsearchOp[DeleteOutboundCrossClusterSearchConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteOutboundCrossClusterSearchConnectionResponse] =
        visitor.deleteOutboundCrossClusterSearchConnection(request)
    }

    final case class DeletePackageOp(
      request: DeletePackageRequest
    ) extends ElasticsearchOp[DeletePackageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePackageResponse] =
        visitor.deletePackage(request)
    }

    final case class DescribeDomainAutoTunesOp(
      request: DescribeDomainAutoTunesRequest
    ) extends ElasticsearchOp[DescribeDomainAutoTunesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDomainAutoTunesResponse] =
        visitor.describeDomainAutoTunes(request)
    }

    final case class DescribeElasticsearchDomainOp(
      request: DescribeElasticsearchDomainRequest
    ) extends ElasticsearchOp[DescribeElasticsearchDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeElasticsearchDomainResponse] =
        visitor.describeElasticsearchDomain(request)
    }

    final case class DescribeElasticsearchDomainConfigOp(
      request: DescribeElasticsearchDomainConfigRequest
    ) extends ElasticsearchOp[DescribeElasticsearchDomainConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeElasticsearchDomainConfigResponse] =
        visitor.describeElasticsearchDomainConfig(request)
    }

    final case class DescribeElasticsearchDomainsOp(
      request: DescribeElasticsearchDomainsRequest
    ) extends ElasticsearchOp[DescribeElasticsearchDomainsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeElasticsearchDomainsResponse] =
        visitor.describeElasticsearchDomains(request)
    }

    final case class DescribeElasticsearchInstanceTypeLimitsOp(
      request: DescribeElasticsearchInstanceTypeLimitsRequest
    ) extends ElasticsearchOp[DescribeElasticsearchInstanceTypeLimitsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeElasticsearchInstanceTypeLimitsResponse] =
        visitor.describeElasticsearchInstanceTypeLimits(request)
    }

    final case class DescribeInboundCrossClusterSearchConnectionsOp(
      request: DescribeInboundCrossClusterSearchConnectionsRequest
    ) extends ElasticsearchOp[DescribeInboundCrossClusterSearchConnectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInboundCrossClusterSearchConnectionsResponse] =
        visitor.describeInboundCrossClusterSearchConnections(request)
    }

    final case class DescribeOutboundCrossClusterSearchConnectionsOp(
      request: DescribeOutboundCrossClusterSearchConnectionsRequest
    ) extends ElasticsearchOp[DescribeOutboundCrossClusterSearchConnectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOutboundCrossClusterSearchConnectionsResponse] =
        visitor.describeOutboundCrossClusterSearchConnections(request)
    }

    final case class DescribePackagesOp(
      request: DescribePackagesRequest
    ) extends ElasticsearchOp[DescribePackagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePackagesResponse] =
        visitor.describePackages(request)
    }

    final case class DescribeReservedElasticsearchInstanceOfferingsOp(
      request: DescribeReservedElasticsearchInstanceOfferingsRequest
    ) extends ElasticsearchOp[DescribeReservedElasticsearchInstanceOfferingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReservedElasticsearchInstanceOfferingsResponse] =
        visitor.describeReservedElasticsearchInstanceOfferings(request)
    }

    final case class DescribeReservedElasticsearchInstancesOp(
      request: DescribeReservedElasticsearchInstancesRequest
    ) extends ElasticsearchOp[DescribeReservedElasticsearchInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReservedElasticsearchInstancesResponse] =
        visitor.describeReservedElasticsearchInstances(request)
    }

    final case class DissociatePackageOp(
      request: DissociatePackageRequest
    ) extends ElasticsearchOp[DissociatePackageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DissociatePackageResponse] =
        visitor.dissociatePackage(request)
    }

    final case class GetCompatibleElasticsearchVersionsOp(
      request: GetCompatibleElasticsearchVersionsRequest
    ) extends ElasticsearchOp[GetCompatibleElasticsearchVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCompatibleElasticsearchVersionsResponse] =
        visitor.getCompatibleElasticsearchVersions(request)
    }

    final case class GetPackageVersionHistoryOp(
      request: GetPackageVersionHistoryRequest
    ) extends ElasticsearchOp[GetPackageVersionHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPackageVersionHistoryResponse] =
        visitor.getPackageVersionHistory(request)
    }

    final case class GetUpgradeHistoryOp(
      request: GetUpgradeHistoryRequest
    ) extends ElasticsearchOp[GetUpgradeHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUpgradeHistoryResponse] =
        visitor.getUpgradeHistory(request)
    }

    final case class GetUpgradeStatusOp(
      request: GetUpgradeStatusRequest
    ) extends ElasticsearchOp[GetUpgradeStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUpgradeStatusResponse] =
        visitor.getUpgradeStatus(request)
    }

    final case class ListDomainNamesOp(
      request: ListDomainNamesRequest
    ) extends ElasticsearchOp[ListDomainNamesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDomainNamesResponse] =
        visitor.listDomainNames(request)
    }

    final case class ListDomainsForPackageOp(
      request: ListDomainsForPackageRequest
    ) extends ElasticsearchOp[ListDomainsForPackageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDomainsForPackageResponse] =
        visitor.listDomainsForPackage(request)
    }

    final case class ListElasticsearchInstanceTypesOp(
      request: ListElasticsearchInstanceTypesRequest
    ) extends ElasticsearchOp[ListElasticsearchInstanceTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListElasticsearchInstanceTypesResponse] =
        visitor.listElasticsearchInstanceTypes(request)
    }

    final case class ListElasticsearchVersionsOp(
      request: ListElasticsearchVersionsRequest
    ) extends ElasticsearchOp[ListElasticsearchVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListElasticsearchVersionsResponse] =
        visitor.listElasticsearchVersions(request)
    }

    final case class ListPackagesForDomainOp(
      request: ListPackagesForDomainRequest
    ) extends ElasticsearchOp[ListPackagesForDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPackagesForDomainResponse] =
        visitor.listPackagesForDomain(request)
    }

    final case class ListTagsOp(
      request: ListTagsRequest
    ) extends ElasticsearchOp[ListTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsResponse] =
        visitor.listTags(request)
    }

    final case class PurchaseReservedElasticsearchInstanceOfferingOp(
      request: PurchaseReservedElasticsearchInstanceOfferingRequest
    ) extends ElasticsearchOp[PurchaseReservedElasticsearchInstanceOfferingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PurchaseReservedElasticsearchInstanceOfferingResponse] =
        visitor.purchaseReservedElasticsearchInstanceOffering(request)
    }

    final case class RejectInboundCrossClusterSearchConnectionOp(
      request: RejectInboundCrossClusterSearchConnectionRequest
    ) extends ElasticsearchOp[RejectInboundCrossClusterSearchConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RejectInboundCrossClusterSearchConnectionResponse] =
        visitor.rejectInboundCrossClusterSearchConnection(request)
    }

    final case class RemoveTagsOp(
      request: RemoveTagsRequest
    ) extends ElasticsearchOp[RemoveTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTagsResponse] =
        visitor.removeTags(request)
    }

    final case class StartElasticsearchServiceSoftwareUpdateOp(
      request: StartElasticsearchServiceSoftwareUpdateRequest
    ) extends ElasticsearchOp[StartElasticsearchServiceSoftwareUpdateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartElasticsearchServiceSoftwareUpdateResponse] =
        visitor.startElasticsearchServiceSoftwareUpdate(request)
    }

    final case class UpdateElasticsearchDomainConfigOp(
      request: UpdateElasticsearchDomainConfigRequest
    ) extends ElasticsearchOp[UpdateElasticsearchDomainConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateElasticsearchDomainConfigResponse] =
        visitor.updateElasticsearchDomainConfig(request)
    }

    final case class UpdatePackageOp(
      request: UpdatePackageRequest
    ) extends ElasticsearchOp[UpdatePackageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePackageResponse] =
        visitor.updatePackage(request)
    }

    final case class UpgradeElasticsearchDomainOp(
      request: UpgradeElasticsearchDomainRequest
    ) extends ElasticsearchOp[UpgradeElasticsearchDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpgradeElasticsearchDomainResponse] =
        visitor.upgradeElasticsearchDomain(request)
    }
  }

  import ElasticsearchOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ElasticsearchOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptInboundCrossClusterSearchConnection(
    request: AcceptInboundCrossClusterSearchConnectionRequest
  ): ElasticsearchIO[AcceptInboundCrossClusterSearchConnectionResponse] =
    FF.liftF(AcceptInboundCrossClusterSearchConnectionOp(request))

  def addTags(
    request: AddTagsRequest
  ): ElasticsearchIO[AddTagsResponse] =
    FF.liftF(AddTagsOp(request))

  def associatePackage(
    request: AssociatePackageRequest
  ): ElasticsearchIO[AssociatePackageResponse] =
    FF.liftF(AssociatePackageOp(request))

  def cancelElasticsearchServiceSoftwareUpdate(
    request: CancelElasticsearchServiceSoftwareUpdateRequest
  ): ElasticsearchIO[CancelElasticsearchServiceSoftwareUpdateResponse] =
    FF.liftF(CancelElasticsearchServiceSoftwareUpdateOp(request))

  def createElasticsearchDomain(
    request: CreateElasticsearchDomainRequest
  ): ElasticsearchIO[CreateElasticsearchDomainResponse] =
    FF.liftF(CreateElasticsearchDomainOp(request))

  def createOutboundCrossClusterSearchConnection(
    request: CreateOutboundCrossClusterSearchConnectionRequest
  ): ElasticsearchIO[CreateOutboundCrossClusterSearchConnectionResponse] =
    FF.liftF(CreateOutboundCrossClusterSearchConnectionOp(request))

  def createPackage(
    request: CreatePackageRequest
  ): ElasticsearchIO[CreatePackageResponse] =
    FF.liftF(CreatePackageOp(request))

  def deleteElasticsearchDomain(
    request: DeleteElasticsearchDomainRequest
  ): ElasticsearchIO[DeleteElasticsearchDomainResponse] =
    FF.liftF(DeleteElasticsearchDomainOp(request))

  def deleteElasticsearchServiceRole(
    request: DeleteElasticsearchServiceRoleRequest
  ): ElasticsearchIO[DeleteElasticsearchServiceRoleResponse] =
    FF.liftF(DeleteElasticsearchServiceRoleOp(request))

  def deleteInboundCrossClusterSearchConnection(
    request: DeleteInboundCrossClusterSearchConnectionRequest
  ): ElasticsearchIO[DeleteInboundCrossClusterSearchConnectionResponse] =
    FF.liftF(DeleteInboundCrossClusterSearchConnectionOp(request))

  def deleteOutboundCrossClusterSearchConnection(
    request: DeleteOutboundCrossClusterSearchConnectionRequest
  ): ElasticsearchIO[DeleteOutboundCrossClusterSearchConnectionResponse] =
    FF.liftF(DeleteOutboundCrossClusterSearchConnectionOp(request))

  def deletePackage(
    request: DeletePackageRequest
  ): ElasticsearchIO[DeletePackageResponse] =
    FF.liftF(DeletePackageOp(request))

  def describeDomainAutoTunes(
    request: DescribeDomainAutoTunesRequest
  ): ElasticsearchIO[DescribeDomainAutoTunesResponse] =
    FF.liftF(DescribeDomainAutoTunesOp(request))

  def describeElasticsearchDomain(
    request: DescribeElasticsearchDomainRequest
  ): ElasticsearchIO[DescribeElasticsearchDomainResponse] =
    FF.liftF(DescribeElasticsearchDomainOp(request))

  def describeElasticsearchDomainConfig(
    request: DescribeElasticsearchDomainConfigRequest
  ): ElasticsearchIO[DescribeElasticsearchDomainConfigResponse] =
    FF.liftF(DescribeElasticsearchDomainConfigOp(request))

  def describeElasticsearchDomains(
    request: DescribeElasticsearchDomainsRequest
  ): ElasticsearchIO[DescribeElasticsearchDomainsResponse] =
    FF.liftF(DescribeElasticsearchDomainsOp(request))

  def describeElasticsearchInstanceTypeLimits(
    request: DescribeElasticsearchInstanceTypeLimitsRequest
  ): ElasticsearchIO[DescribeElasticsearchInstanceTypeLimitsResponse] =
    FF.liftF(DescribeElasticsearchInstanceTypeLimitsOp(request))

  def describeInboundCrossClusterSearchConnections(
    request: DescribeInboundCrossClusterSearchConnectionsRequest
  ): ElasticsearchIO[DescribeInboundCrossClusterSearchConnectionsResponse] =
    FF.liftF(DescribeInboundCrossClusterSearchConnectionsOp(request))

  def describeOutboundCrossClusterSearchConnections(
    request: DescribeOutboundCrossClusterSearchConnectionsRequest
  ): ElasticsearchIO[DescribeOutboundCrossClusterSearchConnectionsResponse] =
    FF.liftF(DescribeOutboundCrossClusterSearchConnectionsOp(request))

  def describePackages(
    request: DescribePackagesRequest
  ): ElasticsearchIO[DescribePackagesResponse] =
    FF.liftF(DescribePackagesOp(request))

  def describeReservedElasticsearchInstanceOfferings(
    request: DescribeReservedElasticsearchInstanceOfferingsRequest
  ): ElasticsearchIO[DescribeReservedElasticsearchInstanceOfferingsResponse] =
    FF.liftF(DescribeReservedElasticsearchInstanceOfferingsOp(request))

  def describeReservedElasticsearchInstances(
    request: DescribeReservedElasticsearchInstancesRequest
  ): ElasticsearchIO[DescribeReservedElasticsearchInstancesResponse] =
    FF.liftF(DescribeReservedElasticsearchInstancesOp(request))

  def dissociatePackage(
    request: DissociatePackageRequest
  ): ElasticsearchIO[DissociatePackageResponse] =
    FF.liftF(DissociatePackageOp(request))

  def getCompatibleElasticsearchVersions(
    request: GetCompatibleElasticsearchVersionsRequest
  ): ElasticsearchIO[GetCompatibleElasticsearchVersionsResponse] =
    FF.liftF(GetCompatibleElasticsearchVersionsOp(request))

  def getPackageVersionHistory(
    request: GetPackageVersionHistoryRequest
  ): ElasticsearchIO[GetPackageVersionHistoryResponse] =
    FF.liftF(GetPackageVersionHistoryOp(request))

  def getUpgradeHistory(
    request: GetUpgradeHistoryRequest
  ): ElasticsearchIO[GetUpgradeHistoryResponse] =
    FF.liftF(GetUpgradeHistoryOp(request))

  def getUpgradeStatus(
    request: GetUpgradeStatusRequest
  ): ElasticsearchIO[GetUpgradeStatusResponse] =
    FF.liftF(GetUpgradeStatusOp(request))

  def listDomainNames(
    request: ListDomainNamesRequest
  ): ElasticsearchIO[ListDomainNamesResponse] =
    FF.liftF(ListDomainNamesOp(request))

  def listDomainsForPackage(
    request: ListDomainsForPackageRequest
  ): ElasticsearchIO[ListDomainsForPackageResponse] =
    FF.liftF(ListDomainsForPackageOp(request))

  def listElasticsearchInstanceTypes(
    request: ListElasticsearchInstanceTypesRequest
  ): ElasticsearchIO[ListElasticsearchInstanceTypesResponse] =
    FF.liftF(ListElasticsearchInstanceTypesOp(request))

  def listElasticsearchVersions(
    request: ListElasticsearchVersionsRequest
  ): ElasticsearchIO[ListElasticsearchVersionsResponse] =
    FF.liftF(ListElasticsearchVersionsOp(request))

  def listPackagesForDomain(
    request: ListPackagesForDomainRequest
  ): ElasticsearchIO[ListPackagesForDomainResponse] =
    FF.liftF(ListPackagesForDomainOp(request))

  def listTags(
    request: ListTagsRequest
  ): ElasticsearchIO[ListTagsResponse] =
    FF.liftF(ListTagsOp(request))

  def purchaseReservedElasticsearchInstanceOffering(
    request: PurchaseReservedElasticsearchInstanceOfferingRequest
  ): ElasticsearchIO[PurchaseReservedElasticsearchInstanceOfferingResponse] =
    FF.liftF(PurchaseReservedElasticsearchInstanceOfferingOp(request))

  def rejectInboundCrossClusterSearchConnection(
    request: RejectInboundCrossClusterSearchConnectionRequest
  ): ElasticsearchIO[RejectInboundCrossClusterSearchConnectionResponse] =
    FF.liftF(RejectInboundCrossClusterSearchConnectionOp(request))

  def removeTags(
    request: RemoveTagsRequest
  ): ElasticsearchIO[RemoveTagsResponse] =
    FF.liftF(RemoveTagsOp(request))

  def startElasticsearchServiceSoftwareUpdate(
    request: StartElasticsearchServiceSoftwareUpdateRequest
  ): ElasticsearchIO[StartElasticsearchServiceSoftwareUpdateResponse] =
    FF.liftF(StartElasticsearchServiceSoftwareUpdateOp(request))

  def updateElasticsearchDomainConfig(
    request: UpdateElasticsearchDomainConfigRequest
  ): ElasticsearchIO[UpdateElasticsearchDomainConfigResponse] =
    FF.liftF(UpdateElasticsearchDomainConfigOp(request))

  def updatePackage(
    request: UpdatePackageRequest
  ): ElasticsearchIO[UpdatePackageResponse] =
    FF.liftF(UpdatePackageOp(request))

  def upgradeElasticsearchDomain(
    request: UpgradeElasticsearchDomainRequest
  ): ElasticsearchIO[UpgradeElasticsearchDomainResponse] =
    FF.liftF(UpgradeElasticsearchDomainOp(request))
}
