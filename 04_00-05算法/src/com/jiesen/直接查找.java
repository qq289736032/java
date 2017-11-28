package com.jiesen;

import java.util.Scanner;

public class 直接查找 {

	/**
	 * 这个方法用于直接在数组里面查找是否存在某个元素
	 * @param
	 * 
	 */
	public static int straightSearch(int[] a,int num){
		
		for(int i=0;i<a.length;i++){
			if(a[i]==num)
				return i;
		}
			
		return -1;
	}
	public static void main(String[] args) {
		int[] a={1,9,2,8,7,3,6,4,5};
		System.out.println("数组的内容如下：");
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		System.out.println("请输入查找的元素：");
		int num=new Scanner(System.in).nextInt();
		int index=straightSearch(a,num);
		if(index<0)
			System.out.println("没有找到该元素");
		else 
			System.out.print("找到该元素,位置为："+index);
	}

}
