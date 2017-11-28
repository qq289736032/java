package com.jisen;

//class MyClass{
//	private int a;
//	public MyClass(){}
//	public MyClass(int a){
//		this.a=a;
//	}
//	public void setA(int a){
//		this.a=a;
//	}
//	public int getA(){
//		return a;
//	}
//}

class MyClass<Type>{
	private Type a;
	public MyClass(){}
	public MyClass(Type a){
		this.a=a;
	}
	public void setA(Type a){
		this.a=a;
	}
	public Type getA(){
		return a;
	}
}

class A{
	private int a;
}

//泛型类实例化之后成为具体类，具体类实例化称为对象，泛型是比类更高层次的的对象
public class GenericArray {

	public static void main(String[] args) {
		//基本数据类型
		int a0=0,a1=1,a2=2,a3=3;
		int a[]={a0,a1,a2,a3};
		
		//类类型的数组如下
		A a_0=new A();
		A a_1=new A();
		A[] ac={a_0,a_1};
		//泛型的数组如下
//		MyClass<Integer> mci0=new MyClass<Integer>(0);
//		MyClass<Integer> mci1=new MyClass<Integer>(1);
//		MyClass<Integer> mci2=new MyClass<Integer>(2);
//		MyClass<Integer> mci3=new MyClass<Integer>(3);
//		MyClass<Integer>[] mci={new MyClass<Integer>(0),new MyClass<Integer>(1),new MyClass<Integer>(2),new MyClass<Integer>(3)};
//		MyClass<Integer>[] mcii={mci0,mci1,mci2,mci3};//Cannot create a generic array of MyClass<Integer>
		
		//1、
		MyClass<Integer>[] mci=new MyClass[4];//如果要建立泛型类数组，需要注意new关键字后面不要加入泛型实际类型名。
		mci[0]=new MyClass<Integer>(0);
		mci[1]=new MyClass<Integer>(1);
		mci[2]=new MyClass<Integer>(2);
		mci[3]=new MyClass<Integer>(3);
		//2、
		MyClass[] mcii={new MyClass<Integer>(0),new MyClass<Integer>(1)};
		//3、
		MyClass<Integer>[] mciii=new MyClass[]{new MyClass<Integer>(0),new MyClass<Integer>(1)};
		
		MyClass<Integer> mc=new MyClass<Integer>(10);
		System.out.println(mc.getA());
	}

}
