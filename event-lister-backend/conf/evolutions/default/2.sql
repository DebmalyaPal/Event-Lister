-- Events Table => id, event_type, date, description

-- !Ups
CREATE TABLE IF NOT EXISTS events (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    event_type VARCHAR(15) NOT NULL,
    description VARCHAR(50) NOT NULL,
    event_date TIMESTAMP
);

-- !Downs
DROP TABLE events;

