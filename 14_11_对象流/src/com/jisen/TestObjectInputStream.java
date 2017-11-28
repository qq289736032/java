package com.jisen;

import java.io.*;
import java.util.*;
import com.jisen.student.Person;

public class TestObjectInputStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Person> list=new ArrayList<Person>();
		
		ObjectInputStream ois=null;
		try {
			ois=new ObjectInputStream(new FileInputStream("c:\\Person.dat"));//该输入流关联一个数据源，从源中读取一个对象
			try {
				while (true) {
					Person o = null;
					try {
						o = (Person) ois.readObject();// 直接读取一个对象，将它赋给一个对象,读到末尾时有一个异常，当产生异常是作为判断结束循环
					} catch (EOFException e) {
						break;
					}
					System.out.println(o);// 输出该对象，toString，读取一次一个对象
					list.add(o);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(ois!=null){
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
