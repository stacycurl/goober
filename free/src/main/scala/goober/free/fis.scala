package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.fis.FisClient
import software.amazon.awssdk.services.fis.model._


object fis { module =>

  // Free monad over FisOp
  type FisIO[A] = FF[FisOp, A]

  sealed trait FisOp[A] {
    def visit[F[_]](visitor: FisOp.Visitor[F]): F[A]
  }

  object FisOp {
    // Given a FisClient we can embed a FisIO program in any algebra that understands embedding.
    implicit val FisOpEmbeddable: Embeddable[FisOp, FisClient] = new Embeddable[FisOp, FisClient] {
      def embed[A](client: FisClient, io: FisIO[A]): Embedded[A] = Embedded.Fis(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends FisOp.Visitor[Kleisli[M, FisClient, *]] {
        def createExperimentTemplate(
          request: CreateExperimentTemplateRequest
        ): Kleisli[M, FisClient, CreateExperimentTemplateResponse] =
          primitive(_.createExperimentTemplate(request))

        def deleteExperimentTemplate(
          request: DeleteExperimentTemplateRequest
        ): Kleisli[M, FisClient, DeleteExperimentTemplateResponse] =
          primitive(_.deleteExperimentTemplate(request))

        def getAction(
          request: GetActionRequest
        ): Kleisli[M, FisClient, GetActionResponse] =
          primitive(_.getAction(request))

        def getExperiment(
          request: GetExperimentRequest
        ): Kleisli[M, FisClient, GetExperimentResponse] =
          primitive(_.getExperiment(request))

        def getExperimentTemplate(
          request: GetExperimentTemplateRequest
        ): Kleisli[M, FisClient, GetExperimentTemplateResponse] =
          primitive(_.getExperimentTemplate(request))

        def listActions(
          request: ListActionsRequest
        ): Kleisli[M, FisClient, ListActionsResponse] =
          primitive(_.listActions(request))

        def listExperimentTemplates(
          request: ListExperimentTemplatesRequest
        ): Kleisli[M, FisClient, ListExperimentTemplatesResponse] =
          primitive(_.listExperimentTemplates(request))

        def listExperiments(
          request: ListExperimentsRequest
        ): Kleisli[M, FisClient, ListExperimentsResponse] =
          primitive(_.listExperiments(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, FisClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def startExperiment(
          request: StartExperimentRequest
        ): Kleisli[M, FisClient, StartExperimentResponse] =
          primitive(_.startExperiment(request))

        def stopExperiment(
          request: StopExperimentRequest
        ): Kleisli[M, FisClient, StopExperimentResponse] =
          primitive(_.stopExperiment(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, FisClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, FisClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateExperimentTemplate(
          request: UpdateExperimentTemplateRequest
        ): Kleisli[M, FisClient, UpdateExperimentTemplateResponse] =
          primitive(_.updateExperimentTemplate(request))

        def primitive[A](
          f: FisClient => A
        ): Kleisli[M, FisClient, A]
      }
    }

    trait Visitor[F[_]] extends (FisOp ~> F) {
      final def apply[A](op: FisOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createExperimentTemplate(
        request: CreateExperimentTemplateRequest
      ): F[CreateExperimentTemplateResponse]

      def deleteExperimentTemplate(
        request: DeleteExperimentTemplateRequest
      ): F[DeleteExperimentTemplateResponse]

      def getAction(
        request: GetActionRequest
      ): F[GetActionResponse]

      def getExperiment(
        request: GetExperimentRequest
      ): F[GetExperimentResponse]

      def getExperimentTemplate(
        request: GetExperimentTemplateRequest
      ): F[GetExperimentTemplateResponse]

      def listActions(
        request: ListActionsRequest
      ): F[ListActionsResponse]

      def listExperimentTemplates(
        request: ListExperimentTemplatesRequest
      ): F[ListExperimentTemplatesResponse]

      def listExperiments(
        request: ListExperimentsRequest
      ): F[ListExperimentsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def startExperiment(
        request: StartExperimentRequest
      ): F[StartExperimentResponse]

      def stopExperiment(
        request: StopExperimentRequest
      ): F[StopExperimentResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateExperimentTemplate(
        request: UpdateExperimentTemplateRequest
      ): F[UpdateExperimentTemplateResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends FisOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateExperimentTemplateOp(
      request: CreateExperimentTemplateRequest
    ) extends FisOp[CreateExperimentTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateExperimentTemplateResponse] =
        visitor.createExperimentTemplate(request)
    }

    final case class DeleteExperimentTemplateOp(
      request: DeleteExperimentTemplateRequest
    ) extends FisOp[DeleteExperimentTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteExperimentTemplateResponse] =
        visitor.deleteExperimentTemplate(request)
    }

    final case class GetActionOp(
      request: GetActionRequest
    ) extends FisOp[GetActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetActionResponse] =
        visitor.getAction(request)
    }

    final case class GetExperimentOp(
      request: GetExperimentRequest
    ) extends FisOp[GetExperimentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetExperimentResponse] =
        visitor.getExperiment(request)
    }

    final case class GetExperimentTemplateOp(
      request: GetExperimentTemplateRequest
    ) extends FisOp[GetExperimentTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetExperimentTemplateResponse] =
        visitor.getExperimentTemplate(request)
    }

    final case class ListActionsOp(
      request: ListActionsRequest
    ) extends FisOp[ListActionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListActionsResponse] =
        visitor.listActions(request)
    }

    final case class ListExperimentTemplatesOp(
      request: ListExperimentTemplatesRequest
    ) extends FisOp[ListExperimentTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListExperimentTemplatesResponse] =
        visitor.listExperimentTemplates(request)
    }

    final case class ListExperimentsOp(
      request: ListExperimentsRequest
    ) extends FisOp[ListExperimentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListExperimentsResponse] =
        visitor.listExperiments(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends FisOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class StartExperimentOp(
      request: StartExperimentRequest
    ) extends FisOp[StartExperimentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartExperimentResponse] =
        visitor.startExperiment(request)
    }

    final case class StopExperimentOp(
      request: StopExperimentRequest
    ) extends FisOp[StopExperimentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopExperimentResponse] =
        visitor.stopExperiment(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends FisOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends FisOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateExperimentTemplateOp(
      request: UpdateExperimentTemplateRequest
    ) extends FisOp[UpdateExperimentTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateExperimentTemplateResponse] =
        visitor.updateExperimentTemplate(request)
    }
  }

  import FisOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[FisOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createExperimentTemplate(
    request: CreateExperimentTemplateRequest
  ): FisIO[CreateExperimentTemplateResponse] =
    FF.liftF(CreateExperimentTemplateOp(request))

  def deleteExperimentTemplate(
    request: DeleteExperimentTemplateRequest
  ): FisIO[DeleteExperimentTemplateResponse] =
    FF.liftF(DeleteExperimentTemplateOp(request))

  def getAction(
    request: GetActionRequest
  ): FisIO[GetActionResponse] =
    FF.liftF(GetActionOp(request))

  def getExperiment(
    request: GetExperimentRequest
  ): FisIO[GetExperimentResponse] =
    FF.liftF(GetExperimentOp(request))

  def getExperimentTemplate(
    request: GetExperimentTemplateRequest
  ): FisIO[GetExperimentTemplateResponse] =
    FF.liftF(GetExperimentTemplateOp(request))

  def listActions(
    request: ListActionsRequest
  ): FisIO[ListActionsResponse] =
    FF.liftF(ListActionsOp(request))

  def listExperimentTemplates(
    request: ListExperimentTemplatesRequest
  ): FisIO[ListExperimentTemplatesResponse] =
    FF.liftF(ListExperimentTemplatesOp(request))

  def listExperiments(
    request: ListExperimentsRequest
  ): FisIO[ListExperimentsResponse] =
    FF.liftF(ListExperimentsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): FisIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def startExperiment(
    request: StartExperimentRequest
  ): FisIO[StartExperimentResponse] =
    FF.liftF(StartExperimentOp(request))

  def stopExperiment(
    request: StopExperimentRequest
  ): FisIO[StopExperimentResponse] =
    FF.liftF(StopExperimentOp(request))

  def tagResource(
    request: TagResourceRequest
  ): FisIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): FisIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateExperimentTemplate(
    request: UpdateExperimentTemplateRequest
  ): FisIO[UpdateExperimentTemplateResponse] =
    FF.liftF(UpdateExperimentTemplateOp(request))
}
