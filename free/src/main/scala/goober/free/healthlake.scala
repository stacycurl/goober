package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.healthlake.HealthLakeClient
import software.amazon.awssdk.services.healthlake.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object healthlake { module =>

  // Free monad over HealthLakeOp
  type HealthLakeIO[A] = FF[HealthLakeOp, A]

  sealed trait HealthLakeOp[A] {
    def visit[F[_]](visitor: HealthLakeOp.Visitor[F]): F[A]
  }

  object HealthLakeOp {
    // Given a HealthLakeClient we can embed a HealthLakeIO program in any algebra that understands embedding.
    implicit val HealthLakeOpEmbeddable: Embeddable[HealthLakeOp, HealthLakeClient] = new Embeddable[HealthLakeOp, HealthLakeClient] {
      def embed[A](client: HealthLakeClient, io: HealthLakeIO[A]): Embedded[A] = Embedded.HealthLake(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends HealthLakeOp.Visitor[Kleisli[M, HealthLakeClient, *]] {
        def createFHIRDatastore(
          request: CreateFhirDatastoreRequest
        ): Kleisli[M, HealthLakeClient, CreateFhirDatastoreResponse] =
          primitive(_.createFHIRDatastore(request))

        def deleteFHIRDatastore(
          request: DeleteFhirDatastoreRequest
        ): Kleisli[M, HealthLakeClient, DeleteFhirDatastoreResponse] =
          primitive(_.deleteFHIRDatastore(request))

        def describeFHIRDatastore(
          request: DescribeFhirDatastoreRequest
        ): Kleisli[M, HealthLakeClient, DescribeFhirDatastoreResponse] =
          primitive(_.describeFHIRDatastore(request))

        def describeFHIRExportJob(
          request: DescribeFhirExportJobRequest
        ): Kleisli[M, HealthLakeClient, DescribeFhirExportJobResponse] =
          primitive(_.describeFHIRExportJob(request))

        def describeFHIRImportJob(
          request: DescribeFhirImportJobRequest
        ): Kleisli[M, HealthLakeClient, DescribeFhirImportJobResponse] =
          primitive(_.describeFHIRImportJob(request))

        def listFHIRDatastores(
          request: ListFhirDatastoresRequest
        ): Kleisli[M, HealthLakeClient, ListFhirDatastoresResponse] =
          primitive(_.listFHIRDatastores(request))

        def startFHIRExportJob(
          request: StartFhirExportJobRequest
        ): Kleisli[M, HealthLakeClient, StartFhirExportJobResponse] =
          primitive(_.startFHIRExportJob(request))

        def startFHIRImportJob(
          request: StartFhirImportJobRequest
        ): Kleisli[M, HealthLakeClient, StartFhirImportJobResponse] =
          primitive(_.startFHIRImportJob(request))

        def primitive[A](
          f: HealthLakeClient => A
        ): Kleisli[M, HealthLakeClient, A]
      }
    }

    trait Visitor[F[_]] extends (HealthLakeOp ~> F) {
      final def apply[A](op: HealthLakeOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createFHIRDatastore(
        request: CreateFhirDatastoreRequest
      ): F[CreateFhirDatastoreResponse]

      def deleteFHIRDatastore(
        request: DeleteFhirDatastoreRequest
      ): F[DeleteFhirDatastoreResponse]

      def describeFHIRDatastore(
        request: DescribeFhirDatastoreRequest
      ): F[DescribeFhirDatastoreResponse]

      def describeFHIRExportJob(
        request: DescribeFhirExportJobRequest
      ): F[DescribeFhirExportJobResponse]

      def describeFHIRImportJob(
        request: DescribeFhirImportJobRequest
      ): F[DescribeFhirImportJobResponse]

      def listFHIRDatastores(
        request: ListFhirDatastoresRequest
      ): F[ListFhirDatastoresResponse]

      def startFHIRExportJob(
        request: StartFhirExportJobRequest
      ): F[StartFhirExportJobResponse]

      def startFHIRImportJob(
        request: StartFhirImportJobRequest
      ): F[StartFhirImportJobResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends HealthLakeOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateFHIRDatastoreOp(
      request: CreateFhirDatastoreRequest
    ) extends HealthLakeOp[CreateFhirDatastoreResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFhirDatastoreResponse] =
        visitor.createFHIRDatastore(request)
    }

    final case class DeleteFHIRDatastoreOp(
      request: DeleteFhirDatastoreRequest
    ) extends HealthLakeOp[DeleteFhirDatastoreResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFhirDatastoreResponse] =
        visitor.deleteFHIRDatastore(request)
    }

    final case class DescribeFHIRDatastoreOp(
      request: DescribeFhirDatastoreRequest
    ) extends HealthLakeOp[DescribeFhirDatastoreResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFhirDatastoreResponse] =
        visitor.describeFHIRDatastore(request)
    }

    final case class DescribeFHIRExportJobOp(
      request: DescribeFhirExportJobRequest
    ) extends HealthLakeOp[DescribeFhirExportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFhirExportJobResponse] =
        visitor.describeFHIRExportJob(request)
    }

    final case class DescribeFHIRImportJobOp(
      request: DescribeFhirImportJobRequest
    ) extends HealthLakeOp[DescribeFhirImportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFhirImportJobResponse] =
        visitor.describeFHIRImportJob(request)
    }

    final case class ListFHIRDatastoresOp(
      request: ListFhirDatastoresRequest
    ) extends HealthLakeOp[ListFhirDatastoresResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFhirDatastoresResponse] =
        visitor.listFHIRDatastores(request)
    }

    final case class StartFHIRExportJobOp(
      request: StartFhirExportJobRequest
    ) extends HealthLakeOp[StartFhirExportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartFhirExportJobResponse] =
        visitor.startFHIRExportJob(request)
    }

    final case class StartFHIRImportJobOp(
      request: StartFhirImportJobRequest
    ) extends HealthLakeOp[StartFhirImportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartFhirImportJobResponse] =
        visitor.startFHIRImportJob(request)
    }
  }

  import HealthLakeOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[HealthLakeOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createFHIRDatastore(
    request: CreateFhirDatastoreRequest
  ): HealthLakeIO[CreateFhirDatastoreResponse] =
    FF.liftF(CreateFHIRDatastoreOp(request))

  def deleteFHIRDatastore(
    request: DeleteFhirDatastoreRequest
  ): HealthLakeIO[DeleteFhirDatastoreResponse] =
    FF.liftF(DeleteFHIRDatastoreOp(request))

  def describeFHIRDatastore(
    request: DescribeFhirDatastoreRequest
  ): HealthLakeIO[DescribeFhirDatastoreResponse] =
    FF.liftF(DescribeFHIRDatastoreOp(request))

  def describeFHIRExportJob(
    request: DescribeFhirExportJobRequest
  ): HealthLakeIO[DescribeFhirExportJobResponse] =
    FF.liftF(DescribeFHIRExportJobOp(request))

  def describeFHIRImportJob(
    request: DescribeFhirImportJobRequest
  ): HealthLakeIO[DescribeFhirImportJobResponse] =
    FF.liftF(DescribeFHIRImportJobOp(request))

  def listFHIRDatastores(
    request: ListFhirDatastoresRequest
  ): HealthLakeIO[ListFhirDatastoresResponse] =
    FF.liftF(ListFHIRDatastoresOp(request))

  def startFHIRExportJob(
    request: StartFhirExportJobRequest
  ): HealthLakeIO[StartFhirExportJobResponse] =
    FF.liftF(StartFHIRExportJobOp(request))

  def startFHIRImportJob(
    request: StartFhirImportJobRequest
  ): HealthLakeIO[StartFhirImportJobResponse] =
    FF.liftF(StartFHIRImportJobOp(request))
}
