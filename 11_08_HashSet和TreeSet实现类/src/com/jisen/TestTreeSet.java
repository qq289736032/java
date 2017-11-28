package com.jisen;

import java.util.*;

import com.jisen.student.Student;

//自定义比较器,按年龄排序
//class MyComparator implements Comparator<Student>{
//	public int compare(Student o1, Student o2) {
//		if(o1.getAge()==o2.getAge())//理论上如果遇到年龄相同没有其他比较条件的化，年龄相同即为重复，但可以增加姓名这一判断条件
//			return o1.getName().compareTo(o2.getName());
//		
//		return o2.getAge()-o1.getAge();//2-1返回，说明是按年龄逆序，
//	}
//	
//}

public class TestTreeSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		TreeSet<String> tss=new TreeSet<String>();
//		tss.add("kk");
//		tss.add("oo");
//		tss.add("33");
//		tss.add("bb");
//		tss.add("xx");
//		tss.add("kk");
//		tss.add("dd");
//		tss.add("cc");
//		System.out.println(tss);
		
//		TreeSet<Student> tss=new TreeSet<Student>(new MyComparator());
		TreeSet<Student> tss=new TreeSet<Student>();
		tss.add(new Student(1001,"zs",23));//没有写比较器
		tss.add(new Student(1001,"zs",24));//当学号重复时只保留之前的那个
		tss.add(new Student(1021,"ls",24));
		tss.add(new Student(1082,"ww",23));
		tss.add(new Student(1041,"ml",22));
		tss.add(new Student(1003,"zq",23));
		tss.add(new Student(1049,"qb",26));
		tss.add(new Student(2048,"sj",23));
		tss.add(new Student(1001,"zs",29));
		System.out.println(tss);
		
		Iterator<Student> is=tss.iterator();
		while(is.hasNext()){
			System.out.println(is.next());
		}
	}

}
