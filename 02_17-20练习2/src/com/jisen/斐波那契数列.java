package com.jisen;

import java.util.Scanner;

public class 斐波那契数列 {

	/**
	 * 1,1,2,3,5,8,13
	 * f(3)=2
	 * f(n)=f(n-1)+f(n-2)  n>=3
	 */
	
	public static int f(int n){
		if(n==1||n==2) return 1;
		return f(n-1)+f(n-2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("请输入斐波那契数列个数n:");
		Scanner scan= new Scanner(System.in);
		int n=scan.nextInt();
		
		
		System.out.print("前n个斐波那契为:");
		for(int i=1;i<=n;i++) {
			System.out.print(f(i)+" ");
		}
		
	}

}
