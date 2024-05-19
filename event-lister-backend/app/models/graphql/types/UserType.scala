package models.graphql.types

import models.User
import sangria.macros.derive.deriveObjectType
import sangria.schema.ObjectType

trait UserType {

  implicit lazy val userType: ObjectType[Unit, User] = deriveObjectType[Unit, User]()

}

object UserType extends UserType
