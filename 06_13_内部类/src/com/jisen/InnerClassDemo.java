package com.jisen;

class Outer1{
	private String name="haha";
	private int age =23;
	
	class Inner1{
		private String content="keke";
		private int age =22;
		public void say(int age){
			System.out.println(name);//内部类能访问外部成员
			System.out.println(content);//内部类当然可以访问本类成员
			System.out.println("1.age="+age);//内部类直接访问本类方法内传递的age
			System.out.println("2.age="+this.age);//内部类访问本类的私有age
			System.out.println("3.age="+Outer1.this.age);//内部类访问外部类的age
		}
	}
	
	public void talk(){
		System.out.println("我是"+name+",我今年"+age+"岁");
		Inner1 in =new Inner1();//如果外部类想访问内部类的成员则要用内部类实例化对象来调用
		in.age=33;//一旦内部类被实例化之后，其内部的成员全部可调用可见，即使是内部private私有成员。
		in.say(100);
	}
}

public class InnerClassDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer1 out=new Outer1();
		out.talk();
	}

}
