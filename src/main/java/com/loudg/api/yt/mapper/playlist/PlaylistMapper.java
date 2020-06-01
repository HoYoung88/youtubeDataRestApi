package com.loudg.api.yt.mapper.playlist;

import com.loudg.api.yt.vo.playlist.PlaylistStatVo;
import com.loudg.api.yt.vo.playlist.PlaylistVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlaylistMapper {
    List<PlaylistVo> selectPlaylist(String channel);
    List<PlaylistStatVo> selectPlaylistStatMonth(String channel);
}
