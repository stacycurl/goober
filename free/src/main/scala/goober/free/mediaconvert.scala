package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.mediaconvert.MediaConvertClient
import software.amazon.awssdk.services.mediaconvert.model._


object mediaconvert { module =>

  // Free monad over MediaConvertOp
  type MediaConvertIO[A] = FF[MediaConvertOp, A]

  sealed trait MediaConvertOp[A] {
    def visit[F[_]](visitor: MediaConvertOp.Visitor[F]): F[A]
  }

  object MediaConvertOp {
    // Given a MediaConvertClient we can embed a MediaConvertIO program in any algebra that understands embedding.
    implicit val MediaConvertOpEmbeddable: Embeddable[MediaConvertOp, MediaConvertClient] = new Embeddable[MediaConvertOp, MediaConvertClient] {
      def embed[A](client: MediaConvertClient, io: MediaConvertIO[A]): Embedded[A] = Embedded.MediaConvert(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MediaConvertOp.Visitor[Kleisli[M, MediaConvertClient, *]] {
        def associateCertificate(
          request: AssociateCertificateRequest
        ): Kleisli[M, MediaConvertClient, AssociateCertificateResponse] =
          primitive(_.associateCertificate(request))

        def cancelJob(
          request: CancelJobRequest
        ): Kleisli[M, MediaConvertClient, CancelJobResponse] =
          primitive(_.cancelJob(request))

        def createJob(
          request: CreateJobRequest
        ): Kleisli[M, MediaConvertClient, CreateJobResponse] =
          primitive(_.createJob(request))

        def createJobTemplate(
          request: CreateJobTemplateRequest
        ): Kleisli[M, MediaConvertClient, CreateJobTemplateResponse] =
          primitive(_.createJobTemplate(request))

        def createPreset(
          request: CreatePresetRequest
        ): Kleisli[M, MediaConvertClient, CreatePresetResponse] =
          primitive(_.createPreset(request))

        def createQueue(
          request: CreateQueueRequest
        ): Kleisli[M, MediaConvertClient, CreateQueueResponse] =
          primitive(_.createQueue(request))

        def deleteJobTemplate(
          request: DeleteJobTemplateRequest
        ): Kleisli[M, MediaConvertClient, DeleteJobTemplateResponse] =
          primitive(_.deleteJobTemplate(request))

        def deletePreset(
          request: DeletePresetRequest
        ): Kleisli[M, MediaConvertClient, DeletePresetResponse] =
          primitive(_.deletePreset(request))

        def deleteQueue(
          request: DeleteQueueRequest
        ): Kleisli[M, MediaConvertClient, DeleteQueueResponse] =
          primitive(_.deleteQueue(request))

        def describeEndpoints(
          request: DescribeEndpointsRequest
        ): Kleisli[M, MediaConvertClient, DescribeEndpointsResponse] =
          primitive(_.describeEndpoints(request))

        def disassociateCertificate(
          request: DisassociateCertificateRequest
        ): Kleisli[M, MediaConvertClient, DisassociateCertificateResponse] =
          primitive(_.disassociateCertificate(request))

        def getJob(
          request: GetJobRequest
        ): Kleisli[M, MediaConvertClient, GetJobResponse] =
          primitive(_.getJob(request))

        def getJobTemplate(
          request: GetJobTemplateRequest
        ): Kleisli[M, MediaConvertClient, GetJobTemplateResponse] =
          primitive(_.getJobTemplate(request))

        def getPreset(
          request: GetPresetRequest
        ): Kleisli[M, MediaConvertClient, GetPresetResponse] =
          primitive(_.getPreset(request))

        def getQueue(
          request: GetQueueRequest
        ): Kleisli[M, MediaConvertClient, GetQueueResponse] =
          primitive(_.getQueue(request))

        def listJobTemplates(
          request: ListJobTemplatesRequest
        ): Kleisli[M, MediaConvertClient, ListJobTemplatesResponse] =
          primitive(_.listJobTemplates(request))

        def listJobs(
          request: ListJobsRequest
        ): Kleisli[M, MediaConvertClient, ListJobsResponse] =
          primitive(_.listJobs(request))

        def listPresets(
          request: ListPresetsRequest
        ): Kleisli[M, MediaConvertClient, ListPresetsResponse] =
          primitive(_.listPresets(request))

        def listQueues(
          request: ListQueuesRequest
        ): Kleisli[M, MediaConvertClient, ListQueuesResponse] =
          primitive(_.listQueues(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, MediaConvertClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, MediaConvertClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, MediaConvertClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateJobTemplate(
          request: UpdateJobTemplateRequest
        ): Kleisli[M, MediaConvertClient, UpdateJobTemplateResponse] =
          primitive(_.updateJobTemplate(request))

        def updatePreset(
          request: UpdatePresetRequest
        ): Kleisli[M, MediaConvertClient, UpdatePresetResponse] =
          primitive(_.updatePreset(request))

        def updateQueue(
          request: UpdateQueueRequest
        ): Kleisli[M, MediaConvertClient, UpdateQueueResponse] =
          primitive(_.updateQueue(request))

        def primitive[A](
          f: MediaConvertClient => A
        ): Kleisli[M, MediaConvertClient, A]
      }
    }

    trait Visitor[F[_]] extends (MediaConvertOp ~> F) {
      final def apply[A](op: MediaConvertOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateCertificate(
        request: AssociateCertificateRequest
      ): F[AssociateCertificateResponse]

      def cancelJob(
        request: CancelJobRequest
      ): F[CancelJobResponse]

      def createJob(
        request: CreateJobRequest
      ): F[CreateJobResponse]

      def createJobTemplate(
        request: CreateJobTemplateRequest
      ): F[CreateJobTemplateResponse]

      def createPreset(
        request: CreatePresetRequest
      ): F[CreatePresetResponse]

      def createQueue(
        request: CreateQueueRequest
      ): F[CreateQueueResponse]

      def deleteJobTemplate(
        request: DeleteJobTemplateRequest
      ): F[DeleteJobTemplateResponse]

      def deletePreset(
        request: DeletePresetRequest
      ): F[DeletePresetResponse]

      def deleteQueue(
        request: DeleteQueueRequest
      ): F[DeleteQueueResponse]

      def describeEndpoints(
        request: DescribeEndpointsRequest
      ): F[DescribeEndpointsResponse]

      def disassociateCertificate(
        request: DisassociateCertificateRequest
      ): F[DisassociateCertificateResponse]

      def getJob(
        request: GetJobRequest
      ): F[GetJobResponse]

      def getJobTemplate(
        request: GetJobTemplateRequest
      ): F[GetJobTemplateResponse]

      def getPreset(
        request: GetPresetRequest
      ): F[GetPresetResponse]

      def getQueue(
        request: GetQueueRequest
      ): F[GetQueueResponse]

      def listJobTemplates(
        request: ListJobTemplatesRequest
      ): F[ListJobTemplatesResponse]

      def listJobs(
        request: ListJobsRequest
      ): F[ListJobsResponse]

      def listPresets(
        request: ListPresetsRequest
      ): F[ListPresetsResponse]

      def listQueues(
        request: ListQueuesRequest
      ): F[ListQueuesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateJobTemplate(
        request: UpdateJobTemplateRequest
      ): F[UpdateJobTemplateResponse]

      def updatePreset(
        request: UpdatePresetRequest
      ): F[UpdatePresetResponse]

      def updateQueue(
        request: UpdateQueueRequest
      ): F[UpdateQueueResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MediaConvertOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateCertificateOp(
      request: AssociateCertificateRequest
    ) extends MediaConvertOp[AssociateCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateCertificateResponse] =
        visitor.associateCertificate(request)
    }

    final case class CancelJobOp(
      request: CancelJobRequest
    ) extends MediaConvertOp[CancelJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelJobResponse] =
        visitor.cancelJob(request)
    }

    final case class CreateJobOp(
      request: CreateJobRequest
    ) extends MediaConvertOp[CreateJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateJobResponse] =
        visitor.createJob(request)
    }

    final case class CreateJobTemplateOp(
      request: CreateJobTemplateRequest
    ) extends MediaConvertOp[CreateJobTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateJobTemplateResponse] =
        visitor.createJobTemplate(request)
    }

    final case class CreatePresetOp(
      request: CreatePresetRequest
    ) extends MediaConvertOp[CreatePresetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePresetResponse] =
        visitor.createPreset(request)
    }

    final case class CreateQueueOp(
      request: CreateQueueRequest
    ) extends MediaConvertOp[CreateQueueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateQueueResponse] =
        visitor.createQueue(request)
    }

    final case class DeleteJobTemplateOp(
      request: DeleteJobTemplateRequest
    ) extends MediaConvertOp[DeleteJobTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteJobTemplateResponse] =
        visitor.deleteJobTemplate(request)
    }

    final case class DeletePresetOp(
      request: DeletePresetRequest
    ) extends MediaConvertOp[DeletePresetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePresetResponse] =
        visitor.deletePreset(request)
    }

    final case class DeleteQueueOp(
      request: DeleteQueueRequest
    ) extends MediaConvertOp[DeleteQueueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteQueueResponse] =
        visitor.deleteQueue(request)
    }

    final case class DescribeEndpointsOp(
      request: DescribeEndpointsRequest
    ) extends MediaConvertOp[DescribeEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEndpointsResponse] =
        visitor.describeEndpoints(request)
    }

    final case class DisassociateCertificateOp(
      request: DisassociateCertificateRequest
    ) extends MediaConvertOp[DisassociateCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateCertificateResponse] =
        visitor.disassociateCertificate(request)
    }

    final case class GetJobOp(
      request: GetJobRequest
    ) extends MediaConvertOp[GetJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJobResponse] =
        visitor.getJob(request)
    }

    final case class GetJobTemplateOp(
      request: GetJobTemplateRequest
    ) extends MediaConvertOp[GetJobTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJobTemplateResponse] =
        visitor.getJobTemplate(request)
    }

    final case class GetPresetOp(
      request: GetPresetRequest
    ) extends MediaConvertOp[GetPresetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPresetResponse] =
        visitor.getPreset(request)
    }

    final case class GetQueueOp(
      request: GetQueueRequest
    ) extends MediaConvertOp[GetQueueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetQueueResponse] =
        visitor.getQueue(request)
    }

    final case class ListJobTemplatesOp(
      request: ListJobTemplatesRequest
    ) extends MediaConvertOp[ListJobTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJobTemplatesResponse] =
        visitor.listJobTemplates(request)
    }

    final case class ListJobsOp(
      request: ListJobsRequest
    ) extends MediaConvertOp[ListJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJobsResponse] =
        visitor.listJobs(request)
    }

    final case class ListPresetsOp(
      request: ListPresetsRequest
    ) extends MediaConvertOp[ListPresetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPresetsResponse] =
        visitor.listPresets(request)
    }

    final case class ListQueuesOp(
      request: ListQueuesRequest
    ) extends MediaConvertOp[ListQueuesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListQueuesResponse] =
        visitor.listQueues(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends MediaConvertOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends MediaConvertOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends MediaConvertOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateJobTemplateOp(
      request: UpdateJobTemplateRequest
    ) extends MediaConvertOp[UpdateJobTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateJobTemplateResponse] =
        visitor.updateJobTemplate(request)
    }

    final case class UpdatePresetOp(
      request: UpdatePresetRequest
    ) extends MediaConvertOp[UpdatePresetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePresetResponse] =
        visitor.updatePreset(request)
    }

    final case class UpdateQueueOp(
      request: UpdateQueueRequest
    ) extends MediaConvertOp[UpdateQueueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateQueueResponse] =
        visitor.updateQueue(request)
    }
  }

  import MediaConvertOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MediaConvertOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateCertificate(
    request: AssociateCertificateRequest
  ): MediaConvertIO[AssociateCertificateResponse] =
    FF.liftF(AssociateCertificateOp(request))

  def cancelJob(
    request: CancelJobRequest
  ): MediaConvertIO[CancelJobResponse] =
    FF.liftF(CancelJobOp(request))

  def createJob(
    request: CreateJobRequest
  ): MediaConvertIO[CreateJobResponse] =
    FF.liftF(CreateJobOp(request))

  def createJobTemplate(
    request: CreateJobTemplateRequest
  ): MediaConvertIO[CreateJobTemplateResponse] =
    FF.liftF(CreateJobTemplateOp(request))

  def createPreset(
    request: CreatePresetRequest
  ): MediaConvertIO[CreatePresetResponse] =
    FF.liftF(CreatePresetOp(request))

  def createQueue(
    request: CreateQueueRequest
  ): MediaConvertIO[CreateQueueResponse] =
    FF.liftF(CreateQueueOp(request))

  def deleteJobTemplate(
    request: DeleteJobTemplateRequest
  ): MediaConvertIO[DeleteJobTemplateResponse] =
    FF.liftF(DeleteJobTemplateOp(request))

  def deletePreset(
    request: DeletePresetRequest
  ): MediaConvertIO[DeletePresetResponse] =
    FF.liftF(DeletePresetOp(request))

  def deleteQueue(
    request: DeleteQueueRequest
  ): MediaConvertIO[DeleteQueueResponse] =
    FF.liftF(DeleteQueueOp(request))

  def describeEndpoints(
    request: DescribeEndpointsRequest
  ): MediaConvertIO[DescribeEndpointsResponse] =
    FF.liftF(DescribeEndpointsOp(request))

  def disassociateCertificate(
    request: DisassociateCertificateRequest
  ): MediaConvertIO[DisassociateCertificateResponse] =
    FF.liftF(DisassociateCertificateOp(request))

  def getJob(
    request: GetJobRequest
  ): MediaConvertIO[GetJobResponse] =
    FF.liftF(GetJobOp(request))

  def getJobTemplate(
    request: GetJobTemplateRequest
  ): MediaConvertIO[GetJobTemplateResponse] =
    FF.liftF(GetJobTemplateOp(request))

  def getPreset(
    request: GetPresetRequest
  ): MediaConvertIO[GetPresetResponse] =
    FF.liftF(GetPresetOp(request))

  def getQueue(
    request: GetQueueRequest
  ): MediaConvertIO[GetQueueResponse] =
    FF.liftF(GetQueueOp(request))

  def listJobTemplates(
    request: ListJobTemplatesRequest
  ): MediaConvertIO[ListJobTemplatesResponse] =
    FF.liftF(ListJobTemplatesOp(request))

  def listJobs(
    request: ListJobsRequest
  ): MediaConvertIO[ListJobsResponse] =
    FF.liftF(ListJobsOp(request))

  def listPresets(
    request: ListPresetsRequest
  ): MediaConvertIO[ListPresetsResponse] =
    FF.liftF(ListPresetsOp(request))

  def listQueues(
    request: ListQueuesRequest
  ): MediaConvertIO[ListQueuesResponse] =
    FF.liftF(ListQueuesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): MediaConvertIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): MediaConvertIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): MediaConvertIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateJobTemplate(
    request: UpdateJobTemplateRequest
  ): MediaConvertIO[UpdateJobTemplateResponse] =
    FF.liftF(UpdateJobTemplateOp(request))

  def updatePreset(
    request: UpdatePresetRequest
  ): MediaConvertIO[UpdatePresetResponse] =
    FF.liftF(UpdatePresetOp(request))

  def updateQueue(
    request: UpdateQueueRequest
  ): MediaConvertIO[UpdateQueueResponse] =
    FF.liftF(UpdateQueueOp(request))
}
