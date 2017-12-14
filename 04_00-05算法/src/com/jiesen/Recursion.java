package com.jiesen;
/**
 * µİ¹éËã·¨recursion
 * @author Administrator
 *
 */
public class Recursion {
	
	public static int fib(int n){
		if(n==1||n==2){
			return 1;
		}else{
			return fib(n-1)+fib(n-2);
		}
	}
	
//	public static int[] fibArray(int n){
//		int[] array =new int[n]; 
//		for(int i = 0; i < n; i++){
//			array[i] = fib(i);
// 		}
//		return array;
//	}
	public static void main(String[] args) {
		int fib = fib(7);
//		int[] fibArray = fibArray(7);
		System.out.println(fib);
//		System.out.println(fibArray);
	}
}
