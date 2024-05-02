package controllers

import models.Event
import services.EventService

import javax.inject._
import play.api.mvc._
import play.api.libs.json._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class EventController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  private val eventService = new EventService()

  def getEvent(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(
      Json.toJson(eventService.getEvent)
    )
  }

  def getEventById(id : Int) = Action { implicit request: Request[AnyContent] =>
    Ok(
      Json.toJson(eventService.getEventById(id))
    )
  }

}
