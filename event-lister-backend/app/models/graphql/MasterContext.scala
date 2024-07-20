package models.graphql

import services.{ CategoryService, EventService, UserService }

import javax.inject.{Inject, Singleton}

@Singleton
class MasterContext @Inject() (
                    userService: UserService,
                    eventService: EventService,
                    categoryService: CategoryService
                    )  {

}
