package com.pingan.qhzx.Syn;

/**
 * Created by peijian280 on 17/1/10.
 */
public class FooTest {

    public static void main(String[] args) {
//        moreInstance();
//        oneInstance();
//        System.out.println("<....>");
//        oneInstance2();
//        moreInstance2();
        oneInstance3();
    }

    private static void moreInstance() {
        Foo foo = new Foo(1);
        foo.start();
        Foo foo1 = new Foo(3);
        foo1.start();


    }

    private static void oneInstance() {
        Foo foo = new Foo(1);
        new Thread(foo).start();
        new Thread(foo).start();
    }

    private static void oneInstance2() {
        Foo2 foo = new Foo2();
        for(int i=0;i<100;i++) {
            new Thread(foo).start();
        }
    }

    private static void moreInstance2() {
        Foo2 foo = new Foo2();
        foo.start();
        Foo2 foo1 = new Foo2();
        foo1.start();
    }

    private static void oneInstance3() {
        Foo3 foo = new Foo3();
        for(int i=0;i<100;i++) {
            new Thread(foo).start();
        }
    }
}
