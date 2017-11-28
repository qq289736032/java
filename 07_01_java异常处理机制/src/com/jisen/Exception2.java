package com.jisen;

import java.util.Scanner;

public class Exception2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("请输入一个num");
		int num=new Scanner(System.in).nextInt();
		assert num>=0:"开平方的数据不能为负数";//断言，如果num大于零则往下运行，如果小于零则终止运行；
		double m=Math.sqrt(num);
		System.out.println(num+"平方根是"+m);
	}

}
