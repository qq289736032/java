package com.jisen.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author User
 * 支持两个附加操作的 Queue，这两个操作是：获取元素时等待队列变为非空，以及存储元素时等待空间变得可用。
 * 关键词等待阻塞
 */
public class BlockingQueueExample {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Object> queue = new ArrayBlockingQueue<>(1);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		
		new Thread(producer).start();
		new Thread(consumer).start();
		Thread.sleep(4000);
		
		
	}
}
