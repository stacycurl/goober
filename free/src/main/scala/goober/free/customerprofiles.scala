package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.customerprofiles.CustomerProfilesClient
import software.amazon.awssdk.services.customerprofiles.model._


object customerprofiles { module =>

  // Free monad over CustomerProfilesOp
  type CustomerProfilesIO[A] = FF[CustomerProfilesOp, A]

  sealed trait CustomerProfilesOp[A] {
    def visit[F[_]](visitor: CustomerProfilesOp.Visitor[F]): F[A]
  }

  object CustomerProfilesOp {
    // Given a CustomerProfilesClient we can embed a CustomerProfilesIO program in any algebra that understands embedding.
    implicit val CustomerProfilesOpEmbeddable: Embeddable[CustomerProfilesOp, CustomerProfilesClient] = new Embeddable[CustomerProfilesOp, CustomerProfilesClient] {
      def embed[A](client: CustomerProfilesClient, io: CustomerProfilesIO[A]): Embedded[A] = Embedded.CustomerProfiles(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CustomerProfilesOp.Visitor[Kleisli[M, CustomerProfilesClient, *]] {
        def addProfileKey(
          request: AddProfileKeyRequest
        ): Kleisli[M, CustomerProfilesClient, AddProfileKeyResponse] =
          primitive(_.addProfileKey(request))

        def createDomain(
          request: CreateDomainRequest
        ): Kleisli[M, CustomerProfilesClient, CreateDomainResponse] =
          primitive(_.createDomain(request))

        def createProfile(
          request: CreateProfileRequest
        ): Kleisli[M, CustomerProfilesClient, CreateProfileResponse] =
          primitive(_.createProfile(request))

        def deleteDomain(
          request: DeleteDomainRequest
        ): Kleisli[M, CustomerProfilesClient, DeleteDomainResponse] =
          primitive(_.deleteDomain(request))

        def deleteIntegration(
          request: DeleteIntegrationRequest
        ): Kleisli[M, CustomerProfilesClient, DeleteIntegrationResponse] =
          primitive(_.deleteIntegration(request))

        def deleteProfile(
          request: DeleteProfileRequest
        ): Kleisli[M, CustomerProfilesClient, DeleteProfileResponse] =
          primitive(_.deleteProfile(request))

        def deleteProfileKey(
          request: DeleteProfileKeyRequest
        ): Kleisli[M, CustomerProfilesClient, DeleteProfileKeyResponse] =
          primitive(_.deleteProfileKey(request))

        def deleteProfileObject(
          request: DeleteProfileObjectRequest
        ): Kleisli[M, CustomerProfilesClient, DeleteProfileObjectResponse] =
          primitive(_.deleteProfileObject(request))

        def deleteProfileObjectType(
          request: DeleteProfileObjectTypeRequest
        ): Kleisli[M, CustomerProfilesClient, DeleteProfileObjectTypeResponse] =
          primitive(_.deleteProfileObjectType(request))

        def getDomain(
          request: GetDomainRequest
        ): Kleisli[M, CustomerProfilesClient, GetDomainResponse] =
          primitive(_.getDomain(request))

        def getIntegration(
          request: GetIntegrationRequest
        ): Kleisli[M, CustomerProfilesClient, GetIntegrationResponse] =
          primitive(_.getIntegration(request))

        def getMatches(
          request: GetMatchesRequest
        ): Kleisli[M, CustomerProfilesClient, GetMatchesResponse] =
          primitive(_.getMatches(request))

        def getProfileObjectType(
          request: GetProfileObjectTypeRequest
        ): Kleisli[M, CustomerProfilesClient, GetProfileObjectTypeResponse] =
          primitive(_.getProfileObjectType(request))

        def getProfileObjectTypeTemplate(
          request: GetProfileObjectTypeTemplateRequest
        ): Kleisli[M, CustomerProfilesClient, GetProfileObjectTypeTemplateResponse] =
          primitive(_.getProfileObjectTypeTemplate(request))

        def listAccountIntegrations(
          request: ListAccountIntegrationsRequest
        ): Kleisli[M, CustomerProfilesClient, ListAccountIntegrationsResponse] =
          primitive(_.listAccountIntegrations(request))

        def listDomains(
          request: ListDomainsRequest
        ): Kleisli[M, CustomerProfilesClient, ListDomainsResponse] =
          primitive(_.listDomains(request))

        def listIntegrations(
          request: ListIntegrationsRequest
        ): Kleisli[M, CustomerProfilesClient, ListIntegrationsResponse] =
          primitive(_.listIntegrations(request))

        def listProfileObjectTypeTemplates(
          request: ListProfileObjectTypeTemplatesRequest
        ): Kleisli[M, CustomerProfilesClient, ListProfileObjectTypeTemplatesResponse] =
          primitive(_.listProfileObjectTypeTemplates(request))

        def listProfileObjectTypes(
          request: ListProfileObjectTypesRequest
        ): Kleisli[M, CustomerProfilesClient, ListProfileObjectTypesResponse] =
          primitive(_.listProfileObjectTypes(request))

        def listProfileObjects(
          request: ListProfileObjectsRequest
        ): Kleisli[M, CustomerProfilesClient, ListProfileObjectsResponse] =
          primitive(_.listProfileObjects(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, CustomerProfilesClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def mergeProfiles(
          request: MergeProfilesRequest
        ): Kleisli[M, CustomerProfilesClient, MergeProfilesResponse] =
          primitive(_.mergeProfiles(request))

        def putIntegration(
          request: PutIntegrationRequest
        ): Kleisli[M, CustomerProfilesClient, PutIntegrationResponse] =
          primitive(_.putIntegration(request))

        def putProfileObject(
          request: PutProfileObjectRequest
        ): Kleisli[M, CustomerProfilesClient, PutProfileObjectResponse] =
          primitive(_.putProfileObject(request))

        def putProfileObjectType(
          request: PutProfileObjectTypeRequest
        ): Kleisli[M, CustomerProfilesClient, PutProfileObjectTypeResponse] =
          primitive(_.putProfileObjectType(request))

        def searchProfiles(
          request: SearchProfilesRequest
        ): Kleisli[M, CustomerProfilesClient, SearchProfilesResponse] =
          primitive(_.searchProfiles(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, CustomerProfilesClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, CustomerProfilesClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateDomain(
          request: UpdateDomainRequest
        ): Kleisli[M, CustomerProfilesClient, UpdateDomainResponse] =
          primitive(_.updateDomain(request))

        def updateProfile(
          request: UpdateProfileRequest
        ): Kleisli[M, CustomerProfilesClient, UpdateProfileResponse] =
          primitive(_.updateProfile(request))

        def primitive[A](
          f: CustomerProfilesClient => A
        ): Kleisli[M, CustomerProfilesClient, A]
      }
    }

    trait Visitor[F[_]] extends (CustomerProfilesOp ~> F) {
      final def apply[A](op: CustomerProfilesOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addProfileKey(
        request: AddProfileKeyRequest
      ): F[AddProfileKeyResponse]

      def createDomain(
        request: CreateDomainRequest
      ): F[CreateDomainResponse]

      def createProfile(
        request: CreateProfileRequest
      ): F[CreateProfileResponse]

      def deleteDomain(
        request: DeleteDomainRequest
      ): F[DeleteDomainResponse]

      def deleteIntegration(
        request: DeleteIntegrationRequest
      ): F[DeleteIntegrationResponse]

      def deleteProfile(
        request: DeleteProfileRequest
      ): F[DeleteProfileResponse]

      def deleteProfileKey(
        request: DeleteProfileKeyRequest
      ): F[DeleteProfileKeyResponse]

      def deleteProfileObject(
        request: DeleteProfileObjectRequest
      ): F[DeleteProfileObjectResponse]

      def deleteProfileObjectType(
        request: DeleteProfileObjectTypeRequest
      ): F[DeleteProfileObjectTypeResponse]

      def getDomain(
        request: GetDomainRequest
      ): F[GetDomainResponse]

      def getIntegration(
        request: GetIntegrationRequest
      ): F[GetIntegrationResponse]

      def getMatches(
        request: GetMatchesRequest
      ): F[GetMatchesResponse]

      def getProfileObjectType(
        request: GetProfileObjectTypeRequest
      ): F[GetProfileObjectTypeResponse]

      def getProfileObjectTypeTemplate(
        request: GetProfileObjectTypeTemplateRequest
      ): F[GetProfileObjectTypeTemplateResponse]

      def listAccountIntegrations(
        request: ListAccountIntegrationsRequest
      ): F[ListAccountIntegrationsResponse]

      def listDomains(
        request: ListDomainsRequest
      ): F[ListDomainsResponse]

      def listIntegrations(
        request: ListIntegrationsRequest
      ): F[ListIntegrationsResponse]

      def listProfileObjectTypeTemplates(
        request: ListProfileObjectTypeTemplatesRequest
      ): F[ListProfileObjectTypeTemplatesResponse]

      def listProfileObjectTypes(
        request: ListProfileObjectTypesRequest
      ): F[ListProfileObjectTypesResponse]

      def listProfileObjects(
        request: ListProfileObjectsRequest
      ): F[ListProfileObjectsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def mergeProfiles(
        request: MergeProfilesRequest
      ): F[MergeProfilesResponse]

      def putIntegration(
        request: PutIntegrationRequest
      ): F[PutIntegrationResponse]

      def putProfileObject(
        request: PutProfileObjectRequest
      ): F[PutProfileObjectResponse]

      def putProfileObjectType(
        request: PutProfileObjectTypeRequest
      ): F[PutProfileObjectTypeResponse]

      def searchProfiles(
        request: SearchProfilesRequest
      ): F[SearchProfilesResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateDomain(
        request: UpdateDomainRequest
      ): F[UpdateDomainResponse]

      def updateProfile(
        request: UpdateProfileRequest
      ): F[UpdateProfileResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CustomerProfilesOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddProfileKeyOp(
      request: AddProfileKeyRequest
    ) extends CustomerProfilesOp[AddProfileKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddProfileKeyResponse] =
        visitor.addProfileKey(request)
    }

    final case class CreateDomainOp(
      request: CreateDomainRequest
    ) extends CustomerProfilesOp[CreateDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDomainResponse] =
        visitor.createDomain(request)
    }

    final case class CreateProfileOp(
      request: CreateProfileRequest
    ) extends CustomerProfilesOp[CreateProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProfileResponse] =
        visitor.createProfile(request)
    }

    final case class DeleteDomainOp(
      request: DeleteDomainRequest
    ) extends CustomerProfilesOp[DeleteDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDomainResponse] =
        visitor.deleteDomain(request)
    }

    final case class DeleteIntegrationOp(
      request: DeleteIntegrationRequest
    ) extends CustomerProfilesOp[DeleteIntegrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIntegrationResponse] =
        visitor.deleteIntegration(request)
    }

    final case class DeleteProfileOp(
      request: DeleteProfileRequest
    ) extends CustomerProfilesOp[DeleteProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProfileResponse] =
        visitor.deleteProfile(request)
    }

    final case class DeleteProfileKeyOp(
      request: DeleteProfileKeyRequest
    ) extends CustomerProfilesOp[DeleteProfileKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProfileKeyResponse] =
        visitor.deleteProfileKey(request)
    }

    final case class DeleteProfileObjectOp(
      request: DeleteProfileObjectRequest
    ) extends CustomerProfilesOp[DeleteProfileObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProfileObjectResponse] =
        visitor.deleteProfileObject(request)
    }

    final case class DeleteProfileObjectTypeOp(
      request: DeleteProfileObjectTypeRequest
    ) extends CustomerProfilesOp[DeleteProfileObjectTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProfileObjectTypeResponse] =
        visitor.deleteProfileObjectType(request)
    }

    final case class GetDomainOp(
      request: GetDomainRequest
    ) extends CustomerProfilesOp[GetDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDomainResponse] =
        visitor.getDomain(request)
    }

    final case class GetIntegrationOp(
      request: GetIntegrationRequest
    ) extends CustomerProfilesOp[GetIntegrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIntegrationResponse] =
        visitor.getIntegration(request)
    }

    final case class GetMatchesOp(
      request: GetMatchesRequest
    ) extends CustomerProfilesOp[GetMatchesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMatchesResponse] =
        visitor.getMatches(request)
    }

    final case class GetProfileObjectTypeOp(
      request: GetProfileObjectTypeRequest
    ) extends CustomerProfilesOp[GetProfileObjectTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetProfileObjectTypeResponse] =
        visitor.getProfileObjectType(request)
    }

    final case class GetProfileObjectTypeTemplateOp(
      request: GetProfileObjectTypeTemplateRequest
    ) extends CustomerProfilesOp[GetProfileObjectTypeTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetProfileObjectTypeTemplateResponse] =
        visitor.getProfileObjectTypeTemplate(request)
    }

    final case class ListAccountIntegrationsOp(
      request: ListAccountIntegrationsRequest
    ) extends CustomerProfilesOp[ListAccountIntegrationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccountIntegrationsResponse] =
        visitor.listAccountIntegrations(request)
    }

    final case class ListDomainsOp(
      request: ListDomainsRequest
    ) extends CustomerProfilesOp[ListDomainsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDomainsResponse] =
        visitor.listDomains(request)
    }

    final case class ListIntegrationsOp(
      request: ListIntegrationsRequest
    ) extends CustomerProfilesOp[ListIntegrationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIntegrationsResponse] =
        visitor.listIntegrations(request)
    }

    final case class ListProfileObjectTypeTemplatesOp(
      request: ListProfileObjectTypeTemplatesRequest
    ) extends CustomerProfilesOp[ListProfileObjectTypeTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProfileObjectTypeTemplatesResponse] =
        visitor.listProfileObjectTypeTemplates(request)
    }

    final case class ListProfileObjectTypesOp(
      request: ListProfileObjectTypesRequest
    ) extends CustomerProfilesOp[ListProfileObjectTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProfileObjectTypesResponse] =
        visitor.listProfileObjectTypes(request)
    }

    final case class ListProfileObjectsOp(
      request: ListProfileObjectsRequest
    ) extends CustomerProfilesOp[ListProfileObjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProfileObjectsResponse] =
        visitor.listProfileObjects(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends CustomerProfilesOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class MergeProfilesOp(
      request: MergeProfilesRequest
    ) extends CustomerProfilesOp[MergeProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[MergeProfilesResponse] =
        visitor.mergeProfiles(request)
    }

    final case class PutIntegrationOp(
      request: PutIntegrationRequest
    ) extends CustomerProfilesOp[PutIntegrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutIntegrationResponse] =
        visitor.putIntegration(request)
    }

    final case class PutProfileObjectOp(
      request: PutProfileObjectRequest
    ) extends CustomerProfilesOp[PutProfileObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutProfileObjectResponse] =
        visitor.putProfileObject(request)
    }

    final case class PutProfileObjectTypeOp(
      request: PutProfileObjectTypeRequest
    ) extends CustomerProfilesOp[PutProfileObjectTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutProfileObjectTypeResponse] =
        visitor.putProfileObjectType(request)
    }

    final case class SearchProfilesOp(
      request: SearchProfilesRequest
    ) extends CustomerProfilesOp[SearchProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchProfilesResponse] =
        visitor.searchProfiles(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends CustomerProfilesOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends CustomerProfilesOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateDomainOp(
      request: UpdateDomainRequest
    ) extends CustomerProfilesOp[UpdateDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDomainResponse] =
        visitor.updateDomain(request)
    }

    final case class UpdateProfileOp(
      request: UpdateProfileRequest
    ) extends CustomerProfilesOp[UpdateProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateProfileResponse] =
        visitor.updateProfile(request)
    }
  }

  import CustomerProfilesOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CustomerProfilesOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addProfileKey(
    request: AddProfileKeyRequest
  ): CustomerProfilesIO[AddProfileKeyResponse] =
    FF.liftF(AddProfileKeyOp(request))

  def createDomain(
    request: CreateDomainRequest
  ): CustomerProfilesIO[CreateDomainResponse] =
    FF.liftF(CreateDomainOp(request))

  def createProfile(
    request: CreateProfileRequest
  ): CustomerProfilesIO[CreateProfileResponse] =
    FF.liftF(CreateProfileOp(request))

  def deleteDomain(
    request: DeleteDomainRequest
  ): CustomerProfilesIO[DeleteDomainResponse] =
    FF.liftF(DeleteDomainOp(request))

  def deleteIntegration(
    request: DeleteIntegrationRequest
  ): CustomerProfilesIO[DeleteIntegrationResponse] =
    FF.liftF(DeleteIntegrationOp(request))

  def deleteProfile(
    request: DeleteProfileRequest
  ): CustomerProfilesIO[DeleteProfileResponse] =
    FF.liftF(DeleteProfileOp(request))

  def deleteProfileKey(
    request: DeleteProfileKeyRequest
  ): CustomerProfilesIO[DeleteProfileKeyResponse] =
    FF.liftF(DeleteProfileKeyOp(request))

  def deleteProfileObject(
    request: DeleteProfileObjectRequest
  ): CustomerProfilesIO[DeleteProfileObjectResponse] =
    FF.liftF(DeleteProfileObjectOp(request))

  def deleteProfileObjectType(
    request: DeleteProfileObjectTypeRequest
  ): CustomerProfilesIO[DeleteProfileObjectTypeResponse] =
    FF.liftF(DeleteProfileObjectTypeOp(request))

  def getDomain(
    request: GetDomainRequest
  ): CustomerProfilesIO[GetDomainResponse] =
    FF.liftF(GetDomainOp(request))

  def getIntegration(
    request: GetIntegrationRequest
  ): CustomerProfilesIO[GetIntegrationResponse] =
    FF.liftF(GetIntegrationOp(request))

  def getMatches(
    request: GetMatchesRequest
  ): CustomerProfilesIO[GetMatchesResponse] =
    FF.liftF(GetMatchesOp(request))

  def getProfileObjectType(
    request: GetProfileObjectTypeRequest
  ): CustomerProfilesIO[GetProfileObjectTypeResponse] =
    FF.liftF(GetProfileObjectTypeOp(request))

  def getProfileObjectTypeTemplate(
    request: GetProfileObjectTypeTemplateRequest
  ): CustomerProfilesIO[GetProfileObjectTypeTemplateResponse] =
    FF.liftF(GetProfileObjectTypeTemplateOp(request))

  def listAccountIntegrations(
    request: ListAccountIntegrationsRequest
  ): CustomerProfilesIO[ListAccountIntegrationsResponse] =
    FF.liftF(ListAccountIntegrationsOp(request))

  def listDomains(
    request: ListDomainsRequest
  ): CustomerProfilesIO[ListDomainsResponse] =
    FF.liftF(ListDomainsOp(request))

  def listIntegrations(
    request: ListIntegrationsRequest
  ): CustomerProfilesIO[ListIntegrationsResponse] =
    FF.liftF(ListIntegrationsOp(request))

  def listProfileObjectTypeTemplates(
    request: ListProfileObjectTypeTemplatesRequest
  ): CustomerProfilesIO[ListProfileObjectTypeTemplatesResponse] =
    FF.liftF(ListProfileObjectTypeTemplatesOp(request))

  def listProfileObjectTypes(
    request: ListProfileObjectTypesRequest
  ): CustomerProfilesIO[ListProfileObjectTypesResponse] =
    FF.liftF(ListProfileObjectTypesOp(request))

  def listProfileObjects(
    request: ListProfileObjectsRequest
  ): CustomerProfilesIO[ListProfileObjectsResponse] =
    FF.liftF(ListProfileObjectsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): CustomerProfilesIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def mergeProfiles(
    request: MergeProfilesRequest
  ): CustomerProfilesIO[MergeProfilesResponse] =
    FF.liftF(MergeProfilesOp(request))

  def putIntegration(
    request: PutIntegrationRequest
  ): CustomerProfilesIO[PutIntegrationResponse] =
    FF.liftF(PutIntegrationOp(request))

  def putProfileObject(
    request: PutProfileObjectRequest
  ): CustomerProfilesIO[PutProfileObjectResponse] =
    FF.liftF(PutProfileObjectOp(request))

  def putProfileObjectType(
    request: PutProfileObjectTypeRequest
  ): CustomerProfilesIO[PutProfileObjectTypeResponse] =
    FF.liftF(PutProfileObjectTypeOp(request))

  def searchProfiles(
    request: SearchProfilesRequest
  ): CustomerProfilesIO[SearchProfilesResponse] =
    FF.liftF(SearchProfilesOp(request))

  def tagResource(
    request: TagResourceRequest
  ): CustomerProfilesIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): CustomerProfilesIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateDomain(
    request: UpdateDomainRequest
  ): CustomerProfilesIO[UpdateDomainResponse] =
    FF.liftF(UpdateDomainOp(request))

  def updateProfile(
    request: UpdateProfileRequest
  ): CustomerProfilesIO[UpdateProfileResponse] =
    FF.liftF(UpdateProfileOp(request))
}
