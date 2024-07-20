package models.graphql.types

import models.Event
import sangria.macros.derive.deriveObjectType
import sangria.schema._ //ObjectType
import models.graphql.types.{ CategoryType, UserType }

trait EventType {

  implicit lazy val eventType: ObjectType[Unit, Event] = ObjectType(
    name = "Event",
    fields[Unit, Event](
      Field("id", IntType, resolve = _.value.id),
      Field("category", CategoryType.categoryType, resolve = _.value.category),
      Field("date", StringType, resolve = _.value.date),
      Field("description", StringType, resolve = _.value.description),
      Field("notes", StringType, resolve = _.value.notes),
      Field("user", UserType.userType, resolve = _.value.user)
    )
  )

}

object EventType extends EventType
