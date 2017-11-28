package com.jisen;

/*
 * 方法内部类
 */

class Outer3{
	private int i=10;
	public void fun(final int k) {
		final int j=3;
		class Inner3{//方法类中的内部类
			public void say() {
				System.out.println(i);
				System.out.println(j);//在在方法内部类中不能引用定义在不同方法中的非final变量j。所以要在j中加上final
				System.out.println(k);//在内部类中不能引用定义在不同方法中的非final变量j。所以要在j中加上final
			}
		}
	}
}

public class InnerClassDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
