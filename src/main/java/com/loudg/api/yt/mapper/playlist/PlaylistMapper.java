package com.loudg.api.yt.mapper.playlist;

import com.loudg.api.yt.entity.Playlist;
import com.loudg.api.yt.vo.playlist.PlaylistVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlaylistMapper {
    List<Playlist> selectPlaylist(Playlist playlist);
}
