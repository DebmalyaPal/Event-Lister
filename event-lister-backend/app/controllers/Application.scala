package controllers

import models.graphql.{MasterContext, MasterSchema}
import javax.inject.{Inject, Singleton}
import play.api.mvc._
import play.api.libs.json.{JsArray, JsObject, JsString, JsValue, Json}
import sangria.ast.Document
import sangria.execution.{ErrorWithResolver, Executor, QueryAnalysisError}
import sangria.parser.QueryParser
import sangria.marshalling.playJson._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success, Try}

@Singleton
class Application @Inject()(
                             val controllerComponents: ControllerComponents,
                             masterSchema: MasterSchema,
                             masterContext: MasterContext,
                             implicit val context: ExecutionContext
                           ) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  // Receives POST request
  def graphqlBody: Action[JsValue] = Action.async(parse.json) {
    implicit request: Request[JsValue] =>
      val extract: JsValue => (String, Option[String], Option[JsObject]) = query => (
        (query \ "query").as[String],
        (query \ "operationName").asOpt[String],
        (query \ "variables").toOption.flatMap {
          case JsString(vars) => Some(parseVariables(vars))
          case obj: JsObject => Some(obj)
          case _ => None
        }
      )

      val maybeQuery: Try[(String, Option[String], Option[JsObject])] =
        Try {
          request.body match {
            case arrayBody@JsArray(_) => extract(arrayBody.value(0))
            case objectBody@JsObject(_) => extract(objectBody)
            case otherType =>
              throw new Error {
                s"The '/graphql' endpoint doesn't support a request body of the type [${otherType.getClass.getSimpleName}]"
              }
          }
        }

      maybeQuery match {
        case Success((query, operationName, variables)) => executeQuery(query, variables, operationName)
        case Failure(error) => Future.successful {
          BadRequest(error.getMessage)
        }
      }
  }

  def parseVariables(variables: String): JsObject = {
    if (variables.trim.isEmpty || variables.trim == "null") Json.obj()
    else Json.parse(variables).as[JsObject]
  }

  def executeQuery(query: String, variables: Option[JsObject] = None, operation: Option[String] = None): Future[Result] =
    QueryParser.parse(query) match {
      case Success(queryAst: Document) => Executor.execute(
          schema = masterSchema.schema,
          userContext = masterContext,
          queryAst = queryAst,
          variables = variables.getOrElse(Json.obj()),
        ).map(Ok(_))
        .recover {
          case error: QueryAnalysisError => BadRequest(error.resolveError)
          case error: ErrorWithResolver => InternalServerError(error.resolveError)
        }
      case Failure(ex) => Future(BadRequest(s"${ex.getMessage}"))
    }

}