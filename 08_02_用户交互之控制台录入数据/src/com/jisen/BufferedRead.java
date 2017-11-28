package com.jisen;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;


public class BufferedRead {
	/**
	 * jdk1.5以前的从控制台输入数据的方式---->读取操作
	 */
	public static void main(String[] args) {
		//我们的目的是请求用户在键盘上输入数据
		//我们已经知道System.in是字节流（InputStream）
		//我们可能要做一件事情：把字节流转换为字符流；
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//读取键盘上输入的字符流，这个类的参数是一个子类对象Reader in
//		BufferedReader br=new BufferedReader(reader);传一个Reader的参数对象
//		Reader reader=new Reader();//那我就要产生一个reader对象；因为这个类是一个抽象类，不能被实例化，但是可以实例化它的子类
//		Reader reader= new InputStreamReader(is);//这里面的参数又是一个InputStream类因此又要new一个InputStream对象
//		InputStream is=new InputStream();//InputStream类又是一个抽象对象，又是不能new本身
//		InputStream is=System.in;
		String name=null;
		System.out.print("请输入你的名字");
		try {
			name =br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("我叫："+name);
	}

}
