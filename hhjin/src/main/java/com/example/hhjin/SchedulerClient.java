package com.example.hhjin;

import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SchedulerClient {

    private final Long _1HOUR = 123L;

    public static final LocalDateTime ANY_TIME = LocalDateTime.now();
    private final UserRepository repository;

    public void doSomething() {
        // 정시에만 문자를 보내
        List<User> targets = repository.findAllByXXXCondition(ANY_TIME, ANY_TIME);
        for (int i = 0; i < targets.size(); i++) {
            targets.get(0);
            System.out.println("send");
        }
    }
}
