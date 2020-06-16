package com.loudg.api.yt.controller.core;

import com.loudg.api.yt.vo.response.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Slf4j
@CrossOrigin
public class CoreRestController {

  protected ResponseVo apiResponseVo;

  @PostConstruct
  private void init() {
    this.apiResponseVo = new ResponseVo();
  }

  @ExceptionHandler(NotFoundException.class)
  public void notFound(NotFoundException e) {
    log.debug("Not Fount :: {}", e);
  }

}
