package com.jisen.Operate;

import java.util.Scanner;

import com.jisen.student.Student;

public class StudentOperate2 {
	private StudentOperate2(){}
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
	
	public static int i=0;//i起到的作用就是统计元素的个数
	public static Scanner in = new Scanner(System.in);
	public static Student[] addStudentInfo(Student[] stu){
			
			while (i<stu.length) {
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
	public static Student[] deleteStudentInfoByNo(Student[] stu,int id){
		if(stu==null){//一进来判断是否为空指针
			System.out.println("无学生记录，删除失败~");
			return stu;
		}
		for (i = 0; i <= stu.length; i++) {// 找到该学生
			if (stu[i].getId() == id) {//找到该学生之后做删除动作，将后续学生依次向前挪一位
				for(int j=i;j<stu.length-1;j++){//将后续学生依次向前挪一位
					stu[j]=stu[j+1];
					if(j+1==stu.length-1)
						stu[j+1]=null;
				}
			break;//找到该学生，并挪动完成退出循环
			}
			if(stu[i]==null)
				System.out.println("未找到该学生，删除失败~");
		}
		return stu;
	}
	public static void modifyInfo(Student[] stu,int id){
		
		if(stu==null){//一进来判断是否为空指针
			System.out.println("无学生记录，修改失败~");
		}
		for (i = 0; i <= stu.length;i++) {// 找到该学生
			if (stu[i].getId() == id) {//找到该学生之后做修改动作
				System.out.print("名字修改为：");
				String name=in.next();
				stu[i].setName(name);
				System.out.print("年龄修改为：");
				int age=in.nextInt();
				stu[i].setAge(age);
				break;//修改完成，并挪动完成退出循环
			}
		}
	}
	public static void showAllStudentInfo(Student[] stu) {
		for (int j = 0; j < stu.length; j++) {
			System.out.println(stu[j] + " ");
		}
	}
}
