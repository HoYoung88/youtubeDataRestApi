package com.loudg.api.yt.service;

import com.loudg.api.yt.mapper.video.VideoMapper;
import com.loudg.api.yt.vo.video.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class VideoService {
  @Resource
  private VideoMapper videoMapper;
  
  public List<VideoVo> findVideoList(String channelId) {
    List<VideoVo> videoVos = videoMapper.selectVideos(channelId);
    List<VideoStatVo> videoStatVos = videoMapper.selectVideoStat(channelId);
  
    videoVos.forEach(videoVo -> {
      StatVo statVo = new StatVo();
      videoStatVos.forEach(videoStatVo -> {
        if(videoVo.getVideoId().equals(videoStatVo.getVideoId())) {
          String date = videoStatVo.getDate();
          
          statVo.setViews(new StatViewsVo(date, videoStatVo.getViews()));
          
          statVo.setEstimatedMinutesWatched(new StatEstimatedMinutesWatchedVo(date, videoStatVo.getEstimatedMinutesWatched()));
          
          statVo.setSubscribers(new StatSubscribersVo(date, videoStatVo.getSubscribers()));
  
          statVo.setLikes(new StatLikesVo(date, videoStatVo.getLikes()));
        }
      });
      videoVo.setStat(statVo);
    });
    
    return videoVos;
  }
}
