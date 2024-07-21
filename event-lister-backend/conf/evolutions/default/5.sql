-- Inserting initial records into Events_Info and Events

-- !Ups

INSERT INTO events_info (category_id, date, description) VALUES
(1, '2022-10-10', 'Debmalya''s Birthday'),
(2, '2022-01-24', 'Aura''s Day'),
(4, '2022-06-23', 'UEM 2018 batch''s Graduation day'),
(1, '2022-09-14', 'Sindrela''s Birthday'),
(2, '2022-01-24', 'Aura''s Day'),
(4, '2022-06-23', 'UEM 2018 batch''s Graduation day'),
(6, '2022-12-19', 'FIFA 2022 World Cup Final @ Lussail, Qatar');

INSERT INTO events (event_id, user_id) VALUES
(1, 1), (2, 1), (3, 1),
(4, 2), (5, 2), (6, 2), (7, 2);

