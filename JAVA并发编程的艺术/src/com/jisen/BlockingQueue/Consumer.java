package com.jisen.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	
	protected BlockingQueue queue = null;
	
	public Consumer(BlockingQueue queue) {  
        this.queue = queue;  
    }
	
	@Override
	public void run() {
		try {
			System.out.println("取"+queue.take());
			System.out.println("取"+queue.take());
			System.out.println("取"+queue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
