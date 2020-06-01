package com.loudg.api.yt.controller;

import com.loudg.api.yt.controller.core.CoreRestController;
import com.loudg.api.yt.service.PlaylistService;
import com.loudg.api.yt.vo.playlist.PlaylistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PlaylistRestController extends CoreRestController {
  
  @Autowired
  private PlaylistService playlistService;
  
  @GetMapping("/channel/{channelId}/playlist")
  public ResponseEntity<List<PlaylistVo>> playlist(@PathVariable("channelId") String channelId) {
    List<PlaylistVo> playlist = playlistService.findPlaylist(channelId);
    
    if (playlist.size() <= 0) {
      return ResponseEntity.noContent().build();
    }
    
    return ResponseEntity.ok(playlist);
  }
}
