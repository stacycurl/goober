package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.glacier.GlacierClient
import software.amazon.awssdk.services.glacier.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody


object glacier { module =>

  // Free monad over GlacierOp
  type GlacierIO[A] = FF[GlacierOp, A]

  sealed trait GlacierOp[A] {
    def visit[F[_]](visitor: GlacierOp.Visitor[F]): F[A]
  }

  object GlacierOp {
    // Given a GlacierClient we can embed a GlacierIO program in any algebra that understands embedding.
    implicit val GlacierOpEmbeddable: Embeddable[GlacierOp, GlacierClient] = new Embeddable[GlacierOp, GlacierClient] {
      def embed[A](client: GlacierClient, io: GlacierIO[A]): Embedded[A] = Embedded.Glacier(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends GlacierOp.Visitor[Kleisli[M, GlacierClient, *]] {
        def abortMultipartUpload(
          request: AbortMultipartUploadRequest
        ): Kleisli[M, GlacierClient, AbortMultipartUploadResponse] =
          primitive(_.abortMultipartUpload(request))

        def abortVaultLock(
          request: AbortVaultLockRequest
        ): Kleisli[M, GlacierClient, AbortVaultLockResponse] =
          primitive(_.abortVaultLock(request))

        def addTagsToVault(
          request: AddTagsToVaultRequest
        ): Kleisli[M, GlacierClient, AddTagsToVaultResponse] =
          primitive(_.addTagsToVault(request))

        def completeMultipartUpload(
          request: CompleteMultipartUploadRequest
        ): Kleisli[M, GlacierClient, CompleteMultipartUploadResponse] =
          primitive(_.completeMultipartUpload(request))

        def completeVaultLock(
          request: CompleteVaultLockRequest
        ): Kleisli[M, GlacierClient, CompleteVaultLockResponse] =
          primitive(_.completeVaultLock(request))

        def createVault(
          request: CreateVaultRequest
        ): Kleisli[M, GlacierClient, CreateVaultResponse] =
          primitive(_.createVault(request))

        def deleteArchive(
          request: DeleteArchiveRequest
        ): Kleisli[M, GlacierClient, DeleteArchiveResponse] =
          primitive(_.deleteArchive(request))

        def deleteVault(
          request: DeleteVaultRequest
        ): Kleisli[M, GlacierClient, DeleteVaultResponse] =
          primitive(_.deleteVault(request))

        def deleteVaultAccessPolicy(
          request: DeleteVaultAccessPolicyRequest
        ): Kleisli[M, GlacierClient, DeleteVaultAccessPolicyResponse] =
          primitive(_.deleteVaultAccessPolicy(request))

        def deleteVaultNotifications(
          request: DeleteVaultNotificationsRequest
        ): Kleisli[M, GlacierClient, DeleteVaultNotificationsResponse] =
          primitive(_.deleteVaultNotifications(request))

        def describeJob(
          request: DescribeJobRequest
        ): Kleisli[M, GlacierClient, DescribeJobResponse] =
          primitive(_.describeJob(request))

        def describeVault(
          request: DescribeVaultRequest
        ): Kleisli[M, GlacierClient, DescribeVaultResponse] =
          primitive(_.describeVault(request))

        def getDataRetrievalPolicy(
          request: GetDataRetrievalPolicyRequest
        ): Kleisli[M, GlacierClient, GetDataRetrievalPolicyResponse] =
          primitive(_.getDataRetrievalPolicy(request))

        def getJobOutput(
          request: GetJobOutputRequest,
          path: Path
        ): Kleisli[M, GlacierClient, GetJobOutputResponse] =
          primitive(_.getJobOutput(request, path))

        def getVaultAccessPolicy(
          request: GetVaultAccessPolicyRequest
        ): Kleisli[M, GlacierClient, GetVaultAccessPolicyResponse] =
          primitive(_.getVaultAccessPolicy(request))

        def getVaultLock(
          request: GetVaultLockRequest
        ): Kleisli[M, GlacierClient, GetVaultLockResponse] =
          primitive(_.getVaultLock(request))

        def getVaultNotifications(
          request: GetVaultNotificationsRequest
        ): Kleisli[M, GlacierClient, GetVaultNotificationsResponse] =
          primitive(_.getVaultNotifications(request))

        def initiateJob(
          request: InitiateJobRequest
        ): Kleisli[M, GlacierClient, InitiateJobResponse] =
          primitive(_.initiateJob(request))

        def initiateMultipartUpload(
          request: InitiateMultipartUploadRequest
        ): Kleisli[M, GlacierClient, InitiateMultipartUploadResponse] =
          primitive(_.initiateMultipartUpload(request))

        def initiateVaultLock(
          request: InitiateVaultLockRequest
        ): Kleisli[M, GlacierClient, InitiateVaultLockResponse] =
          primitive(_.initiateVaultLock(request))

        def listJobs(
          request: ListJobsRequest
        ): Kleisli[M, GlacierClient, ListJobsResponse] =
          primitive(_.listJobs(request))

        def listMultipartUploads(
          request: ListMultipartUploadsRequest
        ): Kleisli[M, GlacierClient, ListMultipartUploadsResponse] =
          primitive(_.listMultipartUploads(request))

        def listParts(
          request: ListPartsRequest
        ): Kleisli[M, GlacierClient, ListPartsResponse] =
          primitive(_.listParts(request))

        def listProvisionedCapacity(
          request: ListProvisionedCapacityRequest
        ): Kleisli[M, GlacierClient, ListProvisionedCapacityResponse] =
          primitive(_.listProvisionedCapacity(request))

        def listTagsForVault(
          request: ListTagsForVaultRequest
        ): Kleisli[M, GlacierClient, ListTagsForVaultResponse] =
          primitive(_.listTagsForVault(request))

        def listVaults(
          request: ListVaultsRequest
        ): Kleisli[M, GlacierClient, ListVaultsResponse] =
          primitive(_.listVaults(request))

        def purchaseProvisionedCapacity(
          request: PurchaseProvisionedCapacityRequest
        ): Kleisli[M, GlacierClient, PurchaseProvisionedCapacityResponse] =
          primitive(_.purchaseProvisionedCapacity(request))

        def removeTagsFromVault(
          request: RemoveTagsFromVaultRequest
        ): Kleisli[M, GlacierClient, RemoveTagsFromVaultResponse] =
          primitive(_.removeTagsFromVault(request))

        def setDataRetrievalPolicy(
          request: SetDataRetrievalPolicyRequest
        ): Kleisli[M, GlacierClient, SetDataRetrievalPolicyResponse] =
          primitive(_.setDataRetrievalPolicy(request))

        def setVaultAccessPolicy(
          request: SetVaultAccessPolicyRequest
        ): Kleisli[M, GlacierClient, SetVaultAccessPolicyResponse] =
          primitive(_.setVaultAccessPolicy(request))

        def setVaultNotifications(
          request: SetVaultNotificationsRequest
        ): Kleisli[M, GlacierClient, SetVaultNotificationsResponse] =
          primitive(_.setVaultNotifications(request))

        def uploadArchive(
          request: UploadArchiveRequest,
          body: RequestBody
        ): Kleisli[M, GlacierClient, UploadArchiveResponse] =
          primitive(_.uploadArchive(request, body))

        def uploadMultipartPart(
          request: UploadMultipartPartRequest,
          body: RequestBody
        ): Kleisli[M, GlacierClient, UploadMultipartPartResponse] =
          primitive(_.uploadMultipartPart(request, body))

        def primitive[A](
          f: GlacierClient => A
        ): Kleisli[M, GlacierClient, A]
      }
    }

    trait Visitor[F[_]] extends (GlacierOp ~> F) {
      final def apply[A](op: GlacierOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def abortMultipartUpload(
        request: AbortMultipartUploadRequest
      ): F[AbortMultipartUploadResponse]

      def abortVaultLock(
        request: AbortVaultLockRequest
      ): F[AbortVaultLockResponse]

      def addTagsToVault(
        request: AddTagsToVaultRequest
      ): F[AddTagsToVaultResponse]

      def completeMultipartUpload(
        request: CompleteMultipartUploadRequest
      ): F[CompleteMultipartUploadResponse]

      def completeVaultLock(
        request: CompleteVaultLockRequest
      ): F[CompleteVaultLockResponse]

      def createVault(
        request: CreateVaultRequest
      ): F[CreateVaultResponse]

      def deleteArchive(
        request: DeleteArchiveRequest
      ): F[DeleteArchiveResponse]

      def deleteVault(
        request: DeleteVaultRequest
      ): F[DeleteVaultResponse]

      def deleteVaultAccessPolicy(
        request: DeleteVaultAccessPolicyRequest
      ): F[DeleteVaultAccessPolicyResponse]

      def deleteVaultNotifications(
        request: DeleteVaultNotificationsRequest
      ): F[DeleteVaultNotificationsResponse]

      def describeJob(
        request: DescribeJobRequest
      ): F[DescribeJobResponse]

      def describeVault(
        request: DescribeVaultRequest
      ): F[DescribeVaultResponse]

      def getDataRetrievalPolicy(
        request: GetDataRetrievalPolicyRequest
      ): F[GetDataRetrievalPolicyResponse]

      def getJobOutput(
        request: GetJobOutputRequest,
        path: Path
      ): F[GetJobOutputResponse]

      def getVaultAccessPolicy(
        request: GetVaultAccessPolicyRequest
      ): F[GetVaultAccessPolicyResponse]

      def getVaultLock(
        request: GetVaultLockRequest
      ): F[GetVaultLockResponse]

      def getVaultNotifications(
        request: GetVaultNotificationsRequest
      ): F[GetVaultNotificationsResponse]

      def initiateJob(
        request: InitiateJobRequest
      ): F[InitiateJobResponse]

      def initiateMultipartUpload(
        request: InitiateMultipartUploadRequest
      ): F[InitiateMultipartUploadResponse]

      def initiateVaultLock(
        request: InitiateVaultLockRequest
      ): F[InitiateVaultLockResponse]

      def listJobs(
        request: ListJobsRequest
      ): F[ListJobsResponse]

      def listMultipartUploads(
        request: ListMultipartUploadsRequest
      ): F[ListMultipartUploadsResponse]

      def listParts(
        request: ListPartsRequest
      ): F[ListPartsResponse]

      def listProvisionedCapacity(
        request: ListProvisionedCapacityRequest
      ): F[ListProvisionedCapacityResponse]

      def listTagsForVault(
        request: ListTagsForVaultRequest
      ): F[ListTagsForVaultResponse]

      def listVaults(
        request: ListVaultsRequest
      ): F[ListVaultsResponse]

      def purchaseProvisionedCapacity(
        request: PurchaseProvisionedCapacityRequest
      ): F[PurchaseProvisionedCapacityResponse]

      def removeTagsFromVault(
        request: RemoveTagsFromVaultRequest
      ): F[RemoveTagsFromVaultResponse]

      def setDataRetrievalPolicy(
        request: SetDataRetrievalPolicyRequest
      ): F[SetDataRetrievalPolicyResponse]

      def setVaultAccessPolicy(
        request: SetVaultAccessPolicyRequest
      ): F[SetVaultAccessPolicyResponse]

      def setVaultNotifications(
        request: SetVaultNotificationsRequest
      ): F[SetVaultNotificationsResponse]

      def uploadArchive(
        request: UploadArchiveRequest,
        body: RequestBody
      ): F[UploadArchiveResponse]

      def uploadMultipartPart(
        request: UploadMultipartPartRequest,
        body: RequestBody
      ): F[UploadMultipartPartResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends GlacierOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AbortMultipartUploadOp(
      request: AbortMultipartUploadRequest
    ) extends GlacierOp[AbortMultipartUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AbortMultipartUploadResponse] =
        visitor.abortMultipartUpload(request)
    }

    final case class AbortVaultLockOp(
      request: AbortVaultLockRequest
    ) extends GlacierOp[AbortVaultLockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AbortVaultLockResponse] =
        visitor.abortVaultLock(request)
    }

    final case class AddTagsToVaultOp(
      request: AddTagsToVaultRequest
    ) extends GlacierOp[AddTagsToVaultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsToVaultResponse] =
        visitor.addTagsToVault(request)
    }

    final case class CompleteMultipartUploadOp(
      request: CompleteMultipartUploadRequest
    ) extends GlacierOp[CompleteMultipartUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CompleteMultipartUploadResponse] =
        visitor.completeMultipartUpload(request)
    }

    final case class CompleteVaultLockOp(
      request: CompleteVaultLockRequest
    ) extends GlacierOp[CompleteVaultLockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CompleteVaultLockResponse] =
        visitor.completeVaultLock(request)
    }

    final case class CreateVaultOp(
      request: CreateVaultRequest
    ) extends GlacierOp[CreateVaultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVaultResponse] =
        visitor.createVault(request)
    }

    final case class DeleteArchiveOp(
      request: DeleteArchiveRequest
    ) extends GlacierOp[DeleteArchiveResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteArchiveResponse] =
        visitor.deleteArchive(request)
    }

    final case class DeleteVaultOp(
      request: DeleteVaultRequest
    ) extends GlacierOp[DeleteVaultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVaultResponse] =
        visitor.deleteVault(request)
    }

    final case class DeleteVaultAccessPolicyOp(
      request: DeleteVaultAccessPolicyRequest
    ) extends GlacierOp[DeleteVaultAccessPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVaultAccessPolicyResponse] =
        visitor.deleteVaultAccessPolicy(request)
    }

    final case class DeleteVaultNotificationsOp(
      request: DeleteVaultNotificationsRequest
    ) extends GlacierOp[DeleteVaultNotificationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVaultNotificationsResponse] =
        visitor.deleteVaultNotifications(request)
    }

    final case class DescribeJobOp(
      request: DescribeJobRequest
    ) extends GlacierOp[DescribeJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeJobResponse] =
        visitor.describeJob(request)
    }

    final case class DescribeVaultOp(
      request: DescribeVaultRequest
    ) extends GlacierOp[DescribeVaultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVaultResponse] =
        visitor.describeVault(request)
    }

    final case class GetDataRetrievalPolicyOp(
      request: GetDataRetrievalPolicyRequest
    ) extends GlacierOp[GetDataRetrievalPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDataRetrievalPolicyResponse] =
        visitor.getDataRetrievalPolicy(request)
    }

    final case class GetJobOutputOp(
      request: GetJobOutputRequest,
      path: Path
    ) extends GlacierOp[GetJobOutputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJobOutputResponse] =
        visitor.getJobOutput(request, path)
    }

    final case class GetVaultAccessPolicyOp(
      request: GetVaultAccessPolicyRequest
    ) extends GlacierOp[GetVaultAccessPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVaultAccessPolicyResponse] =
        visitor.getVaultAccessPolicy(request)
    }

    final case class GetVaultLockOp(
      request: GetVaultLockRequest
    ) extends GlacierOp[GetVaultLockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVaultLockResponse] =
        visitor.getVaultLock(request)
    }

    final case class GetVaultNotificationsOp(
      request: GetVaultNotificationsRequest
    ) extends GlacierOp[GetVaultNotificationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVaultNotificationsResponse] =
        visitor.getVaultNotifications(request)
    }

    final case class InitiateJobOp(
      request: InitiateJobRequest
    ) extends GlacierOp[InitiateJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InitiateJobResponse] =
        visitor.initiateJob(request)
    }

    final case class InitiateMultipartUploadOp(
      request: InitiateMultipartUploadRequest
    ) extends GlacierOp[InitiateMultipartUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InitiateMultipartUploadResponse] =
        visitor.initiateMultipartUpload(request)
    }

    final case class InitiateVaultLockOp(
      request: InitiateVaultLockRequest
    ) extends GlacierOp[InitiateVaultLockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InitiateVaultLockResponse] =
        visitor.initiateVaultLock(request)
    }

    final case class ListJobsOp(
      request: ListJobsRequest
    ) extends GlacierOp[ListJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJobsResponse] =
        visitor.listJobs(request)
    }

    final case class ListMultipartUploadsOp(
      request: ListMultipartUploadsRequest
    ) extends GlacierOp[ListMultipartUploadsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMultipartUploadsResponse] =
        visitor.listMultipartUploads(request)
    }

    final case class ListPartsOp(
      request: ListPartsRequest
    ) extends GlacierOp[ListPartsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPartsResponse] =
        visitor.listParts(request)
    }

    final case class ListProvisionedCapacityOp(
      request: ListProvisionedCapacityRequest
    ) extends GlacierOp[ListProvisionedCapacityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProvisionedCapacityResponse] =
        visitor.listProvisionedCapacity(request)
    }

    final case class ListTagsForVaultOp(
      request: ListTagsForVaultRequest
    ) extends GlacierOp[ListTagsForVaultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForVaultResponse] =
        visitor.listTagsForVault(request)
    }

    final case class ListVaultsOp(
      request: ListVaultsRequest
    ) extends GlacierOp[ListVaultsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVaultsResponse] =
        visitor.listVaults(request)
    }

    final case class PurchaseProvisionedCapacityOp(
      request: PurchaseProvisionedCapacityRequest
    ) extends GlacierOp[PurchaseProvisionedCapacityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PurchaseProvisionedCapacityResponse] =
        visitor.purchaseProvisionedCapacity(request)
    }

    final case class RemoveTagsFromVaultOp(
      request: RemoveTagsFromVaultRequest
    ) extends GlacierOp[RemoveTagsFromVaultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTagsFromVaultResponse] =
        visitor.removeTagsFromVault(request)
    }

    final case class SetDataRetrievalPolicyOp(
      request: SetDataRetrievalPolicyRequest
    ) extends GlacierOp[SetDataRetrievalPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetDataRetrievalPolicyResponse] =
        visitor.setDataRetrievalPolicy(request)
    }

    final case class SetVaultAccessPolicyOp(
      request: SetVaultAccessPolicyRequest
    ) extends GlacierOp[SetVaultAccessPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetVaultAccessPolicyResponse] =
        visitor.setVaultAccessPolicy(request)
    }

    final case class SetVaultNotificationsOp(
      request: SetVaultNotificationsRequest
    ) extends GlacierOp[SetVaultNotificationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetVaultNotificationsResponse] =
        visitor.setVaultNotifications(request)
    }

    final case class UploadArchiveOp(
      request: UploadArchiveRequest,
      body: RequestBody
    ) extends GlacierOp[UploadArchiveResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UploadArchiveResponse] =
        visitor.uploadArchive(request, body)
    }

    final case class UploadMultipartPartOp(
      request: UploadMultipartPartRequest,
      body: RequestBody
    ) extends GlacierOp[UploadMultipartPartResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UploadMultipartPartResponse] =
        visitor.uploadMultipartPart(request, body)
    }
  }

  import GlacierOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[GlacierOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def abortMultipartUpload(
    request: AbortMultipartUploadRequest
  ): GlacierIO[AbortMultipartUploadResponse] =
    FF.liftF(AbortMultipartUploadOp(request))

  def abortVaultLock(
    request: AbortVaultLockRequest
  ): GlacierIO[AbortVaultLockResponse] =
    FF.liftF(AbortVaultLockOp(request))

  def addTagsToVault(
    request: AddTagsToVaultRequest
  ): GlacierIO[AddTagsToVaultResponse] =
    FF.liftF(AddTagsToVaultOp(request))

  def completeMultipartUpload(
    request: CompleteMultipartUploadRequest
  ): GlacierIO[CompleteMultipartUploadResponse] =
    FF.liftF(CompleteMultipartUploadOp(request))

  def completeVaultLock(
    request: CompleteVaultLockRequest
  ): GlacierIO[CompleteVaultLockResponse] =
    FF.liftF(CompleteVaultLockOp(request))

  def createVault(
    request: CreateVaultRequest
  ): GlacierIO[CreateVaultResponse] =
    FF.liftF(CreateVaultOp(request))

  def deleteArchive(
    request: DeleteArchiveRequest
  ): GlacierIO[DeleteArchiveResponse] =
    FF.liftF(DeleteArchiveOp(request))

  def deleteVault(
    request: DeleteVaultRequest
  ): GlacierIO[DeleteVaultResponse] =
    FF.liftF(DeleteVaultOp(request))

  def deleteVaultAccessPolicy(
    request: DeleteVaultAccessPolicyRequest
  ): GlacierIO[DeleteVaultAccessPolicyResponse] =
    FF.liftF(DeleteVaultAccessPolicyOp(request))

  def deleteVaultNotifications(
    request: DeleteVaultNotificationsRequest
  ): GlacierIO[DeleteVaultNotificationsResponse] =
    FF.liftF(DeleteVaultNotificationsOp(request))

  def describeJob(
    request: DescribeJobRequest
  ): GlacierIO[DescribeJobResponse] =
    FF.liftF(DescribeJobOp(request))

  def describeVault(
    request: DescribeVaultRequest
  ): GlacierIO[DescribeVaultResponse] =
    FF.liftF(DescribeVaultOp(request))

  def getDataRetrievalPolicy(
    request: GetDataRetrievalPolicyRequest
  ): GlacierIO[GetDataRetrievalPolicyResponse] =
    FF.liftF(GetDataRetrievalPolicyOp(request))

  def getJobOutput(
    request: GetJobOutputRequest,
    path: Path
  ): GlacierIO[GetJobOutputResponse] =
    FF.liftF(GetJobOutputOp(request, path))

  def getVaultAccessPolicy(
    request: GetVaultAccessPolicyRequest
  ): GlacierIO[GetVaultAccessPolicyResponse] =
    FF.liftF(GetVaultAccessPolicyOp(request))

  def getVaultLock(
    request: GetVaultLockRequest
  ): GlacierIO[GetVaultLockResponse] =
    FF.liftF(GetVaultLockOp(request))

  def getVaultNotifications(
    request: GetVaultNotificationsRequest
  ): GlacierIO[GetVaultNotificationsResponse] =
    FF.liftF(GetVaultNotificationsOp(request))

  def initiateJob(
    request: InitiateJobRequest
  ): GlacierIO[InitiateJobResponse] =
    FF.liftF(InitiateJobOp(request))

  def initiateMultipartUpload(
    request: InitiateMultipartUploadRequest
  ): GlacierIO[InitiateMultipartUploadResponse] =
    FF.liftF(InitiateMultipartUploadOp(request))

  def initiateVaultLock(
    request: InitiateVaultLockRequest
  ): GlacierIO[InitiateVaultLockResponse] =
    FF.liftF(InitiateVaultLockOp(request))

  def listJobs(
    request: ListJobsRequest
  ): GlacierIO[ListJobsResponse] =
    FF.liftF(ListJobsOp(request))

  def listMultipartUploads(
    request: ListMultipartUploadsRequest
  ): GlacierIO[ListMultipartUploadsResponse] =
    FF.liftF(ListMultipartUploadsOp(request))

  def listParts(
    request: ListPartsRequest
  ): GlacierIO[ListPartsResponse] =
    FF.liftF(ListPartsOp(request))

  def listProvisionedCapacity(
    request: ListProvisionedCapacityRequest
  ): GlacierIO[ListProvisionedCapacityResponse] =
    FF.liftF(ListProvisionedCapacityOp(request))

  def listTagsForVault(
    request: ListTagsForVaultRequest
  ): GlacierIO[ListTagsForVaultResponse] =
    FF.liftF(ListTagsForVaultOp(request))

  def listVaults(
    request: ListVaultsRequest
  ): GlacierIO[ListVaultsResponse] =
    FF.liftF(ListVaultsOp(request))

  def purchaseProvisionedCapacity(
    request: PurchaseProvisionedCapacityRequest
  ): GlacierIO[PurchaseProvisionedCapacityResponse] =
    FF.liftF(PurchaseProvisionedCapacityOp(request))

  def removeTagsFromVault(
    request: RemoveTagsFromVaultRequest
  ): GlacierIO[RemoveTagsFromVaultResponse] =
    FF.liftF(RemoveTagsFromVaultOp(request))

  def setDataRetrievalPolicy(
    request: SetDataRetrievalPolicyRequest
  ): GlacierIO[SetDataRetrievalPolicyResponse] =
    FF.liftF(SetDataRetrievalPolicyOp(request))

  def setVaultAccessPolicy(
    request: SetVaultAccessPolicyRequest
  ): GlacierIO[SetVaultAccessPolicyResponse] =
    FF.liftF(SetVaultAccessPolicyOp(request))

  def setVaultNotifications(
    request: SetVaultNotificationsRequest
  ): GlacierIO[SetVaultNotificationsResponse] =
    FF.liftF(SetVaultNotificationsOp(request))

  def uploadArchive(
    request: UploadArchiveRequest,
    body: RequestBody
  ): GlacierIO[UploadArchiveResponse] =
    FF.liftF(UploadArchiveOp(request, body))

  def uploadMultipartPart(
    request: UploadMultipartPartRequest,
    body: RequestBody
  ): GlacierIO[UploadMultipartPartResponse] =
    FF.liftF(UploadMultipartPartOp(request, body))
}
