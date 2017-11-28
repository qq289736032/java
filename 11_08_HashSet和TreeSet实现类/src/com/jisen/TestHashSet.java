package com.jisen;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestHashSet {

	/**
	 * @param args
	 * hashSet是set接口典型实现类,大多数时候使用Set集合就是用这个实现类,hashset按hash算法来存储集合中的元素,在散列中,
	 * 一个关键字的信息内容被用来确定,唯一的一个值,称为散列码,而散列码被用来当做关键字相连的数据存储下标,关键字到其散列码的转换是自动执行的,
	 * 看不到散列码本身.
	 */
	public static void main(String[] args) {
		
		//构造方法HashSet(int initialCapacity, float loadFactor) 
        //构造一个新的空 set，其底层 HashMap 实例具有指定的初始容量和指定的加载因子。
		HashSet<Integer> hsi=new HashSet<Integer>(30,0.8f);//此构造方法可传入初始容量和增加率（float）
		hsi.add(11);
		hsi.add(91);
		hsi.add(31);
		hsi.add(61);
		hsi.add(21);
		hsi.add(51);
		hsi.add(71);
		hsi.add(41);
		hsi.add(81);
		hsi.add(81);
		System.out.println(hsi);//输出结果看是无序的
		
		//equals 不等，不同
		//equals 相等 hashCode相同--->相同，hashCode不同则不同
	}
	
	class MyHashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, java.io.Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public Iterator<E> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}

}
