package services

import models.Event
import repository.EventRepository

object EventService {

  def getEvent : List[Event] = {
    EventRepository.getEvent()
  }

  def getEventById(id: Int): Option[Event] = {
    EventRepository.getEventById(id)
  }

  def addEvent(newEvent : Event) : Option[Event] = {
    ???
  }

  def updateEvent(id : Int, event : Event) : Option[Event] = {
    ???
  }

}
