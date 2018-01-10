package com.jisen.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

public class TestArrayBlockingQueue {
	public static void main(String[] args) {
		 BlockingQueue queue = new ArrayBlockingQueue(2);
		 BlockingQueue<String> queue2 = new ArrayBlockingQueue(1);
		 
		 try {
			queue.put(1);
			queue.put(2);
			int num1 = (int) queue.take();
			int num2 = (int) queue.take();
			System.out.println(num1);
			System.out.println(num2);
			
			queue2.put("1");
			String take = queue2.take();
			System.out.println(take);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
