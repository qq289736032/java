package com.jisen.salvemores;



class  Person{

	String name;
	String sex;
	public Person(){}
	public Person(String name, String sex) {
		this.name = name;
		this.sex = sex;
	}
	public static boolean isEmpty=true;

	public synchronized void  setPerson(String name,String sex){
		if(!isEmpty){//如果不是是空的那就阻塞让给消费
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name;
		this.sex = sex;
		//生产完之后要将状态改为空改为实
		isEmpty=false;
		//并且唤醒消费者产者
		notify();
	}
	public synchronized void getPerson(){
		if (isEmpty) {//如果是空的那就阻塞让给生产者
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + "--" + sex);
		//消费完之后要将状态改为空
		isEmpty=true;
		//并且唤醒生产者
		notify();
	}
}
class Productor extends Thread{
	private Person p;//成员属性一般都私有？
	public Productor(){}
	public Productor(Person p){
		this.p=p;
	}
	@Override
	public void run() {//出现男女姓名错乱的情况，原因是，CPU给一个线程时间片段到了4ns就会切换到下一个线程，
						//因此当写入 p.sex的时候，正好时间片段到了，Consumer读取的是上李思,
						//一个实例连续出现多次的原因是，一个线程连续消费读取了实例
		
		boolean b=true;
		while (true) {
				if (b) {
					this.p.setPerson("zs", "男");
					b = false;
				} else {
					this.p.setPerson("李思", "女");
					b = true;
				}
			//}
		}
	}
}
class Consumer extends Thread{
	private Person p;
	public Consumer(){}
	public Consumer(Person p){
		this.p=p;
	}
	
	@Override
	public void run() {//交替生产两个固定的实例，也可以采用哨兵法，作为判断，两态和三态可以求，
		while(true){
			 this.p.getPerson();
		}
	}
}
public class TestConsumerQuestionSolve {

	/**
	 * 开两个线程，一个产生实例，一个获取实例，在获取的实例不匹配时姓名和性别时，该如何解决呢？
	 * 解决男女性别混乱，在生产一个实例的同时要保证已经读取完上一个实例，synchronized该放在何处能保证两个线程错开生产和读取呢
	 * 一般情况下是认为放放在循环里面，但是这两个线程执行的却不是同一个run放法，他们仅仅只是操作的时间有交叉，那必须得找到这两个线程的共同操作点，加以卡住。
	 * 我们发现这两个进程的的共同操作点是p这个对象，Productor这个线程利用引用p这个对象，对姓名和性别加以赋值，Consumer这个线程需要引用p这个对象获取姓名和性别
	 * 我们可以在分别在两个线程即将要引用p的地方分别设置互斥锁。
	 * 
	 * 这个问题解决完之后，新的问题又出现了，他们没有交替进行
	 * 
	 * 总结：就是在两个线程同时进入操作一个对象时，先进行一个判断，谁先谁后，
	 * 第一次，没产品当然要让生产者先生产，第一次，产品状态必然为空，设置isEmpty设为true，因此，消费者要判断为空时要wait等待生产者生产，
	 * 生产者，判断为为满时要wait让消费者先消费，等生产者生产出第一个实例，那么就要将isEmpty改为false，并且notify唤醒消费者。
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
