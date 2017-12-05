package com.example.examplespringdatarest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class ExampleSpringDataRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleSpringDataRestApplication.class, args);
    }
}
