package com.pingan.qhzx.designpattern.proxy.AOP.more;

/**
 * Created by peijian280 on 17/2/16.
 */
public class PhoneImp implements  Phone{
    public void sale() {
        System.out.println(PhoneImp.class.getName()+",sale phone");
    }
}
