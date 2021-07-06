package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.lakeformation.LakeFormationClient
import software.amazon.awssdk.services.lakeformation.model._


object lakeformation { module =>

  // Free monad over LakeFormationOp
  type LakeFormationIO[A] = FF[LakeFormationOp, A]

  sealed trait LakeFormationOp[A] {
    def visit[F[_]](visitor: LakeFormationOp.Visitor[F]): F[A]
  }

  object LakeFormationOp {
    // Given a LakeFormationClient we can embed a LakeFormationIO program in any algebra that understands embedding.
    implicit val LakeFormationOpEmbeddable: Embeddable[LakeFormationOp, LakeFormationClient] = new Embeddable[LakeFormationOp, LakeFormationClient] {
      def embed[A](client: LakeFormationClient, io: LakeFormationIO[A]): Embedded[A] = Embedded.LakeFormation(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends LakeFormationOp.Visitor[Kleisli[M, LakeFormationClient, *]] {
        def addLFTagsToResource(
          request: AddLfTagsToResourceRequest
        ): Kleisli[M, LakeFormationClient, AddLfTagsToResourceResponse] =
          primitive(_.addLFTagsToResource(request))

        def batchGrantPermissions(
          request: BatchGrantPermissionsRequest
        ): Kleisli[M, LakeFormationClient, BatchGrantPermissionsResponse] =
          primitive(_.batchGrantPermissions(request))

        def batchRevokePermissions(
          request: BatchRevokePermissionsRequest
        ): Kleisli[M, LakeFormationClient, BatchRevokePermissionsResponse] =
          primitive(_.batchRevokePermissions(request))

        def createLFTag(
          request: CreateLfTagRequest
        ): Kleisli[M, LakeFormationClient, CreateLfTagResponse] =
          primitive(_.createLFTag(request))

        def deleteLFTag(
          request: DeleteLfTagRequest
        ): Kleisli[M, LakeFormationClient, DeleteLfTagResponse] =
          primitive(_.deleteLFTag(request))

        def deregisterResource(
          request: DeregisterResourceRequest
        ): Kleisli[M, LakeFormationClient, DeregisterResourceResponse] =
          primitive(_.deregisterResource(request))

        def describeResource(
          request: DescribeResourceRequest
        ): Kleisli[M, LakeFormationClient, DescribeResourceResponse] =
          primitive(_.describeResource(request))

        def getDataLakeSettings(
          request: GetDataLakeSettingsRequest
        ): Kleisli[M, LakeFormationClient, GetDataLakeSettingsResponse] =
          primitive(_.getDataLakeSettings(request))

        def getEffectivePermissionsForPath(
          request: GetEffectivePermissionsForPathRequest
        ): Kleisli[M, LakeFormationClient, GetEffectivePermissionsForPathResponse] =
          primitive(_.getEffectivePermissionsForPath(request))

        def getLFTag(
          request: GetLfTagRequest
        ): Kleisli[M, LakeFormationClient, GetLfTagResponse] =
          primitive(_.getLFTag(request))

        def getResourceLFTags(
          request: GetResourceLfTagsRequest
        ): Kleisli[M, LakeFormationClient, GetResourceLfTagsResponse] =
          primitive(_.getResourceLFTags(request))

        def grantPermissions(
          request: GrantPermissionsRequest
        ): Kleisli[M, LakeFormationClient, GrantPermissionsResponse] =
          primitive(_.grantPermissions(request))

        def listLFTags(
          request: ListLfTagsRequest
        ): Kleisli[M, LakeFormationClient, ListLfTagsResponse] =
          primitive(_.listLFTags(request))

        def listPermissions(
          request: ListPermissionsRequest
        ): Kleisli[M, LakeFormationClient, ListPermissionsResponse] =
          primitive(_.listPermissions(request))

        def listResources(
          request: ListResourcesRequest
        ): Kleisli[M, LakeFormationClient, ListResourcesResponse] =
          primitive(_.listResources(request))

        def putDataLakeSettings(
          request: PutDataLakeSettingsRequest
        ): Kleisli[M, LakeFormationClient, PutDataLakeSettingsResponse] =
          primitive(_.putDataLakeSettings(request))

        def registerResource(
          request: RegisterResourceRequest
        ): Kleisli[M, LakeFormationClient, RegisterResourceResponse] =
          primitive(_.registerResource(request))

        def removeLFTagsFromResource(
          request: RemoveLfTagsFromResourceRequest
        ): Kleisli[M, LakeFormationClient, RemoveLfTagsFromResourceResponse] =
          primitive(_.removeLFTagsFromResource(request))

        def revokePermissions(
          request: RevokePermissionsRequest
        ): Kleisli[M, LakeFormationClient, RevokePermissionsResponse] =
          primitive(_.revokePermissions(request))

        def searchDatabasesByLFTags(
          request: SearchDatabasesByLfTagsRequest
        ): Kleisli[M, LakeFormationClient, SearchDatabasesByLfTagsResponse] =
          primitive(_.searchDatabasesByLFTags(request))

        def searchTablesByLFTags(
          request: SearchTablesByLfTagsRequest
        ): Kleisli[M, LakeFormationClient, SearchTablesByLfTagsResponse] =
          primitive(_.searchTablesByLFTags(request))

        def updateLFTag(
          request: UpdateLfTagRequest
        ): Kleisli[M, LakeFormationClient, UpdateLfTagResponse] =
          primitive(_.updateLFTag(request))

        def updateResource(
          request: UpdateResourceRequest
        ): Kleisli[M, LakeFormationClient, UpdateResourceResponse] =
          primitive(_.updateResource(request))

        def primitive[A](
          f: LakeFormationClient => A
        ): Kleisli[M, LakeFormationClient, A]
      }
    }

    trait Visitor[F[_]] extends (LakeFormationOp ~> F) {
      final def apply[A](op: LakeFormationOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addLFTagsToResource(
        request: AddLfTagsToResourceRequest
      ): F[AddLfTagsToResourceResponse]

      def batchGrantPermissions(
        request: BatchGrantPermissionsRequest
      ): F[BatchGrantPermissionsResponse]

      def batchRevokePermissions(
        request: BatchRevokePermissionsRequest
      ): F[BatchRevokePermissionsResponse]

      def createLFTag(
        request: CreateLfTagRequest
      ): F[CreateLfTagResponse]

      def deleteLFTag(
        request: DeleteLfTagRequest
      ): F[DeleteLfTagResponse]

      def deregisterResource(
        request: DeregisterResourceRequest
      ): F[DeregisterResourceResponse]

      def describeResource(
        request: DescribeResourceRequest
      ): F[DescribeResourceResponse]

      def getDataLakeSettings(
        request: GetDataLakeSettingsRequest
      ): F[GetDataLakeSettingsResponse]

      def getEffectivePermissionsForPath(
        request: GetEffectivePermissionsForPathRequest
      ): F[GetEffectivePermissionsForPathResponse]

      def getLFTag(
        request: GetLfTagRequest
      ): F[GetLfTagResponse]

      def getResourceLFTags(
        request: GetResourceLfTagsRequest
      ): F[GetResourceLfTagsResponse]

      def grantPermissions(
        request: GrantPermissionsRequest
      ): F[GrantPermissionsResponse]

      def listLFTags(
        request: ListLfTagsRequest
      ): F[ListLfTagsResponse]

      def listPermissions(
        request: ListPermissionsRequest
      ): F[ListPermissionsResponse]

      def listResources(
        request: ListResourcesRequest
      ): F[ListResourcesResponse]

      def putDataLakeSettings(
        request: PutDataLakeSettingsRequest
      ): F[PutDataLakeSettingsResponse]

      def registerResource(
        request: RegisterResourceRequest
      ): F[RegisterResourceResponse]

      def removeLFTagsFromResource(
        request: RemoveLfTagsFromResourceRequest
      ): F[RemoveLfTagsFromResourceResponse]

      def revokePermissions(
        request: RevokePermissionsRequest
      ): F[RevokePermissionsResponse]

      def searchDatabasesByLFTags(
        request: SearchDatabasesByLfTagsRequest
      ): F[SearchDatabasesByLfTagsResponse]

      def searchTablesByLFTags(
        request: SearchTablesByLfTagsRequest
      ): F[SearchTablesByLfTagsResponse]

      def updateLFTag(
        request: UpdateLfTagRequest
      ): F[UpdateLfTagResponse]

      def updateResource(
        request: UpdateResourceRequest
      ): F[UpdateResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends LakeFormationOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddLFTagsToResourceOp(
      request: AddLfTagsToResourceRequest
    ) extends LakeFormationOp[AddLfTagsToResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddLfTagsToResourceResponse] =
        visitor.addLFTagsToResource(request)
    }

    final case class BatchGrantPermissionsOp(
      request: BatchGrantPermissionsRequest
    ) extends LakeFormationOp[BatchGrantPermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGrantPermissionsResponse] =
        visitor.batchGrantPermissions(request)
    }

    final case class BatchRevokePermissionsOp(
      request: BatchRevokePermissionsRequest
    ) extends LakeFormationOp[BatchRevokePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchRevokePermissionsResponse] =
        visitor.batchRevokePermissions(request)
    }

    final case class CreateLFTagOp(
      request: CreateLfTagRequest
    ) extends LakeFormationOp[CreateLfTagResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLfTagResponse] =
        visitor.createLFTag(request)
    }

    final case class DeleteLFTagOp(
      request: DeleteLfTagRequest
    ) extends LakeFormationOp[DeleteLfTagResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLfTagResponse] =
        visitor.deleteLFTag(request)
    }

    final case class DeregisterResourceOp(
      request: DeregisterResourceRequest
    ) extends LakeFormationOp[DeregisterResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterResourceResponse] =
        visitor.deregisterResource(request)
    }

    final case class DescribeResourceOp(
      request: DescribeResourceRequest
    ) extends LakeFormationOp[DescribeResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeResourceResponse] =
        visitor.describeResource(request)
    }

    final case class GetDataLakeSettingsOp(
      request: GetDataLakeSettingsRequest
    ) extends LakeFormationOp[GetDataLakeSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDataLakeSettingsResponse] =
        visitor.getDataLakeSettings(request)
    }

    final case class GetEffectivePermissionsForPathOp(
      request: GetEffectivePermissionsForPathRequest
    ) extends LakeFormationOp[GetEffectivePermissionsForPathResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEffectivePermissionsForPathResponse] =
        visitor.getEffectivePermissionsForPath(request)
    }

    final case class GetLFTagOp(
      request: GetLfTagRequest
    ) extends LakeFormationOp[GetLfTagResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLfTagResponse] =
        visitor.getLFTag(request)
    }

    final case class GetResourceLFTagsOp(
      request: GetResourceLfTagsRequest
    ) extends LakeFormationOp[GetResourceLfTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourceLfTagsResponse] =
        visitor.getResourceLFTags(request)
    }

    final case class GrantPermissionsOp(
      request: GrantPermissionsRequest
    ) extends LakeFormationOp[GrantPermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GrantPermissionsResponse] =
        visitor.grantPermissions(request)
    }

    final case class ListLFTagsOp(
      request: ListLfTagsRequest
    ) extends LakeFormationOp[ListLfTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLfTagsResponse] =
        visitor.listLFTags(request)
    }

    final case class ListPermissionsOp(
      request: ListPermissionsRequest
    ) extends LakeFormationOp[ListPermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPermissionsResponse] =
        visitor.listPermissions(request)
    }

    final case class ListResourcesOp(
      request: ListResourcesRequest
    ) extends LakeFormationOp[ListResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResourcesResponse] =
        visitor.listResources(request)
    }

    final case class PutDataLakeSettingsOp(
      request: PutDataLakeSettingsRequest
    ) extends LakeFormationOp[PutDataLakeSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutDataLakeSettingsResponse] =
        visitor.putDataLakeSettings(request)
    }

    final case class RegisterResourceOp(
      request: RegisterResourceRequest
    ) extends LakeFormationOp[RegisterResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterResourceResponse] =
        visitor.registerResource(request)
    }

    final case class RemoveLFTagsFromResourceOp(
      request: RemoveLfTagsFromResourceRequest
    ) extends LakeFormationOp[RemoveLfTagsFromResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveLfTagsFromResourceResponse] =
        visitor.removeLFTagsFromResource(request)
    }

    final case class RevokePermissionsOp(
      request: RevokePermissionsRequest
    ) extends LakeFormationOp[RevokePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RevokePermissionsResponse] =
        visitor.revokePermissions(request)
    }

    final case class SearchDatabasesByLFTagsOp(
      request: SearchDatabasesByLfTagsRequest
    ) extends LakeFormationOp[SearchDatabasesByLfTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchDatabasesByLfTagsResponse] =
        visitor.searchDatabasesByLFTags(request)
    }

    final case class SearchTablesByLFTagsOp(
      request: SearchTablesByLfTagsRequest
    ) extends LakeFormationOp[SearchTablesByLfTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchTablesByLfTagsResponse] =
        visitor.searchTablesByLFTags(request)
    }

    final case class UpdateLFTagOp(
      request: UpdateLfTagRequest
    ) extends LakeFormationOp[UpdateLfTagResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLfTagResponse] =
        visitor.updateLFTag(request)
    }

    final case class UpdateResourceOp(
      request: UpdateResourceRequest
    ) extends LakeFormationOp[UpdateResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateResourceResponse] =
        visitor.updateResource(request)
    }
  }

  import LakeFormationOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[LakeFormationOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addLFTagsToResource(
    request: AddLfTagsToResourceRequest
  ): LakeFormationIO[AddLfTagsToResourceResponse] =
    FF.liftF(AddLFTagsToResourceOp(request))

  def batchGrantPermissions(
    request: BatchGrantPermissionsRequest
  ): LakeFormationIO[BatchGrantPermissionsResponse] =
    FF.liftF(BatchGrantPermissionsOp(request))

  def batchRevokePermissions(
    request: BatchRevokePermissionsRequest
  ): LakeFormationIO[BatchRevokePermissionsResponse] =
    FF.liftF(BatchRevokePermissionsOp(request))

  def createLFTag(
    request: CreateLfTagRequest
  ): LakeFormationIO[CreateLfTagResponse] =
    FF.liftF(CreateLFTagOp(request))

  def deleteLFTag(
    request: DeleteLfTagRequest
  ): LakeFormationIO[DeleteLfTagResponse] =
    FF.liftF(DeleteLFTagOp(request))

  def deregisterResource(
    request: DeregisterResourceRequest
  ): LakeFormationIO[DeregisterResourceResponse] =
    FF.liftF(DeregisterResourceOp(request))

  def describeResource(
    request: DescribeResourceRequest
  ): LakeFormationIO[DescribeResourceResponse] =
    FF.liftF(DescribeResourceOp(request))

  def getDataLakeSettings(
    request: GetDataLakeSettingsRequest
  ): LakeFormationIO[GetDataLakeSettingsResponse] =
    FF.liftF(GetDataLakeSettingsOp(request))

  def getEffectivePermissionsForPath(
    request: GetEffectivePermissionsForPathRequest
  ): LakeFormationIO[GetEffectivePermissionsForPathResponse] =
    FF.liftF(GetEffectivePermissionsForPathOp(request))

  def getLFTag(
    request: GetLfTagRequest
  ): LakeFormationIO[GetLfTagResponse] =
    FF.liftF(GetLFTagOp(request))

  def getResourceLFTags(
    request: GetResourceLfTagsRequest
  ): LakeFormationIO[GetResourceLfTagsResponse] =
    FF.liftF(GetResourceLFTagsOp(request))

  def grantPermissions(
    request: GrantPermissionsRequest
  ): LakeFormationIO[GrantPermissionsResponse] =
    FF.liftF(GrantPermissionsOp(request))

  def listLFTags(
    request: ListLfTagsRequest
  ): LakeFormationIO[ListLfTagsResponse] =
    FF.liftF(ListLFTagsOp(request))

  def listPermissions(
    request: ListPermissionsRequest
  ): LakeFormationIO[ListPermissionsResponse] =
    FF.liftF(ListPermissionsOp(request))

  def listResources(
    request: ListResourcesRequest
  ): LakeFormationIO[ListResourcesResponse] =
    FF.liftF(ListResourcesOp(request))

  def putDataLakeSettings(
    request: PutDataLakeSettingsRequest
  ): LakeFormationIO[PutDataLakeSettingsResponse] =
    FF.liftF(PutDataLakeSettingsOp(request))

  def registerResource(
    request: RegisterResourceRequest
  ): LakeFormationIO[RegisterResourceResponse] =
    FF.liftF(RegisterResourceOp(request))

  def removeLFTagsFromResource(
    request: RemoveLfTagsFromResourceRequest
  ): LakeFormationIO[RemoveLfTagsFromResourceResponse] =
    FF.liftF(RemoveLFTagsFromResourceOp(request))

  def revokePermissions(
    request: RevokePermissionsRequest
  ): LakeFormationIO[RevokePermissionsResponse] =
    FF.liftF(RevokePermissionsOp(request))

  def searchDatabasesByLFTags(
    request: SearchDatabasesByLfTagsRequest
  ): LakeFormationIO[SearchDatabasesByLfTagsResponse] =
    FF.liftF(SearchDatabasesByLFTagsOp(request))

  def searchTablesByLFTags(
    request: SearchTablesByLfTagsRequest
  ): LakeFormationIO[SearchTablesByLfTagsResponse] =
    FF.liftF(SearchTablesByLFTagsOp(request))

  def updateLFTag(
    request: UpdateLfTagRequest
  ): LakeFormationIO[UpdateLfTagResponse] =
    FF.liftF(UpdateLFTagOp(request))

  def updateResource(
    request: UpdateResourceRequest
  ): LakeFormationIO[UpdateResourceResponse] =
    FF.liftF(UpdateResourceOp(request))
}
