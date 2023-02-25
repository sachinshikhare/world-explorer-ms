package com.example.worldexplorerms.config;

import com.example.worldexplorerms.exception.handler.RestTemplateResponseErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CountryConfiguration {

    @Bean
    public RestTemplateBuilder restTemplateBuilder() {
        return new RestTemplateBuilder();
    }

    @Bean
    public RestTemplate restTemplate() {
        return restTemplateBuilder()
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }
}

