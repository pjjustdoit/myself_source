package com.pingan.qhzx.Syn;

/**
 * Created by peijian280 on 17/1/10.
 */
public class Foo2 extends Thread {

    private int val = 0;

    public synchronized void addNum() {
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        val++;
        System.out.println(val);
    }

    public void run() {
        addNum();

    }

}
