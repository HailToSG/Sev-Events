package itc.sevevents;

import itc.sevevents.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SevEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SevEventsApplication.class, args);
    }
    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepo repo) throws Exception {
        builder.userDetailsService(username -> new CustomUserDetails(repo.findByUsername(username)));
    }
}

