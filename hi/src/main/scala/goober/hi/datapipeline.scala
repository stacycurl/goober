package goober.hi

import goober.free.datapipeline.DataPipelineIO
import software.amazon.awssdk.services.datapipeline.model._


object datapipeline {
  import goober.free.{datapipeline ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def activatePipelineInput(
      pipelineId: Option[String] = None,
      parameterValues: Option[List[ParameterValue]] = None,
      startTimestamp: Option[timestamp] = None
    ): ActivatePipelineInput =
      ActivatePipelineInput
        .builder
        .ifSome(pipelineId)(_.pipelineId(_))
        .ifSome(parameterValues)(_.parameterValues(_))
        .ifSome(startTimestamp)(_.startTimestamp(_))
        .build

    def activatePipelineOutput(

    ): ActivatePipelineOutput =
      ActivatePipelineOutput
        .builder

        .build

    def addTagsInput(
      pipelineId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): AddTagsInput =
      AddTagsInput
        .builder
        .ifSome(pipelineId)(_.pipelineId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def addTagsOutput(

    ): AddTagsOutput =
      AddTagsOutput
        .builder

        .build

    def createPipelineInput(
      name: Option[String] = None,
      uniqueId: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreatePipelineInput =
      CreatePipelineInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(uniqueId)(_.uniqueId(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPipelineOutput(
      pipelineId: Option[String] = None
    ): CreatePipelineOutput =
      CreatePipelineOutput
        .builder
        .ifSome(pipelineId)(_.pipelineId(_))
        .build

    def deactivatePipelineInput(
      pipelineId: Option[String] = None,
      cancelActive: Option[Boolean] = None
    ): DeactivatePipelineInput =
      DeactivatePipelineInput
        .builder
        .ifSome(pipelineId)(_.pipelineId(_))
        .ifSome(cancelActive)(_.cancelActive(_))
        .build

    def deactivatePipelineOutput(

    ): DeactivatePipelineOutput =
      DeactivatePipelineOutput
        .builder

        .build

    def deletePipelineInput(
      pipelineId: Option[String] = None
    ): DeletePipelineInput =
      DeletePipelineInput
        .builder
        .ifSome(pipelineId)(_.pipelineId(_))
        .build

    def describeObjectsInput(
      pipelineId: Option[String] = None,
      objectIds: Option[List[id]] = None,
      evaluateExpressions: Option[Boolean] = None,
      marker: Option[String] = None
    ): DescribeObjectsInput =
      DescribeObjectsInput
        .builder
        .ifSome(pipelineId)(_.pipelineId(_))
        .ifSome(objectIds)(_.objectIds(_))
        .ifSome(evaluateExpressions)(_.evaluateExpressions(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeObjectsOutput(
      pipelineObjects: Option[List[PipelineObject]] = None,
      marker: Option[String] = None,
      hasMoreResults: Option[Boolean] = None
    ): DescribeObjectsOutput =
      DescribeObjectsOutput
        .builder
        .ifSome(pipelineObjects)(_.pipelineObjects(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(hasMoreResults)(_.hasMoreResults(_))
        .build

    def describePipelinesInput(
      pipelineIds: Option[List[id]] = None
    ): DescribePipelinesInput =
      DescribePipelinesInput
        .builder
        .ifSome(pipelineIds)(_.pipelineIds(_))
        .build

    def describePipelinesOutput(
      pipelineDescriptionList: Option[List[PipelineDescription]] = None
    ): DescribePipelinesOutput =
      DescribePipelinesOutput
        .builder
        .ifSome(pipelineDescriptionList)(_.pipelineDescriptionList(_))
        .build

    def evaluateExpressionInput(
      pipelineId: Option[String] = None,
      objectId: Option[String] = None,
      expression: Option[String] = None
    ): EvaluateExpressionInput =
      EvaluateExpressionInput
        .builder
        .ifSome(pipelineId)(_.pipelineId(_))
        .ifSome(objectId)(_.objectId(_))
        .ifSome(expression)(_.expression(_))
        .build

    def evaluateExpressionOutput(
      evaluatedExpression: Option[String] = None
    ): EvaluateExpressionOutput =
      EvaluateExpressionOutput
        .builder
        .ifSome(evaluatedExpression)(_.evaluatedExpression(_))
        .build

    def field(
      key: Option[String] = None,
      stringValue: Option[String] = None,
      refValue: Option[String] = None
    ): Field =
      Field
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(stringValue)(_.stringValue(_))
        .ifSome(refValue)(_.refValue(_))
        .build

    def getPipelineDefinitionInput(
      pipelineId: Option[String] = None,
      version: Option[String] = None
    ): GetPipelineDefinitionInput =
      GetPipelineDefinitionInput
        .builder
        .ifSome(pipelineId)(_.pipelineId(_))
        .ifSome(version)(_.version(_))
        .build

    def getPipelineDefinitionOutput(
      pipelineObjects: Option[List[PipelineObject]] = None,
      parameterObjects: Option[List[ParameterObject]] = None,
      parameterValues: Option[List[ParameterValue]] = None
    ): GetPipelineDefinitionOutput =
      GetPipelineDefinitionOutput
        .builder
        .ifSome(pipelineObjects)(_.pipelineObjects(_))
        .ifSome(parameterObjects)(_.parameterObjects(_))
        .ifSome(parameterValues)(_.parameterValues(_))
        .build

    def instanceIdentity(
      document: Option[String] = None,
      signature: Option[String] = None
    ): InstanceIdentity =
      InstanceIdentity
        .builder
        .ifSome(document)(_.document(_))
        .ifSome(signature)(_.signature(_))
        .build

    def internalServiceError(
      message: Option[String] = None
    ): InternalServiceError =
      InternalServiceError
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

    def listPipelinesInput(
      marker: Option[String] = None
    ): ListPipelinesInput =
      ListPipelinesInput
        .builder
        .ifSome(marker)(_.marker(_))
        .build

    def listPipelinesOutput(
      pipelineIdList: Option[List[PipelineIdName]] = None,
      marker: Option[String] = None,
      hasMoreResults: Option[Boolean] = None
    ): ListPipelinesOutput =
      ListPipelinesOutput
        .builder
        .ifSome(pipelineIdList)(_.pipelineIdList(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(hasMoreResults)(_.hasMoreResults(_))
        .build

    def operator(
      `type`: Option[String] = None,
      values: Option[List[string]] = None
    ): Operator =
      Operator
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(values)(_.values(_))
        .build

    def parameterAttribute(
      key: Option[String] = None,
      stringValue: Option[String] = None
    ): ParameterAttribute =
      ParameterAttribute
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(stringValue)(_.stringValue(_))
        .build

    def parameterObject(
      id: Option[String] = None,
      attributes: Option[List[ParameterAttribute]] = None
    ): ParameterObject =
      ParameterObject
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def parameterValue(
      id: Option[String] = None,
      stringValue: Option[String] = None
    ): ParameterValue =
      ParameterValue
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(stringValue)(_.stringValue(_))
        .build

    def pipelineDeletedException(
      message: Option[String] = None
    ): PipelineDeletedException =
      PipelineDeletedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def pipelineDescription(
      pipelineId: Option[String] = None,
      name: Option[String] = None,
      fields: Option[List[Field]] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): PipelineDescription =
      PipelineDescription
        .builder
        .ifSome(pipelineId)(_.pipelineId(_))
        .ifSome(name)(_.name(_))
        .ifSome(fields)(_.fields(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def pipelineIdName(
      id: Option[String] = None,
      name: Option[String] = None
    ): PipelineIdName =
      PipelineIdName
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .build

    def pipelineNotFoundException(
      message: Option[String] = None
    ): PipelineNotFoundException =
      PipelineNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def pipelineObject(
      id: Option[String] = None,
      name: Option[String] = None,
      fields: Option[List[Field]] = None
    ): PipelineObject =
      PipelineObject
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(fields)(_.fields(_))
        .build

    def pollForTaskInput(
      workerGroup: Option[String] = None,
      hostname: Option[String] = None,
      instanceIdentity: Option[InstanceIdentity] = None
    ): PollForTaskInput =
      PollForTaskInput
        .builder
        .ifSome(workerGroup)(_.workerGroup(_))
        .ifSome(hostname)(_.hostname(_))
        .ifSome(instanceIdentity)(_.instanceIdentity(_))
        .build

    def pollForTaskOutput(
      taskObject: Option[TaskObject] = None
    ): PollForTaskOutput =
      PollForTaskOutput
        .builder
        .ifSome(taskObject)(_.taskObject(_))
        .build

    def putPipelineDefinitionInput(
      pipelineId: Option[String] = None,
      pipelineObjects: Option[List[PipelineObject]] = None,
      parameterObjects: Option[List[ParameterObject]] = None,
      parameterValues: Option[List[ParameterValue]] = None
    ): PutPipelineDefinitionInput =
      PutPipelineDefinitionInput
        .builder
        .ifSome(pipelineId)(_.pipelineId(_))
        .ifSome(pipelineObjects)(_.pipelineObjects(_))
        .ifSome(parameterObjects)(_.parameterObjects(_))
        .ifSome(parameterValues)(_.parameterValues(_))
        .build

    def putPipelineDefinitionOutput(
      validationErrors: Option[List[ValidationError]] = None,
      validationWarnings: Option[List[ValidationWarning]] = None,
      errored: Option[Boolean] = None
    ): PutPipelineDefinitionOutput =
      PutPipelineDefinitionOutput
        .builder
        .ifSome(validationErrors)(_.validationErrors(_))
        .ifSome(validationWarnings)(_.validationWarnings(_))
        .ifSome(errored)(_.errored(_))
        .build

    def query(
      selectors: Option[List[Selector]] = None
    ): Query =
      Query
        .builder
        .ifSome(selectors)(_.selectors(_))
        .build

    def queryObjectsInput(
      pipelineId: Option[String] = None,
      query: Option[Query] = None,
      sphere: Option[String] = None,
      marker: Option[String] = None,
      limit: Option[Int] = None
    ): QueryObjectsInput =
      QueryObjectsInput
        .builder
        .ifSome(pipelineId)(_.pipelineId(_))
        .ifSome(query)(_.query(_))
        .ifSome(sphere)(_.sphere(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def queryObjectsOutput(
      ids: Option[List[id]] = None,
      marker: Option[String] = None,
      hasMoreResults: Option[Boolean] = None
    ): QueryObjectsOutput =
      QueryObjectsOutput
        .builder
        .ifSome(ids)(_.ids(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(hasMoreResults)(_.hasMoreResults(_))
        .build

    def removeTagsInput(
      pipelineId: Option[String] = None,
      tagKeys: Option[List[string]] = None
    ): RemoveTagsInput =
      RemoveTagsInput
        .builder
        .ifSome(pipelineId)(_.pipelineId(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def removeTagsOutput(

    ): RemoveTagsOutput =
      RemoveTagsOutput
        .builder

        .build

    def reportTaskProgressInput(
      taskId: Option[String] = None,
      fields: Option[List[Field]] = None
    ): ReportTaskProgressInput =
      ReportTaskProgressInput
        .builder
        .ifSome(taskId)(_.taskId(_))
        .ifSome(fields)(_.fields(_))
        .build

    def reportTaskProgressOutput(
      canceled: Option[Boolean] = None
    ): ReportTaskProgressOutput =
      ReportTaskProgressOutput
        .builder
        .ifSome(canceled)(_.canceled(_))
        .build

    def reportTaskRunnerHeartbeatInput(
      taskrunnerId: Option[String] = None,
      workerGroup: Option[String] = None,
      hostname: Option[String] = None
    ): ReportTaskRunnerHeartbeatInput =
      ReportTaskRunnerHeartbeatInput
        .builder
        .ifSome(taskrunnerId)(_.taskrunnerId(_))
        .ifSome(workerGroup)(_.workerGroup(_))
        .ifSome(hostname)(_.hostname(_))
        .build

    def reportTaskRunnerHeartbeatOutput(
      terminate: Option[Boolean] = None
    ): ReportTaskRunnerHeartbeatOutput =
      ReportTaskRunnerHeartbeatOutput
        .builder
        .ifSome(terminate)(_.terminate(_))
        .build

    def selector(
      fieldName: Option[String] = None,
      operator: Option[Operator] = None
    ): Selector =
      Selector
        .builder
        .ifSome(fieldName)(_.fieldName(_))
        .ifSome(operator)(_.operator(_))
        .build

    def setStatusInput(
      pipelineId: Option[String] = None,
      objectIds: Option[List[id]] = None,
      status: Option[String] = None
    ): SetStatusInput =
      SetStatusInput
        .builder
        .ifSome(pipelineId)(_.pipelineId(_))
        .ifSome(objectIds)(_.objectIds(_))
        .ifSome(status)(_.status(_))
        .build

    def setTaskStatusInput(
      taskId: Option[String] = None,
      taskStatus: Option[String] = None,
      errorId: Option[String] = None,
      errorMessage: Option[String] = None,
      errorStackTrace: Option[String] = None
    ): SetTaskStatusInput =
      SetTaskStatusInput
        .builder
        .ifSome(taskId)(_.taskId(_))
        .ifSome(taskStatus)(_.taskStatus(_))
        .ifSome(errorId)(_.errorId(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(errorStackTrace)(_.errorStackTrace(_))
        .build

    def setTaskStatusOutput(

    ): SetTaskStatusOutput =
      SetTaskStatusOutput
        .builder

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

    def taskNotFoundException(
      message: Option[String] = None
    ): TaskNotFoundException =
      TaskNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def taskObject(
      taskId: Option[String] = None,
      pipelineId: Option[String] = None,
      attemptId: Option[String] = None,
      objects: Option[PipelineObjectMap] = None
    ): TaskObject =
      TaskObject
        .builder
        .ifSome(taskId)(_.taskId(_))
        .ifSome(pipelineId)(_.pipelineId(_))
        .ifSome(attemptId)(_.attemptId(_))
        .ifSome(objects)(_.objects(_))
        .build

    def validatePipelineDefinitionInput(
      pipelineId: Option[String] = None,
      pipelineObjects: Option[List[PipelineObject]] = None,
      parameterObjects: Option[List[ParameterObject]] = None,
      parameterValues: Option[List[ParameterValue]] = None
    ): ValidatePipelineDefinitionInput =
      ValidatePipelineDefinitionInput
        .builder
        .ifSome(pipelineId)(_.pipelineId(_))
        .ifSome(pipelineObjects)(_.pipelineObjects(_))
        .ifSome(parameterObjects)(_.parameterObjects(_))
        .ifSome(parameterValues)(_.parameterValues(_))
        .build

    def validatePipelineDefinitionOutput(
      validationErrors: Option[List[ValidationError]] = None,
      validationWarnings: Option[List[ValidationWarning]] = None,
      errored: Option[Boolean] = None
    ): ValidatePipelineDefinitionOutput =
      ValidatePipelineDefinitionOutput
        .builder
        .ifSome(validationErrors)(_.validationErrors(_))
        .ifSome(validationWarnings)(_.validationWarnings(_))
        .ifSome(errored)(_.errored(_))
        .build

    def validationError(
      id: Option[String] = None,
      errors: Option[List[validationMessage]] = None
    ): ValidationError =
      ValidationError
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(errors)(_.errors(_))
        .build

    def validationWarning(
      id: Option[String] = None,
      warnings: Option[List[validationMessage]] = None
    ): ValidationWarning =
      ValidationWarning
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(warnings)(_.warnings(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
