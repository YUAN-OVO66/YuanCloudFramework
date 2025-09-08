package com.yuan.cloudcommon.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "yuan")
@Data
public class CloudConfig {
    /**
     * 获取地址开关
     */
    private static boolean addressEnabled;
}
