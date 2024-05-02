-- User Table => id, email, name, created, updated, password

-- !Ups
CREATE TABLE IF NOT EXISTS Users (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(30) NOT NULL UNIQUE,
    name VARCHAR(30) NOT NULL,
    created TIMESTAMP,
    updated TIMESTAMP,
    password VARCHAR(15) NOT NULL
);

-- !Downs
DROP TABLE Users;

