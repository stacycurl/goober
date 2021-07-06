package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.synthetics.SyntheticsClient
import software.amazon.awssdk.services.synthetics.model._


object synthetics { module =>

  // Free monad over SyntheticsOp
  type SyntheticsIO[A] = FF[SyntheticsOp, A]

  sealed trait SyntheticsOp[A] {
    def visit[F[_]](visitor: SyntheticsOp.Visitor[F]): F[A]
  }

  object SyntheticsOp {
    // Given a SyntheticsClient we can embed a SyntheticsIO program in any algebra that understands embedding.
    implicit val SyntheticsOpEmbeddable: Embeddable[SyntheticsOp, SyntheticsClient] = new Embeddable[SyntheticsOp, SyntheticsClient] {
      def embed[A](client: SyntheticsClient, io: SyntheticsIO[A]): Embedded[A] = Embedded.Synthetics(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SyntheticsOp.Visitor[Kleisli[M, SyntheticsClient, *]] {
        def createCanary(
          request: CreateCanaryRequest
        ): Kleisli[M, SyntheticsClient, CreateCanaryResponse] =
          primitive(_.createCanary(request))

        def deleteCanary(
          request: DeleteCanaryRequest
        ): Kleisli[M, SyntheticsClient, DeleteCanaryResponse] =
          primitive(_.deleteCanary(request))

        def describeCanaries(
          request: DescribeCanariesRequest
        ): Kleisli[M, SyntheticsClient, DescribeCanariesResponse] =
          primitive(_.describeCanaries(request))

        def describeCanariesLastRun(
          request: DescribeCanariesLastRunRequest
        ): Kleisli[M, SyntheticsClient, DescribeCanariesLastRunResponse] =
          primitive(_.describeCanariesLastRun(request))

        def describeRuntimeVersions(
          request: DescribeRuntimeVersionsRequest
        ): Kleisli[M, SyntheticsClient, DescribeRuntimeVersionsResponse] =
          primitive(_.describeRuntimeVersions(request))

        def getCanary(
          request: GetCanaryRequest
        ): Kleisli[M, SyntheticsClient, GetCanaryResponse] =
          primitive(_.getCanary(request))

        def getCanaryRuns(
          request: GetCanaryRunsRequest
        ): Kleisli[M, SyntheticsClient, GetCanaryRunsResponse] =
          primitive(_.getCanaryRuns(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, SyntheticsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def startCanary(
          request: StartCanaryRequest
        ): Kleisli[M, SyntheticsClient, StartCanaryResponse] =
          primitive(_.startCanary(request))

        def stopCanary(
          request: StopCanaryRequest
        ): Kleisli[M, SyntheticsClient, StopCanaryResponse] =
          primitive(_.stopCanary(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, SyntheticsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, SyntheticsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateCanary(
          request: UpdateCanaryRequest
        ): Kleisli[M, SyntheticsClient, UpdateCanaryResponse] =
          primitive(_.updateCanary(request))

        def primitive[A](
          f: SyntheticsClient => A
        ): Kleisli[M, SyntheticsClient, A]
      }
    }

    trait Visitor[F[_]] extends (SyntheticsOp ~> F) {
      final def apply[A](op: SyntheticsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createCanary(
        request: CreateCanaryRequest
      ): F[CreateCanaryResponse]

      def deleteCanary(
        request: DeleteCanaryRequest
      ): F[DeleteCanaryResponse]

      def describeCanaries(
        request: DescribeCanariesRequest
      ): F[DescribeCanariesResponse]

      def describeCanariesLastRun(
        request: DescribeCanariesLastRunRequest
      ): F[DescribeCanariesLastRunResponse]

      def describeRuntimeVersions(
        request: DescribeRuntimeVersionsRequest
      ): F[DescribeRuntimeVersionsResponse]

      def getCanary(
        request: GetCanaryRequest
      ): F[GetCanaryResponse]

      def getCanaryRuns(
        request: GetCanaryRunsRequest
      ): F[GetCanaryRunsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def startCanary(
        request: StartCanaryRequest
      ): F[StartCanaryResponse]

      def stopCanary(
        request: StopCanaryRequest
      ): F[StopCanaryResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateCanary(
        request: UpdateCanaryRequest
      ): F[UpdateCanaryResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SyntheticsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateCanaryOp(
      request: CreateCanaryRequest
    ) extends SyntheticsOp[CreateCanaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCanaryResponse] =
        visitor.createCanary(request)
    }

    final case class DeleteCanaryOp(
      request: DeleteCanaryRequest
    ) extends SyntheticsOp[DeleteCanaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCanaryResponse] =
        visitor.deleteCanary(request)
    }

    final case class DescribeCanariesOp(
      request: DescribeCanariesRequest
    ) extends SyntheticsOp[DescribeCanariesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCanariesResponse] =
        visitor.describeCanaries(request)
    }

    final case class DescribeCanariesLastRunOp(
      request: DescribeCanariesLastRunRequest
    ) extends SyntheticsOp[DescribeCanariesLastRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCanariesLastRunResponse] =
        visitor.describeCanariesLastRun(request)
    }

    final case class DescribeRuntimeVersionsOp(
      request: DescribeRuntimeVersionsRequest
    ) extends SyntheticsOp[DescribeRuntimeVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRuntimeVersionsResponse] =
        visitor.describeRuntimeVersions(request)
    }

    final case class GetCanaryOp(
      request: GetCanaryRequest
    ) extends SyntheticsOp[GetCanaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCanaryResponse] =
        visitor.getCanary(request)
    }

    final case class GetCanaryRunsOp(
      request: GetCanaryRunsRequest
    ) extends SyntheticsOp[GetCanaryRunsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCanaryRunsResponse] =
        visitor.getCanaryRuns(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends SyntheticsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class StartCanaryOp(
      request: StartCanaryRequest
    ) extends SyntheticsOp[StartCanaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartCanaryResponse] =
        visitor.startCanary(request)
    }

    final case class StopCanaryOp(
      request: StopCanaryRequest
    ) extends SyntheticsOp[StopCanaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopCanaryResponse] =
        visitor.stopCanary(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends SyntheticsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends SyntheticsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateCanaryOp(
      request: UpdateCanaryRequest
    ) extends SyntheticsOp[UpdateCanaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCanaryResponse] =
        visitor.updateCanary(request)
    }
  }

  import SyntheticsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SyntheticsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createCanary(
    request: CreateCanaryRequest
  ): SyntheticsIO[CreateCanaryResponse] =
    FF.liftF(CreateCanaryOp(request))

  def deleteCanary(
    request: DeleteCanaryRequest
  ): SyntheticsIO[DeleteCanaryResponse] =
    FF.liftF(DeleteCanaryOp(request))

  def describeCanaries(
    request: DescribeCanariesRequest
  ): SyntheticsIO[DescribeCanariesResponse] =
    FF.liftF(DescribeCanariesOp(request))

  def describeCanariesLastRun(
    request: DescribeCanariesLastRunRequest
  ): SyntheticsIO[DescribeCanariesLastRunResponse] =
    FF.liftF(DescribeCanariesLastRunOp(request))

  def describeRuntimeVersions(
    request: DescribeRuntimeVersionsRequest
  ): SyntheticsIO[DescribeRuntimeVersionsResponse] =
    FF.liftF(DescribeRuntimeVersionsOp(request))

  def getCanary(
    request: GetCanaryRequest
  ): SyntheticsIO[GetCanaryResponse] =
    FF.liftF(GetCanaryOp(request))

  def getCanaryRuns(
    request: GetCanaryRunsRequest
  ): SyntheticsIO[GetCanaryRunsResponse] =
    FF.liftF(GetCanaryRunsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): SyntheticsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def startCanary(
    request: StartCanaryRequest
  ): SyntheticsIO[StartCanaryResponse] =
    FF.liftF(StartCanaryOp(request))

  def stopCanary(
    request: StopCanaryRequest
  ): SyntheticsIO[StopCanaryResponse] =
    FF.liftF(StopCanaryOp(request))

  def tagResource(
    request: TagResourceRequest
  ): SyntheticsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): SyntheticsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateCanary(
    request: UpdateCanaryRequest
  ): SyntheticsIO[UpdateCanaryResponse] =
    FF.liftF(UpdateCanaryOp(request))
}
