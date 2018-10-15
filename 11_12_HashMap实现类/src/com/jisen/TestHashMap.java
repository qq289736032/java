package com.jisen;

//Map的本质是有很多个entry组成的Set集合

import com.jisen.student.Student;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* 构造器1、HashMap() 构造一个具有默认初始容量 (16) 和默认加载因子 (0.75) 的空 HashMap。 
		 * 构造器2、HashMap(int initialCapacity) 构造一个带指定初始容量和默认加载因子 (0.75) 的空 HashMap。
		 * 构造器3、 HashMap(int initialCapacity, float loadFactor) 构造一个带指定初始容量和加载因子的空 HashMap。 
		 * 构造器4、HashMap(Map<? extends K,? extends V> m) 构造一个映射关系与指定 Map 相同的新 HashMap。 
		 */
//		HashMap<Integer, String> hm=new HashMap<Integer, String>(20,0.8f);
//		hm.put(1001, "zs");
		HashMap<Student, String> hm=new HashMap<Student, String>(20,0.8f);
		//String类型可以
		hm.put(new Student(1001,"zs",22),"310宿舍");
		hm.put(new Student(1002,"ls",22),"312宿舍");
		hm.put(new Student(1003,"ws",22),"314宿舍");
		hm.put(new Student(1004,"ms",22),"311宿舍");
		hm.put(new Student(1005,"qs",22),"314宿舍");
		System.out.println(hm);
		
		 Set<Map.Entry<Student, String>> sess=hm.entrySet();//正确思维是//Map的本质是有很多个entry组成的Set集合
		 Iterator<Map.Entry<Student, String>> it=sess.iterator();
		 while(it.hasNext()){
			 Map.Entry<Student, String> mess=it.next();
//			 System.out.println(it.next().getKey()+it.next().getValue());//这里已经可以遍历整个set数据了
			 System.out.println(mess.getKey()+"\t\t"+mess.getValue());
		 }


	}


}
