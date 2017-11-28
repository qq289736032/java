package com.jisen;

import java.util.Random;

public class ClassOfRandom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random r1=new Random(1L);//new后面是一个无参构造方法//种子一样得到的随机数也一样
		Random r2=new Random(1);//后面的种子是如何选取的呢？Random(long seed)是一个长整型的种子
		System.out.println(r1.nextInt());
		System.out.println(r2.nextInt());
		System.out.println((int)(r1.nextDouble()));
	}

}
