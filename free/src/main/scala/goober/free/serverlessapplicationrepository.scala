package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.serverlessapplicationrepository.ServerlessApplicationRepositoryClient
import software.amazon.awssdk.services.serverlessapplicationrepository.model._


object serverlessapplicationrepository { module =>

  // Free monad over ServerlessApplicationRepositoryOp
  type ServerlessApplicationRepositoryIO[A] = FF[ServerlessApplicationRepositoryOp, A]

  sealed trait ServerlessApplicationRepositoryOp[A] {
    def visit[F[_]](visitor: ServerlessApplicationRepositoryOp.Visitor[F]): F[A]
  }

  object ServerlessApplicationRepositoryOp {
    // Given a ServerlessApplicationRepositoryClient we can embed a ServerlessApplicationRepositoryIO program in any algebra that understands embedding.
    implicit val ServerlessApplicationRepositoryOpEmbeddable: Embeddable[ServerlessApplicationRepositoryOp, ServerlessApplicationRepositoryClient] = new Embeddable[ServerlessApplicationRepositoryOp, ServerlessApplicationRepositoryClient] {
      def embed[A](client: ServerlessApplicationRepositoryClient, io: ServerlessApplicationRepositoryIO[A]): Embedded[A] = Embedded.ServerlessApplicationRepository(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ServerlessApplicationRepositoryOp.Visitor[Kleisli[M, ServerlessApplicationRepositoryClient, *]] {
        def createApplication(
          request: CreateApplicationRequest
        ): Kleisli[M, ServerlessApplicationRepositoryClient, CreateApplicationResponse] =
          primitive(_.createApplication(request))

        def createApplicationVersion(
          request: CreateApplicationVersionRequest
        ): Kleisli[M, ServerlessApplicationRepositoryClient, CreateApplicationVersionResponse] =
          primitive(_.createApplicationVersion(request))

        def createCloudFormationChangeSet(
          request: CreateCloudFormationChangeSetRequest
        ): Kleisli[M, ServerlessApplicationRepositoryClient, CreateCloudFormationChangeSetResponse] =
          primitive(_.createCloudFormationChangeSet(request))

        def createCloudFormationTemplate(
          request: CreateCloudFormationTemplateRequest
        ): Kleisli[M, ServerlessApplicationRepositoryClient, CreateCloudFormationTemplateResponse] =
          primitive(_.createCloudFormationTemplate(request))

        def deleteApplication(
          request: DeleteApplicationRequest
        ): Kleisli[M, ServerlessApplicationRepositoryClient, DeleteApplicationResponse] =
          primitive(_.deleteApplication(request))

        def getApplication(
          request: GetApplicationRequest
        ): Kleisli[M, ServerlessApplicationRepositoryClient, GetApplicationResponse] =
          primitive(_.getApplication(request))

        def getApplicationPolicy(
          request: GetApplicationPolicyRequest
        ): Kleisli[M, ServerlessApplicationRepositoryClient, GetApplicationPolicyResponse] =
          primitive(_.getApplicationPolicy(request))

        def getCloudFormationTemplate(
          request: GetCloudFormationTemplateRequest
        ): Kleisli[M, ServerlessApplicationRepositoryClient, GetCloudFormationTemplateResponse] =
          primitive(_.getCloudFormationTemplate(request))

        def listApplicationDependencies(
          request: ListApplicationDependenciesRequest
        ): Kleisli[M, ServerlessApplicationRepositoryClient, ListApplicationDependenciesResponse] =
          primitive(_.listApplicationDependencies(request))

        def listApplicationVersions(
          request: ListApplicationVersionsRequest
        ): Kleisli[M, ServerlessApplicationRepositoryClient, ListApplicationVersionsResponse] =
          primitive(_.listApplicationVersions(request))

        def listApplications(
          request: ListApplicationsRequest
        ): Kleisli[M, ServerlessApplicationRepositoryClient, ListApplicationsResponse] =
          primitive(_.listApplications(request))

        def putApplicationPolicy(
          request: PutApplicationPolicyRequest
        ): Kleisli[M, ServerlessApplicationRepositoryClient, PutApplicationPolicyResponse] =
          primitive(_.putApplicationPolicy(request))

        def unshareApplication(
          request: UnshareApplicationRequest
        ): Kleisli[M, ServerlessApplicationRepositoryClient, UnshareApplicationResponse] =
          primitive(_.unshareApplication(request))

        def updateApplication(
          request: UpdateApplicationRequest
        ): Kleisli[M, ServerlessApplicationRepositoryClient, UpdateApplicationResponse] =
          primitive(_.updateApplication(request))

        def primitive[A](
          f: ServerlessApplicationRepositoryClient => A
        ): Kleisli[M, ServerlessApplicationRepositoryClient, A]
      }
    }

    trait Visitor[F[_]] extends (ServerlessApplicationRepositoryOp ~> F) {
      final def apply[A](op: ServerlessApplicationRepositoryOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createApplication(
        request: CreateApplicationRequest
      ): F[CreateApplicationResponse]

      def createApplicationVersion(
        request: CreateApplicationVersionRequest
      ): F[CreateApplicationVersionResponse]

      def createCloudFormationChangeSet(
        request: CreateCloudFormationChangeSetRequest
      ): F[CreateCloudFormationChangeSetResponse]

      def createCloudFormationTemplate(
        request: CreateCloudFormationTemplateRequest
      ): F[CreateCloudFormationTemplateResponse]

      def deleteApplication(
        request: DeleteApplicationRequest
      ): F[DeleteApplicationResponse]

      def getApplication(
        request: GetApplicationRequest
      ): F[GetApplicationResponse]

      def getApplicationPolicy(
        request: GetApplicationPolicyRequest
      ): F[GetApplicationPolicyResponse]

      def getCloudFormationTemplate(
        request: GetCloudFormationTemplateRequest
      ): F[GetCloudFormationTemplateResponse]

      def listApplicationDependencies(
        request: ListApplicationDependenciesRequest
      ): F[ListApplicationDependenciesResponse]

      def listApplicationVersions(
        request: ListApplicationVersionsRequest
      ): F[ListApplicationVersionsResponse]

      def listApplications(
        request: ListApplicationsRequest
      ): F[ListApplicationsResponse]

      def putApplicationPolicy(
        request: PutApplicationPolicyRequest
      ): F[PutApplicationPolicyResponse]

      def unshareApplication(
        request: UnshareApplicationRequest
      ): F[UnshareApplicationResponse]

      def updateApplication(
        request: UpdateApplicationRequest
      ): F[UpdateApplicationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ServerlessApplicationRepositoryOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateApplicationOp(
      request: CreateApplicationRequest
    ) extends ServerlessApplicationRepositoryOp[CreateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApplicationResponse] =
        visitor.createApplication(request)
    }

    final case class CreateApplicationVersionOp(
      request: CreateApplicationVersionRequest
    ) extends ServerlessApplicationRepositoryOp[CreateApplicationVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApplicationVersionResponse] =
        visitor.createApplicationVersion(request)
    }

    final case class CreateCloudFormationChangeSetOp(
      request: CreateCloudFormationChangeSetRequest
    ) extends ServerlessApplicationRepositoryOp[CreateCloudFormationChangeSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCloudFormationChangeSetResponse] =
        visitor.createCloudFormationChangeSet(request)
    }

    final case class CreateCloudFormationTemplateOp(
      request: CreateCloudFormationTemplateRequest
    ) extends ServerlessApplicationRepositoryOp[CreateCloudFormationTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCloudFormationTemplateResponse] =
        visitor.createCloudFormationTemplate(request)
    }

    final case class DeleteApplicationOp(
      request: DeleteApplicationRequest
    ) extends ServerlessApplicationRepositoryOp[DeleteApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationResponse] =
        visitor.deleteApplication(request)
    }

    final case class GetApplicationOp(
      request: GetApplicationRequest
    ) extends ServerlessApplicationRepositoryOp[GetApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApplicationResponse] =
        visitor.getApplication(request)
    }

    final case class GetApplicationPolicyOp(
      request: GetApplicationPolicyRequest
    ) extends ServerlessApplicationRepositoryOp[GetApplicationPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApplicationPolicyResponse] =
        visitor.getApplicationPolicy(request)
    }

    final case class GetCloudFormationTemplateOp(
      request: GetCloudFormationTemplateRequest
    ) extends ServerlessApplicationRepositoryOp[GetCloudFormationTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCloudFormationTemplateResponse] =
        visitor.getCloudFormationTemplate(request)
    }

    final case class ListApplicationDependenciesOp(
      request: ListApplicationDependenciesRequest
    ) extends ServerlessApplicationRepositoryOp[ListApplicationDependenciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListApplicationDependenciesResponse] =
        visitor.listApplicationDependencies(request)
    }

    final case class ListApplicationVersionsOp(
      request: ListApplicationVersionsRequest
    ) extends ServerlessApplicationRepositoryOp[ListApplicationVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListApplicationVersionsResponse] =
        visitor.listApplicationVersions(request)
    }

    final case class ListApplicationsOp(
      request: ListApplicationsRequest
    ) extends ServerlessApplicationRepositoryOp[ListApplicationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListApplicationsResponse] =
        visitor.listApplications(request)
    }

    final case class PutApplicationPolicyOp(
      request: PutApplicationPolicyRequest
    ) extends ServerlessApplicationRepositoryOp[PutApplicationPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutApplicationPolicyResponse] =
        visitor.putApplicationPolicy(request)
    }

    final case class UnshareApplicationOp(
      request: UnshareApplicationRequest
    ) extends ServerlessApplicationRepositoryOp[UnshareApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UnshareApplicationResponse] =
        visitor.unshareApplication(request)
    }

    final case class UpdateApplicationOp(
      request: UpdateApplicationRequest
    ) extends ServerlessApplicationRepositoryOp[UpdateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApplicationResponse] =
        visitor.updateApplication(request)
    }
  }

  import ServerlessApplicationRepositoryOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ServerlessApplicationRepositoryOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createApplication(
    request: CreateApplicationRequest
  ): ServerlessApplicationRepositoryIO[CreateApplicationResponse] =
    FF.liftF(CreateApplicationOp(request))

  def createApplicationVersion(
    request: CreateApplicationVersionRequest
  ): ServerlessApplicationRepositoryIO[CreateApplicationVersionResponse] =
    FF.liftF(CreateApplicationVersionOp(request))

  def createCloudFormationChangeSet(
    request: CreateCloudFormationChangeSetRequest
  ): ServerlessApplicationRepositoryIO[CreateCloudFormationChangeSetResponse] =
    FF.liftF(CreateCloudFormationChangeSetOp(request))

  def createCloudFormationTemplate(
    request: CreateCloudFormationTemplateRequest
  ): ServerlessApplicationRepositoryIO[CreateCloudFormationTemplateResponse] =
    FF.liftF(CreateCloudFormationTemplateOp(request))

  def deleteApplication(
    request: DeleteApplicationRequest
  ): ServerlessApplicationRepositoryIO[DeleteApplicationResponse] =
    FF.liftF(DeleteApplicationOp(request))

  def getApplication(
    request: GetApplicationRequest
  ): ServerlessApplicationRepositoryIO[GetApplicationResponse] =
    FF.liftF(GetApplicationOp(request))

  def getApplicationPolicy(
    request: GetApplicationPolicyRequest
  ): ServerlessApplicationRepositoryIO[GetApplicationPolicyResponse] =
    FF.liftF(GetApplicationPolicyOp(request))

  def getCloudFormationTemplate(
    request: GetCloudFormationTemplateRequest
  ): ServerlessApplicationRepositoryIO[GetCloudFormationTemplateResponse] =
    FF.liftF(GetCloudFormationTemplateOp(request))

  def listApplicationDependencies(
    request: ListApplicationDependenciesRequest
  ): ServerlessApplicationRepositoryIO[ListApplicationDependenciesResponse] =
    FF.liftF(ListApplicationDependenciesOp(request))

  def listApplicationVersions(
    request: ListApplicationVersionsRequest
  ): ServerlessApplicationRepositoryIO[ListApplicationVersionsResponse] =
    FF.liftF(ListApplicationVersionsOp(request))

  def listApplications(
    request: ListApplicationsRequest
  ): ServerlessApplicationRepositoryIO[ListApplicationsResponse] =
    FF.liftF(ListApplicationsOp(request))

  def putApplicationPolicy(
    request: PutApplicationPolicyRequest
  ): ServerlessApplicationRepositoryIO[PutApplicationPolicyResponse] =
    FF.liftF(PutApplicationPolicyOp(request))

  def unshareApplication(
    request: UnshareApplicationRequest
  ): ServerlessApplicationRepositoryIO[UnshareApplicationResponse] =
    FF.liftF(UnshareApplicationOp(request))

  def updateApplication(
    request: UpdateApplicationRequest
  ): ServerlessApplicationRepositoryIO[UpdateApplicationResponse] =
    FF.liftF(UpdateApplicationOp(request))
}
