package com.agsr.monitor_sensors_statistics.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@Configuration
public class FeignConfig {

    @Value("${open.feign.username}")
    private String username;

    @Value("${open.feign.password}")
    private String password;

    @Bean
    public RequestInterceptor basicAuthRequestInterceptor() {
        return requestTemplate -> {
            String basicAuthHeader = "Basic " + Base64.getEncoder()
                    .encodeToString((username + ":" + password).getBytes());
            requestTemplate.header("Authorization", basicAuthHeader);
        };
    }
}
