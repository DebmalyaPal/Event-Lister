package services

import models.Event

class EventService {

  var eventList: List[Event] = List(
    Event(1, "Birthday", "April 24, 2024", "Sachin Tendulkar's Birthday"),
    Event(2, "Birthday", "June 24, 2024", "Lionel Messi's Birthday"),
    Event(3, "Birthday", "February 05, 2024", "CR7's Birthday"),
    Event(4, "Birthday", "October 10, 2024", "DP's Birthday"),
  )

  def getEvent : List[Event] = {
    eventList
  }

  def getEventById(id: Int): Option[Event] = {
    eventList.find(event => event.id == id)
  }

  def addEvent(event : Event) : Event = {
    ???
  }

  def updateEvent(id : Int, event : Event) : Option[Event] = {
    ???
  }

}
