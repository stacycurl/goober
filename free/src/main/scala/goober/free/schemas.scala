package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.schemas.SchemasClient
import software.amazon.awssdk.services.schemas.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object schemas { module =>

  // Free monad over SchemasOp
  type SchemasIO[A] = FF[SchemasOp, A]

  sealed trait SchemasOp[A] {
    def visit[F[_]](visitor: SchemasOp.Visitor[F]): F[A]
  }

  object SchemasOp {
    // Given a SchemasClient we can embed a SchemasIO program in any algebra that understands embedding.
    implicit val SchemasOpEmbeddable: Embeddable[SchemasOp, SchemasClient] = new Embeddable[SchemasOp, SchemasClient] {
      def embed[A](client: SchemasClient, io: SchemasIO[A]): Embedded[A] = Embedded.Schemas(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SchemasOp.Visitor[Kleisli[M, SchemasClient, *]] {
        def createDiscoverer(
          request: CreateDiscovererRequest
        ): Kleisli[M, SchemasClient, CreateDiscovererResponse] =
          primitive(_.createDiscoverer(request))

        def createRegistry(
          request: CreateRegistryRequest
        ): Kleisli[M, SchemasClient, CreateRegistryResponse] =
          primitive(_.createRegistry(request))

        def createSchema(
          request: CreateSchemaRequest
        ): Kleisli[M, SchemasClient, CreateSchemaResponse] =
          primitive(_.createSchema(request))

        def deleteDiscoverer(
          request: DeleteDiscovererRequest
        ): Kleisli[M, SchemasClient, DeleteDiscovererResponse] =
          primitive(_.deleteDiscoverer(request))

        def deleteRegistry(
          request: DeleteRegistryRequest
        ): Kleisli[M, SchemasClient, DeleteRegistryResponse] =
          primitive(_.deleteRegistry(request))

        def deleteResourcePolicy(
          request: DeleteResourcePolicyRequest
        ): Kleisli[M, SchemasClient, DeleteResourcePolicyResponse] =
          primitive(_.deleteResourcePolicy(request))

        def deleteSchema(
          request: DeleteSchemaRequest
        ): Kleisli[M, SchemasClient, DeleteSchemaResponse] =
          primitive(_.deleteSchema(request))

        def deleteSchemaVersion(
          request: DeleteSchemaVersionRequest
        ): Kleisli[M, SchemasClient, DeleteSchemaVersionResponse] =
          primitive(_.deleteSchemaVersion(request))

        def describeCodeBinding(
          request: DescribeCodeBindingRequest
        ): Kleisli[M, SchemasClient, DescribeCodeBindingResponse] =
          primitive(_.describeCodeBinding(request))

        def describeDiscoverer(
          request: DescribeDiscovererRequest
        ): Kleisli[M, SchemasClient, DescribeDiscovererResponse] =
          primitive(_.describeDiscoverer(request))

        def describeRegistry(
          request: DescribeRegistryRequest
        ): Kleisli[M, SchemasClient, DescribeRegistryResponse] =
          primitive(_.describeRegistry(request))

        def describeSchema(
          request: DescribeSchemaRequest
        ): Kleisli[M, SchemasClient, DescribeSchemaResponse] =
          primitive(_.describeSchema(request))

        def exportSchema(
          request: ExportSchemaRequest
        ): Kleisli[M, SchemasClient, ExportSchemaResponse] =
          primitive(_.exportSchema(request))

        def getCodeBindingSource(
          request: GetCodeBindingSourceRequest
        ): Kleisli[M, SchemasClient, GetCodeBindingSourceResponse] =
          primitive(_.getCodeBindingSource(request))

        def getDiscoveredSchema(
          request: GetDiscoveredSchemaRequest
        ): Kleisli[M, SchemasClient, GetDiscoveredSchemaResponse] =
          primitive(_.getDiscoveredSchema(request))

        def getResourcePolicy(
          request: GetResourcePolicyRequest
        ): Kleisli[M, SchemasClient, GetResourcePolicyResponse] =
          primitive(_.getResourcePolicy(request))

        def listDiscoverers(
          request: ListDiscoverersRequest
        ): Kleisli[M, SchemasClient, ListDiscoverersResponse] =
          primitive(_.listDiscoverers(request))

        def listRegistries(
          request: ListRegistriesRequest
        ): Kleisli[M, SchemasClient, ListRegistriesResponse] =
          primitive(_.listRegistries(request))

        def listSchemaVersions(
          request: ListSchemaVersionsRequest
        ): Kleisli[M, SchemasClient, ListSchemaVersionsResponse] =
          primitive(_.listSchemaVersions(request))

        def listSchemas(
          request: ListSchemasRequest
        ): Kleisli[M, SchemasClient, ListSchemasResponse] =
          primitive(_.listSchemas(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, SchemasClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putCodeBinding(
          request: PutCodeBindingRequest
        ): Kleisli[M, SchemasClient, PutCodeBindingResponse] =
          primitive(_.putCodeBinding(request))

        def putResourcePolicy(
          request: PutResourcePolicyRequest
        ): Kleisli[M, SchemasClient, PutResourcePolicyResponse] =
          primitive(_.putResourcePolicy(request))

        def searchSchemas(
          request: SearchSchemasRequest
        ): Kleisli[M, SchemasClient, SearchSchemasResponse] =
          primitive(_.searchSchemas(request))

        def startDiscoverer(
          request: StartDiscovererRequest
        ): Kleisli[M, SchemasClient, StartDiscovererResponse] =
          primitive(_.startDiscoverer(request))

        def stopDiscoverer(
          request: StopDiscovererRequest
        ): Kleisli[M, SchemasClient, StopDiscovererResponse] =
          primitive(_.stopDiscoverer(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, SchemasClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, SchemasClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateDiscoverer(
          request: UpdateDiscovererRequest
        ): Kleisli[M, SchemasClient, UpdateDiscovererResponse] =
          primitive(_.updateDiscoverer(request))

        def updateRegistry(
          request: UpdateRegistryRequest
        ): Kleisli[M, SchemasClient, UpdateRegistryResponse] =
          primitive(_.updateRegistry(request))

        def updateSchema(
          request: UpdateSchemaRequest
        ): Kleisli[M, SchemasClient, UpdateSchemaResponse] =
          primitive(_.updateSchema(request))

        def primitive[A](
          f: SchemasClient => A
        ): Kleisli[M, SchemasClient, A]
      }
    }

    trait Visitor[F[_]] extends (SchemasOp ~> F) {
      final def apply[A](op: SchemasOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createDiscoverer(
        request: CreateDiscovererRequest
      ): F[CreateDiscovererResponse]

      def createRegistry(
        request: CreateRegistryRequest
      ): F[CreateRegistryResponse]

      def createSchema(
        request: CreateSchemaRequest
      ): F[CreateSchemaResponse]

      def deleteDiscoverer(
        request: DeleteDiscovererRequest
      ): F[DeleteDiscovererResponse]

      def deleteRegistry(
        request: DeleteRegistryRequest
      ): F[DeleteRegistryResponse]

      def deleteResourcePolicy(
        request: DeleteResourcePolicyRequest
      ): F[DeleteResourcePolicyResponse]

      def deleteSchema(
        request: DeleteSchemaRequest
      ): F[DeleteSchemaResponse]

      def deleteSchemaVersion(
        request: DeleteSchemaVersionRequest
      ): F[DeleteSchemaVersionResponse]

      def describeCodeBinding(
        request: DescribeCodeBindingRequest
      ): F[DescribeCodeBindingResponse]

      def describeDiscoverer(
        request: DescribeDiscovererRequest
      ): F[DescribeDiscovererResponse]

      def describeRegistry(
        request: DescribeRegistryRequest
      ): F[DescribeRegistryResponse]

      def describeSchema(
        request: DescribeSchemaRequest
      ): F[DescribeSchemaResponse]

      def exportSchema(
        request: ExportSchemaRequest
      ): F[ExportSchemaResponse]

      def getCodeBindingSource(
        request: GetCodeBindingSourceRequest
      ): F[GetCodeBindingSourceResponse]

      def getDiscoveredSchema(
        request: GetDiscoveredSchemaRequest
      ): F[GetDiscoveredSchemaResponse]

      def getResourcePolicy(
        request: GetResourcePolicyRequest
      ): F[GetResourcePolicyResponse]

      def listDiscoverers(
        request: ListDiscoverersRequest
      ): F[ListDiscoverersResponse]

      def listRegistries(
        request: ListRegistriesRequest
      ): F[ListRegistriesResponse]

      def listSchemaVersions(
        request: ListSchemaVersionsRequest
      ): F[ListSchemaVersionsResponse]

      def listSchemas(
        request: ListSchemasRequest
      ): F[ListSchemasResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putCodeBinding(
        request: PutCodeBindingRequest
      ): F[PutCodeBindingResponse]

      def putResourcePolicy(
        request: PutResourcePolicyRequest
      ): F[PutResourcePolicyResponse]

      def searchSchemas(
        request: SearchSchemasRequest
      ): F[SearchSchemasResponse]

      def startDiscoverer(
        request: StartDiscovererRequest
      ): F[StartDiscovererResponse]

      def stopDiscoverer(
        request: StopDiscovererRequest
      ): F[StopDiscovererResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateDiscoverer(
        request: UpdateDiscovererRequest
      ): F[UpdateDiscovererResponse]

      def updateRegistry(
        request: UpdateRegistryRequest
      ): F[UpdateRegistryResponse]

      def updateSchema(
        request: UpdateSchemaRequest
      ): F[UpdateSchemaResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SchemasOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateDiscovererOp(
      request: CreateDiscovererRequest
    ) extends SchemasOp[CreateDiscovererResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDiscovererResponse] =
        visitor.createDiscoverer(request)
    }

    final case class CreateRegistryOp(
      request: CreateRegistryRequest
    ) extends SchemasOp[CreateRegistryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRegistryResponse] =
        visitor.createRegistry(request)
    }

    final case class CreateSchemaOp(
      request: CreateSchemaRequest
    ) extends SchemasOp[CreateSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSchemaResponse] =
        visitor.createSchema(request)
    }

    final case class DeleteDiscovererOp(
      request: DeleteDiscovererRequest
    ) extends SchemasOp[DeleteDiscovererResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDiscovererResponse] =
        visitor.deleteDiscoverer(request)
    }

    final case class DeleteRegistryOp(
      request: DeleteRegistryRequest
    ) extends SchemasOp[DeleteRegistryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRegistryResponse] =
        visitor.deleteRegistry(request)
    }

    final case class DeleteResourcePolicyOp(
      request: DeleteResourcePolicyRequest
    ) extends SchemasOp[DeleteResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResourcePolicyResponse] =
        visitor.deleteResourcePolicy(request)
    }

    final case class DeleteSchemaOp(
      request: DeleteSchemaRequest
    ) extends SchemasOp[DeleteSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSchemaResponse] =
        visitor.deleteSchema(request)
    }

    final case class DeleteSchemaVersionOp(
      request: DeleteSchemaVersionRequest
    ) extends SchemasOp[DeleteSchemaVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSchemaVersionResponse] =
        visitor.deleteSchemaVersion(request)
    }

    final case class DescribeCodeBindingOp(
      request: DescribeCodeBindingRequest
    ) extends SchemasOp[DescribeCodeBindingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCodeBindingResponse] =
        visitor.describeCodeBinding(request)
    }

    final case class DescribeDiscovererOp(
      request: DescribeDiscovererRequest
    ) extends SchemasOp[DescribeDiscovererResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDiscovererResponse] =
        visitor.describeDiscoverer(request)
    }

    final case class DescribeRegistryOp(
      request: DescribeRegistryRequest
    ) extends SchemasOp[DescribeRegistryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRegistryResponse] =
        visitor.describeRegistry(request)
    }

    final case class DescribeSchemaOp(
      request: DescribeSchemaRequest
    ) extends SchemasOp[DescribeSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSchemaResponse] =
        visitor.describeSchema(request)
    }

    final case class ExportSchemaOp(
      request: ExportSchemaRequest
    ) extends SchemasOp[ExportSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExportSchemaResponse] =
        visitor.exportSchema(request)
    }

    final case class GetCodeBindingSourceOp(
      request: GetCodeBindingSourceRequest
    ) extends SchemasOp[GetCodeBindingSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCodeBindingSourceResponse] =
        visitor.getCodeBindingSource(request)
    }

    final case class GetDiscoveredSchemaOp(
      request: GetDiscoveredSchemaRequest
    ) extends SchemasOp[GetDiscoveredSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDiscoveredSchemaResponse] =
        visitor.getDiscoveredSchema(request)
    }

    final case class GetResourcePolicyOp(
      request: GetResourcePolicyRequest
    ) extends SchemasOp[GetResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourcePolicyResponse] =
        visitor.getResourcePolicy(request)
    }

    final case class ListDiscoverersOp(
      request: ListDiscoverersRequest
    ) extends SchemasOp[ListDiscoverersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDiscoverersResponse] =
        visitor.listDiscoverers(request)
    }

    final case class ListRegistriesOp(
      request: ListRegistriesRequest
    ) extends SchemasOp[ListRegistriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRegistriesResponse] =
        visitor.listRegistries(request)
    }

    final case class ListSchemaVersionsOp(
      request: ListSchemaVersionsRequest
    ) extends SchemasOp[ListSchemaVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSchemaVersionsResponse] =
        visitor.listSchemaVersions(request)
    }

    final case class ListSchemasOp(
      request: ListSchemasRequest
    ) extends SchemasOp[ListSchemasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSchemasResponse] =
        visitor.listSchemas(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends SchemasOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutCodeBindingOp(
      request: PutCodeBindingRequest
    ) extends SchemasOp[PutCodeBindingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutCodeBindingResponse] =
        visitor.putCodeBinding(request)
    }

    final case class PutResourcePolicyOp(
      request: PutResourcePolicyRequest
    ) extends SchemasOp[PutResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutResourcePolicyResponse] =
        visitor.putResourcePolicy(request)
    }

    final case class SearchSchemasOp(
      request: SearchSchemasRequest
    ) extends SchemasOp[SearchSchemasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchSchemasResponse] =
        visitor.searchSchemas(request)
    }

    final case class StartDiscovererOp(
      request: StartDiscovererRequest
    ) extends SchemasOp[StartDiscovererResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDiscovererResponse] =
        visitor.startDiscoverer(request)
    }

    final case class StopDiscovererOp(
      request: StopDiscovererRequest
    ) extends SchemasOp[StopDiscovererResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopDiscovererResponse] =
        visitor.stopDiscoverer(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends SchemasOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends SchemasOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateDiscovererOp(
      request: UpdateDiscovererRequest
    ) extends SchemasOp[UpdateDiscovererResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDiscovererResponse] =
        visitor.updateDiscoverer(request)
    }

    final case class UpdateRegistryOp(
      request: UpdateRegistryRequest
    ) extends SchemasOp[UpdateRegistryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRegistryResponse] =
        visitor.updateRegistry(request)
    }

    final case class UpdateSchemaOp(
      request: UpdateSchemaRequest
    ) extends SchemasOp[UpdateSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSchemaResponse] =
        visitor.updateSchema(request)
    }
  }

  import SchemasOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SchemasOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createDiscoverer(
    request: CreateDiscovererRequest
  ): SchemasIO[CreateDiscovererResponse] =
    FF.liftF(CreateDiscovererOp(request))

  def createRegistry(
    request: CreateRegistryRequest
  ): SchemasIO[CreateRegistryResponse] =
    FF.liftF(CreateRegistryOp(request))

  def createSchema(
    request: CreateSchemaRequest
  ): SchemasIO[CreateSchemaResponse] =
    FF.liftF(CreateSchemaOp(request))

  def deleteDiscoverer(
    request: DeleteDiscovererRequest
  ): SchemasIO[DeleteDiscovererResponse] =
    FF.liftF(DeleteDiscovererOp(request))

  def deleteRegistry(
    request: DeleteRegistryRequest
  ): SchemasIO[DeleteRegistryResponse] =
    FF.liftF(DeleteRegistryOp(request))

  def deleteResourcePolicy(
    request: DeleteResourcePolicyRequest
  ): SchemasIO[DeleteResourcePolicyResponse] =
    FF.liftF(DeleteResourcePolicyOp(request))

  def deleteSchema(
    request: DeleteSchemaRequest
  ): SchemasIO[DeleteSchemaResponse] =
    FF.liftF(DeleteSchemaOp(request))

  def deleteSchemaVersion(
    request: DeleteSchemaVersionRequest
  ): SchemasIO[DeleteSchemaVersionResponse] =
    FF.liftF(DeleteSchemaVersionOp(request))

  def describeCodeBinding(
    request: DescribeCodeBindingRequest
  ): SchemasIO[DescribeCodeBindingResponse] =
    FF.liftF(DescribeCodeBindingOp(request))

  def describeDiscoverer(
    request: DescribeDiscovererRequest
  ): SchemasIO[DescribeDiscovererResponse] =
    FF.liftF(DescribeDiscovererOp(request))

  def describeRegistry(
    request: DescribeRegistryRequest
  ): SchemasIO[DescribeRegistryResponse] =
    FF.liftF(DescribeRegistryOp(request))

  def describeSchema(
    request: DescribeSchemaRequest
  ): SchemasIO[DescribeSchemaResponse] =
    FF.liftF(DescribeSchemaOp(request))

  def exportSchema(
    request: ExportSchemaRequest
  ): SchemasIO[ExportSchemaResponse] =
    FF.liftF(ExportSchemaOp(request))

  def getCodeBindingSource(
    request: GetCodeBindingSourceRequest
  ): SchemasIO[GetCodeBindingSourceResponse] =
    FF.liftF(GetCodeBindingSourceOp(request))

  def getDiscoveredSchema(
    request: GetDiscoveredSchemaRequest
  ): SchemasIO[GetDiscoveredSchemaResponse] =
    FF.liftF(GetDiscoveredSchemaOp(request))

  def getResourcePolicy(
    request: GetResourcePolicyRequest
  ): SchemasIO[GetResourcePolicyResponse] =
    FF.liftF(GetResourcePolicyOp(request))

  def listDiscoverers(
    request: ListDiscoverersRequest
  ): SchemasIO[ListDiscoverersResponse] =
    FF.liftF(ListDiscoverersOp(request))

  def listRegistries(
    request: ListRegistriesRequest
  ): SchemasIO[ListRegistriesResponse] =
    FF.liftF(ListRegistriesOp(request))

  def listSchemaVersions(
    request: ListSchemaVersionsRequest
  ): SchemasIO[ListSchemaVersionsResponse] =
    FF.liftF(ListSchemaVersionsOp(request))

  def listSchemas(
    request: ListSchemasRequest
  ): SchemasIO[ListSchemasResponse] =
    FF.liftF(ListSchemasOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): SchemasIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putCodeBinding(
    request: PutCodeBindingRequest
  ): SchemasIO[PutCodeBindingResponse] =
    FF.liftF(PutCodeBindingOp(request))

  def putResourcePolicy(
    request: PutResourcePolicyRequest
  ): SchemasIO[PutResourcePolicyResponse] =
    FF.liftF(PutResourcePolicyOp(request))

  def searchSchemas(
    request: SearchSchemasRequest
  ): SchemasIO[SearchSchemasResponse] =
    FF.liftF(SearchSchemasOp(request))

  def startDiscoverer(
    request: StartDiscovererRequest
  ): SchemasIO[StartDiscovererResponse] =
    FF.liftF(StartDiscovererOp(request))

  def stopDiscoverer(
    request: StopDiscovererRequest
  ): SchemasIO[StopDiscovererResponse] =
    FF.liftF(StopDiscovererOp(request))

  def tagResource(
    request: TagResourceRequest
  ): SchemasIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): SchemasIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateDiscoverer(
    request: UpdateDiscovererRequest
  ): SchemasIO[UpdateDiscovererResponse] =
    FF.liftF(UpdateDiscovererOp(request))

  def updateRegistry(
    request: UpdateRegistryRequest
  ): SchemasIO[UpdateRegistryResponse] =
    FF.liftF(UpdateRegistryOp(request))

  def updateSchema(
    request: UpdateSchemaRequest
  ): SchemasIO[UpdateSchemaResponse] =
    FF.liftF(UpdateSchemaOp(request))
}
