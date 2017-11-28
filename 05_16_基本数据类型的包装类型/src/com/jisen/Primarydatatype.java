package com.jisen;

public class Primarydatatype {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a=10;
		System.out.println(Integer.bitCount(a));
//		Integer i1 =new Integer(10);
		Integer i1 =20;//说明引用基本数据类型可以直接赋值，但是i1是一个对象是一个类变量，这个过程叫装箱
		int aa=i1;//把该对象赋给一个整形变量，类类型转化为基本数据类型这个过程叫拆箱
		Integer i2=new Integer(20);
		System.out.println(i1.compareTo(i2));//比较如果i1<i2返回-1，相等返回0，否则返回1
		
		int m=Integer.parseInt("123");//将数字字符串转换成数字
		System.out.println(m);
		//实现过程
		String str="123";
//		System.out.println(str.length());
//		System.out.println((str.charAt(0)-'0')*Math.pow(10, 2));
//		System.out.println((str.charAt(1)-'0')*Math.pow(10, 1));
//		System.out.println((str.charAt(2)-'0')*Math.pow(10, 0));
		int isum=0;
		for(int i=0;i<str.length();i++)
			 isum+=(int)(str.charAt(i)-'0')*Math.pow(10, str.length()-i);
		System.out.println(isum);
		
		
		
	}

}
