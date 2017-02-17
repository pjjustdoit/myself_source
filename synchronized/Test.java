package com.pingan.qhzx.Syn;

/**
 * Created by peijian280 on 17/1/10.
 */
public class Test {
    private int i = 1;
    public void add() {
        i++;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.add();
        System.out.println(test.i);
    }
}
