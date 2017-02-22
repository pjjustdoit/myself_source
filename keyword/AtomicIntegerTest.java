package myself_source.KeyWord;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by peijian280 on 17/2/22.
 * 使用AtomicInteger可以实现int++操作,实现原子操作
 */
public class AtomicIntegerTest {
    private static volatile AtomicInteger count = new AtomicInteger(0);
    private static volatile int i = 1;
    private static ExecutorService executorPool = Executors.newFixedThreadPool(1000);

    private static void addNum() {
        try {
            Thread.sleep(1);
        } catch (Exception e) {

        }
        i++;   //i++不是原子操作,volatile此时作用无效
    }

    private static void addAtomicInteger() {
        count.getAndAdd(1);
    }

    public static void main(String[] args) {
        for(int s = 0;s < 1000;s++) {
            executorPool.execute(new Runnable() {
                @Override
                public void run() {
//                    AtomicIntegerTest.addNum();
                    AtomicIntegerTest.addAtomicInteger();
                }
            });
        }
        System.out.println(count);

    }

}
