package com.hzsolution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class HZApplication {
    public static void main(String[] args) {

        // specify ${jwt.secret}
        // access
        // POST localhost:8083/authenticate
        // GET localhost:8083/hello
        SpringApplication app = new SpringApplication(HZApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        app.run(args);
        // SpringApplication.run(HZApplication.class, args);
    }
}
