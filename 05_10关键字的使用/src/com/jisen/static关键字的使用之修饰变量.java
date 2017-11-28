package com.jisen;

class Student{
	String name;
	int age;
	static String contry;//如果成员用静态static修饰则下面的引用需要用类来引用
	public String getName() {
		return name;
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getContry() {
		return contry;
	}
	public void setContry(String contry) {
		Student.contry = contry;
	}
	
	public Student(){}
	public Student(String name, int age, String contry) {
		this.name = name;
		this.age = age;
		Student.contry = contry;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", contry=" + contry
				+ "]";
	}
	
}

public class static关键字的使用之修饰变量 {

	/**
	 * 
	 */
	/***********************************************************************
	static int m=10;//类的成员变量要用static修饰，为什么呢，因为main主方法要引用而且main是static修饰的，
					//为什么main函数一定要static修饰呢,因为如果没有static修饰，编译器不会锁定当前main函数。
	public static void main(String[] args) {
		
		System.out.println("1、"+m);
	}
	public  void hehe(){
		System.out.println("2、"+m);//把变量放到main外面这样，其他方法也可以引用，但是放到外面就变成了类的成员变量。
	}
	 **************************************************************************/
	public static void main(String[] args) {
		Student stu1=new Student("zs",23,"America");
		Student stu2=new Student("ls",23,"America");
		Student stu3=new Student("ww",23,"America");
		
		System.out.println(stu1);
		System.out.println(stu2);
		System.out.println(stu3);
		/*
		 * 如果不在成员变量contry加static修饰要修改国籍则要在每一个对象上修改，
		 */
//		stu1.setContry("china");
//		stu2.setContry("china");
//		stu3.setContry("china");
		/*
		 * 如果把国籍前面加static修饰，把它放到静态区
		 */
//		Student.contry="china";//静态成员用类来引用
		
		System.out.println(stu1);
		System.out.println(stu2);
		System.out.println(stu3);
		
	}
}
