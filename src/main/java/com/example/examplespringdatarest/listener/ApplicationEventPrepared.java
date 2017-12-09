package com.example.examplespringdatarest.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationEventPrepared implements ApplicationListener<ApplicationPreparedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationListener.class);

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        logger.info(getClass().getSimpleName());
    }

}
