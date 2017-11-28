package com.jisen;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	//PrintStream IO流
		System.out.println();
		
		//在jdk1.5之前，输入利用BufferedRead
		//从jdk开始，输入利用Scanner
		//在jdk1.6产生了一个输入，Console(密码处理)
		Console con =System.console();//返回与当前 Java 虚拟机关联的唯一 Console 对象（如果有）
		System.out.println(con);//输出该对象的hashCode值得16进制。System.out.println(con.toString);
		/*
		 * 百元买鸡
		 */
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
		System.out.println(sdf.format(new Date(System.currentTimeMillis())));
		long a=System.currentTimeMillis();
		long a1=System.nanoTime();
		System.out.println(System.currentTimeMillis());//返回以毫秒为单位的当前时间。获取当前毫秒形式系统时间
		long b1=System.nanoTime();
		System.out.println(b1-a1+"纳秒");
		for(int i=0;i<=1000;i++){
			for(int j=0;j<=1000;j++){
				for(int k=0;k<=1000;k++){
					if(i+j+k==100&&5*i+3*j+k/3.0==100)
						System.out.println(i+"\t"+j+"\t"+k);
				}
			}
		}
		System.out.println(System.currentTimeMillis());//返回以毫秒为单位的当前时间。获取当前毫秒形式系统时间
		long b=System.currentTimeMillis();
		System.out.println(b-a+"毫秒");
	}

}
