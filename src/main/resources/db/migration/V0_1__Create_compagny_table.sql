create extension if not exists "uuid-ossp";

create table if not exists "compagny"
(
    id                  varchar
        constraint compagny_pk primary key default uuid_generate_v4(),
    name VARCHAR(50),
    description VARCHAR(250),
    logo oid,
    email VARCHAR(50) UNIQUE,
    slogan VARCHAR(255),
    address VARCHAR(255),
    phone_numbers VARCHAR(50),
    nif VARCHAR(50) UNIQUE,
    stat VARCHAR(50) UNIQUE,
    rcs VARCHAR(50) UNIQUE
);