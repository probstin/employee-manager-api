package com.probstin.employeemanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.ErrorDecoder;

@Configuration
public class CustomFeignClientConfig {

    @Bean
    ErrorDecoder errorDecoder() {
        return new FeignClientDecoder();
    }

}
