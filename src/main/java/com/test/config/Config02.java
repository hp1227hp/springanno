package com.test.config;

import com.test.OuterObject;
import com.test.entity3.Dog;
import com.test.entity3.Mouse;
import org.springframework.context.annotation.*;

/**
 * profile生效    命令行添加vm参数  -Dspring.profiles.active=test  没有标注的bean会加载
 * profile可以添加到类上，总开关
 */
@Configuration
@PropertySource(value = "classpath:/test.properties")
@ComponentScan("com.test.entity3")
public class Config02 {

    @Profile("test")
    @Bean
    public Dog dog() {
        return new Dog();
    }

    @Profile("dev")
    @Bean
    public Mouse mouse() {
        return new Mouse();
    }

    @Bean
    public OuterObject outerObject() {
        return new OuterObject();
    }


}
