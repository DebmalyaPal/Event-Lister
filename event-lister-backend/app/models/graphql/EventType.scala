package models.graphql

import models.Event
import repository.EventRepository
import sangria.macros.derive._
import sangria.schema._

trait EventType {

  implicit lazy val eventType: ObjectType[Unit, Event] =
    deriveObjectType[Unit, Event]()

  val ID = Argument("id", IntType, description = "id of the event")

  val queries = ObjectType(
    "queries",
    fields[EventRepository, Unit](
      Field(
        name = "getEvents",
        ListType(eventType),
        resolve = (context) => context.ctx.getEvent()
      ),
      Field(
        name = "getEventById",
        OptionType(eventType),
        arguments = ID :: Nil,
        resolve = (context) => context.ctx.getEventById(context.arg(ID))
      )
    )
  )

  val eventSchema = Schema(queries)
}

object EventType extends EventType