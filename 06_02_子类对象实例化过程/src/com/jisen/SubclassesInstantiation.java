package com.jisen;
/*
 * 1、子类的实例化过程，子类能调用父类一切公共的东西，但是构造器除外。
 * 2、父类变量接收子类对象时，该父类变量不能看到子类属性，
 * 3、父类变量接收父类对象时，该父类变量不能看到子类属性
 * 4、子类变量接收父类对象时时要强制类型转换，且可能会有运行时错误，因为编译不报错
 */

class Person{
	private String name;
	private int age;
	public Person(){}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
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
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

class Student extends Person {// 父类被封装之后，子类能不能看的见呢
	private String school;

	public Student() {
	}
	//子类实例化时调用子类构造方法，子类构造方法引用父类参数时也在调用父类构造方法
	//子类对象在实例化时会默认先去调用父类中的无参构造放法，之后再调用本类中的相应构造方法
//	public Student(String name,int age,String school) {//默认会调用父类的无参构造方法，因此要保证有父类有无参构造方法
////		super();//这里的super();正是隐藏的父类无参构造方法，如果super(参数)那么调用的是父类的有参构造方法
//		this.setName(name);
//		this.setAge(age);
//		this.school = school;
//	}
	public Student(String school) {
		super();
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	
	public void setSchool(String school) {
		this.school = school;
	}
	public String getInfo(){
		return "我叫"+getName()+",我"+getAge()+"岁"+"，我在"+school+"上学";
	}
}
public class SubclassesInstantiation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Student s=new Student("王大锤",23,"清华大学");
		Student s=new Student();
	
		s.getName();
		s.getAge();
		s.getSchool();
		s.setName("王二锤");
		s.setAge(23);
		s.setSchool("清华大学");
//		s.Person(23,"王大锤");//子类能调用父类一切公共的东西，但是构造器除外。
		//s.name="王大锤";
		//s.age=22;
		//s.school="清华大学";
		
		Person p1=new Student("清华大学");//用父类定义的变量接收子类对象,看不到子类的任何东西,//new的子类对象甚至只能用子类构造器，
		Person p2=new Person("王二锤",23);//用父类定义的变量，接收父类的对象，依然只能看到父类对象
		Student s1=(Student) new Person();//用子类定义的变量，用父类实例化对象那么要将父类对象强制类型转换为子类类型
		s1.setName("wangdachui");
		System.out.println(s1.getName());
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(s.getInfo());
	}

}
