package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.cognitoidentity.CognitoIdentityClient
import software.amazon.awssdk.services.cognitoidentity.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object cognitoidentity { module =>

  // Free monad over CognitoIdentityOp
  type CognitoIdentityIO[A] = FF[CognitoIdentityOp, A]

  sealed trait CognitoIdentityOp[A] {
    def visit[F[_]](visitor: CognitoIdentityOp.Visitor[F]): F[A]
  }

  object CognitoIdentityOp {
    // Given a CognitoIdentityClient we can embed a CognitoIdentityIO program in any algebra that understands embedding.
    implicit val CognitoIdentityOpEmbeddable: Embeddable[CognitoIdentityOp, CognitoIdentityClient] = new Embeddable[CognitoIdentityOp, CognitoIdentityClient] {
      def embed[A](client: CognitoIdentityClient, io: CognitoIdentityIO[A]): Embedded[A] = Embedded.CognitoIdentity(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CognitoIdentityOp.Visitor[Kleisli[M, CognitoIdentityClient, *]] {
        def createIdentityPool(
          request: CreateIdentityPoolRequest
        ): Kleisli[M, CognitoIdentityClient, CreateIdentityPoolResponse] =
          primitive(_.createIdentityPool(request))

        def deleteIdentities(
          request: DeleteIdentitiesRequest
        ): Kleisli[M, CognitoIdentityClient, DeleteIdentitiesResponse] =
          primitive(_.deleteIdentities(request))

        def deleteIdentityPool(
          request: DeleteIdentityPoolRequest
        ): Kleisli[M, CognitoIdentityClient, DeleteIdentityPoolResponse] =
          primitive(_.deleteIdentityPool(request))

        def describeIdentity(
          request: DescribeIdentityRequest
        ): Kleisli[M, CognitoIdentityClient, DescribeIdentityResponse] =
          primitive(_.describeIdentity(request))

        def describeIdentityPool(
          request: DescribeIdentityPoolRequest
        ): Kleisli[M, CognitoIdentityClient, DescribeIdentityPoolResponse] =
          primitive(_.describeIdentityPool(request))

        def getCredentialsForIdentity(
          request: GetCredentialsForIdentityRequest
        ): Kleisli[M, CognitoIdentityClient, GetCredentialsForIdentityResponse] =
          primitive(_.getCredentialsForIdentity(request))

        def getId(
          request: GetIdRequest
        ): Kleisli[M, CognitoIdentityClient, GetIdResponse] =
          primitive(_.getId(request))

        def getIdentityPoolRoles(
          request: GetIdentityPoolRolesRequest
        ): Kleisli[M, CognitoIdentityClient, GetIdentityPoolRolesResponse] =
          primitive(_.getIdentityPoolRoles(request))

        def getOpenIdToken(
          request: GetOpenIdTokenRequest
        ): Kleisli[M, CognitoIdentityClient, GetOpenIdTokenResponse] =
          primitive(_.getOpenIdToken(request))

        def getOpenIdTokenForDeveloperIdentity(
          request: GetOpenIdTokenForDeveloperIdentityRequest
        ): Kleisli[M, CognitoIdentityClient, GetOpenIdTokenForDeveloperIdentityResponse] =
          primitive(_.getOpenIdTokenForDeveloperIdentity(request))

        def getPrincipalTagAttributeMap(
          request: GetPrincipalTagAttributeMapRequest
        ): Kleisli[M, CognitoIdentityClient, GetPrincipalTagAttributeMapResponse] =
          primitive(_.getPrincipalTagAttributeMap(request))

        def listIdentities(
          request: ListIdentitiesRequest
        ): Kleisli[M, CognitoIdentityClient, ListIdentitiesResponse] =
          primitive(_.listIdentities(request))

        def listIdentityPools(
          request: ListIdentityPoolsRequest
        ): Kleisli[M, CognitoIdentityClient, ListIdentityPoolsResponse] =
          primitive(_.listIdentityPools(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, CognitoIdentityClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def lookupDeveloperIdentity(
          request: LookupDeveloperIdentityRequest
        ): Kleisli[M, CognitoIdentityClient, LookupDeveloperIdentityResponse] =
          primitive(_.lookupDeveloperIdentity(request))

        def mergeDeveloperIdentities(
          request: MergeDeveloperIdentitiesRequest
        ): Kleisli[M, CognitoIdentityClient, MergeDeveloperIdentitiesResponse] =
          primitive(_.mergeDeveloperIdentities(request))

        def setIdentityPoolRoles(
          request: SetIdentityPoolRolesRequest
        ): Kleisli[M, CognitoIdentityClient, SetIdentityPoolRolesResponse] =
          primitive(_.setIdentityPoolRoles(request))

        def setPrincipalTagAttributeMap(
          request: SetPrincipalTagAttributeMapRequest
        ): Kleisli[M, CognitoIdentityClient, SetPrincipalTagAttributeMapResponse] =
          primitive(_.setPrincipalTagAttributeMap(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, CognitoIdentityClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def unlinkDeveloperIdentity(
          request: UnlinkDeveloperIdentityRequest
        ): Kleisli[M, CognitoIdentityClient, UnlinkDeveloperIdentityResponse] =
          primitive(_.unlinkDeveloperIdentity(request))

        def unlinkIdentity(
          request: UnlinkIdentityRequest
        ): Kleisli[M, CognitoIdentityClient, UnlinkIdentityResponse] =
          primitive(_.unlinkIdentity(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, CognitoIdentityClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateIdentityPool(
          request: UpdateIdentityPoolRequest
        ): Kleisli[M, CognitoIdentityClient, UpdateIdentityPoolResponse] =
          primitive(_.updateIdentityPool(request))

        def primitive[A](
          f: CognitoIdentityClient => A
        ): Kleisli[M, CognitoIdentityClient, A]
      }
    }

    trait Visitor[F[_]] extends (CognitoIdentityOp ~> F) {
      final def apply[A](op: CognitoIdentityOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createIdentityPool(
        request: CreateIdentityPoolRequest
      ): F[CreateIdentityPoolResponse]

      def deleteIdentities(
        request: DeleteIdentitiesRequest
      ): F[DeleteIdentitiesResponse]

      def deleteIdentityPool(
        request: DeleteIdentityPoolRequest
      ): F[DeleteIdentityPoolResponse]

      def describeIdentity(
        request: DescribeIdentityRequest
      ): F[DescribeIdentityResponse]

      def describeIdentityPool(
        request: DescribeIdentityPoolRequest
      ): F[DescribeIdentityPoolResponse]

      def getCredentialsForIdentity(
        request: GetCredentialsForIdentityRequest
      ): F[GetCredentialsForIdentityResponse]

      def getId(
        request: GetIdRequest
      ): F[GetIdResponse]

      def getIdentityPoolRoles(
        request: GetIdentityPoolRolesRequest
      ): F[GetIdentityPoolRolesResponse]

      def getOpenIdToken(
        request: GetOpenIdTokenRequest
      ): F[GetOpenIdTokenResponse]

      def getOpenIdTokenForDeveloperIdentity(
        request: GetOpenIdTokenForDeveloperIdentityRequest
      ): F[GetOpenIdTokenForDeveloperIdentityResponse]

      def getPrincipalTagAttributeMap(
        request: GetPrincipalTagAttributeMapRequest
      ): F[GetPrincipalTagAttributeMapResponse]

      def listIdentities(
        request: ListIdentitiesRequest
      ): F[ListIdentitiesResponse]

      def listIdentityPools(
        request: ListIdentityPoolsRequest
      ): F[ListIdentityPoolsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def lookupDeveloperIdentity(
        request: LookupDeveloperIdentityRequest
      ): F[LookupDeveloperIdentityResponse]

      def mergeDeveloperIdentities(
        request: MergeDeveloperIdentitiesRequest
      ): F[MergeDeveloperIdentitiesResponse]

      def setIdentityPoolRoles(
        request: SetIdentityPoolRolesRequest
      ): F[SetIdentityPoolRolesResponse]

      def setPrincipalTagAttributeMap(
        request: SetPrincipalTagAttributeMapRequest
      ): F[SetPrincipalTagAttributeMapResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def unlinkDeveloperIdentity(
        request: UnlinkDeveloperIdentityRequest
      ): F[UnlinkDeveloperIdentityResponse]

      def unlinkIdentity(
        request: UnlinkIdentityRequest
      ): F[UnlinkIdentityResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateIdentityPool(
        request: UpdateIdentityPoolRequest
      ): F[UpdateIdentityPoolResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CognitoIdentityOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateIdentityPoolOp(
      request: CreateIdentityPoolRequest
    ) extends CognitoIdentityOp[CreateIdentityPoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateIdentityPoolResponse] =
        visitor.createIdentityPool(request)
    }

    final case class DeleteIdentitiesOp(
      request: DeleteIdentitiesRequest
    ) extends CognitoIdentityOp[DeleteIdentitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIdentitiesResponse] =
        visitor.deleteIdentities(request)
    }

    final case class DeleteIdentityPoolOp(
      request: DeleteIdentityPoolRequest
    ) extends CognitoIdentityOp[DeleteIdentityPoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIdentityPoolResponse] =
        visitor.deleteIdentityPool(request)
    }

    final case class DescribeIdentityOp(
      request: DescribeIdentityRequest
    ) extends CognitoIdentityOp[DescribeIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeIdentityResponse] =
        visitor.describeIdentity(request)
    }

    final case class DescribeIdentityPoolOp(
      request: DescribeIdentityPoolRequest
    ) extends CognitoIdentityOp[DescribeIdentityPoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeIdentityPoolResponse] =
        visitor.describeIdentityPool(request)
    }

    final case class GetCredentialsForIdentityOp(
      request: GetCredentialsForIdentityRequest
    ) extends CognitoIdentityOp[GetCredentialsForIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCredentialsForIdentityResponse] =
        visitor.getCredentialsForIdentity(request)
    }

    final case class GetIdOp(
      request: GetIdRequest
    ) extends CognitoIdentityOp[GetIdResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIdResponse] =
        visitor.getId(request)
    }

    final case class GetIdentityPoolRolesOp(
      request: GetIdentityPoolRolesRequest
    ) extends CognitoIdentityOp[GetIdentityPoolRolesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIdentityPoolRolesResponse] =
        visitor.getIdentityPoolRoles(request)
    }

    final case class GetOpenIdTokenOp(
      request: GetOpenIdTokenRequest
    ) extends CognitoIdentityOp[GetOpenIdTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOpenIdTokenResponse] =
        visitor.getOpenIdToken(request)
    }

    final case class GetOpenIdTokenForDeveloperIdentityOp(
      request: GetOpenIdTokenForDeveloperIdentityRequest
    ) extends CognitoIdentityOp[GetOpenIdTokenForDeveloperIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOpenIdTokenForDeveloperIdentityResponse] =
        visitor.getOpenIdTokenForDeveloperIdentity(request)
    }

    final case class GetPrincipalTagAttributeMapOp(
      request: GetPrincipalTagAttributeMapRequest
    ) extends CognitoIdentityOp[GetPrincipalTagAttributeMapResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPrincipalTagAttributeMapResponse] =
        visitor.getPrincipalTagAttributeMap(request)
    }

    final case class ListIdentitiesOp(
      request: ListIdentitiesRequest
    ) extends CognitoIdentityOp[ListIdentitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIdentitiesResponse] =
        visitor.listIdentities(request)
    }

    final case class ListIdentityPoolsOp(
      request: ListIdentityPoolsRequest
    ) extends CognitoIdentityOp[ListIdentityPoolsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIdentityPoolsResponse] =
        visitor.listIdentityPools(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends CognitoIdentityOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class LookupDeveloperIdentityOp(
      request: LookupDeveloperIdentityRequest
    ) extends CognitoIdentityOp[LookupDeveloperIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[LookupDeveloperIdentityResponse] =
        visitor.lookupDeveloperIdentity(request)
    }

    final case class MergeDeveloperIdentitiesOp(
      request: MergeDeveloperIdentitiesRequest
    ) extends CognitoIdentityOp[MergeDeveloperIdentitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[MergeDeveloperIdentitiesResponse] =
        visitor.mergeDeveloperIdentities(request)
    }

    final case class SetIdentityPoolRolesOp(
      request: SetIdentityPoolRolesRequest
    ) extends CognitoIdentityOp[SetIdentityPoolRolesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetIdentityPoolRolesResponse] =
        visitor.setIdentityPoolRoles(request)
    }

    final case class SetPrincipalTagAttributeMapOp(
      request: SetPrincipalTagAttributeMapRequest
    ) extends CognitoIdentityOp[SetPrincipalTagAttributeMapResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetPrincipalTagAttributeMapResponse] =
        visitor.setPrincipalTagAttributeMap(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends CognitoIdentityOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UnlinkDeveloperIdentityOp(
      request: UnlinkDeveloperIdentityRequest
    ) extends CognitoIdentityOp[UnlinkDeveloperIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UnlinkDeveloperIdentityResponse] =
        visitor.unlinkDeveloperIdentity(request)
    }

    final case class UnlinkIdentityOp(
      request: UnlinkIdentityRequest
    ) extends CognitoIdentityOp[UnlinkIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UnlinkIdentityResponse] =
        visitor.unlinkIdentity(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends CognitoIdentityOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateIdentityPoolOp(
      request: UpdateIdentityPoolRequest
    ) extends CognitoIdentityOp[UpdateIdentityPoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateIdentityPoolResponse] =
        visitor.updateIdentityPool(request)
    }
  }

  import CognitoIdentityOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CognitoIdentityOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createIdentityPool(
    request: CreateIdentityPoolRequest
  ): CognitoIdentityIO[CreateIdentityPoolResponse] =
    FF.liftF(CreateIdentityPoolOp(request))

  def deleteIdentities(
    request: DeleteIdentitiesRequest
  ): CognitoIdentityIO[DeleteIdentitiesResponse] =
    FF.liftF(DeleteIdentitiesOp(request))

  def deleteIdentityPool(
    request: DeleteIdentityPoolRequest
  ): CognitoIdentityIO[DeleteIdentityPoolResponse] =
    FF.liftF(DeleteIdentityPoolOp(request))

  def describeIdentity(
    request: DescribeIdentityRequest
  ): CognitoIdentityIO[DescribeIdentityResponse] =
    FF.liftF(DescribeIdentityOp(request))

  def describeIdentityPool(
    request: DescribeIdentityPoolRequest
  ): CognitoIdentityIO[DescribeIdentityPoolResponse] =
    FF.liftF(DescribeIdentityPoolOp(request))

  def getCredentialsForIdentity(
    request: GetCredentialsForIdentityRequest
  ): CognitoIdentityIO[GetCredentialsForIdentityResponse] =
    FF.liftF(GetCredentialsForIdentityOp(request))

  def getId(
    request: GetIdRequest
  ): CognitoIdentityIO[GetIdResponse] =
    FF.liftF(GetIdOp(request))

  def getIdentityPoolRoles(
    request: GetIdentityPoolRolesRequest
  ): CognitoIdentityIO[GetIdentityPoolRolesResponse] =
    FF.liftF(GetIdentityPoolRolesOp(request))

  def getOpenIdToken(
    request: GetOpenIdTokenRequest
  ): CognitoIdentityIO[GetOpenIdTokenResponse] =
    FF.liftF(GetOpenIdTokenOp(request))

  def getOpenIdTokenForDeveloperIdentity(
    request: GetOpenIdTokenForDeveloperIdentityRequest
  ): CognitoIdentityIO[GetOpenIdTokenForDeveloperIdentityResponse] =
    FF.liftF(GetOpenIdTokenForDeveloperIdentityOp(request))

  def getPrincipalTagAttributeMap(
    request: GetPrincipalTagAttributeMapRequest
  ): CognitoIdentityIO[GetPrincipalTagAttributeMapResponse] =
    FF.liftF(GetPrincipalTagAttributeMapOp(request))

  def listIdentities(
    request: ListIdentitiesRequest
  ): CognitoIdentityIO[ListIdentitiesResponse] =
    FF.liftF(ListIdentitiesOp(request))

  def listIdentityPools(
    request: ListIdentityPoolsRequest
  ): CognitoIdentityIO[ListIdentityPoolsResponse] =
    FF.liftF(ListIdentityPoolsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): CognitoIdentityIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def lookupDeveloperIdentity(
    request: LookupDeveloperIdentityRequest
  ): CognitoIdentityIO[LookupDeveloperIdentityResponse] =
    FF.liftF(LookupDeveloperIdentityOp(request))

  def mergeDeveloperIdentities(
    request: MergeDeveloperIdentitiesRequest
  ): CognitoIdentityIO[MergeDeveloperIdentitiesResponse] =
    FF.liftF(MergeDeveloperIdentitiesOp(request))

  def setIdentityPoolRoles(
    request: SetIdentityPoolRolesRequest
  ): CognitoIdentityIO[SetIdentityPoolRolesResponse] =
    FF.liftF(SetIdentityPoolRolesOp(request))

  def setPrincipalTagAttributeMap(
    request: SetPrincipalTagAttributeMapRequest
  ): CognitoIdentityIO[SetPrincipalTagAttributeMapResponse] =
    FF.liftF(SetPrincipalTagAttributeMapOp(request))

  def tagResource(
    request: TagResourceRequest
  ): CognitoIdentityIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def unlinkDeveloperIdentity(
    request: UnlinkDeveloperIdentityRequest
  ): CognitoIdentityIO[UnlinkDeveloperIdentityResponse] =
    FF.liftF(UnlinkDeveloperIdentityOp(request))

  def unlinkIdentity(
    request: UnlinkIdentityRequest
  ): CognitoIdentityIO[UnlinkIdentityResponse] =
    FF.liftF(UnlinkIdentityOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): CognitoIdentityIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateIdentityPool(
    request: UpdateIdentityPoolRequest
  ): CognitoIdentityIO[UpdateIdentityPoolResponse] =
    FF.liftF(UpdateIdentityPoolOp(request))
}
