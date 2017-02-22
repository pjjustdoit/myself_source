package myself_source.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by peijian280 on 17/2/22.
 线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样
的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
说明：Executors 返回的线程池对象的弊端如下：
1）FixedThreadPool 和 SingleThreadPool:
允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。
2）CachedThreadPool 和 ScheduledThreadPool:
允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM。
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
