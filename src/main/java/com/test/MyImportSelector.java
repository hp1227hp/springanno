package com.test;

import com.test.entity3.Dog;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Class clazz = Dog.class;
        System.out.println("clazz.getName() " + clazz.getName());
        System.out.println("clazz.getPackage() " + clazz.getPackage().getName());
        System.out.println("clazz.getCanonicalName() " + clazz.getCanonicalName());
        return new String[]{clazz.getName()};
    }

}
