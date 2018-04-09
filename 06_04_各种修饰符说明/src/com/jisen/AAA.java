package com.jisen;

public class AAA{
	private int a;
	protected int b;
	int c;//default
	public int d;

	public void talk(){//在本类中所有数据都被talk（）这个方法可见
		AAA aaa=new AAA();
		aaa.a=10;
		aaa.b=20;
		aaa.c=30;
		aaa.d=40;
		a=10;
		b=20;
		c=30;
		d=40;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
	
}
