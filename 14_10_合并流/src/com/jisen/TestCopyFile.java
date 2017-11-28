/**
 * 合并流将多个输入流并到一块，对外展现为一个，用于将很多数据来源变成一个进行操作，比如实现一个文件拷贝
 *
 */
package com.jisen;

import java.io.*;

public class TestCopyFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//文件从什么地方考到哪个地方呢？
		if(args.length<2){//输入参数的使用提示，当参数长度小于2时，即输如的字符串小于两个时，系统推出重新执行
			System.out.println("USAGE:java 主类源文件	目标地址");
			System.exit(0);
		}
		
		String srcDir=args[0];//源文件地址
		String dstDir=args[1];//目标地址
		
		File f1=new File(srcDir);//建立源文件连接
		if(!f1.exists()){//如果这个文件不存在
			System.out.println("源文件不存在，拷贝失败。。。");
			System.exit(-1);
		}
		
		File f2=new File(dstDir);//建立目标地址文件连接
		if(!f2.exists()||!f2.isDirectory()){//如果目标文件不存在或者不是个目录
			System.out.println("目的地址有误，拷贝失败。。");
			System.exit(-1);
		}
		
		String filename=f1.getName();//获取源文件的的名称，
		System.out.println(filename);//输出该名称源文件名称
		String[] fns=f2.list();//将目标路径的次目录内容名称放到数组
		for(String fn:fns){//这一步在检查目标文件夹下的文件是否与源文件重名
			if(filename.equals(fn)){//如果次目录有文件名称与源文件重名，那就给它重新分配一个文件，这一步可以加个copy
				int index=filename.indexOf(".");//获取文件名中点的位置
				String prefix=filename.substring(0,index);//截取文件名称点前缀
				prefix +="(copy)";//在前缀名称后面加随机数字，避免与现有文件重名
				String suffix=filename.substring(index+1);//获取后缀名称
				filename=dstDir+prefix+"."+suffix;//合成一个新的路径文件目录
						
			}
		}
		
		FileInputStream fis=null;//
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream(f1);//建立一个输出流，从源文件中读取出内容
			fos=new FileOutputStream(filename);
			byte[] b=new byte[1024];//建立一个临时存放小段内容的byte数组，
			int len=-1;
			while((len=fis.read(b))!=-1){//read(byte[] b)返回读入缓冲区的字节总数，如果因为已经到达文件末尾而没有更多的数据，则返回 -1。
				fos.write(b, 0, len);
			}
			System.out.println(filename+"拷贝成功");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fis!=null){
				try {
					fis.close();
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
