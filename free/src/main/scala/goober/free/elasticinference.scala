package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.elasticinference.ElasticInferenceClient
import software.amazon.awssdk.services.elasticinference.model._


object elasticinference { module =>

  // Free monad over ElasticInferenceOp
  type ElasticInferenceIO[A] = FF[ElasticInferenceOp, A]

  sealed trait ElasticInferenceOp[A] {
    def visit[F[_]](visitor: ElasticInferenceOp.Visitor[F]): F[A]
  }

  object ElasticInferenceOp {
    // Given a ElasticInferenceClient we can embed a ElasticInferenceIO program in any algebra that understands embedding.
    implicit val ElasticInferenceOpEmbeddable: Embeddable[ElasticInferenceOp, ElasticInferenceClient] = new Embeddable[ElasticInferenceOp, ElasticInferenceClient] {
      def embed[A](client: ElasticInferenceClient, io: ElasticInferenceIO[A]): Embedded[A] = Embedded.ElasticInference(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ElasticInferenceOp.Visitor[Kleisli[M, ElasticInferenceClient, *]] {
        def describeAcceleratorOfferings(
          request: DescribeAcceleratorOfferingsRequest
        ): Kleisli[M, ElasticInferenceClient, DescribeAcceleratorOfferingsResponse] =
          primitive(_.describeAcceleratorOfferings(request))

        def describeAcceleratorTypes(
          request: DescribeAcceleratorTypesRequest
        ): Kleisli[M, ElasticInferenceClient, DescribeAcceleratorTypesResponse] =
          primitive(_.describeAcceleratorTypes(request))

        def describeAccelerators(
          request: DescribeAcceleratorsRequest
        ): Kleisli[M, ElasticInferenceClient, DescribeAcceleratorsResponse] =
          primitive(_.describeAccelerators(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, ElasticInferenceClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, ElasticInferenceClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, ElasticInferenceClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: ElasticInferenceClient => A
        ): Kleisli[M, ElasticInferenceClient, A]
      }
    }

    trait Visitor[F[_]] extends (ElasticInferenceOp ~> F) {
      final def apply[A](op: ElasticInferenceOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def describeAcceleratorOfferings(
        request: DescribeAcceleratorOfferingsRequest
      ): F[DescribeAcceleratorOfferingsResponse]

      def describeAcceleratorTypes(
        request: DescribeAcceleratorTypesRequest
      ): F[DescribeAcceleratorTypesResponse]

      def describeAccelerators(
        request: DescribeAcceleratorsRequest
      ): F[DescribeAcceleratorsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ElasticInferenceOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DescribeAcceleratorOfferingsOp(
      request: DescribeAcceleratorOfferingsRequest
    ) extends ElasticInferenceOp[DescribeAcceleratorOfferingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAcceleratorOfferingsResponse] =
        visitor.describeAcceleratorOfferings(request)
    }

    final case class DescribeAcceleratorTypesOp(
      request: DescribeAcceleratorTypesRequest
    ) extends ElasticInferenceOp[DescribeAcceleratorTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAcceleratorTypesResponse] =
        visitor.describeAcceleratorTypes(request)
    }

    final case class DescribeAcceleratorsOp(
      request: DescribeAcceleratorsRequest
    ) extends ElasticInferenceOp[DescribeAcceleratorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAcceleratorsResponse] =
        visitor.describeAccelerators(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends ElasticInferenceOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends ElasticInferenceOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends ElasticInferenceOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import ElasticInferenceOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ElasticInferenceOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def describeAcceleratorOfferings(
    request: DescribeAcceleratorOfferingsRequest
  ): ElasticInferenceIO[DescribeAcceleratorOfferingsResponse] =
    FF.liftF(DescribeAcceleratorOfferingsOp(request))

  def describeAcceleratorTypes(
    request: DescribeAcceleratorTypesRequest
  ): ElasticInferenceIO[DescribeAcceleratorTypesResponse] =
    FF.liftF(DescribeAcceleratorTypesOp(request))

  def describeAccelerators(
    request: DescribeAcceleratorsRequest
  ): ElasticInferenceIO[DescribeAcceleratorsResponse] =
    FF.liftF(DescribeAcceleratorsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): ElasticInferenceIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): ElasticInferenceIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): ElasticInferenceIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
