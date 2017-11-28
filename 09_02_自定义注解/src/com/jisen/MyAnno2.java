package com.jisen;

import java.lang.annotation.*;

@Target(ElementType.TYPE)//原注解，标明注解使用场合
@Retention(RetentionPolicy.RUNTIME)//原注解，标明注解使用周期
public @interface MyAnno2 {//自定义注解，注解里面含有成员属性和，其他注解类型的变量
	int id();
	String school();
	MyAnno1[] annos();
}
