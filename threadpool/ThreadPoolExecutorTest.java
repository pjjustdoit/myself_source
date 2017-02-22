package com.pingan.qhzx.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by peijian280 on 17/2/22.
 */
public class ThreadPoolExecutorTest {
    private static ExecutorService executorPool = new java.util.concurrent.ThreadPoolExecutor(3, 4, 2L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(100000),
            new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        for(int i = 0;i < 9;i++) {
            executorPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

        executorPool.shutdown();
    }
}
