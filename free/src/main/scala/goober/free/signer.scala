package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.signer.SignerClient
import software.amazon.awssdk.services.signer.model._


object signer { module =>

  // Free monad over SignerOp
  type SignerIO[A] = FF[SignerOp, A]

  sealed trait SignerOp[A] {
    def visit[F[_]](visitor: SignerOp.Visitor[F]): F[A]
  }

  object SignerOp {
    // Given a SignerClient we can embed a SignerIO program in any algebra that understands embedding.
    implicit val SignerOpEmbeddable: Embeddable[SignerOp, SignerClient] = new Embeddable[SignerOp, SignerClient] {
      def embed[A](client: SignerClient, io: SignerIO[A]): Embedded[A] = Embedded.Signer(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SignerOp.Visitor[Kleisli[M, SignerClient, *]] {
        def addProfilePermission(
          request: AddProfilePermissionRequest
        ): Kleisli[M, SignerClient, AddProfilePermissionResponse] =
          primitive(_.addProfilePermission(request))

        def cancelSigningProfile(
          request: CancelSigningProfileRequest
        ): Kleisli[M, SignerClient, CancelSigningProfileResponse] =
          primitive(_.cancelSigningProfile(request))

        def describeSigningJob(
          request: DescribeSigningJobRequest
        ): Kleisli[M, SignerClient, DescribeSigningJobResponse] =
          primitive(_.describeSigningJob(request))

        def getSigningPlatform(
          request: GetSigningPlatformRequest
        ): Kleisli[M, SignerClient, GetSigningPlatformResponse] =
          primitive(_.getSigningPlatform(request))

        def getSigningProfile(
          request: GetSigningProfileRequest
        ): Kleisli[M, SignerClient, GetSigningProfileResponse] =
          primitive(_.getSigningProfile(request))

        def listProfilePermissions(
          request: ListProfilePermissionsRequest
        ): Kleisli[M, SignerClient, ListProfilePermissionsResponse] =
          primitive(_.listProfilePermissions(request))

        def listSigningJobs(
          request: ListSigningJobsRequest
        ): Kleisli[M, SignerClient, ListSigningJobsResponse] =
          primitive(_.listSigningJobs(request))

        def listSigningPlatforms(
          request: ListSigningPlatformsRequest
        ): Kleisli[M, SignerClient, ListSigningPlatformsResponse] =
          primitive(_.listSigningPlatforms(request))

        def listSigningProfiles(
          request: ListSigningProfilesRequest
        ): Kleisli[M, SignerClient, ListSigningProfilesResponse] =
          primitive(_.listSigningProfiles(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, SignerClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putSigningProfile(
          request: PutSigningProfileRequest
        ): Kleisli[M, SignerClient, PutSigningProfileResponse] =
          primitive(_.putSigningProfile(request))

        def removeProfilePermission(
          request: RemoveProfilePermissionRequest
        ): Kleisli[M, SignerClient, RemoveProfilePermissionResponse] =
          primitive(_.removeProfilePermission(request))

        def revokeSignature(
          request: RevokeSignatureRequest
        ): Kleisli[M, SignerClient, RevokeSignatureResponse] =
          primitive(_.revokeSignature(request))

        def revokeSigningProfile(
          request: RevokeSigningProfileRequest
        ): Kleisli[M, SignerClient, RevokeSigningProfileResponse] =
          primitive(_.revokeSigningProfile(request))

        def startSigningJob(
          request: StartSigningJobRequest
        ): Kleisli[M, SignerClient, StartSigningJobResponse] =
          primitive(_.startSigningJob(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, SignerClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, SignerClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: SignerClient => A
        ): Kleisli[M, SignerClient, A]
      }
    }

    trait Visitor[F[_]] extends (SignerOp ~> F) {
      final def apply[A](op: SignerOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addProfilePermission(
        request: AddProfilePermissionRequest
      ): F[AddProfilePermissionResponse]

      def cancelSigningProfile(
        request: CancelSigningProfileRequest
      ): F[CancelSigningProfileResponse]

      def describeSigningJob(
        request: DescribeSigningJobRequest
      ): F[DescribeSigningJobResponse]

      def getSigningPlatform(
        request: GetSigningPlatformRequest
      ): F[GetSigningPlatformResponse]

      def getSigningProfile(
        request: GetSigningProfileRequest
      ): F[GetSigningProfileResponse]

      def listProfilePermissions(
        request: ListProfilePermissionsRequest
      ): F[ListProfilePermissionsResponse]

      def listSigningJobs(
        request: ListSigningJobsRequest
      ): F[ListSigningJobsResponse]

      def listSigningPlatforms(
        request: ListSigningPlatformsRequest
      ): F[ListSigningPlatformsResponse]

      def listSigningProfiles(
        request: ListSigningProfilesRequest
      ): F[ListSigningProfilesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putSigningProfile(
        request: PutSigningProfileRequest
      ): F[PutSigningProfileResponse]

      def removeProfilePermission(
        request: RemoveProfilePermissionRequest
      ): F[RemoveProfilePermissionResponse]

      def revokeSignature(
        request: RevokeSignatureRequest
      ): F[RevokeSignatureResponse]

      def revokeSigningProfile(
        request: RevokeSigningProfileRequest
      ): F[RevokeSigningProfileResponse]

      def startSigningJob(
        request: StartSigningJobRequest
      ): F[StartSigningJobResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SignerOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddProfilePermissionOp(
      request: AddProfilePermissionRequest
    ) extends SignerOp[AddProfilePermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddProfilePermissionResponse] =
        visitor.addProfilePermission(request)
    }

    final case class CancelSigningProfileOp(
      request: CancelSigningProfileRequest
    ) extends SignerOp[CancelSigningProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelSigningProfileResponse] =
        visitor.cancelSigningProfile(request)
    }

    final case class DescribeSigningJobOp(
      request: DescribeSigningJobRequest
    ) extends SignerOp[DescribeSigningJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSigningJobResponse] =
        visitor.describeSigningJob(request)
    }

    final case class GetSigningPlatformOp(
      request: GetSigningPlatformRequest
    ) extends SignerOp[GetSigningPlatformResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSigningPlatformResponse] =
        visitor.getSigningPlatform(request)
    }

    final case class GetSigningProfileOp(
      request: GetSigningProfileRequest
    ) extends SignerOp[GetSigningProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSigningProfileResponse] =
        visitor.getSigningProfile(request)
    }

    final case class ListProfilePermissionsOp(
      request: ListProfilePermissionsRequest
    ) extends SignerOp[ListProfilePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProfilePermissionsResponse] =
        visitor.listProfilePermissions(request)
    }

    final case class ListSigningJobsOp(
      request: ListSigningJobsRequest
    ) extends SignerOp[ListSigningJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSigningJobsResponse] =
        visitor.listSigningJobs(request)
    }

    final case class ListSigningPlatformsOp(
      request: ListSigningPlatformsRequest
    ) extends SignerOp[ListSigningPlatformsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSigningPlatformsResponse] =
        visitor.listSigningPlatforms(request)
    }

    final case class ListSigningProfilesOp(
      request: ListSigningProfilesRequest
    ) extends SignerOp[ListSigningProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSigningProfilesResponse] =
        visitor.listSigningProfiles(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends SignerOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutSigningProfileOp(
      request: PutSigningProfileRequest
    ) extends SignerOp[PutSigningProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutSigningProfileResponse] =
        visitor.putSigningProfile(request)
    }

    final case class RemoveProfilePermissionOp(
      request: RemoveProfilePermissionRequest
    ) extends SignerOp[RemoveProfilePermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveProfilePermissionResponse] =
        visitor.removeProfilePermission(request)
    }

    final case class RevokeSignatureOp(
      request: RevokeSignatureRequest
    ) extends SignerOp[RevokeSignatureResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RevokeSignatureResponse] =
        visitor.revokeSignature(request)
    }

    final case class RevokeSigningProfileOp(
      request: RevokeSigningProfileRequest
    ) extends SignerOp[RevokeSigningProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RevokeSigningProfileResponse] =
        visitor.revokeSigningProfile(request)
    }

    final case class StartSigningJobOp(
      request: StartSigningJobRequest
    ) extends SignerOp[StartSigningJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartSigningJobResponse] =
        visitor.startSigningJob(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends SignerOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends SignerOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import SignerOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SignerOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addProfilePermission(
    request: AddProfilePermissionRequest
  ): SignerIO[AddProfilePermissionResponse] =
    FF.liftF(AddProfilePermissionOp(request))

  def cancelSigningProfile(
    request: CancelSigningProfileRequest
  ): SignerIO[CancelSigningProfileResponse] =
    FF.liftF(CancelSigningProfileOp(request))

  def describeSigningJob(
    request: DescribeSigningJobRequest
  ): SignerIO[DescribeSigningJobResponse] =
    FF.liftF(DescribeSigningJobOp(request))

  def getSigningPlatform(
    request: GetSigningPlatformRequest
  ): SignerIO[GetSigningPlatformResponse] =
    FF.liftF(GetSigningPlatformOp(request))

  def getSigningProfile(
    request: GetSigningProfileRequest
  ): SignerIO[GetSigningProfileResponse] =
    FF.liftF(GetSigningProfileOp(request))

  def listProfilePermissions(
    request: ListProfilePermissionsRequest
  ): SignerIO[ListProfilePermissionsResponse] =
    FF.liftF(ListProfilePermissionsOp(request))

  def listSigningJobs(
    request: ListSigningJobsRequest
  ): SignerIO[ListSigningJobsResponse] =
    FF.liftF(ListSigningJobsOp(request))

  def listSigningPlatforms(
    request: ListSigningPlatformsRequest
  ): SignerIO[ListSigningPlatformsResponse] =
    FF.liftF(ListSigningPlatformsOp(request))

  def listSigningProfiles(
    request: ListSigningProfilesRequest
  ): SignerIO[ListSigningProfilesResponse] =
    FF.liftF(ListSigningProfilesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): SignerIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putSigningProfile(
    request: PutSigningProfileRequest
  ): SignerIO[PutSigningProfileResponse] =
    FF.liftF(PutSigningProfileOp(request))

  def removeProfilePermission(
    request: RemoveProfilePermissionRequest
  ): SignerIO[RemoveProfilePermissionResponse] =
    FF.liftF(RemoveProfilePermissionOp(request))

  def revokeSignature(
    request: RevokeSignatureRequest
  ): SignerIO[RevokeSignatureResponse] =
    FF.liftF(RevokeSignatureOp(request))

  def revokeSigningProfile(
    request: RevokeSigningProfileRequest
  ): SignerIO[RevokeSigningProfileResponse] =
    FF.liftF(RevokeSigningProfileOp(request))

  def startSigningJob(
    request: StartSigningJobRequest
  ): SignerIO[StartSigningJobResponse] =
    FF.liftF(StartSigningJobOp(request))

  def tagResource(
    request: TagResourceRequest
  ): SignerIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): SignerIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
