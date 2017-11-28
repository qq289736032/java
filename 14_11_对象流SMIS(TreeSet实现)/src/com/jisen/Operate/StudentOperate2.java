package com.jisen.Operate;

import java.io.*;
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
	
	public static TreeSet<Student> ts=new TreeSet<Student>();
	public static void addStudentInfo(){	
			while (true) {
				System.out.println("请输入学号id=");
				int id = in.nextInt();
				System.out.println("请输入姓名name=");
				String name = in.next();
				System.out.println("请输入年龄age=");
				int age = in.nextInt();
				ts.add(new Student(id,name,age));
				System.out.println("继续添加请输1，退出请按0");
				if(in.nextInt()==0){
					saveStuInfo(ts);
					break;
				}
			}
	}
	public static void deleteStudentInfoByNo(){
		
		while (true) {
			System.out.println("请输入您要删除的学号");
			int id=in.nextInt();
			Student stu = new Student(id, " ", 0);
			if (ts.remove(stu)) {
				System.out.println("删除成功");
			} else {
				System.out.println("不存在该学生记录，无法删除");
				break ;
			}
			System.out.println("继续删除请按1，退出请按0");
			if(in.nextInt()==0){
				saveStuInfo(ts);
				break;
			}
		}
	}
	public static void modifyInfo(){//先删除再添加实现修改
		while (true) {
			System.out.println("请输入您要修改的学号");
			int id=in.nextInt();
			
			if (ts.remove(new Student(id,"",0))==false) {
				System.out.println("不存在该学生。。无法修改");
			} else {
				System.out.print("请输入姓名：");
				String name = in.next();
				System.out.print("请输入年龄：");
				int age = in.nextInt();
				ts.add(new Student(id, name, age));
			}
			System.out.println("继续修改请按1，退出请按0");
			if(in.nextInt()==0){
				saveStuInfo(ts);
				break;
			}
		}
	}
	public static void showAllStudentInfo() {
		for (Student s:ts) {
			System.out.println(s + " ");
		}
	}
	
	public static void saveStuInfo(TreeSet<Student> ts){
		Iterator<Student> it=ts.iterator();
		//1、对象流
		ObjectOutputStream oos=null;
		try {
			oos=new ObjectOutputStream(new FileOutputStream("student.dat"));
			while(it.hasNext()){
				oos.writeObject(it.next());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static TreeSet<Student> loadStudentInfo(){
		ObjectInputStream ois=null;
		try {
			File f = new File("student.dat");//这个程序第一次进来的时候要创建文件
			if (!f.exists()) {
				f.createNewFile();
//				return ;
			}
			ois = new ObjectInputStream(new FileInputStream(f));
			while(true){
				try {
					Student stu=(Student) ois.readObject();
					ts.add(stu);
				} catch (Exception e) {
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ois!=null){
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ts;
	}
}











