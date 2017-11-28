package com.jiesen;

import java.util.Arrays;
import java.util.Scanner;

public class 折半查找法 {

	/**
	 * 这个方法用于直接在数组里面查找是否存在某个元素
	 * @param
	 * 
	 */
	public static int binarySearch(int[] a,int num){
		int min=0;
		int max=a.length-1;
				
		while (min < max) {
			int mid = (min + max) / 2;
			if (a[mid] == num)
				return mid;
			else if (a[mid] > num)
				max = mid - 1;
			else
				min = mid + 1;
		}
		
		for(int i=0;i<a.length;i++){
			if(a[i]==num)
				return i;
		}
			
		return -1;
	}
	public static void main(String[] args) {
		int[] a={1,9,2,8,7,3,6,4,5};
		Arrays.sort(a);
		System.out.println("数组的内容如下：");
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		
		System.out.println("请输入查找的元素：");
		int num=new Scanner(System.in).nextInt();
		int index=binarySearch(a,num);
		if(index<0)
			System.out.println("没有找到该元素");
		else 
			System.out.print("找到该元素,位置为："+index);
	}

}
