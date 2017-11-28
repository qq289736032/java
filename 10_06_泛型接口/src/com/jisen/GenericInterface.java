package com.jisen;

interface I<T, K> { // 泛型接口
	// 常量
	public static final int NUM = 10;

	// 抽象方法
	public void fun1(T m);

	public K fun2();
}

//1、在子类的定义上也声明泛型类型
class IC1<T, K> implements I<T, K> {
	
	public void fun1(T m) {
		// 实现该方法
	}
	
	public K fun2() {
		//实现方法
		return null;
	}
}

class IC2<T,K,X> implements I<String,Integer> {
	@SuppressWarnings("unused")
	private X a;
	public void fun1(String s) {
		// 实现该方法
	}
	
	public Integer fun2() {
		//实现方法
		return null;
	}
}

//如果实现接口的子类不想使用泛型声明，则在实现接口的时候直接指定好其具体的操作类型即可。如果不指定，则此时泛型会自动变为Object
class IC3 implements I<String,Integer> {
	
	public void fun1(String s) {
		// 实现该方法
	}
	
	public Integer fun2() {
		//实现方法
		return null;
	}
}

class IC4<X> implements I<String,Integer> {
	@SuppressWarnings("unused")
	private X a;
	public void fun1(String s) {
		// 实现该方法
	}
	
	public Integer fun2() {
		//实现方法
		return null;
	}
}

class IC5<T,X> implements I<T,Integer> {
	@SuppressWarnings("unused")
	private X a;
	public void fun1(T s) {
		// 实现该方法
	}
	
	public Integer fun2() {
		//实现方法
		return null;
	}
}

public class GenericInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
