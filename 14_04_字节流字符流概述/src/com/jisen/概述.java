package com.jisen;
public class 概述 {}
/**
 * IO流：有方向的数据集，即：数据从一个地方流向另外一个地方
 * 字节流：在通道中最小的数据单位是byte
 * 字符流：在通道中最小的数据单位是char
 * 
 * 输入流：我们可以从该流中读取数据
 * 输出流：我们可以写入数据到该流中
 * 
 * 字节输入流：InputStream
 * 字节输出流：OutputStream
 * 
 * 字符输入流：Read
 * 字符输出流：Write
 * 管道流：实现
 * 
分类		字节输入流					字节输出流					字符输入流				字符输出流
抽象基类	InputStream				OutputStream			Reader				Writer
访问文件	FileInputStream			FileOutputStream		FileReader			FileWriter
访问数组	ByteArrayInputStream	ByteArrayOutputStream	CharArrayReader		CharArrayWriter
访问管道	PipedInputStream		PipedOutputStream		PipedReader			PipedWriter
访问字符串													StringReader		StringWriter
缓冲流	BufferedInputStream		BufferedOutputStream	BufferedReader		BufferedWriter
转换流													InputStreamReader	OutputStreamWriter
对象流	ObjectInputStream		ObjectOutputStream		
抽象基类	FilterInputStream		FilterOutputStream		FilterReader		FilterWriter
打印流							PrintStream									PrintWriter
推回输入流	PushbackInputStream								PushbackReader	
特殊流	DataInputStream			DataOutputStream		

 * 
 * 底层操作都是字节流，字符流就是字节流的封装，字节流写入的话直接写到真实设备，字符流则写到缓存里面，要刷新或者关闭一下一下才能写到真实磁盘里，flush加快文件存储速度。
 * 为什么要这样呢字节流存储是每存一个字母磁头要检索一次位置，而字符流是先将一整个字符串先放到缓存，做flush的时候一次性刷入进去？
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
