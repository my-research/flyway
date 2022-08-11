package com.example.hhjin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableScheduling
@SpringBootApplication
public class HhjinApplication {

    @RestController
    public static class HelloController {
        @GetMapping("/hello")
        public String hello() {
            return "hello";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(HhjinApplication.class, args);
    }
}
