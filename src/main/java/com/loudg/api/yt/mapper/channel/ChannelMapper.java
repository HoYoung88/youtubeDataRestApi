package com.loudg.api.yt.mapper.channel;

import com.loudg.api.yt.entity.Channel;
import com.loudg.api.yt.entity.ChannelStat;
import com.loudg.api.yt.vo.channel.ChannelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChannelMapper {
  Channel selectChannelInfo(Channel channel);
  List<ChannelStat> selectChannelStat(ChannelStat channelStat);
}
