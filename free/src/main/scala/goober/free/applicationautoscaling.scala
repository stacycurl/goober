package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.applicationautoscaling.ApplicationAutoScalingClient
import software.amazon.awssdk.services.applicationautoscaling.model._


object applicationautoscaling { module =>

  // Free monad over ApplicationAutoScalingOp
  type ApplicationAutoScalingIO[A] = FF[ApplicationAutoScalingOp, A]

  sealed trait ApplicationAutoScalingOp[A] {
    def visit[F[_]](visitor: ApplicationAutoScalingOp.Visitor[F]): F[A]
  }

  object ApplicationAutoScalingOp {
    // Given a ApplicationAutoScalingClient we can embed a ApplicationAutoScalingIO program in any algebra that understands embedding.
    implicit val ApplicationAutoScalingOpEmbeddable: Embeddable[ApplicationAutoScalingOp, ApplicationAutoScalingClient] = new Embeddable[ApplicationAutoScalingOp, ApplicationAutoScalingClient] {
      def embed[A](client: ApplicationAutoScalingClient, io: ApplicationAutoScalingIO[A]): Embedded[A] = Embedded.ApplicationAutoScaling(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ApplicationAutoScalingOp.Visitor[Kleisli[M, ApplicationAutoScalingClient, *]] {
        def deleteScalingPolicy(
          request: DeleteScalingPolicyRequest
        ): Kleisli[M, ApplicationAutoScalingClient, DeleteScalingPolicyResponse] =
          primitive(_.deleteScalingPolicy(request))

        def deleteScheduledAction(
          request: DeleteScheduledActionRequest
        ): Kleisli[M, ApplicationAutoScalingClient, DeleteScheduledActionResponse] =
          primitive(_.deleteScheduledAction(request))

        def deregisterScalableTarget(
          request: DeregisterScalableTargetRequest
        ): Kleisli[M, ApplicationAutoScalingClient, DeregisterScalableTargetResponse] =
          primitive(_.deregisterScalableTarget(request))

        def describeScalableTargets(
          request: DescribeScalableTargetsRequest
        ): Kleisli[M, ApplicationAutoScalingClient, DescribeScalableTargetsResponse] =
          primitive(_.describeScalableTargets(request))

        def describeScalingActivities(
          request: DescribeScalingActivitiesRequest
        ): Kleisli[M, ApplicationAutoScalingClient, DescribeScalingActivitiesResponse] =
          primitive(_.describeScalingActivities(request))

        def describeScalingPolicies(
          request: DescribeScalingPoliciesRequest
        ): Kleisli[M, ApplicationAutoScalingClient, DescribeScalingPoliciesResponse] =
          primitive(_.describeScalingPolicies(request))

        def describeScheduledActions(
          request: DescribeScheduledActionsRequest
        ): Kleisli[M, ApplicationAutoScalingClient, DescribeScheduledActionsResponse] =
          primitive(_.describeScheduledActions(request))

        def putScalingPolicy(
          request: PutScalingPolicyRequest
        ): Kleisli[M, ApplicationAutoScalingClient, PutScalingPolicyResponse] =
          primitive(_.putScalingPolicy(request))

        def putScheduledAction(
          request: PutScheduledActionRequest
        ): Kleisli[M, ApplicationAutoScalingClient, PutScheduledActionResponse] =
          primitive(_.putScheduledAction(request))

        def registerScalableTarget(
          request: RegisterScalableTargetRequest
        ): Kleisli[M, ApplicationAutoScalingClient, RegisterScalableTargetResponse] =
          primitive(_.registerScalableTarget(request))

        def primitive[A](
          f: ApplicationAutoScalingClient => A
        ): Kleisli[M, ApplicationAutoScalingClient, A]
      }
    }

    trait Visitor[F[_]] extends (ApplicationAutoScalingOp ~> F) {
      final def apply[A](op: ApplicationAutoScalingOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def deleteScalingPolicy(
        request: DeleteScalingPolicyRequest
      ): F[DeleteScalingPolicyResponse]

      def deleteScheduledAction(
        request: DeleteScheduledActionRequest
      ): F[DeleteScheduledActionResponse]

      def deregisterScalableTarget(
        request: DeregisterScalableTargetRequest
      ): F[DeregisterScalableTargetResponse]

      def describeScalableTargets(
        request: DescribeScalableTargetsRequest
      ): F[DescribeScalableTargetsResponse]

      def describeScalingActivities(
        request: DescribeScalingActivitiesRequest
      ): F[DescribeScalingActivitiesResponse]

      def describeScalingPolicies(
        request: DescribeScalingPoliciesRequest
      ): F[DescribeScalingPoliciesResponse]

      def describeScheduledActions(
        request: DescribeScheduledActionsRequest
      ): F[DescribeScheduledActionsResponse]

      def putScalingPolicy(
        request: PutScalingPolicyRequest
      ): F[PutScalingPolicyResponse]

      def putScheduledAction(
        request: PutScheduledActionRequest
      ): F[PutScheduledActionResponse]

      def registerScalableTarget(
        request: RegisterScalableTargetRequest
      ): F[RegisterScalableTargetResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ApplicationAutoScalingOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DeleteScalingPolicyOp(
      request: DeleteScalingPolicyRequest
    ) extends ApplicationAutoScalingOp[DeleteScalingPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteScalingPolicyResponse] =
        visitor.deleteScalingPolicy(request)
    }

    final case class DeleteScheduledActionOp(
      request: DeleteScheduledActionRequest
    ) extends ApplicationAutoScalingOp[DeleteScheduledActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteScheduledActionResponse] =
        visitor.deleteScheduledAction(request)
    }

    final case class DeregisterScalableTargetOp(
      request: DeregisterScalableTargetRequest
    ) extends ApplicationAutoScalingOp[DeregisterScalableTargetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterScalableTargetResponse] =
        visitor.deregisterScalableTarget(request)
    }

    final case class DescribeScalableTargetsOp(
      request: DescribeScalableTargetsRequest
    ) extends ApplicationAutoScalingOp[DescribeScalableTargetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeScalableTargetsResponse] =
        visitor.describeScalableTargets(request)
    }

    final case class DescribeScalingActivitiesOp(
      request: DescribeScalingActivitiesRequest
    ) extends ApplicationAutoScalingOp[DescribeScalingActivitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeScalingActivitiesResponse] =
        visitor.describeScalingActivities(request)
    }

    final case class DescribeScalingPoliciesOp(
      request: DescribeScalingPoliciesRequest
    ) extends ApplicationAutoScalingOp[DescribeScalingPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeScalingPoliciesResponse] =
        visitor.describeScalingPolicies(request)
    }

    final case class DescribeScheduledActionsOp(
      request: DescribeScheduledActionsRequest
    ) extends ApplicationAutoScalingOp[DescribeScheduledActionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeScheduledActionsResponse] =
        visitor.describeScheduledActions(request)
    }

    final case class PutScalingPolicyOp(
      request: PutScalingPolicyRequest
    ) extends ApplicationAutoScalingOp[PutScalingPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutScalingPolicyResponse] =
        visitor.putScalingPolicy(request)
    }

    final case class PutScheduledActionOp(
      request: PutScheduledActionRequest
    ) extends ApplicationAutoScalingOp[PutScheduledActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutScheduledActionResponse] =
        visitor.putScheduledAction(request)
    }

    final case class RegisterScalableTargetOp(
      request: RegisterScalableTargetRequest
    ) extends ApplicationAutoScalingOp[RegisterScalableTargetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterScalableTargetResponse] =
        visitor.registerScalableTarget(request)
    }
  }

  import ApplicationAutoScalingOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ApplicationAutoScalingOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def deleteScalingPolicy(
    request: DeleteScalingPolicyRequest
  ): ApplicationAutoScalingIO[DeleteScalingPolicyResponse] =
    FF.liftF(DeleteScalingPolicyOp(request))

  def deleteScheduledAction(
    request: DeleteScheduledActionRequest
  ): ApplicationAutoScalingIO[DeleteScheduledActionResponse] =
    FF.liftF(DeleteScheduledActionOp(request))

  def deregisterScalableTarget(
    request: DeregisterScalableTargetRequest
  ): ApplicationAutoScalingIO[DeregisterScalableTargetResponse] =
    FF.liftF(DeregisterScalableTargetOp(request))

  def describeScalableTargets(
    request: DescribeScalableTargetsRequest
  ): ApplicationAutoScalingIO[DescribeScalableTargetsResponse] =
    FF.liftF(DescribeScalableTargetsOp(request))

  def describeScalingActivities(
    request: DescribeScalingActivitiesRequest
  ): ApplicationAutoScalingIO[DescribeScalingActivitiesResponse] =
    FF.liftF(DescribeScalingActivitiesOp(request))

  def describeScalingPolicies(
    request: DescribeScalingPoliciesRequest
  ): ApplicationAutoScalingIO[DescribeScalingPoliciesResponse] =
    FF.liftF(DescribeScalingPoliciesOp(request))

  def describeScheduledActions(
    request: DescribeScheduledActionsRequest
  ): ApplicationAutoScalingIO[DescribeScheduledActionsResponse] =
    FF.liftF(DescribeScheduledActionsOp(request))

  def putScalingPolicy(
    request: PutScalingPolicyRequest
  ): ApplicationAutoScalingIO[PutScalingPolicyResponse] =
    FF.liftF(PutScalingPolicyOp(request))

  def putScheduledAction(
    request: PutScheduledActionRequest
  ): ApplicationAutoScalingIO[PutScheduledActionResponse] =
    FF.liftF(PutScheduledActionOp(request))

  def registerScalableTarget(
    request: RegisterScalableTargetRequest
  ): ApplicationAutoScalingIO[RegisterScalableTargetResponse] =
    FF.liftF(RegisterScalableTargetOp(request))
}
