package myself_source.Concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by peijian280 on 17/4/12.
 * 有时候在实际应用中，某些操作很耗时，但又不是不可或缺的步骤。比如用网页浏览器浏览新闻时，
 * 最重要的是显示文字内容，至于与新闻相匹配的图片就没有那么重要的，所以此时首先保证文字信息先显示，
 * 而图片信息会后显示，但又不能不显示，由于下载图片是一个耗时的操作，所以必须一开始就得下载。
 * Java的并发库的Future类就可以满足这个要求。Future的重要方法包括get()和cancel()，get()获取数据对象，
 * 如果数据没有加载，就会阻塞直到取到数据，而 cancel()是取消数据加载。另外一个get(timeout)操作，
 * 表示如果在timeout时间内没有取到就失败返回，而不再阻塞。
 * 下面的Demo简单的说明了Future的使用方法：一个非常耗时的操作必须一开始启动，但又不能一直等待；
 * 其他重要的事情又必须做，等完成后，就可以做不重要的事情。
 */
public class FutureTaskTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000*5);
                return "other less important something but longtime thing.";
            }
        };

        Future future = pool.submit(callable);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //重要的事情
            System.out.println(sdf.format(new Date()));
            Thread.sleep(1000*3);
            System.out.println("let`s do important thing.");
            System.out.println(sdf.format(new Date()));
            //执行不是很重要,但是耗时的事情
            String obj = (String) future.get();
            System.out.println(obj);
            System.out.println(sdf.format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}

/**
 * 输出:
 * 2017-04-12 09:49:58
 * let`s do important thing.
 * 2017-04-12 09:50:01
 * other less important something but longtime thing.
 * 2017-04-12 09:50:03
 */
