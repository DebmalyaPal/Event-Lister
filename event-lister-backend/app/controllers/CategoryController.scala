package controllers

import services.CategoryService

import javax.inject._
import play.api.mvc._
import play.api.libs.json._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class CategoryController @Inject()(val controllerComponents: ControllerComponents,
                                categoryService: CategoryService
                               ) extends BaseController {

  def getCategory: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(
      Json.toJson(categoryService.getCategory)
    )
  }

  def getCategoryById(id : Int): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(
      Json.toJson(categoryService.getCategoryById(id))
    )
  }

}
