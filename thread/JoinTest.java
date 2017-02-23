package myself_source.thread;

/**
 * Created by peijian280 on 17/2/23.
 * Thread.join作用是等子线程结束后才继续执行主线程
 */
public class JoinTest {
    public static void main(String[] args) {
        CustomThread customThread = new CustomThread();
        customThread.start();
        try {
            customThread.join();
            System.out.println(JoinTest.class.getName()+" 主线程: end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 *打印结果:
 [CustomThread] 子线程: start.
 [CustomThread] 子线程: end.
 myself_source.JoinTest 主线程: end
 */
