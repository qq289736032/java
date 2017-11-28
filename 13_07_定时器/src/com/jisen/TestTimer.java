/*
 *	 	void cancel() 
          	终止此计时器，丢弃所有当前已安排的任务。 
 		int purge() 
          	从此计时器的任务队列中移除所有已取消的任务。 
 		void schedule(TimerTask task, Date time) 
          	安排在指定的时间执行指定的任务。 
 		void schedule(TimerTask task, Date firstTime, long period) 
          	安排指定的任务在指定的时间开始进行重复的固定延迟执行。 
 		void schedule(TimerTask task, long delay) 
     	  	安排在指定延迟后执行指定的任务。 
 		void schedule(TimerTask task, long delay, long period) 
          	安排指定的任务从指定的延迟后开始进行重复的固定延迟执行。 
 		void scheduleAtFixedRate(TimerTask task, Date firstTime, long period) 
          	安排指定的任务在指定的时间开始进行重复的固定速率执行。 
 		void scheduleAtFixedRate(TimerTask task, long delay, long period) 
          	安排指定的任务在指定的延迟后开始进行重复的固定速率执行。 

 */

/*
 * 		boolean cancel() 
          	取消此计时器任务。 
		abstract  void run() 
          	此计时器任务要执行的操作。 
 		long scheduledExecutionTime() 
          	返回此任务最近实际 执行的已安排 执行时间 

 */
package com.jisen;

import java.util.*;
class MyTask2 extends TimerTask{
	@Override
	public void run() {
		cancel();//结束后还会把整个线程运行完,这里表示该任务的结束但是 计时器schedule依然没有结束
		System.out.println("baba~");
	}
}

class MyTask1 extends TimerTask{
	@Override
	public void run() {
//		for(int i=0;i<5;i++){
//			try {
//				Thread.sleep(1000);
//				System.out.println(i);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		cancel();//结束后还会把整个线程运行完,这里表示该任务的结束但是 计时器schedule依然没有结束
		System.out.println("biu~~");
	}
}

public class TestTimer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Timer t=new Timer();//先产生一个定时器
		MyTask1 mt1=new MyTask1();
		MyTask2 mt2=new MyTask2();
		//schedule(TimerTask task, Date time),参数1，要执行的任务。参数2，多少毫秒后执行该任务
		//schedule(TimerTask task, Date firstTime, long period) 参数1，任务；参数2，第一次执行时，多少秒后执行该任务；参数3，第二次以后，该任务重复执行的时间
		//schedule(TimerTask task, long delay, long period) 
		t.schedule(mt1, 5000,1000);//产生一个任务，5秒后执行，以后每隔1秒执行依次。
		t.schedule(mt2, 5000,1000);
		//t.scheduleAtFixedRate(mt2, 5000, 1000);//这个不知道有什么区别
		System.out.println("结束吗");
		//t.cancel();//这里表示计时器的结束
	}
}
