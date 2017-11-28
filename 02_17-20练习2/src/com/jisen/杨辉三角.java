package com.jisen;

import java.util.Scanner;

public class 杨辉三角 {

	/**
	 * 题目打印杨辉三角前N行
	 * 杨辉三角的特点是该数等于肩上两数之和
	 */
	public static void main(String[] args) {
		System.out.print("请输入杨辉三角的行数n：");
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		System.out.println("前"+n+"行杨辉三角是：");
		pascalTriangle(n);
	}
	public static void pascalTriangle(int n){
		int[][] a=new int[n][];
		for(int i=0;i<n;i++){
			a[i]=new int[i+1];
			a[i][0]=1;
			a[i][i]=1;
		}
		for(int i=2;i<n;i++){
			for(int j=1;j<i;j++){
				a[i][j]=a[i-1][j]+a[i-1][j-1];
			}
		}
		for(int[] i:a){
			for(int j:i)
				System.out.print(j+"\t");
			System.out.println();
		}	
		
	}
}
