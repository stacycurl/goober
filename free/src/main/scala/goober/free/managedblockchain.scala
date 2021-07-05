package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.managedblockchain.ManagedBlockchainClient
import software.amazon.awssdk.services.managedblockchain.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object managedblockchain { module =>

  // Free monad over ManagedBlockchainOp
  type ManagedBlockchainIO[A] = FF[ManagedBlockchainOp, A]

  sealed trait ManagedBlockchainOp[A] {
    def visit[F[_]](visitor: ManagedBlockchainOp.Visitor[F]): F[A]
  }

  object ManagedBlockchainOp {
    // Given a ManagedBlockchainClient we can embed a ManagedBlockchainIO program in any algebra that understands embedding.
    implicit val ManagedBlockchainOpEmbeddable: Embeddable[ManagedBlockchainOp, ManagedBlockchainClient] = new Embeddable[ManagedBlockchainOp, ManagedBlockchainClient] {
      def embed[A](client: ManagedBlockchainClient, io: ManagedBlockchainIO[A]): Embedded[A] = Embedded.ManagedBlockchain(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ManagedBlockchainOp.Visitor[Kleisli[M, ManagedBlockchainClient, *]] {
        def createMember(
          request: CreateMemberRequest
        ): Kleisli[M, ManagedBlockchainClient, CreateMemberResponse] =
          primitive(_.createMember(request))

        def createNetwork(
          request: CreateNetworkRequest
        ): Kleisli[M, ManagedBlockchainClient, CreateNetworkResponse] =
          primitive(_.createNetwork(request))

        def createNode(
          request: CreateNodeRequest
        ): Kleisli[M, ManagedBlockchainClient, CreateNodeResponse] =
          primitive(_.createNode(request))

        def createProposal(
          request: CreateProposalRequest
        ): Kleisli[M, ManagedBlockchainClient, CreateProposalResponse] =
          primitive(_.createProposal(request))

        def deleteMember(
          request: DeleteMemberRequest
        ): Kleisli[M, ManagedBlockchainClient, DeleteMemberResponse] =
          primitive(_.deleteMember(request))

        def deleteNode(
          request: DeleteNodeRequest
        ): Kleisli[M, ManagedBlockchainClient, DeleteNodeResponse] =
          primitive(_.deleteNode(request))

        def getMember(
          request: GetMemberRequest
        ): Kleisli[M, ManagedBlockchainClient, GetMemberResponse] =
          primitive(_.getMember(request))

        def getNetwork(
          request: GetNetworkRequest
        ): Kleisli[M, ManagedBlockchainClient, GetNetworkResponse] =
          primitive(_.getNetwork(request))

        def getNode(
          request: GetNodeRequest
        ): Kleisli[M, ManagedBlockchainClient, GetNodeResponse] =
          primitive(_.getNode(request))

        def getProposal(
          request: GetProposalRequest
        ): Kleisli[M, ManagedBlockchainClient, GetProposalResponse] =
          primitive(_.getProposal(request))

        def listInvitations(
          request: ListInvitationsRequest
        ): Kleisli[M, ManagedBlockchainClient, ListInvitationsResponse] =
          primitive(_.listInvitations(request))

        def listMembers(
          request: ListMembersRequest
        ): Kleisli[M, ManagedBlockchainClient, ListMembersResponse] =
          primitive(_.listMembers(request))

        def listNetworks(
          request: ListNetworksRequest
        ): Kleisli[M, ManagedBlockchainClient, ListNetworksResponse] =
          primitive(_.listNetworks(request))

        def listNodes(
          request: ListNodesRequest
        ): Kleisli[M, ManagedBlockchainClient, ListNodesResponse] =
          primitive(_.listNodes(request))

        def listProposalVotes(
          request: ListProposalVotesRequest
        ): Kleisli[M, ManagedBlockchainClient, ListProposalVotesResponse] =
          primitive(_.listProposalVotes(request))

        def listProposals(
          request: ListProposalsRequest
        ): Kleisli[M, ManagedBlockchainClient, ListProposalsResponse] =
          primitive(_.listProposals(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, ManagedBlockchainClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def rejectInvitation(
          request: RejectInvitationRequest
        ): Kleisli[M, ManagedBlockchainClient, RejectInvitationResponse] =
          primitive(_.rejectInvitation(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, ManagedBlockchainClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, ManagedBlockchainClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateMember(
          request: UpdateMemberRequest
        ): Kleisli[M, ManagedBlockchainClient, UpdateMemberResponse] =
          primitive(_.updateMember(request))

        def updateNode(
          request: UpdateNodeRequest
        ): Kleisli[M, ManagedBlockchainClient, UpdateNodeResponse] =
          primitive(_.updateNode(request))

        def voteOnProposal(
          request: VoteOnProposalRequest
        ): Kleisli[M, ManagedBlockchainClient, VoteOnProposalResponse] =
          primitive(_.voteOnProposal(request))

        def primitive[A](
          f: ManagedBlockchainClient => A
        ): Kleisli[M, ManagedBlockchainClient, A]
      }
    }

    trait Visitor[F[_]] extends (ManagedBlockchainOp ~> F) {
      final def apply[A](op: ManagedBlockchainOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createMember(
        request: CreateMemberRequest
      ): F[CreateMemberResponse]

      def createNetwork(
        request: CreateNetworkRequest
      ): F[CreateNetworkResponse]

      def createNode(
        request: CreateNodeRequest
      ): F[CreateNodeResponse]

      def createProposal(
        request: CreateProposalRequest
      ): F[CreateProposalResponse]

      def deleteMember(
        request: DeleteMemberRequest
      ): F[DeleteMemberResponse]

      def deleteNode(
        request: DeleteNodeRequest
      ): F[DeleteNodeResponse]

      def getMember(
        request: GetMemberRequest
      ): F[GetMemberResponse]

      def getNetwork(
        request: GetNetworkRequest
      ): F[GetNetworkResponse]

      def getNode(
        request: GetNodeRequest
      ): F[GetNodeResponse]

      def getProposal(
        request: GetProposalRequest
      ): F[GetProposalResponse]

      def listInvitations(
        request: ListInvitationsRequest
      ): F[ListInvitationsResponse]

      def listMembers(
        request: ListMembersRequest
      ): F[ListMembersResponse]

      def listNetworks(
        request: ListNetworksRequest
      ): F[ListNetworksResponse]

      def listNodes(
        request: ListNodesRequest
      ): F[ListNodesResponse]

      def listProposalVotes(
        request: ListProposalVotesRequest
      ): F[ListProposalVotesResponse]

      def listProposals(
        request: ListProposalsRequest
      ): F[ListProposalsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def rejectInvitation(
        request: RejectInvitationRequest
      ): F[RejectInvitationResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateMember(
        request: UpdateMemberRequest
      ): F[UpdateMemberResponse]

      def updateNode(
        request: UpdateNodeRequest
      ): F[UpdateNodeResponse]

      def voteOnProposal(
        request: VoteOnProposalRequest
      ): F[VoteOnProposalResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ManagedBlockchainOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateMemberOp(
      request: CreateMemberRequest
    ) extends ManagedBlockchainOp[CreateMemberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMemberResponse] =
        visitor.createMember(request)
    }

    final case class CreateNetworkOp(
      request: CreateNetworkRequest
    ) extends ManagedBlockchainOp[CreateNetworkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateNetworkResponse] =
        visitor.createNetwork(request)
    }

    final case class CreateNodeOp(
      request: CreateNodeRequest
    ) extends ManagedBlockchainOp[CreateNodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateNodeResponse] =
        visitor.createNode(request)
    }

    final case class CreateProposalOp(
      request: CreateProposalRequest
    ) extends ManagedBlockchainOp[CreateProposalResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProposalResponse] =
        visitor.createProposal(request)
    }

    final case class DeleteMemberOp(
      request: DeleteMemberRequest
    ) extends ManagedBlockchainOp[DeleteMemberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMemberResponse] =
        visitor.deleteMember(request)
    }

    final case class DeleteNodeOp(
      request: DeleteNodeRequest
    ) extends ManagedBlockchainOp[DeleteNodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNodeResponse] =
        visitor.deleteNode(request)
    }

    final case class GetMemberOp(
      request: GetMemberRequest
    ) extends ManagedBlockchainOp[GetMemberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMemberResponse] =
        visitor.getMember(request)
    }

    final case class GetNetworkOp(
      request: GetNetworkRequest
    ) extends ManagedBlockchainOp[GetNetworkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetNetworkResponse] =
        visitor.getNetwork(request)
    }

    final case class GetNodeOp(
      request: GetNodeRequest
    ) extends ManagedBlockchainOp[GetNodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetNodeResponse] =
        visitor.getNode(request)
    }

    final case class GetProposalOp(
      request: GetProposalRequest
    ) extends ManagedBlockchainOp[GetProposalResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetProposalResponse] =
        visitor.getProposal(request)
    }

    final case class ListInvitationsOp(
      request: ListInvitationsRequest
    ) extends ManagedBlockchainOp[ListInvitationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInvitationsResponse] =
        visitor.listInvitations(request)
    }

    final case class ListMembersOp(
      request: ListMembersRequest
    ) extends ManagedBlockchainOp[ListMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMembersResponse] =
        visitor.listMembers(request)
    }

    final case class ListNetworksOp(
      request: ListNetworksRequest
    ) extends ManagedBlockchainOp[ListNetworksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListNetworksResponse] =
        visitor.listNetworks(request)
    }

    final case class ListNodesOp(
      request: ListNodesRequest
    ) extends ManagedBlockchainOp[ListNodesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListNodesResponse] =
        visitor.listNodes(request)
    }

    final case class ListProposalVotesOp(
      request: ListProposalVotesRequest
    ) extends ManagedBlockchainOp[ListProposalVotesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProposalVotesResponse] =
        visitor.listProposalVotes(request)
    }

    final case class ListProposalsOp(
      request: ListProposalsRequest
    ) extends ManagedBlockchainOp[ListProposalsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProposalsResponse] =
        visitor.listProposals(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends ManagedBlockchainOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class RejectInvitationOp(
      request: RejectInvitationRequest
    ) extends ManagedBlockchainOp[RejectInvitationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RejectInvitationResponse] =
        visitor.rejectInvitation(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends ManagedBlockchainOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends ManagedBlockchainOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateMemberOp(
      request: UpdateMemberRequest
    ) extends ManagedBlockchainOp[UpdateMemberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMemberResponse] =
        visitor.updateMember(request)
    }

    final case class UpdateNodeOp(
      request: UpdateNodeRequest
    ) extends ManagedBlockchainOp[UpdateNodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateNodeResponse] =
        visitor.updateNode(request)
    }

    final case class VoteOnProposalOp(
      request: VoteOnProposalRequest
    ) extends ManagedBlockchainOp[VoteOnProposalResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[VoteOnProposalResponse] =
        visitor.voteOnProposal(request)
    }
  }

  import ManagedBlockchainOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ManagedBlockchainOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createMember(
    request: CreateMemberRequest
  ): ManagedBlockchainIO[CreateMemberResponse] =
    FF.liftF(CreateMemberOp(request))

  def createNetwork(
    request: CreateNetworkRequest
  ): ManagedBlockchainIO[CreateNetworkResponse] =
    FF.liftF(CreateNetworkOp(request))

  def createNode(
    request: CreateNodeRequest
  ): ManagedBlockchainIO[CreateNodeResponse] =
    FF.liftF(CreateNodeOp(request))

  def createProposal(
    request: CreateProposalRequest
  ): ManagedBlockchainIO[CreateProposalResponse] =
    FF.liftF(CreateProposalOp(request))

  def deleteMember(
    request: DeleteMemberRequest
  ): ManagedBlockchainIO[DeleteMemberResponse] =
    FF.liftF(DeleteMemberOp(request))

  def deleteNode(
    request: DeleteNodeRequest
  ): ManagedBlockchainIO[DeleteNodeResponse] =
    FF.liftF(DeleteNodeOp(request))

  def getMember(
    request: GetMemberRequest
  ): ManagedBlockchainIO[GetMemberResponse] =
    FF.liftF(GetMemberOp(request))

  def getNetwork(
    request: GetNetworkRequest
  ): ManagedBlockchainIO[GetNetworkResponse] =
    FF.liftF(GetNetworkOp(request))

  def getNode(
    request: GetNodeRequest
  ): ManagedBlockchainIO[GetNodeResponse] =
    FF.liftF(GetNodeOp(request))

  def getProposal(
    request: GetProposalRequest
  ): ManagedBlockchainIO[GetProposalResponse] =
    FF.liftF(GetProposalOp(request))

  def listInvitations(
    request: ListInvitationsRequest
  ): ManagedBlockchainIO[ListInvitationsResponse] =
    FF.liftF(ListInvitationsOp(request))

  def listMembers(
    request: ListMembersRequest
  ): ManagedBlockchainIO[ListMembersResponse] =
    FF.liftF(ListMembersOp(request))

  def listNetworks(
    request: ListNetworksRequest
  ): ManagedBlockchainIO[ListNetworksResponse] =
    FF.liftF(ListNetworksOp(request))

  def listNodes(
    request: ListNodesRequest
  ): ManagedBlockchainIO[ListNodesResponse] =
    FF.liftF(ListNodesOp(request))

  def listProposalVotes(
    request: ListProposalVotesRequest
  ): ManagedBlockchainIO[ListProposalVotesResponse] =
    FF.liftF(ListProposalVotesOp(request))

  def listProposals(
    request: ListProposalsRequest
  ): ManagedBlockchainIO[ListProposalsResponse] =
    FF.liftF(ListProposalsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): ManagedBlockchainIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def rejectInvitation(
    request: RejectInvitationRequest
  ): ManagedBlockchainIO[RejectInvitationResponse] =
    FF.liftF(RejectInvitationOp(request))

  def tagResource(
    request: TagResourceRequest
  ): ManagedBlockchainIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): ManagedBlockchainIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateMember(
    request: UpdateMemberRequest
  ): ManagedBlockchainIO[UpdateMemberResponse] =
    FF.liftF(UpdateMemberOp(request))

  def updateNode(
    request: UpdateNodeRequest
  ): ManagedBlockchainIO[UpdateNodeResponse] =
    FF.liftF(UpdateNodeOp(request))

  def voteOnProposal(
    request: VoteOnProposalRequest
  ): ManagedBlockchainIO[VoteOnProposalResponse] =
    FF.liftF(VoteOnProposalOp(request))
}
