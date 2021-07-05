package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.iotdataplane.IotDataPlaneClient
import software.amazon.awssdk.services.iotdataplane.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object iotdataplane { module =>

  // Free monad over IotDataPlaneOp
  type IotDataPlaneIO[A] = FF[IotDataPlaneOp, A]

  sealed trait IotDataPlaneOp[A] {
    def visit[F[_]](visitor: IotDataPlaneOp.Visitor[F]): F[A]
  }

  object IotDataPlaneOp {
    // Given a IotDataPlaneClient we can embed a IotDataPlaneIO program in any algebra that understands embedding.
    implicit val IotDataPlaneOpEmbeddable: Embeddable[IotDataPlaneOp, IotDataPlaneClient] = new Embeddable[IotDataPlaneOp, IotDataPlaneClient] {
      def embed[A](client: IotDataPlaneClient, io: IotDataPlaneIO[A]): Embedded[A] = Embedded.IotDataPlane(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends IotDataPlaneOp.Visitor[Kleisli[M, IotDataPlaneClient, *]] {
        def deleteThingShadow(
          request: DeleteThingShadowRequest
        ): Kleisli[M, IotDataPlaneClient, DeleteThingShadowResponse] =
          primitive(_.deleteThingShadow(request))

        def getThingShadow(
          request: GetThingShadowRequest
        ): Kleisli[M, IotDataPlaneClient, GetThingShadowResponse] =
          primitive(_.getThingShadow(request))

        def listNamedShadowsForThing(
          request: ListNamedShadowsForThingRequest
        ): Kleisli[M, IotDataPlaneClient, ListNamedShadowsForThingResponse] =
          primitive(_.listNamedShadowsForThing(request))

        def publish(
          request: PublishRequest
        ): Kleisli[M, IotDataPlaneClient, PublishResponse] =
          primitive(_.publish(request))

        def updateThingShadow(
          request: UpdateThingShadowRequest
        ): Kleisli[M, IotDataPlaneClient, UpdateThingShadowResponse] =
          primitive(_.updateThingShadow(request))

        def primitive[A](
          f: IotDataPlaneClient => A
        ): Kleisli[M, IotDataPlaneClient, A]
      }
    }

    trait Visitor[F[_]] extends (IotDataPlaneOp ~> F) {
      final def apply[A](op: IotDataPlaneOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def deleteThingShadow(
        request: DeleteThingShadowRequest
      ): F[DeleteThingShadowResponse]

      def getThingShadow(
        request: GetThingShadowRequest
      ): F[GetThingShadowResponse]

      def listNamedShadowsForThing(
        request: ListNamedShadowsForThingRequest
      ): F[ListNamedShadowsForThingResponse]

      def publish(
        request: PublishRequest
      ): F[PublishResponse]

      def updateThingShadow(
        request: UpdateThingShadowRequest
      ): F[UpdateThingShadowResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends IotDataPlaneOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DeleteThingShadowOp(
      request: DeleteThingShadowRequest
    ) extends IotDataPlaneOp[DeleteThingShadowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteThingShadowResponse] =
        visitor.deleteThingShadow(request)
    }

    final case class GetThingShadowOp(
      request: GetThingShadowRequest
    ) extends IotDataPlaneOp[GetThingShadowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetThingShadowResponse] =
        visitor.getThingShadow(request)
    }

    final case class ListNamedShadowsForThingOp(
      request: ListNamedShadowsForThingRequest
    ) extends IotDataPlaneOp[ListNamedShadowsForThingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListNamedShadowsForThingResponse] =
        visitor.listNamedShadowsForThing(request)
    }

    final case class PublishOp(
      request: PublishRequest
    ) extends IotDataPlaneOp[PublishResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PublishResponse] =
        visitor.publish(request)
    }

    final case class UpdateThingShadowOp(
      request: UpdateThingShadowRequest
    ) extends IotDataPlaneOp[UpdateThingShadowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateThingShadowResponse] =
        visitor.updateThingShadow(request)
    }
  }

  import IotDataPlaneOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[IotDataPlaneOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def deleteThingShadow(
    request: DeleteThingShadowRequest
  ): IotDataPlaneIO[DeleteThingShadowResponse] =
    FF.liftF(DeleteThingShadowOp(request))

  def getThingShadow(
    request: GetThingShadowRequest
  ): IotDataPlaneIO[GetThingShadowResponse] =
    FF.liftF(GetThingShadowOp(request))

  def listNamedShadowsForThing(
    request: ListNamedShadowsForThingRequest
  ): IotDataPlaneIO[ListNamedShadowsForThingResponse] =
    FF.liftF(ListNamedShadowsForThingOp(request))

  def publish(
    request: PublishRequest
  ): IotDataPlaneIO[PublishResponse] =
    FF.liftF(PublishOp(request))

  def updateThingShadow(
    request: UpdateThingShadowRequest
  ): IotDataPlaneIO[UpdateThingShadowResponse] =
    FF.liftF(UpdateThingShadowOp(request))
}
