package com.loudg.api.yt.service;

import com.loudg.api.yt.mapper.playlist.PlaylistMapper;
import com.loudg.api.yt.vo.playlist.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class PlaylistService {
  @Resource
  private PlaylistMapper playlistMapper;
  
  public List<PlaylistVo> findPlaylist(String channelId) {
    List<PlaylistVo> playlistVoList = playlistMapper.selectPlaylist(channelId);
    List<PlaylistStatVo> playlistStatVos = playlistMapper.selectPlaylistStatMonth(channelId);
    playlistVoList.forEach(playlistVo -> {
      StatVo statVo = new StatVo();
      playlistStatVos.forEach(playlistStatVo -> {
        if(playlistStatVo.getPlaylistId().equals(playlistVo.getPlaylistId())) {
          String month = playlistStatVo.getMonth();
          
          statVo.setViews(new StatViewsVo(month, playlistStatVo.getViews(), playlistStatVo.getViewsIncreasPercent()));
          
          statVo.setEstimatedMinutesWatched(new StatEstimatedMinutesWatchedVo(month, playlistStatVo.getEstimatedMinutesWatched(), playlistStatVo.getEstimatedMinutesWatchedIncreasPercent()));
          
          statVo.setSubscribers(new StatSubscribersVo(month, playlistStatVo.getSubscribers(), playlistStatVo.getSubscribersIncreaseIncreasPercent()));
          
        }
      });
  
      playlistVo.setStat(statVo);
    });
    
    return playlistVoList;
  }
}