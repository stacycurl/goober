package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.iot1clickdevices.Iot1ClickDevicesClient
import software.amazon.awssdk.services.iot1clickdevices.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object iot1clickdevices { module =>

  // Free monad over Iot1ClickDevicesOp
  type Iot1ClickDevicesIO[A] = FF[Iot1ClickDevicesOp, A]

  sealed trait Iot1ClickDevicesOp[A] {
    def visit[F[_]](visitor: Iot1ClickDevicesOp.Visitor[F]): F[A]
  }

  object Iot1ClickDevicesOp {
    // Given a Iot1ClickDevicesClient we can embed a Iot1ClickDevicesIO program in any algebra that understands embedding.
    implicit val Iot1ClickDevicesOpEmbeddable: Embeddable[Iot1ClickDevicesOp, Iot1ClickDevicesClient] = new Embeddable[Iot1ClickDevicesOp, Iot1ClickDevicesClient] {
      def embed[A](client: Iot1ClickDevicesClient, io: Iot1ClickDevicesIO[A]): Embedded[A] = Embedded.Iot1ClickDevices(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends Iot1ClickDevicesOp.Visitor[Kleisli[M, Iot1ClickDevicesClient, *]] {
        def claimDevicesByClaimCode(
          request: ClaimDevicesByClaimCodeRequest
        ): Kleisli[M, Iot1ClickDevicesClient, ClaimDevicesByClaimCodeResponse] =
          primitive(_.claimDevicesByClaimCode(request))

        def describeDevice(
          request: DescribeDeviceRequest
        ): Kleisli[M, Iot1ClickDevicesClient, DescribeDeviceResponse] =
          primitive(_.describeDevice(request))

        def finalizeDeviceClaim(
          request: FinalizeDeviceClaimRequest
        ): Kleisli[M, Iot1ClickDevicesClient, FinalizeDeviceClaimResponse] =
          primitive(_.finalizeDeviceClaim(request))

        def getDeviceMethods(
          request: GetDeviceMethodsRequest
        ): Kleisli[M, Iot1ClickDevicesClient, GetDeviceMethodsResponse] =
          primitive(_.getDeviceMethods(request))

        def initiateDeviceClaim(
          request: InitiateDeviceClaimRequest
        ): Kleisli[M, Iot1ClickDevicesClient, InitiateDeviceClaimResponse] =
          primitive(_.initiateDeviceClaim(request))

        def invokeDeviceMethod(
          request: InvokeDeviceMethodRequest
        ): Kleisli[M, Iot1ClickDevicesClient, InvokeDeviceMethodResponse] =
          primitive(_.invokeDeviceMethod(request))

        def listDeviceEvents(
          request: ListDeviceEventsRequest
        ): Kleisli[M, Iot1ClickDevicesClient, ListDeviceEventsResponse] =
          primitive(_.listDeviceEvents(request))

        def listDevices(
          request: ListDevicesRequest
        ): Kleisli[M, Iot1ClickDevicesClient, ListDevicesResponse] =
          primitive(_.listDevices(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, Iot1ClickDevicesClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, Iot1ClickDevicesClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def unclaimDevice(
          request: UnclaimDeviceRequest
        ): Kleisli[M, Iot1ClickDevicesClient, UnclaimDeviceResponse] =
          primitive(_.unclaimDevice(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, Iot1ClickDevicesClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateDeviceState(
          request: UpdateDeviceStateRequest
        ): Kleisli[M, Iot1ClickDevicesClient, UpdateDeviceStateResponse] =
          primitive(_.updateDeviceState(request))

        def primitive[A](
          f: Iot1ClickDevicesClient => A
        ): Kleisli[M, Iot1ClickDevicesClient, A]
      }
    }

    trait Visitor[F[_]] extends (Iot1ClickDevicesOp ~> F) {
      final def apply[A](op: Iot1ClickDevicesOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def claimDevicesByClaimCode(
        request: ClaimDevicesByClaimCodeRequest
      ): F[ClaimDevicesByClaimCodeResponse]

      def describeDevice(
        request: DescribeDeviceRequest
      ): F[DescribeDeviceResponse]

      def finalizeDeviceClaim(
        request: FinalizeDeviceClaimRequest
      ): F[FinalizeDeviceClaimResponse]

      def getDeviceMethods(
        request: GetDeviceMethodsRequest
      ): F[GetDeviceMethodsResponse]

      def initiateDeviceClaim(
        request: InitiateDeviceClaimRequest
      ): F[InitiateDeviceClaimResponse]

      def invokeDeviceMethod(
        request: InvokeDeviceMethodRequest
      ): F[InvokeDeviceMethodResponse]

      def listDeviceEvents(
        request: ListDeviceEventsRequest
      ): F[ListDeviceEventsResponse]

      def listDevices(
        request: ListDevicesRequest
      ): F[ListDevicesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def unclaimDevice(
        request: UnclaimDeviceRequest
      ): F[UnclaimDeviceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateDeviceState(
        request: UpdateDeviceStateRequest
      ): F[UpdateDeviceStateResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends Iot1ClickDevicesOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class ClaimDevicesByClaimCodeOp(
      request: ClaimDevicesByClaimCodeRequest
    ) extends Iot1ClickDevicesOp[ClaimDevicesByClaimCodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ClaimDevicesByClaimCodeResponse] =
        visitor.claimDevicesByClaimCode(request)
    }

    final case class DescribeDeviceOp(
      request: DescribeDeviceRequest
    ) extends Iot1ClickDevicesOp[DescribeDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDeviceResponse] =
        visitor.describeDevice(request)
    }

    final case class FinalizeDeviceClaimOp(
      request: FinalizeDeviceClaimRequest
    ) extends Iot1ClickDevicesOp[FinalizeDeviceClaimResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[FinalizeDeviceClaimResponse] =
        visitor.finalizeDeviceClaim(request)
    }

    final case class GetDeviceMethodsOp(
      request: GetDeviceMethodsRequest
    ) extends Iot1ClickDevicesOp[GetDeviceMethodsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeviceMethodsResponse] =
        visitor.getDeviceMethods(request)
    }

    final case class InitiateDeviceClaimOp(
      request: InitiateDeviceClaimRequest
    ) extends Iot1ClickDevicesOp[InitiateDeviceClaimResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InitiateDeviceClaimResponse] =
        visitor.initiateDeviceClaim(request)
    }

    final case class InvokeDeviceMethodOp(
      request: InvokeDeviceMethodRequest
    ) extends Iot1ClickDevicesOp[InvokeDeviceMethodResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InvokeDeviceMethodResponse] =
        visitor.invokeDeviceMethod(request)
    }

    final case class ListDeviceEventsOp(
      request: ListDeviceEventsRequest
    ) extends Iot1ClickDevicesOp[ListDeviceEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeviceEventsResponse] =
        visitor.listDeviceEvents(request)
    }

    final case class ListDevicesOp(
      request: ListDevicesRequest
    ) extends Iot1ClickDevicesOp[ListDevicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDevicesResponse] =
        visitor.listDevices(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends Iot1ClickDevicesOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends Iot1ClickDevicesOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UnclaimDeviceOp(
      request: UnclaimDeviceRequest
    ) extends Iot1ClickDevicesOp[UnclaimDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UnclaimDeviceResponse] =
        visitor.unclaimDevice(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends Iot1ClickDevicesOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateDeviceStateOp(
      request: UpdateDeviceStateRequest
    ) extends Iot1ClickDevicesOp[UpdateDeviceStateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDeviceStateResponse] =
        visitor.updateDeviceState(request)
    }
  }

  import Iot1ClickDevicesOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[Iot1ClickDevicesOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def claimDevicesByClaimCode(
    request: ClaimDevicesByClaimCodeRequest
  ): Iot1ClickDevicesIO[ClaimDevicesByClaimCodeResponse] =
    FF.liftF(ClaimDevicesByClaimCodeOp(request))

  def describeDevice(
    request: DescribeDeviceRequest
  ): Iot1ClickDevicesIO[DescribeDeviceResponse] =
    FF.liftF(DescribeDeviceOp(request))

  def finalizeDeviceClaim(
    request: FinalizeDeviceClaimRequest
  ): Iot1ClickDevicesIO[FinalizeDeviceClaimResponse] =
    FF.liftF(FinalizeDeviceClaimOp(request))

  def getDeviceMethods(
    request: GetDeviceMethodsRequest
  ): Iot1ClickDevicesIO[GetDeviceMethodsResponse] =
    FF.liftF(GetDeviceMethodsOp(request))

  def initiateDeviceClaim(
    request: InitiateDeviceClaimRequest
  ): Iot1ClickDevicesIO[InitiateDeviceClaimResponse] =
    FF.liftF(InitiateDeviceClaimOp(request))

  def invokeDeviceMethod(
    request: InvokeDeviceMethodRequest
  ): Iot1ClickDevicesIO[InvokeDeviceMethodResponse] =
    FF.liftF(InvokeDeviceMethodOp(request))

  def listDeviceEvents(
    request: ListDeviceEventsRequest
  ): Iot1ClickDevicesIO[ListDeviceEventsResponse] =
    FF.liftF(ListDeviceEventsOp(request))

  def listDevices(
    request: ListDevicesRequest
  ): Iot1ClickDevicesIO[ListDevicesResponse] =
    FF.liftF(ListDevicesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): Iot1ClickDevicesIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): Iot1ClickDevicesIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def unclaimDevice(
    request: UnclaimDeviceRequest
  ): Iot1ClickDevicesIO[UnclaimDeviceResponse] =
    FF.liftF(UnclaimDeviceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): Iot1ClickDevicesIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateDeviceState(
    request: UpdateDeviceStateRequest
  ): Iot1ClickDevicesIO[UpdateDeviceStateResponse] =
    FF.liftF(UpdateDeviceStateOp(request))
}
