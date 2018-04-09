package com.jisen.对象成员变量的线程安全;

/**
 * Created by jisen on 2018/1/11.
 */
public class TestNotThreadSafe {
    /**
     * 对象成员变量线程安全
     * @param args
     */
    public static void main(String[] args) {
        //如果两个线程都调用同一个对象实例的方法,那么这两个线程会出现竞争
        NotThreadSafe sharedInstance  = new NotThreadSafe();
        new Thread(new MyRunnable(sharedInstance)).start();
        new Thread(new MyRunnable(sharedInstance)).start();

    }
}
