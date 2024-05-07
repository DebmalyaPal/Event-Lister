package services

import models.User
import repository.UserRepository

import javax.inject.{Inject, Singleton}

@Singleton
class UserService @Inject() (userRepository: UserRepository) {

  def getUser : List[User] = {
    userRepository.getUser
  }

  def getUserById(id: Int): Option[User] = {
    userRepository.getUserById(id)
  }

  def addUser(user: User): User = {
    ???
  }

  def updateUser(id: Int, user: User): Option[User] = {
    ???
  }

}
