package com.pingan.qhzx.designpattern.proxy.AOP.more;

/**
 * Created by peijian280 on 17/2/16.
 */
public class ComputerImp implements Computer {

    public void sale() {
        System.out.println(ComputerImp.class.getName()+",sale computer");
    }
}
