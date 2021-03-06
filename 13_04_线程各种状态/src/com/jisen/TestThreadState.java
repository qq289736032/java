package com.jisen;

public class TestThreadState {

	/**
	 * start(),run(),停止，阻塞，等待
	 * 线程的状态有5种，也有说3种的
	 * 1、开始状态：还没执行start()
	 * 2、就绪状态(排队)：万事俱备只欠CPU：调用start()方法之后就进入到队列结构排队，先产生的线程排在队列的前面的先得到执行
	 * 3、运行状态()：CPU获取到线程开始执行，当4纳秒之内执行完一个线程，这个线程直接进入结束状态，并且CPU立马切换到下一个线程，当一个线程执行超过4ns时，过了4纳秒后，又回到就绪状态排队
	 * 4、等待状态(cpu执行队列线程,此线程没有排队资格)：当执行某一个线程时突然需要打印机，但是打印机又被别的线程占用了（打印机是互斥设备），那这个线程就进入等待状态没有排队资格，同时CPU执行下一个线程，
	 * 5、结束状态
	 * 最宝贵的资源：CPU谁抢到谁得到执行，CPU划分成很多很小的时间片段	4ns	4*10^-9s，因此CPU同时处理十几个进程时是交替执行的，因为时间非常短，程序看起来是连贯执行的
	 *
	 * New:线程未启动,叫做开始状态: A thread that has not yet started
	 * Runable:就绪状态执行了start(): A thread executing in the java virtual machine
	 *
	 *
	 */
	public static void main(String[] args) {


	}

}
