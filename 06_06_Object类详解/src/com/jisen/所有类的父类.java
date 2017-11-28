package com.jisen;

class Student implements Cloneable{
	private int id;
	private String name;
	private int age;
	public int getId() {
		return id;
	}
	public Student(){}
	public Student(int id, String name, int age) {
		//super();
		this.id = id;
		this.name = name;
		this.age = age;
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
	
	//toString
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	//hashcode
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.id+this.name.hashCode();
	}
	//equals
	@Override
	public boolean equals(Object obj){
		if(this==null)	return false;
		if(this==obj)	return true;
		//if(this.getClass()!=obj.getClass())	return false;
		if(obj instanceof Student){
			Student stu=(Student)obj;
			if(this.id==stu.id&&this.name.equals(stu.name))	return true;
		}
		return false;
	}
	public Student getInstance() throws CloneNotSupportedException{
		return (Student)this.clone();
	}//可以自己复写clone方法将其权限方大
}
 
public class 所有类的父类  extends Object {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student stu1=new Student(1001,"王大锤",23);
		Student stu2=new Student(1001,"王大锤",24);
		System.out.println(stu1==stu2);
		System.out.println(stu1.equals(stu2));
		System.out.println(stu1);
		
		String s="hello";
		System.out.println(s.getClass());
		Object obj=s;
		System.out.println(obj.getClass());//为什么这次输出不是Object，因为运行时类还是String
		
		Student stu3=new Student(1111,"hehe",22);
		Student stu4=stu3;//对象的浅拷贝
		stu4.setName("haha");
		System.out.println(stu3);
		
		Student stu5=null;
		try {
			stu5=stu3.getInstance();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stu5.setName("hihi");
		System.out.println(stu5);
		
	}

}
