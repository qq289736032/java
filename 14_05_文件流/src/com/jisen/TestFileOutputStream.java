package com.jisen;


import java.io.*;


/**
 * 1、FileOutputStream是抽象类OutputStream的一个子类实现类，
 * 2、构造方法
 * FileOutputStream(File file) 参数是一个要写入的文件路径或者直接一个文件名称，如果没有改文件就抓取异常，建立该文件，
 * FileOutputStream(File file, boolean append) 参数1：创建或者要打开的路径文件。参数2：如果为 true，则将字节写入文件末尾处，而不是写入文件开始处
 * FileOutputStream(String name, boolean append) 参数1：创建或者要打开的文件
 * 
 * 对比字节流字符流的写入，字节流是以字节数组byte[]的方式一次性写入的，而字符流则可以直接写入字符串。写入的write(hello.getBytes())和write("hello")的区别
 */

public class TestFileOutputStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileOutputStream fos=null;
		try {
			//1、打开文件
//			fos =new FileOutputStream("c:\\b.txt",true);//参数2：如果为 true，则将字节写入文件末尾处，每写一次会保留前面的数据，
			fos =new FileOutputStream("c:\\b.txt");//每写一次，从文件开头写，原有的数据将会丢失，
//			fos =new FileOutputStream("b.txt",true);//直接在该工程下面创建该文件
			//2、写入数据
//			fos.write("我要放假".getBytes());//每写一次会把原来的文件删除掉再把新内容写入新文件中，
//			fos.write("hellow".getBytes(), 2, 2);//最终存储到文件的是ll，表示偏移量2，长度为2
			fos.write(1000);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fos!=null){
				try {
					//3、关闭文件
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
