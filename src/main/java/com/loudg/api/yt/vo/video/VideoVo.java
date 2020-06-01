package com.loudg.api.yt.vo.video;

import com.fasterxml.jackson.databind.JsonNode;
import com.loudg.api.yt.handler.type.JsonNodeValue;
import lombok.Data;

@Data
public class VideoVo {
  String videoId;
  String title;
  String description;
  String thumbnails;
  String duration;
  String publishedAt;
  long views;
  long estimatedMinutesWatched;
  long subscribers;
  StatVo stat;
  
  public JsonNode getThumbnails() {
    return JsonNodeValue.from(this.thumbnails).get();
  }
  
  public void setThumbnails(String thumbnails) {
    this.thumbnails = thumbnails;
  }
  
}
