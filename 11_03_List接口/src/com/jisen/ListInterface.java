package com.jisen;

import java.util.*;

public class ListInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list=new LinkedList<String>();
		
		//1、add()、get()、indexOf("d")、lastIndexOf("d")
		System.out.println("//1、add()、get()");
		list.add("a");
		list.add("b");
		list.add(1, "c");//不能越界，但是可以在相应位置插入，此位置及后面原有的元素，往后移
		list.add(1, "d");//不能越界，但是可以在相应位置插入，此位置及后面原有的元素，往后移
		list.add(3, "d");//可以重复
		System.out.println(list);//输出呈现中括号数组方式
		System.out.println(list.get(4));//不可越界，get方式可以遍历
		System.out.println(list.indexOf("d"));//某元素的位置，假设某元素有三个重复，那么输出第一个元素的位置。
		System.out.println(list.lastIndexOf("d"));//某元素最后的位置，假设三个重复的元素，那么输出第三个元素位置
		
		//2、itrator，迭代器可以遍历
		System.out.println("//2、itrator");
		Iterator<String> is = list.iterator();
		while (is.hasNext()) {
			String s1 = is.next();
			System.out.print(s1+" ");
		}
		System.out.println();
		
		//3、listItrator，迭代器可以遍历
		System.out.println("//3、listItrator，迭代器可以遍历");
		ListIterator<String> lis=list.listIterator(1);//区别在于能够在指定位置开始
		System.out.println(lis.previous()+" ");//输出前一个
//		System.out.println(lis.previous()+" ");//输出前一个
		while(lis.hasNext()){//2这个位置有下一个吗，有，把list.next赋给
			String s2=lis.next();
			System.out.print(s2+" ");
		}
		
		//remove
	}

}
