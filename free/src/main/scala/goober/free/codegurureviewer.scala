package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.codegurureviewer.CodeGuruReviewerClient
import software.amazon.awssdk.services.codegurureviewer.model._


object codegurureviewer { module =>

  // Free monad over CodeGuruReviewerOp
  type CodeGuruReviewerIO[A] = FF[CodeGuruReviewerOp, A]

  sealed trait CodeGuruReviewerOp[A] {
    def visit[F[_]](visitor: CodeGuruReviewerOp.Visitor[F]): F[A]
  }

  object CodeGuruReviewerOp {
    // Given a CodeGuruReviewerClient we can embed a CodeGuruReviewerIO program in any algebra that understands embedding.
    implicit val CodeGuruReviewerOpEmbeddable: Embeddable[CodeGuruReviewerOp, CodeGuruReviewerClient] = new Embeddable[CodeGuruReviewerOp, CodeGuruReviewerClient] {
      def embed[A](client: CodeGuruReviewerClient, io: CodeGuruReviewerIO[A]): Embedded[A] = Embedded.CodeGuruReviewer(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CodeGuruReviewerOp.Visitor[Kleisli[M, CodeGuruReviewerClient, *]] {
        def associateRepository(
          request: AssociateRepositoryRequest
        ): Kleisli[M, CodeGuruReviewerClient, AssociateRepositoryResponse] =
          primitive(_.associateRepository(request))

        def createCodeReview(
          request: CreateCodeReviewRequest
        ): Kleisli[M, CodeGuruReviewerClient, CreateCodeReviewResponse] =
          primitive(_.createCodeReview(request))

        def describeCodeReview(
          request: DescribeCodeReviewRequest
        ): Kleisli[M, CodeGuruReviewerClient, DescribeCodeReviewResponse] =
          primitive(_.describeCodeReview(request))

        def describeRecommendationFeedback(
          request: DescribeRecommendationFeedbackRequest
        ): Kleisli[M, CodeGuruReviewerClient, DescribeRecommendationFeedbackResponse] =
          primitive(_.describeRecommendationFeedback(request))

        def describeRepositoryAssociation(
          request: DescribeRepositoryAssociationRequest
        ): Kleisli[M, CodeGuruReviewerClient, DescribeRepositoryAssociationResponse] =
          primitive(_.describeRepositoryAssociation(request))

        def disassociateRepository(
          request: DisassociateRepositoryRequest
        ): Kleisli[M, CodeGuruReviewerClient, DisassociateRepositoryResponse] =
          primitive(_.disassociateRepository(request))

        def listCodeReviews(
          request: ListCodeReviewsRequest
        ): Kleisli[M, CodeGuruReviewerClient, ListCodeReviewsResponse] =
          primitive(_.listCodeReviews(request))

        def listRecommendationFeedback(
          request: ListRecommendationFeedbackRequest
        ): Kleisli[M, CodeGuruReviewerClient, ListRecommendationFeedbackResponse] =
          primitive(_.listRecommendationFeedback(request))

        def listRecommendations(
          request: ListRecommendationsRequest
        ): Kleisli[M, CodeGuruReviewerClient, ListRecommendationsResponse] =
          primitive(_.listRecommendations(request))

        def listRepositoryAssociations(
          request: ListRepositoryAssociationsRequest
        ): Kleisli[M, CodeGuruReviewerClient, ListRepositoryAssociationsResponse] =
          primitive(_.listRepositoryAssociations(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, CodeGuruReviewerClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putRecommendationFeedback(
          request: PutRecommendationFeedbackRequest
        ): Kleisli[M, CodeGuruReviewerClient, PutRecommendationFeedbackResponse] =
          primitive(_.putRecommendationFeedback(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, CodeGuruReviewerClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, CodeGuruReviewerClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: CodeGuruReviewerClient => A
        ): Kleisli[M, CodeGuruReviewerClient, A]
      }
    }

    trait Visitor[F[_]] extends (CodeGuruReviewerOp ~> F) {
      final def apply[A](op: CodeGuruReviewerOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateRepository(
        request: AssociateRepositoryRequest
      ): F[AssociateRepositoryResponse]

      def createCodeReview(
        request: CreateCodeReviewRequest
      ): F[CreateCodeReviewResponse]

      def describeCodeReview(
        request: DescribeCodeReviewRequest
      ): F[DescribeCodeReviewResponse]

      def describeRecommendationFeedback(
        request: DescribeRecommendationFeedbackRequest
      ): F[DescribeRecommendationFeedbackResponse]

      def describeRepositoryAssociation(
        request: DescribeRepositoryAssociationRequest
      ): F[DescribeRepositoryAssociationResponse]

      def disassociateRepository(
        request: DisassociateRepositoryRequest
      ): F[DisassociateRepositoryResponse]

      def listCodeReviews(
        request: ListCodeReviewsRequest
      ): F[ListCodeReviewsResponse]

      def listRecommendationFeedback(
        request: ListRecommendationFeedbackRequest
      ): F[ListRecommendationFeedbackResponse]

      def listRecommendations(
        request: ListRecommendationsRequest
      ): F[ListRecommendationsResponse]

      def listRepositoryAssociations(
        request: ListRepositoryAssociationsRequest
      ): F[ListRepositoryAssociationsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putRecommendationFeedback(
        request: PutRecommendationFeedbackRequest
      ): F[PutRecommendationFeedbackResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CodeGuruReviewerOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateRepositoryOp(
      request: AssociateRepositoryRequest
    ) extends CodeGuruReviewerOp[AssociateRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateRepositoryResponse] =
        visitor.associateRepository(request)
    }

    final case class CreateCodeReviewOp(
      request: CreateCodeReviewRequest
    ) extends CodeGuruReviewerOp[CreateCodeReviewResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCodeReviewResponse] =
        visitor.createCodeReview(request)
    }

    final case class DescribeCodeReviewOp(
      request: DescribeCodeReviewRequest
    ) extends CodeGuruReviewerOp[DescribeCodeReviewResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCodeReviewResponse] =
        visitor.describeCodeReview(request)
    }

    final case class DescribeRecommendationFeedbackOp(
      request: DescribeRecommendationFeedbackRequest
    ) extends CodeGuruReviewerOp[DescribeRecommendationFeedbackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRecommendationFeedbackResponse] =
        visitor.describeRecommendationFeedback(request)
    }

    final case class DescribeRepositoryAssociationOp(
      request: DescribeRepositoryAssociationRequest
    ) extends CodeGuruReviewerOp[DescribeRepositoryAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRepositoryAssociationResponse] =
        visitor.describeRepositoryAssociation(request)
    }

    final case class DisassociateRepositoryOp(
      request: DisassociateRepositoryRequest
    ) extends CodeGuruReviewerOp[DisassociateRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateRepositoryResponse] =
        visitor.disassociateRepository(request)
    }

    final case class ListCodeReviewsOp(
      request: ListCodeReviewsRequest
    ) extends CodeGuruReviewerOp[ListCodeReviewsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCodeReviewsResponse] =
        visitor.listCodeReviews(request)
    }

    final case class ListRecommendationFeedbackOp(
      request: ListRecommendationFeedbackRequest
    ) extends CodeGuruReviewerOp[ListRecommendationFeedbackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRecommendationFeedbackResponse] =
        visitor.listRecommendationFeedback(request)
    }

    final case class ListRecommendationsOp(
      request: ListRecommendationsRequest
    ) extends CodeGuruReviewerOp[ListRecommendationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRecommendationsResponse] =
        visitor.listRecommendations(request)
    }

    final case class ListRepositoryAssociationsOp(
      request: ListRepositoryAssociationsRequest
    ) extends CodeGuruReviewerOp[ListRepositoryAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRepositoryAssociationsResponse] =
        visitor.listRepositoryAssociations(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends CodeGuruReviewerOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutRecommendationFeedbackOp(
      request: PutRecommendationFeedbackRequest
    ) extends CodeGuruReviewerOp[PutRecommendationFeedbackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRecommendationFeedbackResponse] =
        visitor.putRecommendationFeedback(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends CodeGuruReviewerOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends CodeGuruReviewerOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import CodeGuruReviewerOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CodeGuruReviewerOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateRepository(
    request: AssociateRepositoryRequest
  ): CodeGuruReviewerIO[AssociateRepositoryResponse] =
    FF.liftF(AssociateRepositoryOp(request))

  def createCodeReview(
    request: CreateCodeReviewRequest
  ): CodeGuruReviewerIO[CreateCodeReviewResponse] =
    FF.liftF(CreateCodeReviewOp(request))

  def describeCodeReview(
    request: DescribeCodeReviewRequest
  ): CodeGuruReviewerIO[DescribeCodeReviewResponse] =
    FF.liftF(DescribeCodeReviewOp(request))

  def describeRecommendationFeedback(
    request: DescribeRecommendationFeedbackRequest
  ): CodeGuruReviewerIO[DescribeRecommendationFeedbackResponse] =
    FF.liftF(DescribeRecommendationFeedbackOp(request))

  def describeRepositoryAssociation(
    request: DescribeRepositoryAssociationRequest
  ): CodeGuruReviewerIO[DescribeRepositoryAssociationResponse] =
    FF.liftF(DescribeRepositoryAssociationOp(request))

  def disassociateRepository(
    request: DisassociateRepositoryRequest
  ): CodeGuruReviewerIO[DisassociateRepositoryResponse] =
    FF.liftF(DisassociateRepositoryOp(request))

  def listCodeReviews(
    request: ListCodeReviewsRequest
  ): CodeGuruReviewerIO[ListCodeReviewsResponse] =
    FF.liftF(ListCodeReviewsOp(request))

  def listRecommendationFeedback(
    request: ListRecommendationFeedbackRequest
  ): CodeGuruReviewerIO[ListRecommendationFeedbackResponse] =
    FF.liftF(ListRecommendationFeedbackOp(request))

  def listRecommendations(
    request: ListRecommendationsRequest
  ): CodeGuruReviewerIO[ListRecommendationsResponse] =
    FF.liftF(ListRecommendationsOp(request))

  def listRepositoryAssociations(
    request: ListRepositoryAssociationsRequest
  ): CodeGuruReviewerIO[ListRepositoryAssociationsResponse] =
    FF.liftF(ListRepositoryAssociationsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): CodeGuruReviewerIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putRecommendationFeedback(
    request: PutRecommendationFeedbackRequest
  ): CodeGuruReviewerIO[PutRecommendationFeedbackResponse] =
    FF.liftF(PutRecommendationFeedbackOp(request))

  def tagResource(
    request: TagResourceRequest
  ): CodeGuruReviewerIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): CodeGuruReviewerIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
