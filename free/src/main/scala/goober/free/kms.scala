package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.kms.KmsClient
import software.amazon.awssdk.services.kms.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object kms { module =>

  // Free monad over KmsOp
  type KmsIO[A] = FF[KmsOp, A]

  sealed trait KmsOp[A] {
    def visit[F[_]](visitor: KmsOp.Visitor[F]): F[A]
  }

  object KmsOp {
    // Given a KmsClient we can embed a KmsIO program in any algebra that understands embedding.
    implicit val KmsOpEmbeddable: Embeddable[KmsOp, KmsClient] = new Embeddable[KmsOp, KmsClient] {
      def embed[A](client: KmsClient, io: KmsIO[A]): Embedded[A] = Embedded.Kms(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends KmsOp.Visitor[Kleisli[M, KmsClient, *]] {
        def cancelKeyDeletion(
          request: CancelKeyDeletionRequest
        ): Kleisli[M, KmsClient, CancelKeyDeletionResponse] =
          primitive(_.cancelKeyDeletion(request))

        def connectCustomKeyStore(
          request: ConnectCustomKeyStoreRequest
        ): Kleisli[M, KmsClient, ConnectCustomKeyStoreResponse] =
          primitive(_.connectCustomKeyStore(request))

        def createAlias(
          request: CreateAliasRequest
        ): Kleisli[M, KmsClient, CreateAliasResponse] =
          primitive(_.createAlias(request))

        def createCustomKeyStore(
          request: CreateCustomKeyStoreRequest
        ): Kleisli[M, KmsClient, CreateCustomKeyStoreResponse] =
          primitive(_.createCustomKeyStore(request))

        def createGrant(
          request: CreateGrantRequest
        ): Kleisli[M, KmsClient, CreateGrantResponse] =
          primitive(_.createGrant(request))

        def createKey(
          request: CreateKeyRequest
        ): Kleisli[M, KmsClient, CreateKeyResponse] =
          primitive(_.createKey(request))

        def decrypt(
          request: DecryptRequest
        ): Kleisli[M, KmsClient, DecryptResponse] =
          primitive(_.decrypt(request))

        def deleteAlias(
          request: DeleteAliasRequest
        ): Kleisli[M, KmsClient, DeleteAliasResponse] =
          primitive(_.deleteAlias(request))

        def deleteCustomKeyStore(
          request: DeleteCustomKeyStoreRequest
        ): Kleisli[M, KmsClient, DeleteCustomKeyStoreResponse] =
          primitive(_.deleteCustomKeyStore(request))

        def deleteImportedKeyMaterial(
          request: DeleteImportedKeyMaterialRequest
        ): Kleisli[M, KmsClient, DeleteImportedKeyMaterialResponse] =
          primitive(_.deleteImportedKeyMaterial(request))

        def describeCustomKeyStores(
          request: DescribeCustomKeyStoresRequest
        ): Kleisli[M, KmsClient, DescribeCustomKeyStoresResponse] =
          primitive(_.describeCustomKeyStores(request))

        def describeKey(
          request: DescribeKeyRequest
        ): Kleisli[M, KmsClient, DescribeKeyResponse] =
          primitive(_.describeKey(request))

        def disableKey(
          request: DisableKeyRequest
        ): Kleisli[M, KmsClient, DisableKeyResponse] =
          primitive(_.disableKey(request))

        def disableKeyRotation(
          request: DisableKeyRotationRequest
        ): Kleisli[M, KmsClient, DisableKeyRotationResponse] =
          primitive(_.disableKeyRotation(request))

        def disconnectCustomKeyStore(
          request: DisconnectCustomKeyStoreRequest
        ): Kleisli[M, KmsClient, DisconnectCustomKeyStoreResponse] =
          primitive(_.disconnectCustomKeyStore(request))

        def enableKey(
          request: EnableKeyRequest
        ): Kleisli[M, KmsClient, EnableKeyResponse] =
          primitive(_.enableKey(request))

        def enableKeyRotation(
          request: EnableKeyRotationRequest
        ): Kleisli[M, KmsClient, EnableKeyRotationResponse] =
          primitive(_.enableKeyRotation(request))

        def encrypt(
          request: EncryptRequest
        ): Kleisli[M, KmsClient, EncryptResponse] =
          primitive(_.encrypt(request))

        def generateDataKey(
          request: GenerateDataKeyRequest
        ): Kleisli[M, KmsClient, GenerateDataKeyResponse] =
          primitive(_.generateDataKey(request))

        def generateDataKeyPair(
          request: GenerateDataKeyPairRequest
        ): Kleisli[M, KmsClient, GenerateDataKeyPairResponse] =
          primitive(_.generateDataKeyPair(request))

        def generateDataKeyPairWithoutPlaintext(
          request: GenerateDataKeyPairWithoutPlaintextRequest
        ): Kleisli[M, KmsClient, GenerateDataKeyPairWithoutPlaintextResponse] =
          primitive(_.generateDataKeyPairWithoutPlaintext(request))

        def generateDataKeyWithoutPlaintext(
          request: GenerateDataKeyWithoutPlaintextRequest
        ): Kleisli[M, KmsClient, GenerateDataKeyWithoutPlaintextResponse] =
          primitive(_.generateDataKeyWithoutPlaintext(request))

        def generateRandom(
          request: GenerateRandomRequest
        ): Kleisli[M, KmsClient, GenerateRandomResponse] =
          primitive(_.generateRandom(request))

        def getKeyPolicy(
          request: GetKeyPolicyRequest
        ): Kleisli[M, KmsClient, GetKeyPolicyResponse] =
          primitive(_.getKeyPolicy(request))

        def getKeyRotationStatus(
          request: GetKeyRotationStatusRequest
        ): Kleisli[M, KmsClient, GetKeyRotationStatusResponse] =
          primitive(_.getKeyRotationStatus(request))

        def getParametersForImport(
          request: GetParametersForImportRequest
        ): Kleisli[M, KmsClient, GetParametersForImportResponse] =
          primitive(_.getParametersForImport(request))

        def getPublicKey(
          request: GetPublicKeyRequest
        ): Kleisli[M, KmsClient, GetPublicKeyResponse] =
          primitive(_.getPublicKey(request))

        def importKeyMaterial(
          request: ImportKeyMaterialRequest
        ): Kleisli[M, KmsClient, ImportKeyMaterialResponse] =
          primitive(_.importKeyMaterial(request))

        def listAliases(
          request: ListAliasesRequest
        ): Kleisli[M, KmsClient, ListAliasesResponse] =
          primitive(_.listAliases(request))

        def listGrants(
          request: ListGrantsRequest
        ): Kleisli[M, KmsClient, ListGrantsResponse] =
          primitive(_.listGrants(request))

        def listKeyPolicies(
          request: ListKeyPoliciesRequest
        ): Kleisli[M, KmsClient, ListKeyPoliciesResponse] =
          primitive(_.listKeyPolicies(request))

        def listKeys(
          request: ListKeysRequest
        ): Kleisli[M, KmsClient, ListKeysResponse] =
          primitive(_.listKeys(request))

        def listResourceTags(
          request: ListResourceTagsRequest
        ): Kleisli[M, KmsClient, ListResourceTagsResponse] =
          primitive(_.listResourceTags(request))

        def listRetirableGrants(
          request: ListRetirableGrantsRequest
        ): Kleisli[M, KmsClient, ListRetirableGrantsResponse] =
          primitive(_.listRetirableGrants(request))

        def putKeyPolicy(
          request: PutKeyPolicyRequest
        ): Kleisli[M, KmsClient, PutKeyPolicyResponse] =
          primitive(_.putKeyPolicy(request))

        def reEncrypt(
          request: ReEncryptRequest
        ): Kleisli[M, KmsClient, ReEncryptResponse] =
          primitive(_.reEncrypt(request))

        def retireGrant(
          request: RetireGrantRequest
        ): Kleisli[M, KmsClient, RetireGrantResponse] =
          primitive(_.retireGrant(request))

        def revokeGrant(
          request: RevokeGrantRequest
        ): Kleisli[M, KmsClient, RevokeGrantResponse] =
          primitive(_.revokeGrant(request))

        def scheduleKeyDeletion(
          request: ScheduleKeyDeletionRequest
        ): Kleisli[M, KmsClient, ScheduleKeyDeletionResponse] =
          primitive(_.scheduleKeyDeletion(request))

        def sign(
          request: SignRequest
        ): Kleisli[M, KmsClient, SignResponse] =
          primitive(_.sign(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, KmsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, KmsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAlias(
          request: UpdateAliasRequest
        ): Kleisli[M, KmsClient, UpdateAliasResponse] =
          primitive(_.updateAlias(request))

        def updateCustomKeyStore(
          request: UpdateCustomKeyStoreRequest
        ): Kleisli[M, KmsClient, UpdateCustomKeyStoreResponse] =
          primitive(_.updateCustomKeyStore(request))

        def updateKeyDescription(
          request: UpdateKeyDescriptionRequest
        ): Kleisli[M, KmsClient, UpdateKeyDescriptionResponse] =
          primitive(_.updateKeyDescription(request))

        def verify(
          request: VerifyRequest
        ): Kleisli[M, KmsClient, VerifyResponse] =
          primitive(_.verify(request))

        def primitive[A](
          f: KmsClient => A
        ): Kleisli[M, KmsClient, A]
      }
    }

    trait Visitor[F[_]] extends (KmsOp ~> F) {
      final def apply[A](op: KmsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def cancelKeyDeletion(
        request: CancelKeyDeletionRequest
      ): F[CancelKeyDeletionResponse]

      def connectCustomKeyStore(
        request: ConnectCustomKeyStoreRequest
      ): F[ConnectCustomKeyStoreResponse]

      def createAlias(
        request: CreateAliasRequest
      ): F[CreateAliasResponse]

      def createCustomKeyStore(
        request: CreateCustomKeyStoreRequest
      ): F[CreateCustomKeyStoreResponse]

      def createGrant(
        request: CreateGrantRequest
      ): F[CreateGrantResponse]

      def createKey(
        request: CreateKeyRequest
      ): F[CreateKeyResponse]

      def decrypt(
        request: DecryptRequest
      ): F[DecryptResponse]

      def deleteAlias(
        request: DeleteAliasRequest
      ): F[DeleteAliasResponse]

      def deleteCustomKeyStore(
        request: DeleteCustomKeyStoreRequest
      ): F[DeleteCustomKeyStoreResponse]

      def deleteImportedKeyMaterial(
        request: DeleteImportedKeyMaterialRequest
      ): F[DeleteImportedKeyMaterialResponse]

      def describeCustomKeyStores(
        request: DescribeCustomKeyStoresRequest
      ): F[DescribeCustomKeyStoresResponse]

      def describeKey(
        request: DescribeKeyRequest
      ): F[DescribeKeyResponse]

      def disableKey(
        request: DisableKeyRequest
      ): F[DisableKeyResponse]

      def disableKeyRotation(
        request: DisableKeyRotationRequest
      ): F[DisableKeyRotationResponse]

      def disconnectCustomKeyStore(
        request: DisconnectCustomKeyStoreRequest
      ): F[DisconnectCustomKeyStoreResponse]

      def enableKey(
        request: EnableKeyRequest
      ): F[EnableKeyResponse]

      def enableKeyRotation(
        request: EnableKeyRotationRequest
      ): F[EnableKeyRotationResponse]

      def encrypt(
        request: EncryptRequest
      ): F[EncryptResponse]

      def generateDataKey(
        request: GenerateDataKeyRequest
      ): F[GenerateDataKeyResponse]

      def generateDataKeyPair(
        request: GenerateDataKeyPairRequest
      ): F[GenerateDataKeyPairResponse]

      def generateDataKeyPairWithoutPlaintext(
        request: GenerateDataKeyPairWithoutPlaintextRequest
      ): F[GenerateDataKeyPairWithoutPlaintextResponse]

      def generateDataKeyWithoutPlaintext(
        request: GenerateDataKeyWithoutPlaintextRequest
      ): F[GenerateDataKeyWithoutPlaintextResponse]

      def generateRandom(
        request: GenerateRandomRequest
      ): F[GenerateRandomResponse]

      def getKeyPolicy(
        request: GetKeyPolicyRequest
      ): F[GetKeyPolicyResponse]

      def getKeyRotationStatus(
        request: GetKeyRotationStatusRequest
      ): F[GetKeyRotationStatusResponse]

      def getParametersForImport(
        request: GetParametersForImportRequest
      ): F[GetParametersForImportResponse]

      def getPublicKey(
        request: GetPublicKeyRequest
      ): F[GetPublicKeyResponse]

      def importKeyMaterial(
        request: ImportKeyMaterialRequest
      ): F[ImportKeyMaterialResponse]

      def listAliases(
        request: ListAliasesRequest
      ): F[ListAliasesResponse]

      def listGrants(
        request: ListGrantsRequest
      ): F[ListGrantsResponse]

      def listKeyPolicies(
        request: ListKeyPoliciesRequest
      ): F[ListKeyPoliciesResponse]

      def listKeys(
        request: ListKeysRequest
      ): F[ListKeysResponse]

      def listResourceTags(
        request: ListResourceTagsRequest
      ): F[ListResourceTagsResponse]

      def listRetirableGrants(
        request: ListRetirableGrantsRequest
      ): F[ListRetirableGrantsResponse]

      def putKeyPolicy(
        request: PutKeyPolicyRequest
      ): F[PutKeyPolicyResponse]

      def reEncrypt(
        request: ReEncryptRequest
      ): F[ReEncryptResponse]

      def retireGrant(
        request: RetireGrantRequest
      ): F[RetireGrantResponse]

      def revokeGrant(
        request: RevokeGrantRequest
      ): F[RevokeGrantResponse]

      def scheduleKeyDeletion(
        request: ScheduleKeyDeletionRequest
      ): F[ScheduleKeyDeletionResponse]

      def sign(
        request: SignRequest
      ): F[SignResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAlias(
        request: UpdateAliasRequest
      ): F[UpdateAliasResponse]

      def updateCustomKeyStore(
        request: UpdateCustomKeyStoreRequest
      ): F[UpdateCustomKeyStoreResponse]

      def updateKeyDescription(
        request: UpdateKeyDescriptionRequest
      ): F[UpdateKeyDescriptionResponse]

      def verify(
        request: VerifyRequest
      ): F[VerifyResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends KmsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CancelKeyDeletionOp(
      request: CancelKeyDeletionRequest
    ) extends KmsOp[CancelKeyDeletionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelKeyDeletionResponse] =
        visitor.cancelKeyDeletion(request)
    }

    final case class ConnectCustomKeyStoreOp(
      request: ConnectCustomKeyStoreRequest
    ) extends KmsOp[ConnectCustomKeyStoreResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ConnectCustomKeyStoreResponse] =
        visitor.connectCustomKeyStore(request)
    }

    final case class CreateAliasOp(
      request: CreateAliasRequest
    ) extends KmsOp[CreateAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAliasResponse] =
        visitor.createAlias(request)
    }

    final case class CreateCustomKeyStoreOp(
      request: CreateCustomKeyStoreRequest
    ) extends KmsOp[CreateCustomKeyStoreResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCustomKeyStoreResponse] =
        visitor.createCustomKeyStore(request)
    }

    final case class CreateGrantOp(
      request: CreateGrantRequest
    ) extends KmsOp[CreateGrantResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGrantResponse] =
        visitor.createGrant(request)
    }

    final case class CreateKeyOp(
      request: CreateKeyRequest
    ) extends KmsOp[CreateKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateKeyResponse] =
        visitor.createKey(request)
    }

    final case class DecryptOp(
      request: DecryptRequest
    ) extends KmsOp[DecryptResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DecryptResponse] =
        visitor.decrypt(request)
    }

    final case class DeleteAliasOp(
      request: DeleteAliasRequest
    ) extends KmsOp[DeleteAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAliasResponse] =
        visitor.deleteAlias(request)
    }

    final case class DeleteCustomKeyStoreOp(
      request: DeleteCustomKeyStoreRequest
    ) extends KmsOp[DeleteCustomKeyStoreResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCustomKeyStoreResponse] =
        visitor.deleteCustomKeyStore(request)
    }

    final case class DeleteImportedKeyMaterialOp(
      request: DeleteImportedKeyMaterialRequest
    ) extends KmsOp[DeleteImportedKeyMaterialResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteImportedKeyMaterialResponse] =
        visitor.deleteImportedKeyMaterial(request)
    }

    final case class DescribeCustomKeyStoresOp(
      request: DescribeCustomKeyStoresRequest
    ) extends KmsOp[DescribeCustomKeyStoresResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCustomKeyStoresResponse] =
        visitor.describeCustomKeyStores(request)
    }

    final case class DescribeKeyOp(
      request: DescribeKeyRequest
    ) extends KmsOp[DescribeKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeKeyResponse] =
        visitor.describeKey(request)
    }

    final case class DisableKeyOp(
      request: DisableKeyRequest
    ) extends KmsOp[DisableKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableKeyResponse] =
        visitor.disableKey(request)
    }

    final case class DisableKeyRotationOp(
      request: DisableKeyRotationRequest
    ) extends KmsOp[DisableKeyRotationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableKeyRotationResponse] =
        visitor.disableKeyRotation(request)
    }

    final case class DisconnectCustomKeyStoreOp(
      request: DisconnectCustomKeyStoreRequest
    ) extends KmsOp[DisconnectCustomKeyStoreResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisconnectCustomKeyStoreResponse] =
        visitor.disconnectCustomKeyStore(request)
    }

    final case class EnableKeyOp(
      request: EnableKeyRequest
    ) extends KmsOp[EnableKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableKeyResponse] =
        visitor.enableKey(request)
    }

    final case class EnableKeyRotationOp(
      request: EnableKeyRotationRequest
    ) extends KmsOp[EnableKeyRotationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableKeyRotationResponse] =
        visitor.enableKeyRotation(request)
    }

    final case class EncryptOp(
      request: EncryptRequest
    ) extends KmsOp[EncryptResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EncryptResponse] =
        visitor.encrypt(request)
    }

    final case class GenerateDataKeyOp(
      request: GenerateDataKeyRequest
    ) extends KmsOp[GenerateDataKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GenerateDataKeyResponse] =
        visitor.generateDataKey(request)
    }

    final case class GenerateDataKeyPairOp(
      request: GenerateDataKeyPairRequest
    ) extends KmsOp[GenerateDataKeyPairResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GenerateDataKeyPairResponse] =
        visitor.generateDataKeyPair(request)
    }

    final case class GenerateDataKeyPairWithoutPlaintextOp(
      request: GenerateDataKeyPairWithoutPlaintextRequest
    ) extends KmsOp[GenerateDataKeyPairWithoutPlaintextResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GenerateDataKeyPairWithoutPlaintextResponse] =
        visitor.generateDataKeyPairWithoutPlaintext(request)
    }

    final case class GenerateDataKeyWithoutPlaintextOp(
      request: GenerateDataKeyWithoutPlaintextRequest
    ) extends KmsOp[GenerateDataKeyWithoutPlaintextResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GenerateDataKeyWithoutPlaintextResponse] =
        visitor.generateDataKeyWithoutPlaintext(request)
    }

    final case class GenerateRandomOp(
      request: GenerateRandomRequest
    ) extends KmsOp[GenerateRandomResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GenerateRandomResponse] =
        visitor.generateRandom(request)
    }

    final case class GetKeyPolicyOp(
      request: GetKeyPolicyRequest
    ) extends KmsOp[GetKeyPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetKeyPolicyResponse] =
        visitor.getKeyPolicy(request)
    }

    final case class GetKeyRotationStatusOp(
      request: GetKeyRotationStatusRequest
    ) extends KmsOp[GetKeyRotationStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetKeyRotationStatusResponse] =
        visitor.getKeyRotationStatus(request)
    }

    final case class GetParametersForImportOp(
      request: GetParametersForImportRequest
    ) extends KmsOp[GetParametersForImportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetParametersForImportResponse] =
        visitor.getParametersForImport(request)
    }

    final case class GetPublicKeyOp(
      request: GetPublicKeyRequest
    ) extends KmsOp[GetPublicKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPublicKeyResponse] =
        visitor.getPublicKey(request)
    }

    final case class ImportKeyMaterialOp(
      request: ImportKeyMaterialRequest
    ) extends KmsOp[ImportKeyMaterialResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportKeyMaterialResponse] =
        visitor.importKeyMaterial(request)
    }

    final case class ListAliasesOp(
      request: ListAliasesRequest
    ) extends KmsOp[ListAliasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAliasesResponse] =
        visitor.listAliases(request)
    }

    final case class ListGrantsOp(
      request: ListGrantsRequest
    ) extends KmsOp[ListGrantsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGrantsResponse] =
        visitor.listGrants(request)
    }

    final case class ListKeyPoliciesOp(
      request: ListKeyPoliciesRequest
    ) extends KmsOp[ListKeyPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListKeyPoliciesResponse] =
        visitor.listKeyPolicies(request)
    }

    final case class ListKeysOp(
      request: ListKeysRequest
    ) extends KmsOp[ListKeysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListKeysResponse] =
        visitor.listKeys(request)
    }

    final case class ListResourceTagsOp(
      request: ListResourceTagsRequest
    ) extends KmsOp[ListResourceTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResourceTagsResponse] =
        visitor.listResourceTags(request)
    }

    final case class ListRetirableGrantsOp(
      request: ListRetirableGrantsRequest
    ) extends KmsOp[ListRetirableGrantsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRetirableGrantsResponse] =
        visitor.listRetirableGrants(request)
    }

    final case class PutKeyPolicyOp(
      request: PutKeyPolicyRequest
    ) extends KmsOp[PutKeyPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutKeyPolicyResponse] =
        visitor.putKeyPolicy(request)
    }

    final case class ReEncryptOp(
      request: ReEncryptRequest
    ) extends KmsOp[ReEncryptResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReEncryptResponse] =
        visitor.reEncrypt(request)
    }

    final case class RetireGrantOp(
      request: RetireGrantRequest
    ) extends KmsOp[RetireGrantResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RetireGrantResponse] =
        visitor.retireGrant(request)
    }

    final case class RevokeGrantOp(
      request: RevokeGrantRequest
    ) extends KmsOp[RevokeGrantResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RevokeGrantResponse] =
        visitor.revokeGrant(request)
    }

    final case class ScheduleKeyDeletionOp(
      request: ScheduleKeyDeletionRequest
    ) extends KmsOp[ScheduleKeyDeletionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ScheduleKeyDeletionResponse] =
        visitor.scheduleKeyDeletion(request)
    }

    final case class SignOp(
      request: SignRequest
    ) extends KmsOp[SignResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SignResponse] =
        visitor.sign(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends KmsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends KmsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAliasOp(
      request: UpdateAliasRequest
    ) extends KmsOp[UpdateAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAliasResponse] =
        visitor.updateAlias(request)
    }

    final case class UpdateCustomKeyStoreOp(
      request: UpdateCustomKeyStoreRequest
    ) extends KmsOp[UpdateCustomKeyStoreResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCustomKeyStoreResponse] =
        visitor.updateCustomKeyStore(request)
    }

    final case class UpdateKeyDescriptionOp(
      request: UpdateKeyDescriptionRequest
    ) extends KmsOp[UpdateKeyDescriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateKeyDescriptionResponse] =
        visitor.updateKeyDescription(request)
    }

    final case class VerifyOp(
      request: VerifyRequest
    ) extends KmsOp[VerifyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[VerifyResponse] =
        visitor.verify(request)
    }
  }

  import KmsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[KmsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def cancelKeyDeletion(
    request: CancelKeyDeletionRequest
  ): KmsIO[CancelKeyDeletionResponse] =
    FF.liftF(CancelKeyDeletionOp(request))

  def connectCustomKeyStore(
    request: ConnectCustomKeyStoreRequest
  ): KmsIO[ConnectCustomKeyStoreResponse] =
    FF.liftF(ConnectCustomKeyStoreOp(request))

  def createAlias(
    request: CreateAliasRequest
  ): KmsIO[CreateAliasResponse] =
    FF.liftF(CreateAliasOp(request))

  def createCustomKeyStore(
    request: CreateCustomKeyStoreRequest
  ): KmsIO[CreateCustomKeyStoreResponse] =
    FF.liftF(CreateCustomKeyStoreOp(request))

  def createGrant(
    request: CreateGrantRequest
  ): KmsIO[CreateGrantResponse] =
    FF.liftF(CreateGrantOp(request))

  def createKey(
    request: CreateKeyRequest
  ): KmsIO[CreateKeyResponse] =
    FF.liftF(CreateKeyOp(request))

  def decrypt(
    request: DecryptRequest
  ): KmsIO[DecryptResponse] =
    FF.liftF(DecryptOp(request))

  def deleteAlias(
    request: DeleteAliasRequest
  ): KmsIO[DeleteAliasResponse] =
    FF.liftF(DeleteAliasOp(request))

  def deleteCustomKeyStore(
    request: DeleteCustomKeyStoreRequest
  ): KmsIO[DeleteCustomKeyStoreResponse] =
    FF.liftF(DeleteCustomKeyStoreOp(request))

  def deleteImportedKeyMaterial(
    request: DeleteImportedKeyMaterialRequest
  ): KmsIO[DeleteImportedKeyMaterialResponse] =
    FF.liftF(DeleteImportedKeyMaterialOp(request))

  def describeCustomKeyStores(
    request: DescribeCustomKeyStoresRequest
  ): KmsIO[DescribeCustomKeyStoresResponse] =
    FF.liftF(DescribeCustomKeyStoresOp(request))

  def describeKey(
    request: DescribeKeyRequest
  ): KmsIO[DescribeKeyResponse] =
    FF.liftF(DescribeKeyOp(request))

  def disableKey(
    request: DisableKeyRequest
  ): KmsIO[DisableKeyResponse] =
    FF.liftF(DisableKeyOp(request))

  def disableKeyRotation(
    request: DisableKeyRotationRequest
  ): KmsIO[DisableKeyRotationResponse] =
    FF.liftF(DisableKeyRotationOp(request))

  def disconnectCustomKeyStore(
    request: DisconnectCustomKeyStoreRequest
  ): KmsIO[DisconnectCustomKeyStoreResponse] =
    FF.liftF(DisconnectCustomKeyStoreOp(request))

  def enableKey(
    request: EnableKeyRequest
  ): KmsIO[EnableKeyResponse] =
    FF.liftF(EnableKeyOp(request))

  def enableKeyRotation(
    request: EnableKeyRotationRequest
  ): KmsIO[EnableKeyRotationResponse] =
    FF.liftF(EnableKeyRotationOp(request))

  def encrypt(
    request: EncryptRequest
  ): KmsIO[EncryptResponse] =
    FF.liftF(EncryptOp(request))

  def generateDataKey(
    request: GenerateDataKeyRequest
  ): KmsIO[GenerateDataKeyResponse] =
    FF.liftF(GenerateDataKeyOp(request))

  def generateDataKeyPair(
    request: GenerateDataKeyPairRequest
  ): KmsIO[GenerateDataKeyPairResponse] =
    FF.liftF(GenerateDataKeyPairOp(request))

  def generateDataKeyPairWithoutPlaintext(
    request: GenerateDataKeyPairWithoutPlaintextRequest
  ): KmsIO[GenerateDataKeyPairWithoutPlaintextResponse] =
    FF.liftF(GenerateDataKeyPairWithoutPlaintextOp(request))

  def generateDataKeyWithoutPlaintext(
    request: GenerateDataKeyWithoutPlaintextRequest
  ): KmsIO[GenerateDataKeyWithoutPlaintextResponse] =
    FF.liftF(GenerateDataKeyWithoutPlaintextOp(request))

  def generateRandom(
    request: GenerateRandomRequest
  ): KmsIO[GenerateRandomResponse] =
    FF.liftF(GenerateRandomOp(request))

  def getKeyPolicy(
    request: GetKeyPolicyRequest
  ): KmsIO[GetKeyPolicyResponse] =
    FF.liftF(GetKeyPolicyOp(request))

  def getKeyRotationStatus(
    request: GetKeyRotationStatusRequest
  ): KmsIO[GetKeyRotationStatusResponse] =
    FF.liftF(GetKeyRotationStatusOp(request))

  def getParametersForImport(
    request: GetParametersForImportRequest
  ): KmsIO[GetParametersForImportResponse] =
    FF.liftF(GetParametersForImportOp(request))

  def getPublicKey(
    request: GetPublicKeyRequest
  ): KmsIO[GetPublicKeyResponse] =
    FF.liftF(GetPublicKeyOp(request))

  def importKeyMaterial(
    request: ImportKeyMaterialRequest
  ): KmsIO[ImportKeyMaterialResponse] =
    FF.liftF(ImportKeyMaterialOp(request))

  def listAliases(
    request: ListAliasesRequest
  ): KmsIO[ListAliasesResponse] =
    FF.liftF(ListAliasesOp(request))

  def listGrants(
    request: ListGrantsRequest
  ): KmsIO[ListGrantsResponse] =
    FF.liftF(ListGrantsOp(request))

  def listKeyPolicies(
    request: ListKeyPoliciesRequest
  ): KmsIO[ListKeyPoliciesResponse] =
    FF.liftF(ListKeyPoliciesOp(request))

  def listKeys(
    request: ListKeysRequest
  ): KmsIO[ListKeysResponse] =
    FF.liftF(ListKeysOp(request))

  def listResourceTags(
    request: ListResourceTagsRequest
  ): KmsIO[ListResourceTagsResponse] =
    FF.liftF(ListResourceTagsOp(request))

  def listRetirableGrants(
    request: ListRetirableGrantsRequest
  ): KmsIO[ListRetirableGrantsResponse] =
    FF.liftF(ListRetirableGrantsOp(request))

  def putKeyPolicy(
    request: PutKeyPolicyRequest
  ): KmsIO[PutKeyPolicyResponse] =
    FF.liftF(PutKeyPolicyOp(request))

  def reEncrypt(
    request: ReEncryptRequest
  ): KmsIO[ReEncryptResponse] =
    FF.liftF(ReEncryptOp(request))

  def retireGrant(
    request: RetireGrantRequest
  ): KmsIO[RetireGrantResponse] =
    FF.liftF(RetireGrantOp(request))

  def revokeGrant(
    request: RevokeGrantRequest
  ): KmsIO[RevokeGrantResponse] =
    FF.liftF(RevokeGrantOp(request))

  def scheduleKeyDeletion(
    request: ScheduleKeyDeletionRequest
  ): KmsIO[ScheduleKeyDeletionResponse] =
    FF.liftF(ScheduleKeyDeletionOp(request))

  def sign(
    request: SignRequest
  ): KmsIO[SignResponse] =
    FF.liftF(SignOp(request))

  def tagResource(
    request: TagResourceRequest
  ): KmsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): KmsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAlias(
    request: UpdateAliasRequest
  ): KmsIO[UpdateAliasResponse] =
    FF.liftF(UpdateAliasOp(request))

  def updateCustomKeyStore(
    request: UpdateCustomKeyStoreRequest
  ): KmsIO[UpdateCustomKeyStoreResponse] =
    FF.liftF(UpdateCustomKeyStoreOp(request))

  def updateKeyDescription(
    request: UpdateKeyDescriptionRequest
  ): KmsIO[UpdateKeyDescriptionResponse] =
    FF.liftF(UpdateKeyDescriptionOp(request))

  def verify(
    request: VerifyRequest
  ): KmsIO[VerifyResponse] =
    FF.liftF(VerifyOp(request))
}
