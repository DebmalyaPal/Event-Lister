package repository

import models.Event
import play.api.db.Database

import java.sql.ResultSet
import javax.inject.{ Inject, Singleton }
import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext

@Singleton
class EventRepository @Inject()(
                                 db : Database,
                                 implicit val databaseExecutionContext : ExecutionContext,
                                 userRepository: UserRepository,
                                 categoryRepository: CategoryRepository
                               ) {

  def getEvent: List[Event] = {
    val eventList = new ListBuffer[Event]()
    db.withConnection { conn =>
      val query : String = "SELECT e.id, c.id, e.date, e.description, e.notes, ei.user_id " +
        "FROM events e " +
        "JOIN events_info ei ON e.id=ei.event_id " +
        "JOIN category c ON c.id=ei.category_id;"
      val rs : ResultSet = conn.createStatement().executeQuery(query)
      while (rs.next()) {
        eventList += Event(
          id = rs.getInt(1),
          category = categoryRepository.getCategoryById(rs.getInt(2)).get,
          date = rs.getString(3),
          description = rs.getString(4),
          notes = rs.getString(5),
          user = userRepository.getUserById(rs.getInt(6)).get
        )
      }
    }

    eventList.toList
  }

  def getEventById(id : Int) : Option[Event] = {
    var event: Option[Event] = None
    db.withConnection { conn =>
      val query : String = "SELECT e.id, c.id, e.date, e.description, e.notes, ei.user_id " +
        "FROM events e " +
        "JOIN events_info ei ON e.id=ei.event_id " +
        "JOIN categories c ON c.id=ei.category_id " +
        s"WHERE e.id=$id;"
      val rs : ResultSet = conn.createStatement().executeQuery(query)
      while (rs.next()) {
        event = Some(
          Event(
            id = rs.getInt(1),
            category = categoryRepository.getCategoryById(rs.getInt(2)).get,
            date = rs.getString(3),
            description = rs.getString(4),
            notes = rs.getString(5),
            user = userRepository.getUserById(6).get
          )
        )
      }
    }

    event
  }

  def addEvent(event: Event): Event = {
    ???
  }

  def updateEvent(id: Int, event: Event): Either[String, Event] = {
    ???
  }

}
