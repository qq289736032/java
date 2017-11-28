package com.jisen;

/*
 * 
 */
interface I{
	public static final int a=10;
	public abstract void fun();
	
}
class IC1 implements I{
	
	public void fun(){
		
	}
}
interface IA{
	int b=5;
	int a=0;
	public void print();
}
interface IB{
	int a=20;
	public void disp();
}
interface IC2 extends IA,IB{
	int a=30;
	public void show();
}
class MyC implements IC2{
	int a;
	
	public void print() {
		System.out.println(IA.a);
		
	}

	public void disp() {
		System.out.println(IB.a);
		
	}

	public void show() {
		System.out.println(IB.a);
		
	}


}
public class 接口 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyC mc=new MyC();
		mc.print();
		mc.disp();
		mc.show();
	}

}
