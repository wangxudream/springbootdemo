package com.kataer.springbootdemo.springbootdemo.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(WxProperties.class)//这个注解告诉Spring Boot 使能支持@ConfigurationProperties
public class WxConfiguration {
    @Autowired
    private WxProperties properties;

    public WxProperties getProperties() {
        return properties;
    }
}
