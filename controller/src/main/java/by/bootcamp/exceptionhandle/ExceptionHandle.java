package by.bootcamp.exceptionhandle;

import by.bootcamp.exception.EntityAlreadyExistException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@RestControllerAdvice
public class ExceptionHandle {

    private static final String ERROR = "error";

    @ExceptionHandler({IllegalArgumentException.class, HttpMessageNotReadableException.class,
            EntityAlreadyExistException.class, DataIntegrityViolationException.class})
    public ResponseEntity<Map<String, ErrorContainer>> handleIllegalArgumentException(Exception e) {

        return new ResponseEntity<>(
                Collections.singletonMap(ERROR, composeErrorContainer(e, 400)),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Map<String, ErrorContainer>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        ErrorContainer errorContainer = composeErrorContainer(e, 400);

        StringBuilder sb = new StringBuilder();
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            sb.append(error.getDefaultMessage()).append('\n');
        }
        errorContainer.setMessage(sb.substring(0, sb.length() - 1));

        return new ResponseEntity<>(
                Collections.singletonMap(ERROR, errorContainer),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, ErrorContainer>> handleNoSuchEntityException(Exception e) {

        return new ResponseEntity<>(
                Collections.singletonMap(ERROR, composeErrorContainer(e, 500)),
                HttpStatus.NOT_FOUND
        );
    }

    private ErrorContainer composeErrorContainer(Exception e, int errorCode) {

        return ErrorContainer.builder()
                .exceptionId(UUID.randomUUID().toString())
                .timestamp(LocalDateTime.now())
                .errorCode(errorCode)
                .clazz(e.getClass().getSimpleName())
                .message(e.getMessage())
                .build();
    }
}
