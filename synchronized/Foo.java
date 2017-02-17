package com.pingan.qhzx.Syn;

/**
 * Created by peijian280 on 17/1/10.
 */
public class Foo extends Thread {

    private static Object lock = new Object();

    private int val;

    public Foo(int v) {
        val = v;
    }

    public void getNum(int v) {
        synchronized (lock) {
            System.out.println(val);
        }

    }

    public void run() {
        getNum(val);
    }
}
