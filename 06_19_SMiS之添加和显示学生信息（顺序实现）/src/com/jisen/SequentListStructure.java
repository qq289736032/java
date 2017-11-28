package com.jisen;

import java.util.Scanner;

public class SequentListStructure {

	/**
	 * @param args
	 */
	static int[] a=new int[100];//a起到的作用就是保存很多个数据
	static int i=0;//i起到的作用就是统计元素的个数
	public static void paddingData() {
		Scanner in = new Scanner(System.in);

		while (true) {
			System.out.println("请输入元素");
			int n = in.nextInt();
			if (n == 0)
				break;
			a[i] = n;
			i++;
		}
	}

	public static void traversingData() {
		for (int j = 0; j < i; j++) {
			System.out.print(a[j] + " ");
		}
	}
	public static void main(String[] args) {
		paddingData();
		traversingData();
		//insert delete isEmpty isFull select alert
	}

}
