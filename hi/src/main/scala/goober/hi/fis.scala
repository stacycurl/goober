package goober.hi

import goober.free.fis.FisIO
import software.amazon.awssdk.services.fis.model._


object fis {
  import goober.free.{fis ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def action(
      id: Option[String] = None,
      description: Option[String] = None,
      parameters: Option[ActionParameterMap] = None,
      targets: Option[ActionTargetMap] = None,
      tags: Option[TagMap] = None
    ): Action =
      Action
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(tags)(_.tags(_))
        .build

    def actionParameter(
      description: Option[String] = None,
      required: Option[Boolean] = None
    ): ActionParameter =
      ActionParameter
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(required)(_.required(_))
        .build

    def actionSummary(
      id: Option[String] = None,
      description: Option[String] = None,
      targets: Option[ActionTargetMap] = None,
      tags: Option[TagMap] = None
    ): ActionSummary =
      ActionSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(tags)(_.tags(_))
        .build

    def actionTarget(
      resourceType: Option[String] = None
    ): ActionTarget =
      ActionTarget
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createExperimentTemplateActionInput(
      actionId: Option[String] = None,
      description: Option[String] = None,
      parameters: Option[ExperimentTemplateActionParameterMap] = None,
      targets: Option[ExperimentTemplateActionTargetMap] = None,
      startAfter: Option[List[ExperimentTemplateActionStartAfter]] = None
    ): CreateExperimentTemplateActionInput =
      CreateExperimentTemplateActionInput
        .builder
        .ifSome(actionId)(_.actionId(_))
        .ifSome(description)(_.description(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(startAfter)(_.startAfter(_))
        .build

    def createExperimentTemplateRequest(
      clientToken: Option[String] = None,
      description: Option[String] = None,
      stopConditions: Option[List[CreateExperimentTemplateStopConditionInput]] = None,
      targets: Option[CreateExperimentTemplateTargetInputMap] = None,
      actions: Option[CreateExperimentTemplateActionInputMap] = None,
      roleArn: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateExperimentTemplateRequest =
      CreateExperimentTemplateRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(description)(_.description(_))
        .ifSome(stopConditions)(_.stopConditions(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createExperimentTemplateResponse(
      experimentTemplate: Option[ExperimentTemplate] = None
    ): CreateExperimentTemplateResponse =
      CreateExperimentTemplateResponse
        .builder
        .ifSome(experimentTemplate)(_.experimentTemplate(_))
        .build

    def createExperimentTemplateStopConditionInput(
      source: Option[String] = None,
      value: Option[String] = None
    ): CreateExperimentTemplateStopConditionInput =
      CreateExperimentTemplateStopConditionInput
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(value)(_.value(_))
        .build

    def createExperimentTemplateTargetInput(
      resourceType: Option[String] = None,
      resourceArns: Option[List[ResourceArn]] = None,
      resourceTags: Option[TagMap] = None,
      filters: Option[List[ExperimentTemplateTargetInputFilter]] = None,
      selectionMode: Option[String] = None
    ): CreateExperimentTemplateTargetInput =
      CreateExperimentTemplateTargetInput
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceArns)(_.resourceArns(_))
        .ifSome(resourceTags)(_.resourceTags(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(selectionMode)(_.selectionMode(_))
        .build

    def deleteExperimentTemplateRequest(
      id: Option[String] = None
    ): DeleteExperimentTemplateRequest =
      DeleteExperimentTemplateRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteExperimentTemplateResponse(
      experimentTemplate: Option[ExperimentTemplate] = None
    ): DeleteExperimentTemplateResponse =
      DeleteExperimentTemplateResponse
        .builder
        .ifSome(experimentTemplate)(_.experimentTemplate(_))
        .build

    def experiment(
      id: Option[String] = None,
      experimentTemplateId: Option[String] = None,
      roleArn: Option[String] = None,
      state: Option[ExperimentState] = None,
      targets: Option[ExperimentTargetMap] = None,
      actions: Option[ExperimentActionMap] = None,
      stopConditions: Option[List[ExperimentStopCondition]] = None,
      creationTime: Option[CreationTime] = None,
      startTime: Option[ExperimentStartTime] = None,
      endTime: Option[ExperimentEndTime] = None,
      tags: Option[TagMap] = None
    ): Experiment =
      Experiment
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(experimentTemplateId)(_.experimentTemplateId(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(stopConditions)(_.stopConditions(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def experimentAction(
      actionId: Option[String] = None,
      description: Option[String] = None,
      parameters: Option[ExperimentActionParameterMap] = None,
      targets: Option[ExperimentActionTargetMap] = None,
      startAfter: Option[List[ExperimentActionStartAfter]] = None,
      state: Option[ExperimentActionState] = None
    ): ExperimentAction =
      ExperimentAction
        .builder
        .ifSome(actionId)(_.actionId(_))
        .ifSome(description)(_.description(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(startAfter)(_.startAfter(_))
        .ifSome(state)(_.state(_))
        .build

    def experimentActionState(
      status: Option[String] = None,
      reason: Option[String] = None
    ): ExperimentActionState =
      ExperimentActionState
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(reason)(_.reason(_))
        .build

    def experimentState(
      status: Option[String] = None,
      reason: Option[String] = None
    ): ExperimentState =
      ExperimentState
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(reason)(_.reason(_))
        .build

    def experimentStopCondition(
      source: Option[String] = None,
      value: Option[String] = None
    ): ExperimentStopCondition =
      ExperimentStopCondition
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(value)(_.value(_))
        .build

    def experimentSummary(
      id: Option[String] = None,
      experimentTemplateId: Option[String] = None,
      state: Option[ExperimentState] = None,
      creationTime: Option[CreationTime] = None,
      tags: Option[TagMap] = None
    ): ExperimentSummary =
      ExperimentSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(experimentTemplateId)(_.experimentTemplateId(_))
        .ifSome(state)(_.state(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def experimentTarget(
      resourceType: Option[String] = None,
      resourceArns: Option[List[ResourceArn]] = None,
      resourceTags: Option[TagMap] = None,
      filters: Option[List[ExperimentTargetFilter]] = None,
      selectionMode: Option[String] = None
    ): ExperimentTarget =
      ExperimentTarget
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceArns)(_.resourceArns(_))
        .ifSome(resourceTags)(_.resourceTags(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(selectionMode)(_.selectionMode(_))
        .build

    def experimentTargetFilter(
      path: Option[String] = None,
      values: Option[List[ExperimentTargetFilterValue]] = None
    ): ExperimentTargetFilter =
      ExperimentTargetFilter
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(values)(_.values(_))
        .build

    def experimentTemplate(
      id: Option[String] = None,
      description: Option[String] = None,
      targets: Option[ExperimentTemplateTargetMap] = None,
      actions: Option[ExperimentTemplateActionMap] = None,
      stopConditions: Option[List[ExperimentTemplateStopCondition]] = None,
      creationTime: Option[CreationTime] = None,
      lastUpdateTime: Option[LastUpdateTime] = None,
      roleArn: Option[String] = None,
      tags: Option[TagMap] = None
    ): ExperimentTemplate =
      ExperimentTemplate
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(stopConditions)(_.stopConditions(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def experimentTemplateAction(
      actionId: Option[String] = None,
      description: Option[String] = None,
      parameters: Option[ExperimentTemplateActionParameterMap] = None,
      targets: Option[ExperimentTemplateActionTargetMap] = None,
      startAfter: Option[List[ExperimentTemplateActionStartAfter]] = None
    ): ExperimentTemplateAction =
      ExperimentTemplateAction
        .builder
        .ifSome(actionId)(_.actionId(_))
        .ifSome(description)(_.description(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(startAfter)(_.startAfter(_))
        .build

    def experimentTemplateStopCondition(
      source: Option[String] = None,
      value: Option[String] = None
    ): ExperimentTemplateStopCondition =
      ExperimentTemplateStopCondition
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(value)(_.value(_))
        .build

    def experimentTemplateSummary(
      id: Option[String] = None,
      description: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      lastUpdateTime: Option[LastUpdateTime] = None,
      tags: Option[TagMap] = None
    ): ExperimentTemplateSummary =
      ExperimentTemplateSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def experimentTemplateTarget(
      resourceType: Option[String] = None,
      resourceArns: Option[List[ResourceArn]] = None,
      resourceTags: Option[TagMap] = None,
      filters: Option[List[ExperimentTemplateTargetFilter]] = None,
      selectionMode: Option[String] = None
    ): ExperimentTemplateTarget =
      ExperimentTemplateTarget
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceArns)(_.resourceArns(_))
        .ifSome(resourceTags)(_.resourceTags(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(selectionMode)(_.selectionMode(_))
        .build

    def experimentTemplateTargetFilter(
      path: Option[String] = None,
      values: Option[List[ExperimentTemplateTargetFilterValue]] = None
    ): ExperimentTemplateTargetFilter =
      ExperimentTemplateTargetFilter
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(values)(_.values(_))
        .build

    def experimentTemplateTargetInputFilter(
      path: Option[String] = None,
      values: Option[List[ExperimentTemplateTargetFilterValue]] = None
    ): ExperimentTemplateTargetInputFilter =
      ExperimentTemplateTargetInputFilter
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(values)(_.values(_))
        .build

    def getActionRequest(
      id: Option[String] = None
    ): GetActionRequest =
      GetActionRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getActionResponse(
      action: Option[Action] = None
    ): GetActionResponse =
      GetActionResponse
        .builder
        .ifSome(action)(_.action(_))
        .build

    def getExperimentRequest(
      id: Option[String] = None
    ): GetExperimentRequest =
      GetExperimentRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getExperimentResponse(
      experiment: Option[Experiment] = None
    ): GetExperimentResponse =
      GetExperimentResponse
        .builder
        .ifSome(experiment)(_.experiment(_))
        .build

    def getExperimentTemplateRequest(
      id: Option[String] = None
    ): GetExperimentTemplateRequest =
      GetExperimentTemplateRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getExperimentTemplateResponse(
      experimentTemplate: Option[ExperimentTemplate] = None
    ): GetExperimentTemplateResponse =
      GetExperimentTemplateResponse
        .builder
        .ifSome(experimentTemplate)(_.experimentTemplate(_))
        .build

    def listActionsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListActionsRequest =
      ListActionsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listActionsResponse(
      actions: Option[List[ActionSummary]] = None,
      nextToken: Option[String] = None
    ): ListActionsResponse =
      ListActionsResponse
        .builder
        .ifSome(actions)(_.actions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listExperimentTemplatesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListExperimentTemplatesRequest =
      ListExperimentTemplatesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listExperimentTemplatesResponse(
      experimentTemplates: Option[List[ExperimentTemplateSummary]] = None,
      nextToken: Option[String] = None
    ): ListExperimentTemplatesResponse =
      ListExperimentTemplatesResponse
        .builder
        .ifSome(experimentTemplates)(_.experimentTemplates(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listExperimentsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListExperimentsRequest =
      ListExperimentsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listExperimentsResponse(
      experiments: Option[List[ExperimentSummary]] = None,
      nextToken: Option[String] = None
    ): ListExperimentsResponse =
      ListExperimentsResponse
        .builder
        .ifSome(experiments)(_.experiments(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[TagMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
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

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def startExperimentRequest(
      clientToken: Option[String] = None,
      experimentTemplateId: Option[String] = None,
      tags: Option[TagMap] = None
    ): StartExperimentRequest =
      StartExperimentRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(experimentTemplateId)(_.experimentTemplateId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def startExperimentResponse(
      experiment: Option[Experiment] = None
    ): StartExperimentResponse =
      StartExperimentResponse
        .builder
        .ifSome(experiment)(_.experiment(_))
        .build

    def stopExperimentRequest(
      id: Option[String] = None
    ): StopExperimentRequest =
      StopExperimentRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def stopExperimentResponse(
      experiment: Option[Experiment] = None
    ): StopExperimentResponse =
      StopExperimentResponse
        .builder
        .ifSome(experiment)(_.experiment(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[TagMap] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateExperimentTemplateActionInputItem(
      actionId: Option[String] = None,
      description: Option[String] = None,
      parameters: Option[ExperimentTemplateActionParameterMap] = None,
      targets: Option[ExperimentTemplateActionTargetMap] = None,
      startAfter: Option[List[ExperimentTemplateActionStartAfter]] = None
    ): UpdateExperimentTemplateActionInputItem =
      UpdateExperimentTemplateActionInputItem
        .builder
        .ifSome(actionId)(_.actionId(_))
        .ifSome(description)(_.description(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(startAfter)(_.startAfter(_))
        .build

    def updateExperimentTemplateRequest(
      id: Option[String] = None,
      description: Option[String] = None,
      stopConditions: Option[List[UpdateExperimentTemplateStopConditionInput]] = None,
      targets: Option[UpdateExperimentTemplateTargetInputMap] = None,
      actions: Option[UpdateExperimentTemplateActionInputMap] = None,
      roleArn: Option[String] = None
    ): UpdateExperimentTemplateRequest =
      UpdateExperimentTemplateRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(stopConditions)(_.stopConditions(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def updateExperimentTemplateResponse(
      experimentTemplate: Option[ExperimentTemplate] = None
    ): UpdateExperimentTemplateResponse =
      UpdateExperimentTemplateResponse
        .builder
        .ifSome(experimentTemplate)(_.experimentTemplate(_))
        .build

    def updateExperimentTemplateStopConditionInput(
      source: Option[String] = None,
      value: Option[String] = None
    ): UpdateExperimentTemplateStopConditionInput =
      UpdateExperimentTemplateStopConditionInput
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(value)(_.value(_))
        .build

    def updateExperimentTemplateTargetInput(
      resourceType: Option[String] = None,
      resourceArns: Option[List[ResourceArn]] = None,
      resourceTags: Option[TagMap] = None,
      filters: Option[List[ExperimentTemplateTargetInputFilter]] = None,
      selectionMode: Option[String] = None
    ): UpdateExperimentTemplateTargetInput =
      UpdateExperimentTemplateTargetInput
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceArns)(_.resourceArns(_))
        .ifSome(resourceTags)(_.resourceTags(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(selectionMode)(_.selectionMode(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
