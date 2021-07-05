package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.eks.EksClient
import software.amazon.awssdk.services.eks.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object eks { module =>

  // Free monad over EksOp
  type EksIO[A] = FF[EksOp, A]

  sealed trait EksOp[A] {
    def visit[F[_]](visitor: EksOp.Visitor[F]): F[A]
  }

  object EksOp {
    // Given a EksClient we can embed a EksIO program in any algebra that understands embedding.
    implicit val EksOpEmbeddable: Embeddable[EksOp, EksClient] = new Embeddable[EksOp, EksClient] {
      def embed[A](client: EksClient, io: EksIO[A]): Embedded[A] = Embedded.Eks(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends EksOp.Visitor[Kleisli[M, EksClient, *]] {
        def associateEncryptionConfig(
          request: AssociateEncryptionConfigRequest
        ): Kleisli[M, EksClient, AssociateEncryptionConfigResponse] =
          primitive(_.associateEncryptionConfig(request))

        def associateIdentityProviderConfig(
          request: AssociateIdentityProviderConfigRequest
        ): Kleisli[M, EksClient, AssociateIdentityProviderConfigResponse] =
          primitive(_.associateIdentityProviderConfig(request))

        def createAddon(
          request: CreateAddonRequest
        ): Kleisli[M, EksClient, CreateAddonResponse] =
          primitive(_.createAddon(request))

        def createCluster(
          request: CreateClusterRequest
        ): Kleisli[M, EksClient, CreateClusterResponse] =
          primitive(_.createCluster(request))

        def createFargateProfile(
          request: CreateFargateProfileRequest
        ): Kleisli[M, EksClient, CreateFargateProfileResponse] =
          primitive(_.createFargateProfile(request))

        def createNodegroup(
          request: CreateNodegroupRequest
        ): Kleisli[M, EksClient, CreateNodegroupResponse] =
          primitive(_.createNodegroup(request))

        def deleteAddon(
          request: DeleteAddonRequest
        ): Kleisli[M, EksClient, DeleteAddonResponse] =
          primitive(_.deleteAddon(request))

        def deleteCluster(
          request: DeleteClusterRequest
        ): Kleisli[M, EksClient, DeleteClusterResponse] =
          primitive(_.deleteCluster(request))

        def deleteFargateProfile(
          request: DeleteFargateProfileRequest
        ): Kleisli[M, EksClient, DeleteFargateProfileResponse] =
          primitive(_.deleteFargateProfile(request))

        def deleteNodegroup(
          request: DeleteNodegroupRequest
        ): Kleisli[M, EksClient, DeleteNodegroupResponse] =
          primitive(_.deleteNodegroup(request))

        def describeAddon(
          request: DescribeAddonRequest
        ): Kleisli[M, EksClient, DescribeAddonResponse] =
          primitive(_.describeAddon(request))

        def describeAddonVersions(
          request: DescribeAddonVersionsRequest
        ): Kleisli[M, EksClient, DescribeAddonVersionsResponse] =
          primitive(_.describeAddonVersions(request))

        def describeCluster(
          request: DescribeClusterRequest
        ): Kleisli[M, EksClient, DescribeClusterResponse] =
          primitive(_.describeCluster(request))

        def describeFargateProfile(
          request: DescribeFargateProfileRequest
        ): Kleisli[M, EksClient, DescribeFargateProfileResponse] =
          primitive(_.describeFargateProfile(request))

        def describeIdentityProviderConfig(
          request: DescribeIdentityProviderConfigRequest
        ): Kleisli[M, EksClient, DescribeIdentityProviderConfigResponse] =
          primitive(_.describeIdentityProviderConfig(request))

        def describeNodegroup(
          request: DescribeNodegroupRequest
        ): Kleisli[M, EksClient, DescribeNodegroupResponse] =
          primitive(_.describeNodegroup(request))

        def describeUpdate(
          request: DescribeUpdateRequest
        ): Kleisli[M, EksClient, DescribeUpdateResponse] =
          primitive(_.describeUpdate(request))

        def disassociateIdentityProviderConfig(
          request: DisassociateIdentityProviderConfigRequest
        ): Kleisli[M, EksClient, DisassociateIdentityProviderConfigResponse] =
          primitive(_.disassociateIdentityProviderConfig(request))

        def listAddons(
          request: ListAddonsRequest
        ): Kleisli[M, EksClient, ListAddonsResponse] =
          primitive(_.listAddons(request))

        def listClusters(
          request: ListClustersRequest
        ): Kleisli[M, EksClient, ListClustersResponse] =
          primitive(_.listClusters(request))

        def listFargateProfiles(
          request: ListFargateProfilesRequest
        ): Kleisli[M, EksClient, ListFargateProfilesResponse] =
          primitive(_.listFargateProfiles(request))

        def listIdentityProviderConfigs(
          request: ListIdentityProviderConfigsRequest
        ): Kleisli[M, EksClient, ListIdentityProviderConfigsResponse] =
          primitive(_.listIdentityProviderConfigs(request))

        def listNodegroups(
          request: ListNodegroupsRequest
        ): Kleisli[M, EksClient, ListNodegroupsResponse] =
          primitive(_.listNodegroups(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, EksClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listUpdates(
          request: ListUpdatesRequest
        ): Kleisli[M, EksClient, ListUpdatesResponse] =
          primitive(_.listUpdates(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, EksClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, EksClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAddon(
          request: UpdateAddonRequest
        ): Kleisli[M, EksClient, UpdateAddonResponse] =
          primitive(_.updateAddon(request))

        def updateClusterConfig(
          request: UpdateClusterConfigRequest
        ): Kleisli[M, EksClient, UpdateClusterConfigResponse] =
          primitive(_.updateClusterConfig(request))

        def updateClusterVersion(
          request: UpdateClusterVersionRequest
        ): Kleisli[M, EksClient, UpdateClusterVersionResponse] =
          primitive(_.updateClusterVersion(request))

        def updateNodegroupConfig(
          request: UpdateNodegroupConfigRequest
        ): Kleisli[M, EksClient, UpdateNodegroupConfigResponse] =
          primitive(_.updateNodegroupConfig(request))

        def updateNodegroupVersion(
          request: UpdateNodegroupVersionRequest
        ): Kleisli[M, EksClient, UpdateNodegroupVersionResponse] =
          primitive(_.updateNodegroupVersion(request))

        def primitive[A](
          f: EksClient => A
        ): Kleisli[M, EksClient, A]
      }
    }

    trait Visitor[F[_]] extends (EksOp ~> F) {
      final def apply[A](op: EksOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateEncryptionConfig(
        request: AssociateEncryptionConfigRequest
      ): F[AssociateEncryptionConfigResponse]

      def associateIdentityProviderConfig(
        request: AssociateIdentityProviderConfigRequest
      ): F[AssociateIdentityProviderConfigResponse]

      def createAddon(
        request: CreateAddonRequest
      ): F[CreateAddonResponse]

      def createCluster(
        request: CreateClusterRequest
      ): F[CreateClusterResponse]

      def createFargateProfile(
        request: CreateFargateProfileRequest
      ): F[CreateFargateProfileResponse]

      def createNodegroup(
        request: CreateNodegroupRequest
      ): F[CreateNodegroupResponse]

      def deleteAddon(
        request: DeleteAddonRequest
      ): F[DeleteAddonResponse]

      def deleteCluster(
        request: DeleteClusterRequest
      ): F[DeleteClusterResponse]

      def deleteFargateProfile(
        request: DeleteFargateProfileRequest
      ): F[DeleteFargateProfileResponse]

      def deleteNodegroup(
        request: DeleteNodegroupRequest
      ): F[DeleteNodegroupResponse]

      def describeAddon(
        request: DescribeAddonRequest
      ): F[DescribeAddonResponse]

      def describeAddonVersions(
        request: DescribeAddonVersionsRequest
      ): F[DescribeAddonVersionsResponse]

      def describeCluster(
        request: DescribeClusterRequest
      ): F[DescribeClusterResponse]

      def describeFargateProfile(
        request: DescribeFargateProfileRequest
      ): F[DescribeFargateProfileResponse]

      def describeIdentityProviderConfig(
        request: DescribeIdentityProviderConfigRequest
      ): F[DescribeIdentityProviderConfigResponse]

      def describeNodegroup(
        request: DescribeNodegroupRequest
      ): F[DescribeNodegroupResponse]

      def describeUpdate(
        request: DescribeUpdateRequest
      ): F[DescribeUpdateResponse]

      def disassociateIdentityProviderConfig(
        request: DisassociateIdentityProviderConfigRequest
      ): F[DisassociateIdentityProviderConfigResponse]

      def listAddons(
        request: ListAddonsRequest
      ): F[ListAddonsResponse]

      def listClusters(
        request: ListClustersRequest
      ): F[ListClustersResponse]

      def listFargateProfiles(
        request: ListFargateProfilesRequest
      ): F[ListFargateProfilesResponse]

      def listIdentityProviderConfigs(
        request: ListIdentityProviderConfigsRequest
      ): F[ListIdentityProviderConfigsResponse]

      def listNodegroups(
        request: ListNodegroupsRequest
      ): F[ListNodegroupsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listUpdates(
        request: ListUpdatesRequest
      ): F[ListUpdatesResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAddon(
        request: UpdateAddonRequest
      ): F[UpdateAddonResponse]

      def updateClusterConfig(
        request: UpdateClusterConfigRequest
      ): F[UpdateClusterConfigResponse]

      def updateClusterVersion(
        request: UpdateClusterVersionRequest
      ): F[UpdateClusterVersionResponse]

      def updateNodegroupConfig(
        request: UpdateNodegroupConfigRequest
      ): F[UpdateNodegroupConfigResponse]

      def updateNodegroupVersion(
        request: UpdateNodegroupVersionRequest
      ): F[UpdateNodegroupVersionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends EksOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateEncryptionConfigOp(
      request: AssociateEncryptionConfigRequest
    ) extends EksOp[AssociateEncryptionConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateEncryptionConfigResponse] =
        visitor.associateEncryptionConfig(request)
    }

    final case class AssociateIdentityProviderConfigOp(
      request: AssociateIdentityProviderConfigRequest
    ) extends EksOp[AssociateIdentityProviderConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateIdentityProviderConfigResponse] =
        visitor.associateIdentityProviderConfig(request)
    }

    final case class CreateAddonOp(
      request: CreateAddonRequest
    ) extends EksOp[CreateAddonResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAddonResponse] =
        visitor.createAddon(request)
    }

    final case class CreateClusterOp(
      request: CreateClusterRequest
    ) extends EksOp[CreateClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateClusterResponse] =
        visitor.createCluster(request)
    }

    final case class CreateFargateProfileOp(
      request: CreateFargateProfileRequest
    ) extends EksOp[CreateFargateProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFargateProfileResponse] =
        visitor.createFargateProfile(request)
    }

    final case class CreateNodegroupOp(
      request: CreateNodegroupRequest
    ) extends EksOp[CreateNodegroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateNodegroupResponse] =
        visitor.createNodegroup(request)
    }

    final case class DeleteAddonOp(
      request: DeleteAddonRequest
    ) extends EksOp[DeleteAddonResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAddonResponse] =
        visitor.deleteAddon(request)
    }

    final case class DeleteClusterOp(
      request: DeleteClusterRequest
    ) extends EksOp[DeleteClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteClusterResponse] =
        visitor.deleteCluster(request)
    }

    final case class DeleteFargateProfileOp(
      request: DeleteFargateProfileRequest
    ) extends EksOp[DeleteFargateProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFargateProfileResponse] =
        visitor.deleteFargateProfile(request)
    }

    final case class DeleteNodegroupOp(
      request: DeleteNodegroupRequest
    ) extends EksOp[DeleteNodegroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNodegroupResponse] =
        visitor.deleteNodegroup(request)
    }

    final case class DescribeAddonOp(
      request: DescribeAddonRequest
    ) extends EksOp[DescribeAddonResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAddonResponse] =
        visitor.describeAddon(request)
    }

    final case class DescribeAddonVersionsOp(
      request: DescribeAddonVersionsRequest
    ) extends EksOp[DescribeAddonVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAddonVersionsResponse] =
        visitor.describeAddonVersions(request)
    }

    final case class DescribeClusterOp(
      request: DescribeClusterRequest
    ) extends EksOp[DescribeClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClusterResponse] =
        visitor.describeCluster(request)
    }

    final case class DescribeFargateProfileOp(
      request: DescribeFargateProfileRequest
    ) extends EksOp[DescribeFargateProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFargateProfileResponse] =
        visitor.describeFargateProfile(request)
    }

    final case class DescribeIdentityProviderConfigOp(
      request: DescribeIdentityProviderConfigRequest
    ) extends EksOp[DescribeIdentityProviderConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeIdentityProviderConfigResponse] =
        visitor.describeIdentityProviderConfig(request)
    }

    final case class DescribeNodegroupOp(
      request: DescribeNodegroupRequest
    ) extends EksOp[DescribeNodegroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNodegroupResponse] =
        visitor.describeNodegroup(request)
    }

    final case class DescribeUpdateOp(
      request: DescribeUpdateRequest
    ) extends EksOp[DescribeUpdateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUpdateResponse] =
        visitor.describeUpdate(request)
    }

    final case class DisassociateIdentityProviderConfigOp(
      request: DisassociateIdentityProviderConfigRequest
    ) extends EksOp[DisassociateIdentityProviderConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateIdentityProviderConfigResponse] =
        visitor.disassociateIdentityProviderConfig(request)
    }

    final case class ListAddonsOp(
      request: ListAddonsRequest
    ) extends EksOp[ListAddonsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAddonsResponse] =
        visitor.listAddons(request)
    }

    final case class ListClustersOp(
      request: ListClustersRequest
    ) extends EksOp[ListClustersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListClustersResponse] =
        visitor.listClusters(request)
    }

    final case class ListFargateProfilesOp(
      request: ListFargateProfilesRequest
    ) extends EksOp[ListFargateProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFargateProfilesResponse] =
        visitor.listFargateProfiles(request)
    }

    final case class ListIdentityProviderConfigsOp(
      request: ListIdentityProviderConfigsRequest
    ) extends EksOp[ListIdentityProviderConfigsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIdentityProviderConfigsResponse] =
        visitor.listIdentityProviderConfigs(request)
    }

    final case class ListNodegroupsOp(
      request: ListNodegroupsRequest
    ) extends EksOp[ListNodegroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListNodegroupsResponse] =
        visitor.listNodegroups(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends EksOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListUpdatesOp(
      request: ListUpdatesRequest
    ) extends EksOp[ListUpdatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUpdatesResponse] =
        visitor.listUpdates(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends EksOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends EksOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAddonOp(
      request: UpdateAddonRequest
    ) extends EksOp[UpdateAddonResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAddonResponse] =
        visitor.updateAddon(request)
    }

    final case class UpdateClusterConfigOp(
      request: UpdateClusterConfigRequest
    ) extends EksOp[UpdateClusterConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateClusterConfigResponse] =
        visitor.updateClusterConfig(request)
    }

    final case class UpdateClusterVersionOp(
      request: UpdateClusterVersionRequest
    ) extends EksOp[UpdateClusterVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateClusterVersionResponse] =
        visitor.updateClusterVersion(request)
    }

    final case class UpdateNodegroupConfigOp(
      request: UpdateNodegroupConfigRequest
    ) extends EksOp[UpdateNodegroupConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateNodegroupConfigResponse] =
        visitor.updateNodegroupConfig(request)
    }

    final case class UpdateNodegroupVersionOp(
      request: UpdateNodegroupVersionRequest
    ) extends EksOp[UpdateNodegroupVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateNodegroupVersionResponse] =
        visitor.updateNodegroupVersion(request)
    }
  }

  import EksOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[EksOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateEncryptionConfig(
    request: AssociateEncryptionConfigRequest
  ): EksIO[AssociateEncryptionConfigResponse] =
    FF.liftF(AssociateEncryptionConfigOp(request))

  def associateIdentityProviderConfig(
    request: AssociateIdentityProviderConfigRequest
  ): EksIO[AssociateIdentityProviderConfigResponse] =
    FF.liftF(AssociateIdentityProviderConfigOp(request))

  def createAddon(
    request: CreateAddonRequest
  ): EksIO[CreateAddonResponse] =
    FF.liftF(CreateAddonOp(request))

  def createCluster(
    request: CreateClusterRequest
  ): EksIO[CreateClusterResponse] =
    FF.liftF(CreateClusterOp(request))

  def createFargateProfile(
    request: CreateFargateProfileRequest
  ): EksIO[CreateFargateProfileResponse] =
    FF.liftF(CreateFargateProfileOp(request))

  def createNodegroup(
    request: CreateNodegroupRequest
  ): EksIO[CreateNodegroupResponse] =
    FF.liftF(CreateNodegroupOp(request))

  def deleteAddon(
    request: DeleteAddonRequest
  ): EksIO[DeleteAddonResponse] =
    FF.liftF(DeleteAddonOp(request))

  def deleteCluster(
    request: DeleteClusterRequest
  ): EksIO[DeleteClusterResponse] =
    FF.liftF(DeleteClusterOp(request))

  def deleteFargateProfile(
    request: DeleteFargateProfileRequest
  ): EksIO[DeleteFargateProfileResponse] =
    FF.liftF(DeleteFargateProfileOp(request))

  def deleteNodegroup(
    request: DeleteNodegroupRequest
  ): EksIO[DeleteNodegroupResponse] =
    FF.liftF(DeleteNodegroupOp(request))

  def describeAddon(
    request: DescribeAddonRequest
  ): EksIO[DescribeAddonResponse] =
    FF.liftF(DescribeAddonOp(request))

  def describeAddonVersions(
    request: DescribeAddonVersionsRequest
  ): EksIO[DescribeAddonVersionsResponse] =
    FF.liftF(DescribeAddonVersionsOp(request))

  def describeCluster(
    request: DescribeClusterRequest
  ): EksIO[DescribeClusterResponse] =
    FF.liftF(DescribeClusterOp(request))

  def describeFargateProfile(
    request: DescribeFargateProfileRequest
  ): EksIO[DescribeFargateProfileResponse] =
    FF.liftF(DescribeFargateProfileOp(request))

  def describeIdentityProviderConfig(
    request: DescribeIdentityProviderConfigRequest
  ): EksIO[DescribeIdentityProviderConfigResponse] =
    FF.liftF(DescribeIdentityProviderConfigOp(request))

  def describeNodegroup(
    request: DescribeNodegroupRequest
  ): EksIO[DescribeNodegroupResponse] =
    FF.liftF(DescribeNodegroupOp(request))

  def describeUpdate(
    request: DescribeUpdateRequest
  ): EksIO[DescribeUpdateResponse] =
    FF.liftF(DescribeUpdateOp(request))

  def disassociateIdentityProviderConfig(
    request: DisassociateIdentityProviderConfigRequest
  ): EksIO[DisassociateIdentityProviderConfigResponse] =
    FF.liftF(DisassociateIdentityProviderConfigOp(request))

  def listAddons(
    request: ListAddonsRequest
  ): EksIO[ListAddonsResponse] =
    FF.liftF(ListAddonsOp(request))

  def listClusters(
    request: ListClustersRequest
  ): EksIO[ListClustersResponse] =
    FF.liftF(ListClustersOp(request))

  def listFargateProfiles(
    request: ListFargateProfilesRequest
  ): EksIO[ListFargateProfilesResponse] =
    FF.liftF(ListFargateProfilesOp(request))

  def listIdentityProviderConfigs(
    request: ListIdentityProviderConfigsRequest
  ): EksIO[ListIdentityProviderConfigsResponse] =
    FF.liftF(ListIdentityProviderConfigsOp(request))

  def listNodegroups(
    request: ListNodegroupsRequest
  ): EksIO[ListNodegroupsResponse] =
    FF.liftF(ListNodegroupsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): EksIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listUpdates(
    request: ListUpdatesRequest
  ): EksIO[ListUpdatesResponse] =
    FF.liftF(ListUpdatesOp(request))

  def tagResource(
    request: TagResourceRequest
  ): EksIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): EksIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAddon(
    request: UpdateAddonRequest
  ): EksIO[UpdateAddonResponse] =
    FF.liftF(UpdateAddonOp(request))

  def updateClusterConfig(
    request: UpdateClusterConfigRequest
  ): EksIO[UpdateClusterConfigResponse] =
    FF.liftF(UpdateClusterConfigOp(request))

  def updateClusterVersion(
    request: UpdateClusterVersionRequest
  ): EksIO[UpdateClusterVersionResponse] =
    FF.liftF(UpdateClusterVersionOp(request))

  def updateNodegroupConfig(
    request: UpdateNodegroupConfigRequest
  ): EksIO[UpdateNodegroupConfigResponse] =
    FF.liftF(UpdateNodegroupConfigOp(request))

  def updateNodegroupVersion(
    request: UpdateNodegroupVersionRequest
  ): EksIO[UpdateNodegroupVersionResponse] =
    FF.liftF(UpdateNodegroupVersionOp(request))
}
