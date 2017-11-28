package com.jisen;

import java.lang.annotation.Annotation;

import com.jisen.en.MyEnum;


@MyAnno2(id=1001,school="清华大学",annos={@MyAnno1(age=22,name="zs"),@MyAnno1(age=23,name="ls")})//使用自定义注解，注解里面含3个参数
@MyAnno(value = "王大锤", age = 23,e=MyEnum.AAA)
class MyClass{
	
}
public class CustomAnno {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Class<?> c=MyClass.class;//准确获取某个类上面的信息
		Annotation[] ans=c.getAnnotations();//在该类信息上提取注解类
		for(Annotation an:ans){//遍历这个类中的注解类
			System.out.println(an.annotationType().getName());
		}
		
		MyAnno2 ma=c.getAnnotation(MyAnno2.class);//实例化一个具体注释，然后用对象去调用成员，获取MyAnno2中的注释
		System.out.println(ma.id()+"\t"+ma.school());
	}

}
