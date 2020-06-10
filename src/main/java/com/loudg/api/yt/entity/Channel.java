package com.loudg.api.yt.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Channel {
  String channelId;
  String title;
  String description;
  String banner;
  String thumbnails;
  Date publishedAt;
  long views;
  long estimatedMinutesWatched;
  long likes;
  long subscribers;
}
