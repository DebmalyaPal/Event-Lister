package models.graphql

import models.graphql.subschema.{ CategorySchema, EventSchema, UserSchema }
import sangria.schema.{ Field, ObjectType, Schema }

import javax.inject.{ Inject, Singleton }

trait SubSchema {

  val queries : Seq[Field[MasterContext, Unit]]

  val mutations : Seq[Field[MasterContext, Unit]]

}

@Singleton
class MasterSchema @Inject() (
                               userSchema: UserSchema,
                               eventSchema: EventSchema,
                               categorySchema: CategorySchema
                             ) {

  private lazy val subSchemaList : Seq[SubSchema] = List(
    userSchema,
    eventSchema,
    categorySchema
  )

  private def queriesList : Seq[Field[MasterContext, Unit]] = subSchemaList.flatMap(_.queries)

  private def mutationsList : Seq[Field[MasterContext, Unit]] = subSchemaList.flatMap(_.mutations)

  lazy val query : ObjectType[MasterContext, Unit] = ObjectType(
    name = "Query",
    description = "All Queries of the API",
    fields = queriesList.toList
  )

  private lazy val mutation: Option[ObjectType[MasterContext, Unit]] =
    if (mutationsList.toList.isEmpty) {
      None
    } else {
      Some(
        ObjectType(
          name = "Mutations",
          description = "All Mutations of the API",
          fields = mutationsList.toList
        )
      )
    }

  lazy val schema: Schema[MasterContext, Unit] = Schema(
    query = query,
    mutation = mutation
  )

}
