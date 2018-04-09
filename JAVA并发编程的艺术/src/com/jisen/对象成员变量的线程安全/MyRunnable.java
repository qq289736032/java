package com.jisen.对象成员变量的线程安全;

/**
 * Created by jisen on 2018/1/11.
 */
public class  MyRunnable implements Runnable{
    NotThreadSafe instanc = null;
    public MyRunnable(NotThreadSafe instanc){
        this.instanc = instanc;
    }
    @Override
    public void run() {
        this.instanc.add("some text");
    }
}
