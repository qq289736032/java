package com.jisen;

class MyThread6 extends Thread{
	@Override
	public void run() {
		System.out.println("当前线程开启："+Thread.currentThread().getName());
		System.out.println("1、isInterrupt"+Thread.interrupted());
		try {
			System.out.println("2、isInterrupt"+Thread.interrupted());
			Thread.sleep(5000);
			System.out.println("3、isInterrupt"+Thread.interrupted());
		} catch (InterruptedException e) {
			System.out.println("4、isInterrupt"+Thread.interrupted());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("5、isInterrupt"+Thread.interrupted());
		System.out.println(Thread.currentThread().getName()+"当前线程结束");
	}
}

public class ThreadInterrupt2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread6 mt=new MyThread6();
		mt.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mt.interrupt();//当线程正在调用sleep修眠的过程中，如果被interrupt（）方法打断，则会产生一个异常
		//该异常会清中断标志位，不是直接结束线程，会把线程执行完
	}

}
