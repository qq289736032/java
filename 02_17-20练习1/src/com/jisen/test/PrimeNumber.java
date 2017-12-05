package com.jisen.test;

public class PrimeNumber{

	/**
	 * 姹�00~200涔嬮棿鐨勫叏閮ㄧ礌鏁帮紙绱犳暟灏辨槸闄や簡1鍜岃嚜韬箣澶栧啀娌℃湁绾︽暟锛�
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("100~200涔嬮棿鐨勭礌鏁颁负锛�");
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
