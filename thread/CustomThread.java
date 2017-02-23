package myself_source.thread;

/**
 * Created by peijian280 on 17/2/23.
 */
public class CustomThread extends Thread {
    public CustomThread() {
        super("[CustomThread] 子线程");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+": start.");
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+": end.");
        } catch (Exception e) {
            System.out.println("Exception from " + Thread.currentThread().getName());
        }
    }
}
