/*
 * 1、	RandomAccessFile 随机访问文件，文件指针可以定位到自己想要的位置，
 * 2、	文件读写位置：当我们打开一个文件的时候，文件上的位置指针（标识）就是在文件的最开头，当从文件中读取内容之后，则文件的位置标识就会随着变化
 * 3、	在数据等长记录格式文件的随机（相对而言）读取时有很大的优势
 * 4、	RandomAccessFile(File file, String mode)参数1该文件（路径）；参数二以什么方式打开文件（只读，读写） 
 * 5、	文件描述符：raf.getFD()文件保存在磁盘上，为了区别文件与文件之间的关系，每个文件在磁盘上就需要一个唯一对应的文件描述符，计算机通过文件描述符访问磁盘中的文件。
 * 		键盘是0号描述符，显示器是1号，打开错误输出2号，因此打开文件都是从3号开始的
 * 6、	一个空格键占一个字节，一个英文字母占一个字节，一个英文标点符号占一个字节，一个中文标点符号占两个字节。
 * 7、	最常用的读取方式：按字节读取，第一步先建立一个存放字节的字节空间数组，第二步，将文件读到的内容放进b里面并返回数据长度，第三步将数组转换为字符串数组。
 * 8、	readBoolean() 从当前指针读取单个字节。值 0 表示 false。其他任何值表示 true。在读取了该字节、检测到流的末尾或者抛出异常前，此方法一直阻塞。
 * 9、	readByte()读取一个有符号的八位值。如果读取的字节为 b，其中 0 <= b <= 255，则结果将是：byte(b) 
 * 
 * 10、每有一次任何方式的读取光标都会移到相应位置，下一次读取时从该位置读取，因此务必调好读取顺序
 */ 

package com.jisen;

import java.io.*;

class Student{
	public static final int LEN=12;//构建一个等长数据
	public int id;
	public String name;
	public  int age;
	public Student(){}
	public Student(int id,String name,int age){
		this.id=id;
	
		if(name.length()>LEN){//如果名字过长
			this.name=name.substring(0,LEN);//返回一个新字符串，它是此字符串的一个子字符串。从0开始到LEN(不包括) 

		}else{//过短用空格填充
			for(int i=name.length();i<LEN;i++){
				name+='\0';
			}
			this.name=name;
		}
		this.age=age;
	}
}

public class TestRandomAccessFile {

	/**
	 * 文件随机访问
	 */
	public static void main(String[] args) {
		/******************************************
		System.out.println("********************API常见方法***********************");
		try {
//			File f=new File("c:\\a.txt");//打开文件的时候如果文件不存在就创建一个文件，
//			if(!f.exists())
//				try {
//					f.createNewFile();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			
			//1、打开文件
			RandomAccessFile raf1=new RandomAccessFile("c:\\a.txt","rw");
			System.out.println("返回此文件中的当前偏移量: "+raf1.getFilePointer()); //返回此文件中的当前偏移量。返回long型,文件的偏移量？？
			System.out.println("返回此文件的长度: "+raf1.length());// 返回此文件的长度。返回long型，即占用空间大小
			System.out.println("返回文件描述符："+raf1.getFD());//返回文件描述符
			
//			//2、读取数据
			System.out.println("********************API常见读取操作***********************");
//			System.out.println(raf.readByte());// 从此文件读取一个有符号的八位值。遇到汉字则返回其编码，遇到字母就返回其ASCII码，
//			System.out.println(raf.read());//读一个字节，强制转化为char类型之后就是一个字母。
//			System.out.println(raf.readChar());//读取一个字符，如果遇到占4个字符的汉字那就显示问号 
//			System.out.println(raf.readLine());//从此文件读取文本的下一行(就是读取第一行)。，但是只能读英文不能读汉字,且不能与raf.read同时存在，或者已经被打出来的不会重复打
			
			//更多的时候采用这种方法
			byte[] b=new byte[1024];	//产生一个byte型的数组，里面能装1024个byte型的数据，一个汉字是占2个byte，1byte=8bit，一个table键占一个字节
//			
//			raf.skipBytes(4);//15个格子往右偏移三个字节,那么左边三个字节将看不到，并且增加右边的3个字节显示，  尝试跳过输入的 n 个字节以丢弃跳过的字节。
//			raf.seek(4);//设置到此文件开头测量到的文件指针偏移量，在该位置发生下一个读取或写入操作。
			int len=raf1.read(b);//读到的字节数， 将最多 b.length 个数据字节从此文件读入 b 数组。
			System.out.println(new String(b,0,len).trim());//输出一个新建的字符串对象，该字符串从数组b的0位置开始，长度为len
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		********************************************************************/
//		/*******************************************************************
		System.out.println("********************写操作***********************");
		//写操作
		Student stu[]={
				new Student(1001,"Wangdachui",23),
				new Student(1003,"wangerchui",22),
				new Student(1009,"王大锤",24)
		};
		RandomAccessFile raf2=null;
		try {
			//1、打开文件
			raf2=new RandomAccessFile("student.txt", "rw");//
			//2、写入数据
			for (Student s : stu) {
				raf2.writeInt(s.id);
//				raf2.writeChars(s.name);
				raf2.write(s.name.getBytes());
				raf2.writeInt(s.age);
			}
			//3、关闭文件,关闭文件如果写在这里，那么在这之前任何一个一个语句发生异常都会直接跳到catch，而不会执行这一步，因此将这一步放到finally
			//raf.close();
		} catch (IOException e ) {
			e.printStackTrace();
		}finally{
			if(raf2!=null){
				try {
					//3、关闭文件
					raf2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
//		********************************************************************/
		System.out.println("********************读操作***********************");
		RandomAccessFile raf3=null;
		try {
			//1、打开文件
			raf3=new RandomAccessFile("student.txt", "r");
			
//			raf.seek(1*20);
			//2、读
			while(true) {
				try{
					int id=raf3.readInt();
					byte[] b=new byte[Student.LEN];
					int len=raf3.read(b,0,b.length);
					String name=new String(b,0,len).trim();
					int age=raf3.readInt();
					System.out.println(id+"\t"+name+"\t"+age);
				}catch(EOFException e){
						break;
					} 
//				raf.write(s.id);
//				raf.write(s.age);
			}
			//3、关闭文件,关闭文件如果写在这里，那么在这之前任何一个一个语句发生异常都会直接跳到catch，而不会执行这一步，因此将这一步放到finally
			//raf.close();
		}catch (IOException e ) {
			e.printStackTrace();
		}finally{
			if(raf3!=null){
				try {
					//3、关闭文件
					raf3.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
