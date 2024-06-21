package com.ostapchuk.oauthsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class OauthSampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(OauthSampleApplication.class, args);
    }
}

@Configuration
class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
              .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
              .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
              .build();
    }
}


@RestController
class OrderController {

    @GetMapping("/api/v1/orders")
    public List<String> orders() {
        return List.of("Order 1", "Order 2", "Order 3");
    }
}