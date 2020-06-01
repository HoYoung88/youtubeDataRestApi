package com.loudg.api.yt.vo.video;

import lombok.Data;

@Data
public class StatLikesVo {
  String date;
  long value;
  
  public StatLikesVo(String date, long value) {
    this.date = date;
    this.value = value;
  }
}
