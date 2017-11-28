package com.jisen;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class MyFilenameFilter implements FilenameFilter{
	
	private String suffix;
	public MyFilenameFilter(){}
	public MyFilenameFilter(String suffix){
		this.suffix=suffix;
	}
	public boolean accept(File dir, String name) {//文件夹，文件夹名称
		return name.endsWith(suffix);
	}
	
}

public class TestFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f=new File("c:\\TestFile");//对一个文件夹(目录)
//		File f=new File("c:\\TestFile.txt");//对一个文件
		System.out.println(f);//toString方法返回的就是路径
		if(!f.exists()){//如果这个抽象路径名表示的文件或目录是否存在。
			try {
				f.createNewFile();//当且仅当不存在具有此抽象路径名指定名称的文件或目录时，不可分地创建一个新的空文件。这是一个没有文件类型的文件
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("该文件可读吗"+f.canRead());//测试应用程序是否可以读取此抽象路径名表示的文件或文件夹。//属性可读
		
		
		//属性，如果是一个文件夹，设置成只读那么，代表里面的文件只读，但是可以增加和重命名文件及文件夹，
		System.out.println("该文件可写吗"+f.canWrite());//测试应用程序是否可以修改此抽象路径名表示的文件。
													
		System.out.println("该文件可执行吗"+f.canExecute());//测试应用程序是否可以执行此抽象路径名表示的文件:可执行文件，类似.exe的文件
		
		System.out.println("是绝对路径吗？"+f.isAbsolute());//绝对路径：从盘符开始按每一级路径展开的文件.相对路径：从当前路径开始的路径
		
		System.out.println("是文件夹吗？"+f.isDirectory());//文件夹和和目录的区别是啥？
		
		System.out.println("是文件吗？"+f.isFile());//没有子目录的的文件
		
		System.out.println("是隐藏吗？"+f.isHidden());//属性是否设置成隐藏
		
		System.out.println("最后修改时间为："+f.lastModified());//最后修改时间，返回long型时间
		
		System.out.println("获取路径名称"+f.getPath());//获取路径名称
		
		System.out.println("获取绝对路径名称"+f.getAbsolutePath());//获取绝对路径,返回此抽象路径名的绝对路径名字符串。
		
		try {
			System.out.println("获取规范路径名称"+f.getCanonicalPath());// 返回此抽象路径名的规范路径名字符串。
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("获取绝对路径文件"+f.getAbsoluteFile());// 返回此抽象路径名的绝对路径名形式。返回的是文件类，直接输出是toString该文件的文件路径
		try {
			System.out.println("获取简洁的文件"+f.getCanonicalFile());//返回此抽象路径名的规范形式。返回的是文件类，直接输出是toString该文件的文件路径
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("长度为："+f.length());//返回由此抽象路径名表示的文件的长度:文件长度是指占用空间，文件大小是指文件大小
		
		
		/*********************文件时间获取**************************/
		//是一个以与语言环境有关的方式来格式化和解析日期的具体类,主要是用来创建一个时间格式
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm");//1、创建时间格式
		long l=f.lastModified();//2、获得时间数据
		Date date=new Date(l);//3、创建日期
		String sb=sdf.format(date);//4、将日期以一定的格式转化为String
		System.out.println(sb);//5、输出一定格式的时间
//		System.out.println(sdf.format(new Date(f.lastModified())));//一次性输出
		
		
		/********************文件遍历**************************/
		System.out.println("/********************文件次目录遍历**************************/");
		String[] filenames=f.list();//返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录。得到的是字符串
		for(String fi:filenames){//注意这个遍历只遍历次目录的文件和文件夹
			System.out.println(fi);
		}
		System.out.println("/********************输出文件名字符串后缀过滤**************************/");
		//利用字符串后缀过滤指定后缀的文件夹及文件名称，
		for(String fns:filenames){
			if(fns.endsWith(".txt"))//String 类方法，后缀过滤
				System.out.println(fns);
			
		}
		
		/********************文件过滤器**************************/
		System.out.println("/********************文件过滤器**************************/");
//		FilenameFilter filter=new FilenameFilter();//是一个接口不能实例化，而且没有实现类
		MyFilenameFilter filter=new MyFilenameFilter(".txt"); //用已经创建的实现类，文件(夹)过滤器，
		//下面这一步，传递到list里面的是文件过滤器，实际上是将，f中的文件和文件夹的名称一一输入进过滤器，过滤器过滤出的.txt的文件再保存到数组里。
		String[] filenames2=f.list(filter);//返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中满足指定过滤器的文件和目录。
		for(String fi:filenames2){
			System.out.println(fi);
		}
		
		/********************创建和删除文件**************************/
		try {
			File f2=File.createTempFile("aaa", "zzz");//产生一个名称前缀和后缀为aaazzz的临时文件
			f2.delete();//删除文件
			System.out.println(f2.getPath());//都已经删除了为什么还能获取到绝对路径呢?
			System.out.println(f2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
