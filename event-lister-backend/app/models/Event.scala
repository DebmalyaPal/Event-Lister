package models

import play.api.libs.json._

case class Event(
                id : Int,
                event_type : String,
                date : String,
                description : String
                )

object Event {
  implicit val eventJsonReads: Reads[Event] = Json.reads[Event]
  implicit val eventJsonWrites: OWrites[Event] = Json.writes[Event]
}