package com.jisen;
//互斥模型，两个线程不能同时使用同一个资源，如售票系统的锁资源
//同步模型，两个线程交替使用资源，相互唤醒对方资源许可。
//生产者消费问题
//售票是一种互斥模型，


class Person{
	String name;
	String sex;
	static boolean bFull=false;//为了解决，notify唤醒另一个线程，并且释放锁资源后，两个线程又进入同等竞争的情况，即不能交替的的情况，那么就要设置一个是否被消费的判断
	public synchronized void setPerson(String name,String sex){
		if(bFull){//产品没有被消费，就把生产者线程阻塞
			try {
				wait();	//先放锁，再阻塞//如果这一步换成sleep虽然本线程正在等待，但是锁没有被释放，另一个线程无法做getPerson动作，
						//waait多长时间呢，当另一个线程运行到notify的时候就通知wait唤醒，但不能立即执行，等getPerson走完并释放synchronized才能恢复锁资源往下执行，
						//但是一旦所资源被释放，那么两个资源时可同时竞争所资源的，getPerson再次被同一个线程抢到，那么就会导致同一个产品被消费两次。
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name=name;
		this.sex=sex;
		bFull=true;
		notify();
	}
	
	public synchronized void getPerson(){
		if(!bFull){//如果没有产品，就把消费者线程阻塞
			try {
				wait();//释放锁并阻塞当前线程，
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.name+"\t"+this.sex);
		bFull=false;
		notify();
	}
}

class Productor extends Thread{//产生Person这个对象，继承自多线程，
	private Person p;
	public Productor(){}
	public Productor(Person p){
		this.p=p;
	}
	@Override
	public void run() {//这个run方法就是产生一个具体的实例
		// int i=0;
		boolean b = true;
		while (true) {
			synchronized (this) {
			b = !b;
			if (b) {
				this.p.setPerson("zs", "男");
			} else {
				this.p.setPerson("李思", "女");
			}
			
			}
		}
	}
}
class Consumer extends Thread{//获取已经产生的学生实例的信息
	private Person p;
	public Consumer(){}
	public Consumer(Person p){
		this.p=p;
	}
	
	@Override
	public void run(){//调用学生信息
		while (true) {
			this.p.getPerson();
		}
	}
}
public class TestCustom {

	/**
	 * 我们已经解决了性别数据混乱的现象，那么如何实现生产和消费交替出现呢，根据同步模型原理，对方能够相互解锁唤醒，那么应用wait和notify是否可以实现呢
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Person person=new Person();
		Productor p=new Productor(person);
		Consumer c=new Consumer(person);
		p.start();
		c.start();
	}

}
