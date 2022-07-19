package com.example.m1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SchedulingJob {
    @Scheduled(fixedDelay = 1000L)
    public void simpleTask() {
        log.info("scheduling working");
    }
}
