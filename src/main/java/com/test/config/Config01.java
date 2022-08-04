package com.test.config;

import com.test.MyCondition;
import com.test.MyImportBeanDefinitionRegistrar;
import com.test.MyImportSelector;
import com.test.entity.Person;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScans(value = {
        @ComponentScan(value = "com.test.entity2")
})
@PropertySource(value="classpath:/test.properties")
//@Import(value={Mouse.class, Dog.class})  // 通过 import 注解  直接放入class，会被注入容器，id是类的全限定名称
@Import(value = {MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})  // 通过 实现ImportSelector接口，实现注入
// 实现MyImportBeanDefinitionRegistrar，手动注册bean到容器中
public class Config01 {

    @Bean(initMethod = "initPerson", destroyMethod = "destroyPerson")
    @Conditional({
            MyCondition.class
    })
    public Person person() {
        return new Person();
    }

    @Bean
//    @Scope("singleton")   容器内单实例
    @Scope("prototype")
    public Person person01() {
        return new Person("李四", 30);
    }

}
