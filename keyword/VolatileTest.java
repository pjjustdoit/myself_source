/**
 * Created by peijian280 on 17/2/20.
 */

/**
 * volatile:可见性(将新的数据存放于公共内存区域,而不是放在私有区域),原子性(a++等操作都是非原子性操作)
 * 加了volatile以下程序只有两种结果a=3,b=3 or a=1,b=2
 * 不加volatile会出现第三种结果
 */
public class VolatileTest {
    volatile int a = 1;
    volatile int b = 2;

    public void change() {
        a = 3;
        b = a;
    }

    public void print() {
        System.out.println("b=" + b + ";a=" + a);
    }

    public static void main(String[] args) {
        while (true) {
            final VolatileTest test = new VolatileTest();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.change();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.print();
                }
            }).start();

        }
    }
}
