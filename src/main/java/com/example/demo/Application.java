package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                    .addMapping("/tasks/**")
                    .allowedOrigins(
                        "https://spring-task-app.vercel.app",
                        "http://localhost",
                        "http://192.168.0.86",
                        "http://localhost:4000",
                        "http://localhost:3000",
                        "https://spring-task-app.vercel.app"
                    )
                    .allowedMethods("*");
            }
        };
    }
}
