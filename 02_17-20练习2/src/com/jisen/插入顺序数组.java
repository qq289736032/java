package com.jisen;

//import java.util.Arrays;
import java.util.Scanner;

public class 插入顺序数组 {

	/**
	 * 假设有10个数已经按照从小到大的顺序存放在数组中，要求向从键盘输入一个整数，插入这10个数中，使得数组扔是从小到大排列
	 */
	public static void main(String[] args) {
		int[] a={1,3,5,7,9,11,13,15,17,19};//原数列
		int[] b=new int[a.length+1];
		System.arraycopy(a,0,b,0,a.length);
		System.out.print("插入元素前：");
		disp(a);
		
		System.out.print("请输入你要插入的整数：");
		Scanner scan=new Scanner(System.in);
		b[b.length-1]=scan.nextInt();
//		Arrays.sort(b);
		sortNum(b,b[b.length-1]);
		System.out.println("插入之后的结果为：");
		disp(b);
	}
	/*
	 * 数组遍历for(int i:a)，表示将a中的元素从a[0]赋给i并依次循环,也可以用Array.toSring(a)
	 */
	public static void disp(int[] a){
		for(int i:a)
			System.out.print(i+" ");
		System.out.println();		
	}
	/*
	 * 插入后排序，抓住原数组的特点，插入元素放在数组最后一个位置，该元素之前的序列是有序的。
	 */
	public static void sortNum(int[] a,int insertNum){
		int i=0;
		for(i=a.length-2;i>=0;i--){
			if(a[i]<insertNum){
				a[i+1]=insertNum;
				break;
			}
			a[i+1]=a[i];
			 if(i==0)
				a[i]=insertNum;
				
			
				
		}
		
	}
}
