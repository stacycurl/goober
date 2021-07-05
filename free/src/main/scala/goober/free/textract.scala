package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.textract.TextractClient
import software.amazon.awssdk.services.textract.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object textract { module =>

  // Free monad over TextractOp
  type TextractIO[A] = FF[TextractOp, A]

  sealed trait TextractOp[A] {
    def visit[F[_]](visitor: TextractOp.Visitor[F]): F[A]
  }

  object TextractOp {
    // Given a TextractClient we can embed a TextractIO program in any algebra that understands embedding.
    implicit val TextractOpEmbeddable: Embeddable[TextractOp, TextractClient] = new Embeddable[TextractOp, TextractClient] {
      def embed[A](client: TextractClient, io: TextractIO[A]): Embedded[A] = Embedded.Textract(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends TextractOp.Visitor[Kleisli[M, TextractClient, *]] {
        def analyzeDocument(
          request: AnalyzeDocumentRequest
        ): Kleisli[M, TextractClient, AnalyzeDocumentResponse] =
          primitive(_.analyzeDocument(request))

        def detectDocumentText(
          request: DetectDocumentTextRequest
        ): Kleisli[M, TextractClient, DetectDocumentTextResponse] =
          primitive(_.detectDocumentText(request))

        def getDocumentAnalysis(
          request: GetDocumentAnalysisRequest
        ): Kleisli[M, TextractClient, GetDocumentAnalysisResponse] =
          primitive(_.getDocumentAnalysis(request))

        def getDocumentTextDetection(
          request: GetDocumentTextDetectionRequest
        ): Kleisli[M, TextractClient, GetDocumentTextDetectionResponse] =
          primitive(_.getDocumentTextDetection(request))

        def startDocumentAnalysis(
          request: StartDocumentAnalysisRequest
        ): Kleisli[M, TextractClient, StartDocumentAnalysisResponse] =
          primitive(_.startDocumentAnalysis(request))

        def startDocumentTextDetection(
          request: StartDocumentTextDetectionRequest
        ): Kleisli[M, TextractClient, StartDocumentTextDetectionResponse] =
          primitive(_.startDocumentTextDetection(request))

        def primitive[A](
          f: TextractClient => A
        ): Kleisli[M, TextractClient, A]
      }
    }

    trait Visitor[F[_]] extends (TextractOp ~> F) {
      final def apply[A](op: TextractOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def analyzeDocument(
        request: AnalyzeDocumentRequest
      ): F[AnalyzeDocumentResponse]

      def detectDocumentText(
        request: DetectDocumentTextRequest
      ): F[DetectDocumentTextResponse]

      def getDocumentAnalysis(
        request: GetDocumentAnalysisRequest
      ): F[GetDocumentAnalysisResponse]

      def getDocumentTextDetection(
        request: GetDocumentTextDetectionRequest
      ): F[GetDocumentTextDetectionResponse]

      def startDocumentAnalysis(
        request: StartDocumentAnalysisRequest
      ): F[StartDocumentAnalysisResponse]

      def startDocumentTextDetection(
        request: StartDocumentTextDetectionRequest
      ): F[StartDocumentTextDetectionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends TextractOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AnalyzeDocumentOp(
      request: AnalyzeDocumentRequest
    ) extends TextractOp[AnalyzeDocumentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AnalyzeDocumentResponse] =
        visitor.analyzeDocument(request)
    }

    final case class DetectDocumentTextOp(
      request: DetectDocumentTextRequest
    ) extends TextractOp[DetectDocumentTextResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectDocumentTextResponse] =
        visitor.detectDocumentText(request)
    }

    final case class GetDocumentAnalysisOp(
      request: GetDocumentAnalysisRequest
    ) extends TextractOp[GetDocumentAnalysisResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDocumentAnalysisResponse] =
        visitor.getDocumentAnalysis(request)
    }

    final case class GetDocumentTextDetectionOp(
      request: GetDocumentTextDetectionRequest
    ) extends TextractOp[GetDocumentTextDetectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDocumentTextDetectionResponse] =
        visitor.getDocumentTextDetection(request)
    }

    final case class StartDocumentAnalysisOp(
      request: StartDocumentAnalysisRequest
    ) extends TextractOp[StartDocumentAnalysisResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDocumentAnalysisResponse] =
        visitor.startDocumentAnalysis(request)
    }

    final case class StartDocumentTextDetectionOp(
      request: StartDocumentTextDetectionRequest
    ) extends TextractOp[StartDocumentTextDetectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDocumentTextDetectionResponse] =
        visitor.startDocumentTextDetection(request)
    }
  }

  import TextractOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[TextractOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def analyzeDocument(
    request: AnalyzeDocumentRequest
  ): TextractIO[AnalyzeDocumentResponse] =
    FF.liftF(AnalyzeDocumentOp(request))

  def detectDocumentText(
    request: DetectDocumentTextRequest
  ): TextractIO[DetectDocumentTextResponse] =
    FF.liftF(DetectDocumentTextOp(request))

  def getDocumentAnalysis(
    request: GetDocumentAnalysisRequest
  ): TextractIO[GetDocumentAnalysisResponse] =
    FF.liftF(GetDocumentAnalysisOp(request))

  def getDocumentTextDetection(
    request: GetDocumentTextDetectionRequest
  ): TextractIO[GetDocumentTextDetectionResponse] =
    FF.liftF(GetDocumentTextDetectionOp(request))

  def startDocumentAnalysis(
    request: StartDocumentAnalysisRequest
  ): TextractIO[StartDocumentAnalysisResponse] =
    FF.liftF(StartDocumentAnalysisOp(request))

  def startDocumentTextDetection(
    request: StartDocumentTextDetectionRequest
  ): TextractIO[StartDocumentTextDetectionResponse] =
    FF.liftF(StartDocumentTextDetectionOp(request))
}
