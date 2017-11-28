package com.jisen;

public class main方法详解 {

	/**
	 * 当我们点击运行按钮，实际上做了Java com.jisen.mian方法的详解  带包的运行方式 ClassLoader把该类加载到JVM 
	 * 加载之后就直接调用     main方法详解.main(参数)
	 * 实际上还可以采用如下形式加载类：Java com.jisen.main方法详解 aaa bbb---->classloader
	 * 将命令行传递的参数组合形成一个String[] a=new String[]{"aaa","bbb"};
	 * 接下来利用  main方法详解.mian(a);  将命令行的内容传递进主函数里
	 * JVM：Java Virtual Machine，Java虚拟机
	 * 1、提供jre Java Runtime Environment（classLoad，JIT 代码生成器）
	 * main表达的含义：
	 * 1、整个程序的入口
	 * 2、public：说明出了类，出了包，别人包里的其他类也可以调用main方法
	 * 3、static：说明主类加载之后，不需要实例化，直接利用类名.main的形式调用main方法，不需要产生对象
	 * 4、void:说明该方法不需要返回值
	 * 5、main：关键字，关键标记，整个程序的入口标记
	 * 6、String[] args:就是系统调用main方法的时候传递的参数，每个参数都是String类型的，参数的个数为args.length
	 * 	参数值为args[i],那么系统传递的参数值到底是什么呢？实际上就是通过命令行传递的值
	 */
	public static void main(String[] args) {
		/*
		 * 下列小程序表明可以不用Scanner扫描输入参数，而用命令行输入参数即可运行
		 */
		if(args.length<1){
			System.out.println("Usage:exe Num");
			System.exit(0);
		}
		int num=Integer.parseInt(args[0]);
		if(num%2==0)
			System.out.println(num+"是偶数");
		else
			System.out.println(num+"是奇数");
	}

}
