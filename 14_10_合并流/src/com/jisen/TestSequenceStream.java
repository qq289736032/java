/**
 * 将a.txt和b.txt中的内容合并考到ab.txt中
 */
package com.jisen;

import java.io.*;

public class TestSequenceStream {

	/**
	 * 
	 */
	public static void main(String[] args) {
		FileInputStream fis1=null;//输入流1
		FileInputStream fis2=null;//输入流读取数据
		FileOutputStream fos=null;//输出流，
		try {
			fis1=new FileInputStream("c:\\a.txt");//和第一个要输出的文件建立连接
			fis2=new FileInputStream("c:\\b.txt");//和第二个要输出的文件建立连接
			fos=new FileOutputStream("c:\\合并.txt",true);//和第三个要写入的文件建立连接，如果没有该文件则创建新文件，
														//如果加了true则每运行一次该指令指针在末尾，否则会覆盖前内容		
			byte[] b=new byte[1024];//临时存放的byte数组
			int len=-1;
			while((len=fis1.read(b))!=-1){//将最多1024个字节放入到b中，返回放入到byte数组的总字节数，
				fos.write(b, 0, len);//写入数据到合并文件，文件指针会不断王后移
			}
			fis1.close();//关闭第一个文件
			while((len=fis2.read(b))!=-1){//读取第二个文件
				fos.write(b, 0, len);//不断的写入，注意这是文件指针会不断王后移
			}
			fis2.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fis1!=null){
				try {
					fis1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fis2!=null){
				try {
					fis2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
