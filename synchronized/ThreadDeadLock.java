package com.pingan.qhzx.Syn;

/**
 * Created by peijian280 on 17/1/11.
 */
public class ThreadDeadLock {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();
        Thread thread1 = new Thread(new SyncThread(obj1, obj2),"t1");
        Thread thread2 = new Thread(new SyncThread(obj1, obj2),"t2");
        thread1.start();
        thread2.start();
    }
}
