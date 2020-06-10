package com.loudg.api.yt.entity;

import lombok.Data;

@Data
public class Playlist {
  String playlistId;
  String title;
  String description;
  String thumbnails;
  String channelId;
}
