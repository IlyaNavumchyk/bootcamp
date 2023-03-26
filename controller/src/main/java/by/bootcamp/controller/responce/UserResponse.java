package by.bootcamp.controller.responce;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Schema(description = "Convert user to response.")
@Data
public class UserResponse {

    @Schema(description = "User surname", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "surname", type = "string")
    private String surname;

    @Schema(description = "User name", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "name", type = "string")
    private String name;

    @Schema(description = "User patronymic", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "patronymic", type = "string")
    private String patronymic;

    @Schema(description = "User email", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "user.123@gmail.com", type = "string")
    private String email;

    @Schema(description = "User roles", requiredMode = Schema.RequiredMode.REQUIRED)
    private Set<RoleResponse> roles;
}
