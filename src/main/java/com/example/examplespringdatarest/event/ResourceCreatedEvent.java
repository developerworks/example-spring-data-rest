package com.example.examplespringdatarest.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件, 在资源创建时触发
 */
public class ResourceCreatedEvent extends ApplicationEvent {

    public ResourceCreatedEvent(Object source) {
        super(source);
    }
}
