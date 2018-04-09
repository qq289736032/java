package com.jisen.优先级的阻塞队列;

import java.util.concurrent.PriorityBlockingQueue;

/**
 *
 */
public class TestPriorityBlockingQueue {
    public static void main(String[] args) {
        PriorityBlockingQueue<Object> queue = new PriorityBlockingQueue<>();
        queue.put("vaule");
        try {
            String value = (String) queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
