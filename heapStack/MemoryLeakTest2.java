package com.pingan.qhzx.heapStack;

import java.util.Vector;

/**
 * Created by peijian280 on 17/2/27.
 * 内存泄露:1 对象是存在通路的(通过一定的关系可以找到) 2 对象是无用的
 */
public class MemoryLeakTest2 {
    public static void main(String[] args) {
        Vector vector = new Vector(10);
        for(int i = 0;i < 100;i++) {
            Object object = new Object();
            vector.add(object);
            object = null;  //此时所有的对象都没有被释放,因为变量vector引用了这些对象
        }
    }
}

/**
 * 最简单的方法就是将Vector设置为null
 */
