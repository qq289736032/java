package com.jisen;

public class 方法参数可变 {

	/**
	 * 在方法的重载讲过，多个参数求和的时候，要写很多个同名方法，我的求和参数是1个？2个？5？8？那是不是每一种都要写一遍？
	 * Java里提供了参数可变的解决方案
	 * 
	 */
//	public static int add(int a,int b){
//		return a+b;
//	}
//	public static int add(int a,int b,int c){
//		return a+b+c;
//	}
//	public static int add(int[] a){
//		int sum=0;
//		for(int i=0;i<a.length;i++){
//			 sum+=a[i];
//		}
//		return sum;
//	}
	public static int add(int ...a){
		int sum=0;
		for(int i=0;i<a.length;i++){
			 sum+=a[i];
		}
		return sum;
	}
	public static void main(String[] args) {
		int a=10;
		int b=10;
		int c=10;
		int d=10;
		System.out.println("sum"+add());
		System.out.println("sum"+add(a));
		System.out.println("sum"+add(a,b));
		System.out.println("sum"+add(a,b,c));
		System.out.println("sum"+add(a,b,c,d));
		
		
	}

}
