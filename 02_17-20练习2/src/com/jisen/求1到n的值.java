package com.jisen;

import java.util.Scanner;

public class 求1到n的值 {

	/**
	 * sum(n)=1+2+..+n-1+n
	 * sum(n-1)=1+2+..+n-1
	 * sum(n)-sum(n-1)=n
	 * sum(n)=n+sum(n-1)
	 */
	public static int sum(int n){
		if(n==1) return 1;
		return n+sum(n-1);
	}
	public static void main(String[] args) {
		System.out.print("请输入n：");
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		System.out.println("1+2+3+...+n="+sum(n));
	}

}
