package com.jisen;

class MyClass<T,K>{
	private T a;
	public MyClass(){}
	public MyClass(T a){
		this.a=a;
	}
	public void setA(T a){
		this.a=a;
		}
	public T getA(){
		return a;
	}
	public String toString(){
		return "a="+a;
	}
}


public class GenericClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyClass<Integer, Object> mc=new MyClass<Integer, Object>(1000);
		mc.setA(100);
		System.out.println(mc.toString());
		System.out.println(mc.getA());
//		MyClass<Object,Object> mo=mc;//不能赋值，虽然因为mo所达成的类虽然是Object但是泛型里面的内容根据不同的类会有所差异，和mc不是同一个类不能赋值
	}

}
