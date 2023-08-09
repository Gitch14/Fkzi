package com.example.fkzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.fkzi")
public class FkziApplication implements WebMvcConfigurer {

    @Bean
    public HttpMessageConverter<?> customJackson2HttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(customJackson2HttpMessageConverter());
    }

    public static void main(String[] args) {
        SpringApplication.run(FkziApplication.class, args);
    }

}
