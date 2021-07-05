package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.ssmcontacts.SsmContactsClient
import software.amazon.awssdk.services.ssmcontacts.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object ssmcontacts { module =>

  // Free monad over SsmContactsOp
  type SsmContactsIO[A] = FF[SsmContactsOp, A]

  sealed trait SsmContactsOp[A] {
    def visit[F[_]](visitor: SsmContactsOp.Visitor[F]): F[A]
  }

  object SsmContactsOp {
    // Given a SsmContactsClient we can embed a SsmContactsIO program in any algebra that understands embedding.
    implicit val SsmContactsOpEmbeddable: Embeddable[SsmContactsOp, SsmContactsClient] = new Embeddable[SsmContactsOp, SsmContactsClient] {
      def embed[A](client: SsmContactsClient, io: SsmContactsIO[A]): Embedded[A] = Embedded.SsmContacts(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SsmContactsOp.Visitor[Kleisli[M, SsmContactsClient, *]] {
        def acceptPage(
          request: AcceptPageRequest
        ): Kleisli[M, SsmContactsClient, AcceptPageResponse] =
          primitive(_.acceptPage(request))

        def activateContactChannel(
          request: ActivateContactChannelRequest
        ): Kleisli[M, SsmContactsClient, ActivateContactChannelResponse] =
          primitive(_.activateContactChannel(request))

        def createContact(
          request: CreateContactRequest
        ): Kleisli[M, SsmContactsClient, CreateContactResponse] =
          primitive(_.createContact(request))

        def createContactChannel(
          request: CreateContactChannelRequest
        ): Kleisli[M, SsmContactsClient, CreateContactChannelResponse] =
          primitive(_.createContactChannel(request))

        def deactivateContactChannel(
          request: DeactivateContactChannelRequest
        ): Kleisli[M, SsmContactsClient, DeactivateContactChannelResponse] =
          primitive(_.deactivateContactChannel(request))

        def deleteContact(
          request: DeleteContactRequest
        ): Kleisli[M, SsmContactsClient, DeleteContactResponse] =
          primitive(_.deleteContact(request))

        def deleteContactChannel(
          request: DeleteContactChannelRequest
        ): Kleisli[M, SsmContactsClient, DeleteContactChannelResponse] =
          primitive(_.deleteContactChannel(request))

        def describeEngagement(
          request: DescribeEngagementRequest
        ): Kleisli[M, SsmContactsClient, DescribeEngagementResponse] =
          primitive(_.describeEngagement(request))

        def describePage(
          request: DescribePageRequest
        ): Kleisli[M, SsmContactsClient, DescribePageResponse] =
          primitive(_.describePage(request))

        def getContact(
          request: GetContactRequest
        ): Kleisli[M, SsmContactsClient, GetContactResponse] =
          primitive(_.getContact(request))

        def getContactChannel(
          request: GetContactChannelRequest
        ): Kleisli[M, SsmContactsClient, GetContactChannelResponse] =
          primitive(_.getContactChannel(request))

        def getContactPolicy(
          request: GetContactPolicyRequest
        ): Kleisli[M, SsmContactsClient, GetContactPolicyResponse] =
          primitive(_.getContactPolicy(request))

        def listContactChannels(
          request: ListContactChannelsRequest
        ): Kleisli[M, SsmContactsClient, ListContactChannelsResponse] =
          primitive(_.listContactChannels(request))

        def listContacts(
          request: ListContactsRequest
        ): Kleisli[M, SsmContactsClient, ListContactsResponse] =
          primitive(_.listContacts(request))

        def listEngagements(
          request: ListEngagementsRequest
        ): Kleisli[M, SsmContactsClient, ListEngagementsResponse] =
          primitive(_.listEngagements(request))

        def listPageReceipts(
          request: ListPageReceiptsRequest
        ): Kleisli[M, SsmContactsClient, ListPageReceiptsResponse] =
          primitive(_.listPageReceipts(request))

        def listPagesByContact(
          request: ListPagesByContactRequest
        ): Kleisli[M, SsmContactsClient, ListPagesByContactResponse] =
          primitive(_.listPagesByContact(request))

        def listPagesByEngagement(
          request: ListPagesByEngagementRequest
        ): Kleisli[M, SsmContactsClient, ListPagesByEngagementResponse] =
          primitive(_.listPagesByEngagement(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, SsmContactsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putContactPolicy(
          request: PutContactPolicyRequest
        ): Kleisli[M, SsmContactsClient, PutContactPolicyResponse] =
          primitive(_.putContactPolicy(request))

        def sendActivationCode(
          request: SendActivationCodeRequest
        ): Kleisli[M, SsmContactsClient, SendActivationCodeResponse] =
          primitive(_.sendActivationCode(request))

        def startEngagement(
          request: StartEngagementRequest
        ): Kleisli[M, SsmContactsClient, StartEngagementResponse] =
          primitive(_.startEngagement(request))

        def stopEngagement(
          request: StopEngagementRequest
        ): Kleisli[M, SsmContactsClient, StopEngagementResponse] =
          primitive(_.stopEngagement(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, SsmContactsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, SsmContactsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateContact(
          request: UpdateContactRequest
        ): Kleisli[M, SsmContactsClient, UpdateContactResponse] =
          primitive(_.updateContact(request))

        def updateContactChannel(
          request: UpdateContactChannelRequest
        ): Kleisli[M, SsmContactsClient, UpdateContactChannelResponse] =
          primitive(_.updateContactChannel(request))

        def primitive[A](
          f: SsmContactsClient => A
        ): Kleisli[M, SsmContactsClient, A]
      }
    }

    trait Visitor[F[_]] extends (SsmContactsOp ~> F) {
      final def apply[A](op: SsmContactsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptPage(
        request: AcceptPageRequest
      ): F[AcceptPageResponse]

      def activateContactChannel(
        request: ActivateContactChannelRequest
      ): F[ActivateContactChannelResponse]

      def createContact(
        request: CreateContactRequest
      ): F[CreateContactResponse]

      def createContactChannel(
        request: CreateContactChannelRequest
      ): F[CreateContactChannelResponse]

      def deactivateContactChannel(
        request: DeactivateContactChannelRequest
      ): F[DeactivateContactChannelResponse]

      def deleteContact(
        request: DeleteContactRequest
      ): F[DeleteContactResponse]

      def deleteContactChannel(
        request: DeleteContactChannelRequest
      ): F[DeleteContactChannelResponse]

      def describeEngagement(
        request: DescribeEngagementRequest
      ): F[DescribeEngagementResponse]

      def describePage(
        request: DescribePageRequest
      ): F[DescribePageResponse]

      def getContact(
        request: GetContactRequest
      ): F[GetContactResponse]

      def getContactChannel(
        request: GetContactChannelRequest
      ): F[GetContactChannelResponse]

      def getContactPolicy(
        request: GetContactPolicyRequest
      ): F[GetContactPolicyResponse]

      def listContactChannels(
        request: ListContactChannelsRequest
      ): F[ListContactChannelsResponse]

      def listContacts(
        request: ListContactsRequest
      ): F[ListContactsResponse]

      def listEngagements(
        request: ListEngagementsRequest
      ): F[ListEngagementsResponse]

      def listPageReceipts(
        request: ListPageReceiptsRequest
      ): F[ListPageReceiptsResponse]

      def listPagesByContact(
        request: ListPagesByContactRequest
      ): F[ListPagesByContactResponse]

      def listPagesByEngagement(
        request: ListPagesByEngagementRequest
      ): F[ListPagesByEngagementResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putContactPolicy(
        request: PutContactPolicyRequest
      ): F[PutContactPolicyResponse]

      def sendActivationCode(
        request: SendActivationCodeRequest
      ): F[SendActivationCodeResponse]

      def startEngagement(
        request: StartEngagementRequest
      ): F[StartEngagementResponse]

      def stopEngagement(
        request: StopEngagementRequest
      ): F[StopEngagementResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateContact(
        request: UpdateContactRequest
      ): F[UpdateContactResponse]

      def updateContactChannel(
        request: UpdateContactChannelRequest
      ): F[UpdateContactChannelResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SsmContactsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptPageOp(
      request: AcceptPageRequest
    ) extends SsmContactsOp[AcceptPageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptPageResponse] =
        visitor.acceptPage(request)
    }

    final case class ActivateContactChannelOp(
      request: ActivateContactChannelRequest
    ) extends SsmContactsOp[ActivateContactChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ActivateContactChannelResponse] =
        visitor.activateContactChannel(request)
    }

    final case class CreateContactOp(
      request: CreateContactRequest
    ) extends SsmContactsOp[CreateContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateContactResponse] =
        visitor.createContact(request)
    }

    final case class CreateContactChannelOp(
      request: CreateContactChannelRequest
    ) extends SsmContactsOp[CreateContactChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateContactChannelResponse] =
        visitor.createContactChannel(request)
    }

    final case class DeactivateContactChannelOp(
      request: DeactivateContactChannelRequest
    ) extends SsmContactsOp[DeactivateContactChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeactivateContactChannelResponse] =
        visitor.deactivateContactChannel(request)
    }

    final case class DeleteContactOp(
      request: DeleteContactRequest
    ) extends SsmContactsOp[DeleteContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteContactResponse] =
        visitor.deleteContact(request)
    }

    final case class DeleteContactChannelOp(
      request: DeleteContactChannelRequest
    ) extends SsmContactsOp[DeleteContactChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteContactChannelResponse] =
        visitor.deleteContactChannel(request)
    }

    final case class DescribeEngagementOp(
      request: DescribeEngagementRequest
    ) extends SsmContactsOp[DescribeEngagementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEngagementResponse] =
        visitor.describeEngagement(request)
    }

    final case class DescribePageOp(
      request: DescribePageRequest
    ) extends SsmContactsOp[DescribePageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePageResponse] =
        visitor.describePage(request)
    }

    final case class GetContactOp(
      request: GetContactRequest
    ) extends SsmContactsOp[GetContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContactResponse] =
        visitor.getContact(request)
    }

    final case class GetContactChannelOp(
      request: GetContactChannelRequest
    ) extends SsmContactsOp[GetContactChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContactChannelResponse] =
        visitor.getContactChannel(request)
    }

    final case class GetContactPolicyOp(
      request: GetContactPolicyRequest
    ) extends SsmContactsOp[GetContactPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContactPolicyResponse] =
        visitor.getContactPolicy(request)
    }

    final case class ListContactChannelsOp(
      request: ListContactChannelsRequest
    ) extends SsmContactsOp[ListContactChannelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListContactChannelsResponse] =
        visitor.listContactChannels(request)
    }

    final case class ListContactsOp(
      request: ListContactsRequest
    ) extends SsmContactsOp[ListContactsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListContactsResponse] =
        visitor.listContacts(request)
    }

    final case class ListEngagementsOp(
      request: ListEngagementsRequest
    ) extends SsmContactsOp[ListEngagementsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEngagementsResponse] =
        visitor.listEngagements(request)
    }

    final case class ListPageReceiptsOp(
      request: ListPageReceiptsRequest
    ) extends SsmContactsOp[ListPageReceiptsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPageReceiptsResponse] =
        visitor.listPageReceipts(request)
    }

    final case class ListPagesByContactOp(
      request: ListPagesByContactRequest
    ) extends SsmContactsOp[ListPagesByContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPagesByContactResponse] =
        visitor.listPagesByContact(request)
    }

    final case class ListPagesByEngagementOp(
      request: ListPagesByEngagementRequest
    ) extends SsmContactsOp[ListPagesByEngagementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPagesByEngagementResponse] =
        visitor.listPagesByEngagement(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends SsmContactsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutContactPolicyOp(
      request: PutContactPolicyRequest
    ) extends SsmContactsOp[PutContactPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutContactPolicyResponse] =
        visitor.putContactPolicy(request)
    }

    final case class SendActivationCodeOp(
      request: SendActivationCodeRequest
    ) extends SsmContactsOp[SendActivationCodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendActivationCodeResponse] =
        visitor.sendActivationCode(request)
    }

    final case class StartEngagementOp(
      request: StartEngagementRequest
    ) extends SsmContactsOp[StartEngagementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartEngagementResponse] =
        visitor.startEngagement(request)
    }

    final case class StopEngagementOp(
      request: StopEngagementRequest
    ) extends SsmContactsOp[StopEngagementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopEngagementResponse] =
        visitor.stopEngagement(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends SsmContactsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends SsmContactsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateContactOp(
      request: UpdateContactRequest
    ) extends SsmContactsOp[UpdateContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateContactResponse] =
        visitor.updateContact(request)
    }

    final case class UpdateContactChannelOp(
      request: UpdateContactChannelRequest
    ) extends SsmContactsOp[UpdateContactChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateContactChannelResponse] =
        visitor.updateContactChannel(request)
    }
  }

  import SsmContactsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SsmContactsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptPage(
    request: AcceptPageRequest
  ): SsmContactsIO[AcceptPageResponse] =
    FF.liftF(AcceptPageOp(request))

  def activateContactChannel(
    request: ActivateContactChannelRequest
  ): SsmContactsIO[ActivateContactChannelResponse] =
    FF.liftF(ActivateContactChannelOp(request))

  def createContact(
    request: CreateContactRequest
  ): SsmContactsIO[CreateContactResponse] =
    FF.liftF(CreateContactOp(request))

  def createContactChannel(
    request: CreateContactChannelRequest
  ): SsmContactsIO[CreateContactChannelResponse] =
    FF.liftF(CreateContactChannelOp(request))

  def deactivateContactChannel(
    request: DeactivateContactChannelRequest
  ): SsmContactsIO[DeactivateContactChannelResponse] =
    FF.liftF(DeactivateContactChannelOp(request))

  def deleteContact(
    request: DeleteContactRequest
  ): SsmContactsIO[DeleteContactResponse] =
    FF.liftF(DeleteContactOp(request))

  def deleteContactChannel(
    request: DeleteContactChannelRequest
  ): SsmContactsIO[DeleteContactChannelResponse] =
    FF.liftF(DeleteContactChannelOp(request))

  def describeEngagement(
    request: DescribeEngagementRequest
  ): SsmContactsIO[DescribeEngagementResponse] =
    FF.liftF(DescribeEngagementOp(request))

  def describePage(
    request: DescribePageRequest
  ): SsmContactsIO[DescribePageResponse] =
    FF.liftF(DescribePageOp(request))

  def getContact(
    request: GetContactRequest
  ): SsmContactsIO[GetContactResponse] =
    FF.liftF(GetContactOp(request))

  def getContactChannel(
    request: GetContactChannelRequest
  ): SsmContactsIO[GetContactChannelResponse] =
    FF.liftF(GetContactChannelOp(request))

  def getContactPolicy(
    request: GetContactPolicyRequest
  ): SsmContactsIO[GetContactPolicyResponse] =
    FF.liftF(GetContactPolicyOp(request))

  def listContactChannels(
    request: ListContactChannelsRequest
  ): SsmContactsIO[ListContactChannelsResponse] =
    FF.liftF(ListContactChannelsOp(request))

  def listContacts(
    request: ListContactsRequest
  ): SsmContactsIO[ListContactsResponse] =
    FF.liftF(ListContactsOp(request))

  def listEngagements(
    request: ListEngagementsRequest
  ): SsmContactsIO[ListEngagementsResponse] =
    FF.liftF(ListEngagementsOp(request))

  def listPageReceipts(
    request: ListPageReceiptsRequest
  ): SsmContactsIO[ListPageReceiptsResponse] =
    FF.liftF(ListPageReceiptsOp(request))

  def listPagesByContact(
    request: ListPagesByContactRequest
  ): SsmContactsIO[ListPagesByContactResponse] =
    FF.liftF(ListPagesByContactOp(request))

  def listPagesByEngagement(
    request: ListPagesByEngagementRequest
  ): SsmContactsIO[ListPagesByEngagementResponse] =
    FF.liftF(ListPagesByEngagementOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): SsmContactsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putContactPolicy(
    request: PutContactPolicyRequest
  ): SsmContactsIO[PutContactPolicyResponse] =
    FF.liftF(PutContactPolicyOp(request))

  def sendActivationCode(
    request: SendActivationCodeRequest
  ): SsmContactsIO[SendActivationCodeResponse] =
    FF.liftF(SendActivationCodeOp(request))

  def startEngagement(
    request: StartEngagementRequest
  ): SsmContactsIO[StartEngagementResponse] =
    FF.liftF(StartEngagementOp(request))

  def stopEngagement(
    request: StopEngagementRequest
  ): SsmContactsIO[StopEngagementResponse] =
    FF.liftF(StopEngagementOp(request))

  def tagResource(
    request: TagResourceRequest
  ): SsmContactsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): SsmContactsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateContact(
    request: UpdateContactRequest
  ): SsmContactsIO[UpdateContactResponse] =
    FF.liftF(UpdateContactOp(request))

  def updateContactChannel(
    request: UpdateContactChannelRequest
  ): SsmContactsIO[UpdateContactChannelResponse] =
    FF.liftF(UpdateContactChannelOp(request))
}
