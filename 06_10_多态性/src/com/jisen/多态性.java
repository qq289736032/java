package com.jisen;

class Animal{
	public void say(){
		
	}
}
class Cat extends Animal{
	public void say(){
		System.out.println("喵喵喵");
	}
	public void catchMouse(){
		System.out.println("猫捉老鼠");
	}
}
class Dog extends Animal{
	public void say(){
		System.out.println("汪汪汪");
	}
	public void filltail(){
		System.out.println("狗摇尾巴");
	}
}
public class 多态性 {

	/**
	 * 要搞清楚运行时和编译时多态，
	 * 1、如果new一个Animal即Animal an=new Animal();则Cat cat=an；是会报错的，
	 * an是Animal的大范围内容小于小于cat所以要加类型转换Cat cat=（Cat）an，这叫向上转换
	 */
	public static void playPet(Animal an){//参数一定要是Animal类Animal空间，如果是某个具体的子类空间那只能玩猫或者玩狗
		if(an instanceof Cat){
			Cat cat=(Cat) an;
			cat.catchMouse();
		}
		if(an instanceof Dog){
			Dog dog=(Dog) an;
			dog.filltail();
		}
		an.say();
	}
	public static void main(String[] args) {
//		//Animal an=new Animal();//编译的时候an是Animal，运行时也是Animal
//		Animal an=new Cat();
////		if(an instanceof Cat){
////			Cat c=(Cat) an;//classCastExeption
////			c.say();
////		}
////		Cat c=new Cat();
//		an.say();	//an可以看得到Cat中say的内容，但是看不到catchMouse中的内容
//		((Cat) an).catchMouse();
//		an=new Dog();
//		an.say();
		playPet(new Cat());
		playPet(new Dog());
	}

}
