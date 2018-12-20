package itc.sevevents;

import itc.sevevents.domain.User;
import itc.sevevents.repos.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SevEventsApplication {


    public static void main(String[] args) {
        SpringApplication.run(SevEventsApplication.class, args);
    }
}

