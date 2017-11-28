package com.jisen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int c=0;
		try{
			c=10/0;
		}catch(ArithmeticException a){//括号里的算术异常是一个类，抓取这个错误类之后，要定义一个该类变量，用该类变量对异常做进一步
//			a.printStackTrace();//打印异常，打印栈跟踪信息
			System.out.println(a.getMessage());
		}
		System.out.println(c);// ArithmeticException算术异常,这是一个类，
	//****************************
		int a=0;int b = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("请输入a：");
		a=in.nextInt();
		do{//此do{}while();可以用来做输入界面
			System.out.println("请输入b：");
			try{
				b=in.nextInt();
				if(b==0) throw new ArithmeticException("除数不能为0");
				
			}catch(ArithmeticException e){
				System.out.println(e.getMessage());
				continue;
			}catch(InputMismatchException e){
//				System.out.println("输入不匹配");			
				continue;
			}
			break;
		}while(true);
		c=a/b;
		System.out.println(c);
		System.out.println("hellow world");
		
		
	}

}
