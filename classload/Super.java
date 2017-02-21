package com.pingan.qhzx.classload;

/**
 * Created by peijian280 on 17/2/21.
 */
public class Super {
    private static Super aSuper = new Super();
    private static int i = 5;
    static {
        System.out.println("test3,i="+i);
    }
    public Super() {
        System.out.println("test4");
    }
}
