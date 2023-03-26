# bootcamp

## Описание

Тестовый проект представляет из себя многомодульный maven проект(
3-level three-module development architecture) - 
простую REST-приложеньку с двумя end-поинтами:

### - добавление пользователя -> POST /users

#### Основные поля:

+ Фамилия(40 символов, только латинские буквы)
+ Имя(20 символов, только латинские буквы)
+ Отчество(40 символов, только латинские буквы)
+ Email(50 символов, стандартный шаблон)
+ Role(Administrator, Sale User, Customer User, Secure API User)

### - получения всех пользователей -> GET/{page_number}

page_number - номер страницы, опциональный параметр.
Выполнен постраничный вывод записей по 10 пользователей.
Записи отсортированы по email в алфавитном порядке.

## Технологии
- Java 11
- Log4j2, Logback
- Spring Boot 2
- Spring (Data JPA, WEB, AOP, Validation)
- MySQL 8
- FlyWay
- Springdoc OpenAPI (Swagger 3)
- Lombok
- MapStruct