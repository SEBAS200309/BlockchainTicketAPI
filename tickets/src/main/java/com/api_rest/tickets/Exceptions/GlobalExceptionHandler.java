package com.api_rest.tickets.Exceptions;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1) Errores de validación @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        fe -> fe.getField(),
                        fe -> fe.getDefaultMessage()
                ));

        return ResponseEntity.badRequest().body(errors);
    }

    // 2) Errores al parsear JSON (por tipos o estructura)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleJsonParseError(
            HttpMessageNotReadableException ex) {

        Throwable cause = ex.getMostSpecificCause();
        String message;

        if (cause instanceof MismatchedInputException) {
            // Hacemos cast para poder usar getOriginalMessage()
            MismatchedInputException mie = (MismatchedInputException) cause;
            message = mie.getOriginalMessage();
        } else {
            // Para otros casos, fallback al getMessage()
            message = cause.getMessage();
        }

        return ResponseEntity
                .badRequest()
                .body(Collections.singletonMap("error", "JSON parse error: " + message));
    }

    // (Opcional) otros handlers para ConstraintViolationException, etc.
}