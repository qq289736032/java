package com.jisen;

import java.util.*;
import com.jisen.Operate.StudentOperate2;


public class SMIS_TreeSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StudentOperate2.loadStudentInfo();
		//输入界面用一个do{}while()
		do{
			int choose =StudentOperate2.showMainmenu();
			switch(choose){
			case 1: {
				System.out.println("			1、添加信息				");
				StudentOperate2.addStudentInfo();
				break;
			}
			case 2:	{
				System.out.println("			2、删除信息				");
				StudentOperate2.deleteStudentInfoByNo();
				break;
			}
			case 3:	{
				System.out.println("			3、修改信息				");
				StudentOperate2.modifyInfo();
				break;
			}
			case 4:
				System.out.println("			4、查询信息				");
				StudentOperate2.showAllStudentInfo();
				break;
			case 0:
				System.out.print("			 确定要 退出系统吗(Y/N):				");
				char cChoose=new Scanner(System.in).next().charAt(0);
				if(cChoose=='Y'||cChoose=='y')
				System.exit(0);
			}
			
		}while(true);
		
	}

}
