package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.migrationhubconfig.MigrationHubConfigClient
import software.amazon.awssdk.services.migrationhubconfig.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object migrationhubconfig { module =>

  // Free monad over MigrationHubConfigOp
  type MigrationHubConfigIO[A] = FF[MigrationHubConfigOp, A]

  sealed trait MigrationHubConfigOp[A] {
    def visit[F[_]](visitor: MigrationHubConfigOp.Visitor[F]): F[A]
  }

  object MigrationHubConfigOp {
    // Given a MigrationHubConfigClient we can embed a MigrationHubConfigIO program in any algebra that understands embedding.
    implicit val MigrationHubConfigOpEmbeddable: Embeddable[MigrationHubConfigOp, MigrationHubConfigClient] = new Embeddable[MigrationHubConfigOp, MigrationHubConfigClient] {
      def embed[A](client: MigrationHubConfigClient, io: MigrationHubConfigIO[A]): Embedded[A] = Embedded.MigrationHubConfig(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MigrationHubConfigOp.Visitor[Kleisli[M, MigrationHubConfigClient, *]] {
        def createHomeRegionControl(
          request: CreateHomeRegionControlRequest
        ): Kleisli[M, MigrationHubConfigClient, CreateHomeRegionControlResponse] =
          primitive(_.createHomeRegionControl(request))

        def describeHomeRegionControls(
          request: DescribeHomeRegionControlsRequest
        ): Kleisli[M, MigrationHubConfigClient, DescribeHomeRegionControlsResponse] =
          primitive(_.describeHomeRegionControls(request))

        def getHomeRegion(
          request: GetHomeRegionRequest
        ): Kleisli[M, MigrationHubConfigClient, GetHomeRegionResponse] =
          primitive(_.getHomeRegion(request))

        def primitive[A](
          f: MigrationHubConfigClient => A
        ): Kleisli[M, MigrationHubConfigClient, A]
      }
    }

    trait Visitor[F[_]] extends (MigrationHubConfigOp ~> F) {
      final def apply[A](op: MigrationHubConfigOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createHomeRegionControl(
        request: CreateHomeRegionControlRequest
      ): F[CreateHomeRegionControlResponse]

      def describeHomeRegionControls(
        request: DescribeHomeRegionControlsRequest
      ): F[DescribeHomeRegionControlsResponse]

      def getHomeRegion(
        request: GetHomeRegionRequest
      ): F[GetHomeRegionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MigrationHubConfigOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateHomeRegionControlOp(
      request: CreateHomeRegionControlRequest
    ) extends MigrationHubConfigOp[CreateHomeRegionControlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateHomeRegionControlResponse] =
        visitor.createHomeRegionControl(request)
    }

    final case class DescribeHomeRegionControlsOp(
      request: DescribeHomeRegionControlsRequest
    ) extends MigrationHubConfigOp[DescribeHomeRegionControlsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeHomeRegionControlsResponse] =
        visitor.describeHomeRegionControls(request)
    }

    final case class GetHomeRegionOp(
      request: GetHomeRegionRequest
    ) extends MigrationHubConfigOp[GetHomeRegionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetHomeRegionResponse] =
        visitor.getHomeRegion(request)
    }
  }

  import MigrationHubConfigOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MigrationHubConfigOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createHomeRegionControl(
    request: CreateHomeRegionControlRequest
  ): MigrationHubConfigIO[CreateHomeRegionControlResponse] =
    FF.liftF(CreateHomeRegionControlOp(request))

  def describeHomeRegionControls(
    request: DescribeHomeRegionControlsRequest
  ): MigrationHubConfigIO[DescribeHomeRegionControlsResponse] =
    FF.liftF(DescribeHomeRegionControlsOp(request))

  def getHomeRegion(
    request: GetHomeRegionRequest
  ): MigrationHubConfigIO[GetHomeRegionResponse] =
    FF.liftF(GetHomeRegionOp(request))
}
