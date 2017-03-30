package myself_source.ThreadLocal;

import java.util.Random;

/**
 * Created by peijian280 on 17/3/30.
 ThreadLocal不是用来解决对象共享访问问题的，而主要是提供了保持对象的方法和避免参数传递的方便的对象访问方式。归纳了两点： 
1。每个线程中都有一个自己的ThreadLocalMap类对象，可以将线程自己的对象保持到其中，各管各的，线程可以正确的访问到自己的对象。 
2。将一个共用的ThreadLocal静态实例作为key，将不同对象的引用保存到不同线程的ThreadLocalMap中，然后在线程执行的各处通过这个静态ThreadLocal实例的get()方法取得自己线程保存的那个对象，避免了将这个对象作为参数传递的麻烦。
 */
public class ThreadLocalDemo implements Runnable {

    private final static ThreadLocal<Student> studentThreadLocal = new ThreadLocal<Student>();

    @Override
    public void run() {
        accessStudent();
    }

    public void accessStudent() {
        String currentName = Thread.currentThread().getName();
        System.out.println(currentName+" is running");
        Random random = new Random();
        int age = random.nextInt(100);
        System.out.println("thread " + currentName + " set age to:" + age);
        Student student = getStudent();
        student.setAge(age);
        System.out.println(currentName+" age:" +student.getAge());
    }

    protected Student getStudent() {
        Student student = studentThreadLocal.get();
        if(student == null) {
            student = new Student();
            studentThreadLocal.set(student);
        }

        return student;
    }

    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        for(int i = 0;i < 5;i++) {
            Thread thread = new Thread(demo, "s"+i);
            thread.start();
        }

    }
}


/**
 * print
 *
 * s0 is running
 s2 is running
 s3 is running
 s1 is running
 s4 is running
 thread s4 set age to:29
 thread s3 set age to:28
 thread s2 set age to:5
 thread s0 set age to:93
 thread s1 set age to:56
 s4 age:29
 s1 age:56
 s0 age:93
 s2 age:5
 s3 age:28
 *
 */
