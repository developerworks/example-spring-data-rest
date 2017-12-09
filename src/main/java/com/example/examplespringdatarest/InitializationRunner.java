package com.example.examplespringdatarest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 初始运行期, 在应用程序完全启动之前运行一些任务.
 */
@Component
public class InitializationRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(InitializationRunner.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("Run tasks before application started.");
    }
}
