package com.jisen.student;

import com.jisen.annotation.FieldAnnotation;
import com.jisen.annotation.TableNameAnnotation;
import com.jisen.myenum.FieldType;

@TableNameAnnotation(tableName="teacher")
public class Teacher {
	@FieldAnnotation(fieldName="tname",fieldtype=FieldType.varchar)
	private String name;
	@FieldAnnotation(fieldName="tage",fieldtype=FieldType.number)
	private int age;
	@FieldAnnotation(fieldName="tsalary",fieldtype=FieldType.number)
	private int salary;
	public Teacher(){}
	public Teacher(String name,int age,int salary){
		this.name=name;
		this.age=age;
		this.salary=salary;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "姓名："+name+"，年龄："+age;
	}
}
