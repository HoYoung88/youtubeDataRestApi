package com.loudg.api.yt.vo.playlist;

import com.fasterxml.jackson.databind.JsonNode;
import com.loudg.api.yt.handler.type.JsonNodeValue;
import lombok.Data;

@Data
public class PlaylistVo {
  long views;
  long estimatedMinutesWatched;
  long subscribersGained;
  String title;
  String description;
  String channelId;
  String playlistId;
  String thumbnails;
  StatVo stat;
  
  public JsonNode getThumbnails() {
    return JsonNodeValue.from(this.thumbnails).get();
  }
  
  public void setThumbnails(String thumbnails) {
    this.thumbnails = thumbnails;
  }
  
}
