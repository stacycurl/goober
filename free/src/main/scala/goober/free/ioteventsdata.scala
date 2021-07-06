package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.ioteventsdata.IotEventsDataClient
import software.amazon.awssdk.services.ioteventsdata.model._


object ioteventsdata { module =>

  // Free monad over IotEventsDataOp
  type IotEventsDataIO[A] = FF[IotEventsDataOp, A]

  sealed trait IotEventsDataOp[A] {
    def visit[F[_]](visitor: IotEventsDataOp.Visitor[F]): F[A]
  }

  object IotEventsDataOp {
    // Given a IotEventsDataClient we can embed a IotEventsDataIO program in any algebra that understands embedding.
    implicit val IotEventsDataOpEmbeddable: Embeddable[IotEventsDataOp, IotEventsDataClient] = new Embeddable[IotEventsDataOp, IotEventsDataClient] {
      def embed[A](client: IotEventsDataClient, io: IotEventsDataIO[A]): Embedded[A] = Embedded.IotEventsData(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends IotEventsDataOp.Visitor[Kleisli[M, IotEventsDataClient, *]] {
        def batchAcknowledgeAlarm(
          request: BatchAcknowledgeAlarmRequest
        ): Kleisli[M, IotEventsDataClient, BatchAcknowledgeAlarmResponse] =
          primitive(_.batchAcknowledgeAlarm(request))

        def batchDisableAlarm(
          request: BatchDisableAlarmRequest
        ): Kleisli[M, IotEventsDataClient, BatchDisableAlarmResponse] =
          primitive(_.batchDisableAlarm(request))

        def batchEnableAlarm(
          request: BatchEnableAlarmRequest
        ): Kleisli[M, IotEventsDataClient, BatchEnableAlarmResponse] =
          primitive(_.batchEnableAlarm(request))

        def batchPutMessage(
          request: BatchPutMessageRequest
        ): Kleisli[M, IotEventsDataClient, BatchPutMessageResponse] =
          primitive(_.batchPutMessage(request))

        def batchResetAlarm(
          request: BatchResetAlarmRequest
        ): Kleisli[M, IotEventsDataClient, BatchResetAlarmResponse] =
          primitive(_.batchResetAlarm(request))

        def batchSnoozeAlarm(
          request: BatchSnoozeAlarmRequest
        ): Kleisli[M, IotEventsDataClient, BatchSnoozeAlarmResponse] =
          primitive(_.batchSnoozeAlarm(request))

        def batchUpdateDetector(
          request: BatchUpdateDetectorRequest
        ): Kleisli[M, IotEventsDataClient, BatchUpdateDetectorResponse] =
          primitive(_.batchUpdateDetector(request))

        def describeAlarm(
          request: DescribeAlarmRequest
        ): Kleisli[M, IotEventsDataClient, DescribeAlarmResponse] =
          primitive(_.describeAlarm(request))

        def describeDetector(
          request: DescribeDetectorRequest
        ): Kleisli[M, IotEventsDataClient, DescribeDetectorResponse] =
          primitive(_.describeDetector(request))

        def listAlarms(
          request: ListAlarmsRequest
        ): Kleisli[M, IotEventsDataClient, ListAlarmsResponse] =
          primitive(_.listAlarms(request))

        def listDetectors(
          request: ListDetectorsRequest
        ): Kleisli[M, IotEventsDataClient, ListDetectorsResponse] =
          primitive(_.listDetectors(request))

        def primitive[A](
          f: IotEventsDataClient => A
        ): Kleisli[M, IotEventsDataClient, A]
      }
    }

    trait Visitor[F[_]] extends (IotEventsDataOp ~> F) {
      final def apply[A](op: IotEventsDataOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchAcknowledgeAlarm(
        request: BatchAcknowledgeAlarmRequest
      ): F[BatchAcknowledgeAlarmResponse]

      def batchDisableAlarm(
        request: BatchDisableAlarmRequest
      ): F[BatchDisableAlarmResponse]

      def batchEnableAlarm(
        request: BatchEnableAlarmRequest
      ): F[BatchEnableAlarmResponse]

      def batchPutMessage(
        request: BatchPutMessageRequest
      ): F[BatchPutMessageResponse]

      def batchResetAlarm(
        request: BatchResetAlarmRequest
      ): F[BatchResetAlarmResponse]

      def batchSnoozeAlarm(
        request: BatchSnoozeAlarmRequest
      ): F[BatchSnoozeAlarmResponse]

      def batchUpdateDetector(
        request: BatchUpdateDetectorRequest
      ): F[BatchUpdateDetectorResponse]

      def describeAlarm(
        request: DescribeAlarmRequest
      ): F[DescribeAlarmResponse]

      def describeDetector(
        request: DescribeDetectorRequest
      ): F[DescribeDetectorResponse]

      def listAlarms(
        request: ListAlarmsRequest
      ): F[ListAlarmsResponse]

      def listDetectors(
        request: ListDetectorsRequest
      ): F[ListDetectorsResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends IotEventsDataOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchAcknowledgeAlarmOp(
      request: BatchAcknowledgeAlarmRequest
    ) extends IotEventsDataOp[BatchAcknowledgeAlarmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchAcknowledgeAlarmResponse] =
        visitor.batchAcknowledgeAlarm(request)
    }

    final case class BatchDisableAlarmOp(
      request: BatchDisableAlarmRequest
    ) extends IotEventsDataOp[BatchDisableAlarmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDisableAlarmResponse] =
        visitor.batchDisableAlarm(request)
    }

    final case class BatchEnableAlarmOp(
      request: BatchEnableAlarmRequest
    ) extends IotEventsDataOp[BatchEnableAlarmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchEnableAlarmResponse] =
        visitor.batchEnableAlarm(request)
    }

    final case class BatchPutMessageOp(
      request: BatchPutMessageRequest
    ) extends IotEventsDataOp[BatchPutMessageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchPutMessageResponse] =
        visitor.batchPutMessage(request)
    }

    final case class BatchResetAlarmOp(
      request: BatchResetAlarmRequest
    ) extends IotEventsDataOp[BatchResetAlarmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchResetAlarmResponse] =
        visitor.batchResetAlarm(request)
    }

    final case class BatchSnoozeAlarmOp(
      request: BatchSnoozeAlarmRequest
    ) extends IotEventsDataOp[BatchSnoozeAlarmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchSnoozeAlarmResponse] =
        visitor.batchSnoozeAlarm(request)
    }

    final case class BatchUpdateDetectorOp(
      request: BatchUpdateDetectorRequest
    ) extends IotEventsDataOp[BatchUpdateDetectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchUpdateDetectorResponse] =
        visitor.batchUpdateDetector(request)
    }

    final case class DescribeAlarmOp(
      request: DescribeAlarmRequest
    ) extends IotEventsDataOp[DescribeAlarmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAlarmResponse] =
        visitor.describeAlarm(request)
    }

    final case class DescribeDetectorOp(
      request: DescribeDetectorRequest
    ) extends IotEventsDataOp[DescribeDetectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDetectorResponse] =
        visitor.describeDetector(request)
    }

    final case class ListAlarmsOp(
      request: ListAlarmsRequest
    ) extends IotEventsDataOp[ListAlarmsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAlarmsResponse] =
        visitor.listAlarms(request)
    }

    final case class ListDetectorsOp(
      request: ListDetectorsRequest
    ) extends IotEventsDataOp[ListDetectorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDetectorsResponse] =
        visitor.listDetectors(request)
    }
  }

  import IotEventsDataOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[IotEventsDataOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchAcknowledgeAlarm(
    request: BatchAcknowledgeAlarmRequest
  ): IotEventsDataIO[BatchAcknowledgeAlarmResponse] =
    FF.liftF(BatchAcknowledgeAlarmOp(request))

  def batchDisableAlarm(
    request: BatchDisableAlarmRequest
  ): IotEventsDataIO[BatchDisableAlarmResponse] =
    FF.liftF(BatchDisableAlarmOp(request))

  def batchEnableAlarm(
    request: BatchEnableAlarmRequest
  ): IotEventsDataIO[BatchEnableAlarmResponse] =
    FF.liftF(BatchEnableAlarmOp(request))

  def batchPutMessage(
    request: BatchPutMessageRequest
  ): IotEventsDataIO[BatchPutMessageResponse] =
    FF.liftF(BatchPutMessageOp(request))

  def batchResetAlarm(
    request: BatchResetAlarmRequest
  ): IotEventsDataIO[BatchResetAlarmResponse] =
    FF.liftF(BatchResetAlarmOp(request))

  def batchSnoozeAlarm(
    request: BatchSnoozeAlarmRequest
  ): IotEventsDataIO[BatchSnoozeAlarmResponse] =
    FF.liftF(BatchSnoozeAlarmOp(request))

  def batchUpdateDetector(
    request: BatchUpdateDetectorRequest
  ): IotEventsDataIO[BatchUpdateDetectorResponse] =
    FF.liftF(BatchUpdateDetectorOp(request))

  def describeAlarm(
    request: DescribeAlarmRequest
  ): IotEventsDataIO[DescribeAlarmResponse] =
    FF.liftF(DescribeAlarmOp(request))

  def describeDetector(
    request: DescribeDetectorRequest
  ): IotEventsDataIO[DescribeDetectorResponse] =
    FF.liftF(DescribeDetectorOp(request))

  def listAlarms(
    request: ListAlarmsRequest
  ): IotEventsDataIO[ListAlarmsResponse] =
    FF.liftF(ListAlarmsOp(request))

  def listDetectors(
    request: ListDetectorsRequest
  ): IotEventsDataIO[ListDetectorsResponse] =
    FF.liftF(ListDetectorsOp(request))
}
