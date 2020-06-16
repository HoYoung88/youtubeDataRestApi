package com.loudg.api.yt.entity;

import lombok.Data;
import java.util.Date;

@Data
public class Video  {
  String channelId;
  String videoId;
  String title;
  String description;
  String thumbnails;
  String duration;
  Date publishedAt;

  long views;
  long estimatedMinutesWatched;
  long subscribers;

  int page;
  int rowCount;
}
