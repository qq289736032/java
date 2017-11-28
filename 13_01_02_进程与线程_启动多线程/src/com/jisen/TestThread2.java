package com.jisen;

//class MyThread2 implements Runnable{
//
//	public void run() {
//		TestThread2.buyChair();
//	}
//	
//}

//class A{
//	public void fun(){}
//}
//class B extends A{
//	@Override
//	public void fun() {//静态与非静态之间是不能满足复写原则的，static不能覆盖父类的
//	}
//}
public class TestThread2 {

	/**
	 * @param args
	 */
	public static void buyDesk(){
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("正在买桌子。。。");
		}
	}
	public static void buyChair(){
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("正在买椅子。。。");
		}
	}
	//产生多线程
	public static void main(String[] args) {//main和gc两个线程同时执行，
		//1、
//		MyThread1 mt=new MyThread1();//运行时要子类对象
		//mt.run();如果直接调用run那么是不产生多线程的，相当于直接调用了buyChair，
//		mt.start();//start就可以直接产生多线程，启动多线程之后系统自动回复调用复写的run方法，因此不要自己直接调用
		//1.1
		//或者、//这种方式在安卓中非常常见
//		new Thread(){//new的是一个匿名的子类
//			public void run(){
//				TestThread2.buyChair();
//			}	
//		}.start();
		//2、
//		MyThread2 tt=new MyThread2();
//		Thread t=new Thread(tt);
//		t.start();
//		
		//或者
//		new Thread(new MyThread2()).start();
		//或者
		new Thread(new Runnable(){//产生一个匿名对象
			public void run() {
				TestThread2.buyChair();
			}
		}).start();
		buyDesk();//谁抢到CPU谁就执行
	}

}
