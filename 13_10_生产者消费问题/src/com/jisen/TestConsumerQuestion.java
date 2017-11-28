package com.jisen;

class Person{
	String name;
	String sex;
	public Person(){}
	public Person(String name, String sex) {
		this.name = name;
		this.sex = sex;
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
//		int i=0;
		boolean b=true;
		while (true) {
//			i++;
			if (b) {
				p.name = "zs";
				p.sex = "男";
				b=false;
			} else {
				p.name = "李思";
				p.sex = "女";
				b=true;
			}
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
			System.out.println(p.name+"--"+p.sex);
		}

	}
}
public class TestConsumerQuestion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person person=new Person();
		Productor p=new Productor(person);
		Consumer c=new Consumer(person);
		p.start();
		c.start();
	}

}
