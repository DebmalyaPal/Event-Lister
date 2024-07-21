-- Users (id, email, first_name, middle_name, last_name, created, updated, password)

-- !Ups
CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(30) NOT NULL UNIQUE,
    first_name VARCHAR(30) NOT NULL,
    middle_name VARCHAR(30),
    last_name VARCHAR(30) NOT NULL,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    password VARCHAR(30) NOT NULL
);

-- !Downs
DROP TABLE users;

