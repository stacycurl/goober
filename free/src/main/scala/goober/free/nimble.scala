package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.nimble.NimbleClient
import software.amazon.awssdk.services.nimble.model._


object nimble { module =>

  // Free monad over NimbleOp
  type NimbleIO[A] = FF[NimbleOp, A]

  sealed trait NimbleOp[A] {
    def visit[F[_]](visitor: NimbleOp.Visitor[F]): F[A]
  }

  object NimbleOp {
    // Given a NimbleClient we can embed a NimbleIO program in any algebra that understands embedding.
    implicit val NimbleOpEmbeddable: Embeddable[NimbleOp, NimbleClient] = new Embeddable[NimbleOp, NimbleClient] {
      def embed[A](client: NimbleClient, io: NimbleIO[A]): Embedded[A] = Embedded.Nimble(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends NimbleOp.Visitor[Kleisli[M, NimbleClient, *]] {
        def acceptEulas(
          request: AcceptEulasRequest
        ): Kleisli[M, NimbleClient, AcceptEulasResponse] =
          primitive(_.acceptEulas(request))

        def createLaunchProfile(
          request: CreateLaunchProfileRequest
        ): Kleisli[M, NimbleClient, CreateLaunchProfileResponse] =
          primitive(_.createLaunchProfile(request))

        def createStreamingImage(
          request: CreateStreamingImageRequest
        ): Kleisli[M, NimbleClient, CreateStreamingImageResponse] =
          primitive(_.createStreamingImage(request))

        def createStreamingSession(
          request: CreateStreamingSessionRequest
        ): Kleisli[M, NimbleClient, CreateStreamingSessionResponse] =
          primitive(_.createStreamingSession(request))

        def createStreamingSessionStream(
          request: CreateStreamingSessionStreamRequest
        ): Kleisli[M, NimbleClient, CreateStreamingSessionStreamResponse] =
          primitive(_.createStreamingSessionStream(request))

        def createStudio(
          request: CreateStudioRequest
        ): Kleisli[M, NimbleClient, CreateStudioResponse] =
          primitive(_.createStudio(request))

        def createStudioComponent(
          request: CreateStudioComponentRequest
        ): Kleisli[M, NimbleClient, CreateStudioComponentResponse] =
          primitive(_.createStudioComponent(request))

        def deleteLaunchProfile(
          request: DeleteLaunchProfileRequest
        ): Kleisli[M, NimbleClient, DeleteLaunchProfileResponse] =
          primitive(_.deleteLaunchProfile(request))

        def deleteLaunchProfileMember(
          request: DeleteLaunchProfileMemberRequest
        ): Kleisli[M, NimbleClient, DeleteLaunchProfileMemberResponse] =
          primitive(_.deleteLaunchProfileMember(request))

        def deleteStreamingImage(
          request: DeleteStreamingImageRequest
        ): Kleisli[M, NimbleClient, DeleteStreamingImageResponse] =
          primitive(_.deleteStreamingImage(request))

        def deleteStreamingSession(
          request: DeleteStreamingSessionRequest
        ): Kleisli[M, NimbleClient, DeleteStreamingSessionResponse] =
          primitive(_.deleteStreamingSession(request))

        def deleteStudio(
          request: DeleteStudioRequest
        ): Kleisli[M, NimbleClient, DeleteStudioResponse] =
          primitive(_.deleteStudio(request))

        def deleteStudioComponent(
          request: DeleteStudioComponentRequest
        ): Kleisli[M, NimbleClient, DeleteStudioComponentResponse] =
          primitive(_.deleteStudioComponent(request))

        def deleteStudioMember(
          request: DeleteStudioMemberRequest
        ): Kleisli[M, NimbleClient, DeleteStudioMemberResponse] =
          primitive(_.deleteStudioMember(request))

        def getEula(
          request: GetEulaRequest
        ): Kleisli[M, NimbleClient, GetEulaResponse] =
          primitive(_.getEula(request))

        def getLaunchProfile(
          request: GetLaunchProfileRequest
        ): Kleisli[M, NimbleClient, GetLaunchProfileResponse] =
          primitive(_.getLaunchProfile(request))

        def getLaunchProfileDetails(
          request: GetLaunchProfileDetailsRequest
        ): Kleisli[M, NimbleClient, GetLaunchProfileDetailsResponse] =
          primitive(_.getLaunchProfileDetails(request))

        def getLaunchProfileInitialization(
          request: GetLaunchProfileInitializationRequest
        ): Kleisli[M, NimbleClient, GetLaunchProfileInitializationResponse] =
          primitive(_.getLaunchProfileInitialization(request))

        def getLaunchProfileMember(
          request: GetLaunchProfileMemberRequest
        ): Kleisli[M, NimbleClient, GetLaunchProfileMemberResponse] =
          primitive(_.getLaunchProfileMember(request))

        def getStreamingImage(
          request: GetStreamingImageRequest
        ): Kleisli[M, NimbleClient, GetStreamingImageResponse] =
          primitive(_.getStreamingImage(request))

        def getStreamingSession(
          request: GetStreamingSessionRequest
        ): Kleisli[M, NimbleClient, GetStreamingSessionResponse] =
          primitive(_.getStreamingSession(request))

        def getStreamingSessionStream(
          request: GetStreamingSessionStreamRequest
        ): Kleisli[M, NimbleClient, GetStreamingSessionStreamResponse] =
          primitive(_.getStreamingSessionStream(request))

        def getStudio(
          request: GetStudioRequest
        ): Kleisli[M, NimbleClient, GetStudioResponse] =
          primitive(_.getStudio(request))

        def getStudioComponent(
          request: GetStudioComponentRequest
        ): Kleisli[M, NimbleClient, GetStudioComponentResponse] =
          primitive(_.getStudioComponent(request))

        def getStudioMember(
          request: GetStudioMemberRequest
        ): Kleisli[M, NimbleClient, GetStudioMemberResponse] =
          primitive(_.getStudioMember(request))

        def listEulaAcceptances(
          request: ListEulaAcceptancesRequest
        ): Kleisli[M, NimbleClient, ListEulaAcceptancesResponse] =
          primitive(_.listEulaAcceptances(request))

        def listEulas(
          request: ListEulasRequest
        ): Kleisli[M, NimbleClient, ListEulasResponse] =
          primitive(_.listEulas(request))

        def listLaunchProfileMembers(
          request: ListLaunchProfileMembersRequest
        ): Kleisli[M, NimbleClient, ListLaunchProfileMembersResponse] =
          primitive(_.listLaunchProfileMembers(request))

        def listLaunchProfiles(
          request: ListLaunchProfilesRequest
        ): Kleisli[M, NimbleClient, ListLaunchProfilesResponse] =
          primitive(_.listLaunchProfiles(request))

        def listStreamingImages(
          request: ListStreamingImagesRequest
        ): Kleisli[M, NimbleClient, ListStreamingImagesResponse] =
          primitive(_.listStreamingImages(request))

        def listStreamingSessions(
          request: ListStreamingSessionsRequest
        ): Kleisli[M, NimbleClient, ListStreamingSessionsResponse] =
          primitive(_.listStreamingSessions(request))

        def listStudioComponents(
          request: ListStudioComponentsRequest
        ): Kleisli[M, NimbleClient, ListStudioComponentsResponse] =
          primitive(_.listStudioComponents(request))

        def listStudioMembers(
          request: ListStudioMembersRequest
        ): Kleisli[M, NimbleClient, ListStudioMembersResponse] =
          primitive(_.listStudioMembers(request))

        def listStudios(
          request: ListStudiosRequest
        ): Kleisli[M, NimbleClient, ListStudiosResponse] =
          primitive(_.listStudios(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, NimbleClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putLaunchProfileMembers(
          request: PutLaunchProfileMembersRequest
        ): Kleisli[M, NimbleClient, PutLaunchProfileMembersResponse] =
          primitive(_.putLaunchProfileMembers(request))

        def putStudioMembers(
          request: PutStudioMembersRequest
        ): Kleisli[M, NimbleClient, PutStudioMembersResponse] =
          primitive(_.putStudioMembers(request))

        def startStudioSSOConfigurationRepair(
          request: StartStudioSsoConfigurationRepairRequest
        ): Kleisli[M, NimbleClient, StartStudioSsoConfigurationRepairResponse] =
          primitive(_.startStudioSSOConfigurationRepair(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, NimbleClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, NimbleClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateLaunchProfile(
          request: UpdateLaunchProfileRequest
        ): Kleisli[M, NimbleClient, UpdateLaunchProfileResponse] =
          primitive(_.updateLaunchProfile(request))

        def updateLaunchProfileMember(
          request: UpdateLaunchProfileMemberRequest
        ): Kleisli[M, NimbleClient, UpdateLaunchProfileMemberResponse] =
          primitive(_.updateLaunchProfileMember(request))

        def updateStreamingImage(
          request: UpdateStreamingImageRequest
        ): Kleisli[M, NimbleClient, UpdateStreamingImageResponse] =
          primitive(_.updateStreamingImage(request))

        def updateStudio(
          request: UpdateStudioRequest
        ): Kleisli[M, NimbleClient, UpdateStudioResponse] =
          primitive(_.updateStudio(request))

        def updateStudioComponent(
          request: UpdateStudioComponentRequest
        ): Kleisli[M, NimbleClient, UpdateStudioComponentResponse] =
          primitive(_.updateStudioComponent(request))

        def primitive[A](
          f: NimbleClient => A
        ): Kleisli[M, NimbleClient, A]
      }
    }

    trait Visitor[F[_]] extends (NimbleOp ~> F) {
      final def apply[A](op: NimbleOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptEulas(
        request: AcceptEulasRequest
      ): F[AcceptEulasResponse]

      def createLaunchProfile(
        request: CreateLaunchProfileRequest
      ): F[CreateLaunchProfileResponse]

      def createStreamingImage(
        request: CreateStreamingImageRequest
      ): F[CreateStreamingImageResponse]

      def createStreamingSession(
        request: CreateStreamingSessionRequest
      ): F[CreateStreamingSessionResponse]

      def createStreamingSessionStream(
        request: CreateStreamingSessionStreamRequest
      ): F[CreateStreamingSessionStreamResponse]

      def createStudio(
        request: CreateStudioRequest
      ): F[CreateStudioResponse]

      def createStudioComponent(
        request: CreateStudioComponentRequest
      ): F[CreateStudioComponentResponse]

      def deleteLaunchProfile(
        request: DeleteLaunchProfileRequest
      ): F[DeleteLaunchProfileResponse]

      def deleteLaunchProfileMember(
        request: DeleteLaunchProfileMemberRequest
      ): F[DeleteLaunchProfileMemberResponse]

      def deleteStreamingImage(
        request: DeleteStreamingImageRequest
      ): F[DeleteStreamingImageResponse]

      def deleteStreamingSession(
        request: DeleteStreamingSessionRequest
      ): F[DeleteStreamingSessionResponse]

      def deleteStudio(
        request: DeleteStudioRequest
      ): F[DeleteStudioResponse]

      def deleteStudioComponent(
        request: DeleteStudioComponentRequest
      ): F[DeleteStudioComponentResponse]

      def deleteStudioMember(
        request: DeleteStudioMemberRequest
      ): F[DeleteStudioMemberResponse]

      def getEula(
        request: GetEulaRequest
      ): F[GetEulaResponse]

      def getLaunchProfile(
        request: GetLaunchProfileRequest
      ): F[GetLaunchProfileResponse]

      def getLaunchProfileDetails(
        request: GetLaunchProfileDetailsRequest
      ): F[GetLaunchProfileDetailsResponse]

      def getLaunchProfileInitialization(
        request: GetLaunchProfileInitializationRequest
      ): F[GetLaunchProfileInitializationResponse]

      def getLaunchProfileMember(
        request: GetLaunchProfileMemberRequest
      ): F[GetLaunchProfileMemberResponse]

      def getStreamingImage(
        request: GetStreamingImageRequest
      ): F[GetStreamingImageResponse]

      def getStreamingSession(
        request: GetStreamingSessionRequest
      ): F[GetStreamingSessionResponse]

      def getStreamingSessionStream(
        request: GetStreamingSessionStreamRequest
      ): F[GetStreamingSessionStreamResponse]

      def getStudio(
        request: GetStudioRequest
      ): F[GetStudioResponse]

      def getStudioComponent(
        request: GetStudioComponentRequest
      ): F[GetStudioComponentResponse]

      def getStudioMember(
        request: GetStudioMemberRequest
      ): F[GetStudioMemberResponse]

      def listEulaAcceptances(
        request: ListEulaAcceptancesRequest
      ): F[ListEulaAcceptancesResponse]

      def listEulas(
        request: ListEulasRequest
      ): F[ListEulasResponse]

      def listLaunchProfileMembers(
        request: ListLaunchProfileMembersRequest
      ): F[ListLaunchProfileMembersResponse]

      def listLaunchProfiles(
        request: ListLaunchProfilesRequest
      ): F[ListLaunchProfilesResponse]

      def listStreamingImages(
        request: ListStreamingImagesRequest
      ): F[ListStreamingImagesResponse]

      def listStreamingSessions(
        request: ListStreamingSessionsRequest
      ): F[ListStreamingSessionsResponse]

      def listStudioComponents(
        request: ListStudioComponentsRequest
      ): F[ListStudioComponentsResponse]

      def listStudioMembers(
        request: ListStudioMembersRequest
      ): F[ListStudioMembersResponse]

      def listStudios(
        request: ListStudiosRequest
      ): F[ListStudiosResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putLaunchProfileMembers(
        request: PutLaunchProfileMembersRequest
      ): F[PutLaunchProfileMembersResponse]

      def putStudioMembers(
        request: PutStudioMembersRequest
      ): F[PutStudioMembersResponse]

      def startStudioSSOConfigurationRepair(
        request: StartStudioSsoConfigurationRepairRequest
      ): F[StartStudioSsoConfigurationRepairResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateLaunchProfile(
        request: UpdateLaunchProfileRequest
      ): F[UpdateLaunchProfileResponse]

      def updateLaunchProfileMember(
        request: UpdateLaunchProfileMemberRequest
      ): F[UpdateLaunchProfileMemberResponse]

      def updateStreamingImage(
        request: UpdateStreamingImageRequest
      ): F[UpdateStreamingImageResponse]

      def updateStudio(
        request: UpdateStudioRequest
      ): F[UpdateStudioResponse]

      def updateStudioComponent(
        request: UpdateStudioComponentRequest
      ): F[UpdateStudioComponentResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends NimbleOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptEulasOp(
      request: AcceptEulasRequest
    ) extends NimbleOp[AcceptEulasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptEulasResponse] =
        visitor.acceptEulas(request)
    }

    final case class CreateLaunchProfileOp(
      request: CreateLaunchProfileRequest
    ) extends NimbleOp[CreateLaunchProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLaunchProfileResponse] =
        visitor.createLaunchProfile(request)
    }

    final case class CreateStreamingImageOp(
      request: CreateStreamingImageRequest
    ) extends NimbleOp[CreateStreamingImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStreamingImageResponse] =
        visitor.createStreamingImage(request)
    }

    final case class CreateStreamingSessionOp(
      request: CreateStreamingSessionRequest
    ) extends NimbleOp[CreateStreamingSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStreamingSessionResponse] =
        visitor.createStreamingSession(request)
    }

    final case class CreateStreamingSessionStreamOp(
      request: CreateStreamingSessionStreamRequest
    ) extends NimbleOp[CreateStreamingSessionStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStreamingSessionStreamResponse] =
        visitor.createStreamingSessionStream(request)
    }

    final case class CreateStudioOp(
      request: CreateStudioRequest
    ) extends NimbleOp[CreateStudioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStudioResponse] =
        visitor.createStudio(request)
    }

    final case class CreateStudioComponentOp(
      request: CreateStudioComponentRequest
    ) extends NimbleOp[CreateStudioComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStudioComponentResponse] =
        visitor.createStudioComponent(request)
    }

    final case class DeleteLaunchProfileOp(
      request: DeleteLaunchProfileRequest
    ) extends NimbleOp[DeleteLaunchProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLaunchProfileResponse] =
        visitor.deleteLaunchProfile(request)
    }

    final case class DeleteLaunchProfileMemberOp(
      request: DeleteLaunchProfileMemberRequest
    ) extends NimbleOp[DeleteLaunchProfileMemberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLaunchProfileMemberResponse] =
        visitor.deleteLaunchProfileMember(request)
    }

    final case class DeleteStreamingImageOp(
      request: DeleteStreamingImageRequest
    ) extends NimbleOp[DeleteStreamingImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStreamingImageResponse] =
        visitor.deleteStreamingImage(request)
    }

    final case class DeleteStreamingSessionOp(
      request: DeleteStreamingSessionRequest
    ) extends NimbleOp[DeleteStreamingSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStreamingSessionResponse] =
        visitor.deleteStreamingSession(request)
    }

    final case class DeleteStudioOp(
      request: DeleteStudioRequest
    ) extends NimbleOp[DeleteStudioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStudioResponse] =
        visitor.deleteStudio(request)
    }

    final case class DeleteStudioComponentOp(
      request: DeleteStudioComponentRequest
    ) extends NimbleOp[DeleteStudioComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStudioComponentResponse] =
        visitor.deleteStudioComponent(request)
    }

    final case class DeleteStudioMemberOp(
      request: DeleteStudioMemberRequest
    ) extends NimbleOp[DeleteStudioMemberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStudioMemberResponse] =
        visitor.deleteStudioMember(request)
    }

    final case class GetEulaOp(
      request: GetEulaRequest
    ) extends NimbleOp[GetEulaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEulaResponse] =
        visitor.getEula(request)
    }

    final case class GetLaunchProfileOp(
      request: GetLaunchProfileRequest
    ) extends NimbleOp[GetLaunchProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLaunchProfileResponse] =
        visitor.getLaunchProfile(request)
    }

    final case class GetLaunchProfileDetailsOp(
      request: GetLaunchProfileDetailsRequest
    ) extends NimbleOp[GetLaunchProfileDetailsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLaunchProfileDetailsResponse] =
        visitor.getLaunchProfileDetails(request)
    }

    final case class GetLaunchProfileInitializationOp(
      request: GetLaunchProfileInitializationRequest
    ) extends NimbleOp[GetLaunchProfileInitializationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLaunchProfileInitializationResponse] =
        visitor.getLaunchProfileInitialization(request)
    }

    final case class GetLaunchProfileMemberOp(
      request: GetLaunchProfileMemberRequest
    ) extends NimbleOp[GetLaunchProfileMemberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLaunchProfileMemberResponse] =
        visitor.getLaunchProfileMember(request)
    }

    final case class GetStreamingImageOp(
      request: GetStreamingImageRequest
    ) extends NimbleOp[GetStreamingImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStreamingImageResponse] =
        visitor.getStreamingImage(request)
    }

    final case class GetStreamingSessionOp(
      request: GetStreamingSessionRequest
    ) extends NimbleOp[GetStreamingSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStreamingSessionResponse] =
        visitor.getStreamingSession(request)
    }

    final case class GetStreamingSessionStreamOp(
      request: GetStreamingSessionStreamRequest
    ) extends NimbleOp[GetStreamingSessionStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStreamingSessionStreamResponse] =
        visitor.getStreamingSessionStream(request)
    }

    final case class GetStudioOp(
      request: GetStudioRequest
    ) extends NimbleOp[GetStudioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStudioResponse] =
        visitor.getStudio(request)
    }

    final case class GetStudioComponentOp(
      request: GetStudioComponentRequest
    ) extends NimbleOp[GetStudioComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStudioComponentResponse] =
        visitor.getStudioComponent(request)
    }

    final case class GetStudioMemberOp(
      request: GetStudioMemberRequest
    ) extends NimbleOp[GetStudioMemberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStudioMemberResponse] =
        visitor.getStudioMember(request)
    }

    final case class ListEulaAcceptancesOp(
      request: ListEulaAcceptancesRequest
    ) extends NimbleOp[ListEulaAcceptancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEulaAcceptancesResponse] =
        visitor.listEulaAcceptances(request)
    }

    final case class ListEulasOp(
      request: ListEulasRequest
    ) extends NimbleOp[ListEulasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEulasResponse] =
        visitor.listEulas(request)
    }

    final case class ListLaunchProfileMembersOp(
      request: ListLaunchProfileMembersRequest
    ) extends NimbleOp[ListLaunchProfileMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLaunchProfileMembersResponse] =
        visitor.listLaunchProfileMembers(request)
    }

    final case class ListLaunchProfilesOp(
      request: ListLaunchProfilesRequest
    ) extends NimbleOp[ListLaunchProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLaunchProfilesResponse] =
        visitor.listLaunchProfiles(request)
    }

    final case class ListStreamingImagesOp(
      request: ListStreamingImagesRequest
    ) extends NimbleOp[ListStreamingImagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStreamingImagesResponse] =
        visitor.listStreamingImages(request)
    }

    final case class ListStreamingSessionsOp(
      request: ListStreamingSessionsRequest
    ) extends NimbleOp[ListStreamingSessionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStreamingSessionsResponse] =
        visitor.listStreamingSessions(request)
    }

    final case class ListStudioComponentsOp(
      request: ListStudioComponentsRequest
    ) extends NimbleOp[ListStudioComponentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStudioComponentsResponse] =
        visitor.listStudioComponents(request)
    }

    final case class ListStudioMembersOp(
      request: ListStudioMembersRequest
    ) extends NimbleOp[ListStudioMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStudioMembersResponse] =
        visitor.listStudioMembers(request)
    }

    final case class ListStudiosOp(
      request: ListStudiosRequest
    ) extends NimbleOp[ListStudiosResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStudiosResponse] =
        visitor.listStudios(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends NimbleOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutLaunchProfileMembersOp(
      request: PutLaunchProfileMembersRequest
    ) extends NimbleOp[PutLaunchProfileMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutLaunchProfileMembersResponse] =
        visitor.putLaunchProfileMembers(request)
    }

    final case class PutStudioMembersOp(
      request: PutStudioMembersRequest
    ) extends NimbleOp[PutStudioMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutStudioMembersResponse] =
        visitor.putStudioMembers(request)
    }

    final case class StartStudioSSOConfigurationRepairOp(
      request: StartStudioSsoConfigurationRepairRequest
    ) extends NimbleOp[StartStudioSsoConfigurationRepairResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartStudioSsoConfigurationRepairResponse] =
        visitor.startStudioSSOConfigurationRepair(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends NimbleOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends NimbleOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateLaunchProfileOp(
      request: UpdateLaunchProfileRequest
    ) extends NimbleOp[UpdateLaunchProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLaunchProfileResponse] =
        visitor.updateLaunchProfile(request)
    }

    final case class UpdateLaunchProfileMemberOp(
      request: UpdateLaunchProfileMemberRequest
    ) extends NimbleOp[UpdateLaunchProfileMemberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLaunchProfileMemberResponse] =
        visitor.updateLaunchProfileMember(request)
    }

    final case class UpdateStreamingImageOp(
      request: UpdateStreamingImageRequest
    ) extends NimbleOp[UpdateStreamingImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateStreamingImageResponse] =
        visitor.updateStreamingImage(request)
    }

    final case class UpdateStudioOp(
      request: UpdateStudioRequest
    ) extends NimbleOp[UpdateStudioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateStudioResponse] =
        visitor.updateStudio(request)
    }

    final case class UpdateStudioComponentOp(
      request: UpdateStudioComponentRequest
    ) extends NimbleOp[UpdateStudioComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateStudioComponentResponse] =
        visitor.updateStudioComponent(request)
    }
  }

  import NimbleOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[NimbleOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptEulas(
    request: AcceptEulasRequest
  ): NimbleIO[AcceptEulasResponse] =
    FF.liftF(AcceptEulasOp(request))

  def createLaunchProfile(
    request: CreateLaunchProfileRequest
  ): NimbleIO[CreateLaunchProfileResponse] =
    FF.liftF(CreateLaunchProfileOp(request))

  def createStreamingImage(
    request: CreateStreamingImageRequest
  ): NimbleIO[CreateStreamingImageResponse] =
    FF.liftF(CreateStreamingImageOp(request))

  def createStreamingSession(
    request: CreateStreamingSessionRequest
  ): NimbleIO[CreateStreamingSessionResponse] =
    FF.liftF(CreateStreamingSessionOp(request))

  def createStreamingSessionStream(
    request: CreateStreamingSessionStreamRequest
  ): NimbleIO[CreateStreamingSessionStreamResponse] =
    FF.liftF(CreateStreamingSessionStreamOp(request))

  def createStudio(
    request: CreateStudioRequest
  ): NimbleIO[CreateStudioResponse] =
    FF.liftF(CreateStudioOp(request))

  def createStudioComponent(
    request: CreateStudioComponentRequest
  ): NimbleIO[CreateStudioComponentResponse] =
    FF.liftF(CreateStudioComponentOp(request))

  def deleteLaunchProfile(
    request: DeleteLaunchProfileRequest
  ): NimbleIO[DeleteLaunchProfileResponse] =
    FF.liftF(DeleteLaunchProfileOp(request))

  def deleteLaunchProfileMember(
    request: DeleteLaunchProfileMemberRequest
  ): NimbleIO[DeleteLaunchProfileMemberResponse] =
    FF.liftF(DeleteLaunchProfileMemberOp(request))

  def deleteStreamingImage(
    request: DeleteStreamingImageRequest
  ): NimbleIO[DeleteStreamingImageResponse] =
    FF.liftF(DeleteStreamingImageOp(request))

  def deleteStreamingSession(
    request: DeleteStreamingSessionRequest
  ): NimbleIO[DeleteStreamingSessionResponse] =
    FF.liftF(DeleteStreamingSessionOp(request))

  def deleteStudio(
    request: DeleteStudioRequest
  ): NimbleIO[DeleteStudioResponse] =
    FF.liftF(DeleteStudioOp(request))

  def deleteStudioComponent(
    request: DeleteStudioComponentRequest
  ): NimbleIO[DeleteStudioComponentResponse] =
    FF.liftF(DeleteStudioComponentOp(request))

  def deleteStudioMember(
    request: DeleteStudioMemberRequest
  ): NimbleIO[DeleteStudioMemberResponse] =
    FF.liftF(DeleteStudioMemberOp(request))

  def getEula(
    request: GetEulaRequest
  ): NimbleIO[GetEulaResponse] =
    FF.liftF(GetEulaOp(request))

  def getLaunchProfile(
    request: GetLaunchProfileRequest
  ): NimbleIO[GetLaunchProfileResponse] =
    FF.liftF(GetLaunchProfileOp(request))

  def getLaunchProfileDetails(
    request: GetLaunchProfileDetailsRequest
  ): NimbleIO[GetLaunchProfileDetailsResponse] =
    FF.liftF(GetLaunchProfileDetailsOp(request))

  def getLaunchProfileInitialization(
    request: GetLaunchProfileInitializationRequest
  ): NimbleIO[GetLaunchProfileInitializationResponse] =
    FF.liftF(GetLaunchProfileInitializationOp(request))

  def getLaunchProfileMember(
    request: GetLaunchProfileMemberRequest
  ): NimbleIO[GetLaunchProfileMemberResponse] =
    FF.liftF(GetLaunchProfileMemberOp(request))

  def getStreamingImage(
    request: GetStreamingImageRequest
  ): NimbleIO[GetStreamingImageResponse] =
    FF.liftF(GetStreamingImageOp(request))

  def getStreamingSession(
    request: GetStreamingSessionRequest
  ): NimbleIO[GetStreamingSessionResponse] =
    FF.liftF(GetStreamingSessionOp(request))

  def getStreamingSessionStream(
    request: GetStreamingSessionStreamRequest
  ): NimbleIO[GetStreamingSessionStreamResponse] =
    FF.liftF(GetStreamingSessionStreamOp(request))

  def getStudio(
    request: GetStudioRequest
  ): NimbleIO[GetStudioResponse] =
    FF.liftF(GetStudioOp(request))

  def getStudioComponent(
    request: GetStudioComponentRequest
  ): NimbleIO[GetStudioComponentResponse] =
    FF.liftF(GetStudioComponentOp(request))

  def getStudioMember(
    request: GetStudioMemberRequest
  ): NimbleIO[GetStudioMemberResponse] =
    FF.liftF(GetStudioMemberOp(request))

  def listEulaAcceptances(
    request: ListEulaAcceptancesRequest
  ): NimbleIO[ListEulaAcceptancesResponse] =
    FF.liftF(ListEulaAcceptancesOp(request))

  def listEulas(
    request: ListEulasRequest
  ): NimbleIO[ListEulasResponse] =
    FF.liftF(ListEulasOp(request))

  def listLaunchProfileMembers(
    request: ListLaunchProfileMembersRequest
  ): NimbleIO[ListLaunchProfileMembersResponse] =
    FF.liftF(ListLaunchProfileMembersOp(request))

  def listLaunchProfiles(
    request: ListLaunchProfilesRequest
  ): NimbleIO[ListLaunchProfilesResponse] =
    FF.liftF(ListLaunchProfilesOp(request))

  def listStreamingImages(
    request: ListStreamingImagesRequest
  ): NimbleIO[ListStreamingImagesResponse] =
    FF.liftF(ListStreamingImagesOp(request))

  def listStreamingSessions(
    request: ListStreamingSessionsRequest
  ): NimbleIO[ListStreamingSessionsResponse] =
    FF.liftF(ListStreamingSessionsOp(request))

  def listStudioComponents(
    request: ListStudioComponentsRequest
  ): NimbleIO[ListStudioComponentsResponse] =
    FF.liftF(ListStudioComponentsOp(request))

  def listStudioMembers(
    request: ListStudioMembersRequest
  ): NimbleIO[ListStudioMembersResponse] =
    FF.liftF(ListStudioMembersOp(request))

  def listStudios(
    request: ListStudiosRequest
  ): NimbleIO[ListStudiosResponse] =
    FF.liftF(ListStudiosOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): NimbleIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putLaunchProfileMembers(
    request: PutLaunchProfileMembersRequest
  ): NimbleIO[PutLaunchProfileMembersResponse] =
    FF.liftF(PutLaunchProfileMembersOp(request))

  def putStudioMembers(
    request: PutStudioMembersRequest
  ): NimbleIO[PutStudioMembersResponse] =
    FF.liftF(PutStudioMembersOp(request))

  def startStudioSSOConfigurationRepair(
    request: StartStudioSsoConfigurationRepairRequest
  ): NimbleIO[StartStudioSsoConfigurationRepairResponse] =
    FF.liftF(StartStudioSSOConfigurationRepairOp(request))

  def tagResource(
    request: TagResourceRequest
  ): NimbleIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): NimbleIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateLaunchProfile(
    request: UpdateLaunchProfileRequest
  ): NimbleIO[UpdateLaunchProfileResponse] =
    FF.liftF(UpdateLaunchProfileOp(request))

  def updateLaunchProfileMember(
    request: UpdateLaunchProfileMemberRequest
  ): NimbleIO[UpdateLaunchProfileMemberResponse] =
    FF.liftF(UpdateLaunchProfileMemberOp(request))

  def updateStreamingImage(
    request: UpdateStreamingImageRequest
  ): NimbleIO[UpdateStreamingImageResponse] =
    FF.liftF(UpdateStreamingImageOp(request))

  def updateStudio(
    request: UpdateStudioRequest
  ): NimbleIO[UpdateStudioResponse] =
    FF.liftF(UpdateStudioOp(request))

  def updateStudioComponent(
    request: UpdateStudioComponentRequest
  ): NimbleIO[UpdateStudioComponentResponse] =
    FF.liftF(UpdateStudioComponentOp(request))
}
