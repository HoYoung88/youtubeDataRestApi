package com.loudg.api.yt.vo.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.loudg.api.yt.handler.type.JsonNodeValue;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.function.Supplier;

public class BaseChannelVo {
  @JsonIgnore
  @Getter
  public String channelId;
  @Getter
  public String title;
  @Getter
  public String description;
  @Setter
  public String thumbnails;
  @Getter
  public Date publishedAt;

  public JsonNode getThumbnails() {
    return JsonNodeValue.from(this.thumbnails).get();
  }

  public void setChannelId(Supplier<String> channelId) {
    this.channelId = channelId.get();
  }

  public void setTitle(Supplier<String> title) {
    this.title = title.get();
  }

  public void setDescription(Supplier<String> description) {
    this.description = description.get();
  }

  public void setThumbnails(Supplier<String> thumbnails) {
    this.thumbnails = thumbnails.get();
  }

  public void setPublishedAt(Supplier<Date> publishedAt) {
    this.publishedAt = publishedAt.get();
  }
}
