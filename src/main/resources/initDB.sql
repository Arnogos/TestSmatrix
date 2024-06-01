CREATE TABLE IF NOT EXISTS users
(
    id    SERIAL PRIMARY KEY ,
    login  VARCHAR(10) NOT NULL UNIQUE ,
    password  VARCHAR(10) NOT NULL UNIQUE ,
    first_name VARCHAR(254) NOT NULL ,
    middle_name VARCHAR(254) NOT NULL ,
    last_name VARCHAR(254) NOT NULL ,
    birthday DATE NOT NULL ,
    email VARCHAR(254) NOT NULL UNIQUE ,
    /*gender BOOLEAN NOT NULL ,*/
    penny BIGINT CHECK ( penny >=0 ) ,
    rub BIGINT NOT NULL CHECK ( rub>=0 )
);