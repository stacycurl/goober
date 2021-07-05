package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.translate.TranslateClient
import software.amazon.awssdk.services.translate.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object translate { module =>

  // Free monad over TranslateOp
  type TranslateIO[A] = FF[TranslateOp, A]

  sealed trait TranslateOp[A] {
    def visit[F[_]](visitor: TranslateOp.Visitor[F]): F[A]
  }

  object TranslateOp {
    // Given a TranslateClient we can embed a TranslateIO program in any algebra that understands embedding.
    implicit val TranslateOpEmbeddable: Embeddable[TranslateOp, TranslateClient] = new Embeddable[TranslateOp, TranslateClient] {
      def embed[A](client: TranslateClient, io: TranslateIO[A]): Embedded[A] = Embedded.Translate(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends TranslateOp.Visitor[Kleisli[M, TranslateClient, *]] {
        def createParallelData(
          request: CreateParallelDataRequest
        ): Kleisli[M, TranslateClient, CreateParallelDataResponse] =
          primitive(_.createParallelData(request))

        def deleteParallelData(
          request: DeleteParallelDataRequest
        ): Kleisli[M, TranslateClient, DeleteParallelDataResponse] =
          primitive(_.deleteParallelData(request))

        def deleteTerminology(
          request: DeleteTerminologyRequest
        ): Kleisli[M, TranslateClient, DeleteTerminologyResponse] =
          primitive(_.deleteTerminology(request))

        def describeTextTranslationJob(
          request: DescribeTextTranslationJobRequest
        ): Kleisli[M, TranslateClient, DescribeTextTranslationJobResponse] =
          primitive(_.describeTextTranslationJob(request))

        def getParallelData(
          request: GetParallelDataRequest
        ): Kleisli[M, TranslateClient, GetParallelDataResponse] =
          primitive(_.getParallelData(request))

        def getTerminology(
          request: GetTerminologyRequest
        ): Kleisli[M, TranslateClient, GetTerminologyResponse] =
          primitive(_.getTerminology(request))

        def importTerminology(
          request: ImportTerminologyRequest
        ): Kleisli[M, TranslateClient, ImportTerminologyResponse] =
          primitive(_.importTerminology(request))

        def listParallelData(
          request: ListParallelDataRequest
        ): Kleisli[M, TranslateClient, ListParallelDataResponse] =
          primitive(_.listParallelData(request))

        def listTerminologies(
          request: ListTerminologiesRequest
        ): Kleisli[M, TranslateClient, ListTerminologiesResponse] =
          primitive(_.listTerminologies(request))

        def listTextTranslationJobs(
          request: ListTextTranslationJobsRequest
        ): Kleisli[M, TranslateClient, ListTextTranslationJobsResponse] =
          primitive(_.listTextTranslationJobs(request))

        def startTextTranslationJob(
          request: StartTextTranslationJobRequest
        ): Kleisli[M, TranslateClient, StartTextTranslationJobResponse] =
          primitive(_.startTextTranslationJob(request))

        def stopTextTranslationJob(
          request: StopTextTranslationJobRequest
        ): Kleisli[M, TranslateClient, StopTextTranslationJobResponse] =
          primitive(_.stopTextTranslationJob(request))

        def translateText(
          request: TranslateTextRequest
        ): Kleisli[M, TranslateClient, TranslateTextResponse] =
          primitive(_.translateText(request))

        def updateParallelData(
          request: UpdateParallelDataRequest
        ): Kleisli[M, TranslateClient, UpdateParallelDataResponse] =
          primitive(_.updateParallelData(request))

        def primitive[A](
          f: TranslateClient => A
        ): Kleisli[M, TranslateClient, A]
      }
    }

    trait Visitor[F[_]] extends (TranslateOp ~> F) {
      final def apply[A](op: TranslateOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createParallelData(
        request: CreateParallelDataRequest
      ): F[CreateParallelDataResponse]

      def deleteParallelData(
        request: DeleteParallelDataRequest
      ): F[DeleteParallelDataResponse]

      def deleteTerminology(
        request: DeleteTerminologyRequest
      ): F[DeleteTerminologyResponse]

      def describeTextTranslationJob(
        request: DescribeTextTranslationJobRequest
      ): F[DescribeTextTranslationJobResponse]

      def getParallelData(
        request: GetParallelDataRequest
      ): F[GetParallelDataResponse]

      def getTerminology(
        request: GetTerminologyRequest
      ): F[GetTerminologyResponse]

      def importTerminology(
        request: ImportTerminologyRequest
      ): F[ImportTerminologyResponse]

      def listParallelData(
        request: ListParallelDataRequest
      ): F[ListParallelDataResponse]

      def listTerminologies(
        request: ListTerminologiesRequest
      ): F[ListTerminologiesResponse]

      def listTextTranslationJobs(
        request: ListTextTranslationJobsRequest
      ): F[ListTextTranslationJobsResponse]

      def startTextTranslationJob(
        request: StartTextTranslationJobRequest
      ): F[StartTextTranslationJobResponse]

      def stopTextTranslationJob(
        request: StopTextTranslationJobRequest
      ): F[StopTextTranslationJobResponse]

      def translateText(
        request: TranslateTextRequest
      ): F[TranslateTextResponse]

      def updateParallelData(
        request: UpdateParallelDataRequest
      ): F[UpdateParallelDataResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends TranslateOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateParallelDataOp(
      request: CreateParallelDataRequest
    ) extends TranslateOp[CreateParallelDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateParallelDataResponse] =
        visitor.createParallelData(request)
    }

    final case class DeleteParallelDataOp(
      request: DeleteParallelDataRequest
    ) extends TranslateOp[DeleteParallelDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteParallelDataResponse] =
        visitor.deleteParallelData(request)
    }

    final case class DeleteTerminologyOp(
      request: DeleteTerminologyRequest
    ) extends TranslateOp[DeleteTerminologyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTerminologyResponse] =
        visitor.deleteTerminology(request)
    }

    final case class DescribeTextTranslationJobOp(
      request: DescribeTextTranslationJobRequest
    ) extends TranslateOp[DescribeTextTranslationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTextTranslationJobResponse] =
        visitor.describeTextTranslationJob(request)
    }

    final case class GetParallelDataOp(
      request: GetParallelDataRequest
    ) extends TranslateOp[GetParallelDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetParallelDataResponse] =
        visitor.getParallelData(request)
    }

    final case class GetTerminologyOp(
      request: GetTerminologyRequest
    ) extends TranslateOp[GetTerminologyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTerminologyResponse] =
        visitor.getTerminology(request)
    }

    final case class ImportTerminologyOp(
      request: ImportTerminologyRequest
    ) extends TranslateOp[ImportTerminologyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportTerminologyResponse] =
        visitor.importTerminology(request)
    }

    final case class ListParallelDataOp(
      request: ListParallelDataRequest
    ) extends TranslateOp[ListParallelDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListParallelDataResponse] =
        visitor.listParallelData(request)
    }

    final case class ListTerminologiesOp(
      request: ListTerminologiesRequest
    ) extends TranslateOp[ListTerminologiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTerminologiesResponse] =
        visitor.listTerminologies(request)
    }

    final case class ListTextTranslationJobsOp(
      request: ListTextTranslationJobsRequest
    ) extends TranslateOp[ListTextTranslationJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTextTranslationJobsResponse] =
        visitor.listTextTranslationJobs(request)
    }

    final case class StartTextTranslationJobOp(
      request: StartTextTranslationJobRequest
    ) extends TranslateOp[StartTextTranslationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartTextTranslationJobResponse] =
        visitor.startTextTranslationJob(request)
    }

    final case class StopTextTranslationJobOp(
      request: StopTextTranslationJobRequest
    ) extends TranslateOp[StopTextTranslationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopTextTranslationJobResponse] =
        visitor.stopTextTranslationJob(request)
    }

    final case class TranslateTextOp(
      request: TranslateTextRequest
    ) extends TranslateOp[TranslateTextResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TranslateTextResponse] =
        visitor.translateText(request)
    }

    final case class UpdateParallelDataOp(
      request: UpdateParallelDataRequest
    ) extends TranslateOp[UpdateParallelDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateParallelDataResponse] =
        visitor.updateParallelData(request)
    }
  }

  import TranslateOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[TranslateOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createParallelData(
    request: CreateParallelDataRequest
  ): TranslateIO[CreateParallelDataResponse] =
    FF.liftF(CreateParallelDataOp(request))

  def deleteParallelData(
    request: DeleteParallelDataRequest
  ): TranslateIO[DeleteParallelDataResponse] =
    FF.liftF(DeleteParallelDataOp(request))

  def deleteTerminology(
    request: DeleteTerminologyRequest
  ): TranslateIO[DeleteTerminologyResponse] =
    FF.liftF(DeleteTerminologyOp(request))

  def describeTextTranslationJob(
    request: DescribeTextTranslationJobRequest
  ): TranslateIO[DescribeTextTranslationJobResponse] =
    FF.liftF(DescribeTextTranslationJobOp(request))

  def getParallelData(
    request: GetParallelDataRequest
  ): TranslateIO[GetParallelDataResponse] =
    FF.liftF(GetParallelDataOp(request))

  def getTerminology(
    request: GetTerminologyRequest
  ): TranslateIO[GetTerminologyResponse] =
    FF.liftF(GetTerminologyOp(request))

  def importTerminology(
    request: ImportTerminologyRequest
  ): TranslateIO[ImportTerminologyResponse] =
    FF.liftF(ImportTerminologyOp(request))

  def listParallelData(
    request: ListParallelDataRequest
  ): TranslateIO[ListParallelDataResponse] =
    FF.liftF(ListParallelDataOp(request))

  def listTerminologies(
    request: ListTerminologiesRequest
  ): TranslateIO[ListTerminologiesResponse] =
    FF.liftF(ListTerminologiesOp(request))

  def listTextTranslationJobs(
    request: ListTextTranslationJobsRequest
  ): TranslateIO[ListTextTranslationJobsResponse] =
    FF.liftF(ListTextTranslationJobsOp(request))

  def startTextTranslationJob(
    request: StartTextTranslationJobRequest
  ): TranslateIO[StartTextTranslationJobResponse] =
    FF.liftF(StartTextTranslationJobOp(request))

  def stopTextTranslationJob(
    request: StopTextTranslationJobRequest
  ): TranslateIO[StopTextTranslationJobResponse] =
    FF.liftF(StopTextTranslationJobOp(request))

  def translateText(
    request: TranslateTextRequest
  ): TranslateIO[TranslateTextResponse] =
    FF.liftF(TranslateTextOp(request))

  def updateParallelData(
    request: UpdateParallelDataRequest
  ): TranslateIO[UpdateParallelDataResponse] =
    FF.liftF(UpdateParallelDataOp(request))
}
