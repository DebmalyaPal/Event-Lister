package repository

import models.User
import play.api.db.Database

import java.sql.ResultSet
import javax.inject.{Inject, Singleton}
import scala.collection.mutable.ListBuffer
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UserRepository @Inject()(db : Database, implicit val databaseExecutionContext : ExecutionContext) {

  def getUser:List[User] = {
    val userList = new ListBuffer[User]()
    db.withConnection { conn =>
      val query : String = "SELECT * FROM users"
      val rs : ResultSet = conn.createStatement().executeQuery(query)
      while (rs.next()) {
        userList += User(
          id = rs.getInt(1),
          email = rs.getString(2),
          name = rs.getString(3),
          created = rs.getString(4),
          updated = rs.getString(5),
          password = rs.getString(6)
        )
      }
    }

    userList.toList
  }

  def getUserById(id: Int): Option[User] = {
    var user : Option[User] = None
    db.withConnection { conn =>
      val query = s"SELECT * FROM users WHERE id=${id}"
      val rs: ResultSet = conn.createStatement().executeQuery(query)
      while (rs.next()) {
        user = Some(
          User(
            rs.getInt(1).toInt,
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5),
            rs.getString(6)
          )
        )
      }
    }
    user
  }

  def addUser(user: User): User = {
    ???
  }

  def updateUser(id: Int, user: User): User = {
    ???
  }

}
