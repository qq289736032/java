package com.jisen;

public class 方法的重载 {

	/**
	 * 方法的重载，实现的业务逻相同，但是参数个数和数据类型不同，这样就会导致同一个过程出现很多类似的方法名字，比如求悠闲个数的和，可以是两个数相加，三个数相加，四个数
	 * 或者参数可以是整形，双精度型，浮点型，但是实现这些求和功能，如果方法名要不同就会出现，
	 * add1，add2，add3，doubleadd，doubleadd1，doubleadd2，doubleadd3。实际上可以都叫add（）
	 * 方法的
	 */
	public static int add(int a,int b){
		return a+b;
	}
	public static int add(int a,int b,int c){
		return a+b+c;
	}
	public static double add(int a,int b,int c,int d){
		return a+b+c;
	}
	public static void main(String[] args) {
		int a =10;
		int b=20;
		int s1=add(a,b);
		System.out.println("s1="+s1);
		int c=30;
		int s2=add(add(a,b),c);
		
		System.out.println("s2="+s2);
		int s3=add(a,b,c);
		System.out.println("s3="+s3);
		int d=10;
		double s4=add(a,b,c,d);
		System.out.println("s3="+s4);
		}

}
