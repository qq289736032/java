package com.jisen;

class MyThread3 extends Thread {
	@Override
	public void run() {
		for(int i=0;i<10;i=i+2){
			
			try {
				MyThread3.sleep(1000);
//				Thread.sleep(800);
				System.out.println(Thread.currentThread().getName()+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class MyThread4 extends Thread {
	@Override
	public void run() {
		for(int i=1;i<10;i=i+2){
			
			try {
				MyThread4.sleep(1000);
				MyThread4.yield();
//				Thread.sleep(800);
				System.out.println(Thread.currentThread().getName()+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class TestThreadAPI2 {

	/**
	 * @param args
	 * 	MyThread4.sleep(1000);//sleep表示让出CPU资源，自己变成阻塞状态
	 *	MyThread4.yield();yield表示执行到这一句的时候让出CPU资源，进入就绪状态队尾排列，
	 */
	public static void main(String[] args) {
		System.out.println("main is running");
		MyThread3 mt1=new MyThread3();
		MyThread4 mt2=new MyThread4();
		mt1.start();
		mt2.start();
//		System.exit(0);//结束进程，会把所有线程结束
//		try {
//			mt1.join(8000);//等待线程结束，才能继续往下执行main线程，如果没有这句则是一次性会执行main
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		MyThread3.yield();
		System.out.println("main is running");
		
	}

}
