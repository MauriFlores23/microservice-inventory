package com.mauriflores.ms.inventoryservice.infrastructure.adapter.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mauriflores.ms.inventoryservice.domain.exception.ProductNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //Error de negocio controladoss
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(ProductNotFoundException foundException) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", "404");
        body.put("error","Not found");
        body.put("message", foundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

   @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
    Map<String, String> errors = ex.getBindingResult()
      .getFieldErrors()
      .stream()
      .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

    return ResponseEntity.badRequest().body(Map.of("errors", errors));
  }

  @ExceptionHandler(org.springframework.web.bind.MissingServletRequestParameterException.class)
public ResponseEntity<Map<String, Object>> handleMissingParams(
        org.springframework.web.bind.MissingServletRequestParameterException ex
) {
    Map<String, Object> body = new HashMap<>();
    body.put("status", 400);
    body.put("error", "Bad Request");
    body.put("message", ex.getMessage());

    return ResponseEntity.badRequest().body(body);
}

}
