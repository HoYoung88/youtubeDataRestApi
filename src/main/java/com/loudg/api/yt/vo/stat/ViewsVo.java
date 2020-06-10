package com.loudg.api.yt.vo.stat;

import lombok.Getter;

@Getter
public class ViewsVo {
  String date;
  long value;

  public ViewsVo(String date, long value) {
    this.date = date;
    this.value = value;
  }
}
