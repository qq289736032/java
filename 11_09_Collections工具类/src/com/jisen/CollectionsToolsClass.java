package com.jisen;

import java.util.*;

//创建自己的collections
class MyCollections<T>{
	private MyCollections(){}
	public static <T>void addAll(Collection<T> coll,T... elem){
		for(int i=0;i<elem.length;i++)
			coll.add(elem[i]);
	}
}

//创建自己的比较器
class MyComparator implements Comparator<Integer>{

	public int compare(Integer o1, Integer o2) {
		
		return o2.intValue()-o1.intValue();
	}

}

public class CollectionsToolsClass {

	/**
	 * 常见的使用方法1、addall2、swap3、
	 */
	public static void main(String[] args) {
		ArrayList<Integer> ali=new ArrayList<Integer>();
		//1、addAll 将所有指定元素添加到指定 collection 中。
		System.out.println("//1、addAll 将所有指定元素添加到指定 collection 中。");
		Collections.addAll(ali, 1,5,3,1,2);
		System.out.println(ali);
		
		
		/*
		 * <T extends Comparable<? super T>> void sort(List<T> list)，无返回值
		 * 根据元素的自然顺序 对指定列表按升序进行排序。 
		 *  <T> void sort(List<T> list,Comparator<? super T> c)，无返回值
		 * 可以自行导入比较器进行排序
		 */
		//自定义比较器输出
		
		Collections.sort(ali, new MyComparator());//逆序
		System.out.println("//自定义比较器输出\n"+ali);
		//根据元素的自然顺序 对指定列表按升序进行排序。
		System.out.println("//根据元素的自然顺序 对指定列表按升序进行排序。");
		Collections.sort(ali);
		System.out.println(ali);
		
		//使用二分搜索法搜索指定列表，以获得指定对象。binarySearch
		System.out.println("//使用二分搜索法搜索指定列表，以获得指定对象。并返回下标位置");
		System.out.println(Collections.binarySearch(ali, 5));
		//使用自定义比较器，排序然后输出5的位置
		System.out.println("//使用二分搜索法搜索指定列表，以获得指定对象。");
		System.out.println(Collections.binarySearch(ali, 5,new MyComparator()));//？？？
		System.out.println(ali);
		
		
//		Collections.checkedCollection(ali, type)
		
		//copy的使用
		ArrayList<Integer> dest=new ArrayList<Integer>(30);
		Collections.addAll(dest,4,4,5,7,8,3);
		Collections.copy(dest, ali);//把ali中的元素取代，dest中同下标的元素，且dest的元素个数要大于等于ali
		System.out.println(dest);
		
		//fill替换所有元素为同一个对象
		ArrayList<Integer> ali1=new ArrayList<Integer>();
		Collections.addAll(ali1, 1,2,3,4);
		Collections.fill(ali1, 1);//将对象替换所有元素，
		System.out.println(ali1);
		
		//reverseOrder() 返回一个反转的比较器
		//reverse(List<?> list) //反转列表中的所有元素
		
		ArrayList<Integer> ali2=new ArrayList<Integer>();
		Collections.addAll(ali2, 1,2,3,4);
		System.out.println(ali2);
		Collections.reverse(ali2);
		System.out.println(ali2);
		Collections.sort(ali2, Collections.reverseOrder());//返回一个逆转自然顺的比较器
		System.out.println(ali2);
		Collections.sort(ali2, Collections.reverseOrder(new MyComparator()));//返回一个逆转自定义比较器的比较器，
		System.out.println(ali2);
	}

}
