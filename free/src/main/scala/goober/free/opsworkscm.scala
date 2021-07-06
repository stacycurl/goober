package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.opsworkscm.OpsWorksCmClient
import software.amazon.awssdk.services.opsworkscm.model._


object opsworkscm { module =>

  // Free monad over OpsWorksCmOp
  type OpsWorksCmIO[A] = FF[OpsWorksCmOp, A]

  sealed trait OpsWorksCmOp[A] {
    def visit[F[_]](visitor: OpsWorksCmOp.Visitor[F]): F[A]
  }

  object OpsWorksCmOp {
    // Given a OpsWorksCmClient we can embed a OpsWorksCmIO program in any algebra that understands embedding.
    implicit val OpsWorksCmOpEmbeddable: Embeddable[OpsWorksCmOp, OpsWorksCmClient] = new Embeddable[OpsWorksCmOp, OpsWorksCmClient] {
      def embed[A](client: OpsWorksCmClient, io: OpsWorksCmIO[A]): Embedded[A] = Embedded.OpsWorksCm(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends OpsWorksCmOp.Visitor[Kleisli[M, OpsWorksCmClient, *]] {
        def associateNode(
          request: AssociateNodeRequest
        ): Kleisli[M, OpsWorksCmClient, AssociateNodeResponse] =
          primitive(_.associateNode(request))

        def createBackup(
          request: CreateBackupRequest
        ): Kleisli[M, OpsWorksCmClient, CreateBackupResponse] =
          primitive(_.createBackup(request))

        def createServer(
          request: CreateServerRequest
        ): Kleisli[M, OpsWorksCmClient, CreateServerResponse] =
          primitive(_.createServer(request))

        def deleteBackup(
          request: DeleteBackupRequest
        ): Kleisli[M, OpsWorksCmClient, DeleteBackupResponse] =
          primitive(_.deleteBackup(request))

        def deleteServer(
          request: DeleteServerRequest
        ): Kleisli[M, OpsWorksCmClient, DeleteServerResponse] =
          primitive(_.deleteServer(request))

        def describeAccountAttributes(
          request: DescribeAccountAttributesRequest
        ): Kleisli[M, OpsWorksCmClient, DescribeAccountAttributesResponse] =
          primitive(_.describeAccountAttributes(request))

        def describeBackups(
          request: DescribeBackupsRequest
        ): Kleisli[M, OpsWorksCmClient, DescribeBackupsResponse] =
          primitive(_.describeBackups(request))

        def describeEvents(
          request: DescribeEventsRequest
        ): Kleisli[M, OpsWorksCmClient, DescribeEventsResponse] =
          primitive(_.describeEvents(request))

        def describeNodeAssociationStatus(
          request: DescribeNodeAssociationStatusRequest
        ): Kleisli[M, OpsWorksCmClient, DescribeNodeAssociationStatusResponse] =
          primitive(_.describeNodeAssociationStatus(request))

        def describeServers(
          request: DescribeServersRequest
        ): Kleisli[M, OpsWorksCmClient, DescribeServersResponse] =
          primitive(_.describeServers(request))

        def disassociateNode(
          request: DisassociateNodeRequest
        ): Kleisli[M, OpsWorksCmClient, DisassociateNodeResponse] =
          primitive(_.disassociateNode(request))

        def exportServerEngineAttribute(
          request: ExportServerEngineAttributeRequest
        ): Kleisli[M, OpsWorksCmClient, ExportServerEngineAttributeResponse] =
          primitive(_.exportServerEngineAttribute(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, OpsWorksCmClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def restoreServer(
          request: RestoreServerRequest
        ): Kleisli[M, OpsWorksCmClient, RestoreServerResponse] =
          primitive(_.restoreServer(request))

        def startMaintenance(
          request: StartMaintenanceRequest
        ): Kleisli[M, OpsWorksCmClient, StartMaintenanceResponse] =
          primitive(_.startMaintenance(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, OpsWorksCmClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, OpsWorksCmClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateServer(
          request: UpdateServerRequest
        ): Kleisli[M, OpsWorksCmClient, UpdateServerResponse] =
          primitive(_.updateServer(request))

        def updateServerEngineAttributes(
          request: UpdateServerEngineAttributesRequest
        ): Kleisli[M, OpsWorksCmClient, UpdateServerEngineAttributesResponse] =
          primitive(_.updateServerEngineAttributes(request))

        def primitive[A](
          f: OpsWorksCmClient => A
        ): Kleisli[M, OpsWorksCmClient, A]
      }
    }

    trait Visitor[F[_]] extends (OpsWorksCmOp ~> F) {
      final def apply[A](op: OpsWorksCmOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateNode(
        request: AssociateNodeRequest
      ): F[AssociateNodeResponse]

      def createBackup(
        request: CreateBackupRequest
      ): F[CreateBackupResponse]

      def createServer(
        request: CreateServerRequest
      ): F[CreateServerResponse]

      def deleteBackup(
        request: DeleteBackupRequest
      ): F[DeleteBackupResponse]

      def deleteServer(
        request: DeleteServerRequest
      ): F[DeleteServerResponse]

      def describeAccountAttributes(
        request: DescribeAccountAttributesRequest
      ): F[DescribeAccountAttributesResponse]

      def describeBackups(
        request: DescribeBackupsRequest
      ): F[DescribeBackupsResponse]

      def describeEvents(
        request: DescribeEventsRequest
      ): F[DescribeEventsResponse]

      def describeNodeAssociationStatus(
        request: DescribeNodeAssociationStatusRequest
      ): F[DescribeNodeAssociationStatusResponse]

      def describeServers(
        request: DescribeServersRequest
      ): F[DescribeServersResponse]

      def disassociateNode(
        request: DisassociateNodeRequest
      ): F[DisassociateNodeResponse]

      def exportServerEngineAttribute(
        request: ExportServerEngineAttributeRequest
      ): F[ExportServerEngineAttributeResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def restoreServer(
        request: RestoreServerRequest
      ): F[RestoreServerResponse]

      def startMaintenance(
        request: StartMaintenanceRequest
      ): F[StartMaintenanceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateServer(
        request: UpdateServerRequest
      ): F[UpdateServerResponse]

      def updateServerEngineAttributes(
        request: UpdateServerEngineAttributesRequest
      ): F[UpdateServerEngineAttributesResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends OpsWorksCmOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateNodeOp(
      request: AssociateNodeRequest
    ) extends OpsWorksCmOp[AssociateNodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateNodeResponse] =
        visitor.associateNode(request)
    }

    final case class CreateBackupOp(
      request: CreateBackupRequest
    ) extends OpsWorksCmOp[CreateBackupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBackupResponse] =
        visitor.createBackup(request)
    }

    final case class CreateServerOp(
      request: CreateServerRequest
    ) extends OpsWorksCmOp[CreateServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateServerResponse] =
        visitor.createServer(request)
    }

    final case class DeleteBackupOp(
      request: DeleteBackupRequest
    ) extends OpsWorksCmOp[DeleteBackupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBackupResponse] =
        visitor.deleteBackup(request)
    }

    final case class DeleteServerOp(
      request: DeleteServerRequest
    ) extends OpsWorksCmOp[DeleteServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteServerResponse] =
        visitor.deleteServer(request)
    }

    final case class DescribeAccountAttributesOp(
      request: DescribeAccountAttributesRequest
    ) extends OpsWorksCmOp[DescribeAccountAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountAttributesResponse] =
        visitor.describeAccountAttributes(request)
    }

    final case class DescribeBackupsOp(
      request: DescribeBackupsRequest
    ) extends OpsWorksCmOp[DescribeBackupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBackupsResponse] =
        visitor.describeBackups(request)
    }

    final case class DescribeEventsOp(
      request: DescribeEventsRequest
    ) extends OpsWorksCmOp[DescribeEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventsResponse] =
        visitor.describeEvents(request)
    }

    final case class DescribeNodeAssociationStatusOp(
      request: DescribeNodeAssociationStatusRequest
    ) extends OpsWorksCmOp[DescribeNodeAssociationStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNodeAssociationStatusResponse] =
        visitor.describeNodeAssociationStatus(request)
    }

    final case class DescribeServersOp(
      request: DescribeServersRequest
    ) extends OpsWorksCmOp[DescribeServersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeServersResponse] =
        visitor.describeServers(request)
    }

    final case class DisassociateNodeOp(
      request: DisassociateNodeRequest
    ) extends OpsWorksCmOp[DisassociateNodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateNodeResponse] =
        visitor.disassociateNode(request)
    }

    final case class ExportServerEngineAttributeOp(
      request: ExportServerEngineAttributeRequest
    ) extends OpsWorksCmOp[ExportServerEngineAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExportServerEngineAttributeResponse] =
        visitor.exportServerEngineAttribute(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends OpsWorksCmOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class RestoreServerOp(
      request: RestoreServerRequest
    ) extends OpsWorksCmOp[RestoreServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreServerResponse] =
        visitor.restoreServer(request)
    }

    final case class StartMaintenanceOp(
      request: StartMaintenanceRequest
    ) extends OpsWorksCmOp[StartMaintenanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartMaintenanceResponse] =
        visitor.startMaintenance(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends OpsWorksCmOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends OpsWorksCmOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateServerOp(
      request: UpdateServerRequest
    ) extends OpsWorksCmOp[UpdateServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateServerResponse] =
        visitor.updateServer(request)
    }

    final case class UpdateServerEngineAttributesOp(
      request: UpdateServerEngineAttributesRequest
    ) extends OpsWorksCmOp[UpdateServerEngineAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateServerEngineAttributesResponse] =
        visitor.updateServerEngineAttributes(request)
    }
  }

  import OpsWorksCmOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[OpsWorksCmOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateNode(
    request: AssociateNodeRequest
  ): OpsWorksCmIO[AssociateNodeResponse] =
    FF.liftF(AssociateNodeOp(request))

  def createBackup(
    request: CreateBackupRequest
  ): OpsWorksCmIO[CreateBackupResponse] =
    FF.liftF(CreateBackupOp(request))

  def createServer(
    request: CreateServerRequest
  ): OpsWorksCmIO[CreateServerResponse] =
    FF.liftF(CreateServerOp(request))

  def deleteBackup(
    request: DeleteBackupRequest
  ): OpsWorksCmIO[DeleteBackupResponse] =
    FF.liftF(DeleteBackupOp(request))

  def deleteServer(
    request: DeleteServerRequest
  ): OpsWorksCmIO[DeleteServerResponse] =
    FF.liftF(DeleteServerOp(request))

  def describeAccountAttributes(
    request: DescribeAccountAttributesRequest
  ): OpsWorksCmIO[DescribeAccountAttributesResponse] =
    FF.liftF(DescribeAccountAttributesOp(request))

  def describeBackups(
    request: DescribeBackupsRequest
  ): OpsWorksCmIO[DescribeBackupsResponse] =
    FF.liftF(DescribeBackupsOp(request))

  def describeEvents(
    request: DescribeEventsRequest
  ): OpsWorksCmIO[DescribeEventsResponse] =
    FF.liftF(DescribeEventsOp(request))

  def describeNodeAssociationStatus(
    request: DescribeNodeAssociationStatusRequest
  ): OpsWorksCmIO[DescribeNodeAssociationStatusResponse] =
    FF.liftF(DescribeNodeAssociationStatusOp(request))

  def describeServers(
    request: DescribeServersRequest
  ): OpsWorksCmIO[DescribeServersResponse] =
    FF.liftF(DescribeServersOp(request))

  def disassociateNode(
    request: DisassociateNodeRequest
  ): OpsWorksCmIO[DisassociateNodeResponse] =
    FF.liftF(DisassociateNodeOp(request))

  def exportServerEngineAttribute(
    request: ExportServerEngineAttributeRequest
  ): OpsWorksCmIO[ExportServerEngineAttributeResponse] =
    FF.liftF(ExportServerEngineAttributeOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): OpsWorksCmIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def restoreServer(
    request: RestoreServerRequest
  ): OpsWorksCmIO[RestoreServerResponse] =
    FF.liftF(RestoreServerOp(request))

  def startMaintenance(
    request: StartMaintenanceRequest
  ): OpsWorksCmIO[StartMaintenanceResponse] =
    FF.liftF(StartMaintenanceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): OpsWorksCmIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): OpsWorksCmIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateServer(
    request: UpdateServerRequest
  ): OpsWorksCmIO[UpdateServerResponse] =
    FF.liftF(UpdateServerOp(request))

  def updateServerEngineAttributes(
    request: UpdateServerEngineAttributesRequest
  ): OpsWorksCmIO[UpdateServerEngineAttributesResponse] =
    FF.liftF(UpdateServerEngineAttributesOp(request))
}
