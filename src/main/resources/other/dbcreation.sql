CREATE SCHEMA usersdb;
USE usersdb;

CREATE TABLE user(
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(20),
    email VARCHAR(50),
    password VARCHAR(15)
);