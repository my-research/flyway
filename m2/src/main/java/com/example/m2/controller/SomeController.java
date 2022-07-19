package com.example.m2.controller;

import com.example.m2.scheduler.ScheduleTaskService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SomeController {
    private final ScheduleTaskService scheduleTaskService;

    @GetMapping("/add")
    public void add() {
        String id = UUID.randomUUID().toString();
        scheduleTaskService.addTaskToScheduler(id, () -> {
            log.info("hello world " + id);
            throw new RuntimeException("error");
        });
    }
}
