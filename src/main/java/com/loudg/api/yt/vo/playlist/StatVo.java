package com.loudg.api.yt.vo.playlist;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StatVo {
//  long totalViews;
//  long totalEstimatedMinutesWatched;
//  long totalSubscribers;
  
  List<StatViewsVo> views = new ArrayList<>();
  List<StatEstimatedMinutesWatchedVo> estimatedMinutesWatched = new ArrayList<>();
  List<StatSubscribersVo> subscribers = new ArrayList<>();
  
  public void setViews(StatViewsVo statViewsVo) {
    this.views.add(statViewsVo);
  }
  
  public void setEstimatedMinutesWatched(StatEstimatedMinutesWatchedVo statEstimatedMinutesWatchedVo) {
    this.estimatedMinutesWatched.add(statEstimatedMinutesWatchedVo);
  }
  
  public void setSubscribers(StatSubscribersVo statSubscribersVo) {
    this.subscribers.add(statSubscribersVo);
  }
}
