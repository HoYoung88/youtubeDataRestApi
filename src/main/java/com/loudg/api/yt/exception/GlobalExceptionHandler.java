package com.loudg.api.yt.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Data
class GlobalError {
  int code;
  String message;
  String timestamp;
}

@Slf4j
//@RestControllerAdvice(basePackages = {"com.loudg.api.yt.controller"})
public class GlobalExceptionHandler {

  @ExceptionHandler({RuntimeException.class, Exception.class})
  public ResponseEntity handleRuntimeException(Exception e, HttpRequestHandlerServlet servlet) {
    GlobalError globalError = new GlobalError();
    globalError.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    globalError.setMessage(e.getMessage());
    Calendar cal = Calendar.getInstance();
    globalError.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime()));


    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .contentType(MediaType.APPLICATION_JSON)
        .body(globalError);
  }


  /*

  @ExceptionHandler(HttpClientErrorException.NotFound.class)
  public String handle() {
    return "Not Found Exception";
  }
  */

}
