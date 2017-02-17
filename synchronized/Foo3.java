package com.pingan.qhzx.Syn;

/**
 * Created by peijian280 on 17/1/10.
 */
public class Foo3 implements Runnable {

    private int val = 0;

    public synchronized void addNum() {
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        val++;

    }

    public void run() {
        addNum();
        System.out.println(val);
    }
}
