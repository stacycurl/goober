package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.identitystore.IdentitystoreClient
import software.amazon.awssdk.services.identitystore.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object identitystore { module =>

  // Free monad over IdentitystoreOp
  type IdentitystoreIO[A] = FF[IdentitystoreOp, A]

  sealed trait IdentitystoreOp[A] {
    def visit[F[_]](visitor: IdentitystoreOp.Visitor[F]): F[A]
  }

  object IdentitystoreOp {
    // Given a IdentitystoreClient we can embed a IdentitystoreIO program in any algebra that understands embedding.
    implicit val IdentitystoreOpEmbeddable: Embeddable[IdentitystoreOp, IdentitystoreClient] = new Embeddable[IdentitystoreOp, IdentitystoreClient] {
      def embed[A](client: IdentitystoreClient, io: IdentitystoreIO[A]): Embedded[A] = Embedded.Identitystore(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends IdentitystoreOp.Visitor[Kleisli[M, IdentitystoreClient, *]] {
        def describeGroup(
          request: DescribeGroupRequest
        ): Kleisli[M, IdentitystoreClient, DescribeGroupResponse] =
          primitive(_.describeGroup(request))

        def describeUser(
          request: DescribeUserRequest
        ): Kleisli[M, IdentitystoreClient, DescribeUserResponse] =
          primitive(_.describeUser(request))

        def listGroups(
          request: ListGroupsRequest
        ): Kleisli[M, IdentitystoreClient, ListGroupsResponse] =
          primitive(_.listGroups(request))

        def listUsers(
          request: ListUsersRequest
        ): Kleisli[M, IdentitystoreClient, ListUsersResponse] =
          primitive(_.listUsers(request))

        def primitive[A](
          f: IdentitystoreClient => A
        ): Kleisli[M, IdentitystoreClient, A]
      }
    }

    trait Visitor[F[_]] extends (IdentitystoreOp ~> F) {
      final def apply[A](op: IdentitystoreOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def describeGroup(
        request: DescribeGroupRequest
      ): F[DescribeGroupResponse]

      def describeUser(
        request: DescribeUserRequest
      ): F[DescribeUserResponse]

      def listGroups(
        request: ListGroupsRequest
      ): F[ListGroupsResponse]

      def listUsers(
        request: ListUsersRequest
      ): F[ListUsersResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends IdentitystoreOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DescribeGroupOp(
      request: DescribeGroupRequest
    ) extends IdentitystoreOp[DescribeGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGroupResponse] =
        visitor.describeGroup(request)
    }

    final case class DescribeUserOp(
      request: DescribeUserRequest
    ) extends IdentitystoreOp[DescribeUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUserResponse] =
        visitor.describeUser(request)
    }

    final case class ListGroupsOp(
      request: ListGroupsRequest
    ) extends IdentitystoreOp[ListGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGroupsResponse] =
        visitor.listGroups(request)
    }

    final case class ListUsersOp(
      request: ListUsersRequest
    ) extends IdentitystoreOp[ListUsersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUsersResponse] =
        visitor.listUsers(request)
    }
  }

  import IdentitystoreOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[IdentitystoreOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def describeGroup(
    request: DescribeGroupRequest
  ): IdentitystoreIO[DescribeGroupResponse] =
    FF.liftF(DescribeGroupOp(request))

  def describeUser(
    request: DescribeUserRequest
  ): IdentitystoreIO[DescribeUserResponse] =
    FF.liftF(DescribeUserOp(request))

  def listGroups(
    request: ListGroupsRequest
  ): IdentitystoreIO[ListGroupsResponse] =
    FF.liftF(ListGroupsOp(request))

  def listUsers(
    request: ListUsersRequest
  ): IdentitystoreIO[ListUsersResponse] =
    FF.liftF(ListUsersOp(request))
}
