package com.loudg.api.yt.entity;

import lombok.Data;

@Data
public class ChannelStat {
  String channelId;
  String date;
  long views;
  long estimatedMinutesWatched;
  long likes;
  long subscribers;
}
