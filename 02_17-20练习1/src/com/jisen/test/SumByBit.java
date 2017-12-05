package com.jisen.test;

import java.util.Scanner;

public class SumByBit{

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("璇疯緭鍏ヤ竴涓鏁存暟锛�");
		int num = new Scanner(System.in).nextInt();
		int sum=0;
		
		while(num!=0){
			sum=num%10+sum;
			num/=10;
		}
			
		System.out.print("鍚勪綅鏁扮殑鍜屼负锛�"+sum);

	}

}
