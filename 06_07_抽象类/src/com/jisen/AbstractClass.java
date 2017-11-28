package com.jisen;

abstract class Animal{		//抽象类，不能实例化，用于派生子类，并限定模板，子类必须遵循的原则
	String name;
	
	int age;
	public abstract  void say();//格式，模板，每一个子类都要有这个say，
//	public abstract  void eat();
}
class Cat extends Animal{
	public void say(){
		System.out.println("喵喵");
	}
}
class miCat extends Cat{
	public void say(){
		System.out.println("咪咪");
	}
}
class miaoCat extends miCat{
	public void say(){
		System.out.println("喵");
	}
}
class Dog extends Animal{
	public void say(){
		System.out.println("旺旺");
	}
}
public class AbstractClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Animal an=new Animal();//抽象类不能实例化
		//an.say();
		Animal an=new Cat();//多态
		
		an.say();
		//Cat cat=new Cat();
		an=new Dog();
		an.say();
		an=new miCat();
		an.say();
	}

}


