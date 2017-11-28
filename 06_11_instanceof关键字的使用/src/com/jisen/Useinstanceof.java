package com.jisen;

class Animal{
	public void say(){
		
	}
}
class Cat extends Animal{
	public void say(){
		System.out.println("喵喵喵");
	}
}
class Dog extends Animal{
	public void say(){
		System.out.println("汪汪汪");
	}
}
public class Useinstanceof {

	/**
	 * 1、如果new一个Animal即Animal an=new Animal();则Cat cat=an；是会报错的，
	 * an是Animal的大范围内容小于小于cat所以要加类型转换Cat cat=（Cat）an，这叫向上转换
	 */
	public static void main(String[] args) {
		Animal an=new Animal();//编译的时候an是Animal，运行时也是Animal
		if(an instanceof Cat){
			Cat c=(Cat) an;//classCastExeption
			c.say();
		}
		Cat c=new Cat();
		c.say();
		an=new Dog();
		an.say();
	}

}
