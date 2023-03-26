package by.bootcamp.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
public class RequestForCreateUser {

    //@Schema(description = "User surname", required = true, defaultValue = "surname", type = "string")
    @Pattern(regexp = "^[A-Za-z]{1,40}$", message = "Surname must be between 1 and 40 Latin characters.")
    private String surname;

    //@Schema(description = "User patronymic", required = true, defaultValue = "", type = "string")
    @Pattern(regexp = "^[A-Za-z]{1,20}$", message = "Name must be between 1 and 20 Latin characters.")
    private String name;

    //@Schema(description = "User patronymic", required = true, defaultValue = "patronymic", type = "string")
    @Pattern(regexp = "^[A-Za-z]{1,40}$", message = "Patronymic must be between 1 and 40 Latin characters.")
    private String patronymic;

    //@Schema(description = "User email", required = true, defaultValue = "user@gmail.com", type = "string")
    @Size(max = 50, message = "Email must be less than or equal to 50 characters.")
    @Email(regexp = "^[A-Za-z][\\w.]+@[A-Za-z]+\\.[A-Za-z]{2,}$",
            message = "Invalid email format. Example: user@gmail.com")
    private String email;

    //@Schema
    @NotBlank(message = "User must have role.")
    private String role;
}
