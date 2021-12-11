package goober.hi

import goober.free.codestar.CodeStarIO
import software.amazon.awssdk.services.codestar.model._


object codestar {
  import goober.free.{codestar ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def associateTeamMemberRequest(
      projectId: Option[String] = None,
      clientRequestToken: Option[String] = None,
      userArn: Option[String] = None,
      projectRole: Option[String] = None,
      remoteAccessAllowed: Option[Boolean] = None
    ): AssociateTeamMemberRequest =
      AssociateTeamMemberRequest
        .builder
        .ifSome(projectId)(_.projectId(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(userArn)(_.userArn(_))
        .ifSome(projectRole)(_.projectRole(_))
        .ifSome(remoteAccessAllowed)(_.remoteAccessAllowed(_))
        .build

    def code(
      source: Option[CodeSource] = None,
      destination: Option[CodeDestination] = None
    ): Code =
      Code
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(destination)(_.destination(_))
        .build

    def codeCommitCodeDestination(
      name: Option[String] = None
    ): CodeCommitCodeDestination =
      CodeCommitCodeDestination
        .builder
        .ifSome(name)(_.name(_))
        .build

    def codeDestination(
      codeCommit: Option[CodeCommitCodeDestination] = None,
      gitHub: Option[GitHubCodeDestination] = None
    ): CodeDestination =
      CodeDestination
        .builder
        .ifSome(codeCommit)(_.codeCommit(_))
        .ifSome(gitHub)(_.gitHub(_))
        .build

    def codeSource(
      s3: Option[S3Location] = None
    ): CodeSource =
      CodeSource
        .builder
        .ifSome(s3)(_.s3(_))
        .build

    def concurrentModificationException(

    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder

        .build

    def createProjectRequest(
      name: Option[String] = None,
      id: Option[String] = None,
      description: Option[String] = None,
      clientRequestToken: Option[String] = None,
      sourceCode: Option[List[Code]] = None,
      toolchain: Option[Toolchain] = None,
      tags: Option[Tags] = None
    ): CreateProjectRequest =
      CreateProjectRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(sourceCode)(_.sourceCode(_))
        .ifSome(toolchain)(_.toolchain(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createUserProfileRequest(
      userArn: Option[String] = None,
      displayName: Option[String] = None,
      emailAddress: Option[String] = None,
      sshPublicKey: Option[String] = None
    ): CreateUserProfileRequest =
      CreateUserProfileRequest
        .builder
        .ifSome(userArn)(_.userArn(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(sshPublicKey)(_.sshPublicKey(_))
        .build

    def deleteProjectRequest(
      id: Option[String] = None,
      clientRequestToken: Option[String] = None,
      deleteStack: Option[Boolean] = None
    ): DeleteProjectRequest =
      DeleteProjectRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(deleteStack)(_.deleteStack(_))
        .build

    def deleteUserProfileRequest(
      userArn: Option[String] = None
    ): DeleteUserProfileRequest =
      DeleteUserProfileRequest
        .builder
        .ifSome(userArn)(_.userArn(_))
        .build

    def describeProjectRequest(
      id: Option[String] = None
    ): DescribeProjectRequest =
      DescribeProjectRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def describeUserProfileRequest(
      userArn: Option[String] = None
    ): DescribeUserProfileRequest =
      DescribeUserProfileRequest
        .builder
        .ifSome(userArn)(_.userArn(_))
        .build

    def disassociateTeamMemberRequest(
      projectId: Option[String] = None,
      userArn: Option[String] = None
    ): DisassociateTeamMemberRequest =
      DisassociateTeamMemberRequest
        .builder
        .ifSome(projectId)(_.projectId(_))
        .ifSome(userArn)(_.userArn(_))
        .build

    def gitHubCodeDestination(
      name: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      owner: Option[String] = None,
      privateRepository: Option[Boolean] = None,
      issuesEnabled: Option[Boolean] = None,
      token: Option[String] = None
    ): GitHubCodeDestination =
      GitHubCodeDestination
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(privateRepository)(_.privateRepository(_))
        .ifSome(issuesEnabled)(_.issuesEnabled(_))
        .ifSome(token)(_.token(_))
        .build

    def invalidNextTokenException(

    ): InvalidNextTokenException =
      InvalidNextTokenException
        .builder

        .build

    def invalidServiceRoleException(

    ): InvalidServiceRoleException =
      InvalidServiceRoleException
        .builder

        .build

    def limitExceededException(

    ): LimitExceededException =
      LimitExceededException
        .builder

        .build

    def listProjectsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListProjectsRequest =
      ListProjectsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listResourcesRequest(
      projectId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListResourcesRequest =
      ListResourcesRequest
        .builder
        .ifSome(projectId)(_.projectId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTagsForProjectRequest(
      id: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTagsForProjectRequest =
      ListTagsForProjectRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTeamMembersRequest(
      projectId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTeamMembersRequest =
      ListTeamMembersRequest
        .builder
        .ifSome(projectId)(_.projectId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listUserProfilesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListUserProfilesRequest =
      ListUserProfilesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def projectAlreadyExistsException(

    ): ProjectAlreadyExistsException =
      ProjectAlreadyExistsException
        .builder

        .build

    def projectConfigurationException(

    ): ProjectConfigurationException =
      ProjectConfigurationException
        .builder

        .build

    def projectCreationFailedException(

    ): ProjectCreationFailedException =
      ProjectCreationFailedException
        .builder

        .build

    def projectNotFoundException(

    ): ProjectNotFoundException =
      ProjectNotFoundException
        .builder

        .build

    def projectStatus(
      state: Option[String] = None,
      reason: Option[String] = None
    ): ProjectStatus =
      ProjectStatus
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(reason)(_.reason(_))
        .build

    def projectSummary(
      projectId: Option[String] = None,
      projectArn: Option[String] = None
    ): ProjectSummary =
      ProjectSummary
        .builder
        .ifSome(projectId)(_.projectId(_))
        .ifSome(projectArn)(_.projectArn(_))
        .build

    def resource(
      id: Option[String] = None
    ): Resource =
      Resource
        .builder
        .ifSome(id)(_.id(_))
        .build

    def s3Location(
      bucketName: Option[String] = None,
      bucketKey: Option[String] = None
    ): S3Location =
      S3Location
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(bucketKey)(_.bucketKey(_))
        .build

    def tagProjectRequest(
      id: Option[String] = None,
      tags: Option[Tags] = None
    ): TagProjectRequest =
      TagProjectRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(tags)(_.tags(_))
        .build

    def teamMember(
      userArn: Option[String] = None,
      projectRole: Option[String] = None,
      remoteAccessAllowed: Option[Boolean] = None
    ): TeamMember =
      TeamMember
        .builder
        .ifSome(userArn)(_.userArn(_))
        .ifSome(projectRole)(_.projectRole(_))
        .ifSome(remoteAccessAllowed)(_.remoteAccessAllowed(_))
        .build

    def teamMemberAlreadyAssociatedException(

    ): TeamMemberAlreadyAssociatedException =
      TeamMemberAlreadyAssociatedException
        .builder

        .build

    def teamMemberNotFoundException(

    ): TeamMemberNotFoundException =
      TeamMemberNotFoundException
        .builder

        .build

    def toolchain(
      source: Option[ToolchainSource] = None,
      roleArn: Option[String] = None,
      stackParameters: Option[TemplateParameterMap] = None
    ): Toolchain =
      Toolchain
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(stackParameters)(_.stackParameters(_))
        .build

    def toolchainSource(
      s3: Option[S3Location] = None
    ): ToolchainSource =
      ToolchainSource
        .builder
        .ifSome(s3)(_.s3(_))
        .build

    def untagProjectRequest(
      id: Option[String] = None,
      tags: Option[List[TagKey]] = None
    ): UntagProjectRequest =
      UntagProjectRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(tags)(_.tags(_))
        .build

    def updateProjectRequest(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): UpdateProjectRequest =
      UpdateProjectRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def updateTeamMemberRequest(
      projectId: Option[String] = None,
      userArn: Option[String] = None,
      projectRole: Option[String] = None,
      remoteAccessAllowed: Option[Boolean] = None
    ): UpdateTeamMemberRequest =
      UpdateTeamMemberRequest
        .builder
        .ifSome(projectId)(_.projectId(_))
        .ifSome(userArn)(_.userArn(_))
        .ifSome(projectRole)(_.projectRole(_))
        .ifSome(remoteAccessAllowed)(_.remoteAccessAllowed(_))
        .build

    def updateUserProfileRequest(
      userArn: Option[String] = None,
      displayName: Option[String] = None,
      emailAddress: Option[String] = None,
      sshPublicKey: Option[String] = None
    ): UpdateUserProfileRequest =
      UpdateUserProfileRequest
        .builder
        .ifSome(userArn)(_.userArn(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(sshPublicKey)(_.sshPublicKey(_))
        .build

    def userProfileAlreadyExistsException(

    ): UserProfileAlreadyExistsException =
      UserProfileAlreadyExistsException
        .builder

        .build

    def userProfileNotFoundException(

    ): UserProfileNotFoundException =
      UserProfileNotFoundException
        .builder

        .build

    def userProfileSummary(
      userArn: Option[String] = None,
      displayName: Option[String] = None,
      emailAddress: Option[String] = None,
      sshPublicKey: Option[String] = None
    ): UserProfileSummary =
      UserProfileSummary
        .builder
        .ifSome(userArn)(_.userArn(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(sshPublicKey)(_.sshPublicKey(_))
        .build

    def validationException(

    ): ValidationException =
      ValidationException
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
