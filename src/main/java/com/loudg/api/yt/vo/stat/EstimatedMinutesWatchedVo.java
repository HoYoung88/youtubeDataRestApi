package com.loudg.api.yt.vo.stat;

import lombok.Getter;

@Getter
public class EstimatedMinutesWatchedVo {
  String date;
  long value;

  public EstimatedMinutesWatchedVo(String date, long value) {
    this.date = date;
    this.value = value;
  }
}
