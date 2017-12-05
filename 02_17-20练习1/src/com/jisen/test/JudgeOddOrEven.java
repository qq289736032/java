package com.jisen.test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JudgeOddOrEven {

	/**
	 * 由键盘输入一个整数，判断是奇数还是偶�?
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int num = 0;
		do{
			System.out.print("请输入一个整数：");
			try{
				num = in.nextInt();
			}catch(InputMismatchException e){ 
				in.next();//清除缓冲区的数据
				continue;
			}
			break;
		}while(true);
		
		if(num % 2 == 0){
			System.out.println(num + "是偶�?");
		}else {
			System.out.println(num + "是奇�?");  
			return ;
		}
	}

}
