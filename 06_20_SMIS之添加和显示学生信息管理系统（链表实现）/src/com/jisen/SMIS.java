package com.jisen;

import java.util.Scanner;

import com.jisen.student.Student;

public class SMIS {

	/**
	 * @param args
	 */
	public static Student add(){
		Student head=null;//填充数据前先产生头部栈区空间
		Student tail=null;//因为头部栈区空间不需要再被改变了，但是要有一个临时变量将下个学生放到上个学生的指针域
		Scanner in=new Scanner(System.in);
		while(true){
			//1、产生节点，产生对象实例
			Student newStu=new Student();
			//2、填充数据
			System.out.println("请输入学号");
			int id=in.nextInt();
			if(id==0){//防止输入学号为0，或者设定输入为0时填充数据结束
				newStu=null;
				break;
			}
			newStu.setId(id);
			
			System.out.println("请输入姓名");
			String name=in.next();
			newStu.setName(name);
			
			System.out.println("请输入年龄");
			int age=in.nextInt();
			newStu.setAge(age);
			
			//加入到链表
			
			if(head==null){//第一次添加学生，头部已经填好了就不变了
				head=newStu;//当只有一个链表时，把第一个学生放到头部
				newStu.next=null;//当只有一个学生的时候，指针域不再向下
				tail=newStu;//如果有新的学生则还要将第一个学生放到临时变量区，
			}else{			//以后的每次
				tail.next=newStu;//把该次的学生赋给上一个学生的指针域
				newStu.next=null;//将该次的学生指针域初始化
				tail=newStu;	//把该次的学生赋给临时变量，如果没有下一个学生则为尾部，
			}
		}
		return head;
	}
	public static void print(Student head) {
		Student current=head;//头部是永远不变的，所以要避免在循环遍历中被改变
		while(current!=null){//只打印有效数据
			System.out.println(current);
			current=current.next;//类似于循环自加1
		}
//		for(Student current=head;current.next==null;current=current.next ){
//			System.out.println(current);
//		}
//			
	}
	public static void main(String[] args) {
		print(add());
	}

}
