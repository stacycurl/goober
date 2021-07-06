package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.transfer.TransferClient
import software.amazon.awssdk.services.transfer.model._


object transfer { module =>

  // Free monad over TransferOp
  type TransferIO[A] = FF[TransferOp, A]

  sealed trait TransferOp[A] {
    def visit[F[_]](visitor: TransferOp.Visitor[F]): F[A]
  }

  object TransferOp {
    // Given a TransferClient we can embed a TransferIO program in any algebra that understands embedding.
    implicit val TransferOpEmbeddable: Embeddable[TransferOp, TransferClient] = new Embeddable[TransferOp, TransferClient] {
      def embed[A](client: TransferClient, io: TransferIO[A]): Embedded[A] = Embedded.Transfer(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends TransferOp.Visitor[Kleisli[M, TransferClient, *]] {
        def createAccess(
          request: CreateAccessRequest
        ): Kleisli[M, TransferClient, CreateAccessResponse] =
          primitive(_.createAccess(request))

        def createServer(
          request: CreateServerRequest
        ): Kleisli[M, TransferClient, CreateServerResponse] =
          primitive(_.createServer(request))

        def createUser(
          request: CreateUserRequest
        ): Kleisli[M, TransferClient, CreateUserResponse] =
          primitive(_.createUser(request))

        def deleteAccess(
          request: DeleteAccessRequest
        ): Kleisli[M, TransferClient, DeleteAccessResponse] =
          primitive(_.deleteAccess(request))

        def deleteServer(
          request: DeleteServerRequest
        ): Kleisli[M, TransferClient, DeleteServerResponse] =
          primitive(_.deleteServer(request))

        def deleteSshPublicKey(
          request: DeleteSshPublicKeyRequest
        ): Kleisli[M, TransferClient, DeleteSshPublicKeyResponse] =
          primitive(_.deleteSshPublicKey(request))

        def deleteUser(
          request: DeleteUserRequest
        ): Kleisli[M, TransferClient, DeleteUserResponse] =
          primitive(_.deleteUser(request))

        def describeAccess(
          request: DescribeAccessRequest
        ): Kleisli[M, TransferClient, DescribeAccessResponse] =
          primitive(_.describeAccess(request))

        def describeSecurityPolicy(
          request: DescribeSecurityPolicyRequest
        ): Kleisli[M, TransferClient, DescribeSecurityPolicyResponse] =
          primitive(_.describeSecurityPolicy(request))

        def describeServer(
          request: DescribeServerRequest
        ): Kleisli[M, TransferClient, DescribeServerResponse] =
          primitive(_.describeServer(request))

        def describeUser(
          request: DescribeUserRequest
        ): Kleisli[M, TransferClient, DescribeUserResponse] =
          primitive(_.describeUser(request))

        def importSshPublicKey(
          request: ImportSshPublicKeyRequest
        ): Kleisli[M, TransferClient, ImportSshPublicKeyResponse] =
          primitive(_.importSshPublicKey(request))

        def listAccesses(
          request: ListAccessesRequest
        ): Kleisli[M, TransferClient, ListAccessesResponse] =
          primitive(_.listAccesses(request))

        def listSecurityPolicies(
          request: ListSecurityPoliciesRequest
        ): Kleisli[M, TransferClient, ListSecurityPoliciesResponse] =
          primitive(_.listSecurityPolicies(request))

        def listServers(
          request: ListServersRequest
        ): Kleisli[M, TransferClient, ListServersResponse] =
          primitive(_.listServers(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, TransferClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listUsers(
          request: ListUsersRequest
        ): Kleisli[M, TransferClient, ListUsersResponse] =
          primitive(_.listUsers(request))

        def startServer(
          request: StartServerRequest
        ): Kleisli[M, TransferClient, StartServerResponse] =
          primitive(_.startServer(request))

        def stopServer(
          request: StopServerRequest
        ): Kleisli[M, TransferClient, StopServerResponse] =
          primitive(_.stopServer(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, TransferClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def testIdentityProvider(
          request: TestIdentityProviderRequest
        ): Kleisli[M, TransferClient, TestIdentityProviderResponse] =
          primitive(_.testIdentityProvider(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, TransferClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAccess(
          request: UpdateAccessRequest
        ): Kleisli[M, TransferClient, UpdateAccessResponse] =
          primitive(_.updateAccess(request))

        def updateServer(
          request: UpdateServerRequest
        ): Kleisli[M, TransferClient, UpdateServerResponse] =
          primitive(_.updateServer(request))

        def updateUser(
          request: UpdateUserRequest
        ): Kleisli[M, TransferClient, UpdateUserResponse] =
          primitive(_.updateUser(request))

        def primitive[A](
          f: TransferClient => A
        ): Kleisli[M, TransferClient, A]
      }
    }

    trait Visitor[F[_]] extends (TransferOp ~> F) {
      final def apply[A](op: TransferOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createAccess(
        request: CreateAccessRequest
      ): F[CreateAccessResponse]

      def createServer(
        request: CreateServerRequest
      ): F[CreateServerResponse]

      def createUser(
        request: CreateUserRequest
      ): F[CreateUserResponse]

      def deleteAccess(
        request: DeleteAccessRequest
      ): F[DeleteAccessResponse]

      def deleteServer(
        request: DeleteServerRequest
      ): F[DeleteServerResponse]

      def deleteSshPublicKey(
        request: DeleteSshPublicKeyRequest
      ): F[DeleteSshPublicKeyResponse]

      def deleteUser(
        request: DeleteUserRequest
      ): F[DeleteUserResponse]

      def describeAccess(
        request: DescribeAccessRequest
      ): F[DescribeAccessResponse]

      def describeSecurityPolicy(
        request: DescribeSecurityPolicyRequest
      ): F[DescribeSecurityPolicyResponse]

      def describeServer(
        request: DescribeServerRequest
      ): F[DescribeServerResponse]

      def describeUser(
        request: DescribeUserRequest
      ): F[DescribeUserResponse]

      def importSshPublicKey(
        request: ImportSshPublicKeyRequest
      ): F[ImportSshPublicKeyResponse]

      def listAccesses(
        request: ListAccessesRequest
      ): F[ListAccessesResponse]

      def listSecurityPolicies(
        request: ListSecurityPoliciesRequest
      ): F[ListSecurityPoliciesResponse]

      def listServers(
        request: ListServersRequest
      ): F[ListServersResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listUsers(
        request: ListUsersRequest
      ): F[ListUsersResponse]

      def startServer(
        request: StartServerRequest
      ): F[StartServerResponse]

      def stopServer(
        request: StopServerRequest
      ): F[StopServerResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def testIdentityProvider(
        request: TestIdentityProviderRequest
      ): F[TestIdentityProviderResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAccess(
        request: UpdateAccessRequest
      ): F[UpdateAccessResponse]

      def updateServer(
        request: UpdateServerRequest
      ): F[UpdateServerResponse]

      def updateUser(
        request: UpdateUserRequest
      ): F[UpdateUserResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends TransferOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateAccessOp(
      request: CreateAccessRequest
    ) extends TransferOp[CreateAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAccessResponse] =
        visitor.createAccess(request)
    }

    final case class CreateServerOp(
      request: CreateServerRequest
    ) extends TransferOp[CreateServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateServerResponse] =
        visitor.createServer(request)
    }

    final case class CreateUserOp(
      request: CreateUserRequest
    ) extends TransferOp[CreateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserResponse] =
        visitor.createUser(request)
    }

    final case class DeleteAccessOp(
      request: DeleteAccessRequest
    ) extends TransferOp[DeleteAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAccessResponse] =
        visitor.deleteAccess(request)
    }

    final case class DeleteServerOp(
      request: DeleteServerRequest
    ) extends TransferOp[DeleteServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteServerResponse] =
        visitor.deleteServer(request)
    }

    final case class DeleteSshPublicKeyOp(
      request: DeleteSshPublicKeyRequest
    ) extends TransferOp[DeleteSshPublicKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSshPublicKeyResponse] =
        visitor.deleteSshPublicKey(request)
    }

    final case class DeleteUserOp(
      request: DeleteUserRequest
    ) extends TransferOp[DeleteUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserResponse] =
        visitor.deleteUser(request)
    }

    final case class DescribeAccessOp(
      request: DescribeAccessRequest
    ) extends TransferOp[DescribeAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccessResponse] =
        visitor.describeAccess(request)
    }

    final case class DescribeSecurityPolicyOp(
      request: DescribeSecurityPolicyRequest
    ) extends TransferOp[DescribeSecurityPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSecurityPolicyResponse] =
        visitor.describeSecurityPolicy(request)
    }

    final case class DescribeServerOp(
      request: DescribeServerRequest
    ) extends TransferOp[DescribeServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeServerResponse] =
        visitor.describeServer(request)
    }

    final case class DescribeUserOp(
      request: DescribeUserRequest
    ) extends TransferOp[DescribeUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUserResponse] =
        visitor.describeUser(request)
    }

    final case class ImportSshPublicKeyOp(
      request: ImportSshPublicKeyRequest
    ) extends TransferOp[ImportSshPublicKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportSshPublicKeyResponse] =
        visitor.importSshPublicKey(request)
    }

    final case class ListAccessesOp(
      request: ListAccessesRequest
    ) extends TransferOp[ListAccessesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccessesResponse] =
        visitor.listAccesses(request)
    }

    final case class ListSecurityPoliciesOp(
      request: ListSecurityPoliciesRequest
    ) extends TransferOp[ListSecurityPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSecurityPoliciesResponse] =
        visitor.listSecurityPolicies(request)
    }

    final case class ListServersOp(
      request: ListServersRequest
    ) extends TransferOp[ListServersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListServersResponse] =
        visitor.listServers(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends TransferOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListUsersOp(
      request: ListUsersRequest
    ) extends TransferOp[ListUsersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUsersResponse] =
        visitor.listUsers(request)
    }

    final case class StartServerOp(
      request: StartServerRequest
    ) extends TransferOp[StartServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartServerResponse] =
        visitor.startServer(request)
    }

    final case class StopServerOp(
      request: StopServerRequest
    ) extends TransferOp[StopServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopServerResponse] =
        visitor.stopServer(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends TransferOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class TestIdentityProviderOp(
      request: TestIdentityProviderRequest
    ) extends TransferOp[TestIdentityProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TestIdentityProviderResponse] =
        visitor.testIdentityProvider(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends TransferOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAccessOp(
      request: UpdateAccessRequest
    ) extends TransferOp[UpdateAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAccessResponse] =
        visitor.updateAccess(request)
    }

    final case class UpdateServerOp(
      request: UpdateServerRequest
    ) extends TransferOp[UpdateServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateServerResponse] =
        visitor.updateServer(request)
    }

    final case class UpdateUserOp(
      request: UpdateUserRequest
    ) extends TransferOp[UpdateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserResponse] =
        visitor.updateUser(request)
    }
  }

  import TransferOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[TransferOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createAccess(
    request: CreateAccessRequest
  ): TransferIO[CreateAccessResponse] =
    FF.liftF(CreateAccessOp(request))

  def createServer(
    request: CreateServerRequest
  ): TransferIO[CreateServerResponse] =
    FF.liftF(CreateServerOp(request))

  def createUser(
    request: CreateUserRequest
  ): TransferIO[CreateUserResponse] =
    FF.liftF(CreateUserOp(request))

  def deleteAccess(
    request: DeleteAccessRequest
  ): TransferIO[DeleteAccessResponse] =
    FF.liftF(DeleteAccessOp(request))

  def deleteServer(
    request: DeleteServerRequest
  ): TransferIO[DeleteServerResponse] =
    FF.liftF(DeleteServerOp(request))

  def deleteSshPublicKey(
    request: DeleteSshPublicKeyRequest
  ): TransferIO[DeleteSshPublicKeyResponse] =
    FF.liftF(DeleteSshPublicKeyOp(request))

  def deleteUser(
    request: DeleteUserRequest
  ): TransferIO[DeleteUserResponse] =
    FF.liftF(DeleteUserOp(request))

  def describeAccess(
    request: DescribeAccessRequest
  ): TransferIO[DescribeAccessResponse] =
    FF.liftF(DescribeAccessOp(request))

  def describeSecurityPolicy(
    request: DescribeSecurityPolicyRequest
  ): TransferIO[DescribeSecurityPolicyResponse] =
    FF.liftF(DescribeSecurityPolicyOp(request))

  def describeServer(
    request: DescribeServerRequest
  ): TransferIO[DescribeServerResponse] =
    FF.liftF(DescribeServerOp(request))

  def describeUser(
    request: DescribeUserRequest
  ): TransferIO[DescribeUserResponse] =
    FF.liftF(DescribeUserOp(request))

  def importSshPublicKey(
    request: ImportSshPublicKeyRequest
  ): TransferIO[ImportSshPublicKeyResponse] =
    FF.liftF(ImportSshPublicKeyOp(request))

  def listAccesses(
    request: ListAccessesRequest
  ): TransferIO[ListAccessesResponse] =
    FF.liftF(ListAccessesOp(request))

  def listSecurityPolicies(
    request: ListSecurityPoliciesRequest
  ): TransferIO[ListSecurityPoliciesResponse] =
    FF.liftF(ListSecurityPoliciesOp(request))

  def listServers(
    request: ListServersRequest
  ): TransferIO[ListServersResponse] =
    FF.liftF(ListServersOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): TransferIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listUsers(
    request: ListUsersRequest
  ): TransferIO[ListUsersResponse] =
    FF.liftF(ListUsersOp(request))

  def startServer(
    request: StartServerRequest
  ): TransferIO[StartServerResponse] =
    FF.liftF(StartServerOp(request))

  def stopServer(
    request: StopServerRequest
  ): TransferIO[StopServerResponse] =
    FF.liftF(StopServerOp(request))

  def tagResource(
    request: TagResourceRequest
  ): TransferIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def testIdentityProvider(
    request: TestIdentityProviderRequest
  ): TransferIO[TestIdentityProviderResponse] =
    FF.liftF(TestIdentityProviderOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): TransferIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAccess(
    request: UpdateAccessRequest
  ): TransferIO[UpdateAccessResponse] =
    FF.liftF(UpdateAccessOp(request))

  def updateServer(
    request: UpdateServerRequest
  ): TransferIO[UpdateServerResponse] =
    FF.liftF(UpdateServerOp(request))

  def updateUser(
    request: UpdateUserRequest
  ): TransferIO[UpdateUserResponse] =
    FF.liftF(UpdateUserOp(request))
}
