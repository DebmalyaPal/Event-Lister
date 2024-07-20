package models

import play.api.libs.json._

case class Category(
                   id: Int,
                   display_name: String
                   )

object Category {
  implicit val categoryJsonReads: Reads[Category] = Json.reads[Category]
  implicit val categoryJsonWrites: OWrites[Category] = Json.writes[Category]
}
