package controllers

import play.api.libs.json.Json
import play.api.mvc._
import services.{EventService, UserService}

import javax.inject.{Inject, Singleton}

@Singleton
class UserController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def getUser: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(
      Json.toJson(UserService.getUser)
    )
  }

  def getUserById(id : Int): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(
      Json.toJson(UserService.getUserById(id))
    )
  }

}
