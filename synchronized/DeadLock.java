package myself_source.Synchronized;

/**
 * Created by peijian280 on 17/1/11.
 */
public class DeadLock implements Runnable {

    private int flag;
    private static Object o1 = new Object();
    private static Object o2 = new Object();

    public void twoLock() {
        System.out.println(flag);
        if(flag == 0) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("111");
                }
            }
        }
        if(flag == 1) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("222");
                }
            }
        }
    }

    public void run() {
        twoLock();
    }

    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock();
        DeadLock deadLock2 = new DeadLock();
        deadLock1.flag = 0;
        deadLock2.flag = 1;
        Thread thread1 = new Thread(deadLock1);
        Thread thread2 = new Thread(deadLock2);
        thread1.start();
        thread2.start();
    }
}
