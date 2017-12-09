package com.jisen.test;

import java.lang.reflect.Array;


public class TestArray {

	/**
	 * Array类提供了动态创建和访问 Java 数组的方法
	 */
	public static void main(String[] args) {
		
		Object arr = Array.newInstance(Integer.class, 5);
		Object arr2 = Array.newInstance(int.class, 5);
		Array.set(arr, 0, 1);
		
		
		int[] a;
		a=new int[3];
		a[0]=1;
		a[1]=2;
		a[2]=3;
		int[] b=new int[4];
		int[] c={4,5,6};
		
		System.out.println(a[2]);
		System.out.println(a);//不会打印首地址打印的是这个数组对象的地址
		System.out.println(b.length);
		System.out.println(b[b.length-1]);
		//涓ょ閬嶅巻鏂瑰紡
		System.out.println(c[0]+" "+c[1]+" "+c[2]);
		for(int val:c)
			
			System.out.print(val+"");
		
		
	}

}
