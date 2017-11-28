/*
 * 线程互斥，之前的售票员系统，两个线程都在执行各自的run方法因此出现，卖20张票的情况，卖出重复票
 * 加上synchronized之后表示一个线程进去了则另一个线程不能进去
 */

package com.jisen;

class SaleTicket implements Runnable{
	private int ticket=10;
	public  void sale(){//
		
		System.out.println(Thread.currentThread().getName()
				+ "当前票数为：" + ticket);
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ticket--;
		System.out.println(Thread.currentThread().getName()
				+ "售票成功，票余为：" + ticket);
	}
	public void run() {//大家都同时进到了run方法
		System.out.println(Thread.currentThread().getName()+"调用run方法");
		while(true){
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName+"进入了while");
			synchronized (this) {//没有锁的时候
				String threadName1 = Thread.currentThread().getName();
				String threadName2 = Thread.currentThread().getName();
				System.out.println(Thread.currentThread().getName()+"夺取了互斥锁进行卖票");
				if (ticket > 0) {
					sale();
				} else {
					System.out.println(Thread.currentThread().getName()+"退出");//会出现两次，两个线程都会执行break
					break;
				}
			}
		}
	}
	
}

public class TestThreadMutex {

	/**
	 * 1、synchronized (对象){}同步代码块
	 * 2、t1调用start()，会用st会去调用run()方法,
	 * 3、讨论synchronized加在何处？才能让售票正常进行？
	 * 3.1、第一，大家都能够同时进入run方法进行卖票，核心就是等我卖完一张票完成余票的减一操作，另一个线程才能进行卖票，
	 * 3.2、while循环当只碰到票数被卖完之后才跳出，
	 * 综上所述synchronized至少不能加在while循环之外，因为一旦一个线程进入了while循环，那么这个票将由这个线程全部卖出
	 * synchronized只能加在while里面，用同步代码块的方式将售票并且判断的部分加以锁住synchronized (this)。括号中this表示抢到该锁当前线程的对象，
	 */
	public static void main(String[] args) {
		SaleTicket st=new SaleTicket();//这个runnable实现类，具备买票的功能，其实例化对象就是一个卖票系统
		Thread t1=new Thread(st,"窗口1");
		Thread t2=new Thread(st,"窗口2");
		t1.start();//t1调用start()，会用st会去调用run()方法,
		t2.start();//t2调用start()，会用st会去调用run()方法,同一个st调用run方法
		
	}

}
