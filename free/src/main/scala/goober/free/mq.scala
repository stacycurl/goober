package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.mq.MqClient
import software.amazon.awssdk.services.mq.model._


object mq { module =>

  // Free monad over MqOp
  type MqIO[A] = FF[MqOp, A]

  sealed trait MqOp[A] {
    def visit[F[_]](visitor: MqOp.Visitor[F]): F[A]
  }

  object MqOp {
    // Given a MqClient we can embed a MqIO program in any algebra that understands embedding.
    implicit val MqOpEmbeddable: Embeddable[MqOp, MqClient] = new Embeddable[MqOp, MqClient] {
      def embed[A](client: MqClient, io: MqIO[A]): Embedded[A] = Embedded.Mq(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MqOp.Visitor[Kleisli[M, MqClient, *]] {
        def createBroker(
          request: CreateBrokerRequest
        ): Kleisli[M, MqClient, CreateBrokerResponse] =
          primitive(_.createBroker(request))

        def createConfiguration(
          request: CreateConfigurationRequest
        ): Kleisli[M, MqClient, CreateConfigurationResponse] =
          primitive(_.createConfiguration(request))

        def createTags(
          request: CreateTagsRequest
        ): Kleisli[M, MqClient, CreateTagsResponse] =
          primitive(_.createTags(request))

        def createUser(
          request: CreateUserRequest
        ): Kleisli[M, MqClient, CreateUserResponse] =
          primitive(_.createUser(request))

        def deleteBroker(
          request: DeleteBrokerRequest
        ): Kleisli[M, MqClient, DeleteBrokerResponse] =
          primitive(_.deleteBroker(request))

        def deleteTags(
          request: DeleteTagsRequest
        ): Kleisli[M, MqClient, DeleteTagsResponse] =
          primitive(_.deleteTags(request))

        def deleteUser(
          request: DeleteUserRequest
        ): Kleisli[M, MqClient, DeleteUserResponse] =
          primitive(_.deleteUser(request))

        def describeBroker(
          request: DescribeBrokerRequest
        ): Kleisli[M, MqClient, DescribeBrokerResponse] =
          primitive(_.describeBroker(request))

        def describeBrokerEngineTypes(
          request: DescribeBrokerEngineTypesRequest
        ): Kleisli[M, MqClient, DescribeBrokerEngineTypesResponse] =
          primitive(_.describeBrokerEngineTypes(request))

        def describeBrokerInstanceOptions(
          request: DescribeBrokerInstanceOptionsRequest
        ): Kleisli[M, MqClient, DescribeBrokerInstanceOptionsResponse] =
          primitive(_.describeBrokerInstanceOptions(request))

        def describeConfiguration(
          request: DescribeConfigurationRequest
        ): Kleisli[M, MqClient, DescribeConfigurationResponse] =
          primitive(_.describeConfiguration(request))

        def describeConfigurationRevision(
          request: DescribeConfigurationRevisionRequest
        ): Kleisli[M, MqClient, DescribeConfigurationRevisionResponse] =
          primitive(_.describeConfigurationRevision(request))

        def describeUser(
          request: DescribeUserRequest
        ): Kleisli[M, MqClient, DescribeUserResponse] =
          primitive(_.describeUser(request))

        def listBrokers(
          request: ListBrokersRequest
        ): Kleisli[M, MqClient, ListBrokersResponse] =
          primitive(_.listBrokers(request))

        def listConfigurationRevisions(
          request: ListConfigurationRevisionsRequest
        ): Kleisli[M, MqClient, ListConfigurationRevisionsResponse] =
          primitive(_.listConfigurationRevisions(request))

        def listConfigurations(
          request: ListConfigurationsRequest
        ): Kleisli[M, MqClient, ListConfigurationsResponse] =
          primitive(_.listConfigurations(request))

        def listTags(
          request: ListTagsRequest
        ): Kleisli[M, MqClient, ListTagsResponse] =
          primitive(_.listTags(request))

        def listUsers(
          request: ListUsersRequest
        ): Kleisli[M, MqClient, ListUsersResponse] =
          primitive(_.listUsers(request))

        def rebootBroker(
          request: RebootBrokerRequest
        ): Kleisli[M, MqClient, RebootBrokerResponse] =
          primitive(_.rebootBroker(request))

        def updateBroker(
          request: UpdateBrokerRequest
        ): Kleisli[M, MqClient, UpdateBrokerResponse] =
          primitive(_.updateBroker(request))

        def updateConfiguration(
          request: UpdateConfigurationRequest
        ): Kleisli[M, MqClient, UpdateConfigurationResponse] =
          primitive(_.updateConfiguration(request))

        def updateUser(
          request: UpdateUserRequest
        ): Kleisli[M, MqClient, UpdateUserResponse] =
          primitive(_.updateUser(request))

        def primitive[A](
          f: MqClient => A
        ): Kleisli[M, MqClient, A]
      }
    }

    trait Visitor[F[_]] extends (MqOp ~> F) {
      final def apply[A](op: MqOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createBroker(
        request: CreateBrokerRequest
      ): F[CreateBrokerResponse]

      def createConfiguration(
        request: CreateConfigurationRequest
      ): F[CreateConfigurationResponse]

      def createTags(
        request: CreateTagsRequest
      ): F[CreateTagsResponse]

      def createUser(
        request: CreateUserRequest
      ): F[CreateUserResponse]

      def deleteBroker(
        request: DeleteBrokerRequest
      ): F[DeleteBrokerResponse]

      def deleteTags(
        request: DeleteTagsRequest
      ): F[DeleteTagsResponse]

      def deleteUser(
        request: DeleteUserRequest
      ): F[DeleteUserResponse]

      def describeBroker(
        request: DescribeBrokerRequest
      ): F[DescribeBrokerResponse]

      def describeBrokerEngineTypes(
        request: DescribeBrokerEngineTypesRequest
      ): F[DescribeBrokerEngineTypesResponse]

      def describeBrokerInstanceOptions(
        request: DescribeBrokerInstanceOptionsRequest
      ): F[DescribeBrokerInstanceOptionsResponse]

      def describeConfiguration(
        request: DescribeConfigurationRequest
      ): F[DescribeConfigurationResponse]

      def describeConfigurationRevision(
        request: DescribeConfigurationRevisionRequest
      ): F[DescribeConfigurationRevisionResponse]

      def describeUser(
        request: DescribeUserRequest
      ): F[DescribeUserResponse]

      def listBrokers(
        request: ListBrokersRequest
      ): F[ListBrokersResponse]

      def listConfigurationRevisions(
        request: ListConfigurationRevisionsRequest
      ): F[ListConfigurationRevisionsResponse]

      def listConfigurations(
        request: ListConfigurationsRequest
      ): F[ListConfigurationsResponse]

      def listTags(
        request: ListTagsRequest
      ): F[ListTagsResponse]

      def listUsers(
        request: ListUsersRequest
      ): F[ListUsersResponse]

      def rebootBroker(
        request: RebootBrokerRequest
      ): F[RebootBrokerResponse]

      def updateBroker(
        request: UpdateBrokerRequest
      ): F[UpdateBrokerResponse]

      def updateConfiguration(
        request: UpdateConfigurationRequest
      ): F[UpdateConfigurationResponse]

      def updateUser(
        request: UpdateUserRequest
      ): F[UpdateUserResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MqOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateBrokerOp(
      request: CreateBrokerRequest
    ) extends MqOp[CreateBrokerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBrokerResponse] =
        visitor.createBroker(request)
    }

    final case class CreateConfigurationOp(
      request: CreateConfigurationRequest
    ) extends MqOp[CreateConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConfigurationResponse] =
        visitor.createConfiguration(request)
    }

    final case class CreateTagsOp(
      request: CreateTagsRequest
    ) extends MqOp[CreateTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTagsResponse] =
        visitor.createTags(request)
    }

    final case class CreateUserOp(
      request: CreateUserRequest
    ) extends MqOp[CreateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserResponse] =
        visitor.createUser(request)
    }

    final case class DeleteBrokerOp(
      request: DeleteBrokerRequest
    ) extends MqOp[DeleteBrokerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBrokerResponse] =
        visitor.deleteBroker(request)
    }

    final case class DeleteTagsOp(
      request: DeleteTagsRequest
    ) extends MqOp[DeleteTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTagsResponse] =
        visitor.deleteTags(request)
    }

    final case class DeleteUserOp(
      request: DeleteUserRequest
    ) extends MqOp[DeleteUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserResponse] =
        visitor.deleteUser(request)
    }

    final case class DescribeBrokerOp(
      request: DescribeBrokerRequest
    ) extends MqOp[DescribeBrokerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBrokerResponse] =
        visitor.describeBroker(request)
    }

    final case class DescribeBrokerEngineTypesOp(
      request: DescribeBrokerEngineTypesRequest
    ) extends MqOp[DescribeBrokerEngineTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBrokerEngineTypesResponse] =
        visitor.describeBrokerEngineTypes(request)
    }

    final case class DescribeBrokerInstanceOptionsOp(
      request: DescribeBrokerInstanceOptionsRequest
    ) extends MqOp[DescribeBrokerInstanceOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBrokerInstanceOptionsResponse] =
        visitor.describeBrokerInstanceOptions(request)
    }

    final case class DescribeConfigurationOp(
      request: DescribeConfigurationRequest
    ) extends MqOp[DescribeConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConfigurationResponse] =
        visitor.describeConfiguration(request)
    }

    final case class DescribeConfigurationRevisionOp(
      request: DescribeConfigurationRevisionRequest
    ) extends MqOp[DescribeConfigurationRevisionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConfigurationRevisionResponse] =
        visitor.describeConfigurationRevision(request)
    }

    final case class DescribeUserOp(
      request: DescribeUserRequest
    ) extends MqOp[DescribeUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUserResponse] =
        visitor.describeUser(request)
    }

    final case class ListBrokersOp(
      request: ListBrokersRequest
    ) extends MqOp[ListBrokersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBrokersResponse] =
        visitor.listBrokers(request)
    }

    final case class ListConfigurationRevisionsOp(
      request: ListConfigurationRevisionsRequest
    ) extends MqOp[ListConfigurationRevisionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConfigurationRevisionsResponse] =
        visitor.listConfigurationRevisions(request)
    }

    final case class ListConfigurationsOp(
      request: ListConfigurationsRequest
    ) extends MqOp[ListConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConfigurationsResponse] =
        visitor.listConfigurations(request)
    }

    final case class ListTagsOp(
      request: ListTagsRequest
    ) extends MqOp[ListTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsResponse] =
        visitor.listTags(request)
    }

    final case class ListUsersOp(
      request: ListUsersRequest
    ) extends MqOp[ListUsersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUsersResponse] =
        visitor.listUsers(request)
    }

    final case class RebootBrokerOp(
      request: RebootBrokerRequest
    ) extends MqOp[RebootBrokerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RebootBrokerResponse] =
        visitor.rebootBroker(request)
    }

    final case class UpdateBrokerOp(
      request: UpdateBrokerRequest
    ) extends MqOp[UpdateBrokerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBrokerResponse] =
        visitor.updateBroker(request)
    }

    final case class UpdateConfigurationOp(
      request: UpdateConfigurationRequest
    ) extends MqOp[UpdateConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConfigurationResponse] =
        visitor.updateConfiguration(request)
    }

    final case class UpdateUserOp(
      request: UpdateUserRequest
    ) extends MqOp[UpdateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserResponse] =
        visitor.updateUser(request)
    }
  }

  import MqOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MqOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createBroker(
    request: CreateBrokerRequest
  ): MqIO[CreateBrokerResponse] =
    FF.liftF(CreateBrokerOp(request))

  def createConfiguration(
    request: CreateConfigurationRequest
  ): MqIO[CreateConfigurationResponse] =
    FF.liftF(CreateConfigurationOp(request))

  def createTags(
    request: CreateTagsRequest
  ): MqIO[CreateTagsResponse] =
    FF.liftF(CreateTagsOp(request))

  def createUser(
    request: CreateUserRequest
  ): MqIO[CreateUserResponse] =
    FF.liftF(CreateUserOp(request))

  def deleteBroker(
    request: DeleteBrokerRequest
  ): MqIO[DeleteBrokerResponse] =
    FF.liftF(DeleteBrokerOp(request))

  def deleteTags(
    request: DeleteTagsRequest
  ): MqIO[DeleteTagsResponse] =
    FF.liftF(DeleteTagsOp(request))

  def deleteUser(
    request: DeleteUserRequest
  ): MqIO[DeleteUserResponse] =
    FF.liftF(DeleteUserOp(request))

  def describeBroker(
    request: DescribeBrokerRequest
  ): MqIO[DescribeBrokerResponse] =
    FF.liftF(DescribeBrokerOp(request))

  def describeBrokerEngineTypes(
    request: DescribeBrokerEngineTypesRequest
  ): MqIO[DescribeBrokerEngineTypesResponse] =
    FF.liftF(DescribeBrokerEngineTypesOp(request))

  def describeBrokerInstanceOptions(
    request: DescribeBrokerInstanceOptionsRequest
  ): MqIO[DescribeBrokerInstanceOptionsResponse] =
    FF.liftF(DescribeBrokerInstanceOptionsOp(request))

  def describeConfiguration(
    request: DescribeConfigurationRequest
  ): MqIO[DescribeConfigurationResponse] =
    FF.liftF(DescribeConfigurationOp(request))

  def describeConfigurationRevision(
    request: DescribeConfigurationRevisionRequest
  ): MqIO[DescribeConfigurationRevisionResponse] =
    FF.liftF(DescribeConfigurationRevisionOp(request))

  def describeUser(
    request: DescribeUserRequest
  ): MqIO[DescribeUserResponse] =
    FF.liftF(DescribeUserOp(request))

  def listBrokers(
    request: ListBrokersRequest
  ): MqIO[ListBrokersResponse] =
    FF.liftF(ListBrokersOp(request))

  def listConfigurationRevisions(
    request: ListConfigurationRevisionsRequest
  ): MqIO[ListConfigurationRevisionsResponse] =
    FF.liftF(ListConfigurationRevisionsOp(request))

  def listConfigurations(
    request: ListConfigurationsRequest
  ): MqIO[ListConfigurationsResponse] =
    FF.liftF(ListConfigurationsOp(request))

  def listTags(
    request: ListTagsRequest
  ): MqIO[ListTagsResponse] =
    FF.liftF(ListTagsOp(request))

  def listUsers(
    request: ListUsersRequest
  ): MqIO[ListUsersResponse] =
    FF.liftF(ListUsersOp(request))

  def rebootBroker(
    request: RebootBrokerRequest
  ): MqIO[RebootBrokerResponse] =
    FF.liftF(RebootBrokerOp(request))

  def updateBroker(
    request: UpdateBrokerRequest
  ): MqIO[UpdateBrokerResponse] =
    FF.liftF(UpdateBrokerOp(request))

  def updateConfiguration(
    request: UpdateConfigurationRequest
  ): MqIO[UpdateConfigurationResponse] =
    FF.liftF(UpdateConfigurationOp(request))

  def updateUser(
    request: UpdateUserRequest
  ): MqIO[UpdateUserResponse] =
    FF.liftF(UpdateUserOp(request))
}
