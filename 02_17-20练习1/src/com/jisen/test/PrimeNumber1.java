package com.jisen.test;

public class PrimeNumber1{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int i=0;
		int sum=0;
		for (i = 101; i <= 199; i++) {
			
			for (int j = 1; j <= i; j++) {
				sum+=i%j;
				}
			
			if (sum == 0) {
				System.out.println(i);
			}
			}

		}

	

}
