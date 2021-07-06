package goober.hi

import goober.free.qldb.QldbIO
import software.amazon.awssdk.services.qldb.model._


object qldb {
  import goober.free.{qldb ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // CancelJournalKinesisStreamRequest
    // CreateLedgerRequest
    // DeleteLedgerRequest
    // DescribeJournalKinesisStreamRequest
    // DescribeJournalS3ExportRequest
    // DescribeLedgerRequest
    // ExportJournalToS3Request
    // GetBlockRequest
    // GetDigestRequest
    // GetRevisionRequest
    // ListJournalKinesisStreamsForLedgerRequest
    // ListJournalS3ExportsForLedgerRequest
    // ListJournalS3ExportsRequest
    // ListLedgersRequest
    // ListTagsForResourceRequest
    // StreamJournalToKinesisRequest
    // TagResourceRequest
    // UntagResourceRequest
    // UpdateLedgerPermissionsModeRequest
    // UpdateLedgerRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
