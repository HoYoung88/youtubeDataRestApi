package com.loudg.api.yt.vo.video;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StatVo {
  List<StatViewsVo> views = new ArrayList<>();
  List<StatEstimatedMinutesWatchedVo> estimatedMinutesWatched = new ArrayList<>();
  List<StatSubscribersVo> subscribers = new ArrayList<>();
  List<StatLikesVo> likes = new ArrayList<>();
  public void setViews(StatViewsVo statViewsVo) {
    this.views.add(statViewsVo);
  }
  
  public void setEstimatedMinutesWatched(StatEstimatedMinutesWatchedVo statEstimatedMinutesWatchedVo) {
    this.estimatedMinutesWatched.add(statEstimatedMinutesWatchedVo);
  }
  
  public void setSubscribers(StatSubscribersVo statSubscribersVo) {
    this.subscribers.add(statSubscribersVo);
  }
  
  public void setLikes(StatLikesVo statLikesVo) {
    this.likes.add(statLikesVo);
  }
}
