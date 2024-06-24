package com.ohgiraffers.fworks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FworksApplication {

    public static void main(String[] args) {
        SpringApplication.run(FworksApplication.class, args);
    }

}
