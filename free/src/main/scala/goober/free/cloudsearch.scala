package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.cloudsearch.CloudSearchClient
import software.amazon.awssdk.services.cloudsearch.model._


object cloudsearch { module =>

  // Free monad over CloudSearchOp
  type CloudSearchIO[A] = FF[CloudSearchOp, A]

  sealed trait CloudSearchOp[A] {
    def visit[F[_]](visitor: CloudSearchOp.Visitor[F]): F[A]
  }

  object CloudSearchOp {
    // Given a CloudSearchClient we can embed a CloudSearchIO program in any algebra that understands embedding.
    implicit val CloudSearchOpEmbeddable: Embeddable[CloudSearchOp, CloudSearchClient] = new Embeddable[CloudSearchOp, CloudSearchClient] {
      def embed[A](client: CloudSearchClient, io: CloudSearchIO[A]): Embedded[A] = Embedded.CloudSearch(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CloudSearchOp.Visitor[Kleisli[M, CloudSearchClient, *]] {
        def buildSuggesters(
          request: BuildSuggestersRequest
        ): Kleisli[M, CloudSearchClient, BuildSuggestersResponse] =
          primitive(_.buildSuggesters(request))

        def createDomain(
          request: CreateDomainRequest
        ): Kleisli[M, CloudSearchClient, CreateDomainResponse] =
          primitive(_.createDomain(request))

        def defineAnalysisScheme(
          request: DefineAnalysisSchemeRequest
        ): Kleisli[M, CloudSearchClient, DefineAnalysisSchemeResponse] =
          primitive(_.defineAnalysisScheme(request))

        def defineExpression(
          request: DefineExpressionRequest
        ): Kleisli[M, CloudSearchClient, DefineExpressionResponse] =
          primitive(_.defineExpression(request))

        def defineIndexField(
          request: DefineIndexFieldRequest
        ): Kleisli[M, CloudSearchClient, DefineIndexFieldResponse] =
          primitive(_.defineIndexField(request))

        def defineSuggester(
          request: DefineSuggesterRequest
        ): Kleisli[M, CloudSearchClient, DefineSuggesterResponse] =
          primitive(_.defineSuggester(request))

        def deleteAnalysisScheme(
          request: DeleteAnalysisSchemeRequest
        ): Kleisli[M, CloudSearchClient, DeleteAnalysisSchemeResponse] =
          primitive(_.deleteAnalysisScheme(request))

        def deleteDomain(
          request: DeleteDomainRequest
        ): Kleisli[M, CloudSearchClient, DeleteDomainResponse] =
          primitive(_.deleteDomain(request))

        def deleteExpression(
          request: DeleteExpressionRequest
        ): Kleisli[M, CloudSearchClient, DeleteExpressionResponse] =
          primitive(_.deleteExpression(request))

        def deleteIndexField(
          request: DeleteIndexFieldRequest
        ): Kleisli[M, CloudSearchClient, DeleteIndexFieldResponse] =
          primitive(_.deleteIndexField(request))

        def deleteSuggester(
          request: DeleteSuggesterRequest
        ): Kleisli[M, CloudSearchClient, DeleteSuggesterResponse] =
          primitive(_.deleteSuggester(request))

        def describeAnalysisSchemes(
          request: DescribeAnalysisSchemesRequest
        ): Kleisli[M, CloudSearchClient, DescribeAnalysisSchemesResponse] =
          primitive(_.describeAnalysisSchemes(request))

        def describeAvailabilityOptions(
          request: DescribeAvailabilityOptionsRequest
        ): Kleisli[M, CloudSearchClient, DescribeAvailabilityOptionsResponse] =
          primitive(_.describeAvailabilityOptions(request))

        def describeDomainEndpointOptions(
          request: DescribeDomainEndpointOptionsRequest
        ): Kleisli[M, CloudSearchClient, DescribeDomainEndpointOptionsResponse] =
          primitive(_.describeDomainEndpointOptions(request))

        def describeDomains(
          request: DescribeDomainsRequest
        ): Kleisli[M, CloudSearchClient, DescribeDomainsResponse] =
          primitive(_.describeDomains(request))

        def describeExpressions(
          request: DescribeExpressionsRequest
        ): Kleisli[M, CloudSearchClient, DescribeExpressionsResponse] =
          primitive(_.describeExpressions(request))

        def describeIndexFields(
          request: DescribeIndexFieldsRequest
        ): Kleisli[M, CloudSearchClient, DescribeIndexFieldsResponse] =
          primitive(_.describeIndexFields(request))

        def describeScalingParameters(
          request: DescribeScalingParametersRequest
        ): Kleisli[M, CloudSearchClient, DescribeScalingParametersResponse] =
          primitive(_.describeScalingParameters(request))

        def describeServiceAccessPolicies(
          request: DescribeServiceAccessPoliciesRequest
        ): Kleisli[M, CloudSearchClient, DescribeServiceAccessPoliciesResponse] =
          primitive(_.describeServiceAccessPolicies(request))

        def describeSuggesters(
          request: DescribeSuggestersRequest
        ): Kleisli[M, CloudSearchClient, DescribeSuggestersResponse] =
          primitive(_.describeSuggesters(request))

        def indexDocuments(
          request: IndexDocumentsRequest
        ): Kleisli[M, CloudSearchClient, IndexDocumentsResponse] =
          primitive(_.indexDocuments(request))

        def listDomainNames(
          request: ListDomainNamesRequest
        ): Kleisli[M, CloudSearchClient, ListDomainNamesResponse] =
          primitive(_.listDomainNames(request))

        def updateAvailabilityOptions(
          request: UpdateAvailabilityOptionsRequest
        ): Kleisli[M, CloudSearchClient, UpdateAvailabilityOptionsResponse] =
          primitive(_.updateAvailabilityOptions(request))

        def updateDomainEndpointOptions(
          request: UpdateDomainEndpointOptionsRequest
        ): Kleisli[M, CloudSearchClient, UpdateDomainEndpointOptionsResponse] =
          primitive(_.updateDomainEndpointOptions(request))

        def updateScalingParameters(
          request: UpdateScalingParametersRequest
        ): Kleisli[M, CloudSearchClient, UpdateScalingParametersResponse] =
          primitive(_.updateScalingParameters(request))

        def updateServiceAccessPolicies(
          request: UpdateServiceAccessPoliciesRequest
        ): Kleisli[M, CloudSearchClient, UpdateServiceAccessPoliciesResponse] =
          primitive(_.updateServiceAccessPolicies(request))

        def primitive[A](
          f: CloudSearchClient => A
        ): Kleisli[M, CloudSearchClient, A]
      }
    }

    trait Visitor[F[_]] extends (CloudSearchOp ~> F) {
      final def apply[A](op: CloudSearchOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def buildSuggesters(
        request: BuildSuggestersRequest
      ): F[BuildSuggestersResponse]

      def createDomain(
        request: CreateDomainRequest
      ): F[CreateDomainResponse]

      def defineAnalysisScheme(
        request: DefineAnalysisSchemeRequest
      ): F[DefineAnalysisSchemeResponse]

      def defineExpression(
        request: DefineExpressionRequest
      ): F[DefineExpressionResponse]

      def defineIndexField(
        request: DefineIndexFieldRequest
      ): F[DefineIndexFieldResponse]

      def defineSuggester(
        request: DefineSuggesterRequest
      ): F[DefineSuggesterResponse]

      def deleteAnalysisScheme(
        request: DeleteAnalysisSchemeRequest
      ): F[DeleteAnalysisSchemeResponse]

      def deleteDomain(
        request: DeleteDomainRequest
      ): F[DeleteDomainResponse]

      def deleteExpression(
        request: DeleteExpressionRequest
      ): F[DeleteExpressionResponse]

      def deleteIndexField(
        request: DeleteIndexFieldRequest
      ): F[DeleteIndexFieldResponse]

      def deleteSuggester(
        request: DeleteSuggesterRequest
      ): F[DeleteSuggesterResponse]

      def describeAnalysisSchemes(
        request: DescribeAnalysisSchemesRequest
      ): F[DescribeAnalysisSchemesResponse]

      def describeAvailabilityOptions(
        request: DescribeAvailabilityOptionsRequest
      ): F[DescribeAvailabilityOptionsResponse]

      def describeDomainEndpointOptions(
        request: DescribeDomainEndpointOptionsRequest
      ): F[DescribeDomainEndpointOptionsResponse]

      def describeDomains(
        request: DescribeDomainsRequest
      ): F[DescribeDomainsResponse]

      def describeExpressions(
        request: DescribeExpressionsRequest
      ): F[DescribeExpressionsResponse]

      def describeIndexFields(
        request: DescribeIndexFieldsRequest
      ): F[DescribeIndexFieldsResponse]

      def describeScalingParameters(
        request: DescribeScalingParametersRequest
      ): F[DescribeScalingParametersResponse]

      def describeServiceAccessPolicies(
        request: DescribeServiceAccessPoliciesRequest
      ): F[DescribeServiceAccessPoliciesResponse]

      def describeSuggesters(
        request: DescribeSuggestersRequest
      ): F[DescribeSuggestersResponse]

      def indexDocuments(
        request: IndexDocumentsRequest
      ): F[IndexDocumentsResponse]

      def listDomainNames(
        request: ListDomainNamesRequest
      ): F[ListDomainNamesResponse]

      def updateAvailabilityOptions(
        request: UpdateAvailabilityOptionsRequest
      ): F[UpdateAvailabilityOptionsResponse]

      def updateDomainEndpointOptions(
        request: UpdateDomainEndpointOptionsRequest
      ): F[UpdateDomainEndpointOptionsResponse]

      def updateScalingParameters(
        request: UpdateScalingParametersRequest
      ): F[UpdateScalingParametersResponse]

      def updateServiceAccessPolicies(
        request: UpdateServiceAccessPoliciesRequest
      ): F[UpdateServiceAccessPoliciesResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CloudSearchOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BuildSuggestersOp(
      request: BuildSuggestersRequest
    ) extends CloudSearchOp[BuildSuggestersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BuildSuggestersResponse] =
        visitor.buildSuggesters(request)
    }

    final case class CreateDomainOp(
      request: CreateDomainRequest
    ) extends CloudSearchOp[CreateDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDomainResponse] =
        visitor.createDomain(request)
    }

    final case class DefineAnalysisSchemeOp(
      request: DefineAnalysisSchemeRequest
    ) extends CloudSearchOp[DefineAnalysisSchemeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DefineAnalysisSchemeResponse] =
        visitor.defineAnalysisScheme(request)
    }

    final case class DefineExpressionOp(
      request: DefineExpressionRequest
    ) extends CloudSearchOp[DefineExpressionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DefineExpressionResponse] =
        visitor.defineExpression(request)
    }

    final case class DefineIndexFieldOp(
      request: DefineIndexFieldRequest
    ) extends CloudSearchOp[DefineIndexFieldResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DefineIndexFieldResponse] =
        visitor.defineIndexField(request)
    }

    final case class DefineSuggesterOp(
      request: DefineSuggesterRequest
    ) extends CloudSearchOp[DefineSuggesterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DefineSuggesterResponse] =
        visitor.defineSuggester(request)
    }

    final case class DeleteAnalysisSchemeOp(
      request: DeleteAnalysisSchemeRequest
    ) extends CloudSearchOp[DeleteAnalysisSchemeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAnalysisSchemeResponse] =
        visitor.deleteAnalysisScheme(request)
    }

    final case class DeleteDomainOp(
      request: DeleteDomainRequest
    ) extends CloudSearchOp[DeleteDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDomainResponse] =
        visitor.deleteDomain(request)
    }

    final case class DeleteExpressionOp(
      request: DeleteExpressionRequest
    ) extends CloudSearchOp[DeleteExpressionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteExpressionResponse] =
        visitor.deleteExpression(request)
    }

    final case class DeleteIndexFieldOp(
      request: DeleteIndexFieldRequest
    ) extends CloudSearchOp[DeleteIndexFieldResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIndexFieldResponse] =
        visitor.deleteIndexField(request)
    }

    final case class DeleteSuggesterOp(
      request: DeleteSuggesterRequest
    ) extends CloudSearchOp[DeleteSuggesterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSuggesterResponse] =
        visitor.deleteSuggester(request)
    }

    final case class DescribeAnalysisSchemesOp(
      request: DescribeAnalysisSchemesRequest
    ) extends CloudSearchOp[DescribeAnalysisSchemesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAnalysisSchemesResponse] =
        visitor.describeAnalysisSchemes(request)
    }

    final case class DescribeAvailabilityOptionsOp(
      request: DescribeAvailabilityOptionsRequest
    ) extends CloudSearchOp[DescribeAvailabilityOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAvailabilityOptionsResponse] =
        visitor.describeAvailabilityOptions(request)
    }

    final case class DescribeDomainEndpointOptionsOp(
      request: DescribeDomainEndpointOptionsRequest
    ) extends CloudSearchOp[DescribeDomainEndpointOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDomainEndpointOptionsResponse] =
        visitor.describeDomainEndpointOptions(request)
    }

    final case class DescribeDomainsOp(
      request: DescribeDomainsRequest
    ) extends CloudSearchOp[DescribeDomainsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDomainsResponse] =
        visitor.describeDomains(request)
    }

    final case class DescribeExpressionsOp(
      request: DescribeExpressionsRequest
    ) extends CloudSearchOp[DescribeExpressionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeExpressionsResponse] =
        visitor.describeExpressions(request)
    }

    final case class DescribeIndexFieldsOp(
      request: DescribeIndexFieldsRequest
    ) extends CloudSearchOp[DescribeIndexFieldsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeIndexFieldsResponse] =
        visitor.describeIndexFields(request)
    }

    final case class DescribeScalingParametersOp(
      request: DescribeScalingParametersRequest
    ) extends CloudSearchOp[DescribeScalingParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeScalingParametersResponse] =
        visitor.describeScalingParameters(request)
    }

    final case class DescribeServiceAccessPoliciesOp(
      request: DescribeServiceAccessPoliciesRequest
    ) extends CloudSearchOp[DescribeServiceAccessPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeServiceAccessPoliciesResponse] =
        visitor.describeServiceAccessPolicies(request)
    }

    final case class DescribeSuggestersOp(
      request: DescribeSuggestersRequest
    ) extends CloudSearchOp[DescribeSuggestersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSuggestersResponse] =
        visitor.describeSuggesters(request)
    }

    final case class IndexDocumentsOp(
      request: IndexDocumentsRequest
    ) extends CloudSearchOp[IndexDocumentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[IndexDocumentsResponse] =
        visitor.indexDocuments(request)
    }

    final case class ListDomainNamesOp(
      request: ListDomainNamesRequest
    ) extends CloudSearchOp[ListDomainNamesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDomainNamesResponse] =
        visitor.listDomainNames(request)
    }

    final case class UpdateAvailabilityOptionsOp(
      request: UpdateAvailabilityOptionsRequest
    ) extends CloudSearchOp[UpdateAvailabilityOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAvailabilityOptionsResponse] =
        visitor.updateAvailabilityOptions(request)
    }

    final case class UpdateDomainEndpointOptionsOp(
      request: UpdateDomainEndpointOptionsRequest
    ) extends CloudSearchOp[UpdateDomainEndpointOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDomainEndpointOptionsResponse] =
        visitor.updateDomainEndpointOptions(request)
    }

    final case class UpdateScalingParametersOp(
      request: UpdateScalingParametersRequest
    ) extends CloudSearchOp[UpdateScalingParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateScalingParametersResponse] =
        visitor.updateScalingParameters(request)
    }

    final case class UpdateServiceAccessPoliciesOp(
      request: UpdateServiceAccessPoliciesRequest
    ) extends CloudSearchOp[UpdateServiceAccessPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateServiceAccessPoliciesResponse] =
        visitor.updateServiceAccessPolicies(request)
    }
  }

  import CloudSearchOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CloudSearchOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def buildSuggesters(
    request: BuildSuggestersRequest
  ): CloudSearchIO[BuildSuggestersResponse] =
    FF.liftF(BuildSuggestersOp(request))

  def createDomain(
    request: CreateDomainRequest
  ): CloudSearchIO[CreateDomainResponse] =
    FF.liftF(CreateDomainOp(request))

  def defineAnalysisScheme(
    request: DefineAnalysisSchemeRequest
  ): CloudSearchIO[DefineAnalysisSchemeResponse] =
    FF.liftF(DefineAnalysisSchemeOp(request))

  def defineExpression(
    request: DefineExpressionRequest
  ): CloudSearchIO[DefineExpressionResponse] =
    FF.liftF(DefineExpressionOp(request))

  def defineIndexField(
    request: DefineIndexFieldRequest
  ): CloudSearchIO[DefineIndexFieldResponse] =
    FF.liftF(DefineIndexFieldOp(request))

  def defineSuggester(
    request: DefineSuggesterRequest
  ): CloudSearchIO[DefineSuggesterResponse] =
    FF.liftF(DefineSuggesterOp(request))

  def deleteAnalysisScheme(
    request: DeleteAnalysisSchemeRequest
  ): CloudSearchIO[DeleteAnalysisSchemeResponse] =
    FF.liftF(DeleteAnalysisSchemeOp(request))

  def deleteDomain(
    request: DeleteDomainRequest
  ): CloudSearchIO[DeleteDomainResponse] =
    FF.liftF(DeleteDomainOp(request))

  def deleteExpression(
    request: DeleteExpressionRequest
  ): CloudSearchIO[DeleteExpressionResponse] =
    FF.liftF(DeleteExpressionOp(request))

  def deleteIndexField(
    request: DeleteIndexFieldRequest
  ): CloudSearchIO[DeleteIndexFieldResponse] =
    FF.liftF(DeleteIndexFieldOp(request))

  def deleteSuggester(
    request: DeleteSuggesterRequest
  ): CloudSearchIO[DeleteSuggesterResponse] =
    FF.liftF(DeleteSuggesterOp(request))

  def describeAnalysisSchemes(
    request: DescribeAnalysisSchemesRequest
  ): CloudSearchIO[DescribeAnalysisSchemesResponse] =
    FF.liftF(DescribeAnalysisSchemesOp(request))

  def describeAvailabilityOptions(
    request: DescribeAvailabilityOptionsRequest
  ): CloudSearchIO[DescribeAvailabilityOptionsResponse] =
    FF.liftF(DescribeAvailabilityOptionsOp(request))

  def describeDomainEndpointOptions(
    request: DescribeDomainEndpointOptionsRequest
  ): CloudSearchIO[DescribeDomainEndpointOptionsResponse] =
    FF.liftF(DescribeDomainEndpointOptionsOp(request))

  def describeDomains(
    request: DescribeDomainsRequest
  ): CloudSearchIO[DescribeDomainsResponse] =
    FF.liftF(DescribeDomainsOp(request))

  def describeExpressions(
    request: DescribeExpressionsRequest
  ): CloudSearchIO[DescribeExpressionsResponse] =
    FF.liftF(DescribeExpressionsOp(request))

  def describeIndexFields(
    request: DescribeIndexFieldsRequest
  ): CloudSearchIO[DescribeIndexFieldsResponse] =
    FF.liftF(DescribeIndexFieldsOp(request))

  def describeScalingParameters(
    request: DescribeScalingParametersRequest
  ): CloudSearchIO[DescribeScalingParametersResponse] =
    FF.liftF(DescribeScalingParametersOp(request))

  def describeServiceAccessPolicies(
    request: DescribeServiceAccessPoliciesRequest
  ): CloudSearchIO[DescribeServiceAccessPoliciesResponse] =
    FF.liftF(DescribeServiceAccessPoliciesOp(request))

  def describeSuggesters(
    request: DescribeSuggestersRequest
  ): CloudSearchIO[DescribeSuggestersResponse] =
    FF.liftF(DescribeSuggestersOp(request))

  def indexDocuments(
    request: IndexDocumentsRequest
  ): CloudSearchIO[IndexDocumentsResponse] =
    FF.liftF(IndexDocumentsOp(request))

  def listDomainNames(
    request: ListDomainNamesRequest
  ): CloudSearchIO[ListDomainNamesResponse] =
    FF.liftF(ListDomainNamesOp(request))

  def updateAvailabilityOptions(
    request: UpdateAvailabilityOptionsRequest
  ): CloudSearchIO[UpdateAvailabilityOptionsResponse] =
    FF.liftF(UpdateAvailabilityOptionsOp(request))

  def updateDomainEndpointOptions(
    request: UpdateDomainEndpointOptionsRequest
  ): CloudSearchIO[UpdateDomainEndpointOptionsResponse] =
    FF.liftF(UpdateDomainEndpointOptionsOp(request))

  def updateScalingParameters(
    request: UpdateScalingParametersRequest
  ): CloudSearchIO[UpdateScalingParametersResponse] =
    FF.liftF(UpdateScalingParametersOp(request))

  def updateServiceAccessPolicies(
    request: UpdateServiceAccessPoliciesRequest
  ): CloudSearchIO[UpdateServiceAccessPoliciesResponse] =
    FF.liftF(UpdateServiceAccessPoliciesOp(request))
}
