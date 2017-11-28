package com.jisen;

import java.lang.annotation.*;

@Target(ElementType.FIELD)//原注解，标明使用场合
@Retention(RetentionPolicy.RUNTIME)//y原注解，标明使用周期
public @interface MyAnno1 {//自定义的注解，注解中含有成员属性
	int age();
	String name();
}
