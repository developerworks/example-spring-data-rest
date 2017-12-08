package com.example.examplespringdatarest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * https://itnext.io/building-microservices-with-spring-data-rest-40bb94080a9e
 */
@SpringBootApplication
@EnableSwagger2

// 导入Spring Data REST配置到API文档
@Import({springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class})
public class ExampleSpringDataRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleSpringDataRestApplication.class, args);
    }
}
