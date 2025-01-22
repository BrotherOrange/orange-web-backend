package com.richard.website.api.bootstrap;

import com.richard.website.api.config.ApiConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ApiConfig.class)
public class PersonalWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalWebsiteApplication.class, args);
    }

}
