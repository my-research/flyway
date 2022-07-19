package com.example.springscheduler;

import com.example.springscheduler.scheduler.ScheduleTaskService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SomeController {
    private final ScheduleTaskService scheduleTaskService;

    @GetMapping("/add")
    public void add() {
        String id = UUID.randomUUID().toString();
        scheduleTaskService.addTaskToScheduler(id, () -> System.out.println("hello world " + id));
    }
}
