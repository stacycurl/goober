package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.ssooidc.SsoOidcClient
import software.amazon.awssdk.services.ssooidc.model._


object ssooidc { module =>

  // Free monad over SsoOidcOp
  type SsoOidcIO[A] = FF[SsoOidcOp, A]

  sealed trait SsoOidcOp[A] {
    def visit[F[_]](visitor: SsoOidcOp.Visitor[F]): F[A]
  }

  object SsoOidcOp {
    // Given a SsoOidcClient we can embed a SsoOidcIO program in any algebra that understands embedding.
    implicit val SsoOidcOpEmbeddable: Embeddable[SsoOidcOp, SsoOidcClient] = new Embeddable[SsoOidcOp, SsoOidcClient] {
      def embed[A](client: SsoOidcClient, io: SsoOidcIO[A]): Embedded[A] = Embedded.SsoOidc(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SsoOidcOp.Visitor[Kleisli[M, SsoOidcClient, *]] {
        def createToken(
          request: CreateTokenRequest
        ): Kleisli[M, SsoOidcClient, CreateTokenResponse] =
          primitive(_.createToken(request))

        def registerClient(
          request: RegisterClientRequest
        ): Kleisli[M, SsoOidcClient, RegisterClientResponse] =
          primitive(_.registerClient(request))

        def startDeviceAuthorization(
          request: StartDeviceAuthorizationRequest
        ): Kleisli[M, SsoOidcClient, StartDeviceAuthorizationResponse] =
          primitive(_.startDeviceAuthorization(request))

        def primitive[A](
          f: SsoOidcClient => A
        ): Kleisli[M, SsoOidcClient, A]
      }
    }

    trait Visitor[F[_]] extends (SsoOidcOp ~> F) {
      final def apply[A](op: SsoOidcOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createToken(
        request: CreateTokenRequest
      ): F[CreateTokenResponse]

      def registerClient(
        request: RegisterClientRequest
      ): F[RegisterClientResponse]

      def startDeviceAuthorization(
        request: StartDeviceAuthorizationRequest
      ): F[StartDeviceAuthorizationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SsoOidcOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateTokenOp(
      request: CreateTokenRequest
    ) extends SsoOidcOp[CreateTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTokenResponse] =
        visitor.createToken(request)
    }

    final case class RegisterClientOp(
      request: RegisterClientRequest
    ) extends SsoOidcOp[RegisterClientResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterClientResponse] =
        visitor.registerClient(request)
    }

    final case class StartDeviceAuthorizationOp(
      request: StartDeviceAuthorizationRequest
    ) extends SsoOidcOp[StartDeviceAuthorizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDeviceAuthorizationResponse] =
        visitor.startDeviceAuthorization(request)
    }
  }

  import SsoOidcOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SsoOidcOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createToken(
    request: CreateTokenRequest
  ): SsoOidcIO[CreateTokenResponse] =
    FF.liftF(CreateTokenOp(request))

  def registerClient(
    request: RegisterClientRequest
  ): SsoOidcIO[RegisterClientResponse] =
    FF.liftF(RegisterClientOp(request))

  def startDeviceAuthorization(
    request: StartDeviceAuthorizationRequest
  ): SsoOidcIO[StartDeviceAuthorizationResponse] =
    FF.liftF(StartDeviceAuthorizationOp(request))
}
