package com.loudg.api.yt.controller;

import com.loudg.api.yt.controller.core.CoreRestController;
import com.loudg.api.yt.service.VideoService;
import com.loudg.api.yt.vo.video.VideoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class VideoRestController extends CoreRestController {
  
  @Autowired
  private VideoService videoService;
  
  @GetMapping("/channel/{channelId}/videos")
  public ResponseEntity<List<VideoVo>> videos(@PathVariable("channelId") String channelId) {
    return ResponseEntity.ok(videoService.findVideoList(channelId));
  }
}
