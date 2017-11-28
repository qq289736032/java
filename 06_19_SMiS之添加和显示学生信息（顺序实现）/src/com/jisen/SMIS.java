package com.jisen;

import java.util.Scanner;

import com.jisen.student.Student;

public class SMIS {

	/**
	 * @param args
	 */
	static Student[] Stu=new Student[100];//a起到的作用就是保存很多个数据
	static int i=0;//i起到的作用就是统计元素的个数
	public static void paddingData() {
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
			Stu[i]=newStu;
			i++;
		}
	}

	public static void traversingData() {
		for (int j = 0; j < i; j++) {
			System.out.println(Stu[j] + " ");
		}
	}
	public static void main(String[] args) {
		paddingData();
		traversingData();
		//insert delete isEmpty isFull select alert
	}

}
