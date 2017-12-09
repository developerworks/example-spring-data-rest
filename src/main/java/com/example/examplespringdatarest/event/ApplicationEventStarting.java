package com.example.examplespringdatarest.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationEventStarting implements ApplicationListener<ApplicationStartingEvent> {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationListener.class);

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        logger.info(getClass().getSimpleName());
    }
}
