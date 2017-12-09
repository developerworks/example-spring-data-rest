package com.example.examplespringdatarest.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationEventReady implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationListener.class);

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        logger.info(getClass().getSimpleName());
    }
}
