package com.example.hhjin;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    // 생성으로부터 10초가 지나면 콘솔에 출력한다
}
