package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.detective.DetectiveClient
import software.amazon.awssdk.services.detective.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object detective { module =>

  // Free monad over DetectiveOp
  type DetectiveIO[A] = FF[DetectiveOp, A]

  sealed trait DetectiveOp[A] {
    def visit[F[_]](visitor: DetectiveOp.Visitor[F]): F[A]
  }

  object DetectiveOp {
    // Given a DetectiveClient we can embed a DetectiveIO program in any algebra that understands embedding.
    implicit val DetectiveOpEmbeddable: Embeddable[DetectiveOp, DetectiveClient] = new Embeddable[DetectiveOp, DetectiveClient] {
      def embed[A](client: DetectiveClient, io: DetectiveIO[A]): Embedded[A] = Embedded.Detective(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends DetectiveOp.Visitor[Kleisli[M, DetectiveClient, *]] {
        def acceptInvitation(
          request: AcceptInvitationRequest
        ): Kleisli[M, DetectiveClient, AcceptInvitationResponse] =
          primitive(_.acceptInvitation(request))

        def createGraph(
          request: CreateGraphRequest
        ): Kleisli[M, DetectiveClient, CreateGraphResponse] =
          primitive(_.createGraph(request))

        def createMembers(
          request: CreateMembersRequest
        ): Kleisli[M, DetectiveClient, CreateMembersResponse] =
          primitive(_.createMembers(request))

        def deleteGraph(
          request: DeleteGraphRequest
        ): Kleisli[M, DetectiveClient, DeleteGraphResponse] =
          primitive(_.deleteGraph(request))

        def deleteMembers(
          request: DeleteMembersRequest
        ): Kleisli[M, DetectiveClient, DeleteMembersResponse] =
          primitive(_.deleteMembers(request))

        def disassociateMembership(
          request: DisassociateMembershipRequest
        ): Kleisli[M, DetectiveClient, DisassociateMembershipResponse] =
          primitive(_.disassociateMembership(request))

        def getMembers(
          request: GetMembersRequest
        ): Kleisli[M, DetectiveClient, GetMembersResponse] =
          primitive(_.getMembers(request))

        def listGraphs(
          request: ListGraphsRequest
        ): Kleisli[M, DetectiveClient, ListGraphsResponse] =
          primitive(_.listGraphs(request))

        def listInvitations(
          request: ListInvitationsRequest
        ): Kleisli[M, DetectiveClient, ListInvitationsResponse] =
          primitive(_.listInvitations(request))

        def listMembers(
          request: ListMembersRequest
        ): Kleisli[M, DetectiveClient, ListMembersResponse] =
          primitive(_.listMembers(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, DetectiveClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def rejectInvitation(
          request: RejectInvitationRequest
        ): Kleisli[M, DetectiveClient, RejectInvitationResponse] =
          primitive(_.rejectInvitation(request))

        def startMonitoringMember(
          request: StartMonitoringMemberRequest
        ): Kleisli[M, DetectiveClient, StartMonitoringMemberResponse] =
          primitive(_.startMonitoringMember(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, DetectiveClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, DetectiveClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: DetectiveClient => A
        ): Kleisli[M, DetectiveClient, A]
      }
    }

    trait Visitor[F[_]] extends (DetectiveOp ~> F) {
      final def apply[A](op: DetectiveOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptInvitation(
        request: AcceptInvitationRequest
      ): F[AcceptInvitationResponse]

      def createGraph(
        request: CreateGraphRequest
      ): F[CreateGraphResponse]

      def createMembers(
        request: CreateMembersRequest
      ): F[CreateMembersResponse]

      def deleteGraph(
        request: DeleteGraphRequest
      ): F[DeleteGraphResponse]

      def deleteMembers(
        request: DeleteMembersRequest
      ): F[DeleteMembersResponse]

      def disassociateMembership(
        request: DisassociateMembershipRequest
      ): F[DisassociateMembershipResponse]

      def getMembers(
        request: GetMembersRequest
      ): F[GetMembersResponse]

      def listGraphs(
        request: ListGraphsRequest
      ): F[ListGraphsResponse]

      def listInvitations(
        request: ListInvitationsRequest
      ): F[ListInvitationsResponse]

      def listMembers(
        request: ListMembersRequest
      ): F[ListMembersResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def rejectInvitation(
        request: RejectInvitationRequest
      ): F[RejectInvitationResponse]

      def startMonitoringMember(
        request: StartMonitoringMemberRequest
      ): F[StartMonitoringMemberResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends DetectiveOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptInvitationOp(
      request: AcceptInvitationRequest
    ) extends DetectiveOp[AcceptInvitationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptInvitationResponse] =
        visitor.acceptInvitation(request)
    }

    final case class CreateGraphOp(
      request: CreateGraphRequest
    ) extends DetectiveOp[CreateGraphResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGraphResponse] =
        visitor.createGraph(request)
    }

    final case class CreateMembersOp(
      request: CreateMembersRequest
    ) extends DetectiveOp[CreateMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMembersResponse] =
        visitor.createMembers(request)
    }

    final case class DeleteGraphOp(
      request: DeleteGraphRequest
    ) extends DetectiveOp[DeleteGraphResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGraphResponse] =
        visitor.deleteGraph(request)
    }

    final case class DeleteMembersOp(
      request: DeleteMembersRequest
    ) extends DetectiveOp[DeleteMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMembersResponse] =
        visitor.deleteMembers(request)
    }

    final case class DisassociateMembershipOp(
      request: DisassociateMembershipRequest
    ) extends DetectiveOp[DisassociateMembershipResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateMembershipResponse] =
        visitor.disassociateMembership(request)
    }

    final case class GetMembersOp(
      request: GetMembersRequest
    ) extends DetectiveOp[GetMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMembersResponse] =
        visitor.getMembers(request)
    }

    final case class ListGraphsOp(
      request: ListGraphsRequest
    ) extends DetectiveOp[ListGraphsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGraphsResponse] =
        visitor.listGraphs(request)
    }

    final case class ListInvitationsOp(
      request: ListInvitationsRequest
    ) extends DetectiveOp[ListInvitationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInvitationsResponse] =
        visitor.listInvitations(request)
    }

    final case class ListMembersOp(
      request: ListMembersRequest
    ) extends DetectiveOp[ListMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMembersResponse] =
        visitor.listMembers(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends DetectiveOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class RejectInvitationOp(
      request: RejectInvitationRequest
    ) extends DetectiveOp[RejectInvitationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RejectInvitationResponse] =
        visitor.rejectInvitation(request)
    }

    final case class StartMonitoringMemberOp(
      request: StartMonitoringMemberRequest
    ) extends DetectiveOp[StartMonitoringMemberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartMonitoringMemberResponse] =
        visitor.startMonitoringMember(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends DetectiveOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends DetectiveOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import DetectiveOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[DetectiveOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptInvitation(
    request: AcceptInvitationRequest
  ): DetectiveIO[AcceptInvitationResponse] =
    FF.liftF(AcceptInvitationOp(request))

  def createGraph(
    request: CreateGraphRequest
  ): DetectiveIO[CreateGraphResponse] =
    FF.liftF(CreateGraphOp(request))

  def createMembers(
    request: CreateMembersRequest
  ): DetectiveIO[CreateMembersResponse] =
    FF.liftF(CreateMembersOp(request))

  def deleteGraph(
    request: DeleteGraphRequest
  ): DetectiveIO[DeleteGraphResponse] =
    FF.liftF(DeleteGraphOp(request))

  def deleteMembers(
    request: DeleteMembersRequest
  ): DetectiveIO[DeleteMembersResponse] =
    FF.liftF(DeleteMembersOp(request))

  def disassociateMembership(
    request: DisassociateMembershipRequest
  ): DetectiveIO[DisassociateMembershipResponse] =
    FF.liftF(DisassociateMembershipOp(request))

  def getMembers(
    request: GetMembersRequest
  ): DetectiveIO[GetMembersResponse] =
    FF.liftF(GetMembersOp(request))

  def listGraphs(
    request: ListGraphsRequest
  ): DetectiveIO[ListGraphsResponse] =
    FF.liftF(ListGraphsOp(request))

  def listInvitations(
    request: ListInvitationsRequest
  ): DetectiveIO[ListInvitationsResponse] =
    FF.liftF(ListInvitationsOp(request))

  def listMembers(
    request: ListMembersRequest
  ): DetectiveIO[ListMembersResponse] =
    FF.liftF(ListMembersOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): DetectiveIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def rejectInvitation(
    request: RejectInvitationRequest
  ): DetectiveIO[RejectInvitationResponse] =
    FF.liftF(RejectInvitationOp(request))

  def startMonitoringMember(
    request: StartMonitoringMemberRequest
  ): DetectiveIO[StartMonitoringMemberResponse] =
    FF.liftF(StartMonitoringMemberOp(request))

  def tagResource(
    request: TagResourceRequest
  ): DetectiveIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): DetectiveIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
