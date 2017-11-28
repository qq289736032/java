package com.jisen;

class A{
	private int a=10;
	
	class C{//内部类可以访问a私有成员
		public void fun(){
			System.out.println(a);
		}
	}
}
class B{//外部类不可以访问a私有成员
	public void fun(){
		//A aa=new A();
		//System.out.println(a);//外部类不可以访问a私有成员
	}
}
public class InnerClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
