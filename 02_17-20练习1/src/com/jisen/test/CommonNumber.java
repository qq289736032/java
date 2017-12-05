package com.jisen.test;

import java.util.Scanner;

public class CommonNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("请输入第1个数");
		int num1 = new Scanner(System.in).nextInt();
		System.out.print("请输入第2个数");
		int num2 = new Scanner(System.in).nextInt();

		// int min=0;
		// if(num1<num2){
		// min=num1;
		// }else min=num2;
		int min = num1 > num2 ? num2 : num1;
		int commonDivisor = 0;
		for (int i = 1; i <= min; i++) {
			if (num1 % i == 0 && num2 % i == 0) { // 如果满足被两个数整除则这个数是公约数
				commonDivisor = i;
			}
		}
		
		int max = num1 < num2 ? num2 : num1;
		int commonMultiple=0;
		for(int j=max;;j++){
			if(j%num1 == 0 && j%num2 == 0){
				commonMultiple=j;
				break;
			}
		}
		System.out.println("这两个数的最大公约数和最小公倍数为：" + commonDivisor+" "+commonMultiple);

	}

}
