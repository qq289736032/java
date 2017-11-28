package com.jisen;

public class 递归调用 {

	/**
	 * @param args
	 */
	
	//f(n)=n*f(n-1)
	public static int fun1(int n){
		if(n==0) return 1;
		return n*fun1(n-1);
	}
	
	public static int fun2(int n){
		if(n==1) return 1;
		return n+fun2(n-1);
	}
	public static int fun3(int n){
		if(n==1) return 1;
		return fun1(n)+fun3(n-1);
	}
	public static void main(String[] args) {
		System.out.println("5!="+fun1(5));
		System.out.println("1+2+...+100="+fun2(100));
		System.out.println("1!+2!+3!+4!+5!="+fun3(5));
	}

}
