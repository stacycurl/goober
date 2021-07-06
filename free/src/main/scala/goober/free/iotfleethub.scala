package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.iotfleethub.IoTFleetHubClient
import software.amazon.awssdk.services.iotfleethub.model._


object iotfleethub { module =>

  // Free monad over IoTFleetHubOp
  type IoTFleetHubIO[A] = FF[IoTFleetHubOp, A]

  sealed trait IoTFleetHubOp[A] {
    def visit[F[_]](visitor: IoTFleetHubOp.Visitor[F]): F[A]
  }

  object IoTFleetHubOp {
    // Given a IoTFleetHubClient we can embed a IoTFleetHubIO program in any algebra that understands embedding.
    implicit val IoTFleetHubOpEmbeddable: Embeddable[IoTFleetHubOp, IoTFleetHubClient] = new Embeddable[IoTFleetHubOp, IoTFleetHubClient] {
      def embed[A](client: IoTFleetHubClient, io: IoTFleetHubIO[A]): Embedded[A] = Embedded.IoTFleetHub(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends IoTFleetHubOp.Visitor[Kleisli[M, IoTFleetHubClient, *]] {
        def createApplication(
          request: CreateApplicationRequest
        ): Kleisli[M, IoTFleetHubClient, CreateApplicationResponse] =
          primitive(_.createApplication(request))

        def deleteApplication(
          request: DeleteApplicationRequest
        ): Kleisli[M, IoTFleetHubClient, DeleteApplicationResponse] =
          primitive(_.deleteApplication(request))

        def describeApplication(
          request: DescribeApplicationRequest
        ): Kleisli[M, IoTFleetHubClient, DescribeApplicationResponse] =
          primitive(_.describeApplication(request))

        def listApplications(
          request: ListApplicationsRequest
        ): Kleisli[M, IoTFleetHubClient, ListApplicationsResponse] =
          primitive(_.listApplications(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, IoTFleetHubClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, IoTFleetHubClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, IoTFleetHubClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateApplication(
          request: UpdateApplicationRequest
        ): Kleisli[M, IoTFleetHubClient, UpdateApplicationResponse] =
          primitive(_.updateApplication(request))

        def primitive[A](
          f: IoTFleetHubClient => A
        ): Kleisli[M, IoTFleetHubClient, A]
      }
    }

    trait Visitor[F[_]] extends (IoTFleetHubOp ~> F) {
      final def apply[A](op: IoTFleetHubOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createApplication(
        request: CreateApplicationRequest
      ): F[CreateApplicationResponse]

      def deleteApplication(
        request: DeleteApplicationRequest
      ): F[DeleteApplicationResponse]

      def describeApplication(
        request: DescribeApplicationRequest
      ): F[DescribeApplicationResponse]

      def listApplications(
        request: ListApplicationsRequest
      ): F[ListApplicationsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateApplication(
        request: UpdateApplicationRequest
      ): F[UpdateApplicationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends IoTFleetHubOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateApplicationOp(
      request: CreateApplicationRequest
    ) extends IoTFleetHubOp[CreateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApplicationResponse] =
        visitor.createApplication(request)
    }

    final case class DeleteApplicationOp(
      request: DeleteApplicationRequest
    ) extends IoTFleetHubOp[DeleteApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationResponse] =
        visitor.deleteApplication(request)
    }

    final case class DescribeApplicationOp(
      request: DescribeApplicationRequest
    ) extends IoTFleetHubOp[DescribeApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeApplicationResponse] =
        visitor.describeApplication(request)
    }

    final case class ListApplicationsOp(
      request: ListApplicationsRequest
    ) extends IoTFleetHubOp[ListApplicationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListApplicationsResponse] =
        visitor.listApplications(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends IoTFleetHubOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends IoTFleetHubOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends IoTFleetHubOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateApplicationOp(
      request: UpdateApplicationRequest
    ) extends IoTFleetHubOp[UpdateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApplicationResponse] =
        visitor.updateApplication(request)
    }
  }

  import IoTFleetHubOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[IoTFleetHubOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createApplication(
    request: CreateApplicationRequest
  ): IoTFleetHubIO[CreateApplicationResponse] =
    FF.liftF(CreateApplicationOp(request))

  def deleteApplication(
    request: DeleteApplicationRequest
  ): IoTFleetHubIO[DeleteApplicationResponse] =
    FF.liftF(DeleteApplicationOp(request))

  def describeApplication(
    request: DescribeApplicationRequest
  ): IoTFleetHubIO[DescribeApplicationResponse] =
    FF.liftF(DescribeApplicationOp(request))

  def listApplications(
    request: ListApplicationsRequest
  ): IoTFleetHubIO[ListApplicationsResponse] =
    FF.liftF(ListApplicationsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): IoTFleetHubIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): IoTFleetHubIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): IoTFleetHubIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateApplication(
    request: UpdateApplicationRequest
  ): IoTFleetHubIO[UpdateApplicationResponse] =
    FF.liftF(UpdateApplicationOp(request))
}
