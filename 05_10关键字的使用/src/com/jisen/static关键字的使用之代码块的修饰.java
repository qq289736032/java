package com.jisen;

class MyC{
	static int m=0;//
	public MyC(){
		m++;
	}
	public static void talk(){
		System.out.println(m);
	}
}

public class static关键字的使用之代码块的修饰 {

	/**
	 * 每实例化一个对象开辟一个空间，都要对static修饰的m进行加1
	 * 这个程序可以统计游戏在线人数，每有一个人上线就加1
	 * 
	 */
	public static void main(String[] args) {
		new MyC();
		MyC m1=new MyC();
		MyC m2=new MyC();
		MyC m3=new MyC();
		MyC.talk();//用类直接调用，而不用实例化之后的对象去调用
		MyC m4=new MyC();
		MyC m5=new MyC();
		MyC m6=new MyC();
		MyC m7=new MyC();
		MyC.talk();
	}

}
