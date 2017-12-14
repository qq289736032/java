package com.jisen;

class Student{
	String name;
	int age;
	void talk(){
		System.out.println("我叫�"+name+"，我今年"+age+"�");
	}
}

public class LeiNeiChun{

	/**
	 * @param args
	 */
	//static Student stu2;
	public static void main(String[] args) {
		Student stu1=new Student();
		stu1.name="钟吉�";
		stu1.age=25;
		stu1.talk();
		
		//Student stu2;//定义了一个对象，还没�?��空间,把该定义放到main的外面用static封装，不报错，但是运行出现空指针异常�?
		//Student stu2=null;//将该对象初始化为空，不报错，但是运行出现空指针异�?
		Student stu2=stu1;//把stu1的指针给stu2，运行，出现修改之后的talk内容�?
		stu2.talk();
		stu2.name="王大�";
		stu2.age=26;
		stu1.talk();
		stu2.talk();
	}

}
