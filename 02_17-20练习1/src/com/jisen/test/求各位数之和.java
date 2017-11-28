package com.jisen.test;

import java.util.Scanner;

public class 求各位数之和 {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("请输入一个正整数：");
		int num = new Scanner(System.in).nextInt();
		int sum=0;
		
		while(num!=0){
			sum=num%10+sum;
			num/=10;
		}
			
		System.out.print("各位数的和为："+sum);

	}

}
