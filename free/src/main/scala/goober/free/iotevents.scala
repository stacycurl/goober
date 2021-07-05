package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.iotevents.IotEventsClient
import software.amazon.awssdk.services.iotevents.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object iotevents { module =>

  // Free monad over IotEventsOp
  type IotEventsIO[A] = FF[IotEventsOp, A]

  sealed trait IotEventsOp[A] {
    def visit[F[_]](visitor: IotEventsOp.Visitor[F]): F[A]
  }

  object IotEventsOp {
    // Given a IotEventsClient we can embed a IotEventsIO program in any algebra that understands embedding.
    implicit val IotEventsOpEmbeddable: Embeddable[IotEventsOp, IotEventsClient] = new Embeddable[IotEventsOp, IotEventsClient] {
      def embed[A](client: IotEventsClient, io: IotEventsIO[A]): Embedded[A] = Embedded.IotEvents(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends IotEventsOp.Visitor[Kleisli[M, IotEventsClient, *]] {
        def createAlarmModel(
          request: CreateAlarmModelRequest
        ): Kleisli[M, IotEventsClient, CreateAlarmModelResponse] =
          primitive(_.createAlarmModel(request))

        def createDetectorModel(
          request: CreateDetectorModelRequest
        ): Kleisli[M, IotEventsClient, CreateDetectorModelResponse] =
          primitive(_.createDetectorModel(request))

        def createInput(
          request: CreateInputRequest
        ): Kleisli[M, IotEventsClient, CreateInputResponse] =
          primitive(_.createInput(request))

        def deleteAlarmModel(
          request: DeleteAlarmModelRequest
        ): Kleisli[M, IotEventsClient, DeleteAlarmModelResponse] =
          primitive(_.deleteAlarmModel(request))

        def deleteDetectorModel(
          request: DeleteDetectorModelRequest
        ): Kleisli[M, IotEventsClient, DeleteDetectorModelResponse] =
          primitive(_.deleteDetectorModel(request))

        def deleteInput(
          request: DeleteInputRequest
        ): Kleisli[M, IotEventsClient, DeleteInputResponse] =
          primitive(_.deleteInput(request))

        def describeAlarmModel(
          request: DescribeAlarmModelRequest
        ): Kleisli[M, IotEventsClient, DescribeAlarmModelResponse] =
          primitive(_.describeAlarmModel(request))

        def describeDetectorModel(
          request: DescribeDetectorModelRequest
        ): Kleisli[M, IotEventsClient, DescribeDetectorModelResponse] =
          primitive(_.describeDetectorModel(request))

        def describeDetectorModelAnalysis(
          request: DescribeDetectorModelAnalysisRequest
        ): Kleisli[M, IotEventsClient, DescribeDetectorModelAnalysisResponse] =
          primitive(_.describeDetectorModelAnalysis(request))

        def describeInput(
          request: DescribeInputRequest
        ): Kleisli[M, IotEventsClient, DescribeInputResponse] =
          primitive(_.describeInput(request))

        def describeLoggingOptions(
          request: DescribeLoggingOptionsRequest
        ): Kleisli[M, IotEventsClient, DescribeLoggingOptionsResponse] =
          primitive(_.describeLoggingOptions(request))

        def getDetectorModelAnalysisResults(
          request: GetDetectorModelAnalysisResultsRequest
        ): Kleisli[M, IotEventsClient, GetDetectorModelAnalysisResultsResponse] =
          primitive(_.getDetectorModelAnalysisResults(request))

        def listAlarmModelVersions(
          request: ListAlarmModelVersionsRequest
        ): Kleisli[M, IotEventsClient, ListAlarmModelVersionsResponse] =
          primitive(_.listAlarmModelVersions(request))

        def listAlarmModels(
          request: ListAlarmModelsRequest
        ): Kleisli[M, IotEventsClient, ListAlarmModelsResponse] =
          primitive(_.listAlarmModels(request))

        def listDetectorModelVersions(
          request: ListDetectorModelVersionsRequest
        ): Kleisli[M, IotEventsClient, ListDetectorModelVersionsResponse] =
          primitive(_.listDetectorModelVersions(request))

        def listDetectorModels(
          request: ListDetectorModelsRequest
        ): Kleisli[M, IotEventsClient, ListDetectorModelsResponse] =
          primitive(_.listDetectorModels(request))

        def listInputRoutings(
          request: ListInputRoutingsRequest
        ): Kleisli[M, IotEventsClient, ListInputRoutingsResponse] =
          primitive(_.listInputRoutings(request))

        def listInputs(
          request: ListInputsRequest
        ): Kleisli[M, IotEventsClient, ListInputsResponse] =
          primitive(_.listInputs(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, IotEventsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putLoggingOptions(
          request: PutLoggingOptionsRequest
        ): Kleisli[M, IotEventsClient, PutLoggingOptionsResponse] =
          primitive(_.putLoggingOptions(request))

        def startDetectorModelAnalysis(
          request: StartDetectorModelAnalysisRequest
        ): Kleisli[M, IotEventsClient, StartDetectorModelAnalysisResponse] =
          primitive(_.startDetectorModelAnalysis(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, IotEventsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, IotEventsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAlarmModel(
          request: UpdateAlarmModelRequest
        ): Kleisli[M, IotEventsClient, UpdateAlarmModelResponse] =
          primitive(_.updateAlarmModel(request))

        def updateDetectorModel(
          request: UpdateDetectorModelRequest
        ): Kleisli[M, IotEventsClient, UpdateDetectorModelResponse] =
          primitive(_.updateDetectorModel(request))

        def updateInput(
          request: UpdateInputRequest
        ): Kleisli[M, IotEventsClient, UpdateInputResponse] =
          primitive(_.updateInput(request))

        def primitive[A](
          f: IotEventsClient => A
        ): Kleisli[M, IotEventsClient, A]
      }
    }

    trait Visitor[F[_]] extends (IotEventsOp ~> F) {
      final def apply[A](op: IotEventsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createAlarmModel(
        request: CreateAlarmModelRequest
      ): F[CreateAlarmModelResponse]

      def createDetectorModel(
        request: CreateDetectorModelRequest
      ): F[CreateDetectorModelResponse]

      def createInput(
        request: CreateInputRequest
      ): F[CreateInputResponse]

      def deleteAlarmModel(
        request: DeleteAlarmModelRequest
      ): F[DeleteAlarmModelResponse]

      def deleteDetectorModel(
        request: DeleteDetectorModelRequest
      ): F[DeleteDetectorModelResponse]

      def deleteInput(
        request: DeleteInputRequest
      ): F[DeleteInputResponse]

      def describeAlarmModel(
        request: DescribeAlarmModelRequest
      ): F[DescribeAlarmModelResponse]

      def describeDetectorModel(
        request: DescribeDetectorModelRequest
      ): F[DescribeDetectorModelResponse]

      def describeDetectorModelAnalysis(
        request: DescribeDetectorModelAnalysisRequest
      ): F[DescribeDetectorModelAnalysisResponse]

      def describeInput(
        request: DescribeInputRequest
      ): F[DescribeInputResponse]

      def describeLoggingOptions(
        request: DescribeLoggingOptionsRequest
      ): F[DescribeLoggingOptionsResponse]

      def getDetectorModelAnalysisResults(
        request: GetDetectorModelAnalysisResultsRequest
      ): F[GetDetectorModelAnalysisResultsResponse]

      def listAlarmModelVersions(
        request: ListAlarmModelVersionsRequest
      ): F[ListAlarmModelVersionsResponse]

      def listAlarmModels(
        request: ListAlarmModelsRequest
      ): F[ListAlarmModelsResponse]

      def listDetectorModelVersions(
        request: ListDetectorModelVersionsRequest
      ): F[ListDetectorModelVersionsResponse]

      def listDetectorModels(
        request: ListDetectorModelsRequest
      ): F[ListDetectorModelsResponse]

      def listInputRoutings(
        request: ListInputRoutingsRequest
      ): F[ListInputRoutingsResponse]

      def listInputs(
        request: ListInputsRequest
      ): F[ListInputsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putLoggingOptions(
        request: PutLoggingOptionsRequest
      ): F[PutLoggingOptionsResponse]

      def startDetectorModelAnalysis(
        request: StartDetectorModelAnalysisRequest
      ): F[StartDetectorModelAnalysisResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAlarmModel(
        request: UpdateAlarmModelRequest
      ): F[UpdateAlarmModelResponse]

      def updateDetectorModel(
        request: UpdateDetectorModelRequest
      ): F[UpdateDetectorModelResponse]

      def updateInput(
        request: UpdateInputRequest
      ): F[UpdateInputResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends IotEventsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateAlarmModelOp(
      request: CreateAlarmModelRequest
    ) extends IotEventsOp[CreateAlarmModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAlarmModelResponse] =
        visitor.createAlarmModel(request)
    }

    final case class CreateDetectorModelOp(
      request: CreateDetectorModelRequest
    ) extends IotEventsOp[CreateDetectorModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDetectorModelResponse] =
        visitor.createDetectorModel(request)
    }

    final case class CreateInputOp(
      request: CreateInputRequest
    ) extends IotEventsOp[CreateInputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateInputResponse] =
        visitor.createInput(request)
    }

    final case class DeleteAlarmModelOp(
      request: DeleteAlarmModelRequest
    ) extends IotEventsOp[DeleteAlarmModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAlarmModelResponse] =
        visitor.deleteAlarmModel(request)
    }

    final case class DeleteDetectorModelOp(
      request: DeleteDetectorModelRequest
    ) extends IotEventsOp[DeleteDetectorModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDetectorModelResponse] =
        visitor.deleteDetectorModel(request)
    }

    final case class DeleteInputOp(
      request: DeleteInputRequest
    ) extends IotEventsOp[DeleteInputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInputResponse] =
        visitor.deleteInput(request)
    }

    final case class DescribeAlarmModelOp(
      request: DescribeAlarmModelRequest
    ) extends IotEventsOp[DescribeAlarmModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAlarmModelResponse] =
        visitor.describeAlarmModel(request)
    }

    final case class DescribeDetectorModelOp(
      request: DescribeDetectorModelRequest
    ) extends IotEventsOp[DescribeDetectorModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDetectorModelResponse] =
        visitor.describeDetectorModel(request)
    }

    final case class DescribeDetectorModelAnalysisOp(
      request: DescribeDetectorModelAnalysisRequest
    ) extends IotEventsOp[DescribeDetectorModelAnalysisResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDetectorModelAnalysisResponse] =
        visitor.describeDetectorModelAnalysis(request)
    }

    final case class DescribeInputOp(
      request: DescribeInputRequest
    ) extends IotEventsOp[DescribeInputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInputResponse] =
        visitor.describeInput(request)
    }

    final case class DescribeLoggingOptionsOp(
      request: DescribeLoggingOptionsRequest
    ) extends IotEventsOp[DescribeLoggingOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLoggingOptionsResponse] =
        visitor.describeLoggingOptions(request)
    }

    final case class GetDetectorModelAnalysisResultsOp(
      request: GetDetectorModelAnalysisResultsRequest
    ) extends IotEventsOp[GetDetectorModelAnalysisResultsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDetectorModelAnalysisResultsResponse] =
        visitor.getDetectorModelAnalysisResults(request)
    }

    final case class ListAlarmModelVersionsOp(
      request: ListAlarmModelVersionsRequest
    ) extends IotEventsOp[ListAlarmModelVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAlarmModelVersionsResponse] =
        visitor.listAlarmModelVersions(request)
    }

    final case class ListAlarmModelsOp(
      request: ListAlarmModelsRequest
    ) extends IotEventsOp[ListAlarmModelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAlarmModelsResponse] =
        visitor.listAlarmModels(request)
    }

    final case class ListDetectorModelVersionsOp(
      request: ListDetectorModelVersionsRequest
    ) extends IotEventsOp[ListDetectorModelVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDetectorModelVersionsResponse] =
        visitor.listDetectorModelVersions(request)
    }

    final case class ListDetectorModelsOp(
      request: ListDetectorModelsRequest
    ) extends IotEventsOp[ListDetectorModelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDetectorModelsResponse] =
        visitor.listDetectorModels(request)
    }

    final case class ListInputRoutingsOp(
      request: ListInputRoutingsRequest
    ) extends IotEventsOp[ListInputRoutingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInputRoutingsResponse] =
        visitor.listInputRoutings(request)
    }

    final case class ListInputsOp(
      request: ListInputsRequest
    ) extends IotEventsOp[ListInputsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInputsResponse] =
        visitor.listInputs(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends IotEventsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutLoggingOptionsOp(
      request: PutLoggingOptionsRequest
    ) extends IotEventsOp[PutLoggingOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutLoggingOptionsResponse] =
        visitor.putLoggingOptions(request)
    }

    final case class StartDetectorModelAnalysisOp(
      request: StartDetectorModelAnalysisRequest
    ) extends IotEventsOp[StartDetectorModelAnalysisResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDetectorModelAnalysisResponse] =
        visitor.startDetectorModelAnalysis(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends IotEventsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends IotEventsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAlarmModelOp(
      request: UpdateAlarmModelRequest
    ) extends IotEventsOp[UpdateAlarmModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAlarmModelResponse] =
        visitor.updateAlarmModel(request)
    }

    final case class UpdateDetectorModelOp(
      request: UpdateDetectorModelRequest
    ) extends IotEventsOp[UpdateDetectorModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDetectorModelResponse] =
        visitor.updateDetectorModel(request)
    }

    final case class UpdateInputOp(
      request: UpdateInputRequest
    ) extends IotEventsOp[UpdateInputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateInputResponse] =
        visitor.updateInput(request)
    }
  }

  import IotEventsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[IotEventsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createAlarmModel(
    request: CreateAlarmModelRequest
  ): IotEventsIO[CreateAlarmModelResponse] =
    FF.liftF(CreateAlarmModelOp(request))

  def createDetectorModel(
    request: CreateDetectorModelRequest
  ): IotEventsIO[CreateDetectorModelResponse] =
    FF.liftF(CreateDetectorModelOp(request))

  def createInput(
    request: CreateInputRequest
  ): IotEventsIO[CreateInputResponse] =
    FF.liftF(CreateInputOp(request))

  def deleteAlarmModel(
    request: DeleteAlarmModelRequest
  ): IotEventsIO[DeleteAlarmModelResponse] =
    FF.liftF(DeleteAlarmModelOp(request))

  def deleteDetectorModel(
    request: DeleteDetectorModelRequest
  ): IotEventsIO[DeleteDetectorModelResponse] =
    FF.liftF(DeleteDetectorModelOp(request))

  def deleteInput(
    request: DeleteInputRequest
  ): IotEventsIO[DeleteInputResponse] =
    FF.liftF(DeleteInputOp(request))

  def describeAlarmModel(
    request: DescribeAlarmModelRequest
  ): IotEventsIO[DescribeAlarmModelResponse] =
    FF.liftF(DescribeAlarmModelOp(request))

  def describeDetectorModel(
    request: DescribeDetectorModelRequest
  ): IotEventsIO[DescribeDetectorModelResponse] =
    FF.liftF(DescribeDetectorModelOp(request))

  def describeDetectorModelAnalysis(
    request: DescribeDetectorModelAnalysisRequest
  ): IotEventsIO[DescribeDetectorModelAnalysisResponse] =
    FF.liftF(DescribeDetectorModelAnalysisOp(request))

  def describeInput(
    request: DescribeInputRequest
  ): IotEventsIO[DescribeInputResponse] =
    FF.liftF(DescribeInputOp(request))

  def describeLoggingOptions(
    request: DescribeLoggingOptionsRequest
  ): IotEventsIO[DescribeLoggingOptionsResponse] =
    FF.liftF(DescribeLoggingOptionsOp(request))

  def getDetectorModelAnalysisResults(
    request: GetDetectorModelAnalysisResultsRequest
  ): IotEventsIO[GetDetectorModelAnalysisResultsResponse] =
    FF.liftF(GetDetectorModelAnalysisResultsOp(request))

  def listAlarmModelVersions(
    request: ListAlarmModelVersionsRequest
  ): IotEventsIO[ListAlarmModelVersionsResponse] =
    FF.liftF(ListAlarmModelVersionsOp(request))

  def listAlarmModels(
    request: ListAlarmModelsRequest
  ): IotEventsIO[ListAlarmModelsResponse] =
    FF.liftF(ListAlarmModelsOp(request))

  def listDetectorModelVersions(
    request: ListDetectorModelVersionsRequest
  ): IotEventsIO[ListDetectorModelVersionsResponse] =
    FF.liftF(ListDetectorModelVersionsOp(request))

  def listDetectorModels(
    request: ListDetectorModelsRequest
  ): IotEventsIO[ListDetectorModelsResponse] =
    FF.liftF(ListDetectorModelsOp(request))

  def listInputRoutings(
    request: ListInputRoutingsRequest
  ): IotEventsIO[ListInputRoutingsResponse] =
    FF.liftF(ListInputRoutingsOp(request))

  def listInputs(
    request: ListInputsRequest
  ): IotEventsIO[ListInputsResponse] =
    FF.liftF(ListInputsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): IotEventsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putLoggingOptions(
    request: PutLoggingOptionsRequest
  ): IotEventsIO[PutLoggingOptionsResponse] =
    FF.liftF(PutLoggingOptionsOp(request))

  def startDetectorModelAnalysis(
    request: StartDetectorModelAnalysisRequest
  ): IotEventsIO[StartDetectorModelAnalysisResponse] =
    FF.liftF(StartDetectorModelAnalysisOp(request))

  def tagResource(
    request: TagResourceRequest
  ): IotEventsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): IotEventsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAlarmModel(
    request: UpdateAlarmModelRequest
  ): IotEventsIO[UpdateAlarmModelResponse] =
    FF.liftF(UpdateAlarmModelOp(request))

  def updateDetectorModel(
    request: UpdateDetectorModelRequest
  ): IotEventsIO[UpdateDetectorModelResponse] =
    FF.liftF(UpdateDetectorModelOp(request))

  def updateInput(
    request: UpdateInputRequest
  ): IotEventsIO[UpdateInputResponse] =
    FF.liftF(UpdateInputOp(request))
}
