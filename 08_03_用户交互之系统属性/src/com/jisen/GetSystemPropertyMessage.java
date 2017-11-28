package com.jisen;

import java.util.*;

public class GetSystemPropertyMessage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name=null;
		int age=0;
		Properties ps=System.getProperties();//利用getProperties()获取所有属性
		Enumeration<?> en=ps.propertyNames();//获取所有属性关键字 返回一个集合
		while(en.hasMoreElements()){
			String key=(String) en.nextElement();
			if(key.equals("name")){
				name=ps.getProperty(key);
			}
			if(key.equals("age")){
				age=Integer.parseInt(ps.getProperty(key));
			}
		}
		System.out.println("你的名字为："+name+",年龄："+age);
	}

}
