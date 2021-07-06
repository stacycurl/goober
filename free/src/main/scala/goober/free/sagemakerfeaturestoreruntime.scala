package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.sagemakerfeaturestoreruntime.SageMakerFeatureStoreRuntimeClient
import software.amazon.awssdk.services.sagemakerfeaturestoreruntime.model._


object sagemakerfeaturestoreruntime { module =>

  // Free monad over SageMakerFeatureStoreRuntimeOp
  type SageMakerFeatureStoreRuntimeIO[A] = FF[SageMakerFeatureStoreRuntimeOp, A]

  sealed trait SageMakerFeatureStoreRuntimeOp[A] {
    def visit[F[_]](visitor: SageMakerFeatureStoreRuntimeOp.Visitor[F]): F[A]
  }

  object SageMakerFeatureStoreRuntimeOp {
    // Given a SageMakerFeatureStoreRuntimeClient we can embed a SageMakerFeatureStoreRuntimeIO program in any algebra that understands embedding.
    implicit val SageMakerFeatureStoreRuntimeOpEmbeddable: Embeddable[SageMakerFeatureStoreRuntimeOp, SageMakerFeatureStoreRuntimeClient] = new Embeddable[SageMakerFeatureStoreRuntimeOp, SageMakerFeatureStoreRuntimeClient] {
      def embed[A](client: SageMakerFeatureStoreRuntimeClient, io: SageMakerFeatureStoreRuntimeIO[A]): Embedded[A] = Embedded.SageMakerFeatureStoreRuntime(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SageMakerFeatureStoreRuntimeOp.Visitor[Kleisli[M, SageMakerFeatureStoreRuntimeClient, *]] {
        def batchGetRecord(
          request: BatchGetRecordRequest
        ): Kleisli[M, SageMakerFeatureStoreRuntimeClient, BatchGetRecordResponse] =
          primitive(_.batchGetRecord(request))

        def deleteRecord(
          request: DeleteRecordRequest
        ): Kleisli[M, SageMakerFeatureStoreRuntimeClient, DeleteRecordResponse] =
          primitive(_.deleteRecord(request))

        def getRecord(
          request: GetRecordRequest
        ): Kleisli[M, SageMakerFeatureStoreRuntimeClient, GetRecordResponse] =
          primitive(_.getRecord(request))

        def putRecord(
          request: PutRecordRequest
        ): Kleisli[M, SageMakerFeatureStoreRuntimeClient, PutRecordResponse] =
          primitive(_.putRecord(request))

        def primitive[A](
          f: SageMakerFeatureStoreRuntimeClient => A
        ): Kleisli[M, SageMakerFeatureStoreRuntimeClient, A]
      }
    }

    trait Visitor[F[_]] extends (SageMakerFeatureStoreRuntimeOp ~> F) {
      final def apply[A](op: SageMakerFeatureStoreRuntimeOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchGetRecord(
        request: BatchGetRecordRequest
      ): F[BatchGetRecordResponse]

      def deleteRecord(
        request: DeleteRecordRequest
      ): F[DeleteRecordResponse]

      def getRecord(
        request: GetRecordRequest
      ): F[GetRecordResponse]

      def putRecord(
        request: PutRecordRequest
      ): F[PutRecordResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SageMakerFeatureStoreRuntimeOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchGetRecordOp(
      request: BatchGetRecordRequest
    ) extends SageMakerFeatureStoreRuntimeOp[BatchGetRecordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetRecordResponse] =
        visitor.batchGetRecord(request)
    }

    final case class DeleteRecordOp(
      request: DeleteRecordRequest
    ) extends SageMakerFeatureStoreRuntimeOp[DeleteRecordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRecordResponse] =
        visitor.deleteRecord(request)
    }

    final case class GetRecordOp(
      request: GetRecordRequest
    ) extends SageMakerFeatureStoreRuntimeOp[GetRecordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRecordResponse] =
        visitor.getRecord(request)
    }

    final case class PutRecordOp(
      request: PutRecordRequest
    ) extends SageMakerFeatureStoreRuntimeOp[PutRecordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRecordResponse] =
        visitor.putRecord(request)
    }
  }

  import SageMakerFeatureStoreRuntimeOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SageMakerFeatureStoreRuntimeOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchGetRecord(
    request: BatchGetRecordRequest
  ): SageMakerFeatureStoreRuntimeIO[BatchGetRecordResponse] =
    FF.liftF(BatchGetRecordOp(request))

  def deleteRecord(
    request: DeleteRecordRequest
  ): SageMakerFeatureStoreRuntimeIO[DeleteRecordResponse] =
    FF.liftF(DeleteRecordOp(request))

  def getRecord(
    request: GetRecordRequest
  ): SageMakerFeatureStoreRuntimeIO[GetRecordResponse] =
    FF.liftF(GetRecordOp(request))

  def putRecord(
    request: PutRecordRequest
  ): SageMakerFeatureStoreRuntimeIO[PutRecordResponse] =
    FF.liftF(PutRecordOp(request))
}
