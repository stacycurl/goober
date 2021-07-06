package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.dlm.DlmClient
import software.amazon.awssdk.services.dlm.model._


object dlm { module =>

  // Free monad over DlmOp
  type DlmIO[A] = FF[DlmOp, A]

  sealed trait DlmOp[A] {
    def visit[F[_]](visitor: DlmOp.Visitor[F]): F[A]
  }

  object DlmOp {
    // Given a DlmClient we can embed a DlmIO program in any algebra that understands embedding.
    implicit val DlmOpEmbeddable: Embeddable[DlmOp, DlmClient] = new Embeddable[DlmOp, DlmClient] {
      def embed[A](client: DlmClient, io: DlmIO[A]): Embedded[A] = Embedded.Dlm(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends DlmOp.Visitor[Kleisli[M, DlmClient, *]] {
        def createLifecyclePolicy(
          request: CreateLifecyclePolicyRequest
        ): Kleisli[M, DlmClient, CreateLifecyclePolicyResponse] =
          primitive(_.createLifecyclePolicy(request))

        def deleteLifecyclePolicy(
          request: DeleteLifecyclePolicyRequest
        ): Kleisli[M, DlmClient, DeleteLifecyclePolicyResponse] =
          primitive(_.deleteLifecyclePolicy(request))

        def getLifecyclePolicies(
          request: GetLifecyclePoliciesRequest
        ): Kleisli[M, DlmClient, GetLifecyclePoliciesResponse] =
          primitive(_.getLifecyclePolicies(request))

        def getLifecyclePolicy(
          request: GetLifecyclePolicyRequest
        ): Kleisli[M, DlmClient, GetLifecyclePolicyResponse] =
          primitive(_.getLifecyclePolicy(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, DlmClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, DlmClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, DlmClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateLifecyclePolicy(
          request: UpdateLifecyclePolicyRequest
        ): Kleisli[M, DlmClient, UpdateLifecyclePolicyResponse] =
          primitive(_.updateLifecyclePolicy(request))

        def primitive[A](
          f: DlmClient => A
        ): Kleisli[M, DlmClient, A]
      }
    }

    trait Visitor[F[_]] extends (DlmOp ~> F) {
      final def apply[A](op: DlmOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createLifecyclePolicy(
        request: CreateLifecyclePolicyRequest
      ): F[CreateLifecyclePolicyResponse]

      def deleteLifecyclePolicy(
        request: DeleteLifecyclePolicyRequest
      ): F[DeleteLifecyclePolicyResponse]

      def getLifecyclePolicies(
        request: GetLifecyclePoliciesRequest
      ): F[GetLifecyclePoliciesResponse]

      def getLifecyclePolicy(
        request: GetLifecyclePolicyRequest
      ): F[GetLifecyclePolicyResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateLifecyclePolicy(
        request: UpdateLifecyclePolicyRequest
      ): F[UpdateLifecyclePolicyResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends DlmOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateLifecyclePolicyOp(
      request: CreateLifecyclePolicyRequest
    ) extends DlmOp[CreateLifecyclePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLifecyclePolicyResponse] =
        visitor.createLifecyclePolicy(request)
    }

    final case class DeleteLifecyclePolicyOp(
      request: DeleteLifecyclePolicyRequest
    ) extends DlmOp[DeleteLifecyclePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLifecyclePolicyResponse] =
        visitor.deleteLifecyclePolicy(request)
    }

    final case class GetLifecyclePoliciesOp(
      request: GetLifecyclePoliciesRequest
    ) extends DlmOp[GetLifecyclePoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLifecyclePoliciesResponse] =
        visitor.getLifecyclePolicies(request)
    }

    final case class GetLifecyclePolicyOp(
      request: GetLifecyclePolicyRequest
    ) extends DlmOp[GetLifecyclePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLifecyclePolicyResponse] =
        visitor.getLifecyclePolicy(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends DlmOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends DlmOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends DlmOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateLifecyclePolicyOp(
      request: UpdateLifecyclePolicyRequest
    ) extends DlmOp[UpdateLifecyclePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLifecyclePolicyResponse] =
        visitor.updateLifecyclePolicy(request)
    }
  }

  import DlmOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[DlmOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createLifecyclePolicy(
    request: CreateLifecyclePolicyRequest
  ): DlmIO[CreateLifecyclePolicyResponse] =
    FF.liftF(CreateLifecyclePolicyOp(request))

  def deleteLifecyclePolicy(
    request: DeleteLifecyclePolicyRequest
  ): DlmIO[DeleteLifecyclePolicyResponse] =
    FF.liftF(DeleteLifecyclePolicyOp(request))

  def getLifecyclePolicies(
    request: GetLifecyclePoliciesRequest
  ): DlmIO[GetLifecyclePoliciesResponse] =
    FF.liftF(GetLifecyclePoliciesOp(request))

  def getLifecyclePolicy(
    request: GetLifecyclePolicyRequest
  ): DlmIO[GetLifecyclePolicyResponse] =
    FF.liftF(GetLifecyclePolicyOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): DlmIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): DlmIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): DlmIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateLifecyclePolicy(
    request: UpdateLifecyclePolicyRequest
  ): DlmIO[UpdateLifecyclePolicyResponse] =
    FF.liftF(UpdateLifecyclePolicyOp(request))
}
