package by.bootcamp.service.request;

import by.bootcamp.domain.UserRoles;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class RequestForCreateUser {

    private String name;

    private String surname;


    private String patronymic;

    private String email;

    private Set<UserRoles> roles;
}
