package com.example.examplespringdatarest;

import com.example.examplespringdatarest.listener.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * https://itnext.io/building-microservices-with-spring-data-rest-40bb94080a9e
 * https://reflectoring.io/documenting-spring-data-rest-api-with-springfox/
 */
@SpringBootApplication
@EnableSwagger2

// 导入Spring Data REST配置到API文档
@Import({SpringDataRestConfiguration.class})
public class ExampleSpringDataRestApplication {

    public static void main(String[] args) {
        // 默认启动
        // SpringApplication.run(ExampleSpringDataRestApplication.class, args);
        // 自定义启动
        SpringApplication app = new SpringApplication(ExampleSpringDataRestApplication.class);
        /**
         * 应用生命周期事件监听器
         */
        // 启动中
        app.addListeners(new ApplicationEventStarting());
        // 环境已准备好
        app.addListeners(new ApplicationEventEnvironmentPrepared());
        // 启动失败
        app.addListeners(new ApplicationEventFailed());
        // 已准备
        app.addListeners(new ApplicationEventPrepared());
        // 应用程序已准备好接收请求
        app.addListeners(new ApplicationEventReady());

        app.run(args);

    }

}
