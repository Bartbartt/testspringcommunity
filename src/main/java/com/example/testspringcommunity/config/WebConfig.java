package com.example.testspringcommunity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Apply to all endpoints
            .allowedOrigins(
                "http://localhost:3000",   // React default
                "http://localhost:5500",   // Live Server
                "http://127.0.0.1:5500",   // Alternative localhost
                "http://localhost:8080",  // Spring Boot default
                "http://localhost:8081"
            )
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowedHeaders("*")
            .allowCredentials(true);
    }
}