package com.jisen.DelayQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
/**
 * Delayed 元素的一个无界阻塞队列，只有在延迟期满时才能从中提取元素。该队列的头部 是延迟期满后保存时间最长的 Delayed 元素。
 * 如果延迟都还没有期满，则队列没有头部，并且 poll 将返回 null。当一个元素的 getDelay(TimeUnit.NANOSECONDS) 方法返回一个小于等于 0 的值时，
 * 将发生到期。即使无法使用 take 或 poll 移除未到期的元素，也不会将这些元素作为正常元素对待。例如，size 方法同时返回到期和未到期元素的计数。此队列不允许使用 null 元素。
 * @author jisen
 */
public class TestDelayQueue {
	public static void main(String[] args) {
		BlockingQueue  queue = new DelayQueue();
		Delayed element1 = new MyDelayedElement("1"); 
		
		try {
			queue.put(element1);
			String take = (String) queue.take();
			System.out.println(take);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
