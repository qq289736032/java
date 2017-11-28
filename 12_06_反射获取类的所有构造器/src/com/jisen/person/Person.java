package com.jisen.person;
/*
 * 重载：在同一个类中，方法名相同，方法参数不同（个数、顺序、类型），不能仅仅依靠返回值不同
 * 重写
 */

import com.jisen.Anno.MyAnno;

class A{
	public void hehe(){}
	public void haha(){}
}
class MyException1 extends Exception{}
class MyException2 extends Exception{}
interface I1{}
interface I2{};
@MyAnno
public class Person extends A implements I1,I2,Cloneable{
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
	//构造器1
	@SuppressWarnings("unused")
	private Person(){}
	protected Person(int id){
		this.id=id;
	}
	//构造器2
	Person(String name){
		this.name=name;
	}
	//构造器3
	public Person(int id,String name,int age){
		this.id=id;
		this.name=name;
		this.age=age;
	}
	//toString
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	//其他方法
	public static void fun1(int m){
		System.out.println(m);
	}
	public void fun2(int m) {
		System.out.println(m);
	}
	private static void fun3(int m) {
		System.out.println(m);
	}
	private void fun4(int m) {
		System.out.println(m);
	}
	public void fun5() throws MyException1,MyException2{
		
	}
}
