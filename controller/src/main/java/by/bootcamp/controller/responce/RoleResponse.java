package by.bootcamp.controller.responce;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Convert role to response.")
@Data
public class RoleResponse {

    @Schema(description = "User role", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "Customer_User", type = "string")
    private String roleName;
}
