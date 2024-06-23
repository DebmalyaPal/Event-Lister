-- Inserting initial records into Users table

INSERT INTO Users (email, first_name, last_name, created, updated, password) VALUES
('admin1@email.com', 'Admin', '1', NOW(), NOW(), 'AdMiN'),
('user1@email.com', 'USER', '1', NOW(), NOW(), 'UsEr1'),
('user2@user.com', 'USER', '2', NOW(), NOW(), 'UsEr2');

