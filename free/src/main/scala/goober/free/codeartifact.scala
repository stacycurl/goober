package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.codeartifact.CodeartifactClient
import software.amazon.awssdk.services.codeartifact.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object codeartifact { module =>

  // Free monad over CodeartifactOp
  type CodeartifactIO[A] = FF[CodeartifactOp, A]

  sealed trait CodeartifactOp[A] {
    def visit[F[_]](visitor: CodeartifactOp.Visitor[F]): F[A]
  }

  object CodeartifactOp {
    // Given a CodeartifactClient we can embed a CodeartifactIO program in any algebra that understands embedding.
    implicit val CodeartifactOpEmbeddable: Embeddable[CodeartifactOp, CodeartifactClient] = new Embeddable[CodeartifactOp, CodeartifactClient] {
      def embed[A](client: CodeartifactClient, io: CodeartifactIO[A]): Embedded[A] = Embedded.Codeartifact(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CodeartifactOp.Visitor[Kleisli[M, CodeartifactClient, *]] {
        def associateExternalConnection(
          request: AssociateExternalConnectionRequest
        ): Kleisli[M, CodeartifactClient, AssociateExternalConnectionResponse] =
          primitive(_.associateExternalConnection(request))

        def copyPackageVersions(
          request: CopyPackageVersionsRequest
        ): Kleisli[M, CodeartifactClient, CopyPackageVersionsResponse] =
          primitive(_.copyPackageVersions(request))

        def createDomain(
          request: CreateDomainRequest
        ): Kleisli[M, CodeartifactClient, CreateDomainResponse] =
          primitive(_.createDomain(request))

        def createRepository(
          request: CreateRepositoryRequest
        ): Kleisli[M, CodeartifactClient, CreateRepositoryResponse] =
          primitive(_.createRepository(request))

        def deleteDomain(
          request: DeleteDomainRequest
        ): Kleisli[M, CodeartifactClient, DeleteDomainResponse] =
          primitive(_.deleteDomain(request))

        def deleteDomainPermissionsPolicy(
          request: DeleteDomainPermissionsPolicyRequest
        ): Kleisli[M, CodeartifactClient, DeleteDomainPermissionsPolicyResponse] =
          primitive(_.deleteDomainPermissionsPolicy(request))

        def deletePackageVersions(
          request: DeletePackageVersionsRequest
        ): Kleisli[M, CodeartifactClient, DeletePackageVersionsResponse] =
          primitive(_.deletePackageVersions(request))

        def deleteRepository(
          request: DeleteRepositoryRequest
        ): Kleisli[M, CodeartifactClient, DeleteRepositoryResponse] =
          primitive(_.deleteRepository(request))

        def deleteRepositoryPermissionsPolicy(
          request: DeleteRepositoryPermissionsPolicyRequest
        ): Kleisli[M, CodeartifactClient, DeleteRepositoryPermissionsPolicyResponse] =
          primitive(_.deleteRepositoryPermissionsPolicy(request))

        def describeDomain(
          request: DescribeDomainRequest
        ): Kleisli[M, CodeartifactClient, DescribeDomainResponse] =
          primitive(_.describeDomain(request))

        def describePackageVersion(
          request: DescribePackageVersionRequest
        ): Kleisli[M, CodeartifactClient, DescribePackageVersionResponse] =
          primitive(_.describePackageVersion(request))

        def describeRepository(
          request: DescribeRepositoryRequest
        ): Kleisli[M, CodeartifactClient, DescribeRepositoryResponse] =
          primitive(_.describeRepository(request))

        def disassociateExternalConnection(
          request: DisassociateExternalConnectionRequest
        ): Kleisli[M, CodeartifactClient, DisassociateExternalConnectionResponse] =
          primitive(_.disassociateExternalConnection(request))

        def disposePackageVersions(
          request: DisposePackageVersionsRequest
        ): Kleisli[M, CodeartifactClient, DisposePackageVersionsResponse] =
          primitive(_.disposePackageVersions(request))

        def getAuthorizationToken(
          request: GetAuthorizationTokenRequest
        ): Kleisli[M, CodeartifactClient, GetAuthorizationTokenResponse] =
          primitive(_.getAuthorizationToken(request))

        def getDomainPermissionsPolicy(
          request: GetDomainPermissionsPolicyRequest
        ): Kleisli[M, CodeartifactClient, GetDomainPermissionsPolicyResponse] =
          primitive(_.getDomainPermissionsPolicy(request))

        def getPackageVersionAsset(
          request: GetPackageVersionAssetRequest,
          path: Path
        ): Kleisli[M, CodeartifactClient, GetPackageVersionAssetResponse] =
          primitive(_.getPackageVersionAsset(request, path))

        def getPackageVersionReadme(
          request: GetPackageVersionReadmeRequest
        ): Kleisli[M, CodeartifactClient, GetPackageVersionReadmeResponse] =
          primitive(_.getPackageVersionReadme(request))

        def getRepositoryEndpoint(
          request: GetRepositoryEndpointRequest
        ): Kleisli[M, CodeartifactClient, GetRepositoryEndpointResponse] =
          primitive(_.getRepositoryEndpoint(request))

        def getRepositoryPermissionsPolicy(
          request: GetRepositoryPermissionsPolicyRequest
        ): Kleisli[M, CodeartifactClient, GetRepositoryPermissionsPolicyResponse] =
          primitive(_.getRepositoryPermissionsPolicy(request))

        def listDomains(
          request: ListDomainsRequest
        ): Kleisli[M, CodeartifactClient, ListDomainsResponse] =
          primitive(_.listDomains(request))

        def listPackageVersionAssets(
          request: ListPackageVersionAssetsRequest
        ): Kleisli[M, CodeartifactClient, ListPackageVersionAssetsResponse] =
          primitive(_.listPackageVersionAssets(request))

        def listPackageVersionDependencies(
          request: ListPackageVersionDependenciesRequest
        ): Kleisli[M, CodeartifactClient, ListPackageVersionDependenciesResponse] =
          primitive(_.listPackageVersionDependencies(request))

        def listPackageVersions(
          request: ListPackageVersionsRequest
        ): Kleisli[M, CodeartifactClient, ListPackageVersionsResponse] =
          primitive(_.listPackageVersions(request))

        def listPackages(
          request: ListPackagesRequest
        ): Kleisli[M, CodeartifactClient, ListPackagesResponse] =
          primitive(_.listPackages(request))

        def listRepositories(
          request: ListRepositoriesRequest
        ): Kleisli[M, CodeartifactClient, ListRepositoriesResponse] =
          primitive(_.listRepositories(request))

        def listRepositoriesInDomain(
          request: ListRepositoriesInDomainRequest
        ): Kleisli[M, CodeartifactClient, ListRepositoriesInDomainResponse] =
          primitive(_.listRepositoriesInDomain(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, CodeartifactClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putDomainPermissionsPolicy(
          request: PutDomainPermissionsPolicyRequest
        ): Kleisli[M, CodeartifactClient, PutDomainPermissionsPolicyResponse] =
          primitive(_.putDomainPermissionsPolicy(request))

        def putRepositoryPermissionsPolicy(
          request: PutRepositoryPermissionsPolicyRequest
        ): Kleisli[M, CodeartifactClient, PutRepositoryPermissionsPolicyResponse] =
          primitive(_.putRepositoryPermissionsPolicy(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, CodeartifactClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, CodeartifactClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updatePackageVersionsStatus(
          request: UpdatePackageVersionsStatusRequest
        ): Kleisli[M, CodeartifactClient, UpdatePackageVersionsStatusResponse] =
          primitive(_.updatePackageVersionsStatus(request))

        def updateRepository(
          request: UpdateRepositoryRequest
        ): Kleisli[M, CodeartifactClient, UpdateRepositoryResponse] =
          primitive(_.updateRepository(request))

        def primitive[A](
          f: CodeartifactClient => A
        ): Kleisli[M, CodeartifactClient, A]
      }
    }

    trait Visitor[F[_]] extends (CodeartifactOp ~> F) {
      final def apply[A](op: CodeartifactOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateExternalConnection(
        request: AssociateExternalConnectionRequest
      ): F[AssociateExternalConnectionResponse]

      def copyPackageVersions(
        request: CopyPackageVersionsRequest
      ): F[CopyPackageVersionsResponse]

      def createDomain(
        request: CreateDomainRequest
      ): F[CreateDomainResponse]

      def createRepository(
        request: CreateRepositoryRequest
      ): F[CreateRepositoryResponse]

      def deleteDomain(
        request: DeleteDomainRequest
      ): F[DeleteDomainResponse]

      def deleteDomainPermissionsPolicy(
        request: DeleteDomainPermissionsPolicyRequest
      ): F[DeleteDomainPermissionsPolicyResponse]

      def deletePackageVersions(
        request: DeletePackageVersionsRequest
      ): F[DeletePackageVersionsResponse]

      def deleteRepository(
        request: DeleteRepositoryRequest
      ): F[DeleteRepositoryResponse]

      def deleteRepositoryPermissionsPolicy(
        request: DeleteRepositoryPermissionsPolicyRequest
      ): F[DeleteRepositoryPermissionsPolicyResponse]

      def describeDomain(
        request: DescribeDomainRequest
      ): F[DescribeDomainResponse]

      def describePackageVersion(
        request: DescribePackageVersionRequest
      ): F[DescribePackageVersionResponse]

      def describeRepository(
        request: DescribeRepositoryRequest
      ): F[DescribeRepositoryResponse]

      def disassociateExternalConnection(
        request: DisassociateExternalConnectionRequest
      ): F[DisassociateExternalConnectionResponse]

      def disposePackageVersions(
        request: DisposePackageVersionsRequest
      ): F[DisposePackageVersionsResponse]

      def getAuthorizationToken(
        request: GetAuthorizationTokenRequest
      ): F[GetAuthorizationTokenResponse]

      def getDomainPermissionsPolicy(
        request: GetDomainPermissionsPolicyRequest
      ): F[GetDomainPermissionsPolicyResponse]

      def getPackageVersionAsset(
        request: GetPackageVersionAssetRequest,
        path: Path
      ): F[GetPackageVersionAssetResponse]

      def getPackageVersionReadme(
        request: GetPackageVersionReadmeRequest
      ): F[GetPackageVersionReadmeResponse]

      def getRepositoryEndpoint(
        request: GetRepositoryEndpointRequest
      ): F[GetRepositoryEndpointResponse]

      def getRepositoryPermissionsPolicy(
        request: GetRepositoryPermissionsPolicyRequest
      ): F[GetRepositoryPermissionsPolicyResponse]

      def listDomains(
        request: ListDomainsRequest
      ): F[ListDomainsResponse]

      def listPackageVersionAssets(
        request: ListPackageVersionAssetsRequest
      ): F[ListPackageVersionAssetsResponse]

      def listPackageVersionDependencies(
        request: ListPackageVersionDependenciesRequest
      ): F[ListPackageVersionDependenciesResponse]

      def listPackageVersions(
        request: ListPackageVersionsRequest
      ): F[ListPackageVersionsResponse]

      def listPackages(
        request: ListPackagesRequest
      ): F[ListPackagesResponse]

      def listRepositories(
        request: ListRepositoriesRequest
      ): F[ListRepositoriesResponse]

      def listRepositoriesInDomain(
        request: ListRepositoriesInDomainRequest
      ): F[ListRepositoriesInDomainResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putDomainPermissionsPolicy(
        request: PutDomainPermissionsPolicyRequest
      ): F[PutDomainPermissionsPolicyResponse]

      def putRepositoryPermissionsPolicy(
        request: PutRepositoryPermissionsPolicyRequest
      ): F[PutRepositoryPermissionsPolicyResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updatePackageVersionsStatus(
        request: UpdatePackageVersionsStatusRequest
      ): F[UpdatePackageVersionsStatusResponse]

      def updateRepository(
        request: UpdateRepositoryRequest
      ): F[UpdateRepositoryResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CodeartifactOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateExternalConnectionOp(
      request: AssociateExternalConnectionRequest
    ) extends CodeartifactOp[AssociateExternalConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateExternalConnectionResponse] =
        visitor.associateExternalConnection(request)
    }

    final case class CopyPackageVersionsOp(
      request: CopyPackageVersionsRequest
    ) extends CodeartifactOp[CopyPackageVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyPackageVersionsResponse] =
        visitor.copyPackageVersions(request)
    }

    final case class CreateDomainOp(
      request: CreateDomainRequest
    ) extends CodeartifactOp[CreateDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDomainResponse] =
        visitor.createDomain(request)
    }

    final case class CreateRepositoryOp(
      request: CreateRepositoryRequest
    ) extends CodeartifactOp[CreateRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRepositoryResponse] =
        visitor.createRepository(request)
    }

    final case class DeleteDomainOp(
      request: DeleteDomainRequest
    ) extends CodeartifactOp[DeleteDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDomainResponse] =
        visitor.deleteDomain(request)
    }

    final case class DeleteDomainPermissionsPolicyOp(
      request: DeleteDomainPermissionsPolicyRequest
    ) extends CodeartifactOp[DeleteDomainPermissionsPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDomainPermissionsPolicyResponse] =
        visitor.deleteDomainPermissionsPolicy(request)
    }

    final case class DeletePackageVersionsOp(
      request: DeletePackageVersionsRequest
    ) extends CodeartifactOp[DeletePackageVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePackageVersionsResponse] =
        visitor.deletePackageVersions(request)
    }

    final case class DeleteRepositoryOp(
      request: DeleteRepositoryRequest
    ) extends CodeartifactOp[DeleteRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRepositoryResponse] =
        visitor.deleteRepository(request)
    }

    final case class DeleteRepositoryPermissionsPolicyOp(
      request: DeleteRepositoryPermissionsPolicyRequest
    ) extends CodeartifactOp[DeleteRepositoryPermissionsPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRepositoryPermissionsPolicyResponse] =
        visitor.deleteRepositoryPermissionsPolicy(request)
    }

    final case class DescribeDomainOp(
      request: DescribeDomainRequest
    ) extends CodeartifactOp[DescribeDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDomainResponse] =
        visitor.describeDomain(request)
    }

    final case class DescribePackageVersionOp(
      request: DescribePackageVersionRequest
    ) extends CodeartifactOp[DescribePackageVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePackageVersionResponse] =
        visitor.describePackageVersion(request)
    }

    final case class DescribeRepositoryOp(
      request: DescribeRepositoryRequest
    ) extends CodeartifactOp[DescribeRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRepositoryResponse] =
        visitor.describeRepository(request)
    }

    final case class DisassociateExternalConnectionOp(
      request: DisassociateExternalConnectionRequest
    ) extends CodeartifactOp[DisassociateExternalConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateExternalConnectionResponse] =
        visitor.disassociateExternalConnection(request)
    }

    final case class DisposePackageVersionsOp(
      request: DisposePackageVersionsRequest
    ) extends CodeartifactOp[DisposePackageVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisposePackageVersionsResponse] =
        visitor.disposePackageVersions(request)
    }

    final case class GetAuthorizationTokenOp(
      request: GetAuthorizationTokenRequest
    ) extends CodeartifactOp[GetAuthorizationTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAuthorizationTokenResponse] =
        visitor.getAuthorizationToken(request)
    }

    final case class GetDomainPermissionsPolicyOp(
      request: GetDomainPermissionsPolicyRequest
    ) extends CodeartifactOp[GetDomainPermissionsPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDomainPermissionsPolicyResponse] =
        visitor.getDomainPermissionsPolicy(request)
    }

    final case class GetPackageVersionAssetOp(
      request: GetPackageVersionAssetRequest,
      path: Path
    ) extends CodeartifactOp[GetPackageVersionAssetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPackageVersionAssetResponse] =
        visitor.getPackageVersionAsset(request, path)
    }

    final case class GetPackageVersionReadmeOp(
      request: GetPackageVersionReadmeRequest
    ) extends CodeartifactOp[GetPackageVersionReadmeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPackageVersionReadmeResponse] =
        visitor.getPackageVersionReadme(request)
    }

    final case class GetRepositoryEndpointOp(
      request: GetRepositoryEndpointRequest
    ) extends CodeartifactOp[GetRepositoryEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRepositoryEndpointResponse] =
        visitor.getRepositoryEndpoint(request)
    }

    final case class GetRepositoryPermissionsPolicyOp(
      request: GetRepositoryPermissionsPolicyRequest
    ) extends CodeartifactOp[GetRepositoryPermissionsPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRepositoryPermissionsPolicyResponse] =
        visitor.getRepositoryPermissionsPolicy(request)
    }

    final case class ListDomainsOp(
      request: ListDomainsRequest
    ) extends CodeartifactOp[ListDomainsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDomainsResponse] =
        visitor.listDomains(request)
    }

    final case class ListPackageVersionAssetsOp(
      request: ListPackageVersionAssetsRequest
    ) extends CodeartifactOp[ListPackageVersionAssetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPackageVersionAssetsResponse] =
        visitor.listPackageVersionAssets(request)
    }

    final case class ListPackageVersionDependenciesOp(
      request: ListPackageVersionDependenciesRequest
    ) extends CodeartifactOp[ListPackageVersionDependenciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPackageVersionDependenciesResponse] =
        visitor.listPackageVersionDependencies(request)
    }

    final case class ListPackageVersionsOp(
      request: ListPackageVersionsRequest
    ) extends CodeartifactOp[ListPackageVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPackageVersionsResponse] =
        visitor.listPackageVersions(request)
    }

    final case class ListPackagesOp(
      request: ListPackagesRequest
    ) extends CodeartifactOp[ListPackagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPackagesResponse] =
        visitor.listPackages(request)
    }

    final case class ListRepositoriesOp(
      request: ListRepositoriesRequest
    ) extends CodeartifactOp[ListRepositoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRepositoriesResponse] =
        visitor.listRepositories(request)
    }

    final case class ListRepositoriesInDomainOp(
      request: ListRepositoriesInDomainRequest
    ) extends CodeartifactOp[ListRepositoriesInDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRepositoriesInDomainResponse] =
        visitor.listRepositoriesInDomain(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends CodeartifactOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutDomainPermissionsPolicyOp(
      request: PutDomainPermissionsPolicyRequest
    ) extends CodeartifactOp[PutDomainPermissionsPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutDomainPermissionsPolicyResponse] =
        visitor.putDomainPermissionsPolicy(request)
    }

    final case class PutRepositoryPermissionsPolicyOp(
      request: PutRepositoryPermissionsPolicyRequest
    ) extends CodeartifactOp[PutRepositoryPermissionsPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRepositoryPermissionsPolicyResponse] =
        visitor.putRepositoryPermissionsPolicy(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends CodeartifactOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends CodeartifactOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdatePackageVersionsStatusOp(
      request: UpdatePackageVersionsStatusRequest
    ) extends CodeartifactOp[UpdatePackageVersionsStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePackageVersionsStatusResponse] =
        visitor.updatePackageVersionsStatus(request)
    }

    final case class UpdateRepositoryOp(
      request: UpdateRepositoryRequest
    ) extends CodeartifactOp[UpdateRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRepositoryResponse] =
        visitor.updateRepository(request)
    }
  }

  import CodeartifactOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CodeartifactOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateExternalConnection(
    request: AssociateExternalConnectionRequest
  ): CodeartifactIO[AssociateExternalConnectionResponse] =
    FF.liftF(AssociateExternalConnectionOp(request))

  def copyPackageVersions(
    request: CopyPackageVersionsRequest
  ): CodeartifactIO[CopyPackageVersionsResponse] =
    FF.liftF(CopyPackageVersionsOp(request))

  def createDomain(
    request: CreateDomainRequest
  ): CodeartifactIO[CreateDomainResponse] =
    FF.liftF(CreateDomainOp(request))

  def createRepository(
    request: CreateRepositoryRequest
  ): CodeartifactIO[CreateRepositoryResponse] =
    FF.liftF(CreateRepositoryOp(request))

  def deleteDomain(
    request: DeleteDomainRequest
  ): CodeartifactIO[DeleteDomainResponse] =
    FF.liftF(DeleteDomainOp(request))

  def deleteDomainPermissionsPolicy(
    request: DeleteDomainPermissionsPolicyRequest
  ): CodeartifactIO[DeleteDomainPermissionsPolicyResponse] =
    FF.liftF(DeleteDomainPermissionsPolicyOp(request))

  def deletePackageVersions(
    request: DeletePackageVersionsRequest
  ): CodeartifactIO[DeletePackageVersionsResponse] =
    FF.liftF(DeletePackageVersionsOp(request))

  def deleteRepository(
    request: DeleteRepositoryRequest
  ): CodeartifactIO[DeleteRepositoryResponse] =
    FF.liftF(DeleteRepositoryOp(request))

  def deleteRepositoryPermissionsPolicy(
    request: DeleteRepositoryPermissionsPolicyRequest
  ): CodeartifactIO[DeleteRepositoryPermissionsPolicyResponse] =
    FF.liftF(DeleteRepositoryPermissionsPolicyOp(request))

  def describeDomain(
    request: DescribeDomainRequest
  ): CodeartifactIO[DescribeDomainResponse] =
    FF.liftF(DescribeDomainOp(request))

  def describePackageVersion(
    request: DescribePackageVersionRequest
  ): CodeartifactIO[DescribePackageVersionResponse] =
    FF.liftF(DescribePackageVersionOp(request))

  def describeRepository(
    request: DescribeRepositoryRequest
  ): CodeartifactIO[DescribeRepositoryResponse] =
    FF.liftF(DescribeRepositoryOp(request))

  def disassociateExternalConnection(
    request: DisassociateExternalConnectionRequest
  ): CodeartifactIO[DisassociateExternalConnectionResponse] =
    FF.liftF(DisassociateExternalConnectionOp(request))

  def disposePackageVersions(
    request: DisposePackageVersionsRequest
  ): CodeartifactIO[DisposePackageVersionsResponse] =
    FF.liftF(DisposePackageVersionsOp(request))

  def getAuthorizationToken(
    request: GetAuthorizationTokenRequest
  ): CodeartifactIO[GetAuthorizationTokenResponse] =
    FF.liftF(GetAuthorizationTokenOp(request))

  def getDomainPermissionsPolicy(
    request: GetDomainPermissionsPolicyRequest
  ): CodeartifactIO[GetDomainPermissionsPolicyResponse] =
    FF.liftF(GetDomainPermissionsPolicyOp(request))

  def getPackageVersionAsset(
    request: GetPackageVersionAssetRequest,
    path: Path
  ): CodeartifactIO[GetPackageVersionAssetResponse] =
    FF.liftF(GetPackageVersionAssetOp(request, path))

  def getPackageVersionReadme(
    request: GetPackageVersionReadmeRequest
  ): CodeartifactIO[GetPackageVersionReadmeResponse] =
    FF.liftF(GetPackageVersionReadmeOp(request))

  def getRepositoryEndpoint(
    request: GetRepositoryEndpointRequest
  ): CodeartifactIO[GetRepositoryEndpointResponse] =
    FF.liftF(GetRepositoryEndpointOp(request))

  def getRepositoryPermissionsPolicy(
    request: GetRepositoryPermissionsPolicyRequest
  ): CodeartifactIO[GetRepositoryPermissionsPolicyResponse] =
    FF.liftF(GetRepositoryPermissionsPolicyOp(request))

  def listDomains(
    request: ListDomainsRequest
  ): CodeartifactIO[ListDomainsResponse] =
    FF.liftF(ListDomainsOp(request))

  def listPackageVersionAssets(
    request: ListPackageVersionAssetsRequest
  ): CodeartifactIO[ListPackageVersionAssetsResponse] =
    FF.liftF(ListPackageVersionAssetsOp(request))

  def listPackageVersionDependencies(
    request: ListPackageVersionDependenciesRequest
  ): CodeartifactIO[ListPackageVersionDependenciesResponse] =
    FF.liftF(ListPackageVersionDependenciesOp(request))

  def listPackageVersions(
    request: ListPackageVersionsRequest
  ): CodeartifactIO[ListPackageVersionsResponse] =
    FF.liftF(ListPackageVersionsOp(request))

  def listPackages(
    request: ListPackagesRequest
  ): CodeartifactIO[ListPackagesResponse] =
    FF.liftF(ListPackagesOp(request))

  def listRepositories(
    request: ListRepositoriesRequest
  ): CodeartifactIO[ListRepositoriesResponse] =
    FF.liftF(ListRepositoriesOp(request))

  def listRepositoriesInDomain(
    request: ListRepositoriesInDomainRequest
  ): CodeartifactIO[ListRepositoriesInDomainResponse] =
    FF.liftF(ListRepositoriesInDomainOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): CodeartifactIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putDomainPermissionsPolicy(
    request: PutDomainPermissionsPolicyRequest
  ): CodeartifactIO[PutDomainPermissionsPolicyResponse] =
    FF.liftF(PutDomainPermissionsPolicyOp(request))

  def putRepositoryPermissionsPolicy(
    request: PutRepositoryPermissionsPolicyRequest
  ): CodeartifactIO[PutRepositoryPermissionsPolicyResponse] =
    FF.liftF(PutRepositoryPermissionsPolicyOp(request))

  def tagResource(
    request: TagResourceRequest
  ): CodeartifactIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): CodeartifactIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updatePackageVersionsStatus(
    request: UpdatePackageVersionsStatusRequest
  ): CodeartifactIO[UpdatePackageVersionsStatusResponse] =
    FF.liftF(UpdatePackageVersionsStatusOp(request))

  def updateRepository(
    request: UpdateRepositoryRequest
  ): CodeartifactIO[UpdateRepositoryResponse] =
    FF.liftF(UpdateRepositoryOp(request))
}
