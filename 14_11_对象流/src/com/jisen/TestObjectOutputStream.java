/**
 * ObjectOutputStream()为完全重新实现 ObjectOutputStream 的子类提供一种方法，让它不必分配仅由 ObjectOutputStream 的实现使用的私有数据。
 * ObjectOutputStream(OutputStream out)创建写入指定 OutputStream 的 ObjectOutputStream。
 * 
 */

package com.jisen;

import java.io.*;
import java.util.*;
import com.jisen.student.Person;

public class TestObjectOutputStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Person> list=new ArrayList<Person>();
		Person p1=new Person(1001,"zs",22);
		Person p2=new Person(1002,"ls",23);
		Person p3=new Person(1003,"ww",24);
		Person p4=new Person(1004,"ml",25);
		Person p5=new Person(1005,"qq",26);
		Person p6=new Person(1006,"zz",27);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		
		ObjectOutputStream oos=null;
		
		try{
			oos=new ObjectOutputStream(new FileOutputStream("c:\\Person.dat"));//对象流，将对象与该文件相关联，文件不区分大小写，容易重复，
			for(Person p:list)
				oos.writeObject(p);//写入一个对象到文件，写入的只是成员变量？如果没有序列化则运行时错误，保存的数据有相关序列化的数据。
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(oos!=null)
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
