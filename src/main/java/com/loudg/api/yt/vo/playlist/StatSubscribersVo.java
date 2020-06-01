package com.loudg.api.yt.vo.playlist;

import lombok.Data;

@Data
public class StatSubscribersVo {
  String month;
  long value;
  float increasPercent;
  
  public StatSubscribersVo(String month, long subscribers, float increasPercent) {
    this.month = month;
    this.value = subscribers;
    this.increasPercent = increasPercent;
  }
}
