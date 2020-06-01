package com.loudg.api.yt.mapper.channel;

import com.loudg.api.yt.vo.channel.ChannelVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChannelMapper {
  ChannelVo selectChannelInfo(String channelId);
}
