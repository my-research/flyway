package com.example.hhjin;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserJoinController {

    private final UserRepository repository;

    private final String[] users = {"장원익", "허혜진", "kim", "soo", "yang", "song"};
    int count = 0;

    @GetMapping("/")
    public String join() {
        repository.save(User.builder().name(users[count++]).createdAt(LocalDateTime.now()).build());
        return "joined";
    }
}
