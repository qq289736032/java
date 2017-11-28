/**
 * 基于字符的文件流
 * FileWriter(File file)根据给定的 File 对象构造一个 FileWriter 对象。 
 * FileWriter(File file, boolean append)根据给定的 File 对象构造一个 FileWriter 对象。如果第二个参数为 true，则将字节写入文件末尾处，而不是写入文件开始处。
 * 
 * 如果参数1文件存在，但它是一个目录，而不是一个常规文件；或者该文件不存在，但无法创建它；抑或因为其他某些原因而无法打开它
 * 
 * 对比字节流字符流的写入，字节流是以字节数组byte[]的方式一次性写入的，而字符流则可以直接写入字符串。写入的write(hello.getBytes())和write("hello")的区别
 * 
 * 
 */

package com.jisen;

import java.io.*;

public class TestFileWriter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileWriter fw=null;
		try {
			//1、打开文件
			fw=new FileWriter("c:\\这个文件不存在.txt");//写在缓存区，要通过刷新或者来写入文件，加true则在末尾续写
			//2写入文件
			//2.1写入一组字符串
//			fw.write("helloworld");//可以直接写入一串字符对比write(hello.getBytes())
			//fw.flush();//这一步可以有保存能功能，刷新该流的缓冲，字节流字符流的区别。
			//2.2写入带有偏移量的字符串
//			fw.write("helloworld",2,5);//文件写入的是llowo表明，从第二个字符开始写，长度为5
			//2.3写一个字符串数组
			char[] c="hello".toCharArray();//将它变为一个新的字符数组，有别于"hello".getBytes(),字节序列和字符数组的区别
			fw.write(c, 2, 3);
			System.out.println("返回此流使用的字符编码的名称:"+fw.getEncoding());
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				//关闭文件
				fw.close();//关闭这个动作不能丢，可以将缓存取得数据保存到文件上
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

/**
 * 遗留问题:1、String类里面的char[] c="hello".toCharArray();和byte[] b="hello".getBytes()，区别是返回数组类型不同，char[] c={'h','e','l','l','o'}
 * 那么byte[] b={104，101，108，108，111}这就是8位二进制的ASCII码
 * 
 * 
 */
