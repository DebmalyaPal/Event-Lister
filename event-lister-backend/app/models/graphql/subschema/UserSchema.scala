package models.graphql.subschema

import models.graphql.{ MasterContext, SubSchema }
import models.graphql.types.UserType
import services.UserService
import sangria.schema._

import javax.inject.{Inject, Singleton}

@Singleton
class UserSchema @Inject() (
                             userService: UserService
                           ) extends SubSchema {

  val ID: Argument[Int] = Argument("id", IntType, description = "id of the event")

  override lazy val queries: Seq[Field[MasterContext, Unit]] = List(
      Field(
        name = "getUser",
        ListType(UserType.userType),
        resolve = context => userService.getUser
      ),
      Field(
        name = "getUserById",
        OptionType(UserType.userType),
        arguments = ID :: Nil,
        resolve = context => userService.getUserById(context.arg(ID))
      )
  )

  lazy override val mutations: Seq[Field[MasterContext, Unit]] = List()
}