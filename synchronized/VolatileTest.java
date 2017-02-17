package com.pingan.qhzx.Syn;

/**
 * Created by peijian280 on 17/1/9.
 */
public class VolatileTest {

    public static volatile int count = 0;

    public static void addNum() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count = count + 1;
    }

    public static void main(String[] args) {
        for(int i=0;i<1000;i++) {
            new Thread(new Runnable() {
                public void run() {
                    addNum();
                }
            }).start();
        }
        System.out.println(count);
    }
}
