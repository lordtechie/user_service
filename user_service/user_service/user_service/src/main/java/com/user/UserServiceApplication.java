package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class UserServiceApplication {

        public static void main(String[] args) {
            SpringApplication.run(UserServiceApplication.class, args);
        }



        @Bean
        @LoadBalanced
        public RestTemplate restTemplate(RestTemplateBuilder builder) {
            return builder.build();
        }
}
