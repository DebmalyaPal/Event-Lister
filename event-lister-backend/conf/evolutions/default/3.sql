-- Category (id, display_name)

-- !Ups
CREATE TABLE IF NOT EXISTS category (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    display_name TEXT NOT NULL
);

INSERT INTO category (id, display_name) VALUES
(1, 'Birth Anniversary'),
(2, 'Marriage Anniversary'),
(3, 'Death Anniversary'),
(4, 'Graduation Anniversary'),
(5, 'Friendship Anniversary'),
(6, 'Special Dates'),
(7, 'Miscellaneous');

-- !Downs
DROP TABLE category;
