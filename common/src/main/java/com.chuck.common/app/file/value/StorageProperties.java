package com.chuck.common.app.file.value;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @since 2021/8/25
 * @version 0.0.1
 * @apiNote Value Object
 */
@ConfigurationProperties(prefix = "com.chuck")
@Configuration
@Getter
@Setter
public class StorageProperties {

  private String fileLocation;
}
