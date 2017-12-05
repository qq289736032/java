package com.jisen.test;

import java.util.Scanner;

public class DecimalToBinary{

	/**
	 * 思路
	 * 思路1、将该十进制整数转化为二进制，用短除法？用数组保存然后再从数组取�?负数情况，则�?��先求其原码，然后将其转化为补码（实际上就是最高位变为1�?
	 * 思路2、实际上�?��负数的二进制补码和一个整数的原码是一样的，比�?100的补码和4294967196的原码是�?��的，我们可以直接对该正数进行操作即可
	 * 思路3、实际上计算机中数据都是以二进制补码形式存储的，我们可以利用位操作去取每�?��数据�?
	 */
	public static void main(String[] args) {
		System.out.print("请输入一个整数：");
		int num=new Scanner(System.in).nextInt();
		int[] a=new int[32];
		if(num<0){
			num=-num;
			a[a.length-1]=1;
		}
		
		int i=0;
		while(num!=0){
			a[i] = num%2;
			num=num/2;
			i++;
		}
		System.out.print("转化为二�?制为�?");
		for(int j=a.length-1;j>=0;j--){
			System.out.print(a[j]);
		}
		//System.out.println();
	}

}
