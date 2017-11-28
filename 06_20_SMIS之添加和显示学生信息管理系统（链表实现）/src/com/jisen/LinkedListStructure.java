package com.jisen;

import java.util.Scanner;

class Node{
	//1、数据域
	private int elem;//元素
	public void setElem(int elem){
		this.elem=elem;
	}
	public int getElem(){
		return this.elem;
	}
	public String toString(){
		return this.elem+" ";
	}
	public Node(){}
	public Node(int elem){
		this.elem=elem;
	}
	
	//2、指针域：地址域
	Node next; 
}

public class LinkedListStructure {

	/**
	 * @param args
	 */
	//1、产生链表
	public static Node add(){
		Node head=null;
		Node tail=null;
		Scanner in=new Scanner(System.in);
		while(true){
			//1、产生节点空间
			Node node=new Node();
			//2、填充数据
			System.out.println("请输入元素");
			int n=in.nextInt();
			if(n==0){
				node=null;
				break;
			}
			node.setElem(n);
			//3、加入到链表
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
	public static void print(Node head){
		Node current=head;
		while(current!=null){
		System.out.println(current);
		current=current.next;
		}
	}
	public static void main(String[] args) {
//		add();
		print(add());
//		Node node1=new Node(1);
//		Node node2=new Node(2);
//		Node node3=new Node(3);
//		Node node4=new Node(4);
//		node1.next=node2;
//		node2.next=node3;
//		node3.next=node4;
//		node4.next=null;
//		Node head = node1;
//		System.out.println(head);
//		System.out.println(head.next);
//		System.out.println(head.next.next);
	}

}
