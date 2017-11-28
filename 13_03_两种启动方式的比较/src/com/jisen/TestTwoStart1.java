package com.jisen;

class SaleTicket1 extends Thread {// 写一个类，让这个类继承自多线程类，并且复写了run方法，那么这个SaleTicket就具备多线程功能了
	private static int ticket = 10;// 票数要设为静态私有的，能能通过run方法内部修改，外界不能操控。并且要在run方法外面

	@Override
	public void run() {
		while (true) {// 程序停止不了
			if (ticket > 0) {// 当票数大于零时买票
				System.out.println(Thread.currentThread().getName() + "卖出第" + ticket + "票");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 互斥锁
				ticket--;
				if (ticket == 0)
					break;
				// System.out.println(Thread.currentThread().getName()+"开始售票，售票结束"+ticket);
			}
		}
	}
}

public class TestTwoStart1 {

	/**
	 * @param args//
	 *            1、当只产生一个实例化对象时，只能调用一次start（）方法，如果要实现多线程，则要实例化两个对象，分别调用start();
	 * 
	 *            2、当使用继承自Thread的子类开启线程时，利用该子类开启两个线程时要new两个子类对象，
	 *            然后分别用这两个对象调用start()方法产生两个线程，
	 *            但是这样有一个问题，就是这两个对象所产生的两个线程是独立操作Ticket卖票这个动作的，也就是说，两个线程共卖出去20张票，
	 *            卖出20张票的原因是ticket是类内变量，两个线程开辟的空间是不重叠的，因此都在卖各自的ticket（ticket--），
	 *            因此要将private int ticket=10;方式静态区 private static int ticket=10
	 */
	public static void main(String[] args) {
		SaleTicket1 st1 = new SaleTicket1();
		st1.start();
		SaleTicket1 st2 = new SaleTicket1();
		st2.start();
		// try {
		// Thread.sleep(12000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// st1=new SaleTicket();
		// st1.start();//之前调用过的线程对象，不能再次调用
	}

}
