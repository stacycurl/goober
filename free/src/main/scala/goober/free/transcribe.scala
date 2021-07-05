package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.transcribe.TranscribeClient
import software.amazon.awssdk.services.transcribe.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object transcribe { module =>

  // Free monad over TranscribeOp
  type TranscribeIO[A] = FF[TranscribeOp, A]

  sealed trait TranscribeOp[A] {
    def visit[F[_]](visitor: TranscribeOp.Visitor[F]): F[A]
  }

  object TranscribeOp {
    // Given a TranscribeClient we can embed a TranscribeIO program in any algebra that understands embedding.
    implicit val TranscribeOpEmbeddable: Embeddable[TranscribeOp, TranscribeClient] = new Embeddable[TranscribeOp, TranscribeClient] {
      def embed[A](client: TranscribeClient, io: TranscribeIO[A]): Embedded[A] = Embedded.Transcribe(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends TranscribeOp.Visitor[Kleisli[M, TranscribeClient, *]] {
        def createLanguageModel(
          request: CreateLanguageModelRequest
        ): Kleisli[M, TranscribeClient, CreateLanguageModelResponse] =
          primitive(_.createLanguageModel(request))

        def createMedicalVocabulary(
          request: CreateMedicalVocabularyRequest
        ): Kleisli[M, TranscribeClient, CreateMedicalVocabularyResponse] =
          primitive(_.createMedicalVocabulary(request))

        def createVocabulary(
          request: CreateVocabularyRequest
        ): Kleisli[M, TranscribeClient, CreateVocabularyResponse] =
          primitive(_.createVocabulary(request))

        def createVocabularyFilter(
          request: CreateVocabularyFilterRequest
        ): Kleisli[M, TranscribeClient, CreateVocabularyFilterResponse] =
          primitive(_.createVocabularyFilter(request))

        def deleteLanguageModel(
          request: DeleteLanguageModelRequest
        ): Kleisli[M, TranscribeClient, DeleteLanguageModelResponse] =
          primitive(_.deleteLanguageModel(request))

        def deleteMedicalTranscriptionJob(
          request: DeleteMedicalTranscriptionJobRequest
        ): Kleisli[M, TranscribeClient, DeleteMedicalTranscriptionJobResponse] =
          primitive(_.deleteMedicalTranscriptionJob(request))

        def deleteMedicalVocabulary(
          request: DeleteMedicalVocabularyRequest
        ): Kleisli[M, TranscribeClient, DeleteMedicalVocabularyResponse] =
          primitive(_.deleteMedicalVocabulary(request))

        def deleteTranscriptionJob(
          request: DeleteTranscriptionJobRequest
        ): Kleisli[M, TranscribeClient, DeleteTranscriptionJobResponse] =
          primitive(_.deleteTranscriptionJob(request))

        def deleteVocabulary(
          request: DeleteVocabularyRequest
        ): Kleisli[M, TranscribeClient, DeleteVocabularyResponse] =
          primitive(_.deleteVocabulary(request))

        def deleteVocabularyFilter(
          request: DeleteVocabularyFilterRequest
        ): Kleisli[M, TranscribeClient, DeleteVocabularyFilterResponse] =
          primitive(_.deleteVocabularyFilter(request))

        def describeLanguageModel(
          request: DescribeLanguageModelRequest
        ): Kleisli[M, TranscribeClient, DescribeLanguageModelResponse] =
          primitive(_.describeLanguageModel(request))

        def getMedicalTranscriptionJob(
          request: GetMedicalTranscriptionJobRequest
        ): Kleisli[M, TranscribeClient, GetMedicalTranscriptionJobResponse] =
          primitive(_.getMedicalTranscriptionJob(request))

        def getMedicalVocabulary(
          request: GetMedicalVocabularyRequest
        ): Kleisli[M, TranscribeClient, GetMedicalVocabularyResponse] =
          primitive(_.getMedicalVocabulary(request))

        def getTranscriptionJob(
          request: GetTranscriptionJobRequest
        ): Kleisli[M, TranscribeClient, GetTranscriptionJobResponse] =
          primitive(_.getTranscriptionJob(request))

        def getVocabulary(
          request: GetVocabularyRequest
        ): Kleisli[M, TranscribeClient, GetVocabularyResponse] =
          primitive(_.getVocabulary(request))

        def getVocabularyFilter(
          request: GetVocabularyFilterRequest
        ): Kleisli[M, TranscribeClient, GetVocabularyFilterResponse] =
          primitive(_.getVocabularyFilter(request))

        def listLanguageModels(
          request: ListLanguageModelsRequest
        ): Kleisli[M, TranscribeClient, ListLanguageModelsResponse] =
          primitive(_.listLanguageModels(request))

        def listMedicalTranscriptionJobs(
          request: ListMedicalTranscriptionJobsRequest
        ): Kleisli[M, TranscribeClient, ListMedicalTranscriptionJobsResponse] =
          primitive(_.listMedicalTranscriptionJobs(request))

        def listMedicalVocabularies(
          request: ListMedicalVocabulariesRequest
        ): Kleisli[M, TranscribeClient, ListMedicalVocabulariesResponse] =
          primitive(_.listMedicalVocabularies(request))

        def listTranscriptionJobs(
          request: ListTranscriptionJobsRequest
        ): Kleisli[M, TranscribeClient, ListTranscriptionJobsResponse] =
          primitive(_.listTranscriptionJobs(request))

        def listVocabularies(
          request: ListVocabulariesRequest
        ): Kleisli[M, TranscribeClient, ListVocabulariesResponse] =
          primitive(_.listVocabularies(request))

        def listVocabularyFilters(
          request: ListVocabularyFiltersRequest
        ): Kleisli[M, TranscribeClient, ListVocabularyFiltersResponse] =
          primitive(_.listVocabularyFilters(request))

        def startMedicalTranscriptionJob(
          request: StartMedicalTranscriptionJobRequest
        ): Kleisli[M, TranscribeClient, StartMedicalTranscriptionJobResponse] =
          primitive(_.startMedicalTranscriptionJob(request))

        def startTranscriptionJob(
          request: StartTranscriptionJobRequest
        ): Kleisli[M, TranscribeClient, StartTranscriptionJobResponse] =
          primitive(_.startTranscriptionJob(request))

        def updateMedicalVocabulary(
          request: UpdateMedicalVocabularyRequest
        ): Kleisli[M, TranscribeClient, UpdateMedicalVocabularyResponse] =
          primitive(_.updateMedicalVocabulary(request))

        def updateVocabulary(
          request: UpdateVocabularyRequest
        ): Kleisli[M, TranscribeClient, UpdateVocabularyResponse] =
          primitive(_.updateVocabulary(request))

        def updateVocabularyFilter(
          request: UpdateVocabularyFilterRequest
        ): Kleisli[M, TranscribeClient, UpdateVocabularyFilterResponse] =
          primitive(_.updateVocabularyFilter(request))

        def primitive[A](
          f: TranscribeClient => A
        ): Kleisli[M, TranscribeClient, A]
      }
    }

    trait Visitor[F[_]] extends (TranscribeOp ~> F) {
      final def apply[A](op: TranscribeOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createLanguageModel(
        request: CreateLanguageModelRequest
      ): F[CreateLanguageModelResponse]

      def createMedicalVocabulary(
        request: CreateMedicalVocabularyRequest
      ): F[CreateMedicalVocabularyResponse]

      def createVocabulary(
        request: CreateVocabularyRequest
      ): F[CreateVocabularyResponse]

      def createVocabularyFilter(
        request: CreateVocabularyFilterRequest
      ): F[CreateVocabularyFilterResponse]

      def deleteLanguageModel(
        request: DeleteLanguageModelRequest
      ): F[DeleteLanguageModelResponse]

      def deleteMedicalTranscriptionJob(
        request: DeleteMedicalTranscriptionJobRequest
      ): F[DeleteMedicalTranscriptionJobResponse]

      def deleteMedicalVocabulary(
        request: DeleteMedicalVocabularyRequest
      ): F[DeleteMedicalVocabularyResponse]

      def deleteTranscriptionJob(
        request: DeleteTranscriptionJobRequest
      ): F[DeleteTranscriptionJobResponse]

      def deleteVocabulary(
        request: DeleteVocabularyRequest
      ): F[DeleteVocabularyResponse]

      def deleteVocabularyFilter(
        request: DeleteVocabularyFilterRequest
      ): F[DeleteVocabularyFilterResponse]

      def describeLanguageModel(
        request: DescribeLanguageModelRequest
      ): F[DescribeLanguageModelResponse]

      def getMedicalTranscriptionJob(
        request: GetMedicalTranscriptionJobRequest
      ): F[GetMedicalTranscriptionJobResponse]

      def getMedicalVocabulary(
        request: GetMedicalVocabularyRequest
      ): F[GetMedicalVocabularyResponse]

      def getTranscriptionJob(
        request: GetTranscriptionJobRequest
      ): F[GetTranscriptionJobResponse]

      def getVocabulary(
        request: GetVocabularyRequest
      ): F[GetVocabularyResponse]

      def getVocabularyFilter(
        request: GetVocabularyFilterRequest
      ): F[GetVocabularyFilterResponse]

      def listLanguageModels(
        request: ListLanguageModelsRequest
      ): F[ListLanguageModelsResponse]

      def listMedicalTranscriptionJobs(
        request: ListMedicalTranscriptionJobsRequest
      ): F[ListMedicalTranscriptionJobsResponse]

      def listMedicalVocabularies(
        request: ListMedicalVocabulariesRequest
      ): F[ListMedicalVocabulariesResponse]

      def listTranscriptionJobs(
        request: ListTranscriptionJobsRequest
      ): F[ListTranscriptionJobsResponse]

      def listVocabularies(
        request: ListVocabulariesRequest
      ): F[ListVocabulariesResponse]

      def listVocabularyFilters(
        request: ListVocabularyFiltersRequest
      ): F[ListVocabularyFiltersResponse]

      def startMedicalTranscriptionJob(
        request: StartMedicalTranscriptionJobRequest
      ): F[StartMedicalTranscriptionJobResponse]

      def startTranscriptionJob(
        request: StartTranscriptionJobRequest
      ): F[StartTranscriptionJobResponse]

      def updateMedicalVocabulary(
        request: UpdateMedicalVocabularyRequest
      ): F[UpdateMedicalVocabularyResponse]

      def updateVocabulary(
        request: UpdateVocabularyRequest
      ): F[UpdateVocabularyResponse]

      def updateVocabularyFilter(
        request: UpdateVocabularyFilterRequest
      ): F[UpdateVocabularyFilterResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends TranscribeOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateLanguageModelOp(
      request: CreateLanguageModelRequest
    ) extends TranscribeOp[CreateLanguageModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLanguageModelResponse] =
        visitor.createLanguageModel(request)
    }

    final case class CreateMedicalVocabularyOp(
      request: CreateMedicalVocabularyRequest
    ) extends TranscribeOp[CreateMedicalVocabularyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMedicalVocabularyResponse] =
        visitor.createMedicalVocabulary(request)
    }

    final case class CreateVocabularyOp(
      request: CreateVocabularyRequest
    ) extends TranscribeOp[CreateVocabularyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVocabularyResponse] =
        visitor.createVocabulary(request)
    }

    final case class CreateVocabularyFilterOp(
      request: CreateVocabularyFilterRequest
    ) extends TranscribeOp[CreateVocabularyFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVocabularyFilterResponse] =
        visitor.createVocabularyFilter(request)
    }

    final case class DeleteLanguageModelOp(
      request: DeleteLanguageModelRequest
    ) extends TranscribeOp[DeleteLanguageModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLanguageModelResponse] =
        visitor.deleteLanguageModel(request)
    }

    final case class DeleteMedicalTranscriptionJobOp(
      request: DeleteMedicalTranscriptionJobRequest
    ) extends TranscribeOp[DeleteMedicalTranscriptionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMedicalTranscriptionJobResponse] =
        visitor.deleteMedicalTranscriptionJob(request)
    }

    final case class DeleteMedicalVocabularyOp(
      request: DeleteMedicalVocabularyRequest
    ) extends TranscribeOp[DeleteMedicalVocabularyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMedicalVocabularyResponse] =
        visitor.deleteMedicalVocabulary(request)
    }

    final case class DeleteTranscriptionJobOp(
      request: DeleteTranscriptionJobRequest
    ) extends TranscribeOp[DeleteTranscriptionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTranscriptionJobResponse] =
        visitor.deleteTranscriptionJob(request)
    }

    final case class DeleteVocabularyOp(
      request: DeleteVocabularyRequest
    ) extends TranscribeOp[DeleteVocabularyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVocabularyResponse] =
        visitor.deleteVocabulary(request)
    }

    final case class DeleteVocabularyFilterOp(
      request: DeleteVocabularyFilterRequest
    ) extends TranscribeOp[DeleteVocabularyFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVocabularyFilterResponse] =
        visitor.deleteVocabularyFilter(request)
    }

    final case class DescribeLanguageModelOp(
      request: DescribeLanguageModelRequest
    ) extends TranscribeOp[DescribeLanguageModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLanguageModelResponse] =
        visitor.describeLanguageModel(request)
    }

    final case class GetMedicalTranscriptionJobOp(
      request: GetMedicalTranscriptionJobRequest
    ) extends TranscribeOp[GetMedicalTranscriptionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMedicalTranscriptionJobResponse] =
        visitor.getMedicalTranscriptionJob(request)
    }

    final case class GetMedicalVocabularyOp(
      request: GetMedicalVocabularyRequest
    ) extends TranscribeOp[GetMedicalVocabularyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMedicalVocabularyResponse] =
        visitor.getMedicalVocabulary(request)
    }

    final case class GetTranscriptionJobOp(
      request: GetTranscriptionJobRequest
    ) extends TranscribeOp[GetTranscriptionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTranscriptionJobResponse] =
        visitor.getTranscriptionJob(request)
    }

    final case class GetVocabularyOp(
      request: GetVocabularyRequest
    ) extends TranscribeOp[GetVocabularyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVocabularyResponse] =
        visitor.getVocabulary(request)
    }

    final case class GetVocabularyFilterOp(
      request: GetVocabularyFilterRequest
    ) extends TranscribeOp[GetVocabularyFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVocabularyFilterResponse] =
        visitor.getVocabularyFilter(request)
    }

    final case class ListLanguageModelsOp(
      request: ListLanguageModelsRequest
    ) extends TranscribeOp[ListLanguageModelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLanguageModelsResponse] =
        visitor.listLanguageModels(request)
    }

    final case class ListMedicalTranscriptionJobsOp(
      request: ListMedicalTranscriptionJobsRequest
    ) extends TranscribeOp[ListMedicalTranscriptionJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMedicalTranscriptionJobsResponse] =
        visitor.listMedicalTranscriptionJobs(request)
    }

    final case class ListMedicalVocabulariesOp(
      request: ListMedicalVocabulariesRequest
    ) extends TranscribeOp[ListMedicalVocabulariesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMedicalVocabulariesResponse] =
        visitor.listMedicalVocabularies(request)
    }

    final case class ListTranscriptionJobsOp(
      request: ListTranscriptionJobsRequest
    ) extends TranscribeOp[ListTranscriptionJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTranscriptionJobsResponse] =
        visitor.listTranscriptionJobs(request)
    }

    final case class ListVocabulariesOp(
      request: ListVocabulariesRequest
    ) extends TranscribeOp[ListVocabulariesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVocabulariesResponse] =
        visitor.listVocabularies(request)
    }

    final case class ListVocabularyFiltersOp(
      request: ListVocabularyFiltersRequest
    ) extends TranscribeOp[ListVocabularyFiltersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVocabularyFiltersResponse] =
        visitor.listVocabularyFilters(request)
    }

    final case class StartMedicalTranscriptionJobOp(
      request: StartMedicalTranscriptionJobRequest
    ) extends TranscribeOp[StartMedicalTranscriptionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartMedicalTranscriptionJobResponse] =
        visitor.startMedicalTranscriptionJob(request)
    }

    final case class StartTranscriptionJobOp(
      request: StartTranscriptionJobRequest
    ) extends TranscribeOp[StartTranscriptionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartTranscriptionJobResponse] =
        visitor.startTranscriptionJob(request)
    }

    final case class UpdateMedicalVocabularyOp(
      request: UpdateMedicalVocabularyRequest
    ) extends TranscribeOp[UpdateMedicalVocabularyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMedicalVocabularyResponse] =
        visitor.updateMedicalVocabulary(request)
    }

    final case class UpdateVocabularyOp(
      request: UpdateVocabularyRequest
    ) extends TranscribeOp[UpdateVocabularyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateVocabularyResponse] =
        visitor.updateVocabulary(request)
    }

    final case class UpdateVocabularyFilterOp(
      request: UpdateVocabularyFilterRequest
    ) extends TranscribeOp[UpdateVocabularyFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateVocabularyFilterResponse] =
        visitor.updateVocabularyFilter(request)
    }
  }

  import TranscribeOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[TranscribeOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createLanguageModel(
    request: CreateLanguageModelRequest
  ): TranscribeIO[CreateLanguageModelResponse] =
    FF.liftF(CreateLanguageModelOp(request))

  def createMedicalVocabulary(
    request: CreateMedicalVocabularyRequest
  ): TranscribeIO[CreateMedicalVocabularyResponse] =
    FF.liftF(CreateMedicalVocabularyOp(request))

  def createVocabulary(
    request: CreateVocabularyRequest
  ): TranscribeIO[CreateVocabularyResponse] =
    FF.liftF(CreateVocabularyOp(request))

  def createVocabularyFilter(
    request: CreateVocabularyFilterRequest
  ): TranscribeIO[CreateVocabularyFilterResponse] =
    FF.liftF(CreateVocabularyFilterOp(request))

  def deleteLanguageModel(
    request: DeleteLanguageModelRequest
  ): TranscribeIO[DeleteLanguageModelResponse] =
    FF.liftF(DeleteLanguageModelOp(request))

  def deleteMedicalTranscriptionJob(
    request: DeleteMedicalTranscriptionJobRequest
  ): TranscribeIO[DeleteMedicalTranscriptionJobResponse] =
    FF.liftF(DeleteMedicalTranscriptionJobOp(request))

  def deleteMedicalVocabulary(
    request: DeleteMedicalVocabularyRequest
  ): TranscribeIO[DeleteMedicalVocabularyResponse] =
    FF.liftF(DeleteMedicalVocabularyOp(request))

  def deleteTranscriptionJob(
    request: DeleteTranscriptionJobRequest
  ): TranscribeIO[DeleteTranscriptionJobResponse] =
    FF.liftF(DeleteTranscriptionJobOp(request))

  def deleteVocabulary(
    request: DeleteVocabularyRequest
  ): TranscribeIO[DeleteVocabularyResponse] =
    FF.liftF(DeleteVocabularyOp(request))

  def deleteVocabularyFilter(
    request: DeleteVocabularyFilterRequest
  ): TranscribeIO[DeleteVocabularyFilterResponse] =
    FF.liftF(DeleteVocabularyFilterOp(request))

  def describeLanguageModel(
    request: DescribeLanguageModelRequest
  ): TranscribeIO[DescribeLanguageModelResponse] =
    FF.liftF(DescribeLanguageModelOp(request))

  def getMedicalTranscriptionJob(
    request: GetMedicalTranscriptionJobRequest
  ): TranscribeIO[GetMedicalTranscriptionJobResponse] =
    FF.liftF(GetMedicalTranscriptionJobOp(request))

  def getMedicalVocabulary(
    request: GetMedicalVocabularyRequest
  ): TranscribeIO[GetMedicalVocabularyResponse] =
    FF.liftF(GetMedicalVocabularyOp(request))

  def getTranscriptionJob(
    request: GetTranscriptionJobRequest
  ): TranscribeIO[GetTranscriptionJobResponse] =
    FF.liftF(GetTranscriptionJobOp(request))

  def getVocabulary(
    request: GetVocabularyRequest
  ): TranscribeIO[GetVocabularyResponse] =
    FF.liftF(GetVocabularyOp(request))

  def getVocabularyFilter(
    request: GetVocabularyFilterRequest
  ): TranscribeIO[GetVocabularyFilterResponse] =
    FF.liftF(GetVocabularyFilterOp(request))

  def listLanguageModels(
    request: ListLanguageModelsRequest
  ): TranscribeIO[ListLanguageModelsResponse] =
    FF.liftF(ListLanguageModelsOp(request))

  def listMedicalTranscriptionJobs(
    request: ListMedicalTranscriptionJobsRequest
  ): TranscribeIO[ListMedicalTranscriptionJobsResponse] =
    FF.liftF(ListMedicalTranscriptionJobsOp(request))

  def listMedicalVocabularies(
    request: ListMedicalVocabulariesRequest
  ): TranscribeIO[ListMedicalVocabulariesResponse] =
    FF.liftF(ListMedicalVocabulariesOp(request))

  def listTranscriptionJobs(
    request: ListTranscriptionJobsRequest
  ): TranscribeIO[ListTranscriptionJobsResponse] =
    FF.liftF(ListTranscriptionJobsOp(request))

  def listVocabularies(
    request: ListVocabulariesRequest
  ): TranscribeIO[ListVocabulariesResponse] =
    FF.liftF(ListVocabulariesOp(request))

  def listVocabularyFilters(
    request: ListVocabularyFiltersRequest
  ): TranscribeIO[ListVocabularyFiltersResponse] =
    FF.liftF(ListVocabularyFiltersOp(request))

  def startMedicalTranscriptionJob(
    request: StartMedicalTranscriptionJobRequest
  ): TranscribeIO[StartMedicalTranscriptionJobResponse] =
    FF.liftF(StartMedicalTranscriptionJobOp(request))

  def startTranscriptionJob(
    request: StartTranscriptionJobRequest
  ): TranscribeIO[StartTranscriptionJobResponse] =
    FF.liftF(StartTranscriptionJobOp(request))

  def updateMedicalVocabulary(
    request: UpdateMedicalVocabularyRequest
  ): TranscribeIO[UpdateMedicalVocabularyResponse] =
    FF.liftF(UpdateMedicalVocabularyOp(request))

  def updateVocabulary(
    request: UpdateVocabularyRequest
  ): TranscribeIO[UpdateVocabularyResponse] =
    FF.liftF(UpdateVocabularyOp(request))

  def updateVocabularyFilter(
    request: UpdateVocabularyFilterRequest
  ): TranscribeIO[UpdateVocabularyFilterResponse] =
    FF.liftF(UpdateVocabularyFilterOp(request))
}
