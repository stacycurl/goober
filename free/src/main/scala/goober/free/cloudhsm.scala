package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.cloudhsm.CloudHsmClient
import software.amazon.awssdk.services.cloudhsm.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object cloudhsm { module =>

  // Free monad over CloudHsmOp
  type CloudHsmIO[A] = FF[CloudHsmOp, A]

  sealed trait CloudHsmOp[A] {
    def visit[F[_]](visitor: CloudHsmOp.Visitor[F]): F[A]
  }

  object CloudHsmOp {
    // Given a CloudHsmClient we can embed a CloudHsmIO program in any algebra that understands embedding.
    implicit val CloudHsmOpEmbeddable: Embeddable[CloudHsmOp, CloudHsmClient] = new Embeddable[CloudHsmOp, CloudHsmClient] {
      def embed[A](client: CloudHsmClient, io: CloudHsmIO[A]): Embedded[A] = Embedded.CloudHsm(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CloudHsmOp.Visitor[Kleisli[M, CloudHsmClient, *]] {
        def addTagsToResource(
          request: AddTagsToResourceRequest
        ): Kleisli[M, CloudHsmClient, AddTagsToResourceResponse] =
          primitive(_.addTagsToResource(request))

        def createHapg(
          request: CreateHapgRequest
        ): Kleisli[M, CloudHsmClient, CreateHapgResponse] =
          primitive(_.createHapg(request))

        def createHsm(
          request: CreateHsmRequest
        ): Kleisli[M, CloudHsmClient, CreateHsmResponse] =
          primitive(_.createHsm(request))

        def createLunaClient(
          request: CreateLunaClientRequest
        ): Kleisli[M, CloudHsmClient, CreateLunaClientResponse] =
          primitive(_.createLunaClient(request))

        def deleteHapg(
          request: DeleteHapgRequest
        ): Kleisli[M, CloudHsmClient, DeleteHapgResponse] =
          primitive(_.deleteHapg(request))

        def deleteHsm(
          request: DeleteHsmRequest
        ): Kleisli[M, CloudHsmClient, DeleteHsmResponse] =
          primitive(_.deleteHsm(request))

        def deleteLunaClient(
          request: DeleteLunaClientRequest
        ): Kleisli[M, CloudHsmClient, DeleteLunaClientResponse] =
          primitive(_.deleteLunaClient(request))

        def describeHapg(
          request: DescribeHapgRequest
        ): Kleisli[M, CloudHsmClient, DescribeHapgResponse] =
          primitive(_.describeHapg(request))

        def describeHsm(
          request: DescribeHsmRequest
        ): Kleisli[M, CloudHsmClient, DescribeHsmResponse] =
          primitive(_.describeHsm(request))

        def describeLunaClient(
          request: DescribeLunaClientRequest
        ): Kleisli[M, CloudHsmClient, DescribeLunaClientResponse] =
          primitive(_.describeLunaClient(request))

        def getConfig(
          request: GetConfigRequest
        ): Kleisli[M, CloudHsmClient, GetConfigResponse] =
          primitive(_.getConfig(request))

        def listAvailableZones(
          request: ListAvailableZonesRequest
        ): Kleisli[M, CloudHsmClient, ListAvailableZonesResponse] =
          primitive(_.listAvailableZones(request))

        def listHapgs(
          request: ListHapgsRequest
        ): Kleisli[M, CloudHsmClient, ListHapgsResponse] =
          primitive(_.listHapgs(request))

        def listHsms(
          request: ListHsmsRequest
        ): Kleisli[M, CloudHsmClient, ListHsmsResponse] =
          primitive(_.listHsms(request))

        def listLunaClients(
          request: ListLunaClientsRequest
        ): Kleisli[M, CloudHsmClient, ListLunaClientsResponse] =
          primitive(_.listLunaClients(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, CloudHsmClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def modifyHapg(
          request: ModifyHapgRequest
        ): Kleisli[M, CloudHsmClient, ModifyHapgResponse] =
          primitive(_.modifyHapg(request))

        def modifyHsm(
          request: ModifyHsmRequest
        ): Kleisli[M, CloudHsmClient, ModifyHsmResponse] =
          primitive(_.modifyHsm(request))

        def modifyLunaClient(
          request: ModifyLunaClientRequest
        ): Kleisli[M, CloudHsmClient, ModifyLunaClientResponse] =
          primitive(_.modifyLunaClient(request))

        def removeTagsFromResource(
          request: RemoveTagsFromResourceRequest
        ): Kleisli[M, CloudHsmClient, RemoveTagsFromResourceResponse] =
          primitive(_.removeTagsFromResource(request))

        def primitive[A](
          f: CloudHsmClient => A
        ): Kleisli[M, CloudHsmClient, A]
      }
    }

    trait Visitor[F[_]] extends (CloudHsmOp ~> F) {
      final def apply[A](op: CloudHsmOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addTagsToResource(
        request: AddTagsToResourceRequest
      ): F[AddTagsToResourceResponse]

      def createHapg(
        request: CreateHapgRequest
      ): F[CreateHapgResponse]

      def createHsm(
        request: CreateHsmRequest
      ): F[CreateHsmResponse]

      def createLunaClient(
        request: CreateLunaClientRequest
      ): F[CreateLunaClientResponse]

      def deleteHapg(
        request: DeleteHapgRequest
      ): F[DeleteHapgResponse]

      def deleteHsm(
        request: DeleteHsmRequest
      ): F[DeleteHsmResponse]

      def deleteLunaClient(
        request: DeleteLunaClientRequest
      ): F[DeleteLunaClientResponse]

      def describeHapg(
        request: DescribeHapgRequest
      ): F[DescribeHapgResponse]

      def describeHsm(
        request: DescribeHsmRequest
      ): F[DescribeHsmResponse]

      def describeLunaClient(
        request: DescribeLunaClientRequest
      ): F[DescribeLunaClientResponse]

      def getConfig(
        request: GetConfigRequest
      ): F[GetConfigResponse]

      def listAvailableZones(
        request: ListAvailableZonesRequest
      ): F[ListAvailableZonesResponse]

      def listHapgs(
        request: ListHapgsRequest
      ): F[ListHapgsResponse]

      def listHsms(
        request: ListHsmsRequest
      ): F[ListHsmsResponse]

      def listLunaClients(
        request: ListLunaClientsRequest
      ): F[ListLunaClientsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def modifyHapg(
        request: ModifyHapgRequest
      ): F[ModifyHapgResponse]

      def modifyHsm(
        request: ModifyHsmRequest
      ): F[ModifyHsmResponse]

      def modifyLunaClient(
        request: ModifyLunaClientRequest
      ): F[ModifyLunaClientResponse]

      def removeTagsFromResource(
        request: RemoveTagsFromResourceRequest
      ): F[RemoveTagsFromResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CloudHsmOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddTagsToResourceOp(
      request: AddTagsToResourceRequest
    ) extends CloudHsmOp[AddTagsToResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsToResourceResponse] =
        visitor.addTagsToResource(request)
    }

    final case class CreateHapgOp(
      request: CreateHapgRequest
    ) extends CloudHsmOp[CreateHapgResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateHapgResponse] =
        visitor.createHapg(request)
    }

    final case class CreateHsmOp(
      request: CreateHsmRequest
    ) extends CloudHsmOp[CreateHsmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateHsmResponse] =
        visitor.createHsm(request)
    }

    final case class CreateLunaClientOp(
      request: CreateLunaClientRequest
    ) extends CloudHsmOp[CreateLunaClientResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLunaClientResponse] =
        visitor.createLunaClient(request)
    }

    final case class DeleteHapgOp(
      request: DeleteHapgRequest
    ) extends CloudHsmOp[DeleteHapgResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteHapgResponse] =
        visitor.deleteHapg(request)
    }

    final case class DeleteHsmOp(
      request: DeleteHsmRequest
    ) extends CloudHsmOp[DeleteHsmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteHsmResponse] =
        visitor.deleteHsm(request)
    }

    final case class DeleteLunaClientOp(
      request: DeleteLunaClientRequest
    ) extends CloudHsmOp[DeleteLunaClientResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLunaClientResponse] =
        visitor.deleteLunaClient(request)
    }

    final case class DescribeHapgOp(
      request: DescribeHapgRequest
    ) extends CloudHsmOp[DescribeHapgResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeHapgResponse] =
        visitor.describeHapg(request)
    }

    final case class DescribeHsmOp(
      request: DescribeHsmRequest
    ) extends CloudHsmOp[DescribeHsmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeHsmResponse] =
        visitor.describeHsm(request)
    }

    final case class DescribeLunaClientOp(
      request: DescribeLunaClientRequest
    ) extends CloudHsmOp[DescribeLunaClientResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLunaClientResponse] =
        visitor.describeLunaClient(request)
    }

    final case class GetConfigOp(
      request: GetConfigRequest
    ) extends CloudHsmOp[GetConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConfigResponse] =
        visitor.getConfig(request)
    }

    final case class ListAvailableZonesOp(
      request: ListAvailableZonesRequest
    ) extends CloudHsmOp[ListAvailableZonesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAvailableZonesResponse] =
        visitor.listAvailableZones(request)
    }

    final case class ListHapgsOp(
      request: ListHapgsRequest
    ) extends CloudHsmOp[ListHapgsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListHapgsResponse] =
        visitor.listHapgs(request)
    }

    final case class ListHsmsOp(
      request: ListHsmsRequest
    ) extends CloudHsmOp[ListHsmsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListHsmsResponse] =
        visitor.listHsms(request)
    }

    final case class ListLunaClientsOp(
      request: ListLunaClientsRequest
    ) extends CloudHsmOp[ListLunaClientsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLunaClientsResponse] =
        visitor.listLunaClients(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends CloudHsmOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ModifyHapgOp(
      request: ModifyHapgRequest
    ) extends CloudHsmOp[ModifyHapgResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyHapgResponse] =
        visitor.modifyHapg(request)
    }

    final case class ModifyHsmOp(
      request: ModifyHsmRequest
    ) extends CloudHsmOp[ModifyHsmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyHsmResponse] =
        visitor.modifyHsm(request)
    }

    final case class ModifyLunaClientOp(
      request: ModifyLunaClientRequest
    ) extends CloudHsmOp[ModifyLunaClientResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyLunaClientResponse] =
        visitor.modifyLunaClient(request)
    }

    final case class RemoveTagsFromResourceOp(
      request: RemoveTagsFromResourceRequest
    ) extends CloudHsmOp[RemoveTagsFromResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTagsFromResourceResponse] =
        visitor.removeTagsFromResource(request)
    }
  }

  import CloudHsmOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CloudHsmOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addTagsToResource(
    request: AddTagsToResourceRequest
  ): CloudHsmIO[AddTagsToResourceResponse] =
    FF.liftF(AddTagsToResourceOp(request))

  def createHapg(
    request: CreateHapgRequest
  ): CloudHsmIO[CreateHapgResponse] =
    FF.liftF(CreateHapgOp(request))

  def createHsm(
    request: CreateHsmRequest
  ): CloudHsmIO[CreateHsmResponse] =
    FF.liftF(CreateHsmOp(request))

  def createLunaClient(
    request: CreateLunaClientRequest
  ): CloudHsmIO[CreateLunaClientResponse] =
    FF.liftF(CreateLunaClientOp(request))

  def deleteHapg(
    request: DeleteHapgRequest
  ): CloudHsmIO[DeleteHapgResponse] =
    FF.liftF(DeleteHapgOp(request))

  def deleteHsm(
    request: DeleteHsmRequest
  ): CloudHsmIO[DeleteHsmResponse] =
    FF.liftF(DeleteHsmOp(request))

  def deleteLunaClient(
    request: DeleteLunaClientRequest
  ): CloudHsmIO[DeleteLunaClientResponse] =
    FF.liftF(DeleteLunaClientOp(request))

  def describeHapg(
    request: DescribeHapgRequest
  ): CloudHsmIO[DescribeHapgResponse] =
    FF.liftF(DescribeHapgOp(request))

  def describeHsm(
    request: DescribeHsmRequest
  ): CloudHsmIO[DescribeHsmResponse] =
    FF.liftF(DescribeHsmOp(request))

  def describeLunaClient(
    request: DescribeLunaClientRequest
  ): CloudHsmIO[DescribeLunaClientResponse] =
    FF.liftF(DescribeLunaClientOp(request))

  def getConfig(
    request: GetConfigRequest
  ): CloudHsmIO[GetConfigResponse] =
    FF.liftF(GetConfigOp(request))

  def listAvailableZones(
    request: ListAvailableZonesRequest
  ): CloudHsmIO[ListAvailableZonesResponse] =
    FF.liftF(ListAvailableZonesOp(request))

  def listHapgs(
    request: ListHapgsRequest
  ): CloudHsmIO[ListHapgsResponse] =
    FF.liftF(ListHapgsOp(request))

  def listHsms(
    request: ListHsmsRequest
  ): CloudHsmIO[ListHsmsResponse] =
    FF.liftF(ListHsmsOp(request))

  def listLunaClients(
    request: ListLunaClientsRequest
  ): CloudHsmIO[ListLunaClientsResponse] =
    FF.liftF(ListLunaClientsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): CloudHsmIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def modifyHapg(
    request: ModifyHapgRequest
  ): CloudHsmIO[ModifyHapgResponse] =
    FF.liftF(ModifyHapgOp(request))

  def modifyHsm(
    request: ModifyHsmRequest
  ): CloudHsmIO[ModifyHsmResponse] =
    FF.liftF(ModifyHsmOp(request))

  def modifyLunaClient(
    request: ModifyLunaClientRequest
  ): CloudHsmIO[ModifyLunaClientResponse] =
    FF.liftF(ModifyLunaClientOp(request))

  def removeTagsFromResource(
    request: RemoveTagsFromResourceRequest
  ): CloudHsmIO[RemoveTagsFromResourceResponse] =
    FF.liftF(RemoveTagsFromResourceOp(request))
}
