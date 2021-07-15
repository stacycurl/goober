package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.mediastoredata.MediaStoreDataClient
import software.amazon.awssdk.services.mediastoredata.model._
import software.amazon.awssdk.core.sync.RequestBody


object mediastoredata { module =>

  // Free monad over MediaStoreDataOp
  type MediaStoreDataIO[A] = FF[MediaStoreDataOp, A]

  sealed trait MediaStoreDataOp[A] {
    def visit[F[_]](visitor: MediaStoreDataOp.Visitor[F]): F[A]
  }

  object MediaStoreDataOp {
    // Given a MediaStoreDataClient we can embed a MediaStoreDataIO program in any algebra that understands embedding.
    implicit val MediaStoreDataOpEmbeddable: Embeddable[MediaStoreDataOp, MediaStoreDataClient] = new Embeddable[MediaStoreDataOp, MediaStoreDataClient] {
      def embed[A](client: MediaStoreDataClient, io: MediaStoreDataIO[A]): Embedded[A] = Embedded.MediaStoreData(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MediaStoreDataOp.Visitor[Kleisli[M, MediaStoreDataClient, *]] {
        def deleteObject(
          request: DeleteObjectRequest
        ): Kleisli[M, MediaStoreDataClient, DeleteObjectResponse] =
          primitive(_.deleteObject(request))

        def describeObject(
          request: DescribeObjectRequest
        ): Kleisli[M, MediaStoreDataClient, DescribeObjectResponse] =
          primitive(_.describeObject(request))

        def listItems(
          request: ListItemsRequest
        ): Kleisli[M, MediaStoreDataClient, ListItemsResponse] =
          primitive(_.listItems(request))

        def putObject(
          request: PutObjectRequest,
          body: RequestBody
        ): Kleisli[M, MediaStoreDataClient, PutObjectResponse] =
          primitive(_.putObject(request, body))

        def primitive[A](
          f: MediaStoreDataClient => A
        ): Kleisli[M, MediaStoreDataClient, A]
      }
    }

    trait Visitor[F[_]] extends (MediaStoreDataOp ~> F) {
      final def apply[A](op: MediaStoreDataOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def deleteObject(
        request: DeleteObjectRequest
      ): F[DeleteObjectResponse]

      def describeObject(
        request: DescribeObjectRequest
      ): F[DescribeObjectResponse]

      def listItems(
        request: ListItemsRequest
      ): F[ListItemsResponse]

      def putObject(
        request: PutObjectRequest,
        body: RequestBody
      ): F[PutObjectResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MediaStoreDataOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DeleteObjectOp(
      request: DeleteObjectRequest
    ) extends MediaStoreDataOp[DeleteObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteObjectResponse] =
        visitor.deleteObject(request)
    }

    final case class DescribeObjectOp(
      request: DescribeObjectRequest
    ) extends MediaStoreDataOp[DescribeObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeObjectResponse] =
        visitor.describeObject(request)
    }

    final case class ListItemsOp(
      request: ListItemsRequest
    ) extends MediaStoreDataOp[ListItemsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListItemsResponse] =
        visitor.listItems(request)
    }

    final case class PutObjectOp(
      request: PutObjectRequest,
      body: RequestBody
    ) extends MediaStoreDataOp[PutObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutObjectResponse] =
        visitor.putObject(request, body)
    }
  }

  import MediaStoreDataOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MediaStoreDataOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def deleteObject(
    request: DeleteObjectRequest
  ): MediaStoreDataIO[DeleteObjectResponse] =
    FF.liftF(DeleteObjectOp(request))

  def describeObject(
    request: DescribeObjectRequest
  ): MediaStoreDataIO[DescribeObjectResponse] =
    FF.liftF(DescribeObjectOp(request))

  def listItems(
    request: ListItemsRequest
  ): MediaStoreDataIO[ListItemsResponse] =
    FF.liftF(ListItemsOp(request))

  def putObject(
    request: PutObjectRequest,
    body: RequestBody
  ): MediaStoreDataIO[PutObjectResponse] =
    FF.liftF(PutObjectOp(request, body))
}
