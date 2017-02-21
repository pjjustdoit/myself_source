package myself_source.classload;

/**
 * Created by peijian280 on 17/2/21.
 * 类的初始化顺序:static变量 or static成员变量(按照声明的先后顺序初始化的)>构造函数
 * 父类static >  子类static
 * 输出结果:
 * test4
 * test3,i=5
 * test1,i=2
 * test4
 * test2,i=2
 */
public class InitClassloadSort extends Super {

    private static int i = 2;
    private int s = 3;
    static {
        System.out.println("test1,i="+i);
    }

    public InitClassloadSort() {
        //此处省略了super(),针对带有父类的情况,super()默认是带上的
        System.out.println("test2,i="+i);
    }

//    public static InitClassloadSort getInstance() {
//        return classloadSort;
//    }

    public static void main(String[] args) {
        new InitClassloadSort();
    }

}
