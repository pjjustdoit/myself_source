package com.pingan.qhzx.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by peijian280 on 17/2/22.
 * FixedThreadPool线程池
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService threadpool = Executors.newFixedThreadPool(3);
        for(int i = 1;i < 5;i++) {
            final int taskID = i;
            threadpool.execute(new Runnable() {
                @Override
                public void run() {
                    for(int i = 1;i < 5;i++) {
                        try {
                            Thread.sleep(200);
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("第" + taskID + "次任务的第" + i + "次执行");
                    }
                }
            });
        }
        threadpool.shutdown();
    }
}


/**
 输出结果:
 第1次任务的第1次执行
 第2次任务的第1次执行
 第3次任务的第1次执行
 第2次任务的第2次执行
 第3次任务的第2次执行
 第1次任务的第2次执行
 第3次任务的第3次执行
 第1次任务的第3次执行
 第2次任务的第3次执行
 第3次任务的第4次执行
 第2次任务的第4次执行
 第1次任务的第4次执行
 第4次任务的第1次执行
 第4次任务的第2次执行
 第4次任务的第3次执行
 第4次任务的第4次执行
 */

/**
 * 创建了一个固定大小的线程池,大小为3,启动了4个线程,然后从线程池里先拿到了三个线程,等空闲下来的线程去执行第四个任务
 * 在fixedThreadPool中,有一个固定大小的池,如果当前需要执行的任务超过了池的大小,那么多余的任务处于等待状态,直到有空闲
 * 下来的线程执行任务,而当执行的任务小于池大小,空闲的线程也不会销毁
 */
