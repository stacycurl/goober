package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.mediapackage.MediaPackageClient
import software.amazon.awssdk.services.mediapackage.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object mediapackage { module =>

  // Free monad over MediaPackageOp
  type MediaPackageIO[A] = FF[MediaPackageOp, A]

  sealed trait MediaPackageOp[A] {
    def visit[F[_]](visitor: MediaPackageOp.Visitor[F]): F[A]
  }

  object MediaPackageOp {
    // Given a MediaPackageClient we can embed a MediaPackageIO program in any algebra that understands embedding.
    implicit val MediaPackageOpEmbeddable: Embeddable[MediaPackageOp, MediaPackageClient] = new Embeddable[MediaPackageOp, MediaPackageClient] {
      def embed[A](client: MediaPackageClient, io: MediaPackageIO[A]): Embedded[A] = Embedded.MediaPackage(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MediaPackageOp.Visitor[Kleisli[M, MediaPackageClient, *]] {
        def configureLogs(
          request: ConfigureLogsRequest
        ): Kleisli[M, MediaPackageClient, ConfigureLogsResponse] =
          primitive(_.configureLogs(request))

        def createChannel(
          request: CreateChannelRequest
        ): Kleisli[M, MediaPackageClient, CreateChannelResponse] =
          primitive(_.createChannel(request))

        def createHarvestJob(
          request: CreateHarvestJobRequest
        ): Kleisli[M, MediaPackageClient, CreateHarvestJobResponse] =
          primitive(_.createHarvestJob(request))

        def createOriginEndpoint(
          request: CreateOriginEndpointRequest
        ): Kleisli[M, MediaPackageClient, CreateOriginEndpointResponse] =
          primitive(_.createOriginEndpoint(request))

        def deleteChannel(
          request: DeleteChannelRequest
        ): Kleisli[M, MediaPackageClient, DeleteChannelResponse] =
          primitive(_.deleteChannel(request))

        def deleteOriginEndpoint(
          request: DeleteOriginEndpointRequest
        ): Kleisli[M, MediaPackageClient, DeleteOriginEndpointResponse] =
          primitive(_.deleteOriginEndpoint(request))

        def describeChannel(
          request: DescribeChannelRequest
        ): Kleisli[M, MediaPackageClient, DescribeChannelResponse] =
          primitive(_.describeChannel(request))

        def describeHarvestJob(
          request: DescribeHarvestJobRequest
        ): Kleisli[M, MediaPackageClient, DescribeHarvestJobResponse] =
          primitive(_.describeHarvestJob(request))

        def describeOriginEndpoint(
          request: DescribeOriginEndpointRequest
        ): Kleisli[M, MediaPackageClient, DescribeOriginEndpointResponse] =
          primitive(_.describeOriginEndpoint(request))

        def listChannels(
          request: ListChannelsRequest
        ): Kleisli[M, MediaPackageClient, ListChannelsResponse] =
          primitive(_.listChannels(request))

        def listHarvestJobs(
          request: ListHarvestJobsRequest
        ): Kleisli[M, MediaPackageClient, ListHarvestJobsResponse] =
          primitive(_.listHarvestJobs(request))

        def listOriginEndpoints(
          request: ListOriginEndpointsRequest
        ): Kleisli[M, MediaPackageClient, ListOriginEndpointsResponse] =
          primitive(_.listOriginEndpoints(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, MediaPackageClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def rotateIngestEndpointCredentials(
          request: RotateIngestEndpointCredentialsRequest
        ): Kleisli[M, MediaPackageClient, RotateIngestEndpointCredentialsResponse] =
          primitive(_.rotateIngestEndpointCredentials(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, MediaPackageClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, MediaPackageClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateChannel(
          request: UpdateChannelRequest
        ): Kleisli[M, MediaPackageClient, UpdateChannelResponse] =
          primitive(_.updateChannel(request))

        def updateOriginEndpoint(
          request: UpdateOriginEndpointRequest
        ): Kleisli[M, MediaPackageClient, UpdateOriginEndpointResponse] =
          primitive(_.updateOriginEndpoint(request))

        def primitive[A](
          f: MediaPackageClient => A
        ): Kleisli[M, MediaPackageClient, A]
      }
    }

    trait Visitor[F[_]] extends (MediaPackageOp ~> F) {
      final def apply[A](op: MediaPackageOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def configureLogs(
        request: ConfigureLogsRequest
      ): F[ConfigureLogsResponse]

      def createChannel(
        request: CreateChannelRequest
      ): F[CreateChannelResponse]

      def createHarvestJob(
        request: CreateHarvestJobRequest
      ): F[CreateHarvestJobResponse]

      def createOriginEndpoint(
        request: CreateOriginEndpointRequest
      ): F[CreateOriginEndpointResponse]

      def deleteChannel(
        request: DeleteChannelRequest
      ): F[DeleteChannelResponse]

      def deleteOriginEndpoint(
        request: DeleteOriginEndpointRequest
      ): F[DeleteOriginEndpointResponse]

      def describeChannel(
        request: DescribeChannelRequest
      ): F[DescribeChannelResponse]

      def describeHarvestJob(
        request: DescribeHarvestJobRequest
      ): F[DescribeHarvestJobResponse]

      def describeOriginEndpoint(
        request: DescribeOriginEndpointRequest
      ): F[DescribeOriginEndpointResponse]

      def listChannels(
        request: ListChannelsRequest
      ): F[ListChannelsResponse]

      def listHarvestJobs(
        request: ListHarvestJobsRequest
      ): F[ListHarvestJobsResponse]

      def listOriginEndpoints(
        request: ListOriginEndpointsRequest
      ): F[ListOriginEndpointsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def rotateIngestEndpointCredentials(
        request: RotateIngestEndpointCredentialsRequest
      ): F[RotateIngestEndpointCredentialsResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateChannel(
        request: UpdateChannelRequest
      ): F[UpdateChannelResponse]

      def updateOriginEndpoint(
        request: UpdateOriginEndpointRequest
      ): F[UpdateOriginEndpointResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MediaPackageOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class ConfigureLogsOp(
      request: ConfigureLogsRequest
    ) extends MediaPackageOp[ConfigureLogsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ConfigureLogsResponse] =
        visitor.configureLogs(request)
    }

    final case class CreateChannelOp(
      request: CreateChannelRequest
    ) extends MediaPackageOp[CreateChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateChannelResponse] =
        visitor.createChannel(request)
    }

    final case class CreateHarvestJobOp(
      request: CreateHarvestJobRequest
    ) extends MediaPackageOp[CreateHarvestJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateHarvestJobResponse] =
        visitor.createHarvestJob(request)
    }

    final case class CreateOriginEndpointOp(
      request: CreateOriginEndpointRequest
    ) extends MediaPackageOp[CreateOriginEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateOriginEndpointResponse] =
        visitor.createOriginEndpoint(request)
    }

    final case class DeleteChannelOp(
      request: DeleteChannelRequest
    ) extends MediaPackageOp[DeleteChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteChannelResponse] =
        visitor.deleteChannel(request)
    }

    final case class DeleteOriginEndpointOp(
      request: DeleteOriginEndpointRequest
    ) extends MediaPackageOp[DeleteOriginEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteOriginEndpointResponse] =
        visitor.deleteOriginEndpoint(request)
    }

    final case class DescribeChannelOp(
      request: DescribeChannelRequest
    ) extends MediaPackageOp[DescribeChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeChannelResponse] =
        visitor.describeChannel(request)
    }

    final case class DescribeHarvestJobOp(
      request: DescribeHarvestJobRequest
    ) extends MediaPackageOp[DescribeHarvestJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeHarvestJobResponse] =
        visitor.describeHarvestJob(request)
    }

    final case class DescribeOriginEndpointOp(
      request: DescribeOriginEndpointRequest
    ) extends MediaPackageOp[DescribeOriginEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOriginEndpointResponse] =
        visitor.describeOriginEndpoint(request)
    }

    final case class ListChannelsOp(
      request: ListChannelsRequest
    ) extends MediaPackageOp[ListChannelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListChannelsResponse] =
        visitor.listChannels(request)
    }

    final case class ListHarvestJobsOp(
      request: ListHarvestJobsRequest
    ) extends MediaPackageOp[ListHarvestJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListHarvestJobsResponse] =
        visitor.listHarvestJobs(request)
    }

    final case class ListOriginEndpointsOp(
      request: ListOriginEndpointsRequest
    ) extends MediaPackageOp[ListOriginEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOriginEndpointsResponse] =
        visitor.listOriginEndpoints(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends MediaPackageOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class RotateIngestEndpointCredentialsOp(
      request: RotateIngestEndpointCredentialsRequest
    ) extends MediaPackageOp[RotateIngestEndpointCredentialsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RotateIngestEndpointCredentialsResponse] =
        visitor.rotateIngestEndpointCredentials(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends MediaPackageOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends MediaPackageOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateChannelOp(
      request: UpdateChannelRequest
    ) extends MediaPackageOp[UpdateChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateChannelResponse] =
        visitor.updateChannel(request)
    }

    final case class UpdateOriginEndpointOp(
      request: UpdateOriginEndpointRequest
    ) extends MediaPackageOp[UpdateOriginEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateOriginEndpointResponse] =
        visitor.updateOriginEndpoint(request)
    }
  }

  import MediaPackageOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MediaPackageOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def configureLogs(
    request: ConfigureLogsRequest
  ): MediaPackageIO[ConfigureLogsResponse] =
    FF.liftF(ConfigureLogsOp(request))

  def createChannel(
    request: CreateChannelRequest
  ): MediaPackageIO[CreateChannelResponse] =
    FF.liftF(CreateChannelOp(request))

  def createHarvestJob(
    request: CreateHarvestJobRequest
  ): MediaPackageIO[CreateHarvestJobResponse] =
    FF.liftF(CreateHarvestJobOp(request))

  def createOriginEndpoint(
    request: CreateOriginEndpointRequest
  ): MediaPackageIO[CreateOriginEndpointResponse] =
    FF.liftF(CreateOriginEndpointOp(request))

  def deleteChannel(
    request: DeleteChannelRequest
  ): MediaPackageIO[DeleteChannelResponse] =
    FF.liftF(DeleteChannelOp(request))

  def deleteOriginEndpoint(
    request: DeleteOriginEndpointRequest
  ): MediaPackageIO[DeleteOriginEndpointResponse] =
    FF.liftF(DeleteOriginEndpointOp(request))

  def describeChannel(
    request: DescribeChannelRequest
  ): MediaPackageIO[DescribeChannelResponse] =
    FF.liftF(DescribeChannelOp(request))

  def describeHarvestJob(
    request: DescribeHarvestJobRequest
  ): MediaPackageIO[DescribeHarvestJobResponse] =
    FF.liftF(DescribeHarvestJobOp(request))

  def describeOriginEndpoint(
    request: DescribeOriginEndpointRequest
  ): MediaPackageIO[DescribeOriginEndpointResponse] =
    FF.liftF(DescribeOriginEndpointOp(request))

  def listChannels(
    request: ListChannelsRequest
  ): MediaPackageIO[ListChannelsResponse] =
    FF.liftF(ListChannelsOp(request))

  def listHarvestJobs(
    request: ListHarvestJobsRequest
  ): MediaPackageIO[ListHarvestJobsResponse] =
    FF.liftF(ListHarvestJobsOp(request))

  def listOriginEndpoints(
    request: ListOriginEndpointsRequest
  ): MediaPackageIO[ListOriginEndpointsResponse] =
    FF.liftF(ListOriginEndpointsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): MediaPackageIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def rotateIngestEndpointCredentials(
    request: RotateIngestEndpointCredentialsRequest
  ): MediaPackageIO[RotateIngestEndpointCredentialsResponse] =
    FF.liftF(RotateIngestEndpointCredentialsOp(request))

  def tagResource(
    request: TagResourceRequest
  ): MediaPackageIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): MediaPackageIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateChannel(
    request: UpdateChannelRequest
  ): MediaPackageIO[UpdateChannelResponse] =
    FF.liftF(UpdateChannelOp(request))

  def updateOriginEndpoint(
    request: UpdateOriginEndpointRequest
  ): MediaPackageIO[UpdateOriginEndpointResponse] =
    FF.liftF(UpdateOriginEndpointOp(request))
}
