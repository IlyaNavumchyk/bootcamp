create table roles
(
    id                int auto_increment primary key,
    role_name         varchar(20)  not null,
    creation_date     timestamp(6) null,
    modification_date timestamp(6) null,
    constraint role_name unique (role_name)
);

