package com.pingan.qhzx.DependencyInjection;

/**
 * Created by peijian280 on 17/2/15.
 */
public class ClassA {
    private InterfaceB clzB;

    /***
     * 构造器注入
     * @param clzB
     */
//    public ClassA(InterfaceB clzB) {
//        this.clzB = clzB;
//    }

    /***
     * 运用接口注入
     */
    public void doSomething() {
        try {
            Object obj = Class.forName("com.pingan.qhzx.DependencyInjection.ClassB").newInstance();
            clzB = (InterfaceB) obj;
            clzB.doIt();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * Setter方式注入
     * @param clzB
     */
    public void doSomething2(InterfaceB clzB) {
        clzB = clzB;
        clzB.doIt();
    }

    public static void main(String[] args) {
        ClassA classA = new ClassA();
//        classA.doSomething();
        InterfaceB interfaceB = new ClassB();
        classA.doSomething2(interfaceB);
    }

}
