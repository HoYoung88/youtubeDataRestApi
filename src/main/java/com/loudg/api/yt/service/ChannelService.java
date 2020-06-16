package com.loudg.api.yt.service;

import com.loudg.api.yt.entity.Channel;
import com.loudg.api.yt.entity.ChannelStat;
import com.loudg.api.yt.mapper.channel.ChannelMapper;
import com.loudg.api.yt.vo.channel.ChannelVo;
import com.loudg.api.yt.vo.response.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Slf4j
@Service
public class ChannelService {
  @Resource
  private ChannelMapper channelMapper;

  private Channel channelEntity;
  private ChannelStat channelStatEntity;
  private ResponseVo<ChannelVo> response;

  @PostConstruct
  public void init() {
    this.channelEntity = new Channel();
    this.channelStatEntity = new ChannelStat();
    this.response = new ResponseVo<>();
  }

  public ChannelVo findChannelInfoById(String channelId) {
    this.channelEntity.setChannelId(channelId);
    this.channelStatEntity.setChannelId(channelId);

    Channel channelEntity = channelMapper.selectChannelInfo(this.channelEntity);
    if(ObjectUtils.isEmpty(channelEntity)) {
      return null;
    }

    ChannelVo channelVo = new ChannelVo();
    channelVo.setChannelId(channelEntity::getChannelId);
    channelVo.setBanner(channelEntity::getBanner);
    channelVo.setDescription(channelEntity::getDescription);
    channelVo.setPublishedAt(channelEntity::getPublishedAt);
    channelVo.setThumbnails(channelEntity::getThumbnails);
    channelVo.setTitle(channelEntity::getTitle);

    channelVo.setViews(channelEntity::getViews);
    channelVo.setEstimatedMinutesWatched(channelEntity::getEstimatedMinutesWatched);
    channelVo.setSubscribers(channelEntity::getSubscribers);

    return channelVo;

  }
}
