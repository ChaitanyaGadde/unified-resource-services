package com.unified.resource.controller;

import javax.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<String> handle(ConstraintViolationException constraintViolationException) {
    return new ResponseEntity<>(constraintViolationException.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(HttpClientErrorException.class)
  public ResponseEntity<String> handle(HttpClientErrorException ex) {
    return new ResponseEntity<>(ex.getMessage(), ex.getStatusCode());
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<String> handleIllegalArgument(MethodArgumentTypeMismatchException exception) {
    log.error(exception.getMessage(), exception);
    return new ResponseEntity<>("Illegal value for: " + exception.getName(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handle(Exception exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
