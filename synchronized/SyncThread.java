package com.pingan.qhzx.Syn;

/**
 * Created by peijian280 on 17/1/11.
 */
public class SyncThread implements Runnable {

    private Object obj1;
    private Object obj2;

    public SyncThread(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " acquiring lock on "+obj1);
        synchronized (obj1) {
            System.out.println(threadName + " acquired lock on "+obj1);
            work();
            System.out.println(threadName + " acquiring lock on "+obj2);
            synchronized (obj2) {
                System.out.println(threadName + " acquired lock on "+obj2);
                work();
            }
            System.out.println(threadName + " released lock on "+obj2);
        }
        System.out.println(threadName + " released lock on "+obj1);
        System.out.println(threadName + " finished execution.");
    }

    private void work() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
