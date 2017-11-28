package com.jisen.student;

public class Student implements Comparable<Student>{
	//数据域
	
	private int id;
	private String name;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "我的id是" + id + "，我叫" + name + "，我今年" + age + "岁\n";
	}
	
	@Override//重写equals
	public boolean equals(Object obj) {
		if(obj==null) return false;//1、判断传递进去的是不是，空
		if(this==obj) return true;//2、如果是同一个对象，那就true
		if(this.getClass() !=obj.getClass()) return false;//3、判断运行时环境如果不相同则为false
		if(obj instanceof Student){//把上面那些都排除之后，再判断是不是Student这个类型的实例，如果是，则改写
			Student stu=(Student)obj;//如果是Student的实例那么就将转换为Student实例
			return this.id==stu.id;//判断返回
		}
		return false;
	}
	
	//重写hashcode
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	public int compareTo(Student o) {
		return this.id-o.id;//这是升序
//		return o.id-this.id;//这是逆序
	}
	
}
