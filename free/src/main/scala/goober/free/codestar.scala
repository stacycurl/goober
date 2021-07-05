package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.codestar.CodeStarClient
import software.amazon.awssdk.services.codestar.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object codestar { module =>

  // Free monad over CodeStarOp
  type CodeStarIO[A] = FF[CodeStarOp, A]

  sealed trait CodeStarOp[A] {
    def visit[F[_]](visitor: CodeStarOp.Visitor[F]): F[A]
  }

  object CodeStarOp {
    // Given a CodeStarClient we can embed a CodeStarIO program in any algebra that understands embedding.
    implicit val CodeStarOpEmbeddable: Embeddable[CodeStarOp, CodeStarClient] = new Embeddable[CodeStarOp, CodeStarClient] {
      def embed[A](client: CodeStarClient, io: CodeStarIO[A]): Embedded[A] = Embedded.CodeStar(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CodeStarOp.Visitor[Kleisli[M, CodeStarClient, *]] {
        def associateTeamMember(
          request: AssociateTeamMemberRequest
        ): Kleisli[M, CodeStarClient, AssociateTeamMemberResponse] =
          primitive(_.associateTeamMember(request))

        def createProject(
          request: CreateProjectRequest
        ): Kleisli[M, CodeStarClient, CreateProjectResponse] =
          primitive(_.createProject(request))

        def createUserProfile(
          request: CreateUserProfileRequest
        ): Kleisli[M, CodeStarClient, CreateUserProfileResponse] =
          primitive(_.createUserProfile(request))

        def deleteProject(
          request: DeleteProjectRequest
        ): Kleisli[M, CodeStarClient, DeleteProjectResponse] =
          primitive(_.deleteProject(request))

        def deleteUserProfile(
          request: DeleteUserProfileRequest
        ): Kleisli[M, CodeStarClient, DeleteUserProfileResponse] =
          primitive(_.deleteUserProfile(request))

        def describeProject(
          request: DescribeProjectRequest
        ): Kleisli[M, CodeStarClient, DescribeProjectResponse] =
          primitive(_.describeProject(request))

        def describeUserProfile(
          request: DescribeUserProfileRequest
        ): Kleisli[M, CodeStarClient, DescribeUserProfileResponse] =
          primitive(_.describeUserProfile(request))

        def disassociateTeamMember(
          request: DisassociateTeamMemberRequest
        ): Kleisli[M, CodeStarClient, DisassociateTeamMemberResponse] =
          primitive(_.disassociateTeamMember(request))

        def listProjects(
          request: ListProjectsRequest
        ): Kleisli[M, CodeStarClient, ListProjectsResponse] =
          primitive(_.listProjects(request))

        def listResources(
          request: ListResourcesRequest
        ): Kleisli[M, CodeStarClient, ListResourcesResponse] =
          primitive(_.listResources(request))

        def listTagsForProject(
          request: ListTagsForProjectRequest
        ): Kleisli[M, CodeStarClient, ListTagsForProjectResponse] =
          primitive(_.listTagsForProject(request))

        def listTeamMembers(
          request: ListTeamMembersRequest
        ): Kleisli[M, CodeStarClient, ListTeamMembersResponse] =
          primitive(_.listTeamMembers(request))

        def listUserProfiles(
          request: ListUserProfilesRequest
        ): Kleisli[M, CodeStarClient, ListUserProfilesResponse] =
          primitive(_.listUserProfiles(request))

        def tagProject(
          request: TagProjectRequest
        ): Kleisli[M, CodeStarClient, TagProjectResponse] =
          primitive(_.tagProject(request))

        def untagProject(
          request: UntagProjectRequest
        ): Kleisli[M, CodeStarClient, UntagProjectResponse] =
          primitive(_.untagProject(request))

        def updateProject(
          request: UpdateProjectRequest
        ): Kleisli[M, CodeStarClient, UpdateProjectResponse] =
          primitive(_.updateProject(request))

        def updateTeamMember(
          request: UpdateTeamMemberRequest
        ): Kleisli[M, CodeStarClient, UpdateTeamMemberResponse] =
          primitive(_.updateTeamMember(request))

        def updateUserProfile(
          request: UpdateUserProfileRequest
        ): Kleisli[M, CodeStarClient, UpdateUserProfileResponse] =
          primitive(_.updateUserProfile(request))

        def primitive[A](
          f: CodeStarClient => A
        ): Kleisli[M, CodeStarClient, A]
      }
    }

    trait Visitor[F[_]] extends (CodeStarOp ~> F) {
      final def apply[A](op: CodeStarOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateTeamMember(
        request: AssociateTeamMemberRequest
      ): F[AssociateTeamMemberResponse]

      def createProject(
        request: CreateProjectRequest
      ): F[CreateProjectResponse]

      def createUserProfile(
        request: CreateUserProfileRequest
      ): F[CreateUserProfileResponse]

      def deleteProject(
        request: DeleteProjectRequest
      ): F[DeleteProjectResponse]

      def deleteUserProfile(
        request: DeleteUserProfileRequest
      ): F[DeleteUserProfileResponse]

      def describeProject(
        request: DescribeProjectRequest
      ): F[DescribeProjectResponse]

      def describeUserProfile(
        request: DescribeUserProfileRequest
      ): F[DescribeUserProfileResponse]

      def disassociateTeamMember(
        request: DisassociateTeamMemberRequest
      ): F[DisassociateTeamMemberResponse]

      def listProjects(
        request: ListProjectsRequest
      ): F[ListProjectsResponse]

      def listResources(
        request: ListResourcesRequest
      ): F[ListResourcesResponse]

      def listTagsForProject(
        request: ListTagsForProjectRequest
      ): F[ListTagsForProjectResponse]

      def listTeamMembers(
        request: ListTeamMembersRequest
      ): F[ListTeamMembersResponse]

      def listUserProfiles(
        request: ListUserProfilesRequest
      ): F[ListUserProfilesResponse]

      def tagProject(
        request: TagProjectRequest
      ): F[TagProjectResponse]

      def untagProject(
        request: UntagProjectRequest
      ): F[UntagProjectResponse]

      def updateProject(
        request: UpdateProjectRequest
      ): F[UpdateProjectResponse]

      def updateTeamMember(
        request: UpdateTeamMemberRequest
      ): F[UpdateTeamMemberResponse]

      def updateUserProfile(
        request: UpdateUserProfileRequest
      ): F[UpdateUserProfileResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CodeStarOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateTeamMemberOp(
      request: AssociateTeamMemberRequest
    ) extends CodeStarOp[AssociateTeamMemberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateTeamMemberResponse] =
        visitor.associateTeamMember(request)
    }

    final case class CreateProjectOp(
      request: CreateProjectRequest
    ) extends CodeStarOp[CreateProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProjectResponse] =
        visitor.createProject(request)
    }

    final case class CreateUserProfileOp(
      request: CreateUserProfileRequest
    ) extends CodeStarOp[CreateUserProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserProfileResponse] =
        visitor.createUserProfile(request)
    }

    final case class DeleteProjectOp(
      request: DeleteProjectRequest
    ) extends CodeStarOp[DeleteProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProjectResponse] =
        visitor.deleteProject(request)
    }

    final case class DeleteUserProfileOp(
      request: DeleteUserProfileRequest
    ) extends CodeStarOp[DeleteUserProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserProfileResponse] =
        visitor.deleteUserProfile(request)
    }

    final case class DescribeProjectOp(
      request: DescribeProjectRequest
    ) extends CodeStarOp[DescribeProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProjectResponse] =
        visitor.describeProject(request)
    }

    final case class DescribeUserProfileOp(
      request: DescribeUserProfileRequest
    ) extends CodeStarOp[DescribeUserProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUserProfileResponse] =
        visitor.describeUserProfile(request)
    }

    final case class DisassociateTeamMemberOp(
      request: DisassociateTeamMemberRequest
    ) extends CodeStarOp[DisassociateTeamMemberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateTeamMemberResponse] =
        visitor.disassociateTeamMember(request)
    }

    final case class ListProjectsOp(
      request: ListProjectsRequest
    ) extends CodeStarOp[ListProjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProjectsResponse] =
        visitor.listProjects(request)
    }

    final case class ListResourcesOp(
      request: ListResourcesRequest
    ) extends CodeStarOp[ListResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResourcesResponse] =
        visitor.listResources(request)
    }

    final case class ListTagsForProjectOp(
      request: ListTagsForProjectRequest
    ) extends CodeStarOp[ListTagsForProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForProjectResponse] =
        visitor.listTagsForProject(request)
    }

    final case class ListTeamMembersOp(
      request: ListTeamMembersRequest
    ) extends CodeStarOp[ListTeamMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTeamMembersResponse] =
        visitor.listTeamMembers(request)
    }

    final case class ListUserProfilesOp(
      request: ListUserProfilesRequest
    ) extends CodeStarOp[ListUserProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUserProfilesResponse] =
        visitor.listUserProfiles(request)
    }

    final case class TagProjectOp(
      request: TagProjectRequest
    ) extends CodeStarOp[TagProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagProjectResponse] =
        visitor.tagProject(request)
    }

    final case class UntagProjectOp(
      request: UntagProjectRequest
    ) extends CodeStarOp[UntagProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagProjectResponse] =
        visitor.untagProject(request)
    }

    final case class UpdateProjectOp(
      request: UpdateProjectRequest
    ) extends CodeStarOp[UpdateProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateProjectResponse] =
        visitor.updateProject(request)
    }

    final case class UpdateTeamMemberOp(
      request: UpdateTeamMemberRequest
    ) extends CodeStarOp[UpdateTeamMemberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTeamMemberResponse] =
        visitor.updateTeamMember(request)
    }

    final case class UpdateUserProfileOp(
      request: UpdateUserProfileRequest
    ) extends CodeStarOp[UpdateUserProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserProfileResponse] =
        visitor.updateUserProfile(request)
    }
  }

  import CodeStarOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CodeStarOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateTeamMember(
    request: AssociateTeamMemberRequest
  ): CodeStarIO[AssociateTeamMemberResponse] =
    FF.liftF(AssociateTeamMemberOp(request))

  def createProject(
    request: CreateProjectRequest
  ): CodeStarIO[CreateProjectResponse] =
    FF.liftF(CreateProjectOp(request))

  def createUserProfile(
    request: CreateUserProfileRequest
  ): CodeStarIO[CreateUserProfileResponse] =
    FF.liftF(CreateUserProfileOp(request))

  def deleteProject(
    request: DeleteProjectRequest
  ): CodeStarIO[DeleteProjectResponse] =
    FF.liftF(DeleteProjectOp(request))

  def deleteUserProfile(
    request: DeleteUserProfileRequest
  ): CodeStarIO[DeleteUserProfileResponse] =
    FF.liftF(DeleteUserProfileOp(request))

  def describeProject(
    request: DescribeProjectRequest
  ): CodeStarIO[DescribeProjectResponse] =
    FF.liftF(DescribeProjectOp(request))

  def describeUserProfile(
    request: DescribeUserProfileRequest
  ): CodeStarIO[DescribeUserProfileResponse] =
    FF.liftF(DescribeUserProfileOp(request))

  def disassociateTeamMember(
    request: DisassociateTeamMemberRequest
  ): CodeStarIO[DisassociateTeamMemberResponse] =
    FF.liftF(DisassociateTeamMemberOp(request))

  def listProjects(
    request: ListProjectsRequest
  ): CodeStarIO[ListProjectsResponse] =
    FF.liftF(ListProjectsOp(request))

  def listResources(
    request: ListResourcesRequest
  ): CodeStarIO[ListResourcesResponse] =
    FF.liftF(ListResourcesOp(request))

  def listTagsForProject(
    request: ListTagsForProjectRequest
  ): CodeStarIO[ListTagsForProjectResponse] =
    FF.liftF(ListTagsForProjectOp(request))

  def listTeamMembers(
    request: ListTeamMembersRequest
  ): CodeStarIO[ListTeamMembersResponse] =
    FF.liftF(ListTeamMembersOp(request))

  def listUserProfiles(
    request: ListUserProfilesRequest
  ): CodeStarIO[ListUserProfilesResponse] =
    FF.liftF(ListUserProfilesOp(request))

  def tagProject(
    request: TagProjectRequest
  ): CodeStarIO[TagProjectResponse] =
    FF.liftF(TagProjectOp(request))

  def untagProject(
    request: UntagProjectRequest
  ): CodeStarIO[UntagProjectResponse] =
    FF.liftF(UntagProjectOp(request))

  def updateProject(
    request: UpdateProjectRequest
  ): CodeStarIO[UpdateProjectResponse] =
    FF.liftF(UpdateProjectOp(request))

  def updateTeamMember(
    request: UpdateTeamMemberRequest
  ): CodeStarIO[UpdateTeamMemberResponse] =
    FF.liftF(UpdateTeamMemberOp(request))

  def updateUserProfile(
    request: UpdateUserProfileRequest
  ): CodeStarIO[UpdateUserProfileResponse] =
    FF.liftF(UpdateUserProfileOp(request))
}
