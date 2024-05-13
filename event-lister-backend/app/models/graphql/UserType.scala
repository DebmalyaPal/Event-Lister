package models.graphql

import models.User
import repository.UserRepository
import sangria.macros.derive._
import sangria.schema._

trait UserType {

  implicit lazy val userType: ObjectType[Unit, User] =
    deriveObjectType[Unit, User]()

  val ID = Argument("id", IntType, description = "id of the user")

  val queries = ObjectType(
    "queries",
    fields[UserRepository, Unit](
      Field(
        name = "getUser",
        ListType(userType),
        resolve = (context) => context.ctx.getUser
      ),
      Field(
        name = "getUserById",
        OptionType(userType),
        arguments = ID :: Nil,
        resolve = (context) => context.ctx.getUserById(context.arg(ID))
      )
    )
  )

  val userSchema = Schema(queries)

}

object UserType extends UserType
