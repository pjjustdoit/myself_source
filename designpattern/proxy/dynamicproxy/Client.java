package com.pingan.qhzx.designpattern.proxy.DynamicProxy;

import java.net.Proxy;

/**
 * Created by peijian280 on 17/2/17.
 */
public class Client {
    public static void main(String[] args) {
        FooImp foo = new FooImp();
        MyInvokerHandler myInvokerHandler = new MyInvokerHandler(foo);
        Object proxy = java.lang.reflect.Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{Foo.class}, myInvokerHandler);
        Foo fooProxy = (Foo) proxy;
        fooProxy.sayHello();
    }
}
