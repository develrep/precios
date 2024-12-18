package com.prices.hex.infrastructure.exception;

import com.prices.hex.domain.PriceNotFoundException;
import java.util.Collections;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {PriceNotFoundException.class})
    protected ResponseEntity<?> handleEmptyResultDataAccessException(final PriceNotFoundException exc, final WebRequest request) {
        if (exc.getMessage() != null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("message", exc.getMessage()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("message", "Elemento no encontrado"));
        }
    }
    
    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<?> handleDefaultException(final Exception exc, final WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("message", "Ha ocurrido un problema al realizar la operacion"));
    }

}
