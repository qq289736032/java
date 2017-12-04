package com.jisen;

import org.junit.Test;

/**
 * 将一个链表分成两个
 * @author Administrator
 *
 */
public class TestSplit {
	
	class Node<T>{
		private T val;
		
		public T getVal() {
			return val;
		}

		public void setVal(T a) {
			this.val = a;
		}

		@Override
		public String toString() {
			return "Node [val=" + val + "]";
		}

		//2、指针域：地址域
		Node<T> next;
	}
	/**
	 * 尾插法建立链表的方法
	 * @param <T>
	 * @param L
	 * @param val
	 */
	public <T> Node<T> creatLinkedList(T[] a){
		Node<T> head=null;
		Node<T> tail=null;
		int i;
		
		for( i = 0; i < a.length; i++){
			Node<T> node= new Node<T>();
			node.setVal(a[i]);
			if(head==null){
				head=node;
				tail=node;
				tail.next=null;
			}else{
				tail.next=node;
				tail=node;
				tail.next=null;
			}
		}
		return head;
	}
	/**
	 * 尾插法建立链表的方法,头节点部为空
	 * @param <T>
	 * @param L
	 * @param val
	 */
	public <T> Node<T> creatLinkedList3(T[] a){
		Node<T> head=new Node<T>();
		Node<T> tail=head;
		head.next=null;
		
		for( int i = 0; i < a.length; i++){
			Node<T> node= new Node<T>();
			node.setVal(a[i]);
			tail.next=node;
			tail=node;
		}
		tail.next=null;
		return head;
	}
	/**
	 * 头插法建立链表的方法,头节点为空
	 * @param <T>
	 * @param L
	 * @param val
	 */
	public <T> Node<T> creatLinkedList2(T[] a){
		Node<T> head = new Node<T>();
		for( int i = 0; i < a.length; i++){
			Node<T> node= new Node<T>();
			node.setVal(a[i]);
			node.next=head.next;
			head.next=node;
		}
		return head;
	}
	
	public  <T> void print(Node<T> head){
		Node<T> current=head;//不该表头节点
		while(current!=null){
		System.out.println(current);
		current=current.next;
		}
	}
	@Test
	public void main() {
		TestSplit t = new TestSplit();
		TestSplit t2 = new TestSplit();
		TestSplit t3 = new TestSplit();
		Integer[] a = {1,2,3,4};
		Node<Integer> creatLinkedList = t.creatLinkedList(a);
		Node<Integer> creatLinkedList2 = t2.creatLinkedList2(a);
		Node<Integer> creatLinkedList3 = t3.creatLinkedList3(a);
		t.print(creatLinkedList);
		t2.print(creatLinkedList2);
		t2.print(creatLinkedList3);
		
	}
	
}
