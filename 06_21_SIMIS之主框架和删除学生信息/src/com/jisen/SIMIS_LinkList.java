package com.jisen;

import java.util.Scanner;

import com.jisen.Operate.StudentOperate;
import com.jisen.student.Student;

public class SIMIS_LinkList {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		Student stu=null;
		do {// 做一个菜单和输入界面
			
			int choose=StudentOperate.showMainmenu();
			
			switch(choose){
			case 1:
				System.out.println("			1、添加信息				");
				stu=StudentOperate.addStudentInfo();//添加学生之后返回的是head所以要用一个变量来接收head
				break;
			case 2:
				System.out.println("			2、删除信息				");
				System.out.print("请输入您要删除的学生的学号：");
				int id=new Scanner(System.in).nextInt();
				stu=StudentOperate.deleteStudentInfoByNo(stu,id);
				break;
			case 3:
				System.out.println("			3、修改信息				");
				System.out.println("请输入您要修改的学生学号");
				int id2=new Scanner(System.in).nextInt();
				StudentOperate.modifyInfo(stu, id2);
				break;
			case 4:
				System.out.println("			4、查询信息				");
				StudentOperate.showAllStudentInfo(stu);
				break;
			case 0:
				System.out.print("			 确定要 退出系统吗(Y/N):				");
				char cChoose=new Scanner(System.in).next().charAt(0);
				if(cChoose=='Y'||cChoose=='y')
				System.exit(0);
			}

		} while(true);
	}

}
