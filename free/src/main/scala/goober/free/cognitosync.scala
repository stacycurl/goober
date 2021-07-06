package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.cognitosync.CognitoSyncClient
import software.amazon.awssdk.services.cognitosync.model._


object cognitosync { module =>

  // Free monad over CognitoSyncOp
  type CognitoSyncIO[A] = FF[CognitoSyncOp, A]

  sealed trait CognitoSyncOp[A] {
    def visit[F[_]](visitor: CognitoSyncOp.Visitor[F]): F[A]
  }

  object CognitoSyncOp {
    // Given a CognitoSyncClient we can embed a CognitoSyncIO program in any algebra that understands embedding.
    implicit val CognitoSyncOpEmbeddable: Embeddable[CognitoSyncOp, CognitoSyncClient] = new Embeddable[CognitoSyncOp, CognitoSyncClient] {
      def embed[A](client: CognitoSyncClient, io: CognitoSyncIO[A]): Embedded[A] = Embedded.CognitoSync(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CognitoSyncOp.Visitor[Kleisli[M, CognitoSyncClient, *]] {
        def bulkPublish(
          request: BulkPublishRequest
        ): Kleisli[M, CognitoSyncClient, BulkPublishResponse] =
          primitive(_.bulkPublish(request))

        def deleteDataset(
          request: DeleteDatasetRequest
        ): Kleisli[M, CognitoSyncClient, DeleteDatasetResponse] =
          primitive(_.deleteDataset(request))

        def describeDataset(
          request: DescribeDatasetRequest
        ): Kleisli[M, CognitoSyncClient, DescribeDatasetResponse] =
          primitive(_.describeDataset(request))

        def describeIdentityPoolUsage(
          request: DescribeIdentityPoolUsageRequest
        ): Kleisli[M, CognitoSyncClient, DescribeIdentityPoolUsageResponse] =
          primitive(_.describeIdentityPoolUsage(request))

        def describeIdentityUsage(
          request: DescribeIdentityUsageRequest
        ): Kleisli[M, CognitoSyncClient, DescribeIdentityUsageResponse] =
          primitive(_.describeIdentityUsage(request))

        def getBulkPublishDetails(
          request: GetBulkPublishDetailsRequest
        ): Kleisli[M, CognitoSyncClient, GetBulkPublishDetailsResponse] =
          primitive(_.getBulkPublishDetails(request))

        def getCognitoEvents(
          request: GetCognitoEventsRequest
        ): Kleisli[M, CognitoSyncClient, GetCognitoEventsResponse] =
          primitive(_.getCognitoEvents(request))

        def getIdentityPoolConfiguration(
          request: GetIdentityPoolConfigurationRequest
        ): Kleisli[M, CognitoSyncClient, GetIdentityPoolConfigurationResponse] =
          primitive(_.getIdentityPoolConfiguration(request))

        def listDatasets(
          request: ListDatasetsRequest
        ): Kleisli[M, CognitoSyncClient, ListDatasetsResponse] =
          primitive(_.listDatasets(request))

        def listIdentityPoolUsage(
          request: ListIdentityPoolUsageRequest
        ): Kleisli[M, CognitoSyncClient, ListIdentityPoolUsageResponse] =
          primitive(_.listIdentityPoolUsage(request))

        def listRecords(
          request: ListRecordsRequest
        ): Kleisli[M, CognitoSyncClient, ListRecordsResponse] =
          primitive(_.listRecords(request))

        def registerDevice(
          request: RegisterDeviceRequest
        ): Kleisli[M, CognitoSyncClient, RegisterDeviceResponse] =
          primitive(_.registerDevice(request))

        def setCognitoEvents(
          request: SetCognitoEventsRequest
        ): Kleisli[M, CognitoSyncClient, SetCognitoEventsResponse] =
          primitive(_.setCognitoEvents(request))

        def setIdentityPoolConfiguration(
          request: SetIdentityPoolConfigurationRequest
        ): Kleisli[M, CognitoSyncClient, SetIdentityPoolConfigurationResponse] =
          primitive(_.setIdentityPoolConfiguration(request))

        def subscribeToDataset(
          request: SubscribeToDatasetRequest
        ): Kleisli[M, CognitoSyncClient, SubscribeToDatasetResponse] =
          primitive(_.subscribeToDataset(request))

        def unsubscribeFromDataset(
          request: UnsubscribeFromDatasetRequest
        ): Kleisli[M, CognitoSyncClient, UnsubscribeFromDatasetResponse] =
          primitive(_.unsubscribeFromDataset(request))

        def updateRecords(
          request: UpdateRecordsRequest
        ): Kleisli[M, CognitoSyncClient, UpdateRecordsResponse] =
          primitive(_.updateRecords(request))

        def primitive[A](
          f: CognitoSyncClient => A
        ): Kleisli[M, CognitoSyncClient, A]
      }
    }

    trait Visitor[F[_]] extends (CognitoSyncOp ~> F) {
      final def apply[A](op: CognitoSyncOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def bulkPublish(
        request: BulkPublishRequest
      ): F[BulkPublishResponse]

      def deleteDataset(
        request: DeleteDatasetRequest
      ): F[DeleteDatasetResponse]

      def describeDataset(
        request: DescribeDatasetRequest
      ): F[DescribeDatasetResponse]

      def describeIdentityPoolUsage(
        request: DescribeIdentityPoolUsageRequest
      ): F[DescribeIdentityPoolUsageResponse]

      def describeIdentityUsage(
        request: DescribeIdentityUsageRequest
      ): F[DescribeIdentityUsageResponse]

      def getBulkPublishDetails(
        request: GetBulkPublishDetailsRequest
      ): F[GetBulkPublishDetailsResponse]

      def getCognitoEvents(
        request: GetCognitoEventsRequest
      ): F[GetCognitoEventsResponse]

      def getIdentityPoolConfiguration(
        request: GetIdentityPoolConfigurationRequest
      ): F[GetIdentityPoolConfigurationResponse]

      def listDatasets(
        request: ListDatasetsRequest
      ): F[ListDatasetsResponse]

      def listIdentityPoolUsage(
        request: ListIdentityPoolUsageRequest
      ): F[ListIdentityPoolUsageResponse]

      def listRecords(
        request: ListRecordsRequest
      ): F[ListRecordsResponse]

      def registerDevice(
        request: RegisterDeviceRequest
      ): F[RegisterDeviceResponse]

      def setCognitoEvents(
        request: SetCognitoEventsRequest
      ): F[SetCognitoEventsResponse]

      def setIdentityPoolConfiguration(
        request: SetIdentityPoolConfigurationRequest
      ): F[SetIdentityPoolConfigurationResponse]

      def subscribeToDataset(
        request: SubscribeToDatasetRequest
      ): F[SubscribeToDatasetResponse]

      def unsubscribeFromDataset(
        request: UnsubscribeFromDatasetRequest
      ): F[UnsubscribeFromDatasetResponse]

      def updateRecords(
        request: UpdateRecordsRequest
      ): F[UpdateRecordsResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CognitoSyncOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BulkPublishOp(
      request: BulkPublishRequest
    ) extends CognitoSyncOp[BulkPublishResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BulkPublishResponse] =
        visitor.bulkPublish(request)
    }

    final case class DeleteDatasetOp(
      request: DeleteDatasetRequest
    ) extends CognitoSyncOp[DeleteDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDatasetResponse] =
        visitor.deleteDataset(request)
    }

    final case class DescribeDatasetOp(
      request: DescribeDatasetRequest
    ) extends CognitoSyncOp[DescribeDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDatasetResponse] =
        visitor.describeDataset(request)
    }

    final case class DescribeIdentityPoolUsageOp(
      request: DescribeIdentityPoolUsageRequest
    ) extends CognitoSyncOp[DescribeIdentityPoolUsageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeIdentityPoolUsageResponse] =
        visitor.describeIdentityPoolUsage(request)
    }

    final case class DescribeIdentityUsageOp(
      request: DescribeIdentityUsageRequest
    ) extends CognitoSyncOp[DescribeIdentityUsageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeIdentityUsageResponse] =
        visitor.describeIdentityUsage(request)
    }

    final case class GetBulkPublishDetailsOp(
      request: GetBulkPublishDetailsRequest
    ) extends CognitoSyncOp[GetBulkPublishDetailsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBulkPublishDetailsResponse] =
        visitor.getBulkPublishDetails(request)
    }

    final case class GetCognitoEventsOp(
      request: GetCognitoEventsRequest
    ) extends CognitoSyncOp[GetCognitoEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCognitoEventsResponse] =
        visitor.getCognitoEvents(request)
    }

    final case class GetIdentityPoolConfigurationOp(
      request: GetIdentityPoolConfigurationRequest
    ) extends CognitoSyncOp[GetIdentityPoolConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIdentityPoolConfigurationResponse] =
        visitor.getIdentityPoolConfiguration(request)
    }

    final case class ListDatasetsOp(
      request: ListDatasetsRequest
    ) extends CognitoSyncOp[ListDatasetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDatasetsResponse] =
        visitor.listDatasets(request)
    }

    final case class ListIdentityPoolUsageOp(
      request: ListIdentityPoolUsageRequest
    ) extends CognitoSyncOp[ListIdentityPoolUsageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIdentityPoolUsageResponse] =
        visitor.listIdentityPoolUsage(request)
    }

    final case class ListRecordsOp(
      request: ListRecordsRequest
    ) extends CognitoSyncOp[ListRecordsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRecordsResponse] =
        visitor.listRecords(request)
    }

    final case class RegisterDeviceOp(
      request: RegisterDeviceRequest
    ) extends CognitoSyncOp[RegisterDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterDeviceResponse] =
        visitor.registerDevice(request)
    }

    final case class SetCognitoEventsOp(
      request: SetCognitoEventsRequest
    ) extends CognitoSyncOp[SetCognitoEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetCognitoEventsResponse] =
        visitor.setCognitoEvents(request)
    }

    final case class SetIdentityPoolConfigurationOp(
      request: SetIdentityPoolConfigurationRequest
    ) extends CognitoSyncOp[SetIdentityPoolConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetIdentityPoolConfigurationResponse] =
        visitor.setIdentityPoolConfiguration(request)
    }

    final case class SubscribeToDatasetOp(
      request: SubscribeToDatasetRequest
    ) extends CognitoSyncOp[SubscribeToDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SubscribeToDatasetResponse] =
        visitor.subscribeToDataset(request)
    }

    final case class UnsubscribeFromDatasetOp(
      request: UnsubscribeFromDatasetRequest
    ) extends CognitoSyncOp[UnsubscribeFromDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UnsubscribeFromDatasetResponse] =
        visitor.unsubscribeFromDataset(request)
    }

    final case class UpdateRecordsOp(
      request: UpdateRecordsRequest
    ) extends CognitoSyncOp[UpdateRecordsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRecordsResponse] =
        visitor.updateRecords(request)
    }
  }

  import CognitoSyncOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CognitoSyncOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def bulkPublish(
    request: BulkPublishRequest
  ): CognitoSyncIO[BulkPublishResponse] =
    FF.liftF(BulkPublishOp(request))

  def deleteDataset(
    request: DeleteDatasetRequest
  ): CognitoSyncIO[DeleteDatasetResponse] =
    FF.liftF(DeleteDatasetOp(request))

  def describeDataset(
    request: DescribeDatasetRequest
  ): CognitoSyncIO[DescribeDatasetResponse] =
    FF.liftF(DescribeDatasetOp(request))

  def describeIdentityPoolUsage(
    request: DescribeIdentityPoolUsageRequest
  ): CognitoSyncIO[DescribeIdentityPoolUsageResponse] =
    FF.liftF(DescribeIdentityPoolUsageOp(request))

  def describeIdentityUsage(
    request: DescribeIdentityUsageRequest
  ): CognitoSyncIO[DescribeIdentityUsageResponse] =
    FF.liftF(DescribeIdentityUsageOp(request))

  def getBulkPublishDetails(
    request: GetBulkPublishDetailsRequest
  ): CognitoSyncIO[GetBulkPublishDetailsResponse] =
    FF.liftF(GetBulkPublishDetailsOp(request))

  def getCognitoEvents(
    request: GetCognitoEventsRequest
  ): CognitoSyncIO[GetCognitoEventsResponse] =
    FF.liftF(GetCognitoEventsOp(request))

  def getIdentityPoolConfiguration(
    request: GetIdentityPoolConfigurationRequest
  ): CognitoSyncIO[GetIdentityPoolConfigurationResponse] =
    FF.liftF(GetIdentityPoolConfigurationOp(request))

  def listDatasets(
    request: ListDatasetsRequest
  ): CognitoSyncIO[ListDatasetsResponse] =
    FF.liftF(ListDatasetsOp(request))

  def listIdentityPoolUsage(
    request: ListIdentityPoolUsageRequest
  ): CognitoSyncIO[ListIdentityPoolUsageResponse] =
    FF.liftF(ListIdentityPoolUsageOp(request))

  def listRecords(
    request: ListRecordsRequest
  ): CognitoSyncIO[ListRecordsResponse] =
    FF.liftF(ListRecordsOp(request))

  def registerDevice(
    request: RegisterDeviceRequest
  ): CognitoSyncIO[RegisterDeviceResponse] =
    FF.liftF(RegisterDeviceOp(request))

  def setCognitoEvents(
    request: SetCognitoEventsRequest
  ): CognitoSyncIO[SetCognitoEventsResponse] =
    FF.liftF(SetCognitoEventsOp(request))

  def setIdentityPoolConfiguration(
    request: SetIdentityPoolConfigurationRequest
  ): CognitoSyncIO[SetIdentityPoolConfigurationResponse] =
    FF.liftF(SetIdentityPoolConfigurationOp(request))

  def subscribeToDataset(
    request: SubscribeToDatasetRequest
  ): CognitoSyncIO[SubscribeToDatasetResponse] =
    FF.liftF(SubscribeToDatasetOp(request))

  def unsubscribeFromDataset(
    request: UnsubscribeFromDatasetRequest
  ): CognitoSyncIO[UnsubscribeFromDatasetResponse] =
    FF.liftF(UnsubscribeFromDatasetOp(request))

  def updateRecords(
    request: UpdateRecordsRequest
  ): CognitoSyncIO[UpdateRecordsResponse] =
    FF.liftF(UpdateRecordsOp(request))
}
