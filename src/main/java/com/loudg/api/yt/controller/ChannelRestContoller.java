package com.loudg.api.yt.controller;

import com.loudg.api.yt.controller.core.CoreRestController;
import com.loudg.api.yt.service.ChannelService;
import com.loudg.api.yt.vo.channel.ChannelVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Slf4j
@RestController
public class ChannelRestContoller extends CoreRestController {

  @Autowired
  private ChannelService channelService;

  @GetMapping("/channel/{channelId}")
  public ResponseEntity channelInfo(
      @PathVariable("channelId") String channelId
  ) {
    ChannelVo responseData = channelService.findChannelInfoById(channelId);
    super.apiResponseVo.setChannelId(channelId);
    super.apiResponseVo.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        .format(Calendar.getInstance().getTime()));

    if (ObjectUtils.isEmpty(responseData)) {
      super.apiResponseVo.setCode(404);
      super.apiResponseVo.setMessage("no Data");
      super.apiResponseVo.setData(null);
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body(apiResponseVo);
    }

    super.apiResponseVo.setCode(HttpStatus.OK.value());
    super.apiResponseVo.setMessage(HttpStatus.OK.getReasonPhrase());
    super.apiResponseVo.setData(responseData);
    return ResponseEntity.ok(apiResponseVo);
  }
}
