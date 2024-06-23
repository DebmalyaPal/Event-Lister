-- Inserting initial records into Events_Info and Events

INSERT INTO events_info (id, category_id, date, description) VALUES
(1, 1, , 'Debmalya\'s Birthday'),
(2, 2, , 'Aura\'s Day'),
(3, 4, , 'UEM 2018 batch\'s Graduation day'),
(4, 1, , 'Sindrela\'s Birthday')
(5, 2, , 'Aura\'s Day'),
(6, 4, , 'UEM 2018 batch\'s Graduation day'),
(7, 6, , 'FIFA 2022 World Cup Final @ Lussail, Qatar');

INSERT INTO events (event_id, user_id) VALUES
(2, 1), (2, 2), (2, 3),
(3, 4), (3, 5), (3, 6), (3,7);

