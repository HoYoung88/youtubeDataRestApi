package com.loudg.api.yt.vo.video;

import lombok.Data;

@Data
public class StatViewsVo {
  String date;
  long value;
  
  public StatViewsVo(String date, long value) {
    this.date = date;
    this.value = value;
  }
}
