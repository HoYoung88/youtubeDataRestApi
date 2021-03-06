package com.loudg.api.yt.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Playlist {
  String playlistId;
  String title;
  String description;
  String thumbnails;
  String channelId;
  Date publishedAt;

  long views;
  long estimatedMinutesWatched;
  long subscribers;

  int page;
  int rowCount;
}
