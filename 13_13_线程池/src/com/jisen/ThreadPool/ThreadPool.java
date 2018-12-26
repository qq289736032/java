package com.jisen.ThreadPool;

import java.util.concurrent.*;

class MyThread implements Runnable{

	public void run() {
		for(int i=0;i<10;i++){
//			System.out.println("1、"+Thread.currentThread()+"i="+i);
//			System.out.println("2、"+Thread.currentThread().getId()+"i="+i);
			System.out.println("3、"+Thread.currentThread().getName()+"i="+i);
//			System.out.println("4、"+Thread.currentThread().getPriority()+"i="+i);
//			System.out.println("5、"+Thread.currentThread().getClass()+"i="+i);
//			System.out.println("6、"+Thread.currentThread().getContextClassLoader()+"i="+i);
//			System.out.println("7、"+Thread.currentThread().getState()+"i="+i);
//			System.out.println("8、"+Thread.currentThread().getThreadGroup()+"i="+i);
//			System.out.println("9、"+Thread.currentThread().getUncaughtExceptionHandler()+"i="+i);
//			System.out.println("10、"+Thread.currentThread().getAllStackTraces()+"i="+i);
//			System.out.println("11、"+Thread.currentThread().getDefaultUncaughtExceptionHandler()+"i="+i);
////			System.out.println("12、"+Thread.currentThread()+"i="+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class ThreadPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//当产生一个线程时，它的方式为
//		MyThread1 mt=new MyThread1();
//		Thread t=new Thread(mt);
//		t.start();//此刻T1T2T3都由这里产生，即创建，运行，和销毁所花的时间
		
		//
//		ExecutorService es=Executors.newCachedThreadPool();//创建一个池子
		ExecutorService es = Executors.newFixedThreadPool(3);//创建1个池子，池里面只能有3个线程
		for(int i=0;i<5;i++)//尽管可以提交多个线程，但是线程池只能容纳3个线程
		es.submit(new MyThread());
		es.shutdown();//关闭之后不能再进入新线程
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main方法继续执行");
	}

}
