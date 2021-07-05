package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.mwaa.MwaaClient
import software.amazon.awssdk.services.mwaa.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object mwaa { module =>

  // Free monad over MwaaOp
  type MwaaIO[A] = FF[MwaaOp, A]

  sealed trait MwaaOp[A] {
    def visit[F[_]](visitor: MwaaOp.Visitor[F]): F[A]
  }

  object MwaaOp {
    // Given a MwaaClient we can embed a MwaaIO program in any algebra that understands embedding.
    implicit val MwaaOpEmbeddable: Embeddable[MwaaOp, MwaaClient] = new Embeddable[MwaaOp, MwaaClient] {
      def embed[A](client: MwaaClient, io: MwaaIO[A]): Embedded[A] = Embedded.Mwaa(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MwaaOp.Visitor[Kleisli[M, MwaaClient, *]] {
        def createCliToken(
          request: CreateCliTokenRequest
        ): Kleisli[M, MwaaClient, CreateCliTokenResponse] =
          primitive(_.createCliToken(request))

        def createEnvironment(
          request: CreateEnvironmentRequest
        ): Kleisli[M, MwaaClient, CreateEnvironmentResponse] =
          primitive(_.createEnvironment(request))

        def createWebLoginToken(
          request: CreateWebLoginTokenRequest
        ): Kleisli[M, MwaaClient, CreateWebLoginTokenResponse] =
          primitive(_.createWebLoginToken(request))

        def deleteEnvironment(
          request: DeleteEnvironmentRequest
        ): Kleisli[M, MwaaClient, DeleteEnvironmentResponse] =
          primitive(_.deleteEnvironment(request))

        def getEnvironment(
          request: GetEnvironmentRequest
        ): Kleisli[M, MwaaClient, GetEnvironmentResponse] =
          primitive(_.getEnvironment(request))

        def listEnvironments(
          request: ListEnvironmentsRequest
        ): Kleisli[M, MwaaClient, ListEnvironmentsResponse] =
          primitive(_.listEnvironments(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, MwaaClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def publishMetrics(
          request: PublishMetricsRequest
        ): Kleisli[M, MwaaClient, PublishMetricsResponse] =
          primitive(_.publishMetrics(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, MwaaClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, MwaaClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateEnvironment(
          request: UpdateEnvironmentRequest
        ): Kleisli[M, MwaaClient, UpdateEnvironmentResponse] =
          primitive(_.updateEnvironment(request))

        def primitive[A](
          f: MwaaClient => A
        ): Kleisli[M, MwaaClient, A]
      }
    }

    trait Visitor[F[_]] extends (MwaaOp ~> F) {
      final def apply[A](op: MwaaOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createCliToken(
        request: CreateCliTokenRequest
      ): F[CreateCliTokenResponse]

      def createEnvironment(
        request: CreateEnvironmentRequest
      ): F[CreateEnvironmentResponse]

      def createWebLoginToken(
        request: CreateWebLoginTokenRequest
      ): F[CreateWebLoginTokenResponse]

      def deleteEnvironment(
        request: DeleteEnvironmentRequest
      ): F[DeleteEnvironmentResponse]

      def getEnvironment(
        request: GetEnvironmentRequest
      ): F[GetEnvironmentResponse]

      def listEnvironments(
        request: ListEnvironmentsRequest
      ): F[ListEnvironmentsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def publishMetrics(
        request: PublishMetricsRequest
      ): F[PublishMetricsResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateEnvironment(
        request: UpdateEnvironmentRequest
      ): F[UpdateEnvironmentResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MwaaOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateCliTokenOp(
      request: CreateCliTokenRequest
    ) extends MwaaOp[CreateCliTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCliTokenResponse] =
        visitor.createCliToken(request)
    }

    final case class CreateEnvironmentOp(
      request: CreateEnvironmentRequest
    ) extends MwaaOp[CreateEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEnvironmentResponse] =
        visitor.createEnvironment(request)
    }

    final case class CreateWebLoginTokenOp(
      request: CreateWebLoginTokenRequest
    ) extends MwaaOp[CreateWebLoginTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWebLoginTokenResponse] =
        visitor.createWebLoginToken(request)
    }

    final case class DeleteEnvironmentOp(
      request: DeleteEnvironmentRequest
    ) extends MwaaOp[DeleteEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEnvironmentResponse] =
        visitor.deleteEnvironment(request)
    }

    final case class GetEnvironmentOp(
      request: GetEnvironmentRequest
    ) extends MwaaOp[GetEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEnvironmentResponse] =
        visitor.getEnvironment(request)
    }

    final case class ListEnvironmentsOp(
      request: ListEnvironmentsRequest
    ) extends MwaaOp[ListEnvironmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEnvironmentsResponse] =
        visitor.listEnvironments(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends MwaaOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PublishMetricsOp(
      request: PublishMetricsRequest
    ) extends MwaaOp[PublishMetricsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PublishMetricsResponse] =
        visitor.publishMetrics(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends MwaaOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends MwaaOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateEnvironmentOp(
      request: UpdateEnvironmentRequest
    ) extends MwaaOp[UpdateEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEnvironmentResponse] =
        visitor.updateEnvironment(request)
    }
  }

  import MwaaOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MwaaOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createCliToken(
    request: CreateCliTokenRequest
  ): MwaaIO[CreateCliTokenResponse] =
    FF.liftF(CreateCliTokenOp(request))

  def createEnvironment(
    request: CreateEnvironmentRequest
  ): MwaaIO[CreateEnvironmentResponse] =
    FF.liftF(CreateEnvironmentOp(request))

  def createWebLoginToken(
    request: CreateWebLoginTokenRequest
  ): MwaaIO[CreateWebLoginTokenResponse] =
    FF.liftF(CreateWebLoginTokenOp(request))

  def deleteEnvironment(
    request: DeleteEnvironmentRequest
  ): MwaaIO[DeleteEnvironmentResponse] =
    FF.liftF(DeleteEnvironmentOp(request))

  def getEnvironment(
    request: GetEnvironmentRequest
  ): MwaaIO[GetEnvironmentResponse] =
    FF.liftF(GetEnvironmentOp(request))

  def listEnvironments(
    request: ListEnvironmentsRequest
  ): MwaaIO[ListEnvironmentsResponse] =
    FF.liftF(ListEnvironmentsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): MwaaIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def publishMetrics(
    request: PublishMetricsRequest
  ): MwaaIO[PublishMetricsResponse] =
    FF.liftF(PublishMetricsOp(request))

  def tagResource(
    request: TagResourceRequest
  ): MwaaIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): MwaaIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateEnvironment(
    request: UpdateEnvironmentRequest
  ): MwaaIO[UpdateEnvironmentResponse] =
    FF.liftF(UpdateEnvironmentOp(request))
}
