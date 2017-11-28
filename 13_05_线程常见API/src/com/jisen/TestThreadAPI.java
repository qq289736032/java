package com.jisen;

class MyThread1 extends Thread{
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"is running...");//获取当前线程的名称
	}
}
class MyThread2 extends Thread{
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"is running...");//获取当前线程的名称
	}
}
public class TestThreadAPI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+"is running...");//获取当前线程的名称main
		MyThread1 mt1=new MyThread1();
		mt1.setPriority(8);
		mt1.setName("我是线程mt1");//设置线程名称
		mt1.start();
		MyThread1 mt2=new MyThread1();
		mt2.setName("我是线程mt2");
		mt2.start();
		MyThread2 mt3=new MyThread2();
		mt3.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.activeCount());//返回当前线程的线程组中活动线程的数目。可以知道当前线程组中有多少个线程
		System.out.println("\t线程的id是："+mt1.getId());
		System.out.println("\tmt2优先级是："+mt2.getPriority());
		System.out.println("\tmt1优先级是："+mt1.getPriority());//都是5吗没有设置优先级，
		System.out.println("\tmt3的状态是是："+mt3.getState());//线程状态，1、NEW未启动2、RUNNABLE正在执行3、BLOCKED受阻塞4、WAITING等待5、TIMED_WAITING
//		NEW
//		至今尚未启动的线程处于这种状态。 
//		RUNNABLE
//		正在 Java 虚拟机中执行的线程处于这种状态。 
//		BLOCKED
//		受阻塞并等待某个监视器锁的线程处于这种状态。 
//		WAITING
//		无限期地等待另一个线程来执行某一特定操作的线程处于这种状态。 
//		TIMED_WAITING
//		等待另一个线程来执行取决于指定等待时间的操作的线程处于这种状态。 
//		TERMINATED
//		已退出的线程处于这种状态。 
		try {
			MyThread2.sleep(1000);//此处应该用类名去调用而不是用对象
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread[] tarray=new Thread[Thread.activeCount()];//产生一个这么多个线程的数组
		// 将当前线程的线程组及其子组中的每一个活动线程复制到指定的数组中
		Thread.enumerate(tarray);//将当前线程全部放到这个指定数组上，参数是数组，返回值是当前存放线程的个数
		for(Thread tar:tarray){
			System.out.println("\t线程的名字是："+tar.getName()+"\t线程的id是："+tar.getId()+"\t优先级是："+tar.getPriority());
		}
		
		System.out.println(Thread.currentThread().getName()+Thread.currentThread().getPriority());
	}

}
