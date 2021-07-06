package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.mediatailor.MediaTailorClient
import software.amazon.awssdk.services.mediatailor.model._


object mediatailor { module =>

  // Free monad over MediaTailorOp
  type MediaTailorIO[A] = FF[MediaTailorOp, A]

  sealed trait MediaTailorOp[A] {
    def visit[F[_]](visitor: MediaTailorOp.Visitor[F]): F[A]
  }

  object MediaTailorOp {
    // Given a MediaTailorClient we can embed a MediaTailorIO program in any algebra that understands embedding.
    implicit val MediaTailorOpEmbeddable: Embeddable[MediaTailorOp, MediaTailorClient] = new Embeddable[MediaTailorOp, MediaTailorClient] {
      def embed[A](client: MediaTailorClient, io: MediaTailorIO[A]): Embedded[A] = Embedded.MediaTailor(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MediaTailorOp.Visitor[Kleisli[M, MediaTailorClient, *]] {
        def createChannel(
          request: CreateChannelRequest
        ): Kleisli[M, MediaTailorClient, CreateChannelResponse] =
          primitive(_.createChannel(request))

        def createProgram(
          request: CreateProgramRequest
        ): Kleisli[M, MediaTailorClient, CreateProgramResponse] =
          primitive(_.createProgram(request))

        def createSourceLocation(
          request: CreateSourceLocationRequest
        ): Kleisli[M, MediaTailorClient, CreateSourceLocationResponse] =
          primitive(_.createSourceLocation(request))

        def createVodSource(
          request: CreateVodSourceRequest
        ): Kleisli[M, MediaTailorClient, CreateVodSourceResponse] =
          primitive(_.createVodSource(request))

        def deleteChannel(
          request: DeleteChannelRequest
        ): Kleisli[M, MediaTailorClient, DeleteChannelResponse] =
          primitive(_.deleteChannel(request))

        def deleteChannelPolicy(
          request: DeleteChannelPolicyRequest
        ): Kleisli[M, MediaTailorClient, DeleteChannelPolicyResponse] =
          primitive(_.deleteChannelPolicy(request))

        def deletePlaybackConfiguration(
          request: DeletePlaybackConfigurationRequest
        ): Kleisli[M, MediaTailorClient, DeletePlaybackConfigurationResponse] =
          primitive(_.deletePlaybackConfiguration(request))

        def deleteProgram(
          request: DeleteProgramRequest
        ): Kleisli[M, MediaTailorClient, DeleteProgramResponse] =
          primitive(_.deleteProgram(request))

        def deleteSourceLocation(
          request: DeleteSourceLocationRequest
        ): Kleisli[M, MediaTailorClient, DeleteSourceLocationResponse] =
          primitive(_.deleteSourceLocation(request))

        def deleteVodSource(
          request: DeleteVodSourceRequest
        ): Kleisli[M, MediaTailorClient, DeleteVodSourceResponse] =
          primitive(_.deleteVodSource(request))

        def describeChannel(
          request: DescribeChannelRequest
        ): Kleisli[M, MediaTailorClient, DescribeChannelResponse] =
          primitive(_.describeChannel(request))

        def describeProgram(
          request: DescribeProgramRequest
        ): Kleisli[M, MediaTailorClient, DescribeProgramResponse] =
          primitive(_.describeProgram(request))

        def describeSourceLocation(
          request: DescribeSourceLocationRequest
        ): Kleisli[M, MediaTailorClient, DescribeSourceLocationResponse] =
          primitive(_.describeSourceLocation(request))

        def describeVodSource(
          request: DescribeVodSourceRequest
        ): Kleisli[M, MediaTailorClient, DescribeVodSourceResponse] =
          primitive(_.describeVodSource(request))

        def getChannelPolicy(
          request: GetChannelPolicyRequest
        ): Kleisli[M, MediaTailorClient, GetChannelPolicyResponse] =
          primitive(_.getChannelPolicy(request))

        def getChannelSchedule(
          request: GetChannelScheduleRequest
        ): Kleisli[M, MediaTailorClient, GetChannelScheduleResponse] =
          primitive(_.getChannelSchedule(request))

        def getPlaybackConfiguration(
          request: GetPlaybackConfigurationRequest
        ): Kleisli[M, MediaTailorClient, GetPlaybackConfigurationResponse] =
          primitive(_.getPlaybackConfiguration(request))

        def listChannels(
          request: ListChannelsRequest
        ): Kleisli[M, MediaTailorClient, ListChannelsResponse] =
          primitive(_.listChannels(request))

        def listPlaybackConfigurations(
          request: ListPlaybackConfigurationsRequest
        ): Kleisli[M, MediaTailorClient, ListPlaybackConfigurationsResponse] =
          primitive(_.listPlaybackConfigurations(request))

        def listSourceLocations(
          request: ListSourceLocationsRequest
        ): Kleisli[M, MediaTailorClient, ListSourceLocationsResponse] =
          primitive(_.listSourceLocations(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, MediaTailorClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listVodSources(
          request: ListVodSourcesRequest
        ): Kleisli[M, MediaTailorClient, ListVodSourcesResponse] =
          primitive(_.listVodSources(request))

        def putChannelPolicy(
          request: PutChannelPolicyRequest
        ): Kleisli[M, MediaTailorClient, PutChannelPolicyResponse] =
          primitive(_.putChannelPolicy(request))

        def putPlaybackConfiguration(
          request: PutPlaybackConfigurationRequest
        ): Kleisli[M, MediaTailorClient, PutPlaybackConfigurationResponse] =
          primitive(_.putPlaybackConfiguration(request))

        def startChannel(
          request: StartChannelRequest
        ): Kleisli[M, MediaTailorClient, StartChannelResponse] =
          primitive(_.startChannel(request))

        def stopChannel(
          request: StopChannelRequest
        ): Kleisli[M, MediaTailorClient, StopChannelResponse] =
          primitive(_.stopChannel(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, MediaTailorClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, MediaTailorClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateChannel(
          request: UpdateChannelRequest
        ): Kleisli[M, MediaTailorClient, UpdateChannelResponse] =
          primitive(_.updateChannel(request))

        def updateSourceLocation(
          request: UpdateSourceLocationRequest
        ): Kleisli[M, MediaTailorClient, UpdateSourceLocationResponse] =
          primitive(_.updateSourceLocation(request))

        def updateVodSource(
          request: UpdateVodSourceRequest
        ): Kleisli[M, MediaTailorClient, UpdateVodSourceResponse] =
          primitive(_.updateVodSource(request))

        def primitive[A](
          f: MediaTailorClient => A
        ): Kleisli[M, MediaTailorClient, A]
      }
    }

    trait Visitor[F[_]] extends (MediaTailorOp ~> F) {
      final def apply[A](op: MediaTailorOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createChannel(
        request: CreateChannelRequest
      ): F[CreateChannelResponse]

      def createProgram(
        request: CreateProgramRequest
      ): F[CreateProgramResponse]

      def createSourceLocation(
        request: CreateSourceLocationRequest
      ): F[CreateSourceLocationResponse]

      def createVodSource(
        request: CreateVodSourceRequest
      ): F[CreateVodSourceResponse]

      def deleteChannel(
        request: DeleteChannelRequest
      ): F[DeleteChannelResponse]

      def deleteChannelPolicy(
        request: DeleteChannelPolicyRequest
      ): F[DeleteChannelPolicyResponse]

      def deletePlaybackConfiguration(
        request: DeletePlaybackConfigurationRequest
      ): F[DeletePlaybackConfigurationResponse]

      def deleteProgram(
        request: DeleteProgramRequest
      ): F[DeleteProgramResponse]

      def deleteSourceLocation(
        request: DeleteSourceLocationRequest
      ): F[DeleteSourceLocationResponse]

      def deleteVodSource(
        request: DeleteVodSourceRequest
      ): F[DeleteVodSourceResponse]

      def describeChannel(
        request: DescribeChannelRequest
      ): F[DescribeChannelResponse]

      def describeProgram(
        request: DescribeProgramRequest
      ): F[DescribeProgramResponse]

      def describeSourceLocation(
        request: DescribeSourceLocationRequest
      ): F[DescribeSourceLocationResponse]

      def describeVodSource(
        request: DescribeVodSourceRequest
      ): F[DescribeVodSourceResponse]

      def getChannelPolicy(
        request: GetChannelPolicyRequest
      ): F[GetChannelPolicyResponse]

      def getChannelSchedule(
        request: GetChannelScheduleRequest
      ): F[GetChannelScheduleResponse]

      def getPlaybackConfiguration(
        request: GetPlaybackConfigurationRequest
      ): F[GetPlaybackConfigurationResponse]

      def listChannels(
        request: ListChannelsRequest
      ): F[ListChannelsResponse]

      def listPlaybackConfigurations(
        request: ListPlaybackConfigurationsRequest
      ): F[ListPlaybackConfigurationsResponse]

      def listSourceLocations(
        request: ListSourceLocationsRequest
      ): F[ListSourceLocationsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listVodSources(
        request: ListVodSourcesRequest
      ): F[ListVodSourcesResponse]

      def putChannelPolicy(
        request: PutChannelPolicyRequest
      ): F[PutChannelPolicyResponse]

      def putPlaybackConfiguration(
        request: PutPlaybackConfigurationRequest
      ): F[PutPlaybackConfigurationResponse]

      def startChannel(
        request: StartChannelRequest
      ): F[StartChannelResponse]

      def stopChannel(
        request: StopChannelRequest
      ): F[StopChannelResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateChannel(
        request: UpdateChannelRequest
      ): F[UpdateChannelResponse]

      def updateSourceLocation(
        request: UpdateSourceLocationRequest
      ): F[UpdateSourceLocationResponse]

      def updateVodSource(
        request: UpdateVodSourceRequest
      ): F[UpdateVodSourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MediaTailorOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateChannelOp(
      request: CreateChannelRequest
    ) extends MediaTailorOp[CreateChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateChannelResponse] =
        visitor.createChannel(request)
    }

    final case class CreateProgramOp(
      request: CreateProgramRequest
    ) extends MediaTailorOp[CreateProgramResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProgramResponse] =
        visitor.createProgram(request)
    }

    final case class CreateSourceLocationOp(
      request: CreateSourceLocationRequest
    ) extends MediaTailorOp[CreateSourceLocationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSourceLocationResponse] =
        visitor.createSourceLocation(request)
    }

    final case class CreateVodSourceOp(
      request: CreateVodSourceRequest
    ) extends MediaTailorOp[CreateVodSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVodSourceResponse] =
        visitor.createVodSource(request)
    }

    final case class DeleteChannelOp(
      request: DeleteChannelRequest
    ) extends MediaTailorOp[DeleteChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteChannelResponse] =
        visitor.deleteChannel(request)
    }

    final case class DeleteChannelPolicyOp(
      request: DeleteChannelPolicyRequest
    ) extends MediaTailorOp[DeleteChannelPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteChannelPolicyResponse] =
        visitor.deleteChannelPolicy(request)
    }

    final case class DeletePlaybackConfigurationOp(
      request: DeletePlaybackConfigurationRequest
    ) extends MediaTailorOp[DeletePlaybackConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePlaybackConfigurationResponse] =
        visitor.deletePlaybackConfiguration(request)
    }

    final case class DeleteProgramOp(
      request: DeleteProgramRequest
    ) extends MediaTailorOp[DeleteProgramResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProgramResponse] =
        visitor.deleteProgram(request)
    }

    final case class DeleteSourceLocationOp(
      request: DeleteSourceLocationRequest
    ) extends MediaTailorOp[DeleteSourceLocationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSourceLocationResponse] =
        visitor.deleteSourceLocation(request)
    }

    final case class DeleteVodSourceOp(
      request: DeleteVodSourceRequest
    ) extends MediaTailorOp[DeleteVodSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVodSourceResponse] =
        visitor.deleteVodSource(request)
    }

    final case class DescribeChannelOp(
      request: DescribeChannelRequest
    ) extends MediaTailorOp[DescribeChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeChannelResponse] =
        visitor.describeChannel(request)
    }

    final case class DescribeProgramOp(
      request: DescribeProgramRequest
    ) extends MediaTailorOp[DescribeProgramResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProgramResponse] =
        visitor.describeProgram(request)
    }

    final case class DescribeSourceLocationOp(
      request: DescribeSourceLocationRequest
    ) extends MediaTailorOp[DescribeSourceLocationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSourceLocationResponse] =
        visitor.describeSourceLocation(request)
    }

    final case class DescribeVodSourceOp(
      request: DescribeVodSourceRequest
    ) extends MediaTailorOp[DescribeVodSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVodSourceResponse] =
        visitor.describeVodSource(request)
    }

    final case class GetChannelPolicyOp(
      request: GetChannelPolicyRequest
    ) extends MediaTailorOp[GetChannelPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetChannelPolicyResponse] =
        visitor.getChannelPolicy(request)
    }

    final case class GetChannelScheduleOp(
      request: GetChannelScheduleRequest
    ) extends MediaTailorOp[GetChannelScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetChannelScheduleResponse] =
        visitor.getChannelSchedule(request)
    }

    final case class GetPlaybackConfigurationOp(
      request: GetPlaybackConfigurationRequest
    ) extends MediaTailorOp[GetPlaybackConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPlaybackConfigurationResponse] =
        visitor.getPlaybackConfiguration(request)
    }

    final case class ListChannelsOp(
      request: ListChannelsRequest
    ) extends MediaTailorOp[ListChannelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListChannelsResponse] =
        visitor.listChannels(request)
    }

    final case class ListPlaybackConfigurationsOp(
      request: ListPlaybackConfigurationsRequest
    ) extends MediaTailorOp[ListPlaybackConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPlaybackConfigurationsResponse] =
        visitor.listPlaybackConfigurations(request)
    }

    final case class ListSourceLocationsOp(
      request: ListSourceLocationsRequest
    ) extends MediaTailorOp[ListSourceLocationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSourceLocationsResponse] =
        visitor.listSourceLocations(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends MediaTailorOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListVodSourcesOp(
      request: ListVodSourcesRequest
    ) extends MediaTailorOp[ListVodSourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVodSourcesResponse] =
        visitor.listVodSources(request)
    }

    final case class PutChannelPolicyOp(
      request: PutChannelPolicyRequest
    ) extends MediaTailorOp[PutChannelPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutChannelPolicyResponse] =
        visitor.putChannelPolicy(request)
    }

    final case class PutPlaybackConfigurationOp(
      request: PutPlaybackConfigurationRequest
    ) extends MediaTailorOp[PutPlaybackConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutPlaybackConfigurationResponse] =
        visitor.putPlaybackConfiguration(request)
    }

    final case class StartChannelOp(
      request: StartChannelRequest
    ) extends MediaTailorOp[StartChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartChannelResponse] =
        visitor.startChannel(request)
    }

    final case class StopChannelOp(
      request: StopChannelRequest
    ) extends MediaTailorOp[StopChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopChannelResponse] =
        visitor.stopChannel(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends MediaTailorOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends MediaTailorOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateChannelOp(
      request: UpdateChannelRequest
    ) extends MediaTailorOp[UpdateChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateChannelResponse] =
        visitor.updateChannel(request)
    }

    final case class UpdateSourceLocationOp(
      request: UpdateSourceLocationRequest
    ) extends MediaTailorOp[UpdateSourceLocationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSourceLocationResponse] =
        visitor.updateSourceLocation(request)
    }

    final case class UpdateVodSourceOp(
      request: UpdateVodSourceRequest
    ) extends MediaTailorOp[UpdateVodSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateVodSourceResponse] =
        visitor.updateVodSource(request)
    }
  }

  import MediaTailorOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MediaTailorOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createChannel(
    request: CreateChannelRequest
  ): MediaTailorIO[CreateChannelResponse] =
    FF.liftF(CreateChannelOp(request))

  def createProgram(
    request: CreateProgramRequest
  ): MediaTailorIO[CreateProgramResponse] =
    FF.liftF(CreateProgramOp(request))

  def createSourceLocation(
    request: CreateSourceLocationRequest
  ): MediaTailorIO[CreateSourceLocationResponse] =
    FF.liftF(CreateSourceLocationOp(request))

  def createVodSource(
    request: CreateVodSourceRequest
  ): MediaTailorIO[CreateVodSourceResponse] =
    FF.liftF(CreateVodSourceOp(request))

  def deleteChannel(
    request: DeleteChannelRequest
  ): MediaTailorIO[DeleteChannelResponse] =
    FF.liftF(DeleteChannelOp(request))

  def deleteChannelPolicy(
    request: DeleteChannelPolicyRequest
  ): MediaTailorIO[DeleteChannelPolicyResponse] =
    FF.liftF(DeleteChannelPolicyOp(request))

  def deletePlaybackConfiguration(
    request: DeletePlaybackConfigurationRequest
  ): MediaTailorIO[DeletePlaybackConfigurationResponse] =
    FF.liftF(DeletePlaybackConfigurationOp(request))

  def deleteProgram(
    request: DeleteProgramRequest
  ): MediaTailorIO[DeleteProgramResponse] =
    FF.liftF(DeleteProgramOp(request))

  def deleteSourceLocation(
    request: DeleteSourceLocationRequest
  ): MediaTailorIO[DeleteSourceLocationResponse] =
    FF.liftF(DeleteSourceLocationOp(request))

  def deleteVodSource(
    request: DeleteVodSourceRequest
  ): MediaTailorIO[DeleteVodSourceResponse] =
    FF.liftF(DeleteVodSourceOp(request))

  def describeChannel(
    request: DescribeChannelRequest
  ): MediaTailorIO[DescribeChannelResponse] =
    FF.liftF(DescribeChannelOp(request))

  def describeProgram(
    request: DescribeProgramRequest
  ): MediaTailorIO[DescribeProgramResponse] =
    FF.liftF(DescribeProgramOp(request))

  def describeSourceLocation(
    request: DescribeSourceLocationRequest
  ): MediaTailorIO[DescribeSourceLocationResponse] =
    FF.liftF(DescribeSourceLocationOp(request))

  def describeVodSource(
    request: DescribeVodSourceRequest
  ): MediaTailorIO[DescribeVodSourceResponse] =
    FF.liftF(DescribeVodSourceOp(request))

  def getChannelPolicy(
    request: GetChannelPolicyRequest
  ): MediaTailorIO[GetChannelPolicyResponse] =
    FF.liftF(GetChannelPolicyOp(request))

  def getChannelSchedule(
    request: GetChannelScheduleRequest
  ): MediaTailorIO[GetChannelScheduleResponse] =
    FF.liftF(GetChannelScheduleOp(request))

  def getPlaybackConfiguration(
    request: GetPlaybackConfigurationRequest
  ): MediaTailorIO[GetPlaybackConfigurationResponse] =
    FF.liftF(GetPlaybackConfigurationOp(request))

  def listChannels(
    request: ListChannelsRequest
  ): MediaTailorIO[ListChannelsResponse] =
    FF.liftF(ListChannelsOp(request))

  def listPlaybackConfigurations(
    request: ListPlaybackConfigurationsRequest
  ): MediaTailorIO[ListPlaybackConfigurationsResponse] =
    FF.liftF(ListPlaybackConfigurationsOp(request))

  def listSourceLocations(
    request: ListSourceLocationsRequest
  ): MediaTailorIO[ListSourceLocationsResponse] =
    FF.liftF(ListSourceLocationsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): MediaTailorIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listVodSources(
    request: ListVodSourcesRequest
  ): MediaTailorIO[ListVodSourcesResponse] =
    FF.liftF(ListVodSourcesOp(request))

  def putChannelPolicy(
    request: PutChannelPolicyRequest
  ): MediaTailorIO[PutChannelPolicyResponse] =
    FF.liftF(PutChannelPolicyOp(request))

  def putPlaybackConfiguration(
    request: PutPlaybackConfigurationRequest
  ): MediaTailorIO[PutPlaybackConfigurationResponse] =
    FF.liftF(PutPlaybackConfigurationOp(request))

  def startChannel(
    request: StartChannelRequest
  ): MediaTailorIO[StartChannelResponse] =
    FF.liftF(StartChannelOp(request))

  def stopChannel(
    request: StopChannelRequest
  ): MediaTailorIO[StopChannelResponse] =
    FF.liftF(StopChannelOp(request))

  def tagResource(
    request: TagResourceRequest
  ): MediaTailorIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): MediaTailorIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateChannel(
    request: UpdateChannelRequest
  ): MediaTailorIO[UpdateChannelResponse] =
    FF.liftF(UpdateChannelOp(request))

  def updateSourceLocation(
    request: UpdateSourceLocationRequest
  ): MediaTailorIO[UpdateSourceLocationResponse] =
    FF.liftF(UpdateSourceLocationOp(request))

  def updateVodSource(
    request: UpdateVodSourceRequest
  ): MediaTailorIO[UpdateVodSourceResponse] =
    FF.liftF(UpdateVodSourceOp(request))
}
