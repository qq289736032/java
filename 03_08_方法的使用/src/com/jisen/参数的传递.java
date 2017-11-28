package com.jisen;

public class 参数的传递 {
	public static void swap1(int[] m,int[] n){ //定义一个无返回值得的方法
		
		m[0]=(m[0]+n[0])-(n[0]=m[0]);
	}
public static void swap2(int[] a){ //定义一个无返回值得的方法
	
		a[0]=(a[0]+a[1])-(a[1]=a[0]);
	}

	/**
	 * 为什么调用swap之后m和n没有变，因为参数传递进去之后，在swap方法内m和n相互交换了但是当执行完之后，该方法栈区就会被gc回收，程序在main里继续执行，但是main
	 * 里的m和n没有任何改变，说白了就是调到外面执行了一下swap这个方法，然后对main不产生任何影响。
	 * 
	 * 这种传递方式称为单向传递，即无法反馈到main里
	 * 
	 * 如果想变就要把m和n的地址传进去，
	 * 
	 */
	public static void main(String[] args) {
		int[] m={2};
		int[] n={3};
		int[] a=new int[2];
		a[0]=4;
		a[1]=5;
		System.out.println("交换前："+m[0]+" "+n[0]);
		System.out.println("交换前："+a[0]+" "+a[1]);
		swap1(m, n);
		swap2(a);
//		m=(m+n)-(n=m);
		System.out.println("交换前："+m[0]+" "+n[0]);
		System.out.println("交换前："+a[0]+" "+a[1]);
	}

}
