package com.asiainfo.obsch.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

/**
 * Hbase配置类
 * @author Zhangxuejian
 * @Date 2019年11月26日
 *
 */
@Configuration
//@ConfigurationProperties(prefix = HbaseConfig.CONF_PREFIX)
@PropertySource("classpath:bootstrap.yml")
public class HbaseConfig {
    public static final String CONF_PREFIX = "hbase.conf";
    private Map<String,String> confMaps;
    public Map<String, String> getconfMaps() {
        return confMaps;
    }
    public void setconfMaps(Map<String, String> confMaps) {
        this.confMaps = confMaps;
    }
}
