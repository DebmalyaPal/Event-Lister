package controllers

import models.Event

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  var eventList: List[Event] = List(
    Event(1, "Birthday", "April 24, 2024", "Sachin Tendulkar's Birthday"),
    Event(2, "Birthday", "June 24, 2024", "Lionel Messi's Birthday"),
    Event(3, "Birthday", "February 05, 2024", "CR7's Birthday"),
    Event(4, "Birthday", "October 10, 2024", "DP's Birthday"),
  )

  implicit val eventListJson = Json.format[Event]

  def getEvent(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(
      Json.toJson(
        eventList
      )
    )
  }

  def getEventById(id : Int) = Action { implicit request: Request[AnyContent] =>
    Ok(
      Json.toJson(
        eventList.filter(_.id == id)
      )
    )
  }

}
