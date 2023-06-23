package com.martian.robots.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MartianRobotException.class)
  public ResponseEntity<String> handleMartianRobotException(MartianRobotException e) {
    String errorMessage = e.getMessage();
    return ResponseEntity.badRequest().body(errorMessage);
  }
}
