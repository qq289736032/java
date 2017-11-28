/**
 * 		Java程序在运行期间可以动态加载，解析和使用一些在编译阶段并不确定的类型数据，这一机制被称为反射机制，
 * 反射库提供了一个非常丰富且精心设计的工具类，以便编写能够动态操纵Java代码的程序。使用反射，在设计和运行中添加新类时能够快速的应用开发工具动态的查询新添加类的能力
 * 
 */
package com.jisen;

import java.lang.reflect.*;

class A{
	public static int a;
	private int b;
	int c;
	protected int d;
	void fun1(){}
}
class B{
	void fun2() {

	}
}

public class 概述 {
	public static void main(String[] args) {
		Class<Integer> a = int.class;
	
		A a1 = new A();
		Object a2=new A();
		B b = new B();
//		a1.//同样一个点事件，eclipse能够获取该类的所有除了private的成员方法和属性，包括默认继承自Object的方法，这个现象叫反射
		
//		a2.//a2在没有运行时它的类型是Object类型的，因此只能看到编译时类型的成员方法和属性，但是在运行的时候它就是一个具体的A类型了
		Class<? extends Object> c=a2.getClass();//获取它的运行时类型
		Method[] m=c.getDeclaredMethods();		//获取得到运行时类型之后就能间接得到它运行时的方法
		for(Method mt:m){
			System.out.println(mt.getName());
		}
		Field[] f=c.getDeclaredFields();//获取得到运行时类型之后就能间接得到它运行时的成员属性 ，甚至利用这个方法还能访问私有成员，
		for(Field ft:f){
			System.out.println(ft.getName());
		}
//		b.
	}
}
