package com.jisen.Operate;

import java.util.Scanner;

import com.jisen.student.Student;

public class StudentOperate {
	private StudentOperate(){}
	public static  int showMainmenu() {
		Scanner in = new Scanner(System.in);
		int choose =-1;
		while (choose < 0 || choose > 4) {
			System.out.println("================================");
			System.out.println("			1、添加信息				");
			System.out.println("			2、删除信息				");
			System.out.println("			3、修改信息				");
			System.out.println("			4、查询信息				");
			System.out.println("			0、退出系统				");
			System.out.println("================================");
			System.out.println("请输入您的操作：");
			try{
				choose = in.nextInt();
			}catch(Exception e){
				in.nextLine();
			}
		}
		return choose;
	}
	public static Student addStudentInfo(){
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
	
	public static Student[] addStudentInfo(Student[] stu){
		
		int i=0;//i起到的作用就是统计元素的个数
		
			Scanner in = new Scanner(System.in);

			while (true) {
				//1、产生空间
				Student newStu=new Student();
				//2、填充数据
				System.out.println("请输入学号");
				int n = in.nextInt();
				if (n == 0){
					newStu=null;
					break;
				}
				newStu.setId(n);
				System.out.println("请输入姓名");
				newStu.setName(in.next());
				System.out.println("请输入年龄");
				newStu.setAge(in.nextInt());
				//加入到数组
				stu[i]=newStu;
				i++;
			}
		
		return stu;
		
	}
	public static Student deleteStudentInfoByNo(Student stu,int id){
		Student current=stu;
		Student previous=stu;
		if(stu==null){//一进来判断是否为空指针
			System.out.println("无学生记录，删除失败~");
			return stu ;
		}
		if(stu.getId()==id){//再判断删除的是不是第一个学生
			stu=stu.next;
			return stu;
		}
		while(current!=null){//查询学生
			if(current.getId()==id){//如果找到该学生
				previous.next=current.next;//则把该学生指针域里面保存的下一个学生放到前一个上面
				break;
			}else //如果没找到
				previous=current;//如果找不到就把此刻的学生放在这个中间变量
				current=current.next;//转查询下一个学生
			
			if(current==null){//如果找到最后尾部指针域为null则表示找不到
				System.out.println("找不到该学生学号对应的学生记录，删除失败~");
			}
		}
		return stu;
	}
	public static void modifyInfo(Student stu,int id){
		Student current=stu;
		if(stu==null){//一进来判断是否为空指针
			System.out.println("无学生记录，修改失败~");
		}
		while(current!=null){//查询学生
			Scanner in=new Scanner(System.in);
			if(current.getId()==id){//如果找到该学生
				System.out.println("姓名修改为：");
				String name=in.next();
				current.setName(name);
				System.out.println("年龄修改为：");
				int age=in.nextInt();
				current.setAge(age);
				
				break;
			}else //如果没找到
				
				current=current.next;//转查询下一个学生
			
			if(current==null){//如果找到最后尾部指针域为null则表示找不到
				System.out.println("找不到该学生学号对应的学生记录，修改失败~");
			}
		}
	}
	public static void showAllStudentInfo(Student head) {
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
}
