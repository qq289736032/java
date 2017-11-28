package com.jisen;

class Super{
	static{
		System.out.println("1、父类静态代码块");				//3.1
	}
	{
		System.out.println("2、父类构造代码块");				//3.3	//4.1	//5.1	//6.1
	}
	public Super(){
		System.out.println("3、父类无参构造器代码块");			//3.4	//4.2	//5.2	//6.2
	}
}

class Sub extends Super{
	static{
		System.out.println("4、子类静态代码块");				//3.2
	}
	{
		System.out.println("5、子类构造代码块");				//3.5	//4.3
	}
	public Sub(){
		System.out.println("6、子类无参构造器代码块");			//3.6	//4.4
	}
}
public class 代码块执行顺序子父类 {

	static{
		System.out.println("7、主类静态代码块");				//1
	}
	{
		System.out.println("8、主类的构造代码块");			//8.1
	}
	public 代码块执行顺序子父类(){
		System.out.println("9、主类的无参构造器代码块");		//8.2
	}
	
	public static void main(String[] args) {
		System.out.println("10、main方法");				//2
		Sub s=new Sub();								//3
		Super s2=new Sub();								//4
		Super su=new Super();							//5
		Super su2=new Super();							//6
		{
			System.out.println("11.普通代码块");			//7
		}
		代码块执行顺序子父类 d=new 代码块执行顺序子父类();			//8
	}

}
