/*
 * 死锁，的概念?????还是无法理解
 */
package com.jisen.deadlock;

class A{
	public synchronized void fun1() {
		System.out.println("fun1 is running...");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("fun1 is over...");
		fun2();
	}
	public synchronized void fun2() {
		
		System.out.println("fun2 is running...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("fun2 is over...");
		fun1();
	}
}
public class TestDeadLock extends Thread{
	static A a=new A();
	@Override
	public void run() {
		a.fun1();
	}

	/**
	 * 一个对象占用了锁资源，则这个对象不能再进行其他操作
	 */
	public static void main(String[] args) {
		TestDeadLock tdl=new TestDeadLock();
		
		tdl.start();
		a.fun1();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		//tdl.destroy();//一个线程占用锁资源时被中断，但是锁并没有得到释放，导致其他线程不能使用锁资源，这叫做死锁状态。
//		
		System.out.println("main~");
	}

}
