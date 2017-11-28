package com.jisen;

public class Demo1 {

	/*
	 * 内存的分区（5个大区）
	 * 栈:存放基础数据,如数字,声明变量的时候在栈区开辟一个空间指向堆区对象的地址
	 * 堆:存放对象的
	 * 代码区
	 * 静态区：static
	 * 文字常量区：针对字符串
	 */
	public static void main(String[] args) {
		String s1="hello";//hello在文字常量区，把hello在文字常量区的地址赋给了保存在了s1所在的栈区
		String s2=new String("hello");//在堆区产生了一个空间并保存了文字常量区hello的地址，该堆区空间的地址又保存在了栈区的s2
		String s3="hello";//s1和s3保存的相同的地址
		String s4=new String("hello");//new出来的空间跟s2不同，
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
//		
//		System.out.println("hello".hashCode());
//		System.out.println(s1.hashCode());
//		System.out.println(s2.hashCode());
//		System.out.println(s3.hashCode());
//		System.out.println(s4.hashCode());
//		
		System.out.println(System.identityHashCode("hello"));
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		System.out.println(System.identityHashCode(s3));
		System.out.println(System.identityHashCode(s4));
		
		System.out.println(s1=="hello");
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s2==s4);
		System.out.println(s1==s4);
		
		System.out.println(s1.equals(s2));//1、先比较hello的长度，再比较第一个字母h依次比较，发现相同则返回true
	}

}
