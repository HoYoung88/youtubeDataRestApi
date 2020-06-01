package com.loudg.api.yt.vo.playlist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class PlaylistStatVo {
  String month;
  long views;
  long estimatedMinutesWatched;
  long subscribers;
  long viewsIncreasPercent;
  long estimatedMinutesWatchedIncreasPercent;
  long subscribersIncreaseIncreasPercent;
  
  @JsonIgnore
  String playlistId;
}
