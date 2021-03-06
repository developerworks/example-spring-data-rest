package com.example.examplespringdatarest;

import com.example.examplespringdatarest.event.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * https://itnext.io/building-microservices-with-spring-data-rest-40bb94080a9e
 * https://reflectoring.io/documenting-spring-data-rest-api-with-springfox/
 * http://www.jianshu.com/p/edd4cb960da7
 * http://blog.csdn.net/cqdz_dj/article/details/52910317
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
         *
         * ➜ mvn spring-boot:run |grep o.s.context.ApplicationListener
         * 2017-12-09 17:27:05.230  INFO 34792 --- [  restartedMain] o.s.context.ApplicationListener          : ApplicationEventEnvironmentPrepared
         * 2017-12-09 17:27:05.340  INFO 34792 --- [  restartedMain] o.s.context.ApplicationListener          : ApplicationEventPrepared
         * 2017-12-09 17:27:10.656  INFO 34792 --- [  restartedMain] o.s.context.ApplicationListener          : ApplicationEventReady
         *
         * 为什么注册了5个事件只触发了3个?
         */

        // 启动中
        // Spring boot启动开始时执行的事件
        app.addListeners(new ApplicationEventStarting());

        // 环境已准备好
        // Spring boot 对应Enviroment已经准备完毕, 但此时上下文context还没有创建
        app.addListeners(new ApplicationEventEnvironmentPrepared());

        // 已准备
        // Spring boot上下文 Context 创建完成, 但此时spring中的bean是没有完全加载完成的
        app.addListeners(new ApplicationEventPrepared());

        // 应用程序已准备好接收请求
        app.addListeners(new ApplicationEventReady());

        // 启动失败
        // Spring boot启动异常时执行事件
        app.addListeners(new ApplicationEventFailed());
        app.run(args);

    }

}
