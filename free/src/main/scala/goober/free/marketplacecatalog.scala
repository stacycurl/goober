package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.marketplacecatalog.MarketplaceCatalogClient
import software.amazon.awssdk.services.marketplacecatalog.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object marketplacecatalog { module =>

  // Free monad over MarketplaceCatalogOp
  type MarketplaceCatalogIO[A] = FF[MarketplaceCatalogOp, A]

  sealed trait MarketplaceCatalogOp[A] {
    def visit[F[_]](visitor: MarketplaceCatalogOp.Visitor[F]): F[A]
  }

  object MarketplaceCatalogOp {
    // Given a MarketplaceCatalogClient we can embed a MarketplaceCatalogIO program in any algebra that understands embedding.
    implicit val MarketplaceCatalogOpEmbeddable: Embeddable[MarketplaceCatalogOp, MarketplaceCatalogClient] = new Embeddable[MarketplaceCatalogOp, MarketplaceCatalogClient] {
      def embed[A](client: MarketplaceCatalogClient, io: MarketplaceCatalogIO[A]): Embedded[A] = Embedded.MarketplaceCatalog(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MarketplaceCatalogOp.Visitor[Kleisli[M, MarketplaceCatalogClient, *]] {
        def cancelChangeSet(
          request: CancelChangeSetRequest
        ): Kleisli[M, MarketplaceCatalogClient, CancelChangeSetResponse] =
          primitive(_.cancelChangeSet(request))

        def describeChangeSet(
          request: DescribeChangeSetRequest
        ): Kleisli[M, MarketplaceCatalogClient, DescribeChangeSetResponse] =
          primitive(_.describeChangeSet(request))

        def describeEntity(
          request: DescribeEntityRequest
        ): Kleisli[M, MarketplaceCatalogClient, DescribeEntityResponse] =
          primitive(_.describeEntity(request))

        def listChangeSets(
          request: ListChangeSetsRequest
        ): Kleisli[M, MarketplaceCatalogClient, ListChangeSetsResponse] =
          primitive(_.listChangeSets(request))

        def listEntities(
          request: ListEntitiesRequest
        ): Kleisli[M, MarketplaceCatalogClient, ListEntitiesResponse] =
          primitive(_.listEntities(request))

        def startChangeSet(
          request: StartChangeSetRequest
        ): Kleisli[M, MarketplaceCatalogClient, StartChangeSetResponse] =
          primitive(_.startChangeSet(request))

        def primitive[A](
          f: MarketplaceCatalogClient => A
        ): Kleisli[M, MarketplaceCatalogClient, A]
      }
    }

    trait Visitor[F[_]] extends (MarketplaceCatalogOp ~> F) {
      final def apply[A](op: MarketplaceCatalogOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def cancelChangeSet(
        request: CancelChangeSetRequest
      ): F[CancelChangeSetResponse]

      def describeChangeSet(
        request: DescribeChangeSetRequest
      ): F[DescribeChangeSetResponse]

      def describeEntity(
        request: DescribeEntityRequest
      ): F[DescribeEntityResponse]

      def listChangeSets(
        request: ListChangeSetsRequest
      ): F[ListChangeSetsResponse]

      def listEntities(
        request: ListEntitiesRequest
      ): F[ListEntitiesResponse]

      def startChangeSet(
        request: StartChangeSetRequest
      ): F[StartChangeSetResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MarketplaceCatalogOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CancelChangeSetOp(
      request: CancelChangeSetRequest
    ) extends MarketplaceCatalogOp[CancelChangeSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelChangeSetResponse] =
        visitor.cancelChangeSet(request)
    }

    final case class DescribeChangeSetOp(
      request: DescribeChangeSetRequest
    ) extends MarketplaceCatalogOp[DescribeChangeSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeChangeSetResponse] =
        visitor.describeChangeSet(request)
    }

    final case class DescribeEntityOp(
      request: DescribeEntityRequest
    ) extends MarketplaceCatalogOp[DescribeEntityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEntityResponse] =
        visitor.describeEntity(request)
    }

    final case class ListChangeSetsOp(
      request: ListChangeSetsRequest
    ) extends MarketplaceCatalogOp[ListChangeSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListChangeSetsResponse] =
        visitor.listChangeSets(request)
    }

    final case class ListEntitiesOp(
      request: ListEntitiesRequest
    ) extends MarketplaceCatalogOp[ListEntitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEntitiesResponse] =
        visitor.listEntities(request)
    }

    final case class StartChangeSetOp(
      request: StartChangeSetRequest
    ) extends MarketplaceCatalogOp[StartChangeSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartChangeSetResponse] =
        visitor.startChangeSet(request)
    }
  }

  import MarketplaceCatalogOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MarketplaceCatalogOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def cancelChangeSet(
    request: CancelChangeSetRequest
  ): MarketplaceCatalogIO[CancelChangeSetResponse] =
    FF.liftF(CancelChangeSetOp(request))

  def describeChangeSet(
    request: DescribeChangeSetRequest
  ): MarketplaceCatalogIO[DescribeChangeSetResponse] =
    FF.liftF(DescribeChangeSetOp(request))

  def describeEntity(
    request: DescribeEntityRequest
  ): MarketplaceCatalogIO[DescribeEntityResponse] =
    FF.liftF(DescribeEntityOp(request))

  def listChangeSets(
    request: ListChangeSetsRequest
  ): MarketplaceCatalogIO[ListChangeSetsResponse] =
    FF.liftF(ListChangeSetsOp(request))

  def listEntities(
    request: ListEntitiesRequest
  ): MarketplaceCatalogIO[ListEntitiesResponse] =
    FF.liftF(ListEntitiesOp(request))

  def startChangeSet(
    request: StartChangeSetRequest
  ): MarketplaceCatalogIO[StartChangeSetResponse] =
    FF.liftF(StartChangeSetOp(request))
}
