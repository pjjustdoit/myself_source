package com.pingan.qhzx.designpattern.proxy.AOP.more;

/**
 * Created by peijian280 on 17/2/16.
 */
public class MainProxy implements Computer, Phone {
    private Computer computer;
    private Phone phone;
    public MainProxy(Computer computer, Phone phone) {
        this.phone = phone;
        this.computer = computer;
    }
    public void sayHelloBefore() {
        System.out.println("before");
    }
    public void sayHelloAfter() {
        System.out.println("after");
    }
    public void sale() {
        sayHelloBefore();
        computer.sale();
        phone.sale();
        sayHelloAfter();
    }

}
