package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.macie.MacieClient
import software.amazon.awssdk.services.macie.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object macie { module =>

  // Free monad over MacieOp
  type MacieIO[A] = FF[MacieOp, A]

  sealed trait MacieOp[A] {
    def visit[F[_]](visitor: MacieOp.Visitor[F]): F[A]
  }

  object MacieOp {
    // Given a MacieClient we can embed a MacieIO program in any algebra that understands embedding.
    implicit val MacieOpEmbeddable: Embeddable[MacieOp, MacieClient] = new Embeddable[MacieOp, MacieClient] {
      def embed[A](client: MacieClient, io: MacieIO[A]): Embedded[A] = Embedded.Macie(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MacieOp.Visitor[Kleisli[M, MacieClient, *]] {
        def associateMemberAccount(
          request: AssociateMemberAccountRequest
        ): Kleisli[M, MacieClient, AssociateMemberAccountResponse] =
          primitive(_.associateMemberAccount(request))

        def associateS3Resources(
          request: AssociateS3ResourcesRequest
        ): Kleisli[M, MacieClient, AssociateS3ResourcesResponse] =
          primitive(_.associateS3Resources(request))

        def disassociateMemberAccount(
          request: DisassociateMemberAccountRequest
        ): Kleisli[M, MacieClient, DisassociateMemberAccountResponse] =
          primitive(_.disassociateMemberAccount(request))

        def disassociateS3Resources(
          request: DisassociateS3ResourcesRequest
        ): Kleisli[M, MacieClient, DisassociateS3ResourcesResponse] =
          primitive(_.disassociateS3Resources(request))

        def listMemberAccounts(
          request: ListMemberAccountsRequest
        ): Kleisli[M, MacieClient, ListMemberAccountsResponse] =
          primitive(_.listMemberAccounts(request))

        def listS3Resources(
          request: ListS3ResourcesRequest
        ): Kleisli[M, MacieClient, ListS3ResourcesResponse] =
          primitive(_.listS3Resources(request))

        def updateS3Resources(
          request: UpdateS3ResourcesRequest
        ): Kleisli[M, MacieClient, UpdateS3ResourcesResponse] =
          primitive(_.updateS3Resources(request))

        def primitive[A](
          f: MacieClient => A
        ): Kleisli[M, MacieClient, A]
      }
    }

    trait Visitor[F[_]] extends (MacieOp ~> F) {
      final def apply[A](op: MacieOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateMemberAccount(
        request: AssociateMemberAccountRequest
      ): F[AssociateMemberAccountResponse]

      def associateS3Resources(
        request: AssociateS3ResourcesRequest
      ): F[AssociateS3ResourcesResponse]

      def disassociateMemberAccount(
        request: DisassociateMemberAccountRequest
      ): F[DisassociateMemberAccountResponse]

      def disassociateS3Resources(
        request: DisassociateS3ResourcesRequest
      ): F[DisassociateS3ResourcesResponse]

      def listMemberAccounts(
        request: ListMemberAccountsRequest
      ): F[ListMemberAccountsResponse]

      def listS3Resources(
        request: ListS3ResourcesRequest
      ): F[ListS3ResourcesResponse]

      def updateS3Resources(
        request: UpdateS3ResourcesRequest
      ): F[UpdateS3ResourcesResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MacieOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateMemberAccountOp(
      request: AssociateMemberAccountRequest
    ) extends MacieOp[AssociateMemberAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateMemberAccountResponse] =
        visitor.associateMemberAccount(request)
    }

    final case class AssociateS3ResourcesOp(
      request: AssociateS3ResourcesRequest
    ) extends MacieOp[AssociateS3ResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateS3ResourcesResponse] =
        visitor.associateS3Resources(request)
    }

    final case class DisassociateMemberAccountOp(
      request: DisassociateMemberAccountRequest
    ) extends MacieOp[DisassociateMemberAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateMemberAccountResponse] =
        visitor.disassociateMemberAccount(request)
    }

    final case class DisassociateS3ResourcesOp(
      request: DisassociateS3ResourcesRequest
    ) extends MacieOp[DisassociateS3ResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateS3ResourcesResponse] =
        visitor.disassociateS3Resources(request)
    }

    final case class ListMemberAccountsOp(
      request: ListMemberAccountsRequest
    ) extends MacieOp[ListMemberAccountsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMemberAccountsResponse] =
        visitor.listMemberAccounts(request)
    }

    final case class ListS3ResourcesOp(
      request: ListS3ResourcesRequest
    ) extends MacieOp[ListS3ResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListS3ResourcesResponse] =
        visitor.listS3Resources(request)
    }

    final case class UpdateS3ResourcesOp(
      request: UpdateS3ResourcesRequest
    ) extends MacieOp[UpdateS3ResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateS3ResourcesResponse] =
        visitor.updateS3Resources(request)
    }
  }

  import MacieOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MacieOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateMemberAccount(
    request: AssociateMemberAccountRequest
  ): MacieIO[AssociateMemberAccountResponse] =
    FF.liftF(AssociateMemberAccountOp(request))

  def associateS3Resources(
    request: AssociateS3ResourcesRequest
  ): MacieIO[AssociateS3ResourcesResponse] =
    FF.liftF(AssociateS3ResourcesOp(request))

  def disassociateMemberAccount(
    request: DisassociateMemberAccountRequest
  ): MacieIO[DisassociateMemberAccountResponse] =
    FF.liftF(DisassociateMemberAccountOp(request))

  def disassociateS3Resources(
    request: DisassociateS3ResourcesRequest
  ): MacieIO[DisassociateS3ResourcesResponse] =
    FF.liftF(DisassociateS3ResourcesOp(request))

  def listMemberAccounts(
    request: ListMemberAccountsRequest
  ): MacieIO[ListMemberAccountsResponse] =
    FF.liftF(ListMemberAccountsOp(request))

  def listS3Resources(
    request: ListS3ResourcesRequest
  ): MacieIO[ListS3ResourcesResponse] =
    FF.liftF(ListS3ResourcesOp(request))

  def updateS3Resources(
    request: UpdateS3ResourcesRequest
  ): MacieIO[UpdateS3ResourcesResponse] =
    FF.liftF(UpdateS3ResourcesOp(request))
}
