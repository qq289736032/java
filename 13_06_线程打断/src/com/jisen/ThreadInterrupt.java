package com.jisen;

class MyThread5 extends Thread{
	@Override
	public void run() {
		System.out.println("当前线程开启："+Thread.currentThread().getName());
		System.out.println("1、isInterrupt "+Thread.currentThread().isInterrupted());
		//try {
			System.out.println("2、isInterrupt "+Thread.currentThread().isInterrupted());
//			Thread.sleep(5000);
			for(int i=0;i<10000;i++){
				System.out.println(i);
			}
			System.out.println("3、isInterrupt "+Thread.currentThread().isInterrupted());
		//}// catch (InterruptedException e) {
			System.out.println("4、isInterrupt "+Thread.currentThread().isInterrupted());
			//e.printStackTrace();
		//}
		System.out.println("5、isInterrupt "+Thread.currentThread().isInterrupted());
		System.out.println(Thread.currentThread().getName()+"当前线程结束");
	}
}

public class ThreadInterrupt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread5 mt=new MyThread5();
		mt.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mt.interrupt();//当线程正在调用sleep修眠的过程中，如果被interrupt（）方法打断，则会产生一个异常
		//该异常会清中断标志位，不是直接结束线程，会把线程执行完
	}

}
