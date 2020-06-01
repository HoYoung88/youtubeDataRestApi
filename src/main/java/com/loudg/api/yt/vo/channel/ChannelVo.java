package com.loudg.api.yt.vo.channel;

import com.fasterxml.jackson.databind.JsonNode;
import com.loudg.api.yt.handler.type.JsonNodeValue;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ChannelVo {
  String channelId;
  String title;
  String description;
  String banner;
  String thumbnails;
  Date publishedAt;
  List<CardVo> cards;
  
  public JsonNode getThumbnails() {
    return JsonNodeValue.from(this.thumbnails).get();
  }
  
  public void setThumbnails(String thumbnails) {
    this.thumbnails = thumbnails;
  }
}
