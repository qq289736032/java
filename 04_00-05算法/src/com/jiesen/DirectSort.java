package com.jiesen;

//import java.util.Scanner;

public class DirectSort {

	/**
	 *每次找最大跟次后元素交换
	 * @param
	 * 
	 */
	
	public static void print(int[] a){
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	
	private static void straightSelectSort(int[] a){
		for (int j = 1; j < a.length; j++) {
			int max = 0;
			for (int i = 1; i < a.length-j+1; i++) {
				if (a[max] < a[i])
					max = i;
			}
			if (max != a.length-j) {
				a[max] = (a[max] + a[a.length-j]) - (a[a.length - j] = a[max]);
			}
		}
		
	}
	public static void main(String[] args) {
		int[] a={1,9,2,8,7,3,6,4,5};
		System.out.println("数组的内容如下：");
		print(a);
		straightSelectSort(a);
		System.out.println("排序后，数组内容如下");
		print(a);
		
	}

}
