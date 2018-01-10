package com.jisen.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	
	protected BlockingQueue queue = null;
	
	public Producer(BlockingQueue queue) {  
        this.queue = queue;  
    }
	
	@Override
	public void run() {
		try {
			queue.put("1");
			System.out.println("放1");
			Thread.sleep(1000);
			queue.put("2");
			System.out.println("放2");
			Thread.sleep(1000);
			queue.put("3");
			System.out.println("放3");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
