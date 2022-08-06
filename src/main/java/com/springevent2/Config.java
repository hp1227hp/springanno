package com.springevent2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

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

        @EventListener
        public void process(MyEvent event) {
            System.out.println("email send: " + event.getSource());
        }
    }


    static class Service {

        @Autowired
        private ApplicationEventPublisher applicationEventPublisher;

        public void doSomeThing() {
            System.out.println("业务逻辑处理");

            applicationEventPublisher.publishEvent(new MyEvent("Service.doSomeThing"));
        }

    }

    static class MyEvent extends ApplicationEvent {

        public MyEvent(Object source) {
            super(source);
        }

    }

}
