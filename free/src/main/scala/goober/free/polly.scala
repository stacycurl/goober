package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.polly.PollyClient
import software.amazon.awssdk.services.polly.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object polly { module =>

  // Free monad over PollyOp
  type PollyIO[A] = FF[PollyOp, A]

  sealed trait PollyOp[A] {
    def visit[F[_]](visitor: PollyOp.Visitor[F]): F[A]
  }

  object PollyOp {
    // Given a PollyClient we can embed a PollyIO program in any algebra that understands embedding.
    implicit val PollyOpEmbeddable: Embeddable[PollyOp, PollyClient] = new Embeddable[PollyOp, PollyClient] {
      def embed[A](client: PollyClient, io: PollyIO[A]): Embedded[A] = Embedded.Polly(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends PollyOp.Visitor[Kleisli[M, PollyClient, *]] {
        def deleteLexicon(
          request: DeleteLexiconRequest
        ): Kleisli[M, PollyClient, DeleteLexiconResponse] =
          primitive(_.deleteLexicon(request))

        def describeVoices(
          request: DescribeVoicesRequest
        ): Kleisli[M, PollyClient, DescribeVoicesResponse] =
          primitive(_.describeVoices(request))

        def getLexicon(
          request: GetLexiconRequest
        ): Kleisli[M, PollyClient, GetLexiconResponse] =
          primitive(_.getLexicon(request))

        def getSpeechSynthesisTask(
          request: GetSpeechSynthesisTaskRequest
        ): Kleisli[M, PollyClient, GetSpeechSynthesisTaskResponse] =
          primitive(_.getSpeechSynthesisTask(request))

        def listLexicons(
          request: ListLexiconsRequest
        ): Kleisli[M, PollyClient, ListLexiconsResponse] =
          primitive(_.listLexicons(request))

        def listSpeechSynthesisTasks(
          request: ListSpeechSynthesisTasksRequest
        ): Kleisli[M, PollyClient, ListSpeechSynthesisTasksResponse] =
          primitive(_.listSpeechSynthesisTasks(request))

        def putLexicon(
          request: PutLexiconRequest
        ): Kleisli[M, PollyClient, PutLexiconResponse] =
          primitive(_.putLexicon(request))

        def startSpeechSynthesisTask(
          request: StartSpeechSynthesisTaskRequest
        ): Kleisli[M, PollyClient, StartSpeechSynthesisTaskResponse] =
          primitive(_.startSpeechSynthesisTask(request))

        def synthesizeSpeech(
          request: SynthesizeSpeechRequest,
          path: Path
        ): Kleisli[M, PollyClient, SynthesizeSpeechResponse] =
          primitive(_.synthesizeSpeech(request, path))

        def primitive[A](
          f: PollyClient => A
        ): Kleisli[M, PollyClient, A]
      }
    }

    trait Visitor[F[_]] extends (PollyOp ~> F) {
      final def apply[A](op: PollyOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def deleteLexicon(
        request: DeleteLexiconRequest
      ): F[DeleteLexiconResponse]

      def describeVoices(
        request: DescribeVoicesRequest
      ): F[DescribeVoicesResponse]

      def getLexicon(
        request: GetLexiconRequest
      ): F[GetLexiconResponse]

      def getSpeechSynthesisTask(
        request: GetSpeechSynthesisTaskRequest
      ): F[GetSpeechSynthesisTaskResponse]

      def listLexicons(
        request: ListLexiconsRequest
      ): F[ListLexiconsResponse]

      def listSpeechSynthesisTasks(
        request: ListSpeechSynthesisTasksRequest
      ): F[ListSpeechSynthesisTasksResponse]

      def putLexicon(
        request: PutLexiconRequest
      ): F[PutLexiconResponse]

      def startSpeechSynthesisTask(
        request: StartSpeechSynthesisTaskRequest
      ): F[StartSpeechSynthesisTaskResponse]

      def synthesizeSpeech(
        request: SynthesizeSpeechRequest,
        path: Path
      ): F[SynthesizeSpeechResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends PollyOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DeleteLexiconOp(
      request: DeleteLexiconRequest
    ) extends PollyOp[DeleteLexiconResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLexiconResponse] =
        visitor.deleteLexicon(request)
    }

    final case class DescribeVoicesOp(
      request: DescribeVoicesRequest
    ) extends PollyOp[DescribeVoicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVoicesResponse] =
        visitor.describeVoices(request)
    }

    final case class GetLexiconOp(
      request: GetLexiconRequest
    ) extends PollyOp[GetLexiconResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLexiconResponse] =
        visitor.getLexicon(request)
    }

    final case class GetSpeechSynthesisTaskOp(
      request: GetSpeechSynthesisTaskRequest
    ) extends PollyOp[GetSpeechSynthesisTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSpeechSynthesisTaskResponse] =
        visitor.getSpeechSynthesisTask(request)
    }

    final case class ListLexiconsOp(
      request: ListLexiconsRequest
    ) extends PollyOp[ListLexiconsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLexiconsResponse] =
        visitor.listLexicons(request)
    }

    final case class ListSpeechSynthesisTasksOp(
      request: ListSpeechSynthesisTasksRequest
    ) extends PollyOp[ListSpeechSynthesisTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSpeechSynthesisTasksResponse] =
        visitor.listSpeechSynthesisTasks(request)
    }

    final case class PutLexiconOp(
      request: PutLexiconRequest
    ) extends PollyOp[PutLexiconResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutLexiconResponse] =
        visitor.putLexicon(request)
    }

    final case class StartSpeechSynthesisTaskOp(
      request: StartSpeechSynthesisTaskRequest
    ) extends PollyOp[StartSpeechSynthesisTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartSpeechSynthesisTaskResponse] =
        visitor.startSpeechSynthesisTask(request)
    }

    final case class SynthesizeSpeechOp(
      request: SynthesizeSpeechRequest,
      path: Path
    ) extends PollyOp[SynthesizeSpeechResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SynthesizeSpeechResponse] =
        visitor.synthesizeSpeech(request, path)
    }
  }

  import PollyOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[PollyOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def deleteLexicon(
    request: DeleteLexiconRequest
  ): PollyIO[DeleteLexiconResponse] =
    FF.liftF(DeleteLexiconOp(request))

  def describeVoices(
    request: DescribeVoicesRequest
  ): PollyIO[DescribeVoicesResponse] =
    FF.liftF(DescribeVoicesOp(request))

  def getLexicon(
    request: GetLexiconRequest
  ): PollyIO[GetLexiconResponse] =
    FF.liftF(GetLexiconOp(request))

  def getSpeechSynthesisTask(
    request: GetSpeechSynthesisTaskRequest
  ): PollyIO[GetSpeechSynthesisTaskResponse] =
    FF.liftF(GetSpeechSynthesisTaskOp(request))

  def listLexicons(
    request: ListLexiconsRequest
  ): PollyIO[ListLexiconsResponse] =
    FF.liftF(ListLexiconsOp(request))

  def listSpeechSynthesisTasks(
    request: ListSpeechSynthesisTasksRequest
  ): PollyIO[ListSpeechSynthesisTasksResponse] =
    FF.liftF(ListSpeechSynthesisTasksOp(request))

  def putLexicon(
    request: PutLexiconRequest
  ): PollyIO[PutLexiconResponse] =
    FF.liftF(PutLexiconOp(request))

  def startSpeechSynthesisTask(
    request: StartSpeechSynthesisTaskRequest
  ): PollyIO[StartSpeechSynthesisTaskResponse] =
    FF.liftF(StartSpeechSynthesisTaskOp(request))

  def synthesizeSpeech(
    request: SynthesizeSpeechRequest,
    path: Path
  ): PollyIO[SynthesizeSpeechResponse] =
    FF.liftF(SynthesizeSpeechOp(request, path))
}
