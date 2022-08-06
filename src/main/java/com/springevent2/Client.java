package com.springevent2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Config.Service service = context.getBean(Config.Service.class);
        service.doSomeThing();
        context.close();
    }

}
