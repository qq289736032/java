package com.jisen;

import java.util.*;

public class SetInterface {

	/**
	 *HashSet不允许元素重复，没有升降序，其内部根据hashCode值，利用Hash算法得到1个值，这个值就是HashSet依据的排序关键字
	 *对于系统类而言，已经复写好equals和hashCode，所以我们通常在使用HashSet去保存系统类型的时候，是不需要判断的；
	 *对于自定义类而言，我们通常需要复写equals和hashCode来保证元素的唯一性
	 *去重依据是：如果两个对象的equals比较不相等，则不需要比较hashCode，肯定是两个不同的对象
	 *如果两个对象的equals比较相等，则还需要去比较两个对象的hashCode值是否相等，如果不相等则判为不相等的对象
	 *如果相等，则认为是重复的对象则去重
	 */
	public static void main(String[] args) {
		Set<Integer> set=new HashSet<Integer>();
		//HashSet:元素不能重复，并且没有插入顺序，也没有元素的升降序，实际上也有一个顺序（基于hash码，通过哈希算法）
		//add，添加成功返回true
		set.add(1);
		set.add(22);
		set.add(22);
		set.add(2);
		set.add(3);
		set.add(9);
		set.add(8);
		set.add(7);
		System.out.println(set);
		
		set.remove(1);
		System.out.println(set);
	}

}
