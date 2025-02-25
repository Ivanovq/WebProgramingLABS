package mk.ukim.finki.labb1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication

public class LabB1Application {

    public static void main(String[] args) {
        SpringApplication.run(LabB1Application.class, args);
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder(10);
    }

}
