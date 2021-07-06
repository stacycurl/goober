package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.personalizeevents.PersonalizeEventsClient
import software.amazon.awssdk.services.personalizeevents.model._


object personalizeevents { module =>

  // Free monad over PersonalizeEventsOp
  type PersonalizeEventsIO[A] = FF[PersonalizeEventsOp, A]

  sealed trait PersonalizeEventsOp[A] {
    def visit[F[_]](visitor: PersonalizeEventsOp.Visitor[F]): F[A]
  }

  object PersonalizeEventsOp {
    // Given a PersonalizeEventsClient we can embed a PersonalizeEventsIO program in any algebra that understands embedding.
    implicit val PersonalizeEventsOpEmbeddable: Embeddable[PersonalizeEventsOp, PersonalizeEventsClient] = new Embeddable[PersonalizeEventsOp, PersonalizeEventsClient] {
      def embed[A](client: PersonalizeEventsClient, io: PersonalizeEventsIO[A]): Embedded[A] = Embedded.PersonalizeEvents(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends PersonalizeEventsOp.Visitor[Kleisli[M, PersonalizeEventsClient, *]] {
        def putEvents(
          request: PutEventsRequest
        ): Kleisli[M, PersonalizeEventsClient, PutEventsResponse] =
          primitive(_.putEvents(request))

        def putItems(
          request: PutItemsRequest
        ): Kleisli[M, PersonalizeEventsClient, PutItemsResponse] =
          primitive(_.putItems(request))

        def putUsers(
          request: PutUsersRequest
        ): Kleisli[M, PersonalizeEventsClient, PutUsersResponse] =
          primitive(_.putUsers(request))

        def primitive[A](
          f: PersonalizeEventsClient => A
        ): Kleisli[M, PersonalizeEventsClient, A]
      }
    }

    trait Visitor[F[_]] extends (PersonalizeEventsOp ~> F) {
      final def apply[A](op: PersonalizeEventsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def putEvents(
        request: PutEventsRequest
      ): F[PutEventsResponse]

      def putItems(
        request: PutItemsRequest
      ): F[PutItemsResponse]

      def putUsers(
        request: PutUsersRequest
      ): F[PutUsersResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends PersonalizeEventsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class PutEventsOp(
      request: PutEventsRequest
    ) extends PersonalizeEventsOp[PutEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutEventsResponse] =
        visitor.putEvents(request)
    }

    final case class PutItemsOp(
      request: PutItemsRequest
    ) extends PersonalizeEventsOp[PutItemsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutItemsResponse] =
        visitor.putItems(request)
    }

    final case class PutUsersOp(
      request: PutUsersRequest
    ) extends PersonalizeEventsOp[PutUsersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutUsersResponse] =
        visitor.putUsers(request)
    }
  }

  import PersonalizeEventsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[PersonalizeEventsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def putEvents(
    request: PutEventsRequest
  ): PersonalizeEventsIO[PutEventsResponse] =
    FF.liftF(PutEventsOp(request))

  def putItems(
    request: PutItemsRequest
  ): PersonalizeEventsIO[PutItemsResponse] =
    FF.liftF(PutItemsOp(request))

  def putUsers(
    request: PutUsersRequest
  ): PersonalizeEventsIO[PutUsersResponse] =
    FF.liftF(PutUsersOp(request))
}
