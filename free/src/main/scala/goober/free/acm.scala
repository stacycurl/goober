package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.acm.AcmClient
import software.amazon.awssdk.services.acm.model._


object acm { module =>

  // Free monad over AcmOp
  type AcmIO[A] = FF[AcmOp, A]

  sealed trait AcmOp[A] {
    def visit[F[_]](visitor: AcmOp.Visitor[F]): F[A]
  }

  object AcmOp {
    // Given a AcmClient we can embed a AcmIO program in any algebra that understands embedding.
    implicit val AcmOpEmbeddable: Embeddable[AcmOp, AcmClient] = new Embeddable[AcmOp, AcmClient] {
      def embed[A](client: AcmClient, io: AcmIO[A]): Embedded[A] = Embedded.Acm(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends AcmOp.Visitor[Kleisli[M, AcmClient, *]] {
        def addTagsToCertificate(
          request: AddTagsToCertificateRequest
        ): Kleisli[M, AcmClient, AddTagsToCertificateResponse] =
          primitive(_.addTagsToCertificate(request))

        def deleteCertificate(
          request: DeleteCertificateRequest
        ): Kleisli[M, AcmClient, DeleteCertificateResponse] =
          primitive(_.deleteCertificate(request))

        def describeCertificate(
          request: DescribeCertificateRequest
        ): Kleisli[M, AcmClient, DescribeCertificateResponse] =
          primitive(_.describeCertificate(request))

        def exportCertificate(
          request: ExportCertificateRequest
        ): Kleisli[M, AcmClient, ExportCertificateResponse] =
          primitive(_.exportCertificate(request))

        def getAccountConfiguration(
          request: GetAccountConfigurationRequest
        ): Kleisli[M, AcmClient, GetAccountConfigurationResponse] =
          primitive(_.getAccountConfiguration(request))

        def getCertificate(
          request: GetCertificateRequest
        ): Kleisli[M, AcmClient, GetCertificateResponse] =
          primitive(_.getCertificate(request))

        def importCertificate(
          request: ImportCertificateRequest
        ): Kleisli[M, AcmClient, ImportCertificateResponse] =
          primitive(_.importCertificate(request))

        def listCertificates(
          request: ListCertificatesRequest
        ): Kleisli[M, AcmClient, ListCertificatesResponse] =
          primitive(_.listCertificates(request))

        def listTagsForCertificate(
          request: ListTagsForCertificateRequest
        ): Kleisli[M, AcmClient, ListTagsForCertificateResponse] =
          primitive(_.listTagsForCertificate(request))

        def putAccountConfiguration(
          request: PutAccountConfigurationRequest
        ): Kleisli[M, AcmClient, PutAccountConfigurationResponse] =
          primitive(_.putAccountConfiguration(request))

        def removeTagsFromCertificate(
          request: RemoveTagsFromCertificateRequest
        ): Kleisli[M, AcmClient, RemoveTagsFromCertificateResponse] =
          primitive(_.removeTagsFromCertificate(request))

        def renewCertificate(
          request: RenewCertificateRequest
        ): Kleisli[M, AcmClient, RenewCertificateResponse] =
          primitive(_.renewCertificate(request))

        def requestCertificate(
          request: RequestCertificateRequest
        ): Kleisli[M, AcmClient, RequestCertificateResponse] =
          primitive(_.requestCertificate(request))

        def resendValidationEmail(
          request: ResendValidationEmailRequest
        ): Kleisli[M, AcmClient, ResendValidationEmailResponse] =
          primitive(_.resendValidationEmail(request))

        def updateCertificateOptions(
          request: UpdateCertificateOptionsRequest
        ): Kleisli[M, AcmClient, UpdateCertificateOptionsResponse] =
          primitive(_.updateCertificateOptions(request))

        def primitive[A](
          f: AcmClient => A
        ): Kleisli[M, AcmClient, A]
      }
    }

    trait Visitor[F[_]] extends (AcmOp ~> F) {
      final def apply[A](op: AcmOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addTagsToCertificate(
        request: AddTagsToCertificateRequest
      ): F[AddTagsToCertificateResponse]

      def deleteCertificate(
        request: DeleteCertificateRequest
      ): F[DeleteCertificateResponse]

      def describeCertificate(
        request: DescribeCertificateRequest
      ): F[DescribeCertificateResponse]

      def exportCertificate(
        request: ExportCertificateRequest
      ): F[ExportCertificateResponse]

      def getAccountConfiguration(
        request: GetAccountConfigurationRequest
      ): F[GetAccountConfigurationResponse]

      def getCertificate(
        request: GetCertificateRequest
      ): F[GetCertificateResponse]

      def importCertificate(
        request: ImportCertificateRequest
      ): F[ImportCertificateResponse]

      def listCertificates(
        request: ListCertificatesRequest
      ): F[ListCertificatesResponse]

      def listTagsForCertificate(
        request: ListTagsForCertificateRequest
      ): F[ListTagsForCertificateResponse]

      def putAccountConfiguration(
        request: PutAccountConfigurationRequest
      ): F[PutAccountConfigurationResponse]

      def removeTagsFromCertificate(
        request: RemoveTagsFromCertificateRequest
      ): F[RemoveTagsFromCertificateResponse]

      def renewCertificate(
        request: RenewCertificateRequest
      ): F[RenewCertificateResponse]

      def requestCertificate(
        request: RequestCertificateRequest
      ): F[RequestCertificateResponse]

      def resendValidationEmail(
        request: ResendValidationEmailRequest
      ): F[ResendValidationEmailResponse]

      def updateCertificateOptions(
        request: UpdateCertificateOptionsRequest
      ): F[UpdateCertificateOptionsResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends AcmOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddTagsToCertificateOp(
      request: AddTagsToCertificateRequest
    ) extends AcmOp[AddTagsToCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsToCertificateResponse] =
        visitor.addTagsToCertificate(request)
    }

    final case class DeleteCertificateOp(
      request: DeleteCertificateRequest
    ) extends AcmOp[DeleteCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCertificateResponse] =
        visitor.deleteCertificate(request)
    }

    final case class DescribeCertificateOp(
      request: DescribeCertificateRequest
    ) extends AcmOp[DescribeCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCertificateResponse] =
        visitor.describeCertificate(request)
    }

    final case class ExportCertificateOp(
      request: ExportCertificateRequest
    ) extends AcmOp[ExportCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExportCertificateResponse] =
        visitor.exportCertificate(request)
    }

    final case class GetAccountConfigurationOp(
      request: GetAccountConfigurationRequest
    ) extends AcmOp[GetAccountConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccountConfigurationResponse] =
        visitor.getAccountConfiguration(request)
    }

    final case class GetCertificateOp(
      request: GetCertificateRequest
    ) extends AcmOp[GetCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCertificateResponse] =
        visitor.getCertificate(request)
    }

    final case class ImportCertificateOp(
      request: ImportCertificateRequest
    ) extends AcmOp[ImportCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportCertificateResponse] =
        visitor.importCertificate(request)
    }

    final case class ListCertificatesOp(
      request: ListCertificatesRequest
    ) extends AcmOp[ListCertificatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCertificatesResponse] =
        visitor.listCertificates(request)
    }

    final case class ListTagsForCertificateOp(
      request: ListTagsForCertificateRequest
    ) extends AcmOp[ListTagsForCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForCertificateResponse] =
        visitor.listTagsForCertificate(request)
    }

    final case class PutAccountConfigurationOp(
      request: PutAccountConfigurationRequest
    ) extends AcmOp[PutAccountConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAccountConfigurationResponse] =
        visitor.putAccountConfiguration(request)
    }

    final case class RemoveTagsFromCertificateOp(
      request: RemoveTagsFromCertificateRequest
    ) extends AcmOp[RemoveTagsFromCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTagsFromCertificateResponse] =
        visitor.removeTagsFromCertificate(request)
    }

    final case class RenewCertificateOp(
      request: RenewCertificateRequest
    ) extends AcmOp[RenewCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RenewCertificateResponse] =
        visitor.renewCertificate(request)
    }

    final case class RequestCertificateOp(
      request: RequestCertificateRequest
    ) extends AcmOp[RequestCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RequestCertificateResponse] =
        visitor.requestCertificate(request)
    }

    final case class ResendValidationEmailOp(
      request: ResendValidationEmailRequest
    ) extends AcmOp[ResendValidationEmailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResendValidationEmailResponse] =
        visitor.resendValidationEmail(request)
    }

    final case class UpdateCertificateOptionsOp(
      request: UpdateCertificateOptionsRequest
    ) extends AcmOp[UpdateCertificateOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCertificateOptionsResponse] =
        visitor.updateCertificateOptions(request)
    }
  }

  import AcmOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[AcmOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addTagsToCertificate(
    request: AddTagsToCertificateRequest
  ): AcmIO[AddTagsToCertificateResponse] =
    FF.liftF(AddTagsToCertificateOp(request))

  def deleteCertificate(
    request: DeleteCertificateRequest
  ): AcmIO[DeleteCertificateResponse] =
    FF.liftF(DeleteCertificateOp(request))

  def describeCertificate(
    request: DescribeCertificateRequest
  ): AcmIO[DescribeCertificateResponse] =
    FF.liftF(DescribeCertificateOp(request))

  def exportCertificate(
    request: ExportCertificateRequest
  ): AcmIO[ExportCertificateResponse] =
    FF.liftF(ExportCertificateOp(request))

  def getAccountConfiguration(
    request: GetAccountConfigurationRequest
  ): AcmIO[GetAccountConfigurationResponse] =
    FF.liftF(GetAccountConfigurationOp(request))

  def getCertificate(
    request: GetCertificateRequest
  ): AcmIO[GetCertificateResponse] =
    FF.liftF(GetCertificateOp(request))

  def importCertificate(
    request: ImportCertificateRequest
  ): AcmIO[ImportCertificateResponse] =
    FF.liftF(ImportCertificateOp(request))

  def listCertificates(
    request: ListCertificatesRequest
  ): AcmIO[ListCertificatesResponse] =
    FF.liftF(ListCertificatesOp(request))

  def listTagsForCertificate(
    request: ListTagsForCertificateRequest
  ): AcmIO[ListTagsForCertificateResponse] =
    FF.liftF(ListTagsForCertificateOp(request))

  def putAccountConfiguration(
    request: PutAccountConfigurationRequest
  ): AcmIO[PutAccountConfigurationResponse] =
    FF.liftF(PutAccountConfigurationOp(request))

  def removeTagsFromCertificate(
    request: RemoveTagsFromCertificateRequest
  ): AcmIO[RemoveTagsFromCertificateResponse] =
    FF.liftF(RemoveTagsFromCertificateOp(request))

  def renewCertificate(
    request: RenewCertificateRequest
  ): AcmIO[RenewCertificateResponse] =
    FF.liftF(RenewCertificateOp(request))

  def requestCertificate(
    request: RequestCertificateRequest
  ): AcmIO[RequestCertificateResponse] =
    FF.liftF(RequestCertificateOp(request))

  def resendValidationEmail(
    request: ResendValidationEmailRequest
  ): AcmIO[ResendValidationEmailResponse] =
    FF.liftF(ResendValidationEmailOp(request))

  def updateCertificateOptions(
    request: UpdateCertificateOptionsRequest
  ): AcmIO[UpdateCertificateOptionsResponse] =
    FF.liftF(UpdateCertificateOptionsOp(request))
}
