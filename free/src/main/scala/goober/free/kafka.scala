package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.kafka.KafkaClient
import software.amazon.awssdk.services.kafka.model._


object kafka { module =>

  // Free monad over KafkaOp
  type KafkaIO[A] = FF[KafkaOp, A]

  sealed trait KafkaOp[A] {
    def visit[F[_]](visitor: KafkaOp.Visitor[F]): F[A]
  }

  object KafkaOp {
    // Given a KafkaClient we can embed a KafkaIO program in any algebra that understands embedding.
    implicit val KafkaOpEmbeddable: Embeddable[KafkaOp, KafkaClient] = new Embeddable[KafkaOp, KafkaClient] {
      def embed[A](client: KafkaClient, io: KafkaIO[A]): Embedded[A] = Embedded.Kafka(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends KafkaOp.Visitor[Kleisli[M, KafkaClient, *]] {
        def batchAssociateScramSecret(
          request: BatchAssociateScramSecretRequest
        ): Kleisli[M, KafkaClient, BatchAssociateScramSecretResponse] =
          primitive(_.batchAssociateScramSecret(request))

        def batchDisassociateScramSecret(
          request: BatchDisassociateScramSecretRequest
        ): Kleisli[M, KafkaClient, BatchDisassociateScramSecretResponse] =
          primitive(_.batchDisassociateScramSecret(request))

        def createCluster(
          request: CreateClusterRequest
        ): Kleisli[M, KafkaClient, CreateClusterResponse] =
          primitive(_.createCluster(request))

        def createConfiguration(
          request: CreateConfigurationRequest
        ): Kleisli[M, KafkaClient, CreateConfigurationResponse] =
          primitive(_.createConfiguration(request))

        def deleteCluster(
          request: DeleteClusterRequest
        ): Kleisli[M, KafkaClient, DeleteClusterResponse] =
          primitive(_.deleteCluster(request))

        def deleteConfiguration(
          request: DeleteConfigurationRequest
        ): Kleisli[M, KafkaClient, DeleteConfigurationResponse] =
          primitive(_.deleteConfiguration(request))

        def describeCluster(
          request: DescribeClusterRequest
        ): Kleisli[M, KafkaClient, DescribeClusterResponse] =
          primitive(_.describeCluster(request))

        def describeClusterOperation(
          request: DescribeClusterOperationRequest
        ): Kleisli[M, KafkaClient, DescribeClusterOperationResponse] =
          primitive(_.describeClusterOperation(request))

        def describeConfiguration(
          request: DescribeConfigurationRequest
        ): Kleisli[M, KafkaClient, DescribeConfigurationResponse] =
          primitive(_.describeConfiguration(request))

        def describeConfigurationRevision(
          request: DescribeConfigurationRevisionRequest
        ): Kleisli[M, KafkaClient, DescribeConfigurationRevisionResponse] =
          primitive(_.describeConfigurationRevision(request))

        def getBootstrapBrokers(
          request: GetBootstrapBrokersRequest
        ): Kleisli[M, KafkaClient, GetBootstrapBrokersResponse] =
          primitive(_.getBootstrapBrokers(request))

        def getCompatibleKafkaVersions(
          request: GetCompatibleKafkaVersionsRequest
        ): Kleisli[M, KafkaClient, GetCompatibleKafkaVersionsResponse] =
          primitive(_.getCompatibleKafkaVersions(request))

        def listClusterOperations(
          request: ListClusterOperationsRequest
        ): Kleisli[M, KafkaClient, ListClusterOperationsResponse] =
          primitive(_.listClusterOperations(request))

        def listClusters(
          request: ListClustersRequest
        ): Kleisli[M, KafkaClient, ListClustersResponse] =
          primitive(_.listClusters(request))

        def listConfigurationRevisions(
          request: ListConfigurationRevisionsRequest
        ): Kleisli[M, KafkaClient, ListConfigurationRevisionsResponse] =
          primitive(_.listConfigurationRevisions(request))

        def listConfigurations(
          request: ListConfigurationsRequest
        ): Kleisli[M, KafkaClient, ListConfigurationsResponse] =
          primitive(_.listConfigurations(request))

        def listKafkaVersions(
          request: ListKafkaVersionsRequest
        ): Kleisli[M, KafkaClient, ListKafkaVersionsResponse] =
          primitive(_.listKafkaVersions(request))

        def listNodes(
          request: ListNodesRequest
        ): Kleisli[M, KafkaClient, ListNodesResponse] =
          primitive(_.listNodes(request))

        def listScramSecrets(
          request: ListScramSecretsRequest
        ): Kleisli[M, KafkaClient, ListScramSecretsResponse] =
          primitive(_.listScramSecrets(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, KafkaClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def rebootBroker(
          request: RebootBrokerRequest
        ): Kleisli[M, KafkaClient, RebootBrokerResponse] =
          primitive(_.rebootBroker(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, KafkaClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, KafkaClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateBrokerCount(
          request: UpdateBrokerCountRequest
        ): Kleisli[M, KafkaClient, UpdateBrokerCountResponse] =
          primitive(_.updateBrokerCount(request))

        def updateBrokerStorage(
          request: UpdateBrokerStorageRequest
        ): Kleisli[M, KafkaClient, UpdateBrokerStorageResponse] =
          primitive(_.updateBrokerStorage(request))

        def updateBrokerType(
          request: UpdateBrokerTypeRequest
        ): Kleisli[M, KafkaClient, UpdateBrokerTypeResponse] =
          primitive(_.updateBrokerType(request))

        def updateClusterConfiguration(
          request: UpdateClusterConfigurationRequest
        ): Kleisli[M, KafkaClient, UpdateClusterConfigurationResponse] =
          primitive(_.updateClusterConfiguration(request))

        def updateClusterKafkaVersion(
          request: UpdateClusterKafkaVersionRequest
        ): Kleisli[M, KafkaClient, UpdateClusterKafkaVersionResponse] =
          primitive(_.updateClusterKafkaVersion(request))

        def updateConfiguration(
          request: UpdateConfigurationRequest
        ): Kleisli[M, KafkaClient, UpdateConfigurationResponse] =
          primitive(_.updateConfiguration(request))

        def updateMonitoring(
          request: UpdateMonitoringRequest
        ): Kleisli[M, KafkaClient, UpdateMonitoringResponse] =
          primitive(_.updateMonitoring(request))

        def primitive[A](
          f: KafkaClient => A
        ): Kleisli[M, KafkaClient, A]
      }
    }

    trait Visitor[F[_]] extends (KafkaOp ~> F) {
      final def apply[A](op: KafkaOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchAssociateScramSecret(
        request: BatchAssociateScramSecretRequest
      ): F[BatchAssociateScramSecretResponse]

      def batchDisassociateScramSecret(
        request: BatchDisassociateScramSecretRequest
      ): F[BatchDisassociateScramSecretResponse]

      def createCluster(
        request: CreateClusterRequest
      ): F[CreateClusterResponse]

      def createConfiguration(
        request: CreateConfigurationRequest
      ): F[CreateConfigurationResponse]

      def deleteCluster(
        request: DeleteClusterRequest
      ): F[DeleteClusterResponse]

      def deleteConfiguration(
        request: DeleteConfigurationRequest
      ): F[DeleteConfigurationResponse]

      def describeCluster(
        request: DescribeClusterRequest
      ): F[DescribeClusterResponse]

      def describeClusterOperation(
        request: DescribeClusterOperationRequest
      ): F[DescribeClusterOperationResponse]

      def describeConfiguration(
        request: DescribeConfigurationRequest
      ): F[DescribeConfigurationResponse]

      def describeConfigurationRevision(
        request: DescribeConfigurationRevisionRequest
      ): F[DescribeConfigurationRevisionResponse]

      def getBootstrapBrokers(
        request: GetBootstrapBrokersRequest
      ): F[GetBootstrapBrokersResponse]

      def getCompatibleKafkaVersions(
        request: GetCompatibleKafkaVersionsRequest
      ): F[GetCompatibleKafkaVersionsResponse]

      def listClusterOperations(
        request: ListClusterOperationsRequest
      ): F[ListClusterOperationsResponse]

      def listClusters(
        request: ListClustersRequest
      ): F[ListClustersResponse]

      def listConfigurationRevisions(
        request: ListConfigurationRevisionsRequest
      ): F[ListConfigurationRevisionsResponse]

      def listConfigurations(
        request: ListConfigurationsRequest
      ): F[ListConfigurationsResponse]

      def listKafkaVersions(
        request: ListKafkaVersionsRequest
      ): F[ListKafkaVersionsResponse]

      def listNodes(
        request: ListNodesRequest
      ): F[ListNodesResponse]

      def listScramSecrets(
        request: ListScramSecretsRequest
      ): F[ListScramSecretsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def rebootBroker(
        request: RebootBrokerRequest
      ): F[RebootBrokerResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateBrokerCount(
        request: UpdateBrokerCountRequest
      ): F[UpdateBrokerCountResponse]

      def updateBrokerStorage(
        request: UpdateBrokerStorageRequest
      ): F[UpdateBrokerStorageResponse]

      def updateBrokerType(
        request: UpdateBrokerTypeRequest
      ): F[UpdateBrokerTypeResponse]

      def updateClusterConfiguration(
        request: UpdateClusterConfigurationRequest
      ): F[UpdateClusterConfigurationResponse]

      def updateClusterKafkaVersion(
        request: UpdateClusterKafkaVersionRequest
      ): F[UpdateClusterKafkaVersionResponse]

      def updateConfiguration(
        request: UpdateConfigurationRequest
      ): F[UpdateConfigurationResponse]

      def updateMonitoring(
        request: UpdateMonitoringRequest
      ): F[UpdateMonitoringResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends KafkaOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchAssociateScramSecretOp(
      request: BatchAssociateScramSecretRequest
    ) extends KafkaOp[BatchAssociateScramSecretResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchAssociateScramSecretResponse] =
        visitor.batchAssociateScramSecret(request)
    }

    final case class BatchDisassociateScramSecretOp(
      request: BatchDisassociateScramSecretRequest
    ) extends KafkaOp[BatchDisassociateScramSecretResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDisassociateScramSecretResponse] =
        visitor.batchDisassociateScramSecret(request)
    }

    final case class CreateClusterOp(
      request: CreateClusterRequest
    ) extends KafkaOp[CreateClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateClusterResponse] =
        visitor.createCluster(request)
    }

    final case class CreateConfigurationOp(
      request: CreateConfigurationRequest
    ) extends KafkaOp[CreateConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConfigurationResponse] =
        visitor.createConfiguration(request)
    }

    final case class DeleteClusterOp(
      request: DeleteClusterRequest
    ) extends KafkaOp[DeleteClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteClusterResponse] =
        visitor.deleteCluster(request)
    }

    final case class DeleteConfigurationOp(
      request: DeleteConfigurationRequest
    ) extends KafkaOp[DeleteConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConfigurationResponse] =
        visitor.deleteConfiguration(request)
    }

    final case class DescribeClusterOp(
      request: DescribeClusterRequest
    ) extends KafkaOp[DescribeClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClusterResponse] =
        visitor.describeCluster(request)
    }

    final case class DescribeClusterOperationOp(
      request: DescribeClusterOperationRequest
    ) extends KafkaOp[DescribeClusterOperationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClusterOperationResponse] =
        visitor.describeClusterOperation(request)
    }

    final case class DescribeConfigurationOp(
      request: DescribeConfigurationRequest
    ) extends KafkaOp[DescribeConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConfigurationResponse] =
        visitor.describeConfiguration(request)
    }

    final case class DescribeConfigurationRevisionOp(
      request: DescribeConfigurationRevisionRequest
    ) extends KafkaOp[DescribeConfigurationRevisionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConfigurationRevisionResponse] =
        visitor.describeConfigurationRevision(request)
    }

    final case class GetBootstrapBrokersOp(
      request: GetBootstrapBrokersRequest
    ) extends KafkaOp[GetBootstrapBrokersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBootstrapBrokersResponse] =
        visitor.getBootstrapBrokers(request)
    }

    final case class GetCompatibleKafkaVersionsOp(
      request: GetCompatibleKafkaVersionsRequest
    ) extends KafkaOp[GetCompatibleKafkaVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCompatibleKafkaVersionsResponse] =
        visitor.getCompatibleKafkaVersions(request)
    }

    final case class ListClusterOperationsOp(
      request: ListClusterOperationsRequest
    ) extends KafkaOp[ListClusterOperationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListClusterOperationsResponse] =
        visitor.listClusterOperations(request)
    }

    final case class ListClustersOp(
      request: ListClustersRequest
    ) extends KafkaOp[ListClustersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListClustersResponse] =
        visitor.listClusters(request)
    }

    final case class ListConfigurationRevisionsOp(
      request: ListConfigurationRevisionsRequest
    ) extends KafkaOp[ListConfigurationRevisionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConfigurationRevisionsResponse] =
        visitor.listConfigurationRevisions(request)
    }

    final case class ListConfigurationsOp(
      request: ListConfigurationsRequest
    ) extends KafkaOp[ListConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConfigurationsResponse] =
        visitor.listConfigurations(request)
    }

    final case class ListKafkaVersionsOp(
      request: ListKafkaVersionsRequest
    ) extends KafkaOp[ListKafkaVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListKafkaVersionsResponse] =
        visitor.listKafkaVersions(request)
    }

    final case class ListNodesOp(
      request: ListNodesRequest
    ) extends KafkaOp[ListNodesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListNodesResponse] =
        visitor.listNodes(request)
    }

    final case class ListScramSecretsOp(
      request: ListScramSecretsRequest
    ) extends KafkaOp[ListScramSecretsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListScramSecretsResponse] =
        visitor.listScramSecrets(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends KafkaOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class RebootBrokerOp(
      request: RebootBrokerRequest
    ) extends KafkaOp[RebootBrokerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RebootBrokerResponse] =
        visitor.rebootBroker(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends KafkaOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends KafkaOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateBrokerCountOp(
      request: UpdateBrokerCountRequest
    ) extends KafkaOp[UpdateBrokerCountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBrokerCountResponse] =
        visitor.updateBrokerCount(request)
    }

    final case class UpdateBrokerStorageOp(
      request: UpdateBrokerStorageRequest
    ) extends KafkaOp[UpdateBrokerStorageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBrokerStorageResponse] =
        visitor.updateBrokerStorage(request)
    }

    final case class UpdateBrokerTypeOp(
      request: UpdateBrokerTypeRequest
    ) extends KafkaOp[UpdateBrokerTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBrokerTypeResponse] =
        visitor.updateBrokerType(request)
    }

    final case class UpdateClusterConfigurationOp(
      request: UpdateClusterConfigurationRequest
    ) extends KafkaOp[UpdateClusterConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateClusterConfigurationResponse] =
        visitor.updateClusterConfiguration(request)
    }

    final case class UpdateClusterKafkaVersionOp(
      request: UpdateClusterKafkaVersionRequest
    ) extends KafkaOp[UpdateClusterKafkaVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateClusterKafkaVersionResponse] =
        visitor.updateClusterKafkaVersion(request)
    }

    final case class UpdateConfigurationOp(
      request: UpdateConfigurationRequest
    ) extends KafkaOp[UpdateConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConfigurationResponse] =
        visitor.updateConfiguration(request)
    }

    final case class UpdateMonitoringOp(
      request: UpdateMonitoringRequest
    ) extends KafkaOp[UpdateMonitoringResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMonitoringResponse] =
        visitor.updateMonitoring(request)
    }
  }

  import KafkaOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[KafkaOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchAssociateScramSecret(
    request: BatchAssociateScramSecretRequest
  ): KafkaIO[BatchAssociateScramSecretResponse] =
    FF.liftF(BatchAssociateScramSecretOp(request))

  def batchDisassociateScramSecret(
    request: BatchDisassociateScramSecretRequest
  ): KafkaIO[BatchDisassociateScramSecretResponse] =
    FF.liftF(BatchDisassociateScramSecretOp(request))

  def createCluster(
    request: CreateClusterRequest
  ): KafkaIO[CreateClusterResponse] =
    FF.liftF(CreateClusterOp(request))

  def createConfiguration(
    request: CreateConfigurationRequest
  ): KafkaIO[CreateConfigurationResponse] =
    FF.liftF(CreateConfigurationOp(request))

  def deleteCluster(
    request: DeleteClusterRequest
  ): KafkaIO[DeleteClusterResponse] =
    FF.liftF(DeleteClusterOp(request))

  def deleteConfiguration(
    request: DeleteConfigurationRequest
  ): KafkaIO[DeleteConfigurationResponse] =
    FF.liftF(DeleteConfigurationOp(request))

  def describeCluster(
    request: DescribeClusterRequest
  ): KafkaIO[DescribeClusterResponse] =
    FF.liftF(DescribeClusterOp(request))

  def describeClusterOperation(
    request: DescribeClusterOperationRequest
  ): KafkaIO[DescribeClusterOperationResponse] =
    FF.liftF(DescribeClusterOperationOp(request))

  def describeConfiguration(
    request: DescribeConfigurationRequest
  ): KafkaIO[DescribeConfigurationResponse] =
    FF.liftF(DescribeConfigurationOp(request))

  def describeConfigurationRevision(
    request: DescribeConfigurationRevisionRequest
  ): KafkaIO[DescribeConfigurationRevisionResponse] =
    FF.liftF(DescribeConfigurationRevisionOp(request))

  def getBootstrapBrokers(
    request: GetBootstrapBrokersRequest
  ): KafkaIO[GetBootstrapBrokersResponse] =
    FF.liftF(GetBootstrapBrokersOp(request))

  def getCompatibleKafkaVersions(
    request: GetCompatibleKafkaVersionsRequest
  ): KafkaIO[GetCompatibleKafkaVersionsResponse] =
    FF.liftF(GetCompatibleKafkaVersionsOp(request))

  def listClusterOperations(
    request: ListClusterOperationsRequest
  ): KafkaIO[ListClusterOperationsResponse] =
    FF.liftF(ListClusterOperationsOp(request))

  def listClusters(
    request: ListClustersRequest
  ): KafkaIO[ListClustersResponse] =
    FF.liftF(ListClustersOp(request))

  def listConfigurationRevisions(
    request: ListConfigurationRevisionsRequest
  ): KafkaIO[ListConfigurationRevisionsResponse] =
    FF.liftF(ListConfigurationRevisionsOp(request))

  def listConfigurations(
    request: ListConfigurationsRequest
  ): KafkaIO[ListConfigurationsResponse] =
    FF.liftF(ListConfigurationsOp(request))

  def listKafkaVersions(
    request: ListKafkaVersionsRequest
  ): KafkaIO[ListKafkaVersionsResponse] =
    FF.liftF(ListKafkaVersionsOp(request))

  def listNodes(
    request: ListNodesRequest
  ): KafkaIO[ListNodesResponse] =
    FF.liftF(ListNodesOp(request))

  def listScramSecrets(
    request: ListScramSecretsRequest
  ): KafkaIO[ListScramSecretsResponse] =
    FF.liftF(ListScramSecretsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): KafkaIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def rebootBroker(
    request: RebootBrokerRequest
  ): KafkaIO[RebootBrokerResponse] =
    FF.liftF(RebootBrokerOp(request))

  def tagResource(
    request: TagResourceRequest
  ): KafkaIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): KafkaIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateBrokerCount(
    request: UpdateBrokerCountRequest
  ): KafkaIO[UpdateBrokerCountResponse] =
    FF.liftF(UpdateBrokerCountOp(request))

  def updateBrokerStorage(
    request: UpdateBrokerStorageRequest
  ): KafkaIO[UpdateBrokerStorageResponse] =
    FF.liftF(UpdateBrokerStorageOp(request))

  def updateBrokerType(
    request: UpdateBrokerTypeRequest
  ): KafkaIO[UpdateBrokerTypeResponse] =
    FF.liftF(UpdateBrokerTypeOp(request))

  def updateClusterConfiguration(
    request: UpdateClusterConfigurationRequest
  ): KafkaIO[UpdateClusterConfigurationResponse] =
    FF.liftF(UpdateClusterConfigurationOp(request))

  def updateClusterKafkaVersion(
    request: UpdateClusterKafkaVersionRequest
  ): KafkaIO[UpdateClusterKafkaVersionResponse] =
    FF.liftF(UpdateClusterKafkaVersionOp(request))

  def updateConfiguration(
    request: UpdateConfigurationRequest
  ): KafkaIO[UpdateConfigurationResponse] =
    FF.liftF(UpdateConfigurationOp(request))

  def updateMonitoring(
    request: UpdateMonitoringRequest
  ): KafkaIO[UpdateMonitoringResponse] =
    FF.liftF(UpdateMonitoringOp(request))
}
