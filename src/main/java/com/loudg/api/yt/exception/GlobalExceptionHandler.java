package com.loudg.api.yt.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = {"com.loudg.api.yt.controller"})
public class GlobalExceptionHandler {
  /*
  @ExceptionHandler(RuntimeException.class)
  public String handleRuntimeException() {
    return "Runtime Exception";
  }
  
  @ExceptionHandler(HttpClientErrorException.NotFound.class)
  public String handle() {
    return "Not Found Exception";
  }
  */
  
}
