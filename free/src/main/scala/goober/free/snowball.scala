package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.snowball.SnowballClient
import software.amazon.awssdk.services.snowball.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object snowball { module =>

  // Free monad over SnowballOp
  type SnowballIO[A] = FF[SnowballOp, A]

  sealed trait SnowballOp[A] {
    def visit[F[_]](visitor: SnowballOp.Visitor[F]): F[A]
  }

  object SnowballOp {
    // Given a SnowballClient we can embed a SnowballIO program in any algebra that understands embedding.
    implicit val SnowballOpEmbeddable: Embeddable[SnowballOp, SnowballClient] = new Embeddable[SnowballOp, SnowballClient] {
      def embed[A](client: SnowballClient, io: SnowballIO[A]): Embedded[A] = Embedded.Snowball(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SnowballOp.Visitor[Kleisli[M, SnowballClient, *]] {
        def cancelCluster(
          request: CancelClusterRequest
        ): Kleisli[M, SnowballClient, CancelClusterResponse] =
          primitive(_.cancelCluster(request))

        def cancelJob(
          request: CancelJobRequest
        ): Kleisli[M, SnowballClient, CancelJobResponse] =
          primitive(_.cancelJob(request))

        def createAddress(
          request: CreateAddressRequest
        ): Kleisli[M, SnowballClient, CreateAddressResponse] =
          primitive(_.createAddress(request))

        def createCluster(
          request: CreateClusterRequest
        ): Kleisli[M, SnowballClient, CreateClusterResponse] =
          primitive(_.createCluster(request))

        def createJob(
          request: CreateJobRequest
        ): Kleisli[M, SnowballClient, CreateJobResponse] =
          primitive(_.createJob(request))

        def createLongTermPricing(
          request: CreateLongTermPricingRequest
        ): Kleisli[M, SnowballClient, CreateLongTermPricingResponse] =
          primitive(_.createLongTermPricing(request))

        def createReturnShippingLabel(
          request: CreateReturnShippingLabelRequest
        ): Kleisli[M, SnowballClient, CreateReturnShippingLabelResponse] =
          primitive(_.createReturnShippingLabel(request))

        def describeAddress(
          request: DescribeAddressRequest
        ): Kleisli[M, SnowballClient, DescribeAddressResponse] =
          primitive(_.describeAddress(request))

        def describeAddresses(
          request: DescribeAddressesRequest
        ): Kleisli[M, SnowballClient, DescribeAddressesResponse] =
          primitive(_.describeAddresses(request))

        def describeCluster(
          request: DescribeClusterRequest
        ): Kleisli[M, SnowballClient, DescribeClusterResponse] =
          primitive(_.describeCluster(request))

        def describeJob(
          request: DescribeJobRequest
        ): Kleisli[M, SnowballClient, DescribeJobResponse] =
          primitive(_.describeJob(request))

        def describeReturnShippingLabel(
          request: DescribeReturnShippingLabelRequest
        ): Kleisli[M, SnowballClient, DescribeReturnShippingLabelResponse] =
          primitive(_.describeReturnShippingLabel(request))

        def getJobManifest(
          request: GetJobManifestRequest
        ): Kleisli[M, SnowballClient, GetJobManifestResponse] =
          primitive(_.getJobManifest(request))

        def getJobUnlockCode(
          request: GetJobUnlockCodeRequest
        ): Kleisli[M, SnowballClient, GetJobUnlockCodeResponse] =
          primitive(_.getJobUnlockCode(request))

        def getSnowballUsage(
          request: GetSnowballUsageRequest
        ): Kleisli[M, SnowballClient, GetSnowballUsageResponse] =
          primitive(_.getSnowballUsage(request))

        def getSoftwareUpdates(
          request: GetSoftwareUpdatesRequest
        ): Kleisli[M, SnowballClient, GetSoftwareUpdatesResponse] =
          primitive(_.getSoftwareUpdates(request))

        def listClusterJobs(
          request: ListClusterJobsRequest
        ): Kleisli[M, SnowballClient, ListClusterJobsResponse] =
          primitive(_.listClusterJobs(request))

        def listClusters(
          request: ListClustersRequest
        ): Kleisli[M, SnowballClient, ListClustersResponse] =
          primitive(_.listClusters(request))

        def listCompatibleImages(
          request: ListCompatibleImagesRequest
        ): Kleisli[M, SnowballClient, ListCompatibleImagesResponse] =
          primitive(_.listCompatibleImages(request))

        def listJobs(
          request: ListJobsRequest
        ): Kleisli[M, SnowballClient, ListJobsResponse] =
          primitive(_.listJobs(request))

        def listLongTermPricing(
          request: ListLongTermPricingRequest
        ): Kleisli[M, SnowballClient, ListLongTermPricingResponse] =
          primitive(_.listLongTermPricing(request))

        def updateCluster(
          request: UpdateClusterRequest
        ): Kleisli[M, SnowballClient, UpdateClusterResponse] =
          primitive(_.updateCluster(request))

        def updateJob(
          request: UpdateJobRequest
        ): Kleisli[M, SnowballClient, UpdateJobResponse] =
          primitive(_.updateJob(request))

        def updateJobShipmentState(
          request: UpdateJobShipmentStateRequest
        ): Kleisli[M, SnowballClient, UpdateJobShipmentStateResponse] =
          primitive(_.updateJobShipmentState(request))

        def updateLongTermPricing(
          request: UpdateLongTermPricingRequest
        ): Kleisli[M, SnowballClient, UpdateLongTermPricingResponse] =
          primitive(_.updateLongTermPricing(request))

        def primitive[A](
          f: SnowballClient => A
        ): Kleisli[M, SnowballClient, A]
      }
    }

    trait Visitor[F[_]] extends (SnowballOp ~> F) {
      final def apply[A](op: SnowballOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def cancelCluster(
        request: CancelClusterRequest
      ): F[CancelClusterResponse]

      def cancelJob(
        request: CancelJobRequest
      ): F[CancelJobResponse]

      def createAddress(
        request: CreateAddressRequest
      ): F[CreateAddressResponse]

      def createCluster(
        request: CreateClusterRequest
      ): F[CreateClusterResponse]

      def createJob(
        request: CreateJobRequest
      ): F[CreateJobResponse]

      def createLongTermPricing(
        request: CreateLongTermPricingRequest
      ): F[CreateLongTermPricingResponse]

      def createReturnShippingLabel(
        request: CreateReturnShippingLabelRequest
      ): F[CreateReturnShippingLabelResponse]

      def describeAddress(
        request: DescribeAddressRequest
      ): F[DescribeAddressResponse]

      def describeAddresses(
        request: DescribeAddressesRequest
      ): F[DescribeAddressesResponse]

      def describeCluster(
        request: DescribeClusterRequest
      ): F[DescribeClusterResponse]

      def describeJob(
        request: DescribeJobRequest
      ): F[DescribeJobResponse]

      def describeReturnShippingLabel(
        request: DescribeReturnShippingLabelRequest
      ): F[DescribeReturnShippingLabelResponse]

      def getJobManifest(
        request: GetJobManifestRequest
      ): F[GetJobManifestResponse]

      def getJobUnlockCode(
        request: GetJobUnlockCodeRequest
      ): F[GetJobUnlockCodeResponse]

      def getSnowballUsage(
        request: GetSnowballUsageRequest
      ): F[GetSnowballUsageResponse]

      def getSoftwareUpdates(
        request: GetSoftwareUpdatesRequest
      ): F[GetSoftwareUpdatesResponse]

      def listClusterJobs(
        request: ListClusterJobsRequest
      ): F[ListClusterJobsResponse]

      def listClusters(
        request: ListClustersRequest
      ): F[ListClustersResponse]

      def listCompatibleImages(
        request: ListCompatibleImagesRequest
      ): F[ListCompatibleImagesResponse]

      def listJobs(
        request: ListJobsRequest
      ): F[ListJobsResponse]

      def listLongTermPricing(
        request: ListLongTermPricingRequest
      ): F[ListLongTermPricingResponse]

      def updateCluster(
        request: UpdateClusterRequest
      ): F[UpdateClusterResponse]

      def updateJob(
        request: UpdateJobRequest
      ): F[UpdateJobResponse]

      def updateJobShipmentState(
        request: UpdateJobShipmentStateRequest
      ): F[UpdateJobShipmentStateResponse]

      def updateLongTermPricing(
        request: UpdateLongTermPricingRequest
      ): F[UpdateLongTermPricingResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SnowballOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CancelClusterOp(
      request: CancelClusterRequest
    ) extends SnowballOp[CancelClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelClusterResponse] =
        visitor.cancelCluster(request)
    }

    final case class CancelJobOp(
      request: CancelJobRequest
    ) extends SnowballOp[CancelJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelJobResponse] =
        visitor.cancelJob(request)
    }

    final case class CreateAddressOp(
      request: CreateAddressRequest
    ) extends SnowballOp[CreateAddressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAddressResponse] =
        visitor.createAddress(request)
    }

    final case class CreateClusterOp(
      request: CreateClusterRequest
    ) extends SnowballOp[CreateClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateClusterResponse] =
        visitor.createCluster(request)
    }

    final case class CreateJobOp(
      request: CreateJobRequest
    ) extends SnowballOp[CreateJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateJobResponse] =
        visitor.createJob(request)
    }

    final case class CreateLongTermPricingOp(
      request: CreateLongTermPricingRequest
    ) extends SnowballOp[CreateLongTermPricingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLongTermPricingResponse] =
        visitor.createLongTermPricing(request)
    }

    final case class CreateReturnShippingLabelOp(
      request: CreateReturnShippingLabelRequest
    ) extends SnowballOp[CreateReturnShippingLabelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateReturnShippingLabelResponse] =
        visitor.createReturnShippingLabel(request)
    }

    final case class DescribeAddressOp(
      request: DescribeAddressRequest
    ) extends SnowballOp[DescribeAddressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAddressResponse] =
        visitor.describeAddress(request)
    }

    final case class DescribeAddressesOp(
      request: DescribeAddressesRequest
    ) extends SnowballOp[DescribeAddressesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAddressesResponse] =
        visitor.describeAddresses(request)
    }

    final case class DescribeClusterOp(
      request: DescribeClusterRequest
    ) extends SnowballOp[DescribeClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClusterResponse] =
        visitor.describeCluster(request)
    }

    final case class DescribeJobOp(
      request: DescribeJobRequest
    ) extends SnowballOp[DescribeJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeJobResponse] =
        visitor.describeJob(request)
    }

    final case class DescribeReturnShippingLabelOp(
      request: DescribeReturnShippingLabelRequest
    ) extends SnowballOp[DescribeReturnShippingLabelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReturnShippingLabelResponse] =
        visitor.describeReturnShippingLabel(request)
    }

    final case class GetJobManifestOp(
      request: GetJobManifestRequest
    ) extends SnowballOp[GetJobManifestResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJobManifestResponse] =
        visitor.getJobManifest(request)
    }

    final case class GetJobUnlockCodeOp(
      request: GetJobUnlockCodeRequest
    ) extends SnowballOp[GetJobUnlockCodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJobUnlockCodeResponse] =
        visitor.getJobUnlockCode(request)
    }

    final case class GetSnowballUsageOp(
      request: GetSnowballUsageRequest
    ) extends SnowballOp[GetSnowballUsageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSnowballUsageResponse] =
        visitor.getSnowballUsage(request)
    }

    final case class GetSoftwareUpdatesOp(
      request: GetSoftwareUpdatesRequest
    ) extends SnowballOp[GetSoftwareUpdatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSoftwareUpdatesResponse] =
        visitor.getSoftwareUpdates(request)
    }

    final case class ListClusterJobsOp(
      request: ListClusterJobsRequest
    ) extends SnowballOp[ListClusterJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListClusterJobsResponse] =
        visitor.listClusterJobs(request)
    }

    final case class ListClustersOp(
      request: ListClustersRequest
    ) extends SnowballOp[ListClustersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListClustersResponse] =
        visitor.listClusters(request)
    }

    final case class ListCompatibleImagesOp(
      request: ListCompatibleImagesRequest
    ) extends SnowballOp[ListCompatibleImagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCompatibleImagesResponse] =
        visitor.listCompatibleImages(request)
    }

    final case class ListJobsOp(
      request: ListJobsRequest
    ) extends SnowballOp[ListJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJobsResponse] =
        visitor.listJobs(request)
    }

    final case class ListLongTermPricingOp(
      request: ListLongTermPricingRequest
    ) extends SnowballOp[ListLongTermPricingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLongTermPricingResponse] =
        visitor.listLongTermPricing(request)
    }

    final case class UpdateClusterOp(
      request: UpdateClusterRequest
    ) extends SnowballOp[UpdateClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateClusterResponse] =
        visitor.updateCluster(request)
    }

    final case class UpdateJobOp(
      request: UpdateJobRequest
    ) extends SnowballOp[UpdateJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateJobResponse] =
        visitor.updateJob(request)
    }

    final case class UpdateJobShipmentStateOp(
      request: UpdateJobShipmentStateRequest
    ) extends SnowballOp[UpdateJobShipmentStateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateJobShipmentStateResponse] =
        visitor.updateJobShipmentState(request)
    }

    final case class UpdateLongTermPricingOp(
      request: UpdateLongTermPricingRequest
    ) extends SnowballOp[UpdateLongTermPricingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLongTermPricingResponse] =
        visitor.updateLongTermPricing(request)
    }
  }

  import SnowballOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SnowballOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def cancelCluster(
    request: CancelClusterRequest
  ): SnowballIO[CancelClusterResponse] =
    FF.liftF(CancelClusterOp(request))

  def cancelJob(
    request: CancelJobRequest
  ): SnowballIO[CancelJobResponse] =
    FF.liftF(CancelJobOp(request))

  def createAddress(
    request: CreateAddressRequest
  ): SnowballIO[CreateAddressResponse] =
    FF.liftF(CreateAddressOp(request))

  def createCluster(
    request: CreateClusterRequest
  ): SnowballIO[CreateClusterResponse] =
    FF.liftF(CreateClusterOp(request))

  def createJob(
    request: CreateJobRequest
  ): SnowballIO[CreateJobResponse] =
    FF.liftF(CreateJobOp(request))

  def createLongTermPricing(
    request: CreateLongTermPricingRequest
  ): SnowballIO[CreateLongTermPricingResponse] =
    FF.liftF(CreateLongTermPricingOp(request))

  def createReturnShippingLabel(
    request: CreateReturnShippingLabelRequest
  ): SnowballIO[CreateReturnShippingLabelResponse] =
    FF.liftF(CreateReturnShippingLabelOp(request))

  def describeAddress(
    request: DescribeAddressRequest
  ): SnowballIO[DescribeAddressResponse] =
    FF.liftF(DescribeAddressOp(request))

  def describeAddresses(
    request: DescribeAddressesRequest
  ): SnowballIO[DescribeAddressesResponse] =
    FF.liftF(DescribeAddressesOp(request))

  def describeCluster(
    request: DescribeClusterRequest
  ): SnowballIO[DescribeClusterResponse] =
    FF.liftF(DescribeClusterOp(request))

  def describeJob(
    request: DescribeJobRequest
  ): SnowballIO[DescribeJobResponse] =
    FF.liftF(DescribeJobOp(request))

  def describeReturnShippingLabel(
    request: DescribeReturnShippingLabelRequest
  ): SnowballIO[DescribeReturnShippingLabelResponse] =
    FF.liftF(DescribeReturnShippingLabelOp(request))

  def getJobManifest(
    request: GetJobManifestRequest
  ): SnowballIO[GetJobManifestResponse] =
    FF.liftF(GetJobManifestOp(request))

  def getJobUnlockCode(
    request: GetJobUnlockCodeRequest
  ): SnowballIO[GetJobUnlockCodeResponse] =
    FF.liftF(GetJobUnlockCodeOp(request))

  def getSnowballUsage(
    request: GetSnowballUsageRequest
  ): SnowballIO[GetSnowballUsageResponse] =
    FF.liftF(GetSnowballUsageOp(request))

  def getSoftwareUpdates(
    request: GetSoftwareUpdatesRequest
  ): SnowballIO[GetSoftwareUpdatesResponse] =
    FF.liftF(GetSoftwareUpdatesOp(request))

  def listClusterJobs(
    request: ListClusterJobsRequest
  ): SnowballIO[ListClusterJobsResponse] =
    FF.liftF(ListClusterJobsOp(request))

  def listClusters(
    request: ListClustersRequest
  ): SnowballIO[ListClustersResponse] =
    FF.liftF(ListClustersOp(request))

  def listCompatibleImages(
    request: ListCompatibleImagesRequest
  ): SnowballIO[ListCompatibleImagesResponse] =
    FF.liftF(ListCompatibleImagesOp(request))

  def listJobs(
    request: ListJobsRequest
  ): SnowballIO[ListJobsResponse] =
    FF.liftF(ListJobsOp(request))

  def listLongTermPricing(
    request: ListLongTermPricingRequest
  ): SnowballIO[ListLongTermPricingResponse] =
    FF.liftF(ListLongTermPricingOp(request))

  def updateCluster(
    request: UpdateClusterRequest
  ): SnowballIO[UpdateClusterResponse] =
    FF.liftF(UpdateClusterOp(request))

  def updateJob(
    request: UpdateJobRequest
  ): SnowballIO[UpdateJobResponse] =
    FF.liftF(UpdateJobOp(request))

  def updateJobShipmentState(
    request: UpdateJobShipmentStateRequest
  ): SnowballIO[UpdateJobShipmentStateResponse] =
    FF.liftF(UpdateJobShipmentStateOp(request))

  def updateLongTermPricing(
    request: UpdateLongTermPricingRequest
  ): SnowballIO[UpdateLongTermPricingResponse] =
    FF.liftF(UpdateLongTermPricingOp(request))
}
