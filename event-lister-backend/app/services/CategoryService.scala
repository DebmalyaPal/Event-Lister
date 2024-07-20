package services

import models.Category
import repository.CategoryRepository

import javax.inject.{Inject, Singleton}

@Singleton
class CategoryService @Inject()(categoryRepository: CategoryRepository) {

  def getCategory : List[Category] = {
    categoryRepository.getCategory
  }

  def getCategoryById(id: Int): Option[Category] = {
    categoryRepository.getCategoryById(id)
  }

  def addCategory(user: Category): Category = {
    ???
  }

  def updateCategory(id: Int, category: Category): Either[String, Category] = {
    ???
  }

}
