package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.lexmodelsv2.LexModelsV2Client
import software.amazon.awssdk.services.lexmodelsv2.model._


object lexmodelsv2 { module =>

  // Free monad over LexModelsV2Op
  type LexModelsV2IO[A] = FF[LexModelsV2Op, A]

  sealed trait LexModelsV2Op[A] {
    def visit[F[_]](visitor: LexModelsV2Op.Visitor[F]): F[A]
  }

  object LexModelsV2Op {
    // Given a LexModelsV2Client we can embed a LexModelsV2IO program in any algebra that understands embedding.
    implicit val LexModelsV2OpEmbeddable: Embeddable[LexModelsV2Op, LexModelsV2Client] = new Embeddable[LexModelsV2Op, LexModelsV2Client] {
      def embed[A](client: LexModelsV2Client, io: LexModelsV2IO[A]): Embedded[A] = Embedded.LexModelsV2(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends LexModelsV2Op.Visitor[Kleisli[M, LexModelsV2Client, *]] {
        def buildBotLocale(
          request: BuildBotLocaleRequest
        ): Kleisli[M, LexModelsV2Client, BuildBotLocaleResponse] =
          primitive(_.buildBotLocale(request))

        def createBot(
          request: CreateBotRequest
        ): Kleisli[M, LexModelsV2Client, CreateBotResponse] =
          primitive(_.createBot(request))

        def createBotAlias(
          request: CreateBotAliasRequest
        ): Kleisli[M, LexModelsV2Client, CreateBotAliasResponse] =
          primitive(_.createBotAlias(request))

        def createBotLocale(
          request: CreateBotLocaleRequest
        ): Kleisli[M, LexModelsV2Client, CreateBotLocaleResponse] =
          primitive(_.createBotLocale(request))

        def createBotVersion(
          request: CreateBotVersionRequest
        ): Kleisli[M, LexModelsV2Client, CreateBotVersionResponse] =
          primitive(_.createBotVersion(request))

        def createExport(
          request: CreateExportRequest
        ): Kleisli[M, LexModelsV2Client, CreateExportResponse] =
          primitive(_.createExport(request))

        def createIntent(
          request: CreateIntentRequest
        ): Kleisli[M, LexModelsV2Client, CreateIntentResponse] =
          primitive(_.createIntent(request))

        def createResourcePolicy(
          request: CreateResourcePolicyRequest
        ): Kleisli[M, LexModelsV2Client, CreateResourcePolicyResponse] =
          primitive(_.createResourcePolicy(request))

        def createResourcePolicyStatement(
          request: CreateResourcePolicyStatementRequest
        ): Kleisli[M, LexModelsV2Client, CreateResourcePolicyStatementResponse] =
          primitive(_.createResourcePolicyStatement(request))

        def createSlot(
          request: CreateSlotRequest
        ): Kleisli[M, LexModelsV2Client, CreateSlotResponse] =
          primitive(_.createSlot(request))

        def createSlotType(
          request: CreateSlotTypeRequest
        ): Kleisli[M, LexModelsV2Client, CreateSlotTypeResponse] =
          primitive(_.createSlotType(request))

        def createUploadUrl(
          request: CreateUploadUrlRequest
        ): Kleisli[M, LexModelsV2Client, CreateUploadUrlResponse] =
          primitive(_.createUploadUrl(request))

        def deleteBot(
          request: DeleteBotRequest
        ): Kleisli[M, LexModelsV2Client, DeleteBotResponse] =
          primitive(_.deleteBot(request))

        def deleteBotAlias(
          request: DeleteBotAliasRequest
        ): Kleisli[M, LexModelsV2Client, DeleteBotAliasResponse] =
          primitive(_.deleteBotAlias(request))

        def deleteBotLocale(
          request: DeleteBotLocaleRequest
        ): Kleisli[M, LexModelsV2Client, DeleteBotLocaleResponse] =
          primitive(_.deleteBotLocale(request))

        def deleteBotVersion(
          request: DeleteBotVersionRequest
        ): Kleisli[M, LexModelsV2Client, DeleteBotVersionResponse] =
          primitive(_.deleteBotVersion(request))

        def deleteExport(
          request: DeleteExportRequest
        ): Kleisli[M, LexModelsV2Client, DeleteExportResponse] =
          primitive(_.deleteExport(request))

        def deleteImport(
          request: DeleteImportRequest
        ): Kleisli[M, LexModelsV2Client, DeleteImportResponse] =
          primitive(_.deleteImport(request))

        def deleteIntent(
          request: DeleteIntentRequest
        ): Kleisli[M, LexModelsV2Client, DeleteIntentResponse] =
          primitive(_.deleteIntent(request))

        def deleteResourcePolicy(
          request: DeleteResourcePolicyRequest
        ): Kleisli[M, LexModelsV2Client, DeleteResourcePolicyResponse] =
          primitive(_.deleteResourcePolicy(request))

        def deleteResourcePolicyStatement(
          request: DeleteResourcePolicyStatementRequest
        ): Kleisli[M, LexModelsV2Client, DeleteResourcePolicyStatementResponse] =
          primitive(_.deleteResourcePolicyStatement(request))

        def deleteSlot(
          request: DeleteSlotRequest
        ): Kleisli[M, LexModelsV2Client, DeleteSlotResponse] =
          primitive(_.deleteSlot(request))

        def deleteSlotType(
          request: DeleteSlotTypeRequest
        ): Kleisli[M, LexModelsV2Client, DeleteSlotTypeResponse] =
          primitive(_.deleteSlotType(request))

        def describeBot(
          request: DescribeBotRequest
        ): Kleisli[M, LexModelsV2Client, DescribeBotResponse] =
          primitive(_.describeBot(request))

        def describeBotAlias(
          request: DescribeBotAliasRequest
        ): Kleisli[M, LexModelsV2Client, DescribeBotAliasResponse] =
          primitive(_.describeBotAlias(request))

        def describeBotLocale(
          request: DescribeBotLocaleRequest
        ): Kleisli[M, LexModelsV2Client, DescribeBotLocaleResponse] =
          primitive(_.describeBotLocale(request))

        def describeBotVersion(
          request: DescribeBotVersionRequest
        ): Kleisli[M, LexModelsV2Client, DescribeBotVersionResponse] =
          primitive(_.describeBotVersion(request))

        def describeExport(
          request: DescribeExportRequest
        ): Kleisli[M, LexModelsV2Client, DescribeExportResponse] =
          primitive(_.describeExport(request))

        def describeImport(
          request: DescribeImportRequest
        ): Kleisli[M, LexModelsV2Client, DescribeImportResponse] =
          primitive(_.describeImport(request))

        def describeIntent(
          request: DescribeIntentRequest
        ): Kleisli[M, LexModelsV2Client, DescribeIntentResponse] =
          primitive(_.describeIntent(request))

        def describeResourcePolicy(
          request: DescribeResourcePolicyRequest
        ): Kleisli[M, LexModelsV2Client, DescribeResourcePolicyResponse] =
          primitive(_.describeResourcePolicy(request))

        def describeSlot(
          request: DescribeSlotRequest
        ): Kleisli[M, LexModelsV2Client, DescribeSlotResponse] =
          primitive(_.describeSlot(request))

        def describeSlotType(
          request: DescribeSlotTypeRequest
        ): Kleisli[M, LexModelsV2Client, DescribeSlotTypeResponse] =
          primitive(_.describeSlotType(request))

        def listBotAliases(
          request: ListBotAliasesRequest
        ): Kleisli[M, LexModelsV2Client, ListBotAliasesResponse] =
          primitive(_.listBotAliases(request))

        def listBotLocales(
          request: ListBotLocalesRequest
        ): Kleisli[M, LexModelsV2Client, ListBotLocalesResponse] =
          primitive(_.listBotLocales(request))

        def listBotVersions(
          request: ListBotVersionsRequest
        ): Kleisli[M, LexModelsV2Client, ListBotVersionsResponse] =
          primitive(_.listBotVersions(request))

        def listBots(
          request: ListBotsRequest
        ): Kleisli[M, LexModelsV2Client, ListBotsResponse] =
          primitive(_.listBots(request))

        def listBuiltInIntents(
          request: ListBuiltInIntentsRequest
        ): Kleisli[M, LexModelsV2Client, ListBuiltInIntentsResponse] =
          primitive(_.listBuiltInIntents(request))

        def listBuiltInSlotTypes(
          request: ListBuiltInSlotTypesRequest
        ): Kleisli[M, LexModelsV2Client, ListBuiltInSlotTypesResponse] =
          primitive(_.listBuiltInSlotTypes(request))

        def listExports(
          request: ListExportsRequest
        ): Kleisli[M, LexModelsV2Client, ListExportsResponse] =
          primitive(_.listExports(request))

        def listImports(
          request: ListImportsRequest
        ): Kleisli[M, LexModelsV2Client, ListImportsResponse] =
          primitive(_.listImports(request))

        def listIntents(
          request: ListIntentsRequest
        ): Kleisli[M, LexModelsV2Client, ListIntentsResponse] =
          primitive(_.listIntents(request))

        def listSlotTypes(
          request: ListSlotTypesRequest
        ): Kleisli[M, LexModelsV2Client, ListSlotTypesResponse] =
          primitive(_.listSlotTypes(request))

        def listSlots(
          request: ListSlotsRequest
        ): Kleisli[M, LexModelsV2Client, ListSlotsResponse] =
          primitive(_.listSlots(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, LexModelsV2Client, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def startImport(
          request: StartImportRequest
        ): Kleisli[M, LexModelsV2Client, StartImportResponse] =
          primitive(_.startImport(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, LexModelsV2Client, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, LexModelsV2Client, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateBot(
          request: UpdateBotRequest
        ): Kleisli[M, LexModelsV2Client, UpdateBotResponse] =
          primitive(_.updateBot(request))

        def updateBotAlias(
          request: UpdateBotAliasRequest
        ): Kleisli[M, LexModelsV2Client, UpdateBotAliasResponse] =
          primitive(_.updateBotAlias(request))

        def updateBotLocale(
          request: UpdateBotLocaleRequest
        ): Kleisli[M, LexModelsV2Client, UpdateBotLocaleResponse] =
          primitive(_.updateBotLocale(request))

        def updateExport(
          request: UpdateExportRequest
        ): Kleisli[M, LexModelsV2Client, UpdateExportResponse] =
          primitive(_.updateExport(request))

        def updateIntent(
          request: UpdateIntentRequest
        ): Kleisli[M, LexModelsV2Client, UpdateIntentResponse] =
          primitive(_.updateIntent(request))

        def updateResourcePolicy(
          request: UpdateResourcePolicyRequest
        ): Kleisli[M, LexModelsV2Client, UpdateResourcePolicyResponse] =
          primitive(_.updateResourcePolicy(request))

        def updateSlot(
          request: UpdateSlotRequest
        ): Kleisli[M, LexModelsV2Client, UpdateSlotResponse] =
          primitive(_.updateSlot(request))

        def updateSlotType(
          request: UpdateSlotTypeRequest
        ): Kleisli[M, LexModelsV2Client, UpdateSlotTypeResponse] =
          primitive(_.updateSlotType(request))

        def primitive[A](
          f: LexModelsV2Client => A
        ): Kleisli[M, LexModelsV2Client, A]
      }
    }

    trait Visitor[F[_]] extends (LexModelsV2Op ~> F) {
      final def apply[A](op: LexModelsV2Op[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def buildBotLocale(
        request: BuildBotLocaleRequest
      ): F[BuildBotLocaleResponse]

      def createBot(
        request: CreateBotRequest
      ): F[CreateBotResponse]

      def createBotAlias(
        request: CreateBotAliasRequest
      ): F[CreateBotAliasResponse]

      def createBotLocale(
        request: CreateBotLocaleRequest
      ): F[CreateBotLocaleResponse]

      def createBotVersion(
        request: CreateBotVersionRequest
      ): F[CreateBotVersionResponse]

      def createExport(
        request: CreateExportRequest
      ): F[CreateExportResponse]

      def createIntent(
        request: CreateIntentRequest
      ): F[CreateIntentResponse]

      def createResourcePolicy(
        request: CreateResourcePolicyRequest
      ): F[CreateResourcePolicyResponse]

      def createResourcePolicyStatement(
        request: CreateResourcePolicyStatementRequest
      ): F[CreateResourcePolicyStatementResponse]

      def createSlot(
        request: CreateSlotRequest
      ): F[CreateSlotResponse]

      def createSlotType(
        request: CreateSlotTypeRequest
      ): F[CreateSlotTypeResponse]

      def createUploadUrl(
        request: CreateUploadUrlRequest
      ): F[CreateUploadUrlResponse]

      def deleteBot(
        request: DeleteBotRequest
      ): F[DeleteBotResponse]

      def deleteBotAlias(
        request: DeleteBotAliasRequest
      ): F[DeleteBotAliasResponse]

      def deleteBotLocale(
        request: DeleteBotLocaleRequest
      ): F[DeleteBotLocaleResponse]

      def deleteBotVersion(
        request: DeleteBotVersionRequest
      ): F[DeleteBotVersionResponse]

      def deleteExport(
        request: DeleteExportRequest
      ): F[DeleteExportResponse]

      def deleteImport(
        request: DeleteImportRequest
      ): F[DeleteImportResponse]

      def deleteIntent(
        request: DeleteIntentRequest
      ): F[DeleteIntentResponse]

      def deleteResourcePolicy(
        request: DeleteResourcePolicyRequest
      ): F[DeleteResourcePolicyResponse]

      def deleteResourcePolicyStatement(
        request: DeleteResourcePolicyStatementRequest
      ): F[DeleteResourcePolicyStatementResponse]

      def deleteSlot(
        request: DeleteSlotRequest
      ): F[DeleteSlotResponse]

      def deleteSlotType(
        request: DeleteSlotTypeRequest
      ): F[DeleteSlotTypeResponse]

      def describeBot(
        request: DescribeBotRequest
      ): F[DescribeBotResponse]

      def describeBotAlias(
        request: DescribeBotAliasRequest
      ): F[DescribeBotAliasResponse]

      def describeBotLocale(
        request: DescribeBotLocaleRequest
      ): F[DescribeBotLocaleResponse]

      def describeBotVersion(
        request: DescribeBotVersionRequest
      ): F[DescribeBotVersionResponse]

      def describeExport(
        request: DescribeExportRequest
      ): F[DescribeExportResponse]

      def describeImport(
        request: DescribeImportRequest
      ): F[DescribeImportResponse]

      def describeIntent(
        request: DescribeIntentRequest
      ): F[DescribeIntentResponse]

      def describeResourcePolicy(
        request: DescribeResourcePolicyRequest
      ): F[DescribeResourcePolicyResponse]

      def describeSlot(
        request: DescribeSlotRequest
      ): F[DescribeSlotResponse]

      def describeSlotType(
        request: DescribeSlotTypeRequest
      ): F[DescribeSlotTypeResponse]

      def listBotAliases(
        request: ListBotAliasesRequest
      ): F[ListBotAliasesResponse]

      def listBotLocales(
        request: ListBotLocalesRequest
      ): F[ListBotLocalesResponse]

      def listBotVersions(
        request: ListBotVersionsRequest
      ): F[ListBotVersionsResponse]

      def listBots(
        request: ListBotsRequest
      ): F[ListBotsResponse]

      def listBuiltInIntents(
        request: ListBuiltInIntentsRequest
      ): F[ListBuiltInIntentsResponse]

      def listBuiltInSlotTypes(
        request: ListBuiltInSlotTypesRequest
      ): F[ListBuiltInSlotTypesResponse]

      def listExports(
        request: ListExportsRequest
      ): F[ListExportsResponse]

      def listImports(
        request: ListImportsRequest
      ): F[ListImportsResponse]

      def listIntents(
        request: ListIntentsRequest
      ): F[ListIntentsResponse]

      def listSlotTypes(
        request: ListSlotTypesRequest
      ): F[ListSlotTypesResponse]

      def listSlots(
        request: ListSlotsRequest
      ): F[ListSlotsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def startImport(
        request: StartImportRequest
      ): F[StartImportResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateBot(
        request: UpdateBotRequest
      ): F[UpdateBotResponse]

      def updateBotAlias(
        request: UpdateBotAliasRequest
      ): F[UpdateBotAliasResponse]

      def updateBotLocale(
        request: UpdateBotLocaleRequest
      ): F[UpdateBotLocaleResponse]

      def updateExport(
        request: UpdateExportRequest
      ): F[UpdateExportResponse]

      def updateIntent(
        request: UpdateIntentRequest
      ): F[UpdateIntentResponse]

      def updateResourcePolicy(
        request: UpdateResourcePolicyRequest
      ): F[UpdateResourcePolicyResponse]

      def updateSlot(
        request: UpdateSlotRequest
      ): F[UpdateSlotResponse]

      def updateSlotType(
        request: UpdateSlotTypeRequest
      ): F[UpdateSlotTypeResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends LexModelsV2Op[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BuildBotLocaleOp(
      request: BuildBotLocaleRequest
    ) extends LexModelsV2Op[BuildBotLocaleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BuildBotLocaleResponse] =
        visitor.buildBotLocale(request)
    }

    final case class CreateBotOp(
      request: CreateBotRequest
    ) extends LexModelsV2Op[CreateBotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBotResponse] =
        visitor.createBot(request)
    }

    final case class CreateBotAliasOp(
      request: CreateBotAliasRequest
    ) extends LexModelsV2Op[CreateBotAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBotAliasResponse] =
        visitor.createBotAlias(request)
    }

    final case class CreateBotLocaleOp(
      request: CreateBotLocaleRequest
    ) extends LexModelsV2Op[CreateBotLocaleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBotLocaleResponse] =
        visitor.createBotLocale(request)
    }

    final case class CreateBotVersionOp(
      request: CreateBotVersionRequest
    ) extends LexModelsV2Op[CreateBotVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBotVersionResponse] =
        visitor.createBotVersion(request)
    }

    final case class CreateExportOp(
      request: CreateExportRequest
    ) extends LexModelsV2Op[CreateExportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateExportResponse] =
        visitor.createExport(request)
    }

    final case class CreateIntentOp(
      request: CreateIntentRequest
    ) extends LexModelsV2Op[CreateIntentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateIntentResponse] =
        visitor.createIntent(request)
    }

    final case class CreateResourcePolicyOp(
      request: CreateResourcePolicyRequest
    ) extends LexModelsV2Op[CreateResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateResourcePolicyResponse] =
        visitor.createResourcePolicy(request)
    }

    final case class CreateResourcePolicyStatementOp(
      request: CreateResourcePolicyStatementRequest
    ) extends LexModelsV2Op[CreateResourcePolicyStatementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateResourcePolicyStatementResponse] =
        visitor.createResourcePolicyStatement(request)
    }

    final case class CreateSlotOp(
      request: CreateSlotRequest
    ) extends LexModelsV2Op[CreateSlotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSlotResponse] =
        visitor.createSlot(request)
    }

    final case class CreateSlotTypeOp(
      request: CreateSlotTypeRequest
    ) extends LexModelsV2Op[CreateSlotTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSlotTypeResponse] =
        visitor.createSlotType(request)
    }

    final case class CreateUploadUrlOp(
      request: CreateUploadUrlRequest
    ) extends LexModelsV2Op[CreateUploadUrlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUploadUrlResponse] =
        visitor.createUploadUrl(request)
    }

    final case class DeleteBotOp(
      request: DeleteBotRequest
    ) extends LexModelsV2Op[DeleteBotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBotResponse] =
        visitor.deleteBot(request)
    }

    final case class DeleteBotAliasOp(
      request: DeleteBotAliasRequest
    ) extends LexModelsV2Op[DeleteBotAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBotAliasResponse] =
        visitor.deleteBotAlias(request)
    }

    final case class DeleteBotLocaleOp(
      request: DeleteBotLocaleRequest
    ) extends LexModelsV2Op[DeleteBotLocaleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBotLocaleResponse] =
        visitor.deleteBotLocale(request)
    }

    final case class DeleteBotVersionOp(
      request: DeleteBotVersionRequest
    ) extends LexModelsV2Op[DeleteBotVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBotVersionResponse] =
        visitor.deleteBotVersion(request)
    }

    final case class DeleteExportOp(
      request: DeleteExportRequest
    ) extends LexModelsV2Op[DeleteExportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteExportResponse] =
        visitor.deleteExport(request)
    }

    final case class DeleteImportOp(
      request: DeleteImportRequest
    ) extends LexModelsV2Op[DeleteImportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteImportResponse] =
        visitor.deleteImport(request)
    }

    final case class DeleteIntentOp(
      request: DeleteIntentRequest
    ) extends LexModelsV2Op[DeleteIntentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIntentResponse] =
        visitor.deleteIntent(request)
    }

    final case class DeleteResourcePolicyOp(
      request: DeleteResourcePolicyRequest
    ) extends LexModelsV2Op[DeleteResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResourcePolicyResponse] =
        visitor.deleteResourcePolicy(request)
    }

    final case class DeleteResourcePolicyStatementOp(
      request: DeleteResourcePolicyStatementRequest
    ) extends LexModelsV2Op[DeleteResourcePolicyStatementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResourcePolicyStatementResponse] =
        visitor.deleteResourcePolicyStatement(request)
    }

    final case class DeleteSlotOp(
      request: DeleteSlotRequest
    ) extends LexModelsV2Op[DeleteSlotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSlotResponse] =
        visitor.deleteSlot(request)
    }

    final case class DeleteSlotTypeOp(
      request: DeleteSlotTypeRequest
    ) extends LexModelsV2Op[DeleteSlotTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSlotTypeResponse] =
        visitor.deleteSlotType(request)
    }

    final case class DescribeBotOp(
      request: DescribeBotRequest
    ) extends LexModelsV2Op[DescribeBotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBotResponse] =
        visitor.describeBot(request)
    }

    final case class DescribeBotAliasOp(
      request: DescribeBotAliasRequest
    ) extends LexModelsV2Op[DescribeBotAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBotAliasResponse] =
        visitor.describeBotAlias(request)
    }

    final case class DescribeBotLocaleOp(
      request: DescribeBotLocaleRequest
    ) extends LexModelsV2Op[DescribeBotLocaleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBotLocaleResponse] =
        visitor.describeBotLocale(request)
    }

    final case class DescribeBotVersionOp(
      request: DescribeBotVersionRequest
    ) extends LexModelsV2Op[DescribeBotVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBotVersionResponse] =
        visitor.describeBotVersion(request)
    }

    final case class DescribeExportOp(
      request: DescribeExportRequest
    ) extends LexModelsV2Op[DescribeExportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeExportResponse] =
        visitor.describeExport(request)
    }

    final case class DescribeImportOp(
      request: DescribeImportRequest
    ) extends LexModelsV2Op[DescribeImportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeImportResponse] =
        visitor.describeImport(request)
    }

    final case class DescribeIntentOp(
      request: DescribeIntentRequest
    ) extends LexModelsV2Op[DescribeIntentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeIntentResponse] =
        visitor.describeIntent(request)
    }

    final case class DescribeResourcePolicyOp(
      request: DescribeResourcePolicyRequest
    ) extends LexModelsV2Op[DescribeResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeResourcePolicyResponse] =
        visitor.describeResourcePolicy(request)
    }

    final case class DescribeSlotOp(
      request: DescribeSlotRequest
    ) extends LexModelsV2Op[DescribeSlotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSlotResponse] =
        visitor.describeSlot(request)
    }

    final case class DescribeSlotTypeOp(
      request: DescribeSlotTypeRequest
    ) extends LexModelsV2Op[DescribeSlotTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSlotTypeResponse] =
        visitor.describeSlotType(request)
    }

    final case class ListBotAliasesOp(
      request: ListBotAliasesRequest
    ) extends LexModelsV2Op[ListBotAliasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBotAliasesResponse] =
        visitor.listBotAliases(request)
    }

    final case class ListBotLocalesOp(
      request: ListBotLocalesRequest
    ) extends LexModelsV2Op[ListBotLocalesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBotLocalesResponse] =
        visitor.listBotLocales(request)
    }

    final case class ListBotVersionsOp(
      request: ListBotVersionsRequest
    ) extends LexModelsV2Op[ListBotVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBotVersionsResponse] =
        visitor.listBotVersions(request)
    }

    final case class ListBotsOp(
      request: ListBotsRequest
    ) extends LexModelsV2Op[ListBotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBotsResponse] =
        visitor.listBots(request)
    }

    final case class ListBuiltInIntentsOp(
      request: ListBuiltInIntentsRequest
    ) extends LexModelsV2Op[ListBuiltInIntentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBuiltInIntentsResponse] =
        visitor.listBuiltInIntents(request)
    }

    final case class ListBuiltInSlotTypesOp(
      request: ListBuiltInSlotTypesRequest
    ) extends LexModelsV2Op[ListBuiltInSlotTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBuiltInSlotTypesResponse] =
        visitor.listBuiltInSlotTypes(request)
    }

    final case class ListExportsOp(
      request: ListExportsRequest
    ) extends LexModelsV2Op[ListExportsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListExportsResponse] =
        visitor.listExports(request)
    }

    final case class ListImportsOp(
      request: ListImportsRequest
    ) extends LexModelsV2Op[ListImportsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListImportsResponse] =
        visitor.listImports(request)
    }

    final case class ListIntentsOp(
      request: ListIntentsRequest
    ) extends LexModelsV2Op[ListIntentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIntentsResponse] =
        visitor.listIntents(request)
    }

    final case class ListSlotTypesOp(
      request: ListSlotTypesRequest
    ) extends LexModelsV2Op[ListSlotTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSlotTypesResponse] =
        visitor.listSlotTypes(request)
    }

    final case class ListSlotsOp(
      request: ListSlotsRequest
    ) extends LexModelsV2Op[ListSlotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSlotsResponse] =
        visitor.listSlots(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends LexModelsV2Op[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class StartImportOp(
      request: StartImportRequest
    ) extends LexModelsV2Op[StartImportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartImportResponse] =
        visitor.startImport(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends LexModelsV2Op[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends LexModelsV2Op[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateBotOp(
      request: UpdateBotRequest
    ) extends LexModelsV2Op[UpdateBotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBotResponse] =
        visitor.updateBot(request)
    }

    final case class UpdateBotAliasOp(
      request: UpdateBotAliasRequest
    ) extends LexModelsV2Op[UpdateBotAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBotAliasResponse] =
        visitor.updateBotAlias(request)
    }

    final case class UpdateBotLocaleOp(
      request: UpdateBotLocaleRequest
    ) extends LexModelsV2Op[UpdateBotLocaleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBotLocaleResponse] =
        visitor.updateBotLocale(request)
    }

    final case class UpdateExportOp(
      request: UpdateExportRequest
    ) extends LexModelsV2Op[UpdateExportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateExportResponse] =
        visitor.updateExport(request)
    }

    final case class UpdateIntentOp(
      request: UpdateIntentRequest
    ) extends LexModelsV2Op[UpdateIntentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateIntentResponse] =
        visitor.updateIntent(request)
    }

    final case class UpdateResourcePolicyOp(
      request: UpdateResourcePolicyRequest
    ) extends LexModelsV2Op[UpdateResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateResourcePolicyResponse] =
        visitor.updateResourcePolicy(request)
    }

    final case class UpdateSlotOp(
      request: UpdateSlotRequest
    ) extends LexModelsV2Op[UpdateSlotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSlotResponse] =
        visitor.updateSlot(request)
    }

    final case class UpdateSlotTypeOp(
      request: UpdateSlotTypeRequest
    ) extends LexModelsV2Op[UpdateSlotTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSlotTypeResponse] =
        visitor.updateSlotType(request)
    }
  }

  import LexModelsV2Op._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[LexModelsV2Op, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def buildBotLocale(
    request: BuildBotLocaleRequest
  ): LexModelsV2IO[BuildBotLocaleResponse] =
    FF.liftF(BuildBotLocaleOp(request))

  def createBot(
    request: CreateBotRequest
  ): LexModelsV2IO[CreateBotResponse] =
    FF.liftF(CreateBotOp(request))

  def createBotAlias(
    request: CreateBotAliasRequest
  ): LexModelsV2IO[CreateBotAliasResponse] =
    FF.liftF(CreateBotAliasOp(request))

  def createBotLocale(
    request: CreateBotLocaleRequest
  ): LexModelsV2IO[CreateBotLocaleResponse] =
    FF.liftF(CreateBotLocaleOp(request))

  def createBotVersion(
    request: CreateBotVersionRequest
  ): LexModelsV2IO[CreateBotVersionResponse] =
    FF.liftF(CreateBotVersionOp(request))

  def createExport(
    request: CreateExportRequest
  ): LexModelsV2IO[CreateExportResponse] =
    FF.liftF(CreateExportOp(request))

  def createIntent(
    request: CreateIntentRequest
  ): LexModelsV2IO[CreateIntentResponse] =
    FF.liftF(CreateIntentOp(request))

  def createResourcePolicy(
    request: CreateResourcePolicyRequest
  ): LexModelsV2IO[CreateResourcePolicyResponse] =
    FF.liftF(CreateResourcePolicyOp(request))

  def createResourcePolicyStatement(
    request: CreateResourcePolicyStatementRequest
  ): LexModelsV2IO[CreateResourcePolicyStatementResponse] =
    FF.liftF(CreateResourcePolicyStatementOp(request))

  def createSlot(
    request: CreateSlotRequest
  ): LexModelsV2IO[CreateSlotResponse] =
    FF.liftF(CreateSlotOp(request))

  def createSlotType(
    request: CreateSlotTypeRequest
  ): LexModelsV2IO[CreateSlotTypeResponse] =
    FF.liftF(CreateSlotTypeOp(request))

  def createUploadUrl(
    request: CreateUploadUrlRequest
  ): LexModelsV2IO[CreateUploadUrlResponse] =
    FF.liftF(CreateUploadUrlOp(request))

  def deleteBot(
    request: DeleteBotRequest
  ): LexModelsV2IO[DeleteBotResponse] =
    FF.liftF(DeleteBotOp(request))

  def deleteBotAlias(
    request: DeleteBotAliasRequest
  ): LexModelsV2IO[DeleteBotAliasResponse] =
    FF.liftF(DeleteBotAliasOp(request))

  def deleteBotLocale(
    request: DeleteBotLocaleRequest
  ): LexModelsV2IO[DeleteBotLocaleResponse] =
    FF.liftF(DeleteBotLocaleOp(request))

  def deleteBotVersion(
    request: DeleteBotVersionRequest
  ): LexModelsV2IO[DeleteBotVersionResponse] =
    FF.liftF(DeleteBotVersionOp(request))

  def deleteExport(
    request: DeleteExportRequest
  ): LexModelsV2IO[DeleteExportResponse] =
    FF.liftF(DeleteExportOp(request))

  def deleteImport(
    request: DeleteImportRequest
  ): LexModelsV2IO[DeleteImportResponse] =
    FF.liftF(DeleteImportOp(request))

  def deleteIntent(
    request: DeleteIntentRequest
  ): LexModelsV2IO[DeleteIntentResponse] =
    FF.liftF(DeleteIntentOp(request))

  def deleteResourcePolicy(
    request: DeleteResourcePolicyRequest
  ): LexModelsV2IO[DeleteResourcePolicyResponse] =
    FF.liftF(DeleteResourcePolicyOp(request))

  def deleteResourcePolicyStatement(
    request: DeleteResourcePolicyStatementRequest
  ): LexModelsV2IO[DeleteResourcePolicyStatementResponse] =
    FF.liftF(DeleteResourcePolicyStatementOp(request))

  def deleteSlot(
    request: DeleteSlotRequest
  ): LexModelsV2IO[DeleteSlotResponse] =
    FF.liftF(DeleteSlotOp(request))

  def deleteSlotType(
    request: DeleteSlotTypeRequest
  ): LexModelsV2IO[DeleteSlotTypeResponse] =
    FF.liftF(DeleteSlotTypeOp(request))

  def describeBot(
    request: DescribeBotRequest
  ): LexModelsV2IO[DescribeBotResponse] =
    FF.liftF(DescribeBotOp(request))

  def describeBotAlias(
    request: DescribeBotAliasRequest
  ): LexModelsV2IO[DescribeBotAliasResponse] =
    FF.liftF(DescribeBotAliasOp(request))

  def describeBotLocale(
    request: DescribeBotLocaleRequest
  ): LexModelsV2IO[DescribeBotLocaleResponse] =
    FF.liftF(DescribeBotLocaleOp(request))

  def describeBotVersion(
    request: DescribeBotVersionRequest
  ): LexModelsV2IO[DescribeBotVersionResponse] =
    FF.liftF(DescribeBotVersionOp(request))

  def describeExport(
    request: DescribeExportRequest
  ): LexModelsV2IO[DescribeExportResponse] =
    FF.liftF(DescribeExportOp(request))

  def describeImport(
    request: DescribeImportRequest
  ): LexModelsV2IO[DescribeImportResponse] =
    FF.liftF(DescribeImportOp(request))

  def describeIntent(
    request: DescribeIntentRequest
  ): LexModelsV2IO[DescribeIntentResponse] =
    FF.liftF(DescribeIntentOp(request))

  def describeResourcePolicy(
    request: DescribeResourcePolicyRequest
  ): LexModelsV2IO[DescribeResourcePolicyResponse] =
    FF.liftF(DescribeResourcePolicyOp(request))

  def describeSlot(
    request: DescribeSlotRequest
  ): LexModelsV2IO[DescribeSlotResponse] =
    FF.liftF(DescribeSlotOp(request))

  def describeSlotType(
    request: DescribeSlotTypeRequest
  ): LexModelsV2IO[DescribeSlotTypeResponse] =
    FF.liftF(DescribeSlotTypeOp(request))

  def listBotAliases(
    request: ListBotAliasesRequest
  ): LexModelsV2IO[ListBotAliasesResponse] =
    FF.liftF(ListBotAliasesOp(request))

  def listBotLocales(
    request: ListBotLocalesRequest
  ): LexModelsV2IO[ListBotLocalesResponse] =
    FF.liftF(ListBotLocalesOp(request))

  def listBotVersions(
    request: ListBotVersionsRequest
  ): LexModelsV2IO[ListBotVersionsResponse] =
    FF.liftF(ListBotVersionsOp(request))

  def listBots(
    request: ListBotsRequest
  ): LexModelsV2IO[ListBotsResponse] =
    FF.liftF(ListBotsOp(request))

  def listBuiltInIntents(
    request: ListBuiltInIntentsRequest
  ): LexModelsV2IO[ListBuiltInIntentsResponse] =
    FF.liftF(ListBuiltInIntentsOp(request))

  def listBuiltInSlotTypes(
    request: ListBuiltInSlotTypesRequest
  ): LexModelsV2IO[ListBuiltInSlotTypesResponse] =
    FF.liftF(ListBuiltInSlotTypesOp(request))

  def listExports(
    request: ListExportsRequest
  ): LexModelsV2IO[ListExportsResponse] =
    FF.liftF(ListExportsOp(request))

  def listImports(
    request: ListImportsRequest
  ): LexModelsV2IO[ListImportsResponse] =
    FF.liftF(ListImportsOp(request))

  def listIntents(
    request: ListIntentsRequest
  ): LexModelsV2IO[ListIntentsResponse] =
    FF.liftF(ListIntentsOp(request))

  def listSlotTypes(
    request: ListSlotTypesRequest
  ): LexModelsV2IO[ListSlotTypesResponse] =
    FF.liftF(ListSlotTypesOp(request))

  def listSlots(
    request: ListSlotsRequest
  ): LexModelsV2IO[ListSlotsResponse] =
    FF.liftF(ListSlotsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): LexModelsV2IO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def startImport(
    request: StartImportRequest
  ): LexModelsV2IO[StartImportResponse] =
    FF.liftF(StartImportOp(request))

  def tagResource(
    request: TagResourceRequest
  ): LexModelsV2IO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): LexModelsV2IO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateBot(
    request: UpdateBotRequest
  ): LexModelsV2IO[UpdateBotResponse] =
    FF.liftF(UpdateBotOp(request))

  def updateBotAlias(
    request: UpdateBotAliasRequest
  ): LexModelsV2IO[UpdateBotAliasResponse] =
    FF.liftF(UpdateBotAliasOp(request))

  def updateBotLocale(
    request: UpdateBotLocaleRequest
  ): LexModelsV2IO[UpdateBotLocaleResponse] =
    FF.liftF(UpdateBotLocaleOp(request))

  def updateExport(
    request: UpdateExportRequest
  ): LexModelsV2IO[UpdateExportResponse] =
    FF.liftF(UpdateExportOp(request))

  def updateIntent(
    request: UpdateIntentRequest
  ): LexModelsV2IO[UpdateIntentResponse] =
    FF.liftF(UpdateIntentOp(request))

  def updateResourcePolicy(
    request: UpdateResourcePolicyRequest
  ): LexModelsV2IO[UpdateResourcePolicyResponse] =
    FF.liftF(UpdateResourcePolicyOp(request))

  def updateSlot(
    request: UpdateSlotRequest
  ): LexModelsV2IO[UpdateSlotResponse] =
    FF.liftF(UpdateSlotOp(request))

  def updateSlotType(
    request: UpdateSlotTypeRequest
  ): LexModelsV2IO[UpdateSlotTypeResponse] =
    FF.liftF(UpdateSlotTypeOp(request))
}
