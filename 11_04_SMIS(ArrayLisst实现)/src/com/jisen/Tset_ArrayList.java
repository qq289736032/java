package com.jisen;

import java.util.*;

import com.jisen.student.*;

public class Tset_ArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		List<Student> ls=new ArrayList<Student>();
		ArrayList<Student> ls=new ArrayList<Student>();
		
		//add,remove
		ls.add(new Student(1001,"zs",23));//加入成功返回true
		ls.add(new Student(1001,"zs",24));
		ls.add(new Student(1003,"ls",24));
		ls.add(new Student(1002,"ww",22));
		
		ls.remove(new Student(1001," ",3));//删除成功,删除时先调用Object的equals查找该对象，所以无法删除，
		ls.remove(new Student(1001,"zs",22));//因此要改写Student这个类的equals和hashcode方法，删除成功返回1
		
		//1、遍历
		for(Student s:ls)
		System.out.println(s+"\n");
//		
		//更多的时候推荐迭代器
//		Iterator<Student> it=ls.iterator();
//		while(it.hasNext())
//			System.out.println(it.next());
//		
		//转换成数组
//		Student[] stus1=ls.toArray(new Student[0]);
//		for(Student s:stus1)
//			System.out.println(s);
		
		//把一个数组变成一个集合
		Student[] stus2={
				new Student(1001,"zs",22),
				new Student(1002,"ls",23),
				new Student(1003,"ww",24)
		};
		List<Student> ls2=new ArrayList<Student>();
		for(int i=0;i<stus2.length;i++)
			ls2.add(i, stus2[i]);
		//或者aList
		List<Student> ls3=Arrays.asList(stus2);
		for(Student s:ls3)
			System.out.println(s+"\n");
		
		
		//查询功能,需要改写equals和hashcode，与remove一起搭配使用，便于删除查询
		System.out.println("//查询功能,需要改写equals和hashcode，与remove一起搭配使用，便于删除查询");
		System.out.println(ls2.indexOf(new Student(1001," ",0 )));
		System.out.println(ls2.indexOf(new Student(1002," ",0 )));
//		ls2.remove(ls2.indexOf(new Student(1001," ",0 )));//按下标删除,这种删除方式，返回被删除的元素
		Student rs=ls2.remove(ls2.indexOf(new Student(1002," ",0 )));
		System.out.println("heeh"+rs);
		ls2.remove(new Student(1002," ",0 ));//按对象删除.删除成功返回1
		for(Student s:ls2)
			System.out.println(s+"\n");
		
		//修改功能,修改，也需要查询
		System.out.println("//修改功能");
		System.out.println(ls3.indexOf(new Student(1001," ",0 )));
		System.out.println(ls3.indexOf(new Student(1002," ",0 )));
		for(Student s:ls3)
			System.out.println(s+"\n");
		ls3.set(ls3.indexOf(new Student(1001," ",0 )), new Student(1001,"王大锤 ",0 ));//返回该学生
		System.out.println(ls3.set(ls3.indexOf(new Student(1001," ",0 )), new Student(1001,"王大锤 ",0 )));
		for(Student s:ls3)
			System.out.println(s+"\n");
		
		
//		System.out.println(ls2);//删除成功
	}

}
