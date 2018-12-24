package itc.sevevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = {"itc.sevevents.config", "itc.sevevents.controllers", "itc.sevevents.domain",
                                            "itc.sevevents.exceptions", "itc.sevevents.repos", "itc.sevevents.service",
                                            "itc.sevevents.views"})
public class SevEventsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SevEventsApplication.class, args);
    }
}

