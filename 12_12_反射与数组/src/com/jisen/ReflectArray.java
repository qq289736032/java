package com.jisen;

import java.lang.reflect.*;


public class ReflectArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//将用一个对象来表示数组
		int[] a={1,2,3};
		Class<?> c=a.getClass();
		Class<?> ct=c.getComponentType();//获取运行时类型
		
		//传递数组的运行时类型和数组长度,得到的是一个该类型的对象obj的数组，并且拥有这么多容量
		Object obj=Array.newInstance(ct, 10);//传递数组的运行时类型和数组长度
		
		Array.set(obj, 2, 100);
		Array.set(obj, 5, 10);
		Array.set(obj, 8, 7);
		System.out.println(Array.getInt(obj, 2));
	}

}
