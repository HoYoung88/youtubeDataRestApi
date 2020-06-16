package com.loudg.api.yt.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "paging")
public class PagingProperties {
  public int rowsCount;
}
