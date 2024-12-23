package com.prices.hex.infrastructure.adapter.api.exception;

import com.prices.hex.domain.exception.PriceNotFoundException;
import java.util.Collections;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = {PriceNotFoundException.class})
    protected ResponseEntity<Map<String, String>> handleEmptyResultDataAccessException(final PriceNotFoundException exc, final WebRequest request) {
        if (exc.getMessage() != null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("message", exc.getMessage()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("message", "Elemento no encontrado"));
        }
    }
    
    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Map<String, String>> handleException(final Exception exc, final WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("message", "Ha ocurrido un problema al realizar la operacion"));
    }

}
