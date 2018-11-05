package com.jisen;

/**
 * Created by jisen on 2018/10/25.
 */
public class MyThread extends Thread {
    int i=0;
    @Override
    public void run() {
        while (i<10){
            System.out.println(Thread.currentThread().getName()+":"+(i++));
        }
    }

    public static void main(String[] args) {
        Thread th = new MyThread();
        th.start();
        th.run();
    }
}
