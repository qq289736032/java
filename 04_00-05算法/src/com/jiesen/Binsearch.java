package com.jiesen;

import java.util.Arrays;
import java.util.Scanner;

public class Binsearch{

	/**
	 * 杩欎釜鏂规硶鐢ㄤ簬鐩存帴鍦ㄦ暟缁勯噷闈㈡煡鎵炬槸鍚﹀瓨鍦ㄦ煇涓厓绱�
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
		System.out.println("鏁扮粍鐨勫唴瀹瑰涓嬶細");
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		
		System.out.println("璇疯緭鍏ユ煡鎵剧殑鍏冪礌锛");
		int num=new Scanner(System.in).nextInt();
		int index=binarySearch(a,num);
		if(index<0)
			System.out.println("娌℃湁鎵惧埌璇ュ厓绱");
		else 
			System.out.print("鎵惧埌璇ュ厓绱�浣嶇疆涓猴細"+index);
	}

}
