package models.graphql.subschema

import models.graphql.{ MasterContext, SubSchema }
import models.graphql.types.EventType
import services.EventService
import sangria.schema._
import javax.inject.{Inject, Singleton}

@Singleton
class EventSchema @Inject()(
                            eventService: EventService
                            ) extends SubSchema {

  val ID: Argument[Int] = Argument("id", IntType, description = "id of the event")

  override lazy val queries: Seq[Field[MasterContext, Unit]] = List(
    Field(
        name = "getEvent",
        ListType(EventType.eventType),
        resolve = context => eventService.getEvent
      ),
      Field(
        name = "getEventById",
        OptionType(EventType.eventType),
        arguments = ID :: Nil,
        resolve = context => eventService.getEventById(context.arg(ID))
      )
    )

  override lazy val mutations: Seq[Field[MasterContext, Unit]] = List()
}