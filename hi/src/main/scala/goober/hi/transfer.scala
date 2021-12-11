package goober.hi

import goober.free.transfer.TransferIO
import software.amazon.awssdk.services.transfer.model._


object transfer {
  import goober.free.{transfer ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createAccessRequest(
      homeDirectory: Option[String] = None,
      homeDirectoryType: Option[String] = None,
      homeDirectoryMappings: Option[List[HomeDirectoryMapEntry]] = None,
      policy: Option[String] = None,
      posixProfile: Option[PosixProfile] = None,
      role: Option[String] = None,
      serverId: Option[String] = None,
      externalId: Option[String] = None
    ): CreateAccessRequest =
      CreateAccessRequest
        .builder
        .ifSome(homeDirectory)(_.homeDirectory(_))
        .ifSome(homeDirectoryType)(_.homeDirectoryType(_))
        .ifSome(homeDirectoryMappings)(_.homeDirectoryMappings(_))
        .ifSome(policy)(_.policy(_))
        .ifSome(posixProfile)(_.posixProfile(_))
        .ifSome(role)(_.role(_))
        .ifSome(serverId)(_.serverId(_))
        .ifSome(externalId)(_.externalId(_))
        .build

    def createAccessResponse(
      serverId: Option[String] = None,
      externalId: Option[String] = None
    ): CreateAccessResponse =
      CreateAccessResponse
        .builder
        .ifSome(serverId)(_.serverId(_))
        .ifSome(externalId)(_.externalId(_))
        .build

    def createServerRequest(
      certificate: Option[String] = None,
      domain: Option[String] = None,
      endpointDetails: Option[EndpointDetails] = None,
      endpointType: Option[String] = None,
      hostKey: Option[String] = None,
      identityProviderDetails: Option[IdentityProviderDetails] = None,
      identityProviderType: Option[String] = None,
      loggingRole: Option[String] = None,
      protocols: Option[List[Protocol]] = None,
      securityPolicyName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateServerRequest =
      CreateServerRequest
        .builder
        .ifSome(certificate)(_.certificate(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(endpointDetails)(_.endpointDetails(_))
        .ifSome(endpointType)(_.endpointType(_))
        .ifSome(hostKey)(_.hostKey(_))
        .ifSome(identityProviderDetails)(_.identityProviderDetails(_))
        .ifSome(identityProviderType)(_.identityProviderType(_))
        .ifSome(loggingRole)(_.loggingRole(_))
        .ifSome(protocols)(_.protocols(_))
        .ifSome(securityPolicyName)(_.securityPolicyName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createServerResponse(
      serverId: Option[String] = None
    ): CreateServerResponse =
      CreateServerResponse
        .builder
        .ifSome(serverId)(_.serverId(_))
        .build

    def createUserRequest(
      homeDirectory: Option[String] = None,
      homeDirectoryType: Option[String] = None,
      homeDirectoryMappings: Option[List[HomeDirectoryMapEntry]] = None,
      policy: Option[String] = None,
      posixProfile: Option[PosixProfile] = None,
      role: Option[String] = None,
      serverId: Option[String] = None,
      sshPublicKeyBody: Option[String] = None,
      tags: Option[List[Tag]] = None,
      userName: Option[String] = None
    ): CreateUserRequest =
      CreateUserRequest
        .builder
        .ifSome(homeDirectory)(_.homeDirectory(_))
        .ifSome(homeDirectoryType)(_.homeDirectoryType(_))
        .ifSome(homeDirectoryMappings)(_.homeDirectoryMappings(_))
        .ifSome(policy)(_.policy(_))
        .ifSome(posixProfile)(_.posixProfile(_))
        .ifSome(role)(_.role(_))
        .ifSome(serverId)(_.serverId(_))
        .ifSome(sshPublicKeyBody)(_.sshPublicKeyBody(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(userName)(_.userName(_))
        .build

    def createUserResponse(
      serverId: Option[String] = None,
      userName: Option[String] = None
    ): CreateUserResponse =
      CreateUserResponse
        .builder
        .ifSome(serverId)(_.serverId(_))
        .ifSome(userName)(_.userName(_))
        .build

    def deleteAccessRequest(
      serverId: Option[String] = None,
      externalId: Option[String] = None
    ): DeleteAccessRequest =
      DeleteAccessRequest
        .builder
        .ifSome(serverId)(_.serverId(_))
        .ifSome(externalId)(_.externalId(_))
        .build

    def deleteServerRequest(
      serverId: Option[String] = None
    ): DeleteServerRequest =
      DeleteServerRequest
        .builder
        .ifSome(serverId)(_.serverId(_))
        .build

    def deleteSshPublicKeyRequest(
      serverId: Option[String] = None,
      sshPublicKeyId: Option[String] = None,
      userName: Option[String] = None
    ): DeleteSshPublicKeyRequest =
      DeleteSshPublicKeyRequest
        .builder
        .ifSome(serverId)(_.serverId(_))
        .ifSome(sshPublicKeyId)(_.sshPublicKeyId(_))
        .ifSome(userName)(_.userName(_))
        .build

    def deleteUserRequest(
      serverId: Option[String] = None,
      userName: Option[String] = None
    ): DeleteUserRequest =
      DeleteUserRequest
        .builder
        .ifSome(serverId)(_.serverId(_))
        .ifSome(userName)(_.userName(_))
        .build

    def describeAccessRequest(
      serverId: Option[String] = None,
      externalId: Option[String] = None
    ): DescribeAccessRequest =
      DescribeAccessRequest
        .builder
        .ifSome(serverId)(_.serverId(_))
        .ifSome(externalId)(_.externalId(_))
        .build

    def describeAccessResponse(
      serverId: Option[String] = None,
      access: Option[DescribedAccess] = None
    ): DescribeAccessResponse =
      DescribeAccessResponse
        .builder
        .ifSome(serverId)(_.serverId(_))
        .ifSome(access)(_.access(_))
        .build

    def describeSecurityPolicyRequest(
      securityPolicyName: Option[String] = None
    ): DescribeSecurityPolicyRequest =
      DescribeSecurityPolicyRequest
        .builder
        .ifSome(securityPolicyName)(_.securityPolicyName(_))
        .build

    def describeSecurityPolicyResponse(
      securityPolicy: Option[DescribedSecurityPolicy] = None
    ): DescribeSecurityPolicyResponse =
      DescribeSecurityPolicyResponse
        .builder
        .ifSome(securityPolicy)(_.securityPolicy(_))
        .build

    def describeServerRequest(
      serverId: Option[String] = None
    ): DescribeServerRequest =
      DescribeServerRequest
        .builder
        .ifSome(serverId)(_.serverId(_))
        .build

    def describeServerResponse(
      server: Option[DescribedServer] = None
    ): DescribeServerResponse =
      DescribeServerResponse
        .builder
        .ifSome(server)(_.server(_))
        .build

    def describeUserRequest(
      serverId: Option[String] = None,
      userName: Option[String] = None
    ): DescribeUserRequest =
      DescribeUserRequest
        .builder
        .ifSome(serverId)(_.serverId(_))
        .ifSome(userName)(_.userName(_))
        .build

    def describeUserResponse(
      serverId: Option[String] = None,
      user: Option[DescribedUser] = None
    ): DescribeUserResponse =
      DescribeUserResponse
        .builder
        .ifSome(serverId)(_.serverId(_))
        .ifSome(user)(_.user(_))
        .build

    def describedAccess(
      homeDirectory: Option[String] = None,
      homeDirectoryMappings: Option[List[HomeDirectoryMapEntry]] = None,
      homeDirectoryType: Option[String] = None,
      policy: Option[String] = None,
      posixProfile: Option[PosixProfile] = None,
      role: Option[String] = None,
      externalId: Option[String] = None
    ): DescribedAccess =
      DescribedAccess
        .builder
        .ifSome(homeDirectory)(_.homeDirectory(_))
        .ifSome(homeDirectoryMappings)(_.homeDirectoryMappings(_))
        .ifSome(homeDirectoryType)(_.homeDirectoryType(_))
        .ifSome(policy)(_.policy(_))
        .ifSome(posixProfile)(_.posixProfile(_))
        .ifSome(role)(_.role(_))
        .ifSome(externalId)(_.externalId(_))
        .build

    def describedSecurityPolicy(
      fips: Option[Boolean] = None,
      securityPolicyName: Option[String] = None,
      sshCiphers: Option[List[SecurityPolicyOption]] = None,
      sshKexs: Option[List[SecurityPolicyOption]] = None,
      sshMacs: Option[List[SecurityPolicyOption]] = None,
      tlsCiphers: Option[List[SecurityPolicyOption]] = None
    ): DescribedSecurityPolicy =
      DescribedSecurityPolicy
        .builder
        .ifSome(fips)(_.fips(_))
        .ifSome(securityPolicyName)(_.securityPolicyName(_))
        .ifSome(sshCiphers)(_.sshCiphers(_))
        .ifSome(sshKexs)(_.sshKexs(_))
        .ifSome(sshMacs)(_.sshMacs(_))
        .ifSome(tlsCiphers)(_.tlsCiphers(_))
        .build

    def describedServer(
      arn: Option[String] = None,
      certificate: Option[String] = None,
      domain: Option[String] = None,
      endpointDetails: Option[EndpointDetails] = None,
      endpointType: Option[String] = None,
      hostKeyFingerprint: Option[String] = None,
      identityProviderDetails: Option[IdentityProviderDetails] = None,
      identityProviderType: Option[String] = None,
      loggingRole: Option[String] = None,
      protocols: Option[List[Protocol]] = None,
      securityPolicyName: Option[String] = None,
      serverId: Option[String] = None,
      state: Option[String] = None,
      tags: Option[List[Tag]] = None,
      userCount: Option[Int] = None
    ): DescribedServer =
      DescribedServer
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(certificate)(_.certificate(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(endpointDetails)(_.endpointDetails(_))
        .ifSome(endpointType)(_.endpointType(_))
        .ifSome(hostKeyFingerprint)(_.hostKeyFingerprint(_))
        .ifSome(identityProviderDetails)(_.identityProviderDetails(_))
        .ifSome(identityProviderType)(_.identityProviderType(_))
        .ifSome(loggingRole)(_.loggingRole(_))
        .ifSome(protocols)(_.protocols(_))
        .ifSome(securityPolicyName)(_.securityPolicyName(_))
        .ifSome(serverId)(_.serverId(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(userCount)(_.userCount(_))
        .build

    def describedUser(
      arn: Option[String] = None,
      homeDirectory: Option[String] = None,
      homeDirectoryMappings: Option[List[HomeDirectoryMapEntry]] = None,
      homeDirectoryType: Option[String] = None,
      policy: Option[String] = None,
      posixProfile: Option[PosixProfile] = None,
      role: Option[String] = None,
      sshPublicKeys: Option[List[SshPublicKey]] = None,
      tags: Option[List[Tag]] = None,
      userName: Option[String] = None
    ): DescribedUser =
      DescribedUser
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(homeDirectory)(_.homeDirectory(_))
        .ifSome(homeDirectoryMappings)(_.homeDirectoryMappings(_))
        .ifSome(homeDirectoryType)(_.homeDirectoryType(_))
        .ifSome(policy)(_.policy(_))
        .ifSome(posixProfile)(_.posixProfile(_))
        .ifSome(role)(_.role(_))
        .ifSome(sshPublicKeys)(_.sshPublicKeys(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(userName)(_.userName(_))
        .build

    def endpointDetails(
      addressAllocationIds: Option[List[AddressAllocationId]] = None,
      subnetIds: Option[List[SubnetId]] = None,
      vpcEndpointId: Option[String] = None,
      vpcId: Option[String] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None
    ): EndpointDetails =
      EndpointDetails
        .builder
        .ifSome(addressAllocationIds)(_.addressAllocationIds(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(vpcEndpointId)(_.vpcEndpointId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

    def homeDirectoryMapEntry(
      entry: Option[String] = None,
      target: Option[String] = None
    ): HomeDirectoryMapEntry =
      HomeDirectoryMapEntry
        .builder
        .ifSome(entry)(_.entry(_))
        .ifSome(target)(_.target(_))
        .build

    def identityProviderDetails(
      url: Option[String] = None,
      invocationRole: Option[String] = None,
      directoryId: Option[String] = None
    ): IdentityProviderDetails =
      IdentityProviderDetails
        .builder
        .ifSome(url)(_.url(_))
        .ifSome(invocationRole)(_.invocationRole(_))
        .ifSome(directoryId)(_.directoryId(_))
        .build

    def importSshPublicKeyRequest(
      serverId: Option[String] = None,
      sshPublicKeyBody: Option[String] = None,
      userName: Option[String] = None
    ): ImportSshPublicKeyRequest =
      ImportSshPublicKeyRequest
        .builder
        .ifSome(serverId)(_.serverId(_))
        .ifSome(sshPublicKeyBody)(_.sshPublicKeyBody(_))
        .ifSome(userName)(_.userName(_))
        .build

    def importSshPublicKeyResponse(
      serverId: Option[String] = None,
      sshPublicKeyId: Option[String] = None,
      userName: Option[String] = None
    ): ImportSshPublicKeyResponse =
      ImportSshPublicKeyResponse
        .builder
        .ifSome(serverId)(_.serverId(_))
        .ifSome(sshPublicKeyId)(_.sshPublicKeyId(_))
        .ifSome(userName)(_.userName(_))
        .build

    def internalServiceError(
      message: Option[String] = None
    ): InternalServiceError =
      InternalServiceError
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidNextTokenException(
      message: Option[String] = None
    ): InvalidNextTokenException =
      InvalidNextTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRequestException(
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listAccessesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      serverId: Option[String] = None
    ): ListAccessesRequest =
      ListAccessesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(serverId)(_.serverId(_))
        .build

    def listAccessesResponse(
      nextToken: Option[String] = None,
      serverId: Option[String] = None,
      accesses: Option[List[ListedAccess]] = None
    ): ListAccessesResponse =
      ListAccessesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(serverId)(_.serverId(_))
        .ifSome(accesses)(_.accesses(_))
        .build

    def listSecurityPoliciesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListSecurityPoliciesRequest =
      ListSecurityPoliciesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSecurityPoliciesResponse(
      nextToken: Option[String] = None,
      securityPolicyNames: Option[List[SecurityPolicyName]] = None
    ): ListSecurityPoliciesResponse =
      ListSecurityPoliciesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(securityPolicyNames)(_.securityPolicyNames(_))
        .build

    def listServersRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListServersRequest =
      ListServersRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listServersResponse(
      nextToken: Option[String] = None,
      servers: Option[List[ListedServer]] = None
    ): ListServersResponse =
      ListServersResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(servers)(_.servers(_))
        .build

    def listTagsForResourceRequest(
      arn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceResponse(
      arn: Option[String] = None,
      nextToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def listUsersRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      serverId: Option[String] = None
    ): ListUsersRequest =
      ListUsersRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(serverId)(_.serverId(_))
        .build

    def listUsersResponse(
      nextToken: Option[String] = None,
      serverId: Option[String] = None,
      users: Option[List[ListedUser]] = None
    ): ListUsersResponse =
      ListUsersResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(serverId)(_.serverId(_))
        .ifSome(users)(_.users(_))
        .build

    def listedAccess(
      homeDirectory: Option[String] = None,
      homeDirectoryType: Option[String] = None,
      role: Option[String] = None,
      externalId: Option[String] = None
    ): ListedAccess =
      ListedAccess
        .builder
        .ifSome(homeDirectory)(_.homeDirectory(_))
        .ifSome(homeDirectoryType)(_.homeDirectoryType(_))
        .ifSome(role)(_.role(_))
        .ifSome(externalId)(_.externalId(_))
        .build

    def listedServer(
      arn: Option[String] = None,
      domain: Option[String] = None,
      identityProviderType: Option[String] = None,
      endpointType: Option[String] = None,
      loggingRole: Option[String] = None,
      serverId: Option[String] = None,
      state: Option[String] = None,
      userCount: Option[Int] = None
    ): ListedServer =
      ListedServer
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(identityProviderType)(_.identityProviderType(_))
        .ifSome(endpointType)(_.endpointType(_))
        .ifSome(loggingRole)(_.loggingRole(_))
        .ifSome(serverId)(_.serverId(_))
        .ifSome(state)(_.state(_))
        .ifSome(userCount)(_.userCount(_))
        .build

    def listedUser(
      arn: Option[String] = None,
      homeDirectory: Option[String] = None,
      homeDirectoryType: Option[String] = None,
      role: Option[String] = None,
      sshPublicKeyCount: Option[Int] = None,
      userName: Option[String] = None
    ): ListedUser =
      ListedUser
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(homeDirectory)(_.homeDirectory(_))
        .ifSome(homeDirectoryType)(_.homeDirectoryType(_))
        .ifSome(role)(_.role(_))
        .ifSome(sshPublicKeyCount)(_.sshPublicKeyCount(_))
        .ifSome(userName)(_.userName(_))
        .build

    def posixProfile(
      uid: Option[PosixId] = None,
      gid: Option[PosixId] = None,
      secondaryGids: Option[List[PosixId]] = None
    ): PosixProfile =
      PosixProfile
        .builder
        .ifSome(uid)(_.uid(_))
        .ifSome(gid)(_.gid(_))
        .ifSome(secondaryGids)(_.secondaryGids(_))
        .build

    def resourceExistsException(
      message: Option[String] = None,
      resource: Option[String] = None,
      resourceType: Option[String] = None
    ): ResourceExistsException =
      ResourceExistsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resource: Option[String] = None,
      resourceType: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def sshPublicKey(
      dateImported: Option[DateImported] = None,
      sshPublicKeyBody: Option[String] = None,
      sshPublicKeyId: Option[String] = None
    ): SshPublicKey =
      SshPublicKey
        .builder
        .ifSome(dateImported)(_.dateImported(_))
        .ifSome(sshPublicKeyBody)(_.sshPublicKeyBody(_))
        .ifSome(sshPublicKeyId)(_.sshPublicKeyId(_))
        .build

    def startServerRequest(
      serverId: Option[String] = None
    ): StartServerRequest =
      StartServerRequest
        .builder
        .ifSome(serverId)(_.serverId(_))
        .build

    def stopServerRequest(
      serverId: Option[String] = None
    ): StopServerRequest =
      StopServerRequest
        .builder
        .ifSome(serverId)(_.serverId(_))
        .build

    def tag(
      key: Option[String] = None,
      value: Option[String] = None
    ): Tag =
      Tag
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def tagResourceRequest(
      arn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def testIdentityProviderRequest(
      serverId: Option[String] = None,
      serverProtocol: Option[String] = None,
      sourceIp: Option[String] = None,
      userName: Option[String] = None,
      userPassword: Option[String] = None
    ): TestIdentityProviderRequest =
      TestIdentityProviderRequest
        .builder
        .ifSome(serverId)(_.serverId(_))
        .ifSome(serverProtocol)(_.serverProtocol(_))
        .ifSome(sourceIp)(_.sourceIp(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(userPassword)(_.userPassword(_))
        .build

    def testIdentityProviderResponse(
      response: Option[String] = None,
      statusCode: Option[Int] = None,
      message: Option[String] = None,
      url: Option[String] = None
    ): TestIdentityProviderResponse =
      TestIdentityProviderResponse
        .builder
        .ifSome(response)(_.response(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(message)(_.message(_))
        .ifSome(url)(_.url(_))
        .build

    def throttlingException(
      retryAfterSeconds: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .build

    def untagResourceRequest(
      arn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateAccessRequest(
      homeDirectory: Option[String] = None,
      homeDirectoryType: Option[String] = None,
      homeDirectoryMappings: Option[List[HomeDirectoryMapEntry]] = None,
      policy: Option[String] = None,
      posixProfile: Option[PosixProfile] = None,
      role: Option[String] = None,
      serverId: Option[String] = None,
      externalId: Option[String] = None
    ): UpdateAccessRequest =
      UpdateAccessRequest
        .builder
        .ifSome(homeDirectory)(_.homeDirectory(_))
        .ifSome(homeDirectoryType)(_.homeDirectoryType(_))
        .ifSome(homeDirectoryMappings)(_.homeDirectoryMappings(_))
        .ifSome(policy)(_.policy(_))
        .ifSome(posixProfile)(_.posixProfile(_))
        .ifSome(role)(_.role(_))
        .ifSome(serverId)(_.serverId(_))
        .ifSome(externalId)(_.externalId(_))
        .build

    def updateAccessResponse(
      serverId: Option[String] = None,
      externalId: Option[String] = None
    ): UpdateAccessResponse =
      UpdateAccessResponse
        .builder
        .ifSome(serverId)(_.serverId(_))
        .ifSome(externalId)(_.externalId(_))
        .build

    def updateServerRequest(
      certificate: Option[String] = None,
      endpointDetails: Option[EndpointDetails] = None,
      endpointType: Option[String] = None,
      hostKey: Option[String] = None,
      identityProviderDetails: Option[IdentityProviderDetails] = None,
      loggingRole: Option[String] = None,
      protocols: Option[List[Protocol]] = None,
      securityPolicyName: Option[String] = None,
      serverId: Option[String] = None
    ): UpdateServerRequest =
      UpdateServerRequest
        .builder
        .ifSome(certificate)(_.certificate(_))
        .ifSome(endpointDetails)(_.endpointDetails(_))
        .ifSome(endpointType)(_.endpointType(_))
        .ifSome(hostKey)(_.hostKey(_))
        .ifSome(identityProviderDetails)(_.identityProviderDetails(_))
        .ifSome(loggingRole)(_.loggingRole(_))
        .ifSome(protocols)(_.protocols(_))
        .ifSome(securityPolicyName)(_.securityPolicyName(_))
        .ifSome(serverId)(_.serverId(_))
        .build

    def updateServerResponse(
      serverId: Option[String] = None
    ): UpdateServerResponse =
      UpdateServerResponse
        .builder
        .ifSome(serverId)(_.serverId(_))
        .build

    def updateUserRequest(
      homeDirectory: Option[String] = None,
      homeDirectoryType: Option[String] = None,
      homeDirectoryMappings: Option[List[HomeDirectoryMapEntry]] = None,
      policy: Option[String] = None,
      posixProfile: Option[PosixProfile] = None,
      role: Option[String] = None,
      serverId: Option[String] = None,
      userName: Option[String] = None
    ): UpdateUserRequest =
      UpdateUserRequest
        .builder
        .ifSome(homeDirectory)(_.homeDirectory(_))
        .ifSome(homeDirectoryType)(_.homeDirectoryType(_))
        .ifSome(homeDirectoryMappings)(_.homeDirectoryMappings(_))
        .ifSome(policy)(_.policy(_))
        .ifSome(posixProfile)(_.posixProfile(_))
        .ifSome(role)(_.role(_))
        .ifSome(serverId)(_.serverId(_))
        .ifSome(userName)(_.userName(_))
        .build

    def updateUserResponse(
      serverId: Option[String] = None,
      userName: Option[String] = None
    ): UpdateUserResponse =
      UpdateUserResponse
        .builder
        .ifSome(serverId)(_.serverId(_))
        .ifSome(userName)(_.userName(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
