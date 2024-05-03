package services

import models.User
import repository.UserRepository

object UserService {

  def getUser : List[User] = {
    UserRepository.getUser()
  }

  def getUserById(id: Int): Option[User] = {
    UserRepository.getUserById(id)
  }

  def addUser(user: User): User = {
    ???
  }

  def updateUser(id: Int, user: User): Option[User] = {
    ???
  }

}
