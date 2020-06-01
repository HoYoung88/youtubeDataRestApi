package com.loudg.api.yt.vo.playlist;

import lombok.Data;

@Data
public class StatViewsVo {
  String month;
  long value;
  float increasPercent;
  
  public StatViewsVo(String month, long views, float increasPercent) {
    this.month = month;
    this.value = views;
    this.increasPercent = increasPercent;
  }
}
