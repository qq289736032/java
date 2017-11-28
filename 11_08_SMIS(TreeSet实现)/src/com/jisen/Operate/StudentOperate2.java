package com.jisen.Operate;

import java.util.*;

import com.jisen.student.Student;

public class StudentOperate2 {
	private StudentOperate2(){}
	public static Scanner in = new Scanner(System.in);
	public static  int showMainmenu() {
	
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
	
	public static TreeSet<Student> astu=new TreeSet<Student>();
	public static void addStudentInfo(){	
			while (true) {
				System.out.println("请输入学号id=");
				int id = in.nextInt();
				System.out.println("请输入姓名name=");
				String name = in.next();
				System.out.println("请输入年龄age=");
				int age = in.nextInt();
				astu.add(new Student(id,name,age));
				System.out.println("继续添加请输1，退出请按0");
				if(in.nextInt()==0){
					break;
				}
			}
	}
	public static void deleteStudentInfoByNo(){
		
		while (true) {
			System.out.println("请输入您要删除的学号");
			int id=in.nextInt();
			Student stu = new Student(id, " ", 0);
			if (astu.remove(stu)) {
				System.out.println("删除成功");
			} else {
				System.out.println("不存在该学生记录，无法删除");
				break ;
			}
			System.out.println("继续删除请按1，退出请按0");
			if(in.nextInt()==0){
				break;
			}
		}
	}
	public static void modifyInfo(){//先删除再添加实现修改
		while (true) {
			System.out.println("请输入您要修改的学号");
			int id=in.nextInt();
			
			if (astu.remove(new Student(id,"",0))==false) {
				System.out.println("不存在该学生。。无法修改");
			} else {
				System.out.print("请输入姓名：");
				String name = in.next();
				System.out.print("请输入年龄：");
				int age = in.nextInt();
				astu.add(new Student(id, name, age));
			}
			System.out.println("继续修改请按1，退出请按0");
			if(in.nextInt()==0){
				break;
			}
		}
	}
	public static void showAllStudentInfo() {
		for (Student s:astu) {
			System.out.println(s + " ");
		}
	}
}
