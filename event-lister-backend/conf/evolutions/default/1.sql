-- User Table => id, email, name, created, updated, password

-- !Ups
CREATE TABLE IF NOT EXISTS Users (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(30) NOT NULL UNIQUE,
    name VARCHAR(30) NOT NULL,
    created TIMESTAMP,
    updated TIMESTAMP,
    password VARCHAR(30) NOT NULL
);

INSERT INTO Users (email, name, created, password) VALUES
('user1@email.com', 'USER 1', now(), 'ABED'),
('user2@example.com', 'USER 2', now(), '1234');

-- !Downs
DROP TABLE Users;

