package com.loudg.api.yt.vo.video;

import com.loudg.api.yt.vo.core.BaseChannelVo;
import lombok.Getter;

import java.util.function.Supplier;

@Getter
public class VideoVo extends BaseChannelVo {
  String videoId;
  String duration;

  public void setVideoId(Supplier<String> videoId) {
    this.videoId = videoId.get();
  }

  public void setDuration(Supplier<String> duration) {
    this.duration = duration.get();
  }
}
