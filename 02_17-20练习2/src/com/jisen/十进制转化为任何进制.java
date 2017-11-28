package com.jisen;


import java.util.Arrays;
import java.util.Scanner;

public class 十进制转化为任何进制 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("请输入一个十进制数："); 
		Scanner scan1=new Scanner(System.in);
		int num=scan1.nextInt();
		System.out.println("请输入你要转换的进制："); 
		Scanner scan2=new Scanner(System.in);
		int numSystem=scan2.nextInt();
		System.out.println(num+"的"+numSystem+"进制为");
		System.out.println(num+"的"+numSystem+"进制为"+Arrays.toString(f(num,numSystem)));
	}
	public static int[] f(int num,int numSystem){
		
		int[] a=new int[8];
		int i=0;
		while(num!=0){
			
			a[a.length-1-i]=num%numSystem;
			num=num/numSystem;
			i++;
		}
		return a;
		
		
	}
}
