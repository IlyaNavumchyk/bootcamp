package by.bootcamp.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Schema(description = "Request to add new user.")
@Setter
@Getter
@ToString
public class RequestForCreateUser {

    @Schema(description = "User surname", requiredMode = Schema.RequiredMode.REQUIRED,
            defaultValue = "surname", type = "string")
    @Pattern(regexp = "^[A-Za-z]{1,40}$", message = "Surname must be between 1 and 40 Latin characters.")
    private String surname;

    @Schema(description = "User name", requiredMode = Schema.RequiredMode.REQUIRED,
            defaultValue = "name", type = "string")
    @Pattern(regexp = "^[A-Za-z]{1,20}$", message = "Name must be between 1 and 20 Latin characters.")
    private String name;

    @Schema(description = "User patronymic", requiredMode = Schema.RequiredMode.REQUIRED,
            defaultValue = "patronymic", type = "string")
    @Pattern(regexp = "^[A-Za-z]{1,40}$", message = "Patronymic must be between 1 and 40 Latin characters.")
    private String patronymic;

    @Schema(description = "User email", requiredMode = Schema.RequiredMode.REQUIRED,
            defaultValue = "user.123@gmail.com", type = "string")
    @Size(max = 50, message = "Email must be less than or equal to 50 characters.")
    @Email(regexp = "^[A-Za-z][\\w.]+@[A-Za-z]+\\.[A-Za-z]{2,}$",
            message = "Invalid email format. Example: user.123@gmail.com")
    private String email;

    @Schema(description = "User role", requiredMode = Schema.RequiredMode.REQUIRED,
            allowableValues = {"Administrator", "Sale_User", "Customer_User", "Secure_API_User"},
            defaultValue = "Customer_User", type = "string")
    @NotBlank(message = "User must have role.")
    private String role;
}
