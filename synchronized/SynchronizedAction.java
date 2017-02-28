package myself_source.synchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by peijian280 on 17/2/28.
 * 1 普通方法前面加同步锁synchronized,表示对实例对象加锁
 * 2 静态方法前面加同步锁synchronized,表示对类对象加锁
 * 3 写在代码块中,锁是synchronized括号里配置的对象(可能是实例对象,也可能是类对象)
 */
public class SynchronizedAction implements Runnable {
    //测试同步方法
    private synchronized void testSyncMethod() {
        for(int i = 0;i < 10;i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":i");
        }
    }

    //测试静态同步方法
    private static synchronized void testSyncStaticMethod() {
        for(int i = 0;i < 10;i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":i");
        }
    }

    //测试代码块
    private void testSyncBlock() {
        synchronized (SynchronizedAction.class) {
            for(int i = 0;i < 10;i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":i");
            }
        }
    }

    @Override
    public void run() {
//        testSyncMethod();
        testSyncStaticMethod();
//        testSyncBlock();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        SynchronizedAction cms1 = new SynchronizedAction();
        SynchronizedAction cms2 = new SynchronizedAction();
        exec.execute(cms1);
        exec.execute(cms2);
        exec.shutdown();
    }
}

/**
 * testSyncMethod()输出结果:
 pool-1-thread-2:i
 pool-1-thread-1:i
 pool-1-thread-2:i
 pool-1-thread-1:i
 pool-1-thread-2:i
 pool-1-thread-1:i
 pool-1-thread-2:i
 pool-1-thread-1:i
 pool-1-thread-2:i
 pool-1-thread-1:i
 pool-1-thread-2:i
 pool-1-thread-1:i
 pool-1-thread-2:i
 pool-1-thread-1:i
 pool-1-thread-2:i
 pool-1-thread-1:i
 pool-1-thread-1:i
 pool-1-thread-2:i
 pool-1-thread-1:i
 pool-1-thread-2:i
 * 肯定是无序排列的
 *
 *
 * testSyncStaticMethod()输出结果:
 * pool-1-thread-1:i
 pool-1-thread-1:i
 pool-1-thread-1:i
 pool-1-thread-1:i
 pool-1-thread-1:i
 pool-1-thread-1:i
 pool-1-thread-1:i
 pool-1-thread-1:i
 pool-1-thread-1:i
 pool-1-thread-1:i
 pool-1-thread-2:i
 pool-1-thread-2:i
 pool-1-thread-2:i
 pool-1-thread-2:i
 pool-1-thread-2:i
 pool-1-thread-2:i
 pool-1-thread-2:i
 pool-1-thread-2:i
 pool-1-thread-2:i
 pool-1-thread-2:i
 *
 * testSyncBlock()输出结果:
 pool-1-thread-1:i
 pool-1-thread-1:i
 pool-1-thread-1:i
 pool-1-thread-1:i
 pool-1-thread-1:i
 pool-1-thread-1:i
 pool-1-thread-1:i
 pool-1-thread-1:i
 pool-1-thread-1:i
 pool-1-thread-1:i
 pool-1-thread-2:i
 pool-1-thread-2:i
 pool-1-thread-2:i
 pool-1-thread-2:i
 pool-1-thread-2:i
 pool-1-thread-2:i
 pool-1-thread-2:i
 pool-1-thread-2:i
 pool-1-thread-2:i
 pool-1-thread-2:i
 */
