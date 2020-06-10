package com.loudg.api.yt.controller;

import com.loudg.api.yt.controller.core.CoreRestController;
import com.loudg.api.yt.service.PlaylistService;
import com.loudg.api.yt.vo.playlist.PlaylistVo;
import com.loudg.api.yt.vo.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaylistRestController extends CoreRestController {

  @Autowired
  private PlaylistService playlistService;

  @GetMapping("/channel/{channelId}/playlist")
  public ResponseEntity<ApiResponse<List<PlaylistVo>>> playlist(
      @PathVariable("channelId") String channelId
  ) {
    ApiResponse<List<PlaylistVo>> response = playlistService.findPlaylist(channelId);
    response.setChannelId(channelId);
    if (ObjectUtils.isEmpty(response.getData())) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(response);
  }

  @GetMapping("/channel/{channelId}/playlist/{playlistId}")
  public ResponseEntity<String> playlistById(
      @PathVariable("channelId") String channelId,
      @PathVariable("playlistId") String playlistId
  ) {
    PlaylistVo playlistVo = new PlaylistVo();
//    playlistVo.setChannelId(channelId);
//    playlistVo.setPlaylistId(playlistId);


    return ResponseEntity.ok("");
  }
}
