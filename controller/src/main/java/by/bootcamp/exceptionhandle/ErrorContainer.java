package by.bootcamp.exceptionhandle;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Compose exception massage.")
@Data
@Builder
public class ErrorContainer {

    @Schema(description = "Exception unique id", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "07bae150-acb3-49bc-b298-a6b13bd3c61a", type = "string")
    private String exceptionId;

    @Schema(description = "Current timestamp", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "2023-03-26T22:23:10.3842149", type = "string")
    private LocalDateTime timestamp;

    @Schema(description = "Error code", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "400", type = "string")
    private int errorCode;

    @Schema(description = "Exception class", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "NumberFormatException", type = "string")
    private String clazz;

    @Schema(description = "Exception massage", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "For input string: z", type = "string")
    private String message;
}
