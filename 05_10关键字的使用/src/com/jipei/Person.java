package com.jipei;

/*
 * 1、表示当前调用者对象本身
 * 2、可以利用this去调用本类的属性和方法
 * 3、可以利用this去调用其他形式的构造方法，需要注意的是，该语句必须放在构造方法的第一行，还要避免递归调用和循环调用。
 */

public class Person {
	private  int no;
	//private static int no;
	private String name;
	private int age;
	//private char sex;
	
	public Person(){
		//this(1000,"zhangsan",22);//表示调用有参构造器，而有参构造器又调用无参构造器形成循环，这说明this在调用构造方法时要避免循环调用。
		//this();//要避免递归调用，放在这里便是无参构造器调用自己
		System.out.println("无参构造器被调用");
	}
	public Person(int no,String name,int age){
		this();//表示调用无参构造器，这说明可以利用this去调用其他形式的构造方法，需要注意的是，该语句必须放在构造方法的第一行,且一定要是构造方法
		this.no=no;
		this.name=name;
		this.age=age;
		System.out.println("三个参数构造器被调用");
	}
	
	public void setNo(int no){
		this.no=no;//如果不加this则左右两边的no都为局部变量，加了this之后，左边的no引用的就是成员变量，说明this只能引用成员变量，并且不能是静态变量
		//Person.no=no;//如果成员变量是static则用类名引用。
	}
	public void setName(String name){
		this.name=name;
	}
	public void setAge(int age){
		this.age=age;
	}
	
	public int getNo(){
		return this.no;
	}
	public String getName(){
		return this.name;
	}
	public int getAge(){
		return this.age;
	}
//	public void talk(){
//		System.out.println("学号："+this.no+"，姓名："+this.name+",年龄："+this.age);
//	}
	@Override
	public String toString(){
		return "学号："+this.no+"，姓名："+this.name+",年龄："+this.age;
	}
	
	private void talk(){
		System.out.println("又加班，不高兴");
	}
	public void say(int rate){
		if(rate>80)
			this.talk();
		else
			System.out.println("我以加班为荣~~");
	}
	
	public boolean equals(Object obj){
		if(obj==null) return false;
		if(this==obj) return true;//this保存的是一个地址值，比较用的是不是同一个堆区,当前调用对象
		if(this.getClass()!=obj.getClass()) return false;
		if(obj instanceof Person){
			Person p=(Person)obj;
			return this.no==p.no;//
		}
		return false;
		
	}
}
