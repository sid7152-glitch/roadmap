package com.astrevia.githubLogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class GithubLoggerApplication {

    public static void main(String[] args) {
//        ApplicationContext context ;
        SpringApplication.run(GithubLoggerApplication.class, args);
    }

}
