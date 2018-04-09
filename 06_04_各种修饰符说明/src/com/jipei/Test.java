package com.jipei;

import com.jisen.*;

/**
 * private 只在本类花括弧下可见
 * 重点在default protected 无论在哪对子类可见,但不同包的实例不可见
 *
 */
class DDD extends AAA{	//跨包的时候类之间不可见，AAA cannot be resolved to a type
	public void fun(){
		//a=1;//子private只有在本类的代码中可见	变量不能访问
		this.b=2;//不同包	子类	protect	变量可以访问
		//c=3;//不同包	default时外包不能访问子类	缺省时即无权限关键字修饰时不能访问
		this.d=4;
		AAA ddd=new AAA();
		//ddd.a=5;//不同包	子类利用父类对象	private	变量不能访问
		//ddd.b=5;//不同包	子类利用父类对象	protect	变量不能访问
		//ddd.c=7;//不同包	子类利用父类对象	缺省时	变量不能访问
		ddd.d=8;
	}
}
class EEE{
	public void fun(){
		AAA eee=new AAA();
		//eee.a=10;
		//eee.b=20;
		//eee.c=30;
		eee.d=40;
	}
}
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AAA ddd=new AAA();
		//ddd.d
		// TODO Auto-generated method stub

	}

}
