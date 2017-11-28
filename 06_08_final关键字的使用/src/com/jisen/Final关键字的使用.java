package com.jisen;


/**
 * 1、final修饰类，不能被继承
 * 2、final修饰方法，不能被复写
 * 3、final修饰常量，不能被改写
 */



 class AA{			//父类加上final之后就不能被继承
	
}
class BB extends AA{	//父类加上final之后就不能被继承
	public  void fun() {
		System.out.println("BB");
	}
}
class CC extends BB{
	@Override
	public void fun() {	//父类方法加上final之后就不能被复写
		System.out.println("CC");
	}
}
public class Final关键字的使用 {

	/**
	 * 1、final修饰类，不能被继承
	 * 2、final修饰方法，不能被复写
	 * 3、final修饰常量，不能被改写
	 */
	public static final int NUM=10;//修饰常量的标准形式，
	public static void main(String[] args) {
		final int a=10;
		//a=20;//常量被修饰成final时不能被修改

	}

}
