create table roles
(
    id                int auto_increment primary key,
    role_name         varchar(20)  not null,
    constraint role_name unique (role_name)
);

