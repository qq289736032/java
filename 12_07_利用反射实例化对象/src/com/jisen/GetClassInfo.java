package com.jisen;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import com.jisen.person.Person;


public class GetClassInfo {

	/**
	 * @param args
	 */
	
	//字符截取
	public static String MySplitStr(String s){
		return s.substring(s.lastIndexOf(".")+1);
	}
	
	//打印类信息
	public static void printClassInfo(Class c8) {
		// ------------------获取类的头信息-------------
		// 获取包名

		System.out.println(c8.getPackage());// 调用toString方法输出包名
		// 获取注解
		Annotation[] ans = c8.getAnnotations();
		if (ans.length != 0) {
			for (Annotation an : ans) {
				Class<?> ca = an.annotationType();
				System.out.println("@" + MySplitStr(ca.getName()));
			}
		}
		// 获取修饰符
		System.out.print(Modifier.toString(c8.getModifiers()) + " class "
				+ MySplitStr(c8.getName()));// 获取类的修饰符

		// 获取父类
		String superClassName = MySplitStr(c8.getSuperclass().getName());
		if (!"Object".equals(superClassName)) {
			System.out.print(" extends " + superClassName);
		}

		// 获取父类接口
		Class<?>[] cis = c8.getInterfaces();
		if (cis.length != 0) {
			System.out.print(" implements ");
			for (int i = 0; i < cis.length; i++) {
				if (i < cis.length - 1)
					System.out.print(MySplitStr(cis[i].getName()) + ", ");
				else
					System.out.print(MySplitStr(cis[i].getName()));
			}
		}
		System.out.print("{\n");
	}
	
	//打印构造器
	
	private static void printAllConstructors(Class<?> c) {
//		Constructor<?>[] cons=c.getConstructors();//只能获取到公共类的构造器
		Constructor<?>[] cons=c.getDeclaredConstructors();//能获取本类中所有构造器
		if (cons.length != 0) {
			for (Constructor<?> co : cons) {
				int iMod=co.getModifiers();
				if(iMod==0)
					System.out.print("\t");//输出修饰符,如果无修饰符时
				else
					System.out.print("\t "+Modifier.toString(iMod));//输出修饰符
//				System.out.println("\n\t"+co);//利用系统toString把构造方法都打印了出来
//				System.out.print(" "+MySplitStr(co.toString()));//利用字符截取把截取出来，但是有一个小问题
				System.out.print(" "+MySplitStr(co.getName())+"(");//截取并输出构造方法名称
				Class<?>[] ct=co.getParameterTypes();
				if(ct.length==0){
					System.out.println(");");
				} else {
					for (int i=0;i<ct.length;i++) {
						if (i<ct.length - 1) {
							System.out.print(MySplitStr(ct[i].getName()) + ",");
						}else{
							System.out.println(MySplitStr(ct[i].getName())+");");
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		/*********************************************
		try {
			//其中1、2、3适用于知道类的情况，获取该对象的运行时识别
			//4适用于只知道对象，获取该对象的运行时识别
			
			//1.1利用Class自身的静态方法forName，参数必须是：包.类名
			Class<?> c1= Class.forName("java.lang.String");
			System.out.println(c1.getName());
			
			//1.2利用ClassLoader提供的方法loadclass,参数必须是：包.类名
			ClassLoader cl=ClassLoader.getSystemClassLoader();
			Class<?> c2=cl.loadClass("java.lang.String");//类的二进制名称
			System.out.println(c2.getName());
			
			//1.3利用每个类都有一个字段：class
			Class<?> c3=String.class;
			System.out.println(c3.getName());
			
			//1.4、利用Object的getClass（）方法
			Object o=new String("hello");
			Class<?> c4=o.getClass();
			System.out.println(c4.getName());
			
			//2基本数据类型如何获取运行时
			//2.1知道基本数据类型的情况下		//更多时候就用这个
			Class<?> c5=int.class;
			System.out.println(c5.getName());
			
			//2.2l利用包装类
//			Class<?> c6=Integer.class;
			Class<?> c6=Integer.TYPE;
			System.out.println(c6.getName());
			
			Class<?> c7=Person.class;
			System.out.println(c7.getSuperclass());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		*******************************************************/
		Class<?> c8=Person.class;
		printClassInfo(c8);
		printAllConstructors(c8);
		try {
//			Constructor<?> con =c8.getDeclaredConstructor(int.class,String.class);//调用一个有参构造器
			Constructor<?> con =c8.getDeclaredConstructor();//调用一个有参构造器，出现访问权限异常那么就要开放无参构造器的权限
			con.setAccessible(true);//此函数用于开放构造器权限
			System.out.println(con.newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.print("\n}");
	}
}
