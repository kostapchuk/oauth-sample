package com.ostapchuk.oauthsample;

import org.springframework.boot.SpringApplication;

public class TestOauthSampleApplication {

    public static void main(String[] args) {
        SpringApplication.from(OauthSampleApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
