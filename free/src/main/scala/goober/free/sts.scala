package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.sts.StsClient
import software.amazon.awssdk.services.sts.model._


object sts { module =>

  // Free monad over StsOp
  type StsIO[A] = FF[StsOp, A]

  sealed trait StsOp[A] {
    def visit[F[_]](visitor: StsOp.Visitor[F]): F[A]
  }

  object StsOp {
    // Given a StsClient we can embed a StsIO program in any algebra that understands embedding.
    implicit val StsOpEmbeddable: Embeddable[StsOp, StsClient] = new Embeddable[StsOp, StsClient] {
      def embed[A](client: StsClient, io: StsIO[A]): Embedded[A] = Embedded.Sts(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends StsOp.Visitor[Kleisli[M, StsClient, *]] {
        def assumeRole(
          request: AssumeRoleRequest
        ): Kleisli[M, StsClient, AssumeRoleResponse] =
          primitive(_.assumeRole(request))

        def assumeRoleWithSAML(
          request: AssumeRoleWithSamlRequest
        ): Kleisli[M, StsClient, AssumeRoleWithSamlResponse] =
          primitive(_.assumeRoleWithSAML(request))

        def assumeRoleWithWebIdentity(
          request: AssumeRoleWithWebIdentityRequest
        ): Kleisli[M, StsClient, AssumeRoleWithWebIdentityResponse] =
          primitive(_.assumeRoleWithWebIdentity(request))

        def decodeAuthorizationMessage(
          request: DecodeAuthorizationMessageRequest
        ): Kleisli[M, StsClient, DecodeAuthorizationMessageResponse] =
          primitive(_.decodeAuthorizationMessage(request))

        def getAccessKeyInfo(
          request: GetAccessKeyInfoRequest
        ): Kleisli[M, StsClient, GetAccessKeyInfoResponse] =
          primitive(_.getAccessKeyInfo(request))

        def getCallerIdentity(
          request: GetCallerIdentityRequest
        ): Kleisli[M, StsClient, GetCallerIdentityResponse] =
          primitive(_.getCallerIdentity(request))

        def getFederationToken(
          request: GetFederationTokenRequest
        ): Kleisli[M, StsClient, GetFederationTokenResponse] =
          primitive(_.getFederationToken(request))

        def getSessionToken(
          request: GetSessionTokenRequest
        ): Kleisli[M, StsClient, GetSessionTokenResponse] =
          primitive(_.getSessionToken(request))

        def primitive[A](
          f: StsClient => A
        ): Kleisli[M, StsClient, A]
      }
    }

    trait Visitor[F[_]] extends (StsOp ~> F) {
      final def apply[A](op: StsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def assumeRole(
        request: AssumeRoleRequest
      ): F[AssumeRoleResponse]

      def assumeRoleWithSAML(
        request: AssumeRoleWithSamlRequest
      ): F[AssumeRoleWithSamlResponse]

      def assumeRoleWithWebIdentity(
        request: AssumeRoleWithWebIdentityRequest
      ): F[AssumeRoleWithWebIdentityResponse]

      def decodeAuthorizationMessage(
        request: DecodeAuthorizationMessageRequest
      ): F[DecodeAuthorizationMessageResponse]

      def getAccessKeyInfo(
        request: GetAccessKeyInfoRequest
      ): F[GetAccessKeyInfoResponse]

      def getCallerIdentity(
        request: GetCallerIdentityRequest
      ): F[GetCallerIdentityResponse]

      def getFederationToken(
        request: GetFederationTokenRequest
      ): F[GetFederationTokenResponse]

      def getSessionToken(
        request: GetSessionTokenRequest
      ): F[GetSessionTokenResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends StsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssumeRoleOp(
      request: AssumeRoleRequest
    ) extends StsOp[AssumeRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssumeRoleResponse] =
        visitor.assumeRole(request)
    }

    final case class AssumeRoleWithSAMLOp(
      request: AssumeRoleWithSamlRequest
    ) extends StsOp[AssumeRoleWithSamlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssumeRoleWithSamlResponse] =
        visitor.assumeRoleWithSAML(request)
    }

    final case class AssumeRoleWithWebIdentityOp(
      request: AssumeRoleWithWebIdentityRequest
    ) extends StsOp[AssumeRoleWithWebIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssumeRoleWithWebIdentityResponse] =
        visitor.assumeRoleWithWebIdentity(request)
    }

    final case class DecodeAuthorizationMessageOp(
      request: DecodeAuthorizationMessageRequest
    ) extends StsOp[DecodeAuthorizationMessageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DecodeAuthorizationMessageResponse] =
        visitor.decodeAuthorizationMessage(request)
    }

    final case class GetAccessKeyInfoOp(
      request: GetAccessKeyInfoRequest
    ) extends StsOp[GetAccessKeyInfoResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccessKeyInfoResponse] =
        visitor.getAccessKeyInfo(request)
    }

    final case class GetCallerIdentityOp(
      request: GetCallerIdentityRequest
    ) extends StsOp[GetCallerIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCallerIdentityResponse] =
        visitor.getCallerIdentity(request)
    }

    final case class GetFederationTokenOp(
      request: GetFederationTokenRequest
    ) extends StsOp[GetFederationTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFederationTokenResponse] =
        visitor.getFederationToken(request)
    }

    final case class GetSessionTokenOp(
      request: GetSessionTokenRequest
    ) extends StsOp[GetSessionTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSessionTokenResponse] =
        visitor.getSessionToken(request)
    }
  }

  import StsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[StsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def assumeRole(
    request: AssumeRoleRequest
  ): StsIO[AssumeRoleResponse] =
    FF.liftF(AssumeRoleOp(request))

  def assumeRoleWithSAML(
    request: AssumeRoleWithSamlRequest
  ): StsIO[AssumeRoleWithSamlResponse] =
    FF.liftF(AssumeRoleWithSAMLOp(request))

  def assumeRoleWithWebIdentity(
    request: AssumeRoleWithWebIdentityRequest
  ): StsIO[AssumeRoleWithWebIdentityResponse] =
    FF.liftF(AssumeRoleWithWebIdentityOp(request))

  def decodeAuthorizationMessage(
    request: DecodeAuthorizationMessageRequest
  ): StsIO[DecodeAuthorizationMessageResponse] =
    FF.liftF(DecodeAuthorizationMessageOp(request))

  def getAccessKeyInfo(
    request: GetAccessKeyInfoRequest
  ): StsIO[GetAccessKeyInfoResponse] =
    FF.liftF(GetAccessKeyInfoOp(request))

  def getCallerIdentity(
    request: GetCallerIdentityRequest
  ): StsIO[GetCallerIdentityResponse] =
    FF.liftF(GetCallerIdentityOp(request))

  def getFederationToken(
    request: GetFederationTokenRequest
  ): StsIO[GetFederationTokenResponse] =
    FF.liftF(GetFederationTokenOp(request))

  def getSessionToken(
    request: GetSessionTokenRequest
  ): StsIO[GetSessionTokenResponse] =
    FF.liftF(GetSessionTokenOp(request))
}
