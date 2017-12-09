package com.example.examplespringdatarest.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationEventFailed implements ApplicationListener<ApplicationFailedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationListener.class);

    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        logger.info(getClass().getSimpleName());
    }
}
