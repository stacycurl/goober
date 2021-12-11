package goober.hi

import goober.free.polly.PollyIO
import software.amazon.awssdk.services.polly.model._


object polly {
  import goober.free.{polly ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def deleteLexiconInput(
      name: Option[String] = None
    ): DeleteLexiconInput =
      DeleteLexiconInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteLexiconOutput(

    ): DeleteLexiconOutput =
      DeleteLexiconOutput
        .builder

        .build

    def describeVoicesInput(
      engine: Option[String] = None,
      languageCode: Option[String] = None,
      includeAdditionalLanguageCodes: Option[Boolean] = None,
      nextToken: Option[String] = None
    ): DescribeVoicesInput =
      DescribeVoicesInput
        .builder
        .ifSome(engine)(_.engine(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(includeAdditionalLanguageCodes)(_.includeAdditionalLanguageCodes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeVoicesOutput(
      voices: Option[List[Voice]] = None,
      nextToken: Option[String] = None
    ): DescribeVoicesOutput =
      DescribeVoicesOutput
        .builder
        .ifSome(voices)(_.voices(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def engineNotSupportedException(
      message: Option[String] = None
    ): EngineNotSupportedException =
      EngineNotSupportedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def getLexiconInput(
      name: Option[String] = None
    ): GetLexiconInput =
      GetLexiconInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getLexiconOutput(
      lexicon: Option[Lexicon] = None,
      lexiconAttributes: Option[LexiconAttributes] = None
    ): GetLexiconOutput =
      GetLexiconOutput
        .builder
        .ifSome(lexicon)(_.lexicon(_))
        .ifSome(lexiconAttributes)(_.lexiconAttributes(_))
        .build

    def getSpeechSynthesisTaskInput(
      taskId: Option[String] = None
    ): GetSpeechSynthesisTaskInput =
      GetSpeechSynthesisTaskInput
        .builder
        .ifSome(taskId)(_.taskId(_))
        .build

    def getSpeechSynthesisTaskOutput(
      synthesisTask: Option[SynthesisTask] = None
    ): GetSpeechSynthesisTaskOutput =
      GetSpeechSynthesisTaskOutput
        .builder
        .ifSome(synthesisTask)(_.synthesisTask(_))
        .build

    def invalidLexiconException(
      message: Option[String] = None
    ): InvalidLexiconException =
      InvalidLexiconException
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

    def invalidS3BucketException(
      message: Option[String] = None
    ): InvalidS3BucketException =
      InvalidS3BucketException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidS3KeyException(
      message: Option[String] = None
    ): InvalidS3KeyException =
      InvalidS3KeyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidSampleRateException(
      message: Option[String] = None
    ): InvalidSampleRateException =
      InvalidSampleRateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidSnsTopicArnException(
      message: Option[String] = None
    ): InvalidSnsTopicArnException =
      InvalidSnsTopicArnException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidSsmlException(
      message: Option[String] = None
    ): InvalidSsmlException =
      InvalidSsmlException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidTaskIdException(
      message: Option[String] = None
    ): InvalidTaskIdException =
      InvalidTaskIdException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def languageNotSupportedException(
      message: Option[String] = None
    ): LanguageNotSupportedException =
      LanguageNotSupportedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def lexicon(
      content: Option[String] = None,
      name: Option[String] = None
    ): Lexicon =
      Lexicon
        .builder
        .ifSome(content)(_.content(_))
        .ifSome(name)(_.name(_))
        .build

    def lexiconAttributes(
      alphabet: Option[String] = None,
      languageCode: Option[String] = None,
      lastModified: Option[LastModified] = None,
      lexiconArn: Option[String] = None,
      lexemesCount: Option[Int] = None,
      size: Option[Int] = None
    ): LexiconAttributes =
      LexiconAttributes
        .builder
        .ifSome(alphabet)(_.alphabet(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(lexiconArn)(_.lexiconArn(_))
        .ifSome(lexemesCount)(_.lexemesCount(_))
        .ifSome(size)(_.size(_))
        .build

    def lexiconDescription(
      name: Option[String] = None,
      attributes: Option[LexiconAttributes] = None
    ): LexiconDescription =
      LexiconDescription
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def lexiconNotFoundException(
      message: Option[String] = None
    ): LexiconNotFoundException =
      LexiconNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def lexiconSizeExceededException(
      message: Option[String] = None
    ): LexiconSizeExceededException =
      LexiconSizeExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listLexiconsInput(
      nextToken: Option[String] = None
    ): ListLexiconsInput =
      ListLexiconsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLexiconsOutput(
      lexicons: Option[List[LexiconDescription]] = None,
      nextToken: Option[String] = None
    ): ListLexiconsOutput =
      ListLexiconsOutput
        .builder
        .ifSome(lexicons)(_.lexicons(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSpeechSynthesisTasksInput(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      status: Option[String] = None
    ): ListSpeechSynthesisTasksInput =
      ListSpeechSynthesisTasksInput
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(status)(_.status(_))
        .build

    def listSpeechSynthesisTasksOutput(
      nextToken: Option[String] = None,
      synthesisTasks: Option[List[SynthesisTask]] = None
    ): ListSpeechSynthesisTasksOutput =
      ListSpeechSynthesisTasksOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(synthesisTasks)(_.synthesisTasks(_))
        .build

    def marksNotSupportedForFormatException(
      message: Option[String] = None
    ): MarksNotSupportedForFormatException =
      MarksNotSupportedForFormatException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def maxLexemeLengthExceededException(
      message: Option[String] = None
    ): MaxLexemeLengthExceededException =
      MaxLexemeLengthExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def maxLexiconsNumberExceededException(
      message: Option[String] = None
    ): MaxLexiconsNumberExceededException =
      MaxLexiconsNumberExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def putLexiconInput(
      name: Option[String] = None,
      content: Option[String] = None
    ): PutLexiconInput =
      PutLexiconInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(content)(_.content(_))
        .build

    def putLexiconOutput(

    ): PutLexiconOutput =
      PutLexiconOutput
        .builder

        .build

    def serviceFailureException(
      message: Option[String] = None
    ): ServiceFailureException =
      ServiceFailureException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def ssmlMarksNotSupportedForTextTypeException(
      message: Option[String] = None
    ): SsmlMarksNotSupportedForTextTypeException =
      SsmlMarksNotSupportedForTextTypeException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def startSpeechSynthesisTaskInput(
      engine: Option[String] = None,
      languageCode: Option[String] = None,
      lexiconNames: Option[List[LexiconName]] = None,
      outputFormat: Option[String] = None,
      outputS3BucketName: Option[String] = None,
      outputS3KeyPrefix: Option[String] = None,
      sampleRate: Option[String] = None,
      snsTopicArn: Option[String] = None,
      speechMarkTypes: Option[List[SpeechMarkType]] = None,
      text: Option[String] = None,
      textType: Option[String] = None,
      voiceId: Option[String] = None
    ): StartSpeechSynthesisTaskInput =
      StartSpeechSynthesisTaskInput
        .builder
        .ifSome(engine)(_.engine(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(lexiconNames)(_.lexiconNames(_))
        .ifSome(outputFormat)(_.outputFormat(_))
        .ifSome(outputS3BucketName)(_.outputS3BucketName(_))
        .ifSome(outputS3KeyPrefix)(_.outputS3KeyPrefix(_))
        .ifSome(sampleRate)(_.sampleRate(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(speechMarkTypes)(_.speechMarkTypes(_))
        .ifSome(text)(_.text(_))
        .ifSome(textType)(_.textType(_))
        .ifSome(voiceId)(_.voiceId(_))
        .build

    def startSpeechSynthesisTaskOutput(
      synthesisTask: Option[SynthesisTask] = None
    ): StartSpeechSynthesisTaskOutput =
      StartSpeechSynthesisTaskOutput
        .builder
        .ifSome(synthesisTask)(_.synthesisTask(_))
        .build

    def synthesisTask(
      engine: Option[String] = None,
      taskId: Option[String] = None,
      taskStatus: Option[String] = None,
      taskStatusReason: Option[String] = None,
      outputUri: Option[String] = None,
      creationTime: Option[DateTime] = None,
      requestCharacters: Option[Int] = None,
      snsTopicArn: Option[String] = None,
      lexiconNames: Option[List[LexiconName]] = None,
      outputFormat: Option[String] = None,
      sampleRate: Option[String] = None,
      speechMarkTypes: Option[List[SpeechMarkType]] = None,
      textType: Option[String] = None,
      voiceId: Option[String] = None,
      languageCode: Option[String] = None
    ): SynthesisTask =
      SynthesisTask
        .builder
        .ifSome(engine)(_.engine(_))
        .ifSome(taskId)(_.taskId(_))
        .ifSome(taskStatus)(_.taskStatus(_))
        .ifSome(taskStatusReason)(_.taskStatusReason(_))
        .ifSome(outputUri)(_.outputUri(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(requestCharacters)(_.requestCharacters(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(lexiconNames)(_.lexiconNames(_))
        .ifSome(outputFormat)(_.outputFormat(_))
        .ifSome(sampleRate)(_.sampleRate(_))
        .ifSome(speechMarkTypes)(_.speechMarkTypes(_))
        .ifSome(textType)(_.textType(_))
        .ifSome(voiceId)(_.voiceId(_))
        .ifSome(languageCode)(_.languageCode(_))
        .build

    def synthesisTaskNotFoundException(
      message: Option[String] = None
    ): SynthesisTaskNotFoundException =
      SynthesisTaskNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def synthesizeSpeechInput(
      engine: Option[String] = None,
      languageCode: Option[String] = None,
      lexiconNames: Option[List[LexiconName]] = None,
      outputFormat: Option[String] = None,
      sampleRate: Option[String] = None,
      speechMarkTypes: Option[List[SpeechMarkType]] = None,
      text: Option[String] = None,
      textType: Option[String] = None,
      voiceId: Option[String] = None
    ): SynthesizeSpeechInput =
      SynthesizeSpeechInput
        .builder
        .ifSome(engine)(_.engine(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(lexiconNames)(_.lexiconNames(_))
        .ifSome(outputFormat)(_.outputFormat(_))
        .ifSome(sampleRate)(_.sampleRate(_))
        .ifSome(speechMarkTypes)(_.speechMarkTypes(_))
        .ifSome(text)(_.text(_))
        .ifSome(textType)(_.textType(_))
        .ifSome(voiceId)(_.voiceId(_))
        .build

    def synthesizeSpeechOutput(
      audioStream: Option[AudioStream] = None,
      contentType: Option[String] = None,
      requestCharacters: Option[Int] = None
    ): SynthesizeSpeechOutput =
      SynthesizeSpeechOutput
        .builder
        .ifSome(audioStream)(_.audioStream(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(requestCharacters)(_.requestCharacters(_))
        .build

    def textLengthExceededException(
      message: Option[String] = None
    ): TextLengthExceededException =
      TextLengthExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unsupportedPlsAlphabetException(
      message: Option[String] = None
    ): UnsupportedPlsAlphabetException =
      UnsupportedPlsAlphabetException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unsupportedPlsLanguageException(
      message: Option[String] = None
    ): UnsupportedPlsLanguageException =
      UnsupportedPlsLanguageException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def voice(
      gender: Option[String] = None,
      id: Option[String] = None,
      languageCode: Option[String] = None,
      languageName: Option[String] = None,
      name: Option[String] = None,
      additionalLanguageCodes: Option[List[LanguageCode]] = None,
      supportedEngines: Option[List[Engine]] = None
    ): Voice =
      Voice
        .builder
        .ifSome(gender)(_.gender(_))
        .ifSome(id)(_.id(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(languageName)(_.languageName(_))
        .ifSome(name)(_.name(_))
        .ifSome(additionalLanguageCodes)(_.additionalLanguageCodes(_))
        .ifSome(supportedEngines)(_.supportedEngines(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
