package by.bootcamp.controller.responce;

import lombok.Data;

import java.util.Set;

@Data
public class UserResponse {

    private String surname;

    private String name;

    private String patronymic;

    private String email;

    private Set<RoleResponse> roles;
}
