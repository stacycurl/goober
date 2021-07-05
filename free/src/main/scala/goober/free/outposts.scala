package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.outposts.OutpostsClient
import software.amazon.awssdk.services.outposts.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object outposts { module =>

  // Free monad over OutpostsOp
  type OutpostsIO[A] = FF[OutpostsOp, A]

  sealed trait OutpostsOp[A] {
    def visit[F[_]](visitor: OutpostsOp.Visitor[F]): F[A]
  }

  object OutpostsOp {
    // Given a OutpostsClient we can embed a OutpostsIO program in any algebra that understands embedding.
    implicit val OutpostsOpEmbeddable: Embeddable[OutpostsOp, OutpostsClient] = new Embeddable[OutpostsOp, OutpostsClient] {
      def embed[A](client: OutpostsClient, io: OutpostsIO[A]): Embedded[A] = Embedded.Outposts(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends OutpostsOp.Visitor[Kleisli[M, OutpostsClient, *]] {
        def createOutpost(
          request: CreateOutpostRequest
        ): Kleisli[M, OutpostsClient, CreateOutpostResponse] =
          primitive(_.createOutpost(request))

        def deleteOutpost(
          request: DeleteOutpostRequest
        ): Kleisli[M, OutpostsClient, DeleteOutpostResponse] =
          primitive(_.deleteOutpost(request))

        def deleteSite(
          request: DeleteSiteRequest
        ): Kleisli[M, OutpostsClient, DeleteSiteResponse] =
          primitive(_.deleteSite(request))

        def getOutpost(
          request: GetOutpostRequest
        ): Kleisli[M, OutpostsClient, GetOutpostResponse] =
          primitive(_.getOutpost(request))

        def getOutpostInstanceTypes(
          request: GetOutpostInstanceTypesRequest
        ): Kleisli[M, OutpostsClient, GetOutpostInstanceTypesResponse] =
          primitive(_.getOutpostInstanceTypes(request))

        def listOutposts(
          request: ListOutpostsRequest
        ): Kleisli[M, OutpostsClient, ListOutpostsResponse] =
          primitive(_.listOutposts(request))

        def listSites(
          request: ListSitesRequest
        ): Kleisli[M, OutpostsClient, ListSitesResponse] =
          primitive(_.listSites(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, OutpostsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, OutpostsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, OutpostsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: OutpostsClient => A
        ): Kleisli[M, OutpostsClient, A]
      }
    }

    trait Visitor[F[_]] extends (OutpostsOp ~> F) {
      final def apply[A](op: OutpostsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createOutpost(
        request: CreateOutpostRequest
      ): F[CreateOutpostResponse]

      def deleteOutpost(
        request: DeleteOutpostRequest
      ): F[DeleteOutpostResponse]

      def deleteSite(
        request: DeleteSiteRequest
      ): F[DeleteSiteResponse]

      def getOutpost(
        request: GetOutpostRequest
      ): F[GetOutpostResponse]

      def getOutpostInstanceTypes(
        request: GetOutpostInstanceTypesRequest
      ): F[GetOutpostInstanceTypesResponse]

      def listOutposts(
        request: ListOutpostsRequest
      ): F[ListOutpostsResponse]

      def listSites(
        request: ListSitesRequest
      ): F[ListSitesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends OutpostsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateOutpostOp(
      request: CreateOutpostRequest
    ) extends OutpostsOp[CreateOutpostResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateOutpostResponse] =
        visitor.createOutpost(request)
    }

    final case class DeleteOutpostOp(
      request: DeleteOutpostRequest
    ) extends OutpostsOp[DeleteOutpostResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteOutpostResponse] =
        visitor.deleteOutpost(request)
    }

    final case class DeleteSiteOp(
      request: DeleteSiteRequest
    ) extends OutpostsOp[DeleteSiteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSiteResponse] =
        visitor.deleteSite(request)
    }

    final case class GetOutpostOp(
      request: GetOutpostRequest
    ) extends OutpostsOp[GetOutpostResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOutpostResponse] =
        visitor.getOutpost(request)
    }

    final case class GetOutpostInstanceTypesOp(
      request: GetOutpostInstanceTypesRequest
    ) extends OutpostsOp[GetOutpostInstanceTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOutpostInstanceTypesResponse] =
        visitor.getOutpostInstanceTypes(request)
    }

    final case class ListOutpostsOp(
      request: ListOutpostsRequest
    ) extends OutpostsOp[ListOutpostsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOutpostsResponse] =
        visitor.listOutposts(request)
    }

    final case class ListSitesOp(
      request: ListSitesRequest
    ) extends OutpostsOp[ListSitesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSitesResponse] =
        visitor.listSites(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends OutpostsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends OutpostsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends OutpostsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import OutpostsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[OutpostsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createOutpost(
    request: CreateOutpostRequest
  ): OutpostsIO[CreateOutpostResponse] =
    FF.liftF(CreateOutpostOp(request))

  def deleteOutpost(
    request: DeleteOutpostRequest
  ): OutpostsIO[DeleteOutpostResponse] =
    FF.liftF(DeleteOutpostOp(request))

  def deleteSite(
    request: DeleteSiteRequest
  ): OutpostsIO[DeleteSiteResponse] =
    FF.liftF(DeleteSiteOp(request))

  def getOutpost(
    request: GetOutpostRequest
  ): OutpostsIO[GetOutpostResponse] =
    FF.liftF(GetOutpostOp(request))

  def getOutpostInstanceTypes(
    request: GetOutpostInstanceTypesRequest
  ): OutpostsIO[GetOutpostInstanceTypesResponse] =
    FF.liftF(GetOutpostInstanceTypesOp(request))

  def listOutposts(
    request: ListOutpostsRequest
  ): OutpostsIO[ListOutpostsResponse] =
    FF.liftF(ListOutpostsOp(request))

  def listSites(
    request: ListSitesRequest
  ): OutpostsIO[ListSitesResponse] =
    FF.liftF(ListSitesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): OutpostsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): OutpostsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): OutpostsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
