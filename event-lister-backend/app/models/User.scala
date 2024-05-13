package models

import play.api.libs.json.{Json, OWrites, Reads}
import java.time.OffsetDateTime

case class User(
                 id : Int,
                 email : String,
                 name : String,
                 created : String = OffsetDateTime.now().toLocalDateTime.toString,
                 updated : String = OffsetDateTime.now().toLocalDateTime.toString,
                 password : String
               );

object User {
  implicit val eventJsonReads: Reads[User] = Json.reads[User]
  implicit val eventJsonWrites: OWrites[User] = Json.writes[User]
}


