package com.loudg.api.yt.vo.video;

import lombok.Data;

@Data
public class VideoStatVo {
  String videoId;
  String date;
  long views;
  long likes;
  long estimatedMinutesWatched;
  long subscribers;
}
