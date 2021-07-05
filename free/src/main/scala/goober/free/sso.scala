package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.sso.SsoClient
import software.amazon.awssdk.services.sso.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object sso { module =>

  // Free monad over SsoOp
  type SsoIO[A] = FF[SsoOp, A]

  sealed trait SsoOp[A] {
    def visit[F[_]](visitor: SsoOp.Visitor[F]): F[A]
  }

  object SsoOp {
    // Given a SsoClient we can embed a SsoIO program in any algebra that understands embedding.
    implicit val SsoOpEmbeddable: Embeddable[SsoOp, SsoClient] = new Embeddable[SsoOp, SsoClient] {
      def embed[A](client: SsoClient, io: SsoIO[A]): Embedded[A] = Embedded.Sso(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SsoOp.Visitor[Kleisli[M, SsoClient, *]] {
        def getRoleCredentials(
          request: GetRoleCredentialsRequest
        ): Kleisli[M, SsoClient, GetRoleCredentialsResponse] =
          primitive(_.getRoleCredentials(request))

        def listAccountRoles(
          request: ListAccountRolesRequest
        ): Kleisli[M, SsoClient, ListAccountRolesResponse] =
          primitive(_.listAccountRoles(request))

        def listAccounts(
          request: ListAccountsRequest
        ): Kleisli[M, SsoClient, ListAccountsResponse] =
          primitive(_.listAccounts(request))

        def logout(
          request: LogoutRequest
        ): Kleisli[M, SsoClient, LogoutResponse] =
          primitive(_.logout(request))

        def primitive[A](
          f: SsoClient => A
        ): Kleisli[M, SsoClient, A]
      }
    }

    trait Visitor[F[_]] extends (SsoOp ~> F) {
      final def apply[A](op: SsoOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def getRoleCredentials(
        request: GetRoleCredentialsRequest
      ): F[GetRoleCredentialsResponse]

      def listAccountRoles(
        request: ListAccountRolesRequest
      ): F[ListAccountRolesResponse]

      def listAccounts(
        request: ListAccountsRequest
      ): F[ListAccountsResponse]

      def logout(
        request: LogoutRequest
      ): F[LogoutResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SsoOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class GetRoleCredentialsOp(
      request: GetRoleCredentialsRequest
    ) extends SsoOp[GetRoleCredentialsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRoleCredentialsResponse] =
        visitor.getRoleCredentials(request)
    }

    final case class ListAccountRolesOp(
      request: ListAccountRolesRequest
    ) extends SsoOp[ListAccountRolesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccountRolesResponse] =
        visitor.listAccountRoles(request)
    }

    final case class ListAccountsOp(
      request: ListAccountsRequest
    ) extends SsoOp[ListAccountsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccountsResponse] =
        visitor.listAccounts(request)
    }

    final case class LogoutOp(
      request: LogoutRequest
    ) extends SsoOp[LogoutResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[LogoutResponse] =
        visitor.logout(request)
    }
  }

  import SsoOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SsoOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def getRoleCredentials(
    request: GetRoleCredentialsRequest
  ): SsoIO[GetRoleCredentialsResponse] =
    FF.liftF(GetRoleCredentialsOp(request))

  def listAccountRoles(
    request: ListAccountRolesRequest
  ): SsoIO[ListAccountRolesResponse] =
    FF.liftF(ListAccountRolesOp(request))

  def listAccounts(
    request: ListAccountsRequest
  ): SsoIO[ListAccountsResponse] =
    FF.liftF(ListAccountsOp(request))

  def logout(
    request: LogoutRequest
  ): SsoIO[LogoutResponse] =
    FF.liftF(LogoutOp(request))
}
