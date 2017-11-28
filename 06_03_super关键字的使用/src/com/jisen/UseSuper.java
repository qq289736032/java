package com.jisen;

class Person{
	private String name;//父类把属性私有化，子类不能看见，要用getter和setter方法调用，或者super（）调用父类的构造器
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
	public String getInfo(){		//显示父类中信息的方法
		return "我叫："+name+",我今年"+age+"岁";
	}
}

class Student extends Person {// 父类被封装之后，子类能不能看的见呢
	private String school;

	public Student() {
		super();
	}
	//子类实例化时调用子类构造方法，子类构造方法引用父类参数时也在调用父类构造方法
	//子类对象在实例化时会默认先去调用父类中的无参构造放法，之后再调用本类中的相应构造方法
	public Student(String name,int age,String school) {
		super(name,age);
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	public String getInfo(){
		return super.getInfo()+"，我在"+school+"上学";
	}
}
public class UseSuper {

	/**
	 * super：超类
	 * 1、调用父类的属性和方法
	 * 2、调用父类指定参数的构造方法
	 * 好处是：当子类有跟父类相同的成员方法，即子类将父类的方法覆盖的时候如果想要访问父类的方法，则需要利用super来调用
	 * 如果父类没有无参构造方法，则子类需要在每个构造器中显示调用父类有参的构造方法，通过super完成
	 */
	public static void main(String[] args) {
		Student s=new Student("王大锤",23,"清华大学");
		//s.name="王大锤";
		//s.age=22;
		//s.school="清华大学";
		System.out.println(s.getInfo());
	}

}
