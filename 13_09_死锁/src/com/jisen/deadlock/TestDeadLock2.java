package com.jisen.deadlock;

class Chinese{
	public synchronized void funA(American an) {
		System.out.println("我有筷子和刀。。。");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		an.eat();
	}
	public void eat(){
		System.out.println("可以吃饭。。。");
	}
}

class American{
	public synchronized void funB(Chinese ch) {
		System.out.println("我有叉和筷子。。。");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ch.eat();
	}
	public void eat(){
		System.out.println("吃饭了。。。");
	}
}
public class TestDeadLock2 extends Thread{

	/**
	 * 单对象死锁的情况是，单个对象同个线程同时调用多个synchronized的情况
	 * 双对象死锁的情况是，两个线程相互之间持有对方的锁，都在等待对方释放，
	 */
	
	static Chinese ch=new Chinese();
	static American an=new American();
	@Override
	public void run() {
		ch.funA(an);
	}
	public static void main(String[] args) {
		TestDeadLock2 tdl=new TestDeadLock2();
		tdl.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
