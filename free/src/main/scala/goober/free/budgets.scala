package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.budgets.BudgetsClient
import software.amazon.awssdk.services.budgets.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object budgets { module =>

  // Free monad over BudgetsOp
  type BudgetsIO[A] = FF[BudgetsOp, A]

  sealed trait BudgetsOp[A] {
    def visit[F[_]](visitor: BudgetsOp.Visitor[F]): F[A]
  }

  object BudgetsOp {
    // Given a BudgetsClient we can embed a BudgetsIO program in any algebra that understands embedding.
    implicit val BudgetsOpEmbeddable: Embeddable[BudgetsOp, BudgetsClient] = new Embeddable[BudgetsOp, BudgetsClient] {
      def embed[A](client: BudgetsClient, io: BudgetsIO[A]): Embedded[A] = Embedded.Budgets(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends BudgetsOp.Visitor[Kleisli[M, BudgetsClient, *]] {
        def createBudget(
          request: CreateBudgetRequest
        ): Kleisli[M, BudgetsClient, CreateBudgetResponse] =
          primitive(_.createBudget(request))

        def createBudgetAction(
          request: CreateBudgetActionRequest
        ): Kleisli[M, BudgetsClient, CreateBudgetActionResponse] =
          primitive(_.createBudgetAction(request))

        def createNotification(
          request: CreateNotificationRequest
        ): Kleisli[M, BudgetsClient, CreateNotificationResponse] =
          primitive(_.createNotification(request))

        def createSubscriber(
          request: CreateSubscriberRequest
        ): Kleisli[M, BudgetsClient, CreateSubscriberResponse] =
          primitive(_.createSubscriber(request))

        def deleteBudget(
          request: DeleteBudgetRequest
        ): Kleisli[M, BudgetsClient, DeleteBudgetResponse] =
          primitive(_.deleteBudget(request))

        def deleteBudgetAction(
          request: DeleteBudgetActionRequest
        ): Kleisli[M, BudgetsClient, DeleteBudgetActionResponse] =
          primitive(_.deleteBudgetAction(request))

        def deleteNotification(
          request: DeleteNotificationRequest
        ): Kleisli[M, BudgetsClient, DeleteNotificationResponse] =
          primitive(_.deleteNotification(request))

        def deleteSubscriber(
          request: DeleteSubscriberRequest
        ): Kleisli[M, BudgetsClient, DeleteSubscriberResponse] =
          primitive(_.deleteSubscriber(request))

        def describeBudget(
          request: DescribeBudgetRequest
        ): Kleisli[M, BudgetsClient, DescribeBudgetResponse] =
          primitive(_.describeBudget(request))

        def describeBudgetAction(
          request: DescribeBudgetActionRequest
        ): Kleisli[M, BudgetsClient, DescribeBudgetActionResponse] =
          primitive(_.describeBudgetAction(request))

        def describeBudgetActionHistories(
          request: DescribeBudgetActionHistoriesRequest
        ): Kleisli[M, BudgetsClient, DescribeBudgetActionHistoriesResponse] =
          primitive(_.describeBudgetActionHistories(request))

        def describeBudgetActionsForAccount(
          request: DescribeBudgetActionsForAccountRequest
        ): Kleisli[M, BudgetsClient, DescribeBudgetActionsForAccountResponse] =
          primitive(_.describeBudgetActionsForAccount(request))

        def describeBudgetActionsForBudget(
          request: DescribeBudgetActionsForBudgetRequest
        ): Kleisli[M, BudgetsClient, DescribeBudgetActionsForBudgetResponse] =
          primitive(_.describeBudgetActionsForBudget(request))

        def describeBudgetPerformanceHistory(
          request: DescribeBudgetPerformanceHistoryRequest
        ): Kleisli[M, BudgetsClient, DescribeBudgetPerformanceHistoryResponse] =
          primitive(_.describeBudgetPerformanceHistory(request))

        def describeBudgets(
          request: DescribeBudgetsRequest
        ): Kleisli[M, BudgetsClient, DescribeBudgetsResponse] =
          primitive(_.describeBudgets(request))

        def describeNotificationsForBudget(
          request: DescribeNotificationsForBudgetRequest
        ): Kleisli[M, BudgetsClient, DescribeNotificationsForBudgetResponse] =
          primitive(_.describeNotificationsForBudget(request))

        def describeSubscribersForNotification(
          request: DescribeSubscribersForNotificationRequest
        ): Kleisli[M, BudgetsClient, DescribeSubscribersForNotificationResponse] =
          primitive(_.describeSubscribersForNotification(request))

        def executeBudgetAction(
          request: ExecuteBudgetActionRequest
        ): Kleisli[M, BudgetsClient, ExecuteBudgetActionResponse] =
          primitive(_.executeBudgetAction(request))

        def updateBudget(
          request: UpdateBudgetRequest
        ): Kleisli[M, BudgetsClient, UpdateBudgetResponse] =
          primitive(_.updateBudget(request))

        def updateBudgetAction(
          request: UpdateBudgetActionRequest
        ): Kleisli[M, BudgetsClient, UpdateBudgetActionResponse] =
          primitive(_.updateBudgetAction(request))

        def updateNotification(
          request: UpdateNotificationRequest
        ): Kleisli[M, BudgetsClient, UpdateNotificationResponse] =
          primitive(_.updateNotification(request))

        def updateSubscriber(
          request: UpdateSubscriberRequest
        ): Kleisli[M, BudgetsClient, UpdateSubscriberResponse] =
          primitive(_.updateSubscriber(request))

        def primitive[A](
          f: BudgetsClient => A
        ): Kleisli[M, BudgetsClient, A]
      }
    }

    trait Visitor[F[_]] extends (BudgetsOp ~> F) {
      final def apply[A](op: BudgetsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createBudget(
        request: CreateBudgetRequest
      ): F[CreateBudgetResponse]

      def createBudgetAction(
        request: CreateBudgetActionRequest
      ): F[CreateBudgetActionResponse]

      def createNotification(
        request: CreateNotificationRequest
      ): F[CreateNotificationResponse]

      def createSubscriber(
        request: CreateSubscriberRequest
      ): F[CreateSubscriberResponse]

      def deleteBudget(
        request: DeleteBudgetRequest
      ): F[DeleteBudgetResponse]

      def deleteBudgetAction(
        request: DeleteBudgetActionRequest
      ): F[DeleteBudgetActionResponse]

      def deleteNotification(
        request: DeleteNotificationRequest
      ): F[DeleteNotificationResponse]

      def deleteSubscriber(
        request: DeleteSubscriberRequest
      ): F[DeleteSubscriberResponse]

      def describeBudget(
        request: DescribeBudgetRequest
      ): F[DescribeBudgetResponse]

      def describeBudgetAction(
        request: DescribeBudgetActionRequest
      ): F[DescribeBudgetActionResponse]

      def describeBudgetActionHistories(
        request: DescribeBudgetActionHistoriesRequest
      ): F[DescribeBudgetActionHistoriesResponse]

      def describeBudgetActionsForAccount(
        request: DescribeBudgetActionsForAccountRequest
      ): F[DescribeBudgetActionsForAccountResponse]

      def describeBudgetActionsForBudget(
        request: DescribeBudgetActionsForBudgetRequest
      ): F[DescribeBudgetActionsForBudgetResponse]

      def describeBudgetPerformanceHistory(
        request: DescribeBudgetPerformanceHistoryRequest
      ): F[DescribeBudgetPerformanceHistoryResponse]

      def describeBudgets(
        request: DescribeBudgetsRequest
      ): F[DescribeBudgetsResponse]

      def describeNotificationsForBudget(
        request: DescribeNotificationsForBudgetRequest
      ): F[DescribeNotificationsForBudgetResponse]

      def describeSubscribersForNotification(
        request: DescribeSubscribersForNotificationRequest
      ): F[DescribeSubscribersForNotificationResponse]

      def executeBudgetAction(
        request: ExecuteBudgetActionRequest
      ): F[ExecuteBudgetActionResponse]

      def updateBudget(
        request: UpdateBudgetRequest
      ): F[UpdateBudgetResponse]

      def updateBudgetAction(
        request: UpdateBudgetActionRequest
      ): F[UpdateBudgetActionResponse]

      def updateNotification(
        request: UpdateNotificationRequest
      ): F[UpdateNotificationResponse]

      def updateSubscriber(
        request: UpdateSubscriberRequest
      ): F[UpdateSubscriberResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends BudgetsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateBudgetOp(
      request: CreateBudgetRequest
    ) extends BudgetsOp[CreateBudgetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBudgetResponse] =
        visitor.createBudget(request)
    }

    final case class CreateBudgetActionOp(
      request: CreateBudgetActionRequest
    ) extends BudgetsOp[CreateBudgetActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBudgetActionResponse] =
        visitor.createBudgetAction(request)
    }

    final case class CreateNotificationOp(
      request: CreateNotificationRequest
    ) extends BudgetsOp[CreateNotificationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateNotificationResponse] =
        visitor.createNotification(request)
    }

    final case class CreateSubscriberOp(
      request: CreateSubscriberRequest
    ) extends BudgetsOp[CreateSubscriberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSubscriberResponse] =
        visitor.createSubscriber(request)
    }

    final case class DeleteBudgetOp(
      request: DeleteBudgetRequest
    ) extends BudgetsOp[DeleteBudgetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBudgetResponse] =
        visitor.deleteBudget(request)
    }

    final case class DeleteBudgetActionOp(
      request: DeleteBudgetActionRequest
    ) extends BudgetsOp[DeleteBudgetActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBudgetActionResponse] =
        visitor.deleteBudgetAction(request)
    }

    final case class DeleteNotificationOp(
      request: DeleteNotificationRequest
    ) extends BudgetsOp[DeleteNotificationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNotificationResponse] =
        visitor.deleteNotification(request)
    }

    final case class DeleteSubscriberOp(
      request: DeleteSubscriberRequest
    ) extends BudgetsOp[DeleteSubscriberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSubscriberResponse] =
        visitor.deleteSubscriber(request)
    }

    final case class DescribeBudgetOp(
      request: DescribeBudgetRequest
    ) extends BudgetsOp[DescribeBudgetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBudgetResponse] =
        visitor.describeBudget(request)
    }

    final case class DescribeBudgetActionOp(
      request: DescribeBudgetActionRequest
    ) extends BudgetsOp[DescribeBudgetActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBudgetActionResponse] =
        visitor.describeBudgetAction(request)
    }

    final case class DescribeBudgetActionHistoriesOp(
      request: DescribeBudgetActionHistoriesRequest
    ) extends BudgetsOp[DescribeBudgetActionHistoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBudgetActionHistoriesResponse] =
        visitor.describeBudgetActionHistories(request)
    }

    final case class DescribeBudgetActionsForAccountOp(
      request: DescribeBudgetActionsForAccountRequest
    ) extends BudgetsOp[DescribeBudgetActionsForAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBudgetActionsForAccountResponse] =
        visitor.describeBudgetActionsForAccount(request)
    }

    final case class DescribeBudgetActionsForBudgetOp(
      request: DescribeBudgetActionsForBudgetRequest
    ) extends BudgetsOp[DescribeBudgetActionsForBudgetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBudgetActionsForBudgetResponse] =
        visitor.describeBudgetActionsForBudget(request)
    }

    final case class DescribeBudgetPerformanceHistoryOp(
      request: DescribeBudgetPerformanceHistoryRequest
    ) extends BudgetsOp[DescribeBudgetPerformanceHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBudgetPerformanceHistoryResponse] =
        visitor.describeBudgetPerformanceHistory(request)
    }

    final case class DescribeBudgetsOp(
      request: DescribeBudgetsRequest
    ) extends BudgetsOp[DescribeBudgetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBudgetsResponse] =
        visitor.describeBudgets(request)
    }

    final case class DescribeNotificationsForBudgetOp(
      request: DescribeNotificationsForBudgetRequest
    ) extends BudgetsOp[DescribeNotificationsForBudgetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNotificationsForBudgetResponse] =
        visitor.describeNotificationsForBudget(request)
    }

    final case class DescribeSubscribersForNotificationOp(
      request: DescribeSubscribersForNotificationRequest
    ) extends BudgetsOp[DescribeSubscribersForNotificationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSubscribersForNotificationResponse] =
        visitor.describeSubscribersForNotification(request)
    }

    final case class ExecuteBudgetActionOp(
      request: ExecuteBudgetActionRequest
    ) extends BudgetsOp[ExecuteBudgetActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExecuteBudgetActionResponse] =
        visitor.executeBudgetAction(request)
    }

    final case class UpdateBudgetOp(
      request: UpdateBudgetRequest
    ) extends BudgetsOp[UpdateBudgetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBudgetResponse] =
        visitor.updateBudget(request)
    }

    final case class UpdateBudgetActionOp(
      request: UpdateBudgetActionRequest
    ) extends BudgetsOp[UpdateBudgetActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBudgetActionResponse] =
        visitor.updateBudgetAction(request)
    }

    final case class UpdateNotificationOp(
      request: UpdateNotificationRequest
    ) extends BudgetsOp[UpdateNotificationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateNotificationResponse] =
        visitor.updateNotification(request)
    }

    final case class UpdateSubscriberOp(
      request: UpdateSubscriberRequest
    ) extends BudgetsOp[UpdateSubscriberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSubscriberResponse] =
        visitor.updateSubscriber(request)
    }
  }

  import BudgetsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[BudgetsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createBudget(
    request: CreateBudgetRequest
  ): BudgetsIO[CreateBudgetResponse] =
    FF.liftF(CreateBudgetOp(request))

  def createBudgetAction(
    request: CreateBudgetActionRequest
  ): BudgetsIO[CreateBudgetActionResponse] =
    FF.liftF(CreateBudgetActionOp(request))

  def createNotification(
    request: CreateNotificationRequest
  ): BudgetsIO[CreateNotificationResponse] =
    FF.liftF(CreateNotificationOp(request))

  def createSubscriber(
    request: CreateSubscriberRequest
  ): BudgetsIO[CreateSubscriberResponse] =
    FF.liftF(CreateSubscriberOp(request))

  def deleteBudget(
    request: DeleteBudgetRequest
  ): BudgetsIO[DeleteBudgetResponse] =
    FF.liftF(DeleteBudgetOp(request))

  def deleteBudgetAction(
    request: DeleteBudgetActionRequest
  ): BudgetsIO[DeleteBudgetActionResponse] =
    FF.liftF(DeleteBudgetActionOp(request))

  def deleteNotification(
    request: DeleteNotificationRequest
  ): BudgetsIO[DeleteNotificationResponse] =
    FF.liftF(DeleteNotificationOp(request))

  def deleteSubscriber(
    request: DeleteSubscriberRequest
  ): BudgetsIO[DeleteSubscriberResponse] =
    FF.liftF(DeleteSubscriberOp(request))

  def describeBudget(
    request: DescribeBudgetRequest
  ): BudgetsIO[DescribeBudgetResponse] =
    FF.liftF(DescribeBudgetOp(request))

  def describeBudgetAction(
    request: DescribeBudgetActionRequest
  ): BudgetsIO[DescribeBudgetActionResponse] =
    FF.liftF(DescribeBudgetActionOp(request))

  def describeBudgetActionHistories(
    request: DescribeBudgetActionHistoriesRequest
  ): BudgetsIO[DescribeBudgetActionHistoriesResponse] =
    FF.liftF(DescribeBudgetActionHistoriesOp(request))

  def describeBudgetActionsForAccount(
    request: DescribeBudgetActionsForAccountRequest
  ): BudgetsIO[DescribeBudgetActionsForAccountResponse] =
    FF.liftF(DescribeBudgetActionsForAccountOp(request))

  def describeBudgetActionsForBudget(
    request: DescribeBudgetActionsForBudgetRequest
  ): BudgetsIO[DescribeBudgetActionsForBudgetResponse] =
    FF.liftF(DescribeBudgetActionsForBudgetOp(request))

  def describeBudgetPerformanceHistory(
    request: DescribeBudgetPerformanceHistoryRequest
  ): BudgetsIO[DescribeBudgetPerformanceHistoryResponse] =
    FF.liftF(DescribeBudgetPerformanceHistoryOp(request))

  def describeBudgets(
    request: DescribeBudgetsRequest
  ): BudgetsIO[DescribeBudgetsResponse] =
    FF.liftF(DescribeBudgetsOp(request))

  def describeNotificationsForBudget(
    request: DescribeNotificationsForBudgetRequest
  ): BudgetsIO[DescribeNotificationsForBudgetResponse] =
    FF.liftF(DescribeNotificationsForBudgetOp(request))

  def describeSubscribersForNotification(
    request: DescribeSubscribersForNotificationRequest
  ): BudgetsIO[DescribeSubscribersForNotificationResponse] =
    FF.liftF(DescribeSubscribersForNotificationOp(request))

  def executeBudgetAction(
    request: ExecuteBudgetActionRequest
  ): BudgetsIO[ExecuteBudgetActionResponse] =
    FF.liftF(ExecuteBudgetActionOp(request))

  def updateBudget(
    request: UpdateBudgetRequest
  ): BudgetsIO[UpdateBudgetResponse] =
    FF.liftF(UpdateBudgetOp(request))

  def updateBudgetAction(
    request: UpdateBudgetActionRequest
  ): BudgetsIO[UpdateBudgetActionResponse] =
    FF.liftF(UpdateBudgetActionOp(request))

  def updateNotification(
    request: UpdateNotificationRequest
  ): BudgetsIO[UpdateNotificationResponse] =
    FF.liftF(UpdateNotificationOp(request))

  def updateSubscriber(
    request: UpdateSubscriberRequest
  ): BudgetsIO[UpdateSubscriberResponse] =
    FF.liftF(UpdateSubscriberOp(request))
}
