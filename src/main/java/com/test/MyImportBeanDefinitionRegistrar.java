package com.test;

import com.test.entity3.Mouse;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        String beanName = "mouse";
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(Mouse.class);
        // 设置bean的scope  prototype 每次生成一个新对象    singonten是单例
        beanDefinition.setScope("prototype");
        registry.registerBeanDefinition(beanName, beanDefinition);
    }
}
