package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.clouddirectory.CloudDirectoryClient
import software.amazon.awssdk.services.clouddirectory.model._


object clouddirectory { module =>

  // Free monad over CloudDirectoryOp
  type CloudDirectoryIO[A] = FF[CloudDirectoryOp, A]

  sealed trait CloudDirectoryOp[A] {
    def visit[F[_]](visitor: CloudDirectoryOp.Visitor[F]): F[A]
  }

  object CloudDirectoryOp {
    // Given a CloudDirectoryClient we can embed a CloudDirectoryIO program in any algebra that understands embedding.
    implicit val CloudDirectoryOpEmbeddable: Embeddable[CloudDirectoryOp, CloudDirectoryClient] = new Embeddable[CloudDirectoryOp, CloudDirectoryClient] {
      def embed[A](client: CloudDirectoryClient, io: CloudDirectoryIO[A]): Embedded[A] = Embedded.CloudDirectory(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CloudDirectoryOp.Visitor[Kleisli[M, CloudDirectoryClient, *]] {
        def addFacetToObject(
          request: AddFacetToObjectRequest
        ): Kleisli[M, CloudDirectoryClient, AddFacetToObjectResponse] =
          primitive(_.addFacetToObject(request))

        def applySchema(
          request: ApplySchemaRequest
        ): Kleisli[M, CloudDirectoryClient, ApplySchemaResponse] =
          primitive(_.applySchema(request))

        def attachObject(
          request: AttachObjectRequest
        ): Kleisli[M, CloudDirectoryClient, AttachObjectResponse] =
          primitive(_.attachObject(request))

        def attachPolicy(
          request: AttachPolicyRequest
        ): Kleisli[M, CloudDirectoryClient, AttachPolicyResponse] =
          primitive(_.attachPolicy(request))

        def attachToIndex(
          request: AttachToIndexRequest
        ): Kleisli[M, CloudDirectoryClient, AttachToIndexResponse] =
          primitive(_.attachToIndex(request))

        def attachTypedLink(
          request: AttachTypedLinkRequest
        ): Kleisli[M, CloudDirectoryClient, AttachTypedLinkResponse] =
          primitive(_.attachTypedLink(request))

        def batchRead(
          request: BatchReadRequest
        ): Kleisli[M, CloudDirectoryClient, BatchReadResponse] =
          primitive(_.batchRead(request))

        def batchWrite(
          request: BatchWriteRequest
        ): Kleisli[M, CloudDirectoryClient, BatchWriteResponse] =
          primitive(_.batchWrite(request))

        def createDirectory(
          request: CreateDirectoryRequest
        ): Kleisli[M, CloudDirectoryClient, CreateDirectoryResponse] =
          primitive(_.createDirectory(request))

        def createFacet(
          request: CreateFacetRequest
        ): Kleisli[M, CloudDirectoryClient, CreateFacetResponse] =
          primitive(_.createFacet(request))

        def createIndex(
          request: CreateIndexRequest
        ): Kleisli[M, CloudDirectoryClient, CreateIndexResponse] =
          primitive(_.createIndex(request))

        def createObject(
          request: CreateObjectRequest
        ): Kleisli[M, CloudDirectoryClient, CreateObjectResponse] =
          primitive(_.createObject(request))

        def createSchema(
          request: CreateSchemaRequest
        ): Kleisli[M, CloudDirectoryClient, CreateSchemaResponse] =
          primitive(_.createSchema(request))

        def createTypedLinkFacet(
          request: CreateTypedLinkFacetRequest
        ): Kleisli[M, CloudDirectoryClient, CreateTypedLinkFacetResponse] =
          primitive(_.createTypedLinkFacet(request))

        def deleteDirectory(
          request: DeleteDirectoryRequest
        ): Kleisli[M, CloudDirectoryClient, DeleteDirectoryResponse] =
          primitive(_.deleteDirectory(request))

        def deleteFacet(
          request: DeleteFacetRequest
        ): Kleisli[M, CloudDirectoryClient, DeleteFacetResponse] =
          primitive(_.deleteFacet(request))

        def deleteObject(
          request: DeleteObjectRequest
        ): Kleisli[M, CloudDirectoryClient, DeleteObjectResponse] =
          primitive(_.deleteObject(request))

        def deleteSchema(
          request: DeleteSchemaRequest
        ): Kleisli[M, CloudDirectoryClient, DeleteSchemaResponse] =
          primitive(_.deleteSchema(request))

        def deleteTypedLinkFacet(
          request: DeleteTypedLinkFacetRequest
        ): Kleisli[M, CloudDirectoryClient, DeleteTypedLinkFacetResponse] =
          primitive(_.deleteTypedLinkFacet(request))

        def detachFromIndex(
          request: DetachFromIndexRequest
        ): Kleisli[M, CloudDirectoryClient, DetachFromIndexResponse] =
          primitive(_.detachFromIndex(request))

        def detachObject(
          request: DetachObjectRequest
        ): Kleisli[M, CloudDirectoryClient, DetachObjectResponse] =
          primitive(_.detachObject(request))

        def detachPolicy(
          request: DetachPolicyRequest
        ): Kleisli[M, CloudDirectoryClient, DetachPolicyResponse] =
          primitive(_.detachPolicy(request))

        def detachTypedLink(
          request: DetachTypedLinkRequest
        ): Kleisli[M, CloudDirectoryClient, DetachTypedLinkResponse] =
          primitive(_.detachTypedLink(request))

        def disableDirectory(
          request: DisableDirectoryRequest
        ): Kleisli[M, CloudDirectoryClient, DisableDirectoryResponse] =
          primitive(_.disableDirectory(request))

        def enableDirectory(
          request: EnableDirectoryRequest
        ): Kleisli[M, CloudDirectoryClient, EnableDirectoryResponse] =
          primitive(_.enableDirectory(request))

        def getAppliedSchemaVersion(
          request: GetAppliedSchemaVersionRequest
        ): Kleisli[M, CloudDirectoryClient, GetAppliedSchemaVersionResponse] =
          primitive(_.getAppliedSchemaVersion(request))

        def getDirectory(
          request: GetDirectoryRequest
        ): Kleisli[M, CloudDirectoryClient, GetDirectoryResponse] =
          primitive(_.getDirectory(request))

        def getFacet(
          request: GetFacetRequest
        ): Kleisli[M, CloudDirectoryClient, GetFacetResponse] =
          primitive(_.getFacet(request))

        def getLinkAttributes(
          request: GetLinkAttributesRequest
        ): Kleisli[M, CloudDirectoryClient, GetLinkAttributesResponse] =
          primitive(_.getLinkAttributes(request))

        def getObjectAttributes(
          request: GetObjectAttributesRequest
        ): Kleisli[M, CloudDirectoryClient, GetObjectAttributesResponse] =
          primitive(_.getObjectAttributes(request))

        def getObjectInformation(
          request: GetObjectInformationRequest
        ): Kleisli[M, CloudDirectoryClient, GetObjectInformationResponse] =
          primitive(_.getObjectInformation(request))

        def getSchemaAsJson(
          request: GetSchemaAsJsonRequest
        ): Kleisli[M, CloudDirectoryClient, GetSchemaAsJsonResponse] =
          primitive(_.getSchemaAsJson(request))

        def getTypedLinkFacetInformation(
          request: GetTypedLinkFacetInformationRequest
        ): Kleisli[M, CloudDirectoryClient, GetTypedLinkFacetInformationResponse] =
          primitive(_.getTypedLinkFacetInformation(request))

        def listAppliedSchemaArns(
          request: ListAppliedSchemaArnsRequest
        ): Kleisli[M, CloudDirectoryClient, ListAppliedSchemaArnsResponse] =
          primitive(_.listAppliedSchemaArns(request))

        def listAttachedIndices(
          request: ListAttachedIndicesRequest
        ): Kleisli[M, CloudDirectoryClient, ListAttachedIndicesResponse] =
          primitive(_.listAttachedIndices(request))

        def listDevelopmentSchemaArns(
          request: ListDevelopmentSchemaArnsRequest
        ): Kleisli[M, CloudDirectoryClient, ListDevelopmentSchemaArnsResponse] =
          primitive(_.listDevelopmentSchemaArns(request))

        def listDirectories(
          request: ListDirectoriesRequest
        ): Kleisli[M, CloudDirectoryClient, ListDirectoriesResponse] =
          primitive(_.listDirectories(request))

        def listFacetAttributes(
          request: ListFacetAttributesRequest
        ): Kleisli[M, CloudDirectoryClient, ListFacetAttributesResponse] =
          primitive(_.listFacetAttributes(request))

        def listFacetNames(
          request: ListFacetNamesRequest
        ): Kleisli[M, CloudDirectoryClient, ListFacetNamesResponse] =
          primitive(_.listFacetNames(request))

        def listIncomingTypedLinks(
          request: ListIncomingTypedLinksRequest
        ): Kleisli[M, CloudDirectoryClient, ListIncomingTypedLinksResponse] =
          primitive(_.listIncomingTypedLinks(request))

        def listIndex(
          request: ListIndexRequest
        ): Kleisli[M, CloudDirectoryClient, ListIndexResponse] =
          primitive(_.listIndex(request))

        def listManagedSchemaArns(
          request: ListManagedSchemaArnsRequest
        ): Kleisli[M, CloudDirectoryClient, ListManagedSchemaArnsResponse] =
          primitive(_.listManagedSchemaArns(request))

        def listObjectAttributes(
          request: ListObjectAttributesRequest
        ): Kleisli[M, CloudDirectoryClient, ListObjectAttributesResponse] =
          primitive(_.listObjectAttributes(request))

        def listObjectChildren(
          request: ListObjectChildrenRequest
        ): Kleisli[M, CloudDirectoryClient, ListObjectChildrenResponse] =
          primitive(_.listObjectChildren(request))

        def listObjectParentPaths(
          request: ListObjectParentPathsRequest
        ): Kleisli[M, CloudDirectoryClient, ListObjectParentPathsResponse] =
          primitive(_.listObjectParentPaths(request))

        def listObjectParents(
          request: ListObjectParentsRequest
        ): Kleisli[M, CloudDirectoryClient, ListObjectParentsResponse] =
          primitive(_.listObjectParents(request))

        def listObjectPolicies(
          request: ListObjectPoliciesRequest
        ): Kleisli[M, CloudDirectoryClient, ListObjectPoliciesResponse] =
          primitive(_.listObjectPolicies(request))

        def listOutgoingTypedLinks(
          request: ListOutgoingTypedLinksRequest
        ): Kleisli[M, CloudDirectoryClient, ListOutgoingTypedLinksResponse] =
          primitive(_.listOutgoingTypedLinks(request))

        def listPolicyAttachments(
          request: ListPolicyAttachmentsRequest
        ): Kleisli[M, CloudDirectoryClient, ListPolicyAttachmentsResponse] =
          primitive(_.listPolicyAttachments(request))

        def listPublishedSchemaArns(
          request: ListPublishedSchemaArnsRequest
        ): Kleisli[M, CloudDirectoryClient, ListPublishedSchemaArnsResponse] =
          primitive(_.listPublishedSchemaArns(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, CloudDirectoryClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTypedLinkFacetAttributes(
          request: ListTypedLinkFacetAttributesRequest
        ): Kleisli[M, CloudDirectoryClient, ListTypedLinkFacetAttributesResponse] =
          primitive(_.listTypedLinkFacetAttributes(request))

        def listTypedLinkFacetNames(
          request: ListTypedLinkFacetNamesRequest
        ): Kleisli[M, CloudDirectoryClient, ListTypedLinkFacetNamesResponse] =
          primitive(_.listTypedLinkFacetNames(request))

        def lookupPolicy(
          request: LookupPolicyRequest
        ): Kleisli[M, CloudDirectoryClient, LookupPolicyResponse] =
          primitive(_.lookupPolicy(request))

        def publishSchema(
          request: PublishSchemaRequest
        ): Kleisli[M, CloudDirectoryClient, PublishSchemaResponse] =
          primitive(_.publishSchema(request))

        def putSchemaFromJson(
          request: PutSchemaFromJsonRequest
        ): Kleisli[M, CloudDirectoryClient, PutSchemaFromJsonResponse] =
          primitive(_.putSchemaFromJson(request))

        def removeFacetFromObject(
          request: RemoveFacetFromObjectRequest
        ): Kleisli[M, CloudDirectoryClient, RemoveFacetFromObjectResponse] =
          primitive(_.removeFacetFromObject(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, CloudDirectoryClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, CloudDirectoryClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateFacet(
          request: UpdateFacetRequest
        ): Kleisli[M, CloudDirectoryClient, UpdateFacetResponse] =
          primitive(_.updateFacet(request))

        def updateLinkAttributes(
          request: UpdateLinkAttributesRequest
        ): Kleisli[M, CloudDirectoryClient, UpdateLinkAttributesResponse] =
          primitive(_.updateLinkAttributes(request))

        def updateObjectAttributes(
          request: UpdateObjectAttributesRequest
        ): Kleisli[M, CloudDirectoryClient, UpdateObjectAttributesResponse] =
          primitive(_.updateObjectAttributes(request))

        def updateSchema(
          request: UpdateSchemaRequest
        ): Kleisli[M, CloudDirectoryClient, UpdateSchemaResponse] =
          primitive(_.updateSchema(request))

        def updateTypedLinkFacet(
          request: UpdateTypedLinkFacetRequest
        ): Kleisli[M, CloudDirectoryClient, UpdateTypedLinkFacetResponse] =
          primitive(_.updateTypedLinkFacet(request))

        def upgradeAppliedSchema(
          request: UpgradeAppliedSchemaRequest
        ): Kleisli[M, CloudDirectoryClient, UpgradeAppliedSchemaResponse] =
          primitive(_.upgradeAppliedSchema(request))

        def upgradePublishedSchema(
          request: UpgradePublishedSchemaRequest
        ): Kleisli[M, CloudDirectoryClient, UpgradePublishedSchemaResponse] =
          primitive(_.upgradePublishedSchema(request))

        def primitive[A](
          f: CloudDirectoryClient => A
        ): Kleisli[M, CloudDirectoryClient, A]
      }
    }

    trait Visitor[F[_]] extends (CloudDirectoryOp ~> F) {
      final def apply[A](op: CloudDirectoryOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addFacetToObject(
        request: AddFacetToObjectRequest
      ): F[AddFacetToObjectResponse]

      def applySchema(
        request: ApplySchemaRequest
      ): F[ApplySchemaResponse]

      def attachObject(
        request: AttachObjectRequest
      ): F[AttachObjectResponse]

      def attachPolicy(
        request: AttachPolicyRequest
      ): F[AttachPolicyResponse]

      def attachToIndex(
        request: AttachToIndexRequest
      ): F[AttachToIndexResponse]

      def attachTypedLink(
        request: AttachTypedLinkRequest
      ): F[AttachTypedLinkResponse]

      def batchRead(
        request: BatchReadRequest
      ): F[BatchReadResponse]

      def batchWrite(
        request: BatchWriteRequest
      ): F[BatchWriteResponse]

      def createDirectory(
        request: CreateDirectoryRequest
      ): F[CreateDirectoryResponse]

      def createFacet(
        request: CreateFacetRequest
      ): F[CreateFacetResponse]

      def createIndex(
        request: CreateIndexRequest
      ): F[CreateIndexResponse]

      def createObject(
        request: CreateObjectRequest
      ): F[CreateObjectResponse]

      def createSchema(
        request: CreateSchemaRequest
      ): F[CreateSchemaResponse]

      def createTypedLinkFacet(
        request: CreateTypedLinkFacetRequest
      ): F[CreateTypedLinkFacetResponse]

      def deleteDirectory(
        request: DeleteDirectoryRequest
      ): F[DeleteDirectoryResponse]

      def deleteFacet(
        request: DeleteFacetRequest
      ): F[DeleteFacetResponse]

      def deleteObject(
        request: DeleteObjectRequest
      ): F[DeleteObjectResponse]

      def deleteSchema(
        request: DeleteSchemaRequest
      ): F[DeleteSchemaResponse]

      def deleteTypedLinkFacet(
        request: DeleteTypedLinkFacetRequest
      ): F[DeleteTypedLinkFacetResponse]

      def detachFromIndex(
        request: DetachFromIndexRequest
      ): F[DetachFromIndexResponse]

      def detachObject(
        request: DetachObjectRequest
      ): F[DetachObjectResponse]

      def detachPolicy(
        request: DetachPolicyRequest
      ): F[DetachPolicyResponse]

      def detachTypedLink(
        request: DetachTypedLinkRequest
      ): F[DetachTypedLinkResponse]

      def disableDirectory(
        request: DisableDirectoryRequest
      ): F[DisableDirectoryResponse]

      def enableDirectory(
        request: EnableDirectoryRequest
      ): F[EnableDirectoryResponse]

      def getAppliedSchemaVersion(
        request: GetAppliedSchemaVersionRequest
      ): F[GetAppliedSchemaVersionResponse]

      def getDirectory(
        request: GetDirectoryRequest
      ): F[GetDirectoryResponse]

      def getFacet(
        request: GetFacetRequest
      ): F[GetFacetResponse]

      def getLinkAttributes(
        request: GetLinkAttributesRequest
      ): F[GetLinkAttributesResponse]

      def getObjectAttributes(
        request: GetObjectAttributesRequest
      ): F[GetObjectAttributesResponse]

      def getObjectInformation(
        request: GetObjectInformationRequest
      ): F[GetObjectInformationResponse]

      def getSchemaAsJson(
        request: GetSchemaAsJsonRequest
      ): F[GetSchemaAsJsonResponse]

      def getTypedLinkFacetInformation(
        request: GetTypedLinkFacetInformationRequest
      ): F[GetTypedLinkFacetInformationResponse]

      def listAppliedSchemaArns(
        request: ListAppliedSchemaArnsRequest
      ): F[ListAppliedSchemaArnsResponse]

      def listAttachedIndices(
        request: ListAttachedIndicesRequest
      ): F[ListAttachedIndicesResponse]

      def listDevelopmentSchemaArns(
        request: ListDevelopmentSchemaArnsRequest
      ): F[ListDevelopmentSchemaArnsResponse]

      def listDirectories(
        request: ListDirectoriesRequest
      ): F[ListDirectoriesResponse]

      def listFacetAttributes(
        request: ListFacetAttributesRequest
      ): F[ListFacetAttributesResponse]

      def listFacetNames(
        request: ListFacetNamesRequest
      ): F[ListFacetNamesResponse]

      def listIncomingTypedLinks(
        request: ListIncomingTypedLinksRequest
      ): F[ListIncomingTypedLinksResponse]

      def listIndex(
        request: ListIndexRequest
      ): F[ListIndexResponse]

      def listManagedSchemaArns(
        request: ListManagedSchemaArnsRequest
      ): F[ListManagedSchemaArnsResponse]

      def listObjectAttributes(
        request: ListObjectAttributesRequest
      ): F[ListObjectAttributesResponse]

      def listObjectChildren(
        request: ListObjectChildrenRequest
      ): F[ListObjectChildrenResponse]

      def listObjectParentPaths(
        request: ListObjectParentPathsRequest
      ): F[ListObjectParentPathsResponse]

      def listObjectParents(
        request: ListObjectParentsRequest
      ): F[ListObjectParentsResponse]

      def listObjectPolicies(
        request: ListObjectPoliciesRequest
      ): F[ListObjectPoliciesResponse]

      def listOutgoingTypedLinks(
        request: ListOutgoingTypedLinksRequest
      ): F[ListOutgoingTypedLinksResponse]

      def listPolicyAttachments(
        request: ListPolicyAttachmentsRequest
      ): F[ListPolicyAttachmentsResponse]

      def listPublishedSchemaArns(
        request: ListPublishedSchemaArnsRequest
      ): F[ListPublishedSchemaArnsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTypedLinkFacetAttributes(
        request: ListTypedLinkFacetAttributesRequest
      ): F[ListTypedLinkFacetAttributesResponse]

      def listTypedLinkFacetNames(
        request: ListTypedLinkFacetNamesRequest
      ): F[ListTypedLinkFacetNamesResponse]

      def lookupPolicy(
        request: LookupPolicyRequest
      ): F[LookupPolicyResponse]

      def publishSchema(
        request: PublishSchemaRequest
      ): F[PublishSchemaResponse]

      def putSchemaFromJson(
        request: PutSchemaFromJsonRequest
      ): F[PutSchemaFromJsonResponse]

      def removeFacetFromObject(
        request: RemoveFacetFromObjectRequest
      ): F[RemoveFacetFromObjectResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateFacet(
        request: UpdateFacetRequest
      ): F[UpdateFacetResponse]

      def updateLinkAttributes(
        request: UpdateLinkAttributesRequest
      ): F[UpdateLinkAttributesResponse]

      def updateObjectAttributes(
        request: UpdateObjectAttributesRequest
      ): F[UpdateObjectAttributesResponse]

      def updateSchema(
        request: UpdateSchemaRequest
      ): F[UpdateSchemaResponse]

      def updateTypedLinkFacet(
        request: UpdateTypedLinkFacetRequest
      ): F[UpdateTypedLinkFacetResponse]

      def upgradeAppliedSchema(
        request: UpgradeAppliedSchemaRequest
      ): F[UpgradeAppliedSchemaResponse]

      def upgradePublishedSchema(
        request: UpgradePublishedSchemaRequest
      ): F[UpgradePublishedSchemaResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CloudDirectoryOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddFacetToObjectOp(
      request: AddFacetToObjectRequest
    ) extends CloudDirectoryOp[AddFacetToObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddFacetToObjectResponse] =
        visitor.addFacetToObject(request)
    }

    final case class ApplySchemaOp(
      request: ApplySchemaRequest
    ) extends CloudDirectoryOp[ApplySchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ApplySchemaResponse] =
        visitor.applySchema(request)
    }

    final case class AttachObjectOp(
      request: AttachObjectRequest
    ) extends CloudDirectoryOp[AttachObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachObjectResponse] =
        visitor.attachObject(request)
    }

    final case class AttachPolicyOp(
      request: AttachPolicyRequest
    ) extends CloudDirectoryOp[AttachPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachPolicyResponse] =
        visitor.attachPolicy(request)
    }

    final case class AttachToIndexOp(
      request: AttachToIndexRequest
    ) extends CloudDirectoryOp[AttachToIndexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachToIndexResponse] =
        visitor.attachToIndex(request)
    }

    final case class AttachTypedLinkOp(
      request: AttachTypedLinkRequest
    ) extends CloudDirectoryOp[AttachTypedLinkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachTypedLinkResponse] =
        visitor.attachTypedLink(request)
    }

    final case class BatchReadOp(
      request: BatchReadRequest
    ) extends CloudDirectoryOp[BatchReadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchReadResponse] =
        visitor.batchRead(request)
    }

    final case class BatchWriteOp(
      request: BatchWriteRequest
    ) extends CloudDirectoryOp[BatchWriteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchWriteResponse] =
        visitor.batchWrite(request)
    }

    final case class CreateDirectoryOp(
      request: CreateDirectoryRequest
    ) extends CloudDirectoryOp[CreateDirectoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDirectoryResponse] =
        visitor.createDirectory(request)
    }

    final case class CreateFacetOp(
      request: CreateFacetRequest
    ) extends CloudDirectoryOp[CreateFacetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFacetResponse] =
        visitor.createFacet(request)
    }

    final case class CreateIndexOp(
      request: CreateIndexRequest
    ) extends CloudDirectoryOp[CreateIndexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateIndexResponse] =
        visitor.createIndex(request)
    }

    final case class CreateObjectOp(
      request: CreateObjectRequest
    ) extends CloudDirectoryOp[CreateObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateObjectResponse] =
        visitor.createObject(request)
    }

    final case class CreateSchemaOp(
      request: CreateSchemaRequest
    ) extends CloudDirectoryOp[CreateSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSchemaResponse] =
        visitor.createSchema(request)
    }

    final case class CreateTypedLinkFacetOp(
      request: CreateTypedLinkFacetRequest
    ) extends CloudDirectoryOp[CreateTypedLinkFacetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTypedLinkFacetResponse] =
        visitor.createTypedLinkFacet(request)
    }

    final case class DeleteDirectoryOp(
      request: DeleteDirectoryRequest
    ) extends CloudDirectoryOp[DeleteDirectoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDirectoryResponse] =
        visitor.deleteDirectory(request)
    }

    final case class DeleteFacetOp(
      request: DeleteFacetRequest
    ) extends CloudDirectoryOp[DeleteFacetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFacetResponse] =
        visitor.deleteFacet(request)
    }

    final case class DeleteObjectOp(
      request: DeleteObjectRequest
    ) extends CloudDirectoryOp[DeleteObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteObjectResponse] =
        visitor.deleteObject(request)
    }

    final case class DeleteSchemaOp(
      request: DeleteSchemaRequest
    ) extends CloudDirectoryOp[DeleteSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSchemaResponse] =
        visitor.deleteSchema(request)
    }

    final case class DeleteTypedLinkFacetOp(
      request: DeleteTypedLinkFacetRequest
    ) extends CloudDirectoryOp[DeleteTypedLinkFacetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTypedLinkFacetResponse] =
        visitor.deleteTypedLinkFacet(request)
    }

    final case class DetachFromIndexOp(
      request: DetachFromIndexRequest
    ) extends CloudDirectoryOp[DetachFromIndexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachFromIndexResponse] =
        visitor.detachFromIndex(request)
    }

    final case class DetachObjectOp(
      request: DetachObjectRequest
    ) extends CloudDirectoryOp[DetachObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachObjectResponse] =
        visitor.detachObject(request)
    }

    final case class DetachPolicyOp(
      request: DetachPolicyRequest
    ) extends CloudDirectoryOp[DetachPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachPolicyResponse] =
        visitor.detachPolicy(request)
    }

    final case class DetachTypedLinkOp(
      request: DetachTypedLinkRequest
    ) extends CloudDirectoryOp[DetachTypedLinkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachTypedLinkResponse] =
        visitor.detachTypedLink(request)
    }

    final case class DisableDirectoryOp(
      request: DisableDirectoryRequest
    ) extends CloudDirectoryOp[DisableDirectoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableDirectoryResponse] =
        visitor.disableDirectory(request)
    }

    final case class EnableDirectoryOp(
      request: EnableDirectoryRequest
    ) extends CloudDirectoryOp[EnableDirectoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableDirectoryResponse] =
        visitor.enableDirectory(request)
    }

    final case class GetAppliedSchemaVersionOp(
      request: GetAppliedSchemaVersionRequest
    ) extends CloudDirectoryOp[GetAppliedSchemaVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAppliedSchemaVersionResponse] =
        visitor.getAppliedSchemaVersion(request)
    }

    final case class GetDirectoryOp(
      request: GetDirectoryRequest
    ) extends CloudDirectoryOp[GetDirectoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDirectoryResponse] =
        visitor.getDirectory(request)
    }

    final case class GetFacetOp(
      request: GetFacetRequest
    ) extends CloudDirectoryOp[GetFacetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFacetResponse] =
        visitor.getFacet(request)
    }

    final case class GetLinkAttributesOp(
      request: GetLinkAttributesRequest
    ) extends CloudDirectoryOp[GetLinkAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLinkAttributesResponse] =
        visitor.getLinkAttributes(request)
    }

    final case class GetObjectAttributesOp(
      request: GetObjectAttributesRequest
    ) extends CloudDirectoryOp[GetObjectAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetObjectAttributesResponse] =
        visitor.getObjectAttributes(request)
    }

    final case class GetObjectInformationOp(
      request: GetObjectInformationRequest
    ) extends CloudDirectoryOp[GetObjectInformationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetObjectInformationResponse] =
        visitor.getObjectInformation(request)
    }

    final case class GetSchemaAsJsonOp(
      request: GetSchemaAsJsonRequest
    ) extends CloudDirectoryOp[GetSchemaAsJsonResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSchemaAsJsonResponse] =
        visitor.getSchemaAsJson(request)
    }

    final case class GetTypedLinkFacetInformationOp(
      request: GetTypedLinkFacetInformationRequest
    ) extends CloudDirectoryOp[GetTypedLinkFacetInformationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTypedLinkFacetInformationResponse] =
        visitor.getTypedLinkFacetInformation(request)
    }

    final case class ListAppliedSchemaArnsOp(
      request: ListAppliedSchemaArnsRequest
    ) extends CloudDirectoryOp[ListAppliedSchemaArnsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAppliedSchemaArnsResponse] =
        visitor.listAppliedSchemaArns(request)
    }

    final case class ListAttachedIndicesOp(
      request: ListAttachedIndicesRequest
    ) extends CloudDirectoryOp[ListAttachedIndicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAttachedIndicesResponse] =
        visitor.listAttachedIndices(request)
    }

    final case class ListDevelopmentSchemaArnsOp(
      request: ListDevelopmentSchemaArnsRequest
    ) extends CloudDirectoryOp[ListDevelopmentSchemaArnsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDevelopmentSchemaArnsResponse] =
        visitor.listDevelopmentSchemaArns(request)
    }

    final case class ListDirectoriesOp(
      request: ListDirectoriesRequest
    ) extends CloudDirectoryOp[ListDirectoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDirectoriesResponse] =
        visitor.listDirectories(request)
    }

    final case class ListFacetAttributesOp(
      request: ListFacetAttributesRequest
    ) extends CloudDirectoryOp[ListFacetAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFacetAttributesResponse] =
        visitor.listFacetAttributes(request)
    }

    final case class ListFacetNamesOp(
      request: ListFacetNamesRequest
    ) extends CloudDirectoryOp[ListFacetNamesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFacetNamesResponse] =
        visitor.listFacetNames(request)
    }

    final case class ListIncomingTypedLinksOp(
      request: ListIncomingTypedLinksRequest
    ) extends CloudDirectoryOp[ListIncomingTypedLinksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIncomingTypedLinksResponse] =
        visitor.listIncomingTypedLinks(request)
    }

    final case class ListIndexOp(
      request: ListIndexRequest
    ) extends CloudDirectoryOp[ListIndexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIndexResponse] =
        visitor.listIndex(request)
    }

    final case class ListManagedSchemaArnsOp(
      request: ListManagedSchemaArnsRequest
    ) extends CloudDirectoryOp[ListManagedSchemaArnsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListManagedSchemaArnsResponse] =
        visitor.listManagedSchemaArns(request)
    }

    final case class ListObjectAttributesOp(
      request: ListObjectAttributesRequest
    ) extends CloudDirectoryOp[ListObjectAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListObjectAttributesResponse] =
        visitor.listObjectAttributes(request)
    }

    final case class ListObjectChildrenOp(
      request: ListObjectChildrenRequest
    ) extends CloudDirectoryOp[ListObjectChildrenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListObjectChildrenResponse] =
        visitor.listObjectChildren(request)
    }

    final case class ListObjectParentPathsOp(
      request: ListObjectParentPathsRequest
    ) extends CloudDirectoryOp[ListObjectParentPathsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListObjectParentPathsResponse] =
        visitor.listObjectParentPaths(request)
    }

    final case class ListObjectParentsOp(
      request: ListObjectParentsRequest
    ) extends CloudDirectoryOp[ListObjectParentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListObjectParentsResponse] =
        visitor.listObjectParents(request)
    }

    final case class ListObjectPoliciesOp(
      request: ListObjectPoliciesRequest
    ) extends CloudDirectoryOp[ListObjectPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListObjectPoliciesResponse] =
        visitor.listObjectPolicies(request)
    }

    final case class ListOutgoingTypedLinksOp(
      request: ListOutgoingTypedLinksRequest
    ) extends CloudDirectoryOp[ListOutgoingTypedLinksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOutgoingTypedLinksResponse] =
        visitor.listOutgoingTypedLinks(request)
    }

    final case class ListPolicyAttachmentsOp(
      request: ListPolicyAttachmentsRequest
    ) extends CloudDirectoryOp[ListPolicyAttachmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPolicyAttachmentsResponse] =
        visitor.listPolicyAttachments(request)
    }

    final case class ListPublishedSchemaArnsOp(
      request: ListPublishedSchemaArnsRequest
    ) extends CloudDirectoryOp[ListPublishedSchemaArnsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPublishedSchemaArnsResponse] =
        visitor.listPublishedSchemaArns(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends CloudDirectoryOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTypedLinkFacetAttributesOp(
      request: ListTypedLinkFacetAttributesRequest
    ) extends CloudDirectoryOp[ListTypedLinkFacetAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTypedLinkFacetAttributesResponse] =
        visitor.listTypedLinkFacetAttributes(request)
    }

    final case class ListTypedLinkFacetNamesOp(
      request: ListTypedLinkFacetNamesRequest
    ) extends CloudDirectoryOp[ListTypedLinkFacetNamesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTypedLinkFacetNamesResponse] =
        visitor.listTypedLinkFacetNames(request)
    }

    final case class LookupPolicyOp(
      request: LookupPolicyRequest
    ) extends CloudDirectoryOp[LookupPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[LookupPolicyResponse] =
        visitor.lookupPolicy(request)
    }

    final case class PublishSchemaOp(
      request: PublishSchemaRequest
    ) extends CloudDirectoryOp[PublishSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PublishSchemaResponse] =
        visitor.publishSchema(request)
    }

    final case class PutSchemaFromJsonOp(
      request: PutSchemaFromJsonRequest
    ) extends CloudDirectoryOp[PutSchemaFromJsonResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutSchemaFromJsonResponse] =
        visitor.putSchemaFromJson(request)
    }

    final case class RemoveFacetFromObjectOp(
      request: RemoveFacetFromObjectRequest
    ) extends CloudDirectoryOp[RemoveFacetFromObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveFacetFromObjectResponse] =
        visitor.removeFacetFromObject(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends CloudDirectoryOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends CloudDirectoryOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateFacetOp(
      request: UpdateFacetRequest
    ) extends CloudDirectoryOp[UpdateFacetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFacetResponse] =
        visitor.updateFacet(request)
    }

    final case class UpdateLinkAttributesOp(
      request: UpdateLinkAttributesRequest
    ) extends CloudDirectoryOp[UpdateLinkAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLinkAttributesResponse] =
        visitor.updateLinkAttributes(request)
    }

    final case class UpdateObjectAttributesOp(
      request: UpdateObjectAttributesRequest
    ) extends CloudDirectoryOp[UpdateObjectAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateObjectAttributesResponse] =
        visitor.updateObjectAttributes(request)
    }

    final case class UpdateSchemaOp(
      request: UpdateSchemaRequest
    ) extends CloudDirectoryOp[UpdateSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSchemaResponse] =
        visitor.updateSchema(request)
    }

    final case class UpdateTypedLinkFacetOp(
      request: UpdateTypedLinkFacetRequest
    ) extends CloudDirectoryOp[UpdateTypedLinkFacetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTypedLinkFacetResponse] =
        visitor.updateTypedLinkFacet(request)
    }

    final case class UpgradeAppliedSchemaOp(
      request: UpgradeAppliedSchemaRequest
    ) extends CloudDirectoryOp[UpgradeAppliedSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpgradeAppliedSchemaResponse] =
        visitor.upgradeAppliedSchema(request)
    }

    final case class UpgradePublishedSchemaOp(
      request: UpgradePublishedSchemaRequest
    ) extends CloudDirectoryOp[UpgradePublishedSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpgradePublishedSchemaResponse] =
        visitor.upgradePublishedSchema(request)
    }
  }

  import CloudDirectoryOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CloudDirectoryOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addFacetToObject(
    request: AddFacetToObjectRequest
  ): CloudDirectoryIO[AddFacetToObjectResponse] =
    FF.liftF(AddFacetToObjectOp(request))

  def applySchema(
    request: ApplySchemaRequest
  ): CloudDirectoryIO[ApplySchemaResponse] =
    FF.liftF(ApplySchemaOp(request))

  def attachObject(
    request: AttachObjectRequest
  ): CloudDirectoryIO[AttachObjectResponse] =
    FF.liftF(AttachObjectOp(request))

  def attachPolicy(
    request: AttachPolicyRequest
  ): CloudDirectoryIO[AttachPolicyResponse] =
    FF.liftF(AttachPolicyOp(request))

  def attachToIndex(
    request: AttachToIndexRequest
  ): CloudDirectoryIO[AttachToIndexResponse] =
    FF.liftF(AttachToIndexOp(request))

  def attachTypedLink(
    request: AttachTypedLinkRequest
  ): CloudDirectoryIO[AttachTypedLinkResponse] =
    FF.liftF(AttachTypedLinkOp(request))

  def batchRead(
    request: BatchReadRequest
  ): CloudDirectoryIO[BatchReadResponse] =
    FF.liftF(BatchReadOp(request))

  def batchWrite(
    request: BatchWriteRequest
  ): CloudDirectoryIO[BatchWriteResponse] =
    FF.liftF(BatchWriteOp(request))

  def createDirectory(
    request: CreateDirectoryRequest
  ): CloudDirectoryIO[CreateDirectoryResponse] =
    FF.liftF(CreateDirectoryOp(request))

  def createFacet(
    request: CreateFacetRequest
  ): CloudDirectoryIO[CreateFacetResponse] =
    FF.liftF(CreateFacetOp(request))

  def createIndex(
    request: CreateIndexRequest
  ): CloudDirectoryIO[CreateIndexResponse] =
    FF.liftF(CreateIndexOp(request))

  def createObject(
    request: CreateObjectRequest
  ): CloudDirectoryIO[CreateObjectResponse] =
    FF.liftF(CreateObjectOp(request))

  def createSchema(
    request: CreateSchemaRequest
  ): CloudDirectoryIO[CreateSchemaResponse] =
    FF.liftF(CreateSchemaOp(request))

  def createTypedLinkFacet(
    request: CreateTypedLinkFacetRequest
  ): CloudDirectoryIO[CreateTypedLinkFacetResponse] =
    FF.liftF(CreateTypedLinkFacetOp(request))

  def deleteDirectory(
    request: DeleteDirectoryRequest
  ): CloudDirectoryIO[DeleteDirectoryResponse] =
    FF.liftF(DeleteDirectoryOp(request))

  def deleteFacet(
    request: DeleteFacetRequest
  ): CloudDirectoryIO[DeleteFacetResponse] =
    FF.liftF(DeleteFacetOp(request))

  def deleteObject(
    request: DeleteObjectRequest
  ): CloudDirectoryIO[DeleteObjectResponse] =
    FF.liftF(DeleteObjectOp(request))

  def deleteSchema(
    request: DeleteSchemaRequest
  ): CloudDirectoryIO[DeleteSchemaResponse] =
    FF.liftF(DeleteSchemaOp(request))

  def deleteTypedLinkFacet(
    request: DeleteTypedLinkFacetRequest
  ): CloudDirectoryIO[DeleteTypedLinkFacetResponse] =
    FF.liftF(DeleteTypedLinkFacetOp(request))

  def detachFromIndex(
    request: DetachFromIndexRequest
  ): CloudDirectoryIO[DetachFromIndexResponse] =
    FF.liftF(DetachFromIndexOp(request))

  def detachObject(
    request: DetachObjectRequest
  ): CloudDirectoryIO[DetachObjectResponse] =
    FF.liftF(DetachObjectOp(request))

  def detachPolicy(
    request: DetachPolicyRequest
  ): CloudDirectoryIO[DetachPolicyResponse] =
    FF.liftF(DetachPolicyOp(request))

  def detachTypedLink(
    request: DetachTypedLinkRequest
  ): CloudDirectoryIO[DetachTypedLinkResponse] =
    FF.liftF(DetachTypedLinkOp(request))

  def disableDirectory(
    request: DisableDirectoryRequest
  ): CloudDirectoryIO[DisableDirectoryResponse] =
    FF.liftF(DisableDirectoryOp(request))

  def enableDirectory(
    request: EnableDirectoryRequest
  ): CloudDirectoryIO[EnableDirectoryResponse] =
    FF.liftF(EnableDirectoryOp(request))

  def getAppliedSchemaVersion(
    request: GetAppliedSchemaVersionRequest
  ): CloudDirectoryIO[GetAppliedSchemaVersionResponse] =
    FF.liftF(GetAppliedSchemaVersionOp(request))

  def getDirectory(
    request: GetDirectoryRequest
  ): CloudDirectoryIO[GetDirectoryResponse] =
    FF.liftF(GetDirectoryOp(request))

  def getFacet(
    request: GetFacetRequest
  ): CloudDirectoryIO[GetFacetResponse] =
    FF.liftF(GetFacetOp(request))

  def getLinkAttributes(
    request: GetLinkAttributesRequest
  ): CloudDirectoryIO[GetLinkAttributesResponse] =
    FF.liftF(GetLinkAttributesOp(request))

  def getObjectAttributes(
    request: GetObjectAttributesRequest
  ): CloudDirectoryIO[GetObjectAttributesResponse] =
    FF.liftF(GetObjectAttributesOp(request))

  def getObjectInformation(
    request: GetObjectInformationRequest
  ): CloudDirectoryIO[GetObjectInformationResponse] =
    FF.liftF(GetObjectInformationOp(request))

  def getSchemaAsJson(
    request: GetSchemaAsJsonRequest
  ): CloudDirectoryIO[GetSchemaAsJsonResponse] =
    FF.liftF(GetSchemaAsJsonOp(request))

  def getTypedLinkFacetInformation(
    request: GetTypedLinkFacetInformationRequest
  ): CloudDirectoryIO[GetTypedLinkFacetInformationResponse] =
    FF.liftF(GetTypedLinkFacetInformationOp(request))

  def listAppliedSchemaArns(
    request: ListAppliedSchemaArnsRequest
  ): CloudDirectoryIO[ListAppliedSchemaArnsResponse] =
    FF.liftF(ListAppliedSchemaArnsOp(request))

  def listAttachedIndices(
    request: ListAttachedIndicesRequest
  ): CloudDirectoryIO[ListAttachedIndicesResponse] =
    FF.liftF(ListAttachedIndicesOp(request))

  def listDevelopmentSchemaArns(
    request: ListDevelopmentSchemaArnsRequest
  ): CloudDirectoryIO[ListDevelopmentSchemaArnsResponse] =
    FF.liftF(ListDevelopmentSchemaArnsOp(request))

  def listDirectories(
    request: ListDirectoriesRequest
  ): CloudDirectoryIO[ListDirectoriesResponse] =
    FF.liftF(ListDirectoriesOp(request))

  def listFacetAttributes(
    request: ListFacetAttributesRequest
  ): CloudDirectoryIO[ListFacetAttributesResponse] =
    FF.liftF(ListFacetAttributesOp(request))

  def listFacetNames(
    request: ListFacetNamesRequest
  ): CloudDirectoryIO[ListFacetNamesResponse] =
    FF.liftF(ListFacetNamesOp(request))

  def listIncomingTypedLinks(
    request: ListIncomingTypedLinksRequest
  ): CloudDirectoryIO[ListIncomingTypedLinksResponse] =
    FF.liftF(ListIncomingTypedLinksOp(request))

  def listIndex(
    request: ListIndexRequest
  ): CloudDirectoryIO[ListIndexResponse] =
    FF.liftF(ListIndexOp(request))

  def listManagedSchemaArns(
    request: ListManagedSchemaArnsRequest
  ): CloudDirectoryIO[ListManagedSchemaArnsResponse] =
    FF.liftF(ListManagedSchemaArnsOp(request))

  def listObjectAttributes(
    request: ListObjectAttributesRequest
  ): CloudDirectoryIO[ListObjectAttributesResponse] =
    FF.liftF(ListObjectAttributesOp(request))

  def listObjectChildren(
    request: ListObjectChildrenRequest
  ): CloudDirectoryIO[ListObjectChildrenResponse] =
    FF.liftF(ListObjectChildrenOp(request))

  def listObjectParentPaths(
    request: ListObjectParentPathsRequest
  ): CloudDirectoryIO[ListObjectParentPathsResponse] =
    FF.liftF(ListObjectParentPathsOp(request))

  def listObjectParents(
    request: ListObjectParentsRequest
  ): CloudDirectoryIO[ListObjectParentsResponse] =
    FF.liftF(ListObjectParentsOp(request))

  def listObjectPolicies(
    request: ListObjectPoliciesRequest
  ): CloudDirectoryIO[ListObjectPoliciesResponse] =
    FF.liftF(ListObjectPoliciesOp(request))

  def listOutgoingTypedLinks(
    request: ListOutgoingTypedLinksRequest
  ): CloudDirectoryIO[ListOutgoingTypedLinksResponse] =
    FF.liftF(ListOutgoingTypedLinksOp(request))

  def listPolicyAttachments(
    request: ListPolicyAttachmentsRequest
  ): CloudDirectoryIO[ListPolicyAttachmentsResponse] =
    FF.liftF(ListPolicyAttachmentsOp(request))

  def listPublishedSchemaArns(
    request: ListPublishedSchemaArnsRequest
  ): CloudDirectoryIO[ListPublishedSchemaArnsResponse] =
    FF.liftF(ListPublishedSchemaArnsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): CloudDirectoryIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTypedLinkFacetAttributes(
    request: ListTypedLinkFacetAttributesRequest
  ): CloudDirectoryIO[ListTypedLinkFacetAttributesResponse] =
    FF.liftF(ListTypedLinkFacetAttributesOp(request))

  def listTypedLinkFacetNames(
    request: ListTypedLinkFacetNamesRequest
  ): CloudDirectoryIO[ListTypedLinkFacetNamesResponse] =
    FF.liftF(ListTypedLinkFacetNamesOp(request))

  def lookupPolicy(
    request: LookupPolicyRequest
  ): CloudDirectoryIO[LookupPolicyResponse] =
    FF.liftF(LookupPolicyOp(request))

  def publishSchema(
    request: PublishSchemaRequest
  ): CloudDirectoryIO[PublishSchemaResponse] =
    FF.liftF(PublishSchemaOp(request))

  def putSchemaFromJson(
    request: PutSchemaFromJsonRequest
  ): CloudDirectoryIO[PutSchemaFromJsonResponse] =
    FF.liftF(PutSchemaFromJsonOp(request))

  def removeFacetFromObject(
    request: RemoveFacetFromObjectRequest
  ): CloudDirectoryIO[RemoveFacetFromObjectResponse] =
    FF.liftF(RemoveFacetFromObjectOp(request))

  def tagResource(
    request: TagResourceRequest
  ): CloudDirectoryIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): CloudDirectoryIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateFacet(
    request: UpdateFacetRequest
  ): CloudDirectoryIO[UpdateFacetResponse] =
    FF.liftF(UpdateFacetOp(request))

  def updateLinkAttributes(
    request: UpdateLinkAttributesRequest
  ): CloudDirectoryIO[UpdateLinkAttributesResponse] =
    FF.liftF(UpdateLinkAttributesOp(request))

  def updateObjectAttributes(
    request: UpdateObjectAttributesRequest
  ): CloudDirectoryIO[UpdateObjectAttributesResponse] =
    FF.liftF(UpdateObjectAttributesOp(request))

  def updateSchema(
    request: UpdateSchemaRequest
  ): CloudDirectoryIO[UpdateSchemaResponse] =
    FF.liftF(UpdateSchemaOp(request))

  def updateTypedLinkFacet(
    request: UpdateTypedLinkFacetRequest
  ): CloudDirectoryIO[UpdateTypedLinkFacetResponse] =
    FF.liftF(UpdateTypedLinkFacetOp(request))

  def upgradeAppliedSchema(
    request: UpgradeAppliedSchemaRequest
  ): CloudDirectoryIO[UpgradeAppliedSchemaResponse] =
    FF.liftF(UpgradeAppliedSchemaOp(request))

  def upgradePublishedSchema(
    request: UpgradePublishedSchemaRequest
  ): CloudDirectoryIO[UpgradePublishedSchemaResponse] =
    FF.liftF(UpgradePublishedSchemaOp(request))
}
