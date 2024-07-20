-- Users (id, email, first_name, middle_name, last_name, created, updated, password)

-- !Ups
CREATE TABLE IF NOT EXISTS users (
    id IDENTITY PRIMARY KEY,
    email VARCHAR(30) NOT NULL UNIQUE,
    first_name VARCHAR(30) NOT NULL,
    middle_name VARCHAR(30),
    last_name VARCHAR(30) NOT NULL,
    created TIMESTAMP,
    updated TIMESTAMP,
    password VARCHAR(30) NOT NULL
);

-- !Downs
DROP TABLE users;

