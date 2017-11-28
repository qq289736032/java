package com.jisen;

import java.lang.annotation.*;

import com.jisen.en.MyEnum;

@Target(ElementType.TYPE)//原注解，标明使用场合
@Retention(RetentionPolicy.RUNTIME)//原注解，标明使用周期
public @interface MyAnno{//自定义一个注解，注解里面含成员属性和方法
	int age();
	String value();
	MyEnum e();//在自定义注解可以加入其它方法，比如这个枚举
}
