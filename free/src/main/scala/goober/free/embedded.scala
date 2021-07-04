package goober.free

import scala.language.higherKinds

import cats.free.Free
import goober.free.athena.AthenaIO
import goober.free.codebuild.CodeBuildIO
import goober.free.ec2.Ec2IO
import goober.free.ecr.EcrIO
import goober.free.s3.S3IO
import software.amazon.awssdk.services.athena.AthenaClient
import software.amazon.awssdk.services.codebuild.CodeBuildClient
import software.amazon.awssdk.services.ec2.Ec2Client
import software.amazon.awssdk.services.ecr.EcrClient
import software.amazon.awssdk.services.s3.S3Client


// A pair (J, Free[F, A]) with constructors that tie down J and F.
sealed trait Embedded[A]

object Embedded {
  final case class Athena[A](client: AthenaClient, io: AthenaIO[A]) extends Embedded[A]
  final case class CodeBuild[A](client: CodeBuildClient, io: CodeBuildIO[A]) extends Embedded[A]
  final case class Ec2[A](client: Ec2Client, io: Ec2IO[A]) extends Embedded[A]
  final case class Ecr[A](client: EcrClient, io: EcrIO[A]) extends Embedded[A]
  final case class S3[A](client: S3Client, io: S3IO[A]) extends Embedded[A]
}

// Typeclass for embeddable pairs (J, F)
trait Embeddable[F[_], J] {
  def embed[A](j: J, fa: Free[F, A]): Embedded[A]
}
