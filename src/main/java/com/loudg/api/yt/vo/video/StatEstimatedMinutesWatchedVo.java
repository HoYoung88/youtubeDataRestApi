package com.loudg.api.yt.vo.video;

import lombok.Data;

@Data
public class StatEstimatedMinutesWatchedVo {
  String date;
  long value;
  
  public StatEstimatedMinutesWatchedVo(String date, long value) {
    this.date = date;
    this.value = value;
  }
}
