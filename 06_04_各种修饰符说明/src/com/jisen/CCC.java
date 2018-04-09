package com.jisen;

/**
 * 除了private其余同包可见
 */
public class CCC{
	public void fun(){
		AAA ccc=new AAA();
		//ccc.a=1000;//报错，同一个包中其他类不能访问private修饰的成员
		ccc.b=2000;//protect可见
		ccc.c=3000;//default可见
		ccc.d=4000;//public可见
	}
}
