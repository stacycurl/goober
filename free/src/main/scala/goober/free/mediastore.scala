package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.mediastore.MediaStoreClient
import software.amazon.awssdk.services.mediastore.model._


object mediastore { module =>

  // Free monad over MediaStoreOp
  type MediaStoreIO[A] = FF[MediaStoreOp, A]

  sealed trait MediaStoreOp[A] {
    def visit[F[_]](visitor: MediaStoreOp.Visitor[F]): F[A]
  }

  object MediaStoreOp {
    // Given a MediaStoreClient we can embed a MediaStoreIO program in any algebra that understands embedding.
    implicit val MediaStoreOpEmbeddable: Embeddable[MediaStoreOp, MediaStoreClient] = new Embeddable[MediaStoreOp, MediaStoreClient] {
      def embed[A](client: MediaStoreClient, io: MediaStoreIO[A]): Embedded[A] = Embedded.MediaStore(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MediaStoreOp.Visitor[Kleisli[M, MediaStoreClient, *]] {
        def createContainer(
          request: CreateContainerRequest
        ): Kleisli[M, MediaStoreClient, CreateContainerResponse] =
          primitive(_.createContainer(request))

        def deleteContainer(
          request: DeleteContainerRequest
        ): Kleisli[M, MediaStoreClient, DeleteContainerResponse] =
          primitive(_.deleteContainer(request))

        def deleteContainerPolicy(
          request: DeleteContainerPolicyRequest
        ): Kleisli[M, MediaStoreClient, DeleteContainerPolicyResponse] =
          primitive(_.deleteContainerPolicy(request))

        def deleteCorsPolicy(
          request: DeleteCorsPolicyRequest
        ): Kleisli[M, MediaStoreClient, DeleteCorsPolicyResponse] =
          primitive(_.deleteCorsPolicy(request))

        def deleteLifecyclePolicy(
          request: DeleteLifecyclePolicyRequest
        ): Kleisli[M, MediaStoreClient, DeleteLifecyclePolicyResponse] =
          primitive(_.deleteLifecyclePolicy(request))

        def deleteMetricPolicy(
          request: DeleteMetricPolicyRequest
        ): Kleisli[M, MediaStoreClient, DeleteMetricPolicyResponse] =
          primitive(_.deleteMetricPolicy(request))

        def describeContainer(
          request: DescribeContainerRequest
        ): Kleisli[M, MediaStoreClient, DescribeContainerResponse] =
          primitive(_.describeContainer(request))

        def getContainerPolicy(
          request: GetContainerPolicyRequest
        ): Kleisli[M, MediaStoreClient, GetContainerPolicyResponse] =
          primitive(_.getContainerPolicy(request))

        def getCorsPolicy(
          request: GetCorsPolicyRequest
        ): Kleisli[M, MediaStoreClient, GetCorsPolicyResponse] =
          primitive(_.getCorsPolicy(request))

        def getLifecyclePolicy(
          request: GetLifecyclePolicyRequest
        ): Kleisli[M, MediaStoreClient, GetLifecyclePolicyResponse] =
          primitive(_.getLifecyclePolicy(request))

        def getMetricPolicy(
          request: GetMetricPolicyRequest
        ): Kleisli[M, MediaStoreClient, GetMetricPolicyResponse] =
          primitive(_.getMetricPolicy(request))

        def listContainers(
          request: ListContainersRequest
        ): Kleisli[M, MediaStoreClient, ListContainersResponse] =
          primitive(_.listContainers(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, MediaStoreClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putContainerPolicy(
          request: PutContainerPolicyRequest
        ): Kleisli[M, MediaStoreClient, PutContainerPolicyResponse] =
          primitive(_.putContainerPolicy(request))

        def putCorsPolicy(
          request: PutCorsPolicyRequest
        ): Kleisli[M, MediaStoreClient, PutCorsPolicyResponse] =
          primitive(_.putCorsPolicy(request))

        def putLifecyclePolicy(
          request: PutLifecyclePolicyRequest
        ): Kleisli[M, MediaStoreClient, PutLifecyclePolicyResponse] =
          primitive(_.putLifecyclePolicy(request))

        def putMetricPolicy(
          request: PutMetricPolicyRequest
        ): Kleisli[M, MediaStoreClient, PutMetricPolicyResponse] =
          primitive(_.putMetricPolicy(request))

        def startAccessLogging(
          request: StartAccessLoggingRequest
        ): Kleisli[M, MediaStoreClient, StartAccessLoggingResponse] =
          primitive(_.startAccessLogging(request))

        def stopAccessLogging(
          request: StopAccessLoggingRequest
        ): Kleisli[M, MediaStoreClient, StopAccessLoggingResponse] =
          primitive(_.stopAccessLogging(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, MediaStoreClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, MediaStoreClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: MediaStoreClient => A
        ): Kleisli[M, MediaStoreClient, A]
      }
    }

    trait Visitor[F[_]] extends (MediaStoreOp ~> F) {
      final def apply[A](op: MediaStoreOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createContainer(
        request: CreateContainerRequest
      ): F[CreateContainerResponse]

      def deleteContainer(
        request: DeleteContainerRequest
      ): F[DeleteContainerResponse]

      def deleteContainerPolicy(
        request: DeleteContainerPolicyRequest
      ): F[DeleteContainerPolicyResponse]

      def deleteCorsPolicy(
        request: DeleteCorsPolicyRequest
      ): F[DeleteCorsPolicyResponse]

      def deleteLifecyclePolicy(
        request: DeleteLifecyclePolicyRequest
      ): F[DeleteLifecyclePolicyResponse]

      def deleteMetricPolicy(
        request: DeleteMetricPolicyRequest
      ): F[DeleteMetricPolicyResponse]

      def describeContainer(
        request: DescribeContainerRequest
      ): F[DescribeContainerResponse]

      def getContainerPolicy(
        request: GetContainerPolicyRequest
      ): F[GetContainerPolicyResponse]

      def getCorsPolicy(
        request: GetCorsPolicyRequest
      ): F[GetCorsPolicyResponse]

      def getLifecyclePolicy(
        request: GetLifecyclePolicyRequest
      ): F[GetLifecyclePolicyResponse]

      def getMetricPolicy(
        request: GetMetricPolicyRequest
      ): F[GetMetricPolicyResponse]

      def listContainers(
        request: ListContainersRequest
      ): F[ListContainersResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putContainerPolicy(
        request: PutContainerPolicyRequest
      ): F[PutContainerPolicyResponse]

      def putCorsPolicy(
        request: PutCorsPolicyRequest
      ): F[PutCorsPolicyResponse]

      def putLifecyclePolicy(
        request: PutLifecyclePolicyRequest
      ): F[PutLifecyclePolicyResponse]

      def putMetricPolicy(
        request: PutMetricPolicyRequest
      ): F[PutMetricPolicyResponse]

      def startAccessLogging(
        request: StartAccessLoggingRequest
      ): F[StartAccessLoggingResponse]

      def stopAccessLogging(
        request: StopAccessLoggingRequest
      ): F[StopAccessLoggingResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MediaStoreOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateContainerOp(
      request: CreateContainerRequest
    ) extends MediaStoreOp[CreateContainerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateContainerResponse] =
        visitor.createContainer(request)
    }

    final case class DeleteContainerOp(
      request: DeleteContainerRequest
    ) extends MediaStoreOp[DeleteContainerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteContainerResponse] =
        visitor.deleteContainer(request)
    }

    final case class DeleteContainerPolicyOp(
      request: DeleteContainerPolicyRequest
    ) extends MediaStoreOp[DeleteContainerPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteContainerPolicyResponse] =
        visitor.deleteContainerPolicy(request)
    }

    final case class DeleteCorsPolicyOp(
      request: DeleteCorsPolicyRequest
    ) extends MediaStoreOp[DeleteCorsPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCorsPolicyResponse] =
        visitor.deleteCorsPolicy(request)
    }

    final case class DeleteLifecyclePolicyOp(
      request: DeleteLifecyclePolicyRequest
    ) extends MediaStoreOp[DeleteLifecyclePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLifecyclePolicyResponse] =
        visitor.deleteLifecyclePolicy(request)
    }

    final case class DeleteMetricPolicyOp(
      request: DeleteMetricPolicyRequest
    ) extends MediaStoreOp[DeleteMetricPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMetricPolicyResponse] =
        visitor.deleteMetricPolicy(request)
    }

    final case class DescribeContainerOp(
      request: DescribeContainerRequest
    ) extends MediaStoreOp[DescribeContainerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeContainerResponse] =
        visitor.describeContainer(request)
    }

    final case class GetContainerPolicyOp(
      request: GetContainerPolicyRequest
    ) extends MediaStoreOp[GetContainerPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContainerPolicyResponse] =
        visitor.getContainerPolicy(request)
    }

    final case class GetCorsPolicyOp(
      request: GetCorsPolicyRequest
    ) extends MediaStoreOp[GetCorsPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCorsPolicyResponse] =
        visitor.getCorsPolicy(request)
    }

    final case class GetLifecyclePolicyOp(
      request: GetLifecyclePolicyRequest
    ) extends MediaStoreOp[GetLifecyclePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLifecyclePolicyResponse] =
        visitor.getLifecyclePolicy(request)
    }

    final case class GetMetricPolicyOp(
      request: GetMetricPolicyRequest
    ) extends MediaStoreOp[GetMetricPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMetricPolicyResponse] =
        visitor.getMetricPolicy(request)
    }

    final case class ListContainersOp(
      request: ListContainersRequest
    ) extends MediaStoreOp[ListContainersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListContainersResponse] =
        visitor.listContainers(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends MediaStoreOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutContainerPolicyOp(
      request: PutContainerPolicyRequest
    ) extends MediaStoreOp[PutContainerPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutContainerPolicyResponse] =
        visitor.putContainerPolicy(request)
    }

    final case class PutCorsPolicyOp(
      request: PutCorsPolicyRequest
    ) extends MediaStoreOp[PutCorsPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutCorsPolicyResponse] =
        visitor.putCorsPolicy(request)
    }

    final case class PutLifecyclePolicyOp(
      request: PutLifecyclePolicyRequest
    ) extends MediaStoreOp[PutLifecyclePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutLifecyclePolicyResponse] =
        visitor.putLifecyclePolicy(request)
    }

    final case class PutMetricPolicyOp(
      request: PutMetricPolicyRequest
    ) extends MediaStoreOp[PutMetricPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutMetricPolicyResponse] =
        visitor.putMetricPolicy(request)
    }

    final case class StartAccessLoggingOp(
      request: StartAccessLoggingRequest
    ) extends MediaStoreOp[StartAccessLoggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartAccessLoggingResponse] =
        visitor.startAccessLogging(request)
    }

    final case class StopAccessLoggingOp(
      request: StopAccessLoggingRequest
    ) extends MediaStoreOp[StopAccessLoggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopAccessLoggingResponse] =
        visitor.stopAccessLogging(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends MediaStoreOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends MediaStoreOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import MediaStoreOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MediaStoreOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createContainer(
    request: CreateContainerRequest
  ): MediaStoreIO[CreateContainerResponse] =
    FF.liftF(CreateContainerOp(request))

  def deleteContainer(
    request: DeleteContainerRequest
  ): MediaStoreIO[DeleteContainerResponse] =
    FF.liftF(DeleteContainerOp(request))

  def deleteContainerPolicy(
    request: DeleteContainerPolicyRequest
  ): MediaStoreIO[DeleteContainerPolicyResponse] =
    FF.liftF(DeleteContainerPolicyOp(request))

  def deleteCorsPolicy(
    request: DeleteCorsPolicyRequest
  ): MediaStoreIO[DeleteCorsPolicyResponse] =
    FF.liftF(DeleteCorsPolicyOp(request))

  def deleteLifecyclePolicy(
    request: DeleteLifecyclePolicyRequest
  ): MediaStoreIO[DeleteLifecyclePolicyResponse] =
    FF.liftF(DeleteLifecyclePolicyOp(request))

  def deleteMetricPolicy(
    request: DeleteMetricPolicyRequest
  ): MediaStoreIO[DeleteMetricPolicyResponse] =
    FF.liftF(DeleteMetricPolicyOp(request))

  def describeContainer(
    request: DescribeContainerRequest
  ): MediaStoreIO[DescribeContainerResponse] =
    FF.liftF(DescribeContainerOp(request))

  def getContainerPolicy(
    request: GetContainerPolicyRequest
  ): MediaStoreIO[GetContainerPolicyResponse] =
    FF.liftF(GetContainerPolicyOp(request))

  def getCorsPolicy(
    request: GetCorsPolicyRequest
  ): MediaStoreIO[GetCorsPolicyResponse] =
    FF.liftF(GetCorsPolicyOp(request))

  def getLifecyclePolicy(
    request: GetLifecyclePolicyRequest
  ): MediaStoreIO[GetLifecyclePolicyResponse] =
    FF.liftF(GetLifecyclePolicyOp(request))

  def getMetricPolicy(
    request: GetMetricPolicyRequest
  ): MediaStoreIO[GetMetricPolicyResponse] =
    FF.liftF(GetMetricPolicyOp(request))

  def listContainers(
    request: ListContainersRequest
  ): MediaStoreIO[ListContainersResponse] =
    FF.liftF(ListContainersOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): MediaStoreIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putContainerPolicy(
    request: PutContainerPolicyRequest
  ): MediaStoreIO[PutContainerPolicyResponse] =
    FF.liftF(PutContainerPolicyOp(request))

  def putCorsPolicy(
    request: PutCorsPolicyRequest
  ): MediaStoreIO[PutCorsPolicyResponse] =
    FF.liftF(PutCorsPolicyOp(request))

  def putLifecyclePolicy(
    request: PutLifecyclePolicyRequest
  ): MediaStoreIO[PutLifecyclePolicyResponse] =
    FF.liftF(PutLifecyclePolicyOp(request))

  def putMetricPolicy(
    request: PutMetricPolicyRequest
  ): MediaStoreIO[PutMetricPolicyResponse] =
    FF.liftF(PutMetricPolicyOp(request))

  def startAccessLogging(
    request: StartAccessLoggingRequest
  ): MediaStoreIO[StartAccessLoggingResponse] =
    FF.liftF(StartAccessLoggingOp(request))

  def stopAccessLogging(
    request: StopAccessLoggingRequest
  ): MediaStoreIO[StopAccessLoggingResponse] =
    FF.liftF(StopAccessLoggingOp(request))

  def tagResource(
    request: TagResourceRequest
  ): MediaStoreIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): MediaStoreIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
