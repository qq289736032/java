package com.jisen;

class Person{
	private String name;
	private int age;
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
	public Person(){}
	public Person(String name, int age) {
		
		this.name = name;
		this.age = age;
	}
	public String getInfo(){
		return "锟揭叫ｏ拷"+name+",锟揭斤拷锟斤拷"+age+"锟斤拷";
	}
	@Override
	public String toString() {
		return "锟揭斤拷 [name=" + name + ", age=" + age + "]";
	}
	
}
class Student extends Person{
	private String school;

	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public Student(){} 
	public Student(String name,int age,String school) {
//		super.name=name;//this.name=name;//锟斤拷super锟斤拷锟斤拷锟矫革拷锟杰憋拷示name锟斤拷锟皆革拷锟斤拷
//		super.age=age;//this.age=age;
		super(name,age);
		this.school = school;
	}
	public String getInfo(){
		return super.getInfo()+"锟斤拷锟斤拷"+school+"锟斤拷学锟斤拷";
	}
}
public class 子类的实例化过程{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Student s=new Student();
//		s.name="锟斤拷锟斤拷";
//		s.age=22;
//		s.school="锟藉华锟斤拷学";
//		System.out.println("锟揭叫ｏ拷"+s.name+",锟揭斤拷锟斤拷"+s.age+"锟疥，锟斤拷锟斤拷"+s.school+"锟斤拷学锟斤拷");
		
		Student s=new Student("锟斤拷锟斤拷",23,"锟藉华锟斤拷学");
		System.out.println(s.getInfo());

	}

}
