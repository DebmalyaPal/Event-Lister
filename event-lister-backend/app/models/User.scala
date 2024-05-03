package models

import play.api.libs.json.{Json, OWrites, Reads}
import java.util.Date
import java.util.Calendar

case class User(
                 id : Int,
                 email : String,
                 name : String,
                 created : Date = Calendar.getInstance().getTime,
                 updated : Date,
                 password : String
               );

object User {
  implicit val eventJsonReads: Reads[User] = Json.reads[User]
  implicit val eventJsonWrites: OWrites[User] = Json.writes[User]
}