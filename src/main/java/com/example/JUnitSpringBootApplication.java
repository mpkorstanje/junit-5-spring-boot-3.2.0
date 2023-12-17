package com.example;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
@SpringBootApplication
public class JUnitSpringBootApplication {

    private final JUnitTestRunner JUnitTestRunner;

    public static void main(String[] args) {
        SpringApplication.run(JUnitSpringBootApplication.class, args);
    }

    @EventListener
    public void run(ApplicationStartedEvent event) {
        JUnitTestRunner.run();
    }
}
