package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author manke
 * @Date 2020/7/16 15:07
 * @Version 0.0.1
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${target.url}")
    private String fileSavePath;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/word/**")
                .addResourceLocations("file:"+fileSavePath);
    }
}
