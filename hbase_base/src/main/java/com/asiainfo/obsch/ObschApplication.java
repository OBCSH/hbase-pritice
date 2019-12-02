package com.asiainfo.obsch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"com.asiainfo.obsch.service.impl", "com.asiainfo.obsch.config"})
public class ObschApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObschApplication.class, args);
    }

}
