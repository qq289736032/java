package com.jisen.test;

import java.util.Scanner;

public class JudgeIsLeap {

	/**
	 * 能被4整除的是闰年，如果是百年数则要被400整除
	 * if(year%4==0&&year%100!=0||year%400==0)
	 */
	public static void main(String[] args) {
		System.out.println("请输入一个年�?");
			Scanner scan=new Scanner(System.in); 
			int year = scan.nextInt();
			if(year%4==0&&year%100!=0||year%400==0)
				System.out.println(year+"是闰�?");
			else
				System.out.println(year+"是平�?");
	}

}
