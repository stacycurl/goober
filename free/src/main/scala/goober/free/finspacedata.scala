package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.finspacedata.FinspaceDataClient
import software.amazon.awssdk.services.finspacedata.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object finspacedata { module =>

  // Free monad over FinspaceDataOp
  type FinspaceDataIO[A] = FF[FinspaceDataOp, A]

  sealed trait FinspaceDataOp[A] {
    def visit[F[_]](visitor: FinspaceDataOp.Visitor[F]): F[A]
  }

  object FinspaceDataOp {
    // Given a FinspaceDataClient we can embed a FinspaceDataIO program in any algebra that understands embedding.
    implicit val FinspaceDataOpEmbeddable: Embeddable[FinspaceDataOp, FinspaceDataClient] = new Embeddable[FinspaceDataOp, FinspaceDataClient] {
      def embed[A](client: FinspaceDataClient, io: FinspaceDataIO[A]): Embedded[A] = Embedded.FinspaceData(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends FinspaceDataOp.Visitor[Kleisli[M, FinspaceDataClient, *]] {
        def createChangeset(
          request: CreateChangesetRequest
        ): Kleisli[M, FinspaceDataClient, CreateChangesetResponse] =
          primitive(_.createChangeset(request))

        def getProgrammaticAccessCredentials(
          request: GetProgrammaticAccessCredentialsRequest
        ): Kleisli[M, FinspaceDataClient, GetProgrammaticAccessCredentialsResponse] =
          primitive(_.getProgrammaticAccessCredentials(request))

        def getWorkingLocation(
          request: GetWorkingLocationRequest
        ): Kleisli[M, FinspaceDataClient, GetWorkingLocationResponse] =
          primitive(_.getWorkingLocation(request))

        def primitive[A](
          f: FinspaceDataClient => A
        ): Kleisli[M, FinspaceDataClient, A]
      }
    }

    trait Visitor[F[_]] extends (FinspaceDataOp ~> F) {
      final def apply[A](op: FinspaceDataOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createChangeset(
        request: CreateChangesetRequest
      ): F[CreateChangesetResponse]

      def getProgrammaticAccessCredentials(
        request: GetProgrammaticAccessCredentialsRequest
      ): F[GetProgrammaticAccessCredentialsResponse]

      def getWorkingLocation(
        request: GetWorkingLocationRequest
      ): F[GetWorkingLocationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends FinspaceDataOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateChangesetOp(
      request: CreateChangesetRequest
    ) extends FinspaceDataOp[CreateChangesetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateChangesetResponse] =
        visitor.createChangeset(request)
    }

    final case class GetProgrammaticAccessCredentialsOp(
      request: GetProgrammaticAccessCredentialsRequest
    ) extends FinspaceDataOp[GetProgrammaticAccessCredentialsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetProgrammaticAccessCredentialsResponse] =
        visitor.getProgrammaticAccessCredentials(request)
    }

    final case class GetWorkingLocationOp(
      request: GetWorkingLocationRequest
    ) extends FinspaceDataOp[GetWorkingLocationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWorkingLocationResponse] =
        visitor.getWorkingLocation(request)
    }
  }

  import FinspaceDataOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[FinspaceDataOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createChangeset(
    request: CreateChangesetRequest
  ): FinspaceDataIO[CreateChangesetResponse] =
    FF.liftF(CreateChangesetOp(request))

  def getProgrammaticAccessCredentials(
    request: GetProgrammaticAccessCredentialsRequest
  ): FinspaceDataIO[GetProgrammaticAccessCredentialsResponse] =
    FF.liftF(GetProgrammaticAccessCredentialsOp(request))

  def getWorkingLocation(
    request: GetWorkingLocationRequest
  ): FinspaceDataIO[GetWorkingLocationResponse] =
    FF.liftF(GetWorkingLocationOp(request))
}
