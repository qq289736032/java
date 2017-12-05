package com.jisen.test;

import java.math.BigInteger;
import java.util.Scanner;

public class SumOfFactorialIn1To15 {

	/**
	 * 阶乘的�?归算�?
	 * 阶乘数据类型选择:15!=1307674368000,实际上远远大�?字节�?��达的数据�?00110000 01110111 01110111 01011000 00000000
	 * 15！如果用int型保存则�?1110111 01110111 01011000 00000000===2004310016
	 */
	public static void main(String[] args) {
		System.out.print("请输入num:");
		int num=new Scanner(System.in).nextInt();
		BigInteger sum=BigInteger.valueOf(0);
		for(int n=1;n<=num;n++){
			BigInteger factorial=BigInteger.valueOf(1);
			for(int i=1;i<=n;i++)
				factorial=factorial.multiply(BigInteger.valueOf(i));
			System.out.println(n+"!="+factorial);
			sum=sum.add(factorial);
		}
		System.out.println("1!+2!+...+"+num+"!="+sum);	
	}

}
