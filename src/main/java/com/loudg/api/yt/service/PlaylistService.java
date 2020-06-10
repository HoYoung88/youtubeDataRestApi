package com.loudg.api.yt.service;

import com.loudg.api.yt.entity.Channel;
import com.loudg.api.yt.entity.ChannelStat;
import com.loudg.api.yt.entity.Playlist;
import com.loudg.api.yt.mapper.playlist.PlaylistMapper;
import com.loudg.api.yt.vo.channel.ChannelVo;
import com.loudg.api.yt.vo.playlist.*;
import com.loudg.api.yt.vo.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PlaylistService {
  @Resource
  private PlaylistMapper playlistMapper;

  private ApiResponse<List<PlaylistVo>> response;

  @PostConstruct
  public void init() {
    this.response = new ApiResponse<>();
  }
  
  public ApiResponse<List<PlaylistVo>> findPlaylist(String channelId) {
    Playlist playlist = new Playlist();
    playlist.setChannelId(channelId);
    List<Playlist> playlistDatas = playlistMapper.selectPlaylist(playlist);

    List<PlaylistVo> playlistVos = playlistDatas.stream().map(entity -> {
      PlaylistVo playlistVo = new PlaylistVo();
      playlistVo.setPlaylistId(entity::getPlaylistId);
      playlistVo.setChannelId(entity::getChannelId);
      playlistVo.setDescription(entity::getDescription);
      playlistVo.setThumbnails(entity::getThumbnails);
      playlistVo.setTitle(entity::getTitle);
      return playlistVo;
    }).collect(Collectors.toList());

    this.response.setData(playlistVos);


//    List<PlaylistStatVo> playlistStatVos = playlistMapper.selectPlaylistStatMonth(paramPlaylistVo);

//    List<PlaylistVo> datas = playlistVoList.stream()
//        .map(playlistVo -> {
//          StatVo statVo = new StatVo();
//          playlistStatVos.stream()
//              .filter(playlistStatVo -> playlistStatVo.getPlaylistId().equals(playlistVo.getPlaylistId()))
//              .forEach(playlistStatVo -> {
//                String month = playlistStatVo.getMonth();
//                statVo.setViews(new StatViewsVo(month, playlistStatVo.getViews(), playlistStatVo.getViewsIncreasPercent()));
//                statVo.setEstimatedMinutesWatched(new StatEstimatedMinutesWatchedVo(month, playlistStatVo.getEstimatedMinutesWatched(), playlistStatVo.getEstimatedMinutesWatchedIncreasPercent()));
//                statVo.setSubscribers(new StatSubscribersVo(month, playlistStatVo.getSubscribers(), playlistStatVo.getSubscribersIncreaseIncreasPercent()));
//              });
//          playlistVo.setStat(statVo);
//
//          return playlistVo;
//        }).collect(Collectors.toList());

//    this.response.setData(datas);
    return this.response;
  }
}