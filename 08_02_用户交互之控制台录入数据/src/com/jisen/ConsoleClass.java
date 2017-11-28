package com.jisen;

import java.io.Console;
import java.util.Scanner;

public class ConsoleClass {

	/**
	 * 如果此虚拟机具有控制台，那么它将由此类唯一的实例（可通过调用 System.console() 方法获得）表示。如果没有可用的控制台设备，那么对该方法的调用将返回 null。
	 * readPassword()从控制台读取密码，禁用回显。
	 * java里为什么不能实现输一个密码弹出一个*号，因为Java里面为了提高效率都是整行输入，C语言里有getchar获取一个字符带回显的有一个不带回显的getch保存一个字符，输入一个字符时再打出一个*回显
	 */
	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		System.out.println("\n\n\t\t欢迎来到学生信息管理系统");
		System.out.print("\n\n\t\t\t用户名：");
		String username=in.next();
		System.out.print("\n\t\t\t密码：");
		String password=String.valueOf(System.console().readPassword());
		if(username.equals("root")&&password.equals("123456"))
			System.out.println("\n\t\t\t登陆成功");
		else
			System.out.println("\n\t\t\t密码有误登录失败！");
		Console co=System.console();
		//print--->%s字符串格式输出，%d整形格式输出，%c字符类型输出，%f浮点型输出，%x16进制，%o八进制。double也是%f													
		co.printf("我叫%s,我今年%d岁\n", "王大锤",25);//因为eclipse没有控制台所以返回null，指针异常
		
		char[] ps=co.readPassword();//从控制台中获取密码
		
		System.out.println(ps);//
		
								
	}

}
