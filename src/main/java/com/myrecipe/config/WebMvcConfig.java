package com.myrecipe.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${uploadPath}") // application.properties에 설정한 "uploadPath" 프로퍼티 값 읽어옴
    String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations(uploadPath);
    }

}
