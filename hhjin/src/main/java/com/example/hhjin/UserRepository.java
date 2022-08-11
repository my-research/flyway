package com.example.hhjin;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByXXXCondition(LocalDateTime from, LocalDateTime to);
}
