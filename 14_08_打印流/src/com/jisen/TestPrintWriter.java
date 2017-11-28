/**
 * 打印流说白了就是一种输入方式，将一切类型的数据打印进相关流里面，打印到文件，打印到内存。
 * 以往在验证相关流的特性时是字节提供一个现成的数据，然后调用write写进流里，
 */
package com.jisen;

import java.io.*;

public class TestPrintWriter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean b=true;
		PrintWriter pw=null;
		try {
			pw=new PrintWriter("c:\\TestPrintWriter.txt");
			pw=new PrintWriter("TestPrintWriter.txt");
			pw=new PrintWriter(new FileOutputStream("c:\\TestPrintWriter.txt"),b);//文件字节输入流
			pw=new PrintWriter(new FileWriter("c:\\TestPrintWriter.txt"),b);//文件字符输入流
			pw=new PrintWriter(new ByteArrayOutputStream(),b);//内存字节输入流，
			pw=new PrintWriter(new CharArrayWriter(),b);//内存字字符输入流
			//总之这种打印流实在太多了，根据需要，
			
			pw.print("hellow");//打印字符串到相应流
			pw.print(1000);//打印各种类型的数据到相应流，
			
			//说白了就是能够将所有类型的东西打印到相关流里
			//但是相关流本身就可以有很多种方式获取数据write到流里面
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
