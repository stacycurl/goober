package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.codeguruprofiler.CodeGuruProfilerClient
import software.amazon.awssdk.services.codeguruprofiler.model._


object codeguruprofiler { module =>

  // Free monad over CodeGuruProfilerOp
  type CodeGuruProfilerIO[A] = FF[CodeGuruProfilerOp, A]

  sealed trait CodeGuruProfilerOp[A] {
    def visit[F[_]](visitor: CodeGuruProfilerOp.Visitor[F]): F[A]
  }

  object CodeGuruProfilerOp {
    // Given a CodeGuruProfilerClient we can embed a CodeGuruProfilerIO program in any algebra that understands embedding.
    implicit val CodeGuruProfilerOpEmbeddable: Embeddable[CodeGuruProfilerOp, CodeGuruProfilerClient] = new Embeddable[CodeGuruProfilerOp, CodeGuruProfilerClient] {
      def embed[A](client: CodeGuruProfilerClient, io: CodeGuruProfilerIO[A]): Embedded[A] = Embedded.CodeGuruProfiler(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CodeGuruProfilerOp.Visitor[Kleisli[M, CodeGuruProfilerClient, *]] {
        def addNotificationChannels(
          request: AddNotificationChannelsRequest
        ): Kleisli[M, CodeGuruProfilerClient, AddNotificationChannelsResponse] =
          primitive(_.addNotificationChannels(request))

        def batchGetFrameMetricData(
          request: BatchGetFrameMetricDataRequest
        ): Kleisli[M, CodeGuruProfilerClient, BatchGetFrameMetricDataResponse] =
          primitive(_.batchGetFrameMetricData(request))

        def configureAgent(
          request: ConfigureAgentRequest
        ): Kleisli[M, CodeGuruProfilerClient, ConfigureAgentResponse] =
          primitive(_.configureAgent(request))

        def createProfilingGroup(
          request: CreateProfilingGroupRequest
        ): Kleisli[M, CodeGuruProfilerClient, CreateProfilingGroupResponse] =
          primitive(_.createProfilingGroup(request))

        def deleteProfilingGroup(
          request: DeleteProfilingGroupRequest
        ): Kleisli[M, CodeGuruProfilerClient, DeleteProfilingGroupResponse] =
          primitive(_.deleteProfilingGroup(request))

        def describeProfilingGroup(
          request: DescribeProfilingGroupRequest
        ): Kleisli[M, CodeGuruProfilerClient, DescribeProfilingGroupResponse] =
          primitive(_.describeProfilingGroup(request))

        def getFindingsReportAccountSummary(
          request: GetFindingsReportAccountSummaryRequest
        ): Kleisli[M, CodeGuruProfilerClient, GetFindingsReportAccountSummaryResponse] =
          primitive(_.getFindingsReportAccountSummary(request))

        def getNotificationConfiguration(
          request: GetNotificationConfigurationRequest
        ): Kleisli[M, CodeGuruProfilerClient, GetNotificationConfigurationResponse] =
          primitive(_.getNotificationConfiguration(request))

        def getPolicy(
          request: GetPolicyRequest
        ): Kleisli[M, CodeGuruProfilerClient, GetPolicyResponse] =
          primitive(_.getPolicy(request))

        def getProfile(
          request: GetProfileRequest
        ): Kleisli[M, CodeGuruProfilerClient, GetProfileResponse] =
          primitive(_.getProfile(request))

        def getRecommendations(
          request: GetRecommendationsRequest
        ): Kleisli[M, CodeGuruProfilerClient, GetRecommendationsResponse] =
          primitive(_.getRecommendations(request))

        def listFindingsReports(
          request: ListFindingsReportsRequest
        ): Kleisli[M, CodeGuruProfilerClient, ListFindingsReportsResponse] =
          primitive(_.listFindingsReports(request))

        def listProfileTimes(
          request: ListProfileTimesRequest
        ): Kleisli[M, CodeGuruProfilerClient, ListProfileTimesResponse] =
          primitive(_.listProfileTimes(request))

        def listProfilingGroups(
          request: ListProfilingGroupsRequest
        ): Kleisli[M, CodeGuruProfilerClient, ListProfilingGroupsResponse] =
          primitive(_.listProfilingGroups(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, CodeGuruProfilerClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def postAgentProfile(
          request: PostAgentProfileRequest
        ): Kleisli[M, CodeGuruProfilerClient, PostAgentProfileResponse] =
          primitive(_.postAgentProfile(request))

        def putPermission(
          request: PutPermissionRequest
        ): Kleisli[M, CodeGuruProfilerClient, PutPermissionResponse] =
          primitive(_.putPermission(request))

        def removeNotificationChannel(
          request: RemoveNotificationChannelRequest
        ): Kleisli[M, CodeGuruProfilerClient, RemoveNotificationChannelResponse] =
          primitive(_.removeNotificationChannel(request))

        def removePermission(
          request: RemovePermissionRequest
        ): Kleisli[M, CodeGuruProfilerClient, RemovePermissionResponse] =
          primitive(_.removePermission(request))

        def submitFeedback(
          request: SubmitFeedbackRequest
        ): Kleisli[M, CodeGuruProfilerClient, SubmitFeedbackResponse] =
          primitive(_.submitFeedback(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, CodeGuruProfilerClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, CodeGuruProfilerClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateProfilingGroup(
          request: UpdateProfilingGroupRequest
        ): Kleisli[M, CodeGuruProfilerClient, UpdateProfilingGroupResponse] =
          primitive(_.updateProfilingGroup(request))

        def primitive[A](
          f: CodeGuruProfilerClient => A
        ): Kleisli[M, CodeGuruProfilerClient, A]
      }
    }

    trait Visitor[F[_]] extends (CodeGuruProfilerOp ~> F) {
      final def apply[A](op: CodeGuruProfilerOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addNotificationChannels(
        request: AddNotificationChannelsRequest
      ): F[AddNotificationChannelsResponse]

      def batchGetFrameMetricData(
        request: BatchGetFrameMetricDataRequest
      ): F[BatchGetFrameMetricDataResponse]

      def configureAgent(
        request: ConfigureAgentRequest
      ): F[ConfigureAgentResponse]

      def createProfilingGroup(
        request: CreateProfilingGroupRequest
      ): F[CreateProfilingGroupResponse]

      def deleteProfilingGroup(
        request: DeleteProfilingGroupRequest
      ): F[DeleteProfilingGroupResponse]

      def describeProfilingGroup(
        request: DescribeProfilingGroupRequest
      ): F[DescribeProfilingGroupResponse]

      def getFindingsReportAccountSummary(
        request: GetFindingsReportAccountSummaryRequest
      ): F[GetFindingsReportAccountSummaryResponse]

      def getNotificationConfiguration(
        request: GetNotificationConfigurationRequest
      ): F[GetNotificationConfigurationResponse]

      def getPolicy(
        request: GetPolicyRequest
      ): F[GetPolicyResponse]

      def getProfile(
        request: GetProfileRequest
      ): F[GetProfileResponse]

      def getRecommendations(
        request: GetRecommendationsRequest
      ): F[GetRecommendationsResponse]

      def listFindingsReports(
        request: ListFindingsReportsRequest
      ): F[ListFindingsReportsResponse]

      def listProfileTimes(
        request: ListProfileTimesRequest
      ): F[ListProfileTimesResponse]

      def listProfilingGroups(
        request: ListProfilingGroupsRequest
      ): F[ListProfilingGroupsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def postAgentProfile(
        request: PostAgentProfileRequest
      ): F[PostAgentProfileResponse]

      def putPermission(
        request: PutPermissionRequest
      ): F[PutPermissionResponse]

      def removeNotificationChannel(
        request: RemoveNotificationChannelRequest
      ): F[RemoveNotificationChannelResponse]

      def removePermission(
        request: RemovePermissionRequest
      ): F[RemovePermissionResponse]

      def submitFeedback(
        request: SubmitFeedbackRequest
      ): F[SubmitFeedbackResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateProfilingGroup(
        request: UpdateProfilingGroupRequest
      ): F[UpdateProfilingGroupResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CodeGuruProfilerOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddNotificationChannelsOp(
      request: AddNotificationChannelsRequest
    ) extends CodeGuruProfilerOp[AddNotificationChannelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddNotificationChannelsResponse] =
        visitor.addNotificationChannels(request)
    }

    final case class BatchGetFrameMetricDataOp(
      request: BatchGetFrameMetricDataRequest
    ) extends CodeGuruProfilerOp[BatchGetFrameMetricDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetFrameMetricDataResponse] =
        visitor.batchGetFrameMetricData(request)
    }

    final case class ConfigureAgentOp(
      request: ConfigureAgentRequest
    ) extends CodeGuruProfilerOp[ConfigureAgentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ConfigureAgentResponse] =
        visitor.configureAgent(request)
    }

    final case class CreateProfilingGroupOp(
      request: CreateProfilingGroupRequest
    ) extends CodeGuruProfilerOp[CreateProfilingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProfilingGroupResponse] =
        visitor.createProfilingGroup(request)
    }

    final case class DeleteProfilingGroupOp(
      request: DeleteProfilingGroupRequest
    ) extends CodeGuruProfilerOp[DeleteProfilingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProfilingGroupResponse] =
        visitor.deleteProfilingGroup(request)
    }

    final case class DescribeProfilingGroupOp(
      request: DescribeProfilingGroupRequest
    ) extends CodeGuruProfilerOp[DescribeProfilingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProfilingGroupResponse] =
        visitor.describeProfilingGroup(request)
    }

    final case class GetFindingsReportAccountSummaryOp(
      request: GetFindingsReportAccountSummaryRequest
    ) extends CodeGuruProfilerOp[GetFindingsReportAccountSummaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFindingsReportAccountSummaryResponse] =
        visitor.getFindingsReportAccountSummary(request)
    }

    final case class GetNotificationConfigurationOp(
      request: GetNotificationConfigurationRequest
    ) extends CodeGuruProfilerOp[GetNotificationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetNotificationConfigurationResponse] =
        visitor.getNotificationConfiguration(request)
    }

    final case class GetPolicyOp(
      request: GetPolicyRequest
    ) extends CodeGuruProfilerOp[GetPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPolicyResponse] =
        visitor.getPolicy(request)
    }

    final case class GetProfileOp(
      request: GetProfileRequest
    ) extends CodeGuruProfilerOp[GetProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetProfileResponse] =
        visitor.getProfile(request)
    }

    final case class GetRecommendationsOp(
      request: GetRecommendationsRequest
    ) extends CodeGuruProfilerOp[GetRecommendationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRecommendationsResponse] =
        visitor.getRecommendations(request)
    }

    final case class ListFindingsReportsOp(
      request: ListFindingsReportsRequest
    ) extends CodeGuruProfilerOp[ListFindingsReportsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFindingsReportsResponse] =
        visitor.listFindingsReports(request)
    }

    final case class ListProfileTimesOp(
      request: ListProfileTimesRequest
    ) extends CodeGuruProfilerOp[ListProfileTimesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProfileTimesResponse] =
        visitor.listProfileTimes(request)
    }

    final case class ListProfilingGroupsOp(
      request: ListProfilingGroupsRequest
    ) extends CodeGuruProfilerOp[ListProfilingGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProfilingGroupsResponse] =
        visitor.listProfilingGroups(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends CodeGuruProfilerOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PostAgentProfileOp(
      request: PostAgentProfileRequest
    ) extends CodeGuruProfilerOp[PostAgentProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PostAgentProfileResponse] =
        visitor.postAgentProfile(request)
    }

    final case class PutPermissionOp(
      request: PutPermissionRequest
    ) extends CodeGuruProfilerOp[PutPermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutPermissionResponse] =
        visitor.putPermission(request)
    }

    final case class RemoveNotificationChannelOp(
      request: RemoveNotificationChannelRequest
    ) extends CodeGuruProfilerOp[RemoveNotificationChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveNotificationChannelResponse] =
        visitor.removeNotificationChannel(request)
    }

    final case class RemovePermissionOp(
      request: RemovePermissionRequest
    ) extends CodeGuruProfilerOp[RemovePermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemovePermissionResponse] =
        visitor.removePermission(request)
    }

    final case class SubmitFeedbackOp(
      request: SubmitFeedbackRequest
    ) extends CodeGuruProfilerOp[SubmitFeedbackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SubmitFeedbackResponse] =
        visitor.submitFeedback(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends CodeGuruProfilerOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends CodeGuruProfilerOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateProfilingGroupOp(
      request: UpdateProfilingGroupRequest
    ) extends CodeGuruProfilerOp[UpdateProfilingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateProfilingGroupResponse] =
        visitor.updateProfilingGroup(request)
    }
  }

  import CodeGuruProfilerOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CodeGuruProfilerOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addNotificationChannels(
    request: AddNotificationChannelsRequest
  ): CodeGuruProfilerIO[AddNotificationChannelsResponse] =
    FF.liftF(AddNotificationChannelsOp(request))

  def batchGetFrameMetricData(
    request: BatchGetFrameMetricDataRequest
  ): CodeGuruProfilerIO[BatchGetFrameMetricDataResponse] =
    FF.liftF(BatchGetFrameMetricDataOp(request))

  def configureAgent(
    request: ConfigureAgentRequest
  ): CodeGuruProfilerIO[ConfigureAgentResponse] =
    FF.liftF(ConfigureAgentOp(request))

  def createProfilingGroup(
    request: CreateProfilingGroupRequest
  ): CodeGuruProfilerIO[CreateProfilingGroupResponse] =
    FF.liftF(CreateProfilingGroupOp(request))

  def deleteProfilingGroup(
    request: DeleteProfilingGroupRequest
  ): CodeGuruProfilerIO[DeleteProfilingGroupResponse] =
    FF.liftF(DeleteProfilingGroupOp(request))

  def describeProfilingGroup(
    request: DescribeProfilingGroupRequest
  ): CodeGuruProfilerIO[DescribeProfilingGroupResponse] =
    FF.liftF(DescribeProfilingGroupOp(request))

  def getFindingsReportAccountSummary(
    request: GetFindingsReportAccountSummaryRequest
  ): CodeGuruProfilerIO[GetFindingsReportAccountSummaryResponse] =
    FF.liftF(GetFindingsReportAccountSummaryOp(request))

  def getNotificationConfiguration(
    request: GetNotificationConfigurationRequest
  ): CodeGuruProfilerIO[GetNotificationConfigurationResponse] =
    FF.liftF(GetNotificationConfigurationOp(request))

  def getPolicy(
    request: GetPolicyRequest
  ): CodeGuruProfilerIO[GetPolicyResponse] =
    FF.liftF(GetPolicyOp(request))

  def getProfile(
    request: GetProfileRequest
  ): CodeGuruProfilerIO[GetProfileResponse] =
    FF.liftF(GetProfileOp(request))

  def getRecommendations(
    request: GetRecommendationsRequest
  ): CodeGuruProfilerIO[GetRecommendationsResponse] =
    FF.liftF(GetRecommendationsOp(request))

  def listFindingsReports(
    request: ListFindingsReportsRequest
  ): CodeGuruProfilerIO[ListFindingsReportsResponse] =
    FF.liftF(ListFindingsReportsOp(request))

  def listProfileTimes(
    request: ListProfileTimesRequest
  ): CodeGuruProfilerIO[ListProfileTimesResponse] =
    FF.liftF(ListProfileTimesOp(request))

  def listProfilingGroups(
    request: ListProfilingGroupsRequest
  ): CodeGuruProfilerIO[ListProfilingGroupsResponse] =
    FF.liftF(ListProfilingGroupsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): CodeGuruProfilerIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def postAgentProfile(
    request: PostAgentProfileRequest
  ): CodeGuruProfilerIO[PostAgentProfileResponse] =
    FF.liftF(PostAgentProfileOp(request))

  def putPermission(
    request: PutPermissionRequest
  ): CodeGuruProfilerIO[PutPermissionResponse] =
    FF.liftF(PutPermissionOp(request))

  def removeNotificationChannel(
    request: RemoveNotificationChannelRequest
  ): CodeGuruProfilerIO[RemoveNotificationChannelResponse] =
    FF.liftF(RemoveNotificationChannelOp(request))

  def removePermission(
    request: RemovePermissionRequest
  ): CodeGuruProfilerIO[RemovePermissionResponse] =
    FF.liftF(RemovePermissionOp(request))

  def submitFeedback(
    request: SubmitFeedbackRequest
  ): CodeGuruProfilerIO[SubmitFeedbackResponse] =
    FF.liftF(SubmitFeedbackOp(request))

  def tagResource(
    request: TagResourceRequest
  ): CodeGuruProfilerIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): CodeGuruProfilerIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateProfilingGroup(
    request: UpdateProfilingGroupRequest
  ): CodeGuruProfilerIO[UpdateProfilingGroupResponse] =
    FF.liftF(UpdateProfilingGroupOp(request))
}
