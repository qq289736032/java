package com.jisen;

/**
 * 除了private其余同包可见
 */
public class BBB extends AAA{
	public void say(){
		//a=100;//报错，同一个包中子类不能访问private修饰的成员
		this.b=200;//protected修饰子类可见
		this.c=300;//default可见
		this.d=400;//public可见
		AAA bbb=new AAA();//报错，同一个包中子类不能访问private修饰的成员
		//bbb.a=1;
		bbb.b=2;//protected同包可见
		bbb.c=3;//同包可见
		bbb.d=4;
	}
}
