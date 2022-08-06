package com.springevent3;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Spring事件
 */
@Configuration
public class Config {

    @Bean
    public Service service() {
        return new Service();
    }


    @Component
    static class EventProcessor {

        private Logger logger = LoggerFactory.getLogger(EventProcessor.class);

        @EventListener
        public void process(MyEvent event) {

            logger.debug("email send: " + event.getSource()
            );
        }
    }

    @Bean
    public Executor executor(ApplicationEventMulticaster applicationEventMulticaster) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        if(applicationEventMulticaster instanceof SimpleApplicationEventMulticaster) {
            ( (SimpleApplicationEventMulticaster)applicationEventMulticaster).setTaskExecutor(executorService);
        }
        return executorService;
    }


    static class Service {

        private Logger logger = LoggerFactory.getLogger(Service.class);

        @Autowired
        private ApplicationEventPublisher applicationEventPublisher;

        public void doSomeThing() {
            logger.debug("业务逻辑处理");

            applicationEventPublisher.publishEvent(new MyEvent("Service.doSomeThing"));
        }

    }

    static class MyEvent extends ApplicationEvent {

        public MyEvent(Object source) {
            super(source);
        }

    }



}
