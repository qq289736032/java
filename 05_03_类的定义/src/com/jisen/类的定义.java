package com.jisen;
/*
 * 1、定义一个类，类里面的成员有：属性（姓名，年龄，身高，籍贯），有行为（talk部分）
 * 2、因为属性是专属于这个类的，所以加private.私有的目的就是保存一个核心值，要达到一定阀值才能访问到它。这就保护了这个内心的真实想法不被随便让别人知道
 * 3、但是也要开放一个窗口让外部设置和获取属性
 */
class Person{
	private String name;
	private int age;
	public void setName(String n){
		name=n;
	}
	public void setAge(int a){
		if(a<0||a>120){		//对数据加以判断否则会出现错误年龄
			age=20;
			return ;
		}
		age=a;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	private void talk(){
		//System.out.println("我叫："+name+"，我今年"+age+"岁");
		System.out.println("不干了~~");
	}
	void say(int rate){
		if(rate>=80){
			talk();
		}else{
			System.out.println("我愿意加班，我以加班为荣");
		}
		
	}
}

public class 类的定义 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p1=new Person();
		p1.setName("钟吉森");
		p1.setAge(25);
		//p1.name="钟吉森";
		//p1.age=-25;
		//p1.talk();
		//p1.talk();
		p1.say(90);
		
		Person p2=new Person();
		//p2.talk();
		//p1.talk();
		p2.setName("王大锤");
		p2.setAge(-26);
		//p1.name="钟吉森";
		//p1.age=-25;
		//p2.talk();
		p1.say(30);
		
		new Person().say(85);
	}

}
