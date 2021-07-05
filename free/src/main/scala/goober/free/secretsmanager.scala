package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient
import software.amazon.awssdk.services.secretsmanager.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object secretsmanager { module =>

  // Free monad over SecretsManagerOp
  type SecretsManagerIO[A] = FF[SecretsManagerOp, A]

  sealed trait SecretsManagerOp[A] {
    def visit[F[_]](visitor: SecretsManagerOp.Visitor[F]): F[A]
  }

  object SecretsManagerOp {
    // Given a SecretsManagerClient we can embed a SecretsManagerIO program in any algebra that understands embedding.
    implicit val SecretsManagerOpEmbeddable: Embeddable[SecretsManagerOp, SecretsManagerClient] = new Embeddable[SecretsManagerOp, SecretsManagerClient] {
      def embed[A](client: SecretsManagerClient, io: SecretsManagerIO[A]): Embedded[A] = Embedded.SecretsManager(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SecretsManagerOp.Visitor[Kleisli[M, SecretsManagerClient, *]] {
        def cancelRotateSecret(
          request: CancelRotateSecretRequest
        ): Kleisli[M, SecretsManagerClient, CancelRotateSecretResponse] =
          primitive(_.cancelRotateSecret(request))

        def createSecret(
          request: CreateSecretRequest
        ): Kleisli[M, SecretsManagerClient, CreateSecretResponse] =
          primitive(_.createSecret(request))

        def deleteResourcePolicy(
          request: DeleteResourcePolicyRequest
        ): Kleisli[M, SecretsManagerClient, DeleteResourcePolicyResponse] =
          primitive(_.deleteResourcePolicy(request))

        def deleteSecret(
          request: DeleteSecretRequest
        ): Kleisli[M, SecretsManagerClient, DeleteSecretResponse] =
          primitive(_.deleteSecret(request))

        def describeSecret(
          request: DescribeSecretRequest
        ): Kleisli[M, SecretsManagerClient, DescribeSecretResponse] =
          primitive(_.describeSecret(request))

        def getRandomPassword(
          request: GetRandomPasswordRequest
        ): Kleisli[M, SecretsManagerClient, GetRandomPasswordResponse] =
          primitive(_.getRandomPassword(request))

        def getResourcePolicy(
          request: GetResourcePolicyRequest
        ): Kleisli[M, SecretsManagerClient, GetResourcePolicyResponse] =
          primitive(_.getResourcePolicy(request))

        def getSecretValue(
          request: GetSecretValueRequest
        ): Kleisli[M, SecretsManagerClient, GetSecretValueResponse] =
          primitive(_.getSecretValue(request))

        def listSecretVersionIds(
          request: ListSecretVersionIdsRequest
        ): Kleisli[M, SecretsManagerClient, ListSecretVersionIdsResponse] =
          primitive(_.listSecretVersionIds(request))

        def listSecrets(
          request: ListSecretsRequest
        ): Kleisli[M, SecretsManagerClient, ListSecretsResponse] =
          primitive(_.listSecrets(request))

        def putResourcePolicy(
          request: PutResourcePolicyRequest
        ): Kleisli[M, SecretsManagerClient, PutResourcePolicyResponse] =
          primitive(_.putResourcePolicy(request))

        def putSecretValue(
          request: PutSecretValueRequest
        ): Kleisli[M, SecretsManagerClient, PutSecretValueResponse] =
          primitive(_.putSecretValue(request))

        def removeRegionsFromReplication(
          request: RemoveRegionsFromReplicationRequest
        ): Kleisli[M, SecretsManagerClient, RemoveRegionsFromReplicationResponse] =
          primitive(_.removeRegionsFromReplication(request))

        def replicateSecretToRegions(
          request: ReplicateSecretToRegionsRequest
        ): Kleisli[M, SecretsManagerClient, ReplicateSecretToRegionsResponse] =
          primitive(_.replicateSecretToRegions(request))

        def restoreSecret(
          request: RestoreSecretRequest
        ): Kleisli[M, SecretsManagerClient, RestoreSecretResponse] =
          primitive(_.restoreSecret(request))

        def rotateSecret(
          request: RotateSecretRequest
        ): Kleisli[M, SecretsManagerClient, RotateSecretResponse] =
          primitive(_.rotateSecret(request))

        def stopReplicationToReplica(
          request: StopReplicationToReplicaRequest
        ): Kleisli[M, SecretsManagerClient, StopReplicationToReplicaResponse] =
          primitive(_.stopReplicationToReplica(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, SecretsManagerClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, SecretsManagerClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateSecret(
          request: UpdateSecretRequest
        ): Kleisli[M, SecretsManagerClient, UpdateSecretResponse] =
          primitive(_.updateSecret(request))

        def updateSecretVersionStage(
          request: UpdateSecretVersionStageRequest
        ): Kleisli[M, SecretsManagerClient, UpdateSecretVersionStageResponse] =
          primitive(_.updateSecretVersionStage(request))

        def validateResourcePolicy(
          request: ValidateResourcePolicyRequest
        ): Kleisli[M, SecretsManagerClient, ValidateResourcePolicyResponse] =
          primitive(_.validateResourcePolicy(request))

        def primitive[A](
          f: SecretsManagerClient => A
        ): Kleisli[M, SecretsManagerClient, A]
      }
    }

    trait Visitor[F[_]] extends (SecretsManagerOp ~> F) {
      final def apply[A](op: SecretsManagerOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def cancelRotateSecret(
        request: CancelRotateSecretRequest
      ): F[CancelRotateSecretResponse]

      def createSecret(
        request: CreateSecretRequest
      ): F[CreateSecretResponse]

      def deleteResourcePolicy(
        request: DeleteResourcePolicyRequest
      ): F[DeleteResourcePolicyResponse]

      def deleteSecret(
        request: DeleteSecretRequest
      ): F[DeleteSecretResponse]

      def describeSecret(
        request: DescribeSecretRequest
      ): F[DescribeSecretResponse]

      def getRandomPassword(
        request: GetRandomPasswordRequest
      ): F[GetRandomPasswordResponse]

      def getResourcePolicy(
        request: GetResourcePolicyRequest
      ): F[GetResourcePolicyResponse]

      def getSecretValue(
        request: GetSecretValueRequest
      ): F[GetSecretValueResponse]

      def listSecretVersionIds(
        request: ListSecretVersionIdsRequest
      ): F[ListSecretVersionIdsResponse]

      def listSecrets(
        request: ListSecretsRequest
      ): F[ListSecretsResponse]

      def putResourcePolicy(
        request: PutResourcePolicyRequest
      ): F[PutResourcePolicyResponse]

      def putSecretValue(
        request: PutSecretValueRequest
      ): F[PutSecretValueResponse]

      def removeRegionsFromReplication(
        request: RemoveRegionsFromReplicationRequest
      ): F[RemoveRegionsFromReplicationResponse]

      def replicateSecretToRegions(
        request: ReplicateSecretToRegionsRequest
      ): F[ReplicateSecretToRegionsResponse]

      def restoreSecret(
        request: RestoreSecretRequest
      ): F[RestoreSecretResponse]

      def rotateSecret(
        request: RotateSecretRequest
      ): F[RotateSecretResponse]

      def stopReplicationToReplica(
        request: StopReplicationToReplicaRequest
      ): F[StopReplicationToReplicaResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateSecret(
        request: UpdateSecretRequest
      ): F[UpdateSecretResponse]

      def updateSecretVersionStage(
        request: UpdateSecretVersionStageRequest
      ): F[UpdateSecretVersionStageResponse]

      def validateResourcePolicy(
        request: ValidateResourcePolicyRequest
      ): F[ValidateResourcePolicyResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SecretsManagerOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CancelRotateSecretOp(
      request: CancelRotateSecretRequest
    ) extends SecretsManagerOp[CancelRotateSecretResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelRotateSecretResponse] =
        visitor.cancelRotateSecret(request)
    }

    final case class CreateSecretOp(
      request: CreateSecretRequest
    ) extends SecretsManagerOp[CreateSecretResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSecretResponse] =
        visitor.createSecret(request)
    }

    final case class DeleteResourcePolicyOp(
      request: DeleteResourcePolicyRequest
    ) extends SecretsManagerOp[DeleteResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResourcePolicyResponse] =
        visitor.deleteResourcePolicy(request)
    }

    final case class DeleteSecretOp(
      request: DeleteSecretRequest
    ) extends SecretsManagerOp[DeleteSecretResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSecretResponse] =
        visitor.deleteSecret(request)
    }

    final case class DescribeSecretOp(
      request: DescribeSecretRequest
    ) extends SecretsManagerOp[DescribeSecretResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSecretResponse] =
        visitor.describeSecret(request)
    }

    final case class GetRandomPasswordOp(
      request: GetRandomPasswordRequest
    ) extends SecretsManagerOp[GetRandomPasswordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRandomPasswordResponse] =
        visitor.getRandomPassword(request)
    }

    final case class GetResourcePolicyOp(
      request: GetResourcePolicyRequest
    ) extends SecretsManagerOp[GetResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourcePolicyResponse] =
        visitor.getResourcePolicy(request)
    }

    final case class GetSecretValueOp(
      request: GetSecretValueRequest
    ) extends SecretsManagerOp[GetSecretValueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSecretValueResponse] =
        visitor.getSecretValue(request)
    }

    final case class ListSecretVersionIdsOp(
      request: ListSecretVersionIdsRequest
    ) extends SecretsManagerOp[ListSecretVersionIdsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSecretVersionIdsResponse] =
        visitor.listSecretVersionIds(request)
    }

    final case class ListSecretsOp(
      request: ListSecretsRequest
    ) extends SecretsManagerOp[ListSecretsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSecretsResponse] =
        visitor.listSecrets(request)
    }

    final case class PutResourcePolicyOp(
      request: PutResourcePolicyRequest
    ) extends SecretsManagerOp[PutResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutResourcePolicyResponse] =
        visitor.putResourcePolicy(request)
    }

    final case class PutSecretValueOp(
      request: PutSecretValueRequest
    ) extends SecretsManagerOp[PutSecretValueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutSecretValueResponse] =
        visitor.putSecretValue(request)
    }

    final case class RemoveRegionsFromReplicationOp(
      request: RemoveRegionsFromReplicationRequest
    ) extends SecretsManagerOp[RemoveRegionsFromReplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveRegionsFromReplicationResponse] =
        visitor.removeRegionsFromReplication(request)
    }

    final case class ReplicateSecretToRegionsOp(
      request: ReplicateSecretToRegionsRequest
    ) extends SecretsManagerOp[ReplicateSecretToRegionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReplicateSecretToRegionsResponse] =
        visitor.replicateSecretToRegions(request)
    }

    final case class RestoreSecretOp(
      request: RestoreSecretRequest
    ) extends SecretsManagerOp[RestoreSecretResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreSecretResponse] =
        visitor.restoreSecret(request)
    }

    final case class RotateSecretOp(
      request: RotateSecretRequest
    ) extends SecretsManagerOp[RotateSecretResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RotateSecretResponse] =
        visitor.rotateSecret(request)
    }

    final case class StopReplicationToReplicaOp(
      request: StopReplicationToReplicaRequest
    ) extends SecretsManagerOp[StopReplicationToReplicaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopReplicationToReplicaResponse] =
        visitor.stopReplicationToReplica(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends SecretsManagerOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends SecretsManagerOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateSecretOp(
      request: UpdateSecretRequest
    ) extends SecretsManagerOp[UpdateSecretResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSecretResponse] =
        visitor.updateSecret(request)
    }

    final case class UpdateSecretVersionStageOp(
      request: UpdateSecretVersionStageRequest
    ) extends SecretsManagerOp[UpdateSecretVersionStageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSecretVersionStageResponse] =
        visitor.updateSecretVersionStage(request)
    }

    final case class ValidateResourcePolicyOp(
      request: ValidateResourcePolicyRequest
    ) extends SecretsManagerOp[ValidateResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ValidateResourcePolicyResponse] =
        visitor.validateResourcePolicy(request)
    }
  }

  import SecretsManagerOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SecretsManagerOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def cancelRotateSecret(
    request: CancelRotateSecretRequest
  ): SecretsManagerIO[CancelRotateSecretResponse] =
    FF.liftF(CancelRotateSecretOp(request))

  def createSecret(
    request: CreateSecretRequest
  ): SecretsManagerIO[CreateSecretResponse] =
    FF.liftF(CreateSecretOp(request))

  def deleteResourcePolicy(
    request: DeleteResourcePolicyRequest
  ): SecretsManagerIO[DeleteResourcePolicyResponse] =
    FF.liftF(DeleteResourcePolicyOp(request))

  def deleteSecret(
    request: DeleteSecretRequest
  ): SecretsManagerIO[DeleteSecretResponse] =
    FF.liftF(DeleteSecretOp(request))

  def describeSecret(
    request: DescribeSecretRequest
  ): SecretsManagerIO[DescribeSecretResponse] =
    FF.liftF(DescribeSecretOp(request))

  def getRandomPassword(
    request: GetRandomPasswordRequest
  ): SecretsManagerIO[GetRandomPasswordResponse] =
    FF.liftF(GetRandomPasswordOp(request))

  def getResourcePolicy(
    request: GetResourcePolicyRequest
  ): SecretsManagerIO[GetResourcePolicyResponse] =
    FF.liftF(GetResourcePolicyOp(request))

  def getSecretValue(
    request: GetSecretValueRequest
  ): SecretsManagerIO[GetSecretValueResponse] =
    FF.liftF(GetSecretValueOp(request))

  def listSecretVersionIds(
    request: ListSecretVersionIdsRequest
  ): SecretsManagerIO[ListSecretVersionIdsResponse] =
    FF.liftF(ListSecretVersionIdsOp(request))

  def listSecrets(
    request: ListSecretsRequest
  ): SecretsManagerIO[ListSecretsResponse] =
    FF.liftF(ListSecretsOp(request))

  def putResourcePolicy(
    request: PutResourcePolicyRequest
  ): SecretsManagerIO[PutResourcePolicyResponse] =
    FF.liftF(PutResourcePolicyOp(request))

  def putSecretValue(
    request: PutSecretValueRequest
  ): SecretsManagerIO[PutSecretValueResponse] =
    FF.liftF(PutSecretValueOp(request))

  def removeRegionsFromReplication(
    request: RemoveRegionsFromReplicationRequest
  ): SecretsManagerIO[RemoveRegionsFromReplicationResponse] =
    FF.liftF(RemoveRegionsFromReplicationOp(request))

  def replicateSecretToRegions(
    request: ReplicateSecretToRegionsRequest
  ): SecretsManagerIO[ReplicateSecretToRegionsResponse] =
    FF.liftF(ReplicateSecretToRegionsOp(request))

  def restoreSecret(
    request: RestoreSecretRequest
  ): SecretsManagerIO[RestoreSecretResponse] =
    FF.liftF(RestoreSecretOp(request))

  def rotateSecret(
    request: RotateSecretRequest
  ): SecretsManagerIO[RotateSecretResponse] =
    FF.liftF(RotateSecretOp(request))

  def stopReplicationToReplica(
    request: StopReplicationToReplicaRequest
  ): SecretsManagerIO[StopReplicationToReplicaResponse] =
    FF.liftF(StopReplicationToReplicaOp(request))

  def tagResource(
    request: TagResourceRequest
  ): SecretsManagerIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): SecretsManagerIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateSecret(
    request: UpdateSecretRequest
  ): SecretsManagerIO[UpdateSecretResponse] =
    FF.liftF(UpdateSecretOp(request))

  def updateSecretVersionStage(
    request: UpdateSecretVersionStageRequest
  ): SecretsManagerIO[UpdateSecretVersionStageResponse] =
    FF.liftF(UpdateSecretVersionStageOp(request))

  def validateResourcePolicy(
    request: ValidateResourcePolicyRequest
  ): SecretsManagerIO[ValidateResourcePolicyResponse] =
    FF.liftF(ValidateResourcePolicyOp(request))
}
