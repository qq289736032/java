package com.jisen.test;

public class 求素数 {

	/**
	 * 求100~200之间的全部素数（素数就是除了1和自身之外再没有约数）
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("100~200之间的素数为：");
		for (int i = 101; i <= 199; i++) {
			int sum = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					sum = sum + 1;
				}
			}
			if (sum == 2) {
				System.out.println(i);
			}

		}

	}

}
