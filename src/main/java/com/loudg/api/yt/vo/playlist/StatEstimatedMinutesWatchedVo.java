package com.loudg.api.yt.vo.playlist;

import lombok.Data;

@Data
public class StatEstimatedMinutesWatchedVo {
  String month;
  long value;
  float increasPercent;
  
  public StatEstimatedMinutesWatchedVo(String month, long estimatedMinutesWatched, float increasPercent) {
    this.month = month;
    this.value = estimatedMinutesWatched;
    this.increasPercent = increasPercent;
  }
}
