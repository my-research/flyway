package com.example.springscheduler;

import com.example.springscheduler.message.QueueMessageSender;
import com.example.springscheduler.scheduler.ScheduleTaskService;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SomeController {
    private final ScheduleTaskService scheduleTaskService;
    private final QueueMessageSender sender;

    @GetMapping("/add")
    public void add() {
        String id = UUID.randomUUID().toString();
        scheduleTaskService.addTaskToScheduler(id, () -> {
            log.info("hello world " + id);
            throw new RuntimeException("error");
            // sender.send();
        });
    }

    @GetMapping("/add/future")
    public void addFuture() {
        String id = UUID.randomUUID().toString();
        // CompletableFuture future = CompletableFuture.runAsync(() -> log.info(""));
        RunnableFuture future = new RunnableFuture() {
            @Override
            public void run() {
                System.out.println("xx");
                throw new RuntimeException("error");
            }
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public Object get() throws InterruptedException, ExecutionException {
                return null;
            }

            @Override
            public Object get(long timeout, TimeUnit unit)
                    throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }
        };
        scheduleTaskService.addFutureTaskToScheduler(id, future);
    }
}
