package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.costandusagereport.CostAndUsageReportClient
import software.amazon.awssdk.services.costandusagereport.model._


object costandusagereport { module =>

  // Free monad over CostAndUsageReportOp
  type CostAndUsageReportIO[A] = FF[CostAndUsageReportOp, A]

  sealed trait CostAndUsageReportOp[A] {
    def visit[F[_]](visitor: CostAndUsageReportOp.Visitor[F]): F[A]
  }

  object CostAndUsageReportOp {
    // Given a CostAndUsageReportClient we can embed a CostAndUsageReportIO program in any algebra that understands embedding.
    implicit val CostAndUsageReportOpEmbeddable: Embeddable[CostAndUsageReportOp, CostAndUsageReportClient] = new Embeddable[CostAndUsageReportOp, CostAndUsageReportClient] {
      def embed[A](client: CostAndUsageReportClient, io: CostAndUsageReportIO[A]): Embedded[A] = Embedded.CostAndUsageReport(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CostAndUsageReportOp.Visitor[Kleisli[M, CostAndUsageReportClient, *]] {
        def deleteReportDefinition(
          request: DeleteReportDefinitionRequest
        ): Kleisli[M, CostAndUsageReportClient, DeleteReportDefinitionResponse] =
          primitive(_.deleteReportDefinition(request))

        def describeReportDefinitions(
          request: DescribeReportDefinitionsRequest
        ): Kleisli[M, CostAndUsageReportClient, DescribeReportDefinitionsResponse] =
          primitive(_.describeReportDefinitions(request))

        def modifyReportDefinition(
          request: ModifyReportDefinitionRequest
        ): Kleisli[M, CostAndUsageReportClient, ModifyReportDefinitionResponse] =
          primitive(_.modifyReportDefinition(request))

        def putReportDefinition(
          request: PutReportDefinitionRequest
        ): Kleisli[M, CostAndUsageReportClient, PutReportDefinitionResponse] =
          primitive(_.putReportDefinition(request))

        def primitive[A](
          f: CostAndUsageReportClient => A
        ): Kleisli[M, CostAndUsageReportClient, A]
      }
    }

    trait Visitor[F[_]] extends (CostAndUsageReportOp ~> F) {
      final def apply[A](op: CostAndUsageReportOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def deleteReportDefinition(
        request: DeleteReportDefinitionRequest
      ): F[DeleteReportDefinitionResponse]

      def describeReportDefinitions(
        request: DescribeReportDefinitionsRequest
      ): F[DescribeReportDefinitionsResponse]

      def modifyReportDefinition(
        request: ModifyReportDefinitionRequest
      ): F[ModifyReportDefinitionResponse]

      def putReportDefinition(
        request: PutReportDefinitionRequest
      ): F[PutReportDefinitionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CostAndUsageReportOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DeleteReportDefinitionOp(
      request: DeleteReportDefinitionRequest
    ) extends CostAndUsageReportOp[DeleteReportDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteReportDefinitionResponse] =
        visitor.deleteReportDefinition(request)
    }

    final case class DescribeReportDefinitionsOp(
      request: DescribeReportDefinitionsRequest
    ) extends CostAndUsageReportOp[DescribeReportDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReportDefinitionsResponse] =
        visitor.describeReportDefinitions(request)
    }

    final case class ModifyReportDefinitionOp(
      request: ModifyReportDefinitionRequest
    ) extends CostAndUsageReportOp[ModifyReportDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyReportDefinitionResponse] =
        visitor.modifyReportDefinition(request)
    }

    final case class PutReportDefinitionOp(
      request: PutReportDefinitionRequest
    ) extends CostAndUsageReportOp[PutReportDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutReportDefinitionResponse] =
        visitor.putReportDefinition(request)
    }
  }

  import CostAndUsageReportOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CostAndUsageReportOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def deleteReportDefinition(
    request: DeleteReportDefinitionRequest
  ): CostAndUsageReportIO[DeleteReportDefinitionResponse] =
    FF.liftF(DeleteReportDefinitionOp(request))

  def describeReportDefinitions(
    request: DescribeReportDefinitionsRequest
  ): CostAndUsageReportIO[DescribeReportDefinitionsResponse] =
    FF.liftF(DescribeReportDefinitionsOp(request))

  def modifyReportDefinition(
    request: ModifyReportDefinitionRequest
  ): CostAndUsageReportIO[ModifyReportDefinitionResponse] =
    FF.liftF(ModifyReportDefinitionOp(request))

  def putReportDefinition(
    request: PutReportDefinitionRequest
  ): CostAndUsageReportIO[PutReportDefinitionResponse] =
    FF.liftF(PutReportDefinitionOp(request))
}
