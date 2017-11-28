package com.jisen;

import com.jisen.person.Person;

public class GetClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//其中1、2、3适用于知道类的情况，获取该对象的运行时识别
			//4适用于只知道对象，获取该对象的运行时识别
			
			//1.1利用Class自身的静态方法forName，参数必须是：包.类名
			Class<?> c1= Class.forName("java.lang.String");
			System.out.println(c1.getName());
			
			//1.2利用ClassLoader提供的方法loadclass,参数必须是：包.类名
			ClassLoader cl=ClassLoader.getSystemClassLoader();
			Class<?> c2=cl.loadClass("java.lang.String");//类的二进制名称
			System.out.println(c2.getName());
			
			//1.3利用每个类都有一个字段：class
			Class<?> c3=String.class;
			System.out.println(c3.getName());
			
			//1.4、利用Object的getClass（）方法
			Object o=new String("hello");
			Class<?> c4=o.getClass();
			System.out.println(c4.getName());
			
			//2基本数据类型如何获取运行时
			//2.1知道基本数据类型的情况下		//更多时候就用这个
			Class<?> c5=int.class;
			System.out.println(c5.getName());
			
			//2.2l利用包装类
//			Class<?> c6=Integer.class;
			Class<?> c6=Integer.TYPE;
			System.out.println(c6.getName());
			//
			Class<Void> vo=void.class;
			Class<?> c7=Person.class;
			System.out.println(c7.getSuperclass());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
	}

}
