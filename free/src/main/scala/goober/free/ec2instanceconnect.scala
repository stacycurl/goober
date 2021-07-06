package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.ec2instanceconnect.Ec2InstanceConnectClient
import software.amazon.awssdk.services.ec2instanceconnect.model._


object ec2instanceconnect { module =>

  // Free monad over Ec2InstanceConnectOp
  type Ec2InstanceConnectIO[A] = FF[Ec2InstanceConnectOp, A]

  sealed trait Ec2InstanceConnectOp[A] {
    def visit[F[_]](visitor: Ec2InstanceConnectOp.Visitor[F]): F[A]
  }

  object Ec2InstanceConnectOp {
    // Given a Ec2InstanceConnectClient we can embed a Ec2InstanceConnectIO program in any algebra that understands embedding.
    implicit val Ec2InstanceConnectOpEmbeddable: Embeddable[Ec2InstanceConnectOp, Ec2InstanceConnectClient] = new Embeddable[Ec2InstanceConnectOp, Ec2InstanceConnectClient] {
      def embed[A](client: Ec2InstanceConnectClient, io: Ec2InstanceConnectIO[A]): Embedded[A] = Embedded.Ec2InstanceConnect(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends Ec2InstanceConnectOp.Visitor[Kleisli[M, Ec2InstanceConnectClient, *]] {
        def sendSSHPublicKey(
          request: SendSshPublicKeyRequest
        ): Kleisli[M, Ec2InstanceConnectClient, SendSshPublicKeyResponse] =
          primitive(_.sendSSHPublicKey(request))

        def sendSerialConsoleSSHPublicKey(
          request: SendSerialConsoleSshPublicKeyRequest
        ): Kleisli[M, Ec2InstanceConnectClient, SendSerialConsoleSshPublicKeyResponse] =
          primitive(_.sendSerialConsoleSSHPublicKey(request))

        def primitive[A](
          f: Ec2InstanceConnectClient => A
        ): Kleisli[M, Ec2InstanceConnectClient, A]
      }
    }

    trait Visitor[F[_]] extends (Ec2InstanceConnectOp ~> F) {
      final def apply[A](op: Ec2InstanceConnectOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def sendSSHPublicKey(
        request: SendSshPublicKeyRequest
      ): F[SendSshPublicKeyResponse]

      def sendSerialConsoleSSHPublicKey(
        request: SendSerialConsoleSshPublicKeyRequest
      ): F[SendSerialConsoleSshPublicKeyResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends Ec2InstanceConnectOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class SendSSHPublicKeyOp(
      request: SendSshPublicKeyRequest
    ) extends Ec2InstanceConnectOp[SendSshPublicKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendSshPublicKeyResponse] =
        visitor.sendSSHPublicKey(request)
    }

    final case class SendSerialConsoleSSHPublicKeyOp(
      request: SendSerialConsoleSshPublicKeyRequest
    ) extends Ec2InstanceConnectOp[SendSerialConsoleSshPublicKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendSerialConsoleSshPublicKeyResponse] =
        visitor.sendSerialConsoleSSHPublicKey(request)
    }
  }

  import Ec2InstanceConnectOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[Ec2InstanceConnectOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def sendSSHPublicKey(
    request: SendSshPublicKeyRequest
  ): Ec2InstanceConnectIO[SendSshPublicKeyResponse] =
    FF.liftF(SendSSHPublicKeyOp(request))

  def sendSerialConsoleSSHPublicKey(
    request: SendSerialConsoleSshPublicKeyRequest
  ): Ec2InstanceConnectIO[SendSerialConsoleSshPublicKeyResponse] =
    FF.liftF(SendSerialConsoleSSHPublicKeyOp(request))
}
