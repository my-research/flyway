package com.example.springscheduler.scheduler;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleTaskService {
    private final TaskScheduler scheduler;

    Map<String, ScheduledFuture<?>> jobsMap = new HashMap<>();

    // jobs 에 task 등록
    public void addTaskToScheduler(String id, Runnable task) {
        ScheduledFuture<?> scheduledTask = scheduler.scheduleAtFixedRate(task, 1000L);
        jobsMap.put(id, scheduledTask);
    }

    // jobs 에서 task 삭제
    public void removeTaskFromScheduler(String id) {
        ScheduledFuture<?> scheduledTask = jobsMap.get(id);
        if (scheduledTask == null) {
            return;
        }
        scheduledTask.cancel(true);
        jobsMap.put(id, null);
    }

    // A context refresh event listener
    @EventListener({ContextRefreshedEvent.class})
    public void contextRefreshedEvent() {
        // 기존에 동작하던 task 를 다시 실행시킬 때 사용됨
    }

}