package com.jisen.student;

import com.jisen.annotation.*;

import com.jisen.myenum.*;

@TableNameAnnotation(tableName="student")
public class Student {
	@FieldAnnotation(fieldName="sname",fieldtype=FieldType.varchar)
	private String name;
	@FieldAnnotation(fieldName="sname",fieldtype=FieldType.number)
	private int age;
	public Student(){}
	public Student(String name,int age){
		this.name=name;
		this.age=age;
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
		return "姓名："+name+"，年龄："+age;
	}
}
