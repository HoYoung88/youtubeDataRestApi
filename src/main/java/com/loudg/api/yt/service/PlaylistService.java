package com.loudg.api.yt.service;

import com.loudg.api.yt.entity.Playlist;
import com.loudg.api.yt.mapper.playlist.PlaylistMapper;
import com.loudg.api.yt.properties.PagingProperties;
import com.loudg.api.yt.vo.playlist.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
  @Autowired
  protected PagingProperties pagingProperties;

  private Playlist playlistEntity;

  @PostConstruct
  public void init() {
    this.playlistEntity = new Playlist();
  }
  
  public List<PlaylistVo> findPlaylist(String channelId, int page) {

    this.playlistEntity.setChannelId(channelId);
    this.playlistEntity.setPage((page - 1) * pagingProperties.getRowsCount());
    this.playlistEntity.setRowCount(pagingProperties.getRowsCount());

    List<Playlist> playlistDatas = playlistMapper.selectPlaylist(this.playlistEntity);

    return playlistDatas.stream().map(item -> {
      PlaylistVo playlistVo = new PlaylistVo();
      playlistVo.setPlaylistId(item::getPlaylistId);
      playlistVo.setChannelId(item::getChannelId);
      playlistVo.setDescription(item::getDescription);
      playlistVo.setThumbnails(item::getThumbnails);
      playlistVo.setTitle(item::getTitle);
      playlistVo.setPublishedAt(item::getPublishedAt);
      playlistVo.setViews(item::getViews);
      playlistVo.setEstimatedMinutesWatched(item::getEstimatedMinutesWatched);
      playlistVo.setSubscribers(item::getSubscribers);
      return playlistVo;
    }).collect(Collectors.toList());
  }
}