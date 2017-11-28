package com.jisen;

class MyPerson{
	private String name;
	private int age;
	
	public MyPerson() {}
	public MyPerson(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "MyClass [name=" + name + ", age=" + age + "]";
	}
}

public class 对象数组 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		int a0=10;
		int a1=20;
		int a2=30;
		int[] a=new int[3];//int a[]=new int[]{10,20,30};//int[] a={10,20,30};
		a[0]=10;
		a[1]=20;
		a[2]=30;
		
		
		MyPerson p0=new MyPerson("zs",22); //左边表示在栈区开辟了一个空间，右边表示在堆区实例化了一个类，
		MyPerson p1=new MyPerson("ls",23); //可以用for循环new空间
		MyPerson p2=new MyPerson("ww",24); 
		
//		MyPerson p[]=new MyPerson[3];//
//		p[0]=p0;
//		p[1]=p1;
//		p[2]=p2;
//		System.out.println(p[0]);
		
		MyPerson p[]={new MyPerson("zs",22),new MyPerson("ls",23),new MyPerson("ww",24) };
		
	}

}
