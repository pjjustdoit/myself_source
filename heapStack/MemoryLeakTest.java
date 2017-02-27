package com.pingan.qhzx.heapStack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by peijian280 on 17/2/27.
 * 内存泄露测试, memory leak会导致out of memory
 * 当进行大量的pop操作时，由于引用未进行置空，gc是不会释放的
 */
public class MemoryLeakTest {
    private int size = 0;
    private Object[] elements;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public MemoryLeakTest() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if(size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    /**
     * 优化后的pop方法,用完就将引用设置为null
     * @return
     */
    public Object pop2() {
        if(size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if(elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
        MemoryLeakTest outOfMemoryTest = new MemoryLeakTest();
        outOfMemoryTest.push("nihao");
        outOfMemoryTest.push("nihao2");
        System.out.println(outOfMemoryTest.size);
        for(int i=0;i<outOfMemoryTest.elements.length;i++) {
            System.out.println(outOfMemoryTest.elements[i]);
        }

        System.out.println(outOfMemoryTest.pop());

        for(int i=0;i<outOfMemoryTest.elements.length;i++) {
            System.out.println(outOfMemoryTest.elements[i]);
        }
    }
}
