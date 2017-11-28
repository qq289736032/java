package com.jisen.test;

public class 二维数组的应用 {

	/**
	 * 但需要注意的是，只有在初始化的时候，数组才能整体赋值，在其他情况下不能整体赋值，必须一个个赋值。需要注意的是二维数组本质就是由很多个一维数组组成，每一个一维数组
	 * 的元素可以不同，比如：int[][]
	 */
	public static void main(String[] args) {
//		第一种声明和初始化
//		int[][] a=new int[3][4];
//			a[0][0]=11;
//			a[0][1]=12;
//			a[0][2]=13;
//			a[0][3]=14;
//			a[1][0]=21;
//			a[1][1]=22;
//			a[1][2]=23;
//			a[1][3]=24;
//			a[2][0]=31;
//			a[2][1]=32;
//			a[2][2]=33;
//			a[2][3]=34;
		
		
		
//		第二种声明和初始化
		int[][] a=new int[3][];
		a=new int[][]{{11,12,13,14},{21,22,23},{31,32,33,34}};
		
//		或简写
//		int[][] a=new int[][]{{11,12,13,14},{21,22,23,24},{31,32,33,34}};
		
//		或简写
//		int[][] a={{11,12,13,14},{21,22,23,24},{31,32,33,34}};
		
//		数组遍历1	
//			for(int i=0;i<3;i++){
//				for(int j=0;j<a[i].length;j++){
//					System.out.print(a[i][j]+"\t");
//				}
//				System.out.println();
//			}
//			System.out.print(a[1].length);
//		数组遍历2
//		for (int i=0;i<a.length;i++){
//			for(int val:a[i]){
//				System.out.print(val+" ");
//			}
//			System.out.println();
//		}
//		遍历3
		for (int[] b:a){
			for(int val:b){
				System.out.print(val+" ");
			}
			System.out.println();
		}
	}

}
