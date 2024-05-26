CREATE TABLE IF NOT EXISTS users
(
    id    SERIAL PRIMARY KEY ,
    login  INTEGER NOT NULL ,
    first_name VARCHAR(254) NOT NULL ,
    middle_name VARCHAR(254) NOT NULL ,
    last_name VARCHAR(254) NOT NULL ,
    birthday DATE NOT NULL ,
    email VARCHAR(254) NOT NULL ,
    gender BOOLEAN NOT NULL ,
    penny BIGINT ,
    rub BIGINT NOT NULL

);