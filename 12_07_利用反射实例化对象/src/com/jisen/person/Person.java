package com.jisen.person;
/*
 * 重载：在同一个类中，方法名相同，方法参数不同（个数、顺序、类型），不能仅仅依靠返回值不同
 * 重写
 */

import com.jisen.Anno.MyAnno;

class A{}
interface I1{}
interface I2{};
@MyAnno
public class Person extends A implements I1,I2,Cloneable{
	private int id;
	private String name;
	private int age;
	private Person(){}
	protected Person(int id){
		this.id=id;
	}
	Person(String name){
		this.id=id;
		this.name=name;
	}
	public Person(int id,String name){
		this.id=id;
		this.name=name;
//		this.age=age;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
