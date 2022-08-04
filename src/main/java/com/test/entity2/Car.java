package com.test.entity2;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * -----------------Car  call 构造函数....
 * --------------car postProcessBeforeInitialization
 * -----------------Car  call postConstruct
 * -----------------Car  call afterPropertiesSet
 * --------------car postProcessBeforeInitialization
 */
@Component("car")
public class Car implements InitializingBean {
    public Car() {
        System.out.println("-----------------Car  call 构造函数....");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("-----------------Car  call postConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("-----------------Car  call afterPropertiesSet");
    }

}
