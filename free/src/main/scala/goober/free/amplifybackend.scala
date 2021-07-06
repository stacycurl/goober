package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.amplifybackend.AmplifyBackendClient
import software.amazon.awssdk.services.amplifybackend.model._


object amplifybackend { module =>

  // Free monad over AmplifyBackendOp
  type AmplifyBackendIO[A] = FF[AmplifyBackendOp, A]

  sealed trait AmplifyBackendOp[A] {
    def visit[F[_]](visitor: AmplifyBackendOp.Visitor[F]): F[A]
  }

  object AmplifyBackendOp {
    // Given a AmplifyBackendClient we can embed a AmplifyBackendIO program in any algebra that understands embedding.
    implicit val AmplifyBackendOpEmbeddable: Embeddable[AmplifyBackendOp, AmplifyBackendClient] = new Embeddable[AmplifyBackendOp, AmplifyBackendClient] {
      def embed[A](client: AmplifyBackendClient, io: AmplifyBackendIO[A]): Embedded[A] = Embedded.AmplifyBackend(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends AmplifyBackendOp.Visitor[Kleisli[M, AmplifyBackendClient, *]] {
        def cloneBackend(
          request: CloneBackendRequest
        ): Kleisli[M, AmplifyBackendClient, CloneBackendResponse] =
          primitive(_.cloneBackend(request))

        def createBackend(
          request: CreateBackendRequest
        ): Kleisli[M, AmplifyBackendClient, CreateBackendResponse] =
          primitive(_.createBackend(request))

        def createBackendAPI(
          request: CreateBackendApiRequest
        ): Kleisli[M, AmplifyBackendClient, CreateBackendApiResponse] =
          primitive(_.createBackendAPI(request))

        def createBackendAuth(
          request: CreateBackendAuthRequest
        ): Kleisli[M, AmplifyBackendClient, CreateBackendAuthResponse] =
          primitive(_.createBackendAuth(request))

        def createBackendConfig(
          request: CreateBackendConfigRequest
        ): Kleisli[M, AmplifyBackendClient, CreateBackendConfigResponse] =
          primitive(_.createBackendConfig(request))

        def createToken(
          request: CreateTokenRequest
        ): Kleisli[M, AmplifyBackendClient, CreateTokenResponse] =
          primitive(_.createToken(request))

        def deleteBackend(
          request: DeleteBackendRequest
        ): Kleisli[M, AmplifyBackendClient, DeleteBackendResponse] =
          primitive(_.deleteBackend(request))

        def deleteBackendAPI(
          request: DeleteBackendApiRequest
        ): Kleisli[M, AmplifyBackendClient, DeleteBackendApiResponse] =
          primitive(_.deleteBackendAPI(request))

        def deleteBackendAuth(
          request: DeleteBackendAuthRequest
        ): Kleisli[M, AmplifyBackendClient, DeleteBackendAuthResponse] =
          primitive(_.deleteBackendAuth(request))

        def deleteToken(
          request: DeleteTokenRequest
        ): Kleisli[M, AmplifyBackendClient, DeleteTokenResponse] =
          primitive(_.deleteToken(request))

        def generateBackendAPIModels(
          request: GenerateBackendApiModelsRequest
        ): Kleisli[M, AmplifyBackendClient, GenerateBackendApiModelsResponse] =
          primitive(_.generateBackendAPIModels(request))

        def getBackend(
          request: GetBackendRequest
        ): Kleisli[M, AmplifyBackendClient, GetBackendResponse] =
          primitive(_.getBackend(request))

        def getBackendAPI(
          request: GetBackendApiRequest
        ): Kleisli[M, AmplifyBackendClient, GetBackendApiResponse] =
          primitive(_.getBackendAPI(request))

        def getBackendAPIModels(
          request: GetBackendApiModelsRequest
        ): Kleisli[M, AmplifyBackendClient, GetBackendApiModelsResponse] =
          primitive(_.getBackendAPIModels(request))

        def getBackendAuth(
          request: GetBackendAuthRequest
        ): Kleisli[M, AmplifyBackendClient, GetBackendAuthResponse] =
          primitive(_.getBackendAuth(request))

        def getBackendJob(
          request: GetBackendJobRequest
        ): Kleisli[M, AmplifyBackendClient, GetBackendJobResponse] =
          primitive(_.getBackendJob(request))

        def getToken(
          request: GetTokenRequest
        ): Kleisli[M, AmplifyBackendClient, GetTokenResponse] =
          primitive(_.getToken(request))

        def listBackendJobs(
          request: ListBackendJobsRequest
        ): Kleisli[M, AmplifyBackendClient, ListBackendJobsResponse] =
          primitive(_.listBackendJobs(request))

        def removeAllBackends(
          request: RemoveAllBackendsRequest
        ): Kleisli[M, AmplifyBackendClient, RemoveAllBackendsResponse] =
          primitive(_.removeAllBackends(request))

        def removeBackendConfig(
          request: RemoveBackendConfigRequest
        ): Kleisli[M, AmplifyBackendClient, RemoveBackendConfigResponse] =
          primitive(_.removeBackendConfig(request))

        def updateBackendAPI(
          request: UpdateBackendApiRequest
        ): Kleisli[M, AmplifyBackendClient, UpdateBackendApiResponse] =
          primitive(_.updateBackendAPI(request))

        def updateBackendAuth(
          request: UpdateBackendAuthRequest
        ): Kleisli[M, AmplifyBackendClient, UpdateBackendAuthResponse] =
          primitive(_.updateBackendAuth(request))

        def updateBackendConfig(
          request: UpdateBackendConfigRequest
        ): Kleisli[M, AmplifyBackendClient, UpdateBackendConfigResponse] =
          primitive(_.updateBackendConfig(request))

        def updateBackendJob(
          request: UpdateBackendJobRequest
        ): Kleisli[M, AmplifyBackendClient, UpdateBackendJobResponse] =
          primitive(_.updateBackendJob(request))

        def primitive[A](
          f: AmplifyBackendClient => A
        ): Kleisli[M, AmplifyBackendClient, A]
      }
    }

    trait Visitor[F[_]] extends (AmplifyBackendOp ~> F) {
      final def apply[A](op: AmplifyBackendOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def cloneBackend(
        request: CloneBackendRequest
      ): F[CloneBackendResponse]

      def createBackend(
        request: CreateBackendRequest
      ): F[CreateBackendResponse]

      def createBackendAPI(
        request: CreateBackendApiRequest
      ): F[CreateBackendApiResponse]

      def createBackendAuth(
        request: CreateBackendAuthRequest
      ): F[CreateBackendAuthResponse]

      def createBackendConfig(
        request: CreateBackendConfigRequest
      ): F[CreateBackendConfigResponse]

      def createToken(
        request: CreateTokenRequest
      ): F[CreateTokenResponse]

      def deleteBackend(
        request: DeleteBackendRequest
      ): F[DeleteBackendResponse]

      def deleteBackendAPI(
        request: DeleteBackendApiRequest
      ): F[DeleteBackendApiResponse]

      def deleteBackendAuth(
        request: DeleteBackendAuthRequest
      ): F[DeleteBackendAuthResponse]

      def deleteToken(
        request: DeleteTokenRequest
      ): F[DeleteTokenResponse]

      def generateBackendAPIModels(
        request: GenerateBackendApiModelsRequest
      ): F[GenerateBackendApiModelsResponse]

      def getBackend(
        request: GetBackendRequest
      ): F[GetBackendResponse]

      def getBackendAPI(
        request: GetBackendApiRequest
      ): F[GetBackendApiResponse]

      def getBackendAPIModels(
        request: GetBackendApiModelsRequest
      ): F[GetBackendApiModelsResponse]

      def getBackendAuth(
        request: GetBackendAuthRequest
      ): F[GetBackendAuthResponse]

      def getBackendJob(
        request: GetBackendJobRequest
      ): F[GetBackendJobResponse]

      def getToken(
        request: GetTokenRequest
      ): F[GetTokenResponse]

      def listBackendJobs(
        request: ListBackendJobsRequest
      ): F[ListBackendJobsResponse]

      def removeAllBackends(
        request: RemoveAllBackendsRequest
      ): F[RemoveAllBackendsResponse]

      def removeBackendConfig(
        request: RemoveBackendConfigRequest
      ): F[RemoveBackendConfigResponse]

      def updateBackendAPI(
        request: UpdateBackendApiRequest
      ): F[UpdateBackendApiResponse]

      def updateBackendAuth(
        request: UpdateBackendAuthRequest
      ): F[UpdateBackendAuthResponse]

      def updateBackendConfig(
        request: UpdateBackendConfigRequest
      ): F[UpdateBackendConfigResponse]

      def updateBackendJob(
        request: UpdateBackendJobRequest
      ): F[UpdateBackendJobResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends AmplifyBackendOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CloneBackendOp(
      request: CloneBackendRequest
    ) extends AmplifyBackendOp[CloneBackendResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CloneBackendResponse] =
        visitor.cloneBackend(request)
    }

    final case class CreateBackendOp(
      request: CreateBackendRequest
    ) extends AmplifyBackendOp[CreateBackendResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBackendResponse] =
        visitor.createBackend(request)
    }

    final case class CreateBackendAPIOp(
      request: CreateBackendApiRequest
    ) extends AmplifyBackendOp[CreateBackendApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBackendApiResponse] =
        visitor.createBackendAPI(request)
    }

    final case class CreateBackendAuthOp(
      request: CreateBackendAuthRequest
    ) extends AmplifyBackendOp[CreateBackendAuthResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBackendAuthResponse] =
        visitor.createBackendAuth(request)
    }

    final case class CreateBackendConfigOp(
      request: CreateBackendConfigRequest
    ) extends AmplifyBackendOp[CreateBackendConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBackendConfigResponse] =
        visitor.createBackendConfig(request)
    }

    final case class CreateTokenOp(
      request: CreateTokenRequest
    ) extends AmplifyBackendOp[CreateTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTokenResponse] =
        visitor.createToken(request)
    }

    final case class DeleteBackendOp(
      request: DeleteBackendRequest
    ) extends AmplifyBackendOp[DeleteBackendResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBackendResponse] =
        visitor.deleteBackend(request)
    }

    final case class DeleteBackendAPIOp(
      request: DeleteBackendApiRequest
    ) extends AmplifyBackendOp[DeleteBackendApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBackendApiResponse] =
        visitor.deleteBackendAPI(request)
    }

    final case class DeleteBackendAuthOp(
      request: DeleteBackendAuthRequest
    ) extends AmplifyBackendOp[DeleteBackendAuthResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBackendAuthResponse] =
        visitor.deleteBackendAuth(request)
    }

    final case class DeleteTokenOp(
      request: DeleteTokenRequest
    ) extends AmplifyBackendOp[DeleteTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTokenResponse] =
        visitor.deleteToken(request)
    }

    final case class GenerateBackendAPIModelsOp(
      request: GenerateBackendApiModelsRequest
    ) extends AmplifyBackendOp[GenerateBackendApiModelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GenerateBackendApiModelsResponse] =
        visitor.generateBackendAPIModels(request)
    }

    final case class GetBackendOp(
      request: GetBackendRequest
    ) extends AmplifyBackendOp[GetBackendResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBackendResponse] =
        visitor.getBackend(request)
    }

    final case class GetBackendAPIOp(
      request: GetBackendApiRequest
    ) extends AmplifyBackendOp[GetBackendApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBackendApiResponse] =
        visitor.getBackendAPI(request)
    }

    final case class GetBackendAPIModelsOp(
      request: GetBackendApiModelsRequest
    ) extends AmplifyBackendOp[GetBackendApiModelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBackendApiModelsResponse] =
        visitor.getBackendAPIModels(request)
    }

    final case class GetBackendAuthOp(
      request: GetBackendAuthRequest
    ) extends AmplifyBackendOp[GetBackendAuthResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBackendAuthResponse] =
        visitor.getBackendAuth(request)
    }

    final case class GetBackendJobOp(
      request: GetBackendJobRequest
    ) extends AmplifyBackendOp[GetBackendJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBackendJobResponse] =
        visitor.getBackendJob(request)
    }

    final case class GetTokenOp(
      request: GetTokenRequest
    ) extends AmplifyBackendOp[GetTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTokenResponse] =
        visitor.getToken(request)
    }

    final case class ListBackendJobsOp(
      request: ListBackendJobsRequest
    ) extends AmplifyBackendOp[ListBackendJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBackendJobsResponse] =
        visitor.listBackendJobs(request)
    }

    final case class RemoveAllBackendsOp(
      request: RemoveAllBackendsRequest
    ) extends AmplifyBackendOp[RemoveAllBackendsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveAllBackendsResponse] =
        visitor.removeAllBackends(request)
    }

    final case class RemoveBackendConfigOp(
      request: RemoveBackendConfigRequest
    ) extends AmplifyBackendOp[RemoveBackendConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveBackendConfigResponse] =
        visitor.removeBackendConfig(request)
    }

    final case class UpdateBackendAPIOp(
      request: UpdateBackendApiRequest
    ) extends AmplifyBackendOp[UpdateBackendApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBackendApiResponse] =
        visitor.updateBackendAPI(request)
    }

    final case class UpdateBackendAuthOp(
      request: UpdateBackendAuthRequest
    ) extends AmplifyBackendOp[UpdateBackendAuthResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBackendAuthResponse] =
        visitor.updateBackendAuth(request)
    }

    final case class UpdateBackendConfigOp(
      request: UpdateBackendConfigRequest
    ) extends AmplifyBackendOp[UpdateBackendConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBackendConfigResponse] =
        visitor.updateBackendConfig(request)
    }

    final case class UpdateBackendJobOp(
      request: UpdateBackendJobRequest
    ) extends AmplifyBackendOp[UpdateBackendJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBackendJobResponse] =
        visitor.updateBackendJob(request)
    }
  }

  import AmplifyBackendOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[AmplifyBackendOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def cloneBackend(
    request: CloneBackendRequest
  ): AmplifyBackendIO[CloneBackendResponse] =
    FF.liftF(CloneBackendOp(request))

  def createBackend(
    request: CreateBackendRequest
  ): AmplifyBackendIO[CreateBackendResponse] =
    FF.liftF(CreateBackendOp(request))

  def createBackendAPI(
    request: CreateBackendApiRequest
  ): AmplifyBackendIO[CreateBackendApiResponse] =
    FF.liftF(CreateBackendAPIOp(request))

  def createBackendAuth(
    request: CreateBackendAuthRequest
  ): AmplifyBackendIO[CreateBackendAuthResponse] =
    FF.liftF(CreateBackendAuthOp(request))

  def createBackendConfig(
    request: CreateBackendConfigRequest
  ): AmplifyBackendIO[CreateBackendConfigResponse] =
    FF.liftF(CreateBackendConfigOp(request))

  def createToken(
    request: CreateTokenRequest
  ): AmplifyBackendIO[CreateTokenResponse] =
    FF.liftF(CreateTokenOp(request))

  def deleteBackend(
    request: DeleteBackendRequest
  ): AmplifyBackendIO[DeleteBackendResponse] =
    FF.liftF(DeleteBackendOp(request))

  def deleteBackendAPI(
    request: DeleteBackendApiRequest
  ): AmplifyBackendIO[DeleteBackendApiResponse] =
    FF.liftF(DeleteBackendAPIOp(request))

  def deleteBackendAuth(
    request: DeleteBackendAuthRequest
  ): AmplifyBackendIO[DeleteBackendAuthResponse] =
    FF.liftF(DeleteBackendAuthOp(request))

  def deleteToken(
    request: DeleteTokenRequest
  ): AmplifyBackendIO[DeleteTokenResponse] =
    FF.liftF(DeleteTokenOp(request))

  def generateBackendAPIModels(
    request: GenerateBackendApiModelsRequest
  ): AmplifyBackendIO[GenerateBackendApiModelsResponse] =
    FF.liftF(GenerateBackendAPIModelsOp(request))

  def getBackend(
    request: GetBackendRequest
  ): AmplifyBackendIO[GetBackendResponse] =
    FF.liftF(GetBackendOp(request))

  def getBackendAPI(
    request: GetBackendApiRequest
  ): AmplifyBackendIO[GetBackendApiResponse] =
    FF.liftF(GetBackendAPIOp(request))

  def getBackendAPIModels(
    request: GetBackendApiModelsRequest
  ): AmplifyBackendIO[GetBackendApiModelsResponse] =
    FF.liftF(GetBackendAPIModelsOp(request))

  def getBackendAuth(
    request: GetBackendAuthRequest
  ): AmplifyBackendIO[GetBackendAuthResponse] =
    FF.liftF(GetBackendAuthOp(request))

  def getBackendJob(
    request: GetBackendJobRequest
  ): AmplifyBackendIO[GetBackendJobResponse] =
    FF.liftF(GetBackendJobOp(request))

  def getToken(
    request: GetTokenRequest
  ): AmplifyBackendIO[GetTokenResponse] =
    FF.liftF(GetTokenOp(request))

  def listBackendJobs(
    request: ListBackendJobsRequest
  ): AmplifyBackendIO[ListBackendJobsResponse] =
    FF.liftF(ListBackendJobsOp(request))

  def removeAllBackends(
    request: RemoveAllBackendsRequest
  ): AmplifyBackendIO[RemoveAllBackendsResponse] =
    FF.liftF(RemoveAllBackendsOp(request))

  def removeBackendConfig(
    request: RemoveBackendConfigRequest
  ): AmplifyBackendIO[RemoveBackendConfigResponse] =
    FF.liftF(RemoveBackendConfigOp(request))

  def updateBackendAPI(
    request: UpdateBackendApiRequest
  ): AmplifyBackendIO[UpdateBackendApiResponse] =
    FF.liftF(UpdateBackendAPIOp(request))

  def updateBackendAuth(
    request: UpdateBackendAuthRequest
  ): AmplifyBackendIO[UpdateBackendAuthResponse] =
    FF.liftF(UpdateBackendAuthOp(request))

  def updateBackendConfig(
    request: UpdateBackendConfigRequest
  ): AmplifyBackendIO[UpdateBackendConfigResponse] =
    FF.liftF(UpdateBackendConfigOp(request))

  def updateBackendJob(
    request: UpdateBackendJobRequest
  ): AmplifyBackendIO[UpdateBackendJobResponse] =
    FF.liftF(UpdateBackendJobOp(request))
}
