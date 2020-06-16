package com.loudg.api.yt.service;

import com.loudg.api.yt.entity.Video;
import com.loudg.api.yt.mapper.video.VideoMapper;
import com.loudg.api.yt.properties.PagingProperties;
import com.loudg.api.yt.vo.video.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VideoService {
  @Resource
  private VideoMapper videoMapper;

  @Autowired
  protected PagingProperties pagingProperties;

  private Video videoEntity;

  @PostConstruct
  public void init() {
    this.videoEntity = new Video();
  }

  public List<VideoVo> findVideoList(String channelId, int page) {
    this.videoEntity.setChannelId(channelId);
    this.videoEntity.setPage((page - 1) * pagingProperties.getRowsCount());
    this.videoEntity.setRowCount(pagingProperties.getRowsCount());

    List<Video> videos = videoMapper.selectVideos(this.videoEntity);

    return videos.stream().map(item -> {
      VideoVo videoVo = new VideoVo();
      videoVo.setVideoId(item::getVideoId);
      videoVo.setTitle(item::getTitle);
      videoVo.setDescription(item::getDescription);
      videoVo.setThumbnails(item::getThumbnails);
      videoVo.setDuration(item::getDuration);
      videoVo.setPublishedAt(item::getPublishedAt);
      videoVo.setViews(item::getViews);
      videoVo.setEstimatedMinutesWatched(item::getEstimatedMinutesWatched);
      videoVo.setSubscribers(item::getSubscribers);
      return videoVo;
    }).collect(Collectors.toList());
  }
}
