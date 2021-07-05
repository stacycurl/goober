package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.groundstation.GroundStationClient
import software.amazon.awssdk.services.groundstation.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object groundstation { module =>

  // Free monad over GroundStationOp
  type GroundStationIO[A] = FF[GroundStationOp, A]

  sealed trait GroundStationOp[A] {
    def visit[F[_]](visitor: GroundStationOp.Visitor[F]): F[A]
  }

  object GroundStationOp {
    // Given a GroundStationClient we can embed a GroundStationIO program in any algebra that understands embedding.
    implicit val GroundStationOpEmbeddable: Embeddable[GroundStationOp, GroundStationClient] = new Embeddable[GroundStationOp, GroundStationClient] {
      def embed[A](client: GroundStationClient, io: GroundStationIO[A]): Embedded[A] = Embedded.GroundStation(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends GroundStationOp.Visitor[Kleisli[M, GroundStationClient, *]] {
        def cancelContact(
          request: CancelContactRequest
        ): Kleisli[M, GroundStationClient, CancelContactResponse] =
          primitive(_.cancelContact(request))

        def createConfig(
          request: CreateConfigRequest
        ): Kleisli[M, GroundStationClient, CreateConfigResponse] =
          primitive(_.createConfig(request))

        def createDataflowEndpointGroup(
          request: CreateDataflowEndpointGroupRequest
        ): Kleisli[M, GroundStationClient, CreateDataflowEndpointGroupResponse] =
          primitive(_.createDataflowEndpointGroup(request))

        def createMissionProfile(
          request: CreateMissionProfileRequest
        ): Kleisli[M, GroundStationClient, CreateMissionProfileResponse] =
          primitive(_.createMissionProfile(request))

        def deleteConfig(
          request: DeleteConfigRequest
        ): Kleisli[M, GroundStationClient, DeleteConfigResponse] =
          primitive(_.deleteConfig(request))

        def deleteDataflowEndpointGroup(
          request: DeleteDataflowEndpointGroupRequest
        ): Kleisli[M, GroundStationClient, DeleteDataflowEndpointGroupResponse] =
          primitive(_.deleteDataflowEndpointGroup(request))

        def deleteMissionProfile(
          request: DeleteMissionProfileRequest
        ): Kleisli[M, GroundStationClient, DeleteMissionProfileResponse] =
          primitive(_.deleteMissionProfile(request))

        def describeContact(
          request: DescribeContactRequest
        ): Kleisli[M, GroundStationClient, DescribeContactResponse] =
          primitive(_.describeContact(request))

        def getConfig(
          request: GetConfigRequest
        ): Kleisli[M, GroundStationClient, GetConfigResponse] =
          primitive(_.getConfig(request))

        def getDataflowEndpointGroup(
          request: GetDataflowEndpointGroupRequest
        ): Kleisli[M, GroundStationClient, GetDataflowEndpointGroupResponse] =
          primitive(_.getDataflowEndpointGroup(request))

        def getMinuteUsage(
          request: GetMinuteUsageRequest
        ): Kleisli[M, GroundStationClient, GetMinuteUsageResponse] =
          primitive(_.getMinuteUsage(request))

        def getMissionProfile(
          request: GetMissionProfileRequest
        ): Kleisli[M, GroundStationClient, GetMissionProfileResponse] =
          primitive(_.getMissionProfile(request))

        def getSatellite(
          request: GetSatelliteRequest
        ): Kleisli[M, GroundStationClient, GetSatelliteResponse] =
          primitive(_.getSatellite(request))

        def listConfigs(
          request: ListConfigsRequest
        ): Kleisli[M, GroundStationClient, ListConfigsResponse] =
          primitive(_.listConfigs(request))

        def listContacts(
          request: ListContactsRequest
        ): Kleisli[M, GroundStationClient, ListContactsResponse] =
          primitive(_.listContacts(request))

        def listDataflowEndpointGroups(
          request: ListDataflowEndpointGroupsRequest
        ): Kleisli[M, GroundStationClient, ListDataflowEndpointGroupsResponse] =
          primitive(_.listDataflowEndpointGroups(request))

        def listGroundStations(
          request: ListGroundStationsRequest
        ): Kleisli[M, GroundStationClient, ListGroundStationsResponse] =
          primitive(_.listGroundStations(request))

        def listMissionProfiles(
          request: ListMissionProfilesRequest
        ): Kleisli[M, GroundStationClient, ListMissionProfilesResponse] =
          primitive(_.listMissionProfiles(request))

        def listSatellites(
          request: ListSatellitesRequest
        ): Kleisli[M, GroundStationClient, ListSatellitesResponse] =
          primitive(_.listSatellites(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, GroundStationClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def reserveContact(
          request: ReserveContactRequest
        ): Kleisli[M, GroundStationClient, ReserveContactResponse] =
          primitive(_.reserveContact(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, GroundStationClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, GroundStationClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateConfig(
          request: UpdateConfigRequest
        ): Kleisli[M, GroundStationClient, UpdateConfigResponse] =
          primitive(_.updateConfig(request))

        def updateMissionProfile(
          request: UpdateMissionProfileRequest
        ): Kleisli[M, GroundStationClient, UpdateMissionProfileResponse] =
          primitive(_.updateMissionProfile(request))

        def primitive[A](
          f: GroundStationClient => A
        ): Kleisli[M, GroundStationClient, A]
      }
    }

    trait Visitor[F[_]] extends (GroundStationOp ~> F) {
      final def apply[A](op: GroundStationOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def cancelContact(
        request: CancelContactRequest
      ): F[CancelContactResponse]

      def createConfig(
        request: CreateConfigRequest
      ): F[CreateConfigResponse]

      def createDataflowEndpointGroup(
        request: CreateDataflowEndpointGroupRequest
      ): F[CreateDataflowEndpointGroupResponse]

      def createMissionProfile(
        request: CreateMissionProfileRequest
      ): F[CreateMissionProfileResponse]

      def deleteConfig(
        request: DeleteConfigRequest
      ): F[DeleteConfigResponse]

      def deleteDataflowEndpointGroup(
        request: DeleteDataflowEndpointGroupRequest
      ): F[DeleteDataflowEndpointGroupResponse]

      def deleteMissionProfile(
        request: DeleteMissionProfileRequest
      ): F[DeleteMissionProfileResponse]

      def describeContact(
        request: DescribeContactRequest
      ): F[DescribeContactResponse]

      def getConfig(
        request: GetConfigRequest
      ): F[GetConfigResponse]

      def getDataflowEndpointGroup(
        request: GetDataflowEndpointGroupRequest
      ): F[GetDataflowEndpointGroupResponse]

      def getMinuteUsage(
        request: GetMinuteUsageRequest
      ): F[GetMinuteUsageResponse]

      def getMissionProfile(
        request: GetMissionProfileRequest
      ): F[GetMissionProfileResponse]

      def getSatellite(
        request: GetSatelliteRequest
      ): F[GetSatelliteResponse]

      def listConfigs(
        request: ListConfigsRequest
      ): F[ListConfigsResponse]

      def listContacts(
        request: ListContactsRequest
      ): F[ListContactsResponse]

      def listDataflowEndpointGroups(
        request: ListDataflowEndpointGroupsRequest
      ): F[ListDataflowEndpointGroupsResponse]

      def listGroundStations(
        request: ListGroundStationsRequest
      ): F[ListGroundStationsResponse]

      def listMissionProfiles(
        request: ListMissionProfilesRequest
      ): F[ListMissionProfilesResponse]

      def listSatellites(
        request: ListSatellitesRequest
      ): F[ListSatellitesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def reserveContact(
        request: ReserveContactRequest
      ): F[ReserveContactResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateConfig(
        request: UpdateConfigRequest
      ): F[UpdateConfigResponse]

      def updateMissionProfile(
        request: UpdateMissionProfileRequest
      ): F[UpdateMissionProfileResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends GroundStationOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CancelContactOp(
      request: CancelContactRequest
    ) extends GroundStationOp[CancelContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelContactResponse] =
        visitor.cancelContact(request)
    }

    final case class CreateConfigOp(
      request: CreateConfigRequest
    ) extends GroundStationOp[CreateConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConfigResponse] =
        visitor.createConfig(request)
    }

    final case class CreateDataflowEndpointGroupOp(
      request: CreateDataflowEndpointGroupRequest
    ) extends GroundStationOp[CreateDataflowEndpointGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDataflowEndpointGroupResponse] =
        visitor.createDataflowEndpointGroup(request)
    }

    final case class CreateMissionProfileOp(
      request: CreateMissionProfileRequest
    ) extends GroundStationOp[CreateMissionProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMissionProfileResponse] =
        visitor.createMissionProfile(request)
    }

    final case class DeleteConfigOp(
      request: DeleteConfigRequest
    ) extends GroundStationOp[DeleteConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConfigResponse] =
        visitor.deleteConfig(request)
    }

    final case class DeleteDataflowEndpointGroupOp(
      request: DeleteDataflowEndpointGroupRequest
    ) extends GroundStationOp[DeleteDataflowEndpointGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDataflowEndpointGroupResponse] =
        visitor.deleteDataflowEndpointGroup(request)
    }

    final case class DeleteMissionProfileOp(
      request: DeleteMissionProfileRequest
    ) extends GroundStationOp[DeleteMissionProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMissionProfileResponse] =
        visitor.deleteMissionProfile(request)
    }

    final case class DescribeContactOp(
      request: DescribeContactRequest
    ) extends GroundStationOp[DescribeContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeContactResponse] =
        visitor.describeContact(request)
    }

    final case class GetConfigOp(
      request: GetConfigRequest
    ) extends GroundStationOp[GetConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConfigResponse] =
        visitor.getConfig(request)
    }

    final case class GetDataflowEndpointGroupOp(
      request: GetDataflowEndpointGroupRequest
    ) extends GroundStationOp[GetDataflowEndpointGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDataflowEndpointGroupResponse] =
        visitor.getDataflowEndpointGroup(request)
    }

    final case class GetMinuteUsageOp(
      request: GetMinuteUsageRequest
    ) extends GroundStationOp[GetMinuteUsageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMinuteUsageResponse] =
        visitor.getMinuteUsage(request)
    }

    final case class GetMissionProfileOp(
      request: GetMissionProfileRequest
    ) extends GroundStationOp[GetMissionProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMissionProfileResponse] =
        visitor.getMissionProfile(request)
    }

    final case class GetSatelliteOp(
      request: GetSatelliteRequest
    ) extends GroundStationOp[GetSatelliteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSatelliteResponse] =
        visitor.getSatellite(request)
    }

    final case class ListConfigsOp(
      request: ListConfigsRequest
    ) extends GroundStationOp[ListConfigsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConfigsResponse] =
        visitor.listConfigs(request)
    }

    final case class ListContactsOp(
      request: ListContactsRequest
    ) extends GroundStationOp[ListContactsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListContactsResponse] =
        visitor.listContacts(request)
    }

    final case class ListDataflowEndpointGroupsOp(
      request: ListDataflowEndpointGroupsRequest
    ) extends GroundStationOp[ListDataflowEndpointGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDataflowEndpointGroupsResponse] =
        visitor.listDataflowEndpointGroups(request)
    }

    final case class ListGroundStationsOp(
      request: ListGroundStationsRequest
    ) extends GroundStationOp[ListGroundStationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGroundStationsResponse] =
        visitor.listGroundStations(request)
    }

    final case class ListMissionProfilesOp(
      request: ListMissionProfilesRequest
    ) extends GroundStationOp[ListMissionProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMissionProfilesResponse] =
        visitor.listMissionProfiles(request)
    }

    final case class ListSatellitesOp(
      request: ListSatellitesRequest
    ) extends GroundStationOp[ListSatellitesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSatellitesResponse] =
        visitor.listSatellites(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends GroundStationOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ReserveContactOp(
      request: ReserveContactRequest
    ) extends GroundStationOp[ReserveContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReserveContactResponse] =
        visitor.reserveContact(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends GroundStationOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends GroundStationOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateConfigOp(
      request: UpdateConfigRequest
    ) extends GroundStationOp[UpdateConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConfigResponse] =
        visitor.updateConfig(request)
    }

    final case class UpdateMissionProfileOp(
      request: UpdateMissionProfileRequest
    ) extends GroundStationOp[UpdateMissionProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMissionProfileResponse] =
        visitor.updateMissionProfile(request)
    }
  }

  import GroundStationOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[GroundStationOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def cancelContact(
    request: CancelContactRequest
  ): GroundStationIO[CancelContactResponse] =
    FF.liftF(CancelContactOp(request))

  def createConfig(
    request: CreateConfigRequest
  ): GroundStationIO[CreateConfigResponse] =
    FF.liftF(CreateConfigOp(request))

  def createDataflowEndpointGroup(
    request: CreateDataflowEndpointGroupRequest
  ): GroundStationIO[CreateDataflowEndpointGroupResponse] =
    FF.liftF(CreateDataflowEndpointGroupOp(request))

  def createMissionProfile(
    request: CreateMissionProfileRequest
  ): GroundStationIO[CreateMissionProfileResponse] =
    FF.liftF(CreateMissionProfileOp(request))

  def deleteConfig(
    request: DeleteConfigRequest
  ): GroundStationIO[DeleteConfigResponse] =
    FF.liftF(DeleteConfigOp(request))

  def deleteDataflowEndpointGroup(
    request: DeleteDataflowEndpointGroupRequest
  ): GroundStationIO[DeleteDataflowEndpointGroupResponse] =
    FF.liftF(DeleteDataflowEndpointGroupOp(request))

  def deleteMissionProfile(
    request: DeleteMissionProfileRequest
  ): GroundStationIO[DeleteMissionProfileResponse] =
    FF.liftF(DeleteMissionProfileOp(request))

  def describeContact(
    request: DescribeContactRequest
  ): GroundStationIO[DescribeContactResponse] =
    FF.liftF(DescribeContactOp(request))

  def getConfig(
    request: GetConfigRequest
  ): GroundStationIO[GetConfigResponse] =
    FF.liftF(GetConfigOp(request))

  def getDataflowEndpointGroup(
    request: GetDataflowEndpointGroupRequest
  ): GroundStationIO[GetDataflowEndpointGroupResponse] =
    FF.liftF(GetDataflowEndpointGroupOp(request))

  def getMinuteUsage(
    request: GetMinuteUsageRequest
  ): GroundStationIO[GetMinuteUsageResponse] =
    FF.liftF(GetMinuteUsageOp(request))

  def getMissionProfile(
    request: GetMissionProfileRequest
  ): GroundStationIO[GetMissionProfileResponse] =
    FF.liftF(GetMissionProfileOp(request))

  def getSatellite(
    request: GetSatelliteRequest
  ): GroundStationIO[GetSatelliteResponse] =
    FF.liftF(GetSatelliteOp(request))

  def listConfigs(
    request: ListConfigsRequest
  ): GroundStationIO[ListConfigsResponse] =
    FF.liftF(ListConfigsOp(request))

  def listContacts(
    request: ListContactsRequest
  ): GroundStationIO[ListContactsResponse] =
    FF.liftF(ListContactsOp(request))

  def listDataflowEndpointGroups(
    request: ListDataflowEndpointGroupsRequest
  ): GroundStationIO[ListDataflowEndpointGroupsResponse] =
    FF.liftF(ListDataflowEndpointGroupsOp(request))

  def listGroundStations(
    request: ListGroundStationsRequest
  ): GroundStationIO[ListGroundStationsResponse] =
    FF.liftF(ListGroundStationsOp(request))

  def listMissionProfiles(
    request: ListMissionProfilesRequest
  ): GroundStationIO[ListMissionProfilesResponse] =
    FF.liftF(ListMissionProfilesOp(request))

  def listSatellites(
    request: ListSatellitesRequest
  ): GroundStationIO[ListSatellitesResponse] =
    FF.liftF(ListSatellitesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): GroundStationIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def reserveContact(
    request: ReserveContactRequest
  ): GroundStationIO[ReserveContactResponse] =
    FF.liftF(ReserveContactOp(request))

  def tagResource(
    request: TagResourceRequest
  ): GroundStationIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): GroundStationIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateConfig(
    request: UpdateConfigRequest
  ): GroundStationIO[UpdateConfigResponse] =
    FF.liftF(UpdateConfigOp(request))

  def updateMissionProfile(
    request: UpdateMissionProfileRequest
  ): GroundStationIO[UpdateMissionProfileResponse] =
    FF.liftF(UpdateMissionProfileOp(request))
}
