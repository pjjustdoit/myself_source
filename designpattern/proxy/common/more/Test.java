package com.pingan.qhzx.designpattern.proxy.AOP.more;

/**
 * Created by peijian280 on 17/2/16.
 */
public class Test {
    public static void main(String[] args) {
        Computer foo = new MainProxy(new ComputerImp(), new PhoneImp());
        foo.sale();
    }
}
