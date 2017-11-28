package com.jisen;

public class 代码块执行顺序 {

	/**
	 * @param args
	 */
	
	//2、构造代码块：在类里面，方法外边，以{开头，以}结尾，中奖多条语句，当实例化对象的时候调用该代码块，优先于构造器
	{
//		int kk=100;
//		System.out.println(kk);
		System.out.println("2、构造代码块被调用");
	}
	
	public 代码块执行顺序(){
		System.out.println("4、无参构造方法被调用");
	}
	
	public void Stru(){
		System.out.println("普通方法被调用");
	}
	
	//3、静态代码块：，在类里面，方法外面，以static{开头，以}结尾，中间，多条语句，当类被加载的时候调用，该代码块即被调用
		static{
			System.out.println("5、静态代码块被调用");
		}
	
	public static void main(String[] args) {
		System.out.println("3、main得到执行");
		
		
		int m=10;
		//1、普通代码块：在方法里面，以{开头以}结尾，中间多条语句，出了代码块的作用域就不可见
		{
//			int n=20;
//			System.out.println(m);
//			System.out.println(n);
			System.out.println("1、普通代码块被调用");
		}
		代码块执行顺序 s=new 代码块执行顺序();
		new 代码块执行顺序();//静态代码块被调用一次
//		System.out.println(m);
		//System.out.println(n);//语句块里面的n在这里不可见
	}

}
