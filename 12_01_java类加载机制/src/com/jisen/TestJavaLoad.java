/**
 * 编辑：编写.java源文件
 * 编译：javac Hello.java---->hello.class在eclipse中编辑完保存即可编译，是一种中间的字节码文件，不能直接运行。
 * 运行（加载主类）：java hello，加载该主类的过程中首先会加载系统的一些类文件。然后加载你的主类，首先会执行该类的静态代码块。然后利用主类名，进入main，即程序的入口。
 * main是一个主线程，同时会启动GC线程。然后取main的每条指令逐条执行，遇到其他类时，才会加载其他类
 * 
 * JVM抽象出来的虚拟机器，3大功能，
 * 1，jre，ClassLoader 字节码校验器 代码生成器
 * 2，GC，
 * 3，中立体系结构
 */

package com.jisen;

class A{
	static{
		System.out.println("A被加载");
	}
	public A(){
		System.out.println("A的构造器被调用");
	}
}

public class TestJavaLoad {

	/**
	 * 类并非一次性加载完成，
	 */
	
	static{
		System.out.println("主类被加载");
	}
	public static void main(String[] args) {
		System.out.println("主方法被执行");
		A a=new A();
		
		
	}

}
