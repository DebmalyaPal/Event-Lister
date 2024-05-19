package models.graphql.types

import models.Event
import sangria.macros.derive.deriveObjectType
import sangria.schema.ObjectType

trait EventType {

  implicit lazy val eventType: ObjectType[Unit, Event] = deriveObjectType[Unit, Event]()

}

object EventType extends EventType
