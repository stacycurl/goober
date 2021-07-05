package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.comprehendmedical.ComprehendMedicalClient
import software.amazon.awssdk.services.comprehendmedical.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object comprehendmedical { module =>

  // Free monad over ComprehendMedicalOp
  type ComprehendMedicalIO[A] = FF[ComprehendMedicalOp, A]

  sealed trait ComprehendMedicalOp[A] {
    def visit[F[_]](visitor: ComprehendMedicalOp.Visitor[F]): F[A]
  }

  object ComprehendMedicalOp {
    // Given a ComprehendMedicalClient we can embed a ComprehendMedicalIO program in any algebra that understands embedding.
    implicit val ComprehendMedicalOpEmbeddable: Embeddable[ComprehendMedicalOp, ComprehendMedicalClient] = new Embeddable[ComprehendMedicalOp, ComprehendMedicalClient] {
      def embed[A](client: ComprehendMedicalClient, io: ComprehendMedicalIO[A]): Embedded[A] = Embedded.ComprehendMedical(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ComprehendMedicalOp.Visitor[Kleisli[M, ComprehendMedicalClient, *]] {
        def describeEntitiesDetectionV2Job(
          request: DescribeEntitiesDetectionV2JobRequest
        ): Kleisli[M, ComprehendMedicalClient, DescribeEntitiesDetectionV2JobResponse] =
          primitive(_.describeEntitiesDetectionV2Job(request))

        def describeICD10CMInferenceJob(
          request: DescribeIcd10CmInferenceJobRequest
        ): Kleisli[M, ComprehendMedicalClient, DescribeIcd10CmInferenceJobResponse] =
          primitive(_.describeICD10CMInferenceJob(request))

        def describePHIDetectionJob(
          request: DescribePhiDetectionJobRequest
        ): Kleisli[M, ComprehendMedicalClient, DescribePhiDetectionJobResponse] =
          primitive(_.describePHIDetectionJob(request))

        def describeRxNormInferenceJob(
          request: DescribeRxNormInferenceJobRequest
        ): Kleisli[M, ComprehendMedicalClient, DescribeRxNormInferenceJobResponse] =
          primitive(_.describeRxNormInferenceJob(request))

        def detectEntities(
          request: DetectEntitiesRequest
        ): Kleisli[M, ComprehendMedicalClient, DetectEntitiesResponse] =
          primitive(_.detectEntities(request))

        def detectEntitiesV2(
          request: DetectEntitiesV2Request
        ): Kleisli[M, ComprehendMedicalClient, DetectEntitiesV2Response] =
          primitive(_.detectEntitiesV2(request))

        def detectPHI(
          request: DetectPhiRequest
        ): Kleisli[M, ComprehendMedicalClient, DetectPhiResponse] =
          primitive(_.detectPHI(request))

        def inferICD10CM(
          request: InferIcd10CmRequest
        ): Kleisli[M, ComprehendMedicalClient, InferIcd10CmResponse] =
          primitive(_.inferICD10CM(request))

        def inferRxNorm(
          request: InferRxNormRequest
        ): Kleisli[M, ComprehendMedicalClient, InferRxNormResponse] =
          primitive(_.inferRxNorm(request))

        def listEntitiesDetectionV2Jobs(
          request: ListEntitiesDetectionV2JobsRequest
        ): Kleisli[M, ComprehendMedicalClient, ListEntitiesDetectionV2JobsResponse] =
          primitive(_.listEntitiesDetectionV2Jobs(request))

        def listICD10CMInferenceJobs(
          request: ListIcd10CmInferenceJobsRequest
        ): Kleisli[M, ComprehendMedicalClient, ListIcd10CmInferenceJobsResponse] =
          primitive(_.listICD10CMInferenceJobs(request))

        def listPHIDetectionJobs(
          request: ListPhiDetectionJobsRequest
        ): Kleisli[M, ComprehendMedicalClient, ListPhiDetectionJobsResponse] =
          primitive(_.listPHIDetectionJobs(request))

        def listRxNormInferenceJobs(
          request: ListRxNormInferenceJobsRequest
        ): Kleisli[M, ComprehendMedicalClient, ListRxNormInferenceJobsResponse] =
          primitive(_.listRxNormInferenceJobs(request))

        def startEntitiesDetectionV2Job(
          request: StartEntitiesDetectionV2JobRequest
        ): Kleisli[M, ComprehendMedicalClient, StartEntitiesDetectionV2JobResponse] =
          primitive(_.startEntitiesDetectionV2Job(request))

        def startICD10CMInferenceJob(
          request: StartIcd10CmInferenceJobRequest
        ): Kleisli[M, ComprehendMedicalClient, StartIcd10CmInferenceJobResponse] =
          primitive(_.startICD10CMInferenceJob(request))

        def startPHIDetectionJob(
          request: StartPhiDetectionJobRequest
        ): Kleisli[M, ComprehendMedicalClient, StartPhiDetectionJobResponse] =
          primitive(_.startPHIDetectionJob(request))

        def startRxNormInferenceJob(
          request: StartRxNormInferenceJobRequest
        ): Kleisli[M, ComprehendMedicalClient, StartRxNormInferenceJobResponse] =
          primitive(_.startRxNormInferenceJob(request))

        def stopEntitiesDetectionV2Job(
          request: StopEntitiesDetectionV2JobRequest
        ): Kleisli[M, ComprehendMedicalClient, StopEntitiesDetectionV2JobResponse] =
          primitive(_.stopEntitiesDetectionV2Job(request))

        def stopICD10CMInferenceJob(
          request: StopIcd10CmInferenceJobRequest
        ): Kleisli[M, ComprehendMedicalClient, StopIcd10CmInferenceJobResponse] =
          primitive(_.stopICD10CMInferenceJob(request))

        def stopPHIDetectionJob(
          request: StopPhiDetectionJobRequest
        ): Kleisli[M, ComprehendMedicalClient, StopPhiDetectionJobResponse] =
          primitive(_.stopPHIDetectionJob(request))

        def stopRxNormInferenceJob(
          request: StopRxNormInferenceJobRequest
        ): Kleisli[M, ComprehendMedicalClient, StopRxNormInferenceJobResponse] =
          primitive(_.stopRxNormInferenceJob(request))

        def primitive[A](
          f: ComprehendMedicalClient => A
        ): Kleisli[M, ComprehendMedicalClient, A]
      }
    }

    trait Visitor[F[_]] extends (ComprehendMedicalOp ~> F) {
      final def apply[A](op: ComprehendMedicalOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def describeEntitiesDetectionV2Job(
        request: DescribeEntitiesDetectionV2JobRequest
      ): F[DescribeEntitiesDetectionV2JobResponse]

      def describeICD10CMInferenceJob(
        request: DescribeIcd10CmInferenceJobRequest
      ): F[DescribeIcd10CmInferenceJobResponse]

      def describePHIDetectionJob(
        request: DescribePhiDetectionJobRequest
      ): F[DescribePhiDetectionJobResponse]

      def describeRxNormInferenceJob(
        request: DescribeRxNormInferenceJobRequest
      ): F[DescribeRxNormInferenceJobResponse]

      def detectEntities(
        request: DetectEntitiesRequest
      ): F[DetectEntitiesResponse]

      def detectEntitiesV2(
        request: DetectEntitiesV2Request
      ): F[DetectEntitiesV2Response]

      def detectPHI(
        request: DetectPhiRequest
      ): F[DetectPhiResponse]

      def inferICD10CM(
        request: InferIcd10CmRequest
      ): F[InferIcd10CmResponse]

      def inferRxNorm(
        request: InferRxNormRequest
      ): F[InferRxNormResponse]

      def listEntitiesDetectionV2Jobs(
        request: ListEntitiesDetectionV2JobsRequest
      ): F[ListEntitiesDetectionV2JobsResponse]

      def listICD10CMInferenceJobs(
        request: ListIcd10CmInferenceJobsRequest
      ): F[ListIcd10CmInferenceJobsResponse]

      def listPHIDetectionJobs(
        request: ListPhiDetectionJobsRequest
      ): F[ListPhiDetectionJobsResponse]

      def listRxNormInferenceJobs(
        request: ListRxNormInferenceJobsRequest
      ): F[ListRxNormInferenceJobsResponse]

      def startEntitiesDetectionV2Job(
        request: StartEntitiesDetectionV2JobRequest
      ): F[StartEntitiesDetectionV2JobResponse]

      def startICD10CMInferenceJob(
        request: StartIcd10CmInferenceJobRequest
      ): F[StartIcd10CmInferenceJobResponse]

      def startPHIDetectionJob(
        request: StartPhiDetectionJobRequest
      ): F[StartPhiDetectionJobResponse]

      def startRxNormInferenceJob(
        request: StartRxNormInferenceJobRequest
      ): F[StartRxNormInferenceJobResponse]

      def stopEntitiesDetectionV2Job(
        request: StopEntitiesDetectionV2JobRequest
      ): F[StopEntitiesDetectionV2JobResponse]

      def stopICD10CMInferenceJob(
        request: StopIcd10CmInferenceJobRequest
      ): F[StopIcd10CmInferenceJobResponse]

      def stopPHIDetectionJob(
        request: StopPhiDetectionJobRequest
      ): F[StopPhiDetectionJobResponse]

      def stopRxNormInferenceJob(
        request: StopRxNormInferenceJobRequest
      ): F[StopRxNormInferenceJobResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ComprehendMedicalOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DescribeEntitiesDetectionV2JobOp(
      request: DescribeEntitiesDetectionV2JobRequest
    ) extends ComprehendMedicalOp[DescribeEntitiesDetectionV2JobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEntitiesDetectionV2JobResponse] =
        visitor.describeEntitiesDetectionV2Job(request)
    }

    final case class DescribeICD10CMInferenceJobOp(
      request: DescribeIcd10CmInferenceJobRequest
    ) extends ComprehendMedicalOp[DescribeIcd10CmInferenceJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeIcd10CmInferenceJobResponse] =
        visitor.describeICD10CMInferenceJob(request)
    }

    final case class DescribePHIDetectionJobOp(
      request: DescribePhiDetectionJobRequest
    ) extends ComprehendMedicalOp[DescribePhiDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePhiDetectionJobResponse] =
        visitor.describePHIDetectionJob(request)
    }

    final case class DescribeRxNormInferenceJobOp(
      request: DescribeRxNormInferenceJobRequest
    ) extends ComprehendMedicalOp[DescribeRxNormInferenceJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRxNormInferenceJobResponse] =
        visitor.describeRxNormInferenceJob(request)
    }

    final case class DetectEntitiesOp(
      request: DetectEntitiesRequest
    ) extends ComprehendMedicalOp[DetectEntitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectEntitiesResponse] =
        visitor.detectEntities(request)
    }

    final case class DetectEntitiesV2Op(
      request: DetectEntitiesV2Request
    ) extends ComprehendMedicalOp[DetectEntitiesV2Response] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectEntitiesV2Response] =
        visitor.detectEntitiesV2(request)
    }

    final case class DetectPHIOp(
      request: DetectPhiRequest
    ) extends ComprehendMedicalOp[DetectPhiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectPhiResponse] =
        visitor.detectPHI(request)
    }

    final case class InferICD10CMOp(
      request: InferIcd10CmRequest
    ) extends ComprehendMedicalOp[InferIcd10CmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InferIcd10CmResponse] =
        visitor.inferICD10CM(request)
    }

    final case class InferRxNormOp(
      request: InferRxNormRequest
    ) extends ComprehendMedicalOp[InferRxNormResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InferRxNormResponse] =
        visitor.inferRxNorm(request)
    }

    final case class ListEntitiesDetectionV2JobsOp(
      request: ListEntitiesDetectionV2JobsRequest
    ) extends ComprehendMedicalOp[ListEntitiesDetectionV2JobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEntitiesDetectionV2JobsResponse] =
        visitor.listEntitiesDetectionV2Jobs(request)
    }

    final case class ListICD10CMInferenceJobsOp(
      request: ListIcd10CmInferenceJobsRequest
    ) extends ComprehendMedicalOp[ListIcd10CmInferenceJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIcd10CmInferenceJobsResponse] =
        visitor.listICD10CMInferenceJobs(request)
    }

    final case class ListPHIDetectionJobsOp(
      request: ListPhiDetectionJobsRequest
    ) extends ComprehendMedicalOp[ListPhiDetectionJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPhiDetectionJobsResponse] =
        visitor.listPHIDetectionJobs(request)
    }

    final case class ListRxNormInferenceJobsOp(
      request: ListRxNormInferenceJobsRequest
    ) extends ComprehendMedicalOp[ListRxNormInferenceJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRxNormInferenceJobsResponse] =
        visitor.listRxNormInferenceJobs(request)
    }

    final case class StartEntitiesDetectionV2JobOp(
      request: StartEntitiesDetectionV2JobRequest
    ) extends ComprehendMedicalOp[StartEntitiesDetectionV2JobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartEntitiesDetectionV2JobResponse] =
        visitor.startEntitiesDetectionV2Job(request)
    }

    final case class StartICD10CMInferenceJobOp(
      request: StartIcd10CmInferenceJobRequest
    ) extends ComprehendMedicalOp[StartIcd10CmInferenceJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartIcd10CmInferenceJobResponse] =
        visitor.startICD10CMInferenceJob(request)
    }

    final case class StartPHIDetectionJobOp(
      request: StartPhiDetectionJobRequest
    ) extends ComprehendMedicalOp[StartPhiDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartPhiDetectionJobResponse] =
        visitor.startPHIDetectionJob(request)
    }

    final case class StartRxNormInferenceJobOp(
      request: StartRxNormInferenceJobRequest
    ) extends ComprehendMedicalOp[StartRxNormInferenceJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartRxNormInferenceJobResponse] =
        visitor.startRxNormInferenceJob(request)
    }

    final case class StopEntitiesDetectionV2JobOp(
      request: StopEntitiesDetectionV2JobRequest
    ) extends ComprehendMedicalOp[StopEntitiesDetectionV2JobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopEntitiesDetectionV2JobResponse] =
        visitor.stopEntitiesDetectionV2Job(request)
    }

    final case class StopICD10CMInferenceJobOp(
      request: StopIcd10CmInferenceJobRequest
    ) extends ComprehendMedicalOp[StopIcd10CmInferenceJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopIcd10CmInferenceJobResponse] =
        visitor.stopICD10CMInferenceJob(request)
    }

    final case class StopPHIDetectionJobOp(
      request: StopPhiDetectionJobRequest
    ) extends ComprehendMedicalOp[StopPhiDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopPhiDetectionJobResponse] =
        visitor.stopPHIDetectionJob(request)
    }

    final case class StopRxNormInferenceJobOp(
      request: StopRxNormInferenceJobRequest
    ) extends ComprehendMedicalOp[StopRxNormInferenceJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopRxNormInferenceJobResponse] =
        visitor.stopRxNormInferenceJob(request)
    }
  }

  import ComprehendMedicalOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ComprehendMedicalOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def describeEntitiesDetectionV2Job(
    request: DescribeEntitiesDetectionV2JobRequest
  ): ComprehendMedicalIO[DescribeEntitiesDetectionV2JobResponse] =
    FF.liftF(DescribeEntitiesDetectionV2JobOp(request))

  def describeICD10CMInferenceJob(
    request: DescribeIcd10CmInferenceJobRequest
  ): ComprehendMedicalIO[DescribeIcd10CmInferenceJobResponse] =
    FF.liftF(DescribeICD10CMInferenceJobOp(request))

  def describePHIDetectionJob(
    request: DescribePhiDetectionJobRequest
  ): ComprehendMedicalIO[DescribePhiDetectionJobResponse] =
    FF.liftF(DescribePHIDetectionJobOp(request))

  def describeRxNormInferenceJob(
    request: DescribeRxNormInferenceJobRequest
  ): ComprehendMedicalIO[DescribeRxNormInferenceJobResponse] =
    FF.liftF(DescribeRxNormInferenceJobOp(request))

  def detectEntities(
    request: DetectEntitiesRequest
  ): ComprehendMedicalIO[DetectEntitiesResponse] =
    FF.liftF(DetectEntitiesOp(request))

  def detectEntitiesV2(
    request: DetectEntitiesV2Request
  ): ComprehendMedicalIO[DetectEntitiesV2Response] =
    FF.liftF(DetectEntitiesV2Op(request))

  def detectPHI(
    request: DetectPhiRequest
  ): ComprehendMedicalIO[DetectPhiResponse] =
    FF.liftF(DetectPHIOp(request))

  def inferICD10CM(
    request: InferIcd10CmRequest
  ): ComprehendMedicalIO[InferIcd10CmResponse] =
    FF.liftF(InferICD10CMOp(request))

  def inferRxNorm(
    request: InferRxNormRequest
  ): ComprehendMedicalIO[InferRxNormResponse] =
    FF.liftF(InferRxNormOp(request))

  def listEntitiesDetectionV2Jobs(
    request: ListEntitiesDetectionV2JobsRequest
  ): ComprehendMedicalIO[ListEntitiesDetectionV2JobsResponse] =
    FF.liftF(ListEntitiesDetectionV2JobsOp(request))

  def listICD10CMInferenceJobs(
    request: ListIcd10CmInferenceJobsRequest
  ): ComprehendMedicalIO[ListIcd10CmInferenceJobsResponse] =
    FF.liftF(ListICD10CMInferenceJobsOp(request))

  def listPHIDetectionJobs(
    request: ListPhiDetectionJobsRequest
  ): ComprehendMedicalIO[ListPhiDetectionJobsResponse] =
    FF.liftF(ListPHIDetectionJobsOp(request))

  def listRxNormInferenceJobs(
    request: ListRxNormInferenceJobsRequest
  ): ComprehendMedicalIO[ListRxNormInferenceJobsResponse] =
    FF.liftF(ListRxNormInferenceJobsOp(request))

  def startEntitiesDetectionV2Job(
    request: StartEntitiesDetectionV2JobRequest
  ): ComprehendMedicalIO[StartEntitiesDetectionV2JobResponse] =
    FF.liftF(StartEntitiesDetectionV2JobOp(request))

  def startICD10CMInferenceJob(
    request: StartIcd10CmInferenceJobRequest
  ): ComprehendMedicalIO[StartIcd10CmInferenceJobResponse] =
    FF.liftF(StartICD10CMInferenceJobOp(request))

  def startPHIDetectionJob(
    request: StartPhiDetectionJobRequest
  ): ComprehendMedicalIO[StartPhiDetectionJobResponse] =
    FF.liftF(StartPHIDetectionJobOp(request))

  def startRxNormInferenceJob(
    request: StartRxNormInferenceJobRequest
  ): ComprehendMedicalIO[StartRxNormInferenceJobResponse] =
    FF.liftF(StartRxNormInferenceJobOp(request))

  def stopEntitiesDetectionV2Job(
    request: StopEntitiesDetectionV2JobRequest
  ): ComprehendMedicalIO[StopEntitiesDetectionV2JobResponse] =
    FF.liftF(StopEntitiesDetectionV2JobOp(request))

  def stopICD10CMInferenceJob(
    request: StopIcd10CmInferenceJobRequest
  ): ComprehendMedicalIO[StopIcd10CmInferenceJobResponse] =
    FF.liftF(StopICD10CMInferenceJobOp(request))

  def stopPHIDetectionJob(
    request: StopPhiDetectionJobRequest
  ): ComprehendMedicalIO[StopPhiDetectionJobResponse] =
    FF.liftF(StopPHIDetectionJobOp(request))

  def stopRxNormInferenceJob(
    request: StopRxNormInferenceJobRequest
  ): ComprehendMedicalIO[StopRxNormInferenceJobResponse] =
    FF.liftF(StopRxNormInferenceJobOp(request))
}
