/**
 * 问题1、输入输出重定向，从屏幕上扫描改为从文件中扫描，关于Scanner的扫描方法？
 * 问题2、setIn(InputStream in)重新分配输入流,	OutsetOut(PrintStream out) 重新分配“标准”输出流,标准是从控制台输入输出
 * 
 * 
 */
package com.jisen;

import java.io.*;
import java.util.*;

public class TestRelocation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		try {
//			System.setOut(new PrintStream("c:\\e.txt"));//输出重定向
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("hello world");
		try {
			System.setIn(new FileInputStream("c:\\e.txt"));//输入重定向从文件中输入数据，然后再打印到屏幕
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Scanner in=new Scanner(System.in);
		String contents=in.nextLine();//只读一行吗
		System.out.println(contents);
		
	}

}
