package com.test;

import com.test.config.Config02;
import com.test.entity.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.Map;

public class TestAnno {

    private ApplicationContext applicationContext;

    @Before
    public void init() {
//        applicationContext = new AnnotationConfigApplicationContext(Config01.class);
    }

    @Test
    public void test03() {
        // 通过代码方式设置profile
        ApplicationContext applicationContext2 = new AnnotationConfigApplicationContext();
        ConfigurableEnvironment environment = (ConfigurableEnvironment) applicationContext2.getEnvironment();
        environment.setActiveProfiles("test");
        ((AnnotationConfigApplicationContext) applicationContext2).register(Config02.class);
        ((AnnotationConfigApplicationContext) applicationContext2).refresh();
        printBeanNames(applicationContext2);
        ((AnnotationConfigApplicationContext) applicationContext2).close();
    }

    @Test
    public void test02() {
        // 通过命令行添加vm参数 传入profile 生效
        //  -Dspring.profiles.active=test
        ApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(Config02.class);
        printBeanNames(applicationContext2);
        ((AnnotationConfigApplicationContext) applicationContext2).close();
    }

    @Test
    public void test01() {
        Environment environment = applicationContext.getEnvironment();
        String key1 = environment.getProperty("key1");
        System.out.println(key1);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
//        Person person = (Person) applicationContext.getBean("person");
//        System.out.println(person);

        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);
        printBeanNames(applicationContext);
        System.out.println("----------------------");
        Object mouse = applicationContext.getBean("mouse");
        Object mouse1 = applicationContext.getBean("mouse");
        System.out.println(mouse);
        System.out.println(mouse1);
        System.out.println(mouse == mouse1);


        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");
        Object person01 = applicationContext.getBean("person01");
        Object person02 = applicationContext.getBean("person01");
        System.out.println(person01);
        System.out.println(person02);
        System.out.println(person01 == person02);
    }

    private void printBeanNames(ApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }

}
