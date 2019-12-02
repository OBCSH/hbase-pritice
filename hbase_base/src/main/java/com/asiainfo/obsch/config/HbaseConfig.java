package com.asiainfo.obsch.config;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;
import java.util.Set;

/**
 * Hbase配置类
 * @author Zhangxuejian
 * @Date 2019年11月26日
 *
 */


@Configuration
@EnableConfigurationProperties(HbaseProperties.class)
@PropertySource("classpath:bootstrap.yml")
public class HbaseConfig {
private final HbaseProperties properties;
    public HbaseConfig(HbaseProperties properties) {
        this.properties = properties;
    }
    public org.apache.hadoop.conf.Configuration configuration() {
        org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();
        Map<String, String> config = properties.getConfig();
        Set<String> keySet = config.keySet();
        for (String key : keySet) {
            configuration.set(key, config.get(key));
        }
        return configuration;
    }
}
