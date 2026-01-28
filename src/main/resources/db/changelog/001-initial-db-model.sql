CREATE TABLE users
(
    id          VARCHAR(100) PRIMARY KEY,
    username    VARCHAR(32) NOT NULL UNIQUE,
    first_name  VARCHAR(32) NOT NULL,
    second_name VARCHAR(32) NOT NULL,
    email       VARCHAR(100) NOT NULL UNIQUE
);