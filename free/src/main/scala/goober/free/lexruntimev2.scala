package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.lexruntimev2.LexRuntimeV2Client
import software.amazon.awssdk.services.lexruntimev2.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object lexruntimev2 { module =>

  // Free monad over LexRuntimeV2Op
  type LexRuntimeV2IO[A] = FF[LexRuntimeV2Op, A]

  sealed trait LexRuntimeV2Op[A] {
    def visit[F[_]](visitor: LexRuntimeV2Op.Visitor[F]): F[A]
  }

  object LexRuntimeV2Op {
    // Given a LexRuntimeV2Client we can embed a LexRuntimeV2IO program in any algebra that understands embedding.
    implicit val LexRuntimeV2OpEmbeddable: Embeddable[LexRuntimeV2Op, LexRuntimeV2Client] = new Embeddable[LexRuntimeV2Op, LexRuntimeV2Client] {
      def embed[A](client: LexRuntimeV2Client, io: LexRuntimeV2IO[A]): Embedded[A] = Embedded.LexRuntimeV2(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends LexRuntimeV2Op.Visitor[Kleisli[M, LexRuntimeV2Client, *]] {
        def deleteSession(
          request: DeleteSessionRequest
        ): Kleisli[M, LexRuntimeV2Client, DeleteSessionResponse] =
          primitive(_.deleteSession(request))

        def getSession(
          request: GetSessionRequest
        ): Kleisli[M, LexRuntimeV2Client, GetSessionResponse] =
          primitive(_.getSession(request))

        def putSession(
          request: PutSessionRequest,
          path: Path
        ): Kleisli[M, LexRuntimeV2Client, PutSessionResponse] =
          primitive(_.putSession(request, path))

        def recognizeText(
          request: RecognizeTextRequest
        ): Kleisli[M, LexRuntimeV2Client, RecognizeTextResponse] =
          primitive(_.recognizeText(request))

        def recognizeUtterance(
          request: RecognizeUtteranceRequest,
          sourcePath: Path,
          destinationPath: Path
        ): Kleisli[M, LexRuntimeV2Client, RecognizeUtteranceResponse] =
          primitive(_.recognizeUtterance(request, sourcePath, destinationPath))

        def primitive[A](
          f: LexRuntimeV2Client => A
        ): Kleisli[M, LexRuntimeV2Client, A]
      }
    }

    trait Visitor[F[_]] extends (LexRuntimeV2Op ~> F) {
      final def apply[A](op: LexRuntimeV2Op[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def deleteSession(
        request: DeleteSessionRequest
      ): F[DeleteSessionResponse]

      def getSession(
        request: GetSessionRequest
      ): F[GetSessionResponse]

      def putSession(
        request: PutSessionRequest,
        path: Path
      ): F[PutSessionResponse]

      def recognizeText(
        request: RecognizeTextRequest
      ): F[RecognizeTextResponse]

      def recognizeUtterance(
        request: RecognizeUtteranceRequest,
        sourcePath: Path,
        destinationPath: Path
      ): F[RecognizeUtteranceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends LexRuntimeV2Op[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DeleteSessionOp(
      request: DeleteSessionRequest
    ) extends LexRuntimeV2Op[DeleteSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSessionResponse] =
        visitor.deleteSession(request)
    }

    final case class GetSessionOp(
      request: GetSessionRequest
    ) extends LexRuntimeV2Op[GetSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSessionResponse] =
        visitor.getSession(request)
    }

    final case class PutSessionOp(
      request: PutSessionRequest,
      path: Path
    ) extends LexRuntimeV2Op[PutSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutSessionResponse] =
        visitor.putSession(request, path)
    }

    final case class RecognizeTextOp(
      request: RecognizeTextRequest
    ) extends LexRuntimeV2Op[RecognizeTextResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RecognizeTextResponse] =
        visitor.recognizeText(request)
    }

    final case class RecognizeUtteranceOp(
      request: RecognizeUtteranceRequest,
      sourcePath: Path,
      destinationPath: Path
    ) extends LexRuntimeV2Op[RecognizeUtteranceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RecognizeUtteranceResponse] =
        visitor.recognizeUtterance(request, sourcePath, destinationPath)
    }
  }

  import LexRuntimeV2Op._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[LexRuntimeV2Op, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def deleteSession(
    request: DeleteSessionRequest
  ): LexRuntimeV2IO[DeleteSessionResponse] =
    FF.liftF(DeleteSessionOp(request))

  def getSession(
    request: GetSessionRequest
  ): LexRuntimeV2IO[GetSessionResponse] =
    FF.liftF(GetSessionOp(request))

  def putSession(
    request: PutSessionRequest,
    path: Path
  ): LexRuntimeV2IO[PutSessionResponse] =
    FF.liftF(PutSessionOp(request, path))

  def recognizeText(
    request: RecognizeTextRequest
  ): LexRuntimeV2IO[RecognizeTextResponse] =
    FF.liftF(RecognizeTextOp(request))

  def recognizeUtterance(
    request: RecognizeUtteranceRequest,
    sourcePath: Path,
    destinationPath: Path
  ): LexRuntimeV2IO[RecognizeUtteranceResponse] =
    FF.liftF(RecognizeUtteranceOp(request, sourcePath, destinationPath))
}
