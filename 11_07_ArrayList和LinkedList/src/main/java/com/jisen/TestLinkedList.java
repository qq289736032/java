package com.jisen;

import java.util.*;

public class TestLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> lli=new LinkedList<Integer>();
		lli.add(1);
		lli.add(9);
		lli.add(7);
		lli.add(2, 3);//空指针或者下标越界异常
		lli.add(4);
		System.out.println(lli);
		
		Iterator<Integer> dit=lli.descendingIterator();//逆序迭代，双向列表，对应Iterator
		while(dit.hasNext()){
			System.out.println(dit.next()+" ");
		}
		System.out.println();
		
		System.out.println(lli.element());//获取第一个，
		System.out.println(lli.get(1));
		
		System.out.println(lli.peek());//取表头
		
		System.out.println(lli.poll());//获取并移除此列表的表头
		System.out.println(lli);//取表头
	}

}
