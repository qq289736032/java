package com.jisen.Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jisen on 2018/1/10.
 */
public class TestLock {
    /**
     * java.util.concurrent.locks.Locks是一个类似于synchronized块的线程同步机制.但是Lock比synchronized块更加灵活,精细
     * @param args
     */
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
    }
}
