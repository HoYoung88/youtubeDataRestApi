package com.loudg.api.yt.controller;

import com.loudg.api.yt.controller.core.CoreRestController;
import com.loudg.api.yt.service.ChannelService;
import com.loudg.api.yt.vo.channel.ChannelVo;
import com.loudg.api.yt.vo.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ChannelRestContoller extends CoreRestController {

  @Autowired
  private ChannelService channelService;

  @GetMapping("/channel/{channelId}")
  public ResponseEntity<ApiResponse<ChannelVo>> channelInfo(
      @PathVariable("channelId") String channelId
  ) {
    ApiResponse<ChannelVo> response = channelService.findChannelInfoById(channelId);
    response.setChannelId(channelId);
    if (ObjectUtils.isEmpty(response.getData())) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(response);
  }
}
