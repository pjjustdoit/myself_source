package com.pingan.qhzx.designpattern.proxy.DynamicProxy;


/**
 * Created by peijian280 on 17/2/16.
 */
public class FooImp implements Foo {

    public void sayHello() {
        System.out.println(FooImp.class.getName()+",say hello");
    }
}
