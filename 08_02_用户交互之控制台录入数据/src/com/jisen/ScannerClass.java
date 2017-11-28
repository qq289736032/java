package com.jisen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerClass {

	/**
	 * Scanner类的应用
	 * 从键盘或者文件中获取数据
	 */
	public static void main(String[] args) {
		//从键盘中输入数据
		Scanner s=new Scanner(System.in);
		System.out.println("输入name");
		String name=s.next();
		System.out.println("输出"+name);
		String line=s.nextLine();//不能确定是是否有东西进去
		System.out.println("mid");
		System.out.print(line);//打印了空白行
		System.out.println("end");
		//从文件中读取数据
		Scanner in=null;
		try {
			in=new Scanner(new File("c:\\a.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String s1=in.next();
		System.out.println("从文件中读到的字符串是"+s1);
	}

}
