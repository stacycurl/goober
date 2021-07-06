package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.appintegrations.AppIntegrationsClient
import software.amazon.awssdk.services.appintegrations.model._


object appintegrations { module =>

  // Free monad over AppIntegrationsOp
  type AppIntegrationsIO[A] = FF[AppIntegrationsOp, A]

  sealed trait AppIntegrationsOp[A] {
    def visit[F[_]](visitor: AppIntegrationsOp.Visitor[F]): F[A]
  }

  object AppIntegrationsOp {
    // Given a AppIntegrationsClient we can embed a AppIntegrationsIO program in any algebra that understands embedding.
    implicit val AppIntegrationsOpEmbeddable: Embeddable[AppIntegrationsOp, AppIntegrationsClient] = new Embeddable[AppIntegrationsOp, AppIntegrationsClient] {
      def embed[A](client: AppIntegrationsClient, io: AppIntegrationsIO[A]): Embedded[A] = Embedded.AppIntegrations(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends AppIntegrationsOp.Visitor[Kleisli[M, AppIntegrationsClient, *]] {
        def createEventIntegration(
          request: CreateEventIntegrationRequest
        ): Kleisli[M, AppIntegrationsClient, CreateEventIntegrationResponse] =
          primitive(_.createEventIntegration(request))

        def deleteEventIntegration(
          request: DeleteEventIntegrationRequest
        ): Kleisli[M, AppIntegrationsClient, DeleteEventIntegrationResponse] =
          primitive(_.deleteEventIntegration(request))

        def getEventIntegration(
          request: GetEventIntegrationRequest
        ): Kleisli[M, AppIntegrationsClient, GetEventIntegrationResponse] =
          primitive(_.getEventIntegration(request))

        def listEventIntegrationAssociations(
          request: ListEventIntegrationAssociationsRequest
        ): Kleisli[M, AppIntegrationsClient, ListEventIntegrationAssociationsResponse] =
          primitive(_.listEventIntegrationAssociations(request))

        def listEventIntegrations(
          request: ListEventIntegrationsRequest
        ): Kleisli[M, AppIntegrationsClient, ListEventIntegrationsResponse] =
          primitive(_.listEventIntegrations(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, AppIntegrationsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, AppIntegrationsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, AppIntegrationsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateEventIntegration(
          request: UpdateEventIntegrationRequest
        ): Kleisli[M, AppIntegrationsClient, UpdateEventIntegrationResponse] =
          primitive(_.updateEventIntegration(request))

        def primitive[A](
          f: AppIntegrationsClient => A
        ): Kleisli[M, AppIntegrationsClient, A]
      }
    }

    trait Visitor[F[_]] extends (AppIntegrationsOp ~> F) {
      final def apply[A](op: AppIntegrationsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createEventIntegration(
        request: CreateEventIntegrationRequest
      ): F[CreateEventIntegrationResponse]

      def deleteEventIntegration(
        request: DeleteEventIntegrationRequest
      ): F[DeleteEventIntegrationResponse]

      def getEventIntegration(
        request: GetEventIntegrationRequest
      ): F[GetEventIntegrationResponse]

      def listEventIntegrationAssociations(
        request: ListEventIntegrationAssociationsRequest
      ): F[ListEventIntegrationAssociationsResponse]

      def listEventIntegrations(
        request: ListEventIntegrationsRequest
      ): F[ListEventIntegrationsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateEventIntegration(
        request: UpdateEventIntegrationRequest
      ): F[UpdateEventIntegrationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends AppIntegrationsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateEventIntegrationOp(
      request: CreateEventIntegrationRequest
    ) extends AppIntegrationsOp[CreateEventIntegrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEventIntegrationResponse] =
        visitor.createEventIntegration(request)
    }

    final case class DeleteEventIntegrationOp(
      request: DeleteEventIntegrationRequest
    ) extends AppIntegrationsOp[DeleteEventIntegrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEventIntegrationResponse] =
        visitor.deleteEventIntegration(request)
    }

    final case class GetEventIntegrationOp(
      request: GetEventIntegrationRequest
    ) extends AppIntegrationsOp[GetEventIntegrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEventIntegrationResponse] =
        visitor.getEventIntegration(request)
    }

    final case class ListEventIntegrationAssociationsOp(
      request: ListEventIntegrationAssociationsRequest
    ) extends AppIntegrationsOp[ListEventIntegrationAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEventIntegrationAssociationsResponse] =
        visitor.listEventIntegrationAssociations(request)
    }

    final case class ListEventIntegrationsOp(
      request: ListEventIntegrationsRequest
    ) extends AppIntegrationsOp[ListEventIntegrationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEventIntegrationsResponse] =
        visitor.listEventIntegrations(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends AppIntegrationsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends AppIntegrationsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends AppIntegrationsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateEventIntegrationOp(
      request: UpdateEventIntegrationRequest
    ) extends AppIntegrationsOp[UpdateEventIntegrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEventIntegrationResponse] =
        visitor.updateEventIntegration(request)
    }
  }

  import AppIntegrationsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[AppIntegrationsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createEventIntegration(
    request: CreateEventIntegrationRequest
  ): AppIntegrationsIO[CreateEventIntegrationResponse] =
    FF.liftF(CreateEventIntegrationOp(request))

  def deleteEventIntegration(
    request: DeleteEventIntegrationRequest
  ): AppIntegrationsIO[DeleteEventIntegrationResponse] =
    FF.liftF(DeleteEventIntegrationOp(request))

  def getEventIntegration(
    request: GetEventIntegrationRequest
  ): AppIntegrationsIO[GetEventIntegrationResponse] =
    FF.liftF(GetEventIntegrationOp(request))

  def listEventIntegrationAssociations(
    request: ListEventIntegrationAssociationsRequest
  ): AppIntegrationsIO[ListEventIntegrationAssociationsResponse] =
    FF.liftF(ListEventIntegrationAssociationsOp(request))

  def listEventIntegrations(
    request: ListEventIntegrationsRequest
  ): AppIntegrationsIO[ListEventIntegrationsResponse] =
    FF.liftF(ListEventIntegrationsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): AppIntegrationsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): AppIntegrationsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): AppIntegrationsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateEventIntegration(
    request: UpdateEventIntegrationRequest
  ): AppIntegrationsIO[UpdateEventIntegrationResponse] =
    FF.liftF(UpdateEventIntegrationOp(request))
}
