-- Events_Info (id, category_id, date, description, notes)
-- Events (event_id, user_id)

-- !Ups

CREATE TABLE IF NOT EXISTS events_info (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    category_id INTEGER REFERENCES category(id),
    date TIMESTAMP NOT NULL,
    description TEXT NOT NULL,
    notes TEXT
);

CREATE TABLE IF NOT EXISTS events (
    event_id INTEGER REFERENCES events_info(id),
    user_id INTEGER REFERENCES users(id)
)

-- !Downs
DROP TABLE events_info;
DROP TABLE events;
