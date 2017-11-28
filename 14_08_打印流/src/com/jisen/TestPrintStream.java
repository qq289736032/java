/**
 * 打印流输出重定向
 * 继承自过滤器,PrintStream(File file)1、如果存在该文件，则将其大小截取为零；否则，创建一个新文件。
 * PrintStream(OutputStream out, boolean autoFlush, String encoding)参数1、将向其打印值和对象的输出流；
 * 参数2如果为 true，则每当写入 byte 数组、调用其中一个 println 方法或写入换行符或字节 ('\n') 时都会刷新缓冲区
 * 参数3受支持的字符编码的名称 ，字符集。

 */
package com.jisen;

import java.io.*;

public class TestPrintStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		File file=new File("c:\\d.txt");//有时候可以不用建立文件连接，在构造方法里直接写入文件路径
		PrintStream ps=null;
		try {
			ps=new PrintStream("c:\\d.txt");
			ps.println("hello");
			ps.println(1000);
			ps.println(3.14);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ps!=null){
				ps.close();
			}
		}
		PrintStream ps2=new PrintStream(System.out);//打印到屏幕，System.out是跟系统屏幕相关联的。
		ps2.print("hehe");
	}

}
