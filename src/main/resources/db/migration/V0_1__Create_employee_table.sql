create extension if not exists "uuid-ossp";

create table if not exists "employee"
(
    id                  varchar
        constraint employee_pk primary key default uuid_generate_v4(),
    first_name           varchar,
    last_name            varchar,
    image               oid,
    registration_number varchar,
    birth_date          date,
    sex VARCHAR(8),
    phone_number VARCHAR(30),
    address VARCHAR(255),
    professional_email VARCHAR(50) UNIQUE,
    personal_email VARCHAR(50) UNIQUE,
    CIN VARCHAR(30) UNIQUE,
    post VARCHAR(200),
    children SMALLINT,
    departing_date DATE,
    entrance_date DATE,
    socio_profesional_category VARCHAR(5),
    CNAPS VARCHAR(30)
);

CREATE SEQUENCE if not exists employ_ref_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 999999
    CACHE 1;

CREATE OR REPLACE FUNCTION generate_employ_custom_ref()
    RETURNS TRIGGER AS
$BODY$
BEGIN
    NEW.registration_number := 'REF-' || LPAD(NEXTVAL('employ_ref_sequence')::TEXT, 6, '0');
    RETURN NEW;
END;
$BODY$
    LANGUAGE plpgsql;

CREATE TRIGGER insert_reference_number_trigger
    BEFORE INSERT
    ON "employee"
    FOR EACH ROW
EXECUTE FUNCTION generate_employ_custom_ref();