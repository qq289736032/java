package com.jisen.test;

public class 求数组元素最大最小值 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a={1,3,4,5,7,8,2,9,0,6,2};
		int max = a[0];
		int min = a[0];
		for(int val:a){
			if(max<val){
				max=val;
			}
			if(min>val){
				min=val;
			}
		}
		System.out.println("max = "+max);	
		System.out.print("min = "+min);	
	}

}
