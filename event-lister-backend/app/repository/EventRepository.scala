package repository

import models.Event

import java.time.OffsetDateTime
import javax.inject.{Inject, Singleton}

@Singleton
class EventRepository @Inject() {

  private val eventList : List[Event] = List(
    Event(1, "Birthday", "1973-04-24", "Sachin Tendulkar's Birthday"),
    Event(2, "Birthday", "1987-06-24", "Lionel Messi's Birthday"),
    Event(3, "Birthday", "1985-02-05", "CR7's Birthday"),
    Event(4, "Birthday", "1999-10-10", "DP's Birthday")
  )

  def getEvent(): List[Event] = {
    eventList
  }

  def getEventById(id : Int) : Option[Event] = {
    eventList.find(event => event.id == id)
  }

  def addEvent(event: Event): Event = {
    ???
  }

  def updateEvent(id: Int, event: Event): Option[Event] = {
    ???
  }

}
