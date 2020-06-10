package com.loudg.api.yt.service;

import com.loudg.api.yt.entity.Channel;
import com.loudg.api.yt.entity.ChannelStat;
import com.loudg.api.yt.mapper.channel.ChannelMapper;
import com.loudg.api.yt.vo.channel.ChannelVo;
import com.loudg.api.yt.vo.response.ApiResponse;
import com.loudg.api.yt.vo.stat.EstimatedMinutesWatchedVo;
import com.loudg.api.yt.vo.stat.StatVo;
import com.loudg.api.yt.vo.stat.SubscribersVo;
import com.loudg.api.yt.vo.stat.ViewsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.function.Consumer;

@Slf4j
@Service
public class ChannelService {
  @Resource
  private ChannelMapper channelMapper;

  private Channel channelEntity;
  private ChannelStat channelStatEntity;
  private ApiResponse<ChannelVo> response;

  @PostConstruct
  public void init() {
    this.channelEntity = new Channel();
    this.channelStatEntity = new ChannelStat();
    this.response = new ApiResponse<>();
  }

  public ApiResponse<ChannelVo> findChannelInfoById(String channelId) {
    this.channelEntity.setChannelId(channelId);
    this.channelStatEntity.setChannelId(channelId);

    Channel channelEntity = channelMapper.selectChannelInfo(this.channelEntity);
    List<ChannelStat> channelStat = channelMapper.selectChannelStat(this.channelStatEntity);

    if(ObjectUtils.isEmpty(channelEntity)) {
      return this.response;
    }

    StatVo statVo = new StatVo();
    channelStat.stream().forEach(channelStat1 -> {
      statVo.setViews(new ViewsVo(channelStat1.getDate(), channelStat1.getViews()));
      statVo.setEstimatedMinutesWatched(new EstimatedMinutesWatchedVo(channelStat1.getDate(), channelStat1.getEstimatedMinutesWatched()));
      statVo.setSubscribers(new SubscribersVo(channelStat1.getDate(), channelStat1.getSubscribers()));
    });

    ChannelVo channelVo = new ChannelVo();
    channelVo.setChannelId(channelEntity::getChannelId);
    channelVo.setBanner(channelEntity::getBanner);
    channelVo.setDescription(channelEntity::getDescription);
    channelVo.setPublishedAt(channelEntity::getPublishedAt);
    channelVo.setThumbnails(channelEntity::getThumbnails);
    channelVo.setTitle(channelEntity::getTitle);
    channelVo.setViews(channelEntity::getViews);
    channelVo.setEstimatedMinutesWatched(channelEntity::getEstimatedMinutesWatched);
    channelVo.setLikes(channelEntity::getLikes);
    channelVo.setSubscribers(channelEntity::getSubscribers);
    channelVo.setStat(statVo);

    this.response.setData(channelVo);
    return this.response;

  }
}
