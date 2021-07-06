package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.elasticbeanstalk.ElasticBeanstalkClient
import software.amazon.awssdk.services.elasticbeanstalk.model._


object elasticbeanstalk { module =>

  // Free monad over ElasticBeanstalkOp
  type ElasticBeanstalkIO[A] = FF[ElasticBeanstalkOp, A]

  sealed trait ElasticBeanstalkOp[A] {
    def visit[F[_]](visitor: ElasticBeanstalkOp.Visitor[F]): F[A]
  }

  object ElasticBeanstalkOp {
    // Given a ElasticBeanstalkClient we can embed a ElasticBeanstalkIO program in any algebra that understands embedding.
    implicit val ElasticBeanstalkOpEmbeddable: Embeddable[ElasticBeanstalkOp, ElasticBeanstalkClient] = new Embeddable[ElasticBeanstalkOp, ElasticBeanstalkClient] {
      def embed[A](client: ElasticBeanstalkClient, io: ElasticBeanstalkIO[A]): Embedded[A] = Embedded.ElasticBeanstalk(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ElasticBeanstalkOp.Visitor[Kleisli[M, ElasticBeanstalkClient, *]] {
        def abortEnvironmentUpdate(
          request: AbortEnvironmentUpdateRequest
        ): Kleisli[M, ElasticBeanstalkClient, AbortEnvironmentUpdateResponse] =
          primitive(_.abortEnvironmentUpdate(request))

        def applyEnvironmentManagedAction(
          request: ApplyEnvironmentManagedActionRequest
        ): Kleisli[M, ElasticBeanstalkClient, ApplyEnvironmentManagedActionResponse] =
          primitive(_.applyEnvironmentManagedAction(request))

        def associateEnvironmentOperationsRole(
          request: AssociateEnvironmentOperationsRoleRequest
        ): Kleisli[M, ElasticBeanstalkClient, AssociateEnvironmentOperationsRoleResponse] =
          primitive(_.associateEnvironmentOperationsRole(request))

        def checkDNSAvailability(
          request: CheckDnsAvailabilityRequest
        ): Kleisli[M, ElasticBeanstalkClient, CheckDnsAvailabilityResponse] =
          primitive(_.checkDNSAvailability(request))

        def composeEnvironments(
          request: ComposeEnvironmentsRequest
        ): Kleisli[M, ElasticBeanstalkClient, ComposeEnvironmentsResponse] =
          primitive(_.composeEnvironments(request))

        def createApplication(
          request: CreateApplicationRequest
        ): Kleisli[M, ElasticBeanstalkClient, CreateApplicationResponse] =
          primitive(_.createApplication(request))

        def createApplicationVersion(
          request: CreateApplicationVersionRequest
        ): Kleisli[M, ElasticBeanstalkClient, CreateApplicationVersionResponse] =
          primitive(_.createApplicationVersion(request))

        def createConfigurationTemplate(
          request: CreateConfigurationTemplateRequest
        ): Kleisli[M, ElasticBeanstalkClient, CreateConfigurationTemplateResponse] =
          primitive(_.createConfigurationTemplate(request))

        def createEnvironment(
          request: CreateEnvironmentRequest
        ): Kleisli[M, ElasticBeanstalkClient, CreateEnvironmentResponse] =
          primitive(_.createEnvironment(request))

        def createPlatformVersion(
          request: CreatePlatformVersionRequest
        ): Kleisli[M, ElasticBeanstalkClient, CreatePlatformVersionResponse] =
          primitive(_.createPlatformVersion(request))

        def createStorageLocation(
          request: CreateStorageLocationRequest
        ): Kleisli[M, ElasticBeanstalkClient, CreateStorageLocationResponse] =
          primitive(_.createStorageLocation(request))

        def deleteApplication(
          request: DeleteApplicationRequest
        ): Kleisli[M, ElasticBeanstalkClient, DeleteApplicationResponse] =
          primitive(_.deleteApplication(request))

        def deleteApplicationVersion(
          request: DeleteApplicationVersionRequest
        ): Kleisli[M, ElasticBeanstalkClient, DeleteApplicationVersionResponse] =
          primitive(_.deleteApplicationVersion(request))

        def deleteConfigurationTemplate(
          request: DeleteConfigurationTemplateRequest
        ): Kleisli[M, ElasticBeanstalkClient, DeleteConfigurationTemplateResponse] =
          primitive(_.deleteConfigurationTemplate(request))

        def deleteEnvironmentConfiguration(
          request: DeleteEnvironmentConfigurationRequest
        ): Kleisli[M, ElasticBeanstalkClient, DeleteEnvironmentConfigurationResponse] =
          primitive(_.deleteEnvironmentConfiguration(request))

        def deletePlatformVersion(
          request: DeletePlatformVersionRequest
        ): Kleisli[M, ElasticBeanstalkClient, DeletePlatformVersionResponse] =
          primitive(_.deletePlatformVersion(request))

        def describeAccountAttributes(
          request: DescribeAccountAttributesRequest
        ): Kleisli[M, ElasticBeanstalkClient, DescribeAccountAttributesResponse] =
          primitive(_.describeAccountAttributes(request))

        def describeApplicationVersions(
          request: DescribeApplicationVersionsRequest
        ): Kleisli[M, ElasticBeanstalkClient, DescribeApplicationVersionsResponse] =
          primitive(_.describeApplicationVersions(request))

        def describeApplications(
          request: DescribeApplicationsRequest
        ): Kleisli[M, ElasticBeanstalkClient, DescribeApplicationsResponse] =
          primitive(_.describeApplications(request))

        def describeConfigurationOptions(
          request: DescribeConfigurationOptionsRequest
        ): Kleisli[M, ElasticBeanstalkClient, DescribeConfigurationOptionsResponse] =
          primitive(_.describeConfigurationOptions(request))

        def describeConfigurationSettings(
          request: DescribeConfigurationSettingsRequest
        ): Kleisli[M, ElasticBeanstalkClient, DescribeConfigurationSettingsResponse] =
          primitive(_.describeConfigurationSettings(request))

        def describeEnvironmentHealth(
          request: DescribeEnvironmentHealthRequest
        ): Kleisli[M, ElasticBeanstalkClient, DescribeEnvironmentHealthResponse] =
          primitive(_.describeEnvironmentHealth(request))

        def describeEnvironmentManagedActionHistory(
          request: DescribeEnvironmentManagedActionHistoryRequest
        ): Kleisli[M, ElasticBeanstalkClient, DescribeEnvironmentManagedActionHistoryResponse] =
          primitive(_.describeEnvironmentManagedActionHistory(request))

        def describeEnvironmentManagedActions(
          request: DescribeEnvironmentManagedActionsRequest
        ): Kleisli[M, ElasticBeanstalkClient, DescribeEnvironmentManagedActionsResponse] =
          primitive(_.describeEnvironmentManagedActions(request))

        def describeEnvironmentResources(
          request: DescribeEnvironmentResourcesRequest
        ): Kleisli[M, ElasticBeanstalkClient, DescribeEnvironmentResourcesResponse] =
          primitive(_.describeEnvironmentResources(request))

        def describeEnvironments(
          request: DescribeEnvironmentsRequest
        ): Kleisli[M, ElasticBeanstalkClient, DescribeEnvironmentsResponse] =
          primitive(_.describeEnvironments(request))

        def describeEvents(
          request: DescribeEventsRequest
        ): Kleisli[M, ElasticBeanstalkClient, DescribeEventsResponse] =
          primitive(_.describeEvents(request))

        def describeInstancesHealth(
          request: DescribeInstancesHealthRequest
        ): Kleisli[M, ElasticBeanstalkClient, DescribeInstancesHealthResponse] =
          primitive(_.describeInstancesHealth(request))

        def describePlatformVersion(
          request: DescribePlatformVersionRequest
        ): Kleisli[M, ElasticBeanstalkClient, DescribePlatformVersionResponse] =
          primitive(_.describePlatformVersion(request))

        def disassociateEnvironmentOperationsRole(
          request: DisassociateEnvironmentOperationsRoleRequest
        ): Kleisli[M, ElasticBeanstalkClient, DisassociateEnvironmentOperationsRoleResponse] =
          primitive(_.disassociateEnvironmentOperationsRole(request))

        def listAvailableSolutionStacks(
          request: ListAvailableSolutionStacksRequest
        ): Kleisli[M, ElasticBeanstalkClient, ListAvailableSolutionStacksResponse] =
          primitive(_.listAvailableSolutionStacks(request))

        def listPlatformBranches(
          request: ListPlatformBranchesRequest
        ): Kleisli[M, ElasticBeanstalkClient, ListPlatformBranchesResponse] =
          primitive(_.listPlatformBranches(request))

        def listPlatformVersions(
          request: ListPlatformVersionsRequest
        ): Kleisli[M, ElasticBeanstalkClient, ListPlatformVersionsResponse] =
          primitive(_.listPlatformVersions(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, ElasticBeanstalkClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def rebuildEnvironment(
          request: RebuildEnvironmentRequest
        ): Kleisli[M, ElasticBeanstalkClient, RebuildEnvironmentResponse] =
          primitive(_.rebuildEnvironment(request))

        def requestEnvironmentInfo(
          request: RequestEnvironmentInfoRequest
        ): Kleisli[M, ElasticBeanstalkClient, RequestEnvironmentInfoResponse] =
          primitive(_.requestEnvironmentInfo(request))

        def restartAppServer(
          request: RestartAppServerRequest
        ): Kleisli[M, ElasticBeanstalkClient, RestartAppServerResponse] =
          primitive(_.restartAppServer(request))

        def retrieveEnvironmentInfo(
          request: RetrieveEnvironmentInfoRequest
        ): Kleisli[M, ElasticBeanstalkClient, RetrieveEnvironmentInfoResponse] =
          primitive(_.retrieveEnvironmentInfo(request))

        def swapEnvironmentCNAMEs(
          request: SwapEnvironmentCnamEsRequest
        ): Kleisli[M, ElasticBeanstalkClient, SwapEnvironmentCnamEsResponse] =
          primitive(_.swapEnvironmentCNAMEs(request))

        def terminateEnvironment(
          request: TerminateEnvironmentRequest
        ): Kleisli[M, ElasticBeanstalkClient, TerminateEnvironmentResponse] =
          primitive(_.terminateEnvironment(request))

        def updateApplication(
          request: UpdateApplicationRequest
        ): Kleisli[M, ElasticBeanstalkClient, UpdateApplicationResponse] =
          primitive(_.updateApplication(request))

        def updateApplicationResourceLifecycle(
          request: UpdateApplicationResourceLifecycleRequest
        ): Kleisli[M, ElasticBeanstalkClient, UpdateApplicationResourceLifecycleResponse] =
          primitive(_.updateApplicationResourceLifecycle(request))

        def updateApplicationVersion(
          request: UpdateApplicationVersionRequest
        ): Kleisli[M, ElasticBeanstalkClient, UpdateApplicationVersionResponse] =
          primitive(_.updateApplicationVersion(request))

        def updateConfigurationTemplate(
          request: UpdateConfigurationTemplateRequest
        ): Kleisli[M, ElasticBeanstalkClient, UpdateConfigurationTemplateResponse] =
          primitive(_.updateConfigurationTemplate(request))

        def updateEnvironment(
          request: UpdateEnvironmentRequest
        ): Kleisli[M, ElasticBeanstalkClient, UpdateEnvironmentResponse] =
          primitive(_.updateEnvironment(request))

        def updateTagsForResource(
          request: UpdateTagsForResourceRequest
        ): Kleisli[M, ElasticBeanstalkClient, UpdateTagsForResourceResponse] =
          primitive(_.updateTagsForResource(request))

        def validateConfigurationSettings(
          request: ValidateConfigurationSettingsRequest
        ): Kleisli[M, ElasticBeanstalkClient, ValidateConfigurationSettingsResponse] =
          primitive(_.validateConfigurationSettings(request))

        def primitive[A](
          f: ElasticBeanstalkClient => A
        ): Kleisli[M, ElasticBeanstalkClient, A]
      }
    }

    trait Visitor[F[_]] extends (ElasticBeanstalkOp ~> F) {
      final def apply[A](op: ElasticBeanstalkOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def abortEnvironmentUpdate(
        request: AbortEnvironmentUpdateRequest
      ): F[AbortEnvironmentUpdateResponse]

      def applyEnvironmentManagedAction(
        request: ApplyEnvironmentManagedActionRequest
      ): F[ApplyEnvironmentManagedActionResponse]

      def associateEnvironmentOperationsRole(
        request: AssociateEnvironmentOperationsRoleRequest
      ): F[AssociateEnvironmentOperationsRoleResponse]

      def checkDNSAvailability(
        request: CheckDnsAvailabilityRequest
      ): F[CheckDnsAvailabilityResponse]

      def composeEnvironments(
        request: ComposeEnvironmentsRequest
      ): F[ComposeEnvironmentsResponse]

      def createApplication(
        request: CreateApplicationRequest
      ): F[CreateApplicationResponse]

      def createApplicationVersion(
        request: CreateApplicationVersionRequest
      ): F[CreateApplicationVersionResponse]

      def createConfigurationTemplate(
        request: CreateConfigurationTemplateRequest
      ): F[CreateConfigurationTemplateResponse]

      def createEnvironment(
        request: CreateEnvironmentRequest
      ): F[CreateEnvironmentResponse]

      def createPlatformVersion(
        request: CreatePlatformVersionRequest
      ): F[CreatePlatformVersionResponse]

      def createStorageLocation(
        request: CreateStorageLocationRequest
      ): F[CreateStorageLocationResponse]

      def deleteApplication(
        request: DeleteApplicationRequest
      ): F[DeleteApplicationResponse]

      def deleteApplicationVersion(
        request: DeleteApplicationVersionRequest
      ): F[DeleteApplicationVersionResponse]

      def deleteConfigurationTemplate(
        request: DeleteConfigurationTemplateRequest
      ): F[DeleteConfigurationTemplateResponse]

      def deleteEnvironmentConfiguration(
        request: DeleteEnvironmentConfigurationRequest
      ): F[DeleteEnvironmentConfigurationResponse]

      def deletePlatformVersion(
        request: DeletePlatformVersionRequest
      ): F[DeletePlatformVersionResponse]

      def describeAccountAttributes(
        request: DescribeAccountAttributesRequest
      ): F[DescribeAccountAttributesResponse]

      def describeApplicationVersions(
        request: DescribeApplicationVersionsRequest
      ): F[DescribeApplicationVersionsResponse]

      def describeApplications(
        request: DescribeApplicationsRequest
      ): F[DescribeApplicationsResponse]

      def describeConfigurationOptions(
        request: DescribeConfigurationOptionsRequest
      ): F[DescribeConfigurationOptionsResponse]

      def describeConfigurationSettings(
        request: DescribeConfigurationSettingsRequest
      ): F[DescribeConfigurationSettingsResponse]

      def describeEnvironmentHealth(
        request: DescribeEnvironmentHealthRequest
      ): F[DescribeEnvironmentHealthResponse]

      def describeEnvironmentManagedActionHistory(
        request: DescribeEnvironmentManagedActionHistoryRequest
      ): F[DescribeEnvironmentManagedActionHistoryResponse]

      def describeEnvironmentManagedActions(
        request: DescribeEnvironmentManagedActionsRequest
      ): F[DescribeEnvironmentManagedActionsResponse]

      def describeEnvironmentResources(
        request: DescribeEnvironmentResourcesRequest
      ): F[DescribeEnvironmentResourcesResponse]

      def describeEnvironments(
        request: DescribeEnvironmentsRequest
      ): F[DescribeEnvironmentsResponse]

      def describeEvents(
        request: DescribeEventsRequest
      ): F[DescribeEventsResponse]

      def describeInstancesHealth(
        request: DescribeInstancesHealthRequest
      ): F[DescribeInstancesHealthResponse]

      def describePlatformVersion(
        request: DescribePlatformVersionRequest
      ): F[DescribePlatformVersionResponse]

      def disassociateEnvironmentOperationsRole(
        request: DisassociateEnvironmentOperationsRoleRequest
      ): F[DisassociateEnvironmentOperationsRoleResponse]

      def listAvailableSolutionStacks(
        request: ListAvailableSolutionStacksRequest
      ): F[ListAvailableSolutionStacksResponse]

      def listPlatformBranches(
        request: ListPlatformBranchesRequest
      ): F[ListPlatformBranchesResponse]

      def listPlatformVersions(
        request: ListPlatformVersionsRequest
      ): F[ListPlatformVersionsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def rebuildEnvironment(
        request: RebuildEnvironmentRequest
      ): F[RebuildEnvironmentResponse]

      def requestEnvironmentInfo(
        request: RequestEnvironmentInfoRequest
      ): F[RequestEnvironmentInfoResponse]

      def restartAppServer(
        request: RestartAppServerRequest
      ): F[RestartAppServerResponse]

      def retrieveEnvironmentInfo(
        request: RetrieveEnvironmentInfoRequest
      ): F[RetrieveEnvironmentInfoResponse]

      def swapEnvironmentCNAMEs(
        request: SwapEnvironmentCnamEsRequest
      ): F[SwapEnvironmentCnamEsResponse]

      def terminateEnvironment(
        request: TerminateEnvironmentRequest
      ): F[TerminateEnvironmentResponse]

      def updateApplication(
        request: UpdateApplicationRequest
      ): F[UpdateApplicationResponse]

      def updateApplicationResourceLifecycle(
        request: UpdateApplicationResourceLifecycleRequest
      ): F[UpdateApplicationResourceLifecycleResponse]

      def updateApplicationVersion(
        request: UpdateApplicationVersionRequest
      ): F[UpdateApplicationVersionResponse]

      def updateConfigurationTemplate(
        request: UpdateConfigurationTemplateRequest
      ): F[UpdateConfigurationTemplateResponse]

      def updateEnvironment(
        request: UpdateEnvironmentRequest
      ): F[UpdateEnvironmentResponse]

      def updateTagsForResource(
        request: UpdateTagsForResourceRequest
      ): F[UpdateTagsForResourceResponse]

      def validateConfigurationSettings(
        request: ValidateConfigurationSettingsRequest
      ): F[ValidateConfigurationSettingsResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ElasticBeanstalkOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AbortEnvironmentUpdateOp(
      request: AbortEnvironmentUpdateRequest
    ) extends ElasticBeanstalkOp[AbortEnvironmentUpdateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AbortEnvironmentUpdateResponse] =
        visitor.abortEnvironmentUpdate(request)
    }

    final case class ApplyEnvironmentManagedActionOp(
      request: ApplyEnvironmentManagedActionRequest
    ) extends ElasticBeanstalkOp[ApplyEnvironmentManagedActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ApplyEnvironmentManagedActionResponse] =
        visitor.applyEnvironmentManagedAction(request)
    }

    final case class AssociateEnvironmentOperationsRoleOp(
      request: AssociateEnvironmentOperationsRoleRequest
    ) extends ElasticBeanstalkOp[AssociateEnvironmentOperationsRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateEnvironmentOperationsRoleResponse] =
        visitor.associateEnvironmentOperationsRole(request)
    }

    final case class CheckDNSAvailabilityOp(
      request: CheckDnsAvailabilityRequest
    ) extends ElasticBeanstalkOp[CheckDnsAvailabilityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CheckDnsAvailabilityResponse] =
        visitor.checkDNSAvailability(request)
    }

    final case class ComposeEnvironmentsOp(
      request: ComposeEnvironmentsRequest
    ) extends ElasticBeanstalkOp[ComposeEnvironmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ComposeEnvironmentsResponse] =
        visitor.composeEnvironments(request)
    }

    final case class CreateApplicationOp(
      request: CreateApplicationRequest
    ) extends ElasticBeanstalkOp[CreateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApplicationResponse] =
        visitor.createApplication(request)
    }

    final case class CreateApplicationVersionOp(
      request: CreateApplicationVersionRequest
    ) extends ElasticBeanstalkOp[CreateApplicationVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApplicationVersionResponse] =
        visitor.createApplicationVersion(request)
    }

    final case class CreateConfigurationTemplateOp(
      request: CreateConfigurationTemplateRequest
    ) extends ElasticBeanstalkOp[CreateConfigurationTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConfigurationTemplateResponse] =
        visitor.createConfigurationTemplate(request)
    }

    final case class CreateEnvironmentOp(
      request: CreateEnvironmentRequest
    ) extends ElasticBeanstalkOp[CreateEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEnvironmentResponse] =
        visitor.createEnvironment(request)
    }

    final case class CreatePlatformVersionOp(
      request: CreatePlatformVersionRequest
    ) extends ElasticBeanstalkOp[CreatePlatformVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePlatformVersionResponse] =
        visitor.createPlatformVersion(request)
    }

    final case class CreateStorageLocationOp(
      request: CreateStorageLocationRequest
    ) extends ElasticBeanstalkOp[CreateStorageLocationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStorageLocationResponse] =
        visitor.createStorageLocation(request)
    }

    final case class DeleteApplicationOp(
      request: DeleteApplicationRequest
    ) extends ElasticBeanstalkOp[DeleteApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationResponse] =
        visitor.deleteApplication(request)
    }

    final case class DeleteApplicationVersionOp(
      request: DeleteApplicationVersionRequest
    ) extends ElasticBeanstalkOp[DeleteApplicationVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationVersionResponse] =
        visitor.deleteApplicationVersion(request)
    }

    final case class DeleteConfigurationTemplateOp(
      request: DeleteConfigurationTemplateRequest
    ) extends ElasticBeanstalkOp[DeleteConfigurationTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConfigurationTemplateResponse] =
        visitor.deleteConfigurationTemplate(request)
    }

    final case class DeleteEnvironmentConfigurationOp(
      request: DeleteEnvironmentConfigurationRequest
    ) extends ElasticBeanstalkOp[DeleteEnvironmentConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEnvironmentConfigurationResponse] =
        visitor.deleteEnvironmentConfiguration(request)
    }

    final case class DeletePlatformVersionOp(
      request: DeletePlatformVersionRequest
    ) extends ElasticBeanstalkOp[DeletePlatformVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePlatformVersionResponse] =
        visitor.deletePlatformVersion(request)
    }

    final case class DescribeAccountAttributesOp(
      request: DescribeAccountAttributesRequest
    ) extends ElasticBeanstalkOp[DescribeAccountAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountAttributesResponse] =
        visitor.describeAccountAttributes(request)
    }

    final case class DescribeApplicationVersionsOp(
      request: DescribeApplicationVersionsRequest
    ) extends ElasticBeanstalkOp[DescribeApplicationVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeApplicationVersionsResponse] =
        visitor.describeApplicationVersions(request)
    }

    final case class DescribeApplicationsOp(
      request: DescribeApplicationsRequest
    ) extends ElasticBeanstalkOp[DescribeApplicationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeApplicationsResponse] =
        visitor.describeApplications(request)
    }

    final case class DescribeConfigurationOptionsOp(
      request: DescribeConfigurationOptionsRequest
    ) extends ElasticBeanstalkOp[DescribeConfigurationOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConfigurationOptionsResponse] =
        visitor.describeConfigurationOptions(request)
    }

    final case class DescribeConfigurationSettingsOp(
      request: DescribeConfigurationSettingsRequest
    ) extends ElasticBeanstalkOp[DescribeConfigurationSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConfigurationSettingsResponse] =
        visitor.describeConfigurationSettings(request)
    }

    final case class DescribeEnvironmentHealthOp(
      request: DescribeEnvironmentHealthRequest
    ) extends ElasticBeanstalkOp[DescribeEnvironmentHealthResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEnvironmentHealthResponse] =
        visitor.describeEnvironmentHealth(request)
    }

    final case class DescribeEnvironmentManagedActionHistoryOp(
      request: DescribeEnvironmentManagedActionHistoryRequest
    ) extends ElasticBeanstalkOp[DescribeEnvironmentManagedActionHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEnvironmentManagedActionHistoryResponse] =
        visitor.describeEnvironmentManagedActionHistory(request)
    }

    final case class DescribeEnvironmentManagedActionsOp(
      request: DescribeEnvironmentManagedActionsRequest
    ) extends ElasticBeanstalkOp[DescribeEnvironmentManagedActionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEnvironmentManagedActionsResponse] =
        visitor.describeEnvironmentManagedActions(request)
    }

    final case class DescribeEnvironmentResourcesOp(
      request: DescribeEnvironmentResourcesRequest
    ) extends ElasticBeanstalkOp[DescribeEnvironmentResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEnvironmentResourcesResponse] =
        visitor.describeEnvironmentResources(request)
    }

    final case class DescribeEnvironmentsOp(
      request: DescribeEnvironmentsRequest
    ) extends ElasticBeanstalkOp[DescribeEnvironmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEnvironmentsResponse] =
        visitor.describeEnvironments(request)
    }

    final case class DescribeEventsOp(
      request: DescribeEventsRequest
    ) extends ElasticBeanstalkOp[DescribeEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventsResponse] =
        visitor.describeEvents(request)
    }

    final case class DescribeInstancesHealthOp(
      request: DescribeInstancesHealthRequest
    ) extends ElasticBeanstalkOp[DescribeInstancesHealthResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstancesHealthResponse] =
        visitor.describeInstancesHealth(request)
    }

    final case class DescribePlatformVersionOp(
      request: DescribePlatformVersionRequest
    ) extends ElasticBeanstalkOp[DescribePlatformVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePlatformVersionResponse] =
        visitor.describePlatformVersion(request)
    }

    final case class DisassociateEnvironmentOperationsRoleOp(
      request: DisassociateEnvironmentOperationsRoleRequest
    ) extends ElasticBeanstalkOp[DisassociateEnvironmentOperationsRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateEnvironmentOperationsRoleResponse] =
        visitor.disassociateEnvironmentOperationsRole(request)
    }

    final case class ListAvailableSolutionStacksOp(
      request: ListAvailableSolutionStacksRequest
    ) extends ElasticBeanstalkOp[ListAvailableSolutionStacksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAvailableSolutionStacksResponse] =
        visitor.listAvailableSolutionStacks(request)
    }

    final case class ListPlatformBranchesOp(
      request: ListPlatformBranchesRequest
    ) extends ElasticBeanstalkOp[ListPlatformBranchesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPlatformBranchesResponse] =
        visitor.listPlatformBranches(request)
    }

    final case class ListPlatformVersionsOp(
      request: ListPlatformVersionsRequest
    ) extends ElasticBeanstalkOp[ListPlatformVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPlatformVersionsResponse] =
        visitor.listPlatformVersions(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends ElasticBeanstalkOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class RebuildEnvironmentOp(
      request: RebuildEnvironmentRequest
    ) extends ElasticBeanstalkOp[RebuildEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RebuildEnvironmentResponse] =
        visitor.rebuildEnvironment(request)
    }

    final case class RequestEnvironmentInfoOp(
      request: RequestEnvironmentInfoRequest
    ) extends ElasticBeanstalkOp[RequestEnvironmentInfoResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RequestEnvironmentInfoResponse] =
        visitor.requestEnvironmentInfo(request)
    }

    final case class RestartAppServerOp(
      request: RestartAppServerRequest
    ) extends ElasticBeanstalkOp[RestartAppServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestartAppServerResponse] =
        visitor.restartAppServer(request)
    }

    final case class RetrieveEnvironmentInfoOp(
      request: RetrieveEnvironmentInfoRequest
    ) extends ElasticBeanstalkOp[RetrieveEnvironmentInfoResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RetrieveEnvironmentInfoResponse] =
        visitor.retrieveEnvironmentInfo(request)
    }

    final case class SwapEnvironmentCNAMEsOp(
      request: SwapEnvironmentCnamEsRequest
    ) extends ElasticBeanstalkOp[SwapEnvironmentCnamEsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SwapEnvironmentCnamEsResponse] =
        visitor.swapEnvironmentCNAMEs(request)
    }

    final case class TerminateEnvironmentOp(
      request: TerminateEnvironmentRequest
    ) extends ElasticBeanstalkOp[TerminateEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TerminateEnvironmentResponse] =
        visitor.terminateEnvironment(request)
    }

    final case class UpdateApplicationOp(
      request: UpdateApplicationRequest
    ) extends ElasticBeanstalkOp[UpdateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApplicationResponse] =
        visitor.updateApplication(request)
    }

    final case class UpdateApplicationResourceLifecycleOp(
      request: UpdateApplicationResourceLifecycleRequest
    ) extends ElasticBeanstalkOp[UpdateApplicationResourceLifecycleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApplicationResourceLifecycleResponse] =
        visitor.updateApplicationResourceLifecycle(request)
    }

    final case class UpdateApplicationVersionOp(
      request: UpdateApplicationVersionRequest
    ) extends ElasticBeanstalkOp[UpdateApplicationVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApplicationVersionResponse] =
        visitor.updateApplicationVersion(request)
    }

    final case class UpdateConfigurationTemplateOp(
      request: UpdateConfigurationTemplateRequest
    ) extends ElasticBeanstalkOp[UpdateConfigurationTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConfigurationTemplateResponse] =
        visitor.updateConfigurationTemplate(request)
    }

    final case class UpdateEnvironmentOp(
      request: UpdateEnvironmentRequest
    ) extends ElasticBeanstalkOp[UpdateEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEnvironmentResponse] =
        visitor.updateEnvironment(request)
    }

    final case class UpdateTagsForResourceOp(
      request: UpdateTagsForResourceRequest
    ) extends ElasticBeanstalkOp[UpdateTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTagsForResourceResponse] =
        visitor.updateTagsForResource(request)
    }

    final case class ValidateConfigurationSettingsOp(
      request: ValidateConfigurationSettingsRequest
    ) extends ElasticBeanstalkOp[ValidateConfigurationSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ValidateConfigurationSettingsResponse] =
        visitor.validateConfigurationSettings(request)
    }
  }

  import ElasticBeanstalkOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ElasticBeanstalkOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def abortEnvironmentUpdate(
    request: AbortEnvironmentUpdateRequest
  ): ElasticBeanstalkIO[AbortEnvironmentUpdateResponse] =
    FF.liftF(AbortEnvironmentUpdateOp(request))

  def applyEnvironmentManagedAction(
    request: ApplyEnvironmentManagedActionRequest
  ): ElasticBeanstalkIO[ApplyEnvironmentManagedActionResponse] =
    FF.liftF(ApplyEnvironmentManagedActionOp(request))

  def associateEnvironmentOperationsRole(
    request: AssociateEnvironmentOperationsRoleRequest
  ): ElasticBeanstalkIO[AssociateEnvironmentOperationsRoleResponse] =
    FF.liftF(AssociateEnvironmentOperationsRoleOp(request))

  def checkDNSAvailability(
    request: CheckDnsAvailabilityRequest
  ): ElasticBeanstalkIO[CheckDnsAvailabilityResponse] =
    FF.liftF(CheckDNSAvailabilityOp(request))

  def composeEnvironments(
    request: ComposeEnvironmentsRequest
  ): ElasticBeanstalkIO[ComposeEnvironmentsResponse] =
    FF.liftF(ComposeEnvironmentsOp(request))

  def createApplication(
    request: CreateApplicationRequest
  ): ElasticBeanstalkIO[CreateApplicationResponse] =
    FF.liftF(CreateApplicationOp(request))

  def createApplicationVersion(
    request: CreateApplicationVersionRequest
  ): ElasticBeanstalkIO[CreateApplicationVersionResponse] =
    FF.liftF(CreateApplicationVersionOp(request))

  def createConfigurationTemplate(
    request: CreateConfigurationTemplateRequest
  ): ElasticBeanstalkIO[CreateConfigurationTemplateResponse] =
    FF.liftF(CreateConfigurationTemplateOp(request))

  def createEnvironment(
    request: CreateEnvironmentRequest
  ): ElasticBeanstalkIO[CreateEnvironmentResponse] =
    FF.liftF(CreateEnvironmentOp(request))

  def createPlatformVersion(
    request: CreatePlatformVersionRequest
  ): ElasticBeanstalkIO[CreatePlatformVersionResponse] =
    FF.liftF(CreatePlatformVersionOp(request))

  def createStorageLocation(
    request: CreateStorageLocationRequest
  ): ElasticBeanstalkIO[CreateStorageLocationResponse] =
    FF.liftF(CreateStorageLocationOp(request))

  def deleteApplication(
    request: DeleteApplicationRequest
  ): ElasticBeanstalkIO[DeleteApplicationResponse] =
    FF.liftF(DeleteApplicationOp(request))

  def deleteApplicationVersion(
    request: DeleteApplicationVersionRequest
  ): ElasticBeanstalkIO[DeleteApplicationVersionResponse] =
    FF.liftF(DeleteApplicationVersionOp(request))

  def deleteConfigurationTemplate(
    request: DeleteConfigurationTemplateRequest
  ): ElasticBeanstalkIO[DeleteConfigurationTemplateResponse] =
    FF.liftF(DeleteConfigurationTemplateOp(request))

  def deleteEnvironmentConfiguration(
    request: DeleteEnvironmentConfigurationRequest
  ): ElasticBeanstalkIO[DeleteEnvironmentConfigurationResponse] =
    FF.liftF(DeleteEnvironmentConfigurationOp(request))

  def deletePlatformVersion(
    request: DeletePlatformVersionRequest
  ): ElasticBeanstalkIO[DeletePlatformVersionResponse] =
    FF.liftF(DeletePlatformVersionOp(request))

  def describeAccountAttributes(
    request: DescribeAccountAttributesRequest
  ): ElasticBeanstalkIO[DescribeAccountAttributesResponse] =
    FF.liftF(DescribeAccountAttributesOp(request))

  def describeApplicationVersions(
    request: DescribeApplicationVersionsRequest
  ): ElasticBeanstalkIO[DescribeApplicationVersionsResponse] =
    FF.liftF(DescribeApplicationVersionsOp(request))

  def describeApplications(
    request: DescribeApplicationsRequest
  ): ElasticBeanstalkIO[DescribeApplicationsResponse] =
    FF.liftF(DescribeApplicationsOp(request))

  def describeConfigurationOptions(
    request: DescribeConfigurationOptionsRequest
  ): ElasticBeanstalkIO[DescribeConfigurationOptionsResponse] =
    FF.liftF(DescribeConfigurationOptionsOp(request))

  def describeConfigurationSettings(
    request: DescribeConfigurationSettingsRequest
  ): ElasticBeanstalkIO[DescribeConfigurationSettingsResponse] =
    FF.liftF(DescribeConfigurationSettingsOp(request))

  def describeEnvironmentHealth(
    request: DescribeEnvironmentHealthRequest
  ): ElasticBeanstalkIO[DescribeEnvironmentHealthResponse] =
    FF.liftF(DescribeEnvironmentHealthOp(request))

  def describeEnvironmentManagedActionHistory(
    request: DescribeEnvironmentManagedActionHistoryRequest
  ): ElasticBeanstalkIO[DescribeEnvironmentManagedActionHistoryResponse] =
    FF.liftF(DescribeEnvironmentManagedActionHistoryOp(request))

  def describeEnvironmentManagedActions(
    request: DescribeEnvironmentManagedActionsRequest
  ): ElasticBeanstalkIO[DescribeEnvironmentManagedActionsResponse] =
    FF.liftF(DescribeEnvironmentManagedActionsOp(request))

  def describeEnvironmentResources(
    request: DescribeEnvironmentResourcesRequest
  ): ElasticBeanstalkIO[DescribeEnvironmentResourcesResponse] =
    FF.liftF(DescribeEnvironmentResourcesOp(request))

  def describeEnvironments(
    request: DescribeEnvironmentsRequest
  ): ElasticBeanstalkIO[DescribeEnvironmentsResponse] =
    FF.liftF(DescribeEnvironmentsOp(request))

  def describeEvents(
    request: DescribeEventsRequest
  ): ElasticBeanstalkIO[DescribeEventsResponse] =
    FF.liftF(DescribeEventsOp(request))

  def describeInstancesHealth(
    request: DescribeInstancesHealthRequest
  ): ElasticBeanstalkIO[DescribeInstancesHealthResponse] =
    FF.liftF(DescribeInstancesHealthOp(request))

  def describePlatformVersion(
    request: DescribePlatformVersionRequest
  ): ElasticBeanstalkIO[DescribePlatformVersionResponse] =
    FF.liftF(DescribePlatformVersionOp(request))

  def disassociateEnvironmentOperationsRole(
    request: DisassociateEnvironmentOperationsRoleRequest
  ): ElasticBeanstalkIO[DisassociateEnvironmentOperationsRoleResponse] =
    FF.liftF(DisassociateEnvironmentOperationsRoleOp(request))

  def listAvailableSolutionStacks(
    request: ListAvailableSolutionStacksRequest
  ): ElasticBeanstalkIO[ListAvailableSolutionStacksResponse] =
    FF.liftF(ListAvailableSolutionStacksOp(request))

  def listPlatformBranches(
    request: ListPlatformBranchesRequest
  ): ElasticBeanstalkIO[ListPlatformBranchesResponse] =
    FF.liftF(ListPlatformBranchesOp(request))

  def listPlatformVersions(
    request: ListPlatformVersionsRequest
  ): ElasticBeanstalkIO[ListPlatformVersionsResponse] =
    FF.liftF(ListPlatformVersionsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): ElasticBeanstalkIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def rebuildEnvironment(
    request: RebuildEnvironmentRequest
  ): ElasticBeanstalkIO[RebuildEnvironmentResponse] =
    FF.liftF(RebuildEnvironmentOp(request))

  def requestEnvironmentInfo(
    request: RequestEnvironmentInfoRequest
  ): ElasticBeanstalkIO[RequestEnvironmentInfoResponse] =
    FF.liftF(RequestEnvironmentInfoOp(request))

  def restartAppServer(
    request: RestartAppServerRequest
  ): ElasticBeanstalkIO[RestartAppServerResponse] =
    FF.liftF(RestartAppServerOp(request))

  def retrieveEnvironmentInfo(
    request: RetrieveEnvironmentInfoRequest
  ): ElasticBeanstalkIO[RetrieveEnvironmentInfoResponse] =
    FF.liftF(RetrieveEnvironmentInfoOp(request))

  def swapEnvironmentCNAMEs(
    request: SwapEnvironmentCnamEsRequest
  ): ElasticBeanstalkIO[SwapEnvironmentCnamEsResponse] =
    FF.liftF(SwapEnvironmentCNAMEsOp(request))

  def terminateEnvironment(
    request: TerminateEnvironmentRequest
  ): ElasticBeanstalkIO[TerminateEnvironmentResponse] =
    FF.liftF(TerminateEnvironmentOp(request))

  def updateApplication(
    request: UpdateApplicationRequest
  ): ElasticBeanstalkIO[UpdateApplicationResponse] =
    FF.liftF(UpdateApplicationOp(request))

  def updateApplicationResourceLifecycle(
    request: UpdateApplicationResourceLifecycleRequest
  ): ElasticBeanstalkIO[UpdateApplicationResourceLifecycleResponse] =
    FF.liftF(UpdateApplicationResourceLifecycleOp(request))

  def updateApplicationVersion(
    request: UpdateApplicationVersionRequest
  ): ElasticBeanstalkIO[UpdateApplicationVersionResponse] =
    FF.liftF(UpdateApplicationVersionOp(request))

  def updateConfigurationTemplate(
    request: UpdateConfigurationTemplateRequest
  ): ElasticBeanstalkIO[UpdateConfigurationTemplateResponse] =
    FF.liftF(UpdateConfigurationTemplateOp(request))

  def updateEnvironment(
    request: UpdateEnvironmentRequest
  ): ElasticBeanstalkIO[UpdateEnvironmentResponse] =
    FF.liftF(UpdateEnvironmentOp(request))

  def updateTagsForResource(
    request: UpdateTagsForResourceRequest
  ): ElasticBeanstalkIO[UpdateTagsForResourceResponse] =
    FF.liftF(UpdateTagsForResourceOp(request))

  def validateConfigurationSettings(
    request: ValidateConfigurationSettingsRequest
  ): ElasticBeanstalkIO[ValidateConfigurationSettingsResponse] =
    FF.liftF(ValidateConfigurationSettingsOp(request))
}
