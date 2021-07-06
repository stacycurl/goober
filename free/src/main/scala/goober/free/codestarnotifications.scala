package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.codestarnotifications.CodestarNotificationsClient
import software.amazon.awssdk.services.codestarnotifications.model._


object codestarnotifications { module =>

  // Free monad over CodestarNotificationsOp
  type CodestarNotificationsIO[A] = FF[CodestarNotificationsOp, A]

  sealed trait CodestarNotificationsOp[A] {
    def visit[F[_]](visitor: CodestarNotificationsOp.Visitor[F]): F[A]
  }

  object CodestarNotificationsOp {
    // Given a CodestarNotificationsClient we can embed a CodestarNotificationsIO program in any algebra that understands embedding.
    implicit val CodestarNotificationsOpEmbeddable: Embeddable[CodestarNotificationsOp, CodestarNotificationsClient] = new Embeddable[CodestarNotificationsOp, CodestarNotificationsClient] {
      def embed[A](client: CodestarNotificationsClient, io: CodestarNotificationsIO[A]): Embedded[A] = Embedded.CodestarNotifications(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CodestarNotificationsOp.Visitor[Kleisli[M, CodestarNotificationsClient, *]] {
        def createNotificationRule(
          request: CreateNotificationRuleRequest
        ): Kleisli[M, CodestarNotificationsClient, CreateNotificationRuleResponse] =
          primitive(_.createNotificationRule(request))

        def deleteNotificationRule(
          request: DeleteNotificationRuleRequest
        ): Kleisli[M, CodestarNotificationsClient, DeleteNotificationRuleResponse] =
          primitive(_.deleteNotificationRule(request))

        def deleteTarget(
          request: DeleteTargetRequest
        ): Kleisli[M, CodestarNotificationsClient, DeleteTargetResponse] =
          primitive(_.deleteTarget(request))

        def describeNotificationRule(
          request: DescribeNotificationRuleRequest
        ): Kleisli[M, CodestarNotificationsClient, DescribeNotificationRuleResponse] =
          primitive(_.describeNotificationRule(request))

        def listEventTypes(
          request: ListEventTypesRequest
        ): Kleisli[M, CodestarNotificationsClient, ListEventTypesResponse] =
          primitive(_.listEventTypes(request))

        def listNotificationRules(
          request: ListNotificationRulesRequest
        ): Kleisli[M, CodestarNotificationsClient, ListNotificationRulesResponse] =
          primitive(_.listNotificationRules(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, CodestarNotificationsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTargets(
          request: ListTargetsRequest
        ): Kleisli[M, CodestarNotificationsClient, ListTargetsResponse] =
          primitive(_.listTargets(request))

        def subscribe(
          request: SubscribeRequest
        ): Kleisli[M, CodestarNotificationsClient, SubscribeResponse] =
          primitive(_.subscribe(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, CodestarNotificationsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def unsubscribe(
          request: UnsubscribeRequest
        ): Kleisli[M, CodestarNotificationsClient, UnsubscribeResponse] =
          primitive(_.unsubscribe(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, CodestarNotificationsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateNotificationRule(
          request: UpdateNotificationRuleRequest
        ): Kleisli[M, CodestarNotificationsClient, UpdateNotificationRuleResponse] =
          primitive(_.updateNotificationRule(request))

        def primitive[A](
          f: CodestarNotificationsClient => A
        ): Kleisli[M, CodestarNotificationsClient, A]
      }
    }

    trait Visitor[F[_]] extends (CodestarNotificationsOp ~> F) {
      final def apply[A](op: CodestarNotificationsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createNotificationRule(
        request: CreateNotificationRuleRequest
      ): F[CreateNotificationRuleResponse]

      def deleteNotificationRule(
        request: DeleteNotificationRuleRequest
      ): F[DeleteNotificationRuleResponse]

      def deleteTarget(
        request: DeleteTargetRequest
      ): F[DeleteTargetResponse]

      def describeNotificationRule(
        request: DescribeNotificationRuleRequest
      ): F[DescribeNotificationRuleResponse]

      def listEventTypes(
        request: ListEventTypesRequest
      ): F[ListEventTypesResponse]

      def listNotificationRules(
        request: ListNotificationRulesRequest
      ): F[ListNotificationRulesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTargets(
        request: ListTargetsRequest
      ): F[ListTargetsResponse]

      def subscribe(
        request: SubscribeRequest
      ): F[SubscribeResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def unsubscribe(
        request: UnsubscribeRequest
      ): F[UnsubscribeResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateNotificationRule(
        request: UpdateNotificationRuleRequest
      ): F[UpdateNotificationRuleResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CodestarNotificationsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateNotificationRuleOp(
      request: CreateNotificationRuleRequest
    ) extends CodestarNotificationsOp[CreateNotificationRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateNotificationRuleResponse] =
        visitor.createNotificationRule(request)
    }

    final case class DeleteNotificationRuleOp(
      request: DeleteNotificationRuleRequest
    ) extends CodestarNotificationsOp[DeleteNotificationRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNotificationRuleResponse] =
        visitor.deleteNotificationRule(request)
    }

    final case class DeleteTargetOp(
      request: DeleteTargetRequest
    ) extends CodestarNotificationsOp[DeleteTargetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTargetResponse] =
        visitor.deleteTarget(request)
    }

    final case class DescribeNotificationRuleOp(
      request: DescribeNotificationRuleRequest
    ) extends CodestarNotificationsOp[DescribeNotificationRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNotificationRuleResponse] =
        visitor.describeNotificationRule(request)
    }

    final case class ListEventTypesOp(
      request: ListEventTypesRequest
    ) extends CodestarNotificationsOp[ListEventTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEventTypesResponse] =
        visitor.listEventTypes(request)
    }

    final case class ListNotificationRulesOp(
      request: ListNotificationRulesRequest
    ) extends CodestarNotificationsOp[ListNotificationRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListNotificationRulesResponse] =
        visitor.listNotificationRules(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends CodestarNotificationsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTargetsOp(
      request: ListTargetsRequest
    ) extends CodestarNotificationsOp[ListTargetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTargetsResponse] =
        visitor.listTargets(request)
    }

    final case class SubscribeOp(
      request: SubscribeRequest
    ) extends CodestarNotificationsOp[SubscribeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SubscribeResponse] =
        visitor.subscribe(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends CodestarNotificationsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UnsubscribeOp(
      request: UnsubscribeRequest
    ) extends CodestarNotificationsOp[UnsubscribeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UnsubscribeResponse] =
        visitor.unsubscribe(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends CodestarNotificationsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateNotificationRuleOp(
      request: UpdateNotificationRuleRequest
    ) extends CodestarNotificationsOp[UpdateNotificationRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateNotificationRuleResponse] =
        visitor.updateNotificationRule(request)
    }
  }

  import CodestarNotificationsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CodestarNotificationsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createNotificationRule(
    request: CreateNotificationRuleRequest
  ): CodestarNotificationsIO[CreateNotificationRuleResponse] =
    FF.liftF(CreateNotificationRuleOp(request))

  def deleteNotificationRule(
    request: DeleteNotificationRuleRequest
  ): CodestarNotificationsIO[DeleteNotificationRuleResponse] =
    FF.liftF(DeleteNotificationRuleOp(request))

  def deleteTarget(
    request: DeleteTargetRequest
  ): CodestarNotificationsIO[DeleteTargetResponse] =
    FF.liftF(DeleteTargetOp(request))

  def describeNotificationRule(
    request: DescribeNotificationRuleRequest
  ): CodestarNotificationsIO[DescribeNotificationRuleResponse] =
    FF.liftF(DescribeNotificationRuleOp(request))

  def listEventTypes(
    request: ListEventTypesRequest
  ): CodestarNotificationsIO[ListEventTypesResponse] =
    FF.liftF(ListEventTypesOp(request))

  def listNotificationRules(
    request: ListNotificationRulesRequest
  ): CodestarNotificationsIO[ListNotificationRulesResponse] =
    FF.liftF(ListNotificationRulesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): CodestarNotificationsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTargets(
    request: ListTargetsRequest
  ): CodestarNotificationsIO[ListTargetsResponse] =
    FF.liftF(ListTargetsOp(request))

  def subscribe(
    request: SubscribeRequest
  ): CodestarNotificationsIO[SubscribeResponse] =
    FF.liftF(SubscribeOp(request))

  def tagResource(
    request: TagResourceRequest
  ): CodestarNotificationsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def unsubscribe(
    request: UnsubscribeRequest
  ): CodestarNotificationsIO[UnsubscribeResponse] =
    FF.liftF(UnsubscribeOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): CodestarNotificationsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateNotificationRule(
    request: UpdateNotificationRuleRequest
  ): CodestarNotificationsIO[UpdateNotificationRuleResponse] =
    FF.liftF(UpdateNotificationRuleOp(request))
}
