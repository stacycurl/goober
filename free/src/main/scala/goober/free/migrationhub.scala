package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.migrationhub.MigrationHubClient
import software.amazon.awssdk.services.migrationhub.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object migrationhub { module =>

  // Free monad over MigrationHubOp
  type MigrationHubIO[A] = FF[MigrationHubOp, A]

  sealed trait MigrationHubOp[A] {
    def visit[F[_]](visitor: MigrationHubOp.Visitor[F]): F[A]
  }

  object MigrationHubOp {
    // Given a MigrationHubClient we can embed a MigrationHubIO program in any algebra that understands embedding.
    implicit val MigrationHubOpEmbeddable: Embeddable[MigrationHubOp, MigrationHubClient] = new Embeddable[MigrationHubOp, MigrationHubClient] {
      def embed[A](client: MigrationHubClient, io: MigrationHubIO[A]): Embedded[A] = Embedded.MigrationHub(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MigrationHubOp.Visitor[Kleisli[M, MigrationHubClient, *]] {
        def associateCreatedArtifact(
          request: AssociateCreatedArtifactRequest
        ): Kleisli[M, MigrationHubClient, AssociateCreatedArtifactResponse] =
          primitive(_.associateCreatedArtifact(request))

        def associateDiscoveredResource(
          request: AssociateDiscoveredResourceRequest
        ): Kleisli[M, MigrationHubClient, AssociateDiscoveredResourceResponse] =
          primitive(_.associateDiscoveredResource(request))

        def createProgressUpdateStream(
          request: CreateProgressUpdateStreamRequest
        ): Kleisli[M, MigrationHubClient, CreateProgressUpdateStreamResponse] =
          primitive(_.createProgressUpdateStream(request))

        def deleteProgressUpdateStream(
          request: DeleteProgressUpdateStreamRequest
        ): Kleisli[M, MigrationHubClient, DeleteProgressUpdateStreamResponse] =
          primitive(_.deleteProgressUpdateStream(request))

        def describeApplicationState(
          request: DescribeApplicationStateRequest
        ): Kleisli[M, MigrationHubClient, DescribeApplicationStateResponse] =
          primitive(_.describeApplicationState(request))

        def describeMigrationTask(
          request: DescribeMigrationTaskRequest
        ): Kleisli[M, MigrationHubClient, DescribeMigrationTaskResponse] =
          primitive(_.describeMigrationTask(request))

        def disassociateCreatedArtifact(
          request: DisassociateCreatedArtifactRequest
        ): Kleisli[M, MigrationHubClient, DisassociateCreatedArtifactResponse] =
          primitive(_.disassociateCreatedArtifact(request))

        def disassociateDiscoveredResource(
          request: DisassociateDiscoveredResourceRequest
        ): Kleisli[M, MigrationHubClient, DisassociateDiscoveredResourceResponse] =
          primitive(_.disassociateDiscoveredResource(request))

        def importMigrationTask(
          request: ImportMigrationTaskRequest
        ): Kleisli[M, MigrationHubClient, ImportMigrationTaskResponse] =
          primitive(_.importMigrationTask(request))

        def listApplicationStates(
          request: ListApplicationStatesRequest
        ): Kleisli[M, MigrationHubClient, ListApplicationStatesResponse] =
          primitive(_.listApplicationStates(request))

        def listCreatedArtifacts(
          request: ListCreatedArtifactsRequest
        ): Kleisli[M, MigrationHubClient, ListCreatedArtifactsResponse] =
          primitive(_.listCreatedArtifacts(request))

        def listDiscoveredResources(
          request: ListDiscoveredResourcesRequest
        ): Kleisli[M, MigrationHubClient, ListDiscoveredResourcesResponse] =
          primitive(_.listDiscoveredResources(request))

        def listMigrationTasks(
          request: ListMigrationTasksRequest
        ): Kleisli[M, MigrationHubClient, ListMigrationTasksResponse] =
          primitive(_.listMigrationTasks(request))

        def listProgressUpdateStreams(
          request: ListProgressUpdateStreamsRequest
        ): Kleisli[M, MigrationHubClient, ListProgressUpdateStreamsResponse] =
          primitive(_.listProgressUpdateStreams(request))

        def notifyApplicationState(
          request: NotifyApplicationStateRequest
        ): Kleisli[M, MigrationHubClient, NotifyApplicationStateResponse] =
          primitive(_.notifyApplicationState(request))

        def notifyMigrationTaskState(
          request: NotifyMigrationTaskStateRequest
        ): Kleisli[M, MigrationHubClient, NotifyMigrationTaskStateResponse] =
          primitive(_.notifyMigrationTaskState(request))

        def putResourceAttributes(
          request: PutResourceAttributesRequest
        ): Kleisli[M, MigrationHubClient, PutResourceAttributesResponse] =
          primitive(_.putResourceAttributes(request))

        def primitive[A](
          f: MigrationHubClient => A
        ): Kleisli[M, MigrationHubClient, A]
      }
    }

    trait Visitor[F[_]] extends (MigrationHubOp ~> F) {
      final def apply[A](op: MigrationHubOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateCreatedArtifact(
        request: AssociateCreatedArtifactRequest
      ): F[AssociateCreatedArtifactResponse]

      def associateDiscoveredResource(
        request: AssociateDiscoveredResourceRequest
      ): F[AssociateDiscoveredResourceResponse]

      def createProgressUpdateStream(
        request: CreateProgressUpdateStreamRequest
      ): F[CreateProgressUpdateStreamResponse]

      def deleteProgressUpdateStream(
        request: DeleteProgressUpdateStreamRequest
      ): F[DeleteProgressUpdateStreamResponse]

      def describeApplicationState(
        request: DescribeApplicationStateRequest
      ): F[DescribeApplicationStateResponse]

      def describeMigrationTask(
        request: DescribeMigrationTaskRequest
      ): F[DescribeMigrationTaskResponse]

      def disassociateCreatedArtifact(
        request: DisassociateCreatedArtifactRequest
      ): F[DisassociateCreatedArtifactResponse]

      def disassociateDiscoveredResource(
        request: DisassociateDiscoveredResourceRequest
      ): F[DisassociateDiscoveredResourceResponse]

      def importMigrationTask(
        request: ImportMigrationTaskRequest
      ): F[ImportMigrationTaskResponse]

      def listApplicationStates(
        request: ListApplicationStatesRequest
      ): F[ListApplicationStatesResponse]

      def listCreatedArtifacts(
        request: ListCreatedArtifactsRequest
      ): F[ListCreatedArtifactsResponse]

      def listDiscoveredResources(
        request: ListDiscoveredResourcesRequest
      ): F[ListDiscoveredResourcesResponse]

      def listMigrationTasks(
        request: ListMigrationTasksRequest
      ): F[ListMigrationTasksResponse]

      def listProgressUpdateStreams(
        request: ListProgressUpdateStreamsRequest
      ): F[ListProgressUpdateStreamsResponse]

      def notifyApplicationState(
        request: NotifyApplicationStateRequest
      ): F[NotifyApplicationStateResponse]

      def notifyMigrationTaskState(
        request: NotifyMigrationTaskStateRequest
      ): F[NotifyMigrationTaskStateResponse]

      def putResourceAttributes(
        request: PutResourceAttributesRequest
      ): F[PutResourceAttributesResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MigrationHubOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateCreatedArtifactOp(
      request: AssociateCreatedArtifactRequest
    ) extends MigrationHubOp[AssociateCreatedArtifactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateCreatedArtifactResponse] =
        visitor.associateCreatedArtifact(request)
    }

    final case class AssociateDiscoveredResourceOp(
      request: AssociateDiscoveredResourceRequest
    ) extends MigrationHubOp[AssociateDiscoveredResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateDiscoveredResourceResponse] =
        visitor.associateDiscoveredResource(request)
    }

    final case class CreateProgressUpdateStreamOp(
      request: CreateProgressUpdateStreamRequest
    ) extends MigrationHubOp[CreateProgressUpdateStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProgressUpdateStreamResponse] =
        visitor.createProgressUpdateStream(request)
    }

    final case class DeleteProgressUpdateStreamOp(
      request: DeleteProgressUpdateStreamRequest
    ) extends MigrationHubOp[DeleteProgressUpdateStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProgressUpdateStreamResponse] =
        visitor.deleteProgressUpdateStream(request)
    }

    final case class DescribeApplicationStateOp(
      request: DescribeApplicationStateRequest
    ) extends MigrationHubOp[DescribeApplicationStateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeApplicationStateResponse] =
        visitor.describeApplicationState(request)
    }

    final case class DescribeMigrationTaskOp(
      request: DescribeMigrationTaskRequest
    ) extends MigrationHubOp[DescribeMigrationTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMigrationTaskResponse] =
        visitor.describeMigrationTask(request)
    }

    final case class DisassociateCreatedArtifactOp(
      request: DisassociateCreatedArtifactRequest
    ) extends MigrationHubOp[DisassociateCreatedArtifactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateCreatedArtifactResponse] =
        visitor.disassociateCreatedArtifact(request)
    }

    final case class DisassociateDiscoveredResourceOp(
      request: DisassociateDiscoveredResourceRequest
    ) extends MigrationHubOp[DisassociateDiscoveredResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateDiscoveredResourceResponse] =
        visitor.disassociateDiscoveredResource(request)
    }

    final case class ImportMigrationTaskOp(
      request: ImportMigrationTaskRequest
    ) extends MigrationHubOp[ImportMigrationTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportMigrationTaskResponse] =
        visitor.importMigrationTask(request)
    }

    final case class ListApplicationStatesOp(
      request: ListApplicationStatesRequest
    ) extends MigrationHubOp[ListApplicationStatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListApplicationStatesResponse] =
        visitor.listApplicationStates(request)
    }

    final case class ListCreatedArtifactsOp(
      request: ListCreatedArtifactsRequest
    ) extends MigrationHubOp[ListCreatedArtifactsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCreatedArtifactsResponse] =
        visitor.listCreatedArtifacts(request)
    }

    final case class ListDiscoveredResourcesOp(
      request: ListDiscoveredResourcesRequest
    ) extends MigrationHubOp[ListDiscoveredResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDiscoveredResourcesResponse] =
        visitor.listDiscoveredResources(request)
    }

    final case class ListMigrationTasksOp(
      request: ListMigrationTasksRequest
    ) extends MigrationHubOp[ListMigrationTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMigrationTasksResponse] =
        visitor.listMigrationTasks(request)
    }

    final case class ListProgressUpdateStreamsOp(
      request: ListProgressUpdateStreamsRequest
    ) extends MigrationHubOp[ListProgressUpdateStreamsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProgressUpdateStreamsResponse] =
        visitor.listProgressUpdateStreams(request)
    }

    final case class NotifyApplicationStateOp(
      request: NotifyApplicationStateRequest
    ) extends MigrationHubOp[NotifyApplicationStateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[NotifyApplicationStateResponse] =
        visitor.notifyApplicationState(request)
    }

    final case class NotifyMigrationTaskStateOp(
      request: NotifyMigrationTaskStateRequest
    ) extends MigrationHubOp[NotifyMigrationTaskStateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[NotifyMigrationTaskStateResponse] =
        visitor.notifyMigrationTaskState(request)
    }

    final case class PutResourceAttributesOp(
      request: PutResourceAttributesRequest
    ) extends MigrationHubOp[PutResourceAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutResourceAttributesResponse] =
        visitor.putResourceAttributes(request)
    }
  }

  import MigrationHubOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MigrationHubOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateCreatedArtifact(
    request: AssociateCreatedArtifactRequest
  ): MigrationHubIO[AssociateCreatedArtifactResponse] =
    FF.liftF(AssociateCreatedArtifactOp(request))

  def associateDiscoveredResource(
    request: AssociateDiscoveredResourceRequest
  ): MigrationHubIO[AssociateDiscoveredResourceResponse] =
    FF.liftF(AssociateDiscoveredResourceOp(request))

  def createProgressUpdateStream(
    request: CreateProgressUpdateStreamRequest
  ): MigrationHubIO[CreateProgressUpdateStreamResponse] =
    FF.liftF(CreateProgressUpdateStreamOp(request))

  def deleteProgressUpdateStream(
    request: DeleteProgressUpdateStreamRequest
  ): MigrationHubIO[DeleteProgressUpdateStreamResponse] =
    FF.liftF(DeleteProgressUpdateStreamOp(request))

  def describeApplicationState(
    request: DescribeApplicationStateRequest
  ): MigrationHubIO[DescribeApplicationStateResponse] =
    FF.liftF(DescribeApplicationStateOp(request))

  def describeMigrationTask(
    request: DescribeMigrationTaskRequest
  ): MigrationHubIO[DescribeMigrationTaskResponse] =
    FF.liftF(DescribeMigrationTaskOp(request))

  def disassociateCreatedArtifact(
    request: DisassociateCreatedArtifactRequest
  ): MigrationHubIO[DisassociateCreatedArtifactResponse] =
    FF.liftF(DisassociateCreatedArtifactOp(request))

  def disassociateDiscoveredResource(
    request: DisassociateDiscoveredResourceRequest
  ): MigrationHubIO[DisassociateDiscoveredResourceResponse] =
    FF.liftF(DisassociateDiscoveredResourceOp(request))

  def importMigrationTask(
    request: ImportMigrationTaskRequest
  ): MigrationHubIO[ImportMigrationTaskResponse] =
    FF.liftF(ImportMigrationTaskOp(request))

  def listApplicationStates(
    request: ListApplicationStatesRequest
  ): MigrationHubIO[ListApplicationStatesResponse] =
    FF.liftF(ListApplicationStatesOp(request))

  def listCreatedArtifacts(
    request: ListCreatedArtifactsRequest
  ): MigrationHubIO[ListCreatedArtifactsResponse] =
    FF.liftF(ListCreatedArtifactsOp(request))

  def listDiscoveredResources(
    request: ListDiscoveredResourcesRequest
  ): MigrationHubIO[ListDiscoveredResourcesResponse] =
    FF.liftF(ListDiscoveredResourcesOp(request))

  def listMigrationTasks(
    request: ListMigrationTasksRequest
  ): MigrationHubIO[ListMigrationTasksResponse] =
    FF.liftF(ListMigrationTasksOp(request))

  def listProgressUpdateStreams(
    request: ListProgressUpdateStreamsRequest
  ): MigrationHubIO[ListProgressUpdateStreamsResponse] =
    FF.liftF(ListProgressUpdateStreamsOp(request))

  def notifyApplicationState(
    request: NotifyApplicationStateRequest
  ): MigrationHubIO[NotifyApplicationStateResponse] =
    FF.liftF(NotifyApplicationStateOp(request))

  def notifyMigrationTaskState(
    request: NotifyMigrationTaskStateRequest
  ): MigrationHubIO[NotifyMigrationTaskStateResponse] =
    FF.liftF(NotifyMigrationTaskStateOp(request))

  def putResourceAttributes(
    request: PutResourceAttributesRequest
  ): MigrationHubIO[PutResourceAttributesResponse] =
    FF.liftF(PutResourceAttributesOp(request))
}
