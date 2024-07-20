package models.graphql.subschema

import models.graphql.{ MasterContext, SubSchema }
import models.graphql.types.CategoryType
import services.CategoryService
import sangria.schema._

import javax.inject.{Inject, Singleton}

@Singleton
class CategorySchema @Inject() (
                             categoryService: CategoryService
                           ) extends SubSchema {

  val ID: Argument[Int] = Argument("id", IntType, description = "id of the category")

  override lazy val queries: Seq[Field[MasterContext, Unit]] = List(
    Field(
      name = "getCategory",
      ListType(CategoryType.categoryType),
      resolve = context => categoryService.getCategory
    ),
    Field(
      name = "getCategoryById",
      OptionType(CategoryType.categoryType),
      arguments = ID :: Nil,
      resolve = context => categoryService.getCategoryById(context.arg(ID))
    )
  )

  lazy override val mutations: Seq[Field[MasterContext, Unit]] = List()
}