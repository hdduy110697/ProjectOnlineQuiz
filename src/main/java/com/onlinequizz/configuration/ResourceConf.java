package com.onlinequizz.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class ResourceConf implements WebMvcConfigurer {

    public void addResourceHandlers(final ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/Template/**").addResourceLocations("/Template/");
    }
}