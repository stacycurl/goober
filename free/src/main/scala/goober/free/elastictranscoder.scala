package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.elastictranscoder.ElasticTranscoderClient
import software.amazon.awssdk.services.elastictranscoder.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object elastictranscoder { module =>

  // Free monad over ElasticTranscoderOp
  type ElasticTranscoderIO[A] = FF[ElasticTranscoderOp, A]

  sealed trait ElasticTranscoderOp[A] {
    def visit[F[_]](visitor: ElasticTranscoderOp.Visitor[F]): F[A]
  }

  object ElasticTranscoderOp {
    // Given a ElasticTranscoderClient we can embed a ElasticTranscoderIO program in any algebra that understands embedding.
    implicit val ElasticTranscoderOpEmbeddable: Embeddable[ElasticTranscoderOp, ElasticTranscoderClient] = new Embeddable[ElasticTranscoderOp, ElasticTranscoderClient] {
      def embed[A](client: ElasticTranscoderClient, io: ElasticTranscoderIO[A]): Embedded[A] = Embedded.ElasticTranscoder(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ElasticTranscoderOp.Visitor[Kleisli[M, ElasticTranscoderClient, *]] {
        def cancelJob(
          request: CancelJobRequest
        ): Kleisli[M, ElasticTranscoderClient, CancelJobResponse] =
          primitive(_.cancelJob(request))

        def createJob(
          request: CreateJobRequest
        ): Kleisli[M, ElasticTranscoderClient, CreateJobResponse] =
          primitive(_.createJob(request))

        def createPipeline(
          request: CreatePipelineRequest
        ): Kleisli[M, ElasticTranscoderClient, CreatePipelineResponse] =
          primitive(_.createPipeline(request))

        def createPreset(
          request: CreatePresetRequest
        ): Kleisli[M, ElasticTranscoderClient, CreatePresetResponse] =
          primitive(_.createPreset(request))

        def deletePipeline(
          request: DeletePipelineRequest
        ): Kleisli[M, ElasticTranscoderClient, DeletePipelineResponse] =
          primitive(_.deletePipeline(request))

        def deletePreset(
          request: DeletePresetRequest
        ): Kleisli[M, ElasticTranscoderClient, DeletePresetResponse] =
          primitive(_.deletePreset(request))

        def listJobsByPipeline(
          request: ListJobsByPipelineRequest
        ): Kleisli[M, ElasticTranscoderClient, ListJobsByPipelineResponse] =
          primitive(_.listJobsByPipeline(request))

        def listJobsByStatus(
          request: ListJobsByStatusRequest
        ): Kleisli[M, ElasticTranscoderClient, ListJobsByStatusResponse] =
          primitive(_.listJobsByStatus(request))

        def listPipelines(
          request: ListPipelinesRequest
        ): Kleisli[M, ElasticTranscoderClient, ListPipelinesResponse] =
          primitive(_.listPipelines(request))

        def listPresets(
          request: ListPresetsRequest
        ): Kleisli[M, ElasticTranscoderClient, ListPresetsResponse] =
          primitive(_.listPresets(request))

        def readJob(
          request: ReadJobRequest
        ): Kleisli[M, ElasticTranscoderClient, ReadJobResponse] =
          primitive(_.readJob(request))

        def readPipeline(
          request: ReadPipelineRequest
        ): Kleisli[M, ElasticTranscoderClient, ReadPipelineResponse] =
          primitive(_.readPipeline(request))

        def readPreset(
          request: ReadPresetRequest
        ): Kleisli[M, ElasticTranscoderClient, ReadPresetResponse] =
          primitive(_.readPreset(request))

        def updatePipeline(
          request: UpdatePipelineRequest
        ): Kleisli[M, ElasticTranscoderClient, UpdatePipelineResponse] =
          primitive(_.updatePipeline(request))

        def updatePipelineNotifications(
          request: UpdatePipelineNotificationsRequest
        ): Kleisli[M, ElasticTranscoderClient, UpdatePipelineNotificationsResponse] =
          primitive(_.updatePipelineNotifications(request))

        def updatePipelineStatus(
          request: UpdatePipelineStatusRequest
        ): Kleisli[M, ElasticTranscoderClient, UpdatePipelineStatusResponse] =
          primitive(_.updatePipelineStatus(request))

        def primitive[A](
          f: ElasticTranscoderClient => A
        ): Kleisli[M, ElasticTranscoderClient, A]
      }
    }

    trait Visitor[F[_]] extends (ElasticTranscoderOp ~> F) {
      final def apply[A](op: ElasticTranscoderOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def cancelJob(
        request: CancelJobRequest
      ): F[CancelJobResponse]

      def createJob(
        request: CreateJobRequest
      ): F[CreateJobResponse]

      def createPipeline(
        request: CreatePipelineRequest
      ): F[CreatePipelineResponse]

      def createPreset(
        request: CreatePresetRequest
      ): F[CreatePresetResponse]

      def deletePipeline(
        request: DeletePipelineRequest
      ): F[DeletePipelineResponse]

      def deletePreset(
        request: DeletePresetRequest
      ): F[DeletePresetResponse]

      def listJobsByPipeline(
        request: ListJobsByPipelineRequest
      ): F[ListJobsByPipelineResponse]

      def listJobsByStatus(
        request: ListJobsByStatusRequest
      ): F[ListJobsByStatusResponse]

      def listPipelines(
        request: ListPipelinesRequest
      ): F[ListPipelinesResponse]

      def listPresets(
        request: ListPresetsRequest
      ): F[ListPresetsResponse]

      def readJob(
        request: ReadJobRequest
      ): F[ReadJobResponse]

      def readPipeline(
        request: ReadPipelineRequest
      ): F[ReadPipelineResponse]

      def readPreset(
        request: ReadPresetRequest
      ): F[ReadPresetResponse]

      def updatePipeline(
        request: UpdatePipelineRequest
      ): F[UpdatePipelineResponse]

      def updatePipelineNotifications(
        request: UpdatePipelineNotificationsRequest
      ): F[UpdatePipelineNotificationsResponse]

      def updatePipelineStatus(
        request: UpdatePipelineStatusRequest
      ): F[UpdatePipelineStatusResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ElasticTranscoderOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CancelJobOp(
      request: CancelJobRequest
    ) extends ElasticTranscoderOp[CancelJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelJobResponse] =
        visitor.cancelJob(request)
    }

    final case class CreateJobOp(
      request: CreateJobRequest
    ) extends ElasticTranscoderOp[CreateJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateJobResponse] =
        visitor.createJob(request)
    }

    final case class CreatePipelineOp(
      request: CreatePipelineRequest
    ) extends ElasticTranscoderOp[CreatePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePipelineResponse] =
        visitor.createPipeline(request)
    }

    final case class CreatePresetOp(
      request: CreatePresetRequest
    ) extends ElasticTranscoderOp[CreatePresetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePresetResponse] =
        visitor.createPreset(request)
    }

    final case class DeletePipelineOp(
      request: DeletePipelineRequest
    ) extends ElasticTranscoderOp[DeletePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePipelineResponse] =
        visitor.deletePipeline(request)
    }

    final case class DeletePresetOp(
      request: DeletePresetRequest
    ) extends ElasticTranscoderOp[DeletePresetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePresetResponse] =
        visitor.deletePreset(request)
    }

    final case class ListJobsByPipelineOp(
      request: ListJobsByPipelineRequest
    ) extends ElasticTranscoderOp[ListJobsByPipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJobsByPipelineResponse] =
        visitor.listJobsByPipeline(request)
    }

    final case class ListJobsByStatusOp(
      request: ListJobsByStatusRequest
    ) extends ElasticTranscoderOp[ListJobsByStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJobsByStatusResponse] =
        visitor.listJobsByStatus(request)
    }

    final case class ListPipelinesOp(
      request: ListPipelinesRequest
    ) extends ElasticTranscoderOp[ListPipelinesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPipelinesResponse] =
        visitor.listPipelines(request)
    }

    final case class ListPresetsOp(
      request: ListPresetsRequest
    ) extends ElasticTranscoderOp[ListPresetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPresetsResponse] =
        visitor.listPresets(request)
    }

    final case class ReadJobOp(
      request: ReadJobRequest
    ) extends ElasticTranscoderOp[ReadJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReadJobResponse] =
        visitor.readJob(request)
    }

    final case class ReadPipelineOp(
      request: ReadPipelineRequest
    ) extends ElasticTranscoderOp[ReadPipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReadPipelineResponse] =
        visitor.readPipeline(request)
    }

    final case class ReadPresetOp(
      request: ReadPresetRequest
    ) extends ElasticTranscoderOp[ReadPresetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReadPresetResponse] =
        visitor.readPreset(request)
    }

    final case class UpdatePipelineOp(
      request: UpdatePipelineRequest
    ) extends ElasticTranscoderOp[UpdatePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePipelineResponse] =
        visitor.updatePipeline(request)
    }

    final case class UpdatePipelineNotificationsOp(
      request: UpdatePipelineNotificationsRequest
    ) extends ElasticTranscoderOp[UpdatePipelineNotificationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePipelineNotificationsResponse] =
        visitor.updatePipelineNotifications(request)
    }

    final case class UpdatePipelineStatusOp(
      request: UpdatePipelineStatusRequest
    ) extends ElasticTranscoderOp[UpdatePipelineStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePipelineStatusResponse] =
        visitor.updatePipelineStatus(request)
    }
  }

  import ElasticTranscoderOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ElasticTranscoderOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def cancelJob(
    request: CancelJobRequest
  ): ElasticTranscoderIO[CancelJobResponse] =
    FF.liftF(CancelJobOp(request))

  def createJob(
    request: CreateJobRequest
  ): ElasticTranscoderIO[CreateJobResponse] =
    FF.liftF(CreateJobOp(request))

  def createPipeline(
    request: CreatePipelineRequest
  ): ElasticTranscoderIO[CreatePipelineResponse] =
    FF.liftF(CreatePipelineOp(request))

  def createPreset(
    request: CreatePresetRequest
  ): ElasticTranscoderIO[CreatePresetResponse] =
    FF.liftF(CreatePresetOp(request))

  def deletePipeline(
    request: DeletePipelineRequest
  ): ElasticTranscoderIO[DeletePipelineResponse] =
    FF.liftF(DeletePipelineOp(request))

  def deletePreset(
    request: DeletePresetRequest
  ): ElasticTranscoderIO[DeletePresetResponse] =
    FF.liftF(DeletePresetOp(request))

  def listJobsByPipeline(
    request: ListJobsByPipelineRequest
  ): ElasticTranscoderIO[ListJobsByPipelineResponse] =
    FF.liftF(ListJobsByPipelineOp(request))

  def listJobsByStatus(
    request: ListJobsByStatusRequest
  ): ElasticTranscoderIO[ListJobsByStatusResponse] =
    FF.liftF(ListJobsByStatusOp(request))

  def listPipelines(
    request: ListPipelinesRequest
  ): ElasticTranscoderIO[ListPipelinesResponse] =
    FF.liftF(ListPipelinesOp(request))

  def listPresets(
    request: ListPresetsRequest
  ): ElasticTranscoderIO[ListPresetsResponse] =
    FF.liftF(ListPresetsOp(request))

  def readJob(
    request: ReadJobRequest
  ): ElasticTranscoderIO[ReadJobResponse] =
    FF.liftF(ReadJobOp(request))

  def readPipeline(
    request: ReadPipelineRequest
  ): ElasticTranscoderIO[ReadPipelineResponse] =
    FF.liftF(ReadPipelineOp(request))

  def readPreset(
    request: ReadPresetRequest
  ): ElasticTranscoderIO[ReadPresetResponse] =
    FF.liftF(ReadPresetOp(request))

  def updatePipeline(
    request: UpdatePipelineRequest
  ): ElasticTranscoderIO[UpdatePipelineResponse] =
    FF.liftF(UpdatePipelineOp(request))

  def updatePipelineNotifications(
    request: UpdatePipelineNotificationsRequest
  ): ElasticTranscoderIO[UpdatePipelineNotificationsResponse] =
    FF.liftF(UpdatePipelineNotificationsOp(request))

  def updatePipelineStatus(
    request: UpdatePipelineStatusRequest
  ): ElasticTranscoderIO[UpdatePipelineStatusResponse] =
    FF.liftF(UpdatePipelineStatusOp(request))
}
