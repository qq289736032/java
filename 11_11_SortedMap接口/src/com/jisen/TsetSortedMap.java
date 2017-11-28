package com.jisen;

import java.util.*;

public class TsetSortedMap {

	/**
	 * 关键字不能重复，元素时按照升序排序，通过equals和hashCode决定。
	 */
	public static void main(String[] args) {
		//有序了，因为Integer类型是标准类型，有自动装箱拆箱的功能，所以比较equals和hash时是相等的，如果关键字是自定义类型，则依然是依据equals和hashCode排序的。
		SortedMap<Integer, String> smis=new TreeMap<Integer, String>();//用子类实现
		smis.put(1001, "张珊");//查询没有并添加，类似修改
		smis.put(1002, "李四");
		smis.put(1003, "王5");
		smis.put(1004, "麻溜");
		System.out.println(smis);
		
		System.out.println(smis.firstKey());
		System.out.println(smis.lastKey());
		
//		SortedMap<Integer, String> smis2=smis.headMap(1003);
		System.out.println(smis.headMap(1003));
		
	}

}
