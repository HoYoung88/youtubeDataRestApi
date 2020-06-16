package com.loudg.api.yt.vo.channel;

import com.loudg.api.yt.vo.core.BaseChannelVo;
import lombok.Getter;
import java.util.function.Supplier;

@Getter
public class ChannelVo extends BaseChannelVo {
  public String banner;
  public void setBanner(Supplier<String> banner) {
    this.banner = banner.get();
  }

}
