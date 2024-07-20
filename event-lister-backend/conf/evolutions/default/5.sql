-- Inserting initial records into Events_Info and Events

-- !Ups

INSERT INTO events_info (id, category_id, date, description) VALUES
(1, 1, DATE '2022-10-10', 'Debmalya\'s Birthday'),
(2, 2, DATE '2022-01-24', 'Aura\'s Day'),
(3, 4, DATE '2022-06-23', 'UEM 2018 batch\'s Graduation day'),
(4, 1, DATE '2022-09-14', 'Sindrela\'s Birthday')
(5, 2, DATE '2022-01-24', 'Aura\'s Day'),
(6, 4, DATE '2022-06-23', 'UEM 2018 batch\'s Graduation day'),
(7, 6, DATE '2022-12-19', 'FIFA 2022 World Cup Final @ Lussail, Qatar');

INSERT INTO events (event_id, user_id) VALUES
(2, 1), (2, 2), (2, 3),
(3, 4), (3, 5), (3, 6), (3,7);

