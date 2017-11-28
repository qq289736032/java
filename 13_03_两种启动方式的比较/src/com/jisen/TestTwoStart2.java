package com.jisen;

/*
 * 问题1、既然是比较启动多线程的两种方式，这两种启动方式有什么异同，分别应用在什么场合？
 * 答：同：都可以实现多线程，都要通过Thread这个实现类开启start()。异：1、Runnable是接口类，其子类除了可以实现Runable之外还可以继承其他类，
 * 即他的作用就是除了实现Runnable实现run方法达到多线程之外还可以继承其他类做其他事情。2、继承自Thread的子类对象可以直接调用start()，
 * 但是实现Runnable的子类对象要通过参数传递的方式，进入Thread，利用Thread的实例化对象调用start();
 * 
 */
class SaleTicket{//一个售票员的父类
	int id;
	int age;
	String name;
}
class SaleTicket2 extends SaleTicket implements Runnable{	//写一个子类，这个类实现了Runnable及其run方法，
															//另外还继承了售票员的父类，那么它即是售票员的子类，又具备多线程功能
	private  int ticket=10;
	public void run() {
		while(true){
			if(ticket>0){
				System.out.println(Thread.currentThread().getName()+"卖出第"+(10-ticket+1)+"票");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//互斥锁
				ticket--;
				if(ticket==0)	break;
//				System.out.println(Thread.currentThread().getName()+"开始售票，售票结束"+ticket);
			}
		}
	}
}

public class TestTwoStart2 {

	/**
	 * 问题2、这两种方式的多线程都应用在什么场合？
	 * 1、当使用Thead的方式，一个对象只能调用一次start（）方法，如果要实现多线程，则要实例化两个对象，分别调用start();
	 * 
	 * 
	 * 3、 创建线程的另一种方法是声明实现 Runnable 接口的类。该类然后实现 run 方法。然后可以分配该类的实例，在创建 Thread 时作为一个参数来传递并启动。 
	 * 这种方法的一个好处是，一个Runnable的实现类，一个子类对象对应一个run方法。但是可以用这个子类对象产生两个线程，两个线程卖的是同一个库里的票，最终不会卖20张票。
	 * 这种模式更适合用于多人合作模式
	 */
	public static void main(String[] args) {
		SaleTicket2 st1=new SaleTicket2();
		Thread t1=new Thread(st1);
		t1.start();
		Thread t2=new Thread(st1);
		t2.start();
	}

}
