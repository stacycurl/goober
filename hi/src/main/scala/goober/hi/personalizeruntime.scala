package goober.hi

import goober.free.personalizeruntime.PersonalizeRuntimeIO
import software.amazon.awssdk.services.personalizeruntime.model._


object personalizeruntime {
  import goober.free.{personalizeruntime ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def getPersonalizedRankingRequest(
      campaignArn: Option[String] = None,
      inputList: Option[List[ItemID]] = None,
      userId: Option[String] = None,
      context: Option[Context] = None,
      filterArn: Option[String] = None,
      filterValues: Option[FilterValues] = None
    ): GetPersonalizedRankingRequest =
      GetPersonalizedRankingRequest
        .builder
        .ifSome(campaignArn)(_.campaignArn(_))
        .ifSome(inputList)(_.inputList(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(context)(_.context(_))
        .ifSome(filterArn)(_.filterArn(_))
        .ifSome(filterValues)(_.filterValues(_))
        .build

    def getPersonalizedRankingResponse(
      personalizedRanking: Option[List[PredictedItem]] = None,
      recommendationId: Option[String] = None
    ): GetPersonalizedRankingResponse =
      GetPersonalizedRankingResponse
        .builder
        .ifSome(personalizedRanking)(_.personalizedRanking(_))
        .ifSome(recommendationId)(_.recommendationId(_))
        .build

    def getRecommendationsRequest(
      campaignArn: Option[String] = None,
      itemId: Option[String] = None,
      userId: Option[String] = None,
      numResults: Option[Int] = None,
      context: Option[Context] = None,
      filterArn: Option[String] = None,
      filterValues: Option[FilterValues] = None
    ): GetRecommendationsRequest =
      GetRecommendationsRequest
        .builder
        .ifSome(campaignArn)(_.campaignArn(_))
        .ifSome(itemId)(_.itemId(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(numResults)(_.numResults(_))
        .ifSome(context)(_.context(_))
        .ifSome(filterArn)(_.filterArn(_))
        .ifSome(filterValues)(_.filterValues(_))
        .build

    def getRecommendationsResponse(
      itemList: Option[List[PredictedItem]] = None,
      recommendationId: Option[String] = None
    ): GetRecommendationsResponse =
      GetRecommendationsResponse
        .builder
        .ifSome(itemList)(_.itemList(_))
        .ifSome(recommendationId)(_.recommendationId(_))
        .build

    def invalidInputException(
      message: Option[String] = None
    ): InvalidInputException =
      InvalidInputException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def predictedItem(
      itemId: Option[String] = None,
      score: Option[Score] = None
    ): PredictedItem =
      PredictedItem
        .builder
        .ifSome(itemId)(_.itemId(_))
        .ifSome(score)(_.score(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
