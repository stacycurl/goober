package goober.hi

import goober.free.codestarconnections.CodeStarConnectionsIO
import software.amazon.awssdk.services.codestarconnections.model._


object codestarconnections {
  import goober.free.{codestarconnections ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def connection(
      connectionName: Option[String] = None,
      connectionArn: Option[String] = None,
      providerType: Option[String] = None,
      ownerAccountId: Option[String] = None,
      connectionStatus: Option[String] = None,
      hostArn: Option[String] = None
    ): Connection =
      Connection
        .builder
        .ifSome(connectionName)(_.connectionName(_))
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(providerType)(_.providerType(_))
        .ifSome(ownerAccountId)(_.ownerAccountId(_))
        .ifSome(connectionStatus)(_.connectionStatus(_))
        .ifSome(hostArn)(_.hostArn(_))
        .build

    def createConnectionInput(
      providerType: Option[String] = None,
      connectionName: Option[String] = None,
      tags: Option[List[Tag]] = None,
      hostArn: Option[String] = None
    ): CreateConnectionInput =
      CreateConnectionInput
        .builder
        .ifSome(providerType)(_.providerType(_))
        .ifSome(connectionName)(_.connectionName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(hostArn)(_.hostArn(_))
        .build

    def createConnectionOutput(
      connectionArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateConnectionOutput =
      CreateConnectionOutput
        .builder
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createHostInput(
      name: Option[String] = None,
      providerType: Option[String] = None,
      providerEndpoint: Option[String] = None,
      vpcConfiguration: Option[VpcConfiguration] = None,
      tags: Option[List[Tag]] = None
    ): CreateHostInput =
      CreateHostInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(providerType)(_.providerType(_))
        .ifSome(providerEndpoint)(_.providerEndpoint(_))
        .ifSome(vpcConfiguration)(_.vpcConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createHostOutput(
      hostArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateHostOutput =
      CreateHostOutput
        .builder
        .ifSome(hostArn)(_.hostArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def deleteConnectionInput(
      connectionArn: Option[String] = None
    ): DeleteConnectionInput =
      DeleteConnectionInput
        .builder
        .ifSome(connectionArn)(_.connectionArn(_))
        .build

    def deleteConnectionOutput(

    ): DeleteConnectionOutput =
      DeleteConnectionOutput
        .builder

        .build

    def deleteHostInput(
      hostArn: Option[String] = None
    ): DeleteHostInput =
      DeleteHostInput
        .builder
        .ifSome(hostArn)(_.hostArn(_))
        .build

    def deleteHostOutput(

    ): DeleteHostOutput =
      DeleteHostOutput
        .builder

        .build

    def getConnectionInput(
      connectionArn: Option[String] = None
    ): GetConnectionInput =
      GetConnectionInput
        .builder
        .ifSome(connectionArn)(_.connectionArn(_))
        .build

    def getConnectionOutput(
      connection: Option[Connection] = None
    ): GetConnectionOutput =
      GetConnectionOutput
        .builder
        .ifSome(connection)(_.connection(_))
        .build

    def getHostInput(
      hostArn: Option[String] = None
    ): GetHostInput =
      GetHostInput
        .builder
        .ifSome(hostArn)(_.hostArn(_))
        .build

    def getHostOutput(
      name: Option[String] = None,
      status: Option[String] = None,
      providerType: Option[String] = None,
      providerEndpoint: Option[String] = None,
      vpcConfiguration: Option[VpcConfiguration] = None
    ): GetHostOutput =
      GetHostOutput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(providerType)(_.providerType(_))
        .ifSome(providerEndpoint)(_.providerEndpoint(_))
        .ifSome(vpcConfiguration)(_.vpcConfiguration(_))
        .build

    def host(
      name: Option[String] = None,
      hostArn: Option[String] = None,
      providerType: Option[String] = None,
      providerEndpoint: Option[String] = None,
      vpcConfiguration: Option[VpcConfiguration] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None
    ): Host =
      Host
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(hostArn)(_.hostArn(_))
        .ifSome(providerType)(_.providerType(_))
        .ifSome(providerEndpoint)(_.providerEndpoint(_))
        .ifSome(vpcConfiguration)(_.vpcConfiguration(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listConnectionsInput(
      providerTypeFilter: Option[String] = None,
      hostArnFilter: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListConnectionsInput =
      ListConnectionsInput
        .builder
        .ifSome(providerTypeFilter)(_.providerTypeFilter(_))
        .ifSome(hostArnFilter)(_.hostArnFilter(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listConnectionsOutput(
      connections: Option[List[Connection]] = None,
      nextToken: Option[String] = None
    ): ListConnectionsOutput =
      ListConnectionsOutput
        .builder
        .ifSome(connections)(_.connections(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listHostsInput(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListHostsInput =
      ListHostsInput
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listHostsOutput(
      hosts: Option[List[Host]] = None,
      nextToken: Option[String] = None
    ): ListHostsOutput =
      ListHostsOutput
        .builder
        .ifSome(hosts)(_.hosts(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceInput(
      resourceArn: Option[String] = None
    ): ListTagsForResourceInput =
      ListTagsForResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceOutput(
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceOutput =
      ListTagsForResourceOutput
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceUnavailableException(
      message: Option[String] = None
    ): ResourceUnavailableException =
      ResourceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
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

    def tagResourceInput(
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceInput =
      TagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceOutput(

    ): TagResourceOutput =
      TagResourceOutput
        .builder

        .build

    def unsupportedOperationException(
      message: Option[String] = None
    ): UnsupportedOperationException =
      UnsupportedOperationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceInput(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceInput =
      UntagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceOutput(

    ): UntagResourceOutput =
      UntagResourceOutput
        .builder

        .build

    def updateHostInput(
      hostArn: Option[String] = None,
      providerEndpoint: Option[String] = None,
      vpcConfiguration: Option[VpcConfiguration] = None
    ): UpdateHostInput =
      UpdateHostInput
        .builder
        .ifSome(hostArn)(_.hostArn(_))
        .ifSome(providerEndpoint)(_.providerEndpoint(_))
        .ifSome(vpcConfiguration)(_.vpcConfiguration(_))
        .build

    def updateHostOutput(

    ): UpdateHostOutput =
      UpdateHostOutput
        .builder

        .build

    def vpcConfiguration(
      vpcId: Option[String] = None,
      subnetIds: Option[List[SubnetId]] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None,
      tlsCertificate: Option[String] = None
    ): VpcConfiguration =
      VpcConfiguration
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(tlsCertificate)(_.tlsCertificate(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
