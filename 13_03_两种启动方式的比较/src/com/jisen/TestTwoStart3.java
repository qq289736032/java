
package com.jisen;

public class TestTwoStart3 {
	public static void main(String[] args) {
		TestThread t = new TestThread();
		// 启动了四个线程，并实现了资源共享的目的
		new Thread(t).start();
		new Thread(t).start();
	}
}

class TestThread implements Runnable {
	private int tickets = 20;

	public void run() {
		while (true) {
			if (tickets > 0)
				System.out.println(Thread.currentThread().getName() + "出售票" + tickets--);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
