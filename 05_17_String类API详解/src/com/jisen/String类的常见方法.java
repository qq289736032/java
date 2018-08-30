package com.jisen;

public class String类的常见方法 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = "ac";
		System.out.println(s1.compareTo(s2));// 两个字符串从第一个元素比较，比较到c>b那么s2>s1返回值-1

		s2 = s2.concat("dd");// 直接连接
		System.out.println(s2);

		String s = "haha.txt";
		if (s.endsWith(".txt")) {
			System.out.println("要打印");
		} else {
			System.out.println("不需要打印");
		}
		//c语言有三种输出方式 printf直接输出的终端， sprintf直接输出到字符串， fprintf直接输出到文件 
		String ss=String.format("我是%s，我今年%d岁","zs", 20);
		System.out.println(ss);

		String str = "abc 123";

	}

}
