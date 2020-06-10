package com.loudg.api.yt.vo.stat;

import lombok.Getter;

@Getter
public class SubscribersVo {
  String date;
  long value;

  public SubscribersVo(String date, long value) {
    this.date = date;
    this.value = value;
  }
}
