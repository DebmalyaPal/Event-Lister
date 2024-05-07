package services

import models.Event
import repository.EventRepository

import javax.inject.{Inject, Singleton}

@Singleton
class EventService @Inject() (
                             eventRepository: EventRepository
                             ) {

  def getEvent : List[Event] = {
    eventRepository.getEvent()
  }

  def getEventById(id: Int): Option[Event] = {
    eventRepository.getEventById(id)
  }

  def addEvent(newEvent : Event) : Option[Event] = {
    ???
  }

  def updateEvent(id : Int, event : Event) : Option[Event] = {
    ???
  }

}
