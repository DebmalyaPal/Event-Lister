package repository

import models.User
import java.util.Calendar

object UserRepository {

  val userList : List[User] = List(
    User(
      id = 1, email = "user1@email.com", name = "User 1", updated = Calendar.getInstance().getTime, password = "ABCD"),
    User(
      id = 2, email = "user2@email.com", name = "User 2", updated = Calendar.getInstance().getTime, password = "1234")
  )

  def getUser():List[User] = {
    userList
  }

  def getUserById(id: Int): Option[User] = {
    userList.find(user => user.id == id)
  }

  def addUser(user: User): User = {
    ???
  }

  def updateUser(id: Int, user: User): User = {
    ???
  }

}
