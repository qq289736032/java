package com.jisen;

/**
 * Created by jisen on 2018/4/11.
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 异同:Lock能完成synchronized所实现的所有功能
 * 主要不同点:lock有比synchronized更精确的线程语义和更好的性能.synchronized会自动释放锁而Lock一定要求程序员手动释放,
 * 并且必须在finally从句中释放,Lock还有更强大的功能例如它的tryLock方法可以以非阻塞方式去拿锁.
 *
 */
public class SynchronizedAndLock {
    private static int ticket = 10;
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        SynchronizedAndLock sal = new SynchronizedAndLock();
//        for (int i = 0; i < 2; i++){
            new Thread(sal.new Adder()).start();
            new Thread(sal.new Subtractor()).start();
//        }
    }

    private class Subtractor implements Runnable{
        @Override
        public void run() {
            while (true){
                /*synchronized (SynchronizedAndLock.this){
                    System.out.println("j--="+j--);
                }*/
                lock.lock();
                try{
                    System.out.println(Thread.currentThread().getName()+ticket--);
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    private class Adder implements Runnable{
        @Override
        public void run() {
            while (true){
                /*synchronized (SynchronizedAndLock.this){
                    System.out.println("j++="+j++);
                }*/
                lock.lock();
                try{
                    System.out.println(Thread.currentThread().getName()+ticket--);
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}
