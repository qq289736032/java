package com.jisen;

//import com.jisen.Outer1.Inner1;

class Outer2{
	private static String name="haha";
	private static int age =23;
	
	static class Inner1{	//加上了静态之后，该内部类存储在静态区，相当于外部类了，
		private String content="keke";
		private int age =22;
		public void say(int age){
			System.out.println(name);//内部类能访问外部成员
			System.out.println(content);//内部类当然可以访问本类成员
			System.out.println("1.age="+age);//内部类直接访问本类方法内传递的age
			System.out.println("2.age="+this.age);//内部类访问本类的私有age
			//System.out.println("3.age="+Outer2.this.age);//内部类访问外部类的age
			System.out.println("3.age="+Outer2.age);//内部类加上静态修饰之后访问外部类的数据时用外部类来调用，并且外部age也要是静态的
		}
	}
	
	public void talk(){
		System.out.println("我是"+name+",我今年"+age+"岁");
		Inner1 in =new Inner1();//如果外部类想访问内部类的成员则要用内部类实例化对象来调用
		in.age=33;//一旦内部类被实例化之后，其内部的成员全部可调用可见，即使是内部private私有成员。
		in.say(100);
	}
	public Inner1 getInner(){//既然类外部不能直接产生内部类的对象，那就在类写一个得到内部类对象的方法
		return new Inner1();//那么外面直接调用该方法即可实例化一个内部类对象
	}
}

public class InnerClassDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer2 out=new Outer2();
		out.talk();
		//Outer2.Inner1 in=out.new Inner1();//类的外面如果要调用类的内部类，
		//Outer2.Inner1 in1=out.getInner();//类的外面如果要调用类的内部类，
		Outer2.Inner1 in =new Outer2.Inner1();//内部类变成 静态之后它就放在静态区了，直接用外部类调用该类
		in.say(234);//访问内部类
		
	}

}
