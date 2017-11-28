package com.jisen.person;

import com.jisen.Anno.MyAnno;

class A{}
interface I1{}
interface I2{};
@MyAnno
public class Person extends A implements I1,I2,Cloneable{
	private int age;
	private String name;
}
