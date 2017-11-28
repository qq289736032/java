package com.jisen;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

import com.jisen.annotation.*;
@SuppressWarnings("all")
@MyAnnotation1("Student")
@MyAnnotation2("Stu")
class Student{
	@MyAnnotation1("sid")
	private int id;
	@MyAnnotation1("sname")
	private String name;
	@MyAnnotation1("sage")
	private int age;
	
}
public class ReflectAnnotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Class<?> c=Student.class;
		//获取类的 
		Annotation[] ans=c.getAnnotations();//获得类的所有注解
		for(Annotation an:ans){//遍历注解
			Class<? extends Annotation> ca=an.annotationType();//得到注解的运行时类型
			System.out.println(ca.getName());
		}
		//获取指定注解的数据
		MyAnnotation1 mac=c.getAnnotation(MyAnnotation1.class);
		System.out.println(mac.value());
		
		//获取指定字段的注解，及注解数据
		try {
			Field f=c.getDeclaredField("name");//获取变量名字
			MyAnnotation1 macf=f.getAnnotation(MyAnnotation1.class);
			System.out.println(macf.value());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//先要获得字段，即成员属性
	}

}
