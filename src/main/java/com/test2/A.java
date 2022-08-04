package com.test2;

/**
 * java8中
 * 1.常量
 * 2.抽象方法
 * 3. 默认方法default    默认方法可以不强制重写，并且在一个类继承接口后可以直接使用接口中的默认方法
 * 4. 静态方法static     实现接口的类或者子接口不会继承接口中的静态方法
 * 一个类实现多个接口时，各个接口中存在相同的默认方法（方法名、参数、返回值相同），此时实现类必须要重写默认方法，否则编译错误
 */
public interface A {

    void test1();

    default void test2() {
        System.out.println("test2");
    }

    default String test3() {
        A.staticMethod1();
        return "default test3";

    }

    static void staticMethod1() {
        System.out.println("staticMethod1");
    }

    static String staticMethod2(String name) {
        return "staticMethod2 " + name;
    }

}
