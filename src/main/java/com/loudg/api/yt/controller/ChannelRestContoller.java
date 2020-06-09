package com.loudg.api.yt.controller;

import com.loudg.api.yt.controller.core.CoreRestController;
import com.loudg.api.yt.service.ChannelService;
import com.loudg.api.yt.vo.channel.ChannelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChannelRestContoller extends CoreRestController {
  
  @Autowired
  private ChannelService channelService;
  
  @GetMapping("/channel/{channelId}")
  public ResponseEntity<ChannelVo> channelInfo(@PathVariable("channelId") String channelId) {
    ChannelVo channelVo = channelService.selectChannelInfo(channelId);
    if(channelVo == null) {
      return ResponseEntity.noContent().build();
    }
    
    return ResponseEntity.ok(channelService.selectChannelInfo(channelId));
  }
}
