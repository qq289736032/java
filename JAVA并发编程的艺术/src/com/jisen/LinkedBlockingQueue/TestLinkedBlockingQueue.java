package com.jisen.LinkedBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * 链式存储元素
 * @author User
 *
 */
public class TestLinkedBlockingQueue {
	public static void main(String[] args) {
		 BlockingQueue queue = new LinkedBlockingQueue(2);
		 BlockingQueue<String> queue2 = new LinkedBlockingQueue(1);
		 
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
