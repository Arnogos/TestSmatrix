CREATE TABLE IF NOT EXISTS users
(
    login  VARCHAR(10) NOT NULL UNIQUE ,
    password  VARCHAR(20) NOT NULL ,
    first_name VARCHAR(20) NOT NULL ,
    middle_name VARCHAR(20) NOT NULL ,
    last_name VARCHAR(20) NOT NULL ,
    birthday DATE NOT NULL ,
    email VARCHAR(40) NOT NULL UNIQUE ,
    gender VARCHAR(3) NOT NULL ,
    penny BIGINT CHECK ( penny >=0 ) ,
    rub BIGINT NOT NULL CHECK ( rub>=0 )
);
CREATE TABLE IF NOT EXISTS roles
(
    name VARCHAR(10) NOT NULL
)

