package com.jejo.encode_decode.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionConfig {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MensajeResponse> handleEndpoint(NoHandlerFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new MensajeResponse("Enpoint no encontrado: " + ex.getRequestURL()
                        + "\nDetalles:" + ex.getMessage()));
    }

    // Captura ONLY @Valid exceptions
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MensajeResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        String jsonErrors = convertMapToJson(errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensajeResponse(jsonErrors));
    }

    // Captura IllegalArgumentException (throws manuales)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<MensajeResponse> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new MensajeResponse("Error: " + ex.getMessage()));
    }

    // Captura RuntimeException (throws manuales)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<MensajeResponse> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new MensajeResponse("Error interno: " + ex.getMessage()));
    }

    // Captura ANY otra excepción
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MensajeResponse> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new MensajeResponse("Error inesperado: " + ex.getMessage()));
    }

    private String convertMapToJson(Map<String, String> map) {
        try {
            return new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            return "{\"error\": \"Failed to process validation errors\"}";
        }
    }
}