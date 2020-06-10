package com.loudg.api.yt.vo.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Data
public class ApiResponse<T> {
  int status = HttpStatus.OK.value();
  String message = HttpStatus.OK.getReasonPhrase();
  String channelId;
  T data;
  String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
      .format(Calendar.getInstance().getTime());

}
