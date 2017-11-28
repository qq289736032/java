package com.jisen;

import java.util.Enumeration;
import java.util.Properties;

public class Collection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Properties pro=System.getProperties();//获取系统所有的属性
		 //1、打印所有属性？
		 System.out.println(pro);//打印所有属性
		 
		 //2、打印所有属性名称？发现属性属性名称是个不确定类型的接口 System.out.println(pro.propertyNames());//是一个Enumeration<?>不能打印
		 Enumeration<?> en= pro.propertyNames();//这里返回值是？表示获得的东西是任意类型的，这里获取属性名称
		 String s= (String) en.nextElement();//获取属性名称的元素?未知类型
		
//		 System.out.println(s);
//		 String key=(String) en.nextElement();
//		 String key2=(String) en.nextElement();
//		 System.out.println(key);
//		 System.out.println(key2);
//		 
		 /*
		  * 终于发现Enumeration<?>这种类，有三个关键点的方法
		  * 1、 en.hasMoreElements()确定是否有下个元素
		  * 2、en.nextElement()如果有那就获取下个元素。
		  * 3、可以通过连续取出en.nextElement()的值将Enumeration<?>里的元素全部遍历取出
		  */
		 
		 //遍历元素好像不能用for each?
//		 for(;en.hasMoreElements();){
//			 System.out.println(en.nextElement());
//		 }
//		 while(en.hasMoreElements()){
//			 System.out.println(en.nextElement());
//		 }
//		 
		 //准确获取每一个元素当中的属性
		 while(en.hasMoreElements()){//如果有元素，那么就获取
			 String key=(String) en.nextElement();
			 if(key.equals("os.name")){
				 String value=pro.getProperty(key);
				 System.out.println(value);
			 }
		 }
	}

}
