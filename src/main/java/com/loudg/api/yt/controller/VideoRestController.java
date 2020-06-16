package com.loudg.api.yt.controller;

import com.loudg.api.yt.controller.core.CoreRestController;
import com.loudg.api.yt.service.VideoService;
import com.loudg.api.yt.vo.response.ResponseVo;
import com.loudg.api.yt.vo.video.VideoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class VideoRestController extends CoreRestController {

  @Autowired
  private VideoService videoService;

  @GetMapping("/channel/{channelId}/videos")
  public ResponseEntity findChannelVideos(
      @PathVariable("channelId") String channelId,
      @RequestParam(value = "page") int page
  ) {
    super.apiResponseVo.setChannelId(channelId);
    super.apiResponseVo.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        .format(Calendar.getInstance().getTime()));

    List<VideoVo> responseData = videoService.findVideoList(channelId, page);

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
