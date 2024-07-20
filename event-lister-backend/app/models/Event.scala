package models

import play.api.libs.json._

case class Event(
                  id: Int,
                  category: Category,
                  date: String,
                  description: String,
                  notes: String,
                  user: User
                )

object Event {
  implicit val eventJsonReads: Reads[Event] = Json.reads[Event]
  implicit val eventJsonWrites: OWrites[Event] = Json.writes[Event]
}
