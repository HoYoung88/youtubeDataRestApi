package com.loudg.api.yt.vo.playlist;

import com.fasterxml.jackson.databind.JsonNode;
import com.loudg.api.yt.handler.type.JsonNodeValue;
import com.loudg.api.yt.vo.core.BaseChannelVo;
import lombok.Data;
import lombok.Getter;

import java.util.function.Supplier;

@Getter
public class PlaylistVo extends BaseChannelVo {
  public String playlistId;

  public void setPlaylistId(Supplier<String> playlistId) {
    this.playlistId = playlistId.get();
  }
}
