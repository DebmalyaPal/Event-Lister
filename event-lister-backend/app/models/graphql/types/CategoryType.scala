package models.graphql.types

import models.Category
import sangria.macros.derive.deriveObjectType
import sangria.schema.ObjectType

trait CategoryType {

  implicit lazy val categoryType: ObjectType[Unit, Category] = deriveObjectType[Unit, Category]()

}

object CategoryType extends CategoryType
