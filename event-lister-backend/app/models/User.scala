package models

import play.api.libs.json._
import java.time.OffsetDateTime

case class User(
                 id : Int,
                 email : String,
                 first_name : String,
                 middle_name: String,
                 last_name: String,
                 created : String = OffsetDateTime.now().toLocalDateTime.toString,
                 updated : String = OffsetDateTime.now().toLocalDateTime.toString,
                 password : String
               )

object User {
  implicit val userJsonReads: Reads[User] = Json.reads[User]
  implicit val userJsonWrites: OWrites[User] = Json.writes[User]
}
