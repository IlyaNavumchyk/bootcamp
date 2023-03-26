create table if not exists users
(
    id                bigint auto_increment primary key,
    surname           varchar(40)  not null,
    user_name         varchar(20)  not null,
    patronymic        varchar(40)  not null,
    email             varchar(50)  not null,
    constraint users_email_check_format check (email REGEXP '^\\w+@\\w+.[A-Za-z]{2,}$'),
    is_deleted        tinyint(1)   null,
    creation_date     timestamp(6) null,
    modification_date timestamp(6) null,
    constraint email unique (email),
    constraint id unique (id)
);