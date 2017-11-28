
/**
 * local class incompatible: stream classdesc serialVersionUID = 1, local class serialVersionUID = 2
 * 更改了序列化的ID所报的异常
 */
package com.jisen.student;

import java.io.*;

public class Person implements Serializable{//序列化的ID：当反序列化的时候，反序列化的ID要跟这个是一样的。否则不能反序列化回来，
//	/**
//	 * 
//	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int age;
//	transient private int age;//加了transient表示该成员是否序列化，其结果不会被保存。
	
	public Person() {}
	public Person(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
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
	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", age=" + age;
	}
	
	
	
}
