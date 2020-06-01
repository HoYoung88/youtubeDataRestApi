package com.loudg.api.yt.service;

import com.loudg.api.yt.mapper.channel.ChannelMapper;
import com.loudg.api.yt.vo.channel.ChannelVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChannelService {
  @Resource
  private ChannelMapper channelMapper;
  
  public ChannelVo selectChannelInfo(String channelId) {
    return channelMapper.selectChannelInfo(channelId);
  }
}
