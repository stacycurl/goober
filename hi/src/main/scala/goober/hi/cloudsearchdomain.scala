package goober.hi

import goober.free.cloudsearchdomain.CloudSearchDomainIO
import software.amazon.awssdk.services.cloudsearchdomain.model._


object cloudsearchdomain {
  import goober.free.{cloudsearchdomain ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def bucket(
      value: Option[String] = None,
      count: Option[Long] = None
    ): Bucket =
      Bucket
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(count)(_.count(_))
        .build

    def bucketInfo(
      buckets: Option[List[Bucket]] = None
    ): BucketInfo =
      BucketInfo
        .builder
        .ifSome(buckets)(_.buckets(_))
        .build

    def documentServiceException(
      status: Option[String] = None,
      message: Option[String] = None
    ): DocumentServiceException =
      DocumentServiceException
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
        .build

    def documentServiceWarning(
      message: Option[String] = None
    ): DocumentServiceWarning =
      DocumentServiceWarning
        .builder
        .ifSome(message)(_.message(_))
        .build

    def fieldStats(
      min: Option[String] = None,
      max: Option[String] = None,
      count: Option[Long] = None,
      missing: Option[Long] = None,
      sum: Option[Double] = None,
      sumOfSquares: Option[Double] = None,
      mean: Option[String] = None,
      stddev: Option[Double] = None
    ): FieldStats =
      FieldStats
        .builder
        .ifSome(min)(_.min(_))
        .ifSome(max)(_.max(_))
        .ifSome(count)(_.count(_))
        .ifSome(missing)(_.missing(_))
        .ifSome(sum)(_.sum(_))
        .ifSome(sumOfSquares)(_.sumOfSquares(_))
        .ifSome(mean)(_.mean(_))
        .ifSome(stddev)(_.stddev(_))
        .build

    def hit(
      id: Option[String] = None,
      fields: Option[Fields] = None,
      exprs: Option[Exprs] = None,
      highlights: Option[Highlights] = None
    ): Hit =
      Hit
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(fields)(_.fields(_))
        .ifSome(exprs)(_.exprs(_))
        .ifSome(highlights)(_.highlights(_))
        .build

    def hits(
      found: Option[Long] = None,
      start: Option[Long] = None,
      cursor: Option[String] = None,
      hit: Option[List[Hit]] = None
    ): Hits =
      Hits
        .builder
        .ifSome(found)(_.found(_))
        .ifSome(start)(_.start(_))
        .ifSome(cursor)(_.cursor(_))
        .ifSome(hit)(_.hit(_))
        .build

    def searchException(
      message: Option[String] = None
    ): SearchException =
      SearchException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def searchRequest(
      cursor: Option[String] = None,
      expr: Option[String] = None,
      facet: Option[String] = None,
      filterQuery: Option[String] = None,
      highlight: Option[String] = None,
      partial: Option[Boolean] = None,
      query: Option[String] = None,
      queryOptions: Option[String] = None,
      queryParser: Option[String] = None,
      return: Option[String] = None,
      size: Option[Size] = None,
      sort: Option[String] = None,
      start: Option[Start] = None,
      stats: Option[String] = None
    ): SearchRequest =
      SearchRequest
        .builder
        .ifSome(cursor)(_.cursor(_))
        .ifSome(expr)(_.expr(_))
        .ifSome(facet)(_.facet(_))
        .ifSome(filterQuery)(_.filterQuery(_))
        .ifSome(highlight)(_.highlight(_))
        .ifSome(partial)(_.partial(_))
        .ifSome(query)(_.query(_))
        .ifSome(queryOptions)(_.queryOptions(_))
        .ifSome(queryParser)(_.queryParser(_))
        .ifSome(return)(_.return(_))
        .ifSome(size)(_.size(_))
        .ifSome(sort)(_.sort(_))
        .ifSome(start)(_.start(_))
        .ifSome(stats)(_.stats(_))
        .build

    def searchResponse(
      status: Option[SearchStatus] = None,
      hits: Option[Hits] = None,
      facets: Option[Facets] = None,
      stats: Option[Stats] = None
    ): SearchResponse =
      SearchResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(hits)(_.hits(_))
        .ifSome(facets)(_.facets(_))
        .ifSome(stats)(_.stats(_))
        .build

    def searchStatus(
      timems: Option[Long] = None,
      rid: Option[String] = None
    ): SearchStatus =
      SearchStatus
        .builder
        .ifSome(timems)(_.timems(_))
        .ifSome(rid)(_.rid(_))
        .build

    def suggestModel(
      query: Option[String] = None,
      found: Option[Long] = None,
      suggestions: Option[List[SuggestionMatch]] = None
    ): SuggestModel =
      SuggestModel
        .builder
        .ifSome(query)(_.query(_))
        .ifSome(found)(_.found(_))
        .ifSome(suggestions)(_.suggestions(_))
        .build

    def suggestRequest(
      query: Option[String] = None,
      suggester: Option[String] = None,
      size: Option[SuggestionsSize] = None
    ): SuggestRequest =
      SuggestRequest
        .builder
        .ifSome(query)(_.query(_))
        .ifSome(suggester)(_.suggester(_))
        .ifSome(size)(_.size(_))
        .build

    def suggestResponse(
      status: Option[SuggestStatus] = None,
      suggest: Option[SuggestModel] = None
    ): SuggestResponse =
      SuggestResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(suggest)(_.suggest(_))
        .build

    def suggestStatus(
      timems: Option[Long] = None,
      rid: Option[String] = None
    ): SuggestStatus =
      SuggestStatus
        .builder
        .ifSome(timems)(_.timems(_))
        .ifSome(rid)(_.rid(_))
        .build

    def suggestionMatch(
      suggestion: Option[String] = None,
      score: Option[Long] = None,
      id: Option[String] = None
    ): SuggestionMatch =
      SuggestionMatch
        .builder
        .ifSome(suggestion)(_.suggestion(_))
        .ifSome(score)(_.score(_))
        .ifSome(id)(_.id(_))
        .build

    def uploadDocumentsRequest(
      documents: Option[Blob] = None,
      contentType: Option[String] = None
    ): UploadDocumentsRequest =
      UploadDocumentsRequest
        .builder
        .ifSome(documents)(_.documents(_))
        .ifSome(contentType)(_.contentType(_))
        .build

    def uploadDocumentsResponse(
      status: Option[String] = None,
      adds: Option[Adds] = None,
      deletes: Option[Deletes] = None,
      warnings: Option[List[DocumentServiceWarning]] = None
    ): UploadDocumentsResponse =
      UploadDocumentsResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(adds)(_.adds(_))
        .ifSome(deletes)(_.deletes(_))
        .ifSome(warnings)(_.warnings(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
