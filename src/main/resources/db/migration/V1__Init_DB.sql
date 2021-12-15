drop table if exists vuser;
create table vuser
(
    id       BIGSERIAL,
    username varchar(255),
    password varchar(255),
    email    varchar(255),
    primary key (id)
);


drop table if exists student;
create table student
(
    id         BIGSERIAL,
    v_user_id   BIGSERIAL,
    name       varchar(255),
    speciality varchar(255),
    position varchar(255),
    education varchar(255),
    about varchar(255),
--     surname    varchar(255),
--     patronymic varchar(255),
--     birthdate  date,
    primary key (id)
);
drop table if exists employer;
create table employer
(
    id           BIGSERIAL,
    v_user_id     BIGSERIAL,
    position varchar(255),
    company_name varchar(255),
    ship varchar(255),
    price varchar(255),
    about varchar(255),
--     surname    varchar(255),
--     patronymic varchar(255),
--     birthdate  date,
    primary key (id)
);
