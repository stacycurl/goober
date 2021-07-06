package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.lexruntime.LexRuntimeClient
import software.amazon.awssdk.services.lexruntime.model._
import java.nio.file.Path


object lexruntime { module =>

  // Free monad over LexRuntimeOp
  type LexRuntimeIO[A] = FF[LexRuntimeOp, A]

  sealed trait LexRuntimeOp[A] {
    def visit[F[_]](visitor: LexRuntimeOp.Visitor[F]): F[A]
  }

  object LexRuntimeOp {
    // Given a LexRuntimeClient we can embed a LexRuntimeIO program in any algebra that understands embedding.
    implicit val LexRuntimeOpEmbeddable: Embeddable[LexRuntimeOp, LexRuntimeClient] = new Embeddable[LexRuntimeOp, LexRuntimeClient] {
      def embed[A](client: LexRuntimeClient, io: LexRuntimeIO[A]): Embedded[A] = Embedded.LexRuntime(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends LexRuntimeOp.Visitor[Kleisli[M, LexRuntimeClient, *]] {
        def deleteSession(
          request: DeleteSessionRequest
        ): Kleisli[M, LexRuntimeClient, DeleteSessionResponse] =
          primitive(_.deleteSession(request))

        def getSession(
          request: GetSessionRequest
        ): Kleisli[M, LexRuntimeClient, GetSessionResponse] =
          primitive(_.getSession(request))

        def postContent(
          request: PostContentRequest,
          sourcePath: Path,
          destinationPath: Path
        ): Kleisli[M, LexRuntimeClient, PostContentResponse] =
          primitive(_.postContent(request, sourcePath, destinationPath))

        def postText(
          request: PostTextRequest
        ): Kleisli[M, LexRuntimeClient, PostTextResponse] =
          primitive(_.postText(request))

        def putSession(
          request: PutSessionRequest,
          path: Path
        ): Kleisli[M, LexRuntimeClient, PutSessionResponse] =
          primitive(_.putSession(request, path))

        def primitive[A](
          f: LexRuntimeClient => A
        ): Kleisli[M, LexRuntimeClient, A]
      }
    }

    trait Visitor[F[_]] extends (LexRuntimeOp ~> F) {
      final def apply[A](op: LexRuntimeOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def deleteSession(
        request: DeleteSessionRequest
      ): F[DeleteSessionResponse]

      def getSession(
        request: GetSessionRequest
      ): F[GetSessionResponse]

      def postContent(
        request: PostContentRequest,
        sourcePath: Path,
        destinationPath: Path
      ): F[PostContentResponse]

      def postText(
        request: PostTextRequest
      ): F[PostTextResponse]

      def putSession(
        request: PutSessionRequest,
        path: Path
      ): F[PutSessionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends LexRuntimeOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DeleteSessionOp(
      request: DeleteSessionRequest
    ) extends LexRuntimeOp[DeleteSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSessionResponse] =
        visitor.deleteSession(request)
    }

    final case class GetSessionOp(
      request: GetSessionRequest
    ) extends LexRuntimeOp[GetSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSessionResponse] =
        visitor.getSession(request)
    }

    final case class PostContentOp(
      request: PostContentRequest,
      sourcePath: Path,
      destinationPath: Path
    ) extends LexRuntimeOp[PostContentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PostContentResponse] =
        visitor.postContent(request, sourcePath, destinationPath)
    }

    final case class PostTextOp(
      request: PostTextRequest
    ) extends LexRuntimeOp[PostTextResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PostTextResponse] =
        visitor.postText(request)
    }

    final case class PutSessionOp(
      request: PutSessionRequest,
      path: Path
    ) extends LexRuntimeOp[PutSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutSessionResponse] =
        visitor.putSession(request, path)
    }
  }

  import LexRuntimeOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[LexRuntimeOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def deleteSession(
    request: DeleteSessionRequest
  ): LexRuntimeIO[DeleteSessionResponse] =
    FF.liftF(DeleteSessionOp(request))

  def getSession(
    request: GetSessionRequest
  ): LexRuntimeIO[GetSessionResponse] =
    FF.liftF(GetSessionOp(request))

  def postContent(
    request: PostContentRequest,
    sourcePath: Path,
    destinationPath: Path
  ): LexRuntimeIO[PostContentResponse] =
    FF.liftF(PostContentOp(request, sourcePath, destinationPath))

  def postText(
    request: PostTextRequest
  ): LexRuntimeIO[PostTextResponse] =
    FF.liftF(PostTextOp(request))

  def putSession(
    request: PutSessionRequest,
    path: Path
  ): LexRuntimeIO[PutSessionResponse] =
    FF.liftF(PutSessionOp(request, path))
}
