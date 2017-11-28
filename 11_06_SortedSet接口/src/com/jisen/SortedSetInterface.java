package com.jisen;

import java.util.*;

class MyInteger implements Comparable<MyInteger> {
	int i;

	public MyInteger() {
	}

	public MyInteger(int i) {
		this.i = i;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.i + "";
	}

	public int compareTo(MyInteger o) {// 定制排序，
		// TODO Auto-generated method stub
		return o.i - this.i;
	}

}

class MyComp implements Comparator<Integer> {// 自己编写比较器

	public int compare(Integer o1, Integer o2) {
		return o2.intValue() - o1.intValue();
	}
}

public class SortedSetInterface {

	/**
	 * TreeSet而言，拥有排序规则，两种： 自然排序 定制排序
	 */
	public static void main(String[] args) {
		// 去除重复，有升序

		SortedSet<Integer> ssi = new TreeSet<Integer>(new MyComp());
		// add，添加成功返回true
		// ssi.add(new MyInteger(1));
		// ssi.add(new MyInteger(22));
		// ssi.add(new MyInteger(22));
		// ssi.add(new MyInteger(2));
		// ssi.add(new MyInteger(3));
		// ssi.add(new MyInteger(9));
		// ssi.add(new MyInteger(8));
		// ssi.add(new MyInteger(7));
		ssi.add(1);
		ssi.add(22);
		ssi.add(3);
		ssi.add(2);
		ssi.add(3);
		ssi.add(9);
		ssi.add(8);
		ssi.add(7);

		System.out.println(ssi);

		// ssi.remove(1);
		// System.out.println(ssi);

		// super 下限
		// 上线，如果对此Set中的元素进行排序的比较器，如果此set使用其元素的自然顺序，则返回null。
		Comparator<? super Integer> comp = ssi.comparator();// 获取比较器
		System.out.println(comp);// 输出当前比较器

		// first()返回此Set中当前第一个（最低）元素
		// last()返回此set中当前最后一个元素（最高）元素
		System.out.println(ssi.first());
		System.out.println(ssi.last());

		// headSet()返回set的部分视图，其元素严格小于toElement
		// tailSet()返回此set的部分视图，其元素从fromElement（包括）到toElement（不包括—）
		System.out.println(ssi.headSet(3));
		System.out.println(ssi.tailSet(3));
		System.out.println(ssi.subSet(9, 3));
	}

}
