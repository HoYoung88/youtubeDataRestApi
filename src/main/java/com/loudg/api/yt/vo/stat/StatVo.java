package com.loudg.api.yt.vo.stat;

import java.util.ArrayList;
import java.util.List;

public class StatVo<
    V extends ViewsVo,
    E extends EstimatedMinutesWatchedVo,
    T extends SubscribersVo> {
  List<V> views;
  List<E> estimatedMinutesWatched;
  List<T> subscribers;

  public StatVo() {
    this.views = new ArrayList<>();
    this.estimatedMinutesWatched = new ArrayList<>();
    this.subscribers = new ArrayList<>();
  }

  public void setViews(V item) {
    this.views.add(item);
  }

  public void setEstimatedMinutesWatched(E item) {
    this.estimatedMinutesWatched.add(item);
  }

  public void setSubscribers(T item) {
    this.subscribers.add(item);
  }

  public List<V> getViews() {
    return views;
  }

  public List<E> getEstimatedMinutesWatched() {
    return estimatedMinutesWatched;
  }

  public List<T> getSubscribers() {
    return subscribers;
  }
}
