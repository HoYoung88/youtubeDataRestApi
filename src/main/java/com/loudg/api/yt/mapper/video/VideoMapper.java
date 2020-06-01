package com.loudg.api.yt.mapper.video;

import com.loudg.api.yt.vo.video.VideoStatVo;
import com.loudg.api.yt.vo.video.VideoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VideoMapper {
  List<VideoVo> selectVideos(String channelId);
  List<VideoStatVo> selectVideoStat(String channelId);
}
