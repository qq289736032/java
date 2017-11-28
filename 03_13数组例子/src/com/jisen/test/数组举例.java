package com.jisen.test;

public class 数组举例 {

	/**
	 * 数组练习
	 */
	public static void main(String[] args) {
		int[] a;
		a=new int[3];
		a[0]=1;
		a[1]=2;
		a[2]=3;
		int[] b=new int[4];
		int[] c={4,5,6};
		
		System.out.println(a[2]);
		System.out.println(b.length);
		System.out.println(b[b.length-1]);
		//两种遍历方式
		System.out.println(c[0]+" "+c[1]+" "+c[2]);
		for(int val:c)
			
			System.out.print(val+"");
		
		
	}

}
