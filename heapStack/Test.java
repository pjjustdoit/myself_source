package myself_source.heapStack;

/**
 * Created by peijian280 on 17/2/27.
 */
public class Test {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();
        object2 = object1;   //此时Object2对象已无任何引用,可以GC回收
//        object2 = null;
        System.out.println(object2);
        System.gc();
        System.out.println(object2);
    }

}
