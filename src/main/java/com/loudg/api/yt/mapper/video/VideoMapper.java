package com.loudg.api.yt.mapper.video;

import com.loudg.api.yt.entity.Video;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VideoMapper {
  List<Video> selectVideos(Video video);
}
