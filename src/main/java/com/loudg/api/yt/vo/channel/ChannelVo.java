package com.loudg.api.yt.vo.channel;

import com.fasterxml.jackson.databind.JsonNode;
import com.loudg.api.yt.entity.Channel;
import com.loudg.api.yt.handler.type.JsonNodeValue;
import com.loudg.api.yt.vo.core.BaseChannelVo;
import com.loudg.api.yt.vo.stat.StatVo;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Getter
public class ChannelVo extends BaseChannelVo {
  public String banner;
  long views;
  long estimatedMinutesWatched;
  long likes;
  long subscribers;
  StatVo stat;

  List<CardVo> cards;

  public void setBanner(Supplier<String> banner) {
    this.banner = banner.get();
  }

  public ChannelVo setViews(Supplier<Long> views) {
    this.views = views.get();
    return this;
  }

  public ChannelVo setEstimatedMinutesWatched(Supplier<Long> estimatedMinutesWatched) {
    this.estimatedMinutesWatched = estimatedMinutesWatched.get();
    return this;
  }

  public ChannelVo setLikes(Supplier<Long> likes) {
    this.likes = likes.get();
    return this;
  }

  public ChannelVo setSubscribers(Supplier<Long> subscribers) {
    this.subscribers = subscribers.get();
    return this;
  }

  public ChannelVo setStat(StatVo stat) {
    this.stat = stat;
    return this;
  }

}
