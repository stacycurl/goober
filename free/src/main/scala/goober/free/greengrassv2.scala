package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.greengrassv2.GreengrassV2Client
import software.amazon.awssdk.services.greengrassv2.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object greengrassv2 { module =>

  // Free monad over GreengrassV2Op
  type GreengrassV2IO[A] = FF[GreengrassV2Op, A]

  sealed trait GreengrassV2Op[A] {
    def visit[F[_]](visitor: GreengrassV2Op.Visitor[F]): F[A]
  }

  object GreengrassV2Op {
    // Given a GreengrassV2Client we can embed a GreengrassV2IO program in any algebra that understands embedding.
    implicit val GreengrassV2OpEmbeddable: Embeddable[GreengrassV2Op, GreengrassV2Client] = new Embeddable[GreengrassV2Op, GreengrassV2Client] {
      def embed[A](client: GreengrassV2Client, io: GreengrassV2IO[A]): Embedded[A] = Embedded.GreengrassV2(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends GreengrassV2Op.Visitor[Kleisli[M, GreengrassV2Client, *]] {
        def batchAssociateClientDeviceWithCoreDevice(
          request: BatchAssociateClientDeviceWithCoreDeviceRequest
        ): Kleisli[M, GreengrassV2Client, BatchAssociateClientDeviceWithCoreDeviceResponse] =
          primitive(_.batchAssociateClientDeviceWithCoreDevice(request))

        def batchDisassociateClientDeviceFromCoreDevice(
          request: BatchDisassociateClientDeviceFromCoreDeviceRequest
        ): Kleisli[M, GreengrassV2Client, BatchDisassociateClientDeviceFromCoreDeviceResponse] =
          primitive(_.batchDisassociateClientDeviceFromCoreDevice(request))

        def cancelDeployment(
          request: CancelDeploymentRequest
        ): Kleisli[M, GreengrassV2Client, CancelDeploymentResponse] =
          primitive(_.cancelDeployment(request))

        def createComponentVersion(
          request: CreateComponentVersionRequest
        ): Kleisli[M, GreengrassV2Client, CreateComponentVersionResponse] =
          primitive(_.createComponentVersion(request))

        def createDeployment(
          request: CreateDeploymentRequest
        ): Kleisli[M, GreengrassV2Client, CreateDeploymentResponse] =
          primitive(_.createDeployment(request))

        def deleteComponent(
          request: DeleteComponentRequest
        ): Kleisli[M, GreengrassV2Client, DeleteComponentResponse] =
          primitive(_.deleteComponent(request))

        def deleteCoreDevice(
          request: DeleteCoreDeviceRequest
        ): Kleisli[M, GreengrassV2Client, DeleteCoreDeviceResponse] =
          primitive(_.deleteCoreDevice(request))

        def describeComponent(
          request: DescribeComponentRequest
        ): Kleisli[M, GreengrassV2Client, DescribeComponentResponse] =
          primitive(_.describeComponent(request))

        def getComponent(
          request: GetComponentRequest
        ): Kleisli[M, GreengrassV2Client, GetComponentResponse] =
          primitive(_.getComponent(request))

        def getComponentVersionArtifact(
          request: GetComponentVersionArtifactRequest
        ): Kleisli[M, GreengrassV2Client, GetComponentVersionArtifactResponse] =
          primitive(_.getComponentVersionArtifact(request))

        def getCoreDevice(
          request: GetCoreDeviceRequest
        ): Kleisli[M, GreengrassV2Client, GetCoreDeviceResponse] =
          primitive(_.getCoreDevice(request))

        def getDeployment(
          request: GetDeploymentRequest
        ): Kleisli[M, GreengrassV2Client, GetDeploymentResponse] =
          primitive(_.getDeployment(request))

        def listClientDevicesAssociatedWithCoreDevice(
          request: ListClientDevicesAssociatedWithCoreDeviceRequest
        ): Kleisli[M, GreengrassV2Client, ListClientDevicesAssociatedWithCoreDeviceResponse] =
          primitive(_.listClientDevicesAssociatedWithCoreDevice(request))

        def listComponentVersions(
          request: ListComponentVersionsRequest
        ): Kleisli[M, GreengrassV2Client, ListComponentVersionsResponse] =
          primitive(_.listComponentVersions(request))

        def listComponents(
          request: ListComponentsRequest
        ): Kleisli[M, GreengrassV2Client, ListComponentsResponse] =
          primitive(_.listComponents(request))

        def listCoreDevices(
          request: ListCoreDevicesRequest
        ): Kleisli[M, GreengrassV2Client, ListCoreDevicesResponse] =
          primitive(_.listCoreDevices(request))

        def listDeployments(
          request: ListDeploymentsRequest
        ): Kleisli[M, GreengrassV2Client, ListDeploymentsResponse] =
          primitive(_.listDeployments(request))

        def listEffectiveDeployments(
          request: ListEffectiveDeploymentsRequest
        ): Kleisli[M, GreengrassV2Client, ListEffectiveDeploymentsResponse] =
          primitive(_.listEffectiveDeployments(request))

        def listInstalledComponents(
          request: ListInstalledComponentsRequest
        ): Kleisli[M, GreengrassV2Client, ListInstalledComponentsResponse] =
          primitive(_.listInstalledComponents(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, GreengrassV2Client, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def resolveComponentCandidates(
          request: ResolveComponentCandidatesRequest
        ): Kleisli[M, GreengrassV2Client, ResolveComponentCandidatesResponse] =
          primitive(_.resolveComponentCandidates(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, GreengrassV2Client, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, GreengrassV2Client, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: GreengrassV2Client => A
        ): Kleisli[M, GreengrassV2Client, A]
      }
    }

    trait Visitor[F[_]] extends (GreengrassV2Op ~> F) {
      final def apply[A](op: GreengrassV2Op[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchAssociateClientDeviceWithCoreDevice(
        request: BatchAssociateClientDeviceWithCoreDeviceRequest
      ): F[BatchAssociateClientDeviceWithCoreDeviceResponse]

      def batchDisassociateClientDeviceFromCoreDevice(
        request: BatchDisassociateClientDeviceFromCoreDeviceRequest
      ): F[BatchDisassociateClientDeviceFromCoreDeviceResponse]

      def cancelDeployment(
        request: CancelDeploymentRequest
      ): F[CancelDeploymentResponse]

      def createComponentVersion(
        request: CreateComponentVersionRequest
      ): F[CreateComponentVersionResponse]

      def createDeployment(
        request: CreateDeploymentRequest
      ): F[CreateDeploymentResponse]

      def deleteComponent(
        request: DeleteComponentRequest
      ): F[DeleteComponentResponse]

      def deleteCoreDevice(
        request: DeleteCoreDeviceRequest
      ): F[DeleteCoreDeviceResponse]

      def describeComponent(
        request: DescribeComponentRequest
      ): F[DescribeComponentResponse]

      def getComponent(
        request: GetComponentRequest
      ): F[GetComponentResponse]

      def getComponentVersionArtifact(
        request: GetComponentVersionArtifactRequest
      ): F[GetComponentVersionArtifactResponse]

      def getCoreDevice(
        request: GetCoreDeviceRequest
      ): F[GetCoreDeviceResponse]

      def getDeployment(
        request: GetDeploymentRequest
      ): F[GetDeploymentResponse]

      def listClientDevicesAssociatedWithCoreDevice(
        request: ListClientDevicesAssociatedWithCoreDeviceRequest
      ): F[ListClientDevicesAssociatedWithCoreDeviceResponse]

      def listComponentVersions(
        request: ListComponentVersionsRequest
      ): F[ListComponentVersionsResponse]

      def listComponents(
        request: ListComponentsRequest
      ): F[ListComponentsResponse]

      def listCoreDevices(
        request: ListCoreDevicesRequest
      ): F[ListCoreDevicesResponse]

      def listDeployments(
        request: ListDeploymentsRequest
      ): F[ListDeploymentsResponse]

      def listEffectiveDeployments(
        request: ListEffectiveDeploymentsRequest
      ): F[ListEffectiveDeploymentsResponse]

      def listInstalledComponents(
        request: ListInstalledComponentsRequest
      ): F[ListInstalledComponentsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def resolveComponentCandidates(
        request: ResolveComponentCandidatesRequest
      ): F[ResolveComponentCandidatesResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends GreengrassV2Op[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchAssociateClientDeviceWithCoreDeviceOp(
      request: BatchAssociateClientDeviceWithCoreDeviceRequest
    ) extends GreengrassV2Op[BatchAssociateClientDeviceWithCoreDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchAssociateClientDeviceWithCoreDeviceResponse] =
        visitor.batchAssociateClientDeviceWithCoreDevice(request)
    }

    final case class BatchDisassociateClientDeviceFromCoreDeviceOp(
      request: BatchDisassociateClientDeviceFromCoreDeviceRequest
    ) extends GreengrassV2Op[BatchDisassociateClientDeviceFromCoreDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDisassociateClientDeviceFromCoreDeviceResponse] =
        visitor.batchDisassociateClientDeviceFromCoreDevice(request)
    }

    final case class CancelDeploymentOp(
      request: CancelDeploymentRequest
    ) extends GreengrassV2Op[CancelDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelDeploymentResponse] =
        visitor.cancelDeployment(request)
    }

    final case class CreateComponentVersionOp(
      request: CreateComponentVersionRequest
    ) extends GreengrassV2Op[CreateComponentVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateComponentVersionResponse] =
        visitor.createComponentVersion(request)
    }

    final case class CreateDeploymentOp(
      request: CreateDeploymentRequest
    ) extends GreengrassV2Op[CreateDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDeploymentResponse] =
        visitor.createDeployment(request)
    }

    final case class DeleteComponentOp(
      request: DeleteComponentRequest
    ) extends GreengrassV2Op[DeleteComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteComponentResponse] =
        visitor.deleteComponent(request)
    }

    final case class DeleteCoreDeviceOp(
      request: DeleteCoreDeviceRequest
    ) extends GreengrassV2Op[DeleteCoreDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCoreDeviceResponse] =
        visitor.deleteCoreDevice(request)
    }

    final case class DescribeComponentOp(
      request: DescribeComponentRequest
    ) extends GreengrassV2Op[DescribeComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeComponentResponse] =
        visitor.describeComponent(request)
    }

    final case class GetComponentOp(
      request: GetComponentRequest
    ) extends GreengrassV2Op[GetComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetComponentResponse] =
        visitor.getComponent(request)
    }

    final case class GetComponentVersionArtifactOp(
      request: GetComponentVersionArtifactRequest
    ) extends GreengrassV2Op[GetComponentVersionArtifactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetComponentVersionArtifactResponse] =
        visitor.getComponentVersionArtifact(request)
    }

    final case class GetCoreDeviceOp(
      request: GetCoreDeviceRequest
    ) extends GreengrassV2Op[GetCoreDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCoreDeviceResponse] =
        visitor.getCoreDevice(request)
    }

    final case class GetDeploymentOp(
      request: GetDeploymentRequest
    ) extends GreengrassV2Op[GetDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeploymentResponse] =
        visitor.getDeployment(request)
    }

    final case class ListClientDevicesAssociatedWithCoreDeviceOp(
      request: ListClientDevicesAssociatedWithCoreDeviceRequest
    ) extends GreengrassV2Op[ListClientDevicesAssociatedWithCoreDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListClientDevicesAssociatedWithCoreDeviceResponse] =
        visitor.listClientDevicesAssociatedWithCoreDevice(request)
    }

    final case class ListComponentVersionsOp(
      request: ListComponentVersionsRequest
    ) extends GreengrassV2Op[ListComponentVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListComponentVersionsResponse] =
        visitor.listComponentVersions(request)
    }

    final case class ListComponentsOp(
      request: ListComponentsRequest
    ) extends GreengrassV2Op[ListComponentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListComponentsResponse] =
        visitor.listComponents(request)
    }

    final case class ListCoreDevicesOp(
      request: ListCoreDevicesRequest
    ) extends GreengrassV2Op[ListCoreDevicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCoreDevicesResponse] =
        visitor.listCoreDevices(request)
    }

    final case class ListDeploymentsOp(
      request: ListDeploymentsRequest
    ) extends GreengrassV2Op[ListDeploymentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeploymentsResponse] =
        visitor.listDeployments(request)
    }

    final case class ListEffectiveDeploymentsOp(
      request: ListEffectiveDeploymentsRequest
    ) extends GreengrassV2Op[ListEffectiveDeploymentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEffectiveDeploymentsResponse] =
        visitor.listEffectiveDeployments(request)
    }

    final case class ListInstalledComponentsOp(
      request: ListInstalledComponentsRequest
    ) extends GreengrassV2Op[ListInstalledComponentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInstalledComponentsResponse] =
        visitor.listInstalledComponents(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends GreengrassV2Op[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ResolveComponentCandidatesOp(
      request: ResolveComponentCandidatesRequest
    ) extends GreengrassV2Op[ResolveComponentCandidatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResolveComponentCandidatesResponse] =
        visitor.resolveComponentCandidates(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends GreengrassV2Op[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends GreengrassV2Op[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import GreengrassV2Op._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[GreengrassV2Op, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchAssociateClientDeviceWithCoreDevice(
    request: BatchAssociateClientDeviceWithCoreDeviceRequest
  ): GreengrassV2IO[BatchAssociateClientDeviceWithCoreDeviceResponse] =
    FF.liftF(BatchAssociateClientDeviceWithCoreDeviceOp(request))

  def batchDisassociateClientDeviceFromCoreDevice(
    request: BatchDisassociateClientDeviceFromCoreDeviceRequest
  ): GreengrassV2IO[BatchDisassociateClientDeviceFromCoreDeviceResponse] =
    FF.liftF(BatchDisassociateClientDeviceFromCoreDeviceOp(request))

  def cancelDeployment(
    request: CancelDeploymentRequest
  ): GreengrassV2IO[CancelDeploymentResponse] =
    FF.liftF(CancelDeploymentOp(request))

  def createComponentVersion(
    request: CreateComponentVersionRequest
  ): GreengrassV2IO[CreateComponentVersionResponse] =
    FF.liftF(CreateComponentVersionOp(request))

  def createDeployment(
    request: CreateDeploymentRequest
  ): GreengrassV2IO[CreateDeploymentResponse] =
    FF.liftF(CreateDeploymentOp(request))

  def deleteComponent(
    request: DeleteComponentRequest
  ): GreengrassV2IO[DeleteComponentResponse] =
    FF.liftF(DeleteComponentOp(request))

  def deleteCoreDevice(
    request: DeleteCoreDeviceRequest
  ): GreengrassV2IO[DeleteCoreDeviceResponse] =
    FF.liftF(DeleteCoreDeviceOp(request))

  def describeComponent(
    request: DescribeComponentRequest
  ): GreengrassV2IO[DescribeComponentResponse] =
    FF.liftF(DescribeComponentOp(request))

  def getComponent(
    request: GetComponentRequest
  ): GreengrassV2IO[GetComponentResponse] =
    FF.liftF(GetComponentOp(request))

  def getComponentVersionArtifact(
    request: GetComponentVersionArtifactRequest
  ): GreengrassV2IO[GetComponentVersionArtifactResponse] =
    FF.liftF(GetComponentVersionArtifactOp(request))

  def getCoreDevice(
    request: GetCoreDeviceRequest
  ): GreengrassV2IO[GetCoreDeviceResponse] =
    FF.liftF(GetCoreDeviceOp(request))

  def getDeployment(
    request: GetDeploymentRequest
  ): GreengrassV2IO[GetDeploymentResponse] =
    FF.liftF(GetDeploymentOp(request))

  def listClientDevicesAssociatedWithCoreDevice(
    request: ListClientDevicesAssociatedWithCoreDeviceRequest
  ): GreengrassV2IO[ListClientDevicesAssociatedWithCoreDeviceResponse] =
    FF.liftF(ListClientDevicesAssociatedWithCoreDeviceOp(request))

  def listComponentVersions(
    request: ListComponentVersionsRequest
  ): GreengrassV2IO[ListComponentVersionsResponse] =
    FF.liftF(ListComponentVersionsOp(request))

  def listComponents(
    request: ListComponentsRequest
  ): GreengrassV2IO[ListComponentsResponse] =
    FF.liftF(ListComponentsOp(request))

  def listCoreDevices(
    request: ListCoreDevicesRequest
  ): GreengrassV2IO[ListCoreDevicesResponse] =
    FF.liftF(ListCoreDevicesOp(request))

  def listDeployments(
    request: ListDeploymentsRequest
  ): GreengrassV2IO[ListDeploymentsResponse] =
    FF.liftF(ListDeploymentsOp(request))

  def listEffectiveDeployments(
    request: ListEffectiveDeploymentsRequest
  ): GreengrassV2IO[ListEffectiveDeploymentsResponse] =
    FF.liftF(ListEffectiveDeploymentsOp(request))

  def listInstalledComponents(
    request: ListInstalledComponentsRequest
  ): GreengrassV2IO[ListInstalledComponentsResponse] =
    FF.liftF(ListInstalledComponentsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): GreengrassV2IO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def resolveComponentCandidates(
    request: ResolveComponentCandidatesRequest
  ): GreengrassV2IO[ResolveComponentCandidatesResponse] =
    FF.liftF(ResolveComponentCandidatesOp(request))

  def tagResource(
    request: TagResourceRequest
  ): GreengrassV2IO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): GreengrassV2IO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
