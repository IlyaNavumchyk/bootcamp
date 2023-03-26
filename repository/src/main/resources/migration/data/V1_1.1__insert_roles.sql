insert into roles (role_name)
values ('ROLE_ADMINISTRATOR'),
       ('ROLE_SALE_USER'),
       ('ROLE_CUSTOMER_USER'),
       ('ROLE_SECURE_API_USER');

update roles
set creation_date = current_timestamp(6);