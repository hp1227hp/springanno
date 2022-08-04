package com.test2;

public class Client {

    public static void main(String[] args) {
        A a = new AImpl();
        a.test1();
        a.test2();
        System.out.println(a.test3());
        System.out.println("--------------------");
        A.staticMethod1();
        System.out.println(A.staticMethod2("haha"));

    }

}
