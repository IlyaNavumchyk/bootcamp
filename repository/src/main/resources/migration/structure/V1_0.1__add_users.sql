create table if not exists users
(
    id                bigint auto_increment primary key,
    surname           varchar(40) not null,
    constraint users_surname_check_format check (surname REGEXP '^[A-Za-z]{1,40}'),
    user_name         varchar(20) not null,
    constraint users_name_check_format check (user_name REGEXP '^[A-Za-z]{1,20}'),
    patronymic        varchar(40) not null,
    constraint users_patronymic_check_format check (patronymic REGEXP '^[A-Za-z]{1,40}'),
    email             varchar(50) not null,
    constraint users_email_check_format check (email REGEXP '^[A-Za-z][\\w.]+@[A-Za-z]+\\.[A-Za-z]{2,}$'),
    constraint email unique (email),
    constraint id unique (id)
);