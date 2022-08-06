package com.springevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    static class EmailApplicationListener implements ApplicationListener<MyEvent> {

        @Override
        public void onApplicationEvent(MyEvent event) {
            System.out.println("email发送");
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
