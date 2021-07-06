package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.acmpca.AcmPcaClient
import software.amazon.awssdk.services.acmpca.model._


object acmpca { module =>

  // Free monad over AcmPcaOp
  type AcmPcaIO[A] = FF[AcmPcaOp, A]

  sealed trait AcmPcaOp[A] {
    def visit[F[_]](visitor: AcmPcaOp.Visitor[F]): F[A]
  }

  object AcmPcaOp {
    // Given a AcmPcaClient we can embed a AcmPcaIO program in any algebra that understands embedding.
    implicit val AcmPcaOpEmbeddable: Embeddable[AcmPcaOp, AcmPcaClient] = new Embeddable[AcmPcaOp, AcmPcaClient] {
      def embed[A](client: AcmPcaClient, io: AcmPcaIO[A]): Embedded[A] = Embedded.AcmPca(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends AcmPcaOp.Visitor[Kleisli[M, AcmPcaClient, *]] {
        def createCertificateAuthority(
          request: CreateCertificateAuthorityRequest
        ): Kleisli[M, AcmPcaClient, CreateCertificateAuthorityResponse] =
          primitive(_.createCertificateAuthority(request))

        def createCertificateAuthorityAuditReport(
          request: CreateCertificateAuthorityAuditReportRequest
        ): Kleisli[M, AcmPcaClient, CreateCertificateAuthorityAuditReportResponse] =
          primitive(_.createCertificateAuthorityAuditReport(request))

        def createPermission(
          request: CreatePermissionRequest
        ): Kleisli[M, AcmPcaClient, CreatePermissionResponse] =
          primitive(_.createPermission(request))

        def deleteCertificateAuthority(
          request: DeleteCertificateAuthorityRequest
        ): Kleisli[M, AcmPcaClient, DeleteCertificateAuthorityResponse] =
          primitive(_.deleteCertificateAuthority(request))

        def deletePermission(
          request: DeletePermissionRequest
        ): Kleisli[M, AcmPcaClient, DeletePermissionResponse] =
          primitive(_.deletePermission(request))

        def deletePolicy(
          request: DeletePolicyRequest
        ): Kleisli[M, AcmPcaClient, DeletePolicyResponse] =
          primitive(_.deletePolicy(request))

        def describeCertificateAuthority(
          request: DescribeCertificateAuthorityRequest
        ): Kleisli[M, AcmPcaClient, DescribeCertificateAuthorityResponse] =
          primitive(_.describeCertificateAuthority(request))

        def describeCertificateAuthorityAuditReport(
          request: DescribeCertificateAuthorityAuditReportRequest
        ): Kleisli[M, AcmPcaClient, DescribeCertificateAuthorityAuditReportResponse] =
          primitive(_.describeCertificateAuthorityAuditReport(request))

        def getCertificate(
          request: GetCertificateRequest
        ): Kleisli[M, AcmPcaClient, GetCertificateResponse] =
          primitive(_.getCertificate(request))

        def getCertificateAuthorityCertificate(
          request: GetCertificateAuthorityCertificateRequest
        ): Kleisli[M, AcmPcaClient, GetCertificateAuthorityCertificateResponse] =
          primitive(_.getCertificateAuthorityCertificate(request))

        def getCertificateAuthorityCsr(
          request: GetCertificateAuthorityCsrRequest
        ): Kleisli[M, AcmPcaClient, GetCertificateAuthorityCsrResponse] =
          primitive(_.getCertificateAuthorityCsr(request))

        def getPolicy(
          request: GetPolicyRequest
        ): Kleisli[M, AcmPcaClient, GetPolicyResponse] =
          primitive(_.getPolicy(request))

        def importCertificateAuthorityCertificate(
          request: ImportCertificateAuthorityCertificateRequest
        ): Kleisli[M, AcmPcaClient, ImportCertificateAuthorityCertificateResponse] =
          primitive(_.importCertificateAuthorityCertificate(request))

        def issueCertificate(
          request: IssueCertificateRequest
        ): Kleisli[M, AcmPcaClient, IssueCertificateResponse] =
          primitive(_.issueCertificate(request))

        def listCertificateAuthorities(
          request: ListCertificateAuthoritiesRequest
        ): Kleisli[M, AcmPcaClient, ListCertificateAuthoritiesResponse] =
          primitive(_.listCertificateAuthorities(request))

        def listPermissions(
          request: ListPermissionsRequest
        ): Kleisli[M, AcmPcaClient, ListPermissionsResponse] =
          primitive(_.listPermissions(request))

        def listTags(
          request: ListTagsRequest
        ): Kleisli[M, AcmPcaClient, ListTagsResponse] =
          primitive(_.listTags(request))

        def putPolicy(
          request: PutPolicyRequest
        ): Kleisli[M, AcmPcaClient, PutPolicyResponse] =
          primitive(_.putPolicy(request))

        def restoreCertificateAuthority(
          request: RestoreCertificateAuthorityRequest
        ): Kleisli[M, AcmPcaClient, RestoreCertificateAuthorityResponse] =
          primitive(_.restoreCertificateAuthority(request))

        def revokeCertificate(
          request: RevokeCertificateRequest
        ): Kleisli[M, AcmPcaClient, RevokeCertificateResponse] =
          primitive(_.revokeCertificate(request))

        def tagCertificateAuthority(
          request: TagCertificateAuthorityRequest
        ): Kleisli[M, AcmPcaClient, TagCertificateAuthorityResponse] =
          primitive(_.tagCertificateAuthority(request))

        def untagCertificateAuthority(
          request: UntagCertificateAuthorityRequest
        ): Kleisli[M, AcmPcaClient, UntagCertificateAuthorityResponse] =
          primitive(_.untagCertificateAuthority(request))

        def updateCertificateAuthority(
          request: UpdateCertificateAuthorityRequest
        ): Kleisli[M, AcmPcaClient, UpdateCertificateAuthorityResponse] =
          primitive(_.updateCertificateAuthority(request))

        def primitive[A](
          f: AcmPcaClient => A
        ): Kleisli[M, AcmPcaClient, A]
      }
    }

    trait Visitor[F[_]] extends (AcmPcaOp ~> F) {
      final def apply[A](op: AcmPcaOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createCertificateAuthority(
        request: CreateCertificateAuthorityRequest
      ): F[CreateCertificateAuthorityResponse]

      def createCertificateAuthorityAuditReport(
        request: CreateCertificateAuthorityAuditReportRequest
      ): F[CreateCertificateAuthorityAuditReportResponse]

      def createPermission(
        request: CreatePermissionRequest
      ): F[CreatePermissionResponse]

      def deleteCertificateAuthority(
        request: DeleteCertificateAuthorityRequest
      ): F[DeleteCertificateAuthorityResponse]

      def deletePermission(
        request: DeletePermissionRequest
      ): F[DeletePermissionResponse]

      def deletePolicy(
        request: DeletePolicyRequest
      ): F[DeletePolicyResponse]

      def describeCertificateAuthority(
        request: DescribeCertificateAuthorityRequest
      ): F[DescribeCertificateAuthorityResponse]

      def describeCertificateAuthorityAuditReport(
        request: DescribeCertificateAuthorityAuditReportRequest
      ): F[DescribeCertificateAuthorityAuditReportResponse]

      def getCertificate(
        request: GetCertificateRequest
      ): F[GetCertificateResponse]

      def getCertificateAuthorityCertificate(
        request: GetCertificateAuthorityCertificateRequest
      ): F[GetCertificateAuthorityCertificateResponse]

      def getCertificateAuthorityCsr(
        request: GetCertificateAuthorityCsrRequest
      ): F[GetCertificateAuthorityCsrResponse]

      def getPolicy(
        request: GetPolicyRequest
      ): F[GetPolicyResponse]

      def importCertificateAuthorityCertificate(
        request: ImportCertificateAuthorityCertificateRequest
      ): F[ImportCertificateAuthorityCertificateResponse]

      def issueCertificate(
        request: IssueCertificateRequest
      ): F[IssueCertificateResponse]

      def listCertificateAuthorities(
        request: ListCertificateAuthoritiesRequest
      ): F[ListCertificateAuthoritiesResponse]

      def listPermissions(
        request: ListPermissionsRequest
      ): F[ListPermissionsResponse]

      def listTags(
        request: ListTagsRequest
      ): F[ListTagsResponse]

      def putPolicy(
        request: PutPolicyRequest
      ): F[PutPolicyResponse]

      def restoreCertificateAuthority(
        request: RestoreCertificateAuthorityRequest
      ): F[RestoreCertificateAuthorityResponse]

      def revokeCertificate(
        request: RevokeCertificateRequest
      ): F[RevokeCertificateResponse]

      def tagCertificateAuthority(
        request: TagCertificateAuthorityRequest
      ): F[TagCertificateAuthorityResponse]

      def untagCertificateAuthority(
        request: UntagCertificateAuthorityRequest
      ): F[UntagCertificateAuthorityResponse]

      def updateCertificateAuthority(
        request: UpdateCertificateAuthorityRequest
      ): F[UpdateCertificateAuthorityResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends AcmPcaOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateCertificateAuthorityOp(
      request: CreateCertificateAuthorityRequest
    ) extends AcmPcaOp[CreateCertificateAuthorityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCertificateAuthorityResponse] =
        visitor.createCertificateAuthority(request)
    }

    final case class CreateCertificateAuthorityAuditReportOp(
      request: CreateCertificateAuthorityAuditReportRequest
    ) extends AcmPcaOp[CreateCertificateAuthorityAuditReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCertificateAuthorityAuditReportResponse] =
        visitor.createCertificateAuthorityAuditReport(request)
    }

    final case class CreatePermissionOp(
      request: CreatePermissionRequest
    ) extends AcmPcaOp[CreatePermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePermissionResponse] =
        visitor.createPermission(request)
    }

    final case class DeleteCertificateAuthorityOp(
      request: DeleteCertificateAuthorityRequest
    ) extends AcmPcaOp[DeleteCertificateAuthorityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCertificateAuthorityResponse] =
        visitor.deleteCertificateAuthority(request)
    }

    final case class DeletePermissionOp(
      request: DeletePermissionRequest
    ) extends AcmPcaOp[DeletePermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePermissionResponse] =
        visitor.deletePermission(request)
    }

    final case class DeletePolicyOp(
      request: DeletePolicyRequest
    ) extends AcmPcaOp[DeletePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePolicyResponse] =
        visitor.deletePolicy(request)
    }

    final case class DescribeCertificateAuthorityOp(
      request: DescribeCertificateAuthorityRequest
    ) extends AcmPcaOp[DescribeCertificateAuthorityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCertificateAuthorityResponse] =
        visitor.describeCertificateAuthority(request)
    }

    final case class DescribeCertificateAuthorityAuditReportOp(
      request: DescribeCertificateAuthorityAuditReportRequest
    ) extends AcmPcaOp[DescribeCertificateAuthorityAuditReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCertificateAuthorityAuditReportResponse] =
        visitor.describeCertificateAuthorityAuditReport(request)
    }

    final case class GetCertificateOp(
      request: GetCertificateRequest
    ) extends AcmPcaOp[GetCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCertificateResponse] =
        visitor.getCertificate(request)
    }

    final case class GetCertificateAuthorityCertificateOp(
      request: GetCertificateAuthorityCertificateRequest
    ) extends AcmPcaOp[GetCertificateAuthorityCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCertificateAuthorityCertificateResponse] =
        visitor.getCertificateAuthorityCertificate(request)
    }

    final case class GetCertificateAuthorityCsrOp(
      request: GetCertificateAuthorityCsrRequest
    ) extends AcmPcaOp[GetCertificateAuthorityCsrResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCertificateAuthorityCsrResponse] =
        visitor.getCertificateAuthorityCsr(request)
    }

    final case class GetPolicyOp(
      request: GetPolicyRequest
    ) extends AcmPcaOp[GetPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPolicyResponse] =
        visitor.getPolicy(request)
    }

    final case class ImportCertificateAuthorityCertificateOp(
      request: ImportCertificateAuthorityCertificateRequest
    ) extends AcmPcaOp[ImportCertificateAuthorityCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportCertificateAuthorityCertificateResponse] =
        visitor.importCertificateAuthorityCertificate(request)
    }

    final case class IssueCertificateOp(
      request: IssueCertificateRequest
    ) extends AcmPcaOp[IssueCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[IssueCertificateResponse] =
        visitor.issueCertificate(request)
    }

    final case class ListCertificateAuthoritiesOp(
      request: ListCertificateAuthoritiesRequest
    ) extends AcmPcaOp[ListCertificateAuthoritiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCertificateAuthoritiesResponse] =
        visitor.listCertificateAuthorities(request)
    }

    final case class ListPermissionsOp(
      request: ListPermissionsRequest
    ) extends AcmPcaOp[ListPermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPermissionsResponse] =
        visitor.listPermissions(request)
    }

    final case class ListTagsOp(
      request: ListTagsRequest
    ) extends AcmPcaOp[ListTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsResponse] =
        visitor.listTags(request)
    }

    final case class PutPolicyOp(
      request: PutPolicyRequest
    ) extends AcmPcaOp[PutPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutPolicyResponse] =
        visitor.putPolicy(request)
    }

    final case class RestoreCertificateAuthorityOp(
      request: RestoreCertificateAuthorityRequest
    ) extends AcmPcaOp[RestoreCertificateAuthorityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreCertificateAuthorityResponse] =
        visitor.restoreCertificateAuthority(request)
    }

    final case class RevokeCertificateOp(
      request: RevokeCertificateRequest
    ) extends AcmPcaOp[RevokeCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RevokeCertificateResponse] =
        visitor.revokeCertificate(request)
    }

    final case class TagCertificateAuthorityOp(
      request: TagCertificateAuthorityRequest
    ) extends AcmPcaOp[TagCertificateAuthorityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagCertificateAuthorityResponse] =
        visitor.tagCertificateAuthority(request)
    }

    final case class UntagCertificateAuthorityOp(
      request: UntagCertificateAuthorityRequest
    ) extends AcmPcaOp[UntagCertificateAuthorityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagCertificateAuthorityResponse] =
        visitor.untagCertificateAuthority(request)
    }

    final case class UpdateCertificateAuthorityOp(
      request: UpdateCertificateAuthorityRequest
    ) extends AcmPcaOp[UpdateCertificateAuthorityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCertificateAuthorityResponse] =
        visitor.updateCertificateAuthority(request)
    }
  }

  import AcmPcaOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[AcmPcaOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createCertificateAuthority(
    request: CreateCertificateAuthorityRequest
  ): AcmPcaIO[CreateCertificateAuthorityResponse] =
    FF.liftF(CreateCertificateAuthorityOp(request))

  def createCertificateAuthorityAuditReport(
    request: CreateCertificateAuthorityAuditReportRequest
  ): AcmPcaIO[CreateCertificateAuthorityAuditReportResponse] =
    FF.liftF(CreateCertificateAuthorityAuditReportOp(request))

  def createPermission(
    request: CreatePermissionRequest
  ): AcmPcaIO[CreatePermissionResponse] =
    FF.liftF(CreatePermissionOp(request))

  def deleteCertificateAuthority(
    request: DeleteCertificateAuthorityRequest
  ): AcmPcaIO[DeleteCertificateAuthorityResponse] =
    FF.liftF(DeleteCertificateAuthorityOp(request))

  def deletePermission(
    request: DeletePermissionRequest
  ): AcmPcaIO[DeletePermissionResponse] =
    FF.liftF(DeletePermissionOp(request))

  def deletePolicy(
    request: DeletePolicyRequest
  ): AcmPcaIO[DeletePolicyResponse] =
    FF.liftF(DeletePolicyOp(request))

  def describeCertificateAuthority(
    request: DescribeCertificateAuthorityRequest
  ): AcmPcaIO[DescribeCertificateAuthorityResponse] =
    FF.liftF(DescribeCertificateAuthorityOp(request))

  def describeCertificateAuthorityAuditReport(
    request: DescribeCertificateAuthorityAuditReportRequest
  ): AcmPcaIO[DescribeCertificateAuthorityAuditReportResponse] =
    FF.liftF(DescribeCertificateAuthorityAuditReportOp(request))

  def getCertificate(
    request: GetCertificateRequest
  ): AcmPcaIO[GetCertificateResponse] =
    FF.liftF(GetCertificateOp(request))

  def getCertificateAuthorityCertificate(
    request: GetCertificateAuthorityCertificateRequest
  ): AcmPcaIO[GetCertificateAuthorityCertificateResponse] =
    FF.liftF(GetCertificateAuthorityCertificateOp(request))

  def getCertificateAuthorityCsr(
    request: GetCertificateAuthorityCsrRequest
  ): AcmPcaIO[GetCertificateAuthorityCsrResponse] =
    FF.liftF(GetCertificateAuthorityCsrOp(request))

  def getPolicy(
    request: GetPolicyRequest
  ): AcmPcaIO[GetPolicyResponse] =
    FF.liftF(GetPolicyOp(request))

  def importCertificateAuthorityCertificate(
    request: ImportCertificateAuthorityCertificateRequest
  ): AcmPcaIO[ImportCertificateAuthorityCertificateResponse] =
    FF.liftF(ImportCertificateAuthorityCertificateOp(request))

  def issueCertificate(
    request: IssueCertificateRequest
  ): AcmPcaIO[IssueCertificateResponse] =
    FF.liftF(IssueCertificateOp(request))

  def listCertificateAuthorities(
    request: ListCertificateAuthoritiesRequest
  ): AcmPcaIO[ListCertificateAuthoritiesResponse] =
    FF.liftF(ListCertificateAuthoritiesOp(request))

  def listPermissions(
    request: ListPermissionsRequest
  ): AcmPcaIO[ListPermissionsResponse] =
    FF.liftF(ListPermissionsOp(request))

  def listTags(
    request: ListTagsRequest
  ): AcmPcaIO[ListTagsResponse] =
    FF.liftF(ListTagsOp(request))

  def putPolicy(
    request: PutPolicyRequest
  ): AcmPcaIO[PutPolicyResponse] =
    FF.liftF(PutPolicyOp(request))

  def restoreCertificateAuthority(
    request: RestoreCertificateAuthorityRequest
  ): AcmPcaIO[RestoreCertificateAuthorityResponse] =
    FF.liftF(RestoreCertificateAuthorityOp(request))

  def revokeCertificate(
    request: RevokeCertificateRequest
  ): AcmPcaIO[RevokeCertificateResponse] =
    FF.liftF(RevokeCertificateOp(request))

  def tagCertificateAuthority(
    request: TagCertificateAuthorityRequest
  ): AcmPcaIO[TagCertificateAuthorityResponse] =
    FF.liftF(TagCertificateAuthorityOp(request))

  def untagCertificateAuthority(
    request: UntagCertificateAuthorityRequest
  ): AcmPcaIO[UntagCertificateAuthorityResponse] =
    FF.liftF(UntagCertificateAuthorityOp(request))

  def updateCertificateAuthority(
    request: UpdateCertificateAuthorityRequest
  ): AcmPcaIO[UpdateCertificateAuthorityResponse] =
    FF.liftF(UpdateCertificateAuthorityOp(request))
}
