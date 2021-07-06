package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.braket.BraketClient
import software.amazon.awssdk.services.braket.model._


object braket { module =>

  // Free monad over BraketOp
  type BraketIO[A] = FF[BraketOp, A]

  sealed trait BraketOp[A] {
    def visit[F[_]](visitor: BraketOp.Visitor[F]): F[A]
  }

  object BraketOp {
    // Given a BraketClient we can embed a BraketIO program in any algebra that understands embedding.
    implicit val BraketOpEmbeddable: Embeddable[BraketOp, BraketClient] = new Embeddable[BraketOp, BraketClient] {
      def embed[A](client: BraketClient, io: BraketIO[A]): Embedded[A] = Embedded.Braket(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends BraketOp.Visitor[Kleisli[M, BraketClient, *]] {
        def cancelQuantumTask(
          request: CancelQuantumTaskRequest
        ): Kleisli[M, BraketClient, CancelQuantumTaskResponse] =
          primitive(_.cancelQuantumTask(request))

        def createQuantumTask(
          request: CreateQuantumTaskRequest
        ): Kleisli[M, BraketClient, CreateQuantumTaskResponse] =
          primitive(_.createQuantumTask(request))

        def getDevice(
          request: GetDeviceRequest
        ): Kleisli[M, BraketClient, GetDeviceResponse] =
          primitive(_.getDevice(request))

        def getQuantumTask(
          request: GetQuantumTaskRequest
        ): Kleisli[M, BraketClient, GetQuantumTaskResponse] =
          primitive(_.getQuantumTask(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, BraketClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def searchDevices(
          request: SearchDevicesRequest
        ): Kleisli[M, BraketClient, SearchDevicesResponse] =
          primitive(_.searchDevices(request))

        def searchQuantumTasks(
          request: SearchQuantumTasksRequest
        ): Kleisli[M, BraketClient, SearchQuantumTasksResponse] =
          primitive(_.searchQuantumTasks(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, BraketClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, BraketClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: BraketClient => A
        ): Kleisli[M, BraketClient, A]
      }
    }

    trait Visitor[F[_]] extends (BraketOp ~> F) {
      final def apply[A](op: BraketOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def cancelQuantumTask(
        request: CancelQuantumTaskRequest
      ): F[CancelQuantumTaskResponse]

      def createQuantumTask(
        request: CreateQuantumTaskRequest
      ): F[CreateQuantumTaskResponse]

      def getDevice(
        request: GetDeviceRequest
      ): F[GetDeviceResponse]

      def getQuantumTask(
        request: GetQuantumTaskRequest
      ): F[GetQuantumTaskResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def searchDevices(
        request: SearchDevicesRequest
      ): F[SearchDevicesResponse]

      def searchQuantumTasks(
        request: SearchQuantumTasksRequest
      ): F[SearchQuantumTasksResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends BraketOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CancelQuantumTaskOp(
      request: CancelQuantumTaskRequest
    ) extends BraketOp[CancelQuantumTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelQuantumTaskResponse] =
        visitor.cancelQuantumTask(request)
    }

    final case class CreateQuantumTaskOp(
      request: CreateQuantumTaskRequest
    ) extends BraketOp[CreateQuantumTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateQuantumTaskResponse] =
        visitor.createQuantumTask(request)
    }

    final case class GetDeviceOp(
      request: GetDeviceRequest
    ) extends BraketOp[GetDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeviceResponse] =
        visitor.getDevice(request)
    }

    final case class GetQuantumTaskOp(
      request: GetQuantumTaskRequest
    ) extends BraketOp[GetQuantumTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetQuantumTaskResponse] =
        visitor.getQuantumTask(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends BraketOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class SearchDevicesOp(
      request: SearchDevicesRequest
    ) extends BraketOp[SearchDevicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchDevicesResponse] =
        visitor.searchDevices(request)
    }

    final case class SearchQuantumTasksOp(
      request: SearchQuantumTasksRequest
    ) extends BraketOp[SearchQuantumTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchQuantumTasksResponse] =
        visitor.searchQuantumTasks(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends BraketOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends BraketOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import BraketOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[BraketOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def cancelQuantumTask(
    request: CancelQuantumTaskRequest
  ): BraketIO[CancelQuantumTaskResponse] =
    FF.liftF(CancelQuantumTaskOp(request))

  def createQuantumTask(
    request: CreateQuantumTaskRequest
  ): BraketIO[CreateQuantumTaskResponse] =
    FF.liftF(CreateQuantumTaskOp(request))

  def getDevice(
    request: GetDeviceRequest
  ): BraketIO[GetDeviceResponse] =
    FF.liftF(GetDeviceOp(request))

  def getQuantumTask(
    request: GetQuantumTaskRequest
  ): BraketIO[GetQuantumTaskResponse] =
    FF.liftF(GetQuantumTaskOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): BraketIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def searchDevices(
    request: SearchDevicesRequest
  ): BraketIO[SearchDevicesResponse] =
    FF.liftF(SearchDevicesOp(request))

  def searchQuantumTasks(
    request: SearchQuantumTasksRequest
  ): BraketIO[SearchQuantumTasksResponse] =
    FF.liftF(SearchQuantumTasksOp(request))

  def tagResource(
    request: TagResourceRequest
  ): BraketIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): BraketIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
