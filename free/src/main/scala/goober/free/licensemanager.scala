package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.licensemanager.LicenseManagerClient
import software.amazon.awssdk.services.licensemanager.model._


object licensemanager { module =>

  // Free monad over LicenseManagerOp
  type LicenseManagerIO[A] = FF[LicenseManagerOp, A]

  sealed trait LicenseManagerOp[A] {
    def visit[F[_]](visitor: LicenseManagerOp.Visitor[F]): F[A]
  }

  object LicenseManagerOp {
    // Given a LicenseManagerClient we can embed a LicenseManagerIO program in any algebra that understands embedding.
    implicit val LicenseManagerOpEmbeddable: Embeddable[LicenseManagerOp, LicenseManagerClient] = new Embeddable[LicenseManagerOp, LicenseManagerClient] {
      def embed[A](client: LicenseManagerClient, io: LicenseManagerIO[A]): Embedded[A] = Embedded.LicenseManager(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends LicenseManagerOp.Visitor[Kleisli[M, LicenseManagerClient, *]] {
        def acceptGrant(
          request: AcceptGrantRequest
        ): Kleisli[M, LicenseManagerClient, AcceptGrantResponse] =
          primitive(_.acceptGrant(request))

        def checkInLicense(
          request: CheckInLicenseRequest
        ): Kleisli[M, LicenseManagerClient, CheckInLicenseResponse] =
          primitive(_.checkInLicense(request))

        def checkoutBorrowLicense(
          request: CheckoutBorrowLicenseRequest
        ): Kleisli[M, LicenseManagerClient, CheckoutBorrowLicenseResponse] =
          primitive(_.checkoutBorrowLicense(request))

        def checkoutLicense(
          request: CheckoutLicenseRequest
        ): Kleisli[M, LicenseManagerClient, CheckoutLicenseResponse] =
          primitive(_.checkoutLicense(request))

        def createGrant(
          request: CreateGrantRequest
        ): Kleisli[M, LicenseManagerClient, CreateGrantResponse] =
          primitive(_.createGrant(request))

        def createGrantVersion(
          request: CreateGrantVersionRequest
        ): Kleisli[M, LicenseManagerClient, CreateGrantVersionResponse] =
          primitive(_.createGrantVersion(request))

        def createLicense(
          request: CreateLicenseRequest
        ): Kleisli[M, LicenseManagerClient, CreateLicenseResponse] =
          primitive(_.createLicense(request))

        def createLicenseConfiguration(
          request: CreateLicenseConfigurationRequest
        ): Kleisli[M, LicenseManagerClient, CreateLicenseConfigurationResponse] =
          primitive(_.createLicenseConfiguration(request))

        def createLicenseManagerReportGenerator(
          request: CreateLicenseManagerReportGeneratorRequest
        ): Kleisli[M, LicenseManagerClient, CreateLicenseManagerReportGeneratorResponse] =
          primitive(_.createLicenseManagerReportGenerator(request))

        def createLicenseVersion(
          request: CreateLicenseVersionRequest
        ): Kleisli[M, LicenseManagerClient, CreateLicenseVersionResponse] =
          primitive(_.createLicenseVersion(request))

        def createToken(
          request: CreateTokenRequest
        ): Kleisli[M, LicenseManagerClient, CreateTokenResponse] =
          primitive(_.createToken(request))

        def deleteGrant(
          request: DeleteGrantRequest
        ): Kleisli[M, LicenseManagerClient, DeleteGrantResponse] =
          primitive(_.deleteGrant(request))

        def deleteLicense(
          request: DeleteLicenseRequest
        ): Kleisli[M, LicenseManagerClient, DeleteLicenseResponse] =
          primitive(_.deleteLicense(request))

        def deleteLicenseConfiguration(
          request: DeleteLicenseConfigurationRequest
        ): Kleisli[M, LicenseManagerClient, DeleteLicenseConfigurationResponse] =
          primitive(_.deleteLicenseConfiguration(request))

        def deleteLicenseManagerReportGenerator(
          request: DeleteLicenseManagerReportGeneratorRequest
        ): Kleisli[M, LicenseManagerClient, DeleteLicenseManagerReportGeneratorResponse] =
          primitive(_.deleteLicenseManagerReportGenerator(request))

        def deleteToken(
          request: DeleteTokenRequest
        ): Kleisli[M, LicenseManagerClient, DeleteTokenResponse] =
          primitive(_.deleteToken(request))

        def extendLicenseConsumption(
          request: ExtendLicenseConsumptionRequest
        ): Kleisli[M, LicenseManagerClient, ExtendLicenseConsumptionResponse] =
          primitive(_.extendLicenseConsumption(request))

        def getAccessToken(
          request: GetAccessTokenRequest
        ): Kleisli[M, LicenseManagerClient, GetAccessTokenResponse] =
          primitive(_.getAccessToken(request))

        def getGrant(
          request: GetGrantRequest
        ): Kleisli[M, LicenseManagerClient, GetGrantResponse] =
          primitive(_.getGrant(request))

        def getLicense(
          request: GetLicenseRequest
        ): Kleisli[M, LicenseManagerClient, GetLicenseResponse] =
          primitive(_.getLicense(request))

        def getLicenseConfiguration(
          request: GetLicenseConfigurationRequest
        ): Kleisli[M, LicenseManagerClient, GetLicenseConfigurationResponse] =
          primitive(_.getLicenseConfiguration(request))

        def getLicenseManagerReportGenerator(
          request: GetLicenseManagerReportGeneratorRequest
        ): Kleisli[M, LicenseManagerClient, GetLicenseManagerReportGeneratorResponse] =
          primitive(_.getLicenseManagerReportGenerator(request))

        def getLicenseUsage(
          request: GetLicenseUsageRequest
        ): Kleisli[M, LicenseManagerClient, GetLicenseUsageResponse] =
          primitive(_.getLicenseUsage(request))

        def getServiceSettings(
          request: GetServiceSettingsRequest
        ): Kleisli[M, LicenseManagerClient, GetServiceSettingsResponse] =
          primitive(_.getServiceSettings(request))

        def listAssociationsForLicenseConfiguration(
          request: ListAssociationsForLicenseConfigurationRequest
        ): Kleisli[M, LicenseManagerClient, ListAssociationsForLicenseConfigurationResponse] =
          primitive(_.listAssociationsForLicenseConfiguration(request))

        def listDistributedGrants(
          request: ListDistributedGrantsRequest
        ): Kleisli[M, LicenseManagerClient, ListDistributedGrantsResponse] =
          primitive(_.listDistributedGrants(request))

        def listFailuresForLicenseConfigurationOperations(
          request: ListFailuresForLicenseConfigurationOperationsRequest
        ): Kleisli[M, LicenseManagerClient, ListFailuresForLicenseConfigurationOperationsResponse] =
          primitive(_.listFailuresForLicenseConfigurationOperations(request))

        def listLicenseConfigurations(
          request: ListLicenseConfigurationsRequest
        ): Kleisli[M, LicenseManagerClient, ListLicenseConfigurationsResponse] =
          primitive(_.listLicenseConfigurations(request))

        def listLicenseManagerReportGenerators(
          request: ListLicenseManagerReportGeneratorsRequest
        ): Kleisli[M, LicenseManagerClient, ListLicenseManagerReportGeneratorsResponse] =
          primitive(_.listLicenseManagerReportGenerators(request))

        def listLicenseSpecificationsForResource(
          request: ListLicenseSpecificationsForResourceRequest
        ): Kleisli[M, LicenseManagerClient, ListLicenseSpecificationsForResourceResponse] =
          primitive(_.listLicenseSpecificationsForResource(request))

        def listLicenseVersions(
          request: ListLicenseVersionsRequest
        ): Kleisli[M, LicenseManagerClient, ListLicenseVersionsResponse] =
          primitive(_.listLicenseVersions(request))

        def listLicenses(
          request: ListLicensesRequest
        ): Kleisli[M, LicenseManagerClient, ListLicensesResponse] =
          primitive(_.listLicenses(request))

        def listReceivedGrants(
          request: ListReceivedGrantsRequest
        ): Kleisli[M, LicenseManagerClient, ListReceivedGrantsResponse] =
          primitive(_.listReceivedGrants(request))

        def listReceivedLicenses(
          request: ListReceivedLicensesRequest
        ): Kleisli[M, LicenseManagerClient, ListReceivedLicensesResponse] =
          primitive(_.listReceivedLicenses(request))

        def listResourceInventory(
          request: ListResourceInventoryRequest
        ): Kleisli[M, LicenseManagerClient, ListResourceInventoryResponse] =
          primitive(_.listResourceInventory(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, LicenseManagerClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTokens(
          request: ListTokensRequest
        ): Kleisli[M, LicenseManagerClient, ListTokensResponse] =
          primitive(_.listTokens(request))

        def listUsageForLicenseConfiguration(
          request: ListUsageForLicenseConfigurationRequest
        ): Kleisli[M, LicenseManagerClient, ListUsageForLicenseConfigurationResponse] =
          primitive(_.listUsageForLicenseConfiguration(request))

        def rejectGrant(
          request: RejectGrantRequest
        ): Kleisli[M, LicenseManagerClient, RejectGrantResponse] =
          primitive(_.rejectGrant(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, LicenseManagerClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, LicenseManagerClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateLicenseConfiguration(
          request: UpdateLicenseConfigurationRequest
        ): Kleisli[M, LicenseManagerClient, UpdateLicenseConfigurationResponse] =
          primitive(_.updateLicenseConfiguration(request))

        def updateLicenseManagerReportGenerator(
          request: UpdateLicenseManagerReportGeneratorRequest
        ): Kleisli[M, LicenseManagerClient, UpdateLicenseManagerReportGeneratorResponse] =
          primitive(_.updateLicenseManagerReportGenerator(request))

        def updateLicenseSpecificationsForResource(
          request: UpdateLicenseSpecificationsForResourceRequest
        ): Kleisli[M, LicenseManagerClient, UpdateLicenseSpecificationsForResourceResponse] =
          primitive(_.updateLicenseSpecificationsForResource(request))

        def updateServiceSettings(
          request: UpdateServiceSettingsRequest
        ): Kleisli[M, LicenseManagerClient, UpdateServiceSettingsResponse] =
          primitive(_.updateServiceSettings(request))

        def primitive[A](
          f: LicenseManagerClient => A
        ): Kleisli[M, LicenseManagerClient, A]
      }
    }

    trait Visitor[F[_]] extends (LicenseManagerOp ~> F) {
      final def apply[A](op: LicenseManagerOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptGrant(
        request: AcceptGrantRequest
      ): F[AcceptGrantResponse]

      def checkInLicense(
        request: CheckInLicenseRequest
      ): F[CheckInLicenseResponse]

      def checkoutBorrowLicense(
        request: CheckoutBorrowLicenseRequest
      ): F[CheckoutBorrowLicenseResponse]

      def checkoutLicense(
        request: CheckoutLicenseRequest
      ): F[CheckoutLicenseResponse]

      def createGrant(
        request: CreateGrantRequest
      ): F[CreateGrantResponse]

      def createGrantVersion(
        request: CreateGrantVersionRequest
      ): F[CreateGrantVersionResponse]

      def createLicense(
        request: CreateLicenseRequest
      ): F[CreateLicenseResponse]

      def createLicenseConfiguration(
        request: CreateLicenseConfigurationRequest
      ): F[CreateLicenseConfigurationResponse]

      def createLicenseManagerReportGenerator(
        request: CreateLicenseManagerReportGeneratorRequest
      ): F[CreateLicenseManagerReportGeneratorResponse]

      def createLicenseVersion(
        request: CreateLicenseVersionRequest
      ): F[CreateLicenseVersionResponse]

      def createToken(
        request: CreateTokenRequest
      ): F[CreateTokenResponse]

      def deleteGrant(
        request: DeleteGrantRequest
      ): F[DeleteGrantResponse]

      def deleteLicense(
        request: DeleteLicenseRequest
      ): F[DeleteLicenseResponse]

      def deleteLicenseConfiguration(
        request: DeleteLicenseConfigurationRequest
      ): F[DeleteLicenseConfigurationResponse]

      def deleteLicenseManagerReportGenerator(
        request: DeleteLicenseManagerReportGeneratorRequest
      ): F[DeleteLicenseManagerReportGeneratorResponse]

      def deleteToken(
        request: DeleteTokenRequest
      ): F[DeleteTokenResponse]

      def extendLicenseConsumption(
        request: ExtendLicenseConsumptionRequest
      ): F[ExtendLicenseConsumptionResponse]

      def getAccessToken(
        request: GetAccessTokenRequest
      ): F[GetAccessTokenResponse]

      def getGrant(
        request: GetGrantRequest
      ): F[GetGrantResponse]

      def getLicense(
        request: GetLicenseRequest
      ): F[GetLicenseResponse]

      def getLicenseConfiguration(
        request: GetLicenseConfigurationRequest
      ): F[GetLicenseConfigurationResponse]

      def getLicenseManagerReportGenerator(
        request: GetLicenseManagerReportGeneratorRequest
      ): F[GetLicenseManagerReportGeneratorResponse]

      def getLicenseUsage(
        request: GetLicenseUsageRequest
      ): F[GetLicenseUsageResponse]

      def getServiceSettings(
        request: GetServiceSettingsRequest
      ): F[GetServiceSettingsResponse]

      def listAssociationsForLicenseConfiguration(
        request: ListAssociationsForLicenseConfigurationRequest
      ): F[ListAssociationsForLicenseConfigurationResponse]

      def listDistributedGrants(
        request: ListDistributedGrantsRequest
      ): F[ListDistributedGrantsResponse]

      def listFailuresForLicenseConfigurationOperations(
        request: ListFailuresForLicenseConfigurationOperationsRequest
      ): F[ListFailuresForLicenseConfigurationOperationsResponse]

      def listLicenseConfigurations(
        request: ListLicenseConfigurationsRequest
      ): F[ListLicenseConfigurationsResponse]

      def listLicenseManagerReportGenerators(
        request: ListLicenseManagerReportGeneratorsRequest
      ): F[ListLicenseManagerReportGeneratorsResponse]

      def listLicenseSpecificationsForResource(
        request: ListLicenseSpecificationsForResourceRequest
      ): F[ListLicenseSpecificationsForResourceResponse]

      def listLicenseVersions(
        request: ListLicenseVersionsRequest
      ): F[ListLicenseVersionsResponse]

      def listLicenses(
        request: ListLicensesRequest
      ): F[ListLicensesResponse]

      def listReceivedGrants(
        request: ListReceivedGrantsRequest
      ): F[ListReceivedGrantsResponse]

      def listReceivedLicenses(
        request: ListReceivedLicensesRequest
      ): F[ListReceivedLicensesResponse]

      def listResourceInventory(
        request: ListResourceInventoryRequest
      ): F[ListResourceInventoryResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTokens(
        request: ListTokensRequest
      ): F[ListTokensResponse]

      def listUsageForLicenseConfiguration(
        request: ListUsageForLicenseConfigurationRequest
      ): F[ListUsageForLicenseConfigurationResponse]

      def rejectGrant(
        request: RejectGrantRequest
      ): F[RejectGrantResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateLicenseConfiguration(
        request: UpdateLicenseConfigurationRequest
      ): F[UpdateLicenseConfigurationResponse]

      def updateLicenseManagerReportGenerator(
        request: UpdateLicenseManagerReportGeneratorRequest
      ): F[UpdateLicenseManagerReportGeneratorResponse]

      def updateLicenseSpecificationsForResource(
        request: UpdateLicenseSpecificationsForResourceRequest
      ): F[UpdateLicenseSpecificationsForResourceResponse]

      def updateServiceSettings(
        request: UpdateServiceSettingsRequest
      ): F[UpdateServiceSettingsResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends LicenseManagerOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptGrantOp(
      request: AcceptGrantRequest
    ) extends LicenseManagerOp[AcceptGrantResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptGrantResponse] =
        visitor.acceptGrant(request)
    }

    final case class CheckInLicenseOp(
      request: CheckInLicenseRequest
    ) extends LicenseManagerOp[CheckInLicenseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CheckInLicenseResponse] =
        visitor.checkInLicense(request)
    }

    final case class CheckoutBorrowLicenseOp(
      request: CheckoutBorrowLicenseRequest
    ) extends LicenseManagerOp[CheckoutBorrowLicenseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CheckoutBorrowLicenseResponse] =
        visitor.checkoutBorrowLicense(request)
    }

    final case class CheckoutLicenseOp(
      request: CheckoutLicenseRequest
    ) extends LicenseManagerOp[CheckoutLicenseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CheckoutLicenseResponse] =
        visitor.checkoutLicense(request)
    }

    final case class CreateGrantOp(
      request: CreateGrantRequest
    ) extends LicenseManagerOp[CreateGrantResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGrantResponse] =
        visitor.createGrant(request)
    }

    final case class CreateGrantVersionOp(
      request: CreateGrantVersionRequest
    ) extends LicenseManagerOp[CreateGrantVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGrantVersionResponse] =
        visitor.createGrantVersion(request)
    }

    final case class CreateLicenseOp(
      request: CreateLicenseRequest
    ) extends LicenseManagerOp[CreateLicenseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLicenseResponse] =
        visitor.createLicense(request)
    }

    final case class CreateLicenseConfigurationOp(
      request: CreateLicenseConfigurationRequest
    ) extends LicenseManagerOp[CreateLicenseConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLicenseConfigurationResponse] =
        visitor.createLicenseConfiguration(request)
    }

    final case class CreateLicenseManagerReportGeneratorOp(
      request: CreateLicenseManagerReportGeneratorRequest
    ) extends LicenseManagerOp[CreateLicenseManagerReportGeneratorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLicenseManagerReportGeneratorResponse] =
        visitor.createLicenseManagerReportGenerator(request)
    }

    final case class CreateLicenseVersionOp(
      request: CreateLicenseVersionRequest
    ) extends LicenseManagerOp[CreateLicenseVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLicenseVersionResponse] =
        visitor.createLicenseVersion(request)
    }

    final case class CreateTokenOp(
      request: CreateTokenRequest
    ) extends LicenseManagerOp[CreateTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTokenResponse] =
        visitor.createToken(request)
    }

    final case class DeleteGrantOp(
      request: DeleteGrantRequest
    ) extends LicenseManagerOp[DeleteGrantResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGrantResponse] =
        visitor.deleteGrant(request)
    }

    final case class DeleteLicenseOp(
      request: DeleteLicenseRequest
    ) extends LicenseManagerOp[DeleteLicenseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLicenseResponse] =
        visitor.deleteLicense(request)
    }

    final case class DeleteLicenseConfigurationOp(
      request: DeleteLicenseConfigurationRequest
    ) extends LicenseManagerOp[DeleteLicenseConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLicenseConfigurationResponse] =
        visitor.deleteLicenseConfiguration(request)
    }

    final case class DeleteLicenseManagerReportGeneratorOp(
      request: DeleteLicenseManagerReportGeneratorRequest
    ) extends LicenseManagerOp[DeleteLicenseManagerReportGeneratorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLicenseManagerReportGeneratorResponse] =
        visitor.deleteLicenseManagerReportGenerator(request)
    }

    final case class DeleteTokenOp(
      request: DeleteTokenRequest
    ) extends LicenseManagerOp[DeleteTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTokenResponse] =
        visitor.deleteToken(request)
    }

    final case class ExtendLicenseConsumptionOp(
      request: ExtendLicenseConsumptionRequest
    ) extends LicenseManagerOp[ExtendLicenseConsumptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExtendLicenseConsumptionResponse] =
        visitor.extendLicenseConsumption(request)
    }

    final case class GetAccessTokenOp(
      request: GetAccessTokenRequest
    ) extends LicenseManagerOp[GetAccessTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccessTokenResponse] =
        visitor.getAccessToken(request)
    }

    final case class GetGrantOp(
      request: GetGrantRequest
    ) extends LicenseManagerOp[GetGrantResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGrantResponse] =
        visitor.getGrant(request)
    }

    final case class GetLicenseOp(
      request: GetLicenseRequest
    ) extends LicenseManagerOp[GetLicenseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLicenseResponse] =
        visitor.getLicense(request)
    }

    final case class GetLicenseConfigurationOp(
      request: GetLicenseConfigurationRequest
    ) extends LicenseManagerOp[GetLicenseConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLicenseConfigurationResponse] =
        visitor.getLicenseConfiguration(request)
    }

    final case class GetLicenseManagerReportGeneratorOp(
      request: GetLicenseManagerReportGeneratorRequest
    ) extends LicenseManagerOp[GetLicenseManagerReportGeneratorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLicenseManagerReportGeneratorResponse] =
        visitor.getLicenseManagerReportGenerator(request)
    }

    final case class GetLicenseUsageOp(
      request: GetLicenseUsageRequest
    ) extends LicenseManagerOp[GetLicenseUsageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLicenseUsageResponse] =
        visitor.getLicenseUsage(request)
    }

    final case class GetServiceSettingsOp(
      request: GetServiceSettingsRequest
    ) extends LicenseManagerOp[GetServiceSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetServiceSettingsResponse] =
        visitor.getServiceSettings(request)
    }

    final case class ListAssociationsForLicenseConfigurationOp(
      request: ListAssociationsForLicenseConfigurationRequest
    ) extends LicenseManagerOp[ListAssociationsForLicenseConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssociationsForLicenseConfigurationResponse] =
        visitor.listAssociationsForLicenseConfiguration(request)
    }

    final case class ListDistributedGrantsOp(
      request: ListDistributedGrantsRequest
    ) extends LicenseManagerOp[ListDistributedGrantsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDistributedGrantsResponse] =
        visitor.listDistributedGrants(request)
    }

    final case class ListFailuresForLicenseConfigurationOperationsOp(
      request: ListFailuresForLicenseConfigurationOperationsRequest
    ) extends LicenseManagerOp[ListFailuresForLicenseConfigurationOperationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFailuresForLicenseConfigurationOperationsResponse] =
        visitor.listFailuresForLicenseConfigurationOperations(request)
    }

    final case class ListLicenseConfigurationsOp(
      request: ListLicenseConfigurationsRequest
    ) extends LicenseManagerOp[ListLicenseConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLicenseConfigurationsResponse] =
        visitor.listLicenseConfigurations(request)
    }

    final case class ListLicenseManagerReportGeneratorsOp(
      request: ListLicenseManagerReportGeneratorsRequest
    ) extends LicenseManagerOp[ListLicenseManagerReportGeneratorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLicenseManagerReportGeneratorsResponse] =
        visitor.listLicenseManagerReportGenerators(request)
    }

    final case class ListLicenseSpecificationsForResourceOp(
      request: ListLicenseSpecificationsForResourceRequest
    ) extends LicenseManagerOp[ListLicenseSpecificationsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLicenseSpecificationsForResourceResponse] =
        visitor.listLicenseSpecificationsForResource(request)
    }

    final case class ListLicenseVersionsOp(
      request: ListLicenseVersionsRequest
    ) extends LicenseManagerOp[ListLicenseVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLicenseVersionsResponse] =
        visitor.listLicenseVersions(request)
    }

    final case class ListLicensesOp(
      request: ListLicensesRequest
    ) extends LicenseManagerOp[ListLicensesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLicensesResponse] =
        visitor.listLicenses(request)
    }

    final case class ListReceivedGrantsOp(
      request: ListReceivedGrantsRequest
    ) extends LicenseManagerOp[ListReceivedGrantsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListReceivedGrantsResponse] =
        visitor.listReceivedGrants(request)
    }

    final case class ListReceivedLicensesOp(
      request: ListReceivedLicensesRequest
    ) extends LicenseManagerOp[ListReceivedLicensesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListReceivedLicensesResponse] =
        visitor.listReceivedLicenses(request)
    }

    final case class ListResourceInventoryOp(
      request: ListResourceInventoryRequest
    ) extends LicenseManagerOp[ListResourceInventoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResourceInventoryResponse] =
        visitor.listResourceInventory(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends LicenseManagerOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTokensOp(
      request: ListTokensRequest
    ) extends LicenseManagerOp[ListTokensResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTokensResponse] =
        visitor.listTokens(request)
    }

    final case class ListUsageForLicenseConfigurationOp(
      request: ListUsageForLicenseConfigurationRequest
    ) extends LicenseManagerOp[ListUsageForLicenseConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUsageForLicenseConfigurationResponse] =
        visitor.listUsageForLicenseConfiguration(request)
    }

    final case class RejectGrantOp(
      request: RejectGrantRequest
    ) extends LicenseManagerOp[RejectGrantResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RejectGrantResponse] =
        visitor.rejectGrant(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends LicenseManagerOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends LicenseManagerOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateLicenseConfigurationOp(
      request: UpdateLicenseConfigurationRequest
    ) extends LicenseManagerOp[UpdateLicenseConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLicenseConfigurationResponse] =
        visitor.updateLicenseConfiguration(request)
    }

    final case class UpdateLicenseManagerReportGeneratorOp(
      request: UpdateLicenseManagerReportGeneratorRequest
    ) extends LicenseManagerOp[UpdateLicenseManagerReportGeneratorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLicenseManagerReportGeneratorResponse] =
        visitor.updateLicenseManagerReportGenerator(request)
    }

    final case class UpdateLicenseSpecificationsForResourceOp(
      request: UpdateLicenseSpecificationsForResourceRequest
    ) extends LicenseManagerOp[UpdateLicenseSpecificationsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLicenseSpecificationsForResourceResponse] =
        visitor.updateLicenseSpecificationsForResource(request)
    }

    final case class UpdateServiceSettingsOp(
      request: UpdateServiceSettingsRequest
    ) extends LicenseManagerOp[UpdateServiceSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateServiceSettingsResponse] =
        visitor.updateServiceSettings(request)
    }
  }

  import LicenseManagerOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[LicenseManagerOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptGrant(
    request: AcceptGrantRequest
  ): LicenseManagerIO[AcceptGrantResponse] =
    FF.liftF(AcceptGrantOp(request))

  def checkInLicense(
    request: CheckInLicenseRequest
  ): LicenseManagerIO[CheckInLicenseResponse] =
    FF.liftF(CheckInLicenseOp(request))

  def checkoutBorrowLicense(
    request: CheckoutBorrowLicenseRequest
  ): LicenseManagerIO[CheckoutBorrowLicenseResponse] =
    FF.liftF(CheckoutBorrowLicenseOp(request))

  def checkoutLicense(
    request: CheckoutLicenseRequest
  ): LicenseManagerIO[CheckoutLicenseResponse] =
    FF.liftF(CheckoutLicenseOp(request))

  def createGrant(
    request: CreateGrantRequest
  ): LicenseManagerIO[CreateGrantResponse] =
    FF.liftF(CreateGrantOp(request))

  def createGrantVersion(
    request: CreateGrantVersionRequest
  ): LicenseManagerIO[CreateGrantVersionResponse] =
    FF.liftF(CreateGrantVersionOp(request))

  def createLicense(
    request: CreateLicenseRequest
  ): LicenseManagerIO[CreateLicenseResponse] =
    FF.liftF(CreateLicenseOp(request))

  def createLicenseConfiguration(
    request: CreateLicenseConfigurationRequest
  ): LicenseManagerIO[CreateLicenseConfigurationResponse] =
    FF.liftF(CreateLicenseConfigurationOp(request))

  def createLicenseManagerReportGenerator(
    request: CreateLicenseManagerReportGeneratorRequest
  ): LicenseManagerIO[CreateLicenseManagerReportGeneratorResponse] =
    FF.liftF(CreateLicenseManagerReportGeneratorOp(request))

  def createLicenseVersion(
    request: CreateLicenseVersionRequest
  ): LicenseManagerIO[CreateLicenseVersionResponse] =
    FF.liftF(CreateLicenseVersionOp(request))

  def createToken(
    request: CreateTokenRequest
  ): LicenseManagerIO[CreateTokenResponse] =
    FF.liftF(CreateTokenOp(request))

  def deleteGrant(
    request: DeleteGrantRequest
  ): LicenseManagerIO[DeleteGrantResponse] =
    FF.liftF(DeleteGrantOp(request))

  def deleteLicense(
    request: DeleteLicenseRequest
  ): LicenseManagerIO[DeleteLicenseResponse] =
    FF.liftF(DeleteLicenseOp(request))

  def deleteLicenseConfiguration(
    request: DeleteLicenseConfigurationRequest
  ): LicenseManagerIO[DeleteLicenseConfigurationResponse] =
    FF.liftF(DeleteLicenseConfigurationOp(request))

  def deleteLicenseManagerReportGenerator(
    request: DeleteLicenseManagerReportGeneratorRequest
  ): LicenseManagerIO[DeleteLicenseManagerReportGeneratorResponse] =
    FF.liftF(DeleteLicenseManagerReportGeneratorOp(request))

  def deleteToken(
    request: DeleteTokenRequest
  ): LicenseManagerIO[DeleteTokenResponse] =
    FF.liftF(DeleteTokenOp(request))

  def extendLicenseConsumption(
    request: ExtendLicenseConsumptionRequest
  ): LicenseManagerIO[ExtendLicenseConsumptionResponse] =
    FF.liftF(ExtendLicenseConsumptionOp(request))

  def getAccessToken(
    request: GetAccessTokenRequest
  ): LicenseManagerIO[GetAccessTokenResponse] =
    FF.liftF(GetAccessTokenOp(request))

  def getGrant(
    request: GetGrantRequest
  ): LicenseManagerIO[GetGrantResponse] =
    FF.liftF(GetGrantOp(request))

  def getLicense(
    request: GetLicenseRequest
  ): LicenseManagerIO[GetLicenseResponse] =
    FF.liftF(GetLicenseOp(request))

  def getLicenseConfiguration(
    request: GetLicenseConfigurationRequest
  ): LicenseManagerIO[GetLicenseConfigurationResponse] =
    FF.liftF(GetLicenseConfigurationOp(request))

  def getLicenseManagerReportGenerator(
    request: GetLicenseManagerReportGeneratorRequest
  ): LicenseManagerIO[GetLicenseManagerReportGeneratorResponse] =
    FF.liftF(GetLicenseManagerReportGeneratorOp(request))

  def getLicenseUsage(
    request: GetLicenseUsageRequest
  ): LicenseManagerIO[GetLicenseUsageResponse] =
    FF.liftF(GetLicenseUsageOp(request))

  def getServiceSettings(
    request: GetServiceSettingsRequest
  ): LicenseManagerIO[GetServiceSettingsResponse] =
    FF.liftF(GetServiceSettingsOp(request))

  def listAssociationsForLicenseConfiguration(
    request: ListAssociationsForLicenseConfigurationRequest
  ): LicenseManagerIO[ListAssociationsForLicenseConfigurationResponse] =
    FF.liftF(ListAssociationsForLicenseConfigurationOp(request))

  def listDistributedGrants(
    request: ListDistributedGrantsRequest
  ): LicenseManagerIO[ListDistributedGrantsResponse] =
    FF.liftF(ListDistributedGrantsOp(request))

  def listFailuresForLicenseConfigurationOperations(
    request: ListFailuresForLicenseConfigurationOperationsRequest
  ): LicenseManagerIO[ListFailuresForLicenseConfigurationOperationsResponse] =
    FF.liftF(ListFailuresForLicenseConfigurationOperationsOp(request))

  def listLicenseConfigurations(
    request: ListLicenseConfigurationsRequest
  ): LicenseManagerIO[ListLicenseConfigurationsResponse] =
    FF.liftF(ListLicenseConfigurationsOp(request))

  def listLicenseManagerReportGenerators(
    request: ListLicenseManagerReportGeneratorsRequest
  ): LicenseManagerIO[ListLicenseManagerReportGeneratorsResponse] =
    FF.liftF(ListLicenseManagerReportGeneratorsOp(request))

  def listLicenseSpecificationsForResource(
    request: ListLicenseSpecificationsForResourceRequest
  ): LicenseManagerIO[ListLicenseSpecificationsForResourceResponse] =
    FF.liftF(ListLicenseSpecificationsForResourceOp(request))

  def listLicenseVersions(
    request: ListLicenseVersionsRequest
  ): LicenseManagerIO[ListLicenseVersionsResponse] =
    FF.liftF(ListLicenseVersionsOp(request))

  def listLicenses(
    request: ListLicensesRequest
  ): LicenseManagerIO[ListLicensesResponse] =
    FF.liftF(ListLicensesOp(request))

  def listReceivedGrants(
    request: ListReceivedGrantsRequest
  ): LicenseManagerIO[ListReceivedGrantsResponse] =
    FF.liftF(ListReceivedGrantsOp(request))

  def listReceivedLicenses(
    request: ListReceivedLicensesRequest
  ): LicenseManagerIO[ListReceivedLicensesResponse] =
    FF.liftF(ListReceivedLicensesOp(request))

  def listResourceInventory(
    request: ListResourceInventoryRequest
  ): LicenseManagerIO[ListResourceInventoryResponse] =
    FF.liftF(ListResourceInventoryOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): LicenseManagerIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTokens(
    request: ListTokensRequest
  ): LicenseManagerIO[ListTokensResponse] =
    FF.liftF(ListTokensOp(request))

  def listUsageForLicenseConfiguration(
    request: ListUsageForLicenseConfigurationRequest
  ): LicenseManagerIO[ListUsageForLicenseConfigurationResponse] =
    FF.liftF(ListUsageForLicenseConfigurationOp(request))

  def rejectGrant(
    request: RejectGrantRequest
  ): LicenseManagerIO[RejectGrantResponse] =
    FF.liftF(RejectGrantOp(request))

  def tagResource(
    request: TagResourceRequest
  ): LicenseManagerIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): LicenseManagerIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateLicenseConfiguration(
    request: UpdateLicenseConfigurationRequest
  ): LicenseManagerIO[UpdateLicenseConfigurationResponse] =
    FF.liftF(UpdateLicenseConfigurationOp(request))

  def updateLicenseManagerReportGenerator(
    request: UpdateLicenseManagerReportGeneratorRequest
  ): LicenseManagerIO[UpdateLicenseManagerReportGeneratorResponse] =
    FF.liftF(UpdateLicenseManagerReportGeneratorOp(request))

  def updateLicenseSpecificationsForResource(
    request: UpdateLicenseSpecificationsForResourceRequest
  ): LicenseManagerIO[UpdateLicenseSpecificationsForResourceResponse] =
    FF.liftF(UpdateLicenseSpecificationsForResourceOp(request))

  def updateServiceSettings(
    request: UpdateServiceSettingsRequest
  ): LicenseManagerIO[UpdateServiceSettingsResponse] =
    FF.liftF(UpdateServiceSettingsOp(request))
}
