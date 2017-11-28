package com.jisen;

public class BBB extends AAA{
	public void say(){
//		a=100;//报错，同一个包中子类不能访问private修饰的成员
		b=200;
		c=300;
		d=400;
		AAA bbb=new AAA();//报错，同一个包中子类不能访问private修饰的成员
		//bbb.a=1;
		bbb.b=2;
		bbb.c=3;
		bbb.d=4;
	}
}
