package goober.free

import scala.language.higherKinds

import cats.free.Free
import goober.free.ec2.EC2IO
import goober.free.s3.S3IO
import software.amazon.awssdk.services.ec2.Ec2Client
import software.amazon.awssdk.services.s3.S3Client


// A pair (J, Free[F, A]) with constructors that tie down J and F.
sealed trait Embedded[A]

object Embedded {
  final case class S3[A](client: S3Client, io: S3IO[A]) extends Embedded[A]
  final case class EC2[A](client: Ec2Client, io: EC2IO[A]) extends Embedded[A]
}

// Typeclass for embeddable pairs (J, F)
trait Embeddable[F[_], J] {
  def embed[A](j: J, fa: Free[F, A]): Embedded[A]
}

