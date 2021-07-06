package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.appflow.AppflowClient
import software.amazon.awssdk.services.appflow.model._


object appflow { module =>

  // Free monad over AppflowOp
  type AppflowIO[A] = FF[AppflowOp, A]

  sealed trait AppflowOp[A] {
    def visit[F[_]](visitor: AppflowOp.Visitor[F]): F[A]
  }

  object AppflowOp {
    // Given a AppflowClient we can embed a AppflowIO program in any algebra that understands embedding.
    implicit val AppflowOpEmbeddable: Embeddable[AppflowOp, AppflowClient] = new Embeddable[AppflowOp, AppflowClient] {
      def embed[A](client: AppflowClient, io: AppflowIO[A]): Embedded[A] = Embedded.Appflow(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends AppflowOp.Visitor[Kleisli[M, AppflowClient, *]] {
        def createConnectorProfile(
          request: CreateConnectorProfileRequest
        ): Kleisli[M, AppflowClient, CreateConnectorProfileResponse] =
          primitive(_.createConnectorProfile(request))

        def createFlow(
          request: CreateFlowRequest
        ): Kleisli[M, AppflowClient, CreateFlowResponse] =
          primitive(_.createFlow(request))

        def deleteConnectorProfile(
          request: DeleteConnectorProfileRequest
        ): Kleisli[M, AppflowClient, DeleteConnectorProfileResponse] =
          primitive(_.deleteConnectorProfile(request))

        def deleteFlow(
          request: DeleteFlowRequest
        ): Kleisli[M, AppflowClient, DeleteFlowResponse] =
          primitive(_.deleteFlow(request))

        def describeConnectorEntity(
          request: DescribeConnectorEntityRequest
        ): Kleisli[M, AppflowClient, DescribeConnectorEntityResponse] =
          primitive(_.describeConnectorEntity(request))

        def describeConnectorProfiles(
          request: DescribeConnectorProfilesRequest
        ): Kleisli[M, AppflowClient, DescribeConnectorProfilesResponse] =
          primitive(_.describeConnectorProfiles(request))

        def describeConnectors(
          request: DescribeConnectorsRequest
        ): Kleisli[M, AppflowClient, DescribeConnectorsResponse] =
          primitive(_.describeConnectors(request))

        def describeFlow(
          request: DescribeFlowRequest
        ): Kleisli[M, AppflowClient, DescribeFlowResponse] =
          primitive(_.describeFlow(request))

        def describeFlowExecutionRecords(
          request: DescribeFlowExecutionRecordsRequest
        ): Kleisli[M, AppflowClient, DescribeFlowExecutionRecordsResponse] =
          primitive(_.describeFlowExecutionRecords(request))

        def listConnectorEntities(
          request: ListConnectorEntitiesRequest
        ): Kleisli[M, AppflowClient, ListConnectorEntitiesResponse] =
          primitive(_.listConnectorEntities(request))

        def listFlows(
          request: ListFlowsRequest
        ): Kleisli[M, AppflowClient, ListFlowsResponse] =
          primitive(_.listFlows(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, AppflowClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def startFlow(
          request: StartFlowRequest
        ): Kleisli[M, AppflowClient, StartFlowResponse] =
          primitive(_.startFlow(request))

        def stopFlow(
          request: StopFlowRequest
        ): Kleisli[M, AppflowClient, StopFlowResponse] =
          primitive(_.stopFlow(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, AppflowClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, AppflowClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateConnectorProfile(
          request: UpdateConnectorProfileRequest
        ): Kleisli[M, AppflowClient, UpdateConnectorProfileResponse] =
          primitive(_.updateConnectorProfile(request))

        def updateFlow(
          request: UpdateFlowRequest
        ): Kleisli[M, AppflowClient, UpdateFlowResponse] =
          primitive(_.updateFlow(request))

        def primitive[A](
          f: AppflowClient => A
        ): Kleisli[M, AppflowClient, A]
      }
    }

    trait Visitor[F[_]] extends (AppflowOp ~> F) {
      final def apply[A](op: AppflowOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createConnectorProfile(
        request: CreateConnectorProfileRequest
      ): F[CreateConnectorProfileResponse]

      def createFlow(
        request: CreateFlowRequest
      ): F[CreateFlowResponse]

      def deleteConnectorProfile(
        request: DeleteConnectorProfileRequest
      ): F[DeleteConnectorProfileResponse]

      def deleteFlow(
        request: DeleteFlowRequest
      ): F[DeleteFlowResponse]

      def describeConnectorEntity(
        request: DescribeConnectorEntityRequest
      ): F[DescribeConnectorEntityResponse]

      def describeConnectorProfiles(
        request: DescribeConnectorProfilesRequest
      ): F[DescribeConnectorProfilesResponse]

      def describeConnectors(
        request: DescribeConnectorsRequest
      ): F[DescribeConnectorsResponse]

      def describeFlow(
        request: DescribeFlowRequest
      ): F[DescribeFlowResponse]

      def describeFlowExecutionRecords(
        request: DescribeFlowExecutionRecordsRequest
      ): F[DescribeFlowExecutionRecordsResponse]

      def listConnectorEntities(
        request: ListConnectorEntitiesRequest
      ): F[ListConnectorEntitiesResponse]

      def listFlows(
        request: ListFlowsRequest
      ): F[ListFlowsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def startFlow(
        request: StartFlowRequest
      ): F[StartFlowResponse]

      def stopFlow(
        request: StopFlowRequest
      ): F[StopFlowResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateConnectorProfile(
        request: UpdateConnectorProfileRequest
      ): F[UpdateConnectorProfileResponse]

      def updateFlow(
        request: UpdateFlowRequest
      ): F[UpdateFlowResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends AppflowOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateConnectorProfileOp(
      request: CreateConnectorProfileRequest
    ) extends AppflowOp[CreateConnectorProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConnectorProfileResponse] =
        visitor.createConnectorProfile(request)
    }

    final case class CreateFlowOp(
      request: CreateFlowRequest
    ) extends AppflowOp[CreateFlowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFlowResponse] =
        visitor.createFlow(request)
    }

    final case class DeleteConnectorProfileOp(
      request: DeleteConnectorProfileRequest
    ) extends AppflowOp[DeleteConnectorProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConnectorProfileResponse] =
        visitor.deleteConnectorProfile(request)
    }

    final case class DeleteFlowOp(
      request: DeleteFlowRequest
    ) extends AppflowOp[DeleteFlowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFlowResponse] =
        visitor.deleteFlow(request)
    }

    final case class DescribeConnectorEntityOp(
      request: DescribeConnectorEntityRequest
    ) extends AppflowOp[DescribeConnectorEntityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConnectorEntityResponse] =
        visitor.describeConnectorEntity(request)
    }

    final case class DescribeConnectorProfilesOp(
      request: DescribeConnectorProfilesRequest
    ) extends AppflowOp[DescribeConnectorProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConnectorProfilesResponse] =
        visitor.describeConnectorProfiles(request)
    }

    final case class DescribeConnectorsOp(
      request: DescribeConnectorsRequest
    ) extends AppflowOp[DescribeConnectorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConnectorsResponse] =
        visitor.describeConnectors(request)
    }

    final case class DescribeFlowOp(
      request: DescribeFlowRequest
    ) extends AppflowOp[DescribeFlowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFlowResponse] =
        visitor.describeFlow(request)
    }

    final case class DescribeFlowExecutionRecordsOp(
      request: DescribeFlowExecutionRecordsRequest
    ) extends AppflowOp[DescribeFlowExecutionRecordsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFlowExecutionRecordsResponse] =
        visitor.describeFlowExecutionRecords(request)
    }

    final case class ListConnectorEntitiesOp(
      request: ListConnectorEntitiesRequest
    ) extends AppflowOp[ListConnectorEntitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConnectorEntitiesResponse] =
        visitor.listConnectorEntities(request)
    }

    final case class ListFlowsOp(
      request: ListFlowsRequest
    ) extends AppflowOp[ListFlowsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFlowsResponse] =
        visitor.listFlows(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends AppflowOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class StartFlowOp(
      request: StartFlowRequest
    ) extends AppflowOp[StartFlowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartFlowResponse] =
        visitor.startFlow(request)
    }

    final case class StopFlowOp(
      request: StopFlowRequest
    ) extends AppflowOp[StopFlowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopFlowResponse] =
        visitor.stopFlow(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends AppflowOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends AppflowOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateConnectorProfileOp(
      request: UpdateConnectorProfileRequest
    ) extends AppflowOp[UpdateConnectorProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConnectorProfileResponse] =
        visitor.updateConnectorProfile(request)
    }

    final case class UpdateFlowOp(
      request: UpdateFlowRequest
    ) extends AppflowOp[UpdateFlowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFlowResponse] =
        visitor.updateFlow(request)
    }
  }

  import AppflowOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[AppflowOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createConnectorProfile(
    request: CreateConnectorProfileRequest
  ): AppflowIO[CreateConnectorProfileResponse] =
    FF.liftF(CreateConnectorProfileOp(request))

  def createFlow(
    request: CreateFlowRequest
  ): AppflowIO[CreateFlowResponse] =
    FF.liftF(CreateFlowOp(request))

  def deleteConnectorProfile(
    request: DeleteConnectorProfileRequest
  ): AppflowIO[DeleteConnectorProfileResponse] =
    FF.liftF(DeleteConnectorProfileOp(request))

  def deleteFlow(
    request: DeleteFlowRequest
  ): AppflowIO[DeleteFlowResponse] =
    FF.liftF(DeleteFlowOp(request))

  def describeConnectorEntity(
    request: DescribeConnectorEntityRequest
  ): AppflowIO[DescribeConnectorEntityResponse] =
    FF.liftF(DescribeConnectorEntityOp(request))

  def describeConnectorProfiles(
    request: DescribeConnectorProfilesRequest
  ): AppflowIO[DescribeConnectorProfilesResponse] =
    FF.liftF(DescribeConnectorProfilesOp(request))

  def describeConnectors(
    request: DescribeConnectorsRequest
  ): AppflowIO[DescribeConnectorsResponse] =
    FF.liftF(DescribeConnectorsOp(request))

  def describeFlow(
    request: DescribeFlowRequest
  ): AppflowIO[DescribeFlowResponse] =
    FF.liftF(DescribeFlowOp(request))

  def describeFlowExecutionRecords(
    request: DescribeFlowExecutionRecordsRequest
  ): AppflowIO[DescribeFlowExecutionRecordsResponse] =
    FF.liftF(DescribeFlowExecutionRecordsOp(request))

  def listConnectorEntities(
    request: ListConnectorEntitiesRequest
  ): AppflowIO[ListConnectorEntitiesResponse] =
    FF.liftF(ListConnectorEntitiesOp(request))

  def listFlows(
    request: ListFlowsRequest
  ): AppflowIO[ListFlowsResponse] =
    FF.liftF(ListFlowsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): AppflowIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def startFlow(
    request: StartFlowRequest
  ): AppflowIO[StartFlowResponse] =
    FF.liftF(StartFlowOp(request))

  def stopFlow(
    request: StopFlowRequest
  ): AppflowIO[StopFlowResponse] =
    FF.liftF(StopFlowOp(request))

  def tagResource(
    request: TagResourceRequest
  ): AppflowIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): AppflowIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateConnectorProfile(
    request: UpdateConnectorProfileRequest
  ): AppflowIO[UpdateConnectorProfileResponse] =
    FF.liftF(UpdateConnectorProfileOp(request))

  def updateFlow(
    request: UpdateFlowRequest
  ): AppflowIO[UpdateFlowResponse] =
    FF.liftF(UpdateFlowOp(request))
}
