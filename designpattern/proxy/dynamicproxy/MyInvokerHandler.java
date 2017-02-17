package com.pingan.qhzx.designpattern.proxy.DynamicProxy;

import org.omg.CORBA.portable.InvokeHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by peijian280 on 17/2/16.
 */
public class MyInvokerHandler implements InvocationHandler {
    private Foo foo;
    public MyInvokerHandler() {

    }
    public MyInvokerHandler(Foo foo) {
        this.foo = foo;
    }
    public void beforeInvoke(){
        System.out.println("doSomething before invoke");
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeInvoke();
        method.invoke(foo, args);
        afterInvoke();
        return null;
    }
    public void afterInvoke(){
        System.out.println("doSomething after invoke");
    }
}
