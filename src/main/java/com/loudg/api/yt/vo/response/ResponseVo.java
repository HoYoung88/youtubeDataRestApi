package com.loudg.api.yt.vo.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Data
public class ResponseVo<T> {
  int code;
  String message;
  String channelId;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  T data;
  String timestamp;

}
