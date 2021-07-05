package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.accessanalyzer.AccessAnalyzerClient
import software.amazon.awssdk.services.accessanalyzer.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object accessanalyzer { module =>

  // Free monad over AccessAnalyzerOp
  type AccessAnalyzerIO[A] = FF[AccessAnalyzerOp, A]

  sealed trait AccessAnalyzerOp[A] {
    def visit[F[_]](visitor: AccessAnalyzerOp.Visitor[F]): F[A]
  }

  object AccessAnalyzerOp {
    // Given a AccessAnalyzerClient we can embed a AccessAnalyzerIO program in any algebra that understands embedding.
    implicit val AccessAnalyzerOpEmbeddable: Embeddable[AccessAnalyzerOp, AccessAnalyzerClient] = new Embeddable[AccessAnalyzerOp, AccessAnalyzerClient] {
      def embed[A](client: AccessAnalyzerClient, io: AccessAnalyzerIO[A]): Embedded[A] = Embedded.AccessAnalyzer(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends AccessAnalyzerOp.Visitor[Kleisli[M, AccessAnalyzerClient, *]] {
        def applyArchiveRule(
          request: ApplyArchiveRuleRequest
        ): Kleisli[M, AccessAnalyzerClient, ApplyArchiveRuleResponse] =
          primitive(_.applyArchiveRule(request))

        def cancelPolicyGeneration(
          request: CancelPolicyGenerationRequest
        ): Kleisli[M, AccessAnalyzerClient, CancelPolicyGenerationResponse] =
          primitive(_.cancelPolicyGeneration(request))

        def createAccessPreview(
          request: CreateAccessPreviewRequest
        ): Kleisli[M, AccessAnalyzerClient, CreateAccessPreviewResponse] =
          primitive(_.createAccessPreview(request))

        def createAnalyzer(
          request: CreateAnalyzerRequest
        ): Kleisli[M, AccessAnalyzerClient, CreateAnalyzerResponse] =
          primitive(_.createAnalyzer(request))

        def createArchiveRule(
          request: CreateArchiveRuleRequest
        ): Kleisli[M, AccessAnalyzerClient, CreateArchiveRuleResponse] =
          primitive(_.createArchiveRule(request))

        def deleteAnalyzer(
          request: DeleteAnalyzerRequest
        ): Kleisli[M, AccessAnalyzerClient, DeleteAnalyzerResponse] =
          primitive(_.deleteAnalyzer(request))

        def deleteArchiveRule(
          request: DeleteArchiveRuleRequest
        ): Kleisli[M, AccessAnalyzerClient, DeleteArchiveRuleResponse] =
          primitive(_.deleteArchiveRule(request))

        def getAccessPreview(
          request: GetAccessPreviewRequest
        ): Kleisli[M, AccessAnalyzerClient, GetAccessPreviewResponse] =
          primitive(_.getAccessPreview(request))

        def getAnalyzedResource(
          request: GetAnalyzedResourceRequest
        ): Kleisli[M, AccessAnalyzerClient, GetAnalyzedResourceResponse] =
          primitive(_.getAnalyzedResource(request))

        def getAnalyzer(
          request: GetAnalyzerRequest
        ): Kleisli[M, AccessAnalyzerClient, GetAnalyzerResponse] =
          primitive(_.getAnalyzer(request))

        def getArchiveRule(
          request: GetArchiveRuleRequest
        ): Kleisli[M, AccessAnalyzerClient, GetArchiveRuleResponse] =
          primitive(_.getArchiveRule(request))

        def getFinding(
          request: GetFindingRequest
        ): Kleisli[M, AccessAnalyzerClient, GetFindingResponse] =
          primitive(_.getFinding(request))

        def getGeneratedPolicy(
          request: GetGeneratedPolicyRequest
        ): Kleisli[M, AccessAnalyzerClient, GetGeneratedPolicyResponse] =
          primitive(_.getGeneratedPolicy(request))

        def listAccessPreviewFindings(
          request: ListAccessPreviewFindingsRequest
        ): Kleisli[M, AccessAnalyzerClient, ListAccessPreviewFindingsResponse] =
          primitive(_.listAccessPreviewFindings(request))

        def listAccessPreviews(
          request: ListAccessPreviewsRequest
        ): Kleisli[M, AccessAnalyzerClient, ListAccessPreviewsResponse] =
          primitive(_.listAccessPreviews(request))

        def listAnalyzedResources(
          request: ListAnalyzedResourcesRequest
        ): Kleisli[M, AccessAnalyzerClient, ListAnalyzedResourcesResponse] =
          primitive(_.listAnalyzedResources(request))

        def listAnalyzers(
          request: ListAnalyzersRequest
        ): Kleisli[M, AccessAnalyzerClient, ListAnalyzersResponse] =
          primitive(_.listAnalyzers(request))

        def listArchiveRules(
          request: ListArchiveRulesRequest
        ): Kleisli[M, AccessAnalyzerClient, ListArchiveRulesResponse] =
          primitive(_.listArchiveRules(request))

        def listFindings(
          request: ListFindingsRequest
        ): Kleisli[M, AccessAnalyzerClient, ListFindingsResponse] =
          primitive(_.listFindings(request))

        def listPolicyGenerations(
          request: ListPolicyGenerationsRequest
        ): Kleisli[M, AccessAnalyzerClient, ListPolicyGenerationsResponse] =
          primitive(_.listPolicyGenerations(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, AccessAnalyzerClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def startPolicyGeneration(
          request: StartPolicyGenerationRequest
        ): Kleisli[M, AccessAnalyzerClient, StartPolicyGenerationResponse] =
          primitive(_.startPolicyGeneration(request))

        def startResourceScan(
          request: StartResourceScanRequest
        ): Kleisli[M, AccessAnalyzerClient, StartResourceScanResponse] =
          primitive(_.startResourceScan(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, AccessAnalyzerClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, AccessAnalyzerClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateArchiveRule(
          request: UpdateArchiveRuleRequest
        ): Kleisli[M, AccessAnalyzerClient, UpdateArchiveRuleResponse] =
          primitive(_.updateArchiveRule(request))

        def updateFindings(
          request: UpdateFindingsRequest
        ): Kleisli[M, AccessAnalyzerClient, UpdateFindingsResponse] =
          primitive(_.updateFindings(request))

        def validatePolicy(
          request: ValidatePolicyRequest
        ): Kleisli[M, AccessAnalyzerClient, ValidatePolicyResponse] =
          primitive(_.validatePolicy(request))

        def primitive[A](
          f: AccessAnalyzerClient => A
        ): Kleisli[M, AccessAnalyzerClient, A]
      }
    }

    trait Visitor[F[_]] extends (AccessAnalyzerOp ~> F) {
      final def apply[A](op: AccessAnalyzerOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def applyArchiveRule(
        request: ApplyArchiveRuleRequest
      ): F[ApplyArchiveRuleResponse]

      def cancelPolicyGeneration(
        request: CancelPolicyGenerationRequest
      ): F[CancelPolicyGenerationResponse]

      def createAccessPreview(
        request: CreateAccessPreviewRequest
      ): F[CreateAccessPreviewResponse]

      def createAnalyzer(
        request: CreateAnalyzerRequest
      ): F[CreateAnalyzerResponse]

      def createArchiveRule(
        request: CreateArchiveRuleRequest
      ): F[CreateArchiveRuleResponse]

      def deleteAnalyzer(
        request: DeleteAnalyzerRequest
      ): F[DeleteAnalyzerResponse]

      def deleteArchiveRule(
        request: DeleteArchiveRuleRequest
      ): F[DeleteArchiveRuleResponse]

      def getAccessPreview(
        request: GetAccessPreviewRequest
      ): F[GetAccessPreviewResponse]

      def getAnalyzedResource(
        request: GetAnalyzedResourceRequest
      ): F[GetAnalyzedResourceResponse]

      def getAnalyzer(
        request: GetAnalyzerRequest
      ): F[GetAnalyzerResponse]

      def getArchiveRule(
        request: GetArchiveRuleRequest
      ): F[GetArchiveRuleResponse]

      def getFinding(
        request: GetFindingRequest
      ): F[GetFindingResponse]

      def getGeneratedPolicy(
        request: GetGeneratedPolicyRequest
      ): F[GetGeneratedPolicyResponse]

      def listAccessPreviewFindings(
        request: ListAccessPreviewFindingsRequest
      ): F[ListAccessPreviewFindingsResponse]

      def listAccessPreviews(
        request: ListAccessPreviewsRequest
      ): F[ListAccessPreviewsResponse]

      def listAnalyzedResources(
        request: ListAnalyzedResourcesRequest
      ): F[ListAnalyzedResourcesResponse]

      def listAnalyzers(
        request: ListAnalyzersRequest
      ): F[ListAnalyzersResponse]

      def listArchiveRules(
        request: ListArchiveRulesRequest
      ): F[ListArchiveRulesResponse]

      def listFindings(
        request: ListFindingsRequest
      ): F[ListFindingsResponse]

      def listPolicyGenerations(
        request: ListPolicyGenerationsRequest
      ): F[ListPolicyGenerationsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def startPolicyGeneration(
        request: StartPolicyGenerationRequest
      ): F[StartPolicyGenerationResponse]

      def startResourceScan(
        request: StartResourceScanRequest
      ): F[StartResourceScanResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateArchiveRule(
        request: UpdateArchiveRuleRequest
      ): F[UpdateArchiveRuleResponse]

      def updateFindings(
        request: UpdateFindingsRequest
      ): F[UpdateFindingsResponse]

      def validatePolicy(
        request: ValidatePolicyRequest
      ): F[ValidatePolicyResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends AccessAnalyzerOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class ApplyArchiveRuleOp(
      request: ApplyArchiveRuleRequest
    ) extends AccessAnalyzerOp[ApplyArchiveRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ApplyArchiveRuleResponse] =
        visitor.applyArchiveRule(request)
    }

    final case class CancelPolicyGenerationOp(
      request: CancelPolicyGenerationRequest
    ) extends AccessAnalyzerOp[CancelPolicyGenerationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelPolicyGenerationResponse] =
        visitor.cancelPolicyGeneration(request)
    }

    final case class CreateAccessPreviewOp(
      request: CreateAccessPreviewRequest
    ) extends AccessAnalyzerOp[CreateAccessPreviewResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAccessPreviewResponse] =
        visitor.createAccessPreview(request)
    }

    final case class CreateAnalyzerOp(
      request: CreateAnalyzerRequest
    ) extends AccessAnalyzerOp[CreateAnalyzerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAnalyzerResponse] =
        visitor.createAnalyzer(request)
    }

    final case class CreateArchiveRuleOp(
      request: CreateArchiveRuleRequest
    ) extends AccessAnalyzerOp[CreateArchiveRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateArchiveRuleResponse] =
        visitor.createArchiveRule(request)
    }

    final case class DeleteAnalyzerOp(
      request: DeleteAnalyzerRequest
    ) extends AccessAnalyzerOp[DeleteAnalyzerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAnalyzerResponse] =
        visitor.deleteAnalyzer(request)
    }

    final case class DeleteArchiveRuleOp(
      request: DeleteArchiveRuleRequest
    ) extends AccessAnalyzerOp[DeleteArchiveRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteArchiveRuleResponse] =
        visitor.deleteArchiveRule(request)
    }

    final case class GetAccessPreviewOp(
      request: GetAccessPreviewRequest
    ) extends AccessAnalyzerOp[GetAccessPreviewResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccessPreviewResponse] =
        visitor.getAccessPreview(request)
    }

    final case class GetAnalyzedResourceOp(
      request: GetAnalyzedResourceRequest
    ) extends AccessAnalyzerOp[GetAnalyzedResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAnalyzedResourceResponse] =
        visitor.getAnalyzedResource(request)
    }

    final case class GetAnalyzerOp(
      request: GetAnalyzerRequest
    ) extends AccessAnalyzerOp[GetAnalyzerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAnalyzerResponse] =
        visitor.getAnalyzer(request)
    }

    final case class GetArchiveRuleOp(
      request: GetArchiveRuleRequest
    ) extends AccessAnalyzerOp[GetArchiveRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetArchiveRuleResponse] =
        visitor.getArchiveRule(request)
    }

    final case class GetFindingOp(
      request: GetFindingRequest
    ) extends AccessAnalyzerOp[GetFindingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFindingResponse] =
        visitor.getFinding(request)
    }

    final case class GetGeneratedPolicyOp(
      request: GetGeneratedPolicyRequest
    ) extends AccessAnalyzerOp[GetGeneratedPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGeneratedPolicyResponse] =
        visitor.getGeneratedPolicy(request)
    }

    final case class ListAccessPreviewFindingsOp(
      request: ListAccessPreviewFindingsRequest
    ) extends AccessAnalyzerOp[ListAccessPreviewFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccessPreviewFindingsResponse] =
        visitor.listAccessPreviewFindings(request)
    }

    final case class ListAccessPreviewsOp(
      request: ListAccessPreviewsRequest
    ) extends AccessAnalyzerOp[ListAccessPreviewsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccessPreviewsResponse] =
        visitor.listAccessPreviews(request)
    }

    final case class ListAnalyzedResourcesOp(
      request: ListAnalyzedResourcesRequest
    ) extends AccessAnalyzerOp[ListAnalyzedResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAnalyzedResourcesResponse] =
        visitor.listAnalyzedResources(request)
    }

    final case class ListAnalyzersOp(
      request: ListAnalyzersRequest
    ) extends AccessAnalyzerOp[ListAnalyzersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAnalyzersResponse] =
        visitor.listAnalyzers(request)
    }

    final case class ListArchiveRulesOp(
      request: ListArchiveRulesRequest
    ) extends AccessAnalyzerOp[ListArchiveRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListArchiveRulesResponse] =
        visitor.listArchiveRules(request)
    }

    final case class ListFindingsOp(
      request: ListFindingsRequest
    ) extends AccessAnalyzerOp[ListFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFindingsResponse] =
        visitor.listFindings(request)
    }

    final case class ListPolicyGenerationsOp(
      request: ListPolicyGenerationsRequest
    ) extends AccessAnalyzerOp[ListPolicyGenerationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPolicyGenerationsResponse] =
        visitor.listPolicyGenerations(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends AccessAnalyzerOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class StartPolicyGenerationOp(
      request: StartPolicyGenerationRequest
    ) extends AccessAnalyzerOp[StartPolicyGenerationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartPolicyGenerationResponse] =
        visitor.startPolicyGeneration(request)
    }

    final case class StartResourceScanOp(
      request: StartResourceScanRequest
    ) extends AccessAnalyzerOp[StartResourceScanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartResourceScanResponse] =
        visitor.startResourceScan(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends AccessAnalyzerOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends AccessAnalyzerOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateArchiveRuleOp(
      request: UpdateArchiveRuleRequest
    ) extends AccessAnalyzerOp[UpdateArchiveRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateArchiveRuleResponse] =
        visitor.updateArchiveRule(request)
    }

    final case class UpdateFindingsOp(
      request: UpdateFindingsRequest
    ) extends AccessAnalyzerOp[UpdateFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFindingsResponse] =
        visitor.updateFindings(request)
    }

    final case class ValidatePolicyOp(
      request: ValidatePolicyRequest
    ) extends AccessAnalyzerOp[ValidatePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ValidatePolicyResponse] =
        visitor.validatePolicy(request)
    }
  }

  import AccessAnalyzerOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[AccessAnalyzerOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def applyArchiveRule(
    request: ApplyArchiveRuleRequest
  ): AccessAnalyzerIO[ApplyArchiveRuleResponse] =
    FF.liftF(ApplyArchiveRuleOp(request))

  def cancelPolicyGeneration(
    request: CancelPolicyGenerationRequest
  ): AccessAnalyzerIO[CancelPolicyGenerationResponse] =
    FF.liftF(CancelPolicyGenerationOp(request))

  def createAccessPreview(
    request: CreateAccessPreviewRequest
  ): AccessAnalyzerIO[CreateAccessPreviewResponse] =
    FF.liftF(CreateAccessPreviewOp(request))

  def createAnalyzer(
    request: CreateAnalyzerRequest
  ): AccessAnalyzerIO[CreateAnalyzerResponse] =
    FF.liftF(CreateAnalyzerOp(request))

  def createArchiveRule(
    request: CreateArchiveRuleRequest
  ): AccessAnalyzerIO[CreateArchiveRuleResponse] =
    FF.liftF(CreateArchiveRuleOp(request))

  def deleteAnalyzer(
    request: DeleteAnalyzerRequest
  ): AccessAnalyzerIO[DeleteAnalyzerResponse] =
    FF.liftF(DeleteAnalyzerOp(request))

  def deleteArchiveRule(
    request: DeleteArchiveRuleRequest
  ): AccessAnalyzerIO[DeleteArchiveRuleResponse] =
    FF.liftF(DeleteArchiveRuleOp(request))

  def getAccessPreview(
    request: GetAccessPreviewRequest
  ): AccessAnalyzerIO[GetAccessPreviewResponse] =
    FF.liftF(GetAccessPreviewOp(request))

  def getAnalyzedResource(
    request: GetAnalyzedResourceRequest
  ): AccessAnalyzerIO[GetAnalyzedResourceResponse] =
    FF.liftF(GetAnalyzedResourceOp(request))

  def getAnalyzer(
    request: GetAnalyzerRequest
  ): AccessAnalyzerIO[GetAnalyzerResponse] =
    FF.liftF(GetAnalyzerOp(request))

  def getArchiveRule(
    request: GetArchiveRuleRequest
  ): AccessAnalyzerIO[GetArchiveRuleResponse] =
    FF.liftF(GetArchiveRuleOp(request))

  def getFinding(
    request: GetFindingRequest
  ): AccessAnalyzerIO[GetFindingResponse] =
    FF.liftF(GetFindingOp(request))

  def getGeneratedPolicy(
    request: GetGeneratedPolicyRequest
  ): AccessAnalyzerIO[GetGeneratedPolicyResponse] =
    FF.liftF(GetGeneratedPolicyOp(request))

  def listAccessPreviewFindings(
    request: ListAccessPreviewFindingsRequest
  ): AccessAnalyzerIO[ListAccessPreviewFindingsResponse] =
    FF.liftF(ListAccessPreviewFindingsOp(request))

  def listAccessPreviews(
    request: ListAccessPreviewsRequest
  ): AccessAnalyzerIO[ListAccessPreviewsResponse] =
    FF.liftF(ListAccessPreviewsOp(request))

  def listAnalyzedResources(
    request: ListAnalyzedResourcesRequest
  ): AccessAnalyzerIO[ListAnalyzedResourcesResponse] =
    FF.liftF(ListAnalyzedResourcesOp(request))

  def listAnalyzers(
    request: ListAnalyzersRequest
  ): AccessAnalyzerIO[ListAnalyzersResponse] =
    FF.liftF(ListAnalyzersOp(request))

  def listArchiveRules(
    request: ListArchiveRulesRequest
  ): AccessAnalyzerIO[ListArchiveRulesResponse] =
    FF.liftF(ListArchiveRulesOp(request))

  def listFindings(
    request: ListFindingsRequest
  ): AccessAnalyzerIO[ListFindingsResponse] =
    FF.liftF(ListFindingsOp(request))

  def listPolicyGenerations(
    request: ListPolicyGenerationsRequest
  ): AccessAnalyzerIO[ListPolicyGenerationsResponse] =
    FF.liftF(ListPolicyGenerationsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): AccessAnalyzerIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def startPolicyGeneration(
    request: StartPolicyGenerationRequest
  ): AccessAnalyzerIO[StartPolicyGenerationResponse] =
    FF.liftF(StartPolicyGenerationOp(request))

  def startResourceScan(
    request: StartResourceScanRequest
  ): AccessAnalyzerIO[StartResourceScanResponse] =
    FF.liftF(StartResourceScanOp(request))

  def tagResource(
    request: TagResourceRequest
  ): AccessAnalyzerIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): AccessAnalyzerIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateArchiveRule(
    request: UpdateArchiveRuleRequest
  ): AccessAnalyzerIO[UpdateArchiveRuleResponse] =
    FF.liftF(UpdateArchiveRuleOp(request))

  def updateFindings(
    request: UpdateFindingsRequest
  ): AccessAnalyzerIO[UpdateFindingsResponse] =
    FF.liftF(UpdateFindingsOp(request))

  def validatePolicy(
    request: ValidatePolicyRequest
  ): AccessAnalyzerIO[ValidatePolicyResponse] =
    FF.liftF(ValidatePolicyOp(request))
}
