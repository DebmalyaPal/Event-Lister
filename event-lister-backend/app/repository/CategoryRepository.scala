package repository

import models.{Category, User}
import play.api.db.Database

import java.sql.ResultSet
import javax.inject.{Inject, Singleton}
import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext

@Singleton
class CategoryRepository @Inject()(
                                db : Database,
                                implicit val databaseExecutionContext : ExecutionContext
                              ) {

  def getCategory:List[Category] = {
    val categoryList = new ListBuffer[Category]()
    db.withConnection { conn =>
      val query : String = "SELECT id, display_name FROM category"
      val rs : ResultSet = conn.createStatement().executeQuery(query)
      while (rs.next()) {
        categoryList += Category(
          id = rs.getInt(1),
          display_name = rs.getString(2)
        )
      }
    }

    categoryList.toList
  }

  def getCategoryById(id: Int): Option[Category] = {
    var category : Option[Category] = None
    db.withConnection { conn =>
      val query = s"SELECT id, display_name FROM category WHERE id=$id"
      val rs: ResultSet = conn.createStatement().executeQuery(query)
      while (rs.next()) {
        category = Some(
          Category(
            id = rs.getInt(1),
            display_name = rs.getString(2)
          )
        )
      }
    }

    category
  }

  def addCategory(category: Category): Category = {
    ???
  }

  def updateCategory(id: Int, category: Category): Either[String, Category] = {
    ???
  }

}
