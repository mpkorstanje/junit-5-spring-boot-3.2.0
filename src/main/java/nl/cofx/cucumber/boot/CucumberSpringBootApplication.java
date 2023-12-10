package nl.cofx.cucumber.boot;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
@SpringBootApplication
public class CucumberSpringBootApplication {

    private final CucumberTestRunner cucumberTestRunner;

    public static void main(String[] args) {
        SpringApplication.run(CucumberSpringBootApplication.class, args);
    }

    @EventListener
    public void run(ApplicationStartedEvent event) {
        cucumberTestRunner.run();
    }
}
