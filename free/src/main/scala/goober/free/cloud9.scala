package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.cloud9.Cloud9Client
import software.amazon.awssdk.services.cloud9.model._


object cloud9 { module =>

  // Free monad over Cloud9Op
  type Cloud9IO[A] = FF[Cloud9Op, A]

  sealed trait Cloud9Op[A] {
    def visit[F[_]](visitor: Cloud9Op.Visitor[F]): F[A]
  }

  object Cloud9Op {
    // Given a Cloud9Client we can embed a Cloud9IO program in any algebra that understands embedding.
    implicit val Cloud9OpEmbeddable: Embeddable[Cloud9Op, Cloud9Client] = new Embeddable[Cloud9Op, Cloud9Client] {
      def embed[A](client: Cloud9Client, io: Cloud9IO[A]): Embedded[A] = Embedded.Cloud9(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends Cloud9Op.Visitor[Kleisli[M, Cloud9Client, *]] {
        def createEnvironmentEC2(
          request: CreateEnvironmentEc2Request
        ): Kleisli[M, Cloud9Client, CreateEnvironmentEc2Response] =
          primitive(_.createEnvironmentEC2(request))

        def createEnvironmentMembership(
          request: CreateEnvironmentMembershipRequest
        ): Kleisli[M, Cloud9Client, CreateEnvironmentMembershipResponse] =
          primitive(_.createEnvironmentMembership(request))

        def deleteEnvironment(
          request: DeleteEnvironmentRequest
        ): Kleisli[M, Cloud9Client, DeleteEnvironmentResponse] =
          primitive(_.deleteEnvironment(request))

        def deleteEnvironmentMembership(
          request: DeleteEnvironmentMembershipRequest
        ): Kleisli[M, Cloud9Client, DeleteEnvironmentMembershipResponse] =
          primitive(_.deleteEnvironmentMembership(request))

        def describeEnvironmentMemberships(
          request: DescribeEnvironmentMembershipsRequest
        ): Kleisli[M, Cloud9Client, DescribeEnvironmentMembershipsResponse] =
          primitive(_.describeEnvironmentMemberships(request))

        def describeEnvironmentStatus(
          request: DescribeEnvironmentStatusRequest
        ): Kleisli[M, Cloud9Client, DescribeEnvironmentStatusResponse] =
          primitive(_.describeEnvironmentStatus(request))

        def describeEnvironments(
          request: DescribeEnvironmentsRequest
        ): Kleisli[M, Cloud9Client, DescribeEnvironmentsResponse] =
          primitive(_.describeEnvironments(request))

        def listEnvironments(
          request: ListEnvironmentsRequest
        ): Kleisli[M, Cloud9Client, ListEnvironmentsResponse] =
          primitive(_.listEnvironments(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, Cloud9Client, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, Cloud9Client, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, Cloud9Client, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateEnvironment(
          request: UpdateEnvironmentRequest
        ): Kleisli[M, Cloud9Client, UpdateEnvironmentResponse] =
          primitive(_.updateEnvironment(request))

        def updateEnvironmentMembership(
          request: UpdateEnvironmentMembershipRequest
        ): Kleisli[M, Cloud9Client, UpdateEnvironmentMembershipResponse] =
          primitive(_.updateEnvironmentMembership(request))

        def primitive[A](
          f: Cloud9Client => A
        ): Kleisli[M, Cloud9Client, A]
      }
    }

    trait Visitor[F[_]] extends (Cloud9Op ~> F) {
      final def apply[A](op: Cloud9Op[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createEnvironmentEC2(
        request: CreateEnvironmentEc2Request
      ): F[CreateEnvironmentEc2Response]

      def createEnvironmentMembership(
        request: CreateEnvironmentMembershipRequest
      ): F[CreateEnvironmentMembershipResponse]

      def deleteEnvironment(
        request: DeleteEnvironmentRequest
      ): F[DeleteEnvironmentResponse]

      def deleteEnvironmentMembership(
        request: DeleteEnvironmentMembershipRequest
      ): F[DeleteEnvironmentMembershipResponse]

      def describeEnvironmentMemberships(
        request: DescribeEnvironmentMembershipsRequest
      ): F[DescribeEnvironmentMembershipsResponse]

      def describeEnvironmentStatus(
        request: DescribeEnvironmentStatusRequest
      ): F[DescribeEnvironmentStatusResponse]

      def describeEnvironments(
        request: DescribeEnvironmentsRequest
      ): F[DescribeEnvironmentsResponse]

      def listEnvironments(
        request: ListEnvironmentsRequest
      ): F[ListEnvironmentsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateEnvironment(
        request: UpdateEnvironmentRequest
      ): F[UpdateEnvironmentResponse]

      def updateEnvironmentMembership(
        request: UpdateEnvironmentMembershipRequest
      ): F[UpdateEnvironmentMembershipResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends Cloud9Op[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateEnvironmentEC2Op(
      request: CreateEnvironmentEc2Request
    ) extends Cloud9Op[CreateEnvironmentEc2Response] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEnvironmentEc2Response] =
        visitor.createEnvironmentEC2(request)
    }

    final case class CreateEnvironmentMembershipOp(
      request: CreateEnvironmentMembershipRequest
    ) extends Cloud9Op[CreateEnvironmentMembershipResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEnvironmentMembershipResponse] =
        visitor.createEnvironmentMembership(request)
    }

    final case class DeleteEnvironmentOp(
      request: DeleteEnvironmentRequest
    ) extends Cloud9Op[DeleteEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEnvironmentResponse] =
        visitor.deleteEnvironment(request)
    }

    final case class DeleteEnvironmentMembershipOp(
      request: DeleteEnvironmentMembershipRequest
    ) extends Cloud9Op[DeleteEnvironmentMembershipResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEnvironmentMembershipResponse] =
        visitor.deleteEnvironmentMembership(request)
    }

    final case class DescribeEnvironmentMembershipsOp(
      request: DescribeEnvironmentMembershipsRequest
    ) extends Cloud9Op[DescribeEnvironmentMembershipsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEnvironmentMembershipsResponse] =
        visitor.describeEnvironmentMemberships(request)
    }

    final case class DescribeEnvironmentStatusOp(
      request: DescribeEnvironmentStatusRequest
    ) extends Cloud9Op[DescribeEnvironmentStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEnvironmentStatusResponse] =
        visitor.describeEnvironmentStatus(request)
    }

    final case class DescribeEnvironmentsOp(
      request: DescribeEnvironmentsRequest
    ) extends Cloud9Op[DescribeEnvironmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEnvironmentsResponse] =
        visitor.describeEnvironments(request)
    }

    final case class ListEnvironmentsOp(
      request: ListEnvironmentsRequest
    ) extends Cloud9Op[ListEnvironmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEnvironmentsResponse] =
        visitor.listEnvironments(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends Cloud9Op[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends Cloud9Op[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends Cloud9Op[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateEnvironmentOp(
      request: UpdateEnvironmentRequest
    ) extends Cloud9Op[UpdateEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEnvironmentResponse] =
        visitor.updateEnvironment(request)
    }

    final case class UpdateEnvironmentMembershipOp(
      request: UpdateEnvironmentMembershipRequest
    ) extends Cloud9Op[UpdateEnvironmentMembershipResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEnvironmentMembershipResponse] =
        visitor.updateEnvironmentMembership(request)
    }
  }

  import Cloud9Op._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[Cloud9Op, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createEnvironmentEC2(
    request: CreateEnvironmentEc2Request
  ): Cloud9IO[CreateEnvironmentEc2Response] =
    FF.liftF(CreateEnvironmentEC2Op(request))

  def createEnvironmentMembership(
    request: CreateEnvironmentMembershipRequest
  ): Cloud9IO[CreateEnvironmentMembershipResponse] =
    FF.liftF(CreateEnvironmentMembershipOp(request))

  def deleteEnvironment(
    request: DeleteEnvironmentRequest
  ): Cloud9IO[DeleteEnvironmentResponse] =
    FF.liftF(DeleteEnvironmentOp(request))

  def deleteEnvironmentMembership(
    request: DeleteEnvironmentMembershipRequest
  ): Cloud9IO[DeleteEnvironmentMembershipResponse] =
    FF.liftF(DeleteEnvironmentMembershipOp(request))

  def describeEnvironmentMemberships(
    request: DescribeEnvironmentMembershipsRequest
  ): Cloud9IO[DescribeEnvironmentMembershipsResponse] =
    FF.liftF(DescribeEnvironmentMembershipsOp(request))

  def describeEnvironmentStatus(
    request: DescribeEnvironmentStatusRequest
  ): Cloud9IO[DescribeEnvironmentStatusResponse] =
    FF.liftF(DescribeEnvironmentStatusOp(request))

  def describeEnvironments(
    request: DescribeEnvironmentsRequest
  ): Cloud9IO[DescribeEnvironmentsResponse] =
    FF.liftF(DescribeEnvironmentsOp(request))

  def listEnvironments(
    request: ListEnvironmentsRequest
  ): Cloud9IO[ListEnvironmentsResponse] =
    FF.liftF(ListEnvironmentsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): Cloud9IO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): Cloud9IO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): Cloud9IO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateEnvironment(
    request: UpdateEnvironmentRequest
  ): Cloud9IO[UpdateEnvironmentResponse] =
    FF.liftF(UpdateEnvironmentOp(request))

  def updateEnvironmentMembership(
    request: UpdateEnvironmentMembershipRequest
  ): Cloud9IO[UpdateEnvironmentMembershipResponse] =
    FF.liftF(UpdateEnvironmentMembershipOp(request))
}
