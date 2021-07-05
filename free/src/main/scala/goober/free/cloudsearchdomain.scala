package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.cloudsearchdomain.CloudSearchDomainClient
import software.amazon.awssdk.services.cloudsearchdomain.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object cloudsearchdomain { module =>

  // Free monad over CloudSearchDomainOp
  type CloudSearchDomainIO[A] = FF[CloudSearchDomainOp, A]

  sealed trait CloudSearchDomainOp[A] {
    def visit[F[_]](visitor: CloudSearchDomainOp.Visitor[F]): F[A]
  }

  object CloudSearchDomainOp {
    // Given a CloudSearchDomainClient we can embed a CloudSearchDomainIO program in any algebra that understands embedding.
    implicit val CloudSearchDomainOpEmbeddable: Embeddable[CloudSearchDomainOp, CloudSearchDomainClient] = new Embeddable[CloudSearchDomainOp, CloudSearchDomainClient] {
      def embed[A](client: CloudSearchDomainClient, io: CloudSearchDomainIO[A]): Embedded[A] = Embedded.CloudSearchDomain(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CloudSearchDomainOp.Visitor[Kleisli[M, CloudSearchDomainClient, *]] {
        def search(
          request: SearchRequest
        ): Kleisli[M, CloudSearchDomainClient, SearchResponse] =
          primitive(_.search(request))

        def suggest(
          request: SuggestRequest
        ): Kleisli[M, CloudSearchDomainClient, SuggestResponse] =
          primitive(_.suggest(request))

        def uploadDocuments(
          request: UploadDocumentsRequest,
          body: RequestBody
        ): Kleisli[M, CloudSearchDomainClient, UploadDocumentsResponse] =
          primitive(_.uploadDocuments(request, body))

        def primitive[A](
          f: CloudSearchDomainClient => A
        ): Kleisli[M, CloudSearchDomainClient, A]
      }
    }

    trait Visitor[F[_]] extends (CloudSearchDomainOp ~> F) {
      final def apply[A](op: CloudSearchDomainOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def search(
        request: SearchRequest
      ): F[SearchResponse]

      def suggest(
        request: SuggestRequest
      ): F[SuggestResponse]

      def uploadDocuments(
        request: UploadDocumentsRequest,
        body: RequestBody
      ): F[UploadDocumentsResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CloudSearchDomainOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class SearchOp(
      request: SearchRequest
    ) extends CloudSearchDomainOp[SearchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchResponse] =
        visitor.search(request)
    }

    final case class SuggestOp(
      request: SuggestRequest
    ) extends CloudSearchDomainOp[SuggestResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SuggestResponse] =
        visitor.suggest(request)
    }

    final case class UploadDocumentsOp(
      request: UploadDocumentsRequest,
      body: RequestBody
    ) extends CloudSearchDomainOp[UploadDocumentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UploadDocumentsResponse] =
        visitor.uploadDocuments(request, body)
    }
  }

  import CloudSearchDomainOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CloudSearchDomainOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def search(
    request: SearchRequest
  ): CloudSearchDomainIO[SearchResponse] =
    FF.liftF(SearchOp(request))

  def suggest(
    request: SuggestRequest
  ): CloudSearchDomainIO[SuggestResponse] =
    FF.liftF(SuggestOp(request))

  def uploadDocuments(
    request: UploadDocumentsRequest,
    body: RequestBody
  ): CloudSearchDomainIO[UploadDocumentsResponse] =
    FF.liftF(UploadDocumentsOp(request, body))
}
