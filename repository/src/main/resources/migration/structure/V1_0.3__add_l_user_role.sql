create table l_user_role
(
    id            bigint auto_increment primary key,
    user_id       bigint       not null,
    role_id       int          not null,
    creation_date timestamp(6) not null,
    constraint l_user_role_user_id_role_id_uindex
        unique (user_id, role_id),
    constraint l_user_role_roles_id_fk
        foreign key (role_id) references roles (id),
    constraint l_user_role_users_id_fk
        foreign key (user_id) references users (id)
);

