package controllers

import play.api.libs.json.Json
import play.api.mvc._
import services.UserService

import javax.inject.{Inject, Singleton}

@Singleton
class UserController @Inject()(val controllerComponents: ControllerComponents,
                               userService: UserService
                              ) extends BaseController {

  def getUser: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(
      Json.toJson(userService.getUser)
    )
  }

  def getUserById(id : Int): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(
      Json.toJson(userService.getUserById(id))
    )
  }

}
