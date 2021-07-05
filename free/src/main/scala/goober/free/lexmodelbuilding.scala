package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.lexmodelbuilding.LexModelBuildingClient
import software.amazon.awssdk.services.lexmodelbuilding.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object lexmodelbuilding { module =>

  // Free monad over LexModelBuildingOp
  type LexModelBuildingIO[A] = FF[LexModelBuildingOp, A]

  sealed trait LexModelBuildingOp[A] {
    def visit[F[_]](visitor: LexModelBuildingOp.Visitor[F]): F[A]
  }

  object LexModelBuildingOp {
    // Given a LexModelBuildingClient we can embed a LexModelBuildingIO program in any algebra that understands embedding.
    implicit val LexModelBuildingOpEmbeddable: Embeddable[LexModelBuildingOp, LexModelBuildingClient] = new Embeddable[LexModelBuildingOp, LexModelBuildingClient] {
      def embed[A](client: LexModelBuildingClient, io: LexModelBuildingIO[A]): Embedded[A] = Embedded.LexModelBuilding(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends LexModelBuildingOp.Visitor[Kleisli[M, LexModelBuildingClient, *]] {
        def createBotVersion(
          request: CreateBotVersionRequest
        ): Kleisli[M, LexModelBuildingClient, CreateBotVersionResponse] =
          primitive(_.createBotVersion(request))

        def createIntentVersion(
          request: CreateIntentVersionRequest
        ): Kleisli[M, LexModelBuildingClient, CreateIntentVersionResponse] =
          primitive(_.createIntentVersion(request))

        def createSlotTypeVersion(
          request: CreateSlotTypeVersionRequest
        ): Kleisli[M, LexModelBuildingClient, CreateSlotTypeVersionResponse] =
          primitive(_.createSlotTypeVersion(request))

        def deleteBot(
          request: DeleteBotRequest
        ): Kleisli[M, LexModelBuildingClient, DeleteBotResponse] =
          primitive(_.deleteBot(request))

        def deleteBotAlias(
          request: DeleteBotAliasRequest
        ): Kleisli[M, LexModelBuildingClient, DeleteBotAliasResponse] =
          primitive(_.deleteBotAlias(request))

        def deleteBotChannelAssociation(
          request: DeleteBotChannelAssociationRequest
        ): Kleisli[M, LexModelBuildingClient, DeleteBotChannelAssociationResponse] =
          primitive(_.deleteBotChannelAssociation(request))

        def deleteBotVersion(
          request: DeleteBotVersionRequest
        ): Kleisli[M, LexModelBuildingClient, DeleteBotVersionResponse] =
          primitive(_.deleteBotVersion(request))

        def deleteIntent(
          request: DeleteIntentRequest
        ): Kleisli[M, LexModelBuildingClient, DeleteIntentResponse] =
          primitive(_.deleteIntent(request))

        def deleteIntentVersion(
          request: DeleteIntentVersionRequest
        ): Kleisli[M, LexModelBuildingClient, DeleteIntentVersionResponse] =
          primitive(_.deleteIntentVersion(request))

        def deleteSlotType(
          request: DeleteSlotTypeRequest
        ): Kleisli[M, LexModelBuildingClient, DeleteSlotTypeResponse] =
          primitive(_.deleteSlotType(request))

        def deleteSlotTypeVersion(
          request: DeleteSlotTypeVersionRequest
        ): Kleisli[M, LexModelBuildingClient, DeleteSlotTypeVersionResponse] =
          primitive(_.deleteSlotTypeVersion(request))

        def deleteUtterances(
          request: DeleteUtterancesRequest
        ): Kleisli[M, LexModelBuildingClient, DeleteUtterancesResponse] =
          primitive(_.deleteUtterances(request))

        def getBot(
          request: GetBotRequest
        ): Kleisli[M, LexModelBuildingClient, GetBotResponse] =
          primitive(_.getBot(request))

        def getBotAlias(
          request: GetBotAliasRequest
        ): Kleisli[M, LexModelBuildingClient, GetBotAliasResponse] =
          primitive(_.getBotAlias(request))

        def getBotAliases(
          request: GetBotAliasesRequest
        ): Kleisli[M, LexModelBuildingClient, GetBotAliasesResponse] =
          primitive(_.getBotAliases(request))

        def getBotChannelAssociation(
          request: GetBotChannelAssociationRequest
        ): Kleisli[M, LexModelBuildingClient, GetBotChannelAssociationResponse] =
          primitive(_.getBotChannelAssociation(request))

        def getBotChannelAssociations(
          request: GetBotChannelAssociationsRequest
        ): Kleisli[M, LexModelBuildingClient, GetBotChannelAssociationsResponse] =
          primitive(_.getBotChannelAssociations(request))

        def getBotVersions(
          request: GetBotVersionsRequest
        ): Kleisli[M, LexModelBuildingClient, GetBotVersionsResponse] =
          primitive(_.getBotVersions(request))

        def getBots(
          request: GetBotsRequest
        ): Kleisli[M, LexModelBuildingClient, GetBotsResponse] =
          primitive(_.getBots(request))

        def getBuiltinIntent(
          request: GetBuiltinIntentRequest
        ): Kleisli[M, LexModelBuildingClient, GetBuiltinIntentResponse] =
          primitive(_.getBuiltinIntent(request))

        def getBuiltinIntents(
          request: GetBuiltinIntentsRequest
        ): Kleisli[M, LexModelBuildingClient, GetBuiltinIntentsResponse] =
          primitive(_.getBuiltinIntents(request))

        def getBuiltinSlotTypes(
          request: GetBuiltinSlotTypesRequest
        ): Kleisli[M, LexModelBuildingClient, GetBuiltinSlotTypesResponse] =
          primitive(_.getBuiltinSlotTypes(request))

        def getExport(
          request: GetExportRequest
        ): Kleisli[M, LexModelBuildingClient, GetExportResponse] =
          primitive(_.getExport(request))

        def getImport(
          request: GetImportRequest
        ): Kleisli[M, LexModelBuildingClient, GetImportResponse] =
          primitive(_.getImport(request))

        def getIntent(
          request: GetIntentRequest
        ): Kleisli[M, LexModelBuildingClient, GetIntentResponse] =
          primitive(_.getIntent(request))

        def getIntentVersions(
          request: GetIntentVersionsRequest
        ): Kleisli[M, LexModelBuildingClient, GetIntentVersionsResponse] =
          primitive(_.getIntentVersions(request))

        def getIntents(
          request: GetIntentsRequest
        ): Kleisli[M, LexModelBuildingClient, GetIntentsResponse] =
          primitive(_.getIntents(request))

        def getSlotType(
          request: GetSlotTypeRequest
        ): Kleisli[M, LexModelBuildingClient, GetSlotTypeResponse] =
          primitive(_.getSlotType(request))

        def getSlotTypeVersions(
          request: GetSlotTypeVersionsRequest
        ): Kleisli[M, LexModelBuildingClient, GetSlotTypeVersionsResponse] =
          primitive(_.getSlotTypeVersions(request))

        def getSlotTypes(
          request: GetSlotTypesRequest
        ): Kleisli[M, LexModelBuildingClient, GetSlotTypesResponse] =
          primitive(_.getSlotTypes(request))

        def getUtterancesView(
          request: GetUtterancesViewRequest
        ): Kleisli[M, LexModelBuildingClient, GetUtterancesViewResponse] =
          primitive(_.getUtterancesView(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, LexModelBuildingClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putBot(
          request: PutBotRequest
        ): Kleisli[M, LexModelBuildingClient, PutBotResponse] =
          primitive(_.putBot(request))

        def putBotAlias(
          request: PutBotAliasRequest
        ): Kleisli[M, LexModelBuildingClient, PutBotAliasResponse] =
          primitive(_.putBotAlias(request))

        def putIntent(
          request: PutIntentRequest
        ): Kleisli[M, LexModelBuildingClient, PutIntentResponse] =
          primitive(_.putIntent(request))

        def putSlotType(
          request: PutSlotTypeRequest
        ): Kleisli[M, LexModelBuildingClient, PutSlotTypeResponse] =
          primitive(_.putSlotType(request))

        def startImport(
          request: StartImportRequest
        ): Kleisli[M, LexModelBuildingClient, StartImportResponse] =
          primitive(_.startImport(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, LexModelBuildingClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, LexModelBuildingClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: LexModelBuildingClient => A
        ): Kleisli[M, LexModelBuildingClient, A]
      }
    }

    trait Visitor[F[_]] extends (LexModelBuildingOp ~> F) {
      final def apply[A](op: LexModelBuildingOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createBotVersion(
        request: CreateBotVersionRequest
      ): F[CreateBotVersionResponse]

      def createIntentVersion(
        request: CreateIntentVersionRequest
      ): F[CreateIntentVersionResponse]

      def createSlotTypeVersion(
        request: CreateSlotTypeVersionRequest
      ): F[CreateSlotTypeVersionResponse]

      def deleteBot(
        request: DeleteBotRequest
      ): F[DeleteBotResponse]

      def deleteBotAlias(
        request: DeleteBotAliasRequest
      ): F[DeleteBotAliasResponse]

      def deleteBotChannelAssociation(
        request: DeleteBotChannelAssociationRequest
      ): F[DeleteBotChannelAssociationResponse]

      def deleteBotVersion(
        request: DeleteBotVersionRequest
      ): F[DeleteBotVersionResponse]

      def deleteIntent(
        request: DeleteIntentRequest
      ): F[DeleteIntentResponse]

      def deleteIntentVersion(
        request: DeleteIntentVersionRequest
      ): F[DeleteIntentVersionResponse]

      def deleteSlotType(
        request: DeleteSlotTypeRequest
      ): F[DeleteSlotTypeResponse]

      def deleteSlotTypeVersion(
        request: DeleteSlotTypeVersionRequest
      ): F[DeleteSlotTypeVersionResponse]

      def deleteUtterances(
        request: DeleteUtterancesRequest
      ): F[DeleteUtterancesResponse]

      def getBot(
        request: GetBotRequest
      ): F[GetBotResponse]

      def getBotAlias(
        request: GetBotAliasRequest
      ): F[GetBotAliasResponse]

      def getBotAliases(
        request: GetBotAliasesRequest
      ): F[GetBotAliasesResponse]

      def getBotChannelAssociation(
        request: GetBotChannelAssociationRequest
      ): F[GetBotChannelAssociationResponse]

      def getBotChannelAssociations(
        request: GetBotChannelAssociationsRequest
      ): F[GetBotChannelAssociationsResponse]

      def getBotVersions(
        request: GetBotVersionsRequest
      ): F[GetBotVersionsResponse]

      def getBots(
        request: GetBotsRequest
      ): F[GetBotsResponse]

      def getBuiltinIntent(
        request: GetBuiltinIntentRequest
      ): F[GetBuiltinIntentResponse]

      def getBuiltinIntents(
        request: GetBuiltinIntentsRequest
      ): F[GetBuiltinIntentsResponse]

      def getBuiltinSlotTypes(
        request: GetBuiltinSlotTypesRequest
      ): F[GetBuiltinSlotTypesResponse]

      def getExport(
        request: GetExportRequest
      ): F[GetExportResponse]

      def getImport(
        request: GetImportRequest
      ): F[GetImportResponse]

      def getIntent(
        request: GetIntentRequest
      ): F[GetIntentResponse]

      def getIntentVersions(
        request: GetIntentVersionsRequest
      ): F[GetIntentVersionsResponse]

      def getIntents(
        request: GetIntentsRequest
      ): F[GetIntentsResponse]

      def getSlotType(
        request: GetSlotTypeRequest
      ): F[GetSlotTypeResponse]

      def getSlotTypeVersions(
        request: GetSlotTypeVersionsRequest
      ): F[GetSlotTypeVersionsResponse]

      def getSlotTypes(
        request: GetSlotTypesRequest
      ): F[GetSlotTypesResponse]

      def getUtterancesView(
        request: GetUtterancesViewRequest
      ): F[GetUtterancesViewResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putBot(
        request: PutBotRequest
      ): F[PutBotResponse]

      def putBotAlias(
        request: PutBotAliasRequest
      ): F[PutBotAliasResponse]

      def putIntent(
        request: PutIntentRequest
      ): F[PutIntentResponse]

      def putSlotType(
        request: PutSlotTypeRequest
      ): F[PutSlotTypeResponse]

      def startImport(
        request: StartImportRequest
      ): F[StartImportResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends LexModelBuildingOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateBotVersionOp(
      request: CreateBotVersionRequest
    ) extends LexModelBuildingOp[CreateBotVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBotVersionResponse] =
        visitor.createBotVersion(request)
    }

    final case class CreateIntentVersionOp(
      request: CreateIntentVersionRequest
    ) extends LexModelBuildingOp[CreateIntentVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateIntentVersionResponse] =
        visitor.createIntentVersion(request)
    }

    final case class CreateSlotTypeVersionOp(
      request: CreateSlotTypeVersionRequest
    ) extends LexModelBuildingOp[CreateSlotTypeVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSlotTypeVersionResponse] =
        visitor.createSlotTypeVersion(request)
    }

    final case class DeleteBotOp(
      request: DeleteBotRequest
    ) extends LexModelBuildingOp[DeleteBotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBotResponse] =
        visitor.deleteBot(request)
    }

    final case class DeleteBotAliasOp(
      request: DeleteBotAliasRequest
    ) extends LexModelBuildingOp[DeleteBotAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBotAliasResponse] =
        visitor.deleteBotAlias(request)
    }

    final case class DeleteBotChannelAssociationOp(
      request: DeleteBotChannelAssociationRequest
    ) extends LexModelBuildingOp[DeleteBotChannelAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBotChannelAssociationResponse] =
        visitor.deleteBotChannelAssociation(request)
    }

    final case class DeleteBotVersionOp(
      request: DeleteBotVersionRequest
    ) extends LexModelBuildingOp[DeleteBotVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBotVersionResponse] =
        visitor.deleteBotVersion(request)
    }

    final case class DeleteIntentOp(
      request: DeleteIntentRequest
    ) extends LexModelBuildingOp[DeleteIntentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIntentResponse] =
        visitor.deleteIntent(request)
    }

    final case class DeleteIntentVersionOp(
      request: DeleteIntentVersionRequest
    ) extends LexModelBuildingOp[DeleteIntentVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIntentVersionResponse] =
        visitor.deleteIntentVersion(request)
    }

    final case class DeleteSlotTypeOp(
      request: DeleteSlotTypeRequest
    ) extends LexModelBuildingOp[DeleteSlotTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSlotTypeResponse] =
        visitor.deleteSlotType(request)
    }

    final case class DeleteSlotTypeVersionOp(
      request: DeleteSlotTypeVersionRequest
    ) extends LexModelBuildingOp[DeleteSlotTypeVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSlotTypeVersionResponse] =
        visitor.deleteSlotTypeVersion(request)
    }

    final case class DeleteUtterancesOp(
      request: DeleteUtterancesRequest
    ) extends LexModelBuildingOp[DeleteUtterancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUtterancesResponse] =
        visitor.deleteUtterances(request)
    }

    final case class GetBotOp(
      request: GetBotRequest
    ) extends LexModelBuildingOp[GetBotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBotResponse] =
        visitor.getBot(request)
    }

    final case class GetBotAliasOp(
      request: GetBotAliasRequest
    ) extends LexModelBuildingOp[GetBotAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBotAliasResponse] =
        visitor.getBotAlias(request)
    }

    final case class GetBotAliasesOp(
      request: GetBotAliasesRequest
    ) extends LexModelBuildingOp[GetBotAliasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBotAliasesResponse] =
        visitor.getBotAliases(request)
    }

    final case class GetBotChannelAssociationOp(
      request: GetBotChannelAssociationRequest
    ) extends LexModelBuildingOp[GetBotChannelAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBotChannelAssociationResponse] =
        visitor.getBotChannelAssociation(request)
    }

    final case class GetBotChannelAssociationsOp(
      request: GetBotChannelAssociationsRequest
    ) extends LexModelBuildingOp[GetBotChannelAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBotChannelAssociationsResponse] =
        visitor.getBotChannelAssociations(request)
    }

    final case class GetBotVersionsOp(
      request: GetBotVersionsRequest
    ) extends LexModelBuildingOp[GetBotVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBotVersionsResponse] =
        visitor.getBotVersions(request)
    }

    final case class GetBotsOp(
      request: GetBotsRequest
    ) extends LexModelBuildingOp[GetBotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBotsResponse] =
        visitor.getBots(request)
    }

    final case class GetBuiltinIntentOp(
      request: GetBuiltinIntentRequest
    ) extends LexModelBuildingOp[GetBuiltinIntentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBuiltinIntentResponse] =
        visitor.getBuiltinIntent(request)
    }

    final case class GetBuiltinIntentsOp(
      request: GetBuiltinIntentsRequest
    ) extends LexModelBuildingOp[GetBuiltinIntentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBuiltinIntentsResponse] =
        visitor.getBuiltinIntents(request)
    }

    final case class GetBuiltinSlotTypesOp(
      request: GetBuiltinSlotTypesRequest
    ) extends LexModelBuildingOp[GetBuiltinSlotTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBuiltinSlotTypesResponse] =
        visitor.getBuiltinSlotTypes(request)
    }

    final case class GetExportOp(
      request: GetExportRequest
    ) extends LexModelBuildingOp[GetExportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetExportResponse] =
        visitor.getExport(request)
    }

    final case class GetImportOp(
      request: GetImportRequest
    ) extends LexModelBuildingOp[GetImportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetImportResponse] =
        visitor.getImport(request)
    }

    final case class GetIntentOp(
      request: GetIntentRequest
    ) extends LexModelBuildingOp[GetIntentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIntentResponse] =
        visitor.getIntent(request)
    }

    final case class GetIntentVersionsOp(
      request: GetIntentVersionsRequest
    ) extends LexModelBuildingOp[GetIntentVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIntentVersionsResponse] =
        visitor.getIntentVersions(request)
    }

    final case class GetIntentsOp(
      request: GetIntentsRequest
    ) extends LexModelBuildingOp[GetIntentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIntentsResponse] =
        visitor.getIntents(request)
    }

    final case class GetSlotTypeOp(
      request: GetSlotTypeRequest
    ) extends LexModelBuildingOp[GetSlotTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSlotTypeResponse] =
        visitor.getSlotType(request)
    }

    final case class GetSlotTypeVersionsOp(
      request: GetSlotTypeVersionsRequest
    ) extends LexModelBuildingOp[GetSlotTypeVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSlotTypeVersionsResponse] =
        visitor.getSlotTypeVersions(request)
    }

    final case class GetSlotTypesOp(
      request: GetSlotTypesRequest
    ) extends LexModelBuildingOp[GetSlotTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSlotTypesResponse] =
        visitor.getSlotTypes(request)
    }

    final case class GetUtterancesViewOp(
      request: GetUtterancesViewRequest
    ) extends LexModelBuildingOp[GetUtterancesViewResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUtterancesViewResponse] =
        visitor.getUtterancesView(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends LexModelBuildingOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutBotOp(
      request: PutBotRequest
    ) extends LexModelBuildingOp[PutBotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBotResponse] =
        visitor.putBot(request)
    }

    final case class PutBotAliasOp(
      request: PutBotAliasRequest
    ) extends LexModelBuildingOp[PutBotAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBotAliasResponse] =
        visitor.putBotAlias(request)
    }

    final case class PutIntentOp(
      request: PutIntentRequest
    ) extends LexModelBuildingOp[PutIntentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutIntentResponse] =
        visitor.putIntent(request)
    }

    final case class PutSlotTypeOp(
      request: PutSlotTypeRequest
    ) extends LexModelBuildingOp[PutSlotTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutSlotTypeResponse] =
        visitor.putSlotType(request)
    }

    final case class StartImportOp(
      request: StartImportRequest
    ) extends LexModelBuildingOp[StartImportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartImportResponse] =
        visitor.startImport(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends LexModelBuildingOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends LexModelBuildingOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import LexModelBuildingOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[LexModelBuildingOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createBotVersion(
    request: CreateBotVersionRequest
  ): LexModelBuildingIO[CreateBotVersionResponse] =
    FF.liftF(CreateBotVersionOp(request))

  def createIntentVersion(
    request: CreateIntentVersionRequest
  ): LexModelBuildingIO[CreateIntentVersionResponse] =
    FF.liftF(CreateIntentVersionOp(request))

  def createSlotTypeVersion(
    request: CreateSlotTypeVersionRequest
  ): LexModelBuildingIO[CreateSlotTypeVersionResponse] =
    FF.liftF(CreateSlotTypeVersionOp(request))

  def deleteBot(
    request: DeleteBotRequest
  ): LexModelBuildingIO[DeleteBotResponse] =
    FF.liftF(DeleteBotOp(request))

  def deleteBotAlias(
    request: DeleteBotAliasRequest
  ): LexModelBuildingIO[DeleteBotAliasResponse] =
    FF.liftF(DeleteBotAliasOp(request))

  def deleteBotChannelAssociation(
    request: DeleteBotChannelAssociationRequest
  ): LexModelBuildingIO[DeleteBotChannelAssociationResponse] =
    FF.liftF(DeleteBotChannelAssociationOp(request))

  def deleteBotVersion(
    request: DeleteBotVersionRequest
  ): LexModelBuildingIO[DeleteBotVersionResponse] =
    FF.liftF(DeleteBotVersionOp(request))

  def deleteIntent(
    request: DeleteIntentRequest
  ): LexModelBuildingIO[DeleteIntentResponse] =
    FF.liftF(DeleteIntentOp(request))

  def deleteIntentVersion(
    request: DeleteIntentVersionRequest
  ): LexModelBuildingIO[DeleteIntentVersionResponse] =
    FF.liftF(DeleteIntentVersionOp(request))

  def deleteSlotType(
    request: DeleteSlotTypeRequest
  ): LexModelBuildingIO[DeleteSlotTypeResponse] =
    FF.liftF(DeleteSlotTypeOp(request))

  def deleteSlotTypeVersion(
    request: DeleteSlotTypeVersionRequest
  ): LexModelBuildingIO[DeleteSlotTypeVersionResponse] =
    FF.liftF(DeleteSlotTypeVersionOp(request))

  def deleteUtterances(
    request: DeleteUtterancesRequest
  ): LexModelBuildingIO[DeleteUtterancesResponse] =
    FF.liftF(DeleteUtterancesOp(request))

  def getBot(
    request: GetBotRequest
  ): LexModelBuildingIO[GetBotResponse] =
    FF.liftF(GetBotOp(request))

  def getBotAlias(
    request: GetBotAliasRequest
  ): LexModelBuildingIO[GetBotAliasResponse] =
    FF.liftF(GetBotAliasOp(request))

  def getBotAliases(
    request: GetBotAliasesRequest
  ): LexModelBuildingIO[GetBotAliasesResponse] =
    FF.liftF(GetBotAliasesOp(request))

  def getBotChannelAssociation(
    request: GetBotChannelAssociationRequest
  ): LexModelBuildingIO[GetBotChannelAssociationResponse] =
    FF.liftF(GetBotChannelAssociationOp(request))

  def getBotChannelAssociations(
    request: GetBotChannelAssociationsRequest
  ): LexModelBuildingIO[GetBotChannelAssociationsResponse] =
    FF.liftF(GetBotChannelAssociationsOp(request))

  def getBotVersions(
    request: GetBotVersionsRequest
  ): LexModelBuildingIO[GetBotVersionsResponse] =
    FF.liftF(GetBotVersionsOp(request))

  def getBots(
    request: GetBotsRequest
  ): LexModelBuildingIO[GetBotsResponse] =
    FF.liftF(GetBotsOp(request))

  def getBuiltinIntent(
    request: GetBuiltinIntentRequest
  ): LexModelBuildingIO[GetBuiltinIntentResponse] =
    FF.liftF(GetBuiltinIntentOp(request))

  def getBuiltinIntents(
    request: GetBuiltinIntentsRequest
  ): LexModelBuildingIO[GetBuiltinIntentsResponse] =
    FF.liftF(GetBuiltinIntentsOp(request))

  def getBuiltinSlotTypes(
    request: GetBuiltinSlotTypesRequest
  ): LexModelBuildingIO[GetBuiltinSlotTypesResponse] =
    FF.liftF(GetBuiltinSlotTypesOp(request))

  def getExport(
    request: GetExportRequest
  ): LexModelBuildingIO[GetExportResponse] =
    FF.liftF(GetExportOp(request))

  def getImport(
    request: GetImportRequest
  ): LexModelBuildingIO[GetImportResponse] =
    FF.liftF(GetImportOp(request))

  def getIntent(
    request: GetIntentRequest
  ): LexModelBuildingIO[GetIntentResponse] =
    FF.liftF(GetIntentOp(request))

  def getIntentVersions(
    request: GetIntentVersionsRequest
  ): LexModelBuildingIO[GetIntentVersionsResponse] =
    FF.liftF(GetIntentVersionsOp(request))

  def getIntents(
    request: GetIntentsRequest
  ): LexModelBuildingIO[GetIntentsResponse] =
    FF.liftF(GetIntentsOp(request))

  def getSlotType(
    request: GetSlotTypeRequest
  ): LexModelBuildingIO[GetSlotTypeResponse] =
    FF.liftF(GetSlotTypeOp(request))

  def getSlotTypeVersions(
    request: GetSlotTypeVersionsRequest
  ): LexModelBuildingIO[GetSlotTypeVersionsResponse] =
    FF.liftF(GetSlotTypeVersionsOp(request))

  def getSlotTypes(
    request: GetSlotTypesRequest
  ): LexModelBuildingIO[GetSlotTypesResponse] =
    FF.liftF(GetSlotTypesOp(request))

  def getUtterancesView(
    request: GetUtterancesViewRequest
  ): LexModelBuildingIO[GetUtterancesViewResponse] =
    FF.liftF(GetUtterancesViewOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): LexModelBuildingIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putBot(
    request: PutBotRequest
  ): LexModelBuildingIO[PutBotResponse] =
    FF.liftF(PutBotOp(request))

  def putBotAlias(
    request: PutBotAliasRequest
  ): LexModelBuildingIO[PutBotAliasResponse] =
    FF.liftF(PutBotAliasOp(request))

  def putIntent(
    request: PutIntentRequest
  ): LexModelBuildingIO[PutIntentResponse] =
    FF.liftF(PutIntentOp(request))

  def putSlotType(
    request: PutSlotTypeRequest
  ): LexModelBuildingIO[PutSlotTypeResponse] =
    FF.liftF(PutSlotTypeOp(request))

  def startImport(
    request: StartImportRequest
  ): LexModelBuildingIO[StartImportResponse] =
    FF.liftF(StartImportOp(request))

  def tagResource(
    request: TagResourceRequest
  ): LexModelBuildingIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): LexModelBuildingIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
