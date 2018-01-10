package com.jisen.演示死锁;

public class TestDeadLock {
	class MyThread implements Runnable{

		@Override
		public void run() {
			synchronized (A) {
				try {
					Thread.currentThread().sleep(2000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				synchronized (B) {
					System.out.println("1");
				}
			}
			
		}
		
	}
	class MyThread2 implements Runnable{
		
		@Override
		public void run() {
			synchronized (B) {
				try {
					Thread.currentThread().sleep(2000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				synchronized (A) {
					System.out.println("2");
				}
			}
			
		}
		
	}
	private static String A ="A";
	private static String B ="B";
	public static void main(String[] args) {
		new TestDeadLock().deadLock();
	}
	private void deadLock() {
		Thread t1 = new Thread(new MyThread());
		Thread t2 = new Thread(new MyThread2());
		t1.start();
		t2.start();
		
	}
}
