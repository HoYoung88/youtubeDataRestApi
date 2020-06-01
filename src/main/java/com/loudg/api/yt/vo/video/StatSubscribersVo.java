package com.loudg.api.yt.vo.video;

import lombok.Data;

@Data
public class StatSubscribersVo {
  String date;
  long value;
  
  public StatSubscribersVo(String date, long value) {
    this.date = date;
    this.value = value;
  }
}
