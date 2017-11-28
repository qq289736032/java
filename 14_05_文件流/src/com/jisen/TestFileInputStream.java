/**
 * 构造方法
 * FileInputStream(File file) 通过打开一个到实际文件的连接来创建一个 FileInputStream，该文件通过文件系统中的 File，对象 file 指定。
 * 创建一个新 FileDescriptor 对象来表示此文件连接。
 * FileInputStream(String name)	通过打开一个到实际文件的连接来创建一个 FileInputStream，该文件通过文件系统中的路径名 name 指定。
 * 创建一个新 FileDescriptor 对象来表示此文件连接。
 * 如果该文件不存在，或者它是一个目录，而不是一个常规文件，抑或因为其他某些原因而无法打开进行读取,那就抛出异常
 * 
 * read(byte[] b)读入缓冲区的字节总数，如果因为已经到达文件末尾而没有更多的数据，则返回 -1。
 */
package com.jisen;

import java.io.*;

public class TestFileInputStream {

	/**
	 * 1、1byte=8bit	能表示的整数是0-2^8即0-255，总共256种状态，在计算机只能表示保存则是-2^7-2^7-1即-128-127这256个数字状态
	 * 2、如果写入文件的是int1000那么从文件中读取的数据却是232，那么232是怎么来的呢，跟255,256,128,127有什么关系呢，
	 * 3、1000的二进制是1111101000，int是4个字节，写入到文件时以byte，1个字节的的方式写入文件，只截取了低八位，因此文件实际保存的是11101000，所以读取文件的时候也只读到这8位信息
	 * 4、fis.read()这个方法返回的是一个int类型，11101000的十进制表示是232，因此读回来的int值是232
	 * 5、由此可见，232依然超出byte（-128-127）所能表达的数据，如果将232强制类型转换为byte然后输出是-24，那么为什么又是-24呢
	 * 
	 */
	
	/******************************************************
	 	int的1000转换为byte是怎么转的呢？
		方法一：
		1000的二进制如下：1111101000
		而byte只能表示低8位，即11101000该数在计算机中是以补码的形式保存，而最高位是符号位，此时是1表示是负数，原码为：10011000，即-24
		方法二：
		利用八卦原理，byte一圈是256，则1000可以变成3圈之后(3圈为768)，再走232，那么离一圈还差24步，而且已经走到了负的半边，即-24
	 *******************************************************************/
	public static void main(String[] args) {
		
		FileInputStream fis=null;
		try {
			//1、打开文件
			fis=new FileInputStream("c:\\b.txt");//如果不指定路径名称，那么它默认是寻找工程下面的文件
			//2、读取文件
			//2.1读取字符数组b这么长的字节序列，
//			byte[] b=new byte[20];
//			int len=fis.read(b);//将读取到的字节数据放到byte中，并返回该次读取的字节长度
//			System.out.println(new String(b,0,len)+len);//新建一个字符串，将字符数组转化为字符串。
			//2.2读取含有偏移量的字符数组
			byte[] b=new byte[20];
			int len=fis.read(b);//将第一个字符偏移1位，偏移部分用空格表示，包括空格总的字节数为6
			for(byte i:b){
				System.out.println((char)i);//输出的是ASCII码，
			}
			System.out.println(new String(b,0,len));//新建一个字符串，将字符数组转化为字符串。
//			//2.2 读一个字节数据
//			byte b=(byte)fis.read();
//			System.out.println(b);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fis!=null){
				try {
					//3、关闭文件
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
