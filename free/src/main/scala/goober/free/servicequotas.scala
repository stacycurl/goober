package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.servicequotas.ServiceQuotasClient
import software.amazon.awssdk.services.servicequotas.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object servicequotas { module =>

  // Free monad over ServiceQuotasOp
  type ServiceQuotasIO[A] = FF[ServiceQuotasOp, A]

  sealed trait ServiceQuotasOp[A] {
    def visit[F[_]](visitor: ServiceQuotasOp.Visitor[F]): F[A]
  }

  object ServiceQuotasOp {
    // Given a ServiceQuotasClient we can embed a ServiceQuotasIO program in any algebra that understands embedding.
    implicit val ServiceQuotasOpEmbeddable: Embeddable[ServiceQuotasOp, ServiceQuotasClient] = new Embeddable[ServiceQuotasOp, ServiceQuotasClient] {
      def embed[A](client: ServiceQuotasClient, io: ServiceQuotasIO[A]): Embedded[A] = Embedded.ServiceQuotas(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ServiceQuotasOp.Visitor[Kleisli[M, ServiceQuotasClient, *]] {
        def associateServiceQuotaTemplate(
          request: AssociateServiceQuotaTemplateRequest
        ): Kleisli[M, ServiceQuotasClient, AssociateServiceQuotaTemplateResponse] =
          primitive(_.associateServiceQuotaTemplate(request))

        def deleteServiceQuotaIncreaseRequestFromTemplate(
          request: DeleteServiceQuotaIncreaseRequestFromTemplateRequest
        ): Kleisli[M, ServiceQuotasClient, DeleteServiceQuotaIncreaseRequestFromTemplateResponse] =
          primitive(_.deleteServiceQuotaIncreaseRequestFromTemplate(request))

        def disassociateServiceQuotaTemplate(
          request: DisassociateServiceQuotaTemplateRequest
        ): Kleisli[M, ServiceQuotasClient, DisassociateServiceQuotaTemplateResponse] =
          primitive(_.disassociateServiceQuotaTemplate(request))

        def getAWSDefaultServiceQuota(
          request: GetAwsDefaultServiceQuotaRequest
        ): Kleisli[M, ServiceQuotasClient, GetAwsDefaultServiceQuotaResponse] =
          primitive(_.getAWSDefaultServiceQuota(request))

        def getAssociationForServiceQuotaTemplate(
          request: GetAssociationForServiceQuotaTemplateRequest
        ): Kleisli[M, ServiceQuotasClient, GetAssociationForServiceQuotaTemplateResponse] =
          primitive(_.getAssociationForServiceQuotaTemplate(request))

        def getRequestedServiceQuotaChange(
          request: GetRequestedServiceQuotaChangeRequest
        ): Kleisli[M, ServiceQuotasClient, GetRequestedServiceQuotaChangeResponse] =
          primitive(_.getRequestedServiceQuotaChange(request))

        def getServiceQuota(
          request: GetServiceQuotaRequest
        ): Kleisli[M, ServiceQuotasClient, GetServiceQuotaResponse] =
          primitive(_.getServiceQuota(request))

        def getServiceQuotaIncreaseRequestFromTemplate(
          request: GetServiceQuotaIncreaseRequestFromTemplateRequest
        ): Kleisli[M, ServiceQuotasClient, GetServiceQuotaIncreaseRequestFromTemplateResponse] =
          primitive(_.getServiceQuotaIncreaseRequestFromTemplate(request))

        def listAWSDefaultServiceQuotas(
          request: ListAwsDefaultServiceQuotasRequest
        ): Kleisli[M, ServiceQuotasClient, ListAwsDefaultServiceQuotasResponse] =
          primitive(_.listAWSDefaultServiceQuotas(request))

        def listRequestedServiceQuotaChangeHistory(
          request: ListRequestedServiceQuotaChangeHistoryRequest
        ): Kleisli[M, ServiceQuotasClient, ListRequestedServiceQuotaChangeHistoryResponse] =
          primitive(_.listRequestedServiceQuotaChangeHistory(request))

        def listRequestedServiceQuotaChangeHistoryByQuota(
          request: ListRequestedServiceQuotaChangeHistoryByQuotaRequest
        ): Kleisli[M, ServiceQuotasClient, ListRequestedServiceQuotaChangeHistoryByQuotaResponse] =
          primitive(_.listRequestedServiceQuotaChangeHistoryByQuota(request))

        def listServiceQuotaIncreaseRequestsInTemplate(
          request: ListServiceQuotaIncreaseRequestsInTemplateRequest
        ): Kleisli[M, ServiceQuotasClient, ListServiceQuotaIncreaseRequestsInTemplateResponse] =
          primitive(_.listServiceQuotaIncreaseRequestsInTemplate(request))

        def listServiceQuotas(
          request: ListServiceQuotasRequest
        ): Kleisli[M, ServiceQuotasClient, ListServiceQuotasResponse] =
          primitive(_.listServiceQuotas(request))

        def listServices(
          request: ListServicesRequest
        ): Kleisli[M, ServiceQuotasClient, ListServicesResponse] =
          primitive(_.listServices(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, ServiceQuotasClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putServiceQuotaIncreaseRequestIntoTemplate(
          request: PutServiceQuotaIncreaseRequestIntoTemplateRequest
        ): Kleisli[M, ServiceQuotasClient, PutServiceQuotaIncreaseRequestIntoTemplateResponse] =
          primitive(_.putServiceQuotaIncreaseRequestIntoTemplate(request))

        def requestServiceQuotaIncrease(
          request: RequestServiceQuotaIncreaseRequest
        ): Kleisli[M, ServiceQuotasClient, RequestServiceQuotaIncreaseResponse] =
          primitive(_.requestServiceQuotaIncrease(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, ServiceQuotasClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, ServiceQuotasClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: ServiceQuotasClient => A
        ): Kleisli[M, ServiceQuotasClient, A]
      }
    }

    trait Visitor[F[_]] extends (ServiceQuotasOp ~> F) {
      final def apply[A](op: ServiceQuotasOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateServiceQuotaTemplate(
        request: AssociateServiceQuotaTemplateRequest
      ): F[AssociateServiceQuotaTemplateResponse]

      def deleteServiceQuotaIncreaseRequestFromTemplate(
        request: DeleteServiceQuotaIncreaseRequestFromTemplateRequest
      ): F[DeleteServiceQuotaIncreaseRequestFromTemplateResponse]

      def disassociateServiceQuotaTemplate(
        request: DisassociateServiceQuotaTemplateRequest
      ): F[DisassociateServiceQuotaTemplateResponse]

      def getAWSDefaultServiceQuota(
        request: GetAwsDefaultServiceQuotaRequest
      ): F[GetAwsDefaultServiceQuotaResponse]

      def getAssociationForServiceQuotaTemplate(
        request: GetAssociationForServiceQuotaTemplateRequest
      ): F[GetAssociationForServiceQuotaTemplateResponse]

      def getRequestedServiceQuotaChange(
        request: GetRequestedServiceQuotaChangeRequest
      ): F[GetRequestedServiceQuotaChangeResponse]

      def getServiceQuota(
        request: GetServiceQuotaRequest
      ): F[GetServiceQuotaResponse]

      def getServiceQuotaIncreaseRequestFromTemplate(
        request: GetServiceQuotaIncreaseRequestFromTemplateRequest
      ): F[GetServiceQuotaIncreaseRequestFromTemplateResponse]

      def listAWSDefaultServiceQuotas(
        request: ListAwsDefaultServiceQuotasRequest
      ): F[ListAwsDefaultServiceQuotasResponse]

      def listRequestedServiceQuotaChangeHistory(
        request: ListRequestedServiceQuotaChangeHistoryRequest
      ): F[ListRequestedServiceQuotaChangeHistoryResponse]

      def listRequestedServiceQuotaChangeHistoryByQuota(
        request: ListRequestedServiceQuotaChangeHistoryByQuotaRequest
      ): F[ListRequestedServiceQuotaChangeHistoryByQuotaResponse]

      def listServiceQuotaIncreaseRequestsInTemplate(
        request: ListServiceQuotaIncreaseRequestsInTemplateRequest
      ): F[ListServiceQuotaIncreaseRequestsInTemplateResponse]

      def listServiceQuotas(
        request: ListServiceQuotasRequest
      ): F[ListServiceQuotasResponse]

      def listServices(
        request: ListServicesRequest
      ): F[ListServicesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putServiceQuotaIncreaseRequestIntoTemplate(
        request: PutServiceQuotaIncreaseRequestIntoTemplateRequest
      ): F[PutServiceQuotaIncreaseRequestIntoTemplateResponse]

      def requestServiceQuotaIncrease(
        request: RequestServiceQuotaIncreaseRequest
      ): F[RequestServiceQuotaIncreaseResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ServiceQuotasOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateServiceQuotaTemplateOp(
      request: AssociateServiceQuotaTemplateRequest
    ) extends ServiceQuotasOp[AssociateServiceQuotaTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateServiceQuotaTemplateResponse] =
        visitor.associateServiceQuotaTemplate(request)
    }

    final case class DeleteServiceQuotaIncreaseRequestFromTemplateOp(
      request: DeleteServiceQuotaIncreaseRequestFromTemplateRequest
    ) extends ServiceQuotasOp[DeleteServiceQuotaIncreaseRequestFromTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteServiceQuotaIncreaseRequestFromTemplateResponse] =
        visitor.deleteServiceQuotaIncreaseRequestFromTemplate(request)
    }

    final case class DisassociateServiceQuotaTemplateOp(
      request: DisassociateServiceQuotaTemplateRequest
    ) extends ServiceQuotasOp[DisassociateServiceQuotaTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateServiceQuotaTemplateResponse] =
        visitor.disassociateServiceQuotaTemplate(request)
    }

    final case class GetAWSDefaultServiceQuotaOp(
      request: GetAwsDefaultServiceQuotaRequest
    ) extends ServiceQuotasOp[GetAwsDefaultServiceQuotaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAwsDefaultServiceQuotaResponse] =
        visitor.getAWSDefaultServiceQuota(request)
    }

    final case class GetAssociationForServiceQuotaTemplateOp(
      request: GetAssociationForServiceQuotaTemplateRequest
    ) extends ServiceQuotasOp[GetAssociationForServiceQuotaTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAssociationForServiceQuotaTemplateResponse] =
        visitor.getAssociationForServiceQuotaTemplate(request)
    }

    final case class GetRequestedServiceQuotaChangeOp(
      request: GetRequestedServiceQuotaChangeRequest
    ) extends ServiceQuotasOp[GetRequestedServiceQuotaChangeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRequestedServiceQuotaChangeResponse] =
        visitor.getRequestedServiceQuotaChange(request)
    }

    final case class GetServiceQuotaOp(
      request: GetServiceQuotaRequest
    ) extends ServiceQuotasOp[GetServiceQuotaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetServiceQuotaResponse] =
        visitor.getServiceQuota(request)
    }

    final case class GetServiceQuotaIncreaseRequestFromTemplateOp(
      request: GetServiceQuotaIncreaseRequestFromTemplateRequest
    ) extends ServiceQuotasOp[GetServiceQuotaIncreaseRequestFromTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetServiceQuotaIncreaseRequestFromTemplateResponse] =
        visitor.getServiceQuotaIncreaseRequestFromTemplate(request)
    }

    final case class ListAWSDefaultServiceQuotasOp(
      request: ListAwsDefaultServiceQuotasRequest
    ) extends ServiceQuotasOp[ListAwsDefaultServiceQuotasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAwsDefaultServiceQuotasResponse] =
        visitor.listAWSDefaultServiceQuotas(request)
    }

    final case class ListRequestedServiceQuotaChangeHistoryOp(
      request: ListRequestedServiceQuotaChangeHistoryRequest
    ) extends ServiceQuotasOp[ListRequestedServiceQuotaChangeHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRequestedServiceQuotaChangeHistoryResponse] =
        visitor.listRequestedServiceQuotaChangeHistory(request)
    }

    final case class ListRequestedServiceQuotaChangeHistoryByQuotaOp(
      request: ListRequestedServiceQuotaChangeHistoryByQuotaRequest
    ) extends ServiceQuotasOp[ListRequestedServiceQuotaChangeHistoryByQuotaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRequestedServiceQuotaChangeHistoryByQuotaResponse] =
        visitor.listRequestedServiceQuotaChangeHistoryByQuota(request)
    }

    final case class ListServiceQuotaIncreaseRequestsInTemplateOp(
      request: ListServiceQuotaIncreaseRequestsInTemplateRequest
    ) extends ServiceQuotasOp[ListServiceQuotaIncreaseRequestsInTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListServiceQuotaIncreaseRequestsInTemplateResponse] =
        visitor.listServiceQuotaIncreaseRequestsInTemplate(request)
    }

    final case class ListServiceQuotasOp(
      request: ListServiceQuotasRequest
    ) extends ServiceQuotasOp[ListServiceQuotasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListServiceQuotasResponse] =
        visitor.listServiceQuotas(request)
    }

    final case class ListServicesOp(
      request: ListServicesRequest
    ) extends ServiceQuotasOp[ListServicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListServicesResponse] =
        visitor.listServices(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends ServiceQuotasOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutServiceQuotaIncreaseRequestIntoTemplateOp(
      request: PutServiceQuotaIncreaseRequestIntoTemplateRequest
    ) extends ServiceQuotasOp[PutServiceQuotaIncreaseRequestIntoTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutServiceQuotaIncreaseRequestIntoTemplateResponse] =
        visitor.putServiceQuotaIncreaseRequestIntoTemplate(request)
    }

    final case class RequestServiceQuotaIncreaseOp(
      request: RequestServiceQuotaIncreaseRequest
    ) extends ServiceQuotasOp[RequestServiceQuotaIncreaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RequestServiceQuotaIncreaseResponse] =
        visitor.requestServiceQuotaIncrease(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends ServiceQuotasOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends ServiceQuotasOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import ServiceQuotasOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ServiceQuotasOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateServiceQuotaTemplate(
    request: AssociateServiceQuotaTemplateRequest
  ): ServiceQuotasIO[AssociateServiceQuotaTemplateResponse] =
    FF.liftF(AssociateServiceQuotaTemplateOp(request))

  def deleteServiceQuotaIncreaseRequestFromTemplate(
    request: DeleteServiceQuotaIncreaseRequestFromTemplateRequest
  ): ServiceQuotasIO[DeleteServiceQuotaIncreaseRequestFromTemplateResponse] =
    FF.liftF(DeleteServiceQuotaIncreaseRequestFromTemplateOp(request))

  def disassociateServiceQuotaTemplate(
    request: DisassociateServiceQuotaTemplateRequest
  ): ServiceQuotasIO[DisassociateServiceQuotaTemplateResponse] =
    FF.liftF(DisassociateServiceQuotaTemplateOp(request))

  def getAWSDefaultServiceQuota(
    request: GetAwsDefaultServiceQuotaRequest
  ): ServiceQuotasIO[GetAwsDefaultServiceQuotaResponse] =
    FF.liftF(GetAWSDefaultServiceQuotaOp(request))

  def getAssociationForServiceQuotaTemplate(
    request: GetAssociationForServiceQuotaTemplateRequest
  ): ServiceQuotasIO[GetAssociationForServiceQuotaTemplateResponse] =
    FF.liftF(GetAssociationForServiceQuotaTemplateOp(request))

  def getRequestedServiceQuotaChange(
    request: GetRequestedServiceQuotaChangeRequest
  ): ServiceQuotasIO[GetRequestedServiceQuotaChangeResponse] =
    FF.liftF(GetRequestedServiceQuotaChangeOp(request))

  def getServiceQuota(
    request: GetServiceQuotaRequest
  ): ServiceQuotasIO[GetServiceQuotaResponse] =
    FF.liftF(GetServiceQuotaOp(request))

  def getServiceQuotaIncreaseRequestFromTemplate(
    request: GetServiceQuotaIncreaseRequestFromTemplateRequest
  ): ServiceQuotasIO[GetServiceQuotaIncreaseRequestFromTemplateResponse] =
    FF.liftF(GetServiceQuotaIncreaseRequestFromTemplateOp(request))

  def listAWSDefaultServiceQuotas(
    request: ListAwsDefaultServiceQuotasRequest
  ): ServiceQuotasIO[ListAwsDefaultServiceQuotasResponse] =
    FF.liftF(ListAWSDefaultServiceQuotasOp(request))

  def listRequestedServiceQuotaChangeHistory(
    request: ListRequestedServiceQuotaChangeHistoryRequest
  ): ServiceQuotasIO[ListRequestedServiceQuotaChangeHistoryResponse] =
    FF.liftF(ListRequestedServiceQuotaChangeHistoryOp(request))

  def listRequestedServiceQuotaChangeHistoryByQuota(
    request: ListRequestedServiceQuotaChangeHistoryByQuotaRequest
  ): ServiceQuotasIO[ListRequestedServiceQuotaChangeHistoryByQuotaResponse] =
    FF.liftF(ListRequestedServiceQuotaChangeHistoryByQuotaOp(request))

  def listServiceQuotaIncreaseRequestsInTemplate(
    request: ListServiceQuotaIncreaseRequestsInTemplateRequest
  ): ServiceQuotasIO[ListServiceQuotaIncreaseRequestsInTemplateResponse] =
    FF.liftF(ListServiceQuotaIncreaseRequestsInTemplateOp(request))

  def listServiceQuotas(
    request: ListServiceQuotasRequest
  ): ServiceQuotasIO[ListServiceQuotasResponse] =
    FF.liftF(ListServiceQuotasOp(request))

  def listServices(
    request: ListServicesRequest
  ): ServiceQuotasIO[ListServicesResponse] =
    FF.liftF(ListServicesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): ServiceQuotasIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putServiceQuotaIncreaseRequestIntoTemplate(
    request: PutServiceQuotaIncreaseRequestIntoTemplateRequest
  ): ServiceQuotasIO[PutServiceQuotaIncreaseRequestIntoTemplateResponse] =
    FF.liftF(PutServiceQuotaIncreaseRequestIntoTemplateOp(request))

  def requestServiceQuotaIncrease(
    request: RequestServiceQuotaIncreaseRequest
  ): ServiceQuotasIO[RequestServiceQuotaIncreaseResponse] =
    FF.liftF(RequestServiceQuotaIncreaseOp(request))

  def tagResource(
    request: TagResourceRequest
  ): ServiceQuotasIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): ServiceQuotasIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
